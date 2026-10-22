package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f6665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f6666b;

    public m(Object r10, Object r11) {
        this.f6665a = r10;
        this.f6666b = r11;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof m) == true) goto L5;
        return false;
    L5:
        m r11 = (m) r10;
        if (l.a(r11.f6665a, this.f6665a) == true) goto L8;
        return false;
    L8:
        if (l.a(r11.f6666b, this.f6666b) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Object r10 = this.f6665a;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        Object r13 = this.f6666b;
        if (r13 == null) goto L11;
        r11 = r13.hashCode();
    L11:
        return r12 ^ r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f6665a) + " " + this.f6666b + "}";
    }
}
