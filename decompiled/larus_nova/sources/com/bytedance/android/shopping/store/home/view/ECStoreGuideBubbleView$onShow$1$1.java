package com.bytedance.android.shopping.store.home.view;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECStoreGuideBubbleView$onShow$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LifecycleOwner $it;

    public ECStoreGuideBubbleView$onShow$1$1(LifecycleOwner r100) {
        this.$it = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.bytedance.android.ec.store.common.bubble.c.e(ECBubbleControllerManager.f48207b.a(this.$it));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
