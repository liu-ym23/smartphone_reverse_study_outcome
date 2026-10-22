package androidx.constraintlayout.widget;

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
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f2177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f2179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Helper f2180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f2183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View[] f2184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap f2185i;

    public ConstraintHelper(Context r10) {
        super(r10);
        this.f2177a = new int[32];
        this.f2181e = false;
        this.f2184h = null;
        this.f2185i = new HashMap();
        this.f2179c = r10;
        k(null);
    }

    public final void a(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 0) goto L7;
        return;
    L7:
        if (this.f2179c != null) goto L9;
        return;
    L9:
        String r11 = r10.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r12 = (ConstraintLayout) getParent();
    L12:
        int r13 = i(r11);
        if (r13 == 0) goto L15;
        this.f2185i.put(Integer.valueOf(r13), r11);
        b(r13);
        return;
    L15:
        Log.w("ConstraintHelper", "Could not find id of \"" + r11 + "\"");
    }

    public final void b(int r10) {
        if (r10 != getId()) goto L5;
        return;
    L5:
        int r11 = this.f2178b + 1;
        int[] r12 = this.f2177a;
        if (r11 <= r12.length) goto L8;
        this.f2177a = Arrays.copyOf(r12, r12.length * 2);
    L8:
        int[] r13 = this.f2177a;
        int r14 = this.f2178b;
        r13[r14] = r10;
        this.f2178b = r14 + 1;
    }

    public final void c(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 0) goto L7;
        return;
    L7:
        if (this.f2179c != null) goto L9;
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
        if (r11.equals(((ConstraintLayout.LayoutParams) r16).f2192c0) == false) goto L27;
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
        if (r13 >= this.f2178b) goto L11;
        View r14 = r10.getViewById(this.f2177a[r13]);
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

    public final int[] g(View r10, String r11) {
        String[] r12 = r11.split(",");
        r10.getContext();
        int[] r13 = new int[r12.length];
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r12.length) goto L10;
        int r16 = i(r12[r14].trim());
        if (r16 == 0) goto L8;
        r13[r15] = r16;
        r15 = r15 + 1;
    L8:
        r14 = r14 + 1;
        goto L4
    L10:
        if (r15 != r12.length) goto L12;
        return r13;
    L12:
        return Arrays.copyOf(r13, r15);
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f2177a, this.f2178b);
    }

    public final int h(ConstraintLayout r10, String r11) {
        if (r11 == null) goto L21;
        if (r10 == null) goto L21;
        Resources r12 = this.f2179c.getResources();
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
        Object r13 = r11.getDesignInformation(0, r10);
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
        return this.f2179c.getResources().getIdentifier(r10, "id", this.f2179c.getPackageName());
    L21:
        r12 = R$id.class.getField(r10).getInt(null);     // Catch: Exception -> L20
        goto L17
    L5:
        r11 = null;
        goto L6
    }

    public View[] j(ConstraintLayout r10) {
        View[] r11 = this.f2184h;
        if (r11 != null) goto L5;
    L6:
        this.f2184h = new View[this.f2178b];
    L7:
        int r12 = 0;
    L9:
        if (r12 >= this.f2178b) goto L12;
        int r13 = this.f2177a[r12];
        this.f2184h[r12] = r10.getViewById(r13);
        r12 = r12 + 1;
        goto L9
    L12:
        return this.f2184h;
    L5:
        if (r11.length == this.f2178b) goto L7;
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
        this.f2182f = r15;
        setIds(r15);
    L11:
        r13 = r13 + 1;
        goto L4
    L9:
        if (r14 != R$styleable.ConstraintLayout_Layout_constraint_referenced_tags) goto L11;
        String r16 = r11.getString(r14);
        this.f2183g = r16;
        setReferenceTags(r16);
        goto L11
    L12:
        r11.recycle();
        return;
    }

    public void l(ConstraintSet.a r10, k.a r11, ConstraintLayout.LayoutParams r12, SparseArray r13) {
        ConstraintSet.b r14 = r10.f2277e;
        int[] r15 = r14.f2316k0;
        if (r15 == null) goto L5;
        setReferencedIds(r15);
    L11:
        if (r11 == null) goto L21;
        r11.removeAllIds();
        if (r10.f2277e.f2316k0 == null) goto L25;
        int r16 = 0;
    L15:
        int[] r17 = r10.f2277e.f2316k0;
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
        String r19 = r14.f2318l0;
        if (r19 == null) goto L11;
        if (r19.length() <= 0) goto L10;
        ConstraintSet.b r20 = r10.f2277e;
        r20.f2316k0 = g(this, r20.f2318l0);
        goto L11
    L10:
        r10.f2277e.f2316k0 = null;
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
        String r10 = this.f2182f;
        if (r10 == null) goto L5;
        setIds(r10);
    L5:
        String r11 = this.f2183g;
        if (r11 == null) goto L9;
        setReferenceTags(r11);
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.f2181e == false) goto L5;
        super.onMeasure(r10, r11);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public void p(ConstraintLayout r10) {
    }

    public void q(ConstraintWidgetContainer r10, Helper r11, SparseArray r12) {
        r11.removeAllIds();
        int r13 = 0;
    L4:
        if (r13 >= this.f2178b) goto L6;
        r11.add((ConstraintWidget) r12.get(this.f2177a[r13]));
        r13 = r13 + 1;
        goto L4
    }

    public void r(ConstraintLayout r10) {
        if (isInEditMode() == false) goto L5;
        setIds(this.f2182f);
    L5:
        Helper r11 = this.f2180d;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.removeAllIds();
        int r12 = 0;
    L10:
        if (r12 >= this.f2178b) goto L19;
        int r13 = this.f2177a[r12];
        View r14 = r10.getViewById(r13);
        if (r14 != null) goto L16;
        String r15 = (String) this.f2185i.get(Integer.valueOf(r13));
        int r16 = h(r10, r15);
        if (r16 == 0) goto L16;
        this.f2177a[r12] = r16;
        this.f2185i.put(Integer.valueOf(r16), r15);
        r14 = r10.getViewById(r16);
    L16:
        if (r14 == null) goto L18;
        this.f2180d.add(r10.getViewWidget(r14));
    L18:
        r12 = r12 + 1;
        goto L10
    L19:
        this.f2180d.updateConstraints(r10.mLayoutWidget);
    }

    public void s() {
        if (this.f2180d != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r10 = getLayoutParams();
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintWidget r11 = (ConstraintWidget) this.f2180d;
        ((ConstraintLayout.LayoutParams) r10).f2230v0 = r11;
        return;
    }

    public void setIds(String r10) {
        this.f2182f = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = 0;
        this.f2178b = 0;
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
        this.f2183g = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = 0;
        this.f2178b = 0;
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
        this.f2182f = null;
        int r11 = 0;
        this.f2178b = 0;
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
        if (this.f2182f != null) goto L9;
        b(r10);
        return;
    }

    public ConstraintHelper(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f2177a = new int[32];
        this.f2181e = false;
        this.f2184h = null;
        this.f2185i = new HashMap();
        this.f2179c = r10;
        k(r11);
    }

    public ConstraintHelper(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f2177a = new int[32];
        this.f2181e = false;
        this.f2184h = null;
        this.f2185i = new HashMap();
        this.f2179c = r10;
        k(r11);
    }
}
