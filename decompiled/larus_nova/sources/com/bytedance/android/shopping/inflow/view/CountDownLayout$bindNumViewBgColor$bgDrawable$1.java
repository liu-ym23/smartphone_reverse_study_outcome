package com.bytedance.android.shopping.inflow.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/commerce/base/drawable/c;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/commerce/base/drawable/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class CountDownLayout$bindNumViewBgColor$bgDrawable$1 extends Lambda implements Function1<com.bytedance.commerce.base.drawable.c, Unit> {
    final /* synthetic */ String $bgColor;

    public CountDownLayout$bindNumViewBgColor$bgDrawable$1(String r100) {
        this.$bgColor = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.commerce.base.drawable.c r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.a(com.bytedance.android.shopping.extensions.a.a(this.$bgColor, 0));
        r100.c(AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.commerce.base.drawable.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
