package l;

import android.R;
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

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements p0.b {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f10152a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f10153b;

    /* renamed from: c, reason: collision with root package name */
    public Intent f10154c;

    /* renamed from: d, reason: collision with root package name */
    public char f10155d;

    /* renamed from: e, reason: collision with root package name */
    public int f10156e;
    public char h;

    /* renamed from: j, reason: collision with root package name */
    public int f10157j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f10158k;

    /* renamed from: l, reason: collision with root package name */
    public Context f10159l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f10160m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f10161n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f10162o;

    /* renamed from: p, reason: collision with root package name */
    public PorterDuff.Mode f10163p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10164q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public int f10165s;

    @Override // p0.b
    public final p0.b a(v0.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // p0.b
    public final v0.b b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.f10158k;
        if (drawable != null) {
            if (this.f10164q || this.r) {
                this.f10158k = drawable;
                Drawable drawableMutate = drawable.mutate();
                this.f10158k = drawableMutate;
                if (this.f10164q) {
                    drawableMutate.setTintList(this.f10162o);
                }
                if (this.r) {
                    this.f10158k.setTintMode(this.f10163p);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // p0.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f10157j;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.h;
    }

    @Override // p0.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f10160m;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f10158k;
    }

    @Override // p0.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f10162o;
    }

    @Override // p0.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f10163p;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f10154c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // p0.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f10156e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f10155d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f10152a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f10153b;
        return charSequence != null ? charSequence : this.f10152a;
    }

    @Override // p0.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f10161n;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f10165s & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f10165s & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f10165s & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f10165s & 8) == 0;
    }

    public final boolean requiresActionButton() {
        return true;
    }

    public final boolean requiresOverflow() {
        return false;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        this.h = Character.toLowerCase(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        this.f10165s = (z ? 1 : 0) | (this.f10165s & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        this.f10165s = (z ? 2 : 0) | (this.f10165s & (-3));
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f10160m = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        this.f10165s = (z ? 16 : 0) | (this.f10165s & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f10158k = drawable;
        c();
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f10162o = colorStateList;
        this.f10164q = true;
        c();
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f10163p = mode;
        this.r = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f10154c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        this.f10155d = c9;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f10155d = c9;
        this.h = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f10152a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f10153b = charSequence;
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f10161n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        this.f10165s = (this.f10165s & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i10) {
        this.h = Character.toLowerCase(c9);
        this.f10157j = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final p0.b setContentDescription(CharSequence charSequence) {
        this.f10160m = charSequence;
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i10) {
        this.f10155d = c9;
        this.f10156e = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i10) {
        this.f10152a = this.f10159l.getResources().getString(i10);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final p0.b setTooltipText(CharSequence charSequence) {
        this.f10161n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i10) {
        this.f10158k = this.f10159l.getDrawable(i10);
        c();
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i10, int i11) {
        this.f10155d = c9;
        this.f10156e = KeyEvent.normalizeMetaState(i10);
        this.h = Character.toLowerCase(c10);
        this.f10157j = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i10) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i10) {
        return this;
    }
}
