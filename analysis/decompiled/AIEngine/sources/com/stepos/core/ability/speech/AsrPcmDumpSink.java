package com.stepos.core.ability.speech;

import android.content.Context;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.data.AudioContent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrPcmDumpSink {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_CHANNEL = 1;
    private static final int DEFAULT_SAMPLE_RATE = 16000;
    private static final String DUMP_DIR_NAME = "asr_pcm_dump";
    private static final String PROP_ENABLE = "debug.aiengine.asr.pcmdump";
    private static final String PROP_MAX_DIR_MB = "debug.aiengine.asr.pcmdump.max_dir_mb";
    private static final String PROP_MAX_FILE_MB = "debug.aiengine.asr.pcmdump.max_file_mb";
    private static final int QUEUE_CAPACITY = 256;
    private static final String TAG = "AsrPcmDumpSink";
    private final int callerUid;
    private final boolean enabled = PcmDumpBudget.INSTANCE.isEnabled(PROP_ENABLE);
    private final HashMap<String, OpenDump> openDumps = new HashMap<>();
    private final AtomicLong droppedTasks = new AtomicLong(0);
    private final lb.d executor$delegate = kotlin.b.b(new m(this, 0));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class OpenDump {
        private final int channelCount;
        private final long maxFileBytes;
        private final File pcmFile;
        private final BufferedOutputStream pcmStream;
        private final String route;
        private final int sampleRate;
        private final File sidecar;
        private final long startWallMs;
        private long totalBytes;
        private boolean truncated;

        public OpenDump(BufferedOutputStream pcmStream, File pcmFile, File sidecar, String route, int i10, int i11, long j10, long j11) {
            kotlin.jvm.internal.g.f(pcmStream, "pcmStream");
            kotlin.jvm.internal.g.f(pcmFile, "pcmFile");
            kotlin.jvm.internal.g.f(sidecar, "sidecar");
            kotlin.jvm.internal.g.f(route, "route");
            this.pcmStream = pcmStream;
            this.pcmFile = pcmFile;
            this.sidecar = sidecar;
            this.route = route;
            this.sampleRate = i10;
            this.channelCount = i11;
            this.startWallMs = j10;
            this.maxFileBytes = j11;
        }

        public final int getChannelCount() {
            return this.channelCount;
        }

        public final long getMaxFileBytes() {
            return this.maxFileBytes;
        }

        public final File getPcmFile() {
            return this.pcmFile;
        }

        public final BufferedOutputStream getPcmStream() {
            return this.pcmStream;
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

        public final long getTotalBytes() {
            return this.totalBytes;
        }

        public final boolean getTruncated() {
            return this.truncated;
        }

        public final void setTotalBytes(long j10) {
            this.totalBytes = j10;
        }

        public final void setTruncated(boolean z) {
            this.truncated = z;
        }
    }

    public AsrPcmDumpSink(int i10) {
        this.callerUid = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n close$lambda$7(AsrPcmDumpSink asrPcmDumpSink, String str) {
        asrPcmDumpSink.closeDump(str);
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n closeAll$lambda$9(AsrPcmDumpSink asrPcmDumpSink) {
        Set<String> setKeySet = asrPcmDumpSink.openDumps.keySet();
        kotlin.jvm.internal.g.e(setKeySet, "<get-keys>(...)");
        for (String str : kotlin.collections.a.O0(setKeySet)) {
            kotlin.jvm.internal.g.c(str);
            asrPcmDumpSink.closeDump(str);
        }
        return lb.n.f10413a;
    }

    private final void closeDump(String str) {
        OpenDump openDumpRemove = this.openDumps.remove(str);
        if (openDumpRemove == null) {
            return;
        }
        try {
            openDumpRemove.getPcmStream().flush();
            lb.n nVar = lb.n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        try {
            openDumpRemove.getPcmStream().close();
            lb.n nVar2 = lb.n.f10413a;
        } catch (Throwable th2) {
            kotlin.c.a(th2);
        }
        try {
            writeSidecar(str, openDumpRemove);
            lb.n nVar3 = lb.n.f10413a;
        } catch (Throwable th3) {
            kotlin.c.a(th3);
        }
        LogModule logModule = LogModule.ABILITY;
        long totalBytes = openDumpRemove.getTotalBytes();
        boolean truncated = openDumpRemove.getTruncated();
        long j10 = this.droppedTasks.get();
        StringBuilder sbL = com.stepos.core.ota.d.l("pcm dump END inferId=", totalBytes, str, " totalBytes=");
        sbL.append(" truncated=");
        sbL.append(truncated);
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
        long length = 0;
        for (File file2 : fileArrListFiles) {
            length += file2.length();
        }
        if (length <= j10) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (File file3 : fileArrListFiles) {
            kotlin.jvm.internal.g.c(file3);
            if (wb.d.U(file3).equals("pcm")) {
                arrayList.add(file3);
            }
        }
        for (File file4 : kotlin.collections.a.I0(arrayList, new Comparator() { // from class: com.stepos.core.ability.speech.AsrPcmDumpSink$enforceDirBudget$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t10) {
                return ob.b.a(Long.valueOf(((File) t8).lastModified()), Long.valueOf(((File) t10).lastModified()));
            }
        })) {
            if (length <= j10) {
                return;
            }
            length -= file4.length();
            try {
                file4.delete();
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
            File file5 = new File(file, wb.d.V(file4).concat(".json"));
            if (file5.exists()) {
                length -= file5.length();
                try {
                    file5.delete();
                } catch (Throwable th2) {
                    kotlin.c.a(th2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadPoolExecutor executor_delegate$lambda$3(final AsrPcmDumpSink asrPcmDumpSink) {
        return new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(256), new f(2), new RejectedExecutionHandler() { // from class: com.stepos.core.ability.speech.p
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                AsrPcmDumpSink.executor_delegate$lambda$3$lambda$2(this.f7327a, runnable, threadPoolExecutor);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread executor_delegate$lambda$3$lambda$1(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, "asr-pcm-dump", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executor_delegate$lambda$3$lambda$2(AsrPcmDumpSink asrPcmDumpSink, Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        asrPcmDumpSink.droppedTasks.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n feed$lambda$6(AsrPcmDumpSink asrPcmDumpSink, String str, byte[] bArr, String str2, int i10, int i11) {
        asrPcmDumpSink.writeFrame(str, bArr, str2, i10, i11);
        return lb.n.f10413a;
    }

    private final ThreadPoolExecutor getExecutor() {
        return (ThreadPoolExecutor) this.executor$delegate.getValue();
    }

    private final OpenDump openDump(String str, String str2, int i10, int i11) {
        Object objA;
        try {
            File fileDumpDir = dumpDir();
            PcmDumpBudget.Caps caps = PcmDumpBudget.INSTANCE.readCaps(PROP_MAX_FILE_MB, PROP_MAX_DIR_MB);
            enforceDirBudget(fileDumpDir, caps.getMaxDirBytes());
            String strS0 = gc.r.S0(12, str);
            StringBuilder sb2 = new StringBuilder();
            int length = strS0.length();
            for (int i12 = 0; i12 < length; i12++) {
                char cCharAt = strS0.charAt(i12);
                if (Character.isLetterOrDigit(cCharAt)) {
                    sb2.append(cCharAt);
                }
            }
            String string = sb2.toString();
            kotlin.jvm.internal.g.e(string, "toString(...)");
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str3 = jCurrentTimeMillis + "_" + string + "_uid" + this.callerUid + "_" + str2;
            File file = new File(fileDumpDir, str3 + ".pcm");
            objA = new OpenDump(new BufferedOutputStream(new FileOutputStream(file)), file, new File(fileDumpDir, str3 + ".json"), str2, i10, i11, jCurrentTimeMillis, caps.getMaxFileBytes());
            this.openDumps.put(str, objA);
            AIEngineLogger.i(LogModule.ABILITY, TAG, "pcm dump START inferId=" + str + " route=" + str2 + " sr=" + i10 + " ch=" + i11 + " file=" + file.getName() + " " + caps.toLog());
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, ai.onnxruntime.a.k("pcm dump open failed inferId=", str), thB);
            objA = null;
        }
        return (OpenDump) objA;
    }

    private final void submit(zb.a<lb.n> aVar) {
        try {
            getExecutor().execute(new n(0, aVar));
            lb.n nVar = lb.n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    private final void writeFrame(String str, byte[] bArr, String str2, int i10, int i11) {
        Object objA;
        OpenDump openDump = this.openDumps.get(str);
        if ((openDump == null && (openDump = openDump(str, str2, i10, i11)) == null) || openDump.getTruncated()) {
            return;
        }
        if (openDump.getTotalBytes() + bArr.length > openDump.getMaxFileBytes()) {
            openDump.setTruncated(true);
            AIEngineLogger.w(LogModule.ABILITY, TAG, "pcm dump truncated (file cap) inferId=" + str + " totalBytes=" + openDump.getTotalBytes());
            return;
        }
        try {
            openDump.getPcmStream().write(bArr);
            openDump.setTotalBytes(openDump.getTotalBytes() + bArr.length);
            objA = lb.n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, ai.onnxruntime.a.k("pcm dump write failed inferId=", str), thB);
        }
    }

    private final void writeSidecar(String str, OpenDump openDump) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("inferId", str);
        jSONObject.put("uid", this.callerUid);
        jSONObject.put("route", openDump.getRoute());
        jSONObject.put("sampleRate", openDump.getSampleRate());
        jSONObject.put("channelCount", openDump.getChannelCount());
        jSONObject.put("encoding", "s16le");
        jSONObject.put("totalBytes", openDump.getTotalBytes());
        jSONObject.put("truncated", openDump.getTruncated());
        jSONObject.put("startWallMs", openDump.getStartWallMs());
        jSONObject.put("endWallMs", System.currentTimeMillis());
        File sidecar = openDump.getSidecar();
        String string = jSONObject.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        wb.d.e0(sidecar, string);
    }

    public final void close(String inferId) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        if (this.enabled) {
            submit(new android.llama.cpp.b(4, this, inferId));
        }
    }

    public final void closeAll() {
        if (this.enabled) {
            submit(new m(this, 1));
        }
    }

    public final void feed(final String inferId, AudioContent audio, final String route) {
        kotlin.jvm.internal.g.f(inferId, "inferId");
        kotlin.jvm.internal.g.f(audio, "audio");
        kotlin.jvm.internal.g.f(route, "route");
        if (this.enabled) {
            final byte[] audioBytes = audio.getAudioBytes();
            if (audioBytes.length == 0) {
                return;
            }
            int sampleRate = audio.getSampleRate();
            Integer numValueOf = Integer.valueOf(sampleRate);
            if (sampleRate <= 0) {
                numValueOf = null;
            }
            final int iIntValue = numValueOf != null ? numValueOf.intValue() : 16000;
            int channelCount = audio.getChannelCount();
            Integer numValueOf2 = channelCount > 0 ? Integer.valueOf(channelCount) : null;
            final int iIntValue2 = numValueOf2 != null ? numValueOf2.intValue() : 1;
            submit(new zb.a() { // from class: com.stepos.core.ability.speech.o
                @Override // zb.a
                public final Object invoke() {
                    return AsrPcmDumpSink.feed$lambda$6(this.f7320a, inferId, audioBytes, route, iIntValue, iIntValue2);
                }
            });
        }
    }
}
