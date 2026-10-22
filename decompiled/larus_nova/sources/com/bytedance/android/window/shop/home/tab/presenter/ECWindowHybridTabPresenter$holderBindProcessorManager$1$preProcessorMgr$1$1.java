package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zq3.v1;
import zq3.w1;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lzq3/w1;", "p1", "", "p2", "", AbsMethodDelegate.TAG_INVOKE, "(Lzq3/w1;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowHybridTabPresenter$holderBindProcessorManager$1$preProcessorMgr$1$1 extends FunctionReferenceImpl implements Function2<w1, String, Unit> {
    public static final ECWindowHybridTabPresenter$holderBindProcessorManager$1$preProcessorMgr$1$1 INSTANCE = null;

    static {
        INSTANCE = new ECWindowHybridTabPresenter$holderBindProcessorManager$1$preProcessorMgr$1$1();
    }

    public ECWindowHybridTabPresenter$holderBindProcessorManager$1$preProcessorMgr$1$1() {
        super(2, w1.class, "onRenderBegin", "onRenderBegin(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(w1 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        r100.getClass();
        if (r101 == null) goto L7;
        r100.c(new v1.f(r101));
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(w1 r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
