package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.openLoginPage.AbsOpenLoginPageMethodIDL;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class l implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h f35561a;

    public /* synthetic */ l(f3.h r100) {
        this.f35561a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        f3.h r101 = this.f35561a;
        int r102 = OpenLoginPageMethod.f35542b;
        Object r103 = ((Result) r100).m9458unboximpl();
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L5;
        Unit r105 = (Unit) r103;
        Intrinsics.checkNotNullParameter(AbsOpenLoginPageMethodIDL.a.class, "<this>");
        f3.h.a.b(r101, (ResultModel) k3.c.a(AbsOpenLoginPageMethodIDL.a.class));
    L10:
        return Unit.INSTANCE;
    L5:
        com.bytedance.ai.utils.g.f37637a.e("OpenLoginPageMethod", "open MOA login page failed: " + r104.getMessage());
        String r106 = r104.getMessage();
        if (r106 != null) goto L8;
        r106 = "openLoginPage failed";
    L8:
        f3.h.a.a(r101, r106, null, null, 14);
        goto L10
    }
}
