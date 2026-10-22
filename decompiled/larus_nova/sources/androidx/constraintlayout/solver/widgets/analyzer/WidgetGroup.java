package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Chain;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class WidgetGroup {
    private static final boolean DEBUG = false;
    static int count;
    boolean authoritative;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    int f15335id;
    private int moveTo;
    int orientation;
    ArrayList<MeasureResult> results;
    ArrayList<ConstraintWidget> widgets;

    public class MeasureResult {
        int baseline;
        int bottom;
        int left;
        int orientation;
        int right;
        final /* synthetic */ WidgetGroup this$0;
        int top;
        WeakReference<ConstraintWidget> widgetRef;

        public void apply() {
            ConstraintWidget r100 = this.widgetRef.get();
            if (r100 == null) goto L6;
            r100.setFinalFrame(this.left, this.top, this.right, this.bottom, this.baseline, this.orientation);
            return;
        }

        public MeasureResult(WidgetGroup r100, ConstraintWidget r101, LinearSystem r102, int r103) {
            this.this$0 = r100;
            this.widgetRef = new WeakReference(r101);
            this.left = r102.getObjectVariableValue(r101.mLeft);
            this.top = r102.getObjectVariableValue(r101.mTop);
            this.right = r102.getObjectVariableValue(r101.mRight);
            this.bottom = r102.getObjectVariableValue(r101.mBottom);
            this.baseline = r102.getObjectVariableValue(r101.mBaseline);
            this.orientation = r103;
        }
    }

    private String getOrientationString() {
        int r100 = this.orientation;
        if (r100 != 0) goto L7;
        return "Horizontal";
    L7:
        if (r100 != 1) goto L11;
        return "Vertical";
    L11:
        if (r100 != 2) goto L14;
        return "Both";
    L14:
        return "Unknown";
    }

    public void apply() {
        if (this.results != null) goto L6;
        return;
    L6:
        if (this.authoritative == true) goto L8;
        return;
    L8:
        int r100 = 0;
    L10:
        if (r100 >= this.results.size()) goto L12;
        ((MeasureResult) ListProtector.get(this.results, r100)).apply();
        r100 = r100 + 1;
        goto L10
    }

    public void clear() {
        this.widgets.clear();
    }

    public int size() {
        return this.widgets.size();
    }

    public String toString() {
        String r100 = getOrientationString() + " [" + this.f15335id + "] <";
        Iterator<ConstraintWidget> r101 = this.widgets.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100 = r100 + " " + r101.next().getDebugName();
        goto L4
    L7:
        return r100 + " >";
    }

    public int getId() {
        return this.f15335id;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean isAuthoritative() {
        return this.authoritative;
    }

    public WidgetGroup(int r100) {
        this.widgets = new ArrayList();
        this.authoritative = false;
        this.results = null;
        this.moveTo = -1;
        int r101 = count;
        count = r101 + 1;
        this.f15335id = r101;
        this.orientation = r100;
    }

    private boolean contains(ConstraintWidget r100) {
        return this.widgets.contains(r100);
    }

    public boolean add(ConstraintWidget r100) {
        if (this.widgets.contains(r100) == false) goto L6;
        return false;
    L6:
        this.widgets.add(r100);
        return true;
    }

    public void cleanup(ArrayList<WidgetGroup> r100) {
        int r101 = this.widgets.size();
        if (this.moveTo == (-1)) goto L12;
        if (r101 <= 0) goto L12;
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L12;
        WidgetGroup r103 = (WidgetGroup) ListProtector.get(r100, r102);
        if (this.moveTo != r103.f15335id) goto L11;
        moveTo(this.orientation, r103);
    L11:
        r102 = r102 + 1;
    L12:
        if (r101 != 0) goto L18;
        r100.remove(this);
        return;
    }

    public boolean intersectWith(WidgetGroup r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.widgets.size()) goto L10;
        if (r100.contains((ConstraintWidget) ListProtector.get(this.widgets, r101)) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public void setAuthoritative(boolean r100) {
        this.authoritative = r100;
    }

    public void setOrientation(int r100) {
        this.orientation = r100;
    }

    private int measureWrap(int r100, ConstraintWidget r101) {
        ConstraintWidget.DimensionBehaviour r102 = r101.getDimensionBehaviour(r100);
        if (r102 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
    L11:
        if (r100 != 0) goto L14;
        return r101.getWidth();
    L14:
        return r101.getHeight();
    L5:
        if (r102 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L11;
        if (r102 == ConstraintWidget.DimensionBehaviour.FIXED) goto L11;
        return -1;
    }

    public void moveTo(int r100, WidgetGroup r101) {
        Iterator<ConstraintWidget> r102 = this.widgets.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        ConstraintWidget r103 = r102.next();
        r101.add(r103);
        if (r100 == 0) goto L7;
        r103.verticalGroup = r101.getId();
        goto L4
    L7:
        r103.horizontalGroup = r101.getId();
        goto L4
    L9:
        this.moveTo = r101.f15335id;
    }

    public int measureWrap(LinearSystem r100, int r101) {
        if (this.widgets.size() != 0) goto L7;
        return 0;
    L7:
        return solverMeasure(r100, this.widgets, r101);
    }

    private int solverMeasure(LinearSystem r100, ArrayList<ConstraintWidget> r101, int r102) {
        int r103 = 0;
        ConstraintWidgetContainer r104 = (ConstraintWidgetContainer) ((ConstraintWidget) ListProtector.get(r101, 0)).getParent();
        r100.reset();
        r104.addToSolver(r100, false);
        int r105 = 0;
    L4:
        if (r105 >= r101.size()) goto L6;
        ((ConstraintWidget) ListProtector.get(r101, r105)).addToSolver(r100, false);
        r105 = r105 + 1;
        goto L4
    L6:
        if (r102 != 0) goto L11;
        if (r104.mHorizontalChainsSize <= 0) goto L11;
        Chain.applyChainConstraints(r104, r100, r101, 0);
    L11:
        if (r102 == 1) goto L13;
    L28:
        r100.minimize();     // Catch: Exception -> L17
    L19:
        this.results = new ArrayList();
    L21:
        if (r103 >= r101.size()) goto L23;
        MeasureResult r106 = new MeasureResult(this, (ConstraintWidget) ListProtector.get(r101, r103), r100, r102);
        this.results.add(r106);
        r103 = r103 + 1;
        goto L21
    L23:
        if (r102 != 0) goto L27;
        int r107 = r100.getObjectVariableValue(r104.mLeft);
        int r108 = r100.getObjectVariableValue(r104.mRight);
        r100.reset();
    L26:
        return r108 - r107;
    L27:
        r107 = r100.getObjectVariableValue(r104.mTop);
        r108 = r100.getObjectVariableValue(r104.mBottom);
        r100.reset();
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L13:
        if (r104.mVerticalChainsSize <= 0) goto L28;
        Chain.applyChainConstraints(r104, r100, r101, 1);
        goto L28
    }
}
