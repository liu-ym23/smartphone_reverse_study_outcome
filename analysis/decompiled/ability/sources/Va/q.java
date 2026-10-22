package Va;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class q implements SupportMenuItem, i {

    /* renamed from: A, reason: collision with root package name */
    public ActionProvider f1450A;

    /* renamed from: B, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f1451B;

    /* renamed from: a, reason: collision with root package name */
    public final int f1453a;
    public final int b;
    public final int c;
    public final int d;
    public CharSequence e;
    public CharSequence f;
    public Intent g;
    public char h;

    /* renamed from: j, reason: collision with root package name */
    public char f1454j;
    public Drawable l;
    public final n n;
    public F o;
    public MenuItem.OnMenuItemClickListener p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f1455q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f1456r;
    public int y;

    /* renamed from: z, reason: collision with root package name */
    public View f1462z;
    public int i = 4096;
    public int k = 4096;
    public int m = 0;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f1457s = null;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f1458t = null;
    public boolean u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1459v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1460w = false;

    /* renamed from: x, reason: collision with root package name */
    public int f1461x = 16;

    /* renamed from: C, reason: collision with root package name */
    public boolean f1452C = false;

    public q(n nVar, int i, int i6, int i10, int i11, CharSequence charSequence, int i12) {
        this.n = nVar;
        this.f1453a = i6;
        this.b = i;
        this.c = i10;
        this.d = i11;
        this.e = charSequence;
        this.y = i12;
    }

    public final Drawable a(Drawable drawable) {
        if (drawable != null && this.f1460w && (this.u || this.f1459v)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (this.u) {
                DrawableCompat.setTintList(drawable, this.f1457s);
            }
            if (this.f1459v) {
                DrawableCompat.setTintMode(drawable, this.f1458t);
            }
            this.f1460w = false;
        }
        return drawable;
    }

    public final boolean b() {
        ActionProvider actionProvider;
        if ((this.y & 8) != 0) {
            if (this.f1462z == null && (actionProvider = this.f1450A) != null) {
                this.f1462z = actionProvider.onCreateActionView(this);
            }
            if (this.f1462z != null) {
                return true;
            }
        }
        return false;
    }

    public final void c(boolean z10) {
        if (z10) {
            this.f1461x |= 32;
        } else {
            this.f1461x &= -33;
        }
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.f1462z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1451B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.d(this);
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final boolean expandActionView() {
        if (!b()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1451B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.f(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final View getActionView() {
        View view = this.f1462z;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.f1450A;
        if (actionProvider == null) {
            return null;
        }
        View viewOnCreateActionView = actionProvider.onCreateActionView(this);
        this.f1462z = viewOnCreateActionView;
        return viewOnCreateActionView;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f1454j;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f1455q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return a(drawable);
        }
        if (this.m == 0) {
            return null;
        }
        Drawable drawable2 = AppCompatDrawableManager.get().getDrawable(this.n.f1442a, this.m);
        this.m = 0;
        this.l = drawable2;
        return a(drawable2);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f1457s;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f1458t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f1453a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.o;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final ActionProvider getSupportActionProvider() {
        return this.f1450A;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        return charSequence != null ? charSequence : this.e;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f1456r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.o != null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f1452C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f1461x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f1461x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f1461x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        ActionProvider actionProvider = this.f1450A;
        return (actionProvider == null || !actionProvider.overridesItemVisibility()) ? (this.f1461x & 8) == 0 : (this.f1461x & 8) == 0 && this.f1450A.isVisible();
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final boolean requiresActionButton() {
        return (this.y & 2) == 2;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final boolean requiresOverflow() {
        return (requiresActionButton() || (this.y & 1) == 1) ? false : true;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i;
        this.f1462z = view;
        this.f1450A = null;
        if (view != null && view.getId() == -1 && (i = this.f1453a) > 0) {
            view.setId(i);
        }
        n nVar = this.n;
        nVar.f1443j = true;
        nVar.o(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.f1454j == c) {
            return this;
        }
        this.f1454j = Character.toLowerCase(c);
        this.n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z10) {
        int i = this.f1461x;
        int i6 = (z10 ? 1 : 0) | (i & (-2));
        this.f1461x = i6;
        if (i != i6) {
            this.n.o(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z10) {
        int i = this.f1461x;
        if ((i & 4) != 0) {
            ArrayList arrayList = this.n.e;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                q qVar = (q) arrayList.get(i6);
                if (qVar.b == this.b && (qVar.f1461x & 4) != 0 && qVar.isCheckable()) {
                    boolean z11 = qVar == this;
                    int i10 = qVar.f1461x;
                    int i11 = (z11 ? 2 : 0) | (i10 & (-3));
                    qVar.f1461x = i11;
                    if (i10 != i11) {
                        qVar.n.o(false);
                    }
                }
            }
        } else {
            int i12 = (i & (-3)) | (z10 ? 2 : 0);
            this.f1461x = i12;
            if (i != i12) {
                this.n.o(false);
            }
        }
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f1461x |= 16;
        } else {
            this.f1461x &= -17;
        }
        this.n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.l = drawable;
        this.f1460w = true;
        this.n.o(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1457s = colorStateList;
        this.u = true;
        this.f1460w = true;
        this.n.o(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1458t = mode;
        this.f1459v = true;
        this.f1460w = true;
        this.n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        if (this.h == c) {
            return this;
        }
        this.h = c;
        this.n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1451B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2) {
        this.h = c;
        this.f1454j = Character.toLowerCase(c2);
        this.n.o(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final void setShowAsAction(int i) {
        int i6 = i & 3;
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.y = i;
        n nVar = this.n;
        nVar.f1443j = true;
        nVar.o(true);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.f1450A;
        if (actionProvider2 != null) {
            actionProvider2.reset();
        }
        this.f1462z = null;
        this.f1450A = actionProvider;
        this.n.o(true);
        ActionProvider actionProvider3 = this.f1450A;
        if (actionProvider3 != null) {
            actionProvider3.setVisibilityListener(new p(this));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.n.o(false);
        F f = this.o;
        if (f != null) {
            f.t(charSequence, null, null);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        this.n.o(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z10) {
        int i = this.f1461x;
        int i6 = (z10 ? 0 : 8) | (i & (-9));
        this.f1461x = i6;
        if (i != i6) {
            n nVar = this.n;
            nVar.g = true;
            nVar.o(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f1455q = charSequence;
        this.n.o(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f1456r = charSequence;
        this.n.o(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f1454j == c && this.k == i) {
            return this;
        }
        this.f1454j = Character.toLowerCase(c);
        this.k = KeyEvent.normalizeMetaState(i);
        this.n.o(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int i) {
        if (this.h == c && this.i == i) {
            return this;
        }
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i);
        this.n.o(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2, int i, int i6) {
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f1454j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState(i6);
        this.n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.l = null;
        this.m = i;
        this.f1460w = true;
        this.n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        setTitle(this.n.f1442a.getString(i));
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setActionView(int i) {
        int i6;
        Context context = this.n.f1442a;
        View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false);
        this.f1462z = viewInflate;
        this.f1450A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i6 = this.f1453a) > 0) {
            viewInflate.setId(i6);
        }
        n nVar = this.n;
        nVar.f1443j = true;
        nVar.o(true);
        return this;
    }
}
