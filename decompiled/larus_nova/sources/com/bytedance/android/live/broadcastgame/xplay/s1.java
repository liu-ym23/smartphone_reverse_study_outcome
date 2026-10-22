package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.livehostapi.business.depend.xplay.IByteRtcVideoFrame;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class s1 implements com.bytedance.android.live.broadcastgame.api.xplay.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f62351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IByteRtcVideoFrame f62352b;

    public final String toString() {
        return "XplayVideoFrame(" + com.bytedance.android.live.broadcastgame.api.xplay.a.a(this.f62352b) + ", yuvI420Buffer = " + this.f62351a + ')';
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.g
    public final ByteBuffer a() {
        return this.f62351a;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.g
    public final IByteRtcVideoFrame b() {
        return this.f62352b;
    }

    public s1(IByteRtcVideoFrame r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcVideoFrame");
        this.f62352b = r100;
    }
}
