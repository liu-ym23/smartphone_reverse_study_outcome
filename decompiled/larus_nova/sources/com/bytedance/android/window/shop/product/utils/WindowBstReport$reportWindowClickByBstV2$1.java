package com.bytedance.android.window.shop.product.utils;

import com.bytedance.android.bst.api.d;
import com.bytedance.android.bst.api.f;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/bst/api/d;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/bst/api/d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowBstReport$reportWindowClickByBstV2$1 extends FunctionReferenceImpl implements Function1<d, Unit> {
    public WindowBstReport$reportWindowClickByBstV2$1(f r100) {
        super(1, r100, f.class, "clickTrack", "clickTrack(Lcom/bytedance/android/bst/api/BstItem;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(d r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((f) this.receiver).getClass();
        f.c(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(d r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
