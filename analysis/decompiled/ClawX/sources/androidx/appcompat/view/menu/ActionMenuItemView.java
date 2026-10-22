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
import f.a;
import f.b;
import f.i;
import f.k;
import f.q;
import g.f2;
import g.g0;
import g.j;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class ActionMenuItemView extends g0 implements q, View.OnClickListener, j {

    /* renamed from: g, reason: collision with root package name */
    public k f243g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f244h;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f245j;

    /* renamed from: k, reason: collision with root package name */
    public i f246k;

    /* renamed from: l, reason: collision with root package name */
    public a f247l;

    /* renamed from: m, reason: collision with root package name */
    public b f248m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f249n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f250o;

    /* renamed from: p, reason: collision with root package name */
    public final int f251p;

    /* renamed from: q, reason: collision with root package name */
    public int f252q;

    /* renamed from: r, reason: collision with root package name */
    public final int f253r;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f249n = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.f1016c, 0, 0);
        this.f251p = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f253r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f252q = -1;
        setSaveEnabled(false);
    }

    @Override // g.j
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // f.q
    public final void b(k kVar) {
        this.f243g = kVar;
        setIcon(kVar.getIcon());
        setTitle(kVar.getTitleCondensed());
        setId(kVar.f2473a);
        setVisibility(kVar.isVisible() ? 0 : 8);
        setEnabled(kVar.isEnabled());
        if (kVar.hasSubMenu() && this.f247l == null) {
            this.f247l = new a(this);
        }
    }

    @Override // g.j
    public final boolean c() {
        return !TextUtils.isEmpty(getText()) && this.f243g.getIcon() == null;
    }

    public final boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i8 = configuration.screenWidthDp;
        int i9 = configuration.screenHeightDp;
        if (i8 < 480) {
            return (i8 >= 640 && i9 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // f.q
    public k getItemData() {
        return this.f243g;
    }

    public final void h() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f244h);
        if (this.f245j != null && ((this.f243g.y & 4) != 4 || (!this.f249n && !this.f250o))) {
            z = false;
        }
        boolean z8 = z2 & z;
        setText(z8 ? this.f244h : null);
        CharSequence charSequence = this.f243g.f2488q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z8 ? null : this.f243g.f2476e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f243g.f2489r;
        if (TextUtils.isEmpty(charSequence2)) {
            f2.a(this, z8 ? null : this.f243g.f2476e);
        } else {
            f2.a(this, charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        i iVar = this.f246k;
        if (iVar != null) {
            iVar.a(this.f243g);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f249n = g();
        h();
    }

    @Override // g.g0, android.widget.TextView, android.view.View
    public final void onMeasure(int i8, int i9) {
        int i10;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i10 = this.f252q) >= 0) {
            super.setPadding(i10, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i8, i9);
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        int measuredWidth = getMeasuredWidth();
        int i11 = this.f251p;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i11) : i11;
        if (mode != 1073741824 && i11 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i9);
        }
        if (!zIsEmpty || this.f245j == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f245j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (this.f243g.hasSubMenu() && (aVar = this.f247l) != null && aVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z) {
        if (this.f250o != z) {
            this.f250o = z;
            k kVar = this.f243g;
            if (kVar != null) {
                f.j jVar = kVar.f2485n;
                jVar.f2463k = true;
                jVar.o(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f245j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i8 = this.f253r;
            if (intrinsicWidth > i8) {
                intrinsicHeight = (int) (intrinsicHeight * (i8 / intrinsicWidth));
                intrinsicWidth = i8;
            }
            if (intrinsicHeight > i8) {
                intrinsicWidth = (int) (intrinsicWidth * (i8 / intrinsicHeight));
            } else {
                i8 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i8);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(i iVar) {
        this.f246k = iVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i8, int i9, int i10, int i11) {
        this.f252q = i8;
        super.setPadding(i8, i9, i10, i11);
    }

    public void setPopupCallback(b bVar) {
        this.f248m = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f244h = charSequence;
        h();
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }
}
