package l;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n implements h3.b {
    public n3.d A;
    public MenuItem.OnActionExpandListener B;
    public boolean C;

    /* renamed from: a, reason: collision with root package name */
    public int f7610a;

    /* renamed from: b, reason: collision with root package name */
    public int f7611b;

    /* renamed from: c, reason: collision with root package name */
    public int f7612c;

    /* renamed from: d, reason: collision with root package name */
    public int f7613d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f7614e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f7615f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f7616g;

    /* renamed from: h, reason: collision with root package name */
    public char f7617h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public char f7618j;

    /* renamed from: k, reason: collision with root package name */
    public int f7619k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f7620l;

    /* renamed from: m, reason: collision with root package name */
    public int f7621m;

    /* renamed from: n, reason: collision with root package name */
    public l f7622n;

    /* renamed from: o, reason: collision with root package name */
    public d0 f7623o;

    /* renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f7624p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f7625q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f7626r;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f7627s;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f7628t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7629u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f7630v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f7631w;

    /* renamed from: x, reason: collision with root package name */
    public int f7632x;

    /* renamed from: y, reason: collision with root package name */
    public int f7633y;

    /* renamed from: z, reason: collision with root package name */
    public View f7634z;

    public static void c(String str, int i, int i3, StringBuilder sb2) {
        if ((i & i3) == i3) {
            sb2.append(str);
        }
    }

    @Override // h3.b
    public final n3.d a() {
        return this.A;
    }

    @Override // h3.b
    public final h3.b b(n3.d dVar) {
        this.f7634z = null;
        this.A = dVar;
        this.f7622n.p(true);
        n3.d dVar2 = this.A;
        if (dVar2 != null) {
            a2.i iVar = new a2.i(16);
            iVar.f49f = this;
            VarHandle.storeStoreFence();
            dVar2.g(iVar);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f7633y & 8) == 0) {
            return false;
        }
        if (this.f7634z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f7622n.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f7631w && (this.f7629u || this.f7630v)) {
            drawable = drawable.mutate();
            if (this.f7629u) {
                drawable.setTintList(this.f7627s);
            }
            if (this.f7630v) {
                drawable.setTintMode(this.f7628t);
            }
            this.f7631w = false;
        }
        return drawable;
    }

    public final boolean e() {
        n3.d dVar;
        if ((this.f7633y & 8) == 0) {
            return false;
        }
        if (this.f7634z == null && (dVar = this.A) != null) {
            this.f7634z = dVar.c(this);
        }
        return this.f7634z != null;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f7622n.f(this);
        }
        return false;
    }

    public final void f(boolean z10) {
        int i = this.f7632x;
        if (z10) {
            this.f7632x = i | 32;
        } else {
            this.f7632x = i & (-33);
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f7634z;
        if (view != null) {
            return view;
        }
        n3.d dVar = this.A;
        if (dVar == null) {
            return null;
        }
        View viewC = dVar.c(this);
        this.f7634z = viewC;
        return viewC;
    }

    @Override // h3.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f7619k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f7618j;
    }

    @Override // h3.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f7625q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f7611b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f7620l;
        if (drawable != null) {
            return d(drawable);
        }
        int i = this.f7621m;
        if (i == 0) {
            return null;
        }
        Drawable drawableV = id.k.v(i, this.f7622n.f7583a);
        this.f7621m = 0;
        this.f7620l = drawableV;
        return d(drawableV);
    }

    @Override // h3.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f7627s;
    }

    @Override // h3.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f7628t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f7616g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f7610a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // h3.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f7617h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f7612c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f7623o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f7614e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f7615f;
        return charSequence != null ? charSequence : this.f7614e;
    }

    @Override // h3.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f7626r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f7623o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f7632x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f7632x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f7632x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        n3.d dVar = this.A;
        return (dVar == null || !dVar.f()) ? (this.f7632x & 8) == 0 : (this.f7632x & 8) == 0 && this.A.b();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        int i3;
        l lVar = this.f7622n;
        Context context = lVar.f7583a;
        View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false);
        this.f7634z = viewInflate;
        this.A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i3 = this.f7610a) > 0) {
            viewInflate.setId(i3);
        }
        lVar.f7592k = true;
        lVar.p(true);
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i) {
        if (this.f7618j == c9 && this.f7619k == i) {
            return this;
        }
        this.f7618j = Character.toLowerCase(c9);
        this.f7619k = KeyEvent.normalizeMetaState(i);
        this.f7622n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z10) {
        int i = this.f7632x;
        int i3 = (z10 ? 1 : 0) | (i & (-2));
        this.f7632x = i3;
        if (i != i3) {
            this.f7622n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z10) {
        l lVar = this.f7622n;
        int i = this.f7632x;
        if ((i & 4) == 0) {
            int i3 = (i & (-3)) | (z10 ? 2 : 0);
            this.f7632x = i3;
            if (i != i3) {
                lVar.p(false);
            }
            return this;
        }
        int i10 = this.f7611b;
        ArrayList arrayList = lVar.f7588f;
        int size = arrayList.size();
        lVar.w();
        for (int i11 = 0; i11 < size; i11++) {
            n nVar = (n) arrayList.get(i11);
            if (nVar.f7611b == i10 && (nVar.f7632x & 4) != 0 && nVar.isCheckable()) {
                boolean z11 = nVar == this;
                int i12 = nVar.f7632x;
                int i13 = (z11 ? 2 : 0) | (i12 & (-3));
                nVar.f7632x = i13;
                if (i12 != i13) {
                    nVar.f7622n.p(false);
                }
            }
        }
        lVar.v();
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final h3.b setContentDescription(CharSequence charSequence) {
        this.f7625q = charSequence;
        this.f7622n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z10) {
        int i = this.f7632x;
        if (z10) {
            this.f7632x = i | 16;
        } else {
            this.f7632x = i & (-17);
        }
        this.f7622n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f7620l = null;
        this.f7621m = i;
        this.f7631w = true;
        this.f7622n.p(false);
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f7627s = colorStateList;
        this.f7629u = true;
        this.f7631w = true;
        this.f7622n.p(false);
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f7628t = mode;
        this.f7630v = true;
        this.f7631w = true;
        this.f7622n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f7616g = intent;
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i) {
        if (this.f7617h == c9 && this.i == i) {
            return this;
        }
        this.f7617h = c9;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f7622n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f7624p = onMenuItemClickListener;
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i, int i3) {
        this.f7617h = c9;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f7618j = Character.toLowerCase(c10);
        this.f7619k = KeyEvent.normalizeMetaState(i3);
        this.f7622n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
        int i3 = i & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            g5.f.s("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
            return;
        }
        this.f7633y = i;
        l lVar = this.f7622n;
        lVar.f7592k = true;
        lVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f7614e = charSequence;
        this.f7622n.p(false);
        d0 d0Var = this.f7623o;
        if (d0Var != null) {
            d0Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f7615f = charSequence;
        this.f7622n.p(false);
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final h3.b setTooltipText(CharSequence charSequence) {
        this.f7626r = charSequence;
        this.f7622n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z10) {
        int i = this.f7632x;
        int i3 = (z10 ? 0 : 8) | (i & (-9));
        this.f7632x = i3;
        if (i != i3) {
            l lVar = this.f7622n;
            lVar.f7590h = true;
            lVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f7614e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f7621m = 0;
        this.f7620l = drawable;
        this.f7631w = true;
        this.f7622n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        setTitle(this.f7622n.f7583a.getString(i));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        if (this.f7617h == c9) {
            return this;
        }
        this.f7617h = c9;
        this.f7622n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f7617h = c9;
        this.f7618j = Character.toLowerCase(c10);
        this.f7622n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        if (this.f7618j == c9) {
            return this;
        }
        this.f7618j = Character.toLowerCase(c9);
        this.f7622n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i;
        this.f7634z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i = this.f7610a) > 0) {
            view.setId(i);
        }
        l lVar = this.f7622n;
        lVar.f7592k = true;
        lVar.p(true);
        return this;
    }
}
