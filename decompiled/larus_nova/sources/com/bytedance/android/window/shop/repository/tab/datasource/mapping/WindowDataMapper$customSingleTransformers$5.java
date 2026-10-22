package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.window.shop.repository.tab.entity.a0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/a0;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/a0;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$customSingleTransformers$5 extends FunctionReferenceImpl implements Function1<Object, a0> {
    public WindowDataMapper$customSingleTransformers$5(a0.a r100) {
        super(1, r100, a0.a.class, "create", "create(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductEmptyWithCategoryAnchorVO;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final a0 invoke(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((a0.a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "ignored");
        return new a0();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ a0 invoke(Object r100) {
        return invoke(r100);
    }
}
