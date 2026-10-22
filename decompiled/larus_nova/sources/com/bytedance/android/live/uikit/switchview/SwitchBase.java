package com.bytedance.android.live.uikit.switchview;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes7.dex */
public class SwitchBase extends CompoundButton {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f102444t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f102445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f102446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f102447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f102448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f102449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f102450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f102451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f102452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final VelocityTracker f102453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f102454j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f102455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f102456l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f102457m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f102458n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f102459o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f102460p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f102461q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f102462r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f102463s;

    static {
        f102444t = new int[]{R.attr.state_checked};
    }

    private boolean getTargetCheckedState() {
        if (this.f102455k < (getThumbScrollRange() / 2)) goto L5;
        return true;
    L5:
        return false;
    }

    private int getThumbScrollRange() {
        Drawable r100 = this.f102446b;
        if (r100 != null) goto L6;
        return 0;
    L6:
        r100.getPadding(this.f102463s);
        int r101 = this.f102456l - this.f102458n;
        Rect r102 = this.f102463s;
        return (r101 - r102.left) - r102.right;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r100 = getDrawableState();
        Drawable r101 = this.f102445a;
        if (r101 == null) goto L5;
        r101.setState(r100);
    L5:
        Drawable r102 = this.f102446b;
        if (r102 == null) goto L8;
        r102.setState(r100);
    L8:
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int r100 = super.getCompoundPaddingLeft() + this.f102456l;
        if (TextUtils.isEmpty(getText()) == false) goto L5;
        return r100;
    L5:
        return r100 + this.f102448d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        int r100 = super.getCompoundPaddingRight() + this.f102456l;
        if (TextUtils.isEmpty(getText()) == false) goto L5;
        return r100;
    L5:
        return r100 + this.f102448d;
    }

    public Drawable getThumbDrawable() {
        return this.f102445a;
    }

    public Drawable getTrackDrawable() {
        return this.f102446b;
    }

    public SwitchBase(Context r100) {
        this(r100, null);
    }

    private void setThumbPosition(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = getThumbScrollRange();
    L5:
        this.f102455k = r101;
        return;
    L4:
        r101 = 0.0f;
        goto L5
    }

    public void a(boolean r100) {
        setChecked(r100);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (isChecked() == false) goto L5;
        CompoundButton.mergeDrawableStates(r101, f102444t);
    L5:
        return r101;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = this.f102459o;
        int r102 = this.f102460p;
        int r103 = this.f102461q;
        int r104 = this.f102462r;
        this.f102446b.setBounds(r101, r102, r103, r104);
        this.f102446b.draw(r100);
        r100.save();
        this.f102446b.getPadding(this.f102463s);
        Rect r105 = this.f102463s;
        int r106 = r101 + r105.left;
        r100.clipRect(r106, r102, r103 - r105.right, r104);
        this.f102445a.getPadding(this.f102463s);
        int r107 = (int) (this.f102455k + 0.5f);
        Rect r108 = this.f102463s;
        int r109 = (r106 - r108.left) + r107;
        int r110 = ((r106 + r107) + this.f102458n) + r108.right;
        this.f102445a.setBounds(r109, r102, r110, r104);
        this.f102445a.draw(r100);
        r100.restore();
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        this.f102453i.addMovement(r110);
        int r100 = r110.getActionMasked();
        boolean r101 = false;
        if (r100 != 0) goto L5;
        getParent().requestDisallowInterceptTouchEvent(true);
        float r102 = r110.getX();
        float r111 = r110.getY();
        if (isEnabled() == false) goto L65;
        this.f102445a.getPadding(this.f102463s);
        int r103 = this.f102460p;
        int r104 = this.f102450f;
        int r105 = r103 - r104;
        int r106 = (this.f102459o + ((int) (this.f102455k + 0.5f))) - r104;
        int r107 = this.f102458n + r106;
        Rect r108 = this.f102463s;
        int r109 = ((r107 + r108.left) + r108.right) + r104;
        int r112 = this.f102462r + r104;
        if (r102 > r106) goto L53;
    L59:
        boolean r113 = false;
    L60:
        if (r113 == false) goto L62;
        this.f102449e = 1;
    L63:
        this.f102451g = r102;
        this.f102452h = r111;
        goto L65
    L62:
        this.f102449e = 3;
        goto L63
    L53:
        if (r102 >= r109) goto L59;
        if (r111 <= r105) goto L59;
        if (r111 >= r112) goto L59;
        r113 = true;
    L65:
        if (this.f102449e == 0) goto L68;
        return true;
    L68:
        return false;
    L5:
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L9;
        if (r100 == 3) goto L23;
    L9:
        int r114 = this.f102449e;
        if (r114 == 1) goto L17;
        if (r114 != 2) goto L65;
        float r115 = r110.getX();
        float r116 = Math.max(0.0f, Math.min(this.f102455k + (r115 - this.f102451g), getThumbScrollRange()));
        if (r116 == this.f102455k) goto L16;
        this.f102455k = r116;
        this.f102451g = r115;
        invalidate();
    L16:
        return true;
    L17:
        float r117 = r110.getX();
        float r118 = r110.getY();
        if (Math.abs(r117 - this.f102451g) <= this.f102450f) goto L20;
    L21:
        this.f102449e = 2;
        this.f102451g = r117;
        this.f102452h = r118;
        return true;
    L20:
        if (Math.abs(r118 - this.f102452h) <= this.f102450f) goto L65;
    L23:
        int r119 = this.f102449e;
        if (r119 != 2) goto L42;
        this.f102449e = 0;
        if (r110.getAction() == 1) goto L28;
    L30:
        boolean r120 = false;
    L31:
        MotionEvent r121 = MotionEvent.obtain(r110);
        r121.setAction(3);
        super.onTouchEvent(r121);
        r121.recycle();
        if (r120 == false) goto L40;
        this.f102453i.computeCurrentVelocity(1000);
        float r122 = this.f102453i.getXVelocity();
        if (Math.abs(r122) > this.f102454j) goto L36;
        r101 = getTargetCheckedState();
    L39:
        a(r101);
    L41:
        return true;
    L36:
        if (r122 <= 0.0f) goto L39;
        r101 = true;
        goto L39
    L40:
        a(isChecked());
        goto L41
    L28:
        if (isEnabled() == false) goto L30;
        r120 = true;
        goto L31
    L42:
        if (r119 == 1) goto L46;
        if (r119 == 3) goto L46;
        this.f102449e = 0;
        this.f102453i.clear();
    L46:
        this.f102449e = 0;
        this.f102453i.clear();
        toggle();
        return true;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        super.setChecked(r100);
        setThumbPosition(isChecked());
        invalidate();
    }

    public void setSwitchPadding(int r100) {
        this.f102448d = r100;
        requestLayout();
    }

    public void setThumbDrawable(Drawable r100) {
        this.f102445a = r100;
        requestLayout();
    }

    public void setThumbResource(int r100) {
        setThumbDrawable(getContext().getResources().getDrawable(r100));
    }

    public void setTrackDrawable(Drawable r100) {
        this.f102446b = r100;
        requestLayout();
    }

    public void setTrackResource(int r100) {
        setTrackDrawable(getContext().getResources().getDrawable(r100));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (r100 == this.f102445a) goto L10;
        if (r100 == this.f102446b) goto L10;
        return false;
    }

    public SwitchBase(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f102446b.getIntrinsicWidth();
        int r103 = Math.max(this.f102447c, r102);
        int r104 = this.f102446b.getIntrinsicHeight();
        this.f102458n = this.f102445a.getIntrinsicWidth();
        this.f102456l = r103;
        this.f102457m = r104;
        setMeasuredDimension(r103, r104);
    }

    public SwitchBase(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f102453i = VelocityTracker.obtain();
        this.f102463s = new Rect();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.ms_switchMinWidth, com.larus.nova.R.attr.ms_switchPadding, com.larus.nova.R.attr.ms_thumb, com.larus.nova.R.attr.ms_track}, r102, 0);
        this.f102445a = r103.getDrawable(2);
        this.f102446b = r103.getDrawable(3);
        this.f102447c = r103.getDimensionPixelSize(0, 0);
        this.f102448d = r103.getDimensionPixelSize(1, 0);
        r103.recycle();
        ViewConfiguration r104 = ViewConfiguration.get(r100);
        this.f102450f = r104.getScaledTouchSlop();
        this.f102454j = r104.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        setThumbPosition(isChecked());
        int r105 = getWidth() - getPaddingRight();
        int r106 = r105 - this.f102456l;
        int r107 = getGravity() & 112;
        if (r107 != 16) goto L5;
        int r108 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r109 = this.f102457m;
        int r110 = r108 - (r109 / 2);
    L9:
        int r111 = r109 + r110;
    L10:
        this.f102459o = r106;
        this.f102460p = r110;
        this.f102462r = r111;
        this.f102461q = r105;
        return;
    L5:
        if (r107 == 80) goto L7;
        r110 = getPaddingTop();
        r109 = this.f102457m;
        goto L9
    L7:
        r111 = getHeight() - getPaddingBottom();
        r110 = r111 - this.f102457m;
        goto L10
    }
}
