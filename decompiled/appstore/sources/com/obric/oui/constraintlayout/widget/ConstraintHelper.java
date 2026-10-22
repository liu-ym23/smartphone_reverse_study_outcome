package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.Helper;
import com.obric.oui.constraintlayout.core.widgets.d;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ConstraintHelper extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f14051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f14053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Helper f14054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f14056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f14057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View[] f14058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap f14059i;

    public ConstraintHelper(Context r10) {
        super(r10);
        this.f14051a = new int[32];
        this.f14055e = false;
        this.f14058h = null;
        this.f14059i = new HashMap();
        this.f14053c = r10;
        k(null);
    }

    public final void a(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 0) goto L7;
        return;
    L7:
        if (this.f14053c != null) goto L9;
        return;
    L9:
        String r11 = r10.trim();
        int r12 = i(r11);
        if (r12 == 0) goto L12;
        this.f14059i.put(Integer.valueOf(r12), r11);
        b(r12);
        return;
    L12:
        Log.w("ConstraintHelper", "Could not find id of \"" + r11 + "\"");
    }

    public final void b(int r10) {
        if (r10 != getId()) goto L5;
        return;
    L5:
        int r11 = this.f14052b + 1;
        int[] r12 = this.f14051a;
        if (r11 <= r12.length) goto L8;
        this.f14051a = Arrays.copyOf(r12, r12.length * 2);
    L8:
        int[] r13 = this.f14051a;
        int r14 = this.f14052b;
        r13[r14] = r10;
        this.f14052b = r14 + 1;
    }

    public final void c(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 0) goto L7;
        return;
    L7:
        if (this.f14053c != null) goto L9;
        return;
    L9:
        String r11 = r10.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r12 = (ConstraintLayout) getParent();
    L14:
        if (r12 != null) goto L17;
        Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
        return;
    L17:
        int r13 = r12.getChildCount();
        int r14 = 0;
    L18:
        if (r14 >= r13) goto L35;
        View r15 = r12.getChildAt(r14);
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if ((r16 instanceof ConstraintLayout.LayoutParams) == false) goto L27;
        if (r11.equals(((ConstraintLayout.LayoutParams) r16).f14091c0) == false) goto L27;
        if (r15.getId() != (-1)) goto L26;
        Log.w("ConstraintHelper", "to use ConstraintTag view " + r15.getClass().getSimpleName() + " must have an ID");
        goto L27
    L26:
        b(r15.getId());
    L27:
        r14 = r14 + 1;
        goto L18
    L35:
        return;
    L12:
        r12 = null;
        goto L14
    }

    public void d() {
        ViewParent r10 = getParent();
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof ConstraintLayout) == false) goto L9;
        e((ConstraintLayout) r10);
        return;
    }

    public void e(ConstraintLayout r10) {
        int r11 = getVisibility();
        float r12 = getElevation();
        int r13 = 0;
    L4:
        if (r13 >= this.f14052b) goto L11;
        View r14 = r10.j(this.f14051a[r13]);
        if (r14 == null) goto L10;
        r14.setVisibility(r11);
        if (r12 <= 0.0f) goto L10;
        r14.setTranslationZ(r14.getTranslationZ() + r12);
    L10:
        r13 = r13 + 1;
        goto L4
    }

    public void f(ConstraintLayout r10) {
    }

    public final int[] g(String r10) {
        String[] r11 = r10.split(",");
        int[] r12 = new int[r11.length];
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r11.length) goto L10;
        int r15 = i(r11[r13].trim());
        if (r15 == 0) goto L8;
        r12[r14] = r15;
        r14 = r14 + 1;
    L8:
        r13 = r13 + 1;
        goto L4
    L10:
        if (r14 != r11.length) goto L12;
        return r12;
    L12:
        return Arrays.copyOf(r12, r14);
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f14051a, this.f14052b);
    }

    public final int h(ConstraintLayout r10, String r11) {
        if (r11 == null) goto L21;
        if (r10 == null) goto L21;
        Resources r12 = this.f14053c.getResources();
        if (r12 != null) goto L9;
        return 0;
    L9:
        int r13 = r10.getChildCount();
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L21;
        View r15 = r10.getChildAt(r14);
        if (r15.getId() == (-1)) goto L20;
        String r16 = r12.getResourceEntryName(r15.getId());     // Catch: Resources.NotFoundException -> L15
    L17:
        if (r11.equals(r16) == false) goto L20;
        return r15.getId();
    L15:
        r16 = null;
    L20:
        r14 = r14 + 1;
    L21:
        return 0;
    }

    public final int i(String r10) {
        if ((getParent() instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r11 = (ConstraintLayout) getParent();
    L6:
        int r12 = 0;
        if (isInEditMode() == false) goto L12;
        if (r11 == null) goto L12;
        Object r13 = r11.h(0, r10);
        if ((r13 instanceof Integer) == false) goto L12;
        r12 = ((Integer) r13).intValue();
    L12:
        if (r12 != 0) goto L15;
        if (r11 == null) goto L15;
        r12 = h(r11, r10);
    L15:
        if (r12 == 0) goto L21;
    L17:
        if (r12 == 0) goto L19;
        return r12;
    L19:
        return this.f14053c.getResources().getIdentifier(r10, "id", this.f14053c.getPackageName());
    L21:
        r12 = R$id.class.getField(r10).getInt(null);     // Catch: Exception -> L20
        goto L17
    L5:
        r11 = null;
        goto L6
    }

    public View[] j(ConstraintLayout r10) {
        View[] r11 = this.f14058h;
        if (r11 != null) goto L5;
    L6:
        this.f14058h = new View[this.f14052b];
    L7:
        int r12 = 0;
    L9:
        if (r12 >= this.f14052b) goto L12;
        int r13 = this.f14051a[r12];
        this.f14058h[r12] = r10.j(r13);
        r12 = r12 + 1;
        goto L9
    L12:
        return this.f14058h;
    L5:
        if (r11.length == this.f14052b) goto L7;
        goto L6
    }

    public void k(AttributeSet r10) {
        if (r10 == null) goto L18;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L12;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) goto L9;
        String r15 = r11.getString(r14);
        this.f14056f = r15;
        setIds(r15);
    L11:
        r13 = r13 + 1;
        goto L4
    L9:
        if (r14 != R$styleable.ConstraintLayout_Layout_constraint_referenced_tags) goto L11;
        String r16 = r11.getString(r14);
        this.f14057g = r16;
        setReferenceTags(r16);
        goto L11
    L12:
        r11.recycle();
        return;
    }

    public void l(a.C0195a r10, wc.a r11, ConstraintLayout.LayoutParams r12, SparseArray r13) {
        a.b r14 = r10.f14176e;
        int[] r15 = r14.f14215k0;
        if (r15 == null) goto L5;
        setReferencedIds(r15);
    L11:
        if (r11 == null) goto L21;
        r11.removeAllIds();
        if (r10.f14176e.f14215k0 == null) goto L25;
        int r16 = 0;
    L15:
        int[] r17 = r10.f14176e.f14215k0;
        if (r16 >= r17.length) goto L26;
        ConstraintWidget r18 = (ConstraintWidget) r13.get(r17[r16]);
        if (r18 == null) goto L20;
        r11.add(r18);
    L20:
        r16 = r16 + 1;
        goto L15
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L5:
        String r19 = r14.f14217l0;
        if (r19 == null) goto L11;
        if (r19.length() <= 0) goto L10;
        a.b r20 = r10.f14176e;
        r20.f14215k0 = g(r20.f14217l0);
        goto L11
    L10:
        r10.f14176e.f14215k0 = null;
        goto L11
    }

    public void m(ConstraintWidget r10, boolean r11) {
    }

    public void n(ConstraintLayout r10) {
    }

    public void o(ConstraintLayout r10) {
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r10 = this.f14056f;
        if (r10 == null) goto L5;
        setIds(r10);
    L5:
        String r11 = this.f14057g;
        if (r11 == null) goto L9;
        setReferenceTags(r11);
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.f14055e == false) goto L5;
        super.onMeasure(r10, r11);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public void p(ConstraintLayout r10) {
    }

    public void q(d r10, Helper r11, SparseArray r12) {
        r11.removeAllIds();
        int r13 = 0;
    L4:
        if (r13 >= this.f14052b) goto L6;
        r11.add((ConstraintWidget) r12.get(this.f14051a[r13]));
        r13 = r13 + 1;
        goto L4
    }

    public void r(ConstraintLayout r10) {
        if (isInEditMode() == false) goto L5;
        setIds(this.f14056f);
    L5:
        Helper r11 = this.f14054d;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.removeAllIds();
        int r12 = 0;
    L10:
        if (r12 >= this.f14052b) goto L19;
        int r13 = this.f14051a[r12];
        View r14 = r10.j(r13);
        if (r14 != null) goto L16;
        String r15 = (String) this.f14059i.get(Integer.valueOf(r13));
        int r16 = h(r10, r15);
        if (r16 == 0) goto L16;
        this.f14051a[r12] = r16;
        this.f14059i.put(Integer.valueOf(r16), r15);
        r14 = r10.j(r16);
    L16:
        if (r14 == null) goto L18;
        this.f14054d.add(r10.k(r14));
    L18:
        r12 = r12 + 1;
        goto L10
    L19:
        this.f14054d.updateConstraints(r10.f14063c);
    }

    public void s() {
        if (this.f14054d != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r10 = getLayoutParams();
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintWidget r11 = (ConstraintWidget) this.f14054d;
        ((ConstraintLayout.LayoutParams) r10).f14129v0 = r11;
        return;
    }

    public void setIds(String r10) {
        this.f14056f = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = 0;
        this.f14052b = 0;
    L6:
        int r12 = r10.indexOf(44, r11);
        if (r12 == (-1)) goto L8;
        a(r10.substring(r11, r12));
        r11 = r12 + 1;
        goto L6
    L8:
        a(r10.substring(r11));
    }

    public void setReferenceTags(String r10) {
        this.f14057g = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = 0;
        this.f14052b = 0;
    L6:
        int r12 = r10.indexOf(44, r11);
        if (r12 == (-1)) goto L8;
        c(r10.substring(r11, r12));
        r11 = r12 + 1;
        goto L6
    L8:
        c(r10.substring(r11));
    }

    public void setReferencedIds(int[] r10) {
        this.f14056f = null;
        int r11 = 0;
        this.f14052b = 0;
    L4:
        if (r11 >= r10.length) goto L6;
        b(r10[r11]);
        r11 = r11 + 1;
        goto L4
    }

    @Override // android.view.View
    public void setTag(int r10, Object r11) {
        super.setTag(r10, r11);
        if (r11 == null) goto L5;
        return;
    L5:
        if (this.f14056f != null) goto L9;
        b(r10);
        return;
    }

    public ConstraintHelper(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f14051a = new int[32];
        this.f14055e = false;
        this.f14058h = null;
        this.f14059i = new HashMap();
        this.f14053c = r10;
        k(r11);
    }

    public ConstraintHelper(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f14051a = new int[32];
        this.f14055e = false;
        this.f14058h = null;
        this.f14059i = new HashMap();
        this.f14053c = r10;
        k(r11);
    }
}
