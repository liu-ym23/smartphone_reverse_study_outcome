package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.window.shop.repository.tab.entity.j0;
import com.bytedance.android.window.shop.repository.tab.entity.k0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/j0;", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/k0;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/window/shop/repository/tab/entity/j0;)Lcom/bytedance/android/window/shop/repository/tab/entity/k0;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowDataMapper$customSingleTransformers$1 extends FunctionReferenceImpl implements Function1<j0, k0> {
    public WindowDataMapper$customSingleTransformers$1(k0.a r100) {
        super(1, r100, k0.a.class, "create", "create(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowSyncBannerNoticeDTO;)Lcom/bytedance/android/window/shop/repository/tab/entity/WindowSyncNoticeBannerVO;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final k0 invoke2(j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((k0.a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "dto");
        String r101 = r100.a();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        Integer r102 = r100.b();
        if (r102 == null) goto L8;
        int r103 = r102.intValue();
    L10:
        return new k0(r101, r103, r100.c());
    L8:
        r103 = 0;
        goto L10
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ k0 invoke(j0 r100) {
        return invoke2(r100);
    }
}
