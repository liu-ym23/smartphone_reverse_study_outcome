package com.bytedance.android.livesdk.widget;

import android.view.View;
import com.bytedance.android.livesdk.pannel.SheetBaseBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i1 implements SheetBaseBehavior.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveBottomSheetBehavior.c f161753a;

    public i1(LiveBottomSheetBehavior.c r100) {
        this.f161753a = r100;
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseBehavior.b
    public final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "var1");
        this.f161753a.b(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseBehavior.b
    public final void b(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "var1");
        this.f161753a.a(r100, r101);
    }
}
