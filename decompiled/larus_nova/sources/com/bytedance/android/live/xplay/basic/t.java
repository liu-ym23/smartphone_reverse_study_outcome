package com.bytedance.android.live.xplay.basic;

import com.bytedance.android.livehostapi.business.depend.xplay.IByteRtcVideoFrame;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class t implements com.bytedance.android.live.broadcastgame.api.xplay.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f102869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IByteRtcVideoFrame f102870b;

    public final String toString() {
        return "XplayVideoFrame(" + com.bytedance.android.live.broadcastgame.api.xplay.a.a(this.f102870b) + ", yuvI420Buffer = " + this.f102869a + ')';
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.g
    public final ByteBuffer a() {
        return this.f102869a;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.g
    public final IByteRtcVideoFrame b() {
        return this.f102870b;
    }

    public t(IByteRtcVideoFrame r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcVideoFrame");
        this.f102870b = r100;
    }
}
