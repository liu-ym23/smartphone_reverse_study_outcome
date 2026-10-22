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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements h3.b {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f7506a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f7507b;

    /* renamed from: c, reason: collision with root package name */
    public Intent f7508c;

    /* renamed from: d, reason: collision with root package name */
    public char f7509d;

    /* renamed from: e, reason: collision with root package name */
    public int f7510e;

    /* renamed from: f, reason: collision with root package name */
    public char f7511f;

    /* renamed from: g, reason: collision with root package name */
    public int f7512g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f7513h;
    public Context i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f7514j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f7515k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f7516l;

    /* renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f7517m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f7518n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f7519o;

    /* renamed from: p, reason: collision with root package name */
    public int f7520p;

    @Override // h3.b
    public final n3.d a() {
        return null;
    }

    @Override // h3.b
    public final h3.b b(n3.d dVar) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f7513h;
        if (drawable != null) {
            if (this.f7518n || this.f7519o) {
                this.f7513h = drawable;
                Drawable drawableMutate = drawable.mutate();
                this.f7513h = drawableMutate;
                if (this.f7518n) {
                    drawableMutate.setTintList(this.f7516l);
                }
                if (this.f7519o) {
                    this.f7513h.setTintMode(this.f7517m);
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

    @Override // h3.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f7512g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f7511f;
    }

    @Override // h3.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f7514j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f7513h;
    }

    @Override // h3.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f7516l;
    }

    @Override // h3.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f7517m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f7508c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // h3.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f7510e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f7509d;
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
        return this.f7506a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f7507b;
        return charSequence != null ? charSequence : this.f7506a;
    }

    @Override // h3.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f7515k;
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
        return (this.f7520p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f7520p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f7520p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f7520p & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i) {
        this.f7511f = Character.toLowerCase(c9);
        this.f7512g = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z10) {
        this.f7520p = (z10 ? 1 : 0) | (this.f7520p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z10) {
        this.f7520p = (z10 ? 2 : 0) | (this.f7520p & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f7514j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z10) {
        this.f7520p = (z10 ? 16 : 0) | (this.f7520p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f7513h = this.i.getDrawable(i);
        c();
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f7516l = colorStateList;
        this.f7518n = true;
        c();
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f7517m = mode;
        this.f7519o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f7508c = intent;
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i) {
        this.f7509d = c9;
        this.f7510e = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i, int i3) {
        this.f7509d = c9;
        this.f7510e = KeyEvent.normalizeMetaState(i);
        this.f7511f = Character.toLowerCase(c10);
        this.f7512g = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        this.f7506a = this.i.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f7507b = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f7515k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z10) {
        this.f7520p = (this.f7520p & 8) | (z10 ? 0 : 8);
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final h3.b setContentDescription(CharSequence charSequence) {
        this.f7514j = charSequence;
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final h3.b setTooltipText(CharSequence charSequence) {
        this.f7515k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        this.f7509d = c9;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f7513h = drawable;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        this.f7511f = Character.toLowerCase(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f7506a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f7509d = c9;
        this.f7511f = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        return this;
    }
}
