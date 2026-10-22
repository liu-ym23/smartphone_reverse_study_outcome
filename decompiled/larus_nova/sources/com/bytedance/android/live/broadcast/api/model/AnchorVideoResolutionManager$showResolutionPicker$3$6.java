package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AnchorVideoResolutionManager$showResolutionPicker$3$6 extends Lambda implements Function1<String, Unit> {
    public static final AnchorVideoResolutionManager$showResolutionPicker$3$6 INSTANCE = null;

    static {
        INSTANCE = new AnchorVideoResolutionManager$showResolutionPicker$3$6();
    }

    public AnchorVideoResolutionManager$showResolutionPicker$3$6() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Map<String, Pair<Integer, Integer>> r101 = AnchorVideoResolutionManager.f59009a;
        AnchorVideoResolutionManager.k(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
