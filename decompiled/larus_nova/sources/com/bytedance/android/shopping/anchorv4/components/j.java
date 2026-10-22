package com.bytedance.android.shopping.anchorv4.components;

import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j implements com.bytedance.android.shopping.api.mall.feed.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f166097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GulComponent f166098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.api.mall.feed.d f166099c;

    @Override // com.bytedance.android.shopping.api.mall.feed.f
    public final void a(ECMallFeedState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = i.f166094a[r100.ordinal()];
        if (r101 == 1) goto L9;
        if (r101 != 4) goto L6;
    L8:
        int r102 = com.bytedance.android.shopping.utils.z.f187162a;
        com.bytedance.android.shopping.utils.z.c("gul init success state=" + r100, "gul", 4);
        this.f166099c.b();
        return;
    L6:
        if (r101 == 5) goto L8;
        return;
    L9:
        int r103 = com.bytedance.android.shopping.utils.z.f187162a;
        com.bytedance.android.shopping.utils.z.c("gul init failed state=" + r100, "gul", 4);
        if (this.f166097a == true) goto L14;
        this.f166097a = true;
        this.f166098b.j0(this.f166099c);
        return;
    }

    public j(GulComponent r100, com.bytedance.android.shopping.api.mall.feed.d r101) {
        this.f166098b = r100;
        this.f166099c = r101;
    }
}
