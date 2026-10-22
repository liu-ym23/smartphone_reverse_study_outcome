package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.w;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: NavigationMenuPresenter.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements androidx.appcompat.view.menu.d {
    private int A;
    private int B;
    private int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LinearLayout f13446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    MenuBuilder f13447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    b f13448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    LayoutInflater f13449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f13450e;
    ColorStateList f;
    int g;
    ColorStateList h;
    ColorStateList i;
    Drawable j;
    RippleDrawable k;
    int l;
    int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    int s;
    boolean t;
    boolean u;
    int v;
    final View.OnClickListener w;
    private NavigationMenuView x;
    private androidx.appcompat.view.menu.d.a y;
    private int z;

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class a extends k {
        public a(View r1) {
            super(r1);
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private class b extends RecyclerView.a<k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f13451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<d> f13452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private MenuItemImpl f13453c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f13454d;

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public long b(int r1) {
            return r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
            return c(r1, r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public /* synthetic */ void a(RecyclerView.u r3, int r4) {
            a((k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public /* synthetic */ void d(RecyclerView.u r3) {
            a((k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.aiagent.plugin"));
        }

        b(g r1) {
            this.f13451a = r1;
            this.f13452b = new ArrayList();
            j();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public int a() {
            return this.f13452b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public int a(int r2) {
            d r1 = (d) ZeusTransformUtils.preCheckCast(this.f13452b.get(r2), d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r1, e.class) == false) goto L7;
            return 2;
        L7:
            if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L11;
            return 3;
        L11:
            if (ZeusTransformUtils.instanceOf(r1, f.class) == false) goto L19;
            if (((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin")).a().hasSubMenu() == false) goto L16;
            return 1;
        L16:
            return 0;
        L19:
            throw new RuntimeException("Unknown item type.");
        }

        public k c(ViewGroup r2, int r3) {
            if (r3 == 0) goto L18;
            if (r3 == 1) goto L16;
            if (r3 == 2) goto L14;
            if (r3 == 3) goto L12;
            return null;
        L12:
            return new a(this.f13451a.f13446a);
        L14:
            return new i(this.f13451a.f13449d, r2);
        L16:
            return new j(this.f13451a.f13449d, r2);
        L18:
            return new h(this.f13451a.f13449d, r2, this.f13451a.w);
        }

        public void a(k r5, int r6) {
            int r0 = a(r6);
            if (r0 != 0) goto L5;
            NavigationMenuItemView r7 = (NavigationMenuItemView) ZeusTransformUtils.preCheckCast(r5.f2390a, NavigationMenuItemView.class, "com.obric.aiagent.plugin");
            r7.setIconTintList(this.f13451a.i);
            if (this.f13451a.g == 0) goto L20;
            r7.setTextAppearance(this.f13451a.g);
        L20:
            if (this.f13451a.h == null) goto L23;
            r7.setTextColor(this.f13451a.h);
        L23:
            if (this.f13451a.j == null) goto L25;
            Drawable r1 = this.f13451a.j.getConstantState().newDrawable();
        L26:
            ViewCompat.a(r7, r1);
            if (this.f13451a.k == null) goto L29;
            r7.setForeground(this.f13451a.k.getConstantState().newDrawable());
        L29:
            f r8 = (f) ZeusTransformUtils.preCheckCast(this.f13452b.get(r6), f.class, "com.obric.aiagent.plugin");
            r7.setNeedsEmptyIcon(r8.f13457a);
            r7.setPadding(this.f13451a.l, this.f13451a.m, this.f13451a.l, this.f13451a.m);
            r7.setIconPadding(this.f13451a.n);
            if (this.f13451a.t == false) goto L32;
            r7.setIconSize(this.f13451a.o);
        L32:
            r7.setMaxLines(g.a(this.f13451a));
            r7.initialize(r8.a(), 0);
            return;
        L25:
            r1 = null;
            goto L26
        L5:
            if (r0 != 1) goto L7;
            TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r5.f2390a, TextView.class, "com.obric.aiagent.plugin");
            r9.setText(((f) ZeusTransformUtils.preCheckCast(this.f13452b.get(r6), f.class, "com.obric.aiagent.plugin")).a().getTitle());
            if (this.f13451a.f13450e == 0) goto L13;
            TextViewCompat.a(r9, this.f13451a.f13450e);
        L13:
            r9.setPadding(this.f13451a.r, r9.getPaddingTop(), this.f13451a.s, r9.getPaddingBottom());
            if (this.f13451a.f == null) goto L35;
            r9.setTextColor(this.f13451a.f);
            return;
        L35:
            return;
        L7:
            if (r0 != 2) goto L37;
            e r10 = (e) ZeusTransformUtils.preCheckCast(this.f13452b.get(r6), e.class, "com.obric.aiagent.plugin");
            r5.f2390a.setPadding(this.f13451a.p, r10.a(), this.f13451a.q, r10.b());
            return;
        }

        public void a(k r2) {
            if (ZeusTransformUtils.instanceOf(r2, h.class) == false) goto L6;
            ((NavigationMenuItemView) ZeusTransformUtils.preCheckCast(r2.f2390a, NavigationMenuItemView.class, "com.obric.aiagent.plugin")).recycle();
            return;
        }

        public void update() {
            j();
            d();
        }

        private void j() {
            if (this.f13454d == false) goto L5;
            return;
        L5:
            this.f13454d = true;
            this.f13452b.clear();
            this.f13452b.add(new c());
            int r2 = -1;
            int r3 = this.f13451a.f13447b.getVisibleItems().size();
            boolean r4 = false;
            int r5 = 0;
            boolean r6 = false;
            int r7 = 0;
        L6:
            if (r5 >= r3) goto L51;
            MenuItemImpl r8 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(this.f13451a.f13447b.getVisibleItems().get(r5), MenuItemImpl.class, "com.obric.aiagent.plugin");
            if (r8.isChecked() == false) goto L11;
            a(r8);
        L11:
            if (r8.isCheckable() == false) goto L14;
            r8.setExclusiveCheckable(r4);
        L14:
            if (r8.hasSubMenu() == false) goto L37;
            SubMenu r9 = r8.getSubMenu();
            if (r9.hasVisibleItems() == false) goto L50;
            if (r5 == 0) goto L19;
            this.f13452b.add(new e(this.f13451a.v, r4 ? 1 : 0));
        L19:
            this.f13452b.add(new f(r8));
            int r11 = this.f13452b.size();
            int r12 = r9.size();
            int r13 = r4 ? 1 : 0;
            int r14 = r13;
        L20:
            if (r13 >= r12) goto L35;
            MenuItemImpl r1 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(r9.getItem(r13), MenuItemImpl.class, "com.obric.aiagent.plugin");
            if (r1.isVisible() == false) goto L34;
            if (r14 != 0) goto L28;
            if (r1.getIcon() == null) goto L28;
            r14 = 1;
        L28:
            if (r1.isCheckable() == false) goto L31;
            r1.setExclusiveCheckable(r4);
        L31:
            if (r8.isChecked() == false) goto L33;
            a(r8);
        L33:
            this.f13452b.add(new f(r1));
        L34:
            r13 = r13 + 1;
            r4 = false;
            goto L20
        L35:
            if (r14 == 0) goto L50;
            e(r11, this.f13452b.size());
        L50:
            r5 = r5 + 1;
            r4 = false;
            goto L6
        L37:
            int r10 = r8.getGroupId();
            if (r10 == r2) goto L45;
            r7 = this.f13452b.size();
            if (r8.getIcon() == null) goto L42;
            r6 = true;
        L43:
            if (r5 == 0) goto L49;
            r7 = r7 + 1;
            this.f13452b.add(new e(this.f13451a.v, this.f13451a.v));
        L49:
            f r15 = new f(r8);
            r15.f13457a = r6;
            this.f13452b.add(r15);
            r2 = r10;
            goto L50
        L42:
            r6 = false;
            goto L43
        L45:
            if (r6 == true) goto L49;
            if (r8.getIcon() == null) goto L49;
            e(r7, this.f13452b.size());
            r6 = true;
            goto L49
        L51:
            this.f13454d = r4 ? 1 : 0;
        }

        private void e(int r4, int r5) {
        L2:
            if (r4 >= r5) goto L4;
            ((f) ZeusTransformUtils.preCheckCast(this.f13452b.get(r4), f.class, "com.obric.aiagent.plugin")).f13457a = true;
            r4 = r4 + 1;
            goto L2
        }

        public void a(MenuItemImpl r3) {
            if (this.f13453c != r3) goto L5;
            return;
        L5:
            if (r3.isCheckable() == false) goto L13;
            MenuItemImpl r0 = this.f13453c;
            if (r0 == null) goto L10;
            r0.setChecked(false);
        L10:
            this.f13453c = r3;
            r3.setChecked(true);
            return;
        }

        public MenuItemImpl g() {
            return this.f13453c;
        }

        public Bundle h() {
            Bundle r0 = new Bundle();
            MenuItemImpl r1 = this.f13453c;
            if (r1 == null) goto L5;
            r0.putInt("android:menu:checked", r1.getItemId());
        L5:
            SparseArray<? extends Parcelable> r2 = new SparseArray();
            int r3 = 0;
            int r4 = this.f13452b.size();
        L6:
            if (r3 >= r4) goto L16;
            d r5 = (d) ZeusTransformUtils.preCheckCast(this.f13452b.get(r3), d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r5, f.class) == false) goto L15;
            MenuItemImpl r6 = ((f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin")).a();
            if (r6 == null) goto L12;
            View r7 = r6.getActionView();
        L13:
            if (r7 == null) goto L15;
            ParcelableSparseArray r8 = new ParcelableSparseArray();
            r7.saveHierarchyState(r8);
            r2.put(r6.getItemId(), r8);
            goto L15
        L12:
            r7 = null;
        L15:
            r3 = r3 + 1;
            goto L6
        L16:
            r0.putSparseParcelableArray("android:menu:action_views", r2);
            return r0;
        }

        public void a(Bundle r8) {
            int r1 = 0;
            int r0 = r8.getInt("android:menu:checked", 0);
            if (r0 == 0) goto L15;
            this.f13454d = true;
            int r3 = this.f13452b.size();
            int r4 = 0;
        L5:
            if (r4 >= r3) goto L14;
            d r5 = (d) ZeusTransformUtils.preCheckCast(this.f13452b.get(r4), d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r5, f.class) == false) goto L13;
            MenuItemImpl r6 = ((f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin")).a();
            if (r6 == null) goto L13;
            if (r6.getItemId() != r0) goto L13;
            a(r6);
        L13:
            r4 = r4 + 1;
        L14:
            this.f13454d = false;
            j();
        L15:
            SparseArray r9 = r8.getSparseParcelableArray("android:menu:action_views");
            if (r9 == null) goto L33;
            int r2 = this.f13452b.size();
        L18:
            if (r1 >= r2) goto L45;
            d r7 = (d) ZeusTransformUtils.preCheckCast(this.f13452b.get(r1), d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r7, f.class) == false) goto L32;
            MenuItemImpl r10 = ((f) ZeusTransformUtils.preCheckCast(r7, f.class, "com.obric.aiagent.plugin")).a();
            if (r10 == null) goto L32;
            View r11 = r10.getActionView();
            if (r11 == null) goto L32;
            ParcelableSparseArray r12 = (ParcelableSparseArray) ZeusTransformUtils.preCheckCast(r9.get(r10.getItemId()), ParcelableSparseArray.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L32;
            r11.restoreHierarchyState(r12);
        L32:
            r1 = r1 + 1;
            goto L18
        L45:
            return;
        }

        public void b(boolean r1) {
            this.f13454d = r1;
        }

        int i() {
            int r1 = 0;
            if (this.f13451a.f13446a.getChildCount() != 0) goto L5;
            int r0 = 0;
        L7:
            if (r1 >= this.f13451a.f13448c.a()) goto L12;
            if (this.f13451a.f13448c.a(r1) != 0) goto L11;
            r0 = r0 + 1;
        L11:
            r1 = r1 + 1;
            goto L7
        L12:
            return r0;
        L5:
            r0 = 1;
            goto L7
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class c implements d {
        c() {
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private interface d {
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13456b;

        public e(int r1, int r2) {
            this.f13455a = r1;
            this.f13456b = r2;
        }

        public int a() {
            return this.f13455a;
        }

        public int b() {
            return this.f13456b;
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class f implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f13457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MenuItemImpl f13458b;

        f(MenuItemImpl r1) {
            this.f13458b = r1;
        }

        public MenuItemImpl a() {
            return this.f13458b;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private class C0278g extends w {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f13459b;

        C0278g(g r1, RecyclerView r2) {
            this.f13459b = r1;
            super(r2);
        }

        @Override // androidx.recyclerview.widget.w, androidx.core.view.AccessibilityDelegateCompat
        public void a(View r1, androidx.core.view.accessibility.b r2) {
            super.a(r1, r2);
            r2.b(androidx.core.view.accessibility.b.f.a(this.f13459b.f13448c.i(), 0, false));
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class h extends k {
        public h(LayoutInflater r5, ViewGroup r6, View.OnClickListener r7) {
            View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r7, View.OnClickListener.class, "com.obric.aiagent.plugin");
            super(ZeusTransformUtils.inflate(r5, ZeusTransformUtils.mapRes(R.layout.design_navigation_item, "layout", "design_navigation_item"), r6, false, "com.obric.aiagent.plugin"));
            this.f2390a.setOnClickListener(r8);
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class i extends k {
        public i(LayoutInflater r4, ViewGroup r5) {
            super(ZeusTransformUtils.inflate(r4, ZeusTransformUtils.mapRes(R.layout.design_navigation_item_separator, "layout", "design_navigation_item_separator"), r5, false, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class j extends k {
        public j(LayoutInflater r4, ViewGroup r5) {
            super(ZeusTransformUtils.inflate(r4, ZeusTransformUtils.mapRes(R.layout.design_navigation_item_subheader, "layout", "design_navigation_item_subheader"), r5, false, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static abstract class k extends RecyclerView.u {
        public k(View r1) {
            super(r1);
        }
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean collapseItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean expandItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean onSubMenuSelected(SubMenuBuilder r1) {
        return false;
    }

    public g() {
        this.f13450e = 0;
        this.g = 0;
        this.u = true;
        this.C = -1;
        this.w = new NavigationMenuPresenter$1(this);
    }

    static /* synthetic */ int a(g r0) {
        return r0.A;
    }

    @Override // androidx.appcompat.view.menu.d
    public void initForMenu(Context r3, MenuBuilder r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f13449d = LayoutInflater.from(r5);
        this.f13447b = r4;
        this.v = ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.design_navigation_separator_vertical_padding, "dimen", "design_navigation_separator_vertical_padding"));
    }

    public androidx.appcompat.view.menu.e a(ViewGroup r6) {
        if (this.x != null) goto L12;
        NavigationMenuView r7 = (NavigationMenuView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(this.f13449d, ZeusTransformUtils.mapRes(R.layout.design_navigation_menu, "layout", "design_navigation_menu"), r6, false, "com.obric.aiagent.plugin"), NavigationMenuView.class, "com.obric.aiagent.plugin");
        this.x = r7;
        r7.setAccessibilityDelegateCompat(new C0278g(this, this.x));
        if (this.f13448c != null) goto L7;
        this.f13448c = new b(this);
    L7:
        int r8 = this.C;
        if (r8 == (-1)) goto L10;
        this.x.setOverScrollMode(r8);
    L10:
        this.f13446a = (LinearLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(this.f13449d, ZeusTransformUtils.mapRes(R.layout.design_navigation_item_header, "layout", "design_navigation_item_header"), this.x, false, "com.obric.aiagent.plugin"), LinearLayout.class, "com.obric.aiagent.plugin");
        this.x.setAdapter(this.f13448c);
    L12:
        return this.x;
    }

    @Override // androidx.appcompat.view.menu.d
    public void updateMenuView(boolean r1) {
        b r0 = this.f13448c;
        if (r0 == null) goto L6;
        r0.update();
        return;
    }

    @Override // androidx.appcompat.view.menu.d
    public void setCallback(androidx.appcompat.view.menu.d.a r3) {
        this.y = (androidx.appcompat.view.menu.d.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.appcompat.view.menu.d.a.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.appcompat.view.menu.d
    public void onCloseMenu(MenuBuilder r1, boolean r2) {
        androidx.appcompat.view.menu.d.a r0 = this.y;
        if (r0 == null) goto L6;
        r0.onCloseMenu(r1, r2);
        return;
    }

    @Override // androidx.appcompat.view.menu.d
    public int getId() {
        return this.z;
    }

    public void a(int r1) {
        this.z = r1;
    }

    @Override // androidx.appcompat.view.menu.d
    public Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        if (this.x == null) goto L5;
        SparseArray<? extends Parcelable> r1 = new SparseArray();
        this.x.saveHierarchyState(r1);
        r0.putSparseParcelableArray(ListMenuPresenter.VIEWS_TAG, r1);
    L5:
        b r2 = this.f13448c;
        if (r2 == null) goto L9;
        r0.putBundle("android:menu:adapter", r2.h());
    L9:
        if (this.f13446a == null) goto L11;
        SparseArray<? extends Parcelable> r3 = new SparseArray();
        this.f13446a.saveHierarchyState(r3);
        r0.putSparseParcelableArray("android:menu:header", r3);
    L11:
        return r0;
    }

    @Override // androidx.appcompat.view.menu.d
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Bundle.class) == false) goto L14;
        Bundle r5 = (Bundle) ZeusTransformUtils.preCheckCast(r4, Bundle.class, "com.obric.aiagent.plugin");
        SparseArray r0 = r5.getSparseParcelableArray(ListMenuPresenter.VIEWS_TAG);
        if (r0 == null) goto L7;
        this.x.restoreHierarchyState(r0);
    L7:
        Bundle r1 = r5.getBundle("android:menu:adapter");
        if (r1 == null) goto L10;
        this.f13448c.a(r1);
    L10:
        SparseArray r6 = r5.getSparseParcelableArray("android:menu:header");
        if (r6 == null) goto L15;
        this.f13446a.restoreHierarchyState(r6);
        return;
    L15:
        return;
    }

    public void a(MenuItemImpl r1) {
        this.f13448c.a(r1);
    }

    public MenuItemImpl a() {
        return this.f13448c.g();
    }

    public View b(int r5) {
        View r6 = ZeusTransformUtils.inflate(this.f13449d, r5, this.f13446a, false, "com.obric.aiagent.plugin");
        a(r6);
        return r6;
    }

    public void a(View r2) {
        this.f13446a.addView(r2);
        NavigationMenuView r1 = this.x;
        r1.setPadding(0, 0, 0, r1.getPaddingBottom());
    }

    public void b(View r3) {
        this.f13446a.removeView(r3);
        if (this.f13446a.getChildCount() != 0) goto L6;
        NavigationMenuView r4 = this.x;
        r4.setPadding(0, this.B, 0, r4.getPaddingBottom());
        return;
    }

    public int b() {
        return this.f13446a.getChildCount();
    }

    public View c(int r1) {
        return this.f13446a.getChildAt(r1);
    }

    public void a(ColorStateList r1) {
        this.f = r1;
        updateMenuView(false);
    }

    public void d(int r1) {
        this.f13450e = r1;
        updateMenuView(false);
    }

    public ColorStateList c() {
        return this.i;
    }

    public void b(ColorStateList r1) {
        this.i = r1;
        updateMenuView(false);
    }

    public ColorStateList d() {
        return this.h;
    }

    public void c(ColorStateList r1) {
        this.h = r1;
        updateMenuView(false);
    }

    public void e(int r1) {
        this.g = r1;
        updateMenuView(false);
    }

    public Drawable e() {
        return this.j;
    }

    public void a(Drawable r1) {
        this.j = r1;
        updateMenuView(false);
    }

    public void a(RippleDrawable r1) {
        this.k = r1;
        updateMenuView(false);
    }

    public int f() {
        return this.l;
    }

    public void f(int r1) {
        this.l = r1;
        updateMenuView(false);
    }

    public int g() {
        return this.m;
    }

    public void g(int r1) {
        this.m = r1;
        updateMenuView(false);
    }

    public int h() {
        return this.p;
    }

    public void h(int r1) {
        this.p = r1;
        updateMenuView(false);
    }

    public int i() {
        return this.q;
    }

    public void i(int r1) {
        this.q = r1;
        updateMenuView(false);
    }

    public int j() {
        return this.r;
    }

    public void j(int r1) {
        this.r = r1;
        updateMenuView(false);
    }

    public int k() {
        return this.s;
    }

    public int l() {
        return this.n;
    }

    public void k(int r1) {
        this.n = r1;
        updateMenuView(false);
    }

    public void l(int r1) {
        this.A = r1;
        updateMenuView(false);
    }

    public int m() {
        return this.A;
    }

    public void m(int r2) {
        if (this.o == r2) goto L6;
        this.o = r2;
        this.t = true;
        updateMenuView(false);
        return;
    }

    public void a(boolean r1) {
        b r0 = this.f13448c;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }

    public void b(boolean r2) {
        if (this.u == r2) goto L6;
        this.u = r2;
        n();
        return;
    }

    private void n() {
        if (this.f13446a.getChildCount() == 0) goto L5;
    L7:
        int r0 = 0;
    L8:
        NavigationMenuView r3 = this.x;
        r3.setPadding(0, r0, 0, r3.getPaddingBottom());
        return;
    L5:
        if (this.u == false) goto L7;
        r0 = this.B;
        goto L8
    }

    public void a(al r5) {
        int r0 = r5.b();
        if (this.B == r0) goto L5;
        this.B = r0;
        n();
    L5:
        NavigationMenuView r1 = this.x;
        r1.setPadding(0, r1.getPaddingTop(), 0, r5.d());
        ViewCompat.b(this.f13446a, r5);
    }

    public void n(int r1) {
        this.C = r1;
        NavigationMenuView r0 = this.x;
        if (r0 == null) goto L6;
        r0.setOverScrollMode(r1);
        return;
    }
}
