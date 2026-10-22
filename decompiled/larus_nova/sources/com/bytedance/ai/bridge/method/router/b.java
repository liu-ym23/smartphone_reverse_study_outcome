package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements Function3<k2.j, Boolean, String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsCreateTextMethodIDL.b> f35828a;

    public b(f3.h<AbsCreateTextMethodIDL.b> r100) {
        this.f35828a = r100;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(k2.j r100, Boolean r101, String r102) {
        boolean r103 = r101.booleanValue();
        Intrinsics.checkNotNullParameter(r102, "message");
        if (r103 == false) goto L5;
        f3.h<AbsCreateTextMethodIDL.b> r104 = this.f35828a;
        Intrinsics.checkNotNullParameter(AbsCreateTextMethodIDL.b.class, "<this>");
        f3.h.a.b(r104, (ResultModel) k3.c.a(AbsCreateTextMethodIDL.b.class));
    L7:
        return Unit.INSTANCE;
    L5:
        f3.h.a.a(this.f35828a, null, null, null, 15);
        goto L7
    }
}
