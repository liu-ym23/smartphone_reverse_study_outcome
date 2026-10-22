package com.bytedance.android.live.liveinteract.revenue.linkroomfight.rtc;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.ILiveWrappedVideoSink;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import uf2.x;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements ILiveWrappedVideoSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f78544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f78545b;

    @Override // com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.ILiveWrappedVideoSink
    public final void a(fg2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        int r101 = (((r100.width() + 8) - 1) / 8) * 8;
        int r102 = (((r100.height() + 4) - 1) / 4) * 4;
        ByteBuffer r103 = ByteBuffer.allocateDirect((r101 * r102) + ((((r101 + 1) / 2) * ((r102 + 1) / 2)) * 2));
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r104 = ILiveWrappedLivePusher.a.b();
        if (r104 == null) goto L5;
        r104.getYuvHelper();
    L5:
        r103.position(0);
        if (this.f78544a == false) goto L11;
        x r105 = this.f78545b;
        if (r105 == null) goto L12;
        r100.timestampUs();
        r105.n();
        return;
    L12:
        return;
    }

    public c(boolean r100, x r101) {
        this.f78544a = r100;
        this.f78545b = r101;
    }
}
