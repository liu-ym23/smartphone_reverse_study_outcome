package androidx.constraintlayout.solver;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId;
    float[] goalStrengthVector;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f15332id;
    public boolean inGoal;
    HashSet<ArrayRow> inRows;
    public boolean isFinalValue;
    boolean isSynonym;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    int synonym;
    float synonymDelta;
    public int usageInRowCount;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.SolverVariable$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = null;

        static {
            int[] r100 = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = r100;
            r100[Type.UNRESTRICTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.CONSTANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.SLACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.UNKNOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CONSTANT = null;
        public static final Type ERROR = null;
        public static final Type SLACK = null;
        public static final Type UNKNOWN = null;
        public static final Type UNRESTRICTED = null;

        static {
            Type r100 = new Type("UNRESTRICTED", 0);
            UNRESTRICTED = r100;
            Type r101 = new Type("CONSTANT", 1);
            CONSTANT = r101;
            Type r102 = new Type("SLACK", 2);
            SLACK = r102;
            Type r103 = new Type("ERROR", 3);
            ERROR = r103;
            Type r104 = new Type("UNKNOWN", 4);
            UNKNOWN = r104;
            $VALUES = new Type[]{r100, r101, r102, r103, r104};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void clearStrengths() {
        int r100 = 0;
    L4:
        if (r100 >= 9) goto L6;
        this.strengthVector[r100] = 0.0f;
        r100 = r100 + 1;
        goto L4
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.f15332id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int r100 = this.mClientEquationsCount;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        this.mClientEquations[r101] = null;
        r101 = r101 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    public String strengthsToString() {
        String r100 = this + "[";
        int r101 = 0;
        boolean r102 = false;
        boolean r103 = true;
    L4:
        if (r101 >= this.strengthVector.length) goto L19;
        String r104 = r100 + this.strengthVector[r101];
        float[] r105 = this.strengthVector;
        float r106 = r105[r101];
        if (r106 <= 0.0f) goto L9;
        r102 = false;
    L12:
        if (r106 == 0.0f) goto L15;
        r103 = false;
    L15:
        if (r101 >= (r105.length - 1)) goto L17;
        r100 = r104 + ", ";
    L18:
        r101 = r101 + 1;
        goto L4
    L17:
        r100 = r104 + "] ";
        goto L18
    L9:
        if (r106 >= 0.0f) goto L12;
        r102 = true;
        goto L12
    L19:
        if (r102 == false) goto L21;
        r100 = r100 + " (-)";
    L21:
        if (r103 == true) goto L23;
        return r100;
    L23:
        return r100 + " (*)";
    }

    public String toString() {
        if (this.mName == null) goto L6;
        return "" + this.mName;
    L6:
        return "" + this.f15332id;
    }

    public String getName() {
        return this.mName;
    }

    public final void addToRow(ArrayRow r100) {
        int r101 = 0;
    L3:
        int r102 = this.mClientEquationsCount;
        if (r101 >= r102) goto L9;
        if (this.mClientEquations[r101] == r100) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        return;
    L9:
        ArrayRow[] r103 = this.mClientEquations;
        if (r102 < r103.length) goto L12;
        this.mClientEquations = (ArrayRow[]) Arrays.copyOf(r103, r103.length * 2);
    L12:
        ArrayRow[] r104 = this.mClientEquations;
        int r105 = this.mClientEquationsCount;
        r104[r105] = r100;
        this.mClientEquationsCount = r105 + 1;
    }

    public final void removeFromRow(ArrayRow r100) {
        int r101 = this.mClientEquationsCount;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L12;
        if (this.mClientEquations[r102] == r100) goto L7;
        r102 = r102 + 1;
    L7:
        if (r102 >= (r101 - 1)) goto L9;
        ArrayRow[] r103 = this.mClientEquations;
        int r104 = r102 + 1;
        r103[r102] = r103[r104];
        r102 = r104;
        goto L7
    L9:
        this.mClientEquationsCount--;
        return;
    }

    public void setName(String r100) {
        this.mName = r100;
    }

    public SolverVariable(String r100, Type r101) {
        this.f15332id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mName = r100;
        this.mType = r101;
    }

    private static String getUniqueName(Type r100, String r101) {
        if (r101 != null) goto L4;
        int r102 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[r100.ordinal()];
        if (r102 != 1) goto L8;
        StringBuilder r103 = new StringBuilder("U");
        int r104 = uniqueUnrestrictedId + 1;
        uniqueUnrestrictedId = r104;
        r103.append(r104);
        return r103.toString();
    L8:
        if (r102 != 2) goto L10;
        StringBuilder r105 = new StringBuilder("C");
        int r106 = uniqueConstantId + 1;
        uniqueConstantId = r106;
        r105.append(r106);
        return r105.toString();
    L10:
        if (r102 != 3) goto L12;
        StringBuilder r107 = new StringBuilder(ExifInterface.LATITUDE_SOUTH);
        int r108 = uniqueSlackId + 1;
        uniqueSlackId = r108;
        r107.append(r108);
        return r107.toString();
    L12:
        if (r102 != 4) goto L14;
        StringBuilder r109 = new StringBuilder("e");
        int r110 = uniqueErrorId + 1;
        uniqueErrorId = r110;
        r109.append(r110);
        return r109.toString();
    L14:
        if (r102 != 5) goto L18;
        StringBuilder r111 = new StringBuilder("V");
        int r112 = uniqueId + 1;
        uniqueId = r112;
        r111.append(r112);
        return r111.toString();
    L18:
        throw new AssertionError(r100.name());
    L4:
        return r101 + uniqueErrorId;
    }

    public void setFinalValue(LinearSystem r100, float r101) {
        this.computedValue = r101;
        this.isFinalValue = true;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int r102 = this.mClientEquationsCount;
        this.definitionId = -1;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        this.mClientEquations[r103].updateFromFinalVariable(r100, this, false);
        r103 = r103 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
    }

    public void setType(Type r100, String r101) {
        this.mType = r100;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem r100, ArrayRow r101) {
        int r102 = this.mClientEquationsCount;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        this.mClientEquations[r103].updateFromRow(r100, r101, false);
        r103 = r103 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
    }

    public SolverVariable(Type r100, String r101) {
        this.f15332id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mType = r100;
    }

    public void setSynonym(LinearSystem r100, SolverVariable r101, float r102) {
        this.isSynonym = true;
        this.synonym = r101.f15332id;
        this.synonymDelta = r102;
        int r103 = this.mClientEquationsCount;
        this.definitionId = -1;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        this.mClientEquations[r104].updateFromSynonymVariable(r100, this, false);
        r104 = r104 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
        r100.displayReadableRows();
    }
}
