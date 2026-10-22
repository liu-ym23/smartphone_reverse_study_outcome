package com.obric.oui.constraintlayout.core;

import com.bytedanceos.common.ad.param.AdReportParam;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class ArrayRow implements LinearSystem.Row {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SolverVariable f13095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f13096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f13098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayRowVariables f13099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13100f;

    public interface ArrayRowVariables {
        void add(SolverVariable r10, float r11, boolean r12);

        void clear();

        boolean contains(SolverVariable r10);

        void display();

        void divideByAmount(float r10);

        float get(SolverVariable r10);

        int getCurrentSize();

        SolverVariable getVariable(int r10);

        float getVariableValue(int r10);

        int indexOf(SolverVariable r10);

        void invert();

        void put(SolverVariable r10, float r11);

        float remove(SolverVariable r10, boolean r11);

        int sizeInBytes();

        float use(ArrayRow r10, boolean r11);
    }

    public ArrayRow() {
        this.f13095a = null;
        this.f13096b = 0.0f;
        this.f13097c = false;
        this.f13098d = new ArrayList();
        this.f13100f = false;
    }

    public ArrayRow a(LinearSystem r10, int r11) {
        this.f13099e.put(r10.o(r11, "ep"), 1.0f);
        this.f13099e.put(r10.o(r11, "em"), -1.0f);
        return this;
    }

    @Override // com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable r10) {
        int r11 = r10.f13131e;
        float r12 = 1.0f;
        if (r11 != 1) goto L6;
    L17:
        this.f13099e.put(r10, r12);
        return;
    L6:
        if (r11 != 2) goto L9;
        r12 = 1000.0f;
        goto L17
    L9:
        if (r11 != 3) goto L12;
        r12 = 1000000.0f;
        goto L17
    L12:
        if (r11 != 4) goto L15;
        r12 = 1.0E9f;
        goto L17
    L15:
        if (r11 != 5) goto L17;
        r12 = 1.0E12f;
        goto L17
    }

    public ArrayRow b(SolverVariable r10, int r11) {
        this.f13099e.put(r10, r11);
        return this;
    }

    public boolean c(LinearSystem r10) {
        SolverVariable r11 = d(r10);
        if (r11 != null) goto L5;
        boolean r12 = true;
    L7:
        if (this.f13099e.getCurrentSize() != 0) goto L9;
        this.f13100f = true;
    L9:
        return r12;
    L5:
        u(r11);
        r12 = false;
        goto L7
    }

    @Override // com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.f13099e.clear();
        this.f13095a = null;
        this.f13096b = 0.0f;
    }

    public SolverVariable d(LinearSystem r15) {
        int r10 = this.f13099e.getCurrentSize();
        SolverVariable r11 = null;
        float r12 = 0.0f;
        float r13 = 0.0f;
        int r14 = 0;
        boolean r16 = false;
        boolean r17 = false;
        SolverVariable r18 = null;
    L3:
        if (r14 >= r10) goto L30;
        float r19 = this.f13099e.getVariableValue(r14);
        SolverVariable r110 = this.f13099e.getVariable(r14);
        if (r110.f13136j != SolverVariable.Type.UNRESTRICTED) goto L16;
        if (r11 != null) goto L10;
        boolean r20 = r(r110, r15);
    L8:
        r16 = r20;
        r12 = r19;
        r11 = r110;
    L29:
        r14 = r14 + 1;
        goto L3
    L10:
        if (r12 <= r19) goto L12;
        r20 = r(r110, r15);
        goto L8
    L12:
        if (r16 == true) goto L29;
        if (r(r110, r15) == false) goto L29;
        r12 = r19;
        r11 = r110;
        r16 = true;
        goto L29
    L16:
        if (r11 != null) goto L29;
        if (r19 >= 0.0f) goto L29;
        if (r18 != null) goto L23;
        boolean r21 = r(r110, r15);
    L21:
        r17 = r21;
        r13 = r19;
        r18 = r110;
        goto L29
    L23:
        if (r13 <= r19) goto L25;
        r21 = r(r110, r15);
        goto L21
    L25:
        if (r17 == true) goto L29;
        if (r(r110, r15) == false) goto L29;
        r13 = r19;
        r18 = r110;
        r17 = true;
        goto L29
    L30:
        if (r11 == null) goto L32;
        return r11;
    L32:
        return r18;
    }

    public ArrayRow e(SolverVariable r10, SolverVariable r11, int r12, float r13, SolverVariable r14, SolverVariable r15, int r16) {
        if (r11 != r14) goto L7;
        this.f13099e.put(r10, 1.0f);
        this.f13099e.put(r15, 1.0f);
        this.f13099e.put(r11, -2.0f);
        return this;
    L7:
        if (r13 != 0.5f) goto L13;
        this.f13099e.put(r10, 1.0f);
        this.f13099e.put(r11, -1.0f);
        this.f13099e.put(r14, -1.0f);
        this.f13099e.put(r15, 1.0f);
        if (r12 > 0) goto L11;
        if (r16 > 0) goto L11;
    L22:
        return this;
    L11:
        this.f13096b = (-r12) + r16;
        goto L22
    L13:
        if (r13 > 0.0f) goto L16;
        this.f13099e.put(r10, -1.0f);
        this.f13099e.put(r11, 1.0f);
        this.f13096b = r12;
        goto L22
    L16:
        if (r13 < 1.0f) goto L18;
        this.f13099e.put(r15, -1.0f);
        this.f13099e.put(r14, 1.0f);
        this.f13096b = -r16;
        goto L22
    L18:
        float r17 = 1.0f - r13;
        this.f13099e.put(r10, r17 * 1.0f);
        this.f13099e.put(r11, r17 * (-1.0f));
        this.f13099e.put(r14, (-1.0f) * r13);
        this.f13099e.put(r15, 1.0f * r13);
        if (r12 > 0) goto L21;
        if (r16 <= 0) goto L22;
    L21:
        this.f13096b = ((-r12) * r17) + (r16 * r13);
        goto L22
    }

    public ArrayRow f(SolverVariable r10, int r11) {
        this.f13095a = r10;
        float r12 = r11;
        r10.f13132f = r12;
        this.f13096b = r12;
        this.f13100f = true;
        return this;
    }

    public ArrayRow g(SolverVariable r10, SolverVariable r11, float r12) {
        this.f13099e.put(r10, -1.0f);
        this.f13099e.put(r11, r12);
        return this;
    }

    @Override // com.obric.oui.constraintlayout.core.LinearSystem.Row
    public SolverVariable getKey() {
        return this.f13095a;
    }

    @Override // com.obric.oui.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem r10, boolean[] r11) {
        return t(r11, null);
    }

    public ArrayRow h(SolverVariable r10, SolverVariable r11, SolverVariable r12, SolverVariable r13, float r14) {
        this.f13099e.put(r10, -1.0f);
        this.f13099e.put(r11, 1.0f);
        this.f13099e.put(r12, r14);
        this.f13099e.put(r13, -r14);
        return this;
    }

    public ArrayRow i(float r10, float r11, float r12, SolverVariable r13, SolverVariable r14, SolverVariable r15, SolverVariable r16) {
        this.f13096b = 0.0f;
        if (r11 != 0.0f) goto L5;
    L14:
        this.f13099e.put(r13, 1.0f);
        this.f13099e.put(r14, -1.0f);
        this.f13099e.put(r16, 1.0f);
        this.f13099e.put(r15, -1.0f);
    L15:
        return this;
    L5:
        if (r10 == r12) goto L14;
        if (r10 != 0.0f) goto L11;
        this.f13099e.put(r13, 1.0f);
        this.f13099e.put(r14, -1.0f);
        goto L15
    L11:
        if (r12 != 0.0f) goto L13;
        this.f13099e.put(r15, 1.0f);
        this.f13099e.put(r16, -1.0f);
        goto L15
    L13:
        float r17 = (r10 / r11) / (r12 / r11);
        this.f13099e.put(r13, 1.0f);
        this.f13099e.put(r14, -1.0f);
        this.f13099e.put(r16, r17);
        this.f13099e.put(r15, -r17);
        goto L15
    }

    @Override // com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void initFromRow(LinearSystem.Row r10) {
        if ((r10 instanceof ArrayRow) == false) goto L8;
        ArrayRow r11 = (ArrayRow) r10;
        this.f13095a = null;
        this.f13099e.clear();
        int r12 = 0;
    L6:
        if (r12 >= r11.f13099e.getCurrentSize()) goto L10;
        SolverVariable r13 = r11.f13099e.getVariable(r12);
        float r14 = r11.f13099e.getVariableValue(r12);
        this.f13099e.add(r13, r14, true);
        r12 = r12 + 1;
        goto L6
    L10:
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        if (this.f13095a == null) goto L5;
    L9:
        return false;
    L5:
        if (this.f13096b != 0.0f) goto L9;
        if (this.f13099e.getCurrentSize() != 0) goto L9;
        return true;
    }

    public ArrayRow j(SolverVariable r10, int r11) {
        if (r11 >= 0) goto L4;
        this.f13096b = r11 * (-1);
        this.f13099e.put(r10, 1.0f);
    L5:
        return this;
    L4:
        this.f13096b = r11;
        this.f13099e.put(r10, -1.0f);
        goto L5
    }

    public ArrayRow k(SolverVariable r10, SolverVariable r11, int r12) {
        boolean r13 = false;
        if (r12 == 0) goto L8;
        if (r12 >= 0) goto L6;
        r12 = r12 * (-1);
        r13 = true;
    L6:
        this.f13096b = r12;
    L8:
        if (r13 == true) goto L10;
        this.f13099e.put(r10, -1.0f);
        this.f13099e.put(r11, 1.0f);
    L11:
        return this;
    L10:
        this.f13099e.put(r10, 1.0f);
        this.f13099e.put(r11, -1.0f);
        goto L11
    }

    public ArrayRow l(SolverVariable r10, SolverVariable r11, SolverVariable r12, int r13) {
        boolean r14 = false;
        if (r13 == 0) goto L8;
        if (r13 >= 0) goto L6;
        r13 = r13 * (-1);
        r14 = true;
    L6:
        this.f13096b = r13;
    L8:
        if (r14 == true) goto L10;
        this.f13099e.put(r10, -1.0f);
        this.f13099e.put(r11, 1.0f);
        this.f13099e.put(r12, 1.0f);
    L11:
        return this;
    L10:
        this.f13099e.put(r10, 1.0f);
        this.f13099e.put(r11, -1.0f);
        this.f13099e.put(r12, -1.0f);
        goto L11
    }

    public ArrayRow m(SolverVariable r10, SolverVariable r11, SolverVariable r12, int r13) {
        boolean r14 = false;
        if (r13 == 0) goto L8;
        if (r13 >= 0) goto L6;
        r13 = r13 * (-1);
        r14 = true;
    L6:
        this.f13096b = r13;
    L8:
        if (r14 == true) goto L10;
        this.f13099e.put(r10, -1.0f);
        this.f13099e.put(r11, 1.0f);
        this.f13099e.put(r12, -1.0f);
    L11:
        return this;
    L10:
        this.f13099e.put(r10, 1.0f);
        this.f13099e.put(r11, -1.0f);
        this.f13099e.put(r12, 1.0f);
        goto L11
    }

    public ArrayRow n(SolverVariable r10, SolverVariable r11, SolverVariable r12, SolverVariable r13, float r14) {
        this.f13099e.put(r12, 0.5f);
        this.f13099e.put(r13, 0.5f);
        this.f13099e.put(r10, -0.5f);
        this.f13099e.put(r11, -0.5f);
        this.f13096b = -r14;
        return this;
    }

    public void o() {
        float r10 = this.f13096b;
        if (r10 >= 0.0f) goto L6;
        this.f13096b = r10 * (-1.0f);
        this.f13099e.invert();
        return;
    }

    public boolean p() {
        SolverVariable r10 = this.f13095a;
        if (r10 != null) goto L5;
    L9:
        return false;
    L5:
        if (r10.f13136j != SolverVariable.Type.UNRESTRICTED) goto L7;
    L8:
        return true;
    L7:
        if (this.f13096b < 0.0f) goto L9;
        goto L8
    }

    public boolean q(SolverVariable r10) {
        return this.f13099e.contains(r10);
    }

    public final boolean r(SolverVariable r10, LinearSystem r11) {
        if (r10.f13139m <= 1) goto L7;
        return false;
    L7:
        return true;
    }

    public SolverVariable s(SolverVariable r10) {
        return t(null, r10);
    }

    public final SolverVariable t(boolean[] r10, SolverVariable r11) {
        int r12 = this.f13099e.getCurrentSize();
        SolverVariable r13 = null;
        int r14 = 0;
        float r15 = 0.0f;
    L3:
        if (r14 >= r12) goto L19;
        float r16 = this.f13099e.getVariableValue(r14);
        if (r16 >= 0.0f) goto L18;
        SolverVariable r17 = this.f13099e.getVariable(r14);
        if (r10 != null) goto L9;
    L10:
        if (r17 == r11) goto L18;
        SolverVariable.Type r18 = r17.f13136j;
        if (r18 == SolverVariable.Type.SLACK) goto L16;
        if (r18 != SolverVariable.Type.ERROR) goto L18;
    L16:
        if (r16 >= r15) goto L18;
        r15 = r16;
        r13 = r17;
        goto L18
    L9:
        if (r10[r17.f13129c] == false) goto L10;
    L18:
        r14 = r14 + 1;
        goto L3
    L19:
        return r13;
    }

    public String toString() {
        return w();
    }

    public void u(SolverVariable r10) {
        SolverVariable r11 = this.f13095a;
        if (r11 == null) goto L5;
        this.f13099e.put(r11, -1.0f);
        this.f13095a.f13130d = -1;
        this.f13095a = null;
    L5:
        float r12 = this.f13099e.remove(r10, true) * (-1.0f);
        this.f13095a = r10;
        if (r12 != 1.0f) goto L8;
        return;
    L8:
        this.f13096b /= r12;
        this.f13099e.divideByAmount(r12);
    }

    @Override // com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem r10, SolverVariable r11, boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.f13133g == false) goto L18;
        this.f13096b += r11.f13132f * this.f13099e.get(r11);
        this.f13099e.remove(r11, r12);
        if (r12 == false) goto L10;
        r11.d(this);
    L10:
        if (LinearSystem.f13103u == true) goto L12;
        return;
    L12:
        if (this.f13099e.getCurrentSize() != 0) goto L17;
        this.f13100f = true;
        r10.f13109b = true;
        return;
    L17:
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem r10, ArrayRow r11, boolean r12) {
        this.f13096b += r11.f13096b * this.f13099e.use(r11, r12);
        if (r12 == false) goto L6;
        r11.f13095a.d(this);
    L6:
        if (LinearSystem.f13103u == true) goto L8;
        return;
    L8:
        if (this.f13095a != null) goto L10;
        return;
    L10:
        if (this.f13099e.getCurrentSize() != 0) goto L15;
        this.f13100f = true;
        r10.f13109b = true;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void updateFromSystem(LinearSystem r10) {
        if (r10.f13115h.length != 0) goto L5;
        return;
    L5:
        boolean r11 = false;
    L7:
        if (r11 == true) goto L33;
        int r12 = this.f13099e.getCurrentSize();
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L18;
        SolverVariable r14 = this.f13099e.getVariable(r13);
        if (r14.f13130d == (-1)) goto L13;
    L16:
        this.f13098d.add(r14);
    L17:
        r13 = r13 + 1;
        goto L9
    L13:
        if (r14.f13133g == true) goto L16;
        if (r14.f13140n == false) goto L17;
    L18:
        int r15 = this.f13098d.size();
        if (r15 > 0) goto L20;
        r11 = true;
        goto L7
    L20:
        int r16 = 0;
    L21:
        if (r16 >= r15) goto L30;
        SolverVariable r17 = (SolverVariable) this.f13098d.get(r16);
        if (r17.f13133g == false) goto L26;
        updateFromFinalVariable(r10, r17, true);
    L29:
        r16 = r16 + 1;
        goto L21
    L26:
        if (r17.f13140n == false) goto L28;
        x(r10, r17, true);
        goto L29
    L28:
        updateFromRow(r10, r10.f13115h[r17.f13130d], true);
        goto L29
    L30:
        this.f13098d.clear();
        goto L7
    L33:
        if (LinearSystem.f13103u == true) goto L35;
        return;
    L35:
        if (this.f13095a != null) goto L37;
        return;
    L37:
        if (this.f13099e.getCurrentSize() != 0) goto L55;
        this.f13100f = true;
        r10.f13109b = true;
        return;
    }

    public void v() {
        this.f13095a = null;
        this.f13099e.clear();
        this.f13096b = 0.0f;
        this.f13100f = false;
    }

    public String w() {
        if (this.f13095a != null) goto L5;
        String r10 = "" + AdReportParam.ClickPosType.SKIP;
    L6:
        String r11 = r10 + " = ";
        int r12 = 0;
        if (this.f13096b == 0.0f) goto L9;
        r11 = r11 + this.f13096b;
        boolean r13 = true;
    L10:
        int r14 = this.f13099e.getCurrentSize();
    L11:
        if (r12 >= r14) goto L33;
        SolverVariable r15 = this.f13099e.getVariable(r12);
        if (r15 == null) goto L32;
        float r16 = this.f13099e.getVariableValue(r12);
        if (r16 == 0.0f) goto L32;
        String r17 = r15.toString();
        if (r13 == false) goto L21;
        if (r16 <= 0.0f) goto L26;
        r11 = r11 + " + ";
    L28:
        if (r16 != 1.0f) goto L30;
        r11 = r11 + r17;
    L31:
        r13 = true;
        goto L32
    L30:
        r11 = r11 + r16 + " " + r17;
        goto L31
    L26:
        r11 = r11 + " - ";
    L23:
        r16 = r16 * (-1.0f);
        goto L28
    L21:
        if (r16 >= 0.0f) goto L28;
        r11 = r11 + "- ";
    L32:
        r12 = r12 + 1;
        goto L11
    L33:
        if (r13 == false) goto L35;
        return r11;
    L35:
        return r11 + "0.0";
    L9:
        r13 = false;
        goto L10
    L5:
        r10 = "" + this.f13095a;
        goto L6
    }

    public void x(LinearSystem r10, SolverVariable r11, boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.f13140n == false) goto L18;
        float r13 = this.f13099e.get(r11);
        this.f13096b += r11.f13142p * r13;
        this.f13099e.remove(r11, r12);
        if (r12 == false) goto L9;
        r11.d(this);
    L9:
        this.f13099e.add(r10.f13122o.f13159d[r11.f13141o], r13, r12);
        if (LinearSystem.f13103u == true) goto L12;
        return;
    L12:
        if (this.f13099e.getCurrentSize() != 0) goto L17;
        this.f13100f = true;
        r10.f13109b = true;
        return;
    L17:
        return;
    }

    public ArrayRow(b r10) {
        this.f13095a = null;
        this.f13096b = 0.0f;
        this.f13097c = false;
        this.f13098d = new ArrayList();
        this.f13100f = false;
        this.f13099e = new a(this, r10);
    }
}
