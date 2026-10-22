package com.bytedance.android.ec.host.impl;

import com.bytedance.android.shopping.anchorv4.ai.j0;
import com.larus.bmhome.ability.FloatChatWindowState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b0 implements va8.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xe.b f46199a;

    @Override // va8.i
    public final void LS(float r100) {
    }

    public final int hashCode() {
        return this.f46199a.hashCode();
    }

    public b0(j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f46199a = r100;
    }

    @Override // va8.i
    public final void am(va8.h r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        xe.b r101 = this.f46199a;
        FloatChatWindowState r102 = r100.f553966a;
        int r103 = b.a.f46198a[r102.ordinal()];
        if (r103 != 1) goto L5;
    L11:
        com.bytedance.android.ec.base.api.ai.FloatChatWindowState r104 = com.bytedance.android.ec.base.api.ai.FloatChatWindowState.COLLAPSED;
    L12:
        r101.a(r104);
        return;
    L5:
        if (r103 == 2) goto L11;
        if (r103 != 3) goto L10;
        r104 = com.bytedance.android.ec.base.api.ai.FloatChatWindowState.EXPANDED;
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b0) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f46199a, ((b0) r100).f46199a) == false) goto L7;
        return true;
    }
}
