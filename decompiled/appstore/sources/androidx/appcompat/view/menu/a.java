package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenuItem;

/* JADX INFO: loaded from: classes.dex */
public class a implements SupportMenuItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Intent f517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char f518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public char f520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f522k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f523l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f524m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f525n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f526o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ColorStateList f527p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f528q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f529r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f530s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f531t;

    public a(Context r10, int r11, int r12, int r13, int r14, CharSequence r15) {
        this.f519h = 4096;
        this.f521j = 4096;
        this.f527p = null;
        this.f528q = null;
        this.f529r = false;
        this.f530s = false;
        this.f531t = 16;
        this.f523l = r10;
        this.f512a = r12;
        this.f513b = r11;
        this.f514c = r14;
        this.f515d = r15;
    }

    public final void a() {
        Drawable r10 = this.f522k;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f529r == false) goto L7;
    L8:
        Drawable r11 = o.a.l(r10);
        this.f522k = r11;
        Drawable r12 = r11.mutate();
        this.f522k = r12;
        if (this.f529r == false) goto L12;
        o.a.i(r12, this.f527p);
    L12:
        if (this.f530s == false) goto L17;
        o.a.j(this.f522k, this.f528q);
        return;
    L17:
        return;
    L7:
        if (this.f530s == true) goto L8;
    }

    public SupportMenuItem b(int r10) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem c(View r10) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    public SupportMenuItem d(int r10) {
        setShowAsAction(r10);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f521j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f520i;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f525n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f513b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f522k;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f527p;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f528q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f517f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f512a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f519h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f518g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f514c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public androidx.core.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f515d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence r10 = this.f516e;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.f515d;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f526o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.f531t & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.f531t & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.f531t & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        if ((this.f531t & 8) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresActionButton() {
        return true;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresOverflow() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider r10) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int r10) {
        return b(r10);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r10) {
        this.f520i = Character.toLowerCase(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean r10) {
        int r11 = this.f531t & (-2);
        this.f531t = (r10 ? 1 : 0) | r11;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean r10) {
        int r11 = this.f531t & (-3);
        if (r10 == false) goto L5;
        int r12 = 2;
    L6:
        this.f531t = r12 | r11;
        return this;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence r10) {
        return setContentDescription(r10);
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean r10) {
        int r11 = this.f531t & (-17);
        if (r10 == false) goto L5;
        int r12 = 16;
    L6:
        this.f531t = r12 | r11;
        return this;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable r10) {
        this.f522k = r10;
        a();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList r10) {
        this.f527p = r10;
        this.f529r = true;
        a();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode r10) {
        this.f528q = r10;
        this.f530s = true;
        a();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent r10) {
        this.f517f = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r10) {
        this.f518g = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r10) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r10) {
        this.f524m = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r10, char r11) {
        this.f518g = r10;
        this.f520i = Character.toLowerCase(r11);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int r10) {
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int r10) {
        return d(r10);
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(androidx.core.view.ActionProvider r10) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence r10) {
        this.f515d = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence r10) {
        this.f516e = r10;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence r10) {
        return setTooltipText(r10);
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean r10) {
        int r11 = 8;
        int r12 = this.f531t & 8;
        if (r10 == false) goto L5;
        r11 = 0;
    L5:
        this.f531t = r12 | r11;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View r10) {
        return c(r10);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r10, int r11) {
        this.f520i = Character.toLowerCase(r10);
        this.f521j = KeyEvent.normalizeMetaState(r11);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence r10) {
        this.f525n = r10;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char r10, int r11) {
        this.f518g = r10;
        this.f519h = KeyEvent.normalizeMetaState(r11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int r10) {
        this.f515d = this.f523l.getResources().getString(r10);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence r10) {
        this.f526o = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int r10) {
        this.f522k = ContextCompat.d(this.f523l, r10);
        a();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char r10, char r11, int r12, int r13) {
        this.f518g = r10;
        this.f519h = KeyEvent.normalizeMetaState(r12);
        this.f520i = Character.toLowerCase(r11);
        this.f521j = KeyEvent.normalizeMetaState(r13);
        return this;
    }
}
