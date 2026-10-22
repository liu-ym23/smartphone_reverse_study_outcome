package k;

import K.AbstractC0072d;
import Z2.I;
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
import d.C0527a;
import java.util.ArrayList;

/* renamed from: k.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0663q implements F.b {

    /* renamed from: A, reason: collision with root package name */
    public AbstractC0072d f13266A;

    /* renamed from: B, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f13267B;

    /* renamed from: a, reason: collision with root package name */
    public final int f13269a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13270b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13271c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13272d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f13273e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f13274f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f13275g;

    /* renamed from: h, reason: collision with root package name */
    public char f13276h;

    /* renamed from: j, reason: collision with root package name */
    public char f13278j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f13280l;

    /* renamed from: n, reason: collision with root package name */
    public final C0661o f13282n;

    /* renamed from: o, reason: collision with root package name */
    public SubMenuC0646G f13283o;

    /* renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f13284p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f13285q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f13286r;

    /* renamed from: y, reason: collision with root package name */
    public int f13293y;

    /* renamed from: z, reason: collision with root package name */
    public View f13294z;

    /* renamed from: i, reason: collision with root package name */
    public int f13277i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f13279k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f13281m = 0;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f13287s = null;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f13288t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13289u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f13290v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f13291w = false;

    /* renamed from: x, reason: collision with root package name */
    public int f13292x = 16;

    /* renamed from: C, reason: collision with root package name */
    public boolean f13268C = false;

    public C0663q(C0661o c0661o, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8) {
        this.f13282n = c0661o;
        this.f13269a = i5;
        this.f13270b = i4;
        this.f13271c = i6;
        this.f13272d = i7;
        this.f13273e = charSequence;
        this.f13293y = i8;
    }

    public static void c(StringBuilder sb, int i4, int i5, String str) {
        if ((i4 & i5) == i5) {
            sb.append(str);
        }
    }

    @Override // F.b
    public final AbstractC0072d a() {
        return this.f13266A;
    }

    @Override // F.b
    public final F.b b(AbstractC0072d abstractC0072d) {
        AbstractC0072d abstractC0072d2 = this.f13266A;
        if (abstractC0072d2 != null) {
            abstractC0072d2.getClass();
        }
        this.f13294z = null;
        this.f13266A = abstractC0072d;
        this.f13282n.p(true);
        AbstractC0072d abstractC0072d3 = this.f13266A;
        if (abstractC0072d3 != null) {
            abstractC0072d3.g(new C0527a(4, this));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f13293y & 8) == 0) {
            return false;
        }
        if (this.f13294z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f13267B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f13282n.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f13291w && (this.f13289u || this.f13290v)) {
            drawable = drawable.mutate();
            if (this.f13289u) {
                E.a.h(drawable, this.f13287s);
            }
            if (this.f13290v) {
                E.a.i(drawable, this.f13288t);
            }
            this.f13291w = false;
        }
        return drawable;
    }

    public final boolean e() {
        AbstractC0072d abstractC0072d;
        if ((this.f13293y & 8) == 0) {
            return false;
        }
        if (this.f13294z == null && (abstractC0072d = this.f13266A) != null) {
            this.f13294z = abstractC0072d.c(this);
        }
        return this.f13294z != null;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f13267B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f13282n.f(this);
        }
        return false;
    }

    public final boolean f() {
        return (this.f13292x & 32) == 32;
    }

    public final void g(boolean z4) {
        if (z4) {
            this.f13292x |= 32;
        } else {
            this.f13292x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f13294z;
        if (view != null) {
            return view;
        }
        AbstractC0072d abstractC0072d = this.f13266A;
        if (abstractC0072d == null) {
            return null;
        }
        View viewC = abstractC0072d.c(this);
        this.f13294z = viewC;
        return viewC;
    }

    @Override // F.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f13279k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f13278j;
    }

    @Override // F.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f13285q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f13270b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f13280l;
        if (drawable != null) {
            return d(drawable);
        }
        int i4 = this.f13281m;
        if (i4 == 0) {
            return null;
        }
        Drawable drawableO = I.o(this.f13282n.f13238a, i4);
        this.f13281m = 0;
        this.f13280l = drawableO;
        return d(drawableO);
    }

    @Override // F.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f13287s;
    }

    @Override // F.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f13288t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f13275g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f13269a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // F.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f13277i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f13276h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f13271c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f13283o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f13273e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f13274f;
        return charSequence != null ? charSequence : this.f13273e;
    }

    @Override // F.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f13286r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f13283o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f13268C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f13292x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f13292x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f13292x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        AbstractC0072d abstractC0072d = this.f13266A;
        return (abstractC0072d == null || !abstractC0072d.f()) ? (this.f13292x & 8) == 0 : (this.f13292x & 8) == 0 && this.f13266A.b();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i4;
        this.f13294z = view;
        this.f13266A = null;
        if (view != null && view.getId() == -1 && (i4 = this.f13269a) > 0) {
            view.setId(i4);
        }
        C0661o c0661o = this.f13282n;
        c0661o.f13248k = true;
        c0661o.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4) {
        if (this.f13278j == c4) {
            return this;
        }
        this.f13278j = Character.toLowerCase(c4);
        this.f13282n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        int i4 = this.f13292x;
        int i5 = (z4 ? 1 : 0) | (i4 & (-2));
        this.f13292x = i5;
        if (i4 != i5) {
            this.f13282n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        int i4 = this.f13292x;
        if ((i4 & 4) != 0) {
            C0661o c0661o = this.f13282n;
            c0661o.getClass();
            ArrayList arrayList = c0661o.f13243f;
            int size = arrayList.size();
            c0661o.w();
            for (int i5 = 0; i5 < size; i5++) {
                C0663q c0663q = (C0663q) arrayList.get(i5);
                if (c0663q.f13270b == this.f13270b && (c0663q.f13292x & 4) != 0 && c0663q.isCheckable()) {
                    boolean z5 = c0663q == this;
                    int i6 = c0663q.f13292x;
                    int i7 = (z5 ? 2 : 0) | (i6 & (-3));
                    c0663q.f13292x = i7;
                    if (i6 != i7) {
                        c0663q.f13282n.p(false);
                    }
                }
            }
            c0661o.v();
        } else {
            int i8 = (i4 & (-3)) | (z4 ? 2 : 0);
            this.f13292x = i8;
            if (i4 != i8) {
                this.f13282n.p(false);
            }
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        if (z4) {
            this.f13292x |= 16;
        } else {
            this.f13292x &= -17;
        }
        this.f13282n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i4) {
        this.f13280l = null;
        this.f13281m = i4;
        this.f13291w = true;
        this.f13282n.p(false);
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f13287s = colorStateList;
        this.f13289u = true;
        this.f13291w = true;
        this.f13282n.p(false);
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f13288t = mode;
        this.f13290v = true;
        this.f13291w = true;
        this.f13282n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f13275g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4) {
        if (this.f13276h == c4) {
            return this;
        }
        this.f13276h = c4;
        this.f13282n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f13267B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f13284p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5) {
        this.f13276h = c4;
        this.f13278j = Character.toLowerCase(c5);
        this.f13282n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i4) {
        int i5 = i4 & 3;
        if (i5 != 0 && i5 != 1 && i5 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f13293y = i4;
        C0661o c0661o = this.f13282n;
        c0661o.f13248k = true;
        c0661o.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i4) {
        setShowAsAction(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f13273e = charSequence;
        this.f13282n.p(false);
        SubMenuC0646G subMenuC0646G = this.f13283o;
        if (subMenuC0646G != null) {
            subMenuC0646G.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f13274f = charSequence;
        this.f13282n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        int i4 = this.f13292x;
        int i5 = (z4 ? 0 : 8) | (i4 & (-9));
        this.f13292x = i5;
        if (i4 != i5) {
            C0661o c0661o = this.f13282n;
            c0661o.f13245h = true;
            c0661o.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f13273e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // F.b, android.view.MenuItem
    public final F.b setContentDescription(CharSequence charSequence) {
        this.f13285q = charSequence;
        this.f13282n.p(false);
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final F.b setTooltipText(CharSequence charSequence) {
        this.f13286r = charSequence;
        this.f13282n.p(false);
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4, int i4) {
        if (this.f13278j == c4 && this.f13279k == i4) {
            return this;
        }
        this.f13278j = Character.toLowerCase(c4);
        this.f13279k = KeyEvent.normalizeMetaState(i4);
        this.f13282n.p(false);
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4, int i4) {
        if (this.f13276h == c4 && this.f13277i == i4) {
            return this;
        }
        this.f13276h = c4;
        this.f13277i = KeyEvent.normalizeMetaState(i4);
        this.f13282n.p(false);
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5, int i4, int i5) {
        this.f13276h = c4;
        this.f13277i = KeyEvent.normalizeMetaState(i4);
        this.f13278j = Character.toLowerCase(c5);
        this.f13279k = KeyEvent.normalizeMetaState(i5);
        this.f13282n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i4) {
        setTitle(this.f13282n.f13238a.getString(i4));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f13281m = 0;
        this.f13280l = drawable;
        this.f13291w = true;
        this.f13282n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i4) {
        int i5;
        Context context = this.f13282n.f13238a;
        View viewInflate = LayoutInflater.from(context).inflate(i4, (ViewGroup) new LinearLayout(context), false);
        this.f13294z = viewInflate;
        this.f13266A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i5 = this.f13269a) > 0) {
            viewInflate.setId(i5);
        }
        C0661o c0661o = this.f13282n;
        c0661o.f13248k = true;
        c0661o.p(true);
        return this;
    }
}
