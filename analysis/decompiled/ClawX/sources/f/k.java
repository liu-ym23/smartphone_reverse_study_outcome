package f;

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
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k implements MenuItem {
    public MenuItem.OnActionExpandListener A;

    /* renamed from: a, reason: collision with root package name */
    public final int f2473a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2474b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2475c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f2476e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f2477f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f2478g;

    /* renamed from: h, reason: collision with root package name */
    public char f2479h;

    /* renamed from: j, reason: collision with root package name */
    public char f2481j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f2483l;

    /* renamed from: n, reason: collision with root package name */
    public final j f2485n;

    /* renamed from: o, reason: collision with root package name */
    public t f2486o;

    /* renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f2487p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f2488q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f2489r;
    public View z;

    /* renamed from: i, reason: collision with root package name */
    public int f2480i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f2482k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f2484m = 0;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f2490s = null;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f2491t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2492u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2493v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2494w = false;

    /* renamed from: x, reason: collision with root package name */
    public int f2495x = 16;
    public boolean B = false;
    public int y = 0;

    public k(j jVar, int i8, int i9, int i10, int i11, CharSequence charSequence) {
        this.f2485n = jVar;
        this.f2473a = i9;
        this.f2474b = i8;
        this.f2475c = i10;
        this.d = i11;
        this.f2476e = charSequence;
    }

    public static void a(StringBuilder sb, int i8, int i9, String str) {
        if ((i8 & i9) == i9) {
            sb.append(str);
        }
    }

    public final Drawable b(Drawable drawable) {
        if (drawable != null && this.f2494w && (this.f2492u || this.f2493v)) {
            drawable = drawable.mutate();
            if (this.f2492u) {
                drawable.setTintList(this.f2490s);
            }
            if (this.f2493v) {
                drawable.setTintMode(this.f2491t);
            }
            this.f2494w = false;
        }
        return drawable;
    }

    public final k c(CharSequence charSequence) {
        this.f2488q = charSequence;
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.A;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f2485n.d(this);
        }
        return false;
    }

    public final void d(boolean z) {
        if (z) {
            this.f2495x |= 32;
        } else {
            this.f2495x &= -33;
        }
    }

    public final k e(CharSequence charSequence) {
        this.f2489r = charSequence;
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if ((this.y & 8) == 0 || this.z == null) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.A;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f2485n.f(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.z;
        if (view != null) {
            return view;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f2482k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f2481j;
    }

    @Override // android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f2488q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f2474b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f2483l;
        if (drawable != null) {
            return b(drawable);
        }
        int i8 = this.f2484m;
        if (i8 == 0) {
            return null;
        }
        Drawable drawableP = b8.h.p(this.f2485n.f2454a, i8);
        this.f2484m = 0;
        this.f2483l = drawableP;
        return b(drawableP);
    }

    @Override // android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f2490s;
    }

    @Override // android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f2491t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f2478g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f2473a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f2480i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f2479h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f2475c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f2486o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f2476e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2477f;
        return charSequence != null ? charSequence : this.f2476e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f2489r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f2486o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.B;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f2495x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f2495x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f2495x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f2495x & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i8;
        this.z = view;
        if (view != null && view.getId() == -1 && (i8 = this.f2473a) > 0) {
            view.setId(i8);
        }
        j jVar = this.f2485n;
        jVar.f2463k = true;
        jVar.o(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c3) {
        if (this.f2481j == c3) {
            return this;
        }
        this.f2481j = Character.toLowerCase(c3);
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int i8 = this.f2495x;
        int i9 = (z ? 1 : 0) | (i8 & (-2));
        this.f2495x = i9;
        if (i8 != i9) {
            this.f2485n.o(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        int i8 = this.f2495x;
        int i9 = i8 & 4;
        j jVar = this.f2485n;
        if (i9 == 0) {
            int i10 = (i8 & (-3)) | (z ? 2 : 0);
            this.f2495x = i10;
            if (i8 != i10) {
                jVar.o(false);
            }
            return this;
        }
        ArrayList arrayList = jVar.f2458f;
        int size = arrayList.size();
        jVar.s();
        for (int i11 = 0; i11 < size; i11++) {
            k kVar = (k) arrayList.get(i11);
            if (kVar.f2474b == this.f2474b && (kVar.f2495x & 4) != 0 && kVar.isCheckable()) {
                boolean z2 = kVar == this;
                int i12 = kVar.f2495x;
                int i13 = (z2 ? 2 : 0) | (i12 & (-3));
                kVar.f2495x = i13;
                if (i12 != i13) {
                    kVar.f2485n.o(false);
                }
            }
        }
        jVar.r();
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        c(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.f2495x |= 16;
        } else {
            this.f2495x &= -17;
        }
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f2484m = 0;
        this.f2483l = drawable;
        this.f2494w = true;
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f2490s = colorStateList;
        this.f2492u = true;
        this.f2494w = true;
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f2491t = mode;
        this.f2493v = true;
        this.f2494w = true;
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f2478g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c3) {
        if (this.f2479h == c3) {
            return this;
        }
        this.f2479h = c3;
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.A = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f2487p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c3, char c8) {
        this.f2479h = c3;
        this.f2481j = Character.toLowerCase(c8);
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i8) {
        int i9 = i8 & 3;
        if (i9 != 0 && i9 != 1 && i9 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.y = i8;
        j jVar = this.f2485n;
        jVar.f2463k = true;
        jVar.o(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i8) {
        setShowAsAction(i8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f2476e = charSequence;
        this.f2485n.o(false);
        t tVar = this.f2486o;
        if (tVar != null) {
            tVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2477f = charSequence;
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        e(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        int i8 = this.f2495x;
        int i9 = (z ? 0 : 8) | (i8 & (-9));
        this.f2495x = i9;
        if (i8 != i9) {
            j jVar = this.f2485n;
            jVar.f2460h = true;
            jVar.o(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f2476e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c3, int i8) {
        if (this.f2481j == c3 && this.f2482k == i8) {
            return this;
        }
        this.f2481j = Character.toLowerCase(c3);
        this.f2482k = KeyEvent.normalizeMetaState(i8);
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c3, int i8) {
        if (this.f2479h == c3 && this.f2480i == i8) {
            return this;
        }
        this.f2479h = c3;
        this.f2480i = KeyEvent.normalizeMetaState(i8);
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c3, char c8, int i8, int i9) {
        this.f2479h = c3;
        this.f2480i = KeyEvent.normalizeMetaState(i8);
        this.f2481j = Character.toLowerCase(c8);
        this.f2482k = KeyEvent.normalizeMetaState(i9);
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i8) {
        this.f2483l = null;
        this.f2484m = i8;
        this.f2494w = true;
        this.f2485n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i8) {
        setTitle(this.f2485n.f2454a.getString(i8));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i8) {
        int i9;
        j jVar = this.f2485n;
        Context context = jVar.f2454a;
        View viewInflate = LayoutInflater.from(context).inflate(i8, (ViewGroup) new LinearLayout(context), false);
        this.z = viewInflate;
        if (viewInflate != null && viewInflate.getId() == -1 && (i9 = this.f2473a) > 0) {
            viewInflate.setId(i9);
        }
        jVar.f2463k = true;
        jVar.o(true);
        return this;
    }
}
