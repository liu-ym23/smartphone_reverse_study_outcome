package com.obric.appstore.buss.detail;

import com.bytedanceos.common.model.AppInfo;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppInfo f10637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelationApps f10638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ClassicApps f10639c;

    public a(AppInfo r10, RelationApps r11, ClassicApps r12) {
        this.f10637a = r10;
        this.f10638b = r11;
        this.f10639c = r12;
    }

    public final AppInfo a() {
        return this.f10637a;
    }

    public final ClassicApps b() {
        return this.f10639c;
    }

    public final RelationApps c() {
        return this.f10638b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (q.b(this.f10637a, r11.f10637a) == true) goto L12;
        return false;
    L12:
        if (q.b(this.f10638b, r11.f10638b) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f10639c, r11.f10639c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        AppInfo r10 = this.f10637a;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        RelationApps r14 = this.f10638b;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        ClassicApps r17 = this.f10639c;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "AppDetail(appInfo=" + this.f10637a + ", relationApps=" + this.f10638b + ", classicApps=" + this.f10639c + ')';
    }
}
