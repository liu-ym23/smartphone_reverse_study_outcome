package stepos.support.v7.view.menu;

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
import android.view.ViewConfiguration;
import androidx.core.view.AbstractC1314b;
import androidx.core.view.C1329q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import v0.InterfaceMenuC5650a;

/* loaded from: classes5.dex */
public class c implements InterfaceMenuC5650a, Jc.f {

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f40928y = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f40929a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f40930b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f40931c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f40932d;

    /* renamed from: e, reason: collision with root package name */
    public a f40933e;

    /* renamed from: m, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f40941m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f40942n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f40943o;

    /* renamed from: p, reason: collision with root package name */
    public View f40944p;

    /* renamed from: w, reason: collision with root package name */
    public e f40951w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f40952x;

    /* renamed from: l, reason: collision with root package name */
    public int f40940l = 0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f40945q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f40946r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f40947s = false;

    /* renamed from: t, reason: collision with root package name */
    public boolean f40948t = false;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList<e> f40949u = new ArrayList<>();

    /* renamed from: v, reason: collision with root package name */
    public CopyOnWriteArrayList<WeakReference<g>> f40950v = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<e> f40934f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<e> f40935g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public boolean f40936h = true;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<e> f40937i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<e> f40938j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    public boolean f40939k = true;

    public interface a {
        void a(c cVar);

        boolean b(c cVar, MenuItem menuItem);
    }

    public interface b {
        boolean b(e eVar);
    }

    public c(Context context) {
        this.f40929a = context;
        this.f40930b = context.getResources();
        Y(true);
    }

    public static int B(int i10) {
        int i11 = ((-65536) & i10) >> 16;
        if (i11 >= 0) {
            int[] iArr = f40928y;
            if (i11 < iArr.length) {
                return (i10 & 65535) | (iArr[i11] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public static boolean Z(ViewConfiguration viewConfiguration, Context context) {
        return false;
    }

    public static int n(ArrayList<e> arrayList, int i10) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i10) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean A() {
        return this.f40947s;
    }

    public Resources C() {
        return this.f40930b;
    }

    public c D() {
        return this;
    }

    public ArrayList<e> E() {
        if (!this.f40936h) {
            return this.f40935g;
        }
        this.f40935g.clear();
        int size = this.f40934f.size();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = this.f40934f.get(i10);
            if (eVar.isVisible()) {
                this.f40935g.add(eVar);
            }
        }
        this.f40936h = false;
        this.f40939k = true;
        return this.f40935g;
    }

    public boolean F() {
        return this.f40931c;
    }

    public boolean G() {
        return this.f40932d;
    }

    public void H(e eVar) {
        this.f40939k = true;
        J(true);
    }

    public void I(e eVar) {
        this.f40936h = true;
        J(true);
    }

    public void J(boolean z10) {
        if (this.f40945q) {
            this.f40946r = true;
            return;
        }
        if (z10) {
            this.f40936h = true;
            this.f40939k = true;
        }
        i(z10);
    }

    public boolean K(MenuItem menuItem, int i10) {
        return L(menuItem, null, i10);
    }

    public boolean L(MenuItem menuItem, g gVar, int i10) {
        e eVar = (e) menuItem;
        if (eVar == null || !eVar.isEnabled()) {
            return false;
        }
        boolean zL = eVar.l();
        AbstractC1314b abstractC1314bA = eVar.a();
        boolean z10 = abstractC1314bA != null && abstractC1314bA.a();
        if (eVar.k()) {
            boolean zExpandActionView = eVar.expandActionView() | zL;
            if (zExpandActionView) {
                e(true);
            }
            return zExpandActionView;
        }
        if (!eVar.hasSubMenu() && !z10) {
            if ((i10 & 1) == 0) {
                e(true);
            }
            return zL;
        }
        e(false);
        if (!eVar.hasSubMenu()) {
            eVar.B(new i(u(), this, eVar));
        }
        i iVar = (i) eVar.getSubMenu();
        if (z10) {
            abstractC1314bA.f(iVar);
        }
        boolean zJ = j(iVar, gVar) | zL;
        if (!zJ) {
            e(true);
        }
        return zJ;
    }

    public final void M(int i10, boolean z10) {
        if (i10 < 0 || i10 >= this.f40934f.size()) {
            return;
        }
        this.f40934f.remove(i10);
        if (z10) {
            J(true);
        }
    }

    public void N(g gVar) {
        Iterator<WeakReference<g>> it = this.f40950v.iterator();
        while (it.hasNext()) {
            WeakReference<g> next = it.next();
            g gVar2 = next.get();
            if (gVar2 == null || gVar2 == gVar) {
                this.f40950v.remove(next);
            }
        }
    }

    public void O(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View viewB = C1329q.b(item);
            if (viewB != null && viewB.getId() != -1) {
                viewB.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((i) item.getSubMenu()).O(bundle);
            }
        }
        int i11 = bundle.getInt("android:menu:expandedactionview");
        if (i11 <= 0 || (menuItemFindItem = findItem(i11)) == null) {
            return;
        }
        C1329q.a(menuItemFindItem);
    }

    public void P(Bundle bundle) {
        int size = size();
        SparseArray<Parcelable> sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View viewB = C1329q.b(item);
            if (viewB != null && viewB.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                viewB.saveHierarchyState(sparseArray);
                if (C1329q.c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((i) item.getSubMenu()).P(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void Q(a aVar) {
        this.f40933e = aVar;
    }

    public c R(int i10) {
        this.f40940l = i10;
        return this;
    }

    public void S(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f40934f.size();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = this.f40934f.get(i10);
            if (eVar.getGroupId() == groupId && eVar.n() && eVar.isCheckable()) {
                eVar.w(eVar == menuItem);
            }
        }
    }

    public c T(Drawable drawable) {
        U(0, null, 0, drawable, null);
        return this;
    }

    public final void U(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        Resources resourcesC = C();
        if (view != null) {
            this.f40944p = view;
            this.f40942n = null;
            this.f40943o = null;
        } else {
            if (i10 > 0) {
                this.f40942n = resourcesC.getText(i10);
            } else if (charSequence != null) {
                this.f40942n = charSequence;
            }
            if (i11 > 0) {
                this.f40943o = androidx.core.content.a.e(u(), i11);
            } else if (drawable != null) {
                this.f40943o = drawable;
            }
            this.f40944p = null;
        }
        J(false);
    }

    public c V(CharSequence charSequence) {
        U(0, charSequence, 0, null, null);
        return this;
    }

    public c W(View view) {
        U(0, null, 0, null, view);
        return this;
    }

    public void X(boolean z10) {
        this.f40952x = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f40930b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f40929a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f40929a
            boolean r3 = Z(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f40932d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.view.menu.c.Y(boolean):void");
    }

    public MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        int iB = B(i12);
        e eVarG = g(i10, i11, i12, iB, charSequence, this.f40940l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f40941m;
        if (contextMenuInfo != null) {
            eVarG.z(contextMenuInfo);
        }
        ArrayList<e> arrayList = this.f40934f;
        arrayList.add(n(arrayList, iB), eVarG);
        J(true);
        return eVarG;
    }

    public void a0() {
        this.f40945q = false;
        if (this.f40946r) {
            this.f40946r = false;
            J(true);
        }
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        PackageManager packageManager = this.f40929a.getPackageManager();
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

    public void b(g gVar) {
        c(gVar, this.f40929a);
    }

    public void b0() {
        if (this.f40945q) {
            return;
        }
        this.f40945q = true;
        this.f40946r = false;
    }

    public void c(g gVar, Context context) {
        this.f40950v.add(new WeakReference<>(gVar));
        gVar.g(context, this);
        this.f40939k = true;
    }

    @Override // android.view.Menu
    public void clear() {
        e eVar = this.f40951w;
        if (eVar != null) {
            f(eVar);
        }
        this.f40934f.clear();
        J(true);
    }

    public void clearHeader() {
        this.f40943o = null;
        this.f40942n = null;
        this.f40944p = null;
        J(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f40933e;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void e(boolean z10) {
        if (this.f40948t) {
            return;
        }
        this.f40948t = true;
        Iterator<WeakReference<g>> it = this.f40950v.iterator();
        while (it.hasNext()) {
            WeakReference<g> next = it.next();
            g gVar = next.get();
            if (gVar == null) {
                this.f40950v.remove(next);
            } else {
                gVar.a(this, z10);
            }
        }
        this.f40948t = false;
    }

    public boolean f(e eVar) {
        boolean zD = false;
        if (!this.f40950v.isEmpty() && this.f40951w == eVar) {
            b0();
            Iterator<WeakReference<g>> it = this.f40950v.iterator();
            while (it.hasNext()) {
                WeakReference<g> next = it.next();
                g gVar = next.get();
                if (gVar == null) {
                    this.f40950v.remove(next);
                } else {
                    zD = gVar.d(this, eVar);
                    if (zD) {
                        break;
                    }
                }
            }
            a0();
            if (zD) {
                this.f40951w = null;
            }
        }
        return zD;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = this.f40934f.get(i11);
            if (eVar.getItemId() == i10) {
                return eVar;
            }
            if (eVar.hasSubMenu() && (menuItemFindItem = eVar.getSubMenu().findItem(i10)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final e g(int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        return new e(this, i10, i11, i12, i13, charSequence, i14);
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return this.f40934f.get(i10);
    }

    public boolean h(c cVar, MenuItem menuItem) {
        a aVar = this.f40933e;
        return aVar != null && aVar.b(cVar, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f40952x) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f40934f.get(i10).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i(boolean z10) {
        if (this.f40950v.isEmpty()) {
            return;
        }
        b0();
        Iterator<WeakReference<g>> it = this.f40950v.iterator();
        while (it.hasNext()) {
            WeakReference<g> next = it.next();
            g gVar = next.get();
            if (gVar == null) {
                this.f40950v.remove(next);
            } else {
                gVar.b(z10);
            }
        }
        a0();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return p(i10, keyEvent) != null;
    }

    public final boolean j(i iVar, g gVar) {
        if (this.f40950v.isEmpty()) {
            return false;
        }
        boolean zE = gVar != null ? gVar.e(iVar) : false;
        Iterator<WeakReference<g>> it = this.f40950v.iterator();
        while (it.hasNext()) {
            WeakReference<g> next = it.next();
            g gVar2 = next.get();
            if (gVar2 == null) {
                this.f40950v.remove(next);
            } else if (!zE) {
                zE = gVar2.e(iVar);
            }
        }
        return zE;
    }

    public boolean k(e eVar) {
        boolean zF = false;
        if (this.f40950v.isEmpty()) {
            return false;
        }
        b0();
        Iterator<WeakReference<g>> it = this.f40950v.iterator();
        while (it.hasNext()) {
            WeakReference<g> next = it.next();
            g gVar = next.get();
            if (gVar == null) {
                this.f40950v.remove(next);
            } else {
                zF = gVar.f(this, eVar);
                if (zF) {
                    break;
                }
            }
        }
        a0();
        if (zF) {
            this.f40951w = eVar;
        }
        return zF;
    }

    public int l(int i10) {
        return m(i10, 0);
    }

    public int m(int i10, int i11) {
        int size = size();
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < size) {
            if (this.f40934f.get(i11).getGroupId() == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public int o(int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f40934f.get(i11).getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public e p(int i10, KeyEvent keyEvent) {
        ArrayList<e> arrayList = this.f40949u;
        arrayList.clear();
        q(arrayList, i10, keyEvent);
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
        boolean zF = F();
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = arrayList.get(i11);
            char alphabeticShortcut = zF ? eVar.getAlphabeticShortcut() : eVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zF && alphabeticShortcut == '\b' && i10 == 67))) {
                return eVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return K(findItem(i10), i11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        e eVarP = p(i10, keyEvent);
        boolean zK = eVarP != null ? K(eVarP, i11) : false;
        if ((i11 & 2) != 0) {
            e(true);
        }
        return zK;
    }

    public void q(List<e> list, int i10, KeyEvent keyEvent) {
        boolean zF = F();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i10 == 67) {
            int size = this.f40934f.size();
            for (int i11 = 0; i11 < size; i11++) {
                e eVar = this.f40934f.get(i11);
                if (eVar.hasSubMenu()) {
                    ((c) eVar.getSubMenu()).q(list, i10, keyEvent);
                }
                char alphabeticShortcut = zF ? eVar.getAlphabeticShortcut() : eVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zF && alphabeticShortcut == '\b' && i10 == 67)) && eVar.isEnabled()) {
                        list.add(eVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList<e> arrayListE = E();
        if (this.f40939k) {
            Iterator<WeakReference<g>> it = this.f40950v.iterator();
            boolean zC = false;
            while (it.hasNext()) {
                WeakReference<g> next = it.next();
                g gVar = next.get();
                if (gVar == null) {
                    this.f40950v.remove(next);
                } else {
                    zC |= gVar.c();
                }
            }
            if (zC) {
                this.f40937i.clear();
                this.f40938j.clear();
                int size = arrayListE.size();
                for (int i10 = 0; i10 < size; i10++) {
                    e eVar = arrayListE.get(i10);
                    if (eVar.m()) {
                        this.f40937i.add(eVar);
                    } else {
                        this.f40938j.add(eVar);
                    }
                }
            } else {
                this.f40937i.clear();
                this.f40938j.clear();
                this.f40938j.addAll(E());
            }
            this.f40939k = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        int iL = l(i10);
        if (iL >= 0) {
            int size = this.f40934f.size() - iL;
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= size || this.f40934f.get(iL).getGroupId() != i10) {
                    break;
                }
                M(iL, false);
                i11 = i12;
            }
            J(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        M(o(i10), true);
    }

    public ArrayList<e> s() {
        r();
        return this.f40937i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        int size = this.f40934f.size();
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = this.f40934f.get(i11);
            if (eVar.getGroupId() == i10) {
                eVar.x(z11);
                eVar.setCheckable(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        int size = this.f40934f.size();
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = this.f40934f.get(i11);
            if (eVar.getGroupId() == i10) {
                eVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        int size = this.f40934f.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = this.f40934f.get(i11);
            if (eVar.getGroupId() == i10 && eVar.C(z10)) {
                z11 = true;
            }
        }
        if (z11) {
            J(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f40931c = z10;
        J(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f40934f.size();
    }

    public String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f40929a;
    }

    public e v() {
        return this.f40951w;
    }

    public Drawable w() {
        return this.f40943o;
    }

    public CharSequence x() {
        return this.f40942n;
    }

    public View y() {
        return this.f40944p;
    }

    public ArrayList<e> z() {
        r();
        return this.f40938j;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return a(0, 0, 0, this.f40930b.getString(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, this.f40930b.getString(i10));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(i10, i11, i12, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        e eVar = (e) a(i10, i11, i12, charSequence);
        i iVar = new i(this.f40929a, this, eVar);
        eVar.B(iVar);
        return iVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return a(i10, i11, i12, this.f40930b.getString(i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, this.f40930b.getString(i13));
    }
}
