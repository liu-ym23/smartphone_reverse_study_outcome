package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    private static int POOL_SIZE = 1000;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    private int TABLE_SIZE;
    public boolean graphOptimizer;
    public boolean hasSimpleDefinition;
    private boolean[] mAlreadyTestedCandidates;
    final Cache mCache;
    private Row mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    int mNumColumns;
    int mNumRows;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    ArrayRow[] mRows;
    private Row mTempGoal;
    private HashMap<String, SolverVariable> mVariables;
    int mVariablesID;
    public boolean newgraphOptimizer;

    public interface Row {
        void addError(SolverVariable r100);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem r100, boolean[] r101);

        void initFromRow(Row r100);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem r100, SolverVariable r101, boolean r102);

        void updateFromRow(LinearSystem r100, ArrayRow r101, boolean r102);

        void updateFromSystem(LinearSystem r100);
    }

    /* JADX INFO: loaded from: classes17.dex */
    public class ValuesRow extends ArrayRow {
        final /* synthetic */ LinearSystem this$0;

        public ValuesRow(LinearSystem r100, Cache r101) {
            this.this$0 = r100;
            this.variables = new SolverVariableValues(this, r101);
        }
    }

    private void computeValues() {
        int r100 = 0;
    L4:
        if (r100 >= this.mNumRows) goto L6;
        ArrayRow r101 = this.mRows[r100];
        SolverVariable r102 = r101.variable;
        r102.computedValue = r101.constantValue;
        r100 = r100 + 1;
        goto L4
    }

    private String getDisplayStrength(int r100) {
        if (r100 != 1) goto L7;
        return "LOW";
    L7:
        if (r100 != 2) goto L11;
        return "MEDIUM";
    L11:
        if (r100 != 3) goto L15;
        return "HIGH";
    L15:
        if (r100 != 4) goto L19;
        return "HIGHEST";
    L19:
        if (r100 != 5) goto L23;
        return "EQUALITY";
    L23:
        if (r100 != 8) goto L27;
        return "FIXED";
    L27:
        if (r100 != 6) goto L30;
        return "BARRIER";
    L30:
        return UserProfileEvent.POSITION_NONE;
    }

    public final void cleanupRows() {
        int r100 = 0;
    L4:
        if (r100 >= this.mNumRows) goto L19;
        ArrayRow r101 = this.mRows[r100];
        if (r101.variables.getCurrentSize() != 0) goto L9;
        r101.isSimpleDefinition = true;
    L9:
        if (r101.isSimpleDefinition == false) goto L18;
        SolverVariable r102 = r101.variable;
        r102.computedValue = r101.constantValue;
        r102.removeFromRow(r101);
        int r103 = r100;
    L11:
        int r104 = this.mNumRows;
        if (r103 >= (r104 - 1)) goto L14;
        ArrayRow[] r105 = this.mRows;
        int r106 = r103 + 1;
        r105[r103] = r105[r106];
        r103 = r106;
        goto L11
    L14:
        this.mRows[r104 - 1] = null;
        this.mNumRows = r104 - 1;
        r100 = r100 - 1;
        if (OPTIMIZED_ENGINE == false) goto L17;
        this.mCache.optimizedArrayRowPool.release(r101);
        goto L18
    L17:
        this.mCache.arrayRowPool.release(r101);
    L18:
        r100 = r100 + 1;
        goto L4
    }

    public void displaySystemInformations() {
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r100 >= this.TABLE_SIZE) goto L9;
        ArrayRow r102 = this.mRows[r100];
        if (r102 == null) goto L8;
        r101 = r101 + r102.sizeInBytes();
    L8:
        r100 = r100 + 1;
        goto L4
    L9:
        int r103 = 0;
        int r104 = 0;
    L11:
        if (r103 >= this.mNumRows) goto L16;
        ArrayRow r105 = this.mRows[r103];
        if (r105 == null) goto L15;
        r104 = r104 + r105.sizeInBytes();
    L15:
        r103 = r103 + 1;
        goto L11
    L16:
        PrintStream r106 = System.out;
        StringBuilder r107 = new StringBuilder("Linear System -> Table size: ");
        r107.append(this.TABLE_SIZE);
        r107.append(" (");
        int r108 = this.TABLE_SIZE;
        r107.append(getDisplaySize(r108 * r108));
        r107.append(") -- row sizes: ");
        r107.append(getDisplaySize(r101));
        r107.append(", actual size: ");
        r107.append(getDisplaySize(r104));
        r107.append(" rows: ");
        r107.append(this.mNumRows);
        r107.append(HTTP.URL_DEFAULT);
        r107.append(this.mMaxRows);
        r107.append(" cols: ");
        r107.append(this.mNumColumns);
        r107.append(HTTP.URL_DEFAULT);
        r107.append(this.mMaxColumns);
        r107.append(" 0 occupied cells, ");
        r107.append(getDisplaySize(0));
        r106.println(r107.toString());
    }

    public int getMemoryUsed() {
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r100 >= this.mNumRows) goto L9;
        ArrayRow r102 = this.mRows[r100];
        if (r102 == null) goto L8;
        r101 = r101 + r102.sizeInBytes();
    L8:
        r100 = r100 + 1;
        goto L4
    L9:
        return r101;
    }

    public void reset() {
        int r100 = 0;
    L3:
        Cache r101 = this.mCache;
        SolverVariable[] r102 = r101.mIndexedVariables;
        if (r100 >= r102.length) goto L9;
        SolverVariable r103 = r102[r100];
        if (r103 == null) goto L8;
        r103.reset();
    L8:
        r100 = r100 + 1;
        goto L3
    L9:
        r101.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, null);
        HashMap<String, SolverVariable> r104 = this.mVariables;
        if (r104 == null) goto L12;
        r104.clear();
    L12:
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        int r105 = 0;
    L14:
        if (r105 >= this.mNumRows) goto L19;
        ArrayRow r106 = this.mRows[r105];
        if (r106 == null) goto L18;
        r106.used = false;
    L18:
        r105 = r105 + 1;
        goto L14
    L19:
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE == false) goto L22;
        this.mTempGoal = new ValuesRow(this, this.mCache);
        return;
    L22:
        this.mTempGoal = new ArrayRow(this.mCache);
    }

    private void displaySolverVariables() {
        System.out.println("Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n");
    }

    private void increaseTableSize() {
        int r100 = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = r100;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, r100);
        Cache r101 = this.mCache;
        r101.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(r101.mIndexedVariables, this.TABLE_SIZE);
        int r102 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[r102];
        this.mMaxColumns = r102;
        this.mMaxRows = r102;
        Metrics r103 = sMetrics;
        if (r103 == null) goto L6;
        r103.tableSizeIncrease++;
        r103.maxTableSize = Math.max(r103.maxTableSize, r102);
        Metrics r104 = sMetrics;
        r104.lastTableSize = r104.maxTableSize;
        return;
    }

    private void releaseRows() {
        int r100 = 0;
        if (OPTIMIZED_ENGINE == false) goto L11;
    L5:
        if (r100 >= this.mNumRows) goto L16;
        ArrayRow r101 = this.mRows[r100];
        if (r101 == null) goto L9;
        this.mCache.optimizedArrayRowPool.release(r101);
    L9:
        this.mRows[r100] = null;
        r100 = r100 + 1;
        goto L5
    L16:
        return;
    L11:
        if (r100 >= this.mNumRows) goto L23;
        ArrayRow r102 = this.mRows[r100];
        if (r102 == null) goto L15;
        this.mCache.arrayRowPool.release(r102);
    L15:
        this.mRows[r100] = null;
        r100 = r100 + 1;
        goto L11
    }

    public SolverVariable createExtraVariable() {
        Metrics r100 = sMetrics;
        if (r100 == null) goto L6;
        r100.extravariables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r101 = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int r102 = this.mVariablesID + 1;
        this.mVariablesID = r102;
        this.mNumColumns++;
        r101.f15332id = r102;
        this.mCache.mIndexedVariables[r102] = r101;
        return r101;
    }

    public ArrayRow createRow() {
        if (OPTIMIZED_ENGINE == false) goto L8;
        ArrayRow r100 = this.mCache.optimizedArrayRowPool.acquire();
        if (r100 != null) goto L7;
        r100 = new ValuesRow(this, this.mCache);
        OPTIMIZED_ARRAY_ROW_CREATION++;
    L12:
        SolverVariable.increaseErrorId();
        return r100;
    L7:
        r100.reset();
        goto L12
    L8:
        r100 = this.mCache.arrayRowPool.acquire();
        if (r100 != null) goto L11;
        r100 = new ArrayRow(this.mCache);
        ARRAY_ROW_CREATION++;
        goto L12
    L11:
        r100.reset();
        goto L12
    }

    public SolverVariable createSlackVariable() {
        Metrics r100 = sMetrics;
        if (r100 == null) goto L6;
        r100.slackvariables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r101 = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int r102 = this.mVariablesID + 1;
        this.mVariablesID = r102;
        this.mNumColumns++;
        r101.f15332id = r102;
        this.mCache.mIndexedVariables[r102] = r101;
        return r101;
    }

    public void minimize() throws Exception {
        Metrics r100 = sMetrics;
        if (r100 == null) goto L6;
        r100.minimize++;
    L6:
        if (this.mGoal.isEmpty() == false) goto L10;
        computeValues();
        return;
    L10:
        if (this.graphOptimizer == false) goto L12;
    L15:
        Metrics r101 = sMetrics;
        if (r101 == null) goto L18;
        r101.graphOptimizer++;
    L18:
        boolean r102 = false;
        int r103 = 0;
    L20:
        if (r103 >= this.mNumRows) goto L25;
        if (this.mRows[r103].isSimpleDefinition == false) goto L26;
        r103 = r103 + 1;
    L26:
        if (r102 == true) goto L28;
        minimizeGoal(this.mGoal);
        return;
    L28:
        Metrics r104 = sMetrics;
        if (r104 == null) goto L31;
        r104.fullySolved++;
    L31:
        computeValues();
        return;
    L25:
        r102 = true;
        goto L26
    L12:
        if (this.newgraphOptimizer == true) goto L15;
        minimizeGoal(this.mGoal);
    }

    public LinearSystem() {
        this.hasSimpleDefinition = false;
        this.mVariablesID = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 32;
        this.mMaxColumns = 32;
        this.mRows = null;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[32];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = 32;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache r100 = new Cache();
        this.mCache = r100;
        this.mGoal = new PriorityGoalRow(r100);
        if (OPTIMIZED_ENGINE == false) goto L5;
        this.mTempGoal = new ValuesRow(this, r100);
        return;
    L5:
        this.mTempGoal = new ArrayRow(r100);
    }

    private void displayRows() {
        displaySolverVariables();
        String r100 = "";
        int r101 = 0;
    L4:
        if (r101 >= this.mNumRows) goto L6;
        r100 = (r100 + this.mRows[r101]) + "\n";
        r101 = r101 + 1;
        goto L4
    L6:
        System.out.println(r100 + this.mGoal + "\n");
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String r100 = " num vars " + this.mVariablesID + "\n";
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= (this.mVariablesID + 1)) goto L11;
        SolverVariable r103 = this.mCache.mIndexedVariables[r102];
        if (r103 == null) goto L10;
        if (r103.isFinalValue == false) goto L10;
        r100 = r100 + " $[" + r102 + "] => " + r103 + " = " + r103.computedValue + "\n";
    L10:
        r102 = r102 + 1;
        goto L4
    L11:
        String r104 = r100 + "\n";
        int r105 = 0;
    L13:
        if (r105 >= (this.mVariablesID + 1)) goto L20;
        SolverVariable[] r106 = this.mCache.mIndexedVariables;
        SolverVariable r107 = r106[r105];
        if (r107 == null) goto L19;
        if (r107.isSynonym == false) goto L19;
        r104 = r104 + " ~[" + r105 + "] => " + r107 + " = " + r106[r107.synonym] + " + " + r107.synonymDelta + "\n";
    L19:
        r105 = r105 + 1;
        goto L13
    L20:
        String r108 = r104 + "\n\n #  ";
    L22:
        if (r101 >= this.mNumRows) goto L25;
        r108 = (r108 + this.mRows[r101].toReadableString()) + "\n #  ";
        r101 = r101 + 1;
        goto L22
    L25:
        if (this.mGoal == null) goto L27;
        r108 = r108 + "Goal: " + this.mGoal + "\n";
    L27:
        System.out.println(r108);
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String r100 = "";
        int r101 = 0;
    L4:
        if (r101 >= this.mNumRows) goto L9;
        if (this.mRows[r101].variable.mType != SolverVariable.Type.UNRESTRICTED) goto L8;
        r100 = (r100 + this.mRows[r101].toReadableString()) + "\n";
    L8:
        r101 = r101 + 1;
        goto L4
    L9:
        System.out.println(r100 + this.mGoal + "\n");
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    public Row getGoal() {
        return this.mGoal;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    private void addError(ArrayRow r100) {
        r100.addError(this, 0);
    }

    private final void addRow(ArrayRow r100) {
        if (SIMPLIFY_SYNONYMS == true) goto L5;
    L7:
        ArrayRow[] r101 = this.mRows;
        int r102 = this.mNumRows;
        r101[r102] = r100;
        SolverVariable r103 = r100.variable;
        r103.definitionId = r102;
        this.mNumRows = r102 + 1;
        r103.updateReferencesWithNewDefinition(this, r100);
    L9:
        if (SIMPLIFY_SYNONYMS == true) goto L11;
        return;
    L11:
        if (this.hasSimpleDefinition == false) goto L47;
        int r104 = 0;
    L14:
        if (r104 >= this.mNumRows) goto L37;
        if (this.mRows[r104] != null) goto L18;
        System.out.println("WTF");
    L18:
        ArrayRow r105 = this.mRows[r104];
        if (r105 == null) goto L36;
        if (r105.isSimpleDefinition == false) goto L36;
        r105.variable.setFinalValue(this, r105.constantValue);
        if (OPTIMIZED_ENGINE == false) goto L25;
        this.mCache.optimizedArrayRowPool.release(r105);
    L26:
        this.mRows[r104] = null;
        int r106 = r104 + 1;
        int r107 = r106;
    L27:
        int r108 = this.mNumRows;
        if (r106 >= r108) goto L33;
        ArrayRow[] r109 = this.mRows;
        int r110 = r106 - 1;
        ArrayRow r111 = r109[r106];
        r109[r110] = r111;
        SolverVariable r112 = r111.variable;
        if (r112.definitionId != r106) goto L32;
        r112.definitionId = r110;
    L32:
        r107 = r106;
        r106 = r106 + 1;
        goto L27
    L33:
        if (r107 >= r108) goto L35;
        this.mRows[r107] = null;
    L35:
        this.mNumRows = r108 - 1;
        r104 = r104 - 1;
        goto L36
    L25:
        this.mCache.arrayRowPool.release(r105);
    L36:
        r104 = r104 + 1;
        goto L14
    L37:
        this.hasSimpleDefinition = false;
        return;
    L47:
        return;
    L5:
        if (r100.isSimpleDefinition == false) goto L7;
        r100.variable.setFinalValue(this, r100.constantValue);
        goto L9
    }

    private int enforceBFS(Row r210) throws Exception {
        int r100 = 0;
    L4:
        if (r100 >= this.mNumRows) goto L12;
        ArrayRow r101 = this.mRows[r100];
        if (r101.variable.mType == SolverVariable.Type.UNRESTRICTED) goto L11;
        if (r101.constantValue >= 0.0f) goto L11;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L73;
        boolean r103 = false;
        int r104 = 0;
    L15:
        if (r103 == true) goto L98;
        Metrics r105 = sMetrics;
        if (r105 == null) goto L19;
        r105.bfs++;
    L19:
        r104 = r104 + 1;
        float r106 = Float.MAX_VALUE;
        int r110 = 0;
        int r111 = -1;
        int r112 = -1;
        int r113 = 0;
    L21:
        if (r110 >= this.mNumRows) goto L63;
        ArrayRow r114 = this.mRows[r110];
        if (r114.variable.mType == SolverVariable.Type.UNRESTRICTED) goto L61;
        if (r114.isSimpleDefinition == true) goto L61;
        if (r114.constantValue >= 0.0f) goto L61;
        int r115 = 9;
        if (SKIP_COLUMNS == false) goto L46;
        int r107 = r114.variables.getCurrentSize();
        int r108 = 0;
    L33:
        if (r108 >= r107) goto L61;
        SolverVariable r109 = r114.variables.getVariable(r108);
        float r116 = r114.variables.get(r109);
        if (r116 <= 0.0f) goto L45;
        int r117 = 0;
    L38:
        if (r117 >= r115) goto L45;
        float r118 = r109.strengthVector[r117] / r116;
        if (r118 >= r106) goto L42;
        if (r117 != r113) goto L42;
    L43:
        r112 = r109.f15332id;
        r113 = r117;
        r111 = r110;
        r106 = r118;
    L44:
        r117 = r117 + 1;
        r115 = 9;
    L42:
        if (r117 <= r113) goto L44;
    L45:
        r108 = r108 + 1;
        r115 = 9;
        goto L33
    L46:
        int r119 = 1;
    L48:
        if (r119 >= this.mNumColumns) goto L61;
        SolverVariable r120 = this.mCache.mIndexedVariables[r119];
        float r121 = r114.variables.get(r120);
        if (r121 <= 0.0f) goto L60;
        int r122 = 0;
    L53:
        if (r122 >= 9) goto L60;
        float r123 = r120.strengthVector[r122] / r121;
        if (r123 >= r106) goto L57;
        if (r122 != r113) goto L57;
    L58:
        r112 = r119;
        r113 = r122;
        r111 = r110;
        r106 = r123;
    L59:
        r122 = r122 + 1;
    L57:
        if (r122 <= r113) goto L59;
    L60:
        r119 = r119 + 1;
    L61:
        r110 = r110 + 1;
        goto L21
    L63:
        if (r111 == (-1)) goto L68;
        ArrayRow r124 = this.mRows[r111];
        r124.variable.definitionId = -1;
        Metrics r125 = sMetrics;
        if (r125 == null) goto L67;
        r125.pivots++;
    L67:
        r124.pivot(this.mCache.mIndexedVariables[r112]);
        SolverVariable r126 = r124.variable;
        r126.definitionId = r111;
        r126.updateReferencesWithNewDefinition(this, r124);
    L70:
        if (r104 <= (this.mNumColumns / 2)) goto L15;
        r103 = true;
        goto L15
    L68:
        r103 = true;
        goto L70
    L98:
        return r104;
    L73:
        return 0;
    L11:
        r100 = r100 + 1;
        goto L4
    L12:
        r102 = false;
        goto L13
    }

    private String getDisplaySize(int r100) {
        int r101 = r100 * 4;
        int r102 = r101 / 1024;
        int r103 = r102 / 1024;
        if (r103 > 0) goto L5;
        if (r102 <= 0) goto L10;
        return "" + r102 + " Kb";
    L10:
        return "" + r101 + " bytes";
    L5:
        return "" + r103 + " Mb";
    }

    public void addConstraint(ArrayRow r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Metrics r101 = sMetrics;
        if (r101 == null) goto L9;
        r101.constraints++;
        if (r100.isSimpleDefinition == false) goto L9;
        r101.simpleconstraints++;
    L9:
        boolean r102 = true;
        if ((this.mNumRows + 1) < this.mMaxRows) goto L12;
    L13:
        increaseTableSize();
    L14:
        boolean r103 = false;
        if (r100.isSimpleDefinition == true) goto L46;
        r100.updateFromSystem(this);
        if (r100.isEmpty() == false) goto L19;
        return;
    L19:
        r100.ensurePositiveConstant();
        if (r100.chooseSubject(this) == false) goto L41;
        SolverVariable r104 = createExtraVariable();
        r100.variable = r104;
        int r105 = this.mNumRows;
        addRow(r100);
        if (this.mNumRows != (r105 + 1)) goto L41;
        this.mTempGoal.initFromRow(r100);
        optimize(this.mTempGoal, true);
        if (r104.definitionId != (-1)) goto L43;
        if (r100.variable != r104) goto L34;
        SolverVariable r106 = r100.pickPivot(r104);
        if (r106 == null) goto L34;
        Metrics r107 = sMetrics;
        if (r107 == null) goto L32;
        r107.pivots++;
    L32:
        r100.pivot(r106);
    L34:
        if (r100.isSimpleDefinition == true) goto L37;
        r100.variable.updateReferencesWithNewDefinition(this, r100);
    L37:
        if (OPTIMIZED_ENGINE == false) goto L39;
        this.mCache.optimizedArrayRowPool.release(r100);
    L40:
        this.mNumRows--;
        goto L43
    L39:
        this.mCache.arrayRowPool.release(r100);
    L43:
        if (r100.hasKeyVariable() == true) goto L45;
        return;
    L45:
        r103 = r102;
    L41:
        r102 = false;
    L46:
        if (r103 == true) goto L49;
        addRow(r100);
        return;
    L49:
        return;
    L12:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L14;
        goto L13
    }

    public SolverVariable createObjectVariable(Object r100) {
        SolverVariable r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L9;
        increaseTableSize();
    L9:
        if ((r100 instanceof ConstraintAnchor) == false) goto L22;
        ConstraintAnchor r102 = (ConstraintAnchor) r100;
        r101 = r102.getSolverVariable();
        if (r101 != null) goto L13;
        r102.resetSolverVariable(this.mCache);
        r101 = r102.getSolverVariable();
    L13:
        int r103 = r101.f15332id;
        if (r103 != (-1)) goto L16;
    L19:
        if (r103 == (-1)) goto L21;
        r101.reset();
    L21:
        int r104 = this.mVariablesID + 1;
        this.mVariablesID = r104;
        this.mNumColumns++;
        r101.f15332id = r104;
        r101.mType = SolverVariable.Type.UNRESTRICTED;
        this.mCache.mIndexedVariables[r104] = r101;
        goto L22
    L16:
        if (r103 > this.mVariablesID) goto L19;
        if (this.mCache.mIndexedVariables[r103] == null) goto L19;
    L22:
        return r101;
    }

    public void fillMetrics(Metrics r100) {
        sMetrics = r100;
    }

    public int getObjectVariableValue(Object r100) {
        SolverVariable r101 = ((ConstraintAnchor) r100).getSolverVariable();
        if (r101 != null) goto L5;
        return 0;
    L5:
        return (int) (r101.computedValue + 0.5f);
    }

    public ArrayRow getRow(int r100) {
        return this.mRows[r100];
    }

    public float getValueFor(String r100) {
        SolverVariable r101 = getVariable(r100, SolverVariable.Type.UNRESTRICTED);
        if (r101 != null) goto L7;
        return 0.0f;
    L7:
        return r101.computedValue;
    }

    public void minimizeGoal(Row r100) throws Exception {
        Metrics r101 = sMetrics;
        if (r101 == null) goto L5;
        r101.minimizeGoal++;
        r101.maxVariables = Math.max(r101.maxVariables, this.mNumColumns);
        Metrics r102 = sMetrics;
        r102.maxRows = Math.max(r102.maxRows, this.mNumRows);
    L5:
        enforceBFS(r100);
        optimize(r100, false);
        computeValues();
    }

    public void removeRow(ArrayRow r100) {
        if (r100.isSimpleDefinition == false) goto L26;
        SolverVariable r101 = r100.variable;
        if (r101 == null) goto L27;
        int r102 = r101.definitionId;
        if (r102 == (-1)) goto L15;
    L8:
        int r103 = this.mNumRows;
        if (r102 >= (r103 - 1)) goto L14;
        ArrayRow[] r104 = this.mRows;
        int r105 = r102 + 1;
        ArrayRow r106 = r104[r105];
        SolverVariable r107 = r106.variable;
        if (r107.definitionId != r105) goto L13;
        r107.definitionId = r102;
    L13:
        r104[r102] = r106;
        r102 = r105;
        goto L8
    L14:
        this.mNumRows = r103 - 1;
    L15:
        SolverVariable r108 = r100.variable;
        if (r108.isFinalValue == true) goto L19;
        r108.setFinalValue(this, r100.constantValue);
    L19:
        if (OPTIMIZED_ENGINE == false) goto L21;
        this.mCache.optimizedArrayRowPool.release(r100);
        return;
    L21:
        this.mCache.arrayRowPool.release(r100);
        return;
    L27:
        return;
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type r100, String r101) {
        SolverVariable r102 = this.mCache.solverVariablePool.acquire();
        if (r102 != null) goto L5;
        r102 = new SolverVariable(r100, r101);
        r102.setType(r100, r101);
    L6:
        int r103 = this.mPoolVariablesCount;
        int r104 = POOL_SIZE;
        if (r103 < r104) goto L9;
        int r105 = r104 * 2;
        POOL_SIZE = r105;
        this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, r105);
    L9:
        SolverVariable[] r106 = this.mPoolVariables;
        int r107 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = r107 + 1;
        r106[r107] = r102;
        return r102;
    L5:
        r102.reset();
        r102.setType(r100, r101);
        goto L6
    }

    private void addSingleError(ArrayRow r100, int r101) {
        addSingleError(r100, r101, 0);
    }

    private SolverVariable createVariable(String r100, SolverVariable.Type r101) {
        Metrics r102 = sMetrics;
        if (r102 == null) goto L6;
        r102.variables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r103 = acquireSolverVariable(r101, null);
        r103.setName(r100);
        int r104 = this.mVariablesID + 1;
        this.mVariablesID = r104;
        this.mNumColumns++;
        r103.f15332id = r104;
        if (this.mVariables != null) goto L11;
        this.mVariables = new HashMap();
    L11:
        this.mVariables.put(r100, r103);
        this.mCache.mIndexedVariables[this.mVariablesID] = r103;
        return r103;
    }

    private final int optimize(Row r110, boolean r111) {
        Metrics r112 = sMetrics;
        if (r112 == null) goto L5;
        r112.optimize++;
    L5:
        int r100 = 0;
    L7:
        if (r100 >= this.mNumColumns) goto L9;
        this.mAlreadyTestedCandidates[r100] = false;
        r100 = r100 + 1;
        goto L7
    L9:
        boolean r101 = false;
        int r102 = 0;
    L10:
        if (r101 == true) goto L50;
        Metrics r103 = sMetrics;
        if (r103 == null) goto L14;
        r103.iterations++;
    L14:
        r102 = r102 + 1;
        if (r102 >= (this.mNumColumns * 2)) goto L16;
        if (r110.getKey() == null) goto L20;
        this.mAlreadyTestedCandidates[r110.getKey().f15332id] = true;
    L20:
        SolverVariable r104 = r110.getPivotCandidate(this, this.mAlreadyTestedCandidates);
        if (r104 == null) goto L26;
        boolean[] r105 = this.mAlreadyTestedCandidates;
        int r106 = r104.f15332id;
        if (r105[r106] == true) goto L24;
        r105[r106] = true;
        goto L26
    L24:
        return r102;
    L26:
        if (r104 != null) goto L27;
        r101 = true;
        goto L10
    L27:
        float r107 = Float.MAX_VALUE;
        int r108 = 0;
        int r109 = -1;
    L29:
        if (r108 >= this.mNumRows) goto L44;
        ArrayRow r113 = this.mRows[r108];
        if (r113.variable.mType == SolverVariable.Type.UNRESTRICTED) goto L43;
        if (r113.isSimpleDefinition == true) goto L43;
        if (r113.hasVariable(r104) == false) goto L43;
        float r114 = r113.variables.get(r104);
        if (r114 >= 0.0f) goto L43;
        float r115 = (-r113.constantValue) / r114;
        if (r115 >= r107) goto L43;
        r109 = r108;
        r107 = r115;
    L43:
        r108 = r108 + 1;
        goto L29
    L44:
        if (r109 <= (-1)) goto L10;
        ArrayRow r116 = this.mRows[r109];
        r116.variable.definitionId = -1;
        Metrics r117 = sMetrics;
        if (r117 == null) goto L48;
        r117.pivots++;
    L48:
        r116.pivot(r104);
        SolverVariable r118 = r116.variable;
        r118.definitionId = r109;
        r118.updateReferencesWithNewDefinition(this, r116);
        goto L10
    L16:
        return r102;
    L50:
        return r102;
    }

    public void addEquality(SolverVariable r100, int r101) {
        if (USE_BASIC_SYNONYMS == true) goto L5;
    L18:
        int r102 = r100.definitionId;
        if (r102 == (-1)) goto L27;
        ArrayRow r103 = this.mRows[r102];
        if (r103.isSimpleDefinition == false) goto L24;
        r103.constantValue = r101;
        return;
    L24:
        if (r103.variables.getCurrentSize() != 0) goto L26;
        r103.isSimpleDefinition = true;
        r103.constantValue = r101;
        return;
    L26:
        ArrayRow r104 = createRow();
        r104.createRowEquals(r100, r101);
        addConstraint(r104);
        return;
    L27:
        ArrayRow r105 = createRow();
        r105.createRowDefinition(r100, r101);
        addConstraint(r105);
        return;
    L5:
        if (r100.definitionId != (-1)) goto L18;
        float r106 = r101;
        r100.setFinalValue(this, r106);
        int r107 = 0;
    L8:
        if (r107 >= (this.mVariablesID + 1)) goto L17;
        SolverVariable r108 = this.mCache.mIndexedVariables[r107];
        if (r108 == null) goto L16;
        if (r108.isSynonym == false) goto L16;
        if (r108.synonym != r100.f15332id) goto L16;
        r108.setFinalValue(this, r108.synonymDelta + r106);
    L16:
        r107 = r107 + 1;
        goto L8
    }

    public SolverVariable createErrorVariable(int r100, String r101) {
        Metrics r102 = sMetrics;
        if (r102 == null) goto L6;
        r102.errors++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r103 = acquireSolverVariable(SolverVariable.Type.ERROR, r101);
        int r104 = this.mVariablesID + 1;
        this.mVariablesID = r104;
        this.mNumColumns++;
        r103.f15332id = r104;
        r103.strength = r100;
        this.mCache.mIndexedVariables[r104] = r103;
        this.mGoal.addError(r103);
        return r103;
    }

    public SolverVariable getVariable(String r100, SolverVariable.Type r101) {
        if (this.mVariables != null) goto L5;
        this.mVariables = new HashMap();
    L5:
        SolverVariable r102 = this.mVariables.get(r100);
        if (r102 == null) goto L8;
        return r102;
    L8:
        return createVariable(r100, r101);
    }

    public void addSingleError(ArrayRow r100, int r101, int r102) {
        r100.addSingleError(createErrorVariable(r102, null), r101);
    }

    public void addSynonym(SolverVariable r100, SolverVariable r101, int r102) {
        if (r100.definitionId != (-1)) goto L12;
        if (r102 != 0) goto L12;
        if (r101.isSynonym == false) goto L9;
        r101 = this.mCache.mIndexedVariables[r101.synonym];
    L9:
        if (r100.isSynonym == false) goto L11;
        SolverVariable r103 = this.mCache.mIndexedVariables[r100.synonym];
        return;
    L11:
        r100.setSynonym(this, r101, 0.0f);
        return;
    L12:
        addEquality(r100, r101, r102, 8);
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem r100, SolverVariable r101, SolverVariable r102, float r103) {
        return r100.createRow().createRowDimensionPercent(r101, r102, r103);
    }

    public void addCenterPoint(ConstraintWidget r110, ConstraintWidget r111, float r112, int r210) {
        ConstraintAnchor.Type r100 = ConstraintAnchor.Type.LEFT;
        SolverVariable r101 = createObjectVariable(r110.getAnchor(r100));
        ConstraintAnchor.Type r102 = ConstraintAnchor.Type.TOP;
        SolverVariable r103 = createObjectVariable(r110.getAnchor(r102));
        ConstraintAnchor.Type r104 = ConstraintAnchor.Type.RIGHT;
        SolverVariable r113 = createObjectVariable(r110.getAnchor(r104));
        ConstraintAnchor.Type r105 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable r106 = createObjectVariable(r110.getAnchor(r105));
        SolverVariable r107 = createObjectVariable(r111.getAnchor(r100));
        SolverVariable r114 = createObjectVariable(r111.getAnchor(r102));
        SolverVariable r108 = createObjectVariable(r111.getAnchor(r104));
        SolverVariable r115 = createObjectVariable(r111.getAnchor(r105));
        ArrayRow r109 = createRow();
        double r116 = r112;
        double r117 = r210;
        r109.createRowWithAngle(r103, r106, r114, r115, (float) (Math.sin(r116) * r117));
        addConstraint(r109);
        ArrayRow r118 = createRow();
        r118.createRowWithAngle(r101, r113, r107, r108, (float) (Math.cos(r116) * r117));
        addConstraint(r118);
    }

    public ArrayRow addEquality(SolverVariable r100, SolverVariable r101, int r102, int r103) {
        if (USE_BASIC_SYNONYMS == false) goto L11;
        if (r103 != 8) goto L11;
        if (r101.isFinalValue == false) goto L11;
        if (r100.definitionId != (-1)) goto L11;
        r100.setFinalValue(this, r101.computedValue + r102);
        return null;
    L11:
        ArrayRow r104 = createRow();
        r104.createRowEquals(r100, r101, r102);
        if (r103 == 8) goto L14;
        r104.addError(this, r103);
    L14:
        addConstraint(r104);
        return r104;
    }

    public void addGreaterBarrier(SolverVariable r100, SolverVariable r101, int r102, boolean r103) {
        ArrayRow r104 = createRow();
        SolverVariable r105 = createSlackVariable();
        r105.strength = 0;
        r104.createRowGreaterThan(r100, r101, r105, r102);
        addConstraint(r104);
    }

    public void addGreaterThan(SolverVariable r100, SolverVariable r101, int r102, int r103) {
        ArrayRow r104 = createRow();
        SolverVariable r105 = createSlackVariable();
        r105.strength = 0;
        r104.createRowGreaterThan(r100, r101, r105, r102);
        if (r103 == 8) goto L5;
        addSingleError(r104, (int) (r104.variables.get(r105) * (-1.0f)), r103);
    L5:
        addConstraint(r104);
    }

    public void addLowerBarrier(SolverVariable r100, SolverVariable r101, int r102, boolean r103) {
        ArrayRow r104 = createRow();
        SolverVariable r105 = createSlackVariable();
        r105.strength = 0;
        r104.createRowLowerThan(r100, r101, r105, r102);
        addConstraint(r104);
    }

    public void addLowerThan(SolverVariable r100, SolverVariable r101, int r102, int r103) {
        ArrayRow r104 = createRow();
        SolverVariable r105 = createSlackVariable();
        r105.strength = 0;
        r104.createRowLowerThan(r100, r101, r105, r102);
        if (r103 == 8) goto L5;
        addSingleError(r104, (int) (r104.variables.get(r105) * (-1.0f)), r103);
    L5:
        addConstraint(r104);
    }

    public void addRatio(SolverVariable r100, SolverVariable r101, SolverVariable r110, SolverVariable r111, float r112, int r113) {
        ArrayRow r102 = createRow();
        r102.createRowDimensionRatio(r100, r101, r110, r111, r112);
        if (r113 == 8) goto L5;
        r102.addError(this, r113);
    L5:
        addConstraint(r102);
    }

    public void addCentering(SolverVariable r110, SolverVariable r111, int r112, float r113, SolverVariable r114, SolverVariable r115, int r116, int r117) {
        ArrayRow r118 = createRow();
        r118.createRowCentering(r110, r111, r112, r113, r114, r115, r116);
        if (r117 == 8) goto L5;
        r118.addError(this, r117);
    L5:
        addConstraint(r118);
    }
}
