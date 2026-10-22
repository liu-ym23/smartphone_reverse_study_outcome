package le;

import com.bytedanceos.common.ui.AppPermissionActivity;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f21957b;

    public c(String r10, long r11) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        this.f21956a = r10;
        this.f21957b = r11;
    }

    public final String a() {
        return this.f21956a;
    }

    public final long b() {
        return this.f21957b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (q.b(this.f21956a, r11.f21956a) == true) goto L12;
        return false;
    L12:
        if (this.f21957b == r11.f21957b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f21956a.hashCode() * 31) + Long.hashCode(this.f21957b);
    }

    public String toString() {
        return "PkgInfo(pkg=" + this.f21956a + ", versionCode=" + this.f21957b + ')';
    }
}
