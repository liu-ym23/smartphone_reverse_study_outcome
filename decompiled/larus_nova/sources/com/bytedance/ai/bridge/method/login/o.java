package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.postMcpLogin.AbsPostLoginResultMethodIDL;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class o implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h f35566a;

    public /* synthetic */ o(f3.h r100) {
        this.f35566a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        f3.h r101 = this.f35566a;
        int r102 = PostLoginResultMethod.f35543b;
        Object r103 = ((Result) r100).m9458unboximpl();
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L6;
        Unit r105 = (Unit) r103;
        Intrinsics.checkNotNullParameter(AbsPostLoginResultMethodIDL.a.class, "<this>");
        f3.h.a.b(r101, (ResultModel) k3.c.a(AbsPostLoginResultMethodIDL.a.class));
    L13:
        return Unit.INSTANCE;
    L6:
        if ((r104 instanceof Exception) == false) goto L8;
        Exception r106 = (Exception) r104;
    L9:
        if (r106 != null) goto L11;
        r106 = new Exception(r104);
    L11:
        f3.h.a.a(r101, "Error: " + r104.getMessage(), d.a(r106), null, 10);
        goto L13
    L8:
        r106 = null;
        goto L9
    }
}
