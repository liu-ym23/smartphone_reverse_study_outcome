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
import androidx.appcompat.view.menu.k;
import androidx.core.view.AbstractC0457b;
import androidx.recyclerview.widget.RecyclerView;
import h.C0744a;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class g implements A.b {

    /* renamed from: A, reason: collision with root package name */
    private View f7906A;

    /* renamed from: B, reason: collision with root package name */
    private AbstractC0457b f7907B;

    /* renamed from: C, reason: collision with root package name */
    private MenuItem.OnActionExpandListener f7908C;

    /* renamed from: E, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f7910E;

    /* renamed from: a, reason: collision with root package name */
    private final int f7911a;

    /* renamed from: b, reason: collision with root package name */
    private final int f7912b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7913c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7914d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f7915e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f7916f;

    /* renamed from: g, reason: collision with root package name */
    private Intent f7917g;

    /* renamed from: h, reason: collision with root package name */
    private char f7918h;

    /* renamed from: j, reason: collision with root package name */
    private char f7920j;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f7922l;

    /* renamed from: n, reason: collision with root package name */
    e f7924n;

    /* renamed from: o, reason: collision with root package name */
    private m f7925o;

    /* renamed from: p, reason: collision with root package name */
    private Runnable f7926p;

    /* renamed from: q, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f7927q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f7928r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f7929s;

    /* renamed from: z, reason: collision with root package name */
    private int f7936z;

    /* renamed from: i, reason: collision with root package name */
    private int f7919i = RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;

    /* renamed from: k, reason: collision with root package name */
    private int f7921k = RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;

    /* renamed from: m, reason: collision with root package name */
    private int f7923m = 0;

    /* renamed from: t, reason: collision with root package name */
    private ColorStateList f7930t = null;

    /* renamed from: u, reason: collision with root package name */
    private PorterDuff.Mode f7931u = null;

    /* renamed from: v, reason: collision with root package name */
    private boolean f7932v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f7933w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f7934x = false;

    /* renamed from: y, reason: collision with root package name */
    private int f7935y = 16;

    /* renamed from: D, reason: collision with root package name */
    private boolean f7909D = false;

    class a implements AbstractC0457b.InterfaceC0123b {
        a() {
        }

        @Override // androidx.core.view.AbstractC0457b.InterfaceC0123b
        public void onActionProviderVisibilityChanged(boolean z5) {
            g gVar = g.this;
            gVar.f7924n.K(gVar);
        }
    }

    g(e eVar, int i5, int i6, int i7, int i8, CharSequence charSequence, int i9) {
        this.f7924n = eVar;
        this.f7911a = i6;
        this.f7912b = i5;
        this.f7913c = i7;
        this.f7914d = i8;
        this.f7915e = charSequence;
        this.f7936z = i9;
    }

    private static void d(StringBuilder sb, int i5, int i6, String str) {
        if ((i5 & i6) == i6) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f7934x && (this.f7932v || this.f7933w)) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (this.f7932v) {
                androidx.core.graphics.drawable.a.o(drawable, this.f7930t);
            }
            if (this.f7933w) {
                androidx.core.graphics.drawable.a.p(drawable, this.f7931u);
            }
            this.f7934x = false;
        }
        return drawable;
    }

    boolean A() {
        return this.f7924n.I() && g() != 0;
    }

    public boolean B() {
        return (this.f7936z & 4) == 4;
    }

    @Override // A.b
    public A.b a(AbstractC0457b abstractC0457b) {
        AbstractC0457b abstractC0457b2 = this.f7907B;
        if (abstractC0457b2 != null) {
            abstractC0457b2.h();
        }
        this.f7906A = null;
        this.f7907B = abstractC0457b;
        this.f7924n.L(true);
        AbstractC0457b abstractC0457b3 = this.f7907B;
        if (abstractC0457b3 != null) {
            abstractC0457b3.j(new a());
        }
        return this;
    }

    @Override // A.b
    public AbstractC0457b b() {
        return this.f7907B;
    }

    public void c() {
        this.f7924n.J(this);
    }

    @Override // A.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f7936z & 8) == 0) {
            return false;
        }
        if (this.f7906A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f7908C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f7924n.f(this);
        }
        return false;
    }

    @Override // A.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f7908C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f7924n.k(this);
        }
        return false;
    }

    public int f() {
        return this.f7914d;
    }

    char g() {
        return this.f7924n.H() ? this.f7920j : this.f7918h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // A.b, android.view.MenuItem
    public View getActionView() {
        View view = this.f7906A;
        if (view != null) {
            return view;
        }
        AbstractC0457b abstractC0457b = this.f7907B;
        if (abstractC0457b == null) {
            return null;
        }
        View viewD = abstractC0457b.d(this);
        this.f7906A = viewD;
        return viewD;
    }

    @Override // A.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f7921k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f7920j;
    }

    @Override // A.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f7928r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f7912b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f7922l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f7923m == 0) {
            return null;
        }
        Drawable drawableB = C0744a.b(this.f7924n.u(), this.f7923m);
        this.f7923m = 0;
        this.f7922l = drawableB;
        return e(drawableB);
    }

    @Override // A.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f7930t;
    }

    @Override // A.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f7931u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f7917g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f7911a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f7910E;
    }

    @Override // A.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f7919i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f7918h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f7913c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f7925o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f7915e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f7916f;
        return charSequence != null ? charSequence : this.f7915e;
    }

    @Override // A.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f7929s;
    }

    String h() {
        char cG = g();
        if (cG == 0) {
            return BuildConfig.FLAVOR;
        }
        Resources resources = this.f7924n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f7924n.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(g.h.f16975n));
        }
        int i5 = this.f7924n.H() ? this.f7921k : this.f7919i;
        d(sb, i5, 65536, resources.getString(g.h.f16971j));
        d(sb, i5, RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT, resources.getString(g.h.f16967f));
        d(sb, i5, 2, resources.getString(g.h.f16966e));
        d(sb, i5, 1, resources.getString(g.h.f16972k));
        d(sb, i5, 4, resources.getString(g.h.f16974m));
        d(sb, i5, 8, resources.getString(g.h.f16970i));
        if (cG == '\b') {
            sb.append(resources.getString(g.h.f16968g));
        } else if (cG == '\n') {
            sb.append(resources.getString(g.h.f16969h));
        } else if (cG != ' ') {
            sb.append(cG);
        } else {
            sb.append(resources.getString(g.h.f16973l));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f7925o != null;
    }

    CharSequence i(k.a aVar) {
        return (aVar == null || !aVar.c()) ? getTitle() : getTitleCondensed();
    }

    @Override // A.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f7909D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f7935y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f7935y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f7935y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        AbstractC0457b abstractC0457b = this.f7907B;
        return (abstractC0457b == null || !abstractC0457b.g()) ? (this.f7935y & 8) == 0 : (this.f7935y & 8) == 0 && this.f7907B.b();
    }

    public boolean j() {
        AbstractC0457b abstractC0457b;
        if ((this.f7936z & 8) != 0) {
            if (this.f7906A == null && (abstractC0457b = this.f7907B) != null) {
                this.f7906A = abstractC0457b.d(this);
            }
            if (this.f7906A != null) {
                return true;
            }
        }
        return false;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f7927q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f7924n;
        if (eVar.h(eVar, this)) {
            return true;
        }
        Runnable runnable = this.f7926p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f7917g != null) {
            try {
                this.f7924n.u().startActivity(this.f7917g);
                return true;
            } catch (ActivityNotFoundException e6) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e6);
            }
        }
        AbstractC0457b abstractC0457b = this.f7907B;
        return abstractC0457b != null && abstractC0457b.e();
    }

    public boolean l() {
        return (this.f7935y & 32) == 32;
    }

    public boolean m() {
        return (this.f7935y & 4) != 0;
    }

    public boolean n() {
        return (this.f7936z & 1) == 1;
    }

    public boolean o() {
        return (this.f7936z & 2) == 2;
    }

    @Override // A.b, android.view.MenuItem
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public A.b setActionView(int i5) {
        Context contextU = this.f7924n.u();
        setActionView(LayoutInflater.from(contextU).inflate(i5, (ViewGroup) new LinearLayout(contextU), false));
        return this;
    }

    @Override // A.b, android.view.MenuItem
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public A.b setActionView(View view) {
        int i5;
        this.f7906A = view;
        this.f7907B = null;
        if (view != null && view.getId() == -1 && (i5 = this.f7911a) > 0) {
            view.setId(i5);
        }
        this.f7924n.J(this);
        return this;
    }

    public void r(boolean z5) {
        this.f7909D = z5;
        this.f7924n.L(false);
    }

    void s(boolean z5) {
        int i5 = this.f7935y;
        int i6 = (z5 ? 2 : 0) | (i5 & (-3));
        this.f7935y = i6;
        if (i5 != i6) {
            this.f7924n.L(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6) {
        if (this.f7920j == c6) {
            return this;
        }
        this.f7920j = Character.toLowerCase(c6);
        this.f7924n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z5) {
        int i5 = this.f7935y;
        int i6 = (z5 ? 1 : 0) | (i5 & (-2));
        this.f7935y = i6;
        if (i5 != i6) {
            this.f7924n.L(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z5) {
        if ((this.f7935y & 4) != 0) {
            this.f7924n.U(this);
            return this;
        }
        s(z5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z5) {
        if (z5) {
            this.f7935y |= 16;
        } else {
            this.f7935y &= -17;
        }
        this.f7924n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f7923m = 0;
        this.f7922l = drawable;
        this.f7934x = true;
        this.f7924n.L(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f7930t = colorStateList;
        this.f7932v = true;
        this.f7934x = true;
        this.f7924n.L(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f7931u = mode;
        this.f7933w = true;
        this.f7934x = true;
        this.f7924n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f7917g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c6) {
        if (this.f7918h == c6) {
            return this;
        }
        this.f7918h = c6;
        this.f7924n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f7908C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f7927q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7) {
        this.f7918h = c6;
        this.f7920j = Character.toLowerCase(c7);
        this.f7924n.L(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public void setShowAsAction(int i5) {
        int i6 = i5 & 3;
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f7936z = i5;
        this.f7924n.J(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f7915e = charSequence;
        this.f7924n.L(false);
        m mVar = this.f7925o;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f7916f = charSequence;
        this.f7924n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z5) {
        if (y(z5)) {
            this.f7924n.K(this);
        }
        return this;
    }

    public void t(boolean z5) {
        this.f7935y = (z5 ? 4 : 0) | (this.f7935y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f7915e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z5) {
        if (z5) {
            this.f7935y |= 32;
        } else {
            this.f7935y &= -33;
        }
    }

    void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f7910E = contextMenuInfo;
    }

    @Override // A.b, android.view.MenuItem
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public A.b setShowAsActionFlags(int i5) {
        setShowAsAction(i5);
        return this;
    }

    public void x(m mVar) {
        this.f7925o = mVar;
        mVar.setHeaderTitle(getTitle());
    }

    boolean y(boolean z5) {
        int i5 = this.f7935y;
        int i6 = (z5 ? 0 : 8) | (i5 & (-9));
        this.f7935y = i6;
        return i5 != i6;
    }

    public boolean z() {
        return this.f7924n.A();
    }

    @Override // A.b, android.view.MenuItem
    public A.b setContentDescription(CharSequence charSequence) {
        this.f7928r = charSequence;
        this.f7924n.L(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public A.b setTooltipText(CharSequence charSequence) {
        this.f7929s = charSequence;
        this.f7924n.L(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6, int i5) {
        if (this.f7920j == c6 && this.f7921k == i5) {
            return this;
        }
        this.f7920j = Character.toLowerCase(c6);
        this.f7921k = KeyEvent.normalizeMetaState(i5);
        this.f7924n.L(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c6, int i5) {
        if (this.f7918h == c6 && this.f7919i == i5) {
            return this;
        }
        this.f7918h = c6;
        this.f7919i = KeyEvent.normalizeMetaState(i5);
        this.f7924n.L(false);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7, int i5, int i6) {
        this.f7918h = c6;
        this.f7919i = KeyEvent.normalizeMetaState(i5);
        this.f7920j = Character.toLowerCase(c7);
        this.f7921k = KeyEvent.normalizeMetaState(i6);
        this.f7924n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i5) {
        this.f7922l = null;
        this.f7923m = i5;
        this.f7934x = true;
        this.f7924n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i5) {
        return setTitle(this.f7924n.u().getString(i5));
    }
}
