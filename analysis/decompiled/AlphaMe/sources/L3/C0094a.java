package L3;

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
import stepos.support.v7.widget.B;

/* renamed from: L3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0094a implements F.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f1245a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f1246b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f1247c;

    /* renamed from: d, reason: collision with root package name */
    public Intent f1248d;

    /* renamed from: e, reason: collision with root package name */
    public char f1249e;

    /* renamed from: f, reason: collision with root package name */
    public int f1250f;

    /* renamed from: g, reason: collision with root package name */
    public char f1251g;

    /* renamed from: h, reason: collision with root package name */
    public int f1252h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f1253i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f1254j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f1255k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f1256l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f1257m;

    /* renamed from: n, reason: collision with root package name */
    public PorterDuff.Mode f1258n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1259o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1260p;

    /* renamed from: q, reason: collision with root package name */
    public int f1261q;

    /* renamed from: r, reason: collision with root package name */
    public final y.g f1262r;

    public C0094a(Context context, CharSequence charSequence) {
        this.f1250f = 4096;
        this.f1252h = 4096;
        this.f1257m = null;
        this.f1258n = null;
        this.f1259o = false;
        this.f1260p = false;
        this.f1261q = 16;
        this.f1262r = null;
        this.f1254j = context;
        this.f1245a = R.id.home;
        this.f1246b = charSequence;
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
        Drawable drawable = this.f1253i;
        if (drawable != null && (this.f1259o || this.f1260p)) {
            this.f1253i = drawable;
            Drawable drawableMutate = drawable.mutate();
            this.f1253i = drawableMutate;
            if (this.f1259o) {
                E.a.h(drawableMutate, this.f1257m);
            }
            if (this.f1260p) {
                E.a.i(this.f1253i, this.f1258n);
            }
        }
        Drawable drawable2 = this.f1253i;
        y.g gVar = this.f1262r;
        if (((Drawable) gVar.f16028d) != drawable2) {
            gVar.f16028d = drawable2;
            B b4 = (B) gVar.f16029e;
            if (b4 != null) {
                b4.a();
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
        return this.f1252h;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f1251g;
    }

    @Override // F.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f1255k;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        y.g gVar = this.f1262r;
        return gVar != null ? (Drawable) gVar.f16028d : this.f1253i;
    }

    @Override // F.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f1257m;
    }

    @Override // F.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f1258n;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f1248d;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        y.g gVar = this.f1262r;
        return gVar != null ? gVar.f16025a : this.f1245a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // F.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f1250f;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f1249e;
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
        y.g gVar = this.f1262r;
        return gVar != null ? (String) gVar.f16027c : this.f1246b;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1247c;
        return charSequence != null ? charSequence : getTitle();
    }

    @Override // F.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f1256l;
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
        return (this.f1261q & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f1261q & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f1261q & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f1261q & 8) == 0;
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
        this.f1251g = Character.toLowerCase(c4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        this.f1261q = (z4 ? 1 : 0) | (this.f1261q & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        this.f1261q = (z4 ? 2 : 0) | (this.f1261q & (-3));
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final F.b setContentDescription(CharSequence charSequence) {
        this.f1255k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        this.f1261q = (z4 ? 16 : 0) | (this.f1261q & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f1253i = drawable;
        c();
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1257m = colorStateList;
        this.f1259o = true;
        c();
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1258n = mode;
        this.f1260p = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f1248d = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4) {
        this.f1249e = c4;
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
        this.f1249e = c4;
        this.f1251g = Character.toLowerCase(c5);
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
        y.g gVar = this.f1262r;
        if (gVar != null) {
            gVar.b(charSequence.toString());
            return this;
        }
        this.f1246b = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1247c = charSequence;
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final F.b setTooltipText(CharSequence charSequence) {
        this.f1256l = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        this.f1261q = (this.f1261q & 8) | (z4 ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4, int i4) {
        this.f1251g = Character.toLowerCase(c4);
        this.f1252h = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f1255k = charSequence;
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4, int i4) {
        this.f1249e = c4;
        this.f1250f = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f1256l = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i4) {
        this.f1253i = androidx.core.content.a.b(this.f1254j, i4);
        c();
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5, int i4, int i5) {
        this.f1249e = c4;
        this.f1250f = KeyEvent.normalizeMetaState(i4);
        this.f1251g = Character.toLowerCase(c5);
        this.f1252h = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i4) {
        setTitle(this.f1254j.getResources().getString(i4));
        return this;
    }

    public C0094a(Context context, y.g gVar) {
        this.f1250f = 4096;
        this.f1252h = 4096;
        this.f1257m = null;
        this.f1258n = null;
        this.f1259o = false;
        this.f1260p = false;
        this.f1261q = 16;
        this.f1254j = context;
        this.f1262r = gVar;
        this.f1245a = -1;
    }
}
