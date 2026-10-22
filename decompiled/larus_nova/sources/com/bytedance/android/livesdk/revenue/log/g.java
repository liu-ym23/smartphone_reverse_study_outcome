package com.bytedance.android.livesdk.revenue.log;

import com.bytedance.android.livesdk.log.model.FollowLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FollowLog f157174a;

    public final void d() {
        this.f157174a.f153385d = 1;
    }

    public final void b() {
        Intrinsics.checkNotNullParameter("live", "source");
        this.f157174a.f153382a = "live";
    }

    public g() {
        this.f157174a = new FollowLog(-1);
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f157174a.f153383b = r100;
    }

    public final void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "followTarget");
        Intrinsics.checkNotNullParameter(r102, "isCurrentAnchor");
        FollowLog r103 = this.f157174a;
        r103.f153387f = r100;
        r103.f153388g = r101;
        r103.f153389h = r102;
    }
}
