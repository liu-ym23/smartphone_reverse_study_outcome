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
import g.a;
import l.b;
import l.c;
import l.k;
import l.n;
import l.y;
import m.l;
import m.v0;
import m.w2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ActionMenuItemView extends v0 implements y, View.OnClickListener, l {

    /* renamed from: k, reason: collision with root package name */
    public n f715k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f716l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f717m;

    /* renamed from: n, reason: collision with root package name */
    public k f718n;

    /* renamed from: o, reason: collision with root package name */
    public b f719o;

    /* renamed from: p, reason: collision with root package name */
    public c f720p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f721q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f722r;

    /* renamed from: s, reason: collision with root package name */
    public final int f723s;

    /* renamed from: t, reason: collision with root package name */
    public int f724t;

    /* renamed from: u, reason: collision with root package name */
    public final int f725u;

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f721q = f();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f4100c, i, 0);
        this.f723s = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f725u = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f724t = -1;
        setSaveEnabled(false);
    }

    @Override // m.l
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // m.l
    public final boolean b() {
        return !TextUtils.isEmpty(getText()) && this.f715k.getIcon() == null;
    }

    @Override // l.y
    public final void c(n nVar) {
        this.f715k = nVar;
        setIcon(nVar.getIcon());
        setTitle(nVar.getTitleCondensed());
        setId(nVar.f7610a);
        setVisibility(nVar.isVisible() ? 0 : 8);
        setEnabled(nVar.isEnabled());
        if (nVar.hasSubMenu() && this.f719o == null) {
            this.f719o = new b(this, 0);
        }
    }

    public final boolean f() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (i < 480) {
            return (i >= 640 && i3 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    public final void g() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f716l);
        if (this.f717m != null && ((this.f715k.f7633y & 4) != 4 || (!this.f721q && !this.f722r))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        setText(z12 ? this.f716l : null);
        CharSequence charSequence = this.f715k.f7625q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z12 ? null : this.f715k.f7614e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f715k.f7626r;
        if (TextUtils.isEmpty(charSequence2)) {
            w2.a(this, z12 ? null : this.f715k.f7614e);
        } else {
            w2.a(this, charSequence2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // l.y
    public n getItemData() {
        return this.f715k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k kVar = this.f718n;
        if (kVar != null) {
            kVar.a(this.f715k);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f721q = f();
        g();
    }

    @Override // m.v0, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i3) {
        int i10;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i10 = this.f724t) >= 0) {
            super.setPadding(i10, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i3);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i11 = this.f723s;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i11) : i11;
        if (mode != 1073741824 && i11 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i3);
        }
        if (!zIsEmpty || this.f717m == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f717m.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (this.f715k.hasSubMenu() && (bVar = this.f719o) != null && bVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f722r != z10) {
            this.f722r = z10;
            n nVar = this.f715k;
            if (nVar != null) {
                l.l lVar = nVar.f7622n;
                lVar.f7592k = true;
                lVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f717m = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f725u;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        g();
    }

    public void setItemInvoker(k kVar) {
        this.f718n = kVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i3, int i10, int i11) {
        this.f724t = i;
        super.setPadding(i, i3, i10, i11);
    }

    public void setPopupCallback(c cVar) {
        this.f720p = cVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f716l = charSequence;
        g();
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }
}
