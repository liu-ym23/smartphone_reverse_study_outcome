package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.camera.video.internal.utils.CodecUtil;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class AudioEncoderInfoImpl extends EncoderInfoImpl implements AudioEncoderInfo {
    private final MediaCodecInfo.AudioCapabilities mAudioCapabilities;

    @Override // androidx.camera.video.internal.encoder.AudioEncoderInfo
    public Range<Integer> getBitrateRange() {
        return this.mAudioCapabilities.getBitrateRange();
    }

    public static AudioEncoderInfoImpl from(AudioEncoderConfig r100) throws InvalidConfigException {
        return new AudioEncoderInfoImpl(CodecUtil.findCodecAndGetCodecInfo(r100), r100.getMimeType());
    }

    public AudioEncoderInfoImpl(MediaCodecInfo r100, String r101) throws InvalidConfigException {
        super(r100, r101);
        MediaCodecInfo.AudioCapabilities r102 = this.mCodecCapabilities.getAudioCapabilities();
        Objects.requireNonNull(r102);
        this.mAudioCapabilities = r102;
    }
}
