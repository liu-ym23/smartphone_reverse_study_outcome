package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/m$b;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/shopping/api/mall/m$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class MallPreloadTaskManager$startPreRenderTemplate$1$3 extends Lambda implements Function1<com.bytedance.android.shopping.api.mall.m.b, Unit> {
    public static final MallPreloadTaskManager$startPreRenderTemplate$1$3 INSTANCE = null;

    static {
        INSTANCE = new MallPreloadTaskManager$startPreRenderTemplate$1$3();
    }

    public MallPreloadTaskManager$startPreRenderTemplate$1$3() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.shopping.api.mall.m.b r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.onStart();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.shopping.api.mall.m.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
