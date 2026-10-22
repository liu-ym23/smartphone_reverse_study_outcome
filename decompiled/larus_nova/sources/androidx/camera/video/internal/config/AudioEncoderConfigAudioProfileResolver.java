package androidx.camera.video.internal.config;

import android.util.Range;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public final class AudioEncoderConfigAudioProfileResolver implements Supplier<AudioEncoderConfig> {
    private static final String TAG = "AudioEncAdPrflRslvr";
    private final int mAudioProfile;
    private final EncoderProfilesProxy.AudioProfileProxy mAudioProfileProxy;
    private final AudioSettings mAudioSettings;
    private final AudioSpec mAudioSpec;
    private final Timebase mInputTimebase;
    private final String mMimeType;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    public AudioEncoderConfig get() {
        Logger.d(TAG, "Using resolved AUDIO bitrate from AudioProfile");
        Range<Integer> r100 = this.mAudioSpec.getBitrate();
        int r101 = AudioConfigUtil.scaleAndClampBitrate(this.mAudioProfileProxy.getBitrate(), this.mAudioSettings.getChannelCount(), this.mAudioProfileProxy.getChannels(), this.mAudioSettings.getSampleRate(), this.mAudioProfileProxy.getSampleRate(), r100);
        return AudioEncoderConfig.builder().setMimeType(this.mMimeType).setProfile(this.mAudioProfile).setInputTimebase(this.mInputTimebase).setChannelCount(this.mAudioSettings.getChannelCount()).setSampleRate(this.mAudioSettings.getSampleRate()).setBitrate(r101).build();
    }

    @Override // androidx.core.util.Supplier
    public /* bridge */ /* synthetic */ AudioEncoderConfig get() {
        return get();
    }

    public AudioEncoderConfigAudioProfileResolver(String r100, int r101, Timebase r102, AudioSpec r103, AudioSettings r104, EncoderProfilesProxy.AudioProfileProxy r105) {
        this.mMimeType = r100;
        this.mAudioProfile = r101;
        this.mInputTimebase = r102;
        this.mAudioSpec = r103;
        this.mAudioSettings = r104;
        this.mAudioProfileProxy = r105;
    }
}
