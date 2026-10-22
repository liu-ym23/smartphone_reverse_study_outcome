package kotlin.collections;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f21092b;

    public f0(int r10, Object r11) {
        this.f21091a = r10;
        this.f21092b = r11;
    }

    public final int a() {
        return this.f21091a;
    }

    public final Object b() {
        return this.f21092b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r11 = (f0) r10;
        if (this.f21091a == r11.f21091a) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.f21092b, r11.f21092b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r10 = Integer.hashCode(this.f21091a) * 31;
        Object r11 = this.f21092b;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        return "IndexedValue(index=" + this.f21091a + ", value=" + this.f21092b + ')';
    }
}
