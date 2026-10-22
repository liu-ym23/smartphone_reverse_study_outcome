package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import android.content.Context;
import com.bytedance.android.ec.window.base.dynamicview.common.ECRoundedConstraintLayout;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/bytedance/android/ec/window/base/dynamicview/common/ECRoundedConstraintLayout;", "LP", "Landroid/view/ViewGroup$LayoutParams;", "p1", "Landroid/content/Context;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LinearGroupViewElement$Companion$constraintGroupMaker$1 extends FunctionReferenceImpl implements Function1<Context, ECRoundedConstraintLayout> {
    public static final LinearGroupViewElement$Companion$constraintGroupMaker$1 INSTANCE = null;

    static {
        INSTANCE = new LinearGroupViewElement$Companion$constraintGroupMaker$1();
    }

    public LinearGroupViewElement$Companion$constraintGroupMaker$1() {
        super(1, ECRoundedConstraintLayout.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ECRoundedConstraintLayout invoke2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return new ECRoundedConstraintLayout(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ECRoundedConstraintLayout invoke(Context r100) {
        return invoke2(r100);
    }
}
