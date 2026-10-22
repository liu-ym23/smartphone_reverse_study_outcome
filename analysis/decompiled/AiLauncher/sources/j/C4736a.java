package j;

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
import u0.C5566a;
import v0.InterfaceMenuItemC5651b;

/* renamed from: j.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C4736a implements InterfaceMenuItemC5651b {

    /* renamed from: a, reason: collision with root package name */
    public final int f34390a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34391b;

    /* renamed from: c, reason: collision with root package name */
    public final int f34392c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f34393d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f34394e;

    /* renamed from: f, reason: collision with root package name */
    public Intent f34395f;

    /* renamed from: g, reason: collision with root package name */
    public char f34396g;

    /* renamed from: i, reason: collision with root package name */
    public char f34398i;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f34400k;

    /* renamed from: l, reason: collision with root package name */
    public Context f34401l;

    /* renamed from: m, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f34402m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f34403n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f34404o;

    /* renamed from: h, reason: collision with root package name */
    public int f34397h = 4096;

    /* renamed from: j, reason: collision with root package name */
    public int f34399j = 4096;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f34405p = null;

    /* renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f34406q = null;

    /* renamed from: r, reason: collision with root package name */
    public boolean f34407r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f34408s = false;

    /* renamed from: t, reason: collision with root package name */
    public int f34409t = 16;

    public C4736a(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f34401l = context;
        this.f34390a = i11;
        this.f34391b = i10;
        this.f34392c = i13;
        this.f34393d = charSequence;
    }

    @Override // v0.InterfaceMenuItemC5651b
    public AbstractC1314b a() {
        return null;
    }

    @Override // v0.InterfaceMenuItemC5651b
    public InterfaceMenuItemC5651b b(AbstractC1314b abstractC1314b) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f34400k;
        if (drawable != null) {
            if (this.f34407r || this.f34408s) {
                Drawable drawableR = C5566a.r(drawable);
                this.f34400k = drawableR;
                Drawable drawableMutate = drawableR.mutate();
                this.f34400k = drawableMutate;
                if (this.f34407r) {
                    C5566a.o(drawableMutate, this.f34405p);
                }
                if (this.f34408s) {
                    C5566a.p(this.f34400k, this.f34406q);
                }
            }
        }
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
        return this.f34399j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f34398i;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f34403n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f34391b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f34400k;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f34405p;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f34406q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f34395f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f34390a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f34397h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f34396g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f34392c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f34393d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f34394e;
        return charSequence != null ? charSequence : this.f34393d;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f34404o;
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
        return (this.f34409t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f34409t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f34409t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f34409t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f34398i = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f34409t = (z10 ? 1 : 0) | (this.f34409t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f34409t = (z10 ? 2 : 0) | (this.f34409t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f34409t = (z10 ? 16 : 0) | (this.f34409t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f34400k = drawable;
        c();
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f34405p = colorStateList;
        this.f34407r = true;
        c();
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f34406q = mode;
        this.f34408s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f34395f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f34396g = c10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f34402m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f34396g = c10;
        this.f34398i = Character.toLowerCase(c11);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public void setShowAsAction(int i10) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f34393d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f34394e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        this.f34409t = (this.f34409t & 8) | (z10 ? 0 : 8);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f34398i = Character.toLowerCase(c10);
        this.f34399j = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public InterfaceMenuItemC5651b setContentDescription(CharSequence charSequence) {
        this.f34403n = charSequence;
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f34396g = c10;
        this.f34397h = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f34393d = this.f34401l.getResources().getString(i10);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public InterfaceMenuItemC5651b setTooltipText(CharSequence charSequence) {
        this.f34404o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f34400k = androidx.core.content.a.e(this.f34401l, i10);
        c();
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f34396g = c10;
        this.f34397h = KeyEvent.normalizeMetaState(i10);
        this.f34398i = Character.toLowerCase(c11);
        this.f34399j = KeyEvent.normalizeMetaState(i11);
        return this;
    }
}
