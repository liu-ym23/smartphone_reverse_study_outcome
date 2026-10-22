package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.privacySetting.AbsAgreePrivacyAuthorizationMethodIDL;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class c implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h f35547a;

    public /* synthetic */ c(f3.h r100) {
        this.f35547a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        f3.h r101 = this.f35547a;
        int r102 = AgreeAuthMethod.f35536b;
        Object r103 = ((Result) r100).m9458unboximpl();
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L5;
        Unit r105 = (Unit) r103;
        Intrinsics.checkNotNullParameter(AbsAgreePrivacyAuthorizationMethodIDL.a.class, "<this>");
        BaseModel r106 = k3.c.a(AbsAgreePrivacyAuthorizationMethodIDL.a.class);
        ((AbsAgreePrivacyAuthorizationMethodIDL.a) r106).setResult(true);
        f3.h.a.b(r101, (ResultModel) r106);
    L7:
        return Unit.INSTANCE;
    L5:
        f3.h.a.a(r101, "Error: " + r104.getMessage(), null, null, 14);
        goto L7
    }
}
