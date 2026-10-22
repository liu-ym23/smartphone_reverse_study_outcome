package com.android.ttcjpaysdk.thirdparty.voiceprint.record;

import android.content.Context;
import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J(\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoicePrintUtils;", "", "()V", "AUDIO_MODEL_FILE_NAME", "", "CJ_VOICE_VERIFY_DIR", "ensureSamiModelFile", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ensureVoiceVerifyCacheDir", "Ljava/io/File;", "generateWavFileHeader", "", "pcmByteCount", "", "sampleRate", "channels", "", "generateWavFileHeaderBytes", "getBytesBase64", HTTP.CONTENT_RANGE_BYTES, "getFileBase64", "filePath", "patchWavHeaderInPlace", "", "updateWavHeader", "wavFile", "pcmLength", "writeWavHeader", "outputStream", "Ljava/io/FileOutputStream;", "writeWavHeaderToStream", "Ljava/io/OutputStream;", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoicePrintUtils {
    private static final String AUDIO_MODEL_FILE_NAME = "tcnunet_denoise_espresso_44k_speechim_middle_v1.1.model";
    private static final String CJ_VOICE_VERIFY_DIR = "cj_voice_verify";
    public static final VoicePrintUtils INSTANCE = null;

    static {
        INSTANCE = new VoicePrintUtils();
    }

    private VoicePrintUtils() {
    }

    private final byte[] generateWavFileHeader(long r110, long r111, int r210) {
        long r100 = r110 + ((long) 36);
        long r101 = (((long) 2) * r111) * ((long) r210);
        return new byte[]{82, 73, 70, 70, (byte) (r100 & 255), (byte) ((r100 >> 8) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) r210, 0, (byte) (r111 & 255), (byte) ((r111 >> 8) & 255), (byte) ((r111 >> 16) & 255), (byte) ((r111 >> 24) & 255), (byte) (r101 & 255), (byte) ((r101 >> 8) & 255), (byte) ((r101 >> 16) & 255), (byte) ((r101 >> 24) & 255), (byte) (r210 * 2), 0, 16, 0, 100, 97, 116, 97, (byte) (r110 & 255), (byte) ((r110 >> 8) & 255), (byte) ((r110 >> 16) & 255), (byte) ((r110 >> 24) & 255)};
    }

    public final String ensureSamiModelFile(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), CJ_VOICE_VERIFY_DIR);
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L29
        if (r101.exists() == true) goto L6;
        r101.mkdirs();     // Catch: Throwable -> L29
    L6:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101, AUDIO_MODEL_FILE_NAME);     // Catch: Throwable -> L29
        if (r104.exists() == true) goto L9;
    L11:
        InputStream r105 = r100.getAssets().open(AUDIO_MODEL_FILE_NAME);     // Catch: Throwable -> L29
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L24
        ByteStreamsKt.copyTo$default(r105, r106, 0, 2, null);     // Catch: Throwable -> L19
        r106.flush();     // Catch: Throwable -> L19
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r106, null);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L29
        String r108 = r104.getAbsolutePath();     // Catch: Throwable -> L29
    L17:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L29
    L31:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L35;
        CJLogger.c("VoicePrintUtils", "ensureSamiModelFile exception", r110);
    L35:
        if (Result.m9455isFailureimpl(r109) == true) goto L39;
        r102 = r109;
    L39:
        return (String) r102;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L9:
        if (r104.length() <= 0) goto L11;
        r108 = r104.getAbsolutePath();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    }

    public final File ensureVoiceVerifyCacheDir(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getCacheDir(), CJ_VOICE_VERIFY_DIR);
        if (r101.exists() == true) goto L5;
        r101.mkdirs();
    L5:
        return r101;
    }

    public final String getBytesBase64(byte[] r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.length != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L16;
        return "";
    L16:
        return Base64.encodeToString(r100, 2);
    L13:
        e = move-exception;
        CJLogger.c("VoicePrintUtils", "getBytesBase64 error", e);
        return "";
    L7:
        r101 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    public final String getFileBase64(String r100) {
        String r101 = "";
        Intrinsics.checkNotNullParameter(r100, "filePath");
        ?? r102 = 0;
        Unit r103 = null;
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r100));     // Catch: Throwable -> L27 Exception -> L29
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L20
        byte[] r106 = new byte[8192];     // Catch: Throwable -> L20
    L5:
        int r107 = r104.read(r106);     // Catch: Throwable -> L20
        if (r107 == (-1)) goto L8;
        r105.write(r106, 0, r107);     // Catch: Throwable -> L20
        goto L5
    L8:
        String r108 = Base64.encodeToString(r105.toByteArray(), 2);     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r104, null);     // Catch: Exception -> L25 Throwable -> L43
        if (r108 == null) goto L56;
        r101 = r108;
    L56:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L15
        r104.close();     // Catch: Throwable -> L15
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L42;
    L19:
        CJLogger.c("VoicePrintUtils", "getFileBase64 close inputStream exception", r111);
    L42:
        return r101;
    L15:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Exception -> L25 Throwable -> L43
        throw th;     // Catch: Exception -> L25 Throwable -> L43
    L43:
        th = th;
    L64:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L49
        if (0 == 0) goto L47;
        r102.close();     // Catch: Throwable -> L49
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L49
    L47:
        Object r114 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L49
    L51:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L68;
        CJLogger.c("VoicePrintUtils", "getFileBase64 close inputStream exception", r115);
        throw th;
    L68:
        throw th;
    L49:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L25:
        e = e;
    L31:
        CJLogger.c("VoicePrintUtils", "getFileBase64 error", e);     // Catch: Throwable -> L43
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L37
        if (0 == 0) goto L35;
        r102.close();     // Catch: Throwable -> L37
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L37
    L35:
        Object r118 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L37
    L39:
        r111 = Result.m9452exceptionOrNullimpl(r118);
        if (r111 == null) goto L42;
    L37:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L29:
        e = e;
    L27:
        th = th;
        goto L64
    }

    public final byte[] generateWavFileHeaderBytes(long r100, long r101, int r102) {
        return generateWavFileHeader(r100, r101, r102);
    }

    public final void updateWavHeader(File r110, long r111, int r112) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L7:
        if (r100 == true) goto L9;
        return;
    L9:
        updateWavHeader(RangesKt.coerceAtLeast(r110.length() - ((long) 44), 0), r110, r111, r112);
        return;
    L5:
        if (r110.exists() != true) goto L7;
        r100 = true;
        goto L7
    }

    public final void patchWavHeaderInPlace(byte[] r100, long r101, long r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        if (r100.length >= 44) goto L5;
        return;
    L5:
        byte[] r102 = generateWavFileHeader(r101, r110, r111);
        System.arraycopy(r102, 0, r100, 0, r102.length);
    }

    public final void updateWavHeader(long r110, File r111, long r112, int r113) {
        boolean r100 = false;
        if (r111 != null) goto L5;
    L7:
        if (r100 == true) goto L30;
        return;
    L30:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L20
        RandomAccessFile r102 = new RandomAccessFile(r111, "rw");     // Catch: Throwable -> L20
        r102.seek(0);     // Catch: Throwable -> L15
        r102.write(INSTANCE.generateWavFileHeader(r110, r112, r113));     // Catch: Throwable -> L15
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        CloseableKt.closeFinally(r102, null);     // Catch: Throwable -> L20
        Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L31;
        CJLogger.c("VoicePrintUtils", "updateWavHeader exception", r116);
        return;
    L31:
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L5:
        if (r111.exists() != true) goto L7;
        r100 = true;
        goto L7
    }

    public final void writeWavHeader(FileOutputStream r100, long r101, long r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "outputStream");
        r100.write(generateWavFileHeader(r101, r110, r111));
    }

    public final void writeWavHeaderToStream(OutputStream r100, long r101, long r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "outputStream");
        r100.write(generateWavFileHeader(r101, r110, r111));
    }
}
