package Jc;

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
import androidx.core.view.AbstractC1314b;
import stepos.support.v7.app.a;
import u0.C5566a;
import v0.InterfaceMenuItemC5651b;

/* loaded from: classes5.dex */
public class b implements InterfaceMenuItemC5651b {

    /* renamed from: a, reason: collision with root package name */
    public final int f3809a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3810b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3811c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3812d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f3813e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f3814f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f3815g;

    /* renamed from: h, reason: collision with root package name */
    public char f3816h;

    /* renamed from: i, reason: collision with root package name */
    public int f3817i;

    /* renamed from: j, reason: collision with root package name */
    public char f3818j;

    /* renamed from: k, reason: collision with root package name */
    public int f3819k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f3820l;

    /* renamed from: m, reason: collision with root package name */
    public int f3821m;

    /* renamed from: n, reason: collision with root package name */
    public Context f3822n;

    /* renamed from: o, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f3823o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f3824p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f3825q;

    /* renamed from: r, reason: collision with root package name */
    public ColorStateList f3826r;

    /* renamed from: s, reason: collision with root package name */
    public PorterDuff.Mode f3827s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3828t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3829u;

    /* renamed from: v, reason: collision with root package name */
    public int f3830v;

    /* renamed from: w, reason: collision with root package name */
    public a.InterfaceC0522a f3831w;

    public b(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f3817i = 4096;
        this.f3819k = 4096;
        this.f3821m = 0;
        this.f3826r = null;
        this.f3827s = null;
        this.f3828t = false;
        this.f3829u = false;
        this.f3830v = 16;
        this.f3831w = null;
        this.f3822n = context;
        this.f3809a = i11;
        this.f3810b = i10;
        this.f3811c = i12;
        this.f3812d = i13;
        this.f3813e = charSequence;
    }

    private void c() {
        Drawable drawable = this.f3820l;
        if (drawable != null && (this.f3828t || this.f3829u)) {
            Drawable drawableR = C5566a.r(drawable);
            this.f3820l = drawableR;
            Drawable drawableMutate = drawableR.mutate();
            this.f3820l = drawableMutate;
            if (this.f3828t) {
                C5566a.o(drawableMutate, this.f3826r);
            }
            if (this.f3829u) {
                C5566a.p(this.f3820l, this.f3827s);
            }
        }
        this.f3831w.setIcon(this.f3820l);
    }

    @Override // v0.InterfaceMenuItemC5651b
    public AbstractC1314b a() {
        return null;
    }

    @Override // v0.InterfaceMenuItemC5651b
    public InterfaceMenuItemC5651b b(AbstractC1314b abstractC1314b) {
        throw new UnsupportedOperationException();
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC5651b setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC5651b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC5651b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f3819k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f3818j;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f3824p;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f3810b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        a.InterfaceC0522a interfaceC0522a = this.f3831w;
        return interfaceC0522a != null ? interfaceC0522a.getIcon() : this.f3820l;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f3826r;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f3827s;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f3815g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        a.InterfaceC0522a interfaceC0522a = this.f3831w;
        return interfaceC0522a != null ? interfaceC0522a.getId() : this.f3809a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f3817i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f3816h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f3812d;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        a.InterfaceC0522a interfaceC0522a = this.f3831w;
        return interfaceC0522a != null ? interfaceC0522a.getTitle() : this.f3813e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f3814f;
        return charSequence != null ? charSequence : getTitle();
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f3825q;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f3830v & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f3830v & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f3830v & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f3830v & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f3818j = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f3830v = (z10 ? 1 : 0) | (this.f3830v & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f3830v = (z10 ? 2 : 0) | (this.f3830v & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f3830v = (z10 ? 16 : 0) | (this.f3830v & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f3820l = drawable;
        this.f3821m = 0;
        c();
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3826r = colorStateList;
        this.f3828t = true;
        c();
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3827s = mode;
        this.f3829u = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f3815g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f3816h = c10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f3823o = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f3816h = c10;
        this.f3818j = Character.toLowerCase(c11);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public void setShowAsAction(int i10) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        a.InterfaceC0522a interfaceC0522a = this.f3831w;
        if (interfaceC0522a != null) {
            interfaceC0522a.a(charSequence.toString());
            return this;
        }
        this.f3813e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3814f = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        this.f3830v = (this.f3830v & 8) | (z10 ? 0 : 8);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f3818j = Character.toLowerCase(c10);
        this.f3819k = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public InterfaceMenuItemC5651b setContentDescription(CharSequence charSequence) {
        this.f3824p = charSequence;
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f3816h = c10;
        this.f3817i = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public InterfaceMenuItemC5651b setTooltipText(CharSequence charSequence) {
        this.f3825q = charSequence;
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f3816h = c10;
        this.f3817i = KeyEvent.normalizeMetaState(i10);
        this.f3818j = Character.toLowerCase(c11);
        this.f3819k = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f3821m = i10;
        this.f3820l = androidx.core.content.a.e(this.f3822n, i10);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        setTitle(this.f3822n.getResources().getString(i10));
        return this;
    }

    public b(Context context, a.InterfaceC0522a interfaceC0522a) {
        this.f3817i = 4096;
        this.f3819k = 4096;
        this.f3821m = 0;
        this.f3826r = null;
        this.f3827s = null;
        this.f3828t = false;
        this.f3829u = false;
        this.f3830v = 16;
        this.f3822n = context;
        this.f3831w = interfaceC0522a;
        this.f3809a = -1;
        this.f3810b = 0;
        this.f3811c = 0;
        this.f3812d = 0;
    }
}
