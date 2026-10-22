package c5;

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
import androidx.core.view.AbstractC0457b;
import androidx.recyclerview.widget.RecyclerView;
import stepos.support.v7.app.a;

/* loaded from: classes.dex */
public class b implements A.b {

    /* renamed from: a, reason: collision with root package name */
    private final int f11981a;

    /* renamed from: b, reason: collision with root package name */
    private final int f11982b;

    /* renamed from: c, reason: collision with root package name */
    private final int f11983c;

    /* renamed from: d, reason: collision with root package name */
    private final int f11984d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f11985e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f11986f;

    /* renamed from: g, reason: collision with root package name */
    private Intent f11987g;

    /* renamed from: h, reason: collision with root package name */
    private char f11988h;

    /* renamed from: i, reason: collision with root package name */
    private int f11989i;

    /* renamed from: j, reason: collision with root package name */
    private char f11990j;

    /* renamed from: k, reason: collision with root package name */
    private int f11991k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f11992l;

    /* renamed from: m, reason: collision with root package name */
    private int f11993m;

    /* renamed from: n, reason: collision with root package name */
    private Context f11994n;

    /* renamed from: o, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f11995o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f11996p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f11997q;

    /* renamed from: r, reason: collision with root package name */
    private ColorStateList f11998r;

    /* renamed from: s, reason: collision with root package name */
    private PorterDuff.Mode f11999s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f12000t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f12001u;

    /* renamed from: v, reason: collision with root package name */
    private int f12002v;

    /* renamed from: w, reason: collision with root package name */
    private a.InterfaceC0240a f12003w;

    public b(Context context, int i5, int i6, int i7, int i8, CharSequence charSequence) {
        this.f11989i = RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;
        this.f11991k = RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;
        this.f11993m = 0;
        this.f11998r = null;
        this.f11999s = null;
        this.f12000t = false;
        this.f12001u = false;
        this.f12002v = 16;
        this.f12003w = null;
        this.f11994n = context;
        this.f11981a = i6;
        this.f11982b = i5;
        this.f11983c = i7;
        this.f11984d = i8;
        this.f11985e = charSequence;
    }

    private void c() {
        Drawable drawable = this.f11992l;
        if (drawable != null && (this.f12000t || this.f12001u)) {
            Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable);
            this.f11992l = drawableR;
            Drawable drawableMutate = drawableR.mutate();
            this.f11992l = drawableMutate;
            if (this.f12000t) {
                androidx.core.graphics.drawable.a.o(drawableMutate, this.f11998r);
            }
            if (this.f12001u) {
                androidx.core.graphics.drawable.a.p(this.f11992l, this.f11999s);
            }
        }
        this.f12003w.setIcon(this.f11992l);
    }

    @Override // A.b
    public A.b a(AbstractC0457b abstractC0457b) {
        throw new UnsupportedOperationException();
    }

    @Override // A.b
    public AbstractC0457b b() {
        return null;
    }

    @Override // A.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // A.b, android.view.MenuItem
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public A.b setActionView(int i5) {
        throw new UnsupportedOperationException();
    }

    @Override // A.b, android.view.MenuItem
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public A.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // A.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // A.b, android.view.MenuItem
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public A.b setShowAsActionFlags(int i5) {
        setShowAsAction(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // A.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // A.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f11991k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f11990j;
    }

    @Override // A.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f11996p;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f11982b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        a.InterfaceC0240a interfaceC0240a = this.f12003w;
        return interfaceC0240a != null ? interfaceC0240a.getIcon() : this.f11992l;
    }

    @Override // A.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f11998r;
    }

    @Override // A.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f11999s;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f11987g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        a.InterfaceC0240a interfaceC0240a = this.f12003w;
        return interfaceC0240a != null ? interfaceC0240a.getId() : this.f11981a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // A.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f11989i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f11988h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f11984d;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        a.InterfaceC0240a interfaceC0240a = this.f12003w;
        return interfaceC0240a != null ? interfaceC0240a.getTitle() : this.f11985e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f11986f;
        return charSequence != null ? charSequence : getTitle();
    }

    @Override // A.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f11997q;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // A.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f12002v & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f12002v & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f12002v & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f12002v & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6) {
        this.f11990j = Character.toLowerCase(c6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z5) {
        this.f12002v = (z5 ? 1 : 0) | (this.f12002v & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z5) {
        this.f12002v = (z5 ? 2 : 0) | (this.f12002v & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z5) {
        this.f12002v = (z5 ? 16 : 0) | (this.f12002v & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f11992l = drawable;
        this.f11993m = 0;
        c();
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f11998r = colorStateList;
        this.f12000t = true;
        c();
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f11999s = mode;
        this.f12001u = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f11987g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c6) {
        this.f11988h = c6;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f11995o = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7) {
        this.f11988h = c6;
        this.f11990j = Character.toLowerCase(c7);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public void setShowAsAction(int i5) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        a.InterfaceC0240a interfaceC0240a = this.f12003w;
        if (interfaceC0240a != null) {
            interfaceC0240a.b(charSequence.toString());
            return this;
        }
        this.f11985e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f11986f = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z5) {
        this.f12002v = (this.f12002v & 8) | (z5 ? 0 : 8);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6, int i5) {
        this.f11990j = Character.toLowerCase(c6);
        this.f11991k = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public A.b setContentDescription(CharSequence charSequence) {
        this.f11996p = charSequence;
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c6, int i5) {
        this.f11988h = c6;
        this.f11989i = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public A.b setTooltipText(CharSequence charSequence) {
        this.f11997q = charSequence;
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7, int i5, int i6) {
        this.f11988h = c6;
        this.f11989i = KeyEvent.normalizeMetaState(i5);
        this.f11990j = Character.toLowerCase(c7);
        this.f11991k = KeyEvent.normalizeMetaState(i6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i5) {
        this.f11993m = i5;
        this.f11992l = androidx.core.content.a.e(this.f11994n, i5);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i5) {
        setTitle(this.f11994n.getResources().getString(i5));
        return this;
    }

    public b(Context context, a.InterfaceC0240a interfaceC0240a) {
        this.f11989i = RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;
        this.f11991k = RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;
        this.f11993m = 0;
        this.f11998r = null;
        this.f11999s = null;
        this.f12000t = false;
        this.f12001u = false;
        this.f12002v = 16;
        this.f11994n = context;
        this.f12003w = interfaceC0240a;
        this.f11981a = -1;
        this.f11982b = 0;
        this.f11983c = 0;
        this.f11984d = 0;
    }
}
