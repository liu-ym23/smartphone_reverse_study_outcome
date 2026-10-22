package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

/* JADX INFO: loaded from: classes.dex */
public final class g implements SupportMenuItem {
    public View A;
    public ActionProvider B;
    public MenuItem.OnActionExpandListener C;
    public boolean D;
    public ContextMenu.ContextMenuInfo E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char f576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MenuBuilder f580n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m f581o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Runnable f582p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f583q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f584r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f585s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ColorStateList f586t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f587u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f588v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f589w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f590x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f591y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f592z;

    public class a implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f593a;

        public a(g r10) {
            this.f593a = r10;
        }

        @Override // androidx.core.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean r10) {
            g r11 = this.f593a;
            r11.f580n.onItemVisibleChanged(r11);
        }
    }

    public g(MenuBuilder r10, int r11, int r12, int r13, int r14, CharSequence r15, int r16) {
        this.f575i = 4096;
        this.f577k = 4096;
        this.f579m = 0;
        this.f586t = null;
        this.f587u = null;
        this.f588v = false;
        this.f589w = false;
        this.f590x = false;
        this.f591y = 16;
        this.D = false;
        this.f580n = r10;
        this.f567a = r12;
        this.f568b = r11;
        this.f569c = r13;
        this.f570d = r14;
        this.f571e = r15;
        this.f592z = r16;
    }

    public static void b(StringBuilder r10, int r11, int r12, String r13) {
        if ((r11 & r12) != r12) goto L6;
        r10.append(r13);
        return;
    }

    public void a() {
        this.f580n.onItemActionRequestChanged(this);
    }

    public final Drawable c(Drawable r10) {
        if (r10 != null) goto L4;
    L16:
        return r10;
    L4:
        if (this.f590x == false) goto L16;
        if (this.f588v == false) goto L8;
    L9:
        r10 = o.a.l(r10).mutate();
        if (this.f588v == false) goto L13;
        o.a.i(r10, this.f586t);
    L13:
        if (this.f589w == false) goto L15;
        o.a.j(r10, this.f587u);
    L15:
        this.f590x = false;
        goto L16
    L8:
        if (this.f589w == false) goto L16;
        goto L9
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f592z & 8) != 0) goto L6;
        return false;
    L6:
        if (this.A != null) goto L9;
        return true;
    L9:
        MenuItem.OnActionExpandListener r10 = this.C;
        if (r10 == null) goto L16;
        if (r10.onMenuItemActionCollapse(this) == true) goto L16;
        return false;
    L16:
        return this.f580n.collapseItemActionView(this);
    }

    public int d() {
        return this.f570d;
    }

    public char e() {
        if (this.f580n.isQwertyMode() == false) goto L6;
        return this.f576j;
    L6:
        return this.f574h;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (h() == true) goto L5;
        return false;
    L5:
        MenuItem.OnActionExpandListener r10 = this.C;
        if (r10 == null) goto L12;
        if (r10.onMenuItemActionExpand(this) == true) goto L12;
        return false;
    L12:
        return this.f580n.expandItemActionView(this);
    }

    public String f() {
        char r10 = e();
        if (r10 != 0) goto L6;
        return "";
    L6:
        Resources r11 = this.f580n.getContext().getResources();
        StringBuilder r12 = new StringBuilder();
        if (ViewConfiguration.get(this.f580n.getContext()).hasPermanentMenuKey() == false) goto L10;
        r12.append(r11.getString(R$string.abc_prepend_shortcut_label));
    L10:
        if (this.f580n.isQwertyMode() == false) goto L12;
        int r13 = this.f577k;
    L13:
        b(r12, r13, 65536, r11.getString(R$string.abc_menu_meta_shortcut_label));
        b(r12, r13, 4096, r11.getString(R$string.abc_menu_ctrl_shortcut_label));
        b(r12, r13, 2, r11.getString(R$string.abc_menu_alt_shortcut_label));
        b(r12, r13, 1, r11.getString(R$string.abc_menu_shift_shortcut_label));
        b(r12, r13, 4, r11.getString(R$string.abc_menu_sym_shortcut_label));
        b(r12, r13, 8, r11.getString(R$string.abc_menu_function_shortcut_label));
        if (r10 != '\b') goto L16;
        r12.append(r11.getString(R$string.abc_menu_delete_shortcut_label));
    L24:
        return r12.toString();
    L16:
        if (r10 != '\n') goto L18;
        r12.append(r11.getString(R$string.abc_menu_enter_shortcut_label));
        goto L24
    L18:
        if (r10 == ' ') goto L20;
        r12.append(r10);
        goto L24
    L20:
        r12.append(r11.getString(R$string.abc_menu_space_shortcut_label));
        goto L24
    L12:
        r13 = this.f575i;
        goto L13
    }

    public CharSequence g(MenuView.ItemView r10) {
        if (r10 == null) goto L7;
        if (r10.prefersCondensedTitle() == false) goto L7;
        return getTitleCondensed();
    L7:
        return getTitle();
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        View r10 = this.A;
        if (r10 == null) goto L5;
        return r10;
    L5:
        ActionProvider r11 = this.B;
        if (r11 == null) goto L9;
        View r12 = r11.c(this);
        this.A = r12;
        return r12;
    L9:
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f577k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f576j;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f584r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f568b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable r10 = this.f578l;
        if (r10 == null) goto L7;
        return c(r10);
    L7:
        if (this.f579m == 0) goto L10;
        Drawable r11 = c.a.b(this.f580n.getContext(), this.f579m);
        this.f579m = 0;
        this.f578l = r11;
        return c(r11);
    L10:
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f586t;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f587u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f573g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f567a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f575i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f574h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f569c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f581o;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        return this.B;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f571e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence r10 = this.f572f;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.f571e;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f585s;
    }

    public boolean h() {
        if ((this.f592z & 8) != 0) goto L5;
        return false;
    L5:
        if (this.A != null) goto L10;
        ActionProvider r10 = this.B;
        if (r10 == null) goto L10;
        this.A = r10.c(this);
    L10:
        if (this.A == null) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        if (this.f581o == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        MenuItem.OnMenuItemClickListener r10 = this.f583q;
        if (r10 != null) goto L5;
    L7:
        MenuBuilder r11 = this.f580n;
        if (r11.dispatchMenuItemSelected(r11, this) == false) goto L10;
        return true;
    L10:
        Runnable r12 = this.f582p;
        if (r12 == null) goto L15;
        r12.run();
        return true;
    L15:
        if (this.f573g != null) goto L27;
    L20:
        ActionProvider r13 = this.B;
        if (r13 != null) goto L23;
        return false;
    L23:
        if (r13.d() == false) goto L29;
        return true;
    L29:
        return false;
    L27:
        this.f580n.getContext().startActivity(this.f573g);     // Catch: ActivityNotFoundException -> L18
        return true;
    L18:
        e = move-exception;
        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
        goto L20
    L5:
        if (r10.onMenuItemClick(this) == false) goto L7;
        return true;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.f591y & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.f591y & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.f591y & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider r10 = this.B;
        if (r10 == null) goto L13;
        if (r10.f() == false) goto L13;
        if ((this.f591y & 8) == 0) goto L9;
        return false;
    L9:
        if (this.B.b() == true) goto L11;
        return false;
    L11:
        return true;
    L13:
        if ((this.f591y & 8) == 0) goto L15;
        return false;
    L15:
        return true;
    }

    public boolean j() {
        if ((this.f591y & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean k() {
        if ((this.f591y & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l() {
        if ((this.f592z & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public SupportMenuItem m(int r10) {
        Context r11 = this.f580n.getContext();
        n(LayoutInflater.from(r11).inflate(r10, new LinearLayout(r11), false));
        return this;
    }

    public SupportMenuItem n(View r10) {
        this.A = r10;
        this.B = null;
        if (r10 != null) goto L5;
    L9:
        this.f580n.onItemActionRequestChanged(this);
        return this;
    L5:
        if (r10.getId() != (-1)) goto L9;
        int r11 = this.f567a;
        if (r11 <= 0) goto L9;
        r10.setId(r11);
        goto L9
    }

    public void o(boolean r10) {
        this.D = r10;
        this.f580n.onItemsChanged(false);
    }

    public void p(boolean r10) {
        int r11 = this.f591y;
        int r12 = r11 & (-3);
        if (r10 == false) goto L5;
        int r13 = 2;
    L6:
        int r14 = r13 | r12;
        this.f591y = r14;
        if (r11 == r14) goto L10;
        this.f580n.onItemsChanged(false);
        return;
    L10:
        return;
    L5:
        r13 = 0;
        goto L6
    }

    public void q(boolean r10) {
        int r11 = this.f591y & (-5);
        if (r10 == false) goto L5;
        int r12 = 4;
    L6:
        this.f591y = r12 | r11;
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public void r(boolean r10) {
        if (r10 == false) goto L4;
        this.f591y |= 32;
        return;
    L4:
        this.f591y &= -33;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresActionButton() {
        if ((this.f592z & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresOverflow() {
        if (requiresActionButton() == false) goto L5;
    L7:
        return false;
    L5:
        if (l() == true) goto L7;
        return true;
    }

    public void s(ContextMenu.ContextMenuInfo r10) {
        this.E = r10;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider r10) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int r10) {
        return m(r10);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r10) {
        if (this.f576j != r10) goto L5;
        return this;
    L5:
        this.f576j = Character.toLowerCase(r10);
        this.f580n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean r10) {
        int r11 = this.f591y;
        int r12 = r10 ? 1 : 0;
        int r13 = r12 | (r11 & (-2));
        this.f591y = r13;
        if (r11 == r13) goto L5;
        this.f580n.onItemsChanged(false);
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean r10) {
        if ((this.f591y & 4) == 0) goto L5;
        this.f580n.setExclusiveItemChecked(this);
    L6:
        return this;
    L5:
        p(r10);
        goto L6
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence r10) {
        return setContentDescription(r10);
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean r10) {
        if (r10 == false) goto L4;
        this.f591y |= 16;
    L5:
        this.f580n.onItemsChanged(false);
        return this;
    L4:
        this.f591y &= -17;
        goto L5
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable r10) {
        this.f579m = 0;
        this.f578l = r10;
        this.f590x = true;
        this.f580n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList r10) {
        this.f586t = r10;
        this.f588v = true;
        this.f590x = true;
        this.f580n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode r10) {
        this.f587u = r10;
        this.f589w = true;
        this.f590x = true;
        this.f580n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent r10) {
        this.f573g = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r10) {
        if (this.f574h != r10) goto L5;
        return this;
    L5:
        this.f574h = r10;
        this.f580n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r10) {
        this.C = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r10) {
        this.f583q = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r10, char r11) {
        this.f574h = r10;
        this.f576j = Character.toLowerCase(r11);
        this.f580n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int r10) {
        int r11 = r10 & 3;
        if (r11 != 0) goto L5;
    L11:
        this.f592z = r10;
        this.f580n.onItemActionRequestChanged(this);
        return;
    L5:
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L11;
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int r10) {
        return t(r10);
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(ActionProvider r10) {
        ActionProvider r11 = this.B;
        if (r11 == null) goto L5;
        r11.g();
    L5:
        this.A = null;
        this.B = r10;
        this.f580n.onItemsChanged(true);
        ActionProvider r12 = this.B;
        if (r12 == null) goto L8;
        r12.i(new a(this));
    L8:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence r10) {
        this.f571e = r10;
        this.f580n.onItemsChanged(false);
        m r11 = this.f581o;
        if (r11 == null) goto L5;
        r11.setHeaderTitle(r10);
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence r10) {
        this.f572f = r10;
        this.f580n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence r10) {
        return setTooltipText(r10);
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean r10) {
        if (v(r10) == false) goto L5;
        this.f580n.onItemVisibleChanged(this);
    L5:
        return this;
    }

    public SupportMenuItem t(int r10) {
        setShowAsAction(r10);
        return this;
    }

    public String toString() {
        CharSequence r10 = this.f571e;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.toString();
    }

    public void u(m r10) {
        this.f581o = r10;
        r10.setHeaderTitle(getTitle());
    }

    public boolean v(boolean r10) {
        int r11 = this.f591y;
        int r12 = r11 & (-9);
        if (r10 == false) goto L5;
        int r13 = 0;
    L6:
        int r14 = r13 | r12;
        this.f591y = r14;
        if (r11 == r14) goto L10;
        return true;
    L10:
        return false;
    L5:
        r13 = 8;
        goto L6
    }

    public boolean w() {
        return this.f580n.getOptionalIconsVisible();
    }

    public boolean x() {
        if (this.f580n.isShortcutsVisible() == true) goto L5;
    L7:
        return false;
    L5:
        if (e() == 0) goto L7;
        return true;
    }

    public boolean y() {
        if ((this.f592z & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View r10) {
        return n(r10);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence r10) {
        this.f584r = r10;
        this.f580n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence r10) {
        this.f585s = r10;
        this.f580n.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r10, int r11) {
        if (this.f576j == r10) goto L5;
    L7:
        this.f576j = Character.toLowerCase(r10);
        this.f577k = KeyEvent.normalizeMetaState(r11);
        this.f580n.onItemsChanged(false);
        return this;
    L5:
        if (this.f577k != r11) goto L7;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char r10, int r11) {
        if (this.f574h == r10) goto L5;
    L7:
        this.f574h = r10;
        this.f575i = KeyEvent.normalizeMetaState(r11);
        this.f580n.onItemsChanged(false);
        return this;
    L5:
        if (this.f575i != r11) goto L7;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char r10, char r11, int r12, int r13) {
        this.f574h = r10;
        this.f575i = KeyEvent.normalizeMetaState(r12);
        this.f576j = Character.toLowerCase(r11);
        this.f577k = KeyEvent.normalizeMetaState(r13);
        this.f580n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int r10) {
        this.f578l = null;
        this.f579m = r10;
        this.f590x = true;
        this.f580n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int r10) {
        return setTitle(this.f580n.getContext().getString(r10));
    }
}
