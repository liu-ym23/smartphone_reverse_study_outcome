package l;

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
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class l implements h3.a {

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f7582y = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f7583a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f7584b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7585c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7586d;

    /* renamed from: e, reason: collision with root package name */
    public j f7587e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f7588f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f7589g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7590h;
    public final ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f7591j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7592k;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f7594m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f7595n;

    /* renamed from: o, reason: collision with root package name */
    public View f7596o;

    /* renamed from: v, reason: collision with root package name */
    public n f7603v;

    /* renamed from: x, reason: collision with root package name */
    public boolean f7605x;

    /* renamed from: l, reason: collision with root package name */
    public int f7593l = 0;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7597p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7598q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f7599r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f7600s = false;

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f7601t = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArrayList f7602u = new CopyOnWriteArrayList();

    /* renamed from: w, reason: collision with root package name */
    public boolean f7604w = false;

    public l(Context context) {
        boolean z10 = false;
        this.f7583a = context;
        Resources resources = context.getResources();
        this.f7584b = resources;
        this.f7588f = new ArrayList();
        this.f7589g = new ArrayList();
        this.f7590h = true;
        this.i = new ArrayList();
        this.f7591j = new ArrayList();
        this.f7592k = true;
        if (resources.getConfiguration().keyboard != 1 && ViewConfiguration.get(context).shouldShowMenuShortcutsWhenKeyboardPresent()) {
            z10 = true;
        }
        this.f7586d = z10;
    }

    public final MenuItem a(int i, int i3, int i10, CharSequence charSequence) {
        int i11 = ((-65536) & i10) >> 16;
        if (i11 < 0 || i11 >= 6) {
            g5.f.s("order does not contain a valid category.");
            return null;
        }
        int i12 = (f7582y[i11] << 16) | (65535 & i10);
        int i13 = this.f7593l;
        n nVar = new n();
        nVar.i = 4096;
        nVar.f7619k = 4096;
        int i14 = 0;
        nVar.f7621m = 0;
        nVar.f7627s = null;
        nVar.f7628t = null;
        nVar.f7629u = false;
        nVar.f7630v = false;
        nVar.f7631w = false;
        nVar.f7632x = 16;
        nVar.C = false;
        nVar.f7622n = this;
        nVar.f7610a = i3;
        nVar.f7611b = i;
        nVar.f7612c = i10;
        nVar.f7613d = i12;
        nVar.f7614e = charSequence;
        nVar.f7633y = i13;
        VarHandle.storeStoreFence();
        ArrayList arrayList = this.f7588f;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (((n) arrayList.get(size)).f7613d <= i12) {
                i14 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i14, nVar);
        p(true);
        return nVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return a(0, 0, 0, this.f7584b.getString(i));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i3, int i10, ComponentName componentName, Intent[] intentArr, Intent intent, int i11, MenuItem[] menuItemArr) {
        int i12;
        PackageManager packageManager = this.f7583a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i11 & 1) == 0) {
            removeGroup(i);
        }
        for (int i13 = 0; i13 < size; i13++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i13);
            int i14 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i14 < 0 ? intent : intentArr[i14]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            n nVar = (n) a(i, i3, i10, resolveInfo.loadLabel(packageManager));
            nVar.setIcon(resolveInfo.loadIcon(packageManager));
            nVar.setIntent(intent2);
            if (menuItemArr != null && (i12 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i12] = nVar;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i10, CharSequence charSequence) {
        n nVar = (n) a(i, i3, i10, charSequence);
        d0 d0Var = new d0(this.f7583a, this, nVar);
        nVar.f7623o = d0Var;
        d0Var.setHeaderTitle(nVar.f7614e);
        return d0Var;
    }

    public final void b(x xVar, Context context) {
        this.f7602u.add(new WeakReference(xVar));
        xVar.i(context, this);
        this.f7592k = true;
    }

    public final void c(boolean z10) {
        if (this.f7600s) {
            return;
        }
        this.f7600s = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7602u;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            x xVar = (x) weakReference.get();
            if (xVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                xVar.d(this, z10);
            }
        }
        this.f7600s = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        n nVar = this.f7603v;
        if (nVar != null) {
            d(nVar);
        }
        this.f7588f.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f7595n = null;
        this.f7594m = null;
        this.f7596o = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(n nVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7602u;
        boolean zK = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f7603v == nVar) {
            w();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                x xVar = (x) weakReference.get();
                if (xVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zK = xVar.k(nVar);
                    if (zK) {
                        break;
                    }
                }
            }
            v();
            if (zK) {
                this.f7603v = null;
            }
        }
        return zK;
    }

    public boolean e(l lVar, MenuItem menuItem) {
        j jVar = this.f7587e;
        return jVar != null && jVar.j(lVar, menuItem);
    }

    public boolean f(n nVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7602u;
        boolean zE = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        w();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            x xVar = (x) weakReference.get();
            if (xVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                zE = xVar.e(nVar);
                if (zE) {
                    break;
                }
            }
        }
        v();
        if (zE) {
            this.f7603v = nVar;
        }
        return zE;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.f7588f;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = (n) arrayList.get(i3);
            if (nVar.f7610a == i) {
                return nVar;
            }
            if (nVar.hasSubMenu() && (menuItemFindItem = nVar.f7623o.findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final n g(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.f7601t;
        arrayList.clear();
        h(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (n) arrayList.get(0);
        }
        boolean zN = n();
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = (n) arrayList.get(i3);
            char c9 = zN ? nVar.f7618j : nVar.f7617h;
            char[] cArr = keyData.meta;
            if ((c9 == cArr[0] && (metaState & 2) == 0) || ((c9 == cArr[2] && (metaState & 2) != 0) || (zN && c9 == '\b' && i == 67))) {
                return nVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return (MenuItem) this.f7588f.get(i);
    }

    public final void h(List list, int i, KeyEvent keyEvent) {
        boolean zN = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            ArrayList arrayList = this.f7588f;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                n nVar = (n) arrayList.get(i3);
                if (nVar.hasSubMenu()) {
                    nVar.f7623o.h(list, i, keyEvent);
                }
                char c9 = zN ? nVar.f7618j : nVar.f7617h;
                if ((modifiers & 69647) == ((zN ? nVar.f7619k : nVar.i) & 69647) && c9 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c9 == cArr[0] || c9 == cArr[2] || (zN && c9 == '\b' && i == 67)) && nVar.isEnabled()) {
                        list.add(nVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f7605x) {
            return true;
        }
        ArrayList arrayList = this.f7588f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((n) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList arrayListL = l();
        if (this.f7592k) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f7602u;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean zA = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                x xVar = (x) weakReference.get();
                if (xVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zA |= xVar.a();
                }
            }
            ArrayList arrayList = this.i;
            ArrayList arrayList2 = this.f7591j;
            if (zA) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListL.size();
                for (int i = 0; i < size; i++) {
                    n nVar = (n) arrayListL.get(i);
                    if ((nVar.f7632x & 32) == 32) {
                        arrayList.add(nVar);
                    } else {
                        arrayList2.add(nVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f7592k = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return g(i, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList l() {
        boolean z10 = this.f7590h;
        ArrayList arrayList = this.f7589g;
        if (!z10) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f7588f;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            n nVar = (n) arrayList2.get(i);
            if (nVar.isVisible()) {
                arrayList.add(nVar);
            }
        }
        this.f7590h = false;
        this.f7592k = true;
        return arrayList;
    }

    public boolean m() {
        return this.f7604w;
    }

    public boolean n() {
        return this.f7585c;
    }

    public boolean o() {
        return this.f7586d;
    }

    public final void p(boolean z10) {
        if (this.f7597p) {
            this.f7598q = true;
            if (z10) {
                this.f7599r = true;
                return;
            }
            return;
        }
        if (z10) {
            this.f7590h = true;
            this.f7592k = true;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7602u;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        w();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            x xVar = (x) weakReference.get();
            if (xVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                xVar.c();
            }
        }
        v();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i3) {
        return q(findItem(i), null, i3);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i3) {
        n nVarG = g(i, keyEvent);
        boolean zQ = nVarG != null ? q(nVarG, null, i3) : false;
        if ((i3 & 2) != 0) {
            c(true);
        }
        return zQ;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MenuItem r7, l.x r8, int r9) {
        /*
            r6 = this;
            l.n r7 = (l.n) r7
            r0 = 0
            if (r7 == 0) goto Lcc
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Lcc
        Ld:
            l.l r1 = r7.f7622n
            android.view.MenuItem$OnMenuItemClickListener r2 = r7.f7624p
            r3 = 1
            if (r2 == 0) goto L1c
            boolean r2 = r2.onMenuItemClick(r7)
            if (r2 == 0) goto L1c
        L1a:
            r1 = r3
            goto L41
        L1c:
            boolean r2 = r1.e(r1, r7)
            if (r2 == 0) goto L23
            goto L1a
        L23:
            android.content.Intent r2 = r7.f7616g
            if (r2 == 0) goto L35
            android.content.Context r1 = r1.f7583a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r2)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L1a
        L2d:
            r1 = move-exception
            java.lang.String r2 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r2, r4, r1)
        L35:
            n3.d r1 = r7.A
            if (r1 == 0) goto L40
            boolean r1 = r1.d()
            if (r1 == 0) goto L40
            goto L1a
        L40:
            r1 = r0
        L41:
            n3.d r2 = r7.A
            if (r2 == 0) goto L4d
            boolean r4 = r2.a()
            if (r4 == 0) goto L4d
            r4 = r3
            goto L4e
        L4d:
            r4 = r0
        L4e:
            boolean r5 = r7.e()
            if (r5 == 0) goto L60
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Lcb
            r6.c(r3)
            goto Lcb
        L60:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L71
            if (r4 == 0) goto L69
            goto L71
        L69:
            r7 = r9 & 1
            if (r7 != 0) goto Lcb
            r6.c(r3)
            goto Lcb
        L71:
            r9 = r9 & 4
            if (r9 != 0) goto L78
            r6.c(r0)
        L78:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L8c
            l.d0 r9 = new l.d0
            android.content.Context r5 = r6.f7583a
            r9.<init>(r5, r6, r7)
            r7.f7623o = r9
            java.lang.CharSequence r5 = r7.f7614e
            r9.setHeaderTitle(r5)
        L8c:
            l.d0 r7 = r7.f7623o
            if (r4 == 0) goto L93
            r2.e(r7)
        L93:
            java.util.concurrent.CopyOnWriteArrayList r9 = r6.f7602u
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L9c
            goto Lc5
        L9c:
            if (r8 == 0) goto La2
            boolean r0 = r8.j(r7)
        La2:
            java.util.Iterator r8 = r9.iterator()
        La6:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lc5
            java.lang.Object r2 = r8.next()
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            java.lang.Object r4 = r2.get()
            l.x r4 = (l.x) r4
            if (r4 != 0) goto Lbe
            r9.remove(r2)
            goto La6
        Lbe:
            if (r0 != 0) goto La6
            boolean r0 = r4.j(r7)
            goto La6
        Lc5:
            r1 = r1 | r0
            if (r1 != 0) goto Lcb
            r6.c(r3)
        Lcb:
            return r1
        Lcc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l.l.q(android.view.MenuItem, l.x, int):boolean");
    }

    public final void r(x xVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7602u;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            x xVar2 = (x) weakReference.get();
            if (xVar2 == null || xVar2 == xVar) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayList arrayList = this.f7588f;
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (((n) arrayList.get(i10)).f7611b == i) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            int size2 = arrayList.size() - i10;
            while (true) {
                int i11 = i3 + 1;
                if (i3 >= size2 || ((n) arrayList.get(i10)).f7611b != i) {
                    break;
                }
                if (i10 >= 0 && i10 < arrayList.size()) {
                    arrayList.remove(i10);
                }
                i3 = i11;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayList arrayList = this.f7588f;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (((n) arrayList.get(i3)).f7610a == i) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 < 0 || i3 >= arrayList.size()) {
            return;
        }
        arrayList.remove(i3);
        p(true);
    }

    public final void s(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.f7588f.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((d0) item.getSubMenu()).s(bundle);
            }
        }
        int i3 = bundle.getInt("android:menu:expandedactionview");
        if (i3 <= 0 || (menuItemFindItem = findItem(i3)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z10, boolean z11) {
        ArrayList arrayList = this.f7588f;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = (n) arrayList.get(i3);
            if (nVar.f7611b == i) {
                nVar.f7632x = (nVar.f7632x & (-5)) | (z11 ? 4 : 0);
                nVar.setCheckable(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f7604w = z10;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z10) {
        ArrayList arrayList = this.f7588f;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = (n) arrayList.get(i3);
            if (nVar.f7611b == i) {
                nVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z10) {
        ArrayList arrayList = this.f7588f;
        int size = arrayList.size();
        boolean z11 = false;
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = (n) arrayList.get(i3);
            if (nVar.f7611b == i) {
                int i10 = nVar.f7632x;
                int i11 = (i10 & (-9)) | (z10 ? 0 : 8);
                nVar.f7632x = i11;
                if (i10 != i11) {
                    z11 = true;
                }
            }
        }
        if (z11) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f7585c = z10;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f7588f.size();
    }

    public final void t(Bundle bundle) {
        int size = this.f7588f.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
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
                ((d0) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i, CharSequence charSequence, int i3, Drawable drawable, View view) {
        if (view != null) {
            this.f7596o = view;
            this.f7594m = null;
            this.f7595n = null;
        } else {
            if (i > 0) {
                this.f7594m = this.f7584b.getText(i);
            } else if (charSequence != null) {
                this.f7594m = charSequence;
            }
            if (i3 > 0) {
                this.f7595n = this.f7583a.getDrawable(i3);
            } else if (drawable != null) {
                this.f7595n = drawable;
            }
            this.f7596o = null;
        }
        p(false);
    }

    public final void v() {
        this.f7597p = false;
        if (this.f7598q) {
            this.f7598q = false;
            p(this.f7599r);
        }
    }

    public final void w() {
        if (this.f7597p) {
            return;
        }
        this.f7597p = true;
        this.f7598q = false;
        this.f7599r = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i3, int i10, CharSequence charSequence) {
        return a(i, i3, i10, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i3, int i10, int i11) {
        return a(i, i3, i10, this.f7584b.getString(i11));
    }

    public l k() {
        return this;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f7584b.getString(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i10, int i11) {
        return addSubMenu(i, i3, i10, this.f7584b.getString(i11));
    }
}
