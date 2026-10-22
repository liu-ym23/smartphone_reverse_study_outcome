package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class Grid extends VirtualLayout {
    private static final boolean DEBUG_BOXES = false;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "Grid";
    public static final int VERTICAL = 1;
    private int[] mBoxViewIds;
    private View[] mBoxViews;
    private int mColumns;
    private int mColumnsSet;
    ConstraintLayout mContainer;
    private float mHorizontalGaps;
    private final int mMaxColumns;
    private final int mMaxRows;
    private int mNextAvailableIndex;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    Set<Integer> mSpanIds;
    private String mStrColumnWeights;
    private String mStrRowWeights;
    private String mStrSkips;
    private String mStrSpans;
    private boolean mUseRtl;
    private boolean mValidateInputs;
    private float mVerticalGaps;

    private boolean isSpansValid(CharSequence r1) {
        return true;
    }

    private boolean isWeightsValid(String r1) {
        return true;
    }

    public Grid(Context r1) {
        super(r1);
        this.mMaxRows = 50;
        this.mMaxColumns = 50;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
    }

    public Grid(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mMaxRows = 50;
        this.mMaxColumns = 50;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
    }

    public Grid(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mMaxRows = 50;
        this.mMaxColumns = 50;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r7) {
        super.init(r7);
        this.mUseViewMeasure = true;
        if (r7 == null) goto L55;
        TypedArray r8 = getContext().obtainStyledAttributes(r7, R.styleable.Grid);
        int r0 = r8.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L40;
        int r3 = r8.getIndex(r2);
        if (r3 != R.styleable.Grid_grid_rows) goto L10;
        this.mRowsSet = r8.getInteger(r3, 0);
    L39:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != R.styleable.Grid_grid_columns) goto L13;
        this.mColumnsSet = r8.getInteger(r3, 0);
        goto L39
    L13:
        if (r3 != R.styleable.Grid_grid_spans) goto L16;
        this.mStrSpans = r8.getString(r3);
        goto L39
    L16:
        if (r3 != R.styleable.Grid_grid_skips) goto L19;
        this.mStrSkips = r8.getString(r3);
        goto L39
    L19:
        if (r3 != R.styleable.Grid_grid_rowWeights) goto L22;
        this.mStrRowWeights = r8.getString(r3);
        goto L39
    L22:
        if (r3 != R.styleable.Grid_grid_columnWeights) goto L25;
        this.mStrColumnWeights = r8.getString(r3);
        goto L39
    L25:
        if (r3 != R.styleable.Grid_grid_orientation) goto L28;
        this.mOrientation = r8.getInt(r3, 0);
        goto L39
    L28:
        if (r3 != R.styleable.Grid_grid_horizontalGaps) goto L31;
        this.mHorizontalGaps = r8.getDimension(r3, 0.0f);
        goto L39
    L31:
        if (r3 != R.styleable.Grid_grid_verticalGaps) goto L34;
        this.mVerticalGaps = r8.getDimension(r3, 0.0f);
        goto L39
    L34:
        if (r3 != R.styleable.Grid_grid_validateInputs) goto L37;
        this.mValidateInputs = r8.getBoolean(r3, false);
        goto L39
    L37:
        if (r3 != R.styleable.Grid_grid_useRtl) goto L39;
        this.mUseRtl = r8.getBoolean(r3, false);
        goto L39
    L40:
        updateActualRowsAndColumns();
        initVariables();
        r8.recycle();
        return;
    }

    private void updateActualRowsAndColumns() {
        int r0 = this.mRowsSet;
        if (r0 == 0) goto L8;
        int r1 = this.mColumnsSet;
        if (r1 == 0) goto L8;
        this.mRows = r0;
        this.mColumns = r1;
        return;
    L8:
        int r2 = this.mColumnsSet;
        if (r2 <= 0) goto L11;
        this.mColumns = r2;
        this.mRows = ((this.mCount + this.mColumns) - 1) / this.mColumnsSet;
        return;
    L11:
        if (r0 <= 0) goto L13;
        this.mRows = r0;
        int r3 = this.mCount;
        int r4 = this.mRowsSet;
        this.mColumns = ((r3 + r4) - 1) / r4;
        return;
    L13:
        this.mRows = (int) (Math.sqrt(this.mCount) + 1.5d);
        int r5 = this.mCount;
        int r6 = this.mRows;
        this.mColumns = ((r5 + r6) - 1) / r6;
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        generateGrid(false);
    }

    private boolean generateGrid(boolean r6) {
        if (this.mContainer != null) goto L5;
        return false;
    L5:
        if (this.mRows >= 1) goto L7;
        return false;
    L7:
        if (this.mColumns < 1) goto L45;
        if (r6 == false) goto L19;
        int r7 = 0;
    L12:
        if (r7 >= this.mPositionMatrix.length) goto L18;
        int r0 = 0;
    L14:
        boolean[][] r3 = this.mPositionMatrix;
        if (r0 >= r3[0].length) goto L17;
        r3[r7][r0] = true;
        r0 = r0 + 1;
        goto L14
    L17:
        r7 = r7 + 1;
        goto L12
    L18:
        this.mSpanIds.clear();
    L19:
        this.mNextAvailableIndex = 0;
        buildBoxes();
        String r8 = this.mStrSkips;
        if (r8 != null) goto L22;
    L26:
        boolean r9 = true;
    L27:
        String r1 = this.mStrSpans;
        if (r1 == null) goto L35;
        if (r1.trim().isEmpty() == true) goto L35;
        int[][] r2 = parseSpans(this.mStrSpans);
        if (r2 == null) goto L35;
        r9 = r9 & handleSpans(this.mIds, r2);
    L35:
        if ((r9 & arrangeWidgets()) == true) goto L39;
        if (this.mValidateInputs == false) goto L39;
        return false;
    L39:
        return true;
    L22:
        if (r8.trim().isEmpty() == true) goto L26;
        int[][] r10 = parseSpans(this.mStrSkips);
        if (r10 == null) goto L26;
        r9 = handleSkips(r10) & true;
        goto L27
    L45:
        return false;
    }

    private void initVariables() {
        int r1 = 0;
        boolean[][] r0 = (boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{this.mRows, this.mColumns});
        this.mPositionMatrix = r0;
        int r4 = r0.length;
    L3:
        if (r1 >= r4) goto L5;
        Arrays.fill(r0[r1], true);
        r1 = r1 + 1;
        goto L3
    }

    private float[] parseWeights(int r3, String r4) {
        float[] r2 = null;
        if (r4 != null) goto L5;
    L13:
        return r2;
    L5:
        if (r4.trim().isEmpty() == true) goto L13;
        String[] r5 = r4.split(SimContactsConstants.EMAIL_SEP);
        if (r5.length == r3) goto L10;
        return null;
    L10:
        r2 = new float[r3];
        int r0 = 0;
    L11:
        if (r0 >= r3) goto L13;
        r2[r0] = Float.parseFloat(r5[r0].trim());
        r0 = r0 + 1;
        goto L11
    }

    private ConstraintLayout.LayoutParams params(View r1) {
        return (ConstraintLayout.LayoutParams) r1.getLayoutParams();
    }

    private void connectView(View r3, int r4, int r5, int r6, int r7) {
        ConstraintLayout.LayoutParams r0 = params(r3);
        r0.leftToLeft = this.mBoxViewIds[r5];
        r0.topToTop = this.mBoxViewIds[r4];
        r0.rightToRight = this.mBoxViewIds[(r5 + r7) - 1];
        r0.bottomToBottom = this.mBoxViewIds[(r4 + r6) - 1];
        r3.setLayoutParams(r0);
    }

    private boolean arrangeWidgets() {
        View[] r0 = getViews(this.mContainer);
        int r2 = 0;
    L4:
        if (r2 >= this.mCount) goto L13;
        if (this.mSpanIds.contains(Integer.valueOf(this.mIds[r2])) == true) goto L12;
        int r3 = getNextPosition();
        int r6 = getRowByIndex(r3);
        int r7 = getColByIndex(r3);
        if (r3 == (-1)) goto L10;
        connectView(r0[r2], r6, r7, 1, 1);
        goto L12
    L10:
        return false;
    L12:
        r2 = r2 + 1;
        goto L4
    L13:
        return true;
    }

    private int getRowByIndex(int r3) {
        if (this.mOrientation != 1) goto L7;
        return r3 % this.mRows;
    L7:
        return r3 / this.mColumns;
    }

    private int getColByIndex(int r3) {
        if (this.mOrientation != 1) goto L7;
        return r3 / this.mRows;
    L7:
        return r3 % this.mColumns;
    }

    private int getNextPosition() {
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r1 == true) goto L12;
        r2 = this.mNextAvailableIndex;
        if (r2 >= (this.mRows * this.mColumns)) goto L6;
        int r3 = getRowByIndex(r2);
        int r4 = getColByIndex(this.mNextAvailableIndex);
        boolean[] r5 = this.mPositionMatrix[r3];
        if (r5[r4] == false) goto L11;
        r5[r4] = false;
        r1 = true;
    L11:
        this.mNextAvailableIndex++;
        goto L3
    L6:
        return -1;
    L12:
        return r2;
    }

    private int[][] parseSpans(String r8) {
        if (isSpansValid(r8) == true) goto L6;
        return null;
    L6:
        String[] r7 = r8.split(SimContactsConstants.EMAIL_SEP);
        int[][] r9 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r7.length, 3});
        int r1 = 0;
    L8:
        if (r1 >= r7.length) goto L10;
        String[] r4 = r7[r1].trim().split(SimContactsConstants.ANR_SEP);
        String[] r5 = r4[1].split(MaterialConfigFormatNames.X);
        r9[r1][0] = Integer.parseInt(r4[0]);
        r9[r1][1] = Integer.parseInt(r5[0]);
        r9[r1][2] = Integer.parseInt(r5[1]);
        r1 = r1 + 1;
        goto L8
    L10:
        return r9;
    }

    private boolean handleSpans(int[] r12, int[][] r13) {
        View[] r0 = getViews(this.mContainer);
        int r2 = 0;
    L4:
        if (r2 >= r13.length) goto L9;
        int r7 = getRowByIndex(r13[r2][0]);
        int r8 = getColByIndex(r13[r2][0]);
        int[] r3 = r13[r2];
        if (invalidatePositions(r7, r8, r3[1], r3[2]) == false) goto L7;
        View r4 = r0[r2];
        int[] r5 = r13[r2];
        connectView(r4, r7, r8, r5[1], r5[2]);
        this.mSpanIds.add(Integer.valueOf(r12[r2]));
        r2 = r2 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private boolean handleSkips(int[][] r8) {
        int r1 = 0;
    L4:
        if (r1 >= r8.length) goto L9;
        int r2 = getRowByIndex(r8[r1][0]);
        int r4 = getColByIndex(r8[r1][0]);
        int[] r5 = r8[r1];
        if (invalidatePositions(r2, r4, r5[1], r5[2]) == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private boolean invalidatePositions(int r6, int r7, int r8, int r9) {
        int r0 = r6;
    L4:
        if (r0 >= (r6 + r8)) goto L18;
        int r1 = r7;
    L7:
        if (r1 >= (r7 + r9)) goto L17;
        boolean[][] r2 = this.mPositionMatrix;
        if (r0 >= r2.length) goto L16;
        if (r1 >= r2[0].length) goto L16;
        boolean[] r3 = r2[r0];
        if (r3[r1] == false) goto L16;
        r3[r1] = false;
        r1 = r1 + 1;
    L16:
        return false;
    L17:
        r0 = r0 + 1;
        goto L4
    L18:
        return true;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onDraw(Canvas r17) {
        super.onDraw(r17);
        if (isInEditMode() == true) goto L5;
        return;
    L5:
        Paint r0 = new Paint();
        r0.setColor(SupportMenu.CATEGORY_MASK);
        r0.setStyle(Paint.Style.STROKE);
        int r7 = getTop();
        int r8 = getLeft();
        int r9 = getBottom();
        int r10 = getRight();
        View[] r11 = this.mBoxViews;
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L8;
        View r1 = r11[r13];
        int r2 = r1.getLeft() - r8;
        int r14 = r1.getTop() - r7;
        int r3 = r1.getRight() - r8;
        int r15 = r1.getBottom() - r7;
        r17.drawRect(r2, 0.0f, r3, r9 - r7, r0);
        r17.drawRect(0.0f, r14, r10 - r8, r15, r0);
        r13 = r13 + 1;
        goto L6
    }

    private void setBoxViewHorizontalChains() {
        int r0 = getId();
        int r1 = Math.max(this.mRows, this.mColumns);
        float[] r2 = parseWeights(this.mColumns, this.mStrColumnWeights);
        int r4 = 0;
        ConstraintLayout.LayoutParams r3 = params(this.mBoxViews[0]);
        if (this.mColumns != 1) goto L6;
        clearHParams(this.mBoxViews[0]);
        r3.leftToLeft = r0;
        r3.rightToRight = r0;
        this.mBoxViews[0].setLayoutParams(r3);
        return;
    L6:
        int r5 = this.mColumns;
        if (r4 >= r5) goto L21;
        ConstraintLayout.LayoutParams r6 = params(this.mBoxViews[r4]);
        clearHParams(this.mBoxViews[r4]);
        if (r2 == null) goto L11;
        r6.horizontalWeight = r2[r4];
    L11:
        if (r4 <= 0) goto L13;
        r6.leftToRight = this.mBoxViewIds[r4 - 1];
    L15:
        if (r4 >= (this.mColumns - 1)) goto L17;
        r6.rightToLeft = this.mBoxViewIds[r4 + 1];
    L18:
        if (r4 <= 0) goto L20;
        r6.leftMargin = (int) this.mHorizontalGaps;
    L20:
        this.mBoxViews[r4].setLayoutParams(r6);
        r4 = r4 + 1;
        goto L6
    L17:
        r6.rightToRight = r0;
        goto L18
    L13:
        r6.leftToLeft = r0;
    L21:
        if (r5 >= r1) goto L23;
        ConstraintLayout.LayoutParams r7 = params(this.mBoxViews[r5]);
        clearHParams(this.mBoxViews[r5]);
        r7.leftToLeft = r0;
        r7.rightToRight = r0;
        this.mBoxViews[r5].setLayoutParams(r7);
        r5 = r5 + 1;
        goto L21
    }

    private void setBoxViewVerticalChains() {
        int r0 = getId();
        int r1 = Math.max(this.mRows, this.mColumns);
        float[] r2 = parseWeights(this.mRows, this.mStrRowWeights);
        int r4 = 0;
        if (this.mRows != 1) goto L6;
        ConstraintLayout.LayoutParams r3 = params(this.mBoxViews[0]);
        clearVParams(this.mBoxViews[0]);
        r3.topToTop = r0;
        r3.bottomToBottom = r0;
        this.mBoxViews[0].setLayoutParams(r3);
        return;
    L6:
        int r5 = this.mRows;
        if (r4 >= r5) goto L21;
        ConstraintLayout.LayoutParams r6 = params(this.mBoxViews[r4]);
        clearVParams(this.mBoxViews[r4]);
        if (r2 == null) goto L11;
        r6.verticalWeight = r2[r4];
    L11:
        if (r4 <= 0) goto L13;
        r6.topToBottom = this.mBoxViewIds[r4 - 1];
    L15:
        if (r4 >= (this.mRows - 1)) goto L17;
        r6.bottomToTop = this.mBoxViewIds[r4 + 1];
    L18:
        if (r4 <= 0) goto L20;
        r6.topMargin = (int) this.mHorizontalGaps;
    L20:
        this.mBoxViews[r4].setLayoutParams(r6);
        r4 = r4 + 1;
        goto L6
    L17:
        r6.bottomToBottom = r0;
        goto L18
    L13:
        r6.topToTop = r0;
    L21:
        if (r5 >= r1) goto L23;
        ConstraintLayout.LayoutParams r7 = params(this.mBoxViews[r5]);
        clearVParams(this.mBoxViews[r5]);
        r7.topToTop = r0;
        r7.bottomToBottom = r0;
        this.mBoxViews[r5].setLayoutParams(r7);
        r5 = r5 + 1;
        goto L21
    }

    private View makeNewView() {
        View r0 = new View(getContext());
        r0.setId(View.generateViewId());
        r0.setVisibility(4);
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(0, 0);
        this.mContainer.addView(r0, r1);
        return r0;
    }

    private void clearVParams(View r2) {
        ConstraintLayout.LayoutParams r1 = params(r2);
        r1.verticalWeight = -1.0f;
        r1.topToBottom = -1;
        r1.topToTop = -1;
        r1.bottomToTop = -1;
        r1.bottomToBottom = -1;
        r1.topMargin = -1;
        r2.setLayoutParams(r1);
    }

    private void clearHParams(View r2) {
        ConstraintLayout.LayoutParams r1 = params(r2);
        r1.horizontalWeight = -1.0f;
        r1.leftToRight = -1;
        r1.leftToLeft = -1;
        r1.rightToLeft = -1;
        r1.rightToRight = -1;
        r1.leftMargin = -1;
        r2.setLayoutParams(r1);
    }

    private void buildBoxes() {
        int r0 = Math.max(this.mRows, this.mColumns);
        View[] r1 = this.mBoxViews;
        int r2 = 0;
        if (r1 != null) goto L9;
        this.mBoxViews = new View[r0];
        int r3 = 0;
    L5:
        View[] r4 = this.mBoxViews;
        if (r3 >= r4.length) goto L22;
        r4[r3] = makeNewView();
        r3 = r3 + 1;
    L22:
        this.mBoxViewIds = new int[r0];
    L23:
        View[] r5 = this.mBoxViews;
        if (r2 >= r5.length) goto L26;
        this.mBoxViewIds[r2] = r5[r2].getId();
        r2 = r2 + 1;
        goto L23
    L26:
        setBoxViewVerticalChains();
        setBoxViewHorizontalChains();
        return;
    L9:
        if (r0 == r1.length) goto L22;
        View[] r6 = new View[r0];
        int r7 = 0;
    L11:
        if (r7 >= r0) goto L17;
        View[] r8 = this.mBoxViews;
        if (r7 >= r8.length) goto L15;
        r6[r7] = r8[r7];
    L16:
        r7 = r7 + 1;
        goto L11
    L15:
        r6[r7] = makeNewView();
        goto L16
    L17:
        int r9 = r0;
    L18:
        View[] r10 = this.mBoxViews;
        if (r9 >= r10.length) goto L21;
        this.mContainer.removeView(r10[r9]);
        r9 = r9 + 1;
        goto L18
    L21:
        this.mBoxViews = r6;
        goto L22
    }

    public int getRows() {
        return this.mRowsSet;
    }

    public void setRows(int r2) {
        if (r2 <= 50) goto L6;
        return;
    L6:
        if (this.mRowsSet != r2) goto L8;
        return;
    L8:
        this.mRowsSet = r2;
        updateActualRowsAndColumns();
        initVariables();
        generateGrid(false);
        invalidate();
    }

    public int getColumns() {
        return this.mColumnsSet;
    }

    public void setColumns(int r2) {
        if (r2 <= 50) goto L6;
        return;
    L6:
        if (this.mColumnsSet != r2) goto L8;
        return;
    L8:
        this.mColumnsSet = r2;
        updateActualRowsAndColumns();
        initVariables();
        generateGrid(false);
        invalidate();
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int r3) {
        if (r3 == 0) goto L7;
        if (r3 == 1) goto L7;
        return;
    L7:
        if (this.mOrientation != r3) goto L9;
        return;
    L9:
        this.mOrientation = r3;
        generateGrid(true);
        invalidate();
    }

    public String getSpans() {
        return this.mStrSpans;
    }

    public void setSpans(CharSequence r2) {
        if (isSpansValid(r2) == true) goto L5;
        return;
    L5:
        String r0 = this.mStrSpans;
        if (r0 != null) goto L8;
    L10:
        this.mStrSpans = r2.toString();
        generateGrid(true);
        invalidate();
        return;
    L8:
        if (r0.contentEquals(r2) == false) goto L10;
    }

    public String getSkips() {
        return this.mStrSkips;
    }

    public void setSkips(String r2) {
        if (isSpansValid(r2) == true) goto L5;
        return;
    L5:
        String r0 = this.mStrSkips;
        if (r0 != null) goto L8;
    L10:
        this.mStrSkips = r2;
        generateGrid(true);
        invalidate();
        return;
    L8:
        if (r0.equals(r2) == false) goto L10;
    }

    public String getRowWeights() {
        return this.mStrRowWeights;
    }

    public void setRowWeights(String r2) {
        if (isWeightsValid(r2) == true) goto L5;
        return;
    L5:
        String r0 = this.mStrRowWeights;
        if (r0 != null) goto L8;
    L10:
        this.mStrRowWeights = r2;
        generateGrid(true);
        invalidate();
        return;
    L8:
        if (r0.equals(r2) == false) goto L10;
    }

    public String getColumnWeights() {
        return this.mStrColumnWeights;
    }

    public void setColumnWeights(String r2) {
        if (isWeightsValid(r2) == true) goto L5;
        return;
    L5:
        String r0 = this.mStrColumnWeights;
        if (r0 != null) goto L8;
    L10:
        this.mStrColumnWeights = r2;
        generateGrid(true);
        invalidate();
        return;
    L8:
        if (r0.equals(r2) == false) goto L10;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public void setHorizontalGaps(float r2) {
        if (r2 >= 0.0f) goto L6;
        return;
    L6:
        if (this.mHorizontalGaps != r2) goto L8;
        return;
    L8:
        this.mHorizontalGaps = r2;
        generateGrid(true);
        invalidate();
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    public void setVerticalGaps(float r2) {
        if (r2 >= 0.0f) goto L6;
        return;
    L6:
        if (this.mVerticalGaps != r2) goto L8;
        return;
    L8:
        this.mVerticalGaps = r2;
        generateGrid(true);
        invalidate();
    }
}
