package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import com.obric.capabilitykit.common.UiType;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f653j;

    public static class a {
        public static void a(ActionBarContainer r10) {
            r10.invalidateOutline();
        }
    }

    public ActionBarContainer(Context r10) {
        this(r10, null);
    }

    public final int a(View r10) {
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10.getLayoutParams();
        return (r10.getMeasuredHeight() + r11.topMargin) + r11.bottomMargin;
    }

    public final boolean b(View r10) {
        if (r10 != null) goto L4;
    L9:
        return true;
    L4:
        if (r10.getVisibility() == 8) goto L9;
        if (r10.getMeasuredHeight() == 0) goto L9;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r10 = this.f648e;
        if (r10 != null) goto L5;
    L7:
        Drawable r11 = this.f649f;
        if (r11 != null) goto L10;
    L12:
        Drawable r12 = this.f650g;
        if (r12 != null) goto L15;
        return;
    L15:
        if (r12.isStateful() == false) goto L19;
        this.f650g.setState(getDrawableState());
        return;
    L19:
        return;
    L10:
        if (r11.isStateful() == false) goto L12;
        this.f649f.setState(getDrawableState());
        goto L12
    L5:
        if (r10.isStateful() == false) goto L7;
        this.f648e.setState(getDrawableState());
        goto L7
    }

    public View getTabContainer() {
        return this.f645b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r10 = this.f648e;
        if (r10 == null) goto L5;
        r10.jumpToCurrentState();
    L5:
        Drawable r11 = this.f649f;
        if (r11 == null) goto L8;
        r11.jumpToCurrentState();
    L8:
        Drawable r12 = this.f650g;
        if (r12 == null) goto L12;
        r12.jumpToCurrentState();
        return;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f646c = findViewById(R$id.action_bar);
        this.f647d = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r10) {
        super.onHoverEvent(r10);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.f644a == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(r10) == true) goto L8;
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        View r15 = this.f645b;
        boolean r16 = true;
        boolean r17 = false;
        if (r15 != null) goto L5;
    L7:
        boolean r18 = false;
    L8:
        if (r15 == null) goto L13;
        if (r15.getVisibility() == 8) goto L13;
        int r19 = getMeasuredHeight();
        FrameLayout.LayoutParams r20 = (FrameLayout.LayoutParams) r15.getLayoutParams();
        int r21 = r19 - r15.getMeasuredHeight();
        int r22 = r20.bottomMargin;
        r15.layout(r11, r21 - r22, r13, r19 - r22);
    L13:
        if (this.f651h == false) goto L19;
        Drawable r23 = this.f650g;
        if (r23 == null) goto L17;
        r23.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L35:
        if (r16 == false) goto L38;
        invalidate();
        return;
    L38:
        return;
    L17:
        r16 = r17;
        goto L35
    L19:
        if (this.f648e != null) goto L21;
    L30:
        this.f652i = r18;
        if (r18 == false) goto L17;
        Drawable r24 = this.f649f;
        if (r24 == null) goto L17;
        r24.setBounds(r15.getLeft(), r15.getTop(), r15.getRight(), r15.getBottom());
        goto L35
    L21:
        if (this.f646c.getVisibility() != 0) goto L23;
        this.f648e.setBounds(this.f646c.getLeft(), this.f646c.getTop(), this.f646c.getRight(), this.f646c.getBottom());
    L29:
        r17 = true;
        goto L30
    L23:
        View r25 = this.f647d;
        if (r25 != null) goto L26;
    L28:
        this.f648e.setBounds(0, 0, 0, 0);
        goto L29
    L26:
        if (r25.getVisibility() != 0) goto L28;
        this.f648e.setBounds(this.f647d.getLeft(), this.f647d.getTop(), this.f647d.getRight(), this.f647d.getBottom());
        goto L29
    L5:
        if (r15.getVisibility() == 8) goto L7;
        r18 = true;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.f646c == null) goto L5;
    L9:
        super.onMeasure(r10, r11);
        if (this.f646c != null) goto L12;
        return;
    L12:
        int r12 = View.MeasureSpec.getMode(r11);
        View r13 = this.f645b;
        if (r13 != null) goto L15;
        return;
    L15:
        if (r13.getVisibility() != 8) goto L17;
        return;
    L17:
        if (r12 != 1073741824) goto L19;
        return;
    L19:
        if (b(this.f646c) == true) goto L22;
        int r14 = a(this.f646c);
    L25:
        if (r12 != Integer.MIN_VALUE) goto L27;
        int r15 = View.MeasureSpec.getSize(r11);
    L28:
        setMeasuredDimension(getMeasuredWidth(), Math.min(r14 + a(this.f645b), r15));
        return;
    L27:
        r15 = Channel.UNLIMITED;
        goto L28
    L22:
        if (b(this.f647d) == true) goto L24;
        r14 = a(this.f647d);
        goto L25
    L24:
        r14 = 0;
        goto L25
    L5:
        if (View.MeasureSpec.getMode(r11) != Integer.MIN_VALUE) goto L9;
        int r16 = this.f653j;
        if (r16 < 0) goto L9;
        r11 = View.MeasureSpec.makeMeasureSpec(Math.min(r16, View.MeasureSpec.getSize(r11)), Integer.MIN_VALUE);
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        super.onTouchEvent(r10);
        return true;
    }

    public void setPrimaryBackground(Drawable r10) {
        Drawable r11 = this.f648e;
        if (r11 == null) goto L5;
        r11.setCallback(null);
        unscheduleDrawable(this.f648e);
    L5:
        this.f648e = r10;
        if (r10 == null) goto L10;
        r10.setCallback(this);
        View r12 = this.f646c;
        if (r12 == null) goto L10;
        this.f648e.setBounds(r12.getLeft(), this.f646c.getTop(), this.f646c.getRight(), this.f646c.getBottom());
    L10:
        boolean r13 = false;
        if (this.f651h == false) goto L16;
        if (this.f650g != null) goto L20;
    L14:
        r13 = true;
    L20:
        setWillNotDraw(r13);
        invalidate();
        a.a(this);
        return;
    L16:
        if (this.f648e != null) goto L20;
        if (this.f649f != null) goto L20;
        goto L20
    }

    public void setSplitBackground(Drawable r10) {
        Drawable r11 = this.f650g;
        if (r11 == null) goto L5;
        r11.setCallback(null);
        unscheduleDrawable(this.f650g);
    L5:
        this.f650g = r10;
        boolean r12 = false;
        if (r10 == null) goto L13;
        r10.setCallback(this);
        if (this.f651h == false) goto L13;
        Drawable r13 = this.f650g;
        if (r13 == null) goto L13;
        r13.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L13:
        if (this.f651h == false) goto L18;
        if (this.f650g != null) goto L22;
    L16:
        r12 = true;
    L22:
        setWillNotDraw(r12);
        invalidate();
        a.a(this);
        return;
    L18:
        if (this.f648e != null) goto L22;
        if (this.f649f != null) goto L22;
        goto L22
    }

    public void setStackedBackground(Drawable r10) {
        Drawable r11 = this.f649f;
        if (r11 == null) goto L5;
        r11.setCallback(null);
        unscheduleDrawable(this.f649f);
    L5:
        this.f649f = r10;
        if (r10 == null) goto L12;
        r10.setCallback(this);
        if (this.f652i == false) goto L12;
        Drawable r12 = this.f649f;
        if (r12 == null) goto L12;
        r12.setBounds(this.f645b.getLeft(), this.f645b.getTop(), this.f645b.getRight(), this.f645b.getBottom());
    L12:
        boolean r13 = false;
        if (this.f651h == false) goto L18;
        if (this.f650g != null) goto L22;
    L16:
        r13 = true;
    L22:
        setWillNotDraw(r13);
        invalidate();
        a.a(this);
        return;
    L18:
        if (this.f648e != null) goto L22;
        if (this.f649f != null) goto L22;
        goto L22
    }

    public void setTabContainer(ScrollingTabContainerView r10) {
        View r11 = this.f645b;
        if (r11 == null) goto L5;
        removeView(r11);
    L5:
        this.f645b = r10;
        if (r10 == null) goto L9;
        addView(r10);
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        r12.width = -1;
        r12.height = -2;
        r10.setAllowCollapse(false);
        return;
    }

    public void setTransitioning(boolean r10) {
        this.f644a = r10;
        if (r10 == false) goto L5;
        int r11 = 393216;
    L6:
        setDescendantFocusability(r11);
        return;
    L5:
        r11 = UiType.FLAG_TIMER_CARD;
        goto L6
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        if (r10 != 0) goto L5;
        boolean r11 = true;
    L6:
        Drawable r12 = this.f648e;
        if (r12 == null) goto L9;
        r12.setVisible(r11, false);
    L9:
        Drawable r13 = this.f649f;
        if (r13 == null) goto L12;
        r13.setVisible(r11, false);
    L12:
        Drawable r14 = this.f650g;
        if (r14 == null) goto L16;
        r14.setVisible(r11, false);
        return;
    L16:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View r10, ActionMode.Callback r11) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r10) {
        if (r10 != this.f648e) goto L7;
        if (this.f651h == true) goto L7;
    L16:
        return true;
    L7:
        if (r10 != this.f649f) goto L11;
        if (this.f652i == true) goto L16;
    L11:
        if (r10 != this.f650g) goto L15;
        if (this.f651h == true) goto L16;
    L15:
        if (super.verifyDrawable(r10) == true) goto L16;
        return false;
    }

    public ActionBarContainer(Context r10, AttributeSet r11) {
        super(r10, r11);
        ViewCompat.t0(this, new b(this));
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.ActionBar);
        this.f648e = r12.getDrawable(R$styleable.ActionBar_background);
        this.f649f = r12.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f653j = r12.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean r13 = true;
        if (getId() != R$id.split_action_bar) goto L5;
        this.f651h = true;
        this.f650g = r12.getDrawable(R$styleable.ActionBar_backgroundSplit);
    L5:
        r12.recycle();
        if (this.f651h == false) goto L12;
        if (this.f650g == null) goto L15;
    L10:
        r13 = false;
    L15:
        setWillNotDraw(r13);
        return;
    L12:
        if (this.f648e != null) goto L10;
        if (this.f649f != null) goto L10;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View r10, ActionMode.Callback r11, int r12) {
        if (r12 != 0) goto L4;
        return null;
    L4:
        return super.startActionModeForChild(r10, r11, r12);
    }
}
