package com.bytedance.android.window.shop.holder.factory;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.WindowAnchorCardHolder;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Lfo/b;", "p2", "Lcom/bytedance/android/window/shop/holder/WindowAnchorCardHolder;", AbsMethodDelegate.TAG_INVOKE, "(Landroidx/fragment/app/Fragment;Lfo/b;)Lcom/bytedance/android/window/shop/holder/WindowAnchorCardHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowProductHolderFactory$windowHolderCreators$15 extends FunctionReferenceImpl implements Function2<Fragment, fo.b, WindowAnchorCardHolder> {
    public WindowProductHolderFactory$windowHolderCreators$15(WindowAnchorCardHolder.a r100) {
        super(2, r100, WindowAnchorCardHolder.a.class, "create", "create(Landroidx/fragment/app/Fragment;Lcom/bytedance/android/ec/window/base/common/typeddata/WindowTypedDataCache;)Lcom/bytedance/android/window/shop/holder/WindowAnchorCardHolder;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WindowAnchorCardHolder invoke2(Fragment r100, fo.b r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r101, "p2");
        ((WindowAnchorCardHolder.a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "unused");
        return new WindowAnchorCardHolder(r100);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WindowAnchorCardHolder invoke(Fragment r100, fo.b r101) {
        return invoke2(r100, r101);
    }
}
