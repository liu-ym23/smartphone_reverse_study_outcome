package com.obric.oui.constraintlayout.core;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class a implements ArrayRow.ArrayRowVariables {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static float f13144l = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayRow f13146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f13147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SolverVariable f13149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f13150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f13151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f13152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13155k;

    static {
    }

    public a(ArrayRow r10, b r11) {
        this.f13145a = 0;
        this.f13148d = 8;
        this.f13149e = null;
        this.f13150f = new int[8];
        this.f13151g = new int[8];
        this.f13152h = new float[8];
        this.f13153i = -1;
        this.f13154j = -1;
        this.f13155k = false;
        this.f13146b = r10;
        this.f13147c = r11;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable r10, float r11, boolean r12) {
        float r13 = f13144l;
        if (r11 > (-r13)) goto L5;
    L7:
        int r14 = this.f13153i;
        if (r14 != (-1)) goto L15;
        this.f13153i = 0;
        this.f13152h[0] = r11;
        this.f13150f[0] = r10.f13129c;
        this.f13151g[0] = -1;
        r10.f13139m++;
        r10.a(this.f13146b);
        this.f13145a++;
        if (this.f13155k == true) goto L81;
        int r15 = this.f13154j + 1;
        this.f13154j = r15;
        int[] r16 = this.f13150f;
        if (r15 < r16.length) goto L82;
        this.f13155k = true;
        this.f13154j = r16.length - 1;
        return;
    L82:
        return;
    L81:
        return;
    L15:
        int r17 = 0;
        int r18 = -1;
    L16:
        if (r14 == (-1)) goto L42;
        if (r17 >= this.f13145a) goto L42;
        int r19 = this.f13150f[r14];
        int r20 = r10.f13129c;
        if (r19 == r20) goto L21;
        if (r19 >= r20) goto L41;
        r18 = r14;
    L41:
        r14 = this.f13151g[r14];
        r17 = r17 + 1;
        goto L16
    L21:
        float[] r21 = this.f13152h;
        float r22 = r21[r14] + r11;
        float r110 = f13144l;
        if (r22 > (-r110)) goto L24;
    L26:
        r21[r14] = r22;
        if (r22 == 0.0f) goto L29;
        return;
    L29:
        if (r14 != this.f13153i) goto L31;
        this.f13153i = this.f13151g[r14];
    L32:
        if (r12 == false) goto L35;
        r10.d(this.f13146b);
    L35:
        if (this.f13155k == false) goto L37;
        this.f13154j = r14;
    L37:
        r10.f13139m--;
        this.f13145a--;
        return;
    L31:
        int[] r111 = this.f13151g;
        r111[r18] = r111[r14];
        goto L32
    L24:
        if (r22 >= r110) goto L26;
        r22 = 0.0f;
    L42:
        int r112 = this.f13154j;
        int r23 = r112 + 1;
        if (this.f13155k == false) goto L48;
        int[] r24 = this.f13150f;
        if (r24[r112] == (-1)) goto L49;
        r112 = r24.length;
    L49:
        int[] r25 = this.f13150f;
        if (r112 >= r25.length) goto L52;
    L60:
        int[] r26 = this.f13150f;
        if (r112 < r26.length) goto L63;
        r112 = r26.length;
        int r27 = this.f13148d * 2;
        this.f13148d = r27;
        this.f13155k = false;
        this.f13154j = r112 - 1;
        this.f13152h = Arrays.copyOf(this.f13152h, r27);
        this.f13150f = Arrays.copyOf(this.f13150f, this.f13148d);
        this.f13151g = Arrays.copyOf(this.f13151g, this.f13148d);
    L63:
        this.f13150f[r112] = r10.f13129c;
        this.f13152h[r112] = r11;
        if (r18 == (-1)) goto L66;
        int[] r113 = this.f13151g;
        r113[r112] = r113[r18];
        r113[r18] = r112;
    L67:
        r10.f13139m++;
        r10.a(this.f13146b);
        this.f13145a++;
        if (this.f13155k == true) goto L70;
        this.f13154j++;
    L70:
        int r28 = this.f13154j;
        int[] r114 = this.f13150f;
        if (r28 < r114.length) goto L84;
        this.f13155k = true;
        this.f13154j = r114.length - 1;
        return;
    L84:
        return;
    L66:
        this.f13151g[r112] = this.f13153i;
        this.f13153i = r112;
        goto L67
    L52:
        if (this.f13145a >= r25.length) goto L60;
        int r29 = 0;
    L54:
        int[] r30 = this.f13150f;
        if (r29 >= r30.length) goto L60;
        if (r30[r29] == (-1)) goto L58;
        r29 = r29 + 1;
        goto L54
    L58:
        r112 = r29;
        goto L60
    L48:
        r112 = r23;
        goto L49
    L5:
        if (r11 >= r13) goto L7;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int r10 = this.f13153i;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L11;
        if (r11 >= this.f13145a) goto L11;
        SolverVariable r12 = this.f13147c.f13159d[this.f13150f[r10]];
        if (r12 == null) goto L10;
        r12.d(this.f13146b);
    L10:
        r10 = this.f13151g[r10];
        r11 = r11 + 1;
    L11:
        this.f13153i = -1;
        this.f13154j = -1;
        this.f13155k = false;
        this.f13145a = 0;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable r10) {
        int r11 = this.f13153i;
        if (r11 != (-1)) goto L5;
        return false;
    L5:
        int r12 = 0;
    L6:
        if (r11 == (-1)) goto L14;
        if (r12 >= this.f13145a) goto L14;
        if (this.f13150f[r11] == r10.f13129c) goto L11;
        r11 = this.f13151g[r11];
        r12 = r12 + 1;
        goto L6
    L11:
        return true;
    L14:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int r10 = this.f13145a;
        System.out.print("{ ");
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        SolverVariable r12 = getVariable(r11);
        if (r12 == null) goto L8;
        System.out.print(r12 + " = " + getVariableValue(r11) + " ");
    L8:
        r11 = r11 + 1;
        goto L3
    L9:
        System.out.println(" }");
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float r10) {
        int r11 = this.f13153i;
        int r12 = 0;
    L4:
        if (r11 == (-1)) goto L8;
        if (r12 >= this.f13145a) goto L11;
        float[] r13 = this.f13152h;
        r13[r11] = r13[r11] / r10;
        r11 = this.f13151g[r11];
        r12 = r12 + 1;
        goto L4
    L11:
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable r10) {
        int r11 = this.f13153i;
        int r12 = 0;
    L4:
        if (r11 == (-1)) goto L12;
        if (r12 >= this.f13145a) goto L17;
        if (this.f13150f[r11] == r10.f13129c) goto L10;
        r11 = this.f13151g[r11];
        r12 = r12 + 1;
        goto L4
    L10:
        return this.f13152h[r11];
    L17:
        return 0.0f;
    L12:
        return 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.f13145a;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int r10) {
        int r11 = this.f13153i;
        int r12 = 0;
    L4:
        if (r11 == (-1)) goto L11;
        if (r12 >= this.f13145a) goto L16;
        if (r12 == r10) goto L9;
        r11 = this.f13151g[r11];
        r12 = r12 + 1;
        goto L4
    L9:
        return this.f13147c.f13159d[this.f13150f[r11]];
    L16:
        return null;
    L11:
        return null;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int r10) {
        int r11 = this.f13153i;
        int r12 = 0;
    L4:
        if (r11 == (-1)) goto L11;
        if (r12 >= this.f13145a) goto L16;
        if (r12 == r10) goto L9;
        r11 = this.f13151g[r11];
        r12 = r12 + 1;
        goto L4
    L9:
        return this.f13152h[r11];
    L16:
        return 0.0f;
    L11:
        return 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable r10) {
        int r11 = this.f13153i;
        if (r11 != (-1)) goto L5;
        return -1;
    L5:
        int r12 = 0;
    L6:
        if (r11 == (-1)) goto L13;
        if (r12 >= this.f13145a) goto L13;
        if (this.f13150f[r11] == r10.f13129c) goto L11;
        r11 = this.f13151g[r11];
        r12 = r12 + 1;
        goto L6
    L11:
        return r11;
    L13:
        return -1;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int r10 = this.f13153i;
        int r11 = 0;
    L4:
        if (r10 == (-1)) goto L8;
        if (r11 >= this.f13145a) goto L11;
        float[] r12 = this.f13152h;
        r12[r10] = r12[r10] * (-1.0f);
        r10 = this.f13151g[r10];
        r11 = r11 + 1;
        goto L4
    L11:
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable r10, float r11) {
        if (r11 != 0.0f) goto L6;
        remove(r10, true);
        return;
    L6:
        int r12 = this.f13153i;
        if (r12 != (-1)) goto L14;
        this.f13153i = 0;
        this.f13152h[0] = r11;
        this.f13150f[0] = r10.f13129c;
        this.f13151g[0] = -1;
        r10.f13139m++;
        r10.a(this.f13146b);
        this.f13145a++;
        if (this.f13155k == true) goto L67;
        int r13 = this.f13154j + 1;
        this.f13154j = r13;
        int[] r14 = this.f13150f;
        if (r13 < r14.length) goto L68;
        this.f13155k = true;
        this.f13154j = r14.length - 1;
        return;
    L68:
        return;
    L67:
        return;
    L14:
        int r15 = 0;
        int r16 = -1;
    L15:
        if (r12 == (-1)) goto L25;
        if (r15 >= this.f13145a) goto L25;
        int r17 = this.f13150f[r12];
        int r18 = r10.f13129c;
        if (r17 == r18) goto L20;
        if (r17 >= r18) goto L24;
        r16 = r12;
    L24:
        r12 = this.f13151g[r12];
        r15 = r15 + 1;
        goto L15
    L20:
        this.f13152h[r12] = r11;
        return;
    L25:
        int r19 = this.f13154j;
        int r20 = r19 + 1;
        if (this.f13155k == false) goto L31;
        int[] r21 = this.f13150f;
        if (r21[r19] == (-1)) goto L32;
        r19 = r21.length;
    L32:
        int[] r22 = this.f13150f;
        if (r19 >= r22.length) goto L35;
    L43:
        int[] r23 = this.f13150f;
        if (r19 < r23.length) goto L46;
        r19 = r23.length;
        int r24 = this.f13148d * 2;
        this.f13148d = r24;
        this.f13155k = false;
        this.f13154j = r19 - 1;
        this.f13152h = Arrays.copyOf(this.f13152h, r24);
        this.f13150f = Arrays.copyOf(this.f13150f, this.f13148d);
        this.f13151g = Arrays.copyOf(this.f13151g, this.f13148d);
    L46:
        this.f13150f[r19] = r10.f13129c;
        this.f13152h[r19] = r11;
        if (r16 == (-1)) goto L49;
        int[] r110 = this.f13151g;
        r110[r19] = r110[r16];
        r110[r16] = r19;
    L50:
        r10.f13139m++;
        r10.a(this.f13146b);
        int r25 = this.f13145a + 1;
        this.f13145a = r25;
        if (this.f13155k == true) goto L53;
        this.f13154j++;
    L53:
        int[] r111 = this.f13150f;
        if (r25 < r111.length) goto L57;
        this.f13155k = true;
    L57:
        if (this.f13154j < r111.length) goto L69;
        this.f13155k = true;
        this.f13154j = r111.length - 1;
        return;
    L69:
        return;
    L49:
        this.f13151g[r19] = this.f13153i;
        this.f13153i = r19;
        goto L50
    L35:
        if (this.f13145a >= r22.length) goto L43;
        int r26 = 0;
    L37:
        int[] r27 = this.f13150f;
        if (r26 >= r27.length) goto L43;
        if (r27[r26] == (-1)) goto L41;
        r26 = r26 + 1;
        goto L37
    L41:
        r19 = r26;
        goto L43
    L31:
        r19 = r20;
        goto L32
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable r10, boolean r11) {
        if (this.f13149e != r10) goto L5;
        this.f13149e = null;
    L5:
        int r12 = this.f13153i;
        if (r12 != (-1)) goto L8;
        return 0.0f;
    L8:
        int r13 = 0;
        int r14 = -1;
    L9:
        if (r12 == (-1)) goto L26;
        if (r13 >= this.f13145a) goto L26;
        if (this.f13150f[r12] == r10.f13129c) goto L15;
        r13 = r13 + 1;
        r14 = r12;
        r12 = this.f13151g[r12];
        goto L9
    L15:
        if (r12 != this.f13153i) goto L17;
        this.f13153i = this.f13151g[r12];
    L18:
        if (r11 == false) goto L20;
        r10.d(this.f13146b);
    L20:
        r10.f13139m--;
        this.f13145a--;
        this.f13150f[r12] = -1;
        if (this.f13155k == false) goto L24;
        this.f13154j = r12;
    L24:
        return this.f13152h[r12];
    L17:
        int[] r15 = this.f13151g;
        r15[r14] = r15[r12];
    L26:
        return 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.f13150f.length * 12) + 36;
    }

    public String toString() {
        int r10 = this.f13153i;
        String r11 = "";
        int r12 = 0;
    L4:
        if (r10 == (-1)) goto L8;
        if (r12 >= this.f13145a) goto L8;
        r11 = ((r11 + " -> ") + this.f13152h[r10] + " : ") + this.f13147c.f13159d[this.f13150f[r10]];
        r10 = this.f13151g[r10];
        r12 = r12 + 1;
    L8:
        return r11;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow r10, boolean r11) {
        float r12 = get(r10.f13095a);
        remove(r10.f13095a, r11);
        ArrayRow.ArrayRowVariables r13 = r10.f13099e;
        int r14 = r13.getCurrentSize();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        SolverVariable r16 = r13.getVariable(r15);
        add(r16, r13.get(r16) * r12, r11);
        r15 = r15 + 1;
        goto L3
    L5:
        return r12;
    }
}
