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
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.E;
import androidx.appcompat.widget.Z;
import j.InterfaceC4741f;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements j.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: a, reason: collision with root package name */
    public g f8518a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f8519b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f8520c;

    /* renamed from: d, reason: collision with root package name */
    public e.b f8521d;

    /* renamed from: e, reason: collision with root package name */
    public E f8522e;

    /* renamed from: f, reason: collision with root package name */
    public b f8523f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8524g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8525h;

    /* renamed from: i, reason: collision with root package name */
    public int f8526i;

    /* renamed from: j, reason: collision with root package name */
    public int f8527j;

    /* renamed from: k, reason: collision with root package name */
    public int f8528k;

    public class a extends E {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.E
        public InterfaceC4741f b() {
            b bVar = ActionMenuItemView.this.f8523f;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.E
        public boolean c() {
            InterfaceC4741f interfaceC4741fB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.f8521d;
            return bVar != null && bVar.f(actionMenuItemView.f8518a) && (interfaceC4741fB = b()) != null && interfaceC4741fB.isShowing();
        }
    }

    public static abstract class b {
        public abstract InterfaceC4741f a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void h() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f8519b);
        if (this.f8520c != null && (!this.f8518a.B() || (!this.f8524g && !this.f8525h))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        setText(z12 ? this.f8519b : null);
        CharSequence contentDescription = this.f8518a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z12 ? null : this.f8518a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f8518a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            Z.a(this, z12 ? null : this.f8518a.getTitle());
        } else {
            Z.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return f();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return f() && this.f8518a.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean c() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void e(g gVar, int i10) {
        this.f8518a = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f8522e == null) {
            this.f8522e = new a();
        }
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (i10 < 480) {
            return (i10 >= 640 && i11 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.j.a
    public g getItemData() {
        return this.f8518a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar = this.f8521d;
        if (bVar != null) {
            bVar.f(this.f8518a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f8524g = g();
        h();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        boolean zF = f();
        if (zF && (i12 = this.f8527j) >= 0) {
            super.setPadding(i12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f8526i) : this.f8526i;
        if (mode != 1073741824 && this.f8526i > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i11);
        }
        if (zF || this.f8520c == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f8520c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        E e10;
        if (this.f8518a.hasSubMenu() && (e10 = this.f8522e) != null && e10.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f8525h != z10) {
            this.f8525h = z10;
            g gVar = this.f8518a;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f8520c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f8528k;
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
        h();
    }

    public void setItemInvoker(e.b bVar) {
        this.f8521d = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        this.f8527j = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(b bVar) {
        this.f8523f = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f8519b = charSequence;
        h();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources = context.getResources();
        this.f8524g = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i10, 0);
        this.f8526i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f8528k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f8527j = -1;
        setSaveEnabled(false);
    }
}
