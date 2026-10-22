package com.obric.oui.constraintlayout.core;

import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    private static final boolean DO_NOT_USE = false;
    public static final boolean FULL_DEBUG = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    public boolean graphOptimizer;
    public boolean hasSimpleDefinition;
    private boolean[] mAlreadyTestedCandidates;
    final Cache mCache;
    private Row mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    int mNumColumns;
    int mNumRows;
    private int mPoolSize;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    ArrayRow[] mRows;
    private int mTableSize;
    private Row mTempGoal;
    private HashMap<String, SolverVariable> mVariables;
    int mVariablesID;
    public boolean newgraphOptimizer;

    interface Row {
        void addError(SolverVariable r1);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem r1, boolean[] r2);

        void initFromRow(Row r1);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem r1, SolverVariable r2, boolean r3);

        void updateFromRow(LinearSystem r1, ArrayRow r2, boolean r3);

        void updateFromSystem(LinearSystem r1);
    }

    static class ValuesRow extends ArrayRow {
        ValuesRow(Cache r2) {
            this.variables = new SolverVariableValues(this, r2);
        }
    }

    static {
    }

    private String getDisplayStrength(int r1) {
        if (r1 != 1) goto L7;
        return "LOW";
    L7:
        if (r1 != 2) goto L11;
        return "MEDIUM";
    L11:
        if (r1 != 3) goto L15;
        return "HIGH";
    L15:
        if (r1 != 4) goto L19;
        return "HIGHEST";
    L19:
        if (r1 != 5) goto L23;
        return "EQUALITY";
    L23:
        if (r1 != 8) goto L27;
        return "FIXED";
    L27:
        if (r1 != 6) goto L30;
        return "BARRIER";
    L30:
        return "NONE";
    }

    public LinearSystem() {
        this.mPoolSize = 1000;
        this.hasSimpleDefinition = false;
        this.mVariablesID = 0;
        this.mVariables = null;
        this.mTableSize = 32;
        this.mMaxColumns = 32;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[32];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = 32;
        this.mPoolVariables = new SolverVariable[1000];
        this.mPoolVariablesCount = 0;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache r0 = new Cache();
        this.mCache = r0;
        this.mGoal = new PriorityGoalRow(r0);
        if (OPTIMIZED_ENGINE == false) goto L5;
        this.mTempGoal = new ValuesRow(r0);
        return;
    L5:
        this.mTempGoal = new ArrayRow(r0);
    }

    public void fillMetrics(Metrics r1) {
        sMetrics = r1;
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int r0 = this.mTableSize * 2;
        this.mTableSize = r0;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, r0);
        Cache r1 = this.mCache;
        r1.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(r1.mIndexedVariables, this.mTableSize);
        int r2 = this.mTableSize;
        this.mAlreadyTestedCandidates = new boolean[r2];
        this.mMaxColumns = r2;
        this.mMaxRows = r2;
        Metrics r3 = sMetrics;
        if (r3 == null) goto L6;
        r3.tableSizeIncrease++;
        Metrics r4 = sMetrics;
        r4.maxTableSize = Math.max(r4.maxTableSize, this.mTableSize);
        Metrics r5 = sMetrics;
        r5.lastTableSize = r5.maxTableSize;
        return;
    }

    private void releaseRows() {
        int r2 = 0;
        if (OPTIMIZED_ENGINE == false) goto L11;
    L5:
        if (r2 >= this.mNumRows) goto L16;
        ArrayRow r0 = this.mRows[r2];
        if (r0 == null) goto L9;
        this.mCache.mOptimizedArrayRowPool.release(r0);
    L9:
        this.mRows[r2] = null;
        r2 = r2 + 1;
        goto L5
    L16:
        return;
    L11:
        if (r2 >= this.mNumRows) goto L23;
        ArrayRow r1 = this.mRows[r2];
        if (r1 == null) goto L15;
        this.mCache.mArrayRowPool.release(r1);
    L15:
        this.mRows[r2] = null;
        r2 = r2 + 1;
        goto L11
    }

    public void reset() {
        int r1 = 0;
    L4:
        if (r1 >= this.mCache.mIndexedVariables.length) goto L9;
        SolverVariable r2 = this.mCache.mIndexedVariables[r1];
        if (r2 == null) goto L8;
        r2.reset();
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        this.mCache.mSolverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, null);
        HashMap<String, SolverVariable> r3 = this.mVariables;
        if (r3 == null) goto L12;
        r3.clear();
    L12:
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        int r4 = 0;
    L14:
        if (r4 >= this.mNumRows) goto L19;
        ArrayRow r5 = this.mRows[r4];
        if (r5 == null) goto L18;
        r5.mUsed = false;
    L18:
        r4 = r4 + 1;
        goto L14
    L19:
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE == false) goto L22;
        this.mTempGoal = new ValuesRow(this.mCache);
        return;
    L22:
        this.mTempGoal = new ArrayRow(this.mCache);
    }

    public SolverVariable createObjectVariable(Object r4) {
        SolverVariable r0 = null;
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L9;
        increaseTableSize();
    L9:
        if ((r4 instanceof ConstraintAnchor) == false) goto L23;
        ConstraintAnchor r5 = (ConstraintAnchor) r4;
        r0 = r5.getSolverVariable();
        if (r0 != null) goto L14;
        r5.resetSolverVariable(this.mCache);
        r0 = r5.getSolverVariable();
    L14:
        if (r0.id == (-1)) goto L20;
        if (r0.id > this.mVariablesID) goto L20;
        if (this.mCache.mIndexedVariables[r0.id] != null) goto L23;
    L20:
        if (r0.id == (-1)) goto L22;
        r0.reset();
    L22:
        int r6 = this.mVariablesID + 1;
        this.mVariablesID = r6;
        this.mNumColumns++;
        r0.id = r6;
        r0.mType = SolverVariable.Type.UNRESTRICTED;
        this.mCache.mIndexedVariables[this.mVariablesID] = r0;
    L23:
        return r0;
    }

    public ArrayRow createRow() {
        if (OPTIMIZED_ENGINE == false) goto L8;
        ArrayRow r0 = this.mCache.mOptimizedArrayRowPool.acquire();
        if (r0 != null) goto L7;
        r0 = new ValuesRow(this.mCache);
        OPTIMIZED_ARRAY_ROW_CREATION++;
    L12:
        SolverVariable.increaseErrorId();
        return r0;
    L7:
        r0.reset();
        goto L12
    L8:
        r0 = this.mCache.mArrayRowPool.acquire();
        if (r0 != null) goto L11;
        r0 = new ArrayRow(this.mCache);
        ARRAY_ROW_CREATION++;
        goto L12
    L11:
        r0.reset();
        goto L12
    }

    public SolverVariable createSlackVariable() {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L6;
        r0.slackvariables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r1 = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int r2 = this.mVariablesID + 1;
        this.mVariablesID = r2;
        this.mNumColumns++;
        r1.id = r2;
        this.mCache.mIndexedVariables[this.mVariablesID] = r1;
        return r1;
    }

    public SolverVariable createExtraVariable() {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L6;
        r0.extravariables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r1 = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int r2 = this.mVariablesID + 1;
        this.mVariablesID = r2;
        this.mNumColumns++;
        r1.id = r2;
        this.mCache.mIndexedVariables[this.mVariablesID] = r1;
        return r1;
    }

    void addSingleError(ArrayRow r2, int r3, int r4) {
        r2.addSingleError(createErrorVariable(r4, null), r3);
    }

    private SolverVariable createVariable(String r6, SolverVariable.Type r7) {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L6;
        r0.variables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r8 = acquireSolverVariable(r7, null);
        r8.setName(r6);
        int r1 = this.mVariablesID + 1;
        this.mVariablesID = r1;
        this.mNumColumns++;
        r8.id = r1;
        if (this.mVariables != null) goto L11;
        this.mVariables = new HashMap();
    L11:
        this.mVariables.put(r6, r8);
        this.mCache.mIndexedVariables[this.mVariablesID] = r8;
        return r8;
    }

    public SolverVariable createErrorVariable(int r6, String r7) {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L6;
        r0.errors++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r8 = acquireSolverVariable(SolverVariable.Type.ERROR, r7);
        int r1 = this.mVariablesID + 1;
        this.mVariablesID = r1;
        this.mNumColumns++;
        r8.id = r1;
        r8.strength = r6;
        this.mCache.mIndexedVariables[this.mVariablesID] = r8;
        this.mGoal.addError(r8);
        return r8;
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type r3, String r4) {
        SolverVariable r0 = this.mCache.mSolverVariablePool.acquire();
        if (r0 != null) goto L5;
        r0 = new SolverVariable(r3, r4);
        r0.setType(r3, r4);
    L6:
        int r5 = this.mPoolVariablesCount;
        int r6 = this.mPoolSize;
        if (r5 < r6) goto L9;
        int r7 = r6 * 2;
        this.mPoolSize = r7;
        this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, r7);
    L9:
        SolverVariable[] r8 = this.mPoolVariables;
        int r9 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = r9 + 1;
        r8[r9] = r0;
        return r0;
    L5:
        r0.reset();
        r0.setType(r3, r4);
        goto L6
    }

    Row getGoal() {
        return this.mGoal;
    }

    ArrayRow getRow(int r1) {
        return this.mRows[r1];
    }

    float getValueFor(String r2) {
        SolverVariable r1 = getVariable(r2, SolverVariable.Type.UNRESTRICTED);
        if (r1 != null) goto L7;
        return 0.0f;
    L7:
        return r1.computedValue;
    }

    public int getObjectVariableValue(Object r1) {
        SolverVariable r0 = ((ConstraintAnchor) r1).getSolverVariable();
        if (r0 != null) goto L5;
        return 0;
    L5:
        return (int) (r0.computedValue + 0.5f);
    }

    SolverVariable getVariable(String r2, SolverVariable.Type r3) {
        if (this.mVariables != null) goto L5;
        this.mVariables = new HashMap();
    L5:
        SolverVariable r0 = this.mVariables.get(r2);
        if (r0 == null) goto L8;
        return r0;
    L8:
        return createVariable(r2, r3);
    }

    public void minimize() throws Exception {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L6;
        r0.minimize++;
    L6:
        if (this.mGoal.isEmpty() == false) goto L10;
        computeValues();
        return;
    L10:
        if (this.graphOptimizer == false) goto L12;
    L15:
        Metrics r1 = sMetrics;
        if (r1 == null) goto L18;
        r1.graphOptimizer++;
    L18:
        boolean r2 = false;
        int r3 = 0;
    L20:
        if (r3 >= this.mNumRows) goto L25;
        if (this.mRows[r3].mIsSimpleDefinition == false) goto L26;
        r3 = r3 + 1;
    L26:
        if (r2 == true) goto L28;
        minimizeGoal(this.mGoal);
        return;
    L28:
        Metrics r4 = sMetrics;
        if (r4 == null) goto L31;
        r4.fullySolved++;
    L31:
        computeValues();
        return;
    L25:
        r2 = true;
        goto L26
    L12:
        if (this.newgraphOptimizer == true) goto L15;
        minimizeGoal(this.mGoal);
    }

    void minimizeGoal(Row r6) throws Exception {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L5;
        r0.minimizeGoal++;
        Metrics r1 = sMetrics;
        r1.maxVariables = Math.max(r1.maxVariables, this.mNumColumns);
        Metrics r2 = sMetrics;
        r2.maxRows = Math.max(r2.maxRows, this.mNumRows);
    L5:
        enforceBFS(r6);
        optimize(r6, false);
        computeValues();
    }

    final void cleanupRows() {
        int r0 = 0;
    L4:
        if (r0 >= this.mNumRows) goto L19;
        ArrayRow r1 = this.mRows[r0];
        if (r1.variables.getCurrentSize() != 0) goto L9;
        r1.mIsSimpleDefinition = true;
    L9:
        if (r1.mIsSimpleDefinition == false) goto L18;
        r1.mVariable.computedValue = r1.mConstantValue;
        r1.mVariable.removeFromRow(r1);
        int r2 = r0;
    L11:
        int r4 = this.mNumRows;
        if (r2 >= (r4 - 1)) goto L14;
        ArrayRow[] r5 = this.mRows;
        int r6 = r2 + 1;
        r5[r2] = r5[r6];
        r2 = r6;
        goto L11
    L14:
        this.mRows[r4 - 1] = null;
        this.mNumRows = r4 - 1;
        r0 = r0 - 1;
        if (OPTIMIZED_ENGINE == false) goto L17;
        this.mCache.mOptimizedArrayRowPool.release(r1);
        goto L18
    L17:
        this.mCache.mArrayRowPool.release(r1);
    L18:
        r0 = r0 + 1;
        goto L4
    }

    public void addConstraint(ArrayRow r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Metrics r0 = sMetrics;
        if (r0 == null) goto L9;
        r0.constraints++;
        if (r8.mIsSimpleDefinition == false) goto L9;
        sMetrics.simpleconstraints++;
    L9:
        boolean r3 = true;
        if ((this.mNumRows + 1) < this.mMaxRows) goto L12;
    L13:
        increaseTableSize();
    L14:
        boolean r4 = false;
        if (r8.mIsSimpleDefinition == true) goto L46;
        r8.updateFromSystem(this);
        if (r8.isEmpty() == false) goto L19;
        return;
    L19:
        r8.ensurePositiveConstant();
        if (r8.chooseSubject(this) == false) goto L41;
        SolverVariable r1 = createExtraVariable();
        r8.mVariable = r1;
        int r5 = this.mNumRows;
        addRow(r8);
        if (this.mNumRows != (r5 + 1)) goto L41;
        this.mTempGoal.initFromRow(r8);
        optimize(this.mTempGoal, true);
        if (r1.mDefinitionId != (-1)) goto L43;
        if (r8.mVariable != r1) goto L34;
        SolverVariable r2 = r8.pickPivot(r1);
        if (r2 == null) goto L34;
        Metrics r6 = sMetrics;
        if (r6 == null) goto L32;
        r6.pivots++;
    L32:
        r8.pivot(r2);
    L34:
        if (r8.mIsSimpleDefinition == true) goto L37;
        r8.mVariable.updateReferencesWithNewDefinition(this, r8);
    L37:
        if (OPTIMIZED_ENGINE == false) goto L39;
        this.mCache.mOptimizedArrayRowPool.release(r8);
    L40:
        this.mNumRows--;
        goto L43
    L39:
        this.mCache.mArrayRowPool.release(r8);
    L43:
        if (r8.hasKeyVariable() == true) goto L45;
        return;
    L45:
        r4 = r3;
    L41:
        r3 = false;
    L46:
        if (r4 == true) goto L49;
        addRow(r8);
        return;
    L49:
        return;
    L12:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L14;
        goto L13
    }

    private void addRow(ArrayRow r8) {
        if (SIMPLIFY_SYNONYMS == true) goto L5;
    L7:
        this.mRows[this.mNumRows] = r8;
        r8.mVariable.mDefinitionId = this.mNumRows;
        this.mNumRows++;
        r8.mVariable.updateReferencesWithNewDefinition(this, r8);
    L9:
        if (SIMPLIFY_SYNONYMS == true) goto L11;
        return;
    L11:
        if (this.hasSimpleDefinition == false) goto L47;
        int r0 = 0;
    L14:
        if (r0 >= this.mNumRows) goto L37;
        if (this.mRows[r0] != null) goto L18;
        System.out.println("WTF");
    L18:
        ArrayRow r1 = this.mRows[r0];
        if (r1 == null) goto L36;
        if (r1.mIsSimpleDefinition == false) goto L36;
        ArrayRow r2 = this.mRows[r0];
        r2.mVariable.setFinalValue(this, r2.mConstantValue);
        if (OPTIMIZED_ENGINE == false) goto L25;
        this.mCache.mOptimizedArrayRowPool.release(r2);
    L26:
        this.mRows[r0] = null;
        int r3 = r0 + 1;
        int r4 = r3;
    L27:
        int r5 = this.mNumRows;
        if (r3 >= r5) goto L33;
        ArrayRow[] r6 = this.mRows;
        int r7 = r3 - 1;
        ArrayRow r9 = r6[r3];
        r6[r7] = r9;
        if (r9.mVariable.mDefinitionId != r3) goto L32;
        this.mRows[r7].mVariable.mDefinitionId = r7;
    L32:
        r4 = r3;
        r3 = r3 + 1;
        goto L27
    L33:
        if (r4 >= r5) goto L35;
        this.mRows[r4] = null;
    L35:
        this.mNumRows = r5 - 1;
        r0 = r0 - 1;
        goto L36
    L25:
        this.mCache.mArrayRowPool.release(r2);
    L36:
        r0 = r0 + 1;
        goto L14
    L37:
        this.hasSimpleDefinition = false;
        return;
    L47:
        return;
    L5:
        if (r8.mIsSimpleDefinition == false) goto L7;
        r8.mVariable.setFinalValue(this, r8.mConstantValue);
        goto L9
    }

    public void removeRow(ArrayRow r5) {
        if (r5.mIsSimpleDefinition == true) goto L5;
        return;
    L5:
        if (r5.mVariable != null) goto L7;
        return;
    L7:
        if (r5.mVariable.mDefinitionId == (-1)) goto L17;
        int r0 = r5.mVariable.mDefinitionId;
    L9:
        int r1 = this.mNumRows;
        if (r0 >= (r1 - 1)) goto L15;
        int r2 = r0 + 1;
        SolverVariable r3 = this.mRows[r2].mVariable;
        if (r3.mDefinitionId != r2) goto L14;
        r3.mDefinitionId = r0;
    L14:
        ArrayRow[] r4 = this.mRows;
        r4[r0] = r4[r2];
        r0 = r2;
        goto L9
    L15:
        this.mNumRows = r1 - 1;
    L17:
        if (r5.mVariable.isFinalValue == true) goto L20;
        r5.mVariable.setFinalValue(this, r5.mConstantValue);
    L20:
        if (OPTIMIZED_ENGINE == false) goto L22;
        this.mCache.mOptimizedArrayRowPool.release(r5);
        return;
    L22:
        this.mCache.mArrayRowPool.release(r5);
    }

    private int optimize(Row r13, boolean r14) {
        Metrics r15 = sMetrics;
        if (r15 == null) goto L5;
        r15.optimize++;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= this.mNumColumns) goto L9;
        this.mAlreadyTestedCandidates[r2] = false;
        r2 = r2 + 1;
        goto L7
    L9:
        boolean r3 = false;
        int r4 = 0;
    L10:
        if (r3 == true) goto L50;
        Metrics r5 = sMetrics;
        if (r5 == null) goto L14;
        r5.iterations++;
    L14:
        r4 = r4 + 1;
        if (r4 >= (this.mNumColumns * 2)) goto L16;
        if (r13.getKey() == null) goto L20;
        this.mAlreadyTestedCandidates[r13.getKey().id] = true;
    L20:
        SolverVariable r6 = r13.getPivotCandidate(this, this.mAlreadyTestedCandidates);
        if (r6 != null) goto L23;
    L26:
        if (r6 != null) goto L27;
        r3 = true;
        goto L10
    L27:
        float r7 = Float.MAX_VALUE;
        int r8 = 0;
        int r9 = -1;
    L29:
        if (r8 >= this.mNumRows) goto L44;
        ArrayRow r10 = this.mRows[r8];
        if (r10.mVariable.mType == SolverVariable.Type.UNRESTRICTED) goto L43;
        if (r10.mIsSimpleDefinition == true) goto L43;
        if (r10.hasVariable(r6) == false) goto L43;
        float r11 = r10.variables.get(r6);
        if (r11 >= 0.0f) goto L43;
        float r12 = (-r10.mConstantValue) / r11;
        if (r12 >= r7) goto L43;
        r9 = r8;
        r7 = r12;
    L43:
        r8 = r8 + 1;
        goto L29
    L44:
        if (r9 <= (-1)) goto L10;
        ArrayRow r16 = this.mRows[r9];
        r16.mVariable.mDefinitionId = -1;
        Metrics r17 = sMetrics;
        if (r17 == null) goto L48;
        r17.pivots++;
    L48:
        r16.pivot(r6);
        r16.mVariable.mDefinitionId = r9;
        r16.mVariable.updateReferencesWithNewDefinition(this, r16);
        goto L10
    L23:
        if (this.mAlreadyTestedCandidates[r6.id] == true) goto L24;
        this.mAlreadyTestedCandidates[r6.id] = true;
        goto L26
    L24:
        return r4;
    L16:
        return r4;
    L50:
        return r4;
    }

    private int enforceBFS(Row r20) throws Exception {
        int r2 = 0;
    L4:
        if (r2 >= this.mNumRows) goto L12;
        if (this.mRows[r2].mVariable.mType == SolverVariable.Type.UNRESTRICTED) goto L11;
        if (this.mRows[r2].mConstantValue >= 0.0f) goto L11;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L73;
        boolean r4 = false;
        int r5 = 0;
    L15:
        if (r4 == true) goto L98;
        Metrics r6 = sMetrics;
        if (r6 == null) goto L19;
        r6.bfs++;
    L19:
        r5 = r5 + 1;
        float r9 = Float.MAX_VALUE;
        int r10 = 0;
        int r11 = -1;
        int r12 = -1;
        int r13 = 0;
    L21:
        if (r10 >= this.mNumRows) goto L63;
        ArrayRow r14 = this.mRows[r10];
        if (r14.mVariable.mType == SolverVariable.Type.UNRESTRICTED) goto L61;
        if (r14.mIsSimpleDefinition == true) goto L61;
        if (r14.mConstantValue >= 0.0f) goto L61;
        int r15 = 9;
        if (SKIP_COLUMNS == false) goto L46;
        int r1 = r14.variables.getCurrentSize();
        int r7 = 0;
    L33:
        if (r7 >= r1) goto L61;
        SolverVariable r8 = r14.variables.getVariable(r7);
        float r16 = r14.variables.get(r8);
        if (r16 <= 0.0f) goto L45;
        int r17 = 0;
    L38:
        if (r17 >= r15) goto L45;
        float r18 = r8.mStrengthVector[r17] / r16;
        if (r18 >= r9) goto L42;
        if (r17 != r13) goto L42;
    L43:
        r12 = r8.id;
        r13 = r17;
        r11 = r10;
        r9 = r18;
    L44:
        r17 = r17 + 1;
        r15 = 9;
    L42:
        if (r17 <= r13) goto L44;
    L45:
        r7 = r7 + 1;
        r15 = 9;
        goto L33
    L46:
        int r19 = 1;
    L48:
        if (r19 >= this.mNumColumns) goto L61;
        SolverVariable r21 = this.mCache.mIndexedVariables[r19];
        float r22 = r14.variables.get(r21);
        if (r22 <= 0.0f) goto L60;
        int r23 = 0;
    L53:
        if (r23 >= 9) goto L60;
        float r110 = r21.mStrengthVector[r23] / r22;
        if (r110 >= r9) goto L57;
        if (r23 != r13) goto L57;
    L58:
        r12 = r19;
        r13 = r23;
        r11 = r10;
        r9 = r110;
    L59:
        r23 = r23 + 1;
    L57:
        if (r23 <= r13) goto L59;
    L60:
        r19 = r19 + 1;
    L61:
        r10 = r10 + 1;
        goto L21
    L63:
        if (r11 == (-1)) goto L68;
        ArrayRow r24 = this.mRows[r11];
        r24.mVariable.mDefinitionId = -1;
        Metrics r25 = sMetrics;
        if (r25 == null) goto L67;
        r25.pivots++;
    L67:
        r24.pivot(this.mCache.mIndexedVariables[r12]);
        r24.mVariable.mDefinitionId = r11;
        r24.mVariable.updateReferencesWithNewDefinition(this, r24);
    L70:
        if (r5 <= (this.mNumColumns / 2)) goto L15;
        r4 = true;
        goto L15
    L68:
        r4 = true;
        goto L70
    L98:
        return r5;
    L73:
        return 0;
    L11:
        r2 = r2 + 1;
        goto L4
    L12:
        r3 = false;
        goto L13
    }

    private void computeValues() {
        int r0 = 0;
    L4:
        if (r0 >= this.mNumRows) goto L6;
        ArrayRow r1 = this.mRows[r0];
        SolverVariable r2 = r1.mVariable;
        r2.computedValue = r1.mConstantValue;
        r0 = r0 + 1;
        goto L4
    }

    private void displayRows() {
        displaySolverVariables();
        String r0 = "";
        int r1 = 0;
    L4:
        if (r1 >= this.mNumRows) goto L6;
        r0 = (r0 + this.mRows[r1]) + "\n";
        r1 = r1 + 1;
        goto L4
    L6:
        System.out.println(r0 + this.mGoal + "\n");
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String r0 = " num vars " + this.mVariablesID + "\n";
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= (this.mVariablesID + 1)) goto L11;
        SolverVariable r4 = this.mCache.mIndexedVariables[r3];
        if (r4 == null) goto L10;
        if (r4.isFinalValue == false) goto L10;
        r0 = r0 + " $[" + r3 + "] => " + r4 + " = " + r4.computedValue + "\n";
    L10:
        r3 = r3 + 1;
        goto L4
    L11:
        String r1 = r0 + "\n";
        int r5 = 0;
    L13:
        if (r5 >= (this.mVariablesID + 1)) goto L20;
        SolverVariable r6 = this.mCache.mIndexedVariables[r5];
        if (r6 == null) goto L19;
        if (r6.mIsSynonym == false) goto L19;
        r1 = r1 + " ~[" + r5 + "] => " + r6 + " = " + this.mCache.mIndexedVariables[r6.mSynonym] + " + " + r6.mSynonymDelta + "\n";
    L19:
        r5 = r5 + 1;
        goto L13
    L20:
        String r7 = r1 + "\n\n #  ";
    L22:
        if (r2 >= this.mNumRows) goto L25;
        r7 = (r7 + this.mRows[r2].toReadableString()) + "\n #  ";
        r2 = r2 + 1;
        goto L22
    L25:
        if (this.mGoal == null) goto L27;
        r7 = r7 + "Goal: " + this.mGoal + "\n";
    L27:
        System.out.println(r7);
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String r0 = "";
        int r1 = 0;
    L4:
        if (r1 >= this.mNumRows) goto L9;
        if (this.mRows[r1].mVariable.mType != SolverVariable.Type.UNRESTRICTED) goto L8;
        r0 = (r0 + this.mRows[r1].toReadableString()) + "\n";
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        System.out.println(r0 + this.mGoal + "\n");
    }

    public int getMemoryUsed() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this.mNumRows) goto L9;
        ArrayRow r2 = this.mRows[r0];
        if (r2 == null) goto L8;
        r1 = r1 + r2.sizeInBytes();
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r1;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    void displaySystemInformation() {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= this.mTableSize) goto L9;
        ArrayRow r3 = this.mRows[r1];
        if (r3 == null) goto L8;
        r2 = r2 + r3.sizeInBytes();
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        int r4 = 0;
        int r5 = 0;
    L11:
        if (r4 >= this.mNumRows) goto L16;
        ArrayRow r6 = this.mRows[r4];
        if (r6 == null) goto L15;
        r5 = r5 + r6.sizeInBytes();
    L15:
        r4 = r4 + 1;
        goto L11
    L16:
        PrintStream r7 = System.out;
        StringBuilder r8 = new StringBuilder("Linear System -> Table size: ").append(this.mTableSize).append(" (");
        int r9 = this.mTableSize;
        r7.println(r8.append(getDisplaySize(r9 * r9)).append(") -- row sizes: ").append(getDisplaySize(r2)).append(", actual size: ").append(getDisplaySize(r5)).append(" rows: ").append(this.mNumRows).append(LibrarianImpl.Constants.SEPARATOR).append(this.mMaxRows).append(" cols: ").append(this.mNumColumns).append(LibrarianImpl.Constants.SEPARATOR).append(this.mMaxColumns).append(" 0 occupied cells, ").append(getDisplaySize(0)).toString());
    }

    private void displaySolverVariables() {
        System.out.println("Display Rows (" + this.mNumRows + MaterialConfigFormatNames.X + this.mNumColumns + ")\n");
    }

    private String getDisplaySize(int r3) {
        int r4 = r3 * 4;
        int r2 = r4 / 1024;
        int r0 = r2 / 1024;
        if (r0 > 0) goto L5;
        if (r2 <= 0) goto L10;
        return "" + r2 + " Kb";
    L10:
        return "" + r4 + " bytes";
    L5:
        return "" + r0 + " Mb";
    }

    public Cache getCache() {
        return this.mCache;
    }

    public void addGreaterThan(SolverVariable r4, SolverVariable r5, int r6, int r7) {
        ArrayRow r0 = createRow();
        SolverVariable r1 = createSlackVariable();
        r1.strength = 0;
        r0.createRowGreaterThan(r4, r5, r1, r6);
        if (r7 == 8) goto L5;
        addSingleError(r0, (int) (r0.variables.get(r1) * (-1.0f)), r7);
    L5:
        addConstraint(r0);
    }

    public void addGreaterBarrier(SolverVariable r3, SolverVariable r4, int r5, boolean r6) {
        ArrayRow r7 = createRow();
        SolverVariable r0 = createSlackVariable();
        r0.strength = 0;
        r7.createRowGreaterThan(r3, r4, r0, r5);
        addConstraint(r7);
    }

    public void addLowerThan(SolverVariable r4, SolverVariable r5, int r6, int r7) {
        ArrayRow r0 = createRow();
        SolverVariable r1 = createSlackVariable();
        r1.strength = 0;
        r0.createRowLowerThan(r4, r5, r1, r6);
        if (r7 == 8) goto L5;
        addSingleError(r0, (int) (r0.variables.get(r1) * (-1.0f)), r7);
    L5:
        addConstraint(r0);
    }

    public void addLowerBarrier(SolverVariable r3, SolverVariable r4, int r5, boolean r6) {
        ArrayRow r7 = createRow();
        SolverVariable r0 = createSlackVariable();
        r0.strength = 0;
        r7.createRowLowerThan(r3, r4, r0, r5);
        addConstraint(r7);
    }

    public void addCentering(SolverVariable r12, SolverVariable r13, int r14, float r15, SolverVariable r16, SolverVariable r17, int r18, int r19) {
        ArrayRow r10 = createRow();
        r10.createRowCentering(r12, r13, r14, r15, r16, r17, r18);
        if (r19 == 8) goto L5;
        r10.addError(this, r19);
    L5:
        addConstraint(r10);
    }

    public void addRatio(SolverVariable r8, SolverVariable r9, SolverVariable r10, SolverVariable r11, float r12, int r13) {
        ArrayRow r6 = createRow();
        r6.createRowDimensionRatio(r8, r9, r10, r11, r12);
        if (r13 == 8) goto L5;
        r6.addError(this, r13);
    L5:
        addConstraint(r6);
    }

    public void addSynonym(SolverVariable r3, SolverVariable r4, int r5) {
        if (r3.mDefinitionId != (-1)) goto L12;
        if (r5 != 0) goto L12;
        if (r4.mIsSynonym == false) goto L9;
        float r6 = r4.mSynonymDelta;
        r4 = this.mCache.mIndexedVariables[r4.mSynonym];
    L9:
        if (r3.mIsSynonym == false) goto L11;
        float r7 = r3.mSynonymDelta;
        SolverVariable r2 = this.mCache.mIndexedVariables[r3.mSynonym];
        return;
    L11:
        r3.setSynonym(this, r4, 0.0f);
        return;
    L12:
        addEquality(r3, r4, r5, 8);
    }

    public ArrayRow addEquality(SolverVariable r6, SolverVariable r7, int r8, int r9) {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L6;
        r0.mSimpleEquations++;
    L6:
        if (USE_BASIC_SYNONYMS == false) goto L14;
        if (r9 != 8) goto L14;
        if (r7.isFinalValue == false) goto L14;
        if (r6.mDefinitionId != (-1)) goto L14;
        r6.setFinalValue(this, r7.computedValue + r8);
        return null;
    L14:
        ArrayRow r1 = createRow();
        r1.createRowEquals(r6, r7, r8);
        if (r9 == 8) goto L17;
        r1.addError(this, r9);
    L17:
        addConstraint(r1);
        return r1;
    }

    public void addEquality(SolverVariable r6, int r7) {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L6;
        r0.mSimpleEquations++;
    L6:
        if (USE_BASIC_SYNONYMS == true) goto L8;
    L21:
        int r1 = r6.mDefinitionId;
        if (r6.mDefinitionId == (-1)) goto L30;
        ArrayRow r2 = this.mRows[r1];
        if (r2.mIsSimpleDefinition == false) goto L27;
        r2.mConstantValue = r7;
        return;
    L27:
        if (r2.variables.getCurrentSize() != 0) goto L29;
        r2.mIsSimpleDefinition = true;
        r2.mConstantValue = r7;
        return;
    L29:
        ArrayRow r3 = createRow();
        r3.createRowEquals(r6, r7);
        addConstraint(r3);
        return;
    L30:
        ArrayRow r4 = createRow();
        r4.createRowDefinition(r6, r7);
        addConstraint(r4);
        return;
    L8:
        if (r6.mDefinitionId != (-1)) goto L21;
        float r8 = r7;
        r6.setFinalValue(this, r8);
        int r5 = 0;
    L11:
        if (r5 >= (this.mVariablesID + 1)) goto L20;
        SolverVariable r9 = this.mCache.mIndexedVariables[r5];
        if (r9 == null) goto L19;
        if (r9.mIsSynonym == false) goto L19;
        if (r9.mSynonym != r6.id) goto L19;
        r9.setFinalValue(this, r9.mSynonymDelta + r8);
    L19:
        r5 = r5 + 1;
        goto L11
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem r0, SolverVariable r1, SolverVariable r2, float r3) {
        return r0.createRow().createRowDimensionPercent(r1, r2, r3);
    }

    public void addCenterPoint(ConstraintWidget r19, ConstraintWidget r20, float r21, int r22) {
        SolverVariable r5 = createObjectVariable(r19.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable r7 = createObjectVariable(r19.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable r3 = createObjectVariable(r19.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable r8 = createObjectVariable(r19.getAnchor(ConstraintAnchor.Type.BOTTOM));
        SolverVariable r1 = createObjectVariable(r20.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable r9 = createObjectVariable(r20.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable r12 = createObjectVariable(r20.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable r10 = createObjectVariable(r20.getAnchor(ConstraintAnchor.Type.BOTTOM));
        ArrayRow r2 = createRow();
        double r13 = r21;
        double r4 = r22;
        r2.createRowWithAngle(r7, r8, r9, r10, (float) (Math.sin(r13) * r4));
        addConstraint(r2);
        ArrayRow r6 = createRow();
        r6.createRowWithAngle(r5, r3, r1, r12, (float) (Math.cos(r13) * r4));
        addConstraint(r6);
    }
}
