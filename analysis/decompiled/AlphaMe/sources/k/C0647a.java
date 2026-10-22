package k;

import K.AbstractC0072d;
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

/* renamed from: k.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0647a implements F.b {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f13163a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f13164b;

    /* renamed from: c, reason: collision with root package name */
    public Intent f13165c;

    /* renamed from: d, reason: collision with root package name */
    public char f13166d;

    /* renamed from: f, reason: collision with root package name */
    public char f13168f;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f13170h;

    /* renamed from: i, reason: collision with root package name */
    public final Context f13171i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f13172j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f13173k;

    /* renamed from: e, reason: collision with root package name */
    public int f13167e = 4096;

    /* renamed from: g, reason: collision with root package name */
    public int f13169g = 4096;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f13174l = null;

    /* renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f13175m = null;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13176n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13177o = false;

    /* renamed from: p, reason: collision with root package name */
    public int f13178p = 16;

    public C0647a(Context context, CharSequence charSequence) {
        this.f13171i = context;
        this.f13163a = charSequence;
    }

    @Override // F.b
    public final AbstractC0072d a() {
        return null;
    }

    @Override // F.b
    public final F.b b(AbstractC0072d abstractC0072d) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f13170h;
        if (drawable != null) {
            if (this.f13176n || this.f13177o) {
                this.f13170h = drawable;
                Drawable drawableMutate = drawable.mutate();
                this.f13170h = drawableMutate;
                if (this.f13176n) {
                    E.a.h(drawableMutate, this.f13174l);
                }
                if (this.f13177o) {
                    E.a.i(this.f13170h, this.f13175m);
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

    @Override // F.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f13169g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f13168f;
    }

    @Override // F.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f13172j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f13170h;
    }

    @Override // F.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f13174l;
    }

    @Override // F.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f13175m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f13165c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // F.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f13167e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f13166d;
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
        return this.f13163a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f13164b;
        return charSequence != null ? charSequence : this.f13163a;
    }

    @Override // F.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f13173k;
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
        return (this.f13178p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f13178p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f13178p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f13178p & 8) == 0;
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
    public final MenuItem setAlphabeticShortcut(char c4) {
        this.f13168f = Character.toLowerCase(c4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        this.f13178p = (z4 ? 1 : 0) | (this.f13178p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        this.f13178p = (z4 ? 2 : 0) | (this.f13178p & (-3));
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final F.b setContentDescription(CharSequence charSequence) {
        this.f13172j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        this.f13178p = (z4 ? 16 : 0) | (this.f13178p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f13170h = drawable;
        c();
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f13174l = colorStateList;
        this.f13176n = true;
        c();
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f13175m = mode;
        this.f13177o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f13165c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4) {
        this.f13166d = c4;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5) {
        this.f13166d = c4;
        this.f13168f = Character.toLowerCase(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i4) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i4) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f13163a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f13164b = charSequence;
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final F.b setTooltipText(CharSequence charSequence) {
        this.f13173k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        this.f13178p = (this.f13178p & 8) | (z4 ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4, int i4) {
        this.f13168f = Character.toLowerCase(c4);
        this.f13169g = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f13172j = charSequence;
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4, int i4) {
        this.f13166d = c4;
        this.f13167e = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i4) {
        this.f13163a = this.f13171i.getResources().getString(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f13173k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i4) {
        this.f13170h = androidx.core.content.a.b(this.f13171i, i4);
        c();
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5, int i4, int i5) {
        this.f13166d = c4;
        this.f13167e = KeyEvent.normalizeMetaState(i4);
        this.f13168f = Character.toLowerCase(c5);
        this.f13169g = KeyEvent.normalizeMetaState(i5);
        return this;
    }
}
