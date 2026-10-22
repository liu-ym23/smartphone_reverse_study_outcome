package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.i0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements k.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: j, reason: collision with root package name */
    public h f402j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f403k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f404l;

    /* renamed from: m, reason: collision with root package name */
    public f.b f405m;

    /* renamed from: n, reason: collision with root package name */
    public a f406n;

    /* renamed from: o, reason: collision with root package name */
    public b f407o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f408p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f409q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public int f410s;

    /* renamed from: t, reason: collision with root package name */
    public final int f411t;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends i0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.i0
        public final l.f b() {
            ActionMenuPresenter.a aVar;
            b bVar = ActionMenuItemView.this.f407o;
            if (bVar == null || (aVar = ActionMenuPresenter.this.f606w) == null) {
                return null;
            }
            return aVar.a();
        }

        @Override // androidx.appcompat.widget.i0
        public final boolean c() {
            l.f fVarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            f.b bVar = actionMenuItemView.f405m;
            return bVar != null && bVar.e(actionMenuItemView.f402j) && (fVarB = b()) != null && fVarB.isShowing();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class b {
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f408p = h();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f8923c, 0, 0);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f411t = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f410s = -1;
        setSaveEnabled(false);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public final boolean b() {
        return !TextUtils.isEmpty(getText()) && this.f402j.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final void d(h hVar) {
        this.f402j = hVar;
        setIcon(hVar.getIcon());
        setTitle(hVar.getTitleCondensed());
        setId(hVar.f501a);
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.f406n == null) {
            this.f406n = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public h getItemData() {
        return this.f402j;
    }

    public final boolean h() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (i10 < 480) {
            return (i10 >= 640 && i11 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    public final void i() {
        boolean z = true;
        boolean z3 = !TextUtils.isEmpty(this.f403k);
        if (this.f404l != null && ((this.f402j.B & 4) != 4 || (!this.f408p && !this.f409q))) {
            z = false;
        }
        boolean z10 = z3 & z;
        setText(z10 ? this.f403k : null);
        CharSequence charSequence = this.f402j.f515t;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z10 ? null : this.f402j.f505e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f402j.f516u;
        if (TextUtils.isEmpty(charSequence2)) {
            c1.a(this, z10 ? null : this.f402j.f505e);
        } else {
            c1.a(this, charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        f.b bVar = this.f405m;
        if (bVar != null) {
            bVar.e(this.f402j);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f408p = h();
        i();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i12 = this.f410s) >= 0) {
            super.setPadding(i12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        int i13 = this.r;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i13) : i13;
        if (mode != 1073741824 && i13 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i11);
        }
        if (!zIsEmpty || this.f404l == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f404l.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (this.f402j.hasSubMenu() && (aVar = this.f406n) != null && aVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z) {
        if (this.f409q != z) {
            this.f409q = z;
            h hVar = this.f402j;
            if (hVar != null) {
                f fVar = hVar.f513q;
                fVar.f487n = true;
                fVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f404l = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f411t;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, null, null, null);
        i();
    }

    public void setItemInvoker(f.b bVar) {
        this.f405m = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i10, int i11, int i12, int i13) {
        this.f410s = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(b bVar) {
        this.f407o = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f403k = charSequence;
        i();
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }
}
