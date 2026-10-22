package te;

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
import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class m implements h3.b, h {
    public n3.d A;
    public MenuItem.OnActionExpandListener B;
    public boolean C;

    /* renamed from: a, reason: collision with root package name */
    public int f13363a;

    /* renamed from: b, reason: collision with root package name */
    public int f13364b;

    /* renamed from: c, reason: collision with root package name */
    public int f13365c;

    /* renamed from: d, reason: collision with root package name */
    public int f13366d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f13367e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f13368f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f13369g;

    /* renamed from: h, reason: collision with root package name */
    public char f13370h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public char f13371j;

    /* renamed from: k, reason: collision with root package name */
    public int f13372k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f13373l;

    /* renamed from: m, reason: collision with root package name */
    public int f13374m;

    /* renamed from: n, reason: collision with root package name */
    public l f13375n;

    /* renamed from: o, reason: collision with root package name */
    public z f13376o;

    /* renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f13377p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f13378q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f13379r;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f13380s;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f13381t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13382u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f13383v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f13384w;

    /* renamed from: x, reason: collision with root package name */
    public int f13385x;

    /* renamed from: y, reason: collision with root package name */
    public int f13386y;

    /* renamed from: z, reason: collision with root package name */
    public View f13387z;

    @Override // h3.b
    public final n3.d a() {
        return this.A;
    }

    @Override // h3.b
    public final h3.b b(n3.d dVar) {
        this.f13387z = null;
        this.A = dVar;
        this.f13375n.o(true);
        n3.d dVar2 = this.A;
        if (dVar2 != null) {
            stepos.support.v7.app.f fVar = new stepos.support.v7.app.f(5);
            fVar.f12315f = this;
            VarHandle.storeStoreFence();
            dVar2.g(fVar);
        }
        return this;
    }

    public final Drawable c(Drawable drawable) {
        if (drawable != null && this.f13384w && (this.f13382u || this.f13383v)) {
            drawable = drawable.mutate();
            if (this.f13382u) {
                drawable.setTintList(this.f13380s);
            }
            if (this.f13383v) {
                drawable.setTintMode(this.f13381t);
            }
            this.f13384w = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f13386y & 8) == 0) {
            return false;
        }
        if (this.f13387z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f13375n.d(this);
        }
        return false;
    }

    public final boolean d() {
        n3.d dVar;
        if ((this.f13386y & 8) == 0) {
            return false;
        }
        if (this.f13387z == null && (dVar = this.A) != null) {
            this.f13387z = dVar.c(this);
        }
        return this.f13387z != null;
    }

    public final void e(boolean z10) {
        int i = this.f13385x;
        if (z10) {
            this.f13385x = i | 32;
        } else {
            this.f13385x = i & (-33);
        }
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!d()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f13375n.f(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f13387z;
        if (view != null) {
            return view;
        }
        n3.d dVar = this.A;
        if (dVar == null) {
            return null;
        }
        View viewC = dVar.c(this);
        this.f13387z = viewC;
        return viewC;
    }

    @Override // h3.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f13372k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f13371j;
    }

    @Override // h3.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f13378q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f13364b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f13373l;
        if (drawable != null) {
            return c(drawable);
        }
        if (this.f13374m == 0) {
            return null;
        }
        Drawable drawableB = m.s.a().b(this.f13374m, this.f13375n.f13343a);
        this.f13374m = 0;
        this.f13373l = drawableB;
        return c(drawableB);
    }

    @Override // h3.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f13380s;
    }

    @Override // h3.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f13381t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f13369g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f13363a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // h3.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f13370h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f13365c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f13376o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f13367e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f13368f;
        return charSequence != null ? charSequence : this.f13367e;
    }

    @Override // h3.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f13379r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f13376o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f13385x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f13385x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f13385x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        n3.d dVar = this.A;
        return (dVar == null || !dVar.f()) ? (this.f13385x & 8) == 0 : (this.f13385x & 8) == 0 && this.A.b();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        int i3;
        l lVar = this.f13375n;
        Context context = lVar.f13343a;
        View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false);
        this.f13387z = viewInflate;
        this.A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i3 = this.f13363a) > 0) {
            viewInflate.setId(i3);
        }
        lVar.f13351j = true;
        lVar.o(true);
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i) {
        if (this.f13371j == c9 && this.f13372k == i) {
            return this;
        }
        this.f13371j = Character.toLowerCase(c9);
        this.f13372k = KeyEvent.normalizeMetaState(i);
        this.f13375n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z10) {
        int i = this.f13385x;
        int i3 = (z10 ? 1 : 0) | (i & (-2));
        this.f13385x = i3;
        if (i != i3) {
            this.f13375n.o(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z10) {
        l lVar = this.f13375n;
        int i = this.f13385x;
        if ((i & 4) != 0) {
            int i3 = this.f13364b;
            ArrayList arrayList = lVar.f13347e;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                m mVar = (m) arrayList.get(i10);
                if (mVar.f13364b == i3 && (mVar.f13385x & 4) != 0 && mVar.isCheckable()) {
                    boolean z11 = mVar == this;
                    int i11 = mVar.f13385x;
                    int i12 = (z11 ? 2 : 0) | (i11 & (-3));
                    mVar.f13385x = i12;
                    if (i11 != i12) {
                        mVar.f13375n.o(false);
                    }
                }
            }
        } else {
            int i13 = (i & (-3)) | (z10 ? 2 : 0);
            this.f13385x = i13;
            if (i != i13) {
                lVar.o(false);
            }
        }
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final h3.b setContentDescription(CharSequence charSequence) {
        this.f13378q = charSequence;
        this.f13375n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z10) {
        int i = this.f13385x;
        if (z10) {
            this.f13385x = i | 16;
        } else {
            this.f13385x = i & (-17);
        }
        this.f13375n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f13373l = null;
        this.f13374m = i;
        this.f13384w = true;
        this.f13375n.o(false);
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f13380s = colorStateList;
        this.f13382u = true;
        this.f13384w = true;
        this.f13375n.o(false);
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f13381t = mode;
        this.f13383v = true;
        this.f13384w = true;
        this.f13375n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f13369g = intent;
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i) {
        if (this.f13370h == c9 && this.i == i) {
            return this;
        }
        this.f13370h = c9;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f13375n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f13377p = onMenuItemClickListener;
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i, int i3) {
        this.f13370h = c9;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f13371j = Character.toLowerCase(c10);
        this.f13372k = KeyEvent.normalizeMetaState(i3);
        this.f13375n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
        int i3 = i & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            g5.f.s("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
            return;
        }
        this.f13386y = i;
        l lVar = this.f13375n;
        lVar.f13351j = true;
        lVar.o(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f13367e = charSequence;
        this.f13375n.o(false);
        z zVar = this.f13376o;
        if (zVar != null) {
            zVar.t(charSequence, null, null);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f13368f = charSequence;
        this.f13375n.o(false);
        return this;
    }

    @Override // h3.b, android.view.MenuItem
    public final h3.b setTooltipText(CharSequence charSequence) {
        this.f13379r = charSequence;
        this.f13375n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z10) {
        int i = this.f13385x;
        int i3 = (z10 ? 0 : 8) | (i & (-9));
        this.f13385x = i3;
        if (i != i3) {
            l lVar = this.f13375n;
            lVar.f13349g = true;
            lVar.o(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f13367e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f13374m = 0;
        this.f13373l = drawable;
        this.f13384w = true;
        this.f13375n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        setTitle(this.f13375n.f13343a.getString(i));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        if (this.f13370h == c9) {
            return this;
        }
        this.f13370h = c9;
        this.f13375n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f13370h = c9;
        this.f13371j = Character.toLowerCase(c10);
        this.f13375n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        if (this.f13371j == c9) {
            return this;
        }
        this.f13371j = Character.toLowerCase(c9);
        this.f13375n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i;
        this.f13387z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i = this.f13363a) > 0) {
            view.setId(i);
        }
        l lVar = this.f13375n;
        lVar.f13351j = true;
        lVar.o(true);
        return this;
    }
}
