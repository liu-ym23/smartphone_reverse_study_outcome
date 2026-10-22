package androidx.constraintlayout.core;

import io.reactivex.annotations.SchedulerSupport;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class e implements ArrayRow.ArrayRowVariables {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static float f1358n = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f1362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f1363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f1364f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f1365g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f1366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f1367i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1368j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1369k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayRow f1370l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f1371m;

    static {
    }

    public e(ArrayRow r10, b r11) {
        this.f1359a = -1;
        this.f1360b = 16;
        this.f1361c = 16;
        this.f1362d = new int[16];
        this.f1363e = new int[16];
        this.f1364f = new int[16];
        this.f1365g = new float[16];
        this.f1366h = new int[16];
        this.f1367i = new int[16];
        this.f1368j = 0;
        this.f1369k = -1;
        this.f1370l = r10;
        this.f1371m = r11;
        clear();
    }

    public final void a(SolverVariable r10, int r11) {
        int r12 = r10.f1315c % this.f1361c;
        int[] r13 = this.f1362d;
        int r14 = r13[r12];
        if (r14 != (-1)) goto L5;
        r13[r12] = r11;
    L9:
        this.f1363e[r11] = -1;
        return;
    L5:
        int[] r15 = this.f1363e;
        int r16 = r15[r14];
        if (r16 == (-1)) goto L8;
        r14 = r16;
        goto L5
    L8:
        r15[r14] = r11;
        goto L9
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable r10, float r11, boolean r12) {
        float r13 = f1358n;
        if (r11 > (-r13)) goto L5;
    L7:
        int r14 = indexOf(r10);
        if (r14 != (-1)) goto L10;
        put(r10, r11);
        return;
    L10:
        float[] r15 = this.f1365g;
        float r16 = r15[r14] + r11;
        r15[r14] = r16;
        float r17 = f1358n;
        if (r16 > (-r17)) goto L13;
        return;
    L13:
        if (r16 >= r17) goto L18;
        r15[r14] = 0.0f;
        remove(r10, r12);
        return;
    L18:
        return;
    L5:
        if (r11 >= r13) goto L7;
    }

    public final void b(int r10, SolverVariable r11, float r12) {
        this.f1364f[r10] = r11.f1315c;
        this.f1365g[r10] = r12;
        this.f1366h[r10] = -1;
        this.f1367i[r10] = -1;
        r11.a(this.f1370l);
        r11.f1325m++;
        this.f1368j++;
    }

    public final int c() {
        int r10 = 0;
    L4:
        if (r10 >= this.f1360b) goto L9;
        if (this.f1364f[r10] == (-1)) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return r10;
    L9:
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int r10 = this.f1368j;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        SolverVariable r12 = getVariable(r11);
        if (r12 == null) goto L7;
        r12.d(this.f1370l);
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        int r13 = 0;
    L10:
        if (r13 >= this.f1360b) goto L12;
        this.f1364f[r13] = -1;
        this.f1363e[r13] = -1;
        r13 = r13 + 1;
        goto L10
    L12:
        int r14 = 0;
    L14:
        if (r14 >= this.f1361c) goto L16;
        this.f1362d[r14] = -1;
        r14 = r14 + 1;
        goto L14
    L16:
        this.f1368j = 0;
        this.f1369k = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable r10) {
        if (indexOf(r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d() {
        int r10 = this.f1360b * 2;
        this.f1364f = Arrays.copyOf(this.f1364f, r10);
        this.f1365g = Arrays.copyOf(this.f1365g, r10);
        this.f1366h = Arrays.copyOf(this.f1366h, r10);
        this.f1367i = Arrays.copyOf(this.f1367i, r10);
        this.f1363e = Arrays.copyOf(this.f1363e, r10);
        int r11 = this.f1360b;
    L3:
        if (r11 >= r10) goto L5;
        this.f1364f[r11] = -1;
        this.f1363e[r11] = -1;
        r11 = r11 + 1;
        goto L3
    L5:
        this.f1360b = r10;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int r10 = this.f1368j;
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

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float r10) {
        int r11 = this.f1368j;
        int r12 = this.f1369k;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L8;
        float[] r14 = this.f1365g;
        r14[r12] = r14[r12] / r10;
        r12 = this.f1367i[r12];
        if (r12 == (-1)) goto L11;
        r13 = r13 + 1;
        goto L3
    L11:
        return;
    }

    public final void e(int r10, SolverVariable r11, float r12) {
        int r13 = c();
        b(r13, r11, r12);
        if (r10 == (-1)) goto L5;
        this.f1366h[r13] = r10;
        int[] r14 = this.f1367i;
        r14[r13] = r14[r10];
        r14[r10] = r13;
    L9:
        int r15 = this.f1367i[r13];
        if (r15 == (-1)) goto L12;
        this.f1366h[r15] = r13;
    L12:
        a(r11, r13);
        return;
    L5:
        this.f1366h[r13] = -1;
        if (this.f1368j <= 0) goto L8;
        this.f1367i[r13] = this.f1369k;
        this.f1369k = r13;
        goto L9
    L8:
        this.f1367i[r13] = -1;
        goto L9
    }

    public final void f(SolverVariable r10) {
        int r11 = r10.f1315c;
        int r12 = r11 % this.f1361c;
        int[] r13 = this.f1362d;
        int r14 = r13[r12];
        if (r14 != (-1)) goto L6;
        return;
    L6:
        if (this.f1364f[r14] != r11) goto L8;
        int[] r15 = this.f1363e;
        r13[r12] = r15[r14];
        r15[r14] = -1;
        return;
    L8:
        int[] r16 = this.f1363e;
        int r17 = r16[r14];
        if (r17 == (-1)) goto L13;
        if (this.f1364f[r17] == r11) goto L13;
        r14 = r17;
    L13:
        if (r17 != (-1)) goto L15;
        return;
    L15:
        if (this.f1364f[r17] != r11) goto L22;
        r16[r14] = r16[r17];
        r16[r17] = -1;
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float get(SolverVariable r10) {
        int r11 = indexOf(r10);
        if (r11 != (-1)) goto L5;
        return 0.0f;
    L5:
        return this.f1365g[r11];
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.f1368j;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int r10) {
        int r11 = this.f1368j;
        if (r11 != 0) goto L5;
        return null;
    L5:
        int r12 = this.f1369k;
        int r13 = 0;
    L6:
        if (r13 >= r11) goto L16;
        if (r13 != r10) goto L12;
        if (r12 == (-1)) goto L12;
        return this.f1371m.f1345d[this.f1364f[r12]];
    L12:
        r12 = this.f1367i[r12];
        if (r12 == (-1)) goto L16;
        r13 = r13 + 1;
    L16:
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int r10) {
        int r11 = this.f1368j;
        int r12 = this.f1369k;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L11;
        if (r13 == r10) goto L6;
        r12 = this.f1367i[r12];
        if (r12 == (-1)) goto L16;
        r13 = r13 + 1;
        goto L3
    L16:
        return 0.0f;
    L6:
        return this.f1365g[r12];
    L11:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable r10) {
        if (this.f1368j == 0) goto L22;
        if (r10 == null) goto L22;
        int r11 = r10.f1315c;
        int r12 = r11 % this.f1361c;
        int r13 = this.f1362d[r12];
        if (r13 != (-1)) goto L10;
        return -1;
    L10:
        if (this.f1364f[r13] != r11) goto L12;
        return r13;
    L12:
        r13 = this.f1363e[r13];
        if (r13 == (-1)) goto L17;
        if (this.f1364f[r13] != r11) goto L12;
    L17:
        if (r13 != (-1)) goto L20;
        return -1;
    L20:
        if (this.f1364f[r13] != r11) goto L22;
        return r13;
    L22:
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int r10 = this.f1368j;
        int r11 = this.f1369k;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L8;
        float[] r13 = this.f1365g;
        r13[r11] = r13[r11] * (-1.0f);
        r11 = this.f1367i[r11];
        if (r11 == (-1)) goto L11;
        r12 = r12 + 1;
        goto L3
    L11:
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void put(SolverVariable r10, float r11) {
        float r12 = f1358n;
        if (r11 > (-r12)) goto L5;
    L8:
        int r13 = 0;
        if (this.f1368j != 0) goto L11;
        b(0, r10, r11);
        a(r10, 0);
        this.f1369k = 0;
        return;
    L11:
        int r14 = indexOf(r10);
        if (r14 == (-1)) goto L15;
        this.f1365g[r14] = r11;
        return;
    L15:
        if ((this.f1368j + 1) < this.f1360b) goto L17;
        d();
    L17:
        int r15 = this.f1368j;
        int r16 = this.f1369k;
        int r17 = -1;
    L18:
        if (r13 >= r15) goto L29;
        int r18 = this.f1364f[r16];
        int r19 = r10.f1315c;
        if (r18 == r19) goto L21;
        if (r18 >= r19) goto L25;
        r17 = r16;
    L25:
        r16 = this.f1367i[r16];
        if (r16 == (-1)) goto L29;
        r13 = r13 + 1;
        goto L18
    L21:
        this.f1365g[r16] = r11;
        return;
    L29:
        e(r17, r10, r11);
        return;
    L5:
        if (r11 >= r12) goto L8;
        remove(r10, true);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable r10, boolean r11) {
        int r12 = indexOf(r10);
        if (r12 != (-1)) goto L6;
        return 0.0f;
    L6:
        f(r10);
        float r13 = this.f1365g[r12];
        if (this.f1369k != r12) goto L9;
        this.f1369k = this.f1367i[r12];
    L9:
        this.f1364f[r12] = -1;
        int[] r14 = this.f1366h;
        int r15 = r14[r12];
        if (r15 == (-1)) goto L12;
        int[] r16 = this.f1367i;
        r16[r15] = r16[r12];
    L12:
        int r17 = this.f1367i[r12];
        if (r17 == (-1)) goto L15;
        r14[r17] = r14[r12];
    L15:
        this.f1368j--;
        r10.f1325m--;
        if (r11 == false) goto L18;
        r10.d(this.f1370l);
    L18:
        return r13;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String r10 = hashCode() + " { ";
        int r11 = this.f1368j;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L18;
        SolverVariable r13 = getVariable(r12);
        if (r13 == null) goto L16;
        String r14 = r10 + r13 + " = " + getVariableValue(r12) + " ";
        int r15 = indexOf(r13);
        String r16 = r14 + "[p: ";
        if (this.f1366h[r15] == (-1)) goto L10;
        String r17 = r16 + this.f1371m.f1345d[this.f1364f[this.f1366h[r15]]];
    L11:
        String r18 = r17 + ", n: ";
        if (this.f1367i[r15] == (-1)) goto L14;
        String r19 = r18 + this.f1371m.f1345d[this.f1364f[this.f1367i[r15]]];
    L15:
        r10 = r19 + "]";
        goto L16
    L14:
        r19 = r18 + SchedulerSupport.NONE;
        goto L15
    L10:
        r17 = r16 + SchedulerSupport.NONE;
    L16:
        r12 = r12 + 1;
        goto L3
    L18:
        return r10 + " }";
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow r10, boolean r11) {
        float r12 = get(r10.f1253a);
        remove(r10.f1253a, r11);
        e r13 = (e) r10.f1257e;
        int r14 = r13.getCurrentSize();
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r15 >= r14) goto L8;
        int r17 = r13.f1364f[r16];
        if (r17 == (-1)) goto L7;
        add(this.f1371m.f1345d[r17], r13.f1365g[r16] * r12, r11);
        r15 = r15 + 1;
    L7:
        r16 = r16 + 1;
        goto L3
    L8:
        return r12;
    }
}
