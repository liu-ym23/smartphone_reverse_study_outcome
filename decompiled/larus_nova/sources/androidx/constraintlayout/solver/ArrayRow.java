package androidx.constraintlayout.solver;

import androidx.camera.core.processing.util.GLUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayRow implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    float constantValue;
    boolean isSimpleDefinition;
    boolean used;
    SolverVariable variable;
    public ArrayRowVariables variables;
    ArrayList<SolverVariable> variablesToUpdate;

    public interface ArrayRowVariables {
        void add(SolverVariable r100, float r101, boolean r102);

        void clear();

        boolean contains(SolverVariable r100);

        void display();

        void divideByAmount(float r100);

        float get(SolverVariable r100);

        int getCurrentSize();

        SolverVariable getVariable(int r100);

        float getVariableValue(int r100);

        int indexOf(SolverVariable r100);

        void invert();

        void put(SolverVariable r100, float r101);

        float remove(SolverVariable r100, boolean r101);

        int sizeInBytes();

        float use(ArrayRow r100, boolean r101);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    public void ensurePositiveConstant() {
        float r100 = this.constantValue;
        if (r100 >= 0.0f) goto L6;
        this.constantValue = r100 * (-1.0f);
        this.variables.invert();
        return;
    }

    public boolean hasKeyVariable() {
        SolverVariable r100 = this.variable;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.mType != SolverVariable.Type.UNRESTRICTED) goto L7;
    L8:
        return true;
    L7:
        if (this.constantValue < 0.0f) goto L9;
        goto L8
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        if (this.variable == null) goto L5;
    L9:
        return false;
    L5:
        if (this.constantValue != 0.0f) goto L9;
        if (this.variables.getCurrentSize() != 0) goto L9;
        return true;
    }

    public int sizeInBytes() {
        if (this.variable == null) goto L5;
        int r100 = 4;
    L7:
        return ((r100 + 4) + 4) + this.variables.sizeInBytes();
    L5:
        r100 = 0;
        goto L7
    }

    public String toReadableString() {
        if (this.variable != null) goto L5;
        String r100 = "0";
    L6:
        String r101 = r100 + " = ";
        int r102 = 0;
        if (this.constantValue == 0.0f) goto L9;
        r101 = r101 + this.constantValue;
        boolean r103 = true;
    L10:
        int r104 = this.variables.getCurrentSize();
    L11:
        if (r102 >= r104) goto L33;
        SolverVariable r105 = this.variables.getVariable(r102);
        if (r105 == null) goto L32;
        float r106 = this.variables.getVariableValue(r102);
        if (r106 == 0.0f) goto L32;
        String r107 = r105.toString();
        if (r103 == false) goto L21;
        if (r106 <= 0.0f) goto L25;
        r101 = r101 + " + ";
    L28:
        if (r106 != 1.0f) goto L30;
        r101 = r101 + r107;
    L31:
        r103 = true;
        goto L32
    L30:
        r101 = r101 + r106 + " " + r107;
        goto L31
    L25:
        r101 = r101 + " - ";
    L26:
        r106 = r106 * (-1.0f);
        goto L28
    L21:
        if (r106 >= 0.0f) goto L28;
        r101 = r101 + "- ";
    L32:
        r102 = r102 + 1;
        goto L11
    L33:
        if (r103 == false) goto L35;
        return r101;
    L35:
        return r101 + GLUtils.VERSION_UNKNOWN;
    L9:
        r103 = false;
        goto L10
    L5:
        r100 = "" + this.variable;
        goto L6
    }

    public ArrayRow() {
        this.variable = null;
        this.constantValue = 0.0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList();
        this.isSimpleDefinition = false;
    }

    public String toString() {
        return toReadableString();
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getKey() {
        return this.variable;
    }

    public ArrayRow(Cache r100) {
        this.variable = null;
        this.constantValue = 0.0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList();
        this.isSimpleDefinition = false;
        this.variables = new ArrayLinkedVariables(this, r100);
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable r100) {
        int r101 = r100.strength;
        float r102 = 1.0f;
        if (r101 != 1) goto L6;
    L17:
        this.variables.put(r100, r102);
        return;
    L6:
        if (r101 != 2) goto L9;
        r102 = 1000.0f;
        goto L17
    L9:
        if (r101 != 3) goto L12;
        r102 = 1000000.0f;
        goto L17
    L12:
        if (r101 != 4) goto L15;
        r102 = 1.0E9f;
        goto L17
    L15:
        if (r101 != 5) goto L17;
        r102 = 1.0E12f;
        goto L17
    }

    public boolean chooseSubject(LinearSystem r100) {
        SolverVariable r101 = chooseSubjectInVariables(r100);
        if (r101 != null) goto L5;
        boolean r102 = true;
    L7:
        if (this.variables.getCurrentSize() != 0) goto L9;
        this.isSimpleDefinition = true;
    L9:
        return r102;
    L5:
        pivot(r101);
        r102 = false;
        goto L7
    }

    public SolverVariable chooseSubjectInVariables(LinearSystem r110) {
        int r100 = this.variables.getCurrentSize();
        SolverVariable r101 = null;
        SolverVariable r102 = null;
        int r103 = 0;
        boolean r104 = false;
        boolean r105 = false;
        float r106 = 0.0f;
        float r107 = 0.0f;
    L3:
        if (r103 >= r100) goto L30;
        float r108 = this.variables.getVariableValue(r103);
        SolverVariable r111 = this.variables.getVariable(r103);
        if (r111.mType != SolverVariable.Type.UNRESTRICTED) goto L16;
        if (r101 != null) goto L10;
        boolean r109 = isNew(r111, r110);
    L8:
        r104 = r109;
        r106 = r108;
        r101 = r111;
    L29:
        r103 = r103 + 1;
        goto L3
    L10:
        if (r106 <= r108) goto L12;
        r109 = isNew(r111, r110);
        goto L8
    L12:
        if (r104 == true) goto L29;
        if (isNew(r111, r110) == false) goto L29;
        r106 = r108;
        r101 = r111;
        r104 = true;
        goto L29
    L16:
        if (r101 != null) goto L29;
        if (r108 >= 0.0f) goto L29;
        if (r102 != null) goto L23;
        boolean r112 = isNew(r111, r110);
    L21:
        r105 = r112;
        r107 = r108;
        r102 = r111;
        goto L29
    L23:
        if (r107 <= r108) goto L25;
        r112 = isNew(r111, r110);
        goto L21
    L25:
        if (r105 == true) goto L29;
        if (isNew(r111, r110) == false) goto L29;
        r107 = r108;
        r102 = r111;
        r105 = true;
        goto L29
    L30:
        if (r101 == null) goto L32;
        return r101;
    L32:
        return r102;
    }

    public boolean hasVariable(SolverVariable r100) {
        return this.variables.contains(r100);
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void initFromRow(LinearSystem.Row r100) {
        if ((r100 instanceof ArrayRow) == false) goto L8;
        ArrayRow r101 = (ArrayRow) r100;
        this.variable = null;
        this.variables.clear();
        int r102 = 0;
    L6:
        if (r102 >= r101.variables.getCurrentSize()) goto L10;
        SolverVariable r103 = r101.variables.getVariable(r102);
        float r104 = r101.variables.getVariableValue(r102);
        this.variables.add(r103, r104, true);
        r102 = r102 + 1;
        goto L6
    L10:
        return;
    }

    public SolverVariable pickPivot(SolverVariable r100) {
        return pickPivotInVariables(null, r100);
    }

    public void pivot(SolverVariable r100) {
        SolverVariable r101 = this.variable;
        if (r101 == null) goto L5;
        this.variables.put(r101, -1.0f);
        this.variable.definitionId = -1;
        this.variable = null;
    L5:
        float r102 = this.variables.remove(r100, true) * (-1.0f);
        this.variable = r100;
        if (r102 != 1.0f) goto L8;
        return;
    L8:
        this.constantValue /= r102;
        this.variables.divideByAmount(r102);
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromSystem(LinearSystem r100) {
        if (r100.mRows.length != 0) goto L5;
        return;
    L5:
        boolean r101 = false;
    L7:
        if (r101 == true) goto L33;
        int r102 = this.variables.getCurrentSize();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L18;
        SolverVariable r104 = this.variables.getVariable(r103);
        if (r104.definitionId == (-1)) goto L13;
    L16:
        this.variablesToUpdate.add(r104);
    L17:
        r103 = r103 + 1;
        goto L9
    L13:
        if (r104.isFinalValue == true) goto L16;
        if (r104.isSynonym == false) goto L17;
    L18:
        int r105 = this.variablesToUpdate.size();
        if (r105 > 0) goto L20;
        r101 = true;
        goto L7
    L20:
        int r106 = 0;
    L21:
        if (r106 >= r105) goto L30;
        SolverVariable r107 = (SolverVariable) ListProtector.get(this.variablesToUpdate, r106);
        if (r107.isFinalValue == false) goto L26;
        updateFromFinalVariable(r100, r107, true);
    L29:
        r106 = r106 + 1;
        goto L21
    L26:
        if (r107.isSynonym == false) goto L28;
        updateFromSynonymVariable(r100, r107, true);
        goto L29
    L28:
        updateFromRow(r100, r100.mRows[r107.definitionId], true);
        goto L29
    L30:
        this.variablesToUpdate.clear();
        goto L7
    L33:
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L35;
        return;
    L35:
        if (this.variable != null) goto L37;
        return;
    L37:
        if (this.variables.getCurrentSize() != 0) goto L55;
        this.isSimpleDefinition = true;
        r100.hasSimpleDefinition = true;
        return;
    }

    private boolean isNew(SolverVariable r100, LinearSystem r101) {
        if (r100.usageInRowCount <= 1) goto L7;
        return false;
    L7:
        return true;
    }

    private SolverVariable pickPivotInVariables(boolean[] r110, SolverVariable r111) {
        int r100 = this.variables.getCurrentSize();
        SolverVariable r101 = null;
        int r102 = 0;
        float r103 = 0.0f;
    L3:
        if (r102 >= r100) goto L19;
        float r104 = this.variables.getVariableValue(r102);
        if (r104 >= 0.0f) goto L18;
        SolverVariable r105 = this.variables.getVariable(r102);
        if (r110 != null) goto L9;
    L10:
        if (r105 == r111) goto L18;
        SolverVariable.Type r106 = r105.mType;
        if (r106 == SolverVariable.Type.SLACK) goto L16;
        if (r106 != SolverVariable.Type.ERROR) goto L18;
    L16:
        if (r104 >= r103) goto L18;
        r103 = r104;
        r101 = r105;
        goto L18
    L9:
        if (r110[r105.f15332id] == false) goto L10;
    L18:
        r102 = r102 + 1;
        goto L3
    L19:
        return r101;
    }

    public ArrayRow addError(LinearSystem r100, int r101) {
        this.variables.put(r100.createErrorVariable(r101, "ep"), 1.0f);
        this.variables.put(r100.createErrorVariable(r101, "em"), -1.0f);
        return this;
    }

    public ArrayRow addSingleError(SolverVariable r100, int r101) {
        this.variables.put(r100, r101);
        return this;
    }

    public ArrayRow createRowDefinition(SolverVariable r100, int r101) {
        this.variable = r100;
        float r102 = r101;
        r100.computedValue = r102;
        this.constantValue = r102;
        this.isSimpleDefinition = true;
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable r100, int r101) {
        if (r101 >= 0) goto L4;
        this.constantValue = r101 * (-1);
        this.variables.put(r100, 1.0f);
    L5:
        return this;
    L4:
        this.constantValue = r101;
        this.variables.put(r100, -1.0f);
        goto L5
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem r100, boolean[] r101) {
        return pickPivotInVariables(r101, null);
    }

    public ArrayRow createRowDimensionPercent(SolverVariable r100, SolverVariable r101, float r102) {
        this.variables.put(r100, -1.0f);
        this.variables.put(r101, r102);
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable r100, SolverVariable r101, int r102) {
        boolean r103 = false;
        if (r102 == 0) goto L8;
        if (r102 >= 0) goto L6;
        r102 = r102 * (-1);
        r103 = true;
    L6:
        this.constantValue = r102;
    L8:
        if (r103 == true) goto L10;
        this.variables.put(r100, -1.0f);
        this.variables.put(r101, 1.0f);
    L11:
        return this;
    L10:
        this.variables.put(r100, 1.0f);
        this.variables.put(r101, -1.0f);
        goto L11
    }

    public ArrayRow createRowGreaterThan(SolverVariable r100, int r101, SolverVariable r102) {
        this.constantValue = r101;
        this.variables.put(r100, -1.0f);
        return this;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem r100, SolverVariable r101, boolean r102) {
        if (r101.isFinalValue == true) goto L5;
        return;
    L5:
        this.constantValue += r101.computedValue * this.variables.get(r101);
        this.variables.remove(r101, r102);
        if (r102 == false) goto L9;
        r101.removeFromRow(this);
    L9:
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L11;
        return;
    L11:
        if (this.variables.getCurrentSize() != 0) goto L15;
        this.isSimpleDefinition = true;
        r100.hasSimpleDefinition = true;
        return;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(LinearSystem r100, ArrayRow r101, boolean r102) {
        this.constantValue += r101.constantValue * this.variables.use(r101, r102);
        if (r102 == false) goto L6;
        r101.variable.removeFromRow(this);
    L6:
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L8;
        return;
    L8:
        if (this.variable != null) goto L10;
        return;
    L10:
        if (this.variables.getCurrentSize() != 0) goto L15;
        this.isSimpleDefinition = true;
        r100.hasSimpleDefinition = true;
        return;
    }

    public void updateFromSynonymVariable(LinearSystem r100, SolverVariable r101, boolean r102) {
        if (r101.isSynonym == true) goto L5;
        return;
    L5:
        float r103 = this.variables.get(r101);
        this.constantValue += r101.synonymDelta * r103;
        this.variables.remove(r101, r102);
        if (r102 == false) goto L8;
        r101.removeFromRow(this);
    L8:
        this.variables.add(r100.mCache.mIndexedVariables[r101.synonym], r103, r102);
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L11;
        return;
    L11:
        if (this.variables.getCurrentSize() != 0) goto L15;
        this.isSimpleDefinition = true;
        r100.hasSimpleDefinition = true;
        return;
    }

    public ArrayRow createRowGreaterThan(SolverVariable r100, SolverVariable r101, SolverVariable r102, int r103) {
        boolean r104 = false;
        if (r103 == 0) goto L8;
        if (r103 >= 0) goto L6;
        r103 = r103 * (-1);
        r104 = true;
    L6:
        this.constantValue = r103;
    L8:
        if (r104 == true) goto L10;
        this.variables.put(r100, -1.0f);
        this.variables.put(r101, 1.0f);
        this.variables.put(r102, 1.0f);
    L11:
        return this;
    L10:
        this.variables.put(r100, 1.0f);
        this.variables.put(r101, -1.0f);
        this.variables.put(r102, -1.0f);
        goto L11
    }

    public ArrayRow createRowLowerThan(SolverVariable r100, SolverVariable r101, SolverVariable r102, int r103) {
        boolean r104 = false;
        if (r103 == 0) goto L8;
        if (r103 >= 0) goto L6;
        r103 = r103 * (-1);
        r104 = true;
    L6:
        this.constantValue = r103;
    L8:
        if (r104 == true) goto L10;
        this.variables.put(r100, -1.0f);
        this.variables.put(r101, 1.0f);
        this.variables.put(r102, -1.0f);
    L11:
        return this;
    L10:
        this.variables.put(r100, 1.0f);
        this.variables.put(r101, -1.0f);
        this.variables.put(r102, 1.0f);
        goto L11
    }

    public ArrayRow createRowDimensionRatio(SolverVariable r100, SolverVariable r101, SolverVariable r102, SolverVariable r103, float r104) {
        this.variables.put(r100, -1.0f);
        this.variables.put(r101, 1.0f);
        this.variables.put(r102, r104);
        this.variables.put(r103, -r104);
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable r100, SolverVariable r101, SolverVariable r102, SolverVariable r103, float r104) {
        this.variables.put(r102, 0.5f);
        this.variables.put(r103, 0.5f);
        this.variables.put(r100, -0.5f);
        this.variables.put(r101, -0.5f);
        this.constantValue = -r104;
        return this;
    }

    public ArrayRow createRowCentering(SolverVariable r100, SolverVariable r101, int r102, float r103, SolverVariable r110, SolverVariable r111, int r112) {
        if (r101 != r110) goto L7;
        this.variables.put(r100, 1.0f);
        this.variables.put(r111, 1.0f);
        this.variables.put(r101, -2.0f);
        return this;
    L7:
        if (r103 != 0.5f) goto L13;
        this.variables.put(r100, 1.0f);
        this.variables.put(r101, -1.0f);
        this.variables.put(r110, -1.0f);
        this.variables.put(r111, 1.0f);
        if (r102 > 0) goto L11;
        if (r112 > 0) goto L11;
    L22:
        return this;
    L11:
        this.constantValue = (-r102) + r112;
        goto L22
    L13:
        if (r103 > 0.0f) goto L16;
        this.variables.put(r100, -1.0f);
        this.variables.put(r101, 1.0f);
        this.constantValue = r102;
        goto L22
    L16:
        if (r103 < 1.0f) goto L18;
        this.variables.put(r111, -1.0f);
        this.variables.put(r110, 1.0f);
        this.constantValue = -r112;
        goto L22
    L18:
        float r104 = 1.0f - r103;
        this.variables.put(r100, r104 * 1.0f);
        this.variables.put(r101, r104 * (-1.0f));
        this.variables.put(r110, (-1.0f) * r103);
        this.variables.put(r111, 1.0f * r103);
        if (r102 > 0) goto L21;
        if (r112 <= 0) goto L22;
    L21:
        this.constantValue = ((-r102) * r104) + (r112 * r103);
        goto L22
    }

    public ArrayRow createRowEqualMatchDimensions(float r100, float r101, float r102, SolverVariable r103, SolverVariable r104, SolverVariable r110, SolverVariable r111) {
        this.constantValue = 0.0f;
        if (r101 != 0.0f) goto L5;
    L14:
        this.variables.put(r103, 1.0f);
        this.variables.put(r104, -1.0f);
        this.variables.put(r111, 1.0f);
        this.variables.put(r110, -1.0f);
    L15:
        return this;
    L5:
        if (r100 == r102) goto L14;
        if (r100 != 0.0f) goto L11;
        this.variables.put(r103, 1.0f);
        this.variables.put(r104, -1.0f);
        goto L15
    L11:
        if (r102 != 0.0f) goto L13;
        this.variables.put(r110, 1.0f);
        this.variables.put(r111, -1.0f);
        goto L15
    L13:
        float r105 = (r100 / r101) / (r102 / r101);
        this.variables.put(r103, 1.0f);
        this.variables.put(r104, -1.0f);
        this.variables.put(r111, r105);
        this.variables.put(r110, -r105);
        goto L15
    }

    public ArrayRow createRowEqualDimension(float r100, float r101, float r102, SolverVariable r103, int r104, SolverVariable r105, int r110, SolverVariable r111, int r112, SolverVariable r113, int r114) {
        if (r101 != 0.0f) goto L5;
    L8:
        this.constantValue = (((-r104) - r110) + r112) + r114;
        this.variables.put(r103, 1.0f);
        this.variables.put(r105, -1.0f);
        this.variables.put(r113, 1.0f);
        this.variables.put(r111, -1.0f);
    L9:
        return this;
    L5:
        if (r100 == r102) goto L8;
        float r106 = (r100 / r101) / (r102 / r101);
        this.constantValue = (((-r104) - r110) + (r112 * r106)) + (r114 * r106);
        this.variables.put(r103, 1.0f);
        this.variables.put(r105, -1.0f);
        this.variables.put(r113, r106);
        this.variables.put(r111, -r106);
        goto L9
    }
}
