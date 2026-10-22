package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MenuBuilder f722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ActionMenuPresenter f726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MenuPresenter.Callback f727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MenuBuilder.Callback f728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f729h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f730i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f731j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f732k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OnMenuItemClickListener f733l;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f737d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f738e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f739f;

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.f734a = r10.f734a;
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.f734a = false;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r10);
    }

    public static class a implements MenuPresenter.Callback {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r10, boolean r11) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r10) {
            return false;
        }
    }

    public class b implements MenuBuilder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f740a;

        public b(ActionMenuView r10) {
            this.f740a = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder r10, MenuItem r11) {
            OnMenuItemClickListener r12 = this.f740a.f733l;
            if (r12 != null) goto L5;
        L7:
            return false;
        L5:
            if (r12.onMenuItemClick(r11) == false) goto L7;
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder r10) {
            MenuBuilder.Callback r11 = this.f740a.f728g;
            if (r11 == null) goto L6;
            r11.onMenuModeChange(r10);
            return;
        }
    }

    public ActionMenuView(@NonNull Context r10) {
        this(r10, null);
    }

    public static int n(View r10, int r11, int r12, int r13, int r14) {
        LayoutParams r15 = (LayoutParams) r10.getLayoutParams();
        int r16 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r13) - r14, View.MeasureSpec.getMode(r13));
        if ((r10 instanceof ActionMenuItemView) == false) goto L5;
        ActionMenuItemView r17 = (ActionMenuItemView) r10;
    L6:
        boolean r18 = false;
        if (r17 != null) goto L9;
    L11:
        boolean r19 = false;
    L12:
        if (r12 <= 0) goto L23;
        int r20 = 2;
        if (r19 == false) goto L16;
        if (r12 < 2) goto L23;
    L16:
        r10.measure(View.MeasureSpec.makeMeasureSpec(r12 * r11, Integer.MIN_VALUE), r16);
        int r21 = r10.getMeasuredWidth();
        int r22 = r21 / r11;
        if ((r21 % r11) == 0) goto L19;
        r22 = r22 + 1;
    L19:
        if (r19 == false) goto L22;
        if (r22 >= 2) goto L22;
    L25:
        if (r15.f734a == true) goto L28;
        if (r19 == false) goto L28;
        r18 = true;
    L28:
        r15.f737d = r18;
        r15.f735b = r20;
        r10.measure(View.MeasureSpec.makeMeasureSpec(r11 * r20, Ints.MAX_POWER_OF_TWO), r16);
        return r20;
    L22:
        r20 = r22;
    L23:
        r20 = 0;
        goto L25
    L9:
        if (r17.b() == false) goto L11;
        r19 = true;
        goto L12
    L5:
        r17 = null;
        goto L6
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    public void d() {
        ActionMenuPresenter r10 = this.f726e;
        if (r10 == null) goto L6;
        r10.p();
        return;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
        return false;
    }

    public LayoutParams e() {
        LayoutParams r10 = new LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) r10).gravity = 16;
        return r10;
    }

    public LayoutParams f(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    public LayoutParams g(ViewGroup.LayoutParams r10) {
        if (r10 == null) goto L12;
        if ((r10 instanceof LayoutParams) == false) goto L6;
        LayoutParams r11 = new LayoutParams((LayoutParams) r10);
    L8:
        if (((LinearLayout.LayoutParams) r11).gravity > 0) goto L10;
        ((LinearLayout.LayoutParams) r11).gravity = 16;
    L10:
        return r11;
    L6:
        r11 = new LayoutParams(r10);
        goto L8
    L12:
        return e();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return e();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return f(r10);
    }

    public Menu getMenu() {
        if (this.f722a != null) goto L10;
        Context r10 = getContext();
        MenuBuilder r11 = new MenuBuilder(r10);
        this.f722a = r11;
        r11.setCallback(new b(this));
        ActionMenuPresenter r12 = new ActionMenuPresenter(r10);
        this.f726e = r12;
        r12.A(true);
        ActionMenuPresenter r13 = this.f726e;
        MenuPresenter.Callback r14 = this.f727f;
        if (r14 != null) goto L8;
        r14 = new a();
    L8:
        r13.setCallback(r14);
        this.f722a.addMenuPresenter(this.f726e, this.f723b);
        this.f726e.y(this);
    L10:
        return this.f722a;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.f726e.r();
    }

    public int getPopupTheme() {
        return this.f724c;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        return 0;
    }

    public LayoutParams h() {
        LayoutParams r10 = e();
        r10.f734a = true;
        return r10;
    }

    public boolean i(int r10) {
        boolean r11 = false;
        if (r10 != 0) goto L5;
        return false;
    L5:
        KeyEvent.Callback r12 = getChildAt(r10 - 1);
        KeyEvent.Callback r13 = getChildAt(r10);
        if (r10 < getChildCount()) goto L8;
    L10:
        if (r10 > 0) goto L12;
        return r11;
    L12:
        if ((r13 instanceof ActionMenuChildView) == true) goto L14;
        return r11;
    L14:
        return r11 | ((ActionMenuChildView) r13).needsDividerBefore();
    L8:
        if ((r12 instanceof ActionMenuChildView) == false) goto L10;
        r11 = ((ActionMenuChildView) r12).needsDividerAfter();
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder r10) {
        this.f722a = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(androidx.appcompat.view.menu.g r10) {
        return this.f722a.performItemAction(r10, 0);
    }

    public boolean j() {
        ActionMenuPresenter r10 = this.f726e;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.s() == false) goto L7;
        return true;
    }

    public boolean k() {
        ActionMenuPresenter r10 = this.f726e;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.u() == false) goto L7;
        return true;
    }

    public boolean l() {
        ActionMenuPresenter r10 = this.f726e;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.v() == false) goto L7;
        return true;
    }

    public boolean m() {
        return this.f725d;
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v14 */
    public final void o(int r30, int r31) {
        int r10 = View.MeasureSpec.getMode(r31);
        int r11 = View.MeasureSpec.getSize(r30);
        int r12 = View.MeasureSpec.getSize(r31);
        int r13 = getPaddingLeft() + getPaddingRight();
        int r14 = getPaddingTop() + getPaddingBottom();
        int r15 = ViewGroup.getChildMeasureSpec(r31, r14, -2);
        int r16 = r11 - r13;
        int r17 = this.f731j;
        int r18 = r16 / r17;
        int r19 = r16 % r17;
        if (r18 != 0) goto L6;
        setMeasuredDimension(r16, 0);
        return;
    L6:
        int r20 = r17 + (r19 / r18);
        int r21 = getChildCount();
        int r110 = 0;
        int r111 = 0;
        boolean r112 = false;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        long r116 = 0;
    L7:
        if (r111 >= r21) goto L37;
        View r117 = getChildAt(r111);
        int r118 = r12;
        if (r117.getVisibility() == 8) goto L36;
        boolean r22 = r117 instanceof ActionMenuItemView;
        int r119 = r113 + 1;
        if (r22 == false) goto L14;
        int r23 = this.f732k;
        ?? r120 = 0;
        r117.setPadding(r23, 0, r23, 0);
    L15:
        LayoutParams r24 = (LayoutParams) r117.getLayoutParams();
        r24.f739f = r120;
        r24.f736c = r120;
        r24.f735b = r120;
        r24.f737d = r120;
        ((LinearLayout.LayoutParams) r24).leftMargin = r120;
        ((LinearLayout.LayoutParams) r24).rightMargin = r120;
        if (r22 == true) goto L18;
    L20:
        boolean r25 = false;
    L21:
        r24.f738e = r25;
        if (r24.f734a == false) goto L24;
        int r26 = 1;
    L25:
        int r27 = n(r117, r20, r26, r15, r14);
        r114 = Math.max(r114, r27);
        if (r24.f737d == false) goto L29;
        r115 = r115 + 1;
    L29:
        if (r24.f734a == false) goto L31;
        r112 = true;
    L31:
        r18 = r18 - r27;
        r110 = Math.max(r110, r117.getMeasuredHeight());
        if (r27 != 1) goto L34;
        r116 = r116 | ((long) (1 << r111));
        r110 = r110;
    L34:
        r113 = r119;
        goto L36
    L24:
        r26 = r18;
        goto L25
    L18:
        if (((ActionMenuItemView) r117).b() == false) goto L20;
        r25 = true;
        goto L21
    L14:
        r120 = 0;
    L36:
        r111 = r111 + 1;
        r12 = r118;
        goto L7
    L37:
        int r121 = r12;
        if (r112 == false) goto L41;
        if (r113 != 2) goto L41;
        boolean r28 = true;
    L42:
        boolean r29 = false;
    L43:
        if (r115 <= 0) goto L78;
        if (r18 <= 0) goto L78;
        int r122 = Integer.MAX_VALUE;
        int r32 = 0;
        int r123 = 0;
        long r210 = 0;
    L46:
        if (r123 >= r21) goto L57;
        boolean r211 = r29;
        LayoutParams r33 = (LayoutParams) getChildAt(r123).getLayoutParams();
        int r212 = r110;
        if (r33.f737d == false) goto L56;
        int r34 = r33.f735b;
        if (r34 >= r122) goto L54;
        r210 = 1 << r123;
        r122 = r34;
        r32 = 1;
        goto L56
    L54:
        if (r34 != r122) goto L56;
        r32 = r32 + 1;
        r210 = r210 | (1 << r123);
    L56:
        r123 = r123 + 1;
        r110 = r212;
        r29 = r211;
        goto L46
    L57:
        boolean r213 = r29;
        int r214 = r110;
        r116 = r116 | r210;
        if (r32 > r18) goto L80;
        int r124 = r122 + 1;
        int r35 = 0;
    L61:
        if (r35 >= r21) goto L77;
        View r36 = getChildAt(r35);
        LayoutParams r125 = (LayoutParams) r36.getLayoutParams();
        int r215 = r16;
        int r126 = r10;
        long r37 = 1 << r35;
        if ((r210 & r37) == 0) goto L65;
        if (r28 == false) goto L75;
        if (r125.f738e == false) goto L75;
        if (r18 != 1) goto L75;
        int r38 = this.f732k;
        r36.setPadding(r38 + r20, 0, r38, 0);
    L75:
        r125.f735b++;
        r125.f739f = true;
        r18 = r18 - 1;
    L76:
        r35 = r35 + 1;
        r10 = r126;
        r16 = r215;
        r28 = r28;
        goto L61
    L65:
        if (r125.f735b != r124) goto L67;
        r116 = r116 | r37;
    L67:
        r28 = r28;
        goto L76
    L77:
        r110 = r214;
        r29 = true;
    L80:
        if (r112 == true) goto L83;
        if (r113 != 1) goto L83;
        boolean r39 = true;
    L84:
        if (r18 > 0) goto L86;
    L92:
        int r127 = 0;
        boolean r40 = r213;
    L136:
        if (r40 == false) goto L144;
        int r41 = r127;
    L138:
        if (r41 >= r21) goto L144;
        View r42 = getChildAt(r41);
        LayoutParams r43 = (LayoutParams) r42.getLayoutParams();
        if (r43.f739f == false) goto L143;
        r42.measure(View.MeasureSpec.makeMeasureSpec((r43.f735b * r20) + r43.f736c, Ints.MAX_POWER_OF_TWO), r15);
    L143:
        r41 = r41 + 1;
    L144:
        if (r10 == 1073741824) goto L147;
        int r44 = r214;
    L148:
        setMeasuredDimension(r16, r44);
        return;
    L147:
        r44 = r121;
        goto L148
    L86:
        if (r116 == 0) goto L92;
        if (r18 < (r113 - 1)) goto L93;
        if (r39 == true) goto L93;
        if (r114 <= 1) goto L92;
    L93:
        float r45 = Long.bitCount(r116);
        if (r39 == true) goto L105;
        r127 = 0;
        if ((r116 & 1) != 0) goto L98;
    L100:
        int r46 = r21 - 1;
        if ((r116 & ((long) (1 << r46))) == 0) goto L107;
        if (((LayoutParams) getChildAt(r46).getLayoutParams()).f738e == true) goto L107;
        r45 = r45 - 0.5f;
    L107:
        if (r45 <= 0.0f) goto L109;
        int r47 = (int) ((r18 * r20) / r45);
    L110:
        int r48 = r127;
        r40 = r213;
    L111:
        if (r48 >= r21) goto L136;
        if ((r116 & ((long) (1 << r48))) == 0) goto L133;
        View r49 = getChildAt(r48);
        LayoutParams r50 = (LayoutParams) r49.getLayoutParams();
        if ((r49 instanceof ActionMenuItemView) == false) goto L125;
        r50.f736c = r47;
        r50.f739f = true;
        if (r48 != 0) goto L123;
        if (r50.f738e == true) goto L123;
        ((LinearLayout.LayoutParams) r50).leftMargin = (-r47) / 2;
    L123:
        r40 = true;
        goto L133
    L125:
        if (r50.f734a == false) goto L128;
        r50.f736c = r47;
        r50.f739f = true;
        ((LinearLayout.LayoutParams) r50).rightMargin = (-r47) / 2;
        r40 = true;
        goto L133
    L128:
        if (r48 == 0) goto L131;
        ((LinearLayout.LayoutParams) r50).leftMargin = r47 / 2;
    L131:
        if (r48 == (r21 - 1)) goto L133;
        ((LinearLayout.LayoutParams) r50).rightMargin = r47 / 2;
    L133:
        r48 = r48 + 1;
        goto L111
    L109:
        r47 = r127;
        goto L110
    L98:
        if (((LayoutParams) getChildAt(0).getLayoutParams()).f738e == true) goto L100;
        r45 = r45 - 0.5f;
        goto L100
    L105:
        r127 = 0;
    L83:
        r39 = false;
    L78:
        r213 = r29;
        r214 = r110;
    L41:
        r28 = false;
        goto L42
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        ActionMenuPresenter r11 = this.f726e;
        if (r11 == null) goto L8;
        r11.updateMenuView(false);
        if (this.f726e.v() == false) goto L9;
        this.f726e.s();
        this.f726e.B();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        if (this.f729h == true) goto L6;
        super.onLayout(r18, r19, r20, r21, r22);
        return;
    L6:
        int r10 = getChildCount();
        int r11 = (r22 - r20) / 2;
        int r12 = getDividerWidth();
        int r13 = r21 - r19;
        int r14 = (r13 - getPaddingRight()) - getPaddingLeft();
        boolean r15 = i0.b(this);
        int r16 = 0;
        int r17 = 0;
        int r110 = 0;
    L8:
        if (r16 >= r10) goto L24;
        View r111 = getChildAt(r16);
        if (r111.getVisibility() == 8) goto L23;
        LayoutParams r112 = (LayoutParams) r111.getLayoutParams();
        if (r112.f734a == false) goto L22;
        int r23 = r111.getMeasuredWidth();
        if (i(r16) == false) goto L17;
        r23 = r23 + r12;
    L17:
        int r113 = r111.getMeasuredHeight();
        if (r15 == false) goto L20;
        int r114 = getPaddingLeft() + ((LinearLayout.LayoutParams) r112).leftMargin;
        int r115 = r114 + r23;
    L21:
        int r24 = r11 - (r113 / 2);
        r111.layout(r114, r24, r115, r113 + r24);
        r14 = r14 - r23;
        r17 = 1;
        goto L23
    L20:
        r115 = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) r112).rightMargin;
        r114 = r115 - r23;
        goto L21
    L22:
        r14 = r14 - ((r111.getMeasuredWidth() + ((LinearLayout.LayoutParams) r112).leftMargin) + ((LinearLayout.LayoutParams) r112).rightMargin);
        i(r16);
        r110 = r110 + 1;
    L23:
        r16 = r16 + 1;
        goto L8
    L24:
        if (r10 != 1) goto L28;
        if (r17 != 0) goto L28;
        View r25 = getChildAt(0);
        int r26 = r25.getMeasuredWidth();
        int r27 = r25.getMeasuredHeight();
        int r28 = (r13 / 2) - (r26 / 2);
        int r29 = r11 - (r27 / 2);
        r25.layout(r28, r29, r26 + r28, r27 + r29);
        return;
    L28:
        int r116 = r110 - (r17 ^ 1);
        if (r116 <= 0) goto L32;
        int r30 = r14 / r116;
    L33:
        int r31 = Math.max(0, r30);
        if (r15 == false) goto L44;
        int r32 = getWidth() - getPaddingRight();
        int r33 = 0;
    L36:
        if (r33 >= r10) goto L53;
        View r34 = getChildAt(r33);
        LayoutParams r35 = (LayoutParams) r34.getLayoutParams();
        if (r34.getVisibility() == 8) goto L43;
        if (r35.f734a == true) goto L43;
        int r36 = r32 - ((LinearLayout.LayoutParams) r35).rightMargin;
        int r37 = r34.getMeasuredWidth();
        int r38 = r34.getMeasuredHeight();
        int r117 = r11 - (r38 / 2);
        r34.layout(r36 - r37, r117, r36, r38 + r117);
        r32 = r36 - ((r37 + ((LinearLayout.LayoutParams) r35).leftMargin) + r31);
    L43:
        r33 = r33 + 1;
        goto L36
    L53:
        return;
    L44:
        int r39 = getPaddingLeft();
        int r40 = 0;
    L45:
        if (r40 >= r10) goto L66;
        View r41 = getChildAt(r40);
        LayoutParams r42 = (LayoutParams) r41.getLayoutParams();
        if (r41.getVisibility() == 8) goto L52;
        if (r42.f734a == true) goto L52;
        int r43 = r39 + ((LinearLayout.LayoutParams) r42).leftMargin;
        int r44 = r41.getMeasuredWidth();
        int r45 = r41.getMeasuredHeight();
        int r118 = r11 - (r45 / 2);
        r41.layout(r43, r118, r43 + r44, r45 + r118);
        r39 = r43 + ((r44 + ((LinearLayout.LayoutParams) r42).rightMargin) + r31);
    L52:
        r40 = r40 + 1;
        goto L45
    L66:
        return;
    L32:
        r30 = 0;
        goto L33
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int r10, int r11) {
        boolean r12 = this.f729h;
        if (View.MeasureSpec.getMode(r10) != 1073741824) goto L5;
        boolean r13 = true;
    L6:
        this.f729h = r13;
        if (r12 == r13) goto L9;
        this.f730i = 0;
    L9:
        int r14 = View.MeasureSpec.getSize(r10);
        if (this.f729h == false) goto L16;
        MenuBuilder r15 = this.f722a;
        if (r15 == null) goto L16;
        if (r14 == this.f730i) goto L16;
        this.f730i = r14;
        r15.onItemsChanged(true);
    L16:
        int r16 = getChildCount();
        if (this.f729h == false) goto L20;
        if (r16 <= 0) goto L20;
        o(r10, r11);
        return;
    L20:
        int r17 = 0;
    L21:
        if (r17 >= r16) goto L23;
        LayoutParams r18 = (LayoutParams) getChildAt(r17).getLayoutParams();
        ((LinearLayout.LayoutParams) r18).rightMargin = 0;
        ((LinearLayout.LayoutParams) r18).leftMargin = 0;
        r17 = r17 + 1;
        goto L21
    L23:
        super.onMeasure(r10, r11);
        return;
    L5:
        r13 = false;
        goto L6
    }

    public MenuBuilder p() {
        return this.f722a;
    }

    public void q(MenuPresenter.Callback r10, MenuBuilder.Callback r11) {
        this.f727f = r10;
        this.f728g = r11;
    }

    public boolean r() {
        ActionMenuPresenter r10 = this.f726e;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.B() == false) goto L7;
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean r10) {
        this.f726e.x(r10);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r10) {
        this.f733l = r10;
    }

    public void setOverflowIcon(@Nullable Drawable r10) {
        getMenu();
        this.f726e.z(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean r10) {
        this.f725d = r10;
    }

    public void setPopupTheme(@StyleRes int r10) {
        if (this.f724c == r10) goto L9;
        this.f724c = r10;
        if (r10 != 0) goto L7;
        this.f723b = getContext();
        return;
    L7:
        this.f723b = new ContextThemeWrapper(getContext(), r10);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPresenter(ActionMenuPresenter r10) {
        this.f726e = r10;
        r10.y(this);
    }

    public ActionMenuView(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        setBaselineAligned(false);
        float r12 = r10.getResources().getDisplayMetrics().density;
        this.f731j = (int) (56.0f * r12);
        this.f732k = (int) (r12 * 4.0f);
        this.f723b = r10;
        this.f724c = 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        return e();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return g(r10);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet r10) {
        return f(r10);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return g(r10);
    }
}
