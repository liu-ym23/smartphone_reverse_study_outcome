package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class StepOSCollapsingToolbarLayout extends y {
    public z B;
    public n3.m1 C;
    public d D;
    public ActionBarContextView E;
    public TextView F;
    public a0 G;
    public float H;
    public final t0 I;

    public StepOSCollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.f12904c = true;
        this.f12912n = new Rect();
        this.f12922x = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(o1.f12783a);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(0);
        typedArrayObtainStyledAttributes.recycle();
        if (!zHasValue) {
            g5.f.s("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
            throw null;
        }
        v vVar = new v();
        vVar.f12850g = 16;
        vVar.f12851h = 16;
        vVar.i = 15.0f;
        vVar.f12852j = 15.0f;
        vVar.f12844a = this;
        vVar.D = new TextPaint(129);
        vVar.f12848e = new Rect();
        vVar.f12847d = new Rect();
        vVar.f12849f = new RectF();
        VarHandle.storeStoreFence();
        this.f12913o = vVar;
        vVar.E = u.f12839d;
        vVar.j();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, p6.a.f9813e, i, R.style.Widget_Design_CollapsingToolbar);
        int i3 = typedArrayObtainStyledAttributes2.getInt(9, 8388691);
        if (vVar.f12850g != i3) {
            vVar.f12850g = i3;
            vVar.j();
        }
        int i10 = typedArrayObtainStyledAttributes2.getInt(2, 8388627);
        if (vVar.f12851h != i10) {
            vVar.f12851h = i10;
            vVar.j();
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(10, 0);
        this.f12911m = dimensionPixelSize;
        this.f12910l = dimensionPixelSize;
        this.f12909k = dimensionPixelSize;
        this.f12908j = dimensionPixelSize;
        if (typedArrayObtainStyledAttributes2.hasValue(13)) {
            this.f12908j = typedArrayObtainStyledAttributes2.getDimensionPixelSize(13, 0);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(12)) {
            this.f12910l = typedArrayObtainStyledAttributes2.getDimensionPixelSize(12, 0);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(14)) {
            this.f12909k = typedArrayObtainStyledAttributes2.getDimensionPixelSize(14, 0);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(11)) {
            this.f12911m = typedArrayObtainStyledAttributes2.getDimensionPixelSize(11, 0);
        }
        this.f12914p = typedArrayObtainStyledAttributes2.getBoolean(28, true);
        setTitle(typedArrayObtainStyledAttributes2.getText(26));
        vVar.l(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        vVar.k(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayObtainStyledAttributes2.hasValue(16)) {
            vVar.l(typedArrayObtainStyledAttributes2.getResourceId(16, 0));
        }
        if (typedArrayObtainStyledAttributes2.hasValue(4)) {
            vVar.k(typedArrayObtainStyledAttributes2.getResourceId(4, 0));
        }
        this.f12922x = typedArrayObtainStyledAttributes2.getDimensionPixelSize(22, -1);
        this.f12921w = typedArrayObtainStyledAttributes2.getInt(21, 600);
        setContentScrim(typedArrayObtainStyledAttributes2.getDrawable(6));
        setStatusBarScrim(typedArrayObtainStyledAttributes2.getDrawable(23));
        this.f12905f = typedArrayObtainStyledAttributes2.getResourceId(32, -1);
        typedArrayObtainStyledAttributes2.recycle();
        setWillNotDraw(false);
        p pVar = new p();
        pVar.f12784c = this;
        VarHandle.storeStoreFence();
        WeakHashMap weakHashMap = n3.k0.f8724a;
        n3.e0.b(this, pVar);
        t0 t0Var = new t0();
        t0Var.f12833a = this;
        VarHandle.storeStoreFence();
        this.I = t0Var;
    }

    @Override // stepos.support.v7.widget.y
    public final int a() {
        n3.m1 m1Var = this.C;
        if (m1Var != null) {
            return m1Var.d();
        }
        return 0;
    }

    @Override // stepos.support.v7.widget.y, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        g(this.H);
    }

    public final void g(float f5) {
        TextView textView = this.F;
        if (textView == null) {
            return;
        }
        textView.setAlpha(f5 < 0.5f ? 0.0f : (f5 * 2.0f) - 1.0f);
        float f10 = 1.0f - f5;
        this.f12913o.D.setAlpha((int) ((f10 > 0.5f ? (f10 * 2.0f) - 1.0f : 0.0f) * 255.0f));
    }

    public int getExpandRange() {
        n3.m1 m1Var = this.C;
        int iD = m1Var != null ? m1Var.d() : 0;
        int height = getHeight();
        WeakHashMap weakHashMap = n3.k0.f8724a;
        return (height - getMinimumHeight()) - iD;
    }

    @Override // stepos.support.v7.widget.y, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof com.google.android.material.appbar.g) {
            if (this.D == null) {
                d dVar = new d(2);
                dVar.f12738b = this;
                VarHandle.storeStoreFence();
                this.D = dVar;
            }
            ((com.google.android.material.appbar.g) parent).c(this.D);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.E = (ActionBarContextView) findViewById(R.id.action_context_bar);
    }

    @Override // stepos.support.v7.widget.y, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        int iA = a();
        if (iA > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iA, 1073741824));
        }
    }

    public void setTitleTextColor(int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        v vVar = this.f12913o;
        if (vVar.f12854l != colorStateListValueOf) {
            vVar.f12854l = colorStateListValueOf;
            vVar.j();
        }
        if (vVar.f12853k != colorStateListValueOf) {
            vVar.f12853k = colorStateListValueOf;
            vVar.j();
        }
    }

    public void setOnOffsetChangedListener(stepos.support.v7.app.b bVar) {
    }

    public void setTabLayout(q0 q0Var) {
    }

    public StepOSCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.steposCollapsingToolbarLayoutStyle);
    }

    public StepOSCollapsingToolbarLayout(Context context) {
        this(context, null);
    }
}
