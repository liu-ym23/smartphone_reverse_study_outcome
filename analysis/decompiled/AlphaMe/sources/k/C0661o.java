package k;

import K.U;
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

/* renamed from: k.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0661o implements F.a {

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f13237y = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f13238a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f13239b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13240c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13241d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0659m f13242e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f13243f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f13244g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13245h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f13246i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f13247j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13248k;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f13250m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f13251n;

    /* renamed from: o, reason: collision with root package name */
    public View f13252o;

    /* renamed from: v, reason: collision with root package name */
    public C0663q f13259v;

    /* renamed from: x, reason: collision with root package name */
    public boolean f13261x;

    /* renamed from: l, reason: collision with root package name */
    public int f13249l = 0;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13253p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13254q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f13255r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f13256s = false;

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f13257t = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArrayList f13258u = new CopyOnWriteArrayList();

    /* renamed from: w, reason: collision with root package name */
    public boolean f13260w = false;

    public C0661o(Context context) {
        boolean z4 = false;
        this.f13238a = context;
        Resources resources = context.getResources();
        this.f13239b = resources;
        this.f13243f = new ArrayList();
        this.f13244g = new ArrayList();
        this.f13245h = true;
        this.f13246i = new ArrayList();
        this.f13247j = new ArrayList();
        this.f13248k = true;
        if (resources.getConfiguration().keyboard != 1 && U.b(ViewConfiguration.get(context))) {
            z4 = true;
        }
        this.f13241d = z4;
    }

    public final MenuItem a(int i4, int i5, int i6, CharSequence charSequence) {
        int i7;
        int i8 = ((-65536) & i6) >> 16;
        if (i8 < 0 || i8 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i9 = (f13237y[i8] << 16) | (65535 & i6);
        C0663q c0663q = new C0663q(this, i4, i5, i6, i9, charSequence, this.f13249l);
        ArrayList arrayList = this.f13243f;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i7 = 0;
                break;
            }
            if (((C0663q) arrayList.get(size)).f13272d <= i9) {
                i7 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i7, c0663q);
        p(true);
        return c0663q;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i4, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        int i8;
        PackageManager packageManager = this.f13238a.getPackageManager();
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
            C0663q c0663q = (C0663q) a(i4, i5, i6, resolveInfo.loadLabel(packageManager));
            c0663q.setIcon(resolveInfo.loadIcon(packageManager));
            c0663q.setIntent(intent2);
            if (menuItemArr != null && (i8 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i8] = c0663q;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(InterfaceC0640A interfaceC0640A, Context context) {
        this.f13258u.add(new WeakReference(interfaceC0640A));
        interfaceC0640A.k(context, this);
        this.f13248k = true;
    }

    public final void c(boolean z4) {
        if (this.f13256s) {
            return;
        }
        this.f13256s = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f13258u;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0640A interfaceC0640A = (InterfaceC0640A) weakReference.get();
            if (interfaceC0640A == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                interfaceC0640A.b(this, z4);
            }
        }
        this.f13256s = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        C0663q c0663q = this.f13259v;
        if (c0663q != null) {
            d(c0663q);
        }
        this.f13243f.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f13251n = null;
        this.f13250m = null;
        this.f13252o = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(C0663q c0663q) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f13258u;
        boolean zH = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f13259v == c0663q) {
            w();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                InterfaceC0640A interfaceC0640A = (InterfaceC0640A) weakReference.get();
                if (interfaceC0640A == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zH = interfaceC0640A.h(c0663q);
                    if (zH) {
                        break;
                    }
                }
            }
            v();
            if (zH) {
                this.f13259v = null;
            }
        }
        return zH;
    }

    public boolean e(C0661o c0661o, MenuItem menuItem) {
        InterfaceC0659m interfaceC0659m = this.f13242e;
        return interfaceC0659m != null && interfaceC0659m.i(c0661o, menuItem);
    }

    public boolean f(C0663q c0663q) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f13258u;
        boolean zD = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        w();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0640A interfaceC0640A = (InterfaceC0640A) weakReference.get();
            if (interfaceC0640A == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                zD = interfaceC0640A.d(c0663q);
                if (zD) {
                    break;
                }
            }
        }
        v();
        if (zD) {
            this.f13259v = c0663q;
        }
        return zD;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i4) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.f13243f;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            C0663q c0663q = (C0663q) arrayList.get(i5);
            if (c0663q.f13269a == i4) {
                return c0663q;
            }
            if (c0663q.hasSubMenu() && (menuItemFindItem = c0663q.f13283o.findItem(i4)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final C0663q g(int i4, KeyEvent keyEvent) {
        ArrayList arrayList = this.f13257t;
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
            return (C0663q) arrayList.get(0);
        }
        boolean zN = n();
        for (int i5 = 0; i5 < size; i5++) {
            C0663q c0663q = (C0663q) arrayList.get(i5);
            char c4 = zN ? c0663q.f13278j : c0663q.f13276h;
            char[] cArr = keyData.meta;
            if ((c4 == cArr[0] && (metaState & 2) == 0) || ((c4 == cArr[2] && (metaState & 2) != 0) || (zN && c4 == '\b' && i4 == 67))) {
                return c0663q;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i4) {
        return (MenuItem) this.f13243f.get(i4);
    }

    public final void h(ArrayList arrayList, int i4, KeyEvent keyEvent) {
        boolean zN = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i4 == 67) {
            ArrayList arrayList2 = this.f13243f;
            int size = arrayList2.size();
            for (int i5 = 0; i5 < size; i5++) {
                C0663q c0663q = (C0663q) arrayList2.get(i5);
                if (c0663q.hasSubMenu()) {
                    c0663q.f13283o.h(arrayList, i4, keyEvent);
                }
                char c4 = zN ? c0663q.f13278j : c0663q.f13276h;
                if ((modifiers & 69647) == ((zN ? c0663q.f13279k : c0663q.f13277i) & 69647) && c4 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c4 == cArr[0] || c4 == cArr[2] || (zN && c4 == '\b' && i4 == 67)) && c0663q.isEnabled()) {
                        arrayList.add(c0663q);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f13261x) {
            return true;
        }
        ArrayList arrayList = this.f13243f;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (((C0663q) arrayList.get(i4)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList arrayListL = l();
        if (this.f13248k) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f13258u;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean zC = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                InterfaceC0640A interfaceC0640A = (InterfaceC0640A) weakReference.get();
                if (interfaceC0640A == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zC |= interfaceC0640A.c();
                }
            }
            ArrayList arrayList = this.f13246i;
            ArrayList arrayList2 = this.f13247j;
            if (zC) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListL.size();
                for (int i4 = 0; i4 < size; i4++) {
                    C0663q c0663q = (C0663q) arrayListL.get(i4);
                    if (c0663q.f()) {
                        arrayList.add(c0663q);
                    } else {
                        arrayList2.add(c0663q);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f13248k = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i4, KeyEvent keyEvent) {
        return g(i4, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public C0661o k() {
        return this;
    }

    public final ArrayList l() {
        boolean z4 = this.f13245h;
        ArrayList arrayList = this.f13244g;
        if (!z4) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f13243f;
        int size = arrayList2.size();
        for (int i4 = 0; i4 < size; i4++) {
            C0663q c0663q = (C0663q) arrayList2.get(i4);
            if (c0663q.isVisible()) {
                arrayList.add(c0663q);
            }
        }
        this.f13245h = false;
        this.f13248k = true;
        return arrayList;
    }

    public boolean m() {
        return this.f13260w;
    }

    public boolean n() {
        return this.f13240c;
    }

    public boolean o() {
        return this.f13241d;
    }

    public final void p(boolean z4) {
        if (this.f13253p) {
            this.f13254q = true;
            if (z4) {
                this.f13255r = true;
                return;
            }
            return;
        }
        if (z4) {
            this.f13245h = true;
            this.f13248k = true;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f13258u;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        w();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0640A interfaceC0640A = (InterfaceC0640A) weakReference.get();
            if (interfaceC0640A == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                interfaceC0640A.a();
            }
        }
        v();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i4, int i5) {
        return q(findItem(i4), null, i5);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i4, KeyEvent keyEvent, int i5) {
        C0663q c0663qG = g(i4, keyEvent);
        boolean zQ = c0663qG != null ? q(c0663qG, null, i5) : false;
        if ((i5 & 2) != 0) {
            c(true);
        }
        return zQ;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MenuItem r7, k.InterfaceC0640A r8, int r9) {
        /*
            r6 = this;
            k.q r7 = (k.C0663q) r7
            r0 = 0
            if (r7 == 0) goto Lcc
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Lcc
        Ld:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.f13284p
            r2 = 1
            if (r1 == 0) goto L1a
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L1a
        L18:
            r1 = r2
            goto L41
        L1a:
            k.o r1 = r7.f13282n
            boolean r3 = r1.e(r1, r7)
            if (r3 == 0) goto L23
            goto L18
        L23:
            android.content.Intent r3 = r7.f13275g
            if (r3 == 0) goto L35
            android.content.Context r1 = r1.f13238a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L18
        L2d:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L35:
            K.d r1 = r7.f13266A
            if (r1 == 0) goto L40
            boolean r1 = r1.d()
            if (r1 == 0) goto L40
            goto L18
        L40:
            r1 = r0
        L41:
            K.d r3 = r7.f13266A
            if (r3 == 0) goto L4d
            boolean r4 = r3.a()
            if (r4 == 0) goto L4d
            r4 = r2
            goto L4e
        L4d:
            r4 = r0
        L4e:
            boolean r5 = r7.e()
            if (r5 == 0) goto L60
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Lcb
            r6.c(r2)
            goto Lcb
        L60:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L71
            if (r4 == 0) goto L69
            goto L71
        L69:
            r7 = r9 & 1
            if (r7 != 0) goto Lcb
            r6.c(r2)
            goto Lcb
        L71:
            r9 = r9 & 4
            if (r9 != 0) goto L78
            r6.c(r0)
        L78:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L8c
            k.G r9 = new k.G
            android.content.Context r5 = r6.f13238a
            r9.<init>(r5, r6, r7)
            r7.f13283o = r9
            java.lang.CharSequence r5 = r7.f13273e
            r9.setHeaderTitle(r5)
        L8c:
            k.G r7 = r7.f13283o
            if (r4 == 0) goto L93
            r3.e(r7)
        L93:
            java.util.concurrent.CopyOnWriteArrayList r9 = r6.f13258u
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto L9c
            goto Lc5
        L9c:
            if (r8 == 0) goto La2
            boolean r0 = r8.f(r7)
        La2:
            java.util.Iterator r8 = r9.iterator()
        La6:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto Lc5
            java.lang.Object r3 = r8.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            java.lang.Object r4 = r3.get()
            k.A r4 = (k.InterfaceC0640A) r4
            if (r4 != 0) goto Lbe
            r9.remove(r3)
            goto La6
        Lbe:
            if (r0 != 0) goto La6
            boolean r0 = r4.f(r7)
            goto La6
        Lc5:
            r1 = r1 | r0
            if (r1 != 0) goto Lcb
            r6.c(r2)
        Lcb:
            return r1
        Lcc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k.C0661o.q(android.view.MenuItem, k.A, int):boolean");
    }

    public final void r(InterfaceC0640A interfaceC0640A) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f13258u;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0640A interfaceC0640A2 = (InterfaceC0640A) weakReference.get();
            if (interfaceC0640A2 == null || interfaceC0640A2 == interfaceC0640A) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i4) {
        ArrayList arrayList = this.f13243f;
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            } else if (((C0663q) arrayList.get(i6)).f13270b == i4) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 >= 0) {
            int size2 = arrayList.size() - i6;
            while (true) {
                int i7 = i5 + 1;
                if (i5 >= size2 || ((C0663q) arrayList.get(i6)).f13270b != i4) {
                    break;
                }
                if (i6 >= 0) {
                    ArrayList arrayList2 = this.f13243f;
                    if (i6 < arrayList2.size()) {
                        arrayList2.remove(i6);
                    }
                }
                i5 = i7;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i4) {
        ArrayList arrayList = this.f13243f;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i5 = -1;
                break;
            } else if (((C0663q) arrayList.get(i5)).f13269a == i4) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 >= 0) {
            ArrayList arrayList2 = this.f13243f;
            if (i5 >= arrayList2.size()) {
                return;
            }
            arrayList2.remove(i5);
            p(true);
        }
    }

    public final void s(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.f13243f.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = getItem(i4);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuC0646G) item.getSubMenu()).s(bundle);
            }
        }
        int i5 = bundle.getInt("android:menu:expandedactionview");
        if (i5 <= 0 || (menuItemFindItem = findItem(i5)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i4, boolean z4, boolean z5) {
        ArrayList arrayList = this.f13243f;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            C0663q c0663q = (C0663q) arrayList.get(i5);
            if (c0663q.f13270b == i4) {
                c0663q.f13292x = (c0663q.f13292x & (-5)) | (z5 ? 4 : 0);
                c0663q.setCheckable(z4);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z4) {
        this.f13260w = z4;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i4, boolean z4) {
        ArrayList arrayList = this.f13243f;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            C0663q c0663q = (C0663q) arrayList.get(i5);
            if (c0663q.f13270b == i4) {
                c0663q.setEnabled(z4);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i4, boolean z4) {
        ArrayList arrayList = this.f13243f;
        int size = arrayList.size();
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            C0663q c0663q = (C0663q) arrayList.get(i5);
            if (c0663q.f13270b == i4) {
                int i6 = c0663q.f13292x;
                int i7 = (i6 & (-9)) | (z4 ? 0 : 8);
                c0663q.f13292x = i7;
                if (i6 != i7) {
                    z5 = true;
                }
            }
        }
        if (z5) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z4) {
        this.f13240c = z4;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f13243f.size();
    }

    public final void t(Bundle bundle) {
        int size = this.f13243f.size();
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
                ((SubMenuC0646G) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i4, CharSequence charSequence, int i5, Drawable drawable, View view) {
        if (view != null) {
            this.f13252o = view;
            this.f13250m = null;
            this.f13251n = null;
        } else {
            if (i4 > 0) {
                this.f13250m = this.f13239b.getText(i4);
            } else if (charSequence != null) {
                this.f13250m = charSequence;
            }
            if (i5 > 0) {
                this.f13251n = androidx.core.content.a.b(this.f13238a, i5);
            } else if (drawable != null) {
                this.f13251n = drawable;
            }
            this.f13252o = null;
        }
        p(false);
    }

    public final void v() {
        this.f13253p = false;
        if (this.f13254q) {
            this.f13254q = false;
            p(this.f13255r);
        }
    }

    public final void w() {
        if (this.f13253p) {
            return;
        }
        this.f13253p = true;
        this.f13254q = false;
        this.f13255r = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4) {
        return a(0, 0, 0, this.f13239b.getString(i4));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4) {
        return addSubMenu(0, 0, 0, this.f13239b.getString(i4));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, CharSequence charSequence) {
        return a(i4, i5, i6, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        C0663q c0663q = (C0663q) a(i4, i5, i6, charSequence);
        SubMenuC0646G subMenuC0646G = new SubMenuC0646G(this.f13238a, this, c0663q);
        c0663q.f13283o = subMenuC0646G;
        subMenuC0646G.setHeaderTitle(c0663q.f13273e);
        return subMenuC0646G;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, int i7) {
        return a(i4, i5, i6, this.f13239b.getString(i7));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, int i7) {
        return addSubMenu(i4, i5, i6, this.f13239b.getString(i7));
    }
}
