package com.bytedance.android.livesdk.rank;

import com.bytedance.android.scope.o;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements o, yz0.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cy0.f f156952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yz0.k f156953b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // yz0.m
    public final void i() {
        n r100 = new n(this.f156952a);
        Intrinsics.checkNotNullParameter(r100, "scope");
        Object r101 = e33.k.f470908a;
        if (r100.f156987e != r101) goto L6;
        String r102 = "revenueInstance";
    L12:
        if (r102 != null) goto L16;
        com.bytedance.android.scope.l.a(r100);
        return;
    L16:
        throw new UninitializedPropertyAccessException(r102);
    L6:
        if (r100.f156988f != r101) goto L9;
        r102 = "revenueInstanceExt";
        goto L12
    L9:
        if (r100.f156989g != r101) goto L11;
        r102 = "roomInstance";
        goto L12
    L11:
        r102 = null;
        goto L12
    }

    public b(cy0.f r100, yz0.k r101) {
        Intrinsics.checkNotNullParameter(r100, "instanceScope");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        this.f156952a = r100;
        this.f156953b = r101;
    }
}
