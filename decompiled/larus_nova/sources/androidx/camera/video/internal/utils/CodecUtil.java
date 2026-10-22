package androidx.camera.video.internal.utils;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.util.LruCache;
import androidx.camera.video.internal.encoder.EncoderConfig;
import androidx.camera.video.internal.encoder.InvalidConfigException;

/* JADX INFO: loaded from: classes2.dex */
public final class CodecUtil {
    private static final int MAX_CODEC_INFO_CACHE_COUNT = 10;
    private static final LruCache<String, MediaCodecInfo> sCodecInfoCache = null;

    static {
        sCodecInfoCache = new LruCache(10);
    }

    private CodecUtil() {
    }

    private static MediaCodec createCodec(String r100) throws InvalidConfigException {
        return MediaCodec.createEncoderByType(r100);
    L6:
        e = move-exception;
        throw new InvalidConfigException(e);
    }

    public static MediaCodecInfo findCodecAndGetCodecInfo(EncoderConfig r100) throws InvalidConfigException {
        String r101 = r100.getMimeType();
        LruCache<String, MediaCodecInfo> r102 = sCodecInfoCache;
        monitor-enter(r102);
        MediaCodecInfo r103 = r102.get(r101);     // Catch: Throwable -> L25
        monitor-exit(r102);     // Catch: Throwable -> L25
        if (r103 == null) goto L32;
        return r103;
    L32:
        MediaCodec r104 = createCodec(r101);     // Catch: Throwable -> L20
        MediaCodecInfo r105 = r104.getCodecInfo();     // Catch: Throwable -> L18
        monitor-enter(r102);     // Catch: Throwable -> L18
        r102.put(r101, r105);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        r104.release();
        return r105;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = th;
    L22:
        if (r104 == null) goto L24;
        r104.release();
    L24:
        throw th;
    L20:
        th = th;
        r104 = null;
    L25:
        th = move-exception;
        throw th;
    }

    public static MediaCodec createCodec(EncoderConfig r100) throws InvalidConfigException {
        return createCodec(r100.getMimeType());
    }
}
