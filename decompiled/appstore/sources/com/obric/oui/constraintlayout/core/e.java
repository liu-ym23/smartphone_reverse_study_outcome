package com.obric.oui.constraintlayout.core;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
public class e extends ArrayRow {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SolverVariable[] f13163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SolverVariable[] f13164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f13166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.b f13167l;

    public class a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f13168a;

        public a(e r10) {
            this.f13168a = r10;
        }

        public int a(SolverVariable r10, SolverVariable r11) {
            return r10.f13129c - r11.f13129c;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((SolverVariable) r10, (SolverVariable) r11);
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SolverVariable f13169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f13170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f13171c;

        public b(e r10, e r11) {
            this.f13171c = r10;
            this.f13170b = r11;
        }

        public boolean a(SolverVariable r10, float r11) {
            int r12 = 0;
            boolean r13 = true;
            if (this.f13169a.f13127a == false) goto L14;
            int r14 = 0;
        L5:
            if (r14 >= 9) goto L11;
            float[] r15 = this.f13169a.f13135i;
            float r16 = r15[r14] + (r10.f13135i[r14] * r11);
            r15[r14] = r16;
            if (Math.abs(r16) >= 1.0E-4f) goto L9;
            this.f13169a.f13135i[r14] = 0.0f;
        L10:
            r14 = r14 + 1;
            goto L5
        L9:
            r13 = false;
            goto L10
        L11:
            if (r13 == false) goto L13;
            e.y(this.f13171c, this.f13169a);
        L13:
            return false;
        L14:
            if (r12 >= 9) goto L23;
            float r17 = r10.f13135i[r12];
            if (r17 == 0.0f) goto L21;
            float r18 = r17 * r11;
            if (Math.abs(r18) >= 1.0E-4f) goto L20;
            r18 = 0.0f;
        L20:
            this.f13169a.f13135i[r12] = r18;
        L22:
            r12 = r12 + 1;
            goto L14
        L21:
            this.f13169a.f13135i[r12] = 0.0f;
            goto L22
        L23:
            return true;
        }

        public void b(SolverVariable r10) {
            this.f13169a = r10;
        }

        public final boolean c() {
            int r10 = 8;
        L4:
            if (r10 < 0) goto L13;
            float r11 = this.f13169a.f13135i[r10];
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
            if (r11 < 0) goto L15;
            float r12 = r10.f13135i[r11];
            float r13 = this.f13169a.f13135i[r11];
            if (r13 != r12) goto L9;
            r11 = r11 - 1;
            goto L4
        L9:
            if (r13 >= r12) goto L14;
            return true;
        L14:
            return false;
        L15:
            return false;
        }

        public void e() {
            Arrays.fill(this.f13169a.f13135i, 0.0f);
        }

        public String toString() {
            String r10 = "[ ";
            if (this.f13169a == null) goto L9;
            int r11 = 0;
        L6:
            if (r11 >= 9) goto L9;
            r10 = r10 + this.f13169a.f13135i[r11] + " ";
            r11 = r11 + 1;
        L9:
            return r10 + "] " + this.f13169a;
        }
    }

    public e(com.obric.oui.constraintlayout.core.b r10) {
        super(r10);
        this.f13162g = 128;
        this.f13163h = new SolverVariable[128];
        this.f13164i = new SolverVariable[128];
        this.f13165j = 0;
        this.f13166k = new b(this, this);
        this.f13167l = r10;
    }

    public static /* synthetic */ void y(e r10, SolverVariable r11) {
        r10.A(r11);
    }

    public final void A(SolverVariable r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f13165j) goto L13;
        if (this.f13163h[r11] == r10) goto L7;
        r11 = r11 + 1;
    L7:
        int r12 = this.f13165j;
        if (r11 >= (r12 - 1)) goto L10;
        SolverVariable[] r13 = this.f13163h;
        int r14 = r11 + 1;
        r13[r11] = r13[r14];
        r11 = r14;
        goto L7
    L10:
        this.f13165j = r12 - 1;
        r10.f13127a = false;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow, com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable r10) {
        this.f13166k.b(r10);
        this.f13166k.e();
        r10.f13135i[r10.f13131e] = 1.0f;
        z(r10);
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow, com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.f13165j = 0;
        this.f13096b = 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow, com.obric.oui.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem r10, boolean[] r11) {
        int r12 = 0;
        int r13 = -1;
    L4:
        if (r12 >= this.f13165j) goto L17;
        SolverVariable r14 = this.f13163h[r12];
        if (r11[r14.f13129c] == true) goto L16;
        this.f13166k.b(r14);
        if (r13 != (-1)) goto L14;
        if (this.f13166k.c() == false) goto L16;
    L15:
        r13 = r12;
        goto L16
    L14:
        if (this.f13166k.d(this.f13163h[r13]) == true) goto L15;
    L16:
        r12 = r12 + 1;
        goto L4
    L17:
        if (r13 != (-1)) goto L21;
        return null;
    L21:
        return this.f13163h[r13];
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow, com.obric.oui.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        if (this.f13165j != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow
    public String toString() {
        String r10 = " goal -> (" + this.f13096b + ") : ";
        int r11 = 0;
    L4:
        if (r11 >= this.f13165j) goto L6;
        this.f13166k.b(this.f13163h[r11]);
        r10 = r10 + this.f13166k + " ";
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow, com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem r10, ArrayRow r11, boolean r12) {
        SolverVariable r13 = r11.f13095a;
        if (r13 != null) goto L5;
        return;
    L5:
        ArrayRow.ArrayRowVariables r14 = r11.f13099e;
        int r15 = r14.getCurrentSize();
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L11;
        SolverVariable r17 = r14.getVariable(r16);
        float r18 = r14.getVariableValue(r16);
        this.f13166k.b(r17);
        if (this.f13166k.a(r13, r18) == false) goto L10;
        z(r17);
    L10:
        this.f13096b += r11.f13096b * r18;
        r16 = r16 + 1;
        goto L6
    L11:
        A(r13);
    }

    public final void z(SolverVariable r10) {
        int r11 = this.f13165j + 1;
        SolverVariable[] r12 = this.f13163h;
        if (r11 <= r12.length) goto L5;
        SolverVariable[] r13 = (SolverVariable[]) Arrays.copyOf(r12, r12.length * 2);
        this.f13163h = r13;
        this.f13164i = (SolverVariable[]) Arrays.copyOf(r13, r13.length * 2);
    L5:
        SolverVariable[] r14 = this.f13163h;
        int r15 = this.f13165j;
        r14[r15] = r10;
        int r16 = r15 + 1;
        this.f13165j = r16;
        if (r16 > 1) goto L8;
    L17:
        r10.f13127a = true;
        r10.a(this);
        return;
    L8:
        if (r14[r15].f13129c <= r10.f13129c) goto L17;
        int r17 = 0;
        int r18 = 0;
    L10:
        int r19 = this.f13165j;
        if (r18 >= r19) goto L13;
        this.f13164i[r18] = this.f13163h[r18];
        r18 = r18 + 1;
        goto L10
    L13:
        Arrays.sort(this.f13164i, 0, r19, new a(this));
    L15:
        if (r17 >= this.f13165j) goto L17;
        this.f13163h[r17] = this.f13164i[r17];
        r17 = r17 + 1;
        goto L15
    }
}
