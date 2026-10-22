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
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.L;
import androidx.appcompat.widget.f0;
import l.InterfaceC0820e;

/* loaded from: classes.dex */
public class ActionMenuItemView extends D implements k.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: h, reason: collision with root package name */
    g f7779h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f7780i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f7781j;

    /* renamed from: k, reason: collision with root package name */
    e.b f7782k;

    /* renamed from: l, reason: collision with root package name */
    private L f7783l;

    /* renamed from: m, reason: collision with root package name */
    b f7784m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f7785n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7786o;

    /* renamed from: p, reason: collision with root package name */
    private int f7787p;

    /* renamed from: q, reason: collision with root package name */
    private int f7788q;

    /* renamed from: r, reason: collision with root package name */
    private int f7789r;

    private class a extends L {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.L
        public InterfaceC0820e b() {
            b bVar = ActionMenuItemView.this.f7784m;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.L
        protected boolean c() {
            InterfaceC0820e interfaceC0820eB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.f7782k;
            return bVar != null && bVar.a(actionMenuItemView.f7779h) && (interfaceC0820eB = b()) != null && interfaceC0820eB.h();
        }
    }

    public static abstract class b {
        public abstract InterfaceC0820e a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean u() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i5 = configuration.screenWidthDp;
        int i6 = configuration.screenHeightDp;
        if (i5 < 480) {
            return (i5 >= 640 && i6 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    private void v() {
        boolean z5 = true;
        boolean z6 = !TextUtils.isEmpty(this.f7780i);
        if (this.f7781j != null && (!this.f7779h.B() || (!this.f7785n && !this.f7786o))) {
            z5 = false;
        }
        boolean z7 = z6 & z5;
        setText(z7 ? this.f7780i : null);
        CharSequence contentDescription = this.f7779h.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z7 ? null : this.f7779h.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f7779h.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            f0.a(this, z7 ? null : this.f7779h.getTitle());
        } else {
            f0.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return t();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return t() && this.f7779h.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean c() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void f(g gVar, int i5) {
        this.f7779h = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f7783l == null) {
            this.f7783l = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f7779h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar = this.f7782k;
        if (bVar != null) {
            bVar.a(this.f7779h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f7785n = u();
        v();
    }

    @Override // androidx.appcompat.widget.D, android.widget.TextView, android.view.View
    protected void onMeasure(int i5, int i6) {
        int i7;
        boolean zT = t();
        if (zT && (i7 = this.f7788q) >= 0) {
            super.setPadding(i7, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i5, i6);
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f7787p) : this.f7787p;
        if (mode != 1073741824 && this.f7787p > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i6);
        }
        if (zT || this.f7781j == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f7781j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        L l5;
        if (this.f7779h.hasSubMenu() && (l5 = this.f7783l) != null && l5.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z5) {
    }

    public void setChecked(boolean z5) {
    }

    public void setExpandedFormat(boolean z5) {
        if (this.f7786o != z5) {
            this.f7786o = z5;
            g gVar = this.f7779h;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f7781j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i5 = this.f7789r;
            if (intrinsicWidth > i5) {
                intrinsicHeight = (int) (intrinsicHeight * (i5 / intrinsicWidth));
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > i5) {
                intrinsicWidth = (int) (intrinsicWidth * (i5 / intrinsicHeight));
            } else {
                i5 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i5);
        }
        setCompoundDrawables(drawable, null, null, null);
        v();
    }

    public void setItemInvoker(e.b bVar) {
        this.f7782k = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i5, int i6, int i7, int i8) {
        this.f7788q = i5;
        super.setPadding(i5, i6, i7, i8);
    }

    public void setPopupCallback(b bVar) {
        this.f7784m = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f7780i = charSequence;
        v();
    }

    public boolean t() {
        return !TextUtils.isEmpty(getText());
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        Resources resources = context.getResources();
        this.f7785n = u();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.f17199v, i5, 0);
        this.f7787p = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.f17204w, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f7789r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f7788q = -1;
        setSaveEnabled(false);
    }
}
