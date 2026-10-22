package com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup;

import com.bytedance.android.gamecp.base.gamedetail.BetaApplyStage;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/betaapply/signup/d;", "p1", "Lcom/bytedance/android/gamecp/base/gamedetail/BetaApplyStage;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/gamecp/business/gamedetail/component/betaapply/signup/d;)Lcom/bytedance/android/gamecp/base/gamedetail/BetaApplyStage;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class BetaApplyButtonItemWidget$onUpdate$1 extends FunctionReferenceImpl implements Function1<d, BetaApplyStage> {
    public static final BetaApplyButtonItemWidget$onUpdate$1 INSTANCE = null;

    static {
        INSTANCE = new BetaApplyButtonItemWidget$onUpdate$1();
    }

    public BetaApplyButtonItemWidget$onUpdate$1() {
        super(1, d.class, "getBetaApplyStage", "getBetaApplyStage()Lcom/bytedance/android/gamecp/base/gamedetail/BetaApplyStage;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final BetaApplyStage invoke2(d r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        if (r100.f53811e == true) goto L6;
        return BetaApplyStage.UN_SUPPORT;
    L6:
        if (r100.f53808b == false) goto L9;
        return BetaApplyStage.SIGN_UP_FINISH;
    L9:
        return BetaApplyStage.NOT_SIGNED_UP;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ BetaApplyStage invoke(d r100) {
        return invoke2(r100);
    }
}
