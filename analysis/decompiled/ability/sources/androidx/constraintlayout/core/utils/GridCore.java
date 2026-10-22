package androidx.constraintlayout.core.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appsearch.app.a;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class GridCore extends VirtualLayout {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int SPANS_RESPECT_WIDGET_ORDER = 2;
    public static final int SUB_GRID_BY_COL_ROW = 1;
    public static final int VERTICAL = 1;
    private ConstraintWidget[] mBoxWidgets;
    private String mColumnWeights;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    ConstraintWidgetContainer mContainer;
    private int mFlags;
    private float mHorizontalGaps;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private String mRowWeights;
    private int mRows;
    private int mRowsSet;
    private String mSkips;
    private int[][] mSpanMatrix;
    private String mSpans;
    private float mVerticalGaps;
    private boolean mExtraSpaceHandled = false;
    private int mNextAvailableIndex = 0;
    Set<String> mSpanIds = new HashSet();
    private int mSpanIndex = 0;

    public GridCore() {
        updateActualRowsAndColumns();
        initMatrices();
    }

    private void addConstraints() {
        setBoxWidgetVerticalChains();
        setBoxWidgetHorizontalChains();
        arrangeWidgets();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void arrangeWidgets() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r10.mWidgetsCount
            if (r1 >= r2) goto L75
            java.util.Set<java.lang.String> r2 = r10.mSpanIds
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r3 = r10.mWidgets
            r3 = r3[r1]
            java.lang.String r3 = r3.stringId
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L16
        L14:
            r3 = r10
            goto L71
        L16:
            int r2 = r10.getNextPosition()
            int r5 = r10.getRowByIndex(r2)
            int r6 = r10.getColByIndex(r2)
            r3 = -1
            if (r2 != r3) goto L26
            goto L75
        L26:
            boolean r3 = r10.isSpansRespectWidgetOrder()
            if (r3 == 0) goto L67
            int[][] r3 = r10.mSpanMatrix
            if (r3 == 0) goto L67
            int r4 = r10.mSpanIndex
            int r7 = r3.length
            if (r4 >= r7) goto L67
            r3 = r3[r4]
            r4 = r3[r0]
            if (r4 != r2) goto L67
            boolean[][] r2 = r10.mPositionMatrix
            r2 = r2[r5]
            r9 = 1
            r2[r6] = r9
            r2 = r3[r9]
            r4 = 2
            r3 = r3[r4]
            boolean r2 = r10.invalidatePositions(r5, r6, r2, r3)
            if (r2 != 0) goto L4e
            goto L14
        L4e:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r2 = r10.mWidgets
            r2 = r2[r1]
            int[][] r3 = r10.mSpanMatrix
            int r7 = r10.mSpanIndex
            r3 = r3[r7]
            r7 = r3[r9]
            r8 = r3[r4]
            r3 = r10
            r4 = r2
            r3.connectWidget(r4, r5, r6, r7, r8)
            int r10 = r3.mSpanIndex
            int r10 = r10 + r9
            r3.mSpanIndex = r10
            goto L71
        L67:
            r3 = r10
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r3.mWidgets
            r4 = r10[r1]
            r7 = 1
            r8 = 1
            r3.connectWidget(r4, r5, r6, r7, r8)
        L71:
            int r1 = r1 + 1
            r10 = r3
            goto L2
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.utils.GridCore.arrangeWidgets():void");
    }

    private void clearHorizontalAttributes(ConstraintWidget constraintWidget) {
        constraintWidget.setHorizontalWeight(-1.0f);
        constraintWidget.mLeft.reset();
        constraintWidget.mRight.reset();
    }

    private void clearVerticalAttributes(ConstraintWidget constraintWidget) {
        constraintWidget.setVerticalWeight(-1.0f);
        constraintWidget.mTop.reset();
        constraintWidget.mBottom.reset();
        constraintWidget.mBaseline.reset();
    }

    private void connectWidget(ConstraintWidget constraintWidget, int i, int i6, int i10, int i11) {
        constraintWidget.mLeft.connect(this.mBoxWidgets[i6].mLeft, 0);
        constraintWidget.mTop.connect(this.mBoxWidgets[i].mTop, 0);
        constraintWidget.mRight.connect(this.mBoxWidgets[(i6 + i11) - 1].mRight, 0);
        constraintWidget.mBottom.connect(this.mBoxWidgets[(i + i10) - 1].mBottom, 0);
    }

    private void createBoxes() {
        int iMax = Math.max(this.mRows, this.mColumns);
        ConstraintWidget[] constraintWidgetArr = this.mBoxWidgets;
        int i = 0;
        if (constraintWidgetArr == null) {
            this.mBoxWidgets = new ConstraintWidget[iMax];
            while (true) {
                ConstraintWidget[] constraintWidgetArr2 = this.mBoxWidgets;
                if (i >= constraintWidgetArr2.length) {
                    return;
                }
                constraintWidgetArr2[i] = makeNewWidget();
                i++;
            }
        } else {
            if (iMax == constraintWidgetArr.length) {
                return;
            }
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[iMax];
            while (i < iMax) {
                ConstraintWidget[] constraintWidgetArr4 = this.mBoxWidgets;
                if (i < constraintWidgetArr4.length) {
                    constraintWidgetArr3[i] = constraintWidgetArr4[i];
                } else {
                    constraintWidgetArr3[i] = makeNewWidget();
                }
                i++;
            }
            while (true) {
                ConstraintWidget[] constraintWidgetArr5 = this.mBoxWidgets;
                if (iMax >= constraintWidgetArr5.length) {
                    this.mBoxWidgets = constraintWidgetArr3;
                    return;
                } else {
                    this.mContainer.remove(constraintWidgetArr5[iMax]);
                    iMax++;
                }
            }
        }
    }

    private void fillConstraintMatrix(boolean z10) {
        int[][] spans;
        int[][] spans2;
        if (z10) {
            for (int i = 0; i < this.mPositionMatrix.length; i++) {
                int i6 = 0;
                while (true) {
                    boolean[][] zArr = this.mPositionMatrix;
                    if (i6 < zArr[0].length) {
                        zArr[i][i6] = true;
                        i6++;
                    }
                }
            }
            for (int i10 = 0; i10 < this.mConstraintMatrix.length; i10++) {
                int i11 = 0;
                while (true) {
                    int[][] iArr = this.mConstraintMatrix;
                    if (i11 < iArr[0].length) {
                        iArr[i10][i11] = -1;
                        i11++;
                    }
                }
            }
        }
        this.mNextAvailableIndex = 0;
        String str = this.mSkips;
        if (str != null && !str.trim().isEmpty() && (spans2 = parseSpans(this.mSkips, false)) != null) {
            handleSkips(spans2);
        }
        String str2 = this.mSpans;
        if (str2 == null || str2.trim().isEmpty() || (spans = parseSpans(this.mSpans, true)) == null) {
            return;
        }
        handleSpans(spans);
    }

    private int getColByIndex(int i) {
        return this.mOrientation == 1 ? i / this.mRows : i % this.mColumns;
    }

    private int getNextPosition() {
        boolean z10 = false;
        int i = 0;
        while (!z10) {
            i = this.mNextAvailableIndex;
            if (i >= this.mRows * this.mColumns) {
                return -1;
            }
            int rowByIndex = getRowByIndex(i);
            int colByIndex = getColByIndex(this.mNextAvailableIndex);
            boolean[] zArr = this.mPositionMatrix[rowByIndex];
            if (zArr[colByIndex]) {
                zArr[colByIndex] = false;
                z10 = true;
            }
            this.mNextAvailableIndex++;
        }
        return i;
    }

    private int getRowByIndex(int i) {
        return this.mOrientation == 1 ? i % this.mRows : i / this.mColumns;
    }

    private void handleSkips(int[][] iArr) {
        for (int[] iArr2 : iArr) {
            if (!invalidatePositions(getRowByIndex(iArr2[0]), getColByIndex(iArr2[0]), iArr2[1], iArr2[2])) {
                return;
            }
        }
    }

    private void handleSpans(int[][] iArr) {
        if (isSpansRespectWidgetOrder()) {
            return;
        }
        int i = 0;
        while (i < iArr.length) {
            int rowByIndex = this.getRowByIndex(iArr[i][0]);
            int colByIndex = this.getColByIndex(iArr[i][0]);
            int[] iArr2 = iArr[i];
            if (!this.invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                return;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i];
            int[] iArr3 = iArr[i];
            GridCore gridCore = this;
            gridCore.connectWidget(constraintWidget, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
            gridCore.mSpanIds.add(gridCore.mWidgets[i].stringId);
            i++;
            this = gridCore;
        }
    }

    private void initMatrices() {
        boolean[][] zArr;
        int[][] iArr = this.mConstraintMatrix;
        boolean z10 = false;
        if (iArr != null && iArr.length == this.mWidgetsCount && (zArr = this.mPositionMatrix) != null && zArr.length == this.mRows && zArr[0].length == this.mColumns) {
            z10 = true;
        }
        if (!z10) {
            initVariables();
        }
        fillConstraintMatrix(z10);
    }

    private void initVariables() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        this.mPositionMatrix = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
        int i = this.mWidgetsCount;
        if (i > 0) {
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, 4);
            this.mConstraintMatrix = iArr;
            for (int[] iArr2 : iArr) {
                Arrays.fill(iArr2, -1);
            }
        }
    }

    private boolean invalidatePositions(int i, int i6, int i10, int i11) {
        for (int i12 = i; i12 < i + i10; i12++) {
            for (int i13 = i6; i13 < i6 + i11; i13++) {
                boolean[][] zArr = this.mPositionMatrix;
                if (i12 < zArr.length && i13 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i12];
                    if (zArr2[i13]) {
                        zArr2[i13] = false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isSpansRespectWidgetOrder() {
        return (this.mFlags & 2) > 0;
    }

    private boolean isSubGridByColRow() {
        return (this.mFlags & 1) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$parseSpans$0(String str, String str2) {
        return Integer.parseInt(str.split(":")[0]) - Integer.parseInt(str2.split(":")[0]);
    }

    private ConstraintWidget makeNewWidget() {
        ConstraintWidget constraintWidget = new ConstraintWidget();
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        constraintWidget.stringId = String.valueOf(constraintWidget.hashCode());
        return constraintWidget;
    }

    private int[][] parseSpans(String str, boolean z10) {
        try {
            String[] strArrSplit = str.split(",");
            Arrays.sort(strArrSplit, new a(3));
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, strArrSplit.length, 3);
            if (this.mRows != 1 && this.mColumns != 1) {
                for (int i = 0; i < strArrSplit.length; i++) {
                    String[] strArrSplit2 = strArrSplit[i].trim().split(":");
                    String[] strArrSplit3 = strArrSplit2[1].split("x");
                    iArr[i][0] = Integer.parseInt(strArrSplit2[0]);
                    if (isSubGridByColRow()) {
                        iArr[i][1] = Integer.parseInt(strArrSplit3[1]);
                        iArr[i][2] = Integer.parseInt(strArrSplit3[0]);
                    } else {
                        iArr[i][1] = Integer.parseInt(strArrSplit3[0]);
                        iArr[i][2] = Integer.parseInt(strArrSplit3[1]);
                    }
                }
                return iArr;
            }
            int i6 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < strArrSplit.length; i11++) {
                String[] strArrSplit4 = strArrSplit[i11].trim().split(":");
                iArr[i11][0] = Integer.parseInt(strArrSplit4[0]);
                int[] iArr2 = iArr[i11];
                iArr2[1] = 1;
                iArr2[2] = 1;
                if (this.mColumns == 1) {
                    iArr2[1] = Integer.parseInt(strArrSplit4[1]);
                    i6 += iArr[i11][1];
                    if (z10) {
                        i6--;
                    }
                }
                if (this.mRows == 1) {
                    iArr[i11][2] = Integer.parseInt(strArrSplit4[1]);
                    i10 += iArr[i11][2];
                    if (z10) {
                        i10--;
                    }
                }
            }
            if (i6 != 0 && !this.mExtraSpaceHandled) {
                setRows(this.mRows + i6);
            }
            if (i10 != 0 && !this.mExtraSpaceHandled) {
                setColumns(this.mColumns + i10);
            }
            this.mExtraSpaceHandled = true;
            return iArr;
        } catch (Exception unused) {
            return null;
        }
    }

    private float[] parseWeights(int i, String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        float[] fArr = new float[i];
        for (int i6 = 0; i6 < i; i6++) {
            if (i6 < strArrSplit.length) {
                try {
                    fArr[i6] = Float.parseFloat(strArrSplit[i6]);
                } catch (Exception e) {
                    System.err.println("Error parsing `" + strArrSplit[i6] + "`: " + e.getMessage());
                    fArr[i6] = 1.0f;
                }
            } else {
                fArr[i6] = 1.0f;
            }
        }
        return fArr;
    }

    private void setBoxWidgetHorizontalChains() {
        int i;
        int iMax = Math.max(this.mRows, this.mColumns);
        ConstraintWidget constraintWidget = this.mBoxWidgets[0];
        float[] weights = parseWeights(this.mColumns, this.mColumnWeights);
        if (this.mColumns == 1) {
            clearHorizontalAttributes(constraintWidget);
            constraintWidget.mLeft.connect(this.mLeft, 0);
            constraintWidget.mRight.connect(this.mRight, 0);
            return;
        }
        int i6 = 0;
        while (true) {
            i = this.mColumns;
            if (i6 >= i) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.mBoxWidgets[i6];
            clearHorizontalAttributes(constraintWidget2);
            if (weights != null) {
                constraintWidget2.setHorizontalWeight(weights[i6]);
            }
            if (i6 > 0) {
                constraintWidget2.mLeft.connect(this.mBoxWidgets[i6 - 1].mRight, 0);
            } else {
                constraintWidget2.mLeft.connect(this.mLeft, 0);
            }
            if (i6 < this.mColumns - 1) {
                constraintWidget2.mRight.connect(this.mBoxWidgets[i6 + 1].mLeft, 0);
            } else {
                constraintWidget2.mRight.connect(this.mRight, 0);
            }
            if (i6 > 0) {
                constraintWidget2.mLeft.mMargin = (int) this.mHorizontalGaps;
            }
            i6++;
        }
        while (i < iMax) {
            ConstraintWidget constraintWidget3 = this.mBoxWidgets[i];
            clearHorizontalAttributes(constraintWidget3);
            constraintWidget3.mLeft.connect(this.mLeft, 0);
            constraintWidget3.mRight.connect(this.mRight, 0);
            i++;
        }
    }

    private void setBoxWidgetVerticalChains() {
        int i;
        int iMax = Math.max(this.mRows, this.mColumns);
        ConstraintWidget constraintWidget = this.mBoxWidgets[0];
        float[] weights = parseWeights(this.mRows, this.mRowWeights);
        if (this.mRows == 1) {
            clearVerticalAttributes(constraintWidget);
            constraintWidget.mTop.connect(this.mTop, 0);
            constraintWidget.mBottom.connect(this.mBottom, 0);
            return;
        }
        int i6 = 0;
        while (true) {
            i = this.mRows;
            if (i6 >= i) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.mBoxWidgets[i6];
            clearVerticalAttributes(constraintWidget2);
            if (weights != null) {
                constraintWidget2.setVerticalWeight(weights[i6]);
            }
            if (i6 > 0) {
                constraintWidget2.mTop.connect(this.mBoxWidgets[i6 - 1].mBottom, 0);
            } else {
                constraintWidget2.mTop.connect(this.mTop, 0);
            }
            if (i6 < this.mRows - 1) {
                constraintWidget2.mBottom.connect(this.mBoxWidgets[i6 + 1].mTop, 0);
            } else {
                constraintWidget2.mBottom.connect(this.mBottom, 0);
            }
            if (i6 > 0) {
                constraintWidget2.mTop.mMargin = (int) this.mVerticalGaps;
            }
            i6++;
        }
        while (i < iMax) {
            ConstraintWidget constraintWidget3 = this.mBoxWidgets[i];
            clearVerticalAttributes(constraintWidget3);
            constraintWidget3.mTop.connect(this.mTop, 0);
            constraintWidget3.mBottom.connect(this.mBottom, 0);
            i++;
        }
    }

    private void setupGrid(boolean z10) {
        int[][] spans;
        if (this.mRows < 1 || this.mColumns < 1) {
            return;
        }
        if (z10) {
            for (int i = 0; i < this.mPositionMatrix.length; i++) {
                int i6 = 0;
                while (true) {
                    boolean[][] zArr = this.mPositionMatrix;
                    if (i6 < zArr[0].length) {
                        zArr[i][i6] = true;
                        i6++;
                    }
                }
            }
            this.mSpanIds.clear();
        }
        this.mNextAvailableIndex = 0;
        String str = this.mSkips;
        if (str != null && !str.trim().isEmpty() && (spans = parseSpans(this.mSkips, false)) != null) {
            handleSkips(spans);
        }
        String str2 = this.mSpans;
        if (str2 != null && !str2.trim().isEmpty()) {
            this.mSpanMatrix = parseSpans(this.mSpans, true);
        }
        createBoxes();
        int[][] iArr = this.mSpanMatrix;
        if (iArr != null) {
            handleSpans(iArr);
        }
    }

    private void updateActualRowsAndColumns() {
        int i;
        int i6 = this.mRowsSet;
        if (i6 != 0 && (i = this.mColumnsSet) != 0) {
            this.mRows = i6;
            this.mColumns = i;
            return;
        }
        int i10 = this.mColumnsSet;
        if (i10 > 0) {
            this.mColumns = i10;
            this.mRows = ((this.mWidgetsCount + i10) - 1) / i10;
        } else if (i6 > 0) {
            this.mRows = i6;
            this.mColumns = ((this.mWidgetsCount + i6) - 1) / i6;
        } else {
            int iSqrt = (int) (Math.sqrt(this.mWidgetsCount) + 1.5d);
            this.mRows = iSqrt;
            this.mColumns = ((this.mWidgetsCount + iSqrt) - 1) / iSqrt;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(@Nullable LinearSystem linearSystem, boolean z10) {
        super.addToSolver(linearSystem, z10);
        addConstraints();
    }

    @Nullable
    public String getColumnWeights() {
        return this.mColumnWeights;
    }

    @Nullable
    public ConstraintWidgetContainer getContainer() {
        return this.mContainer;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @Nullable
    public String getRowWeights() {
        return this.mRowWeights;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i, int i6, int i10, int i11) {
        super.measure(i, i6, i10, i11);
        this.mContainer = (ConstraintWidgetContainer) getParent();
        setupGrid(false);
        this.mContainer.add(this.mBoxWidgets);
    }

    public void setColumnWeights(@NonNull String str) {
        String str2 = this.mColumnWeights;
        if (str2 == null || !str2.equals(str)) {
            this.mColumnWeights = str;
        }
    }

    public void setColumns(int i) {
        if (i <= 50 && this.mColumnsSet != i) {
            this.mColumnsSet = i;
            updateActualRowsAndColumns();
            initVariables();
        }
    }

    public void setContainer(@NonNull ConstraintWidgetContainer constraintWidgetContainer) {
        this.mContainer = constraintWidgetContainer;
    }

    public void setFlags(int i) {
        this.mFlags = i;
    }

    public void setHorizontalGaps(float f) {
        if (f >= 0.0f && this.mHorizontalGaps != f) {
            this.mHorizontalGaps = f;
        }
    }

    public void setOrientation(int i) {
        if ((i == 0 || i == 1) && this.mOrientation != i) {
            this.mOrientation = i;
        }
    }

    public void setRowWeights(@NonNull String str) {
        String str2 = this.mRowWeights;
        if (str2 == null || !str2.equals(str)) {
            this.mRowWeights = str;
        }
    }

    public void setRows(int i) {
        if (i <= 50 && this.mRowsSet != i) {
            this.mRowsSet = i;
            updateActualRowsAndColumns();
            initVariables();
        }
    }

    public void setSkips(@NonNull String str) {
        String str2 = this.mSkips;
        if (str2 == null || !str2.equals(str)) {
            this.mExtraSpaceHandled = false;
            this.mSkips = str;
        }
    }

    public void setSpans(@NonNull CharSequence charSequence) {
        String str = this.mSpans;
        if (str == null || !str.equals(charSequence.toString())) {
            this.mExtraSpaceHandled = false;
            this.mSpans = charSequence.toString();
        }
    }

    public void setVerticalGaps(float f) {
        if (f >= 0.0f && this.mVerticalGaps != f) {
            this.mVerticalGaps = f;
        }
    }

    public GridCore(int i, int i6) {
        this.mRowsSet = i;
        this.mColumnsSet = i6;
        if (i > 50) {
            this.mRowsSet = 3;
        }
        if (i6 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initMatrices();
    }
}
