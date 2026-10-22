package Va;

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
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MenuItemCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class n implements SupportMenu, h {

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f1441v = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f1442a;
    public final Resources b;
    public boolean c;
    public l d;
    public final ArrayList e;
    public final ArrayList f;
    public boolean g;
    public final ArrayList h;
    public final ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1443j;
    public CharSequence l;
    public Drawable m;
    public View n;

    /* renamed from: t, reason: collision with root package name */
    public q f1447t;
    public boolean u;
    public int k = 0;
    public boolean o = false;
    public boolean p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1444q = false;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f1445r = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public final CopyOnWriteArrayList f1446s = new CopyOnWriteArrayList();

    public n(Context context) {
        this.f1442a = context;
        Resources resources = context.getResources();
        this.b = resources;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = true;
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.f1443j = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration.get(context);
        }
    }

    public final MenuItem a(int i, int i6, int i10, CharSequence charSequence) {
        int i11;
        int i12 = ((-65536) & i10) >> 16;
        if (i12 < 0 || i12 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i13 = (f1441v[i12] << 16) | (65535 & i10);
        q qVar = new q(this, i, i6, i10, i13, charSequence, this.k);
        ArrayList arrayList = this.e;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i11 = 0;
                break;
            }
            if (((q) arrayList.get(size)).d <= i13) {
                i11 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i11, qVar);
        o(true);
        return qVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i6, int i10, ComponentName componentName, Intent[] intentArr, Intent intent, int i11, MenuItem[] menuItemArr) {
        int i12;
        PackageManager packageManager = this.f1442a.getPackageManager();
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
            q qVar = (q) a(i, i6, i10, resolveInfo.loadLabel(packageManager));
            qVar.setIcon(resolveInfo.loadIcon(packageManager));
            qVar.setIntent(intent2);
            if (menuItemArr != null && (i12 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i12] = qVar;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(B b, Context context) {
        this.f1446s.add(new WeakReference(b));
        b.b(context, this);
        this.f1443j = true;
    }

    public final void c(boolean z10) {
        if (this.f1444q) {
            return;
        }
        this.f1444q = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1446s;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            B b = (B) weakReference.get();
            if (b == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                b.f(this, z10);
            }
        }
        this.f1444q = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        q qVar = this.f1447t;
        if (qVar != null) {
            d(qVar);
        }
        this.e.clear();
        o(true);
    }

    public final void clearHeader() {
        this.m = null;
        this.l = null;
        this.n = null;
        o(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(q qVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1446s;
        boolean zD = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f1447t == qVar) {
            v();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                B b = (B) weakReference.get();
                if (b == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zD = b.d(qVar);
                    if (zD) {
                        break;
                    }
                }
            }
            u();
            if (zD) {
                this.f1447t = null;
            }
        }
        return zD;
    }

    public boolean e(n nVar, MenuItem menuItem) {
        l lVar = this.d;
        return lVar != null && lVar.e(nVar, menuItem);
    }

    public boolean f(q qVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1446s;
        boolean zA = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        v();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            B b = (B) weakReference.get();
            if (b == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                zA = b.a(qVar);
                if (zA) {
                    break;
                }
            }
        }
        u();
        if (zA) {
            this.f1447t = qVar;
        }
        return zA;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) arrayList.get(i6);
            if (qVar.f1453a == i) {
                return qVar;
            }
            if (qVar.hasSubMenu() && (menuItemFindItem = qVar.o.findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final q g(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.f1445r;
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
            return (q) arrayList.get(0);
        }
        boolean zM = m();
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) arrayList.get(i6);
            char c = zM ? qVar.f1454j : qVar.h;
            char[] cArr = keyData.meta;
            if ((c == cArr[0] && (metaState & 2) == 0) || ((c == cArr[2] && (metaState & 2) != 0) || (zM && c == '\b' && i == 67))) {
                return qVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return (MenuItem) this.e.get(i);
    }

    public final void h(List list, int i, KeyEvent keyEvent) {
        boolean zM = m();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            ArrayList arrayList = this.e;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                q qVar = (q) arrayList.get(i6);
                if (qVar.hasSubMenu()) {
                    qVar.o.h(list, i, keyEvent);
                }
                char c = zM ? qVar.f1454j : qVar.h;
                if ((metaState & 5) == 0 && c != 0) {
                    char[] cArr = keyData.meta;
                    if ((c == cArr[0] || c == cArr[2] || (zM && c == '\b' && i == 67)) && qVar.isEnabled()) {
                        list.add(qVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.u) {
            return true;
        }
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((q) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList arrayListL = l();
        if (this.f1443j) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f1446s;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean zFlagActionItems = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                B b = (B) weakReference.get();
                if (b == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zFlagActionItems |= b.flagActionItems();
                }
            }
            ArrayList arrayList = this.h;
            ArrayList arrayList2 = this.i;
            if (zFlagActionItems) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListL.size();
                for (int i = 0; i < size; i++) {
                    q qVar = (q) arrayListL.get(i);
                    if ((qVar.f1461x & 32) == 32) {
                        arrayList.add(qVar);
                    } else {
                        arrayList2.add(qVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f1443j = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return g(i, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public n k() {
        return this;
    }

    public final ArrayList l() {
        boolean z10 = this.g;
        ArrayList arrayList = this.f;
        if (!z10) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.e;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            q qVar = (q) arrayList2.get(i);
            if (qVar.isVisible()) {
                arrayList.add(qVar);
            }
        }
        this.g = false;
        this.f1443j = true;
        return arrayList;
    }

    public boolean m() {
        return this.c;
    }

    public boolean n() {
        return false;
    }

    public final void o(boolean z10) {
        if (this.o) {
            this.p = true;
            return;
        }
        if (z10) {
            this.g = true;
            this.f1443j = true;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1446s;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        v();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            B b = (B) weakReference.get();
            if (b == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                b.updateMenuView(z10);
            }
        }
        u();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(android.view.MenuItem r8, Va.k r9, int r10) {
        /*
            r7 = this;
            Va.q r8 = (Va.q) r8
            r0 = 0
            if (r8 == 0) goto Lc9
            boolean r1 = r8.isEnabled()
            if (r1 != 0) goto Ld
            goto Lc9
        Ld:
            Va.n r1 = r8.n
            android.view.MenuItem$OnMenuItemClickListener r2 = r8.p
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
            android.content.Intent r2 = r8.g
            if (r2 == 0) goto L35
            android.content.Context r1 = r1.f1442a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r2)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L1a
        L2d:
            r1 = move-exception
            java.lang.String r2 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r2, r4, r1)
        L35:
            androidx.core.view.ActionProvider r1 = r8.f1450A
            if (r1 == 0) goto L40
            boolean r1 = r1.onPerformDefaultAction()
            if (r1 == 0) goto L40
            goto L1a
        L40:
            r1 = r0
        L41:
            androidx.core.view.ActionProvider r2 = r8.f1450A
            if (r2 == 0) goto L4d
            boolean r4 = r2.hasSubMenu()
            if (r4 == 0) goto L4d
            r4 = r3
            goto L4e
        L4d:
            r4 = r0
        L4e:
            boolean r5 = r8.b()
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
            Va.F r10 = new Va.F
            android.content.Context r5 = r7.f1442a
            r10.<init>(r5, r7, r8)
            r8.o = r10
            java.lang.CharSequence r5 = r8.e
            r6 = 0
            r10.t(r5, r6, r6)
        L89:
            Va.F r8 = r8.o
            if (r4 == 0) goto L90
            r2.onPrepareSubMenu(r8)
        L90:
            java.util.concurrent.CopyOnWriteArrayList r10 = r7.f1446s
            boolean r2 = r10.isEmpty()
            if (r2 == 0) goto L99
            goto Lc2
        L99:
            if (r9 == 0) goto L9f
            boolean r0 = r9.c(r8)
        L9f:
            java.util.Iterator r9 = r10.iterator()
        La3:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto Lc2
            java.lang.Object r2 = r9.next()
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            java.lang.Object r4 = r2.get()
            Va.B r4 = (Va.B) r4
            if (r4 != 0) goto Lbb
            r10.remove(r2)
            goto La3
        Lbb:
            if (r0 != 0) goto La3
            boolean r0 = r4.c(r8)
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
        throw new UnsupportedOperationException("Method not decompiled: Va.n.p(android.view.MenuItem, Va.k, int):boolean");
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i6) {
        return p(findItem(i), null, i6);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i6) {
        q qVarG = g(i, keyEvent);
        boolean zP = qVarG != null ? p(qVarG, null, i6) : false;
        if ((i6 & 2) != 0) {
            c(true);
        }
        return zP;
    }

    public final void q(B b) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1446s;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            B b5 = (B) weakReference.get();
            if (b5 == null || b5 == b) {
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
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = MenuItemCompat.getActionView(item);
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((F) item.getSubMenu()).r(bundle);
            }
        }
        int i6 = bundle.getInt("android:menu:expandedactionview");
        if (i6 <= 0 || (menuItemFindItem = findItem(i6)) == null) {
            return;
        }
        MenuItemCompat.expandActionView(menuItemFindItem);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        int i6 = 0;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (((q) arrayList.get(i10)).b == i) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            int size2 = arrayList.size() - i10;
            while (true) {
                int i11 = i6 + 1;
                if (i6 >= size2 || ((q) arrayList.get(i10)).b != i) {
                    break;
                }
                if (i10 >= 0) {
                    ArrayList arrayList2 = this.e;
                    if (i10 < arrayList2.size()) {
                        arrayList2.remove(i10);
                    }
                }
                i6 = i11;
            }
            o(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            } else if (((q) arrayList.get(i6)).f1453a == i) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 >= 0) {
            ArrayList arrayList2 = this.e;
            if (i6 >= arrayList2.size()) {
                return;
            }
            arrayList2.remove(i6);
            o(true);
        }
    }

    public final void s(Bundle bundle) {
        int size = this.e.size();
        SparseArray<Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = MenuItemCompat.getActionView(item);
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (MenuItemCompat.isActionViewExpanded(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((F) item.getSubMenu()).s(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z10, boolean z11) {
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) arrayList.get(i6);
            if (qVar.b == i) {
                qVar.f1461x = (qVar.f1461x & (-5)) | (z11 ? 4 : 0);
                qVar.setCheckable(z10);
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenu, android.view.Menu
    public final void setGroupDividerEnabled(boolean z10) {
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z10) {
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) arrayList.get(i6);
            if (qVar.b == i) {
                qVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z10) {
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        boolean z11 = false;
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) arrayList.get(i6);
            if (qVar.b == i) {
                int i10 = qVar.f1461x;
                int i11 = (i10 & (-9)) | (z10 ? 0 : 8);
                qVar.f1461x = i11;
                if (i10 != i11) {
                    z11 = true;
                }
            }
        }
        if (z11) {
            o(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.c = z10;
        o(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.e.size();
    }

    public final void t(CharSequence charSequence, Drawable drawable, View view) {
        if (view != null) {
            this.n = view;
            this.l = null;
            this.m = null;
        } else {
            if (charSequence != null) {
                this.l = charSequence;
            }
            if (drawable != null) {
                this.m = drawable;
            }
            this.n = null;
        }
        o(false);
    }

    public final void u() {
        this.o = false;
        if (this.p) {
            this.p = false;
            o(true);
        }
    }

    public final void v() {
        if (this.o) {
            return;
        }
        this.o = true;
        this.p = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return a(0, 0, 0, this.b.getString(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.b.getString(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i6, int i10, CharSequence charSequence) {
        return a(i, i6, i10, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i6, int i10, CharSequence charSequence) {
        q qVar = (q) a(i, i6, i10, charSequence);
        F f = new F(this.f1442a, this, qVar);
        qVar.o = f;
        f.t(qVar.e, null, null);
        return f;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i6, int i10, int i11) {
        return a(i, i6, i10, this.b.getString(i11));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i6, int i10, int i11) {
        return addSubMenu(i, i6, i10, this.b.getString(i11));
    }
}
