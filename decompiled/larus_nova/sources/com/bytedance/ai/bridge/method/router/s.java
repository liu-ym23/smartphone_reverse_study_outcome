package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class s implements Function3<k2.j, Boolean, String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsReplyLocalPluginMethodIDL.b> f35881a;

    public s(f3.h<AbsReplyLocalPluginMethodIDL.b> r100) {
        this.f35881a = r100;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(k2.j r100, Boolean r101, String r102) {
        boolean r103 = r101.booleanValue();
        String r104 = r102;
        Intrinsics.checkNotNullParameter(r104, "message");
        if (r103 == false) goto L5;
        f3.h<AbsReplyLocalPluginMethodIDL.b> r105 = this.f35881a;
        Intrinsics.checkNotNullParameter(AbsReplyLocalPluginMethodIDL.b.class, "<this>");
        f3.h.a.b(r105, (ResultModel) k3.c.a(AbsReplyLocalPluginMethodIDL.b.class));
    L7:
        return Unit.INSTANCE;
    L5:
        f3.h.a.a(this.f35881a, r104, null, null, 14);
        goto L7
    }
}
