package com.bytedance.android.shopping.anchorv3.activities.quick.uimodule;

import com.bytedance.commerce.base.drawable.c;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import wf4.b;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/commerce/base/drawable/c;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/commerce/base/drawable/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class RuleUIModule$onViewCreated$1 extends Lambda implements Function1<c, Unit> {
    public static final RuleUIModule$onViewCreated$1 INSTANCE = null;

    static {
        INSTANCE = new RuleUIModule$onViewCreated$1();
    }

    public RuleUIModule$onViewCreated$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.g(b.C8105b.f559471b);
        r100.a(ColorProtector.parseColor("#08161823"));
        r100.f(AnonymousClass1.INSTANCE);
        r100.c(AnonymousClass2.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
