package androidx.appcompat.view.menu;

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
import androidx.datastore.preferences.protobuf.b1;
import java.util.ArrayList;
import v0.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h implements p0.b {
    public int B;
    public View C;
    public v0.b D;
    public MenuItem.OnActionExpandListener E;

    /* renamed from: a, reason: collision with root package name */
    public final int f501a;

    /* renamed from: b, reason: collision with root package name */
    public final int f502b;

    /* renamed from: c, reason: collision with root package name */
    public final int f503c;

    /* renamed from: d, reason: collision with root package name */
    public final int f504d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f505e;
    public CharSequence h;

    /* renamed from: j, reason: collision with root package name */
    public Intent f506j;

    /* renamed from: k, reason: collision with root package name */
    public char f507k;

    /* renamed from: m, reason: collision with root package name */
    public char f509m;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f511o;

    /* renamed from: q, reason: collision with root package name */
    public final f f513q;
    public m r;

    /* renamed from: s, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f514s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f515t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f516u;

    /* renamed from: l, reason: collision with root package name */
    public int f508l = 4096;

    /* renamed from: n, reason: collision with root package name */
    public int f510n = 4096;

    /* renamed from: p, reason: collision with root package name */
    public int f512p = 0;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f517v = null;

    /* renamed from: w, reason: collision with root package name */
    public PorterDuff.Mode f518w = null;

    /* renamed from: x, reason: collision with root package name */
    public boolean f519x = false;

    /* renamed from: y, reason: collision with root package name */
    public boolean f520y = false;
    public boolean z = false;
    public int A = 16;
    public boolean F = false;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements b.a {
        public a() {
        }

        @Override // v0.b.a
        public final void a() {
            f fVar = h.this.f513q;
            fVar.f484k = true;
            fVar.p(true);
        }
    }

    public h(f fVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f513q = fVar;
        this.f501a = i11;
        this.f502b = i10;
        this.f503c = i12;
        this.f504d = i13;
        this.f505e = charSequence;
        this.B = i14;
    }

    public static void c(int i10, int i11, String str, StringBuilder sb2) {
        if ((i10 & i11) == i11) {
            sb2.append(str);
        }
    }

    @Override // p0.b
    public final p0.b a(v0.b bVar) {
        v0.b bVar2 = this.D;
        if (bVar2 != null) {
            bVar2.f13252a = null;
        }
        this.C = null;
        this.D = bVar;
        this.f513q.p(true);
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
            return this.f513q.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.z && (this.f519x || this.f520y)) {
            drawable = drawable.mutate();
            if (this.f519x) {
                drawable.setTintList(this.f517v);
            }
            if (this.f520y) {
                drawable.setTintMode(this.f518w);
            }
            this.z = false;
        }
        return drawable;
    }

    public final boolean e() {
        v0.b bVar;
        if ((this.B & 8) == 0) {
            return false;
        }
        if (this.C == null && (bVar = this.D) != null) {
            this.C = bVar.d(this);
        }
        return this.C != null;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.E;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f513q.f(this);
        }
        return false;
    }

    public final void f(boolean z) {
        if (z) {
            this.A |= 32;
        } else {
            this.A &= -33;
        }
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
        return this.f510n;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f509m;
    }

    @Override // p0.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f515t;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f502b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f511o;
        if (drawable != null) {
            return d(drawable);
        }
        int i10 = this.f512p;
        if (i10 == 0) {
            return null;
        }
        Drawable drawableL = b1.L(i10, this.f513q.f478a);
        this.f512p = 0;
        this.f511o = drawableL;
        return d(drawableL);
    }

    @Override // p0.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f517v;
    }

    @Override // p0.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f518w;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f506j;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.f501a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // p0.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f508l;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f507k;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f503c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.r;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.f505e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.h;
        return charSequence != null ? charSequence : this.f505e;
    }

    @Override // p0.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f516u;
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
        if (view != null && view.getId() == -1 && (i10 = this.f501a) > 0) {
            view.setId(i10);
        }
        f fVar = this.f513q;
        fVar.f487n = true;
        fVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        if (this.f509m == c9) {
            return this;
        }
        this.f509m = Character.toLowerCase(c9);
        this.f513q.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int i10 = this.A;
        int i11 = (z ? 1 : 0) | (i10 & (-2));
        this.A = i11;
        if (i10 != i11) {
            this.f513q.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        int i10 = this.A;
        int i11 = i10 & 4;
        f fVar = this.f513q;
        if (i11 == 0) {
            int i12 = (i10 & (-3)) | (z ? 2 : 0);
            this.A = i12;
            if (i10 != i12) {
                fVar.p(false);
            }
            return this;
        }
        ArrayList<h> arrayList = fVar.h;
        int size = arrayList.size();
        fVar.w();
        for (int i13 = 0; i13 < size; i13++) {
            h hVar = arrayList.get(i13);
            if (hVar.f502b == this.f502b && (hVar.A & 4) != 0 && hVar.isCheckable()) {
                boolean z3 = hVar == this;
                int i14 = hVar.A;
                int i15 = (z3 ? 2 : 0) | (i14 & (-3));
                hVar.A = i15;
                if (i14 != i15) {
                    hVar.f513q.p(false);
                }
            }
        }
        fVar.v();
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
        this.f513q.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f512p = 0;
        this.f511o = drawable;
        this.z = true;
        this.f513q.p(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f517v = colorStateList;
        this.f519x = true;
        this.z = true;
        this.f513q.p(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f518w = mode;
        this.f520y = true;
        this.z = true;
        this.f513q.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f506j = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        if (this.f507k == c9) {
            return this;
        }
        this.f507k = c9;
        this.f513q.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.E = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f514s = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f507k = c9;
        this.f509m = Character.toLowerCase(c10);
        this.f513q.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.B = i10;
        f fVar = this.f513q;
        fVar.f487n = true;
        fVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f505e = charSequence;
        this.f513q.p(false);
        m mVar = this.r;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.h = charSequence;
        this.f513q.p(false);
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
            f fVar = this.f513q;
            fVar.f484k = true;
            fVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f505e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // p0.b, android.view.MenuItem
    public final p0.b setContentDescription(CharSequence charSequence) {
        this.f515t = charSequence;
        this.f513q.p(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final p0.b setTooltipText(CharSequence charSequence) {
        this.f516u = charSequence;
        this.f513q.p(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i10) {
        if (this.f509m == c9 && this.f510n == i10) {
            return this;
        }
        this.f509m = Character.toLowerCase(c9);
        this.f510n = KeyEvent.normalizeMetaState(i10);
        this.f513q.p(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i10) {
        if (this.f507k == c9 && this.f508l == i10) {
            return this;
        }
        this.f507k = c9;
        this.f508l = KeyEvent.normalizeMetaState(i10);
        this.f513q.p(false);
        return this;
    }

    @Override // p0.b, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i10, int i11) {
        this.f507k = c9;
        this.f508l = KeyEvent.normalizeMetaState(i10);
        this.f509m = Character.toLowerCase(c10);
        this.f510n = KeyEvent.normalizeMetaState(i11);
        this.f513q.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i10) {
        this.f511o = null;
        this.f512p = i10;
        this.z = true;
        this.f513q.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i10) {
        setTitle(this.f513q.f478a.getString(i10));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i10) {
        int i11;
        f fVar = this.f513q;
        Context context = fVar.f478a;
        View viewInflate = LayoutInflater.from(context).inflate(i10, (ViewGroup) new LinearLayout(context), false);
        this.C = viewInflate;
        this.D = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i11 = this.f501a) > 0) {
            viewInflate.setId(i11);
        }
        fVar.f487n = true;
        fVar.p(true);
        return this;
    }
}
