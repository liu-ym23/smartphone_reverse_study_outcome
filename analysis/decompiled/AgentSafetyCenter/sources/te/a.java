package te;

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
/* loaded from: classes2.dex */
public final class a implements h3.b {

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f13312b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f13313c;

    /* renamed from: d, reason: collision with root package name */
    public Intent f13314d;

    /* renamed from: e, reason: collision with root package name */
    public char f13315e;

    /* renamed from: g, reason: collision with root package name */
    public char f13317g;
    public Drawable i;

    /* renamed from: j, reason: collision with root package name */
    public Context f13319j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f13320k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f13321l;

    /* renamed from: r, reason: collision with root package name */
    public f7.x f13327r;

    /* renamed from: f, reason: collision with root package name */
    public int f13316f = 4096;

    /* renamed from: h, reason: collision with root package name */
    public int f13318h = 4096;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f13322m = null;

    /* renamed from: n, reason: collision with root package name */
    public PorterDuff.Mode f13323n = null;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13324o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13325p = false;

    /* renamed from: q, reason: collision with root package name */
    public int f13326q = 16;

    /* renamed from: a, reason: collision with root package name */
    public int f13311a = -1;

    public a(Context context, f7.x xVar) {
        this.f13319j = context;
        this.f13327r = xVar;
    }

    @Override // h3.b
    public final n3.d a() {
        return null;
    }

    @Override // h3.b
    public final h3.b b(n3.d dVar) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.i;
        if (drawable != null && (this.f13324o || this.f13325p)) {
            this.i = drawable;
            Drawable drawableMutate = drawable.mutate();
            this.i = drawableMutate;
            if (this.f13324o) {
                drawableMutate.setTintList(this.f13322m);
            }
            if (this.f13325p) {
                this.i.setTintMode(this.f13323n);
            }
        }
        f7.x xVar = this.f13327r;
        Drawable drawable2 = this.i;
        if (((Drawable) xVar.f4031c) != drawable2) {
            xVar.f4031c = drawable2;
            m4.b bVar = (m4.b) xVar.f4032d;
            if (bVar != null) {
                bVar.a();
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
        return this.f13318h;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f13317g;
    }

    @Override // h3.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f13320k;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        f7.x xVar = this.f13327r;
        return xVar != null ? (Drawable) xVar.f4031c : this.i;
    }

    @Override // h3.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f13322m;
    }

    @Override // h3.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f13323n;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f13314d;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        f7.x xVar = this.f13327r;
        return xVar != null ? xVar.f4029a : this.f13311a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // h3.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f13316f;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f13315e;
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
        f7.x xVar = this.f13327r;
        return xVar != null ? (String) xVar.f4030b : this.f13312b;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f13313c;
        return charSequence != null ? charSequence : getTitle();
    }

    @Override // h3.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f13321l;
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
        return (this.f13326q & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f13326q & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f13326q & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f13326q & 8) == 0;
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
        this.f13317g = Character.toLowerCase(c9);
        this.f13318h = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z10) {
        this.f13326q = (z10 ? 1 : 0) | (this.f13326q & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z10) {
        this.f13326q = (z10 ? 2 : 0) | (this.f13326q & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f13320k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z10) {
        this.f13326q = (z10 ? 16 : 0) | (this.f13326q & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.i = this.f13319j.getDrawable(i);
        c();
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f13322m = colorStateList;
        this.f13324o = true;
        c();
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f13323n = mode;
        this.f13325p = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f13314d = intent;
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i) {
        this.f13315e = c9;
        this.f13316f = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i, int i3) {
        this.f13315e = c9;
        this.f13316f = KeyEvent.normalizeMetaState(i);
        this.f13317g = Character.toLowerCase(c10);
        this.f13318h = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        f7.x xVar = this.f13327r;
        if (xVar == null) {
            this.f13312b = charSequence;
            return this;
        }
        String string = charSequence.toString();
        if (((String) xVar.f4030b) != string) {
            xVar.f4030b = string;
            m4.b bVar = (m4.b) xVar.f4032d;
            if (bVar != null) {
                bVar.a();
            }
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f13313c = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f13321l = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z10) {
        this.f13326q = (this.f13326q & 8) | (z10 ? 0 : 8);
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final h3.b setContentDescription(CharSequence charSequence) {
        this.f13320k = charSequence;
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final h3.b setTooltipText(CharSequence charSequence) {
        this.f13321l = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        this.f13315e = c9;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.i = drawable;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        this.f13317g = Character.toLowerCase(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f13315e = c9;
        this.f13317g = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        setTitle(this.f13319j.getResources().getString(i));
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
