package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public class c implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f1209e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f1211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f1212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1213d;

    static {
        f1209e = new Object();
    }

    public c() {
        this(10);
    }

    public void a() {
        int r10 = this.f1213d;
        Object[] r11 = this.f1212c;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11[r12] = null;
        r12 = r12 + 1;
        goto L3
    L5:
        this.f1213d = 0;
        this.f1210a = false;
    }

    public c b() {
        c r10 = (c) super.clone();     // Catch: CloneNotSupportedException -> L4
        r10.f1211b = (long[]) this.f1211b.clone();     // Catch: CloneNotSupportedException -> L4
        r10.f1212c = (Object[]) this.f1212c.clone();     // Catch: CloneNotSupportedException -> L4
        return r10;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public boolean c(long r10) {
        if (g(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    public final void d() {
        int r10 = this.f1213d;
        long[] r11 = this.f1211b;
        Object[] r12 = this.f1212c;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r10) goto L10;
        Object r15 = r12[r13];
        if (r15 == f1209e) goto L9;
        if (r13 == r14) goto L8;
        r11[r14] = r11[r13];
        r12[r14] = r15;
        r12[r13] = null;
    L8:
        r14 = r14 + 1;
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        this.f1210a = false;
        this.f1213d = r14;
    }

    public Object e(long r10) {
        return f(r10, null);
    }

    public Object f(long r10, Object r11) {
        int r12 = b.b(this.f1211b, this.f1213d, r10);
        if (r12 < 0) goto L8;
        Object r13 = this.f1212c[r12];
        if (r13 == f1209e) goto L8;
        return r13;
    L8:
        return r11;
    }

    public int g(long r10) {
        if (this.f1210a == false) goto L6;
        d();
    L6:
        return b.b(this.f1211b, this.f1213d, r10);
    }

    public boolean h() {
        if (m() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long i(int r10) {
        if (this.f1210a == false) goto L6;
        d();
    L6:
        return this.f1211b[r10];
    }

    public void j(long r10, Object r11) {
        int r12 = b.b(this.f1211b, this.f1213d, r10);
        if (r12 < 0) goto L5;
        this.f1212c[r12] = r11;
        return;
    L5:
        int r13 = ~r12;
        int r14 = this.f1213d;
        if (r13 >= r14) goto L12;
        Object[] r15 = this.f1212c;
        if (r15[r13] != f1209e) goto L12;
        this.f1211b[r13] = r10;
        r15[r13] = r11;
        return;
    L12:
        if (this.f1210a == true) goto L14;
    L16:
        int r16 = this.f1213d;
        if (r16 < this.f1211b.length) goto L19;
        int r17 = b.f(r16 + 1);
        long[] r18 = new long[r17];
        Object[] r19 = new Object[r17];
        long[] r20 = this.f1211b;
        System.arraycopy(r20, 0, r18, 0, r20.length);
        Object[] r21 = this.f1212c;
        System.arraycopy(r21, 0, r19, 0, r21.length);
        this.f1211b = r18;
        this.f1212c = r19;
    L19:
        int r22 = this.f1213d;
        if ((r22 - r13) == 0) goto L22;
        long[] r23 = this.f1211b;
        int r24 = r13 + 1;
        System.arraycopy(r23, r13, r23, r24, r22 - r13);
        Object[] r25 = this.f1212c;
        System.arraycopy(r25, r13, r25, r24, this.f1213d - r13);
    L22:
        this.f1211b[r13] = r10;
        this.f1212c[r13] = r11;
        this.f1213d++;
        return;
    L14:
        if (r14 < this.f1211b.length) goto L16;
        d();
        r13 = ~b.b(this.f1211b, this.f1213d, r10);
        goto L16
    }

    public void k(long r10) {
        int r11 = b.b(this.f1211b, this.f1213d, r10);
        if (r11 < 0) goto L8;
        Object[] r12 = this.f1212c;
        Object r13 = r12[r11];
        Object r14 = f1209e;
        if (r13 == r14) goto L9;
        r12[r11] = r14;
        this.f1210a = true;
        return;
    L9:
        return;
    }

    public void l(int r10) {
        Object[] r11 = this.f1212c;
        Object r12 = r11[r10];
        Object r13 = f1209e;
        if (r12 == r13) goto L6;
        r11[r10] = r13;
        this.f1210a = true;
        return;
    }

    public int m() {
        if (this.f1210a == false) goto L6;
        d();
    L6:
        return this.f1213d;
    }

    public Object n(int r10) {
        if (this.f1210a == false) goto L6;
        d();
    L6:
        return this.f1212c[r10];
    }

    public String toString() {
        if (m() > 0) goto L6;
        return "{}";
    L6:
        StringBuilder r10 = new StringBuilder(this.f1213d * 28);
        r10.append('{');
        int r11 = 0;
    L8:
        if (r11 >= this.f1213d) goto L16;
        if (r11 <= 0) goto L11;
        r10.append(", ");
    L11:
        r10.append(i(r11));
        r10.append('=');
        Object r12 = n(r11);
        if (r12 == this) goto L14;
        r10.append(r12);
    L15:
        r11 = r11 + 1;
        goto L8
    L14:
        r10.append("(this Map)");
        goto L15
    L16:
        r10.append('}');
        return r10.toString();
    }

    public c(int r10) {
        this.f1210a = false;
        if (r10 != 0) goto L5;
        this.f1211b = b.f1207b;
        this.f1212c = b.f1208c;
        return;
    L5:
        int r11 = b.f(r10);
        this.f1211b = new long[r11];
        this.f1212c = new Object[r11];
    }
}
