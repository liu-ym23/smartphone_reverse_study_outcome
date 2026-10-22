package com.bytedance.android.window.shop.holder;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements WindowHotsaleLoadMoreHolder.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowHotsaleLoadMoreHolder f187924a;

    public c(WindowHotsaleLoadMoreHolder r100) {
        this.f187924a = r100;
    }

    @Override // com.bytedance.android.window.shop.holder.WindowHotsaleLoadMoreHolder.b
    public final void a(List<? extends sq3.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        WindowHotsaleLoadMoreHolder r101 = this.f187924a;
        WindowHotsaleLoadMoreHolder.a r102 = r101.f187862v;
        if (r102 == null) goto L6;
        r102.b(r101.getLayoutPosition(), r100);
        return;
    }

    @Override // com.bytedance.android.window.shop.holder.WindowHotsaleLoadMoreHolder.b
    public final void b(sq3.e r100, List<? extends sq3.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "loadMoreVO");
        Intrinsics.checkNotNullParameter(r101, "list");
        WindowHotsaleLoadMoreHolder r102 = this.f187924a;
        WindowHotsaleLoadMoreHolder.a r103 = r102.f187862v;
        if (r103 == null) goto L6;
        r103.a(r102.getLayoutPosition(), r100, r101);
        return;
    }
}
