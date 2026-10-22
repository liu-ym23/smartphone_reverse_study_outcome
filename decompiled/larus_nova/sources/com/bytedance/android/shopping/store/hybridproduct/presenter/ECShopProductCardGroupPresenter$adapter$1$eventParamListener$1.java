package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "params", "", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECShopProductCardGroupPresenter$adapter$1$eventParamListener$1 extends Lambda implements Function1<Map<String, ? extends Object>, Unit> {
    public static final ECShopProductCardGroupPresenter$adapter$1$eventParamListener$1 INSTANCE = null;

    static {
        INSTANCE = new ECShopProductCardGroupPresenter$adapter$1$eventParamListener$1();
    }

    public ECShopProductCardGroupPresenter$adapter$1$eventParamListener$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
