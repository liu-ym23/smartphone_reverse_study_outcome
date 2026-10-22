package com.bytedance.android.shopping.sameproduct;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SameProductListFragment$initViews$2$1 extends FunctionReferenceImpl implements Function1<View, Boolean> {
    public SameProductListFragment$initViews$2$1(StaggeredGridDoubleColumnDecoration.a r100) {
        super(1, r100, StaggeredGridDoubleColumnDecoration.a.class, "needDecoration", "needDecoration(Landroid/view/View;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((StaggeredGridDoubleColumnDecoration.a) this.receiver).getClass();
        return StaggeredGridDoubleColumnDecoration.a.a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(View r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
