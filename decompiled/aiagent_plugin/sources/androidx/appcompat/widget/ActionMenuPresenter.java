package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ActionMenuPresenter extends androidx.appcompat.view.menu.a implements androidx.core.view.a.InterfaceC0035a {
    private static final String TAG = "ActionMenuPresenter";
    OverflowMenuButton g;
    d h;
    a i;
    c j;
    final e k;
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y;
    private b z;

    private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.a {
        final /* synthetic */ ActionMenuPresenter this$0;

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerBefore() {
            return false;
        }

        public OverflowMenuButton(final ActionMenuPresenter r4, Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            this.this$0 = r4;
            super(r6, null, ZeusTransformUtils.mapRes(R.attr.actionOverflowButtonStyle, "attr", "actionOverflowButtonStyle"));
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            aa.a(this, getContentDescription());
            setOnTouchListener(new AnonymousClass1(this, this, r4));
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick() == false) goto L5;
            return true;
        L5:
            playSoundEffect(0);
            this.this$0.c();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int r4, int r5, int r6, int r7) {
            boolean r8 = super.setFrame(r4, r5, r6, r7);
            Drawable r9 = getDrawable();
            Drawable r10 = getBackground();
            if (r9 == null) goto L6;
            if (r10 == null) goto L6;
            int r11 = getWidth();
            int r12 = getHeight();
            int r0 = Math.max(r11, r12) / 2;
            int r1 = getPaddingLeft() - getPaddingRight();
            int r13 = (r11 + r1) / 2;
            int r14 = (r12 + (getPaddingTop() - getPaddingBottom())) / 2;
            androidx.core.graphics.drawable.a.a(r10, r13 - r0, r14 - r0, r13 + r0, r14 + r0);
        L6:
            return r8;
        }
    }

    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int openSubMenuId;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel r1) {
            this.openSubMenuId = r1.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.openSubMenuId);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    private class a extends androidx.appcompat.view.menu.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActionMenuPresenter f341a;

        public a(ActionMenuPresenter r9, Context r10, SubMenuBuilder r11, View r12) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
            this.f341a = r9;
            super(r3, r11, r12, false, ZeusTransformUtils.mapRes(R.attr.actionOverflowMenuStyle, "attr", "actionOverflowMenuStyle"));
            if (((MenuItemImpl) ZeusTransformUtils.preCheckCast(r11.getItem(), MenuItemImpl.class, "com.obric.aiagent.plugin")).isActionButton() == false) goto L5;
        L9:
            a(r9.k);
            return;
        L5:
            if (r9.g != null) goto L7;
            View r13 = (View) ZeusTransformUtils.preCheckCast(ActionMenuPresenter.c(r9), View.class, "com.obric.aiagent.plugin");
        L8:
            a(r13);
            goto L9
        L7:
            r13 = r9.g;
            goto L8
        }

        @Override // androidx.appcompat.view.menu.c
        public void e() {
            this.f341a.i = null;
            this.f341a.l = 0;
            super.e();
        }
    }

    private class b extends ActionMenuItemView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActionMenuPresenter f342a;

        b(ActionMenuPresenter r1) {
            this.f342a = r1;
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.a
        public androidx.appcompat.view.menu.f a() {
            if (this.f342a.i != null) goto L7;
            return null;
        L7:
            return this.f342a.i.b();
        }
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActionMenuPresenter f343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f344b;

        public c(ActionMenuPresenter r1, d r2) {
            this.f343a = r1;
            this.f344b = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.e(this.f343a) == null) goto L5;
            ActionMenuPresenter.f(this.f343a).changeMenuMode();
        L5:
            View r0 = (View) ZeusTransformUtils.preCheckCast(ActionMenuPresenter.g(this.f343a), View.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L8;
        L12:
            this.f343a.j = null;
            return;
        L8:
            if (r0.getWindowToken() == null) goto L12;
            if (this.f344b.c() == false) goto L12;
            ActionMenuPresenter r1 = this.f343a;
            r1.h = this.f344b;
            goto L12
        }
    }

    private class d extends androidx.appcompat.view.menu.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActionMenuPresenter f345a;

        public d(ActionMenuPresenter r7, Context r8, MenuBuilder r9, View r10, boolean r11) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            this.f345a = r7;
            super(r1, r9, r10, r11, ZeusTransformUtils.mapRes(R.attr.actionOverflowMenuStyle, "attr", "actionOverflowMenuStyle"));
            a(8388613);
            a(r7.k);
        }

        @Override // androidx.appcompat.view.menu.c
        public void e() {
            if (ActionMenuPresenter.a(this.f345a) == null) goto L5;
            ActionMenuPresenter.b(this.f345a).close();
        L5:
            this.f345a.h = null;
            super.e();
        }
    }

    private class e implements androidx.appcompat.view.menu.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActionMenuPresenter f346a;

        e(ActionMenuPresenter r1) {
            this.f346a = r1;
        }

        @Override // androidx.appcompat.view.menu.d.a
        public boolean onOpenSubMenu(MenuBuilder r5) {
            if (r5 != ActionMenuPresenter.d(this.f346a)) goto L5;
            return false;
        L5:
            ActionMenuPresenter r0 = this.f346a;
            r0.l = ((SubMenuBuilder) ZeusTransformUtils.preCheckCast(r5, SubMenuBuilder.class, "com.obric.aiagent.plugin")).getItem().getItemId();
            androidx.appcompat.view.menu.d.a r4 = this.f346a.a();
            if (r4 != null) goto L8;
            return false;
        L8:
            return r4.onOpenSubMenu(r5);
        }

        @Override // androidx.appcompat.view.menu.d.a
        public void onCloseMenu(MenuBuilder r3, boolean r4) {
            if (ZeusTransformUtils.instanceOf(r3, SubMenuBuilder.class) == false) goto L5;
            r3.getRootMenu().close(false);
        L5:
            androidx.appcompat.view.menu.d.a r2 = this.f346a.a();
            if (r2 == null) goto L9;
            r2.onCloseMenu(r3, r4);
            return;
        }
    }

    static /* synthetic */ MenuBuilder a(ActionMenuPresenter r0) {
        return r0.f327c;
    }

    static /* synthetic */ MenuBuilder b(ActionMenuPresenter r0) {
        return r0.f327c;
    }

    static /* synthetic */ androidx.appcompat.view.menu.e c(ActionMenuPresenter r0) {
        return r0.f;
    }

    static /* synthetic */ MenuBuilder d(ActionMenuPresenter r0) {
        return r0.f327c;
    }

    static /* synthetic */ MenuBuilder e(ActionMenuPresenter r0) {
        return r0.f327c;
    }

    static /* synthetic */ MenuBuilder f(ActionMenuPresenter r0) {
        return r0.f327c;
    }

    static /* synthetic */ androidx.appcompat.view.menu.e g(ActionMenuPresenter r0) {
        return r0.f;
    }

    public ActionMenuPresenter(Context r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.abc_action_menu_layout, "layout", "abc_action_menu_layout"), ZeusTransformUtils.mapRes(R.layout.abc_action_menu_item_layout, "layout", "abc_action_menu_item_layout"));
        this.y = new SparseBooleanArray();
        this.k = new e(this);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.d
    public void initForMenu(Context r5, MenuBuilder r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        super.initForMenu(r7, r6);
        Resources r8 = ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin");
        androidx.appcompat.view.a r9 = androidx.appcompat.view.a.a(r7);
        if (this.p == true) goto L6;
        this.o = r9.b();
    L6:
        if (this.v == true) goto L9;
        this.q = r9.c();
    L9:
        if (this.t == true) goto L11;
        this.s = r9.a();
    L11:
        int r10 = this.q;
        if (this.o == true) goto L14;
        this.g = null;
    L21:
        this.r = r10;
        this.x = (int) (r8.getDisplayMetrics().density * 56.0f);
        return;
    L14:
        if (this.g != null) goto L19;
        OverflowMenuButton r0 = new OverflowMenuButton(this, this.f325a);
        this.g = r0;
        if (this.n == false) goto L18;
        r0.setImageDrawable(this.m);
        this.m = null;
        this.n = false;
    L18:
        int r1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.g.measure(r1, r1);
    L19:
        r10 = r10 - this.g.getMeasuredWidth();
        goto L21
    }

    public void a(Configuration r1) {
        if (this.t == true) goto L6;
        this.s = androidx.appcompat.view.a.a(this.f326b).a();
    L6:
        if (this.f327c == null) goto L9;
        this.f327c.onItemsChanged(true);
        return;
    }

    public void a(boolean r1) {
        this.o = r1;
        this.p = true;
    }

    public void b(boolean r1) {
        this.w = r1;
    }

    public void a(Drawable r2) {
        OverflowMenuButton r0 = this.g;
        if (r0 == null) goto L5;
        r0.setImageDrawable(r2);
        return;
    L5:
        this.n = true;
        this.m = r2;
    }

    public Drawable b() {
        OverflowMenuButton r0 = this.g;
        if (r0 == null) goto L7;
        return r0.getDrawable();
    L7:
        if (this.n == true) goto L9;
        return null;
    L9:
        return this.m;
    }

    @Override // androidx.appcompat.view.menu.a
    public androidx.appcompat.view.menu.e a(ViewGroup r3) {
        androidx.appcompat.view.menu.e r0 = this.f;
        androidx.appcompat.view.menu.e r4 = super.a(r3);
        if (r0 == r4) goto L5;
        ((ActionMenuView) ZeusTransformUtils.preCheckCast(r4, ActionMenuView.class, "com.obric.aiagent.plugin")).setPresenter(this);
    L5:
        return r4;
    }

    @Override // androidx.appcompat.view.menu.a
    public View a(MenuItemImpl r3, View r4, ViewGroup r5) {
        View r0 = r3.getActionView();
        if (r0 != null) goto L5;
    L6:
        r0 = super.a(r3, r4, r5);
    L8:
        if (r3.isActionViewExpanded() == false) goto L10;
        int r2 = 8;
    L11:
        r0.setVisibility(r2);
        ActionMenuView r6 = (ActionMenuView) ZeusTransformUtils.preCheckCast(r5, ActionMenuView.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r7 = r0.getLayoutParams();
        if (r6.checkLayoutParams(r7) == true) goto L14;
        r0.setLayoutParams(r6.generateLayoutParams(r7));
    L14:
        return r0;
    L10:
        r2 = 0;
        goto L11
    L5:
        if (r3.hasCollapsibleActionView() == false) goto L8;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.a
    public void a(MenuItemImpl r3, androidx.appcompat.view.menu.e.a r4) {
        androidx.appcompat.view.menu.e.a r5 = (androidx.appcompat.view.menu.e.a) ZeusTransformUtils.wrapperContextForParams(r4, androidx.appcompat.view.menu.e.a.class, "com.obric.aiagent.plugin");
        r5.initialize(r3, 0);
        ActionMenuView r6 = (ActionMenuView) ZeusTransformUtils.preCheckCast(this.f, ActionMenuView.class, "com.obric.aiagent.plugin");
        ActionMenuItemView r7 = (ActionMenuItemView) ZeusTransformUtils.preCheckCast(r5, ActionMenuItemView.class, "com.obric.aiagent.plugin");
        r7.setItemInvoker(r6);
        if (this.z != null) goto L5;
        this.z = new b(this);
    L5:
        r7.setPopupCallback(this.z);
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean a(int r1, MenuItemImpl r2) {
        return r2.isActionButton();
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.d
    public void updateMenuView(boolean r7) {
        super.updateMenuView(r7);
        ((View) ZeusTransformUtils.preCheckCast(this.f, View.class, "com.obric.aiagent.plugin")).requestLayout();
        boolean r0 = false;
        if (this.f327c == null) goto L11;
        ArrayList<MenuItemImpl> r8 = this.f327c.getActionItems();
        int r2 = r8.size();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        androidx.core.view.a r4 = ((MenuItemImpl) ZeusTransformUtils.preCheckCast(r8.get(r3), MenuItemImpl.class, "com.obric.aiagent.plugin")).getSupportActionProvider();
        if (r4 == null) goto L9;
        r4.setSubUiVisibilityListener(this);
    L9:
        r3 = r3 + 1;
    L11:
        if (this.f327c == null) goto L13;
        ArrayList<MenuItemImpl> r9 = this.f327c.getNonActionItems();
    L15:
        if (this.o == false) goto L22;
        if (r9 == null) goto L22;
        int r5 = r9.size();
        if (r5 != 1) goto L20;
        r0 = !((MenuItemImpl) ZeusTransformUtils.preCheckCast(r9.get(0), MenuItemImpl.class, "com.obric.aiagent.plugin")).isActionViewExpanded();
        goto L22
    L20:
        if (r5 <= 0) goto L22;
        r0 = true;
    L22:
        if (r0 == true) goto L24;
        OverflowMenuButton r10 = this.g;
        if (r10 != null) goto L34;
    L36:
        ((ActionMenuView) ZeusTransformUtils.preCheckCast(this.f, ActionMenuView.class, "com.obric.aiagent.plugin")).setOverflowReserved(this.o);
        return;
    L34:
        if (r10.getParent() != this.f) goto L36;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(this.f, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(this.g);
        goto L36
    L24:
        if (this.g != null) goto L26;
        this.g = new OverflowMenuButton(this, this.f325a);
    L26:
        ViewGroup r11 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.g.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r11 == this.f) goto L36;
        if (r11 == null) goto L30;
        r11.removeView(this.g);
    L30:
        ActionMenuView r12 = (ActionMenuView) ZeusTransformUtils.preCheckCast(this.f, ActionMenuView.class, "com.obric.aiagent.plugin");
        r12.addView(this.g, r12.generateOverflowButtonLayoutParams());
        goto L36
    L13:
        r9 = null;
        goto L15
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean a(ViewGroup r3, int r4) {
        if (r3.getChildAt(r4) != this.g) goto L7;
        return false;
    L7:
        return super.a(r3, r4);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.d
    public boolean onSubMenuSelected(SubMenuBuilder r8) {
        boolean r1 = false;
        if (r8.hasVisibleItems() == true) goto L5;
        return false;
    L5:
        SubMenuBuilder r0 = r8;
    L7:
        if (r0.getParentMenu() == this.f327c) goto L9;
        r0 = (SubMenuBuilder) ZeusTransformUtils.preCheckCast(r0.getParentMenu(), SubMenuBuilder.class, "com.obric.aiagent.plugin");
        goto L7
    L9:
        View r2 = a(r0.getItem());
        if (r2 != null) goto L12;
        return false;
    L12:
        this.l = r8.getItem().getItemId();
        int r3 = r8.size();
        int r4 = 0;
    L14:
        if (r4 >= r3) goto L21;
        MenuItem r5 = r8.getItem(r4);
        if (r5.isVisible() == false) goto L20;
        if (r5.getIcon() == null) goto L20;
        r1 = true;
    L20:
        r4 = r4 + 1;
    L21:
        a r6 = new a(this, this.f326b, r8, r2);
        this.i = r6;
        r6.a(r1);
        this.i.a();
        super.onSubMenuSelected(r8);
        return true;
    }

    private View a(MenuItem r7) {
        MenuItem r8 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r7, MenuItem.class, "com.obric.aiagent.plugin");
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.f, ViewGroup.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return null;
    L5:
        int r2 = r6.getChildCount();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L13;
        View r4 = r6.getChildAt(r3);
        if (ZeusTransformUtils.instanceOf(r4, androidx.appcompat.view.menu.e.a.class) == false) goto L12;
        if (((androidx.appcompat.view.menu.e.a) ZeusTransformUtils.preCheckCast(r4, androidx.appcompat.view.menu.e.a.class, "com.obric.aiagent.plugin")).getItemData() != r8) goto L12;
        return r4;
    L12:
        r3 = r3 + 1;
        goto L6
    L13:
        return null;
    }

    public boolean c() {
        if (this.o == true) goto L5;
        return false;
    L5:
        if (g() == false) goto L7;
        return false;
    L7:
        if (this.f327c != null) goto L9;
        return false;
    L9:
        if (this.f != null) goto L11;
        return false;
    L11:
        if (this.j == null) goto L13;
        return false;
    L13:
        if (this.f327c.getNonActionItems().isEmpty() == true) goto L22;
        this.j = new c(this, new d(this, this.f326b, this.f327c, this.g, true));
        ((View) ZeusTransformUtils.preCheckCast(this.f, View.class, "com.obric.aiagent.plugin")).post(this.j);
        return true;
    L22:
        return false;
    }

    public boolean d() {
        if (this.j != null) goto L5;
    L8:
        d r4 = this.h;
        if (r4 == null) goto L12;
        r4.d();
        return true;
    L12:
        return false;
    L5:
        if (this.f == null) goto L8;
        ((View) ZeusTransformUtils.preCheckCast(this.f, View.class, "com.obric.aiagent.plugin")).removeCallbacks(this.j);
        this.j = null;
        return true;
    }

    public boolean e() {
        boolean r0 = d();
        return f() | r0;
    }

    public boolean f() {
        a r0 = this.i;
        if (r0 == null) goto L6;
        r0.d();
        return true;
    L6:
        return false;
    }

    public boolean g() {
        d r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.f() == false) goto L7;
        return true;
    }

    public boolean h() {
        if (this.j == null) goto L5;
    L8:
        return true;
    L5:
        if (g() == true) goto L8;
        return false;
    }

    public boolean i() {
        return this.o;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.d
    public boolean flagActionItems() {
        ActionMenuPresenter r0 = this;
        View r2 = null;
        if (r0.f327c == null) goto L5;
        ArrayList<MenuItemImpl> r1 = r0.f327c.getVisibleItems();
        int r4 = r1.size();
    L6:
        int r5 = r0.s;
        int r6 = r0.r;
        int r7 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup r8 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0.f, ViewGroup.class, "com.obric.aiagent.plugin");
        int r9 = 0;
        boolean r11 = false;
        int r12 = 0;
        int r13 = 0;
    L7:
        if (r9 >= r4) goto L22;
        MenuItemImpl r14 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(r1.get(r9), MenuItemImpl.class, "com.obric.aiagent.plugin");
        if (r14.requiresActionButton() == false) goto L12;
        r12 = r12 + 1;
    L16:
        if (r0.w == false) goto L20;
        if (r14.isActionViewExpanded() == false) goto L20;
        r5 = 0;
    L20:
        r9 = r9 + 1;
        goto L7
    L12:
        if (r14.requestsActionButton() == false) goto L14;
        r13 = r13 + 1;
        goto L16
    L14:
        r11 = true;
        goto L16
    L22:
        if (r0.o == false) goto L27;
        if (r11 == false) goto L25;
    L26:
        r5 = r5 - 1;
        goto L27
    L25:
        if ((r13 + r12) > r5) goto L26;
    L27:
        int r10 = r5 - r12;
        SparseBooleanArray r15 = r0.y;
        r15.clear();
        if (r0.u == false) goto L30;
        int r16 = r0.x;
        int r17 = r6 / r16;
        int r18 = r16 + ((r6 % r16) / r17);
    L31:
        int r19 = 0;
        int r110 = 0;
    L32:
        if (r19 >= r4) goto L98;
        MenuItemImpl r3 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(r1.get(r19), MenuItemImpl.class, "com.obric.aiagent.plugin");
        if (r3.requiresActionButton() == false) goto L48;
        View r111 = r0.a(r3, r2, r8);
        if (r0.u == false) goto L38;
        r17 = r17 - ActionMenuView.measureChildForCells(r111, r18, r17, r7, 0);
    L39:
        int r20 = r111.getMeasuredWidth();
        r6 = r6 - r20;
        if (r110 != 0) goto L42;
        r110 = r20;
    L42:
        int r21 = r3.getGroupId();
        if (r21 == 0) goto L45;
        r15.put(r21, true);
    L45:
        r3.setIsActionButton(true);
        int r112 = r4;
    L46:
        boolean r22 = false;
    L97:
        r19 = r19 + 1;
        r4 = r112;
        r2 = null;
        r0 = this;
        goto L32
    L38:
        r111.measure(r7, r7);
        goto L39
    L48:
        if (r3.requestsActionButton() == false) goto L96;
        int r23 = r3.getGroupId();
        boolean r113 = r15.get(r23);
        if (r10 > 0) goto L52;
        if (r113 == true) goto L52;
    L57:
        r112 = r4;
    L58:
        boolean r24 = false;
    L59:
        boolean r114 = r24;
        int r115 = r10;
        if (r24 == false) goto L79;
        View r25 = r0.a(r3, null, r8);
        if (r0.u == false) goto L66;
        int r116 = ActionMenuView.measureChildForCells(r25, r18, r17, r7, 0);
        r17 = r17 - r116;
        if (r116 != 0) goto L67;
        r114 = false;
    L67:
        boolean r26 = r114;
        int r27 = r25.getMeasuredWidth();
        r6 = r6 - r27;
        if (r110 != 0) goto L71;
        r110 = r27;
    L71:
        if (r0.u == false) goto L75;
        if (r6 >= 0) goto L76;
    L77:
        boolean r28 = false;
    L78:
        r24 = r26 & r28;
    L76:
        r28 = true;
        goto L78
    L75:
        if ((r6 + r110) <= 0) goto L77;
    L66:
        r25.measure(r7, r7);
    L79:
        if (r24 == false) goto L82;
        if (r23 == 0) goto L82;
        r15.put(r23, true);
    L92:
        r10 = r115;
        if (r24 == false) goto L95;
        r10 = r10 - 1;
    L95:
        r3.setIsActionButton(r24);
    L82:
        if (r113 == false) goto L92;
        r15.put(r23, false);
        int r29 = 0;
    L84:
        if (r29 >= r19) goto L92;
        MenuItemImpl r30 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(r1.get(r29), MenuItemImpl.class, "com.obric.aiagent.plugin");
        if (r30.getGroupId() != r23) goto L91;
        if (r30.isActionButton() == false) goto L90;
        r115 = r115 + 1;
    L90:
        r30.setIsActionButton(false);
    L91:
        r29 = r29 + 1;
    L52:
        if (r6 <= 0) goto L57;
        r112 = r4;
        if (r0.u == false) goto L56;
        if (r17 <= 0) goto L58;
    L56:
        r24 = true;
        goto L59
    L96:
        r112 = r4;
        r22 = false;
        r3.setIsActionButton(false);
        goto L97
    L98:
        return true;
    L30:
        r18 = 0;
        r17 = 0;
        goto L31
    L5:
        r1 = null;
        r4 = 0;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.d
    public void onCloseMenu(MenuBuilder r1, boolean r2) {
        e();
        super.onCloseMenu(r1, r2);
    }

    @Override // androidx.appcompat.view.menu.d
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState();
        r0.openSubMenuId = this.l;
        return r0;
    }

    @Override // androidx.appcompat.view.menu.d
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L5;
        return;
    L5:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.aiagent.plugin");
        if (r5.openSubMenuId <= 0) goto L11;
        MenuItem r6 = this.f327c.findItem(r5.openSubMenuId);
        if (r6 == null) goto L12;
        onSubMenuSelected((SubMenuBuilder) ZeusTransformUtils.preCheckCast(r6.getSubMenu(), SubMenuBuilder.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        return;
    }

    @Override // androidx.core.view.a.InterfaceC0035a
    public void c(boolean r1) {
        if (r1 == false) goto L5;
        super.onSubMenuSelected(null);
        return;
    L5:
        if (this.f327c == null) goto L9;
        this.f327c.close(false);
        return;
    }

    public void a(ActionMenuView r1) {
        this.f = r1;
        r1.initialize(this.f327c);
    }
}
