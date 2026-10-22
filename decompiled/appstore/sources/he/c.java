package he;

import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.AppPermissionActivity;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f20444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f20448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f20449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f20450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f20451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f20452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f20453j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f20454k;

    public c(long r10, String r12, String r13, int r14, String r15, String r16, String r17, long r18, long r20, long r22, String r24) {
        q.g(r12, "appId");
        q.g(r13, "taskId");
        q.g(r15, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r16, "url");
        q.g(r17, ServerElements.MD5);
        q.g(r24, "versionName");
        this.f20444a = r10;
        this.f20445b = r12;
        this.f20446c = r13;
        this.f20447d = r14;
        this.f20448e = r15;
        this.f20449f = r16;
        this.f20450g = r17;
        this.f20451h = r18;
        this.f20452i = r20;
        this.f20453j = r22;
        this.f20454k = r24;
    }

    public final String a() {
        return this.f20445b;
    }

    public final long b() {
        return this.f20444a;
    }

    public final long c() {
        return this.f20452i;
    }

    public final String d() {
        return this.f20450g;
    }

    public final String e() {
        return this.f20448e;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (this.f20444a == r11.f20444a) goto L12;
        return false;
    L12:
        if (q.b(this.f20445b, r11.f20445b) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f20446c, r11.f20446c) == true) goto L18;
        return false;
    L18:
        if (this.f20447d == r11.f20447d) goto L21;
        return false;
    L21:
        if (q.b(this.f20448e, r11.f20448e) == true) goto L24;
        return false;
    L24:
        if (q.b(this.f20449f, r11.f20449f) == true) goto L27;
        return false;
    L27:
        if (q.b(this.f20450g, r11.f20450g) == true) goto L30;
        return false;
    L30:
        if (this.f20451h == r11.f20451h) goto L33;
        return false;
    L33:
        if (this.f20452i == r11.f20452i) goto L36;
        return false;
    L36:
        if (this.f20453j == r11.f20453j) goto L39;
        return false;
    L39:
        if (q.b(this.f20454k, r11.f20454k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final long f() {
        return this.f20451h;
    }

    public final String g() {
        return this.f20446c;
    }

    public final int h() {
        return this.f20447d;
    }

    public int hashCode() {
        return (((((((((((((((((((Long.hashCode(this.f20444a) * 31) + this.f20445b.hashCode()) * 31) + this.f20446c.hashCode()) * 31) + Integer.hashCode(this.f20447d)) * 31) + this.f20448e.hashCode()) * 31) + this.f20449f.hashCode()) * 31) + this.f20450g.hashCode()) * 31) + Long.hashCode(this.f20451h)) * 31) + Long.hashCode(this.f20452i)) * 31) + Long.hashCode(this.f20453j)) * 31) + this.f20454k.hashCode();
    }

    public final String i() {
        return this.f20449f;
    }

    public final long j() {
        return this.f20453j;
    }

    public final String k() {
        return this.f20454k;
    }

    public String toString() {
        return "SysAppAutoUpdateTaskInfo(id=" + this.f20444a + ", appId=" + this.f20445b + ", taskId=" + this.f20446c + ", updateModel=" + this.f20447d + ", pkg=" + this.f20448e + ", url=" + this.f20449f + ", md5=" + this.f20450g + ", size=" + this.f20451h + ", localVersionCode=" + this.f20452i + ", versionCode=" + this.f20453j + ", versionName=" + this.f20454k + ')';
    }
}
