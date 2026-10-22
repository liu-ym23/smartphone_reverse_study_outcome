package l;

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

/* renamed from: l.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0816a implements A.b {

    /* renamed from: a, reason: collision with root package name */
    private final int f17981a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17982b;

    /* renamed from: c, reason: collision with root package name */
    private final int f17983c;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f17984d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f17985e;

    /* renamed from: f, reason: collision with root package name */
    private Intent f17986f;

    /* renamed from: g, reason: collision with root package name */
    private char f17987g;

    /* renamed from: i, reason: collision with root package name */
    private char f17989i;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f17991k;

    /* renamed from: l, reason: collision with root package name */
    private Context f17992l;

    /* renamed from: m, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f17993m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f17994n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f17995o;

    /* renamed from: h, reason: collision with root package name */
    private int f17988h = RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;

    /* renamed from: j, reason: collision with root package name */
    private int f17990j = RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f17996p = null;

    /* renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f17997q = null;

    /* renamed from: r, reason: collision with root package name */
    private boolean f17998r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f17999s = false;

    /* renamed from: t, reason: collision with root package name */
    private int f18000t = 16;

    public C0816a(Context context, int i5, int i6, int i7, int i8, CharSequence charSequence) {
        this.f17992l = context;
        this.f17981a = i6;
        this.f17982b = i5;
        this.f17983c = i8;
        this.f17984d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f17991k;
        if (drawable != null) {
            if (this.f17998r || this.f17999s) {
                Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable);
                this.f17991k = drawableR;
                Drawable drawableMutate = drawableR.mutate();
                this.f17991k = drawableMutate;
                if (this.f17998r) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f17996p);
                }
                if (this.f17999s) {
                    androidx.core.graphics.drawable.a.p(this.f17991k, this.f17997q);
                }
            }
        }
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
        return this.f17990j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f17989i;
    }

    @Override // A.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f17994n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f17982b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f17991k;
    }

    @Override // A.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f17996p;
    }

    @Override // A.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f17997q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f17986f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f17981a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // A.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f17988h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f17987g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f17983c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f17984d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f17985e;
        return charSequence != null ? charSequence : this.f17984d;
    }

    @Override // A.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f17995o;
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
        return (this.f18000t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f18000t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f18000t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f18000t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6) {
        this.f17989i = Character.toLowerCase(c6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z5) {
        this.f18000t = (z5 ? 1 : 0) | (this.f18000t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z5) {
        this.f18000t = (z5 ? 2 : 0) | (this.f18000t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z5) {
        this.f18000t = (z5 ? 16 : 0) | (this.f18000t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f17991k = drawable;
        c();
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f17996p = colorStateList;
        this.f17998r = true;
        c();
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f17997q = mode;
        this.f17999s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f17986f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c6) {
        this.f17987g = c6;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f17993m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7) {
        this.f17987g = c6;
        this.f17989i = Character.toLowerCase(c7);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public void setShowAsAction(int i5) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f17984d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f17985e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z5) {
        this.f18000t = (this.f18000t & 8) | (z5 ? 0 : 8);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c6, int i5) {
        this.f17989i = Character.toLowerCase(c6);
        this.f17990j = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public A.b setContentDescription(CharSequence charSequence) {
        this.f17994n = charSequence;
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c6, int i5) {
        this.f17987g = c6;
        this.f17988h = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i5) {
        this.f17984d = this.f17992l.getResources().getString(i5);
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public A.b setTooltipText(CharSequence charSequence) {
        this.f17995o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i5) {
        this.f17991k = androidx.core.content.a.e(this.f17992l, i5);
        c();
        return this;
    }

    @Override // A.b, android.view.MenuItem
    public MenuItem setShortcut(char c6, char c7, int i5, int i6) {
        this.f17987g = c6;
        this.f17988h = KeyEvent.normalizeMetaState(i5);
        this.f17989i = Character.toLowerCase(c7);
        this.f17990j = KeyEvent.normalizeMetaState(i6);
        return this;
    }
}
