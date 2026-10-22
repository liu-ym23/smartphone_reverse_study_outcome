package com.stepos.core.ability.speech;

import android.content.Context;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.jvm.internal.Ref$LongRef;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsPcmDumpSink {
    private static final int DEFAULT_CHANNEL = 1;
    private static final int DEFAULT_SAMPLE_RATE = 24000;
    private static final String DUMP_DIR_NAME = "tts_pcm_dump";
    private static final int MAX_TEXT_CHARS = 200000;
    private static final int MAX_TRACE_ID_CHARS = 48;
    private static final String PROP_MAX_DIR_MB = "debug.aiengine.tts.pcmdump.max_dir_mb";
    private static final String PROP_MAX_FILE_MB = "debug.aiengine.tts.pcmdump.max_file_mb";
    private static final int QUEUE_CAPACITY = 256;
    private static final String TAG = "TtsPcmDumpSink";
    private static final int WAV_HEADER_BYTES = 44;
    public static final TtsPcmDumpSink INSTANCE = new TtsPcmDumpSink();
    private static final String PROP_ENABLE = "debug.aiengine.tts.pcmdump";
    private static final boolean enabled = PcmDumpBudget.INSTANCE.isEnabled(PROP_ENABLE);
    private static final HashMap<String, OpenWav> openDumps = new HashMap<>();
    private static final HashMap<String, TextBuf> openTexts = new HashMap<>();
    private static final AtomicLong droppedTasks = new AtomicLong(0);
    private static final lb.d executor$delegate = kotlin.b.b(new a(6));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class OpenWav {
        private final int channelCount;
        private long dataBytes;
        private final long maxFileBytes;
        private final RandomAccessFile raf;
        private final String route;
        private final int sampleRate;
        private final File sidecar;
        private final long startWallMs;
        private final String traceId;
        private boolean truncated;
        private final int uid;
        private final File wavFile;

        public OpenWav(RandomAccessFile raf, File wavFile, File sidecar, int i10, String route, int i11, int i12, long j10, String traceId, long j11) {
            kotlin.jvm.internal.g.f(raf, "raf");
            kotlin.jvm.internal.g.f(wavFile, "wavFile");
            kotlin.jvm.internal.g.f(sidecar, "sidecar");
            kotlin.jvm.internal.g.f(route, "route");
            kotlin.jvm.internal.g.f(traceId, "traceId");
            this.raf = raf;
            this.wavFile = wavFile;
            this.sidecar = sidecar;
            this.uid = i10;
            this.route = route;
            this.sampleRate = i11;
            this.channelCount = i12;
            this.startWallMs = j10;
            this.traceId = traceId;
            this.maxFileBytes = j11;
        }

        public final int getChannelCount() {
            return this.channelCount;
        }

        public final long getDataBytes() {
            return this.dataBytes;
        }

        public final long getMaxFileBytes() {
            return this.maxFileBytes;
        }

        public final RandomAccessFile getRaf() {
            return this.raf;
        }

        public final String getRoute() {
            return this.route;
        }

        public final int getSampleRate() {
            return this.sampleRate;
        }

        public final File getSidecar() {
            return this.sidecar;
        }

        public final long getStartWallMs() {
            return this.startWallMs;
        }

        public final String getTraceId() {
            return this.traceId;
        }

        public final boolean getTruncated() {
            return this.truncated;
        }

        public final int getUid() {
            return this.uid;
        }

        public final File getWavFile() {
            return this.wavFile;
        }

        public final void setDataBytes(long j10) {
            this.dataBytes = j10;
        }

        public final void setTruncated(boolean z) {
            this.truncated = z;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TextBuf {

        /* renamed from: sb, reason: collision with root package name */
        private final StringBuilder f7235sb = new StringBuilder();
        private boolean truncated;

        public final StringBuilder getSb() {
            return this.f7235sb;
        }

        public final boolean getTruncated() {
            return this.truncated;
        }

        public final void setTruncated(boolean z) {
            this.truncated = z;
        }
    }

    private TtsPcmDumpSink() {
    }

    private final void appendText(String str, String str2) {
        HashMap<String, TextBuf> map = openTexts;
        TextBuf textBuf = map.get(str);
        if (textBuf == null) {
            textBuf = new TextBuf();
            map.put(str, textBuf);
        }
        TextBuf textBuf2 = textBuf;
        if (textBuf2.getTruncated()) {
            return;
        }
        int length = MAX_TEXT_CHARS - textBuf2.getSb().length();
        if (length <= 0) {
            textBuf2.setTruncated(true);
        } else {
            if (str2.length() <= length) {
                textBuf2.getSb().append(str2);
                return;
            }
            textBuf2.getSb().append((CharSequence) str2, 0, length);
            textBuf2.setTruncated(true);
            ai.onnxruntime.a.w("text dump truncated (char cap) sessionKey=", str, LogModule.ABILITY, TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n close$lambda$8(String str) {
        INSTANCE.closeWav(str);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n closeAll$lambda$10() {
        Set<String> setKeySet = openDumps.keySet();
        kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
        Set<String> setKeySet2 = openTexts.keySet();
        kotlin.jvm.internal.g.e(setKeySet2, "<get-keys>(...)");
        for (String str : kotlin.collections.a.O0(mb.x.W(setKeySet, setKeySet2))) {
            TtsPcmDumpSink ttsPcmDumpSink = INSTANCE;
            kotlin.jvm.internal.g.c(str);
            ttsPcmDumpSink.closeWav(str);
        }
        return lb.n.f10413a;
    }

    private final void closeWav(String str) {
        StringBuilder sb2;
        OpenWav openWavRemove = openDumps.remove(str);
        TextBuf textBufRemove = openTexts.remove(str);
        if (openWavRemove == null && textBufRemove == null) {
            return;
        }
        if (openWavRemove != null) {
            try {
                patchHeaderSizes(openWavRemove.getRaf(), openWavRemove.getDataBytes());
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            try {
                openWavRemove.getRaf().close();
                lb.n nVar2 = lb.n.f10413a;
            } catch (Throwable th2) {
                kotlin.c.a(th2);
            }
            try {
                writeSidecar(str, openWavRemove);
                lb.n nVar3 = lb.n.f10413a;
            } catch (Throwable th3) {
                kotlin.c.a(th3);
            }
        }
        if (textBufRemove != null && textBufRemove.getSb().length() > 0) {
            try {
                writeTextDump(openWavRemove, textBufRemove);
                lb.n nVar4 = lb.n.f10413a;
            } catch (Throwable th4) {
                kotlin.c.a(th4);
            }
        }
        LogModule logModule = LogModule.ABILITY;
        long dataBytes = openWavRemove != null ? openWavRemove.getDataBytes() : 0L;
        int length = 0;
        boolean truncated = openWavRemove != null ? openWavRemove.getTruncated() : false;
        if (textBufRemove != null && (sb2 = textBufRemove.getSb()) != null) {
            length = sb2.length();
        }
        long j10 = droppedTasks.get();
        StringBuilder sbL = com.stepos.core.ota.d.l("wav dump END sessionKey=", dataBytes, str, " dataBytes=");
        sbL.append(" truncated=");
        sbL.append(truncated);
        sbL.append(" textChars=");
        sbL.append(length);
        sbL.append(" dropped=");
        sbL.append(j10);
        AIEngineLogger.i(logModule, TAG, sbL.toString());
    }

    private final File dumpDir() {
        Context context = l7.a.f10344a;
        if (context == null) {
            throw new IllegalStateException("ContextHolder must be initialized before use!");
        }
        File file = new File(context.getCacheDir(), DUMP_DIR_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private final void enforceDirBudget(File file, long j10) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        long length = 0;
        for (File file2 : fileArrListFiles) {
            length += file2.length();
        }
        ref$LongRef.f10075a = length;
        if (length <= j10) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (File file3 : mb.l.k0(fileArrListFiles, new Comparator() { // from class: com.stepos.core.ability.speech.TtsPcmDumpSink$enforceDirBudget$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t10) {
                return ob.b.a(Long.valueOf(((File) t8).lastModified()), Long.valueOf(((File) t10).lastModified()));
            }
        })) {
            if (ref$LongRef.f10075a <= j10) {
                return;
            }
            if (!hashSet.contains(file3.getAbsolutePath())) {
                enforceDirBudget$deleteFile(hashSet, ref$LongRef, file3);
                if (wb.d.U(file3).equals("wav")) {
                    Iterator it = mb.m.b0("json", "txt").iterator();
                    while (it.hasNext()) {
                        enforceDirBudget$deleteFile(hashSet, ref$LongRef, new File(file, com.stepos.core.ota.d.i(wb.d.V(file3), ".", (String) it.next())));
                    }
                }
            }
        }
    }

    private static final void enforceDirBudget$deleteFile(HashSet<String> hashSet, Ref$LongRef ref$LongRef, File file) {
        if (hashSet.add(file.getAbsolutePath()) && file.exists()) {
            ref$LongRef.f10075a -= file.length();
            try {
                file.delete();
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadPoolExecutor executor_delegate$lambda$3() {
        return new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(256), new b0(0), new c0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread executor_delegate$lambda$3$lambda$1(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, "tts-pcm-dump", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executor_delegate$lambda$3$lambda$2(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        droppedTasks.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n feed$lambda$6(String str, int i10, byte[] bArr, int i11, int i12, String str2, String str3) {
        INSTANCE.writeFrame(str, i10, bArr, i11, i12, str2, str3);
        return lb.n.f10413a;
    }

    public static /* synthetic */ void feedText$default(TtsPcmDumpSink ttsPcmDumpSink, String str, int i10, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            str4 = "";
        }
        ttsPcmDumpSink.feedText(str, i10, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n feedText$lambda$7(String str, String str2) {
        INSTANCE.appendText(str, str2);
        return lb.n.f10413a;
    }

    private final String fileIdSegment(String str, String str2) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        int length = str2.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str2.charAt(i10);
            if (Character.isLetterOrDigit(cCharAt) || cCharAt == '-' || cCharAt == '_') {
                sb2.append(cCharAt);
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        if (!gc.q.t0(string)) {
            return gc.r.R0(48, string);
        }
        String strS0 = gc.r.S0(12, str);
        StringBuilder sb3 = new StringBuilder();
        int length2 = strS0.length();
        for (int i11 = 0; i11 < length2; i11++) {
            char cCharAt2 = strS0.charAt(i11);
            if (Character.isLetterOrDigit(cCharAt2)) {
                sb3.append(cCharAt2);
            }
        }
        String string2 = sb3.toString();
        kotlin.jvm.internal.g.e(string2, "toString(...)");
        return string2;
    }

    private final ThreadPoolExecutor getExecutor() {
        return (ThreadPoolExecutor) executor$delegate.getValue();
    }

    private final byte[] intLe(int i10) {
        byte[] bArr = new byte[4];
        INSTANCE.putIntLe(bArr, 0, i10);
        return bArr;
    }

    private final OpenWav openWav(String str, int i10, int i11, int i12, String str2, String str3) {
        Object objA;
        try {
            File fileDumpDir = dumpDir();
            PcmDumpBudget.Caps caps = PcmDumpBudget.INSTANCE.readCaps(PROP_MAX_FILE_MB, PROP_MAX_DIR_MB);
            enforceDirBudget(fileDumpDir, caps.getMaxDirBytes());
            String strFileIdSegment = fileIdSegment(str, str3);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str4 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS", Locale.US).format(new Date(jCurrentTimeMillis)) + "_" + strFileIdSegment + "_uid" + i10 + "_" + str2;
            File file = new File(fileDumpDir, str4 + ".wav");
            File file2 = new File(fileDumpDir, str4 + ".json");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.write(placeholderHeader(i11, i12));
            objA = new OpenWav(randomAccessFile, file, file2, i10, str2, i11, i12, jCurrentTimeMillis, str3, caps.getMaxFileBytes());
            openDumps.put(str, objA);
            AIEngineLogger.i(LogModule.ABILITY, TAG, "wav dump START sessionKey=" + str + " route=" + str2 + " sr=" + i11 + " ch=" + i12 + " file=" + file.getName() + " " + caps.toLog());
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, ai.onnxruntime.a.k("wav dump open failed sessionKey=", str), thB);
            objA = null;
        }
        return (OpenWav) objA;
    }

    private final void patchHeaderSizes(RandomAccessFile randomAccessFile, long j10) throws IOException {
        int i10 = (int) (j10 > 4294967295L ? 4294967295L : j10);
        long j11 = j10 + 36;
        long j12 = j11 <= 4294967295L ? j11 : 4294967295L;
        randomAccessFile.seek(4L);
        randomAccessFile.write(intLe((int) j12));
        randomAccessFile.seek(40L);
        randomAccessFile.write(intLe(i10));
    }

    private final byte[] placeholderHeader(int i10, int i11) {
        byte[] bArr = new byte[44];
        putAscii(bArr, 0, "RIFF");
        putIntLe(bArr, 4, 0);
        putAscii(bArr, 8, "WAVE");
        putAscii(bArr, 12, "fmt ");
        putIntLe(bArr, 16, 16);
        putShortLe(bArr, 20, 1);
        putShortLe(bArr, 22, i11);
        putIntLe(bArr, 24, i10);
        putIntLe(bArr, 28, ((i10 * i11) * 16) / 8);
        putShortLe(bArr, 32, (i11 * 16) / 8);
        putShortLe(bArr, 34, 16);
        putAscii(bArr, 36, "data");
        putIntLe(bArr, 40, 0);
        return bArr;
    }

    private final void putAscii(byte[] bArr, int i10, String str) {
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i10 + i11] = (byte) str.charAt(i11);
        }
    }

    private final void putIntLe(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((i11 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((i11 >> 24) & 255);
    }

    private final void putShortLe(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
    }

    private final void submit(zb.a<lb.n> aVar) {
        try {
            getExecutor().execute(new n(1, aVar));
            lb.n nVar = lb.n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    private final void writeFrame(String str, int i10, byte[] bArr, int i11, int i12, String str2, String str3) {
        String str4;
        Object objA;
        OpenWav openWav = openDumps.get(str);
        if (openWav == null) {
            str4 = str;
            openWav = openWav(str4, i10, i11, i12, str2, str3);
            if (openWav == null) {
                return;
            }
        } else {
            str4 = str;
        }
        if (openWav.getTruncated()) {
            return;
        }
        if (openWav.getDataBytes() + bArr.length > openWav.getMaxFileBytes()) {
            openWav.setTruncated(true);
            AIEngineLogger.w(LogModule.ABILITY, TAG, "wav dump truncated (file cap) sessionKey=" + str4 + " dataBytes=" + openWav.getDataBytes());
            return;
        }
        try {
            openWav.getRaf().write(bArr);
            openWav.setDataBytes(openWav.getDataBytes() + bArr.length);
            objA = lb.n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, ai.onnxruntime.a.k("wav dump write failed sessionKey=", str4), thB);
        }
    }

    private final void writeSidecar(String str, OpenWav openWav) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("inferId", str);
        jSONObject.put("traceId", openWav.getTraceId());
        jSONObject.put("uid", openWav.getUid());
        jSONObject.put("route", openWav.getRoute());
        jSONObject.put("sampleRate", openWav.getSampleRate());
        jSONObject.put("channelCount", openWav.getChannelCount());
        jSONObject.put("encoding", "s16le");
        jSONObject.put("dataBytes", openWav.getDataBytes());
        jSONObject.put("truncated", openWav.getTruncated());
        jSONObject.put("startWallMs", openWav.getStartWallMs());
        jSONObject.put("endWallMs", System.currentTimeMillis());
        File sidecar = openWav.getSidecar();
        String string = jSONObject.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        wb.d.e0(sidecar, string);
    }

    private final void writeTextDump(OpenWav openWav, TextBuf textBuf) throws IOException {
        String string;
        File file = openWav != null ? new File(openWav.getWavFile().getParentFile(), wb.d.V(openWav.getWavFile()).concat(".txt")) : new File(dumpDir(), a0.a.j(new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS", Locale.US).format(new Date(System.currentTimeMillis())), "_textonly.txt"));
        if (textBuf.getTruncated()) {
            string = ((Object) textBuf.getSb()) + "\n[TRUNCATED]";
        } else {
            string = textBuf.getSb().toString();
            kotlin.jvm.internal.g.e(string, "toString(...)");
        }
        wb.d.e0(file, string);
    }

    public final void close(String sessionKey) {
        kotlin.jvm.internal.g.f(sessionKey, "sessionKey");
        if (enabled) {
            submit(new l(sessionKey, 1));
        }
    }

    public final void closeAll() {
        if (enabled) {
            submit(new a(5));
        }
    }

    public final void feed(final String sessionKey, final int i10, final byte[] pcm16, int i11, int i12, final String route, final String traceId) {
        kotlin.jvm.internal.g.f(sessionKey, "sessionKey");
        kotlin.jvm.internal.g.f(pcm16, "pcm16");
        kotlin.jvm.internal.g.f(route, "route");
        kotlin.jvm.internal.g.f(traceId, "traceId");
        if (enabled && pcm16.length != 0) {
            Integer numValueOf = Integer.valueOf(i11);
            if (i11 <= 0) {
                numValueOf = null;
            }
            final int iIntValue = numValueOf != null ? numValueOf.intValue() : 24000;
            Integer numValueOf2 = i12 > 0 ? Integer.valueOf(i12) : null;
            final int iIntValue2 = numValueOf2 != null ? numValueOf2.intValue() : 1;
            submit(new zb.a() { // from class: com.stepos.core.ability.speech.a0
                @Override // zb.a
                public final Object invoke() {
                    return TtsPcmDumpSink.feed$lambda$6(sessionKey, i10, pcm16, iIntValue, iIntValue2, route, traceId);
                }
            });
        }
    }

    public final void feedText(String sessionKey, int i10, String text, String route, String traceId) {
        kotlin.jvm.internal.g.f(sessionKey, "sessionKey");
        kotlin.jvm.internal.g.f(text, "text");
        kotlin.jvm.internal.g.f(route, "route");
        kotlin.jvm.internal.g.f(traceId, "traceId");
        if (enabled && text.length() != 0) {
            submit(new z(0, sessionKey, text));
        }
    }
}
