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

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class f implements p0.a {
    public static final int[] C = {1, 4, 5, 3, 2, 0};
    public boolean B;

    /* renamed from: a, reason: collision with root package name */
    public final Context f478a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f479b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f480c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f481d;

    /* renamed from: e, reason: collision with root package name */
    public a f482e;
    public final ArrayList<h> h;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList<h> f483j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f484k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList<h> f485l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList<h> f486m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f487n;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f489p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f490q;
    public View r;
    public h z;

    /* renamed from: o, reason: collision with root package name */
    public int f488o = 0;

    /* renamed from: s, reason: collision with root package name */
    public boolean f491s = false;

    /* renamed from: t, reason: collision with root package name */
    public boolean f492t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f493u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f494v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f495w = false;

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList<h> f496x = new ArrayList<>();

    /* renamed from: y, reason: collision with root package name */
    public final CopyOnWriteArrayList<WeakReference<j>> f497y = new CopyOnWriteArrayList<>();
    public boolean A = false;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        boolean a(f fVar, MenuItem menuItem);

        void b(f fVar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        boolean e(h hVar);
    }

    public f(Context context) {
        boolean z = false;
        this.f478a = context;
        Resources resources = context.getResources();
        this.f479b = resources;
        this.h = new ArrayList<>();
        this.f483j = new ArrayList<>();
        this.f484k = true;
        this.f485l = new ArrayList<>();
        this.f486m = new ArrayList<>();
        this.f487n = true;
        if (resources.getConfiguration().keyboard != 1 && ViewConfiguration.get(context).shouldShowMenuShortcutsWhenKeyboardPresent()) {
            z = true;
        }
        this.f481d = z;
    }

    public final MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        int i13;
        int i14 = ((-65536) & i12) >> 16;
        if (i14 < 0 || i14 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i15 = (C[i14] << 16) | (65535 & i12);
        h hVar = new h(this, i10, i11, i12, i15, charSequence, this.f488o);
        ArrayList<h> arrayList = this.h;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i13 = 0;
                break;
            }
            if (arrayList.get(size).f504d <= i15) {
                i13 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i13, hVar);
        p(true);
        return hVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        PackageManager packageManager = this.f478a.getPackageManager();
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
            h hVar = (h) a(i10, i11, i12, resolveInfo.loadLabel(packageManager));
            hVar.setIcon(resolveInfo.loadIcon(packageManager));
            hVar.setIntent(intent2);
            if (menuItemArr != null && (i14 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i14] = hVar;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(j jVar, Context context) {
        this.f497y.add(new WeakReference<>(jVar));
        jVar.h(context, this);
        this.f487n = true;
    }

    public final void c(boolean z) {
        if (this.f495w) {
            return;
        }
        this.f495w = true;
        CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList = this.f497y;
        Iterator<WeakReference<j>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar = next.get();
            if (jVar == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                jVar.a(this, z);
            }
        }
        this.f495w = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        h hVar = this.z;
        if (hVar != null) {
            d(hVar);
        }
        this.h.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f490q = null;
        this.f489p = null;
        this.r = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(h hVar) {
        CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList = this.f497y;
        boolean zE = false;
        if (!copyOnWriteArrayList.isEmpty() && this.z == hVar) {
            w();
            Iterator<WeakReference<j>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    copyOnWriteArrayList.remove(next);
                } else {
                    zE = jVar.e(hVar);
                    if (zE) {
                        break;
                    }
                }
            }
            v();
            if (zE) {
                this.z = null;
            }
        }
        return zE;
    }

    public boolean e(f fVar, MenuItem menuItem) {
        a aVar = this.f482e;
        return aVar != null && aVar.a(fVar, menuItem);
    }

    public boolean f(h hVar) {
        CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList = this.f497y;
        boolean zG = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        w();
        Iterator<WeakReference<j>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar = next.get();
            if (jVar == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                zG = jVar.g(hVar);
                if (zG) {
                    break;
                }
            }
        }
        v();
        if (zG) {
            this.z = hVar;
        }
        return zG;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i10) {
        MenuItem menuItemFindItem;
        ArrayList<h> arrayList = this.h;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = arrayList.get(i11);
            if (hVar.f501a == i10) {
                return hVar;
            }
            if (hVar.hasSubMenu() && (menuItemFindItem = hVar.r.findItem(i10)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final h g(int i10, KeyEvent keyEvent) {
        ArrayList<h> arrayList = this.f496x;
        arrayList.clear();
        h(arrayList, i10, keyEvent);
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
        boolean zN = n();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = arrayList.get(i11);
            char c9 = zN ? hVar.f509m : hVar.f507k;
            char[] cArr = keyData.meta;
            if ((c9 == cArr[0] && (metaState & 2) == 0) || ((c9 == cArr[2] && (metaState & 2) != 0) || (zN && c9 == '\b' && i10 == 67))) {
                return hVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i10) {
        return this.h.get(i10);
    }

    public final void h(List<h> list, int i10, KeyEvent keyEvent) {
        boolean zN = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i10 == 67) {
            ArrayList<h> arrayList = this.h;
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = arrayList.get(i11);
                if (hVar.hasSubMenu()) {
                    hVar.r.h(list, i10, keyEvent);
                }
                char c9 = zN ? hVar.f509m : hVar.f507k;
                if ((modifiers & 69647) == ((zN ? hVar.f510n : hVar.f508l) & 69647) && c9 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c9 == cArr[0] || c9 == cArr[2] || (zN && c9 == '\b' && i10 == 67)) && hVar.isEnabled()) {
                        list.add(hVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.B) {
            return true;
        }
        ArrayList<h> arrayList = this.h;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (arrayList.get(i10).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList<h> arrayListL = l();
        if (this.f487n) {
            CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList = this.f497y;
            Iterator<WeakReference<j>> it = copyOnWriteArrayList.iterator();
            boolean zC = false;
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    copyOnWriteArrayList.remove(next);
                } else {
                    zC |= jVar.c();
                }
            }
            ArrayList<h> arrayList = this.f485l;
            ArrayList<h> arrayList2 = this.f486m;
            if (zC) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListL.size();
                for (int i10 = 0; i10 < size; i10++) {
                    h hVar = arrayListL.get(i10);
                    if ((hVar.A & 32) == 32) {
                        arrayList.add(hVar);
                    } else {
                        arrayList2.add(hVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f487n = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return g(i10, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList<h> l() {
        boolean z = this.f484k;
        ArrayList<h> arrayList = this.f483j;
        if (!z) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList<h> arrayList2 = this.h;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            h hVar = arrayList2.get(i10);
            if (hVar.isVisible()) {
                arrayList.add(hVar);
            }
        }
        this.f484k = false;
        this.f487n = true;
        return arrayList;
    }

    public boolean m() {
        return this.A;
    }

    public boolean n() {
        return this.f480c;
    }

    public boolean o() {
        return this.f481d;
    }

    public final void p(boolean z) {
        if (this.f491s) {
            this.f492t = true;
            if (z) {
                this.f493u = true;
                return;
            }
            return;
        }
        if (z) {
            this.f484k = true;
            this.f487n = true;
        }
        CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList = this.f497y;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        w();
        Iterator<WeakReference<j>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar = next.get();
            if (jVar == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                jVar.b();
            }
        }
        v();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i10, int i11) {
        return q(findItem(i10), null, i11);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        h hVarG = g(i10, keyEvent);
        boolean zQ = hVarG != null ? q(hVarG, null, i11) : false;
        if ((i11 & 2) != 0) {
            c(true);
        }
        return zQ;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MenuItem r7, androidx.appcompat.view.menu.j r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.h r7 = (androidx.appcompat.view.menu.h) r7
            r0 = 0
            if (r7 == 0) goto Lcc
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Lcc
        Ld:
            androidx.appcompat.view.menu.f r1 = r7.f513q
            android.view.MenuItem$OnMenuItemClickListener r2 = r7.f514s
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
            android.content.Intent r2 = r7.f506j
            if (r2 == 0) goto L35
            android.content.Context r1 = r1.f478a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r2)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L1a
        L2d:
            r1 = move-exception
            java.lang.String r2 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r2, r4, r1)
        L35:
            v0.b r1 = r7.D
            if (r1 == 0) goto L40
            boolean r1 = r1.e()
            if (r1 == 0) goto L40
            goto L1a
        L40:
            r1 = r0
        L41:
            v0.b r2 = r7.D
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
            androidx.appcompat.view.menu.m r9 = new androidx.appcompat.view.menu.m
            android.content.Context r5 = r6.f478a
            r9.<init>(r5, r6, r7)
            r7.r = r9
            java.lang.CharSequence r5 = r7.f505e
            r9.setHeaderTitle(r5)
        L8c:
            androidx.appcompat.view.menu.m r7 = r7.r
            if (r4 == 0) goto L93
            r2.f(r7)
        L93:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<androidx.appcompat.view.menu.j>> r9 = r6.f497y
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L9c
            goto Lc5
        L9c:
            if (r8 == 0) goto La2
            boolean r0 = r8.f(r7)
        La2:
            java.util.Iterator r8 = r9.iterator()
        La6:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lc5
            java.lang.Object r2 = r8.next()
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            java.lang.Object r4 = r2.get()
            androidx.appcompat.view.menu.j r4 = (androidx.appcompat.view.menu.j) r4
            if (r4 != 0) goto Lbe
            r9.remove(r2)
            goto La6
        Lbe:
            if (r0 != 0) goto La6
            boolean r0 = r4.f(r7)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.f.q(android.view.MenuItem, androidx.appcompat.view.menu.j, int):boolean");
    }

    public final void r(j jVar) {
        CopyOnWriteArrayList<WeakReference<j>> copyOnWriteArrayList = this.f497y;
        Iterator<WeakReference<j>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar2 = next.get();
            if (jVar2 == null || jVar2 == jVar) {
                copyOnWriteArrayList.remove(next);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i10) {
        ArrayList<h> arrayList = this.h;
        int size = arrayList.size();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                i12 = -1;
                break;
            } else if (arrayList.get(i12).f502b == i10) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 >= 0) {
            int size2 = arrayList.size() - i12;
            while (true) {
                int i13 = i11 + 1;
                if (i11 >= size2 || arrayList.get(i12).f502b != i10) {
                    break;
                }
                if (i12 >= 0 && i12 < arrayList.size()) {
                    arrayList.remove(i12);
                }
                i11 = i13;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i10) {
        ArrayList<h> arrayList = this.h;
        int size = arrayList.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (arrayList.get(i11).f501a == i10) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 < 0 || i11 >= arrayList.size()) {
            return;
        }
        arrayList.remove(i11);
        p(true);
    }

    public final void s(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.h.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).s(bundle);
            }
        }
        int i11 = bundle.getInt("android:menu:expandedactionview");
        if (i11 <= 0 || (menuItemFindItem = findItem(i11)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i10, boolean z, boolean z3) {
        ArrayList<h> arrayList = this.h;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = arrayList.get(i11);
            if (hVar.f502b == i10) {
                hVar.A = (hVar.A & (-5)) | (z3 ? 4 : 0);
                hVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.A = z;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i10, boolean z) {
        ArrayList<h> arrayList = this.h;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = arrayList.get(i11);
            if (hVar.f502b == i10) {
                hVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i10, boolean z) {
        ArrayList<h> arrayList = this.h;
        int size = arrayList.size();
        boolean z3 = false;
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = arrayList.get(i11);
            if (hVar.f502b == i10) {
                int i12 = hVar.A;
                int i13 = (i12 & (-9)) | (z ? 0 : 8);
                hVar.A = i13;
                if (i12 != i13) {
                    z3 = true;
                }
            }
        }
        if (z3) {
            p(true);
        }
    }

    public final void setOptionalIconsVisible(boolean z) {
        this.f494v = z;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f480c = z;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.h.size();
    }

    public final void t(Bundle bundle) {
        int size = this.h.size();
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
                ((m) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        if (view != null) {
            this.r = view;
            this.f489p = null;
            this.f490q = null;
        } else {
            if (i10 > 0) {
                this.f489p = this.f479b.getText(i10);
            } else if (charSequence != null) {
                this.f489p = charSequence;
            }
            if (i11 > 0) {
                this.f490q = this.f478a.getDrawable(i11);
            } else if (drawable != null) {
                this.f490q = drawable;
            }
            this.r = null;
        }
        p(false);
    }

    public final void v() {
        this.f491s = false;
        if (this.f492t) {
            this.f492t = false;
            p(this.f493u);
        }
    }

    public final void w() {
        if (this.f491s) {
            return;
        }
        this.f491s = true;
        this.f492t = false;
        this.f493u = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i10) {
        return a(0, 0, 0, this.f479b.getString(i10));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, this.f479b.getString(i10));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(i10, i11, i12, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        h hVar = (h) a(i10, i11, i12, charSequence);
        m mVar = new m(this.f478a, this, hVar);
        hVar.r = mVar;
        mVar.setHeaderTitle(hVar.f505e);
        return mVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i10, int i11, int i12, int i13) {
        return a(i10, i11, i12, this.f479b.getString(i13));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, this.f479b.getString(i13));
    }

    public f k() {
        return this;
    }
}
