package com.bytedance.android.live.revenue.platform.preference.impl;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements o, wz0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nr2.a f91572a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public d(nr2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f91572a = r100;
    }

    @Override // wz0.c
    public final wz0.a getStorage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = this.f91572a.G0(r100, Object.class);
        if (r101 != null) goto L7;
        return new wz0.a(null);
    L7:
        return new wz0.a(GsonProtectorUtils.toJson(GsonHelper.get(), r101).toString());
    }

    @Override // wz0.c
    public final void removeStorage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f91572a.G2(r100);
    }

    @Override // wz0.c
    public final void setStorage(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f91572a.Va(r100, r101, String.class);
    }
}
