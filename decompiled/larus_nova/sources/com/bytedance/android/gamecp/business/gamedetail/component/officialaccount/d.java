package com.bytedance.android.gamecp.business.gamedetail.component.officialaccount;

import com.bytedance.ies.sve_core.s;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f54711b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f54712a;

    public static final class a {
    }

    static {
    }

    public d() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (this.f54712a == ((d) r100).f54712a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f54712a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "FollowOfficialState(isFollow=" + this.f54712a + ")";
    }

    public d(boolean r100) {
        this.f54712a = r100;
    }
}
