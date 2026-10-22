package androidx.camera.video.internal.config;

import android.util.Range;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public final class AudioSettingsAudioProfileResolver implements Supplier<AudioSettings> {
    private static final String TAG = "AudioSrcAdPrflRslvr";
    private final EncoderProfilesProxy.AudioProfileProxy mAudioProfile;
    private final AudioSpec mAudioSpec;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    public AudioSettings get() {
        int r100 = AudioConfigUtil.resolveAudioSource(this.mAudioSpec);
        int r101 = AudioConfigUtil.resolveAudioSourceFormat(this.mAudioSpec);
        int r102 = this.mAudioSpec.getChannelCount();
        Range<Integer> r103 = this.mAudioSpec.getSampleRate();
        int r104 = this.mAudioProfile.getChannels();
        if (r102 != (-1)) goto L5;
        Logger.d(TAG, "Resolved AUDIO channel count from AudioProfile: " + r104);
        r102 = r104;
    L6:
        int r105 = this.mAudioProfile.getSampleRate();
        int r106 = AudioConfigUtil.selectSampleRateOrNearestSupported(r103, r102, r101, r105);
        Logger.d(TAG, "Using resolved AUDIO sample rate or nearest supported from AudioProfile: " + r106 + "Hz. [AudioProfile sample rate: " + r105 + "Hz]");
        return AudioSettings.builder().setAudioSource(r100).setAudioFormat(r101).setChannelCount(r102).setSampleRate(r106).build();
    L5:
        Logger.d(TAG, "Media spec AUDIO channel count overrides AudioProfile [AudioProfile channel count: " + r104 + ", Resolved Channel Count: " + r102 + "]");
        goto L6
    }

    @Override // androidx.core.util.Supplier
    public /* bridge */ /* synthetic */ AudioSettings get() {
        return get();
    }

    public AudioSettingsAudioProfileResolver(AudioSpec r100, EncoderProfilesProxy.AudioProfileProxy r101) {
        this.mAudioSpec = r100;
        this.mAudioProfile = r101;
    }
}
