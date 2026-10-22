package stepos.support.v7.view.menu;

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
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.j;
import java.util.ArrayList;
import v0.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e implements p0.b, ge.g {
    public int B;
    public View C;
    public v0.b D;
    public MenuItem.OnActionExpandListener E;

    /* renamed from: a, reason: collision with root package name */
    public final int f12397a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12398b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12399c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12400d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f12401e;
    public CharSequence h;

    /* renamed from: j, reason: collision with root package name */
    public Intent f12402j;

    /* renamed from: k, reason: collision with root package name */
    public char f12403k;

    /* renamed from: m, reason: collision with root package name */
    public char f12405m;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f12407o;

    /* renamed from: q, reason: collision with root package name */
    public final c f12409q;
    public i r;

    /* renamed from: s, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f12410s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f12411t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f12412u;

    /* renamed from: l, reason: collision with root package name */
    public int f12404l = 4096;

    /* renamed from: n, reason: collision with root package name */
    public int f12406n = 4096;

    /* renamed from: p, reason: collision with root package name */
    public int f12408p = 0;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f12413v = null;

    /* renamed from: w, reason: collision with root package name */
    public PorterDuff.Mode f12414w = null;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12415x = false;

    /* renamed from: y, reason: collision with root package name */
    public boolean f12416y = false;
    public boolean z = false;
    public int A = 16;
    public boolean F = false;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements b.a {
        public a() {
        }

        @Override // v0.b.a
        public final void a() {
            c cVar = e.this.f12409q;
            cVar.f12379j = true;
            cVar.o(true);
        }
    }

    public e(c cVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f12409q = cVar;
        this.f12397a = i11;
        this.f12398b = i10;
        this.f12399c = i12;
        this.f12400d = i13;
        this.f12401e = charSequence;
        this.B = i14;
    }

    @Override // p0.b
    public final p0.b a(v0.b bVar) {
        v0.b bVar2 = this.D;
        if (bVar2 != null) {
            bVar2.f13252a = null;
        }
        this.C = null;
        this.D = bVar;
        this.f12409q.o(true);
        v0.b bVar3 = this.D;
        if (bVar3 != null) {
            bVar3.h(new a());
        }
        return this;
    }

    @Override // p0.b
    public final v0.b b() {
        return this.D;
    }

    public final Drawable c(Drawable drawable) {
        if (drawable != null && this.z && (this.f12415x || this.f12416y)) {
            drawable = drawable.mutate();
            if (this.f12415x) {
                drawable.setTintList(this.f12413v);
            }
            if (this.f12416y) {
                drawable.setTintMode(this.f12414w);
            }
            this.z = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.B & 8) == 0) {
            return false;
        }
        if (this.C == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.E;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f12409q.d(this);
        }
        return false;
    }

    public final boolean d() {
        v0.b bVar;
        if ((this.B & 8) == 0) {
            return false;
        }
        if (this.C == null && (bVar = this.D) != null) {
            this.C = bVar.d(this);
        }
        return this.C != null;
    }

    public final void e(boolean z) {
        if (z) {
            this.A |= 32;
        } else {
            this.A &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!d()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.E;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f12409q.f(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.C;
        if (view != null) {
            return view;
        }
        v0.b bVar = this.D;
        if (bVar == null) {
            return null;
        }
        View viewD = bVar.d(this);
        this.C = viewD;
        return viewD;
    }

    @Override // p0.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f12406n;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f12405m;
    }

    @Override // p0.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f12411t;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f12398b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f12407o;
        if (drawable != null) {
            return c(drawable);
        }
        if (this.f12408p == 0) {
            return null;
        }
        Drawable drawableB = j.a().b(this.f12408p, this.f12409q.f12374a);
        this.f12408p = 0;
        this.f12407o = drawableB;
        return c(drawableB);
    }

    @Override // p0.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f12413v;
    }

    @Override // p0.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f12414w;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f12402j;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.f12397a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // p0.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f12404l;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f12403k;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f12399c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.r;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.f12401e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.h;
        return charSequence != null ? charSequence : this.f12401e;
    }

    @Override // p0.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f12412u;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.r != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.F;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.A & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.A & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.A & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        v0.b bVar = this.D;
        return (bVar == null || !bVar.g()) ? (this.A & 8) == 0 : (this.A & 8) == 0 && this.D.b();
    }

    public final boolean requiresActionButton() {
        return (this.B & 2) == 2;
    }

    public final boolean requiresOverflow() {
        return (requiresActionButton() || (this.B & 1) == 1) ? false : true;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i10;
        this.C = view;
        this.D = null;
        if (view != null && view.getId() == -1 && (i10 = this.f12397a) > 0) {
            view.setId(i10);
        }
        c cVar = this.f12409q;
        cVar.f12382m = true;
        cVar.o(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        if (this.f12405m == c9) {
            return this;
        }
        this.f12405m = Character.toLowerCase(c9);
        this.f12409q.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int i10 = this.A;
        int i11 = (z ? 1 : 0) | (i10 & (-2));
        this.A = i11;
        if (i10 != i11) {
            this.f12409q.o(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        int i10 = this.A;
        int i11 = i10 & 4;
        c cVar = this.f12409q;
        if (i11 != 0) {
            ArrayList<e> arrayList = cVar.f12378e;
            int size = arrayList.size();
            for (int i12 = 0; i12 < size; i12++) {
                e eVar = arrayList.get(i12);
                if (eVar.f12398b == this.f12398b && (eVar.A & 4) != 0 && eVar.isCheckable()) {
                    boolean z3 = eVar == this;
                    int i13 = eVar.A;
                    int i14 = (z3 ? 2 : 0) | (i13 & (-3));
                    eVar.A = i14;
                    if (i13 != i14) {
                        eVar.f12409q.o(false);
                    }
                }
            }
        } else {
            int i15 = (i10 & (-3)) | (z ? 2 : 0);
            this.A = i15;
            if (i10 != i15) {
                cVar.o(false);
            }
        }
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.A |= 16;
        } else {
            this.A &= -17;
        }
        this.f12409q.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f12408p = 0;
        this.f12407o = drawable;
        this.z = true;
        this.f12409q.o(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f12413v = colorStateList;
        this.f12415x = true;
        this.z = true;
        this.f12409q.o(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f12414w = mode;
        this.f12416y = true;
        this.z = true;
        this.f12409q.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f12402j = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        if (this.f12403k == c9) {
            return this;
        }
        this.f12403k = c9;
        this.f12409q.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.E = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f12410s = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f12403k = c9;
        this.f12405m = Character.toLowerCase(c10);
        this.f12409q.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.B = i10;
        c cVar = this.f12409q;
        cVar.f12382m = true;
        cVar.o(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f12401e = charSequence;
        this.f12409q.o(false);
        i iVar = this.r;
        if (iVar != null) {
            iVar.t(charSequence, null, null);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.h = charSequence;
        this.f12409q.o(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        int i10 = this.A;
        int i11 = (z ? 0 : 8) | (i10 & (-9));
        this.A = i11;
        if (i10 != i11) {
            c cVar = this.f12409q;
            cVar.f12379j = true;
            cVar.o(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f12401e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // p0.b, android.view.MenuItem
    public final p0.b setContentDescription(CharSequence charSequence) {
        this.f12411t = charSequence;
        this.f12409q.o(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final p0.b setTooltipText(CharSequence charSequence) {
        this.f12412u = charSequence;
        this.f12409q.o(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i10) {
        if (this.f12405m == c9 && this.f12406n == i10) {
            return this;
        }
        this.f12405m = Character.toLowerCase(c9);
        this.f12406n = KeyEvent.normalizeMetaState(i10);
        this.f12409q.o(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i10) {
        if (this.f12403k == c9 && this.f12404l == i10) {
            return this;
        }
        this.f12403k = c9;
        this.f12404l = KeyEvent.normalizeMetaState(i10);
        this.f12409q.o(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i10, int i11) {
        this.f12403k = c9;
        this.f12404l = KeyEvent.normalizeMetaState(i10);
        this.f12405m = Character.toLowerCase(c10);
        this.f12406n = KeyEvent.normalizeMetaState(i11);
        this.f12409q.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i10) {
        this.f12407o = null;
        this.f12408p = i10;
        this.z = true;
        this.f12409q.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i10) {
        setTitle(this.f12409q.f12374a.getString(i10));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i10) {
        int i11;
        c cVar = this.f12409q;
        Context context = cVar.f12374a;
        View viewInflate = LayoutInflater.from(context).inflate(i10, (ViewGroup) new LinearLayout(context), false);
        this.C = viewInflate;
        this.D = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i11 = this.f12397a) > 0) {
            viewInflate.setId(i11);
        }
        cVar.f12382m = true;
        cVar.o(true);
        return this;
    }
}
