package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamAudioCodecType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamAudioProfile;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveWrappedMixedStreamAudioCodecType f18859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveWrappedMixedStreamAudioProfile f18863e;

    public final String toString() {
        return "LiveWrappedMixedStreamAudioConfig{audioProfile='" + this.f18863e + "', channels=" + this.f18862d + ", sampleRate=" + this.f18861c + ", bitrate=" + this.f18860b + ", audioCodec=" + this.f18859a + '}';
    }

    public c() {
        this.f18859a = LiveWrappedMixedStreamAudioCodecType.MIXED_STREAM_AUDIO_CODEC_TYPE_AAC;
        this.f18860b = 64;
        this.f18861c = 48000;
        this.f18862d = 2;
        this.f18863e = LiveWrappedMixedStreamAudioProfile.MIXED_STREAM_AUDIO_PROFILE_LC;
    }
}
