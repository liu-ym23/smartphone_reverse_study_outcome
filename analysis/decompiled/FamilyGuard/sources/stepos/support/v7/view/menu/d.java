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
import androidx.core.view.AbstractC0457b;
import androidx.core.view.C0472q;
import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class d implements A.a, c5.e {

    /* renamed from: y, reason: collision with root package name */
    private static final int[] f21270y = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    private final Context f21271a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f21272b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f21273c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f21274d;

    /* renamed from: e, reason: collision with root package name */
    private a f21275e;

    /* renamed from: m, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f21283m;

    /* renamed from: n, reason: collision with root package name */
    CharSequence f21284n;

    /* renamed from: o, reason: collision with root package name */
    Drawable f21285o;

    /* renamed from: p, reason: collision with root package name */
    View f21286p;

    /* renamed from: w, reason: collision with root package name */
    private f f21293w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f21294x;

    /* renamed from: l, reason: collision with root package name */
    private int f21282l = 0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f21287q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f21288r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f21289s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f21290t = false;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<f> f21291u = new ArrayList<>();

    /* renamed from: v, reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<h>> f21292v = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<f> f21276f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<f> f21277g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private boolean f21278h = true;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<f> f21279i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<f> f21280j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private boolean f21281k = true;

    public interface a {
        boolean c(d dVar, MenuItem menuItem);

        void d(d dVar);
    }

    public interface b {
        boolean d(f fVar);
    }

    public d(Context context) {
        this.f21271a = context;
        this.f21272b = context.getResources();
        Y(true);
    }

    private static int B(int i5) {
        int i6 = ((-65536) & i5) >> 16;
        if (i6 >= 0) {
            int[] iArr = f21270y;
            if (i6 < iArr.length) {
                return (i5 & ExifInterface.COLOR_SPACE_UNCALIBRATED) | (iArr[i6] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void M(int i5, boolean z5) {
        if (i5 < 0 || i5 >= this.f21276f.size()) {
            return;
        }
        this.f21276f.remove(i5);
        if (z5) {
            J(true);
        }
    }

    private void U(int i5, CharSequence charSequence, int i6, Drawable drawable, View view) {
        Resources resourcesC = C();
        if (view != null) {
            this.f21286p = view;
            this.f21284n = null;
            this.f21285o = null;
        } else {
            if (i5 > 0) {
                this.f21284n = resourcesC.getText(i5);
            } else if (charSequence != null) {
                this.f21284n = charSequence;
            }
            if (i6 > 0) {
                this.f21285o = androidx.core.content.a.e(u(), i6);
            } else if (drawable != null) {
                this.f21285o = drawable;
            }
            this.f21286p = null;
        }
        J(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Y(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f21272b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f21271a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f21271a
            boolean r3 = Z(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f21274d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.view.menu.d.Y(boolean):void");
    }

    public static boolean Z(ViewConfiguration viewConfiguration, Context context) {
        return false;
    }

    private f g(int i5, int i6, int i7, int i8, CharSequence charSequence, int i9) {
        return new f(this, i5, i6, i7, i8, charSequence, i9);
    }

    private void i(boolean z5) {
        if (this.f21292v.isEmpty()) {
            return;
        }
        b0();
        Iterator<WeakReference<h>> it = this.f21292v.iterator();
        while (it.hasNext()) {
            WeakReference<h> next = it.next();
            h hVar = next.get();
            if (hVar == null) {
                this.f21292v.remove(next);
            } else {
                hVar.b(z5);
            }
        }
        a0();
    }

    private boolean j(j jVar, h hVar) {
        if (this.f21292v.isEmpty()) {
            return false;
        }
        boolean zE = hVar != null ? hVar.e(jVar) : false;
        Iterator<WeakReference<h>> it = this.f21292v.iterator();
        while (it.hasNext()) {
            WeakReference<h> next = it.next();
            h hVar2 = next.get();
            if (hVar2 == null) {
                this.f21292v.remove(next);
            } else if (!zE) {
                zE = hVar2.e(jVar);
            }
        }
        return zE;
    }

    private static int n(ArrayList<f> arrayList, int i5) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i5) {
                return size + 1;
            }
        }
        return 0;
    }

    boolean A() {
        return this.f21289s;
    }

    Resources C() {
        return this.f21272b;
    }

    public d D() {
        return this;
    }

    public ArrayList<f> E() {
        if (!this.f21278h) {
            return this.f21277g;
        }
        this.f21277g.clear();
        int size = this.f21276f.size();
        for (int i5 = 0; i5 < size; i5++) {
            f fVar = this.f21276f.get(i5);
            if (fVar.isVisible()) {
                this.f21277g.add(fVar);
            }
        }
        this.f21278h = false;
        this.f21281k = true;
        return this.f21277g;
    }

    boolean F() {
        return this.f21273c;
    }

    public boolean G() {
        return this.f21274d;
    }

    void H(f fVar) {
        this.f21281k = true;
        J(true);
    }

    void I(f fVar) {
        this.f21278h = true;
        J(true);
    }

    public void J(boolean z5) {
        if (this.f21287q) {
            this.f21288r = true;
            return;
        }
        if (z5) {
            this.f21278h = true;
            this.f21281k = true;
        }
        i(z5);
    }

    public boolean K(MenuItem menuItem, int i5) {
        return L(menuItem, null, i5);
    }

    public boolean L(MenuItem menuItem, h hVar, int i5) {
        f fVar = (f) menuItem;
        if (fVar == null || !fVar.isEnabled()) {
            return false;
        }
        boolean zL = fVar.l();
        AbstractC0457b abstractC0457bB = fVar.b();
        boolean z5 = abstractC0457bB != null && abstractC0457bB.a();
        if (fVar.k()) {
            boolean zExpandActionView = fVar.expandActionView() | zL;
            if (zExpandActionView) {
                e(true);
            }
            return zExpandActionView;
        }
        if (!fVar.hasSubMenu() && !z5) {
            if ((i5 & 1) == 0) {
                e(true);
            }
            return zL;
        }
        e(false);
        if (!fVar.hasSubMenu()) {
            fVar.B(new j(u(), this, fVar));
        }
        j jVar = (j) fVar.getSubMenu();
        if (z5) {
            abstractC0457bB.f(jVar);
        }
        boolean zJ = j(jVar, hVar) | zL;
        if (!zJ) {
            e(true);
        }
        return zJ;
    }

    public void N(h hVar) {
        Iterator<WeakReference<h>> it = this.f21292v.iterator();
        while (it.hasNext()) {
            WeakReference<h> next = it.next();
            h hVar2 = next.get();
            if (hVar2 == null || hVar2 == hVar) {
                this.f21292v.remove(next);
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
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = getItem(i5);
            View viewB = C0472q.b(item);
            if (viewB != null && viewB.getId() != -1) {
                viewB.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((j) item.getSubMenu()).O(bundle);
            }
        }
        int i6 = bundle.getInt("android:menu:expandedactionview");
        if (i6 <= 0 || (menuItemFindItem = findItem(i6)) == null) {
            return;
        }
        C0472q.a(menuItemFindItem);
    }

    public void P(Bundle bundle) {
        int size = size();
        SparseArray<Parcelable> sparseArray = null;
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = getItem(i5);
            View viewB = C0472q.b(item);
            if (viewB != null && viewB.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                viewB.saveHierarchyState(sparseArray);
                if (C0472q.c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((j) item.getSubMenu()).P(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void Q(a aVar) {
        this.f21275e = aVar;
    }

    public d R(int i5) {
        this.f21282l = i5;
        return this;
    }

    void S(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f21276f.size();
        for (int i5 = 0; i5 < size; i5++) {
            f fVar = this.f21276f.get(i5);
            if (fVar.getGroupId() == groupId && fVar.n() && fVar.isCheckable()) {
                fVar.w(fVar == menuItem);
            }
        }
    }

    protected d T(Drawable drawable) {
        U(0, null, 0, drawable, null);
        return this;
    }

    protected d V(CharSequence charSequence) {
        U(0, charSequence, 0, null, null);
        return this;
    }

    protected d W(View view) {
        U(0, null, 0, null, view);
        return this;
    }

    public void X(boolean z5) {
        this.f21294x = z5;
    }

    protected MenuItem a(int i5, int i6, int i7, CharSequence charSequence) {
        int iB = B(i7);
        f fVarG = g(i5, i6, i7, iB, charSequence, this.f21282l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f21283m;
        if (contextMenuInfo != null) {
            fVarG.z(contextMenuInfo);
        }
        ArrayList<f> arrayList = this.f21276f;
        arrayList.add(n(arrayList, iB), fVarG);
        J(true);
        return fVarG;
    }

    public void a0() {
        this.f21287q = false;
        if (this.f21288r) {
            this.f21288r = false;
            J(true);
        }
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        int i9;
        PackageManager packageManager = this.f21271a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i8 & 1) == 0) {
            removeGroup(i5);
        }
        for (int i10 = 0; i10 < size; i10++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i10);
            int i11 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i11 < 0 ? intent : intentArr[i11]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i5, i6, i7, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i9 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i9] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(h hVar) {
        c(hVar, this.f21271a);
    }

    public void b0() {
        if (this.f21287q) {
            return;
        }
        this.f21287q = true;
        this.f21288r = false;
    }

    public void c(h hVar, Context context) {
        this.f21292v.add(new WeakReference<>(hVar));
        hVar.f(context, this);
        this.f21281k = true;
    }

    @Override // android.view.Menu
    public void clear() {
        f fVar = this.f21293w;
        if (fVar != null) {
            f(fVar);
        }
        this.f21276f.clear();
        J(true);
    }

    public void clearHeader() {
        this.f21285o = null;
        this.f21284n = null;
        this.f21286p = null;
        J(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f21275e;
        if (aVar != null) {
            aVar.d(this);
        }
    }

    public final void e(boolean z5) {
        if (this.f21290t) {
            return;
        }
        this.f21290t = true;
        Iterator<WeakReference<h>> it = this.f21292v.iterator();
        while (it.hasNext()) {
            WeakReference<h> next = it.next();
            h hVar = next.get();
            if (hVar == null) {
                this.f21292v.remove(next);
            } else {
                hVar.a(this, z5);
            }
        }
        this.f21290t = false;
    }

    public boolean f(f fVar) {
        boolean zD = false;
        if (!this.f21292v.isEmpty() && this.f21293w == fVar) {
            b0();
            Iterator<WeakReference<h>> it = this.f21292v.iterator();
            while (it.hasNext()) {
                WeakReference<h> next = it.next();
                h hVar = next.get();
                if (hVar == null) {
                    this.f21292v.remove(next);
                } else {
                    zD = hVar.d(this, fVar);
                    if (zD) {
                        break;
                    }
                }
            }
            a0();
            if (zD) {
                this.f21293w = null;
            }
        }
        return zD;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i5) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            f fVar = this.f21276f.get(i6);
            if (fVar.getItemId() == i5) {
                return fVar;
            }
            if (fVar.hasSubMenu() && (menuItemFindItem = fVar.getSubMenu().findItem(i5)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i5) {
        return this.f21276f.get(i5);
    }

    boolean h(d dVar, MenuItem menuItem) {
        a aVar = this.f21275e;
        return aVar != null && aVar.c(dVar, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f21294x) {
            return true;
        }
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f21276f.get(i5).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        return p(i5, keyEvent) != null;
    }

    public boolean k(f fVar) {
        boolean zG = false;
        if (this.f21292v.isEmpty()) {
            return false;
        }
        b0();
        Iterator<WeakReference<h>> it = this.f21292v.iterator();
        while (it.hasNext()) {
            WeakReference<h> next = it.next();
            h hVar = next.get();
            if (hVar == null) {
                this.f21292v.remove(next);
            } else {
                zG = hVar.g(this, fVar);
                if (zG) {
                    break;
                }
            }
        }
        a0();
        if (zG) {
            this.f21293w = fVar;
        }
        return zG;
    }

    public int l(int i5) {
        return m(i5, 0);
    }

    public int m(int i5, int i6) {
        int size = size();
        if (i6 < 0) {
            i6 = 0;
        }
        while (i6 < size) {
            if (this.f21276f.get(i6).getGroupId() == i5) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public int o(int i5) {
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            if (this.f21276f.get(i6).getItemId() == i5) {
                return i6;
            }
        }
        return -1;
    }

    f p(int i5, KeyEvent keyEvent) {
        ArrayList<f> arrayList = this.f21291u;
        arrayList.clear();
        q(arrayList, i5, keyEvent);
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
        for (int i6 = 0; i6 < size; i6++) {
            f fVar = arrayList.get(i6);
            char alphabeticShortcut = zF ? fVar.getAlphabeticShortcut() : fVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zF && alphabeticShortcut == '\b' && i5 == 67))) {
                return fVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i5, int i6) {
        return K(findItem(i5), i6);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        f fVarP = p(i5, keyEvent);
        boolean zK = fVarP != null ? K(fVarP, i6) : false;
        if ((i6 & 2) != 0) {
            e(true);
        }
        return zK;
    }

    void q(List<f> list, int i5, KeyEvent keyEvent) {
        boolean zF = F();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i5 == 67) {
            int size = this.f21276f.size();
            for (int i6 = 0; i6 < size; i6++) {
                f fVar = this.f21276f.get(i6);
                if (fVar.hasSubMenu()) {
                    ((d) fVar.getSubMenu()).q(list, i5, keyEvent);
                }
                char alphabeticShortcut = zF ? fVar.getAlphabeticShortcut() : fVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zF && alphabeticShortcut == '\b' && i5 == 67)) && fVar.isEnabled()) {
                        list.add(fVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList<f> arrayListE = E();
        if (this.f21281k) {
            Iterator<WeakReference<h>> it = this.f21292v.iterator();
            boolean zC = false;
            while (it.hasNext()) {
                WeakReference<h> next = it.next();
                h hVar = next.get();
                if (hVar == null) {
                    this.f21292v.remove(next);
                } else {
                    zC |= hVar.c();
                }
            }
            if (zC) {
                this.f21279i.clear();
                this.f21280j.clear();
                int size = arrayListE.size();
                for (int i5 = 0; i5 < size; i5++) {
                    f fVar = arrayListE.get(i5);
                    if (fVar.m()) {
                        this.f21279i.add(fVar);
                    } else {
                        this.f21280j.add(fVar);
                    }
                }
            } else {
                this.f21279i.clear();
                this.f21280j.clear();
                this.f21280j.addAll(E());
            }
            this.f21281k = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i5) {
        int iL = l(i5);
        if (iL >= 0) {
            int size = this.f21276f.size() - iL;
            int i6 = 0;
            while (true) {
                int i7 = i6 + 1;
                if (i6 >= size || this.f21276f.get(iL).getGroupId() != i5) {
                    break;
                }
                M(iL, false);
                i6 = i7;
            }
            J(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i5) {
        M(o(i5), true);
    }

    public ArrayList<f> s() {
        r();
        return this.f21279i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i5, boolean z5, boolean z6) {
        int size = this.f21276f.size();
        for (int i6 = 0; i6 < size; i6++) {
            f fVar = this.f21276f.get(i6);
            if (fVar.getGroupId() == i5) {
                fVar.x(z6);
                fVar.setCheckable(z5);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z5) {
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i5, boolean z5) {
        int size = this.f21276f.size();
        for (int i6 = 0; i6 < size; i6++) {
            f fVar = this.f21276f.get(i6);
            if (fVar.getGroupId() == i5) {
                fVar.setEnabled(z5);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i5, boolean z5) {
        int size = this.f21276f.size();
        boolean z6 = false;
        for (int i6 = 0; i6 < size; i6++) {
            f fVar = this.f21276f.get(i6);
            if (fVar.getGroupId() == i5 && fVar.C(z5)) {
                z6 = true;
            }
        }
        if (z6) {
            J(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z5) {
        this.f21273c = z5;
        J(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f21276f.size();
    }

    protected String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f21271a;
    }

    public f v() {
        return this.f21293w;
    }

    public Drawable w() {
        return this.f21285o;
    }

    public CharSequence x() {
        return this.f21284n;
    }

    public View y() {
        return this.f21286p;
    }

    public ArrayList<f> z() {
        r();
        return this.f21280j;
    }

    @Override // android.view.Menu
    public MenuItem add(int i5) {
        return a(0, 0, 0, this.f21272b.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5) {
        return addSubMenu(0, 0, 0, this.f21272b.getString(i5));
    }

    @Override // android.view.Menu
    public MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        return a(i5, i6, i7, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        f fVar = (f) a(i5, i6, i7, charSequence);
        j jVar = new j(this.f21271a, this, fVar);
        fVar.B(jVar);
        return jVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i5, int i6, int i7, int i8) {
        return a(i5, i6, i7, this.f21272b.getString(i8));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return addSubMenu(i5, i6, i7, this.f21272b.getString(i8));
    }
}
