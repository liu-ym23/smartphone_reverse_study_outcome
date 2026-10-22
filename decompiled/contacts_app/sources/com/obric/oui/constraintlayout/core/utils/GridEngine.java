package com.obric.oui.constraintlayout.core.utils;

import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class GridEngine {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int VERTICAL = 1;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    private int mNextAvailableIndex;
    private int mNumWidgets;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    private String mStrSkips;
    private String mStrSpans;

    private boolean isSpansValid(CharSequence r1) {
        if (r1 != null) goto L5;
        return false;
    L5:
        return true;
    }

    public GridEngine() {
        this.mNextAvailableIndex = 0;
    }

    public GridEngine(int r3, int r4) {
        this.mNextAvailableIndex = 0;
        this.mRowsSet = r3;
        this.mColumnsSet = r4;
        if (r3 <= 50) goto L5;
        this.mRowsSet = 3;
    L5:
        if (r4 <= 50) goto L7;
        this.mColumnsSet = 3;
    L7:
        updateActualRowsAndColumns();
        initVariables();
    }

    public GridEngine(int r4, int r5, int r6) {
        this.mNextAvailableIndex = 0;
        this.mRowsSet = r4;
        this.mColumnsSet = r5;
        this.mNumWidgets = r6;
        if (r4 <= 50) goto L5;
        this.mRowsSet = 3;
    L5:
        if (r5 <= 50) goto L7;
        this.mColumnsSet = 3;
    L7:
        updateActualRowsAndColumns();
        int r7 = this.mRows;
        int r8 = this.mColumns;
        if (r6 <= (r7 * r8)) goto L10;
    L11:
        this.mNumWidgets = r7 * r8;
    L12:
        initVariables();
        fillConstraintMatrix(false);
        return;
    L10:
        if (r6 >= 1) goto L12;
        goto L11
    }

    private void initVariables() {
        int r1 = 0;
        boolean[][] r0 = (boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{this.mRows, this.mColumns});
        this.mPositionMatrix = r0;
        int r3 = r0.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        Arrays.fill(r0[r5], true);
        r5 = r5 + 1;
        goto L3
    L5:
        int r2 = this.mNumWidgets;
        if (r2 <= 0) goto L10;
        int[][] r4 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r2, 4});
        this.mConstraintMatrix = r4;
        int r7 = r4.length;
    L8:
        if (r1 >= r7) goto L13;
        Arrays.fill(r4[r1], -1);
        r1 = r1 + 1;
        goto L8
    L13:
        return;
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

    private void fillConstraintMatrix(boolean r5) {
        if (r5 == false) goto L20;
        int r6 = 0;
    L6:
        if (r6 >= this.mPositionMatrix.length) goto L12;
        int r1 = 0;
    L8:
        boolean[][] r2 = this.mPositionMatrix;
        if (r1 >= r2[0].length) goto L11;
        r2[r6][r1] = true;
        r1 = r1 + 1;
        goto L8
    L11:
        r6 = r6 + 1;
        goto L6
    L12:
        int r7 = 0;
    L14:
        if (r7 >= this.mConstraintMatrix.length) goto L20;
        int r3 = 0;
    L16:
        int[][] r4 = this.mConstraintMatrix;
        if (r3 >= r4[0].length) goto L19;
        r4[r7][r3] = -1;
        r3 = r3 + 1;
        goto L16
    L19:
        r7 = r7 + 1;
    L20:
        this.mNextAvailableIndex = 0;
        String r8 = this.mStrSkips;
        if (r8 != null) goto L23;
    L27:
        String r9 = this.mStrSpans;
        if (r9 != null) goto L30;
    L34:
        addAllConstraintPositions();
        return;
    L30:
        if (r9.trim().isEmpty() == true) goto L34;
        int[][] r10 = parseSpans(this.mStrSpans);
        if (r10 == null) goto L34;
        handleSpans(r10);
        goto L34
    L23:
        if (r8.trim().isEmpty() == true) goto L27;
        int[][] r11 = parseSpans(this.mStrSkips);
        if (r11 == null) goto L27;
        handleSkips(r11);
        goto L27
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

    private void addConstraintPosition(int r1, int r2, int r3, int r4, int r5) {
        int[] r0 = this.mConstraintMatrix[r1];
        r0[0] = r3;
        r0[1] = r2;
        r0[2] = (r3 + r5) - 1;
        r0[3] = (r2 + r4) - 1;
    }

    private void handleSpans(int[][] r9) {
        int r7 = 0;
    L4:
        if (r7 >= r9.length) goto L9;
        int r3 = getRowByIndex(r9[r7][0]);
        int r4 = getColByIndex(r9[r7][0]);
        int[] r1 = r9[r7];
        if (invalidatePositions(r3, r4, r1[1], r1[2]) == false) goto L7;
        int[] r2 = r9[r7];
        addConstraintPosition(r7, r3, r4, r2[1], r2[2]);
        r7 = r7 + 1;
        goto L4
    L7:
        return;
    }

    private void handleSkips(int[][] r8) {
        int r1 = 0;
    L4:
        if (r1 >= r8.length) goto L9;
        int r2 = getRowByIndex(r8[r1][0]);
        int r3 = getColByIndex(r8[r1][0]);
        int[] r4 = r8[r1];
        if (invalidatePositions(r2, r3, r4[1], r4[2]) == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return;
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

    private void addAllConstraintPositions() {
        int r0 = 0;
    L4:
        if (r0 >= this.mNumWidgets) goto L13;
        if (leftOfWidget(r0) != (-1)) goto L12;
        int r1 = getNextPosition();
        int r3 = getRowByIndex(r1);
        int r4 = getColByIndex(r1);
        if (r1 == (-1)) goto L10;
        addConstraintPosition(r0, r3, r4, 1, 1);
        goto L12
    L10:
        return;
    L12:
        r0 = r0 + 1;
        goto L4
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
        this.mRows = ((this.mNumWidgets + r2) - 1) / r2;
        return;
    L11:
        if (r0 <= 0) goto L13;
        this.mRows = r0;
        this.mColumns = ((this.mNumWidgets + r0) - 1) / r0;
        return;
    L13:
        int r3 = (int) (Math.sqrt(this.mNumWidgets) + 1.5d);
        this.mRows = r3;
        this.mColumns = ((this.mNumWidgets + r3) - 1) / r3;
    }

    public void setup() {
        int[][] r0 = this.mConstraintMatrix;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L14:
        if (r1 == true) goto L16;
        initVariables();
    L16:
        fillConstraintMatrix(r1);
        return;
    L5:
        if (r0.length != this.mNumWidgets) goto L14;
        boolean[][] r2 = this.mPositionMatrix;
        if (r2 == null) goto L14;
        if (r2.length != this.mRows) goto L14;
        if (r2[0].length != this.mColumns) goto L14;
        r1 = true;
        goto L14
    }

    public void setSpans(CharSequence r3) {
        String r0 = this.mStrSpans;
        if (r0 != null) goto L5;
    L7:
        this.mStrSpans = r3.toString();
        return;
    L5:
        if (r0.equals(r3.toString()) == false) goto L7;
    }

    public void setSkips(String r2) {
        String r0 = this.mStrSkips;
        if (r0 != null) goto L5;
    L7:
        this.mStrSkips = r2;
        return;
    L5:
        if (r0.equals(r2) == false) goto L7;
    }

    public void setOrientation(int r2) {
        if (r2 == 0) goto L7;
        if (r2 == 1) goto L7;
        return;
    L7:
        if (this.mOrientation != r2) goto L9;
        return;
    L9:
        this.mOrientation = r2;
    }

    public void setNumWidgets(int r3) {
        if (r3 <= (this.mRows * this.mColumns)) goto L5;
        return;
    L5:
        this.mNumWidgets = r3;
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
    }

    public int leftOfWidget(int r3) {
        int[][] r2 = this.mConstraintMatrix;
        if (r2 != null) goto L5;
    L9:
        return 0;
    L5:
        if (r3 >= r2.length) goto L9;
        return r2[r3][0];
    }

    public int topOfWidget(int r2) {
        int[][] r1 = this.mConstraintMatrix;
        if (r1 != null) goto L5;
        return 0;
    L5:
        if (r2 < r1.length) goto L8;
        return 0;
    L8:
        return r1[r2][1];
    }

    public int rightOfWidget(int r2) {
        int[][] r1 = this.mConstraintMatrix;
        if (r1 != null) goto L5;
        return 0;
    L5:
        if (r2 < r1.length) goto L8;
        return 0;
    L8:
        return r1[r2][2];
    }

    public int bottomOfWidget(int r2) {
        int[][] r1 = this.mConstraintMatrix;
        if (r1 != null) goto L5;
        return 0;
    L5:
        if (r2 < r1.length) goto L8;
        return 0;
    L8:
        return r1[r2][3];
    }
}
