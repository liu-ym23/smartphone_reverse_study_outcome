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
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.C0200f0;
import androidx.appcompat.widget.InterfaceC0219p;
import androidx.appcompat.widget.h1;
import e.EnumC0546d;
import g.AbstractC0560a;
import k.AbstractC0649c;
import k.C0648b;
import k.C0661o;
import k.C0663q;
import k.InterfaceC0641B;
import k.InterfaceC0660n;

@RestrictTo({EnumC0546d.f12494c})
/* loaded from: classes.dex */
public class ActionMenuItemView extends C0200f0 implements InterfaceC0641B, View.OnClickListener, InterfaceC0219p {

    /* renamed from: g, reason: collision with root package name */
    public C0663q f2691g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f2692h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f2693i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0660n f2694j;

    /* renamed from: k, reason: collision with root package name */
    public C0648b f2695k;

    /* renamed from: l, reason: collision with root package name */
    public AbstractC0649c f2696l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2697m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2698n;

    /* renamed from: o, reason: collision with root package name */
    public final int f2699o;

    /* renamed from: p, reason: collision with root package name */
    public int f2700p;

    /* renamed from: q, reason: collision with root package name */
    public final int f2701q;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f2697m = s();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12590c, 0, 0);
        this.f2699o = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f2701q = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f2700p = -1;
        setSaveEnabled(false);
    }

    @Override // androidx.appcompat.widget.InterfaceC0219p
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.widget.InterfaceC0219p
    public final boolean b() {
        return (TextUtils.isEmpty(getText()) ^ true) && this.f2691g.getIcon() == null;
    }

    @Override // k.InterfaceC0641B
    public final void c(C0663q c0663q) {
        this.f2691g = c0663q;
        setIcon(c0663q.getIcon());
        setTitle(c0663q.getTitleCondensed());
        setId(c0663q.f13269a);
        int i4 = 0;
        setVisibility(c0663q.isVisible() ? 0 : 8);
        setEnabled(c0663q.isEnabled());
        if (c0663q.hasSubMenu() && this.f2695k == null) {
            this.f2695k = new C0648b(this, i4);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // k.InterfaceC0641B
    public C0663q getItemData() {
        return this.f2691g;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC0660n interfaceC0660n = this.f2694j;
        if (interfaceC0660n != null) {
            interfaceC0660n.a(this.f2691g);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2697m = s();
        t();
    }

    @Override // androidx.appcompat.widget.C0200f0, android.widget.TextView, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        boolean z4 = !TextUtils.isEmpty(getText());
        if (z4 && (i6 = this.f2700p) >= 0) {
            super.setPadding(i6, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int measuredWidth = getMeasuredWidth();
        int i7 = this.f2699o;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i7) : i7;
        if (mode != 1073741824 && i7 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i5);
        }
        if (z4 || this.f2693i == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f2693i.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0648b c0648b;
        if (this.f2691g.hasSubMenu() && (c0648b = this.f2695k) != null && c0648b.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final boolean s() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i4 = configuration.screenWidthDp;
        return i4 >= 480 || (i4 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public void setCheckable(boolean z4) {
    }

    public void setChecked(boolean z4) {
    }

    public void setExpandedFormat(boolean z4) {
        if (this.f2698n != z4) {
            this.f2698n = z4;
            C0663q c0663q = this.f2691g;
            if (c0663q != null) {
                C0661o c0661o = c0663q.f13282n;
                c0661o.f13248k = true;
                c0661o.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2693i = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i4 = this.f2701q;
            if (intrinsicWidth > i4) {
                intrinsicHeight = (int) (intrinsicHeight * (i4 / intrinsicWidth));
                intrinsicWidth = i4;
            }
            if (intrinsicHeight > i4) {
                intrinsicWidth = (int) (intrinsicWidth * (i4 / intrinsicHeight));
            } else {
                i4 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i4);
        }
        setCompoundDrawables(drawable, null, null, null);
        t();
    }

    public void setItemInvoker(InterfaceC0660n interfaceC0660n) {
        this.f2694j = interfaceC0660n;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i4, int i5, int i6, int i7) {
        this.f2700p = i4;
        super.setPadding(i4, i5, i6, i7);
    }

    public void setPopupCallback(AbstractC0649c abstractC0649c) {
        this.f2696l = abstractC0649c;
    }

    public void setTitle(CharSequence charSequence) {
        this.f2692h = charSequence;
        t();
    }

    public final void t() {
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f2692h);
        if (this.f2693i != null && ((this.f2691g.f13293y & 4) != 4 || (!this.f2697m && !this.f2698n))) {
            z4 = false;
        }
        boolean z6 = z5 & z4;
        setText(z6 ? this.f2692h : null);
        CharSequence charSequence = this.f2691g.f13285q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z6 ? null : this.f2691g.f13273e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f2691g.f13286r;
        if (TextUtils.isEmpty(charSequence2)) {
            h1.a(this, z6 ? null : this.f2691g.f13273e);
        } else {
            h1.a(this, charSequence2);
        }
    }
}
