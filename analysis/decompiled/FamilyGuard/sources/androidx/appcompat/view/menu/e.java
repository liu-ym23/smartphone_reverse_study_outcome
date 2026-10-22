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
import androidx.core.view.AbstractC0457b;
import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class e implements A.a {

    /* renamed from: A, reason: collision with root package name */
    private static final int[] f7875A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    private final Context f7876a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f7877b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7878c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7879d;

    /* renamed from: e, reason: collision with root package name */
    private a f7880e;

    /* renamed from: m, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f7888m;

    /* renamed from: n, reason: collision with root package name */
    CharSequence f7889n;

    /* renamed from: o, reason: collision with root package name */
    Drawable f7890o;

    /* renamed from: p, reason: collision with root package name */
    View f7891p;

    /* renamed from: x, reason: collision with root package name */
    private g f7899x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f7901z;

    /* renamed from: l, reason: collision with root package name */
    private int f7887l = 0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7892q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f7893r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f7894s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f7895t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f7896u = false;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<g> f7897v = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<j>> f7898w = new CopyOnWriteArrayList<>();

    /* renamed from: y, reason: collision with root package name */
    private boolean f7900y = false;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<g> f7881f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<g> f7882g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private boolean f7883h = true;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<g> f7884i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<g> f7885j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private boolean f7886k = true;

    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.f7876a = context;
        this.f7877b = context.getResources();
        c0(true);
    }

    private static int B(int i5) {
        int i6 = ((-65536) & i5) >> 16;
        if (i6 >= 0) {
            int[] iArr = f7875A;
            if (i6 < iArr.length) {
                return (i5 & ExifInterface.COLOR_SPACE_UNCALIBRATED) | (iArr[i6] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void O(int i5, boolean z5) {
        if (i5 < 0 || i5 >= this.f7881f.size()) {
            return;
        }
        this.f7881f.remove(i5);
        if (z5) {
            L(true);
        }
    }

    private void X(int i5, CharSequence charSequence, int i6, Drawable drawable, View view) {
        Resources resourcesC = C();
        if (view != null) {
            this.f7891p = view;
            this.f7889n = null;
            this.f7890o = null;
        } else {
            if (i5 > 0) {
                this.f7889n = resourcesC.getText(i5);
            } else if (charSequence != null) {
                this.f7889n = charSequence;
            }
            if (i6 > 0) {
                this.f7890o = androidx.core.content.a.e(u(), i6);
            } else if (drawable != null) {
                this.f7890o = drawable;
            }
            this.f7891p = null;
        }
        L(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c0(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f7877b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f7876a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f7876a
            boolean r3 = androidx.core.view.L.l(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f7879d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.c0(boolean):void");
    }

    private g g(int i5, int i6, int i7, int i8, CharSequence charSequence, int i9) {
        return new g(this, i5, i6, i7, i8, charSequence, i9);
    }

    private void i(boolean z5) {
        if (this.f7898w.isEmpty()) {
            return;
        }
        e0();
        Iterator<WeakReference<j>> it = this.f7898w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar = next.get();
            if (jVar == null) {
                this.f7898w.remove(next);
            } else {
                jVar.b(z5);
            }
        }
        d0();
    }

    private boolean j(m mVar, j jVar) {
        if (this.f7898w.isEmpty()) {
            return false;
        }
        boolean zJ = jVar != null ? jVar.j(mVar) : false;
        Iterator<WeakReference<j>> it = this.f7898w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar2 = next.get();
            if (jVar2 == null) {
                this.f7898w.remove(next);
            } else if (!zJ) {
                zJ = jVar2.j(mVar);
            }
        }
        return zJ;
    }

    private static int n(ArrayList<g> arrayList, int i5) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i5) {
                return size + 1;
            }
        }
        return 0;
    }

    boolean A() {
        return this.f7895t;
    }

    Resources C() {
        return this.f7877b;
    }

    public e D() {
        return this;
    }

    public ArrayList<g> E() {
        if (!this.f7883h) {
            return this.f7882g;
        }
        this.f7882g.clear();
        int size = this.f7881f.size();
        for (int i5 = 0; i5 < size; i5++) {
            g gVar = this.f7881f.get(i5);
            if (gVar.isVisible()) {
                this.f7882g.add(gVar);
            }
        }
        this.f7883h = false;
        this.f7886k = true;
        return this.f7882g;
    }

    public boolean F() {
        return !this.f7892q;
    }

    public boolean G() {
        return this.f7900y;
    }

    boolean H() {
        return this.f7878c;
    }

    public boolean I() {
        return this.f7879d;
    }

    void J(g gVar) {
        this.f7886k = true;
        L(true);
    }

    void K(g gVar) {
        this.f7883h = true;
        L(true);
    }

    public void L(boolean z5) {
        if (this.f7892q) {
            this.f7893r = true;
            if (z5) {
                this.f7894s = true;
                return;
            }
            return;
        }
        if (z5) {
            this.f7883h = true;
            this.f7886k = true;
        }
        i(z5);
    }

    public boolean M(MenuItem menuItem, int i5) {
        return N(menuItem, null, i5);
    }

    public boolean N(MenuItem menuItem, j jVar, int i5) {
        g gVar = (g) menuItem;
        if (gVar == null || !gVar.isEnabled()) {
            return false;
        }
        boolean zK = gVar.k();
        AbstractC0457b abstractC0457bB = gVar.b();
        boolean z5 = abstractC0457bB != null && abstractC0457bB.a();
        if (gVar.j()) {
            boolean zExpandActionView = gVar.expandActionView() | zK;
            if (zExpandActionView) {
                e(true);
            }
            return zExpandActionView;
        }
        if (!gVar.hasSubMenu() && !z5) {
            if ((i5 & 1) == 0) {
                e(true);
            }
            return zK;
        }
        if ((i5 & 4) == 0) {
            e(false);
        }
        if (!gVar.hasSubMenu()) {
            gVar.x(new m(u(), this, gVar));
        }
        m mVar = (m) gVar.getSubMenu();
        if (z5) {
            abstractC0457bB.f(mVar);
        }
        boolean zJ = j(mVar, jVar) | zK;
        if (!zJ) {
            e(true);
        }
        return zJ;
    }

    public void P(j jVar) {
        Iterator<WeakReference<j>> it = this.f7898w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar2 = next.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.f7898w.remove(next);
            }
        }
    }

    public void Q(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = getItem(i5);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).Q(bundle);
            }
        }
        int i6 = bundle.getInt("android:menu:expandedactionview");
        if (i6 <= 0 || (menuItemFindItem = findItem(i6)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void R(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = getItem(i5);
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
                ((m) item.getSubMenu()).R(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void S(a aVar) {
        this.f7880e = aVar;
    }

    public e T(int i5) {
        this.f7887l = i5;
        return this;
    }

    void U(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f7881f.size();
        e0();
        for (int i5 = 0; i5 < size; i5++) {
            g gVar = this.f7881f.get(i5);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        d0();
    }

    protected e V(int i5) {
        X(0, null, i5, null, null);
        return this;
    }

    protected e W(Drawable drawable) {
        X(0, null, 0, drawable, null);
        return this;
    }

    protected e Y(int i5) {
        X(i5, null, 0, null, null);
        return this;
    }

    protected e Z(CharSequence charSequence) {
        X(0, charSequence, 0, null, null);
        return this;
    }

    protected MenuItem a(int i5, int i6, int i7, CharSequence charSequence) {
        int iB = B(i7);
        g gVarG = g(i5, i6, i7, iB, charSequence, this.f7887l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f7888m;
        if (contextMenuInfo != null) {
            gVarG.v(contextMenuInfo);
        }
        ArrayList<g> arrayList = this.f7881f;
        arrayList.add(n(arrayList, iB), gVarG);
        L(true);
        return gVarG;
    }

    protected e a0(View view) {
        X(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        int i9;
        PackageManager packageManager = this.f7876a.getPackageManager();
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

    public void b(j jVar) {
        c(jVar, this.f7876a);
    }

    public void b0(boolean z5) {
        this.f7901z = z5;
    }

    public void c(j jVar, Context context) {
        this.f7898w.add(new WeakReference<>(jVar));
        jVar.i(context, this);
        this.f7886k = true;
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.f7899x;
        if (gVar != null) {
            f(gVar);
        }
        this.f7881f.clear();
        L(true);
    }

    public void clearHeader() {
        this.f7890o = null;
        this.f7889n = null;
        this.f7891p = null;
        L(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f7880e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        this.f7892q = false;
        if (this.f7893r) {
            this.f7893r = false;
            L(this.f7894s);
        }
    }

    public final void e(boolean z5) {
        if (this.f7896u) {
            return;
        }
        this.f7896u = true;
        Iterator<WeakReference<j>> it = this.f7898w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar = next.get();
            if (jVar == null) {
                this.f7898w.remove(next);
            } else {
                jVar.d(this, z5);
            }
        }
        this.f7896u = false;
    }

    public void e0() {
        if (this.f7892q) {
            return;
        }
        this.f7892q = true;
        this.f7893r = false;
        this.f7894s = false;
    }

    public boolean f(g gVar) {
        boolean zE = false;
        if (!this.f7898w.isEmpty() && this.f7899x == gVar) {
            e0();
            Iterator<WeakReference<j>> it = this.f7898w.iterator();
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f7898w.remove(next);
                } else {
                    zE = jVar.e(this, gVar);
                    if (zE) {
                        break;
                    }
                }
            }
            d0();
            if (zE) {
                this.f7899x = null;
            }
        }
        return zE;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i5) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = this.f7881f.get(i6);
            if (gVar.getItemId() == i5) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (menuItemFindItem = gVar.getSubMenu().findItem(i5)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i5) {
        return this.f7881f.get(i5);
    }

    boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.f7880e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f7901z) {
            return true;
        }
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f7881f.get(i5).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        return p(i5, keyEvent) != null;
    }

    public boolean k(g gVar) {
        boolean zF = false;
        if (this.f7898w.isEmpty()) {
            return false;
        }
        e0();
        Iterator<WeakReference<j>> it = this.f7898w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar = next.get();
            if (jVar == null) {
                this.f7898w.remove(next);
            } else {
                zF = jVar.f(this, gVar);
                if (zF) {
                    break;
                }
            }
        }
        d0();
        if (zF) {
            this.f7899x = gVar;
        }
        return zF;
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
            if (this.f7881f.get(i6).getGroupId() == i5) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public int o(int i5) {
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            if (this.f7881f.get(i6).getItemId() == i5) {
                return i6;
            }
        }
        return -1;
    }

    g p(int i5, KeyEvent keyEvent) {
        ArrayList<g> arrayList = this.f7897v;
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
        boolean zH = H();
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = arrayList.get(i6);
            char alphabeticShortcut = zH ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zH && alphabeticShortcut == '\b' && i5 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i5, int i6) {
        return M(findItem(i5), i6);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        g gVarP = p(i5, keyEvent);
        boolean zM = gVarP != null ? M(gVarP, i6) : false;
        if ((i6 & 2) != 0) {
            e(true);
        }
        return zM;
    }

    void q(List<g> list, int i5, KeyEvent keyEvent) {
        boolean zH = H();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i5 == 67) {
            int size = this.f7881f.size();
            for (int i6 = 0; i6 < size; i6++) {
                g gVar = this.f7881f.get(i6);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).q(list, i5, keyEvent);
                }
                char alphabeticShortcut = zH ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zH ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zH && alphabeticShortcut == '\b' && i5 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList<g> arrayListE = E();
        if (this.f7886k) {
            Iterator<WeakReference<j>> it = this.f7898w.iterator();
            boolean zC = false;
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f7898w.remove(next);
                } else {
                    zC |= jVar.c();
                }
            }
            if (zC) {
                this.f7884i.clear();
                this.f7885j.clear();
                int size = arrayListE.size();
                for (int i5 = 0; i5 < size; i5++) {
                    g gVar = arrayListE.get(i5);
                    if (gVar.l()) {
                        this.f7884i.add(gVar);
                    } else {
                        this.f7885j.add(gVar);
                    }
                }
            } else {
                this.f7884i.clear();
                this.f7885j.clear();
                this.f7885j.addAll(E());
            }
            this.f7886k = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i5) {
        int iL = l(i5);
        if (iL >= 0) {
            int size = this.f7881f.size() - iL;
            int i6 = 0;
            while (true) {
                int i7 = i6 + 1;
                if (i6 >= size || this.f7881f.get(iL).getGroupId() != i5) {
                    break;
                }
                O(iL, false);
                i6 = i7;
            }
            L(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i5) {
        O(o(i5), true);
    }

    public ArrayList<g> s() {
        r();
        return this.f7884i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i5, boolean z5, boolean z6) {
        int size = this.f7881f.size();
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = this.f7881f.get(i6);
            if (gVar.getGroupId() == i5) {
                gVar.t(z6);
                gVar.setCheckable(z5);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z5) {
        this.f7900y = z5;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i5, boolean z5) {
        int size = this.f7881f.size();
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = this.f7881f.get(i6);
            if (gVar.getGroupId() == i5) {
                gVar.setEnabled(z5);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i5, boolean z5) {
        int size = this.f7881f.size();
        boolean z6 = false;
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = this.f7881f.get(i6);
            if (gVar.getGroupId() == i5 && gVar.y(z5)) {
                z6 = true;
            }
        }
        if (z6) {
            L(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z5) {
        this.f7878c = z5;
        L(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f7881f.size();
    }

    protected String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f7876a;
    }

    public g v() {
        return this.f7899x;
    }

    public Drawable w() {
        return this.f7890o;
    }

    public CharSequence x() {
        return this.f7889n;
    }

    public View y() {
        return this.f7891p;
    }

    public ArrayList<g> z() {
        r();
        return this.f7885j;
    }

    @Override // android.view.Menu
    public MenuItem add(int i5) {
        return a(0, 0, 0, this.f7877b.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5) {
        return addSubMenu(0, 0, 0, this.f7877b.getString(i5));
    }

    @Override // android.view.Menu
    public MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        return a(i5, i6, i7, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        g gVar = (g) a(i5, i6, i7, charSequence);
        m mVar = new m(this.f7876a, this, gVar);
        gVar.x(mVar);
        return mVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i5, int i6, int i7, int i8) {
        return a(i5, i6, i7, this.f7877b.getString(i8));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return addSubMenu(i5, i6, i7, this.f7877b.getString(i8));
    }
}
