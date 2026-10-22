package m;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n0 extends Spinner {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f8011m = {R.attr.spinnerMode};

    /* renamed from: c, reason: collision with root package name */
    public ed.o f8012c;

    /* renamed from: f, reason: collision with root package name */
    public Context f8013f;

    /* renamed from: g, reason: collision with root package name */
    public f0 f8014g;

    /* renamed from: h, reason: collision with root package name */
    public SpinnerAdapter f8015h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public m0 f8016j;

    /* renamed from: k, reason: collision with root package name */
    public int f8017k;

    /* renamed from: l, reason: collision with root package name */
    public Rect f8018l;

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        Rect rect = this.f8018l;
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(rect);
        return rect.left + rect.right + iMax2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ed.o oVar = this.f8012c;
        if (oVar != null) {
            oVar.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        m0 m0Var = this.f8016j;
        return m0Var != null ? m0Var.a() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        m0 m0Var = this.f8016j;
        return m0Var != null ? m0Var.o() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f8016j != null ? this.f8017k : super.getDropDownWidth();
    }

    public final m0 getInternalPopup() {
        return this.f8016j;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        m0 m0Var = this.f8016j;
        return m0Var != null ? m0Var.e() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f8013f;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        m0 m0Var = this.f8016j;
        return m0Var != null ? m0Var.d() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        ed.o oVar = this.f8012c;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ed.o oVar = this.f8012c;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m0 m0Var = this.f8016j;
        if (m0Var == null || !m0Var.b()) {
            return;
        }
        m0Var.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        if (this.f8016j == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        l0 l0Var = (l0) parcelable;
        super.onRestoreInstanceState(l0Var.getSuperState());
        if (!l0Var.f7986c || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        l.d dVar = new l.d(2);
        dVar.f7543f = this;
        VarHandle.storeStoreFence();
        viewTreeObserver.addOnGlobalLayoutListener(dVar);
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        l0 l0Var = new l0(super.onSaveInstanceState());
        m0 m0Var = this.f8016j;
        l0Var.f7986c = m0Var != null && m0Var.b();
        return l0Var;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        f0 f0Var = this.f8014g;
        if (f0Var == null || !f0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        m0 m0Var = this.f8016j;
        if (m0Var == null) {
            return super.performClick();
        }
        if (m0Var.b()) {
            return true;
        }
        m0Var.m(getTextDirection(), getTextAlignment());
        return true;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        m0 m0Var = this.f8016j;
        if (!this.i) {
            this.f8015h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (m0Var != null) {
            Context context = this.f8013f;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            i0 i0Var = new i0();
            i0Var.f7925a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                i0Var.f7926b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                g0.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            m0Var.p(i0Var);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ed.o oVar = this.f8012c;
        if (oVar != null) {
            oVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ed.o oVar = this.f8012c;
        if (oVar != null) {
            oVar.g(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        m0 m0Var = this.f8016j;
        if (m0Var == null) {
            super.setDropDownHorizontalOffset(i);
        } else {
            m0Var.l(i);
            m0Var.c(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        m0 m0Var = this.f8016j;
        if (m0Var != null) {
            m0Var.k(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f8016j != null) {
            this.f8017k = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        m0 m0Var = this.f8016j;
        if (m0Var != null) {
            m0Var.j(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(id.k.v(i, getPopupContext()));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        m0 m0Var = this.f8016j;
        if (m0Var != null) {
            m0Var.i(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ed.o oVar = this.f8012c;
        if (oVar != null) {
            oVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ed.o oVar = this.f8012c;
        if (oVar != null) {
            oVar.j(mode);
        }
    }
}
