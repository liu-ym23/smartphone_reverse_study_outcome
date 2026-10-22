package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContextView extends androidx.appcompat.widget.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f655j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f656k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f657l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f658m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinearLayout f659n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f660o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f661p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f662q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f663r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f664s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f665t;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMode f666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionBarContextView f667b;

        public a(ActionBarContextView r10, ActionMode r11) {
            this.f667b = r10;
            this.f666a = r11;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            this.f666a.a();
        }
    }

    public ActionBarContextView(@NonNull Context r10) {
        this(r10, null);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ androidx.core.view.r f(int r10, long r11) {
        return super.f(r10, r11);
    }

    public void g() {
        if (this.f656k != null) goto L6;
        k();
        return;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new ViewGroup.MarginLayoutParams(getContext(), r10);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f655j;
    }

    public CharSequence getTitle() {
        return this.f654i;
    }

    public void h(ActionMode r10) {
        View r11 = this.f656k;
        if (r11 != null) goto L6;
        View r12 = LayoutInflater.from(getContext()).inflate(this.f665t, this, false);
        this.f656k = r12;
        addView(r12);
    L8:
        View r13 = this.f656k.findViewById(R$id.action_mode_close_button);
        this.f657l = r13;
        r13.setOnClickListener(new a(this, r10));
        MenuBuilder r14 = (MenuBuilder) r10.c();
        ActionMenuPresenter r15 = this.f961d;
        if (r15 == null) goto L11;
        r15.p();
    L11:
        ActionMenuPresenter r16 = new ActionMenuPresenter(getContext());
        this.f961d = r16;
        r16.A(true);
        ViewGroup.LayoutParams r17 = new ViewGroup.LayoutParams(-2, -1);
        r14.addMenuPresenter(this.f961d, this.f959b);
        ActionMenuView r18 = (ActionMenuView) this.f961d.getMenuView(this);
        this.f960c = r18;
        ViewCompat.t0(r18, null);
        addView(this.f960c, r17);
        return;
    L6:
        if (r11.getParent() != null) goto L8;
        addView(this.f656k);
        goto L8
    }

    public final void i() {
        if (this.f659n != null) goto L10;
        LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
        LinearLayout r10 = (LinearLayout) getChildAt(getChildCount() - 1);
        this.f659n = r10;
        this.f660o = (TextView) r10.findViewById(R$id.action_bar_title);
        this.f661p = (TextView) this.f659n.findViewById(R$id.action_bar_subtitle);
        if (this.f662q == 0) goto L8;
        this.f660o.setTextAppearance(getContext(), this.f662q);
    L8:
        if (this.f663r == 0) goto L10;
        this.f661p.setTextAppearance(getContext(), this.f663r);
    L10:
        this.f660o.setText(this.f654i);
        this.f661p.setText(this.f655j);
        boolean r11 = TextUtils.isEmpty(this.f654i);
        boolean r12 = TextUtils.isEmpty(this.f655j);
        TextView r13 = this.f661p;
        int r14 = 8;
        if (r12 == true) goto L13;
        int r15 = 0;
    L14:
        r13.setVisibility(r15);
        LinearLayout r16 = this.f659n;
        if (r11 == false) goto L17;
        if (r12 == false) goto L17;
    L18:
        r16.setVisibility(r14);
        if (this.f659n.getParent() != null) goto L22;
        addView(this.f659n);
        return;
    L22:
        return;
    L17:
        r14 = 0;
        goto L18
    L13:
        r15 = 8;
        goto L14
    }

    public boolean j() {
        return this.f664s;
    }

    public void k() {
        removeAllViews();
        this.f658m = null;
        this.f960c = null;
        this.f961d = null;
        View r10 = this.f657l;
        if (r10 == null) goto L6;
        r10.setOnClickListener(null);
        return;
    }

    public boolean l() {
        ActionMenuPresenter r10 = this.f961d;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.B();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter r10 = this.f961d;
        if (r10 == null) goto L6;
        r10.s();
        this.f961d.t();
        return;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent r10) {
        return super.onHoverEvent(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        boolean r15 = i0.b(this);
        if (r15 == false) goto L5;
        int r16 = (r13 - r11) - getPaddingRight();
    L6:
        int r17 = getPaddingTop();
        int r18 = ((r14 - r12) - getPaddingTop()) - getPaddingBottom();
        View r19 = this.f656k;
        if (r19 != null) goto L9;
    L18:
        int r110 = r16;
        LinearLayout r20 = this.f659n;
        if (r20 != null) goto L21;
    L25:
        int r21 = r110;
        View r22 = this.f658m;
        if (r22 == null) goto L28;
        e(r22, r21, r17, r18, r15);
    L28:
        if (r15 == false) goto L30;
        int r23 = getPaddingLeft();
    L31:
        ActionMenuView r24 = this.f960c;
        if (r24 == null) goto L35;
        e(r24, r23, r17, r18, !r15);
        return;
    L35:
        return;
    L30:
        r23 = (r13 - r11) - getPaddingRight();
        goto L31
    L21:
        if (this.f658m != null) goto L25;
        if (r20.getVisibility() == 8) goto L25;
        r110 = r110 + e(this.f659n, r110, r17, r18, r15);
        goto L25
    L9:
        if (r19.getVisibility() == 8) goto L18;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) this.f656k.getLayoutParams();
        if (r15 == false) goto L13;
        int r25 = r111.rightMargin;
    L14:
        if (r15 == false) goto L16;
        int r112 = r111.leftMargin;
    L17:
        int r26 = androidx.appcompat.widget.a.d(r16, r25, r15);
        r16 = androidx.appcompat.widget.a.d(r26 + e(this.f656k, r26, r17, r18, r15), r112, r15);
        goto L18
    L16:
        r112 = r111.rightMargin;
        goto L17
    L13:
        r25 = r111.leftMargin;
        goto L14
    L5:
        r16 = getPaddingLeft();
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r11, int r12) {
        int r10 = View.MeasureSpec.getMode(r11);
        int r13 = Ints.MAX_POWER_OF_TWO;
        if (r10 != 1073741824) goto L65;
        if (View.MeasureSpec.getMode(r12) == 0) goto L63;
        int r14 = View.MeasureSpec.getSize(r11);
        int r15 = this.f962e;
        if (r15 > 0) goto L10;
        r15 = View.MeasureSpec.getSize(r12);
    L10:
        int r16 = getPaddingTop() + getPaddingBottom();
        int r17 = (r14 - getPaddingLeft()) - getPaddingRight();
        int r18 = r15 - r16;
        int r19 = View.MeasureSpec.makeMeasureSpec(r18, Integer.MIN_VALUE);
        View r20 = this.f656k;
        int r21 = 0;
        if (r20 == null) goto L13;
        int r22 = c(r20, r17, r19, 0);
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) this.f656k.getLayoutParams();
        r17 = r22 - (r23.leftMargin + r23.rightMargin);
    L13:
        ActionMenuView r24 = this.f960c;
        if (r24 != null) goto L16;
    L18:
        LinearLayout r25 = this.f659n;
        if (r25 != null) goto L21;
    L36:
        View r26 = this.f658m;
        if (r26 == null) goto L52;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        int r28 = r27.width;
        if (r28 == (-2)) goto L41;
        int r29 = 1073741824;
    L42:
        if (r28 < 0) goto L44;
        r17 = Math.min(r28, r17);
    L44:
        int r30 = r27.height;
        if (r30 != (-2)) goto L48;
        r13 = Integer.MIN_VALUE;
    L48:
        if (r30 < 0) goto L50;
        r18 = Math.min(r30, r18);
    L50:
        this.f658m.measure(View.MeasureSpec.makeMeasureSpec(r17, r29), View.MeasureSpec.makeMeasureSpec(r18, r13));
        goto L52
    L41:
        r29 = Integer.MIN_VALUE;
    L52:
        if (this.f962e > 0) goto L60;
        int r31 = getChildCount();
        int r32 = 0;
    L54:
        if (r21 >= r31) goto L59;
        int r33 = getChildAt(r21).getMeasuredHeight() + r16;
        if (r33 <= r32) goto L58;
        r32 = r33;
    L58:
        r21 = r21 + 1;
        goto L54
    L59:
        setMeasuredDimension(r14, r32);
        return;
    L60:
        setMeasuredDimension(r14, r15);
        return;
    L21:
        if (this.f658m != null) goto L36;
        if (this.f664s == false) goto L35;
        this.f659n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), r19);
        int r34 = this.f659n.getMeasuredWidth();
        if (r34 > r17) goto L27;
        boolean r35 = true;
    L28:
        if (r35 == false) goto L30;
        r17 = r17 - r34;
    L30:
        LinearLayout r36 = this.f659n;
        if (r35 == false) goto L33;
        int r37 = 0;
    L34:
        r36.setVisibility(r37);
        goto L36
    L33:
        r37 = 8;
        goto L34
    L27:
        r35 = false;
        goto L28
    L35:
        r17 = c(r25, r17, r19, 0);
        goto L36
    L16:
        if (r24.getParent() != this) goto L18;
        r17 = c(this.f960c, r17, r19, 0);
        goto L18
    L63:
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
    L65:
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r10) {
        return super.onTouchEvent(r10);
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int r10) {
        this.f962e = r10;
    }

    public void setCustomView(View r10) {
        View r11 = this.f658m;
        if (r11 == null) goto L5;
        removeView(r11);
    L5:
        this.f658m = r10;
        if (r10 == null) goto L10;
        LinearLayout r12 = this.f659n;
        if (r12 == null) goto L10;
        removeView(r12);
        this.f659n = null;
    L10:
        if (r10 == null) goto L12;
        addView(r10);
    L12:
        requestLayout();
    }

    public void setSubtitle(CharSequence r10) {
        this.f655j = r10;
        i();
    }

    public void setTitle(CharSequence r10) {
        this.f654i = r10;
        i();
        ViewCompat.s0(this, r10);
    }

    public void setTitleOptional(boolean r10) {
        if (r10 == this.f664s) goto L5;
        requestLayout();
    L5:
        this.f664s = r10;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int r10) {
        super.setVisibility(r10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.actionModeStyle);
    }

    public ActionBarContextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        b0 r13 = b0.v(r10, r11, R$styleable.ActionMode, r12, 0);
        ViewCompat.t0(this, r13.g(R$styleable.ActionMode_background));
        this.f662q = r13.n(R$styleable.ActionMode_titleTextStyle, 0);
        this.f663r = r13.n(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f962e = r13.m(R$styleable.ActionMode_height, 0);
        this.f665t = r13.n(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        r13.w();
    }
}
