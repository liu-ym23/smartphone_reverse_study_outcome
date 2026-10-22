package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.window.shop.repository.dto.l0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/l0;", "p1", "Ltq3/b;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/window/shop/repository/dto/l0;)Ltq3/b;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$productSingleTransformers$4 extends FunctionReferenceImpl implements Function1<l0, tq3.b> {
    public WindowDataMapper$productSingleTransformers$4(tq3.b.a r100) {
        super(1, r100, tq3.b.a.class, "transFromDto", "transFromDto(Lcom/bytedance/android/window/shop/repository/dto/WindowHintTextDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/product/WindowHintTextVO;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final tq3.b invoke2(l0 r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((tq3.b.a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "dto");
        String r101 = r100.a();
        if (r101 != null) goto L6;
        return null;
    L6:
        return new tq3.b(r101);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ tq3.b invoke(l0 r100) {
        return invoke2(r100);
    }
}
