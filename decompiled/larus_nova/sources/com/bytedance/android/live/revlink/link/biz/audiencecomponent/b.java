package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import f31.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements com.bytedance.android.live.revlink.impl.region.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f97760a;

    @Override // com.bytedance.android.live.revlink.impl.region.a
    public final int a() {
        return this.f97760a.f475353f;
    }

    @Override // com.bytedance.android.live.revlink.impl.region.a
    public final int b() {
        return this.f97760a.f475351d;
    }

    @Override // com.bytedance.android.live.revlink.impl.region.a
    public final String c() {
        String r100 = this.f97760a.f475348a;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.live.revlink.impl.region.a
    public final int d() {
        return this.f97760a.f475352e;
    }

    @Override // com.bytedance.android.live.revlink.impl.region.a
    public final int e() {
        return this.f97760a.f475350c;
    }

    @Override // com.bytedance.android.live.revlink.impl.region.a
    public final String getUserID() {
        return this.f97760a.f475349b;
    }

    public b(k r100) {
        Intrinsics.checkNotNullParameter(r100, "windowStatus");
        this.f97760a = r100;
    }
}
