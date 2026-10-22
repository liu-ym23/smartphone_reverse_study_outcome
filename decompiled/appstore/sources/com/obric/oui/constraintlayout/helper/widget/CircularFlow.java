package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class CircularFlow extends VirtualLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f13500v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static float f13501w;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ConstraintLayout f13502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13503m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f13504n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f13505o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13506p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13507q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f13508r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f13509s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Float f13510t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f13511u;

    static {
    }

    public CircularFlow(Context r10) {
        super(r10);
    }

    private void setAngles(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = 0;
        this.f13507q = 0;
    L5:
        int r12 = r10.indexOf(44, r11);
        if (r12 == (-1)) goto L7;
        u(r10.substring(r11, r12).trim());
        r11 = r12 + 1;
        goto L5
    L7:
        u(r10.substring(r11).trim());
    }

    private void setRadius(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = 0;
        this.f13506p = 0;
    L5:
        int r12 = r10.indexOf(44, r11);
        if (r12 == (-1)) goto L7;
        v(r10.substring(r11, r12).trim());
        r11 = r12 + 1;
        goto L5
    L7:
        v(r10.substring(r11).trim());
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f13504n, this.f13507q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f13505o, this.f13506p);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        if (r10 == null) goto L31;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L22;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.ConstraintLayout_Layout_circularflow_viewCenter) goto L10;
        this.f13503m = r11.getResourceId(r14, 0);
    L21:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R$styleable.ConstraintLayout_Layout_circularflow_angles) goto L13;
        String r15 = r11.getString(r14);
        this.f13508r = r15;
        setAngles(r15);
        goto L21
    L13:
        if (r14 != R$styleable.ConstraintLayout_Layout_circularflow_radiusInDP) goto L16;
        String r16 = r11.getString(r14);
        this.f13509s = r16;
        setRadius(r16);
        goto L21
    L16:
        if (r14 != R$styleable.ConstraintLayout_Layout_circularflow_defaultAngle) goto L19;
        Float r17 = Float.valueOf(r11.getFloat(r14, f13501w));
        this.f13510t = r17;
        setDefaultAngle(r17.floatValue());
        goto L21
    L19:
        if (r14 != R$styleable.ConstraintLayout_Layout_circularflow_defaultRadius) goto L21;
        Integer r18 = Integer.valueOf(r11.getDimensionPixelSize(r14, f13500v));
        this.f13511u = r18;
        setDefaultRadius(r18.intValue());
        goto L21
    L22:
        r11.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r10 = this.f13508r;
        if (r10 == null) goto L5;
        this.f13504n = new float[1];
        setAngles(r10);
    L5:
        String r11 = this.f13509s;
        if (r11 == null) goto L8;
        this.f13505o = new int[1];
        setRadius(r11);
    L8:
        Float r12 = this.f13510t;
        if (r12 == null) goto L11;
        setDefaultAngle(r12.floatValue());
    L11:
        Integer r13 = this.f13511u;
        if (r13 == null) goto L14;
        setDefaultRadius(r13.intValue());
    L14:
        w();
    }

    public void setDefaultAngle(float r10) {
        f13501w = r10;
    }

    public void setDefaultRadius(int r10) {
        f13500v = r10;
    }

    public final void u(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 0) goto L7;
        return;
    L7:
        if (this.f14053c != null) goto L9;
        return;
    L9:
        float[] r11 = this.f13504n;
        if (r11 != null) goto L13;
        return;
    L13:
        if ((this.f13507q + 1) <= r11.length) goto L15;
        this.f13504n = Arrays.copyOf(r11, r11.length + 1);
    L15:
        this.f13504n[this.f13507q] = Integer.parseInt(r10);
        this.f13507q++;
    }

    public final void v(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 0) goto L7;
        return;
    L7:
        if (this.f14053c != null) goto L9;
        return;
    L9:
        int[] r11 = this.f13505o;
        if (r11 != null) goto L13;
        return;
    L13:
        if ((this.f13506p + 1) <= r11.length) goto L15;
        this.f13505o = Arrays.copyOf(r11, r11.length + 1);
    L15:
        this.f13505o[this.f13506p] = (int) (Integer.parseInt(r10) * this.f14053c.getResources().getDisplayMetrics().density);
        this.f13506p++;
    }

    public final void w() {
        this.f13502l = (ConstraintLayout) getParent();
        int r10 = 0;
    L4:
        if (r10 >= this.f14052b) goto L38;
        View r11 = this.f13502l.j(this.f14051a[r10]);
        if (r11 == null) goto L37;
        int r12 = f13500v;
        float r13 = f13501w;
        int[] r14 = this.f13505o;
        if (r14 != null) goto L11;
    L13:
        Integer r15 = this.f13511u;
        if (r15 != null) goto L16;
    L21:
        Log.e("CircularFlow", "Added radius to view with id: " + ((String) this.f14059i.get(Integer.valueOf(r11.getId()))));
    L22:
        float[] r16 = this.f13504n;
        if (r16 != null) goto L25;
    L27:
        Float r17 = this.f13510t;
        if (r17 != null) goto L30;
    L35:
        Log.e("CircularFlow", "Added angle to view with id: " + ((String) this.f14059i.get(Integer.valueOf(r11.getId()))));
    L36:
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r11.getLayoutParams();
        r18.f14120r = r13;
        r18.f14116p = this.f13503m;
        r18.f14118q = r12;
        r11.setLayoutParams(r18);
        goto L37
    L30:
        if (r17.floatValue() == (-1.0f)) goto L35;
        this.f13507q++;
        if (this.f13504n != null) goto L34;
        this.f13504n = new float[1];
    L34:
        float[] r19 = getAngles();
        this.f13504n = r19;
        r19[this.f13507q - 1] = r13;
        goto L36
    L25:
        if (r10 >= r16.length) goto L27;
        r13 = r16[r10];
        goto L36
    L16:
        if (r15.intValue() == (-1)) goto L21;
        this.f13506p++;
        if (this.f13505o != null) goto L20;
        this.f13505o = new int[1];
    L20:
        int[] r20 = getRadius();
        this.f13505o = r20;
        r20[this.f13506p - 1] = r12;
        goto L22
    L11:
        if (r10 >= r14.length) goto L13;
        r12 = r14[r10];
    L37:
        r10 = r10 + 1;
        goto L4
    L38:
        d();
    }

    public CircularFlow(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public CircularFlow(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
