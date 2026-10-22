package com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup;

import com.bytedance.ies.sve_core.s;
import com.bytedance.ies.sve_core.u;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f53819b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f53820a;

    public static final class a {
        public static u a() {
            return new u("sign_up_state");
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (this.f53820a == ((f) r100).f53820a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f53820a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "BetaApplySignUpState(signUpSuccess=" + this.f53820a + ")";
    }

    public f(boolean r100) {
        this.f53820a = r100;
    }
}
