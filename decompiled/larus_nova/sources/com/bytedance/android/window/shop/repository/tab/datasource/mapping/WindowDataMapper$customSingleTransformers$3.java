package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.window.base.repository.dto.q;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.d0;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.repository.tab.entity.l0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/l0;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/e0;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/window/shop/repository/tab/entity/l0;)Lcom/bytedance/android/window/shop/repository/tab/entity/e0;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$customSingleTransformers$3 extends FunctionReferenceImpl implements Function1<l0, e0> {
    public WindowDataMapper$customSingleTransformers$3(e0.a r100) {
        super(1, r100, e0.a.class, "create", "create(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowToolbarDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductToolBarVO;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final e0 invoke2(l0 r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((e0.a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "dto");
        int r101 = d0.f189535k;
        List<q> r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = CollectionsKt.emptyList();
    L5:
        d0 r103 = d0.a.a(r102);
        WindowLayoutType.a r104 = WindowLayoutType.Companion;
        Integer r105 = r100.a();
        r104.getClass();
        WindowLayoutType r106 = WindowLayoutType.a.a(r105);
        if (r106 != null) goto L9;
        r106 = WindowLayoutType.SINGLECOLUMN;
    L9:
        return new e0(r103, r106, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ e0 invoke(l0 r100) {
        return invoke2(r100);
    }
}
