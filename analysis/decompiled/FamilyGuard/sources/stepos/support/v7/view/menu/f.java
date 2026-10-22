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
import androidx.appcompat.widget.C0441k;
import androidx.core.view.AbstractC0457b;
import androidx.recyclerview.widget.RecyclerView;
import org.libpag.BuildConfig;
import stepos.support.v7.view.menu.i;

/* loaded from: classes.dex */
public final class f implements A.b, c5.f {

    /* renamed from: K, reason: collision with root package name */
    private static String f21299K;

    /* renamed from: L, reason: collision with root package name */
    private static String f21300L;

    /* renamed from: M, reason: collision with root package name */
    private static String f21301M;

    /* renamed from: Q, reason: collision with root package name */
    private static String f21302Q;

    /* renamed from: A, reason: collision with root package name */
    private View f21303A;

    /* renamed from: B, reason: collision with root package name */
    private AbstractC0457b f21304B;

    /* renamed from: C, reason: collision with root package name */
    private MenuItem.OnActionExpandListener f21305C;

    /* renamed from: E, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f21307E;

    /* renamed from: F, reason: collision with root package name */
    private int f21308F;

    /* renamed from: G, reason: collision with root package name */
    private ColorStateList f21309G;

    /* renamed from: I, reason: collision with root package name */
    private boolean f21311I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f21312J;

    /* renamed from: a, reason: collision with root package name */
    private final int f21313a;

    /* renamed from: b, reason: collision with root package name */
    private final int f21314b;

    /* renamed from: c, reason: collision with root package name */
    private final int f21315c;

    /* renamed from: d, reason: collision with root package name */
    private final int f21316d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f21317e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f21318f;

    /* renamed from: g, reason: collision with root package name */
    private Intent f21319g;

    /* renamed from: h, reason: collision with root package name */
    private char f21320h;

    /* renamed from: j, reason: collision with root package name */
    private char f21322j;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f21324l;

    /* renamed from: n, reason: collision with root package name */
    d f21326n;

    /* renamed from: o, reason: collision with root package name */
    private j f21327o;

    /* renamed from: p, reason: collision with root package name */
    private Runnable f21328p;

    /* renamed from: q, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f21329q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f21330r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f21331s;

    /* renamed from: z, reason: collision with root package name */
    private int f21338z;

    /* renamed from: i, reason: collision with root package name */
    private int f21321i = RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;

    /* renamed from: k, reason: collision with root package name */
    private int f21323k = RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;

    /* renamed from: m, reason: collision with root package name */
    private int f21325m = 0;

    /* renamed from: t, reason: collision with root package name */
    private ColorStateList f21332t = null;

    /* renamed from: u, reason: collision with root package name */
    private PorterDuff.Mode f21333u = null;

    /* renamed from: v, reason: collision with root package name */
    private boolean f21334v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f21335w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f21336x = false;

    /* renamed from: y, reason: collision with root package name */
    private int f21337y = 16;

    /* renamed from: D, reason: collision with root package name */
    private boolean f21306D = false;

    /* renamed from: H, reason: collision with root package name */
    private boolean f21310H = true;

    class a implements AbstractC0457b.InterfaceC0123b {
        a() {
        }

        @Override // androidx.core.view.AbstractC0457b.InterfaceC0123b
        public void onActionProviderVisibilityChanged(boolean z5) {
            f fVar = f.this;
            fVar.f21326n.I(fVar);
        }
    }

    f(d dVar, int i5, int i6, int i7, int i8, CharSequence charSequence, int i9) {
        this.f21326n = dVar;
        this.f21313a = i6;
        this.f21314b = i5;
        this.f21315c = i7;
        this.f21316d = i8;
        this.f21317e = charSequence;
        this.f21338z = i9;
    }

    private Drawable d(Drawable drawable) {
        if (drawable != null && this.f21336x && (this.f21334v || this.f21335w)) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (this.f21334v) {
                androidx.core.graphics.drawable.a.o(drawable, this.f21332t);
            }
            if (this.f21335w) {
                androidx.core.graphics.drawable.a.p(drawable, this.f21333u);
            }
            this.f21336x = false;
        }
        return drawable;
    }

    @Override // A.b, android.view.MenuItem
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public A.b setShowAsActionFlags(int i5) {
        setShowAsAction(i5);
        return this;
    }

    public void B(j jVar) {
        this.f21327o = jVar;
        jVar.setHeaderTitle(getTitle());
    }

    boolean C(boolean z5) {
        int i5 = this.f21337y;
        int i6 = (z5 ? 0 : 8) | (i5 & (-9));
        this.f21337y = i6;
        return i5 != i6;
    }

    public boolean D() {
        return this.f21326n.A();
    }

    boolean E() {
        return this.f21326n.G() && g() != 0;
    }

    public boolean F() {
        return (this.f21338z & 4) == 4;
    }

    @Override // A.b
    public A.b a(AbstractC0457b abstractC0457b) {
        AbstractC0457b abstractC0457b2 = this.f21304B;
        if (abstractC0457b2 != null) {
            abstractC0457b2.h();
        }
        this.f21303A = null;
        this.f21304B = abstractC0457b;
        this.f21326n.J(true);
        AbstractC0457b abstractC0457b3 = this.f21304B;
        if (abstractC0457b3 != null) {
            abstractC0457b3.j(new a());
        }
        return this;
    }

    @Override // A.b
    public AbstractC0457b b() {
        return this.f21304B;
    }

    public void c() {
        this.f21326n.H(this);
    }

    @Override // A.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f21338z & 8) == 0) {
            return false;
        }
        if (this.f21303A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f21305C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f21326n.f(this);
        }
        return false;
    }

    public int e() {
        return this.f21308F;
    }

    @Override // A.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!k()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f21305C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f21326n.k(this);
        }
        return false;
    }

    public int f() {
        return this.f21316d;
    }

    char g() {
        return this.f21326n.F() ? this.f21322j : this.f21320h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // A.b, android.view.MenuItem
    public View getActionView() {
        View view = this.f21303A;
        if (view != null) {
            return view;
        }
        AbstractC0457b abstractC0457b = this.f21304B;
        if (abstractC0457b == null) {
            return null;
        }
        View viewD = abstractC0457b.d(this);
        this.f21303A = viewD;
        return viewD;
    }

    @Override // A.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f21323k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f21322j;
    }

    @Override // A.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f21330r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f21314b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f21324l;
        if (drawable != null) {
            return d(drawable);
        }
        if (this.f21325m == 0) {
            return null;
        }
        Drawable drawableC = C0441k.b().c(this.f21326n.u(), this.f21325m);
        this.f21325m = 0;
        this.f21324l = drawableC;
        return d(drawableC);
    }

    @Override // A.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f21332t;
    }

    @Override // A.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f21333u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f21319g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f21313a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f21307E;
    }

    @Override // A.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f21321i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f21320h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f21315c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f21327o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f21317e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f21318f;
        return charSequence != null ? charSequence : this.f21317e;
    }

    @Override // A.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f21331s;
    }

    String h() {
        char cG = g();
        if (cG == 0) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder(f21299K);
        if (cG == '\b') {
            sb.append(f21301M);
        } else if (cG == '\n') {
            sb.append(f21300L);
        } else if (cG != ' ') {
            sb.append(cG);
        } else {
            sb.append(f21302Q);
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f21327o != null;
    }

    public ColorStateList i() {
        return this.f21309G;
    }

    @Override // A.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f21306D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f21337y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f21337y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f21337y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        AbstractC0457b abstractC0457b = this.f21304B;
        return (abstractC0457b == null || !abstractC0457b.g()) ? (this.f21337y & 8) == 0 : (this.f21337y & 8) == 0 && this.f21304B.b();
    }

    CharSequence j(i.a aVar) {
        return (aVar == null || !aVar.c()) ? getTitle() : getTitleCondensed();
    }

    public boolean k() {
        AbstractC0457b abstractC0457b;
        if ((this.f21338z & 8) != 0) {
            if (this.f21303A == null && (abstractC0457b = this.f21304B) != null) {
                this.f21303A = abstractC0457b.d(this);
            }
            if (this.f21303A != null) {
                return true;
            }
        }
        return false;
    }

    public boolean l() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f21329q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        d dVar = this.f21326n;
        if (dVar.h(dVar, this)) {
            return true;
        }
        Runnable runnable = this.f21328p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f21319g != null) {
            try {
                this.f21326n.u().startActivity(this.f21319g);
                return true;
            } catch (ActivityNotFoundException e6) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e6);
            }
        }
        AbstractC0457b abstractC0457b = this.f21304B;
        return abstractC0457b != null && abstractC0457b.e();
    }

    public boolean m() {
        return (this.f21337y & 32) == 32;
    }

    public boolean n() {
        return (this.f21337y & 4) != 0;
    }

    public boolean o() {
        return this.f21312J;
    }

    public boolean p() {
        return this.f21311I;
    }

    public boolean q() {
        return (this.f21337y & 64) != 0;
    }

    public boolean r() {
        return (this.f21338z & 1) == 1;
    }

    public boolean s() {
        return (this.f21338z & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6) {
        if (this.f21322j == c6) {
            return this;
        }
        this.f21322j = Character.toLowerCase(c6);
        this.f21326n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z5) {
        int i5 = this.f21337y;
        int i6 = (z5 ? 1 : 0) | (i5 & (-2));
        this.f21337y = i6;
        if (i5 != i6) {
            this.f21326n.J(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z5) {
        if ((this.f21337y & 4) != 0) {
            this.f21326n.S(this);
            return this;
        }
        w(z5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z5) {
        if (z5) {
            this.f21337y |= 16;
        } else {
            this.f21337y &= -17;
        }
        this.f21326n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f21325m = 0;
        this.f21324l = drawable;
        this.f21336x = true;
        this.f21326n.J(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f21332t = colorStateList;
        this.f21334v = true;
        this.f21336x = true;
        this.f21326n.J(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f21333u = mode;
        this.f21335w = true;
        this.f21336x = true;
        this.f21326n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f21319g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c6) {
        if (this.f21320h == c6) {
            return this;
        }
        this.f21320h = c6;
        this.f21326n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f21305C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f21329q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7) {
        this.f21320h = c6;
        this.f21322j = Character.toLowerCase(c7);
        this.f21326n.J(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public void setShowAsAction(int i5) {
        int i6 = i5 & 3;
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f21338z = i5;
        this.f21326n.H(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f21317e = charSequence;
        this.f21326n.J(false);
        j jVar = this.f21327o;
        if (jVar != null) {
            jVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f21318f = charSequence;
        this.f21326n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z5) {
        if (C(z5)) {
            this.f21326n.I(this);
        }
        return this;
    }

    @Override // A.b, android.view.MenuItem
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public A.b setActionView(int i5) {
        Context contextU = this.f21326n.u();
        setActionView(LayoutInflater.from(contextU).inflate(i5, (ViewGroup) new LinearLayout(contextU), false));
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f21317e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // A.b, android.view.MenuItem
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public A.b setActionView(View view) {
        int i5;
        this.f21303A = view;
        this.f21304B = null;
        if (view != null && view.getId() == -1 && (i5 = this.f21313a) > 0) {
            view.setId(i5);
        }
        this.f21326n.H(this);
        return this;
    }

    public void v(boolean z5) {
        this.f21306D = z5;
        this.f21326n.J(false);
    }

    void w(boolean z5) {
        int i5 = this.f21337y;
        int i6 = (z5 ? 2 : 0) | (i5 & (-3));
        this.f21337y = i6;
        if (i5 != i6) {
            this.f21326n.J(false);
        }
    }

    public void x(boolean z5) {
        this.f21337y = (z5 ? 4 : 0) | (this.f21337y & (-5));
    }

    public void y(boolean z5) {
        if (z5) {
            this.f21337y |= 32;
        } else {
            this.f21337y &= -33;
        }
    }

    void z(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f21307E = contextMenuInfo;
    }

    @Override // A.b, android.view.MenuItem
    public A.b setContentDescription(CharSequence charSequence) {
        this.f21330r = charSequence;
        this.f21326n.J(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public A.b setTooltipText(CharSequence charSequence) {
        this.f21331s = charSequence;
        this.f21326n.J(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6, int i5) {
        if (this.f21322j == c6 && this.f21323k == i5) {
            return this;
        }
        this.f21322j = Character.toLowerCase(c6);
        this.f21323k = KeyEvent.normalizeMetaState(i5);
        this.f21326n.J(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c6, int i5) {
        if (this.f21320h == c6 && this.f21321i == i5) {
            return this;
        }
        this.f21320h = c6;
        this.f21321i = KeyEvent.normalizeMetaState(i5);
        this.f21326n.J(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7, int i5, int i6) {
        this.f21320h = c6;
        this.f21321i = KeyEvent.normalizeMetaState(i5);
        this.f21322j = Character.toLowerCase(c7);
        this.f21323k = KeyEvent.normalizeMetaState(i6);
        this.f21326n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i5) {
        this.f21324l = null;
        this.f21325m = i5;
        this.f21336x = true;
        this.f21326n.J(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i5) {
        return setTitle(this.f21326n.u().getString(i5));
    }
}
