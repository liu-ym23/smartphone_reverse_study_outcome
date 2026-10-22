package K3;

import K.AbstractC0072d;
import L3.l;
import L3.q;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Menu f1095a;

    /* renamed from: b, reason: collision with root package name */
    public int f1096b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f1097c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f1098d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f1099e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1100f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1101g = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1102h;

    /* renamed from: i, reason: collision with root package name */
    public int f1103i;

    /* renamed from: j, reason: collision with root package name */
    public int f1104j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f1105k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f1106l;

    /* renamed from: m, reason: collision with root package name */
    public int f1107m;

    /* renamed from: n, reason: collision with root package name */
    public char f1108n;

    /* renamed from: o, reason: collision with root package name */
    public char f1109o;

    /* renamed from: p, reason: collision with root package name */
    public int f1110p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1111q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1112r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1113s;

    /* renamed from: t, reason: collision with root package name */
    public int f1114t;

    /* renamed from: u, reason: collision with root package name */
    public int f1115u;

    /* renamed from: v, reason: collision with root package name */
    public String f1116v;

    /* renamed from: w, reason: collision with root package name */
    public String f1117w;

    /* renamed from: x, reason: collision with root package name */
    public AbstractC0072d f1118x;

    /* renamed from: y, reason: collision with root package name */
    public final /* synthetic */ k f1119y;

    public j(k kVar, Menu menu) {
        this.f1119y = kVar;
        this.f1095a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<?> constructor = this.f1119y.f1124c.getClassLoader().loadClass(str).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e4) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e4);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        boolean z4 = false;
        menuItem.setChecked(this.f1111q).setVisible(this.f1112r).setEnabled(this.f1113s).setCheckable(this.f1110p >= 1).setTitleCondensed(this.f1106l).setIcon(this.f1107m).setAlphabeticShortcut(this.f1108n).setNumericShortcut(this.f1109o);
        int i4 = this.f1114t;
        if (i4 >= 0) {
            menuItem.setShowAsAction(i4);
        }
        String str = this.f1117w;
        k kVar = this.f1119y;
        if (str != null) {
            if (kVar.f1124c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (kVar.f1125d == null) {
                kVar.f1125d = k.a(kVar.f1124c);
            }
            Object obj = kVar.f1125d;
            String str2 = this.f1117w;
            i iVar = new i();
            iVar.f1093a = obj;
            Class<?> cls = obj.getClass();
            try {
                iVar.f1094b = cls.getMethod(str2, i.f1092c);
                menuItem.setOnMenuItemClickListener(iVar);
            } catch (Exception e4) {
                StringBuilder sbW = B0.g.w("Couldn't resolve menu item onClick handler ", str2, " in class ");
                sbW.append(cls.getName());
                throw new InflateException(sbW.toString(), e4);
            }
        }
        boolean z5 = menuItem instanceof l;
        if (z5) {
        }
        if (this.f1110p >= 2) {
            if (z5) {
                l lVar = (l) menuItem;
                lVar.f1328x = (lVar.f1328x & (-5)) | 4;
            } else if (menuItem instanceof q) {
                q qVar = (q) menuItem;
                try {
                    if (qVar.f1336e == null) {
                        qVar.f1336e = ((F.b) qVar.f825b).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    qVar.f1336e.invoke(qVar.f825b, Boolean.TRUE);
                } catch (Exception e5) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e5);
                }
            }
        }
        String str3 = this.f1116v;
        if (str3 != null) {
            menuItem.setActionView((View) a(str3, k.f1120e, kVar.f1122a));
            z4 = true;
        }
        int i5 = this.f1115u;
        if (i5 > 0) {
            if (z4) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i5);
            }
        }
        AbstractC0072d abstractC0072d = this.f1118x;
        if (abstractC0072d != null) {
            if (menuItem instanceof F.b) {
                ((F.b) menuItem).b(abstractC0072d);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
    }
}
