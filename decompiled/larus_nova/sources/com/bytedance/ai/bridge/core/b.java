package com.bytedance.ai.bridge.core;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import f3.h;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final <T extends ResultModel> void a(a<? extends T> r100, h<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if ((r100 instanceof a.c) == false) goto L6;
        a.c r102 = (a.c) r100;
        r101.b((ResultModel) r102.f35249b, r102.f35250c);
        return;
    L6:
        if ((r100 instanceof a.b) == false) goto L10;
        a.b r103 = (a.b) r100;
        r101.c(r103.f35245c, r103.f35244b, r103.f35247e, r103.f35246d);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
