package androidx.work.impl.model;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5652b;

    public i(String r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "workSpecId");
        this.f5651a = r10;
        this.f5652b = r11;
    }

    public final int a() {
        return this.f5652b;
    }

    public final String b() {
        return this.f5651a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof i) == true) goto L8;
        return false;
    L8:
        i r11 = (i) r10;
        if (kotlin.jvm.internal.q.b(this.f5651a, r11.f5651a) == true) goto L12;
        return false;
    L12:
        if (this.f5652b == r11.f5652b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f5651a.hashCode() * 31) + Integer.hashCode(this.f5652b);
    }

    public String toString() {
        return "WorkGenerationalId(workSpecId=" + this.f5651a + ", generation=" + this.f5652b + ')';
    }
}
