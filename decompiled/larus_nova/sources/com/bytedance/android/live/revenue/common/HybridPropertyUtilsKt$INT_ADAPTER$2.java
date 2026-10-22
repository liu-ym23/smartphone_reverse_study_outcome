package com.bytedance.android.live.revenue.common;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class HybridPropertyUtilsKt$INT_ADAPTER$2 extends FunctionReferenceImpl implements Function2<String, Object, Unit> {
    public static final HybridPropertyUtilsKt$INT_ADAPTER$2 INSTANCE = null;

    static {
        INSTANCE = new HybridPropertyUtilsKt$INT_ADAPTER$2();
    }

    public HybridPropertyUtilsKt$INT_ADAPTER$2() {
        super(2, HybridPropertyUtilsKt.class, "writeToString", "writeToString(Ljava/lang/String;Ljava/lang/Object;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Object r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r101, "p2");
        HybridPropertyUtilsKt.a(r100, r101);
    }
}
