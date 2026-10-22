package androidx.constraintlayout.a;

import java.util.Arrays;

/* JADX INFO: compiled from: ArrayLinkedVariables.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.a {
    private static float l = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final c f595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h f598e;
    private int[] f;
    private int[] g;
    private float[] h;
    private int i;
    private int j;
    private boolean k;

    static {
    }

    a(b r4, c r5) {
        this.f594a = 0;
        this.f597d = 8;
        this.f598e = null;
        this.f = new int[8];
        this.g = new int[8];
        this.h = new float[8];
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f596c = r4;
        this.f595b = r5;
    }

    @Override // androidx.constraintlayout.a.b.a
    public final void a(h r9, float r10) {
        if (r10 != 0.0f) goto L6;
        a(r9, true);
        return;
    L6:
        int r0 = this.i;
        if (r0 != (-1)) goto L14;
        this.i = 0;
        this.h[0] = r10;
        this.f[0] = r9.f807b;
        this.g[this.i] = -1;
        r9.l++;
        r9.a(this.f596c);
        this.f594a++;
        if (this.k == true) goto L68;
        int r11 = this.j + 1;
        this.j = r11;
        int[] r12 = this.f;
        if (r11 < r12.length) goto L69;
        this.k = true;
        this.j = r12.length - 1;
        return;
    L69:
        return;
    L68:
        return;
    L14:
        int r4 = 0;
        int r5 = -1;
    L15:
        if (r0 == (-1)) goto L26;
        if (r4 >= this.f594a) goto L26;
        if (this.f[r0] == r9.f807b) goto L20;
        if (this.f[r0] >= r9.f807b) goto L25;
        r5 = r0;
    L25:
        r0 = this.g[r0];
        r4 = r4 + 1;
        goto L15
    L20:
        this.h[r0] = r10;
        return;
    L26:
        int r1 = this.j;
        int r6 = r1 + 1;
        if (this.k == false) goto L32;
        int[] r7 = this.f;
        if (r7[r1] == (-1)) goto L33;
        r1 = r7.length;
    L33:
        int[] r8 = this.f;
        if (r1 >= r8.length) goto L36;
    L44:
        int[] r13 = this.f;
        if (r1 < r13.length) goto L47;
        r1 = r13.length;
        int r14 = this.f597d * 2;
        this.f597d = r14;
        this.k = false;
        this.j = r1 - 1;
        this.h = Arrays.copyOf(this.h, r14);
        this.f = Arrays.copyOf(this.f, this.f597d);
        this.g = Arrays.copyOf(this.g, this.f597d);
    L47:
        this.f[r1] = r9.f807b;
        this.h[r1] = r10;
        if (r5 == (-1)) goto L50;
        int[] r15 = this.g;
        r15[r1] = r15[r5];
        r15[r5] = r1;
    L51:
        r9.l++;
        r9.a(this.f596c);
        int r16 = this.f594a + 1;
        this.f594a = r16;
        if (this.k == true) goto L54;
        this.j++;
    L54:
        int[] r17 = this.f;
        if (r16 < r17.length) goto L58;
        this.k = true;
    L58:
        if (this.j < r17.length) goto L70;
        this.k = true;
        this.j = r17.length - 1;
        return;
    L70:
        return;
    L50:
        this.g[r1] = this.i;
        this.i = r1;
        goto L51
    L36:
        if (this.f594a >= r8.length) goto L44;
        int r18 = 0;
    L38:
        int[] r19 = this.f;
        if (r18 >= r19.length) goto L44;
        if (r19[r18] == (-1)) goto L42;
        r18 = r18 + 1;
        goto L38
    L42:
        r1 = r18;
        goto L44
    L32:
        r1 = r6;
        goto L33
    }

    @Override // androidx.constraintlayout.a.b.a
    public void a(h r9, float r10, boolean r11) {
        float r0 = l;
        if (r10 > (-r0)) goto L5;
    L7:
        int r1 = this.i;
        if (r1 != (-1)) goto L15;
        this.i = 0;
        this.h[0] = r10;
        this.f[0] = r9.f807b;
        this.g[this.i] = -1;
        r9.l++;
        r9.a(this.f596c);
        this.f594a++;
        if (this.k == true) goto L82;
        int r12 = this.j + 1;
        this.j = r12;
        int[] r13 = this.f;
        if (r12 < r13.length) goto L83;
        this.k = true;
        this.j = r13.length - 1;
        return;
    L83:
        return;
    L82:
        return;
    L15:
        int r4 = 0;
        int r5 = -1;
    L16:
        if (r1 == (-1)) goto L43;
        if (r4 >= this.f594a) goto L43;
        if (this.f[r1] == r9.f807b) goto L21;
        if (this.f[r1] >= r9.f807b) goto L42;
        r5 = r1;
    L42:
        r1 = this.g[r1];
        r4 = r4 + 1;
        goto L16
    L21:
        float[] r2 = this.h;
        float r3 = r2[r1] + r10;
        float r14 = l;
        if (r3 > (-r14)) goto L24;
    L26:
        r2[r1] = r3;
        if (r3 == 0.0f) goto L29;
        return;
    L29:
        if (r1 != this.i) goto L31;
        this.i = this.g[r1];
    L32:
        if (r11 == false) goto L35;
        r9.b(this.f596c);
    L35:
        if (this.k == false) goto L37;
        this.j = r1;
    L37:
        r9.l--;
        this.f594a--;
        return;
    L31:
        int[] r15 = this.g;
        r15[r5] = r15[r1];
        goto L32
    L24:
        if (r3 >= r14) goto L26;
        r3 = 0.0f;
    L43:
        int r16 = this.j;
        int r6 = r16 + 1;
        if (this.k == false) goto L49;
        int[] r7 = this.f;
        if (r7[r16] == (-1)) goto L50;
        r16 = r7.length;
    L50:
        int[] r8 = this.f;
        if (r16 >= r8.length) goto L53;
    L61:
        int[] r17 = this.f;
        if (r16 < r17.length) goto L64;
        r16 = r17.length;
        int r18 = this.f597d * 2;
        this.f597d = r18;
        this.k = false;
        this.j = r16 - 1;
        this.h = Arrays.copyOf(this.h, r18);
        this.f = Arrays.copyOf(this.f, this.f597d);
        this.g = Arrays.copyOf(this.g, this.f597d);
    L64:
        this.f[r16] = r9.f807b;
        this.h[r16] = r10;
        if (r5 == (-1)) goto L67;
        int[] r19 = this.g;
        r19[r16] = r19[r5];
        r19[r5] = r16;
    L68:
        r9.l++;
        r9.a(this.f596c);
        this.f594a++;
        if (this.k == true) goto L71;
        this.j++;
    L71:
        int r20 = this.j;
        int[] r110 = this.f;
        if (r20 < r110.length) goto L85;
        this.k = true;
        this.j = r110.length - 1;
        return;
    L85:
        return;
    L67:
        this.g[r16] = this.i;
        this.i = r16;
        goto L68
    L53:
        if (this.f594a >= r8.length) goto L61;
        int r21 = 0;
    L55:
        int[] r22 = this.f;
        if (r21 >= r22.length) goto L61;
        if (r22[r21] == (-1)) goto L59;
        r21 = r21 + 1;
        goto L55
    L59:
        r16 = r21;
        goto L61
    L49:
        r16 = r6;
        goto L50
    L5:
        if (r10 >= r0) goto L7;
    }

    @Override // androidx.constraintlayout.a.b.a
    public float a(b r6, boolean r7) {
        float r0 = b(r6.f679a);
        a(r6.f679a, r7);
        b.a r8 = r6.f683e;
        int r1 = r8.c();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        h r3 = r8.a(r2);
        a(r3, r8.b(r3) * r0, r7);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    @Override // androidx.constraintlayout.a.b.a
    public final float a(h r9, boolean r10) {
        if (this.f598e != r9) goto L5;
        this.f598e = null;
    L5:
        int r0 = this.i;
        if (r0 != (-1)) goto L8;
        return 0.0f;
    L8:
        int r3 = 0;
        int r4 = -1;
    L9:
        if (r0 == (-1)) goto L26;
        if (r3 >= this.f594a) goto L26;
        if (this.f[r0] == r9.f807b) goto L15;
        r3 = r3 + 1;
        r4 = r0;
        r0 = this.g[r0];
        goto L9
    L15:
        if (r0 != this.i) goto L17;
        this.i = this.g[r0];
    L18:
        if (r10 == false) goto L20;
        r9.b(this.f596c);
    L20:
        r9.l--;
        this.f594a--;
        this.f[r0] = -1;
        if (this.k == false) goto L24;
        this.j = r0;
    L24:
        return this.h[r0];
    L17:
        int[] r1 = this.g;
        r1[r4] = r1[r0];
    L26:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.a.b.a
    public final void a() {
        int r0 = this.i;
        int r2 = 0;
    L4:
        if (r0 == (-1)) goto L11;
        if (r2 >= this.f594a) goto L11;
        h r3 = this.f595b.f692d[this.f[r0]];
        if (r3 == null) goto L10;
        r3.b(this.f596c);
    L10:
        r0 = this.g[r0];
        r2 = r2 + 1;
    L11:
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f594a = 0;
    }

    @Override // androidx.constraintlayout.a.b.a
    public boolean a(h r7) {
        int r0 = this.i;
        if (r0 != (-1)) goto L5;
        return false;
    L5:
        int r3 = 0;
    L6:
        if (r0 == (-1)) goto L14;
        if (r3 >= this.f594a) goto L14;
        if (this.f[r0] == r7.f807b) goto L11;
        r0 = this.g[r0];
        r3 = r3 + 1;
        goto L6
    L11:
        return true;
    L14:
        return false;
    }

    @Override // androidx.constraintlayout.a.b.a
    public void b() {
        int r0 = this.i;
        int r1 = 0;
    L4:
        if (r0 == (-1)) goto L8;
        if (r1 >= this.f594a) goto L11;
        float[] r2 = this.h;
        r2[r0] = r2[r0] * (-1.0f);
        r0 = this.g[r0];
        r1 = r1 + 1;
        goto L4
    L11:
        return;
    }

    @Override // androidx.constraintlayout.a.b.a
    public void a(float r5) {
        int r0 = this.i;
        int r1 = 0;
    L4:
        if (r0 == (-1)) goto L8;
        if (r1 >= this.f594a) goto L11;
        float[] r2 = this.h;
        r2[r0] = r2[r0] / r5;
        r0 = this.g[r0];
        r1 = r1 + 1;
        goto L4
    L11:
        return;
    }

    @Override // androidx.constraintlayout.a.b.a
    public int c() {
        return this.f594a;
    }

    @Override // androidx.constraintlayout.a.b.a
    public h a(int r4) {
        int r0 = this.i;
        int r1 = 0;
    L4:
        if (r0 == (-1)) goto L11;
        if (r1 >= this.f594a) goto L16;
        if (r1 == r4) goto L9;
        r0 = this.g[r0];
        r1 = r1 + 1;
        goto L4
    L9:
        return this.f595b.f692d[this.f[r0]];
    L16:
        return null;
    L11:
        return null;
    }

    @Override // androidx.constraintlayout.a.b.a
    public float b(int r4) {
        int r0 = this.i;
        int r1 = 0;
    L4:
        if (r0 == (-1)) goto L11;
        if (r1 >= this.f594a) goto L16;
        if (r1 == r4) goto L9;
        r0 = this.g[r0];
        r1 = r1 + 1;
        goto L4
    L9:
        return this.h[r0];
    L16:
        return 0.0f;
    L11:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.a.b.a
    public final float b(h r5) {
        int r0 = this.i;
        int r1 = 0;
    L4:
        if (r0 == (-1)) goto L12;
        if (r1 >= this.f594a) goto L17;
        if (this.f[r0] == r5.f807b) goto L10;
        r0 = this.g[r0];
        r1 = r1 + 1;
        goto L4
    L10:
        return this.h[r0];
    L17:
        return 0.0f;
    L12:
        return 0.0f;
    }

    public String toString() {
        int r0 = this.i;
        String r1 = "";
        int r2 = 0;
    L4:
        if (r0 == (-1)) goto L8;
        if (r2 >= this.f594a) goto L8;
        r1 = ((r1 + " -> ") + this.h[r0] + " : ") + this.f595b.f692d[this.f[r0]];
        r0 = this.g[r0];
        r2 = r2 + 1;
    L8:
        return r1;
    }
}
