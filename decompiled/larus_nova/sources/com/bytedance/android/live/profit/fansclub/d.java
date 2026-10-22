package com.bytedance.android.live.profit.fansclub;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements com.bytedance.android.scope.o, yz0.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cy0.f f87285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yz0.k f87286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n01.a f87287c;

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

    public final DataCenter getDataCenter() {
        return this.f87286b.getDataCenter();
    }

    @Override // yz0.m
    public final void i() {
        ALogger.d("FansClubLoaderService", "FansClubLoaderService->onRoomReady");
        t r100 = new t(this.f87285a);
        Intrinsics.checkNotNullParameter(r100, "scope");
        Object r101 = e33.k.f470908a;
        if (r100.f87358e != r101) goto L6;
        String r102 = "revenueInstance";
    L12:
        if (r102 != null) goto L16;
        com.bytedance.android.scope.l.a(r100);
        return;
    L16:
        throw new UninitializedPropertyAccessException(r102);
    L6:
        if (r100.f87359f != r101) goto L9;
        r102 = "revenueInstanceExt";
        goto L12
    L9:
        if (r100.f87360g != r101) goto L11;
        r102 = "roomInstance";
        goto L12
    L11:
        r102 = null;
        goto L12
    }

    public d(cy0.f r100, yz0.k r101, n01.a r102) {
        Intrinsics.checkNotNullParameter(r100, "instScope");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "vsService");
        this.f87285a = r100;
        this.f87286b = r101;
        this.f87287c = r102;
    }
}
