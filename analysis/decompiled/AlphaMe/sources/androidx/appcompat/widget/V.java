package androidx.appcompat.widget;

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
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import e.EnumC0546d;
import k.ViewTreeObserverOnGlobalLayoutListenerC0651e;

/* loaded from: classes.dex */
public final class V extends Spinner {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f3014i = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    public final C0228u f3015a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f3016b;

    /* renamed from: c, reason: collision with root package name */
    public final C0211l f3017c;

    /* renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f3018d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3019e;

    /* renamed from: f, reason: collision with root package name */
    public final U f3020f;

    /* renamed from: g, reason: collision with root package name */
    public int f3021g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f3022h;

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public V(android.content.Context r12, android.util.AttributeSet r13) throws java.lang.Throwable {
        /*
            r11 = this;
            r0 = 2130970252(0x7f04068c, float:1.7549209E38)
            r11.<init>(r12, r13, r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r11.f3022h = r1
            android.content.Context r1 = r11.getContext()
            androidx.appcompat.widget.V0.a(r1, r11)
            int[] r1 = g.AbstractC0560a.f12608u
            r2 = 0
            android.support.v4.media.session.c r3 = android.support.v4.media.session.c.y(r0, r2, r12, r13, r1)
            androidx.appcompat.widget.u r4 = new androidx.appcompat.widget.u
            r4.<init>(r11)
            r11.f3015a = r4
            r4 = 4
            int r4 = r3.r(r4, r2)
            if (r4 == 0) goto L31
            j.e r5 = new j.e
            r5.<init>(r12, r4)
            r11.f3016b = r5
            goto L33
        L31:
            r11.f3016b = r12
        L33:
            r4 = -1
            r5 = 0
            int[] r6 = androidx.appcompat.widget.V.f3014i     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            android.content.res.TypedArray r6 = r12.obtainStyledAttributes(r13, r6, r0, r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            boolean r7 = r6.hasValue(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
            if (r7 == 0) goto L4c
            int r4 = r6.getInt(r2, r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
            goto L4c
        L46:
            r11 = move-exception
            r5 = r6
            goto Ld5
        L4a:
            r7 = move-exception
            goto L55
        L4c:
            r6.recycle()
            goto L5f
        L50:
            r11 = move-exception
            goto Ld5
        L53:
            r7 = move-exception
            r6 = r5
        L55:
            java.lang.String r8 = "AppCompatSpinner"
            java.lang.String r9 = "Could not read android:spinnerMode"
            android.util.Log.i(r8, r9, r7)     // Catch: java.lang.Throwable -> L46
            if (r6 == 0) goto L5f
            goto L4c
        L5f:
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L99
            if (r4 == r7) goto L66
            goto La6
        L66:
            androidx.appcompat.widget.T r4 = new androidx.appcompat.widget.T
            android.content.Context r8 = r11.f3016b
            r4.<init>(r11, r8, r13)
            android.content.Context r8 = r11.f3016b
            android.support.v4.media.session.c r1 = android.support.v4.media.session.c.y(r0, r2, r8, r13, r1)
            java.lang.Object r8 = r1.f2365c
            android.content.res.TypedArray r8 = (android.content.res.TypedArray) r8
            r9 = 3
            r10 = -2
            int r8 = r8.getLayoutDimension(r9, r10)
            r11.f3021g = r8
            android.graphics.drawable.Drawable r8 = r1.l(r7)
            r4.d(r8)
            java.lang.String r6 = r3.s(r6)
            r4.f2961A = r6
            r1.A()
            r11.f3020f = r4
            androidx.appcompat.widget.l r1 = new androidx.appcompat.widget.l
            r1.<init>(r7, r11, r11, r4)
            r11.f3017c = r1
            goto La6
        L99:
            androidx.appcompat.widget.P r1 = new androidx.appcompat.widget.P
            r1.<init>(r11)
            r11.f3020f = r1
            java.lang.String r4 = r3.s(r6)
            r1.f2896c = r4
        La6:
            java.lang.Object r1 = r3.f2365c
            android.content.res.TypedArray r1 = (android.content.res.TypedArray) r1
            java.lang.CharSequence[] r1 = r1.getTextArray(r2)
            if (r1 == 0) goto Lc1
            android.widget.ArrayAdapter r2 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r2.<init>(r12, r4, r1)
            r12 = 2131493223(0x7f0c0167, float:1.860992E38)
            r2.setDropDownViewResource(r12)
            r11.setAdapter(r2)
        Lc1:
            r3.A()
            r11.f3019e = r7
            android.widget.SpinnerAdapter r12 = r11.f3018d
            if (r12 == 0) goto Lcf
            r11.setAdapter(r12)
            r11.f3018d = r5
        Lcf:
            androidx.appcompat.widget.u r11 = r11.f3015a
            r11.d(r13, r0)
            return
        Ld5:
            if (r5 == 0) goto Lda
            r5.recycle()
        Lda:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.V.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i4 = 0;
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
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
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
        Rect rect = this.f3022h;
        drawable.getPadding(rect);
        return iMax2 + rect.left + rect.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0228u c0228u = this.f3015a;
        if (c0228u != null) {
            c0228u.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        U u4 = this.f3020f;
        return u4 != null ? u4.f() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        U u4 = this.f3020f;
        return u4 != null ? u4.o() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f3020f != null ? this.f3021g : super.getDropDownWidth();
    }

    @VisibleForTesting
    public final U getInternalPopup() {
        return this.f3020f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        U u4 = this.f3020f;
        return u4 != null ? u4.h() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f3016b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        U u4 = this.f3020f;
        return u4 != null ? u4.p() : super.getPrompt();
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportBackgroundTintList() {
        C0228u c0228u = this.f3015a;
        if (c0228u != null) {
            return c0228u.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0228u c0228u = this.f3015a;
        if (c0228u != null) {
            return c0228u.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        U u4 = this.f3020f;
        if (u4 == null || !u4.e()) {
            return;
        }
        u4.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f3020f == null || View.MeasureSpec.getMode(i4) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i4)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        AppCompatSpinner$SavedState appCompatSpinner$SavedState = (AppCompatSpinner$SavedState) parcelable;
        super.onRestoreInstanceState(appCompatSpinner$SavedState.getSuperState());
        if (!appCompatSpinner$SavedState.f2799a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0651e(2, this));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        AppCompatSpinner$SavedState appCompatSpinner$SavedState = new AppCompatSpinner$SavedState(super.onSaveInstanceState());
        U u4 = this.f3020f;
        appCompatSpinner$SavedState.f2799a = u4 != null && u4.e();
        return appCompatSpinner$SavedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0211l c0211l = this.f3017c;
        if (c0211l == null || !c0211l.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        U u4 = this.f3020f;
        if (u4 == null) {
            return super.performClick();
        }
        if (u4.e()) {
            return true;
        }
        this.f3020f.n(getTextDirection(), getTextAlignment());
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0228u c0228u = this.f3015a;
        if (c0228u != null) {
            c0228u.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        C0228u c0228u = this.f3015a;
        if (c0228u != null) {
            c0228u.f(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i4) {
        U u4 = this.f3020f;
        if (u4 == null) {
            super.setDropDownHorizontalOffset(i4);
        } else {
            u4.l(i4);
            u4.m(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i4) {
        U u4 = this.f3020f;
        if (u4 != null) {
            u4.k(i4);
        } else {
            super.setDropDownVerticalOffset(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i4) {
        if (this.f3020f != null) {
            this.f3021g = i4;
        } else {
            super.setDropDownWidth(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        U u4 = this.f3020f;
        if (u4 != null) {
            u4.d(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@DrawableRes int i4) {
        setPopupBackgroundDrawable(Z2.I.o(getPopupContext(), i4));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        U u4 = this.f3020f;
        if (u4 != null) {
            u4.j(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C0228u c0228u = this.f3015a;
        if (c0228u != null) {
            c0228u.h(colorStateList);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C0228u c0228u = this.f3015a;
        if (c0228u != null) {
            c0228u.i(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f3019e) {
            this.f3018d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        U u4 = this.f3020f;
        if (u4 != null) {
            Context context = this.f3016b;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            Q q4 = new Q();
            q4.f2907a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                q4.f2908b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                O.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            u4.q(q4);
        }
    }
}
