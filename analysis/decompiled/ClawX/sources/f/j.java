package f;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.ActionMenuView;
import g.v1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class j implements Menu {

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f2453u = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f2454a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f2455b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2456c;
    public final boolean d;

    /* renamed from: e, reason: collision with root package name */
    public androidx.emoji2.text.m f2457e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f2458f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f2459g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2460h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f2461i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f2462j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2463k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f2464l;

    /* renamed from: s, reason: collision with root package name */
    public k f2471s;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2465m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2466n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2467o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2468p = false;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f2469q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    public final CopyOnWriteArrayList f2470r = new CopyOnWriteArrayList();

    /* renamed from: t, reason: collision with root package name */
    public boolean f2472t = false;

    public j(Context context) {
        boolean z = false;
        this.f2454a = context;
        Resources resources = context.getResources();
        this.f2455b = resources;
        this.f2458f = new ArrayList();
        this.f2459g = new ArrayList();
        this.f2460h = true;
        this.f2461i = new ArrayList();
        this.f2462j = new ArrayList();
        this.f2463k = true;
        if (resources.getConfiguration().keyboard != 1 && ViewConfiguration.get(context).shouldShowMenuShortcutsWhenKeyboardPresent()) {
            z = true;
        }
        this.d = z;
    }

    public final k a(int i8, int i9, int i10, CharSequence charSequence) {
        int i11;
        int i12 = ((-65536) & i10) >> 16;
        if (i12 < 0 || i12 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i13 = (f2453u[i12] << 16) | (65535 & i10);
        k kVar = new k(this, i8, i9, i10, i13, charSequence);
        ArrayList arrayList = this.f2458f;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i11 = 0;
                break;
            }
            if (((k) arrayList.get(size)).d <= i13) {
                i11 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i11, kVar);
        o(true);
        return kVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i8, int i9, int i10, ComponentName componentName, Intent[] intentArr, Intent intent, int i11, MenuItem[] menuItemArr) {
        int i12;
        PackageManager packageManager = this.f2454a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i11 & 1) == 0) {
            removeGroup(i8);
        }
        for (int i13 = 0; i13 < size; i13++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i13);
            int i14 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i14 < 0 ? intent : intentArr[i14]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            k kVarA = a(i8, i9, i10, resolveInfo.loadLabel(packageManager));
            kVarA.setIcon(resolveInfo.loadIcon(packageManager));
            kVarA.f2478g = intent2;
            if (menuItemArr != null && (i12 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i12] = kVarA;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(p pVar, Context context) {
        this.f2470r.add(new WeakReference(pVar));
        pVar.i(context, this);
        this.f2463k = true;
    }

    public final void c(boolean z) {
        if (this.f2468p) {
            return;
        }
        this.f2468p = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2470r;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            p pVar = (p) weakReference.get();
            if (pVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                pVar.b(this, z);
            }
        }
        this.f2468p = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        k kVar = this.f2471s;
        if (kVar != null) {
            d(kVar);
        }
        this.f2458f.clear();
        o(true);
    }

    public final void clearHeader() {
        this.f2464l = null;
        o(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(k kVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2470r;
        boolean zF = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f2471s == kVar) {
            s();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                p pVar = (p) weakReference.get();
                if (pVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zF = pVar.f(kVar);
                    if (zF) {
                        break;
                    }
                }
            }
            r();
            if (zF) {
                this.f2471s = null;
            }
        }
        return zF;
    }

    public boolean e(j jVar, MenuItem menuItem) {
        g.l lVar;
        androidx.emoji2.text.m mVar = this.f2457e;
        if (mVar == null || (lVar = ((ActionMenuView) mVar.f621a).z) == null) {
            return false;
        }
        Iterator it = ((CopyOnWriteArrayList) ((v1) lVar).f2848a.H.f621a).iterator();
        if (!it.hasNext()) {
            return false;
        }
        ((androidx.fragment.app.i) it.next()).getClass();
        throw null;
    }

    public boolean f(k kVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2470r;
        boolean zC = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        s();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            p pVar = (p) weakReference.get();
            if (pVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                zC = pVar.c(kVar);
                if (zC) {
                    break;
                }
            }
        }
        r();
        if (zC) {
            this.f2471s = kVar;
        }
        return zC;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i8) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.f2458f;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            k kVar = (k) arrayList.get(i9);
            if (kVar.f2473a == i8) {
                return kVar;
            }
            if (kVar.hasSubMenu() && (menuItemFindItem = kVar.f2486o.findItem(i8)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final k g(int i8, KeyEvent keyEvent) {
        ArrayList arrayList = this.f2469q;
        arrayList.clear();
        h(arrayList, i8, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (k) arrayList.get(0);
        }
        boolean zM = m();
        for (int i9 = 0; i9 < size; i9++) {
            k kVar = (k) arrayList.get(i9);
            char c3 = zM ? kVar.f2481j : kVar.f2479h;
            char[] cArr = keyData.meta;
            if ((c3 == cArr[0] && (metaState & 2) == 0) || ((c3 == cArr[2] && (metaState & 2) != 0) || (zM && c3 == '\b' && i8 == 67))) {
                return kVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i8) {
        return (MenuItem) this.f2458f.get(i8);
    }

    public final void h(List list, int i8, KeyEvent keyEvent) {
        boolean zM = m();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i8 == 67) {
            ArrayList arrayList = this.f2458f;
            int size = arrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                k kVar = (k) arrayList.get(i9);
                if (kVar.hasSubMenu()) {
                    kVar.f2486o.h(list, i8, keyEvent);
                }
                char c3 = zM ? kVar.f2481j : kVar.f2479h;
                if ((modifiers & 69647) == ((zM ? kVar.f2482k : kVar.f2480i) & 69647) && c3 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c3 == cArr[0] || c3 == cArr[2] || (zM && c3 == '\b' && i8 == 67)) && kVar.isEnabled()) {
                        list.add(kVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        ArrayList arrayList = this.f2458f;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (((k) arrayList.get(i8)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList arrayListK = k();
        if (this.f2463k) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f2470r;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean zH = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                p pVar = (p) weakReference.get();
                if (pVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zH |= pVar.h();
                }
            }
            ArrayList arrayList = this.f2461i;
            ArrayList arrayList2 = this.f2462j;
            if (zH) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListK.size();
                for (int i8 = 0; i8 < size; i8++) {
                    k kVar = (k) arrayListK.get(i8);
                    if ((kVar.f2495x & 32) == 32) {
                        arrayList.add(kVar);
                    } else {
                        arrayList2.add(kVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(k());
            }
            this.f2463k = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i8, KeyEvent keyEvent) {
        return g(i8, keyEvent) != null;
    }

    public final ArrayList k() {
        boolean z = this.f2460h;
        ArrayList arrayList = this.f2459g;
        if (!z) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f2458f;
        int size = arrayList2.size();
        for (int i8 = 0; i8 < size; i8++) {
            k kVar = (k) arrayList2.get(i8);
            if (kVar.isVisible()) {
                arrayList.add(kVar);
            }
        }
        this.f2460h = false;
        this.f2463k = true;
        return arrayList;
    }

    public boolean l() {
        return this.f2472t;
    }

    public boolean m() {
        return this.f2456c;
    }

    public boolean n() {
        return this.d;
    }

    public final void o(boolean z) {
        if (this.f2465m) {
            this.f2466n = true;
            if (z) {
                this.f2467o = true;
                return;
            }
            return;
        }
        if (z) {
            this.f2460h = true;
            this.f2463k = true;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2470r;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        s();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            p pVar = (p) weakReference.get();
            if (pVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                pVar.e();
            }
        }
        r();
    }

    public final boolean p(MenuItem menuItem, l lVar, int i8) {
        boolean zExpandActionView;
        k kVar = (k) menuItem;
        if (kVar == null || !kVar.isEnabled()) {
            return false;
        }
        j jVar = kVar.f2485n;
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = kVar.f2487p;
        if ((onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(kVar)) && !jVar.e(jVar, kVar)) {
            Intent intent = kVar.f2478g;
            if (intent != null) {
                try {
                    jVar.f2454a.startActivity(intent);
                    zExpandActionView = true;
                } catch (ActivityNotFoundException e9) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e9);
                }
            }
            zExpandActionView = false;
        } else {
            zExpandActionView = true;
        }
        if ((kVar.y & 8) != 0 && kVar.z != null) {
            zExpandActionView |= kVar.expandActionView();
            if (zExpandActionView) {
                c(true);
            }
        } else if (kVar.hasSubMenu()) {
            if ((i8 & 4) == 0) {
                c(false);
            }
            if (!kVar.hasSubMenu()) {
                t tVar = new t(this.f2454a, this, kVar);
                kVar.f2486o = tVar;
                tVar.setHeaderTitle(kVar.f2476e);
            }
            t tVar2 = kVar.f2486o;
            CopyOnWriteArrayList copyOnWriteArrayList = this.f2470r;
            if (!copyOnWriteArrayList.isEmpty()) {
                zJ = lVar != null ? lVar.j(tVar2) : false;
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    p pVar = (p) weakReference.get();
                    if (pVar == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else if (!zJ) {
                        zJ = pVar.j(tVar2);
                    }
                }
            }
            zExpandActionView |= zJ;
            if (!zExpandActionView) {
                c(true);
            }
        } else if ((i8 & 1) == 0) {
            c(true);
        }
        return zExpandActionView;
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i8, int i9) {
        return p(findItem(i8), null, i9);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i8, KeyEvent keyEvent, int i9) {
        k kVarG = g(i8, keyEvent);
        boolean zP = kVarG != null ? p(kVarG, null, i9) : false;
        if ((i9 & 2) != 0) {
            c(true);
        }
        return zP;
    }

    public final void q(int i8, CharSequence charSequence, int i9, View view) {
        if (view != null) {
            this.f2464l = null;
        } else {
            if (i8 > 0) {
                this.f2464l = this.f2455b.getText(i8);
            } else if (charSequence != null) {
                this.f2464l = charSequence;
            }
            if (i9 > 0) {
                this.f2454a.getDrawable(i9);
            }
        }
        o(false);
    }

    public final void r() {
        this.f2465m = false;
        if (this.f2466n) {
            this.f2466n = false;
            o(this.f2467o);
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i8) {
        ArrayList arrayList = this.f2458f;
        int size = arrayList.size();
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (((k) arrayList.get(i10)).f2474b == i8) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            int size2 = arrayList.size() - i10;
            while (true) {
                int i11 = i9 + 1;
                if (i9 >= size2 || ((k) arrayList.get(i10)).f2474b != i8) {
                    break;
                }
                if (i10 >= 0 && i10 < arrayList.size()) {
                    arrayList.remove(i10);
                }
                i9 = i11;
            }
            o(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i8) {
        ArrayList arrayList = this.f2458f;
        int size = arrayList.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                i9 = -1;
                break;
            } else if (((k) arrayList.get(i9)).f2473a == i8) {
                break;
            } else {
                i9++;
            }
        }
        if (i9 < 0 || i9 >= arrayList.size()) {
            return;
        }
        arrayList.remove(i9);
        o(true);
    }

    public final void s() {
        if (this.f2465m) {
            return;
        }
        this.f2465m = true;
        this.f2466n = false;
        this.f2467o = false;
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i8, boolean z, boolean z2) {
        ArrayList arrayList = this.f2458f;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            k kVar = (k) arrayList.get(i9);
            if (kVar.f2474b == i8) {
                kVar.f2495x = (kVar.f2495x & (-5)) | (z2 ? 4 : 0);
                kVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f2472t = z;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i8, boolean z) {
        ArrayList arrayList = this.f2458f;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            k kVar = (k) arrayList.get(i9);
            if (kVar.f2474b == i8) {
                kVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i8, boolean z) {
        ArrayList arrayList = this.f2458f;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i9 = 0; i9 < size; i9++) {
            k kVar = (k) arrayList.get(i9);
            if (kVar.f2474b == i8) {
                int i10 = kVar.f2495x;
                int i11 = (i10 & (-9)) | (z ? 0 : 8);
                kVar.f2495x = i11;
                if (i10 != i11) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            o(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f2456c = z;
        o(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f2458f.size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i8) {
        return a(0, 0, 0, this.f2455b.getString(i8));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i8) {
        return addSubMenu(0, 0, 0, this.f2455b.getString(i8));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i8, int i9, int i10, CharSequence charSequence) {
        return a(i8, i9, i10, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i8, int i9, int i10, CharSequence charSequence) {
        k kVarA = a(i8, i9, i10, charSequence);
        t tVar = new t(this.f2454a, this, kVarA);
        kVarA.f2486o = tVar;
        tVar.setHeaderTitle(kVarA.f2476e);
        return tVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i8, int i9, int i10, int i11) {
        return a(i8, i9, i10, this.f2455b.getString(i11));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i8, int i9, int i10, int i11) {
        return addSubMenu(i8, i9, i10, this.f2455b.getString(i11));
    }

    public j j() {
        return this;
    }
}
