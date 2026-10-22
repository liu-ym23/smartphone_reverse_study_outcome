package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamVideoCodecType;

/* JADX INFO: loaded from: classes10.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveWrappedMixedStreamVideoCodecType f18922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f18927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18928g;

    public final String toString() {
        return "LiveWrappedMixedStreamVideoConfig{videoCodec='" + this.f18922a + "', fps=" + this.f18923b + ", gop=" + this.f18924c + ", bitrate=" + this.f18925d + ", width=" + this.f18926e + ", height=" + this.f18927f + ", enableBframe=" + this.f18928g + '}';
    }

    public p() {
        this.f18922a = LiveWrappedMixedStreamVideoCodecType.MIXED_STREAM_VIDEO_CODEC_TYPE_H264;
        this.f18923b = 15;
        this.f18924c = 2;
        this.f18925d = 500;
        this.f18926e = 360;
        this.f18927f = 640;
    }
}
