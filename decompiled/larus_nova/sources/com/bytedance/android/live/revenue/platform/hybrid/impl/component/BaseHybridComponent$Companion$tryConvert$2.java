package com.bytedance.android.live.revenue.platform.hybrid.impl.component;

import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "VIEW", "Lcom/bytedance/android/annie/card/base/BaseHybridComponent;", "p1", "Lcom/bytedance/android/live/revenue/platform/hybrid/impl/component/e;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/annie/card/base/BaseHybridComponent;)Lcom/bytedance/android/live/revenue/platform/hybrid/impl/component/e;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class BaseHybridComponent$Companion$tryConvert$2 extends FunctionReferenceImpl implements Function1<BaseHybridComponent, e> {
    public static final BaseHybridComponent$Companion$tryConvert$2 INSTANCE = null;

    static {
        INSTANCE = new BaseHybridComponent$Companion$tryConvert$2();
    }

    public BaseHybridComponent$Companion$tryConvert$2() {
        super(1, e.class, "<init>", "<init>(Lcom/bytedance/android/annie/card/base/BaseHybridComponent;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final e invoke2(BaseHybridComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return new e(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ e invoke(BaseHybridComponent r100) {
        return invoke2(r100);
    }
}
