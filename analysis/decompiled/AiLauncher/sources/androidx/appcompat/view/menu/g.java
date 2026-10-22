package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.view.menu.j;
import androidx.core.view.AbstractC1314b;
import f.C4027a;
import u0.C5566a;
import v0.InterfaceMenuItemC5651b;

/* loaded from: classes.dex */
public final class g implements InterfaceMenuItemC5651b {

    /* renamed from: A, reason: collision with root package name */
    public View f8646A;

    /* renamed from: B, reason: collision with root package name */
    public AbstractC1314b f8647B;

    /* renamed from: C, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f8648C;

    /* renamed from: E, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f8650E;

    /* renamed from: a, reason: collision with root package name */
    public final int f8651a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8652b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8653c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8654d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f8655e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f8656f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f8657g;

    /* renamed from: h, reason: collision with root package name */
    public char f8658h;

    /* renamed from: j, reason: collision with root package name */
    public char f8660j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f8662l;

    /* renamed from: n, reason: collision with root package name */
    public e f8664n;

    /* renamed from: o, reason: collision with root package name */
    public l f8665o;

    /* renamed from: p, reason: collision with root package name */
    public Runnable f8666p;

    /* renamed from: q, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f8667q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f8668r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f8669s;

    /* renamed from: z, reason: collision with root package name */
    public int f8676z;

    /* renamed from: i, reason: collision with root package name */
    public int f8659i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f8661k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f8663m = 0;

    /* renamed from: t, reason: collision with root package name */
    public ColorStateList f8670t = null;

    /* renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f8671u = null;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8672v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8673w = false;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8674x = false;

    /* renamed from: y, reason: collision with root package name */
    public int f8675y = 16;

    /* renamed from: D, reason: collision with root package name */
    public boolean f8649D = false;

    public class a implements AbstractC1314b.InterfaceC0160b {
        public a() {
        }

        @Override // androidx.core.view.AbstractC1314b.InterfaceC0160b
        public void onActionProviderVisibilityChanged(boolean z10) {
            g gVar = g.this;
            gVar.f8664n.M(gVar);
        }
    }

    public g(e eVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f8664n = eVar;
        this.f8651a = i11;
        this.f8652b = i10;
        this.f8653c = i12;
        this.f8654d = i13;
        this.f8655e = charSequence;
        this.f8676z = i14;
    }

    public static void d(StringBuilder sb2, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb2.append(str);
        }
    }

    public boolean A() {
        return this.f8664n.K() && g() != 0;
    }

    public boolean B() {
        return (this.f8676z & 4) == 4;
    }

    @Override // v0.InterfaceMenuItemC5651b
    public AbstractC1314b a() {
        return this.f8647B;
    }

    @Override // v0.InterfaceMenuItemC5651b
    public InterfaceMenuItemC5651b b(AbstractC1314b abstractC1314b) {
        AbstractC1314b abstractC1314b2 = this.f8647B;
        if (abstractC1314b2 != null) {
            abstractC1314b2.h();
        }
        this.f8646A = null;
        this.f8647B = abstractC1314b;
        this.f8664n.N(true);
        AbstractC1314b abstractC1314b3 = this.f8647B;
        if (abstractC1314b3 != null) {
            abstractC1314b3.j(new a());
        }
        return this;
    }

    public void c() {
        this.f8664n.L(this);
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f8676z & 8) == 0) {
            return false;
        }
        if (this.f8646A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f8648C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f8664n.f(this);
        }
        return false;
    }

    public final Drawable e(Drawable drawable) {
        if (drawable != null && this.f8674x && (this.f8672v || this.f8673w)) {
            drawable = C5566a.r(drawable).mutate();
            if (this.f8672v) {
                C5566a.o(drawable, this.f8670t);
            }
            if (this.f8673w) {
                C5566a.p(drawable, this.f8671u);
            }
            this.f8674x = false;
        }
        return drawable;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f8648C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f8664n.m(this);
        }
        return false;
    }

    public int f() {
        return this.f8654d;
    }

    public char g() {
        return this.f8664n.J() ? this.f8660j : this.f8658h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public View getActionView() {
        View view = this.f8646A;
        if (view != null) {
            return view;
        }
        AbstractC1314b abstractC1314b = this.f8647B;
        if (abstractC1314b == null) {
            return null;
        }
        View viewD = abstractC1314b.d(this);
        this.f8646A = viewD;
        return viewD;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f8661k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f8660j;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f8668r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f8652b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f8662l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f8663m == 0) {
            return null;
        }
        Drawable drawableB = C4027a.b(this.f8664n.w(), this.f8663m);
        this.f8663m = 0;
        this.f8662l = drawableB;
        return e(drawableB);
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f8670t;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f8671u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f8657g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f8651a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f8650E;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f8659i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f8658h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f8653c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f8665o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f8655e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f8656f;
        return charSequence != null ? charSequence : this.f8655e;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f8669s;
    }

    public String h() {
        char cG = g();
        if (cG == 0) {
            return "";
        }
        Resources resources = this.f8664n.w().getResources();
        StringBuilder sb2 = new StringBuilder();
        if (ViewConfiguration.get(this.f8664n.w()).hasPermanentMenuKey()) {
            sb2.append(resources.getString(R$string.abc_prepend_shortcut_label));
        }
        int i10 = this.f8664n.J() ? this.f8661k : this.f8659i;
        d(sb2, i10, 65536, resources.getString(R$string.abc_menu_meta_shortcut_label));
        d(sb2, i10, 4096, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
        d(sb2, i10, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
        d(sb2, i10, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
        d(sb2, i10, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
        d(sb2, i10, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
        if (cG == '\b') {
            sb2.append(resources.getString(R$string.abc_menu_delete_shortcut_label));
        } else if (cG == '\n') {
            sb2.append(resources.getString(R$string.abc_menu_enter_shortcut_label));
        } else if (cG != ' ') {
            sb2.append(cG);
        } else {
            sb2.append(resources.getString(R$string.abc_menu_space_shortcut_label));
        }
        return sb2.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f8665o != null;
    }

    public CharSequence i(j.a aVar) {
        return (aVar == null || !aVar.c()) ? getTitle() : getTitleCondensed();
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f8649D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f8675y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f8675y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f8675y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        AbstractC1314b abstractC1314b = this.f8647B;
        return (abstractC1314b == null || !abstractC1314b.g()) ? (this.f8675y & 8) == 0 : (this.f8675y & 8) == 0 && this.f8647B.b();
    }

    public boolean j() {
        AbstractC1314b abstractC1314b;
        if ((this.f8676z & 8) != 0) {
            if (this.f8646A == null && (abstractC1314b = this.f8647B) != null) {
                this.f8646A = abstractC1314b.d(this);
            }
            if (this.f8646A != null) {
                return true;
            }
        }
        return false;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f8667q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f8664n;
        if (eVar.h(eVar, this)) {
            return true;
        }
        Runnable runnable = this.f8666p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f8657g != null) {
            try {
                this.f8664n.w().startActivity(this.f8657g);
                return true;
            } catch (ActivityNotFoundException e10) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e10);
            }
        }
        AbstractC1314b abstractC1314b = this.f8647B;
        return abstractC1314b != null && abstractC1314b.e();
    }

    public boolean l() {
        return (this.f8675y & 32) == 32;
    }

    public boolean m() {
        return (this.f8675y & 4) != 0;
    }

    public boolean n() {
        return (this.f8676z & 1) == 1;
    }

    public boolean o() {
        return (this.f8676z & 2) == 2;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC5651b setActionView(int i10) {
        Context contextW = this.f8664n.w();
        setActionView(LayoutInflater.from(contextW).inflate(i10, (ViewGroup) new LinearLayout(contextW), false));
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC5651b setActionView(View view) {
        int i10;
        this.f8646A = view;
        this.f8647B = null;
        if (view != null && view.getId() == -1 && (i10 = this.f8651a) > 0) {
            view.setId(i10);
        }
        this.f8664n.L(this);
        return this;
    }

    public void r(boolean z10) {
        this.f8649D = z10;
        this.f8664n.N(false);
    }

    public void s(boolean z10) {
        int i10 = this.f8675y;
        int i11 = (z10 ? 2 : 0) | (i10 & (-3));
        this.f8675y = i11;
        if (i10 != i11) {
            this.f8664n.N(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f8660j == c10) {
            return this;
        }
        this.f8660j = Character.toLowerCase(c10);
        this.f8664n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        int i10 = this.f8675y;
        int i11 = (z10 ? 1 : 0) | (i10 & (-2));
        this.f8675y = i11;
        if (i10 != i11) {
            this.f8664n.N(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        if ((this.f8675y & 4) != 0) {
            this.f8664n.Y(this);
            return this;
        }
        s(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f8675y |= 16;
        } else {
            this.f8675y &= -17;
        }
        this.f8664n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f8663m = 0;
        this.f8662l = drawable;
        this.f8674x = true;
        this.f8664n.N(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f8670t = colorStateList;
        this.f8672v = true;
        this.f8674x = true;
        this.f8664n.N(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f8671u = mode;
        this.f8673w = true;
        this.f8674x = true;
        this.f8664n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f8657g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        if (this.f8658h == c10) {
            return this;
        }
        this.f8658h = c10;
        this.f8664n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f8648C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f8667q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f8658h = c10;
        this.f8660j = Character.toLowerCase(c11);
        this.f8664n.N(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f8676z = i10;
        this.f8664n.L(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f8655e = charSequence;
        this.f8664n.N(false);
        l lVar = this.f8665o;
        if (lVar != null) {
            lVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f8656f = charSequence;
        this.f8664n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        if (y(z10)) {
            this.f8664n.M(this);
        }
        return this;
    }

    public void t(boolean z10) {
        this.f8675y = (z10 ? 4 : 0) | (this.f8675y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f8655e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z10) {
        if (z10) {
            this.f8675y |= 32;
        } else {
            this.f8675y &= -33;
        }
    }

    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f8650E = contextMenuInfo;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC5651b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public void x(l lVar) {
        this.f8665o = lVar;
        lVar.setHeaderTitle(getTitle());
    }

    public boolean y(boolean z10) {
        int i10 = this.f8675y;
        int i11 = (z10 ? 0 : 8) | (i10 & (-9));
        this.f8675y = i11;
        return i10 != i11;
    }

    public boolean z() {
        return this.f8664n.C();
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public InterfaceMenuItemC5651b setContentDescription(CharSequence charSequence) {
        this.f8668r = charSequence;
        this.f8664n.N(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public InterfaceMenuItemC5651b setTooltipText(CharSequence charSequence) {
        this.f8669s = charSequence;
        this.f8664n.N(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f8660j == c10 && this.f8661k == i10) {
            return this;
        }
        this.f8660j = Character.toLowerCase(c10);
        this.f8661k = KeyEvent.normalizeMetaState(i10);
        this.f8664n.N(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f8658h == c10 && this.f8659i == i10) {
            return this;
        }
        this.f8658h = c10;
        this.f8659i = KeyEvent.normalizeMetaState(i10);
        this.f8664n.N(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f8658h = c10;
        this.f8659i = KeyEvent.normalizeMetaState(i10);
        this.f8660j = Character.toLowerCase(c11);
        this.f8661k = KeyEvent.normalizeMetaState(i11);
        this.f8664n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f8662l = null;
        this.f8663m = i10;
        this.f8674x = true;
        this.f8664n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        return setTitle(this.f8664n.w().getString(i10));
    }
}
