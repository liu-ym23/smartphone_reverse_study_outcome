package com.bytedance.android.live.revlink.link.core.layoutstatus;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f98296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<o51.e> f98297b;

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.d
    public final o51.e getUiLayout() {
        return this.f98297b.invoke();
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.d
    public final void requestLayout() {
        this.f98296a.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function0<Unit> r100, Function0<? extends o51.e> r101) {
        Intrinsics.checkNotNullParameter(r100, "requestLayout");
        Intrinsics.checkNotNullParameter(r101, "uiLayoutGetter");
        this.f98296a = r100;
        this.f98297b = r101;
    }
}
