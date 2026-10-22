package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends com.bytedance.ies.web.jsbridge2.g<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.scope.j f129706a;

    public c(com.bytedance.android.scope.j r100) {
        this.f129706a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        i12.d r102 = i12.m.f487958e2.a();
        if (r102 == null) goto L5;
        Object r103 = com.bytedance.android.scope.m.f163449e.d(r102, oc6.o.class);
    L6:
        oc6.o r104 = (oc6.o) r103;
        if (r104 == null) goto L9;
        r104.dismissGiftDialog("");
    L9:
        return null;
    L5:
        r103 = null;
        goto L6
    }
}
