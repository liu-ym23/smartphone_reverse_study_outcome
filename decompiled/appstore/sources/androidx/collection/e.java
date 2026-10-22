package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public class e implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f1222e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f1224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f1225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1226d;

    static {
        f1222e = new Object();
    }

    public e() {
        this(10);
    }

    public void a(int r10, Object r11) {
        int r12 = this.f1226d;
        if (r12 == 0) goto L9;
        if (r10 > this.f1224b[r12 - 1]) goto L9;
        k(r10, r11);
        return;
    L9:
        if (this.f1223a == true) goto L11;
    L13:
        int r13 = this.f1226d;
        if (r13 < this.f1224b.length) goto L16;
        int r14 = b.e(r13 + 1);
        int[] r15 = new int[r14];
        Object[] r16 = new Object[r14];
        int[] r17 = this.f1224b;
        System.arraycopy(r17, 0, r15, 0, r17.length);
        Object[] r18 = this.f1225c;
        System.arraycopy(r18, 0, r16, 0, r18.length);
        this.f1224b = r15;
        this.f1225c = r16;
    L16:
        this.f1224b[r13] = r10;
        this.f1225c[r13] = r11;
        this.f1226d = r13 + 1;
        return;
    L11:
        if (r12 < this.f1224b.length) goto L13;
        e();
        goto L13
    }

    public void b() {
        int r10 = this.f1226d;
        Object[] r11 = this.f1225c;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11[r12] = null;
        r12 = r12 + 1;
        goto L3
    L5:
        this.f1226d = 0;
        this.f1223a = false;
    }

    public e c() {
        e r10 = (e) super.clone();     // Catch: CloneNotSupportedException -> L4
        r10.f1224b = (int[]) this.f1224b.clone();     // Catch: CloneNotSupportedException -> L4
        r10.f1225c = (Object[]) this.f1225c.clone();     // Catch: CloneNotSupportedException -> L4
        return r10;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return c();
    }

    public boolean d(Object r10) {
        if (i(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e() {
        int r10 = this.f1226d;
        int[] r11 = this.f1224b;
        Object[] r12 = this.f1225c;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r10) goto L10;
        Object r15 = r12[r13];
        if (r15 == f1222e) goto L9;
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
        this.f1223a = false;
        this.f1226d = r14;
    }

    public Object f(int r10) {
        return g(r10, null);
    }

    public Object g(int r10, Object r11) {
        int r12 = b.a(this.f1224b, this.f1226d, r10);
        if (r12 < 0) goto L8;
        Object r13 = this.f1225c[r12];
        if (r13 == f1222e) goto L8;
        return r13;
    L8:
        return r11;
    }

    public int h(int r10) {
        if (this.f1223a == false) goto L6;
        e();
    L6:
        return b.a(this.f1224b, this.f1226d, r10);
    }

    public int i(Object r10) {
        if (this.f1223a == false) goto L5;
        e();
    L5:
        int r11 = 0;
    L7:
        if (r11 >= this.f1226d) goto L12;
        if (this.f1225c[r11] == r10) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        return r11;
    L12:
        return -1;
    }

    public int j(int r10) {
        if (this.f1223a == false) goto L6;
        e();
    L6:
        return this.f1224b[r10];
    }

    public void k(int r10, Object r11) {
        int r12 = b.a(this.f1224b, this.f1226d, r10);
        if (r12 < 0) goto L5;
        this.f1225c[r12] = r11;
        return;
    L5:
        int r13 = ~r12;
        int r14 = this.f1226d;
        if (r13 >= r14) goto L12;
        Object[] r15 = this.f1225c;
        if (r15[r13] != f1222e) goto L12;
        this.f1224b[r13] = r10;
        r15[r13] = r11;
        return;
    L12:
        if (this.f1223a == true) goto L14;
    L16:
        int r16 = this.f1226d;
        if (r16 < this.f1224b.length) goto L19;
        int r17 = b.e(r16 + 1);
        int[] r18 = new int[r17];
        Object[] r19 = new Object[r17];
        int[] r20 = this.f1224b;
        System.arraycopy(r20, 0, r18, 0, r20.length);
        Object[] r21 = this.f1225c;
        System.arraycopy(r21, 0, r19, 0, r21.length);
        this.f1224b = r18;
        this.f1225c = r19;
    L19:
        int r22 = this.f1226d;
        if ((r22 - r13) == 0) goto L22;
        int[] r23 = this.f1224b;
        int r24 = r13 + 1;
        System.arraycopy(r23, r13, r23, r24, r22 - r13);
        Object[] r25 = this.f1225c;
        System.arraycopy(r25, r13, r25, r24, this.f1226d - r13);
    L22:
        this.f1224b[r13] = r10;
        this.f1225c[r13] = r11;
        this.f1226d++;
        return;
    L14:
        if (r14 < this.f1224b.length) goto L16;
        e();
        r13 = ~b.a(this.f1224b, this.f1226d, r10);
        goto L16
    }

    public void l(int r10) {
        Object[] r11 = this.f1225c;
        Object r12 = r11[r10];
        Object r13 = f1222e;
        if (r12 == r13) goto L6;
        r11[r10] = r13;
        this.f1223a = true;
        return;
    }

    public Object m(int r10, Object r11) {
        int r12 = h(r10);
        if (r12 < 0) goto L6;
        Object[] r13 = this.f1225c;
        Object r14 = r13[r12];
        r13[r12] = r11;
        return r14;
    L6:
        return null;
    }

    public int n() {
        if (this.f1223a == false) goto L6;
        e();
    L6:
        return this.f1226d;
    }

    public Object o(int r10) {
        if (this.f1223a == false) goto L6;
        e();
    L6:
        return this.f1225c[r10];
    }

    public String toString() {
        if (n() > 0) goto L6;
        return "{}";
    L6:
        StringBuilder r10 = new StringBuilder(this.f1226d * 28);
        r10.append('{');
        int r11 = 0;
    L8:
        if (r11 >= this.f1226d) goto L16;
        if (r11 <= 0) goto L11;
        r10.append(", ");
    L11:
        r10.append(j(r11));
        r10.append('=');
        Object r12 = o(r11);
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

    public e(int r10) {
        this.f1223a = false;
        if (r10 != 0) goto L5;
        this.f1224b = b.f1206a;
        this.f1225c = b.f1208c;
        return;
    L5:
        int r11 = b.e(r10);
        this.f1224b = new int[r11];
        this.f1225c = new Object[r11];
    }
}
