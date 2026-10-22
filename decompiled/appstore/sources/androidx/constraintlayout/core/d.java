package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class d extends ArrayRow {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SolverVariable[] f1349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SolverVariable[] f1350i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f1352k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.core.b f1353l;

    public class a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f1354a;

        public a(d r10) {
            this.f1354a = r10;
        }

        public int a(SolverVariable r10, SolverVariable r11) {
            return r10.f1315c - r11.f1315c;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((SolverVariable) r10, (SolverVariable) r11);
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SolverVariable f1355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f1356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f1357c;

        public b(d r10, d r11) {
            this.f1357c = r10;
            this.f1356b = r11;
        }

        public boolean a(SolverVariable r10, float r11) {
            int r12 = 0;
            boolean r13 = true;
            if (this.f1355a.f1313a == false) goto L14;
            int r14 = 0;
        L5:
            if (r14 >= 9) goto L11;
            float[] r15 = this.f1355a.f1321i;
            float r16 = r15[r14] + (r10.f1321i[r14] * r11);
            r15[r14] = r16;
            if (Math.abs(r16) >= 1.0E-4f) goto L9;
            this.f1355a.f1321i[r14] = 0.0f;
        L10:
            r14 = r14 + 1;
            goto L5
        L9:
            r13 = false;
            goto L10
        L11:
            if (r13 == false) goto L13;
            d.y(this.f1357c, this.f1355a);
        L13:
            return false;
        L14:
            if (r12 >= 9) goto L23;
            float r17 = r10.f1321i[r12];
            if (r17 == 0.0f) goto L21;
            float r18 = r17 * r11;
            if (Math.abs(r18) >= 1.0E-4f) goto L20;
            r18 = 0.0f;
        L20:
            this.f1355a.f1321i[r12] = r18;
        L22:
            r12 = r12 + 1;
            goto L14
        L21:
            this.f1355a.f1321i[r12] = 0.0f;
            goto L22
        L23:
            return true;
        }

        public void b(SolverVariable r10) {
            this.f1355a = r10;
        }

        public final boolean c() {
            int r10 = 8;
        L4:
            if (r10 < 0) goto L13;
            float r11 = this.f1355a.f1321i[r10];
            if (r11 > 0.0f) goto L7;
            if (r11 < 0.0f) goto L10;
            r10 = r10 - 1;
            goto L4
        L10:
            return true;
        L7:
            return false;
        L13:
            return false;
        }

        public final boolean d(SolverVariable r10) {
            int r11 = 8;
        L4:
            if (r11 < 0) goto L12;
            float r12 = r10.f1321i[r11];
            float r13 = this.f1355a.f1321i[r11];
            if (r13 != r12) goto L9;
            r11 = r11 - 1;
            goto L4
        L9:
            if (r13 >= r12) goto L12;
            return true;
        L12:
            return false;
        }

        public void e() {
            Arrays.fill(this.f1355a.f1321i, 0.0f);
        }

        public String toString() {
            String r10 = "[ ";
            if (this.f1355a == null) goto L9;
            int r11 = 0;
        L6:
            if (r11 >= 9) goto L9;
            r10 = r10 + this.f1355a.f1321i[r11] + " ";
            r11 = r11 + 1;
        L9:
            return r10 + "] " + this.f1355a;
        }
    }

    public d(androidx.constraintlayout.core.b r10) {
        super(r10);
        this.f1348g = 128;
        this.f1349h = new SolverVariable[128];
        this.f1350i = new SolverVariable[128];
        this.f1351j = 0;
        this.f1352k = new b(this, this);
        this.f1353l = r10;
    }

    public static /* synthetic */ void y(d r10, SolverVariable r11) {
        r10.A(r11);
    }

    public final void A(SolverVariable r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f1351j) goto L13;
        if (this.f1349h[r11] == r10) goto L7;
        r11 = r11 + 1;
    L7:
        int r12 = this.f1351j;
        if (r11 >= (r12 - 1)) goto L10;
        SolverVariable[] r13 = this.f1349h;
        int r14 = r11 + 1;
        r13[r11] = r13[r14];
        r11 = r14;
        goto L7
    L10:
        this.f1351j = r12 - 1;
        r10.f1313a = false;
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable r10) {
        this.f1352k.b(r10);
        this.f1352k.e();
        r10.f1321i[r10.f1317e] = 1.0f;
        z(r10);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.f1351j = 0;
        this.f1254b = 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem r10, boolean[] r11) {
        int r12 = 0;
        int r13 = -1;
    L4:
        if (r12 >= this.f1351j) goto L17;
        SolverVariable r14 = this.f1349h[r12];
        if (r11[r14.f1315c] == true) goto L16;
        this.f1352k.b(r14);
        if (r13 != (-1)) goto L14;
        if (this.f1352k.c() == false) goto L16;
    L15:
        r13 = r12;
        goto L16
    L14:
        if (this.f1352k.d(this.f1349h[r13]) == true) goto L15;
    L16:
        r12 = r12 + 1;
        goto L4
    L17:
        if (r13 != (-1)) goto L21;
        return null;
    L21:
        return this.f1349h[r13];
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        if (this.f1351j != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String r10 = " goal -> (" + this.f1254b + ") : ";
        int r11 = 0;
    L4:
        if (r11 >= this.f1351j) goto L6;
        this.f1352k.b(this.f1349h[r11]);
        r10 = r10 + this.f1352k + " ";
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem r10, ArrayRow r11, boolean r12) {
        SolverVariable r13 = r11.f1253a;
        if (r13 != null) goto L5;
        return;
    L5:
        ArrayRow.ArrayRowVariables r14 = r11.f1257e;
        int r15 = r14.getCurrentSize();
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L11;
        SolverVariable r17 = r14.getVariable(r16);
        float r18 = r14.getVariableValue(r16);
        this.f1352k.b(r17);
        if (this.f1352k.a(r13, r18) == false) goto L10;
        z(r17);
    L10:
        this.f1254b += r11.f1254b * r18;
        r16 = r16 + 1;
        goto L6
    L11:
        A(r13);
    }

    public final void z(SolverVariable r10) {
        int r11 = this.f1351j + 1;
        SolverVariable[] r12 = this.f1349h;
        if (r11 <= r12.length) goto L5;
        SolverVariable[] r13 = (SolverVariable[]) Arrays.copyOf(r12, r12.length * 2);
        this.f1349h = r13;
        this.f1350i = (SolverVariable[]) Arrays.copyOf(r13, r13.length * 2);
    L5:
        SolverVariable[] r14 = this.f1349h;
        int r15 = this.f1351j;
        r14[r15] = r10;
        int r16 = r15 + 1;
        this.f1351j = r16;
        if (r16 > 1) goto L8;
    L17:
        r10.f1313a = true;
        r10.a(this);
        return;
    L8:
        if (r14[r15].f1315c <= r10.f1315c) goto L17;
        int r17 = 0;
        int r18 = 0;
    L10:
        int r19 = this.f1351j;
        if (r18 >= r19) goto L13;
        this.f1350i[r18] = this.f1349h[r18];
        r18 = r18 + 1;
        goto L10
    L13:
        Arrays.sort(this.f1350i, 0, r19, new a(this));
    L15:
        if (r17 >= this.f1351j) goto L17;
        this.f1349h[r17] = this.f1350i[r17];
        r17 = r17 + 1;
        goto L15
    }
}
