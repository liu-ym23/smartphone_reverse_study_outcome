package he;

import com.bytedanceos.common.ui.AppPermissionActivity;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f20441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppStatus f20442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.smt.obric.appstore.domain.app.entity.a f20443e;

    public b(String r10, String r11, Long r12, AppStatus r13, com.smt.obric.appstore.domain.app.entity.a r14) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r13, "status");
        this.f20439a = r10;
        this.f20440b = r11;
        this.f20441c = r12;
        this.f20442d = r13;
        this.f20443e = r14;
    }

    public final com.smt.obric.appstore.domain.app.entity.a a() {
        return this.f20443e;
    }

    public final String b() {
        return this.f20439a;
    }

    public final AppStatus c() {
        return this.f20442d;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (q.b(this.f20439a, r11.f20439a) == true) goto L12;
        return false;
    L12:
        if (q.b(this.f20440b, r11.f20440b) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f20441c, r11.f20441c) == true) goto L18;
        return false;
    L18:
        if (q.b(this.f20442d, r11.f20442d) == true) goto L21;
        return false;
    L21:
        if (q.b(this.f20443e, r11.f20443e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r10 = this.f20439a.hashCode() * 31;
        String r11 = this.f20440b;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        Long r15 = this.f20441c;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (((r14 + r16) * 31) + this.f20442d.hashCode()) * 31;
        com.smt.obric.appstore.domain.app.entity.a r18 = this.f20443e;
        if (r18 == null) goto L15;
        r12 = r18.hashCode();
    L15:
        return r17 + r12;
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public String toString() {
        return "AppStatusEntity(pkg=" + this.f20439a + ", name=" + this.f20440b + ", versionCode=" + this.f20441c + ", status=" + this.f20442d + ", installTask=" + this.f20443e + ')';
    }
}
