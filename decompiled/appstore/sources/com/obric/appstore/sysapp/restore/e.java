package com.obric.appstore.sysapp.restore;

import com.bytedanceos.common.model.AppInfo;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppInfo f11010a;

    public e(AppInfo r10) {
        q.g(r10, "appInfo");
        this.f11010a = r10;
    }

    public final AppInfo a() {
        return this.f11010a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L9;
        return false;
    L9:
        if (q.b(this.f11010a, ((e) r10).f11010a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f11010a.hashCode();
    }

    public String toString() {
        return "SysAppRestoreItem(appInfo=" + this.f11010a + ')';
    }
}
