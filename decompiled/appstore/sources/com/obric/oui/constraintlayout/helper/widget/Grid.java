package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class Grid extends VirtualLayout {
    public int A;
    public boolean B;
    public boolean C;
    public boolean[][] D;
    public Set E;
    public int[] F;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f13513l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f13514m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View[] f13515n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ConstraintLayout f13516o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13517p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13518q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13519r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13520s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f13521t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f13522u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f13523v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f13524w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f13525x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f13526y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13527z;

    public Grid(Context r10) {
        super(r10);
        this.f13513l = 50;
        this.f13514m = 50;
        this.A = 0;
        this.E = new HashSet();
    }

    private int getNextPosition() {
        boolean r10 = false;
        int r11 = 0;
    L3:
        if (r10 == true) goto L12;
        r11 = this.A;
        if (r11 >= (this.f13517p * this.f13519r)) goto L6;
        int r12 = B(r11);
        int r13 = A(this.A);
        boolean[] r14 = this.D[r12];
        if (r14[r13] == false) goto L11;
        r14[r13] = false;
        r10 = true;
    L11:
        this.A++;
        goto L3
    L6:
        return -1;
    L12:
        return r11;
    }

    public final int A(int r10) {
        if (this.f13527z != 1) goto L7;
        return r10 / this.f13517p;
    L7:
        return r10 % this.f13519r;
    }

    public final int B(int r10) {
        if (this.f13527z != 1) goto L7;
        return r10 % this.f13517p;
    L7:
        return r10 / this.f13519r;
    }

    public final boolean C(int[][] r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L9;
        int r12 = B(r10[r11][0]);
        int r13 = A(r10[r11][0]);
        int[] r14 = r10[r11];
        if (F(r12, r13, r14[1], r14[2]) == false) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public final boolean D(int[] r12, int[][] r13) {
        View[] r10 = j(this.f13516o);
        int r11 = 0;
    L4:
        if (r11 >= r13.length) goto L9;
        int r14 = B(r13[r11][0]);
        int r15 = A(r13[r11][0]);
        int[] r16 = r13[r11];
        if (F(r14, r15, r16[1], r16[2]) == false) goto L7;
        View r17 = r10[r11];
        int[] r18 = r13[r11];
        y(r17, r14, r15, r18[1], r18[2]);
        this.E.add(Integer.valueOf(r12[r11]));
        r11 = r11 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public final void E() {
        int r10 = 0;
        boolean[][] r11 = (boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{this.f13517p, this.f13519r});
        this.D = r11;
        int r12 = r11.length;
    L3:
        if (r10 >= r12) goto L5;
        Arrays.fill(r11[r10], true);
        r10 = r10 + 1;
        goto L3
    }

    public final boolean F(int r10, int r11, int r12, int r13) {
        int r14 = r10;
    L4:
        if (r14 >= (r10 + r12)) goto L18;
        int r15 = r11;
    L7:
        if (r15 >= (r11 + r13)) goto L17;
        boolean[][] r16 = this.D;
        if (r14 >= r16.length) goto L16;
        if (r15 >= r16[0].length) goto L16;
        boolean[] r17 = r16[r14];
        if (r17[r15] == false) goto L16;
        r17[r15] = false;
        r15 = r15 + 1;
    L16:
        return false;
    L17:
        r14 = r14 + 1;
        goto L4
    L18:
        return true;
    }

    public final boolean G(CharSequence r10) {
        return true;
    }

    public final boolean H(String r10) {
        return true;
    }

    public final View I() {
        View r10 = new View(getContext());
        r10.setId(View.generateViewId());
        r10.setVisibility(4);
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(0, 0);
        this.f13516o.addView(r10, r11);
        return r10;
    }

    public final ConstraintLayout.LayoutParams J(View r10) {
        return (ConstraintLayout.LayoutParams) r10.getLayoutParams();
    }

    public final int[][] K(String r10) {
        if (G(r10) == true) goto L6;
        return null;
    L6:
        String[] r11 = r10.split(",");
        int[][] r12 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r11.length, 3});
        int r13 = 0;
    L8:
        if (r13 >= r11.length) goto L10;
        String[] r14 = r11[r13].trim().split(":");
        String[] r15 = r14[1].split(FixCard.FixStyle.KEY_X);
        r12[r13][0] = Integer.parseInt(r14[0]);
        r12[r13][1] = Integer.parseInt(r15[0]);
        r12[r13][2] = Integer.parseInt(r15[1]);
        r13 = r13 + 1;
        goto L8
    L10:
        return r12;
    }

    public final float[] L(int r10, String r11) {
        float[] r12 = null;
        if (r11 != null) goto L5;
    L13:
        return r12;
    L5:
        if (r11.trim().isEmpty() == true) goto L13;
        String[] r13 = r11.split(",");
        if (r13.length == r10) goto L10;
        return null;
    L10:
        r12 = new float[r10];
        int r14 = 0;
    L11:
        if (r14 >= r10) goto L13;
        r12[r14] = Float.parseFloat(r13[r14].trim());
        r14 = r14 + 1;
        goto L11
    }

    public final void M() {
        int r10 = getId();
        int r11 = Math.max(this.f13517p, this.f13519r);
        float[] r12 = L(this.f13519r, this.f13524w);
        int r13 = 0;
        ConstraintLayout.LayoutParams r14 = J(this.f13515n[0]);
        if (this.f13519r != 1) goto L6;
        w(this.f13515n[0]);
        r14.f14094e = r10;
        r14.f14100h = r10;
        this.f13515n[0].setLayoutParams(r14);
        return;
    L6:
        int r15 = this.f13519r;
        if (r13 >= r15) goto L21;
        ConstraintLayout.LayoutParams r16 = J(this.f13515n[r13]);
        w(this.f13515n[r13]);
        if (r12 == null) goto L11;
        r16.L = r12[r13];
    L11:
        if (r13 <= 0) goto L13;
        r16.f14096f = this.F[r13 - 1];
    L15:
        if (r13 >= (this.f13519r - 1)) goto L17;
        r16.f14098g = this.F[r13 + 1];
    L18:
        if (r13 <= 0) goto L20;
        ((ViewGroup.MarginLayoutParams) r16).leftMargin = (int) this.f13525x;
    L20:
        this.f13515n[r13].setLayoutParams(r16);
        r13 = r13 + 1;
        goto L6
    L17:
        r16.f14100h = r10;
        goto L18
    L13:
        r16.f14094e = r10;
    L21:
        if (r15 >= r11) goto L23;
        ConstraintLayout.LayoutParams r17 = J(this.f13515n[r15]);
        w(this.f13515n[r15]);
        r17.f14094e = r10;
        r17.f14100h = r10;
        this.f13515n[r15].setLayoutParams(r17);
        r15 = r15 + 1;
        goto L21
    }

    public final void N() {
        int r10 = getId();
        int r11 = Math.max(this.f13517p, this.f13519r);
        float[] r12 = L(this.f13517p, this.f13523v);
        int r13 = 0;
        if (this.f13517p != 1) goto L6;
        ConstraintLayout.LayoutParams r14 = J(this.f13515n[0]);
        x(this.f13515n[0]);
        r14.f14102i = r10;
        r14.f14108l = r10;
        this.f13515n[0].setLayoutParams(r14);
        return;
    L6:
        int r15 = this.f13517p;
        if (r13 >= r15) goto L21;
        ConstraintLayout.LayoutParams r16 = J(this.f13515n[r13]);
        x(this.f13515n[r13]);
        if (r12 == null) goto L11;
        r16.M = r12[r13];
    L11:
        if (r13 <= 0) goto L13;
        r16.f14104j = this.F[r13 - 1];
    L15:
        if (r13 >= (this.f13517p - 1)) goto L17;
        r16.f14106k = this.F[r13 + 1];
    L18:
        if (r13 <= 0) goto L20;
        ((ViewGroup.MarginLayoutParams) r16).topMargin = (int) this.f13525x;
    L20:
        this.f13515n[r13].setLayoutParams(r16);
        r13 = r13 + 1;
        goto L6
    L17:
        r16.f14108l = r10;
        goto L18
    L13:
        r16.f14102i = r10;
    L21:
        if (r15 >= r11) goto L23;
        ConstraintLayout.LayoutParams r17 = J(this.f13515n[r15]);
        x(this.f13515n[r15]);
        r17.f14102i = r10;
        r17.f14108l = r10;
        this.f13515n[r15].setLayoutParams(r17);
        r15 = r15 + 1;
        goto L21
    }

    public final void O() {
        int r10 = this.f13518q;
        if (r10 == 0) goto L8;
        int r11 = this.f13520s;
        if (r11 == 0) goto L8;
        this.f13517p = r10;
        this.f13519r = r11;
        return;
    L8:
        int r12 = this.f13520s;
        if (r12 <= 0) goto L11;
        this.f13519r = r12;
        this.f13517p = ((this.f14052b + r12) - 1) / r12;
        return;
    L11:
        if (r10 <= 0) goto L13;
        this.f13517p = r10;
        this.f13519r = ((this.f14052b + r10) - 1) / r10;
        return;
    L13:
        int r13 = (int) (Math.sqrt(this.f14052b) + 1.5d);
        this.f13517p = r13;
        this.f13519r = ((this.f14052b + r13) - 1) / r13;
    }

    public String getColumnWeights() {
        return this.f13524w;
    }

    public int getColumns() {
        return this.f13520s;
    }

    public float getHorizontalGaps() {
        return this.f13525x;
    }

    public int getOrientation() {
        return this.f13527z;
    }

    public String getRowWeights() {
        return this.f13523v;
    }

    public int getRows() {
        return this.f13518q;
    }

    public String getSkips() {
        return this.f13522u;
    }

    public String getSpans() {
        return this.f13521t;
    }

    public float getVerticalGaps() {
        return this.f13526y;
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        this.f14055e = true;
        if (r10 == null) goto L55;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.Grid);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L40;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.Grid_grid_rows) goto L10;
        this.f13518q = r11.getInteger(r14, 0);
    L39:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R$styleable.Grid_grid_columns) goto L13;
        this.f13520s = r11.getInteger(r14, 0);
        goto L39
    L13:
        if (r14 != R$styleable.Grid_grid_spans) goto L16;
        this.f13521t = r11.getString(r14);
        goto L39
    L16:
        if (r14 != R$styleable.Grid_grid_skips) goto L19;
        this.f13522u = r11.getString(r14);
        goto L39
    L19:
        if (r14 != R$styleable.Grid_grid_rowWeights) goto L22;
        this.f13523v = r11.getString(r14);
        goto L39
    L22:
        if (r14 != R$styleable.Grid_grid_columnWeights) goto L25;
        this.f13524w = r11.getString(r14);
        goto L39
    L25:
        if (r14 != R$styleable.Grid_grid_orientation) goto L28;
        this.f13527z = r11.getInt(r14, 0);
        goto L39
    L28:
        if (r14 != R$styleable.Grid_grid_horizontalGaps) goto L31;
        this.f13525x = r11.getDimension(r14, 0.0f);
        goto L39
    L31:
        if (r14 != R$styleable.Grid_grid_verticalGaps) goto L34;
        this.f13526y = r11.getDimension(r14, 0.0f);
        goto L39
    L34:
        if (r14 != R$styleable.Grid_grid_validateInputs) goto L37;
        this.B = r11.getBoolean(r14, false);
        goto L39
    L37:
        if (r14 != R$styleable.Grid_grid_useRtl) goto L39;
        this.C = r11.getBoolean(r14, false);
        goto L39
    L40:
        O();
        E();
        r11.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f13516o = (ConstraintLayout) getParent();
        z(false);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onDraw(Canvas r17) {
        super.onDraw(r17);
        if (isInEditMode() == true) goto L5;
        return;
    L5:
        Paint r10 = new Paint();
        r10.setColor(-65536);
        r10.setStyle(Paint.Style.STROKE);
        int r11 = getTop();
        int r12 = getLeft();
        int r13 = getBottom();
        int r14 = getRight();
        View[] r15 = this.f13515n;
        int r16 = r15.length;
        int r18 = 0;
    L6:
        if (r18 >= r16) goto L8;
        View r19 = r15[r18];
        int r20 = r19.getLeft() - r12;
        int r110 = r19.getTop() - r11;
        int r21 = r19.getRight() - r12;
        int r111 = r19.getBottom() - r11;
        r17.drawRect(r20, 0.0f, r21, r13 - r11, r10);
        r17.drawRect(0.0f, r110, r14 - r12, r111, r10);
        r18 = r18 + 1;
        goto L6
    }

    public void setColumnWeights(String r10) {
        if (H(r10) == true) goto L5;
        return;
    L5:
        String r11 = this.f13524w;
        if (r11 != null) goto L8;
    L10:
        this.f13524w = r10;
        z(true);
        invalidate();
        return;
    L8:
        if (r11.equals(r10) == false) goto L10;
    }

    public void setColumns(int r10) {
        if (r10 <= 50) goto L6;
        return;
    L6:
        if (this.f13520s != r10) goto L8;
        return;
    L8:
        this.f13520s = r10;
        O();
        E();
        z(false);
        invalidate();
    }

    public void setHorizontalGaps(float r10) {
        if (r10 >= 0.0f) goto L6;
        return;
    L6:
        if (this.f13525x != r10) goto L8;
        return;
    L8:
        this.f13525x = r10;
        z(true);
        invalidate();
    }

    public void setOrientation(int r10) {
        if (r10 == 0) goto L7;
        if (r10 == 1) goto L7;
        return;
    L7:
        if (this.f13527z != r10) goto L9;
        return;
    L9:
        this.f13527z = r10;
        z(true);
        invalidate();
    }

    public void setRowWeights(String r10) {
        if (H(r10) == true) goto L5;
        return;
    L5:
        String r11 = this.f13523v;
        if (r11 != null) goto L8;
    L10:
        this.f13523v = r10;
        z(true);
        invalidate();
        return;
    L8:
        if (r11.equals(r10) == false) goto L10;
    }

    public void setRows(int r10) {
        if (r10 <= 50) goto L6;
        return;
    L6:
        if (this.f13518q != r10) goto L8;
        return;
    L8:
        this.f13518q = r10;
        O();
        E();
        z(false);
        invalidate();
    }

    public void setSkips(String r10) {
        if (G(r10) == true) goto L5;
        return;
    L5:
        String r11 = this.f13522u;
        if (r11 != null) goto L8;
    L10:
        this.f13522u = r10;
        z(true);
        invalidate();
        return;
    L8:
        if (r11.equals(r10) == false) goto L10;
    }

    public void setSpans(CharSequence r10) {
        if (G(r10) == true) goto L5;
        return;
    L5:
        String r11 = this.f13521t;
        if (r11 != null) goto L8;
    L10:
        this.f13521t = r10.toString();
        z(true);
        invalidate();
        return;
    L8:
        if (r11.contentEquals(r10) == false) goto L10;
    }

    public void setVerticalGaps(float r10) {
        if (r10 >= 0.0f) goto L6;
        return;
    L6:
        if (this.f13526y != r10) goto L8;
        return;
    L8:
        this.f13526y = r10;
        z(true);
        invalidate();
    }

    public final boolean u() {
        View[] r10 = j(this.f13516o);
        int r11 = 0;
    L4:
        if (r11 >= this.f14052b) goto L13;
        if (this.E.contains(Integer.valueOf(this.f14051a[r11])) == true) goto L12;
        int r12 = getNextPosition();
        int r13 = B(r12);
        int r14 = A(r12);
        if (r12 == (-1)) goto L10;
        y(r10[r11], r13, r14, 1, 1);
        goto L12
    L10:
        return false;
    L12:
        r11 = r11 + 1;
        goto L4
    L13:
        return true;
    }

    public final void v() {
        int r10 = Math.max(this.f13517p, this.f13519r);
        View[] r11 = this.f13515n;
        int r12 = 0;
        if (r11 != null) goto L9;
        this.f13515n = new View[r10];
        int r13 = 0;
    L5:
        View[] r14 = this.f13515n;
        if (r13 >= r14.length) goto L22;
        r14[r13] = I();
        r13 = r13 + 1;
    L22:
        this.F = new int[r10];
    L23:
        View[] r15 = this.f13515n;
        if (r12 >= r15.length) goto L26;
        this.F[r12] = r15[r12].getId();
        r12 = r12 + 1;
        goto L23
    L26:
        N();
        M();
        return;
    L9:
        if (r10 == r11.length) goto L22;
        View[] r16 = new View[r10];
        int r17 = 0;
    L11:
        if (r17 >= r10) goto L17;
        View[] r18 = this.f13515n;
        if (r17 >= r18.length) goto L15;
        r16[r17] = r18[r17];
    L16:
        r17 = r17 + 1;
        goto L11
    L15:
        r16[r17] = I();
        goto L16
    L17:
        int r19 = r10;
    L18:
        View[] r20 = this.f13515n;
        if (r19 >= r20.length) goto L21;
        this.f13516o.removeView(r20[r19]);
        r19 = r19 + 1;
        goto L18
    L21:
        this.f13515n = r16;
        goto L22
    }

    public final void w(View r10) {
        ConstraintLayout.LayoutParams r11 = J(r10);
        r11.L = -1.0f;
        r11.f14096f = -1;
        r11.f14094e = -1;
        r11.f14098g = -1;
        r11.f14100h = -1;
        ((ViewGroup.MarginLayoutParams) r11).leftMargin = -1;
        r10.setLayoutParams(r11);
    }

    public final void x(View r10) {
        ConstraintLayout.LayoutParams r11 = J(r10);
        r11.M = -1.0f;
        r11.f14104j = -1;
        r11.f14102i = -1;
        r11.f14106k = -1;
        r11.f14108l = -1;
        ((ViewGroup.MarginLayoutParams) r11).topMargin = -1;
        r10.setLayoutParams(r11);
    }

    public final void y(View r10, int r11, int r12, int r13, int r14) {
        ConstraintLayout.LayoutParams r15 = J(r10);
        int[] r16 = this.F;
        r15.f14094e = r16[r12];
        r15.f14102i = r16[r11];
        r15.f14100h = r16[(r12 + r14) - 1];
        r15.f14108l = r16[(r11 + r13) - 1];
        r10.setLayoutParams(r15);
    }

    public final boolean z(boolean r10) {
        if (this.f13516o != null) goto L5;
        return false;
    L5:
        if (this.f13517p >= 1) goto L7;
        return false;
    L7:
        if (this.f13519r < 1) goto L45;
        if (r10 == false) goto L19;
        int r11 = 0;
    L12:
        if (r11 >= this.D.length) goto L18;
        int r12 = 0;
    L14:
        boolean[][] r13 = this.D;
        if (r12 >= r13[0].length) goto L17;
        r13[r11][r12] = true;
        r12 = r12 + 1;
        goto L14
    L17:
        r11 = r11 + 1;
        goto L12
    L18:
        this.E.clear();
    L19:
        this.A = 0;
        v();
        String r14 = this.f13522u;
        if (r14 != null) goto L22;
    L26:
        boolean r15 = true;
    L27:
        String r16 = this.f13521t;
        if (r16 == null) goto L35;
        if (r16.trim().isEmpty() == true) goto L35;
        int[][] r17 = K(this.f13521t);
        if (r17 == null) goto L35;
        r15 = r15 & D(this.f14051a, r17);
    L35:
        if ((r15 & u()) == true) goto L39;
        if (this.B == false) goto L39;
        return false;
    L39:
        return true;
    L22:
        if (r14.trim().isEmpty() == true) goto L26;
        int[][] r18 = K(this.f13522u);
        if (r18 == null) goto L26;
        r15 = C(r18);
        goto L27
    L45:
        return false;
    }

    public Grid(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f13513l = 50;
        this.f13514m = 50;
        this.A = 0;
        this.E = new HashSet();
    }

    public Grid(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f13513l = 50;
        this.f13514m = 50;
        this.A = 0;
        this.E = new HashSet();
    }
}
