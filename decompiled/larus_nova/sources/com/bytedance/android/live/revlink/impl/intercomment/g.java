package com.bytedance.android.live.revlink.impl.intercomment;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f92541a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (this.f92541a == ((g) r100).f92541a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f92541a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "InterCommentInviteAction(isStarter=" + this.f92541a + ")";
    }

    public g(boolean r100) {
        this.f92541a = r100;
    }
}
