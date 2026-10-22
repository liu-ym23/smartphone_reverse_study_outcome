package androidx.camera.video.internal.config;

import android.util.Range;
import androidx.camera.core.Logger;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public final class AudioSettingsDefaultResolver implements Supplier<AudioSettings> {
    private static final String TAG = "DefAudioResolver";
    private final AudioSpec mAudioSpec;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    public AudioSettings get() {
        int r100 = AudioConfigUtil.resolveAudioSource(this.mAudioSpec);
        int r101 = AudioConfigUtil.resolveAudioSourceFormat(this.mAudioSpec);
        int r102 = this.mAudioSpec.getChannelCount();
        if (r102 != (-1)) goto L5;
        Logger.d(TAG, "Using fallback AUDIO channel count: 1");
        r102 = 1;
    L6:
        Range<Integer> r103 = this.mAudioSpec.getSampleRate();
        if (AudioSpec.SAMPLE_RATE_RANGE_AUTO.equals(r103) == false) goto L9;
        Logger.d(TAG, "Using fallback AUDIO sample rate: 44100Hz");
        int r104 = 44100;
    L11:
        return AudioSettings.builder().setAudioSource(r100).setAudioFormat(r101).setChannelCount(r102).setSampleRate(r104).build();
    L9:
        r104 = AudioConfigUtil.selectSampleRateOrNearestSupported(r103, r102, r101, ((Integer) r103.getUpper()).intValue());
        Logger.d(TAG, "Using AUDIO sample rate resolved from AudioSpec: " + r104 + "Hz");
        goto L11
    L5:
        Logger.d(TAG, "Using supplied AUDIO channel count: " + r102);
        goto L6
    }

    @Override // androidx.core.util.Supplier
    public /* bridge */ /* synthetic */ AudioSettings get() {
        return get();
    }

    public AudioSettingsDefaultResolver(AudioSpec r100) {
        this.mAudioSpec = r100;
    }
}
