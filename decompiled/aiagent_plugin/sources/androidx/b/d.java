package androidx.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LongSparseArray.java */
/* JADX INFO: loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f534e;

    public /* synthetic */ Object clone() {
        return a();
    }

    static {
        f530a = new Object();
    }

    public d() {
        this(10);
    }

    public d(int r2) {
        this.f531b = false;
        if (r2 != 0) goto L5;
        this.f532c = c.f528b;
        this.f533d = c.f529c;
        return;
    L5:
        int r3 = c.b(r2);
        this.f532c = new long[r3];
        this.f533d = new Object[r3];
    }

    public d<E> a() {
        d<E> r1 = (d) ZeusTransformUtils.preCheckCast(super.clone(), d.class, "com.obric.aiagent.plugin");     // Catch: CloneNotSupportedException -> L5
        r1.f532c = (long[]) ZeusTransformUtils.preCheckCast(this.f532c.clone(), long[].class, "com.obric.aiagent.plugin");     // Catch: CloneNotSupportedException -> L5
        r1.f533d = (Object[]) ZeusTransformUtils.preCheckCast(this.f533d.clone(), Object[].class, "com.obric.aiagent.plugin");     // Catch: CloneNotSupportedException -> L5
        return r1;
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    public E a(long r2) {
        return a(r2, null);
    }

    public E a(long r3, E r5) {
        int r4 = c.a(this.f532c, this.f534e, r3);
        if (r4 < 0) goto L9;
        Object[] r2 = this.f533d;
        if (r2[r4] == f530a) goto L9;
        return (E) r2[r4];
    L9:
        return r5;
    }

    @Deprecated
    public void delete(long r1) {
        b(r1);
    }

    public void b(long r3) {
        int r4 = c.a(this.f532c, this.f534e, r3);
        if (r4 < 0) goto L8;
        Object[] r5 = this.f533d;
        Object r0 = r5[r4];
        Object r1 = f530a;
        if (r0 == r1) goto L9;
        r5[r4] = r1;
        this.f531b = true;
        return;
    L9:
        return;
    }

    public void a(int r4) {
        Object[] r0 = this.f533d;
        Object r1 = r0[r4];
        Object r2 = f530a;
        if (r1 == r2) goto L6;
        r0[r4] = r2;
        this.f531b = true;
        return;
    }

    private void e() {
        int r0 = this.f534e;
        long[] r1 = this.f532c;
        Object[] r2 = this.f533d;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r0) goto L10;
        Object r6 = r2[r4];
        if (r6 == f530a) goto L9;
        if (r4 == r5) goto L8;
        r1[r5] = r1[r4];
        r2[r5] = r6;
        r2[r4] = null;
    L8:
        r5 = r5 + 1;
    L9:
        r4 = r4 + 1;
        goto L3
    L10:
        this.f531b = false;
        this.f534e = r5;
    }

    public void b(long r7, E r9) {
        int r0 = c.a(this.f532c, this.f534e, r7);
        if (r0 < 0) goto L5;
        this.f533d[r0] = r9;
        return;
    L5:
        int r1 = ~r0;
        int r2 = this.f534e;
        if (r1 >= r2) goto L12;
        Object[] r3 = this.f533d;
        if (r3[r1] != f530a) goto L12;
        this.f532c[r1] = r7;
        r3[r1] = r9;
        return;
    L12:
        if (this.f531b == true) goto L14;
    L16:
        int r4 = this.f534e;
        if (r4 < this.f532c.length) goto L19;
        int r5 = c.b(r4 + 1);
        long[] r6 = new long[r5];
        Object[] r8 = new Object[r5];
        long[] r10 = this.f532c;
        System.arraycopy(r10, 0, r6, 0, r10.length);
        Object[] r11 = this.f533d;
        System.arraycopy(r11, 0, r8, 0, r11.length);
        this.f532c = r6;
        this.f533d = r8;
    L19:
        int r12 = this.f534e;
        if ((r12 - r1) == 0) goto L22;
        long[] r13 = this.f532c;
        int r14 = r1 + 1;
        System.arraycopy(r13, r1, r13, r14, r12 - r1);
        Object[] r15 = this.f533d;
        System.arraycopy(r15, r1, r15, r14, this.f534e - r1);
    L22:
        this.f532c[r1] = r7;
        this.f533d[r1] = r9;
        this.f534e++;
        return;
    L14:
        if (r2 < this.f532c.length) goto L16;
        e();
        r1 = ~c.a(this.f532c, this.f534e, r7);
        goto L16
    }

    public int b() {
        if (this.f531b == false) goto L6;
        e();
    L6:
        return this.f534e;
    }

    public boolean c() {
        if (b() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long b(int r2) {
        if (this.f531b == false) goto L6;
        e();
    L6:
        return this.f532c[r2];
    }

    public E c(int r2) {
        if (this.f531b == false) goto L6;
        e();
    L6:
        return (E) this.f533d[r2];
    }

    public int c(long r2) {
        if (this.f531b == false) goto L6;
        e();
    L6:
        return c.a(this.f532c, this.f534e, r2);
    }

    public boolean d(long r1) {
        if (c(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void d() {
        int r0 = this.f534e;
        Object[] r1 = this.f533d;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = null;
        r3 = r3 + 1;
        goto L3
    L5:
        this.f534e = 0;
        this.f531b = false;
    }

    public void c(long r7, E r9) {
        int r0 = this.f534e;
        if (r0 == 0) goto L9;
        if (r7 > this.f532c[r0 - 1]) goto L9;
        b(r7, r9);
        return;
    L9:
        if (this.f531b == true) goto L11;
    L13:
        int r1 = this.f534e;
        if (r1 < this.f532c.length) goto L16;
        int r2 = c.b(r1 + 1);
        long[] r3 = new long[r2];
        Object[] r4 = new Object[r2];
        long[] r5 = this.f532c;
        System.arraycopy(r5, 0, r3, 0, r5.length);
        Object[] r6 = this.f533d;
        System.arraycopy(r6, 0, r4, 0, r6.length);
        this.f532c = r3;
        this.f533d = r4;
    L16:
        this.f532c[r1] = r7;
        this.f533d[r1] = r9;
        this.f534e = r1 + 1;
        return;
    L11:
        if (r0 < this.f532c.length) goto L13;
        e();
        goto L13
    }

    public String toString() {
        if (b() > 0) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder(this.f534e * 28);
        r0.append('{');
        int r1 = 0;
    L8:
        if (r1 >= this.f534e) goto L16;
        if (r1 <= 0) goto L11;
        r0.append(", ");
    L11:
        r0.append(b(r1));
        r0.append('=');
        E r2 = c(r1);
        if (r2 == this) goto L14;
        r0.append(r2);
    L15:
        r1 = r1 + 1;
        goto L8
    L14:
        r0.append("(this Map)");
        goto L15
    L16:
        r0.append('}');
        return r0.toString();
    }
}
