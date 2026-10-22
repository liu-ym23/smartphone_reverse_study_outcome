package androidx.navigation;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f3830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3833d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f3834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f3836c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3837d;

        public a() {
        }

        public final c a() {
            n r10 = this.f3834a;
            if (r10 != null) goto L6;
            r10 = n.f3897c.c(this.f3836c);
        L6:
            return new c(r10, this.f3835b, this.f3836c, this.f3837d);
        }

        public final a b(Object r10) {
            this.f3836c = r10;
            this.f3837d = true;
            return this;
        }

        public final a c(boolean r10) {
            this.f3835b = r10;
            return this;
        }

        public final a d(n r10) {
            kotlin.jvm.internal.q.g(r10, "type");
            this.f3834a = r10;
            return this;
        }
    }

    public c(n r10, boolean r11, Object r12, boolean r13) {
        kotlin.jvm.internal.q.g(r10, "type");
        if (r10.c() == true) goto L8;
        if (r11 == false) goto L8;
        throw new IllegalArgumentException((r10.b() + " does not allow nullable values").toString());
    L8:
        if (r11 == true) goto L14;
        if (r13 == false) goto L14;
        if (r12 != null) goto L14;
        throw new IllegalArgumentException(("Argument with type " + r10.b() + " has null value but is not nullable.").toString());
    L14:
        this.f3830a = r10;
        this.f3831b = r11;
        this.f3833d = r12;
        this.f3832c = r13;
    }

    public final n a() {
        return this.f3830a;
    }

    public final boolean b() {
        return this.f3832c;
    }

    public final boolean c() {
        return this.f3831b;
    }

    public final void d(String r10, Bundle r11) {
        kotlin.jvm.internal.q.g(r10, "name");
        kotlin.jvm.internal.q.g(r11, "bundle");
        if (this.f3832c == false) goto L6;
        this.f3830a.f(r11, r10, this.f3833d);
        return;
    }

    public final boolean e(String r10, Bundle r11) {
        kotlin.jvm.internal.q.g(r10, "name");
        kotlin.jvm.internal.q.g(r11, "bundle");
        if (this.f3831b == false) goto L5;
    L13:
        this.f3830a.a(r11, r10);     // Catch: ClassCastException -> L12
        return true;
    L12:
        return false;
    L5:
        if (r11.containsKey(r10) == false) goto L13;
        if (r11.get(r10) != null) goto L13;
        return false;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L27:
        return false;
    L8:
        if (kotlin.jvm.internal.q.b(c.class, r10.getClass()) == false) goto L27;
        c r11 = (c) r10;
        if (this.f3831b == r11.f3831b) goto L14;
        return false;
    L14:
        if (this.f3832c == r11.f3832c) goto L17;
        return false;
    L17:
        if (kotlin.jvm.internal.q.b(this.f3830a, r11.f3830a) == true) goto L19;
        return false;
    L19:
        Object r12 = this.f3833d;
        if (r12 == null) goto L23;
        return kotlin.jvm.internal.q.b(r12, r11.f3833d);
    L23:
        if (r11.f3833d != null) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r10 = ((((this.f3830a.hashCode() * 31) + (this.f3831b ? 1 : 0)) * 31) + (this.f3832c ? 1 : 0)) * 31;
        Object r11 = this.f3833d;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L7:
        return r10 + r12;
    L5:
        r12 = 0;
        goto L7
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(c.class.getSimpleName());
        r10.append(" Type: " + this.f3830a);
        r10.append(" Nullable: " + this.f3831b);
        if (this.f3832c == false) goto L5;
        r10.append(" DefaultValue: " + this.f3833d);
    L5:
        String r11 = r10.toString();
        kotlin.jvm.internal.q.f(r11, "sb.toString()");
        return r11;
    }
}
