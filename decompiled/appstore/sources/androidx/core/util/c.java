package androidx.core.util;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2647b;

    public c(Object r10, Object r11) {
        this.f2646a = r10;
        this.f2647b = r11;
    }

    public static c a(Object r10, Object r11) {
        return new c(r10, r11);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof c) == true) goto L5;
        return false;
    L5:
        c r11 = (c) r10;
        if (b.a(r11.f2646a, this.f2646a) == true) goto L8;
        return false;
    L8:
        if (b.a(r11.f2647b, this.f2647b) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Object r10 = this.f2646a;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        Object r13 = this.f2647b;
        if (r13 == null) goto L11;
        r11 = r13.hashCode();
    L11:
        return r12 ^ r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "Pair{" + this.f2646a + " " + this.f2647b + "}";
    }
}
