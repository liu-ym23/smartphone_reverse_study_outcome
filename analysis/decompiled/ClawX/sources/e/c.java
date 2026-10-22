package e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import f.k;
import java.lang.reflect.Constructor;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {
    public CharSequence A;
    public final /* synthetic */ d D;

    /* renamed from: a, reason: collision with root package name */
    public final Menu f2256a;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2262h;

    /* renamed from: i, reason: collision with root package name */
    public int f2263i;

    /* renamed from: j, reason: collision with root package name */
    public int f2264j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f2265k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f2266l;

    /* renamed from: m, reason: collision with root package name */
    public int f2267m;

    /* renamed from: n, reason: collision with root package name */
    public char f2268n;

    /* renamed from: o, reason: collision with root package name */
    public int f2269o;

    /* renamed from: p, reason: collision with root package name */
    public char f2270p;

    /* renamed from: q, reason: collision with root package name */
    public int f2271q;

    /* renamed from: r, reason: collision with root package name */
    public int f2272r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2273s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2274t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2275u;

    /* renamed from: v, reason: collision with root package name */
    public int f2276v;

    /* renamed from: w, reason: collision with root package name */
    public int f2277w;

    /* renamed from: x, reason: collision with root package name */
    public String f2278x;
    public String y;
    public CharSequence z;
    public ColorStateList B = null;
    public PorterDuff.Mode C = null;

    /* renamed from: b, reason: collision with root package name */
    public int f2257b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f2258c = 0;
    public int d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f2259e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2260f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2261g = true;

    public c(d dVar, Menu menu) {
        this.D = dVar;
        this.f2256a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.D.f2283c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e9) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e9);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        d dVar = this.D;
        Context context = dVar.f2283c;
        boolean z = false;
        menuItem.setChecked(this.f2273s).setVisible(this.f2274t).setEnabled(this.f2275u).setCheckable(this.f2272r >= 1).setTitleCondensed(this.f2266l).setIcon(this.f2267m);
        int i8 = this.f2276v;
        if (i8 >= 0) {
            menuItem.setShowAsAction(i8);
        }
        if (this.y != null) {
            if (context.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (dVar.d == null) {
                dVar.d = d.a(context);
            }
            Object obj = dVar.d;
            String str = this.y;
            b bVar = new b();
            bVar.f2254a = obj;
            Class<?> cls = obj.getClass();
            try {
                bVar.f2255b = cls.getMethod(str, b.f2253c);
                menuItem.setOnMenuItemClickListener(bVar);
            } catch (Exception e9) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e9);
                throw inflateException;
            }
        }
        if (this.f2272r >= 2 && (menuItem instanceof k)) {
            k kVar = (k) menuItem;
            kVar.f2495x = (kVar.f2495x & (-5)) | 4;
        }
        String str2 = this.f2278x;
        if (str2 != null) {
            menuItem.setActionView((View) a(str2, d.f2279e, dVar.f2281a));
            z = true;
        }
        int i9 = this.f2277w;
        if (i9 > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i9);
            }
        }
        CharSequence charSequence = this.z;
        boolean z2 = menuItem instanceof k;
        if (z2) {
            ((k) menuItem).c(charSequence);
        } else {
            menuItem.setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.A;
        if (z2) {
            ((k) menuItem).e(charSequence2);
        } else {
            menuItem.setTooltipText(charSequence2);
        }
        char c3 = this.f2268n;
        int i10 = this.f2269o;
        if (z2) {
            ((k) menuItem).setAlphabeticShortcut(c3, i10);
        } else {
            menuItem.setAlphabeticShortcut(c3, i10);
        }
        char c8 = this.f2270p;
        int i11 = this.f2271q;
        if (z2) {
            ((k) menuItem).setNumericShortcut(c8, i11);
        } else {
            menuItem.setNumericShortcut(c8, i11);
        }
        PorterDuff.Mode mode = this.C;
        if (mode != null) {
            if (z2) {
                ((k) menuItem).setIconTintMode(mode);
            } else {
                menuItem.setIconTintMode(mode);
            }
        }
        ColorStateList colorStateList = this.B;
        if (colorStateList != null) {
            if (z2) {
                ((k) menuItem).setIconTintList(colorStateList);
            } else {
                menuItem.setIconTintList(colorStateList);
            }
        }
    }
}
