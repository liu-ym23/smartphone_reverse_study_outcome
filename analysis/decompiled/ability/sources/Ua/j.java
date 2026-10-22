package Ua;

import Va.q;
import Va.v;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.lang.reflect.Constructor;

/* loaded from: classes4.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Menu f1288a;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public boolean f = true;
    public boolean g = true;
    public boolean h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f1289j;
    public CharSequence k;
    public CharSequence l;
    public int m;
    public char n;
    public char o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1290q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1291r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1292s;

    /* renamed from: t, reason: collision with root package name */
    public int f1293t;
    public int u;

    /* renamed from: v, reason: collision with root package name */
    public String f1294v;

    /* renamed from: w, reason: collision with root package name */
    public String f1295w;

    /* renamed from: x, reason: collision with root package name */
    public ActionProvider f1296x;
    public final /* synthetic */ k y;

    public j(k kVar, Menu menu) {
        this.y = kVar;
        this.f1288a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<?> constructor = this.y.c.getClassLoader().loadClass(str).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        boolean z10 = false;
        menuItem.setChecked(this.f1290q).setVisible(this.f1291r).setEnabled(this.f1292s).setCheckable(this.p >= 1).setTitleCondensed(this.l).setIcon(this.m).setAlphabeticShortcut(this.n).setNumericShortcut(this.o);
        int i = this.f1293t;
        if (i >= 0) {
            MenuItemCompat.setShowAsAction(menuItem, i);
        }
        String str = this.f1295w;
        k kVar = this.y;
        if (str != null) {
            if (kVar.c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (kVar.d == null) {
                kVar.d = k.a(kVar.c);
            }
            Object obj = kVar.d;
            String str2 = this.f1295w;
            i iVar = new i();
            iVar.f1287a = obj;
            Class<?> cls = obj.getClass();
            try {
                iVar.b = cls.getMethod(str2, i.c);
                menuItem.setOnMenuItemClickListener(iVar);
            } catch (Exception e) {
                StringBuilder sbV = B7.a.v("Couldn't resolve menu item onClick handler ", str2, " in class ");
                sbV.append(cls.getName());
                throw new InflateException(sbV.toString(), e);
            }
        }
        boolean z11 = menuItem instanceof q;
        if (z11) {
        }
        if (this.p >= 2) {
            if (z11) {
                q qVar = (q) menuItem;
                qVar.f1461x = (qVar.f1461x & (-5)) | 4;
            } else if (menuItem instanceof v) {
                v vVar = (v) menuItem;
                Object obj2 = vVar.f160a;
                try {
                    if (vVar.e == null) {
                        vVar.e = ((SupportMenuItem) obj2).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    vVar.e.invoke(obj2, Boolean.TRUE);
                } catch (Exception e6) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e6);
                }
            }
        }
        String str3 = this.f1294v;
        if (str3 != null) {
            MenuItemCompat.setActionView(menuItem, (View) a(str3, k.e, kVar.f1297a));
            z10 = true;
        }
        int i6 = this.u;
        if (i6 > 0) {
            if (z10) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                MenuItemCompat.setActionView(menuItem, i6);
            }
        }
        ActionProvider actionProvider = this.f1296x;
        if (actionProvider != null) {
            MenuItemCompat.setActionProvider(menuItem, actionProvider);
        }
    }
}
