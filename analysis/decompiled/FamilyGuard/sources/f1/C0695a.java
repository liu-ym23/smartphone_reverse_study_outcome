package f1;

import a1.C0409b;
import a1.C0412e;
import a1.C0413f;
import a1.C0416i;
import a1.C0417j;
import a1.C0418k;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.appcompat.widget.C0437g;
import androidx.appcompat.widget.a0;
import com.google.android.material.internal.o;
import com.google.android.material.internal.r;
import g.C0728a;
import h.C0744a;
import j1.C0777a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import q1.C0981c;
import x1.C1282a;

/* renamed from: f1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0695a extends C0437g {

    /* renamed from: A, reason: collision with root package name */
    private static final int[] f16752A;

    /* renamed from: B, reason: collision with root package name */
    private static final int[][] f16753B;

    /* renamed from: C, reason: collision with root package name */
    private static final int f16754C;

    /* renamed from: y, reason: collision with root package name */
    private static final int f16755y = C0417j.f6927r;

    /* renamed from: z, reason: collision with root package name */
    private static final int[] f16756z = {C0409b.f6708R};

    /* renamed from: e, reason: collision with root package name */
    private final LinkedHashSet<c> f16757e;

    /* renamed from: f, reason: collision with root package name */
    private final LinkedHashSet<b> f16758f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f16759g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f16760h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f16761i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f16762j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f16763k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f16764l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f16765m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f16766n;

    /* renamed from: o, reason: collision with root package name */
    ColorStateList f16767o;

    /* renamed from: p, reason: collision with root package name */
    ColorStateList f16768p;

    /* renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f16769q;

    /* renamed from: r, reason: collision with root package name */
    private int f16770r;

    /* renamed from: s, reason: collision with root package name */
    private int[] f16771s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f16772t;

    /* renamed from: u, reason: collision with root package name */
    private CharSequence f16773u;

    /* renamed from: v, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f16774v;

    /* renamed from: w, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.c f16775w;

    /* renamed from: x, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b f16776x;

    /* renamed from: f1.a$a, reason: collision with other inner class name */
    class C0214a extends androidx.vectordrawable.graphics.drawable.b {
        C0214a() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void b(Drawable drawable) {
            super.b(drawable);
            ColorStateList colorStateList = C0695a.this.f16767o;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void c(Drawable drawable) {
            super.c(drawable);
            C0695a c0695a = C0695a.this;
            ColorStateList colorStateList = c0695a.f16767o;
            if (colorStateList != null) {
                drawable.setTint(colorStateList.getColorForState(c0695a.f16771s, C0695a.this.f16767o.getDefaultColor()));
            }
        }
    }

    /* renamed from: f1.a$b */
    public interface b {
        void a(C0695a c0695a, int i5);
    }

    /* renamed from: f1.a$c */
    public interface c {
        void a(C0695a c0695a, boolean z5);
    }

    /* renamed from: f1.a$d */
    static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new C0215a();

        /* renamed from: a, reason: collision with root package name */
        int f16778a;

        /* renamed from: f1.a$d$a, reason: collision with other inner class name */
        class C0215a implements Parcelable.Creator<d> {
            C0215a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i5) {
                return new d[i5];
            }
        }

        /* synthetic */ d(Parcel parcel, C0214a c0214a) {
            this(parcel);
        }

        private String a() {
            int i5 = this.f16778a;
            return i5 != 1 ? i5 != 2 ? "unchecked" : "indeterminate" : "checked";
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + a() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeValue(Integer.valueOf(this.f16778a));
        }

        d(Parcelable parcelable) {
            super(parcelable);
        }

        private d(Parcel parcel) {
            super(parcel);
            this.f16778a = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    static {
        int i5 = C0409b.f6707Q;
        f16752A = new int[]{i5};
        f16753B = new int[][]{new int[]{R.attr.state_enabled, i5}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
        f16754C = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public C0695a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16843t);
    }

    private boolean c(a0 a0Var) {
        return a0Var.n(C0418k.f7058U2, 0) == f16754C && a0Var.n(C0418k.f7064V2, 0) == 0;
    }

    private void e() {
        this.f16764l = com.google.android.material.drawable.a.c(this.f16764l, this.f16767o, androidx.core.widget.c.c(this));
        this.f16765m = com.google.android.material.drawable.a.c(this.f16765m, this.f16768p, this.f16769q);
        g();
        h();
        super.setButtonDrawable(com.google.android.material.drawable.a.a(this.f16764l, this.f16765m));
        refreshDrawableState();
    }

    private void f() {
        if (this.f16773u == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    private void g() {
        androidx.vectordrawable.graphics.drawable.c cVar;
        if (this.f16766n) {
            androidx.vectordrawable.graphics.drawable.c cVar2 = this.f16775w;
            if (cVar2 != null) {
                cVar2.f(this.f16776x);
                this.f16775w.b(this.f16776x);
            }
            Drawable drawable = this.f16764l;
            if (!(drawable instanceof AnimatedStateListDrawable) || (cVar = this.f16775w) == null) {
                return;
            }
            int i5 = C0413f.f6839b;
            int i6 = C0413f.f6836S;
            ((AnimatedStateListDrawable) drawable).addTransition(i5, i6, cVar, false);
            ((AnimatedStateListDrawable) this.f16764l).addTransition(C0413f.f6845h, i6, this.f16775w, false);
        }
    }

    private String getButtonStateDescription() {
        int i5 = this.f16770r;
        return i5 == 1 ? getResources().getString(C0416i.f6892h) : i5 == 0 ? getResources().getString(C0416i.f6894j) : getResources().getString(C0416i.f6893i);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f16759g == null) {
            int[][] iArr = f16753B;
            int[] iArr2 = new int[iArr.length];
            int iD = C0777a.d(this, C0728a.f16847x);
            int iD2 = C0777a.d(this, C0728a.f16804A);
            int iD3 = C0777a.d(this, C0409b.f6720g);
            int iD4 = C0777a.d(this, C0409b.f6717d);
            iArr2[0] = C0777a.j(iD3, iD2, 1.0f);
            iArr2[1] = C0777a.j(iD3, iD, 1.0f);
            iArr2[2] = C0777a.j(iD3, iD4, 0.54f);
            iArr2[3] = C0777a.j(iD3, iD4, 0.38f);
            iArr2[4] = C0777a.j(iD3, iD4, 0.38f);
            this.f16759g = new ColorStateList(iArr, iArr2);
        }
        return this.f16759g;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f16767o;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    private void h() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f16764l;
        if (drawable != null && (colorStateList2 = this.f16767o) != null) {
            drawable.setTintList(colorStateList2);
        }
        Drawable drawable2 = this.f16765m;
        if (drawable2 == null || (colorStateList = this.f16768p) == null) {
            return;
        }
        drawable2.setTintList(colorStateList);
    }

    public boolean d() {
        return this.f16762j;
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f16764l;
    }

    public Drawable getButtonIconDrawable() {
        return this.f16765m;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f16768p;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f16769q;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f16767o;
    }

    public int getCheckedState() {
        return this.f16770r;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f16763k;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.f16770r == 1;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f16760h && this.f16767o == null && this.f16768p == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i5) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i5 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f16756z);
        }
        if (d()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f16752A);
        }
        this.f16771s = com.google.android.material.drawable.a.e(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.f16761i || !TextUtils.isEmpty(getText()) || (drawableA = androidx.core.widget.c.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (r.g(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && d()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f16763k));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        setCheckedState(dVar.f16778a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f16778a = getCheckedState();
        return dVar;
    }

    @Override // androidx.appcompat.widget.C0437g, android.widget.CompoundButton
    public void setButtonDrawable(int i5) {
        setButtonDrawable(C0744a.b(getContext(), i5));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f16765m = drawable;
        e();
    }

    public void setButtonIconDrawableResource(int i5) {
        setButtonIconDrawable(C0744a.b(getContext(), i5));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f16768p == colorStateList) {
            return;
        }
        this.f16768p = colorStateList;
        e();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f16769q == mode) {
            return;
        }
        this.f16769q = mode;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f16767o == colorStateList) {
            return;
        }
        this.f16767o = colorStateList;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        e();
    }

    public void setCenterIfNoTextEnabled(boolean z5) {
        this.f16761i = z5;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z5) {
        setCheckedState(z5 ? 1 : 0);
    }

    public void setCheckedState(int i5) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f16770r != i5) {
            this.f16770r = i5;
            super.setChecked(i5 == 1);
            refreshDrawableState();
            f();
            if (this.f16772t) {
                return;
            }
            this.f16772t = true;
            LinkedHashSet<b> linkedHashSet = this.f16758f;
            if (linkedHashSet != null) {
                Iterator<b> it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.f16770r);
                }
            }
            if (this.f16770r != 2 && (onCheckedChangeListener = this.f16774v) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f16772t = false;
        }
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f16763k = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i5) {
        setErrorAccessibilityLabel(i5 != 0 ? getResources().getText(i5) : null);
    }

    public void setErrorShown(boolean z5) {
        if (this.f16762j == z5) {
            return;
        }
        this.f16762j = z5;
        refreshDrawableState();
        Iterator<c> it = this.f16757e.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f16762j);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f16774v = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.f16773u = charSequence;
        if (charSequence == null) {
            f();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z5) {
        this.f16760h = z5;
        if (z5) {
            androidx.core.widget.c.d(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.c.d(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0695a(Context context, AttributeSet attributeSet, int i5) {
        int i6 = f16755y;
        super(C1282a.d(context, attributeSet, i5, i6), attributeSet, i5);
        this.f16757e = new LinkedHashSet<>();
        this.f16758f = new LinkedHashSet<>();
        this.f16775w = androidx.vectordrawable.graphics.drawable.c.a(getContext(), C0412e.f6813g);
        this.f16776x = new C0214a();
        Context context2 = getContext();
        this.f16764l = androidx.core.widget.c.a(this);
        this.f16767o = getSuperButtonTintList();
        setSupportButtonTintList(null);
        a0 a0VarJ = o.j(context2, attributeSet, C0418k.f7052T2, i5, i6, new int[0]);
        this.f16765m = a0VarJ.g(C0418k.f7070W2);
        if (this.f16764l != null && o.g(context2) && c(a0VarJ)) {
            super.setButtonDrawable((Drawable) null);
            this.f16764l = C0744a.b(context2, C0412e.f6812f);
            this.f16766n = true;
            if (this.f16765m == null) {
                this.f16765m = C0744a.b(context2, C0412e.f6814h);
            }
        }
        this.f16768p = C0981c.b(context2, a0VarJ, C0418k.f7076X2);
        this.f16769q = r.h(a0VarJ.k(C0418k.f7082Y2, -1), PorterDuff.Mode.SRC_IN);
        this.f16760h = a0VarJ.a(C0418k.f7116d3, false);
        this.f16761i = a0VarJ.a(C0418k.f7088Z2, true);
        this.f16762j = a0VarJ.a(C0418k.f7109c3, false);
        this.f16763k = a0VarJ.p(C0418k.f7102b3);
        int i7 = C0418k.f7095a3;
        if (a0VarJ.s(i7)) {
            setCheckedState(a0VarJ.k(i7, 0));
        }
        a0VarJ.x();
        e();
    }

    @Override // androidx.appcompat.widget.C0437g, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f16764l = drawable;
        this.f16766n = false;
        e();
    }
}
