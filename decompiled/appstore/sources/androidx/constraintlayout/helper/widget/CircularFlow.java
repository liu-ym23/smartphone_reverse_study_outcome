package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CircularFlow extends VirtualLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f1682v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static float f1683w;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ConstraintLayout f1684l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f1686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f1687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1689q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f1690r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f1691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Float f1692t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f1693u;

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
        this.f1689q = 0;
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
        this.f1688p = 0;
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
        return Arrays.copyOf(this.f1686n, this.f1689q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f1687o, this.f1688p);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
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
        this.f1685m = r11.getResourceId(r14, 0);
    L21:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R$styleable.ConstraintLayout_Layout_circularflow_angles) goto L13;
        String r15 = r11.getString(r14);
        this.f1690r = r15;
        setAngles(r15);
        goto L21
    L13:
        if (r14 != R$styleable.ConstraintLayout_Layout_circularflow_radiusInDP) goto L16;
        String r16 = r11.getString(r14);
        this.f1691s = r16;
        setRadius(r16);
        goto L21
    L16:
        if (r14 != R$styleable.ConstraintLayout_Layout_circularflow_defaultAngle) goto L19;
        Float r17 = Float.valueOf(r11.getFloat(r14, f1683w));
        this.f1692t = r17;
        setDefaultAngle(r17.floatValue());
        goto L21
    L19:
        if (r14 != R$styleable.ConstraintLayout_Layout_circularflow_defaultRadius) goto L21;
        Integer r18 = Integer.valueOf(r11.getDimensionPixelSize(r14, f1682v));
        this.f1693u = r18;
        setDefaultRadius(r18.intValue());
        goto L21
    L22:
        r11.recycle();
        return;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r10 = this.f1690r;
        if (r10 == null) goto L5;
        this.f1686n = new float[1];
        setAngles(r10);
    L5:
        String r11 = this.f1691s;
        if (r11 == null) goto L8;
        this.f1687o = new int[1];
        setRadius(r11);
    L8:
        Float r12 = this.f1692t;
        if (r12 == null) goto L11;
        setDefaultAngle(r12.floatValue());
    L11:
        Integer r13 = this.f1693u;
        if (r13 == null) goto L14;
        setDefaultRadius(r13.intValue());
    L14:
        w();
    }

    public void setDefaultAngle(float r10) {
        f1683w = r10;
    }

    public void setDefaultRadius(int r10) {
        f1682v = r10;
    }

    public final void u(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 0) goto L7;
        return;
    L7:
        if (this.f2179c != null) goto L9;
        return;
    L9:
        float[] r11 = this.f1686n;
        if (r11 != null) goto L13;
        return;
    L13:
        if ((this.f1689q + 1) <= r11.length) goto L15;
        this.f1686n = Arrays.copyOf(r11, r11.length + 1);
    L15:
        this.f1686n[this.f1689q] = Integer.parseInt(r10);
        this.f1689q++;
    }

    public final void v(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 0) goto L7;
        return;
    L7:
        if (this.f2179c != null) goto L9;
        return;
    L9:
        int[] r11 = this.f1687o;
        if (r11 != null) goto L13;
        return;
    L13:
        if ((this.f1688p + 1) <= r11.length) goto L15;
        this.f1687o = Arrays.copyOf(r11, r11.length + 1);
    L15:
        this.f1687o[this.f1688p] = (int) (Integer.parseInt(r10) * this.f2179c.getResources().getDisplayMetrics().density);
        this.f1688p++;
    }

    public final void w() {
        this.f1684l = (ConstraintLayout) getParent();
        int r10 = 0;
    L4:
        if (r10 >= this.f2178b) goto L38;
        View r11 = this.f1684l.getViewById(this.f2177a[r10]);
        if (r11 == null) goto L37;
        int r12 = f1682v;
        float r13 = f1683w;
        int[] r14 = this.f1687o;
        if (r14 != null) goto L11;
    L13:
        Integer r15 = this.f1693u;
        if (r15 != null) goto L16;
    L21:
        Log.e("CircularFlow", "Added radius to view with id: " + ((String) this.f2185i.get(Integer.valueOf(r11.getId()))));
    L22:
        float[] r16 = this.f1686n;
        if (r16 != null) goto L25;
    L27:
        Float r17 = this.f1692t;
        if (r17 != null) goto L30;
    L35:
        Log.e("CircularFlow", "Added angle to view with id: " + ((String) this.f2185i.get(Integer.valueOf(r11.getId()))));
    L36:
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r11.getLayoutParams();
        r18.f2221r = r13;
        r18.f2217p = this.f1685m;
        r18.f2219q = r12;
        r11.setLayoutParams(r18);
        goto L37
    L30:
        if (r17.floatValue() == (-1.0f)) goto L35;
        this.f1689q++;
        if (this.f1686n != null) goto L34;
        this.f1686n = new float[1];
    L34:
        float[] r19 = getAngles();
        this.f1686n = r19;
        r19[this.f1689q - 1] = r13;
        goto L36
    L25:
        if (r10 >= r16.length) goto L27;
        r13 = r16[r10];
        goto L36
    L16:
        if (r15.intValue() == (-1)) goto L21;
        this.f1688p++;
        if (this.f1687o != null) goto L20;
        this.f1687o = new int[1];
    L20:
        int[] r20 = getRadius();
        this.f1687o = r20;
        r20[this.f1688p - 1] = r12;
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
