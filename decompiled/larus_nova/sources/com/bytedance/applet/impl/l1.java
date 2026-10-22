package com.bytedance.applet.impl;

import com.bytedance.ai.api.OperateResult;
import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import com.bytedance.ai.applet.granting.GrantingAction;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class l1 implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f191968a;

    public /* synthetic */ l1(DouyinGeneralAuthHelper.b r100) {
        this.f191968a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        OperateResult r102 = (OperateResult) r100;
        Intrinsics.checkNotNullParameter(r102, "result");
        GrantingAction r103 = z1.a(r102);
        this.f191968a.invoke(r103, (String) r101);
        return Unit.INSTANCE;
    }
}
