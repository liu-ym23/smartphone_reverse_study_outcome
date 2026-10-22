package te;

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
/* loaded from: classes2.dex */
public class l implements h3.a, g {

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f13342v = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f13343a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f13344b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13345c;

    /* renamed from: d, reason: collision with root package name */
    public j f13346d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f13347e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f13348f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13349g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f13350h;
    public final ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13351j;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f13353l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f13354m;

    /* renamed from: n, reason: collision with root package name */
    public View f13355n;

    /* renamed from: t, reason: collision with root package name */
    public m f13361t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13362u;

    /* renamed from: k, reason: collision with root package name */
    public int f13352k = 0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13356o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13357p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13358q = false;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f13359r = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public final CopyOnWriteArrayList f13360s = new CopyOnWriteArrayList();

    public l(Context context) {
        this.f13343a = context;
        Resources resources = context.getResources();
        this.f13344b = resources;
        this.f13347e = new ArrayList();
        this.f13348f = new ArrayList();
        this.f13349g = true;
        this.f13350h = new ArrayList();
        this.i = new ArrayList();
        this.f13351j = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration.get(context);
        }
    }

    public final MenuItem a(int i, int i3, int i10, CharSequence charSequence) {
        int i11 = ((-65536) & i10) >> 16;
        if (i11 < 0 || i11 >= 6) {
            g5.f.s("order does not contain a valid category.");
            return null;
        }
        int i12 = (f13342v[i11] << 16) | (65535 & i10);
        int i13 = this.f13352k;
        m mVar = new m();
        mVar.i = 4096;
        mVar.f13372k = 4096;
        int i14 = 0;
        mVar.f13374m = 0;
        mVar.f13380s = null;
        mVar.f13381t = null;
        mVar.f13382u = false;
        mVar.f13383v = false;
        mVar.f13384w = false;
        mVar.f13385x = 16;
        mVar.C = false;
        mVar.f13375n = this;
        mVar.f13363a = i3;
        mVar.f13364b = i;
        mVar.f13365c = i10;
        mVar.f13366d = i12;
        mVar.f13367e = charSequence;
        mVar.f13386y = i13;
        VarHandle.storeStoreFence();
        ArrayList arrayList = this.f13347e;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (((m) arrayList.get(size)).f13366d <= i12) {
                i14 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i14, mVar);
        o(true);
        return mVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return a(0, 0, 0, this.f13344b.getString(i));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i3, int i10, ComponentName componentName, Intent[] intentArr, Intent intent, int i11, MenuItem[] menuItemArr) {
        int i12;
        PackageManager packageManager = this.f13343a.getPackageManager();
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
            m mVar = (m) a(i, i3, i10, resolveInfo.loadLabel(packageManager));
            mVar.setIcon(resolveInfo.loadIcon(packageManager));
            mVar.setIntent(intent2);
            if (menuItemArr != null && (i12 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i12] = mVar;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i10, CharSequence charSequence) {
        m mVar = (m) a(i, i3, i10, charSequence);
        z zVar = new z(this.f13343a, this, mVar);
        mVar.f13376o = zVar;
        zVar.t(mVar.f13367e, null, null);
        return zVar;
    }

    public final void b(v vVar, Context context) {
        this.f13360s.add(new WeakReference(vVar));
        vVar.f(context, this);
        this.f13351j = true;
    }

    public final void c(boolean z10) {
        if (this.f13358q) {
            return;
        }
        this.f13358q = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f13360s;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            v vVar = (v) weakReference.get();
            if (vVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                vVar.b(this, z10);
            }
        }
        this.f13358q = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        m mVar = this.f13361t;
        if (mVar != null) {
            d(mVar);
        }
        this.f13347e.clear();
        o(true);
    }

    public final void clearHeader() {
        this.f13354m = null;
        this.f13353l = null;
        this.f13355n = null;
        o(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(m mVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f13360s;
        boolean zE = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f13361t == mVar) {
            v();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                v vVar = (v) weakReference.get();
                if (vVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zE = vVar.e(mVar);
                    if (zE) {
                        break;
                    }
                }
            }
            u();
            if (zE) {
                this.f13361t = null;
            }
        }
        return zE;
    }

    public boolean e(l lVar, MenuItem menuItem) {
        j jVar = this.f13346d;
        return jVar != null && jVar.c(lVar, menuItem);
    }

    public boolean f(m mVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f13360s;
        boolean zD = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        v();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            v vVar = (v) weakReference.get();
            if (vVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                zD = vVar.d(mVar);
                if (zD) {
                    break;
                }
            }
        }
        u();
        if (zD) {
            this.f13361t = mVar;
        }
        return zD;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.f13347e;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            m mVar = (m) arrayList.get(i3);
            if (mVar.f13363a == i) {
                return mVar;
            }
            if (mVar.hasSubMenu() && (menuItemFindItem = mVar.f13376o.findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final m g(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.f13359r;
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
            return (m) arrayList.get(0);
        }
        boolean zM = m();
        for (int i3 = 0; i3 < size; i3++) {
            m mVar = (m) arrayList.get(i3);
            char c9 = zM ? mVar.f13371j : mVar.f13370h;
            char[] cArr = keyData.meta;
            if ((c9 == cArr[0] && (metaState & 2) == 0) || ((c9 == cArr[2] && (metaState & 2) != 0) || (zM && c9 == '\b' && i == 67))) {
                return mVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return (MenuItem) this.f13347e.get(i);
    }

    public final void h(List list, int i, KeyEvent keyEvent) {
        boolean zM = m();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            ArrayList arrayList = this.f13347e;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                m mVar = (m) arrayList.get(i3);
                if (mVar.hasSubMenu()) {
                    mVar.f13376o.h(list, i, keyEvent);
                }
                char c9 = zM ? mVar.f13371j : mVar.f13370h;
                if ((metaState & 5) == 0 && c9 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c9 == cArr[0] || c9 == cArr[2] || (zM && c9 == '\b' && i == 67)) && mVar.isEnabled()) {
                        list.add(mVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f13362u) {
            return true;
        }
        ArrayList arrayList = this.f13347e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((m) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList arrayListL = l();
        if (this.f13351j) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f13360s;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean zA = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                v vVar = (v) weakReference.get();
                if (vVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zA |= vVar.a();
                }
            }
            ArrayList arrayList = this.f13350h;
            ArrayList arrayList2 = this.i;
            if (zA) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListL.size();
                for (int i = 0; i < size; i++) {
                    m mVar = (m) arrayListL.get(i);
                    if ((mVar.f13385x & 32) == 32) {
                        arrayList.add(mVar);
                    } else {
                        arrayList2.add(mVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f13351j = false;
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
        boolean z10 = this.f13349g;
        ArrayList arrayList = this.f13348f;
        if (!z10) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f13347e;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            m mVar = (m) arrayList2.get(i);
            if (mVar.isVisible()) {
                arrayList.add(mVar);
            }
        }
        this.f13349g = false;
        this.f13351j = true;
        return arrayList;
    }

    public boolean m() {
        return this.f13345c;
    }

    public boolean n() {
        return false;
    }

    public final void o(boolean z10) {
        if (this.f13356o) {
            this.f13357p = true;
            return;
        }
        if (z10) {
            this.f13349g = true;
            this.f13351j = true;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f13360s;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        v();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            v vVar = (v) weakReference.get();
            if (vVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                vVar.c();
            }
        }
        u();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(android.view.MenuItem r8, te.i r9, int r10) {
        /*
            r7 = this;
            te.m r8 = (te.m) r8
            r0 = 0
            if (r8 == 0) goto Lc9
            boolean r1 = r8.isEnabled()
            if (r1 != 0) goto Ld
            goto Lc9
        Ld:
            te.l r1 = r8.f13375n
            android.view.MenuItem$OnMenuItemClickListener r2 = r8.f13377p
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
            android.content.Intent r2 = r8.f13369g
            if (r2 == 0) goto L35
            android.content.Context r1 = r1.f13343a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r2)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L1a
        L2d:
            r1 = move-exception
            java.lang.String r2 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r2, r4, r1)
        L35:
            n3.d r1 = r8.A
            if (r1 == 0) goto L40
            boolean r1 = r1.d()
            if (r1 == 0) goto L40
            goto L1a
        L40:
            r1 = r0
        L41:
            n3.d r2 = r8.A
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
            te.z r10 = new te.z
            android.content.Context r5 = r7.f13343a
            r10.<init>(r5, r7, r8)
            r8.f13376o = r10
            java.lang.CharSequence r5 = r8.f13367e
            r6 = 0
            r10.t(r5, r6, r6)
        L89:
            te.z r8 = r8.f13376o
            if (r4 == 0) goto L90
            r2.e(r8)
        L90:
            java.util.concurrent.CopyOnWriteArrayList r10 = r7.f13360s
            boolean r2 = r10.isEmpty()
            if (r2 == 0) goto L99
            goto Lc2
        L99:
            if (r9 == 0) goto L9f
            boolean r0 = r9.g(r8)
        L9f:
            java.util.Iterator r9 = r10.iterator()
        La3:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto Lc2
            java.lang.Object r2 = r9.next()
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            java.lang.Object r4 = r2.get()
            te.v r4 = (te.v) r4
            if (r4 != 0) goto Lbb
            r10.remove(r2)
            goto La3
        Lbb:
            if (r0 != 0) goto La3
            boolean r0 = r4.g(r8)
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
        throw new UnsupportedOperationException("Method not decompiled: te.l.p(android.view.MenuItem, te.i, int):boolean");
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i3) {
        return p(findItem(i), null, i3);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i3) {
        m mVarG = g(i, keyEvent);
        boolean zP = mVarG != null ? p(mVarG, null, i3) : false;
        if ((i3 & 2) != 0) {
            c(true);
        }
        return zP;
    }

    public final void q(v vVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f13360s;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            v vVar2 = (v) weakReference.get();
            if (vVar2 == null || vVar2 == vVar) {
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
        int size = this.f13347e.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((z) item.getSubMenu()).r(bundle);
            }
        }
        int i3 = bundle.getInt("android:menu:expandedactionview");
        if (i3 <= 0 || (menuItemFindItem = findItem(i3)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayList arrayList = this.f13347e;
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (((m) arrayList.get(i10)).f13364b == i) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            int size2 = arrayList.size() - i10;
            while (true) {
                int i11 = i3 + 1;
                if (i3 >= size2 || ((m) arrayList.get(i10)).f13364b != i) {
                    break;
                }
                if (i10 >= 0 && i10 < arrayList.size()) {
                    arrayList.remove(i10);
                }
                i3 = i11;
            }
            o(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayList arrayList = this.f13347e;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (((m) arrayList.get(i3)).f13363a == i) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 < 0 || i3 >= arrayList.size()) {
            return;
        }
        arrayList.remove(i3);
        o(true);
    }

    public final void s(Bundle bundle) {
        int size = this.f13347e.size();
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
                ((z) item.getSubMenu()).s(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z10, boolean z11) {
        ArrayList arrayList = this.f13347e;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            m mVar = (m) arrayList.get(i3);
            if (mVar.f13364b == i) {
                mVar.f13385x = (mVar.f13385x & (-5)) | (z11 ? 4 : 0);
                mVar.setCheckable(z10);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z10) {
        ArrayList arrayList = this.f13347e;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            m mVar = (m) arrayList.get(i3);
            if (mVar.f13364b == i) {
                mVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z10) {
        ArrayList arrayList = this.f13347e;
        int size = arrayList.size();
        boolean z11 = false;
        for (int i3 = 0; i3 < size; i3++) {
            m mVar = (m) arrayList.get(i3);
            if (mVar.f13364b == i) {
                int i10 = mVar.f13385x;
                int i11 = (i10 & (-9)) | (z10 ? 0 : 8);
                mVar.f13385x = i11;
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
        this.f13345c = z10;
        o(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f13347e.size();
    }

    public final void t(CharSequence charSequence, Drawable drawable, View view) {
        if (view != null) {
            this.f13355n = view;
            this.f13353l = null;
            this.f13354m = null;
        } else {
            if (charSequence != null) {
                this.f13353l = charSequence;
            }
            if (drawable != null) {
                this.f13354m = drawable;
            }
            this.f13355n = null;
        }
        o(false);
    }

    public final void u() {
        this.f13356o = false;
        if (this.f13357p) {
            this.f13357p = false;
            o(true);
        }
    }

    public final void v() {
        if (this.f13356o) {
            return;
        }
        this.f13356o = true;
        this.f13357p = false;
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
        return a(i, i3, i10, this.f13344b.getString(i11));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f13344b.getString(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i10, int i11) {
        return addSubMenu(i, i3, i10, this.f13344b.getString(i11));
    }

    @Override // android.view.Menu
    public final void setGroupDividerEnabled(boolean z10) {
    }

    public l k() {
        return this;
    }
}
