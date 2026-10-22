package com.bytedance.ai.applet.douyinAuth;

import com.bytedance.ai.applet.granting.GrantingAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GrantingAction f34623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34624b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f34623a == r101.f34623a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34624b, r101.f34624b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f34623a.hashCode() * 31;
        String r101 = this.f34624b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DouyinGeneralAuthRequestResult(userAction=" + this.f34623a + ", errorMsg=" + this.f34624b + ')';
    }

    public d(GrantingAction r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userAction");
        this.f34623a = r100;
        this.f34624b = r101;
    }
}
