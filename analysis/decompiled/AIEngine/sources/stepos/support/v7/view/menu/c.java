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
public class c implements p0.a, ge.f {
    public static final int[] z = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f12374a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f12375b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12376c;

    /* renamed from: d, reason: collision with root package name */
    public a f12377d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<e> f12378e;
    public final ArrayList<e> h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12379j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList<e> f12380k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList<e> f12381l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12382m;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f12384o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f12385p;

    /* renamed from: q, reason: collision with root package name */
    public View f12386q;

    /* renamed from: x, reason: collision with root package name */
    public e f12392x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f12393y;

    /* renamed from: n, reason: collision with root package name */
    public int f12383n = 0;
    public boolean r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12387s = false;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12388t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f12389u = false;

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList<e> f12390v = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    public final CopyOnWriteArrayList<WeakReference<g>> f12391w = new CopyOnWriteArrayList<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void a(c cVar);

        boolean b(c cVar, MenuItem menuItem);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        boolean b(e eVar);
    }

    public c(Context context) {
        this.f12374a = context;
        Resources resources = context.getResources();
        this.f12375b = resources;
        this.f12378e = new ArrayList<>();
        this.h = new ArrayList<>();
        this.f12379j = true;
        this.f12380k = new ArrayList<>();
        this.f12381l = new ArrayList<>();
        this.f12382m = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration.get(context);
        }
    }

    public final MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        int i13;
        int i14 = ((-65536) & i12) >> 16;
        if (i14 < 0 || i14 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i15 = (z[i14] << 16) | (65535 & i12);
        e eVar = new e(this, i10, i11, i12, i15, charSequence, this.f12383n);
        ArrayList<e> arrayList = this.f12378e;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i13 = 0;
                break;
            }
            if (arrayList.get(size).f12400d <= i15) {
                i13 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i13, eVar);
        o(true);
        return eVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        PackageManager packageManager = this.f12374a.getPackageManager();
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
            e eVar = (e) a(i10, i11, i12, resolveInfo.loadLabel(packageManager));
            eVar.setIcon(resolveInfo.loadIcon(packageManager));
            eVar.setIntent(intent2);
            if (menuItemArr != null && (i14 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i14] = eVar;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(g gVar, Context context) {
        this.f12391w.add(new WeakReference<>(gVar));
        gVar.g(context, this);
        this.f12382m = true;
    }

    public final void c(boolean z3) {
        if (this.f12389u) {
            return;
        }
        this.f12389u = true;
        CopyOnWriteArrayList<WeakReference<g>> copyOnWriteArrayList = this.f12391w;
        Iterator<WeakReference<g>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<g> next = it.next();
            g gVar = next.get();
            if (gVar == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                gVar.a(this, z3);
            }
        }
        this.f12389u = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        e eVar = this.f12392x;
        if (eVar != null) {
            d(eVar);
        }
        this.f12378e.clear();
        o(true);
    }

    public final void clearHeader() {
        this.f12385p = null;
        this.f12384o = null;
        this.f12386q = null;
        o(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(e eVar) {
        CopyOnWriteArrayList<WeakReference<g>> copyOnWriteArrayList = this.f12391w;
        boolean zD = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f12392x == eVar) {
            v();
            Iterator<WeakReference<g>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference<g> next = it.next();
                g gVar = next.get();
                if (gVar == null) {
                    copyOnWriteArrayList.remove(next);
                } else {
                    zD = gVar.d(eVar);
                    if (zD) {
                        break;
                    }
                }
            }
            u();
            if (zD) {
                this.f12392x = null;
            }
        }
        return zD;
    }

    public boolean e(c cVar, MenuItem menuItem) {
        a aVar = this.f12377d;
        return aVar != null && aVar.b(cVar, menuItem);
    }

    public boolean f(e eVar) {
        CopyOnWriteArrayList<WeakReference<g>> copyOnWriteArrayList = this.f12391w;
        boolean zF = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        v();
        Iterator<WeakReference<g>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<g> next = it.next();
            g gVar = next.get();
            if (gVar == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                zF = gVar.f(eVar);
                if (zF) {
                    break;
                }
            }
        }
        u();
        if (zF) {
            this.f12392x = eVar;
        }
        return zF;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i10) {
        MenuItem menuItemFindItem;
        ArrayList<e> arrayList = this.f12378e;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = arrayList.get(i11);
            if (eVar.f12397a == i10) {
                return eVar;
            }
            if (eVar.hasSubMenu() && (menuItemFindItem = eVar.r.findItem(i10)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final e g(int i10, KeyEvent keyEvent) {
        ArrayList<e> arrayList = this.f12390v;
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
        boolean zM = m();
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = arrayList.get(i11);
            char c9 = zM ? eVar.f12405m : eVar.f12403k;
            char[] cArr = keyData.meta;
            if ((c9 == cArr[0] && (metaState & 2) == 0) || ((c9 == cArr[2] && (metaState & 2) != 0) || (zM && c9 == '\b' && i10 == 67))) {
                return eVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i10) {
        return this.f12378e.get(i10);
    }

    public final void h(List<e> list, int i10, KeyEvent keyEvent) {
        boolean zM = m();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i10 == 67) {
            ArrayList<e> arrayList = this.f12378e;
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                e eVar = arrayList.get(i11);
                if (eVar.hasSubMenu()) {
                    eVar.r.h(list, i10, keyEvent);
                }
                char c9 = zM ? eVar.f12405m : eVar.f12403k;
                if ((metaState & 5) == 0 && c9 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c9 == cArr[0] || c9 == cArr[2] || (zM && c9 == '\b' && i10 == 67)) && eVar.isEnabled()) {
                        list.add(eVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f12393y) {
            return true;
        }
        ArrayList<e> arrayList = this.f12378e;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (arrayList.get(i10).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList<e> arrayListL = l();
        if (this.f12382m) {
            CopyOnWriteArrayList<WeakReference<g>> copyOnWriteArrayList = this.f12391w;
            Iterator<WeakReference<g>> it = copyOnWriteArrayList.iterator();
            boolean zC = false;
            while (it.hasNext()) {
                WeakReference<g> next = it.next();
                g gVar = next.get();
                if (gVar == null) {
                    copyOnWriteArrayList.remove(next);
                } else {
                    zC |= gVar.c();
                }
            }
            ArrayList<e> arrayList = this.f12380k;
            ArrayList<e> arrayList2 = this.f12381l;
            if (zC) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListL.size();
                for (int i10 = 0; i10 < size; i10++) {
                    e eVar = arrayListL.get(i10);
                    if ((eVar.A & 32) == 32) {
                        arrayList.add(eVar);
                    } else {
                        arrayList2.add(eVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f12382m = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return g(i10, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList<e> l() {
        boolean z3 = this.f12379j;
        ArrayList<e> arrayList = this.h;
        if (!z3) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList<e> arrayList2 = this.f12378e;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = arrayList2.get(i10);
            if (eVar.isVisible()) {
                arrayList.add(eVar);
            }
        }
        this.f12379j = false;
        this.f12382m = true;
        return arrayList;
    }

    public boolean m() {
        return this.f12376c;
    }

    public boolean n() {
        return false;
    }

    public final void o(boolean z3) {
        if (this.r) {
            this.f12387s = true;
            return;
        }
        if (z3) {
            this.f12379j = true;
            this.f12382m = true;
        }
        CopyOnWriteArrayList<WeakReference<g>> copyOnWriteArrayList = this.f12391w;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        v();
        Iterator<WeakReference<g>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<g> next = it.next();
            g gVar = next.get();
            if (gVar == null) {
                copyOnWriteArrayList.remove(next);
            } else {
                gVar.b();
            }
        }
        u();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(android.view.MenuItem r8, stepos.support.v7.view.menu.b r9, int r10) {
        /*
            r7 = this;
            stepos.support.v7.view.menu.e r8 = (stepos.support.v7.view.menu.e) r8
            r0 = 0
            if (r8 == 0) goto Lc9
            boolean r1 = r8.isEnabled()
            if (r1 != 0) goto Ld
            goto Lc9
        Ld:
            stepos.support.v7.view.menu.c r1 = r8.f12409q
            android.view.MenuItem$OnMenuItemClickListener r2 = r8.f12410s
            r3 = 1
            if (r2 == 0) goto L1c
            boolean r2 = r2.onMenuItemClick(r8)
            if (r2 == 0) goto L1c
        L1a:
            r1 = r3
            goto L41
        L1c:
            boolean r2 = r1.e(r1, r8)
            if (r2 == 0) goto L23
            goto L1a
        L23:
            android.content.Intent r2 = r8.f12402j
            if (r2 == 0) goto L35
            android.content.Context r1 = r1.f12374a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r2)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L1a
        L2d:
            r1 = move-exception
            java.lang.String r2 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r2, r4, r1)
        L35:
            v0.b r1 = r8.D
            if (r1 == 0) goto L40
            boolean r1 = r1.e()
            if (r1 == 0) goto L40
            goto L1a
        L40:
            r1 = r0
        L41:
            v0.b r2 = r8.D
            if (r2 == 0) goto L4d
            boolean r4 = r2.a()
            if (r4 == 0) goto L4d
            r4 = r3
            goto L4e
        L4d:
            r4 = r0
        L4e:
            boolean r5 = r8.d()
            if (r5 == 0) goto L60
            boolean r8 = r8.expandActionView()
            r1 = r1 | r8
            if (r1 == 0) goto Lc8
            r7.c(r3)
            goto Lc8
        L60:
            boolean r5 = r8.hasSubMenu()
            if (r5 != 0) goto L71
            if (r4 == 0) goto L69
            goto L71
        L69:
            r8 = r10 & 1
            if (r8 != 0) goto Lc8
            r7.c(r3)
            goto Lc8
        L71:
            r7.c(r0)
            boolean r10 = r8.hasSubMenu()
            if (r10 != 0) goto L89
            stepos.support.v7.view.menu.i r10 = new stepos.support.v7.view.menu.i
            android.content.Context r5 = r7.f12374a
            r10.<init>(r5, r7, r8)
            r8.r = r10
            java.lang.CharSequence r5 = r8.f12401e
            r6 = 0
            r10.t(r5, r6, r6)
        L89:
            stepos.support.v7.view.menu.i r8 = r8.r
            if (r4 == 0) goto L90
            r2.f(r8)
        L90:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<stepos.support.v7.view.menu.g>> r10 = r7.f12391w
            boolean r2 = r10.isEmpty()
            if (r2 == 0) goto L99
            goto Lc2
        L99:
            if (r9 == 0) goto L9f
            boolean r0 = r9.e(r8)
        L9f:
            java.util.Iterator r9 = r10.iterator()
        La3:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto Lc2
            java.lang.Object r2 = r9.next()
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            java.lang.Object r4 = r2.get()
            stepos.support.v7.view.menu.g r4 = (stepos.support.v7.view.menu.g) r4
            if (r4 != 0) goto Lbb
            r10.remove(r2)
            goto La3
        Lbb:
            if (r0 != 0) goto La3
            boolean r0 = r4.e(r8)
            goto La3
        Lc2:
            r1 = r1 | r0
            if (r1 != 0) goto Lc8
            r7.c(r3)
        Lc8:
            return r1
        Lc9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.view.menu.c.p(android.view.MenuItem, stepos.support.v7.view.menu.b, int):boolean");
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i10, int i11) {
        return p(findItem(i10), null, i11);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        e eVarG = g(i10, keyEvent);
        boolean zP = eVarG != null ? p(eVarG, null, i11) : false;
        if ((i11 & 2) != 0) {
            c(true);
        }
        return zP;
    }

    public final void q(g gVar) {
        CopyOnWriteArrayList<WeakReference<g>> copyOnWriteArrayList = this.f12391w;
        Iterator<WeakReference<g>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference<g> next = it.next();
            g gVar2 = next.get();
            if (gVar2 == null || gVar2 == gVar) {
                copyOnWriteArrayList.remove(next);
            }
        }
    }

    public final void r(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.f12378e.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((i) item.getSubMenu()).r(bundle);
            }
        }
        int i11 = bundle.getInt("android:menu:expandedactionview");
        if (i11 <= 0 || (menuItemFindItem = findItem(i11)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void removeGroup(int i10) {
        ArrayList<e> arrayList = this.f12378e;
        int size = arrayList.size();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                i12 = -1;
                break;
            } else if (arrayList.get(i12).f12398b == i10) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 >= 0) {
            int size2 = arrayList.size() - i12;
            while (true) {
                int i13 = i11 + 1;
                if (i11 >= size2 || arrayList.get(i12).f12398b != i10) {
                    break;
                }
                if (i12 >= 0 && i12 < arrayList.size()) {
                    arrayList.remove(i12);
                }
                i11 = i13;
            }
            o(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i10) {
        ArrayList<e> arrayList = this.f12378e;
        int size = arrayList.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (arrayList.get(i11).f12397a == i10) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 < 0 || i11 >= arrayList.size()) {
            return;
        }
        arrayList.remove(i11);
        o(true);
    }

    public final void s(Bundle bundle) {
        int size = this.f12378e.size();
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
                ((i) item.getSubMenu()).s(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i10, boolean z3, boolean z10) {
        ArrayList<e> arrayList = this.f12378e;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = arrayList.get(i11);
            if (eVar.f12398b == i10) {
                eVar.A = (eVar.A & (-5)) | (z10 ? 4 : 0);
                eVar.setCheckable(z3);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i10, boolean z3) {
        ArrayList<e> arrayList = this.f12378e;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = arrayList.get(i11);
            if (eVar.f12398b == i10) {
                eVar.setEnabled(z3);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i10, boolean z3) {
        ArrayList<e> arrayList = this.f12378e;
        int size = arrayList.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = arrayList.get(i11);
            if (eVar.f12398b == i10) {
                int i12 = eVar.A;
                int i13 = (i12 & (-9)) | (z3 ? 0 : 8);
                eVar.A = i13;
                if (i12 != i13) {
                    z10 = true;
                }
            }
        }
        if (z10) {
            o(true);
        }
    }

    public final void setOptionalIconsVisible(boolean z3) {
        this.f12388t = z3;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z3) {
        this.f12376c = z3;
        o(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f12378e.size();
    }

    public final void t(CharSequence charSequence, Drawable drawable, View view) {
        if (view != null) {
            this.f12386q = view;
            this.f12384o = null;
            this.f12385p = null;
        } else {
            if (charSequence != null) {
                this.f12384o = charSequence;
            }
            if (drawable != null) {
                this.f12385p = drawable;
            }
            this.f12386q = null;
        }
        o(false);
    }

    public final void u() {
        this.r = false;
        if (this.f12387s) {
            this.f12387s = false;
            o(true);
        }
    }

    public final void v() {
        if (this.r) {
            return;
        }
        this.r = true;
        this.f12387s = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i10) {
        return a(0, 0, 0, this.f12375b.getString(i10));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, this.f12375b.getString(i10));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(i10, i11, i12, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        e eVar = (e) a(i10, i11, i12, charSequence);
        i iVar = new i(this.f12374a, this, eVar);
        eVar.r = iVar;
        iVar.t(eVar.f12401e, null, null);
        return iVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i10, int i11, int i12, int i13) {
        return a(i10, i11, i12, this.f12375b.getString(i13));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, this.f12375b.getString(i13));
    }

    public c k() {
        return this;
    }

    @Override // android.view.Menu
    public final void setGroupDividerEnabled(boolean z3) {
    }
}
