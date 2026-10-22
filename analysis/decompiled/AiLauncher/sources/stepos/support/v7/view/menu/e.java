package stepos.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
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
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.C1295h;
import androidx.core.view.AbstractC1314b;
import stepos.support.v7.view.menu.h;
import u0.C5566a;
import v0.InterfaceMenuItemC5651b;

/* loaded from: classes5.dex */
public final class e implements InterfaceMenuItemC5651b, Jc.g {

    /* renamed from: K, reason: collision with root package name */
    public static String f40957K;

    /* renamed from: L, reason: collision with root package name */
    public static String f40958L;

    /* renamed from: M, reason: collision with root package name */
    public static String f40959M;

    /* renamed from: N, reason: collision with root package name */
    public static String f40960N;

    /* renamed from: A, reason: collision with root package name */
    public View f40961A;

    /* renamed from: B, reason: collision with root package name */
    public AbstractC1314b f40962B;

    /* renamed from: C, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f40963C;

    /* renamed from: E, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f40965E;

    /* renamed from: F, reason: collision with root package name */
    public int f40966F;

    /* renamed from: G, reason: collision with root package name */
    public ColorStateList f40967G;

    /* renamed from: I, reason: collision with root package name */
    public boolean f40969I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f40970J;

    /* renamed from: a, reason: collision with root package name */
    public final int f40971a;

    /* renamed from: b, reason: collision with root package name */
    public final int f40972b;

    /* renamed from: c, reason: collision with root package name */
    public final int f40973c;

    /* renamed from: d, reason: collision with root package name */
    public final int f40974d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f40975e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f40976f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f40977g;

    /* renamed from: h, reason: collision with root package name */
    public char f40978h;

    /* renamed from: j, reason: collision with root package name */
    public char f40980j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f40982l;

    /* renamed from: n, reason: collision with root package name */
    public c f40984n;

    /* renamed from: o, reason: collision with root package name */
    public i f40985o;

    /* renamed from: p, reason: collision with root package name */
    public Runnable f40986p;

    /* renamed from: q, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f40987q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f40988r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f40989s;

    /* renamed from: z, reason: collision with root package name */
    public int f40996z;

    /* renamed from: i, reason: collision with root package name */
    public int f40979i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f40981k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f40983m = 0;

    /* renamed from: t, reason: collision with root package name */
    public ColorStateList f40990t = null;

    /* renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f40991u = null;

    /* renamed from: v, reason: collision with root package name */
    public boolean f40992v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f40993w = false;

    /* renamed from: x, reason: collision with root package name */
    public boolean f40994x = false;

    /* renamed from: y, reason: collision with root package name */
    public int f40995y = 16;

    /* renamed from: D, reason: collision with root package name */
    public boolean f40964D = false;

    /* renamed from: H, reason: collision with root package name */
    public boolean f40968H = true;

    public class a implements AbstractC1314b.InterfaceC0160b {
        public a() {
        }

        @Override // androidx.core.view.AbstractC1314b.InterfaceC0160b
        public void onActionProviderVisibilityChanged(boolean z10) {
            e eVar = e.this;
            eVar.f40984n.I(eVar);
        }
    }

    public e(c cVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f40984n = cVar;
        this.f40971a = i11;
        this.f40972b = i10;
        this.f40973c = i12;
        this.f40974d = i13;
        this.f40975e = charSequence;
        this.f40996z = i14;
    }

    private Drawable d(Drawable drawable) {
        if (drawable != null && this.f40994x && (this.f40992v || this.f40993w)) {
            drawable = C5566a.r(drawable).mutate();
            if (this.f40992v) {
                C5566a.o(drawable, this.f40990t);
            }
            if (this.f40993w) {
                C5566a.p(drawable, this.f40991u);
            }
            this.f40994x = false;
        }
        return drawable;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC5651b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public void B(i iVar) {
        this.f40985o = iVar;
        iVar.setHeaderTitle(getTitle());
    }

    public boolean C(boolean z10) {
        int i10 = this.f40995y;
        int i11 = (z10 ? 0 : 8) | (i10 & (-9));
        this.f40995y = i11;
        return i10 != i11;
    }

    public boolean D() {
        return this.f40984n.A();
    }

    public boolean E() {
        return this.f40984n.G() && g() != 0;
    }

    public boolean F() {
        return (this.f40996z & 4) == 4;
    }

    @Override // v0.InterfaceMenuItemC5651b
    public AbstractC1314b a() {
        return this.f40962B;
    }

    @Override // v0.InterfaceMenuItemC5651b
    public InterfaceMenuItemC5651b b(AbstractC1314b abstractC1314b) {
        AbstractC1314b abstractC1314b2 = this.f40962B;
        if (abstractC1314b2 != null) {
            abstractC1314b2.h();
        }
        this.f40961A = null;
        this.f40962B = abstractC1314b;
        this.f40984n.J(true);
        AbstractC1314b abstractC1314b3 = this.f40962B;
        if (abstractC1314b3 != null) {
            abstractC1314b3.j(new a());
        }
        return this;
    }

    public void c() {
        this.f40984n.H(this);
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f40996z & 8) == 0) {
            return false;
        }
        if (this.f40961A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f40963C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f40984n.f(this);
        }
        return false;
    }

    public int e() {
        return this.f40966F;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public boolean expandActionView() {
        if (!k()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f40963C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f40984n.k(this);
        }
        return false;
    }

    public int f() {
        return this.f40974d;
    }

    public char g() {
        return this.f40984n.F() ? this.f40980j : this.f40978h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public View getActionView() {
        View view = this.f40961A;
        if (view != null) {
            return view;
        }
        AbstractC1314b abstractC1314b = this.f40962B;
        if (abstractC1314b == null) {
            return null;
        }
        View viewD = abstractC1314b.d(this);
        this.f40961A = viewD;
        return viewD;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f40981k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f40980j;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f40988r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f40972b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f40982l;
        if (drawable != null) {
            return d(drawable);
        }
        if (this.f40983m == 0) {
            return null;
        }
        Drawable drawableC = C1295h.b().c(this.f40984n.u(), this.f40983m);
        this.f40983m = 0;
        this.f40982l = drawableC;
        return d(drawableC);
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f40990t;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f40991u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f40977g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f40971a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f40965E;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f40979i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f40978h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f40973c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f40985o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f40975e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f40976f;
        return charSequence != null ? charSequence : this.f40975e;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f40989s;
    }

    public String h() {
        char cG = g();
        if (cG == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(f40957K);
        if (cG == '\b') {
            sb2.append(f40959M);
        } else if (cG == '\n') {
            sb2.append(f40958L);
        } else if (cG != ' ') {
            sb2.append(cG);
        } else {
            sb2.append(f40960N);
        }
        return sb2.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f40985o != null;
    }

    public ColorStateList i() {
        return this.f40967G;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f40964D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f40995y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f40995y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f40995y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        AbstractC1314b abstractC1314b = this.f40962B;
        return (abstractC1314b == null || !abstractC1314b.g()) ? (this.f40995y & 8) == 0 : (this.f40995y & 8) == 0 && this.f40962B.b();
    }

    public CharSequence j(h.a aVar) {
        return (aVar == null || !aVar.c()) ? getTitle() : getTitleCondensed();
    }

    public boolean k() {
        AbstractC1314b abstractC1314b;
        if ((this.f40996z & 8) != 0) {
            if (this.f40961A == null && (abstractC1314b = this.f40962B) != null) {
                this.f40961A = abstractC1314b.d(this);
            }
            if (this.f40961A != null) {
                return true;
            }
        }
        return false;
    }

    public boolean l() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f40987q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        c cVar = this.f40984n;
        if (cVar.h(cVar, this)) {
            return true;
        }
        Runnable runnable = this.f40986p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f40977g != null) {
            try {
                this.f40984n.u().startActivity(this.f40977g);
                return true;
            } catch (ActivityNotFoundException e10) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e10);
            }
        }
        AbstractC1314b abstractC1314b = this.f40962B;
        return abstractC1314b != null && abstractC1314b.e();
    }

    public boolean m() {
        return (this.f40995y & 32) == 32;
    }

    public boolean n() {
        return (this.f40995y & 4) != 0;
    }

    public boolean o() {
        return this.f40970J;
    }

    public boolean p() {
        return this.f40969I;
    }

    public boolean q() {
        return (this.f40995y & 64) != 0;
    }

    public boolean r() {
        return (this.f40996z & 1) == 1;
    }

    public boolean s() {
        return (this.f40996z & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f40980j == c10) {
            return this;
        }
        this.f40980j = Character.toLowerCase(c10);
        this.f40984n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        int i10 = this.f40995y;
        int i11 = (z10 ? 1 : 0) | (i10 & (-2));
        this.f40995y = i11;
        if (i10 != i11) {
            this.f40984n.J(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        if ((this.f40995y & 4) != 0) {
            this.f40984n.S(this);
            return this;
        }
        w(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f40995y |= 16;
        } else {
            this.f40995y &= -17;
        }
        this.f40984n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f40983m = 0;
        this.f40982l = drawable;
        this.f40994x = true;
        this.f40984n.J(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f40990t = colorStateList;
        this.f40992v = true;
        this.f40994x = true;
        this.f40984n.J(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f40991u = mode;
        this.f40993w = true;
        this.f40994x = true;
        this.f40984n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f40977g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        if (this.f40978h == c10) {
            return this;
        }
        this.f40978h = c10;
        this.f40984n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f40963C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f40987q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f40978h = c10;
        this.f40980j = Character.toLowerCase(c11);
        this.f40984n.J(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f40996z = i10;
        this.f40984n.H(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f40975e = charSequence;
        this.f40984n.J(false);
        i iVar = this.f40985o;
        if (iVar != null) {
            iVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f40976f = charSequence;
        this.f40984n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        if (C(z10)) {
            this.f40984n.I(this);
        }
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC5651b setActionView(int i10) {
        Context contextU = this.f40984n.u();
        setActionView(LayoutInflater.from(contextU).inflate(i10, (ViewGroup) new LinearLayout(contextU), false));
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f40975e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC5651b setActionView(View view) {
        int i10;
        this.f40961A = view;
        this.f40962B = null;
        if (view != null && view.getId() == -1 && (i10 = this.f40971a) > 0) {
            view.setId(i10);
        }
        this.f40984n.H(this);
        return this;
    }

    public void v(boolean z10) {
        this.f40964D = z10;
        this.f40984n.J(false);
    }

    public void w(boolean z10) {
        int i10 = this.f40995y;
        int i11 = (z10 ? 2 : 0) | (i10 & (-3));
        this.f40995y = i11;
        if (i10 != i11) {
            this.f40984n.J(false);
        }
    }

    public void x(boolean z10) {
        this.f40995y = (z10 ? 4 : 0) | (this.f40995y & (-5));
    }

    public void y(boolean z10) {
        if (z10) {
            this.f40995y |= 32;
        } else {
            this.f40995y &= -33;
        }
    }

    public void z(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f40965E = contextMenuInfo;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public InterfaceMenuItemC5651b setContentDescription(CharSequence charSequence) {
        this.f40988r = charSequence;
        this.f40984n.J(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public InterfaceMenuItemC5651b setTooltipText(CharSequence charSequence) {
        this.f40989s = charSequence;
        this.f40984n.J(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f40980j == c10 && this.f40981k == i10) {
            return this;
        }
        this.f40980j = Character.toLowerCase(c10);
        this.f40981k = KeyEvent.normalizeMetaState(i10);
        this.f40984n.J(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f40978h == c10 && this.f40979i == i10) {
            return this;
        }
        this.f40978h = c10;
        this.f40979i = KeyEvent.normalizeMetaState(i10);
        this.f40984n.J(false);
        return this;
    }

    @Override // v0.InterfaceMenuItemC5651b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f40978h = c10;
        this.f40979i = KeyEvent.normalizeMetaState(i10);
        this.f40980j = Character.toLowerCase(c11);
        this.f40981k = KeyEvent.normalizeMetaState(i11);
        this.f40984n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f40982l = null;
        this.f40983m = i10;
        this.f40994x = true;
        this.f40984n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        return setTitle(this.f40984n.u().getString(i10));
    }
}
