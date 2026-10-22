package androidx.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SparseArrayCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class h<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f559a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f563e;

    public /* synthetic */ Object clone() {
        return a();
    }

    static {
        f559a = new Object();
    }

    public h() {
        this(10);
    }

    public h(int r2) {
        this.f560b = false;
        if (r2 != 0) goto L5;
        this.f561c = c.f527a;
        this.f562d = c.f529c;
        return;
    L5:
        int r3 = c.a(r2);
        this.f561c = new int[r3];
        this.f562d = new Object[r3];
    }

    public h<E> a() {
        h<E> r1 = (h) ZeusTransformUtils.preCheckCast(super.clone(), h.class, "com.obric.aiagent.plugin");     // Catch: CloneNotSupportedException -> L5
        r1.f561c = (int[]) ZeusTransformUtils.preCheckCast(this.f561c.clone(), int[].class, "com.obric.aiagent.plugin");     // Catch: CloneNotSupportedException -> L5
        r1.f562d = (Object[]) ZeusTransformUtils.preCheckCast(this.f562d.clone(), Object[].class, "com.obric.aiagent.plugin");     // Catch: CloneNotSupportedException -> L5
        return r1;
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    public E a(int r2) {
        return a(r2, null);
    }

    public E a(int r3, E r4) {
        int r5 = c.a(this.f561c, this.f563e, r3);
        if (r5 < 0) goto L9;
        Object[] r2 = this.f562d;
        if (r2[r5] == f559a) goto L9;
        return (E) r2[r5];
    L9:
        return r4;
    }

    @Deprecated
    public void delete(int r1) {
        b(r1);
    }

    public void b(int r4) {
        int r5 = c.a(this.f561c, this.f563e, r4);
        if (r5 < 0) goto L8;
        Object[] r0 = this.f562d;
        Object r1 = r0[r5];
        Object r2 = f559a;
        if (r1 == r2) goto L9;
        r0[r5] = r2;
        this.f560b = true;
        return;
    L9:
        return;
    }

    private void d() {
        int r0 = this.f563e;
        int[] r1 = this.f561c;
        Object[] r2 = this.f562d;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r0) goto L10;
        Object r6 = r2[r4];
        if (r6 == f559a) goto L9;
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
        this.f560b = false;
        this.f563e = r5;
    }

    public void b(int r7, E r8) {
        int r0 = c.a(this.f561c, this.f563e, r7);
        if (r0 < 0) goto L5;
        this.f562d[r0] = r8;
        return;
    L5:
        int r1 = ~r0;
        int r2 = this.f563e;
        if (r1 >= r2) goto L12;
        Object[] r3 = this.f562d;
        if (r3[r1] != f559a) goto L12;
        this.f561c[r1] = r7;
        r3[r1] = r8;
        return;
    L12:
        if (this.f560b == true) goto L14;
    L16:
        int r4 = this.f563e;
        if (r4 < this.f561c.length) goto L19;
        int r5 = c.a(r4 + 1);
        int[] r6 = new int[r5];
        Object[] r9 = new Object[r5];
        int[] r10 = this.f561c;
        System.arraycopy(r10, 0, r6, 0, r10.length);
        Object[] r11 = this.f562d;
        System.arraycopy(r11, 0, r9, 0, r11.length);
        this.f561c = r6;
        this.f562d = r9;
    L19:
        int r12 = this.f563e;
        if ((r12 - r1) == 0) goto L22;
        int[] r13 = this.f561c;
        int r14 = r1 + 1;
        System.arraycopy(r13, r1, r13, r14, r12 - r1);
        Object[] r15 = this.f562d;
        System.arraycopy(r15, r1, r15, r14, this.f563e - r1);
    L22:
        this.f561c[r1] = r7;
        this.f562d[r1] = r8;
        this.f563e++;
        return;
    L14:
        if (r2 < this.f561c.length) goto L16;
        d();
        r1 = ~c.a(this.f561c, this.f563e, r7);
        goto L16
    }

    public int b() {
        if (this.f560b == false) goto L6;
        d();
    L6:
        return this.f563e;
    }

    public int c(int r2) {
        if (this.f560b == false) goto L6;
        d();
    L6:
        return this.f561c[r2];
    }

    public E d(int r2) {
        if (this.f560b == false) goto L6;
        d();
    L6:
        return (E) this.f562d[r2];
    }

    public int a(E r3) {
        if (this.f560b == false) goto L5;
        d();
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.f563e) goto L12;
        if (this.f562d[r0] == r3) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return r0;
    L12:
        return -1;
    }

    public void c() {
        int r0 = this.f563e;
        Object[] r1 = this.f562d;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = null;
        r3 = r3 + 1;
        goto L3
    L5:
        this.f563e = 0;
        this.f560b = false;
    }

    public void c(int r7, E r8) {
        int r0 = this.f563e;
        if (r0 == 0) goto L9;
        if (r7 > this.f561c[r0 - 1]) goto L9;
        b(r7, r8);
        return;
    L9:
        if (this.f560b == true) goto L11;
    L13:
        int r1 = this.f563e;
        if (r1 < this.f561c.length) goto L16;
        int r2 = c.a(r1 + 1);
        int[] r3 = new int[r2];
        Object[] r4 = new Object[r2];
        int[] r5 = this.f561c;
        System.arraycopy(r5, 0, r3, 0, r5.length);
        Object[] r6 = this.f562d;
        System.arraycopy(r6, 0, r4, 0, r6.length);
        this.f561c = r3;
        this.f562d = r4;
    L16:
        this.f561c[r1] = r7;
        this.f562d[r1] = r8;
        this.f563e = r1 + 1;
        return;
    L11:
        if (r0 < this.f561c.length) goto L13;
        d();
        goto L13
    }

    public String toString() {
        if (b() > 0) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder(this.f563e * 28);
        r0.append('{');
        int r1 = 0;
    L8:
        if (r1 >= this.f563e) goto L16;
        if (r1 <= 0) goto L11;
        r0.append(", ");
    L11:
        r0.append(c(r1));
        r0.append('=');
        E r2 = d(r1);
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
