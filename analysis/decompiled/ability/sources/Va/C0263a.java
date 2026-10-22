package Va;

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
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;

/* renamed from: Va.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0263a implements SupportMenuItem {

    /* renamed from: a, reason: collision with root package name */
    public final int f1431a;
    public CharSequence b;
    public CharSequence c;
    public Intent d;
    public char e;
    public int f;
    public char g;
    public int h;
    public Drawable i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f1432j;
    public CharSequence k;
    public CharSequence l;
    public ColorStateList m;
    public PorterDuff.Mode n;
    public boolean o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public int f1433q;

    /* renamed from: r, reason: collision with root package name */
    public final U.f f1434r;

    public C0263a(Context context, CharSequence charSequence) {
        this.f = 4096;
        this.h = 4096;
        this.m = null;
        this.n = null;
        this.o = false;
        this.p = false;
        this.f1433q = 16;
        this.f1434r = null;
        this.f1432j = context;
        this.f1431a = R.id.home;
        this.b = charSequence;
    }

    public final void a() {
        Drawable drawable = this.i;
        if (drawable != null && (this.o || this.p)) {
            Drawable drawableWrap = DrawableCompat.wrap(drawable);
            this.i = drawableWrap;
            Drawable drawableMutate = drawableWrap.mutate();
            this.i = drawableMutate;
            if (this.o) {
                DrawableCompat.setTintList(drawableMutate, this.m);
            }
            if (this.p) {
                DrawableCompat.setTintMode(this.i, this.n);
            }
        }
        Drawable drawable2 = this.i;
        U.f fVar = this.f1434r;
        if (((Drawable) fVar.c) != drawable2) {
            fVar.c = drawable2;
            stepos.support.v7.widget.G g = (stepos.support.v7.widget.G) fVar.d;
            if (g != null) {
                g.a();
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.g;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        U.f fVar = this.f1434r;
        return fVar != null ? (Drawable) fVar.c : this.i;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.m;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.n;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        U.f fVar = this.f1434r;
        return fVar != null ? fVar.b : this.f1431a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final androidx.core.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        U.f fVar = this.f1434r;
        return fVar != null ? fVar.f1245a : this.b;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.c;
        return charSequence != null ? charSequence : getTitle();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.l;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f1433q & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f1433q & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f1433q & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f1433q & 8) == 0;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final boolean requiresActionButton() {
        return true;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final boolean requiresOverflow() {
        return false;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        this.g = Character.toLowerCase(c);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z10) {
        this.f1433q = (z10 ? 1 : 0) | (this.f1433q & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z10) {
        this.f1433q = (z10 ? 2 : 0) | (this.f1433q & (-3));
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z10) {
        this.f1433q = (z10 ? 16 : 0) | (this.f1433q & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.i = drawable;
        a();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.m = colorStateList;
        this.o = true;
        a();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.n = mode;
        this.p = true;
        a();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.d = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        this.e = c;
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
    public final MenuItem setShortcut(char c, char c2) {
        this.e = c;
        this.g = Character.toLowerCase(c2);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final void setShowAsAction(int i) {
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final SupportMenuItem setSupportActionProvider(androidx.core.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        U.f fVar = this.f1434r;
        if (fVar == null) {
            this.b = charSequence;
            return this;
        }
        String string = charSequence.toString();
        if (fVar.f1245a != string) {
            fVar.f1245a = string;
            stepos.support.v7.widget.G g = (stepos.support.v7.widget.G) fVar.d;
            if (g != null) {
                g.a();
            }
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.c = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.l = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z10) {
        this.f1433q = (this.f1433q & 8) | (z10 ? 0 : 8);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int i) {
        this.g = Character.toLowerCase(c);
        this.h = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.k = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int i) {
        this.e = c;
        this.f = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.l = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.i = ContextCompat.getDrawable(this.f1432j, i);
        a();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2, int i, int i6) {
        this.e = c;
        this.f = KeyEvent.normalizeMetaState(i);
        this.g = Character.toLowerCase(c2);
        this.h = KeyEvent.normalizeMetaState(i6);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        setTitle(this.f1432j.getResources().getString(i));
        return this;
    }

    public C0263a(Context context, U.f fVar) {
        this.f = 4096;
        this.h = 4096;
        this.m = null;
        this.n = null;
        this.o = false;
        this.p = false;
        this.f1433q = 16;
        this.f1432j = context;
        this.f1434r = fVar;
        this.f1431a = -1;
    }
}
