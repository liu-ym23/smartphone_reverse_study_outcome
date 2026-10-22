package com.bytedance.android.shopping.sku.inner.controller;

import android.os.Handler;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class SkuYataRecyclerBottomSheetController$handleRecyclerViewFlingClick$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SkuYataRecyclerBottomSheetController this$0;

    public SkuYataRecyclerBottomSheetController$handleRecyclerViewFlingClick$1(SkuYataRecyclerBottomSheetController r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.shopping.sku.inner.controller.SkuYataRecyclerBottomSheetController$handleRecyclerViewFlingClick$1$cancelRunnable$1] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final Handler r100 = new Handler();
        final Ref.IntRef r101 = new Ref.IntRef();
        r101.element = -1;
        final ?? r102 = new SkuYataRecyclerBottomSheetController$handleRecyclerViewFlingClick$1$cancelRunnable$1(this, r101);
        RecyclerView r103 = this.this$0.f182880a;
        if (r103 == null) goto L6;
        r103.addOnScrollListener(new AnonymousClass1(r100, r102, r101));
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
