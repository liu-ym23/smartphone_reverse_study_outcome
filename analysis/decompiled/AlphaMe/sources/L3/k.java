package L3;

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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class k implements F.a, f {

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f1280v = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f1281a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f1282b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1283c;

    /* renamed from: d, reason: collision with root package name */
    public i f1284d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f1285e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f1286f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1287g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f1288h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f1289i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1290j;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f1292l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f1293m;

    /* renamed from: n, reason: collision with root package name */
    public View f1294n;

    /* renamed from: t, reason: collision with root package name */
    public l f1300t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1301u;

    /* renamed from: k, reason: collision with root package name */
    public int f1291k = 0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1295o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1296p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1297q = false;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f1298r = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public final CopyOnWriteArrayList f1299s = new CopyOnWriteArrayList();

    public k(Context context) {
        this.f1281a = context;
        Resources resources = context.getResources();
        this.f1282b = resources;
        this.f1285e = new ArrayList();
        this.f1286f = new ArrayList();
        this.f1287g = true;
        this.f1288h = new ArrayList();
        this.f1289i = new ArrayList();
        this.f1290j = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration.get(context);
        }
    }

    public final MenuItem a(int i4, int i5, int i6, CharSequence charSequence) {
        int i7;
        int i8 = ((-65536) & i6) >> 16;
        if (i8 < 0 || i8 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i9 = (f1280v[i8] << 16) | (65535 & i6);
        l lVar = new l(this, i4, i5, i6, i9, charSequence, this.f1291k);
        ArrayList arrayList = this.f1285e;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i7 = 0;
                break;
            }
            if (((l) arrayList.get(size)).f1308d <= i9) {
                i7 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i7, lVar);
        o(true);
        return lVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i4, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        int i8;
        PackageManager packageManager = this.f1281a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i7 & 1) == 0) {
            removeGroup(i4);
        }
        for (int i9 = 0; i9 < size; i9++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i9);
            int i10 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i10 < 0 ? intent : intentArr[i10]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            l lVar = (l) a(i4, i5, i6, resolveInfo.loadLabel(packageManager));
            lVar.setIcon(resolveInfo.loadIcon(packageManager));
            lVar.setIntent(intent2);
            if (menuItemArr != null && (i8 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i8] = lVar;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(w wVar, Context context) {
        this.f1299s.add(new WeakReference(wVar));
        wVar.g(context, this);
        this.f1290j = true;
    }

    public final void c(boolean z4) {
        if (this.f1297q) {
            return;
        }
        this.f1297q = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1299s;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            w wVar = (w) weakReference.get();
            if (wVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                wVar.d(this, z4);
            }
        }
        this.f1297q = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        l lVar = this.f1300t;
        if (lVar != null) {
            d(lVar);
        }
        this.f1285e.clear();
        o(true);
    }

    public final void clearHeader() {
        this.f1293m = null;
        this.f1292l = null;
        this.f1294n = null;
        o(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(l lVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1299s;
        boolean zF = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f1300t == lVar) {
            v();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                w wVar = (w) weakReference.get();
                if (wVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zF = wVar.f(lVar);
                    if (zF) {
                        break;
                    }
                }
            }
            u();
            if (zF) {
                this.f1300t = null;
            }
        }
        return zF;
    }

    public boolean e(k kVar, MenuItem menuItem) {
        i iVar = this.f1284d;
        return iVar != null && iVar.b(kVar, menuItem);
    }

    public boolean f(l lVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1299s;
        boolean zH = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        v();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            w wVar = (w) weakReference.get();
            if (wVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                zH = wVar.h(lVar);
                if (zH) {
                    break;
                }
            }
        }
        u();
        if (zH) {
            this.f1300t = lVar;
        }
        return zH;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i4) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.f1285e;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            l lVar = (l) arrayList.get(i5);
            if (lVar.f1305a == i4) {
                return lVar;
            }
            if (lVar.hasSubMenu() && (menuItemFindItem = lVar.f1319o.findItem(i4)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final l g(int i4, KeyEvent keyEvent) {
        ArrayList arrayList = this.f1298r;
        arrayList.clear();
        h(arrayList, i4, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (l) arrayList.get(0);
        }
        boolean zM = m();
        for (int i5 = 0; i5 < size; i5++) {
            l lVar = (l) arrayList.get(i5);
            char c4 = zM ? lVar.f1314j : lVar.f1312h;
            char[] cArr = keyData.meta;
            if ((c4 == cArr[0] && (metaState & 2) == 0) || ((c4 == cArr[2] && (metaState & 2) != 0) || (zM && c4 == '\b' && i4 == 67))) {
                return lVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i4) {
        return (MenuItem) this.f1285e.get(i4);
    }

    public final void h(ArrayList arrayList, int i4, KeyEvent keyEvent) {
        boolean zM = m();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i4 == 67) {
            ArrayList arrayList2 = this.f1285e;
            int size = arrayList2.size();
            for (int i5 = 0; i5 < size; i5++) {
                l lVar = (l) arrayList2.get(i5);
                if (lVar.hasSubMenu()) {
                    lVar.f1319o.h(arrayList, i4, keyEvent);
                }
                char c4 = zM ? lVar.f1314j : lVar.f1312h;
                if ((metaState & 5) == 0 && c4 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c4 == cArr[0] || c4 == cArr[2] || (zM && c4 == '\b' && i4 == 67)) && lVar.isEnabled()) {
                        arrayList.add(lVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f1301u) {
            return true;
        }
        ArrayList arrayList = this.f1285e;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (((l) arrayList.get(i4)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList arrayListL = l();
        if (this.f1290j) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f1299s;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean zC = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                w wVar = (w) weakReference.get();
                if (wVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zC |= wVar.c();
                }
            }
            ArrayList arrayList = this.f1288h;
            ArrayList arrayList2 = this.f1289i;
            if (zC) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListL.size();
                for (int i4 = 0; i4 < size; i4++) {
                    l lVar = (l) arrayListL.get(i4);
                    if (lVar.e()) {
                        arrayList.add(lVar);
                    } else {
                        arrayList2.add(lVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f1290j = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i4, KeyEvent keyEvent) {
        return g(i4, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public k k() {
        return this;
    }

    public final ArrayList l() {
        boolean z4 = this.f1287g;
        ArrayList arrayList = this.f1286f;
        if (!z4) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f1285e;
        int size = arrayList2.size();
        for (int i4 = 0; i4 < size; i4++) {
            l lVar = (l) arrayList2.get(i4);
            if (lVar.isVisible()) {
                arrayList.add(lVar);
            }
        }
        this.f1287g = false;
        this.f1290j = true;
        return arrayList;
    }

    public boolean m() {
        return this.f1283c;
    }

    public boolean n() {
        return false;
    }

    public final void o(boolean z4) {
        if (this.f1295o) {
            this.f1296p = true;
            return;
        }
        if (z4) {
            this.f1287g = true;
            this.f1290j = true;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1299s;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        v();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            w wVar = (w) weakReference.get();
            if (wVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                wVar.a();
            }
        }
        u();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(android.view.MenuItem r8, L3.w r9, int r10) {
        /*
            r7 = this;
            L3.l r8 = (L3.l) r8
            r0 = 0
            if (r8 == 0) goto Lc9
            boolean r1 = r8.isEnabled()
            if (r1 != 0) goto Ld
            goto Lc9
        Ld:
            android.view.MenuItem$OnMenuItemClickListener r1 = r8.f1320p
            r2 = 1
            if (r1 == 0) goto L1a
            boolean r1 = r1.onMenuItemClick(r8)
            if (r1 == 0) goto L1a
        L18:
            r1 = r2
            goto L41
        L1a:
            L3.k r1 = r8.f1318n
            boolean r3 = r1.e(r1, r8)
            if (r3 == 0) goto L23
            goto L18
        L23:
            android.content.Intent r3 = r8.f1311g
            if (r3 == 0) goto L35
            android.content.Context r1 = r1.f1281a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L18
        L2d:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L35:
            K.d r1 = r8.f1302A
            if (r1 == 0) goto L40
            boolean r1 = r1.d()
            if (r1 == 0) goto L40
            goto L18
        L40:
            r1 = r0
        L41:
            K.d r3 = r8.f1302A
            if (r3 == 0) goto L4d
            boolean r4 = r3.a()
            if (r4 == 0) goto L4d
            r4 = r2
            goto L4e
        L4d:
            r4 = r0
        L4e:
            boolean r5 = r8.d()
            if (r5 == 0) goto L60
            boolean r8 = r8.expandActionView()
            r1 = r1 | r8
            if (r1 == 0) goto Lc8
            r7.c(r2)
            goto Lc8
        L60:
            boolean r5 = r8.hasSubMenu()
            if (r5 != 0) goto L71
            if (r4 == 0) goto L69
            goto L71
        L69:
            r8 = r10 & 1
            if (r8 != 0) goto Lc8
            r7.c(r2)
            goto Lc8
        L71:
            r7.c(r0)
            boolean r10 = r8.hasSubMenu()
            if (r10 != 0) goto L89
            L3.A r10 = new L3.A
            android.content.Context r5 = r7.f1281a
            r10.<init>(r5, r7, r8)
            r8.f1319o = r10
            java.lang.CharSequence r5 = r8.f1309e
            r6 = 0
            r10.t(r5, r6, r6)
        L89:
            L3.A r8 = r8.f1319o
            if (r4 == 0) goto L90
            r3.e(r8)
        L90:
            java.util.concurrent.CopyOnWriteArrayList r10 = r7.f1299s
            boolean r3 = r10.isEmpty()
            if (r3 == 0) goto L99
            goto Lc2
        L99:
            if (r9 == 0) goto L9f
            boolean r0 = r9.e(r8)
        L9f:
            java.util.Iterator r9 = r10.iterator()
        La3:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto Lc2
            java.lang.Object r3 = r9.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            java.lang.Object r4 = r3.get()
            L3.w r4 = (L3.w) r4
            if (r4 != 0) goto Lbb
            r10.remove(r3)
            goto La3
        Lbb:
            if (r0 != 0) goto La3
            boolean r0 = r4.e(r8)
            goto La3
        Lc2:
            r1 = r1 | r0
            if (r1 != 0) goto Lc8
            r7.c(r2)
        Lc8:
            return r1
        Lc9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: L3.k.p(android.view.MenuItem, L3.w, int):boolean");
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i4, int i5) {
        return p(findItem(i4), null, i5);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i4, KeyEvent keyEvent, int i5) {
        l lVarG = g(i4, keyEvent);
        boolean zP = lVarG != null ? p(lVarG, null, i5) : false;
        if ((i5 & 2) != 0) {
            c(true);
        }
        return zP;
    }

    public final void q(w wVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1299s;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            w wVar2 = (w) weakReference.get();
            if (wVar2 == null || wVar2 == wVar) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    public final void r(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.f1285e.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = getItem(i4);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((A) item.getSubMenu()).r(bundle);
            }
        }
        int i5 = bundle.getInt("android:menu:expandedactionview");
        if (i5 <= 0 || (menuItemFindItem = findItem(i5)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void removeGroup(int i4) {
        ArrayList arrayList = this.f1285e;
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            } else if (((l) arrayList.get(i6)).f1306b == i4) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 >= 0) {
            int size2 = arrayList.size() - i6;
            while (true) {
                int i7 = i5 + 1;
                if (i5 >= size2 || ((l) arrayList.get(i6)).f1306b != i4) {
                    break;
                }
                if (i6 >= 0) {
                    ArrayList arrayList2 = this.f1285e;
                    if (i6 < arrayList2.size()) {
                        arrayList2.remove(i6);
                    }
                }
                i5 = i7;
            }
            o(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i4) {
        ArrayList arrayList = this.f1285e;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i5 = -1;
                break;
            } else if (((l) arrayList.get(i5)).f1305a == i4) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 >= 0) {
            ArrayList arrayList2 = this.f1285e;
            if (i5 >= arrayList2.size()) {
                return;
            }
            arrayList2.remove(i5);
            o(true);
        }
    }

    public final void s(Bundle bundle) {
        int size = this.f1285e.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = getItem(i4);
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
                ((A) item.getSubMenu()).s(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i4, boolean z4, boolean z5) {
        ArrayList arrayList = this.f1285e;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            l lVar = (l) arrayList.get(i5);
            if (lVar.f1306b == i4) {
                lVar.f1328x = (lVar.f1328x & (-5)) | (z5 ? 4 : 0);
                lVar.setCheckable(z4);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupDividerEnabled(boolean z4) {
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i4, boolean z4) {
        ArrayList arrayList = this.f1285e;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            l lVar = (l) arrayList.get(i5);
            if (lVar.f1306b == i4) {
                lVar.setEnabled(z4);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i4, boolean z4) {
        ArrayList arrayList = this.f1285e;
        int size = arrayList.size();
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            l lVar = (l) arrayList.get(i5);
            if (lVar.f1306b == i4) {
                int i6 = lVar.f1328x;
                int i7 = (i6 & (-9)) | (z4 ? 0 : 8);
                lVar.f1328x = i7;
                if (i6 != i7) {
                    z5 = true;
                }
            }
        }
        if (z5) {
            o(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z4) {
        this.f1283c = z4;
        o(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f1285e.size();
    }

    public final void t(CharSequence charSequence, Drawable drawable, View view) {
        if (view != null) {
            this.f1294n = view;
            this.f1292l = null;
            this.f1293m = null;
        } else {
            if (charSequence != null) {
                this.f1292l = charSequence;
            }
            if (drawable != null) {
                this.f1293m = drawable;
            }
            this.f1294n = null;
        }
        o(false);
    }

    public final void u() {
        this.f1295o = false;
        if (this.f1296p) {
            this.f1296p = false;
            o(true);
        }
    }

    public final void v() {
        if (this.f1295o) {
            return;
        }
        this.f1295o = true;
        this.f1296p = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4) {
        return a(0, 0, 0, this.f1282b.getString(i4));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4) {
        return addSubMenu(0, 0, 0, this.f1282b.getString(i4));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, CharSequence charSequence) {
        return a(i4, i5, i6, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        l lVar = (l) a(i4, i5, i6, charSequence);
        A a4 = new A(this.f1281a, this, lVar);
        lVar.f1319o = a4;
        a4.t(lVar.f1309e, null, null);
        return a4;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, int i7) {
        return a(i4, i5, i6, this.f1282b.getString(i7));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, int i7) {
        return addSubMenu(i4, i5, i6, this.f1282b.getString(i7));
    }
}
