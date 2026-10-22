package com.bytedance.android.live.livelink.platformapi.avclient.video;

import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f81369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f81370b;

    public final boolean b() {
        if (this.f81369a.s1().f89390a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void f() {
        this.f81369a.i1(new uv0.a(LiveRequestSourceRole.Business, "AndroidVideoCaptureApi.switchVideoCapture", null));
    }

    public final int h() {
        d0.a r100 = this.f81370b.getBuilder();
        if (r100 != null) goto L7;
        return 4;
    L7:
        return r100.g();
    }

    public final void c(int r100) {
        d0.a r101 = this.f81370b.getBuilder();
        if (r101 == null) goto L6;
        r101.B();
        return;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f81369a.U0(new uv0.a(LiveRequestSourceRole.Business, "AndroidVideoCaptureApi.startVideoCapture", null));
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f81369a.k1(new uv0.a(LiveRequestSourceRole.Business, "AndroidVideoCaptureApi.stopVideoCapture", null));
    }

    public final void g(int r100) {
        this.f81369a.Z0(r100, new uv0.a(LiveRequestSourceRole.Business, "AndroidVideoCaptureApi.switchVideoCaptureWithDevice", null));
    }

    public a(d r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "liveStream");
        Intrinsics.checkNotNullParameter(r101, "liveCore");
        this.f81369a = r100;
        this.f81370b = r101;
    }

    public final void a(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f81369a.P0(r100, r101);
    }
}
