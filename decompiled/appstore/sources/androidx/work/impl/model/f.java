package androidx.work.impl.model;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5643c;

    public f(String r10, int r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "workSpecId");
        this.f5641a = r10;
        this.f5642b = r11;
        this.f5643c = r12;
    }

    public final int a() {
        return this.f5642b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (kotlin.jvm.internal.q.b(this.f5641a, r11.f5641a) == true) goto L12;
        return false;
    L12:
        if (this.f5642b == r11.f5642b) goto L15;
        return false;
    L15:
        if (this.f5643c == r11.f5643c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f5641a.hashCode() * 31) + Integer.hashCode(this.f5642b)) * 31) + Integer.hashCode(this.f5643c);
    }

    public String toString() {
        return "SystemIdInfo(workSpecId=" + this.f5641a + ", generation=" + this.f5642b + ", systemId=" + this.f5643c + ')';
    }
}
