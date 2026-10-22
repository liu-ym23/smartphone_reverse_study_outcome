package ge;

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
import stepos.support.v7.widget.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements p0.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f9147a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f9148b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f9149c;

    /* renamed from: d, reason: collision with root package name */
    public Intent f9150d;

    /* renamed from: e, reason: collision with root package name */
    public char f9151e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public char f9152j;

    /* renamed from: k, reason: collision with root package name */
    public int f9153k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f9154l;

    /* renamed from: m, reason: collision with root package name */
    public final Context f9155m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f9156n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f9157o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f9158p;

    /* renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f9159q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f9160s;

    /* renamed from: t, reason: collision with root package name */
    public int f9161t;

    /* renamed from: u, reason: collision with root package name */
    public final e0.d f9162u;

    public b(Context context, CharSequence charSequence) {
        this.h = 4096;
        this.f9153k = 4096;
        this.f9158p = null;
        this.f9159q = null;
        this.r = false;
        this.f9160s = false;
        this.f9161t = 16;
        this.f9162u = null;
        this.f9155m = context;
        this.f9147a = R.id.home;
        this.f9148b = charSequence;
    }

    @Override // p0.b
    public final p0.b a(v0.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // p0.b
    public final v0.b b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.f9154l;
        if (drawable != null && (this.r || this.f9160s)) {
            this.f9154l = drawable;
            Drawable drawableMutate = drawable.mutate();
            this.f9154l = drawableMutate;
            if (this.r) {
                drawableMutate.setTintList(this.f9158p);
            }
            if (this.f9160s) {
                this.f9154l.setTintMode(this.f9159q);
            }
        }
        Drawable drawable2 = this.f9154l;
        e0.d dVar = this.f9162u;
        if (dVar.f12786c != drawable2) {
            dVar.f12786c = drawable2;
            stepos.support.v7.widget.i iVar = dVar.f12787d;
            if (iVar != null) {
                iVar.a();
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
        return this.f9153k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f9152j;
    }

    @Override // p0.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f9156n;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        e0.d dVar = this.f9162u;
        return dVar != null ? dVar.f12786c : this.f9154l;
    }

    @Override // p0.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f9158p;
    }

    @Override // p0.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f9159q;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f9150d;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        e0.d dVar = this.f9162u;
        return dVar != null ? dVar.f12785b : this.f9147a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // p0.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f9151e;
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
        e0.d dVar = this.f9162u;
        return dVar != null ? dVar.f12784a : this.f9148b;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f9149c;
        return charSequence != null ? charSequence : getTitle();
    }

    @Override // p0.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f9157o;
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
        return (this.f9161t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f9161t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f9161t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f9161t & 8) == 0;
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
        this.f9152j = Character.toLowerCase(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        this.f9161t = (z ? 1 : 0) | (this.f9161t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        this.f9161t = (z ? 2 : 0) | (this.f9161t & (-3));
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f9156n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        this.f9161t = (z ? 16 : 0) | (this.f9161t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f9154l = drawable;
        c();
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f9158p = colorStateList;
        this.r = true;
        c();
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f9159q = mode;
        this.f9160s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f9150d = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        this.f9151e = c9;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f9151e = c9;
        this.f9152j = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        e0.d dVar = this.f9162u;
        if (dVar == null) {
            this.f9148b = charSequence;
            return this;
        }
        String string = charSequence.toString();
        if (dVar.f12784a != string) {
            dVar.f12784a = string;
            stepos.support.v7.widget.i iVar = dVar.f12787d;
            if (iVar != null) {
                iVar.a();
            }
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f9149c = charSequence;
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f9157o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        this.f9161t = (this.f9161t & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i10) {
        this.f9152j = Character.toLowerCase(c9);
        this.f9153k = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final p0.b setContentDescription(CharSequence charSequence) {
        this.f9156n = charSequence;
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i10) {
        this.f9151e = c9;
        this.h = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final p0.b setTooltipText(CharSequence charSequence) {
        this.f9157o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i10) {
        this.f9154l = this.f9155m.getDrawable(i10);
        c();
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i10, int i11) {
        this.f9151e = c9;
        this.h = KeyEvent.normalizeMetaState(i10);
        this.f9152j = Character.toLowerCase(c10);
        this.f9153k = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i10) {
        setTitle(this.f9155m.getResources().getString(i10));
        return this;
    }

    public b(Context context, e0.d dVar) {
        this.h = 4096;
        this.f9153k = 4096;
        this.f9158p = null;
        this.f9159q = null;
        this.r = false;
        this.f9160s = false;
        this.f9161t = 16;
        this.f9155m = context;
        this.f9162u = dVar;
        this.f9147a = -1;
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
