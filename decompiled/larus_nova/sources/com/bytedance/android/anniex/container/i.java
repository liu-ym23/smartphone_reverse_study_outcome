package com.bytedance.android.anniex.container;

import android.view.View;
import com.bytedance.android.anniex.container.popup.SheetBaseBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i implements SheetBaseBehavior.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f40400a;

    @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.b
    public final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
    }

    public i(d r100) {
        this.f40400a = r100;
    }

    @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.b
    public final void b(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        ia.f.a r102 = this.f40400a.f40357b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        r102 = null;
    L5:
        r102.k(r101);
    }
}
