package L3;

import K.AbstractC0072d;
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
import stepos.support.v7.app.C0872q;

/* loaded from: classes2.dex */
public final class l implements F.b, g {

    /* renamed from: A, reason: collision with root package name */
    public AbstractC0072d f1302A;

    /* renamed from: B, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f1303B;

    /* renamed from: a, reason: collision with root package name */
    public final int f1305a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1306b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1307c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1308d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f1309e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f1310f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f1311g;

    /* renamed from: h, reason: collision with root package name */
    public char f1312h;

    /* renamed from: j, reason: collision with root package name */
    public char f1314j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f1316l;

    /* renamed from: n, reason: collision with root package name */
    public final k f1318n;

    /* renamed from: o, reason: collision with root package name */
    public A f1319o;

    /* renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f1320p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f1321q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f1322r;

    /* renamed from: y, reason: collision with root package name */
    public int f1329y;

    /* renamed from: z, reason: collision with root package name */
    public View f1330z;

    /* renamed from: i, reason: collision with root package name */
    public int f1313i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f1315k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f1317m = 0;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f1323s = null;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f1324t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1325u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1326v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1327w = false;

    /* renamed from: x, reason: collision with root package name */
    public int f1328x = 16;

    /* renamed from: C, reason: collision with root package name */
    public boolean f1304C = false;

    public l(k kVar, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8) {
        this.f1318n = kVar;
        this.f1305a = i5;
        this.f1306b = i4;
        this.f1307c = i6;
        this.f1308d = i7;
        this.f1309e = charSequence;
        this.f1329y = i8;
    }

    @Override // F.b
    public final AbstractC0072d a() {
        return this.f1302A;
    }

    @Override // F.b
    public final F.b b(AbstractC0072d abstractC0072d) {
        AbstractC0072d abstractC0072d2 = this.f1302A;
        if (abstractC0072d2 != null) {
            abstractC0072d2.getClass();
        }
        this.f1330z = null;
        this.f1302A = abstractC0072d;
        this.f1318n.o(true);
        AbstractC0072d abstractC0072d3 = this.f1302A;
        if (abstractC0072d3 != null) {
            abstractC0072d3.g(new C0872q(7, this));
        }
        return this;
    }

    public final Drawable c(Drawable drawable) {
        if (drawable != null && this.f1327w && (this.f1325u || this.f1326v)) {
            drawable = drawable.mutate();
            if (this.f1325u) {
                E.a.h(drawable, this.f1323s);
            }
            if (this.f1326v) {
                E.a.i(drawable, this.f1324t);
            }
            this.f1327w = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f1329y & 8) == 0) {
            return false;
        }
        if (this.f1330z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1303B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1318n.d(this);
        }
        return false;
    }

    public final boolean d() {
        AbstractC0072d abstractC0072d;
        if ((this.f1329y & 8) == 0) {
            return false;
        }
        if (this.f1330z == null && (abstractC0072d = this.f1302A) != null) {
            this.f1330z = abstractC0072d.c(this);
        }
        return this.f1330z != null;
    }

    public final boolean e() {
        return (this.f1328x & 32) == 32;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!d()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1303B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1318n.f(this);
        }
        return false;
    }

    public final void f(boolean z4) {
        if (z4) {
            this.f1328x |= 32;
        } else {
            this.f1328x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f1330z;
        if (view != null) {
            return view;
        }
        AbstractC0072d abstractC0072d = this.f1302A;
        if (abstractC0072d == null) {
            return null;
        }
        View viewC = abstractC0072d.c(this);
        this.f1330z = viewC;
        return viewC;
    }

    @Override // F.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f1315k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f1314j;
    }

    @Override // F.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f1321q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f1306b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f1316l;
        if (drawable != null) {
            return c(drawable);
        }
        if (this.f1317m == 0) {
            return null;
        }
        Drawable drawableB = androidx.appcompat.widget.A.a().b(this.f1318n.f1281a, this.f1317m);
        this.f1317m = 0;
        this.f1316l = drawableB;
        return c(drawableB);
    }

    @Override // F.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f1323s;
    }

    @Override // F.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f1324t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f1311g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f1305a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // F.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f1313i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f1312h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f1307c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f1319o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f1309e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1310f;
        return charSequence != null ? charSequence : this.f1309e;
    }

    @Override // F.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f1322r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f1319o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f1304C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f1328x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f1328x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f1328x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        AbstractC0072d abstractC0072d = this.f1302A;
        return (abstractC0072d == null || !abstractC0072d.f()) ? (this.f1328x & 8) == 0 : (this.f1328x & 8) == 0 && this.f1302A.b();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i4;
        this.f1330z = view;
        this.f1302A = null;
        if (view != null && view.getId() == -1 && (i4 = this.f1305a) > 0) {
            view.setId(i4);
        }
        k kVar = this.f1318n;
        kVar.f1290j = true;
        kVar.o(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4) {
        if (this.f1314j == c4) {
            return this;
        }
        this.f1314j = Character.toLowerCase(c4);
        this.f1318n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        int i4 = this.f1328x;
        int i5 = (z4 ? 1 : 0) | (i4 & (-2));
        this.f1328x = i5;
        if (i4 != i5) {
            this.f1318n.o(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        int i4 = this.f1328x;
        if ((i4 & 4) != 0) {
            k kVar = this.f1318n;
            kVar.getClass();
            ArrayList arrayList = kVar.f1285e;
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                l lVar = (l) arrayList.get(i5);
                if (lVar.f1306b == this.f1306b && (lVar.f1328x & 4) != 0 && lVar.isCheckable()) {
                    boolean z5 = lVar == this;
                    int i6 = lVar.f1328x;
                    int i7 = (z5 ? 2 : 0) | (i6 & (-3));
                    lVar.f1328x = i7;
                    if (i6 != i7) {
                        lVar.f1318n.o(false);
                    }
                }
            }
        } else {
            int i8 = (i4 & (-3)) | (z4 ? 2 : 0);
            this.f1328x = i8;
            if (i4 != i8) {
                this.f1318n.o(false);
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
            this.f1328x |= 16;
        } else {
            this.f1328x &= -17;
        }
        this.f1318n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i4) {
        this.f1316l = null;
        this.f1317m = i4;
        this.f1327w = true;
        this.f1318n.o(false);
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1323s = colorStateList;
        this.f1325u = true;
        this.f1327w = true;
        this.f1318n.o(false);
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1324t = mode;
        this.f1326v = true;
        this.f1327w = true;
        this.f1318n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f1311g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4) {
        if (this.f1312h == c4) {
            return this;
        }
        this.f1312h = c4;
        this.f1318n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1303B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1320p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5) {
        this.f1312h = c4;
        this.f1314j = Character.toLowerCase(c5);
        this.f1318n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i4) {
        int i5 = i4 & 3;
        if (i5 != 0 && i5 != 1 && i5 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f1329y = i4;
        k kVar = this.f1318n;
        kVar.f1290j = true;
        kVar.o(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i4) {
        setShowAsAction(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f1309e = charSequence;
        this.f1318n.o(false);
        A a4 = this.f1319o;
        if (a4 != null) {
            a4.t(charSequence, null, null);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1310f = charSequence;
        this.f1318n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        int i4 = this.f1328x;
        int i5 = (z4 ? 0 : 8) | (i4 & (-9));
        this.f1328x = i5;
        if (i4 != i5) {
            k kVar = this.f1318n;
            kVar.f1287g = true;
            kVar.o(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f1309e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // F.b, android.view.MenuItem
    public final F.b setContentDescription(CharSequence charSequence) {
        this.f1321q = charSequence;
        this.f1318n.o(false);
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final F.b setTooltipText(CharSequence charSequence) {
        this.f1322r = charSequence;
        this.f1318n.o(false);
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4, int i4) {
        if (this.f1314j == c4 && this.f1315k == i4) {
            return this;
        }
        this.f1314j = Character.toLowerCase(c4);
        this.f1315k = KeyEvent.normalizeMetaState(i4);
        this.f1318n.o(false);
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4, int i4) {
        if (this.f1312h == c4 && this.f1313i == i4) {
            return this;
        }
        this.f1312h = c4;
        this.f1313i = KeyEvent.normalizeMetaState(i4);
        this.f1318n.o(false);
        return this;
    }

    @Override // F.b, android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5, int i4, int i5) {
        this.f1312h = c4;
        this.f1313i = KeyEvent.normalizeMetaState(i4);
        this.f1314j = Character.toLowerCase(c5);
        this.f1315k = KeyEvent.normalizeMetaState(i5);
        this.f1318n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i4) {
        setTitle(this.f1318n.f1281a.getString(i4));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f1317m = 0;
        this.f1316l = drawable;
        this.f1327w = true;
        this.f1318n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i4) {
        int i5;
        Context context = this.f1318n.f1281a;
        View viewInflate = LayoutInflater.from(context).inflate(i4, (ViewGroup) new LinearLayout(context), false);
        this.f1330z = viewInflate;
        this.f1302A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i5 = this.f1305a) > 0) {
            viewInflate.setId(i5);
        }
        k kVar = this.f1318n;
        kVar.f1290j = true;
        kVar.o(true);
        return this;
    }
}
