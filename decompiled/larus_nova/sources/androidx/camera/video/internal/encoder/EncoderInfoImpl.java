package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EncoderInfoImpl implements EncoderInfo {
    protected final MediaCodecInfo.CodecCapabilities mCodecCapabilities;
    private final MediaCodecInfo mMediaCodecInfo;

    @Override // androidx.camera.video.internal.encoder.EncoderInfo
    public String getName() {
        return this.mMediaCodecInfo.getName();
    }

    public EncoderInfoImpl(MediaCodecInfo r100, String r101) throws InvalidConfigException {
        this.mMediaCodecInfo = r100;
        MediaCodecInfo.CodecCapabilities r102 = r100.getCapabilitiesForType(r101);     // Catch: RuntimeException -> L5
        Objects.requireNonNull(r102);     // Catch: RuntimeException -> L5
        MediaCodecInfo.CodecCapabilities r103 = r102;     // Catch: RuntimeException -> L5
        this.mCodecCapabilities = r102;     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        throw new InvalidConfigException("Unable to get CodecCapabilities for mime: " + r101, e);
    }
}
