package com.bytedance.android.bst.api.claymore;

import com.bytedance.android.btm.api.bst.EmptyBstInnerService;
import com.bytedance.android.btm.api.bst.b;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class ClayMoreInjects$injectInit$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ yc.a $loader;

    public ClayMoreInjects$injectInit$4(yc.a r100) {
        this.$loader = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$loader.getClass();
        yc.a.b(b.class, EmptyBstInnerService.class);
        this.$loader.getClass();
        yc.a.c(b.class, "com.bytedance.android.bst.impl.inner.BstInnerService");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
