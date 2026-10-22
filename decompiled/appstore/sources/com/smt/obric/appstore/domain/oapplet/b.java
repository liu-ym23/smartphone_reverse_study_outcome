package com.smt.obric.appstore.domain.oapplet;

import com.bytedanceos.common.ui.AppPermissionActivity;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18068a;

    public b(String r10) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        this.f18068a = r10;
    }

    public final String a() {
        return this.f18068a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L9;
        return false;
    L9:
        if (q.b(this.f18068a, ((b) r10).f18068a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f18068a.hashCode();
    }

    public String toString() {
        return "Event(pkg=" + this.f18068a + ')';
    }
}
