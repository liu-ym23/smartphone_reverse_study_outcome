package xd;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f25871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f25872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f25873d;

    public c(String r10, b r11, d r12, e r13) {
        q.g(r10, "gridMode");
        q.g(r11, "pageColumns");
        q.g(r12, "pageGutter");
        q.g(r13, "pageMargin");
        this.f25870a = r10;
        this.f25871b = r11;
        this.f25872c = r12;
        this.f25873d = r13;
    }

    public final String a() {
        return this.f25870a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (q.b(this.f25870a, r11.f25870a) == true) goto L12;
        return false;
    L12:
        if (q.b(this.f25871b, r11.f25871b) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f25872c, r11.f25872c) == true) goto L18;
        return false;
    L18:
        if (q.b(this.f25873d, r11.f25873d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f25870a.hashCode() * 31) + this.f25871b.hashCode()) * 31) + this.f25872c.hashCode()) * 31) + this.f25873d.hashCode();
    }

    public String toString() {
        return "PageGridConfig(gridMode=" + this.f25870a + ", pageColumns=" + this.f25871b + ", pageGutter=" + this.f25872c + ", pageMargin=" + this.f25873d + ')';
    }
}
