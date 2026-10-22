package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.AbstractC1314b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import v0.InterfaceMenuC5650a;

/* loaded from: classes.dex */
public class e implements InterfaceMenuC5650a {

    /* renamed from: A, reason: collision with root package name */
    public static final int[] f8615A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f8616a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f8617b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8618c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8619d;

    /* renamed from: e, reason: collision with root package name */
    public a f8620e;

    /* renamed from: m, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f8628m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f8629n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f8630o;

    /* renamed from: p, reason: collision with root package name */
    public View f8631p;

    /* renamed from: x, reason: collision with root package name */
    public g f8639x;

    /* renamed from: z, reason: collision with root package name */
    public boolean f8641z;

    /* renamed from: l, reason: collision with root package name */
    public int f8627l = 0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8632q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8633r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8634s = false;

    /* renamed from: t, reason: collision with root package name */
    public boolean f8635t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8636u = false;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList<g> f8637v = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    public CopyOnWriteArrayList<WeakReference<i>> f8638w = new CopyOnWriteArrayList<>();

    /* renamed from: y, reason: collision with root package name */
    public boolean f8640y = false;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<g> f8621f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<g> f8622g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public boolean f8623h = true;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<g> f8624i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<g> f8625j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    public boolean f8626k = true;

    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    public interface b {
        boolean f(g gVar);
    }

    public e(Context context) {
        this.f8616a = context;
        this.f8617b = context.getResources();
        g0(true);
    }

    private static int D(int i10) {
        int i11 = ((-65536) & i10) >> 16;
        if (i11 >= 0) {
            int[] iArr = f8615A;
            if (i11 < iArr.length) {
                return (i10 & 65535) | (iArr[i11] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void Q(int i10, boolean z10) {
        if (i10 < 0 || i10 >= this.f8621f.size()) {
            return;
        }
        this.f8621f.remove(i10);
        if (z10) {
            N(true);
        }
    }

    private void b0(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        Resources resourcesE = E();
        if (view != null) {
            this.f8631p = view;
            this.f8629n = null;
            this.f8630o = null;
        } else {
            if (i10 > 0) {
                this.f8629n = resourcesE.getText(i10);
            } else if (charSequence != null) {
                this.f8629n = charSequence;
            }
            if (i11 > 0) {
                this.f8630o = androidx.core.content.a.e(w(), i11);
            } else if (drawable != null) {
                this.f8630o = drawable;
            }
            this.f8631p = null;
        }
        N(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g0(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f8617b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f8616a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f8616a
            boolean r3 = androidx.core.view.O.f(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f8619d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.g0(boolean):void");
    }

    private void i(boolean z10) {
        if (this.f8638w.isEmpty()) {
            return;
        }
        i0();
        Iterator<WeakReference<i>> it = this.f8638w.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar = next.get();
            if (iVar == null) {
                this.f8638w.remove(next);
            } else {
                iVar.b(z10);
            }
        }
        h0();
    }

    private static int p(ArrayList<g> arrayList, int i10) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i10) {
                return size + 1;
            }
        }
        return 0;
    }

    public View A() {
        return this.f8631p;
    }

    public ArrayList<g> B() {
        t();
        return this.f8625j;
    }

    public boolean C() {
        return this.f8635t;
    }

    public Resources E() {
        return this.f8617b;
    }

    public e F() {
        return this;
    }

    public ArrayList<g> G() {
        if (!this.f8623h) {
            return this.f8622g;
        }
        this.f8622g.clear();
        int size = this.f8621f.size();
        for (int i10 = 0; i10 < size; i10++) {
            g gVar = this.f8621f.get(i10);
            if (gVar.isVisible()) {
                this.f8622g.add(gVar);
            }
        }
        this.f8623h = false;
        this.f8626k = true;
        return this.f8622g;
    }

    public boolean H() {
        return !this.f8632q;
    }

    public boolean I() {
        return this.f8640y;
    }

    public boolean J() {
        return this.f8618c;
    }

    public boolean K() {
        return this.f8619d;
    }

    public void L(g gVar) {
        this.f8626k = true;
        N(true);
    }

    public void M(g gVar) {
        this.f8623h = true;
        N(true);
    }

    public void N(boolean z10) {
        if (this.f8632q) {
            this.f8633r = true;
            if (z10) {
                this.f8634s = true;
                return;
            }
            return;
        }
        if (z10) {
            this.f8623h = true;
            this.f8626k = true;
        }
        i(z10);
    }

    public boolean O(MenuItem menuItem, int i10) {
        return P(menuItem, null, i10);
    }

    public boolean P(MenuItem menuItem, i iVar, int i10) {
        g gVar = (g) menuItem;
        if (gVar == null || !gVar.isEnabled()) {
            return false;
        }
        boolean zK = gVar.k();
        AbstractC1314b abstractC1314bA = gVar.a();
        boolean z10 = abstractC1314bA != null && abstractC1314bA.a();
        if (gVar.j()) {
            boolean zExpandActionView = gVar.expandActionView() | zK;
            if (zExpandActionView) {
                e(true);
            }
            return zExpandActionView;
        }
        if (!gVar.hasSubMenu() && !z10) {
            if ((i10 & 1) == 0) {
                e(true);
            }
            return zK;
        }
        if ((i10 & 4) == 0) {
            e(false);
        }
        if (!gVar.hasSubMenu()) {
            gVar.x(new l(w(), this, gVar));
        }
        l lVar = (l) gVar.getSubMenu();
        if (z10) {
            abstractC1314bA.f(lVar);
        }
        boolean zL = l(lVar, iVar) | zK;
        if (!zL) {
            e(true);
        }
        return zL;
    }

    public void R(i iVar) {
        Iterator<WeakReference<i>> it = this.f8638w.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar2 = next.get();
            if (iVar2 == null || iVar2 == iVar) {
                this.f8638w.remove(next);
            }
        }
    }

    public void S(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(v());
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((l) item.getSubMenu()).S(bundle);
            }
        }
        int i11 = bundle.getInt("android:menu:expandedactionview");
        if (i11 <= 0 || (menuItemFindItem = findItem(i11)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void T(Bundle bundle) {
        j(bundle);
    }

    public void U(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((l) item.getSubMenu()).U(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    public void V(Bundle bundle) {
        k(bundle);
    }

    public void W(a aVar) {
        this.f8620e = aVar;
    }

    public e X(int i10) {
        this.f8627l = i10;
        return this;
    }

    public void Y(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f8621f.size();
        i0();
        for (int i10 = 0; i10 < size; i10++) {
            g gVar = this.f8621f.get(i10);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        h0();
    }

    public e Z(int i10) {
        b0(0, null, i10, null, null);
        return this;
    }

    public MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        int iD = D(i12);
        g gVarG = g(i10, i11, i12, iD, charSequence, this.f8627l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f8628m;
        if (contextMenuInfo != null) {
            gVarG.v(contextMenuInfo);
        }
        ArrayList<g> arrayList = this.f8621f;
        arrayList.add(p(arrayList, iD), gVarG);
        N(true);
        return gVarG;
    }

    public e a0(Drawable drawable) {
        b0(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        PackageManager packageManager = this.f8616a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i13 & 1) == 0) {
            removeGroup(i10);
        }
        for (int i15 = 0; i15 < size; i15++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i15);
            int i16 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i16 < 0 ? intent : intentArr[i16]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i10, i11, i12, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i14 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i14] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(i iVar) {
        c(iVar, this.f8616a);
    }

    public void c(i iVar, Context context) {
        this.f8638w.add(new WeakReference<>(iVar));
        iVar.j(context, this);
        this.f8626k = true;
    }

    public e c0(int i10) {
        b0(i10, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.f8639x;
        if (gVar != null) {
            f(gVar);
        }
        this.f8621f.clear();
        N(true);
    }

    public void clearHeader() {
        this.f8630o = null;
        this.f8629n = null;
        this.f8631p = null;
        N(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f8620e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public e d0(CharSequence charSequence) {
        b0(0, charSequence, 0, null, null);
        return this;
    }

    public final void e(boolean z10) {
        if (this.f8636u) {
            return;
        }
        this.f8636u = true;
        Iterator<WeakReference<i>> it = this.f8638w.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar = next.get();
            if (iVar == null) {
                this.f8638w.remove(next);
            } else {
                iVar.a(this, z10);
            }
        }
        this.f8636u = false;
    }

    public e e0(View view) {
        b0(0, null, 0, null, view);
        return this;
    }

    public boolean f(g gVar) {
        boolean zI = false;
        if (!this.f8638w.isEmpty() && this.f8639x == gVar) {
            i0();
            Iterator<WeakReference<i>> it = this.f8638w.iterator();
            while (it.hasNext()) {
                WeakReference<i> next = it.next();
                i iVar = next.get();
                if (iVar == null) {
                    this.f8638w.remove(next);
                } else {
                    zI = iVar.i(this, gVar);
                    if (zI) {
                        break;
                    }
                }
            }
            h0();
            if (zI) {
                this.f8639x = null;
            }
        }
        return zI;
    }

    public void f0(boolean z10) {
        this.f8641z = z10;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f8621f.get(i11);
            if (gVar.getItemId() == i10) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (menuItemFindItem = gVar.getSubMenu().findItem(i10)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final g g(int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        return new g(this, i10, i11, i12, i13, charSequence, i14);
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return this.f8621f.get(i10);
    }

    public boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.f8620e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    public void h0() {
        this.f8632q = false;
        if (this.f8633r) {
            this.f8633r = false;
            N(this.f8634s);
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f8641z) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f8621f.get(i10).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i0() {
        if (this.f8632q) {
            return;
        }
        this.f8632q = true;
        this.f8633r = false;
        this.f8634s = false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return r(i10, keyEvent) != null;
    }

    public final void j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.f8638w.isEmpty()) {
            return;
        }
        Iterator<WeakReference<i>> it = this.f8638w.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar = next.get();
            if (iVar == null) {
                this.f8638w.remove(next);
            } else {
                int id = iVar.getId();
                if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                    iVar.f(parcelable);
                }
            }
        }
    }

    public final void k(Bundle bundle) {
        Parcelable parcelableH;
        if (this.f8638w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<i>> it = this.f8638w.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar = next.get();
            if (iVar == null) {
                this.f8638w.remove(next);
            } else {
                int id = iVar.getId();
                if (id > 0 && (parcelableH = iVar.h()) != null) {
                    sparseArray.put(id, parcelableH);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    public final boolean l(l lVar, i iVar) {
        if (this.f8638w.isEmpty()) {
            return false;
        }
        boolean zG = iVar != null ? iVar.g(lVar) : false;
        Iterator<WeakReference<i>> it = this.f8638w.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar2 = next.get();
            if (iVar2 == null) {
                this.f8638w.remove(next);
            } else if (!zG) {
                zG = iVar2.g(lVar);
            }
        }
        return zG;
    }

    public boolean m(g gVar) {
        boolean zD = false;
        if (this.f8638w.isEmpty()) {
            return false;
        }
        i0();
        Iterator<WeakReference<i>> it = this.f8638w.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar = next.get();
            if (iVar == null) {
                this.f8638w.remove(next);
            } else {
                zD = iVar.d(this, gVar);
                if (zD) {
                    break;
                }
            }
        }
        h0();
        if (zD) {
            this.f8639x = gVar;
        }
        return zD;
    }

    public int n(int i10) {
        return o(i10, 0);
    }

    public int o(int i10, int i11) {
        int size = size();
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < size) {
            if (this.f8621f.get(i11).getGroupId() == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return O(findItem(i10), i11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        g gVarR = r(i10, keyEvent);
        boolean zO = gVarR != null ? O(gVarR, i11) : false;
        if ((i11 & 2) != 0) {
            e(true);
        }
        return zO;
    }

    public int q(int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f8621f.get(i11).getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public g r(int i10, KeyEvent keyEvent) {
        ArrayList<g> arrayList = this.f8637v;
        arrayList.clear();
        s(arrayList, i10, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zJ = J();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = arrayList.get(i11);
            char alphabeticShortcut = zJ ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zJ && alphabeticShortcut == '\b' && i10 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        int iN = n(i10);
        if (iN >= 0) {
            int size = this.f8621f.size() - iN;
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= size || this.f8621f.get(iN).getGroupId() != i10) {
                    break;
                }
                Q(iN, false);
                i11 = i12;
            }
            N(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        Q(q(i10), true);
    }

    public void s(List<g> list, int i10, KeyEvent keyEvent) {
        boolean zJ = J();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i10 == 67) {
            int size = this.f8621f.size();
            for (int i11 = 0; i11 < size; i11++) {
                g gVar = this.f8621f.get(i11);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).s(list, i10, keyEvent);
                }
                char alphabeticShortcut = zJ ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zJ ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zJ && alphabeticShortcut == '\b' && i10 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        int size = this.f8621f.size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f8621f.get(i11);
            if (gVar.getGroupId() == i10) {
                gVar.t(z11);
                gVar.setCheckable(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f8640y = z10;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        int size = this.f8621f.size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f8621f.get(i11);
            if (gVar.getGroupId() == i10) {
                gVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        int size = this.f8621f.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.f8621f.get(i11);
            if (gVar.getGroupId() == i10 && gVar.y(z10)) {
                z11 = true;
            }
        }
        if (z11) {
            N(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f8618c = z10;
        N(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f8621f.size();
    }

    public void t() {
        ArrayList<g> arrayListG = G();
        if (this.f8626k) {
            Iterator<WeakReference<i>> it = this.f8638w.iterator();
            boolean zC = false;
            while (it.hasNext()) {
                WeakReference<i> next = it.next();
                i iVar = next.get();
                if (iVar == null) {
                    this.f8638w.remove(next);
                } else {
                    zC |= iVar.c();
                }
            }
            if (zC) {
                this.f8624i.clear();
                this.f8625j.clear();
                int size = arrayListG.size();
                for (int i10 = 0; i10 < size; i10++) {
                    g gVar = arrayListG.get(i10);
                    if (gVar.l()) {
                        this.f8624i.add(gVar);
                    } else {
                        this.f8625j.add(gVar);
                    }
                }
            } else {
                this.f8624i.clear();
                this.f8625j.clear();
                this.f8625j.addAll(G());
            }
            this.f8626k = false;
        }
    }

    public ArrayList<g> u() {
        t();
        return this.f8624i;
    }

    public String v() {
        return "android:menu:actionviewstates";
    }

    public Context w() {
        return this.f8616a;
    }

    public g x() {
        return this.f8639x;
    }

    public Drawable y() {
        return this.f8630o;
    }

    public CharSequence z() {
        return this.f8629n;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return a(0, 0, 0, this.f8617b.getString(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, this.f8617b.getString(i10));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(i10, i11, i12, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        g gVar = (g) a(i10, i11, i12, charSequence);
        l lVar = new l(this.f8616a, this, gVar);
        gVar.x(lVar);
        return lVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return a(i10, i11, i12, this.f8617b.getString(i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, this.f8617b.getString(i13));
    }
}
