package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import androidx.core.util.Supplier;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class AudioConfigUtil {
    static final int AUDIO_CHANNEL_COUNT_DEFAULT = 1;
    static final int AUDIO_SAMPLE_RATE_DEFAULT = 44100;
    static final int AUDIO_SOURCE_DEFAULT = 5;
    static final int AUDIO_SOURCE_FORMAT_DEFAULT = 2;
    private static final String TAG = "AudioConfigUtil";

    public static /* synthetic */ int a(int r100, Integer r101, Integer r102) {
        return lambda$selectSampleRateOrNearestSupported$0(r100, r101, r102);
    }

    private AudioConfigUtil() {
    }

    public static int resolveAudioSource(AudioSpec r100) {
        int r101 = r100.getSource();
        if (r101 != (-1)) goto L5;
        Logger.d(TAG, "Using default AUDIO source: 5");
        return 5;
    L5:
        Logger.d(TAG, "Using provided AUDIO source: " + r101);
        return r101;
    }

    public static int resolveAudioSourceFormat(AudioSpec r100) {
        int r101 = r100.getSourceFormat();
        if (r101 != (-1)) goto L5;
        Logger.d(TAG, "Using default AUDIO source format: 2");
        return 2;
    L5:
        Logger.d(TAG, "Using provided AUDIO source format: " + r101);
        return r101;
    }

    public static AudioMimeInfo resolveAudioMimeInfo(MediaSpec r100, VideoValidatedEncoderProfilesProxy r101) {
        String r102 = MediaSpec.outputFormatToAudioMime(r100.getOutputFormat());
        int r103 = MediaSpec.outputFormatToAudioProfile(r100.getOutputFormat());
        if (r101 != null) goto L5;
    L17:
        EncoderProfilesProxy.AudioProfileProxy r104 = null;
    L18:
        AudioMimeInfo.Builder r105 = AudioMimeInfo.builder(r102).setProfile(r103);
        if (r104 == null) goto L22;
        r105.setCompatibleAudioProfile(r104);
    L22:
        return r105.build();
    L5:
        if (r101.getDefaultAudioProfile() == null) goto L17;
        r104 = r101.getDefaultAudioProfile();
        String r106 = r104.getMediaType();
        int r107 = r104.getProfile();
        if (Objects.equals(r106, EncoderProfilesProxy.AudioProfileProxy.MEDIA_TYPE_NONE) == false) goto L10;
        Logger.d(TAG, "EncoderProfiles contains undefined AUDIO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: " + r102 + "(profile: " + r103 + ")]");
        goto L17
    L10:
        if (r100.getOutputFormat() != (-1)) goto L13;
        Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_AUTO. Using EncoderProfiles to derive AUDIO settings [mime type: " + r106 + "(profile: " + r107 + ")]");
        r102 = r106;
        r103 = r107;
        goto L18
    L13:
        if (Objects.equals(r102, r106) == false) goto L16;
        if (r103 != r107) goto L16;
        Logger.d(TAG, "MediaSpec audio mime/profile matches EncoderProfiles. Using EncoderProfiles to derive AUDIO settings [mime type: " + r106 + "(profile: " + r103 + ")]");
        r102 = r106;
    L16:
        Logger.d(TAG, "MediaSpec audio mime or profile does not match EncoderProfiles, so EncoderProfiles settings cannot be used. May rely on fallback defaults to derive AUDIO settings [EncoderProfiles mime type: " + r106 + "(profile: " + r107 + "), chosen mime type: " + r102 + "(profile: " + r103 + ")]");
        goto L17
    }

    public static AudioSettings resolveAudioSettings(AudioMimeInfo r100, AudioSpec r101) {
        EncoderProfilesProxy.AudioProfileProxy r102 = r100.getCompatibleAudioProfile();
        if (r102 == null) goto L5;
        Supplier r103 = new AudioSettingsAudioProfileResolver(r101, r102);
    L7:
        return (AudioSettings) r103.get();
    L5:
        r103 = new AudioSettingsDefaultResolver(r101);
        goto L7
    }

    private static /* synthetic */ int lambda$selectSampleRateOrNearestSupported$0(int r100, Integer r101, Integer r102) {
        int r103 = Math.abs(r101.intValue() - r100) - Math.abs(r102.intValue() - r100);
        if (r103 != 0) goto L7;
        float r104 = Math.signum(r101.intValue() - r102.intValue());
    L6:
        return (int) r104;
    L7:
        r104 = Math.signum(r103);
        goto L6
    }

    public static AudioEncoderConfig resolveAudioEncoderConfig(AudioMimeInfo r110, Timebase r111, AudioSettings r112, AudioSpec r113) {
        EncoderProfilesProxy.AudioProfileProxy r100 = r110.getCompatibleAudioProfile();
        if (r100 == null) goto L5;
        Supplier r101 = new AudioEncoderConfigAudioProfileResolver(r110.getMimeType(), r110.getProfile(), r111, r113, r112, r100);
    L7:
        return (AudioEncoderConfig) r101.get();
    L5:
        r101 = new AudioEncoderConfigDefaultResolver(r110.getMimeType(), r110.getProfile(), r111, r113, r112);
        goto L7
    }

    public static int selectSampleRateOrNearestSupported(Range<Integer> r100, int r101, int r102, final int r110) {
        ArrayList r103 = null;
        int r104 = 0;
        int r105 = r110;
    L4:
        if (r100.contains(Integer.valueOf(r105)) == true) goto L6;
        Logger.d(TAG, "Sample rate " + r105 + "Hz is not in target range " + r100);
    L10:
        if (r103 != null) goto L13;
        Logger.d(TAG, "Trying common sample rates in proximity order to target " + r110 + "Hz");
        r103 = new ArrayList(AudioSettings.COMMON_SAMPLE_RATES);
        Collections.sort(r103, new a(r110));
    L13:
        if (r104 >= r103.size()) goto L15;
        r105 = ((Integer) ListProtector.get(r103, r104)).intValue();
        r104 = r104 + 1;
        goto L4
    L15:
        Logger.d(TAG, "No sample rate found in target range or supported by audio source. Falling back to default sample rate of 44100Hz");
        return AUDIO_SAMPLE_RATE_DEFAULT;
    L6:
        if (AudioSource.isSettingsSupported(r105, r101, r102) == true) goto L7;
        Logger.d(TAG, "Sample rate " + r105 + "Hz is not supported by audio source with channel count " + r101 + " and source format " + r102);
        goto L10
    L7:
        return r105;
    }

    public static int scaleAndClampBitrate(int r100, int r101, int r102, int r103, int r110, Range<Integer> r111) {
        int r104 = (int) ((((double) r100) * new Rational(r101, r102).doubleValue()) * new Rational(r103, r110).doubleValue());
        if (Logger.isDebugEnabled(TAG) == false) goto L5;
        String r105 = String.format("Base Bitrate(%dbps) * Channel Count Ratio(%d / %d) * Sample Rate Ratio(%d / %d) = %d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(r110), Integer.valueOf(r104)});
    L7:
        if (AudioSpec.BITRATE_RANGE_AUTO.equals(r111) == true) goto L11;
        r104 = ((Integer) r111.clamp(Integer.valueOf(r104))).intValue();
        if (Logger.isDebugEnabled(TAG) == false) goto L11;
        r105 = r105 + String.format("\nClamped to range %s -> %dbps", new Object[]{r111, Integer.valueOf(r104)});
    L11:
        Logger.d(TAG, r105);
        return r104;
    L5:
        r105 = "";
        goto L7
    }
}
