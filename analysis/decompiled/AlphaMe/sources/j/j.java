package j;

import K.AbstractC0072d;
import K.AbstractC0083o;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import k.C0663q;
import k.MenuItemC0668v;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f13069A;

    /* renamed from: B, reason: collision with root package name */
    public CharSequence f13070B;

    /* renamed from: E, reason: collision with root package name */
    public final /* synthetic */ k f13073E;

    /* renamed from: a, reason: collision with root package name */
    public final Menu f13074a;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13081h;

    /* renamed from: i, reason: collision with root package name */
    public int f13082i;

    /* renamed from: j, reason: collision with root package name */
    public int f13083j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f13084k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f13085l;

    /* renamed from: m, reason: collision with root package name */
    public int f13086m;

    /* renamed from: n, reason: collision with root package name */
    public char f13087n;

    /* renamed from: o, reason: collision with root package name */
    public int f13088o;

    /* renamed from: p, reason: collision with root package name */
    public char f13089p;

    /* renamed from: q, reason: collision with root package name */
    public int f13090q;

    /* renamed from: r, reason: collision with root package name */
    public int f13091r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f13092s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f13093t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13094u;

    /* renamed from: v, reason: collision with root package name */
    public int f13095v;

    /* renamed from: w, reason: collision with root package name */
    public int f13096w;

    /* renamed from: x, reason: collision with root package name */
    public String f13097x;

    /* renamed from: y, reason: collision with root package name */
    public String f13098y;

    /* renamed from: z, reason: collision with root package name */
    public AbstractC0072d f13099z;

    /* renamed from: C, reason: collision with root package name */
    public ColorStateList f13071C = null;

    /* renamed from: D, reason: collision with root package name */
    public PorterDuff.Mode f13072D = null;

    /* renamed from: b, reason: collision with root package name */
    public int f13075b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f13076c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f13077d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f13078e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13079f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13080g = true;

    public j(k kVar, Menu menu) {
        this.f13073E = kVar;
        this.f13074a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.f13073E.f13104c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e4) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e4);
            return null;
        }
    }

    public final void b(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z4 = false;
        menuItem.setChecked(this.f13092s).setVisible(this.f13093t).setEnabled(this.f13094u).setCheckable(this.f13091r >= 1).setTitleCondensed(this.f13085l).setIcon(this.f13086m);
        int i4 = this.f13095v;
        if (i4 >= 0) {
            menuItem.setShowAsAction(i4);
        }
        String str = this.f13098y;
        k kVar = this.f13073E;
        if (str != null) {
            if (kVar.f13104c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (kVar.f13105d == null) {
                kVar.f13105d = k.a(kVar.f13104c);
            }
            Object obj = kVar.f13105d;
            String str2 = this.f13098y;
            i iVar = new i();
            iVar.f13067a = obj;
            Class<?> cls = obj.getClass();
            try {
                iVar.f13068b = cls.getMethod(str2, i.f13066c);
                menuItem.setOnMenuItemClickListener(iVar);
            } catch (Exception e4) {
                StringBuilder sbW = B0.g.w("Couldn't resolve menu item onClick handler ", str2, " in class ");
                sbW.append(cls.getName());
                InflateException inflateException = new InflateException(sbW.toString());
                inflateException.initCause(e4);
                throw inflateException;
            }
        }
        if (this.f13091r >= 2) {
            if (menuItem instanceof C0663q) {
                C0663q c0663q = (C0663q) menuItem;
                c0663q.f13292x = (c0663q.f13292x & (-5)) | 4;
            } else if (menuItem instanceof MenuItemC0668v) {
                MenuItemC0668v menuItemC0668v = (MenuItemC0668v) menuItem;
                try {
                    Method method = menuItemC0668v.f13304e;
                    F.b bVar = menuItemC0668v.f13303d;
                    if (method == null) {
                        menuItemC0668v.f13304e = bVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    menuItemC0668v.f13304e.invoke(bVar, Boolean.TRUE);
                } catch (Exception e5) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e5);
                }
            }
        }
        String str3 = this.f13097x;
        if (str3 != null) {
            menuItem.setActionView((View) a(str3, k.f13100e, kVar.f13102a));
            z4 = true;
        }
        int i5 = this.f13096w;
        if (i5 > 0) {
            if (z4) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i5);
            }
        }
        AbstractC0072d abstractC0072d = this.f13099z;
        if (abstractC0072d != null) {
            if (menuItem instanceof F.b) {
                ((F.b) menuItem).b(abstractC0072d);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.f13069A;
        boolean z5 = menuItem instanceof F.b;
        if (z5) {
            ((F.b) menuItem).setContentDescription(charSequence);
        } else {
            AbstractC0083o.h(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.f13070B;
        if (z5) {
            ((F.b) menuItem).setTooltipText(charSequence2);
        } else {
            AbstractC0083o.m(menuItem, charSequence2);
        }
        char c4 = this.f13087n;
        int i6 = this.f13088o;
        if (z5) {
            ((F.b) menuItem).setAlphabeticShortcut(c4, i6);
        } else {
            AbstractC0083o.g(menuItem, c4, i6);
        }
        char c5 = this.f13089p;
        int i7 = this.f13090q;
        if (z5) {
            ((F.b) menuItem).setNumericShortcut(c5, i7);
        } else {
            AbstractC0083o.k(menuItem, c5, i7);
        }
        PorterDuff.Mode mode = this.f13072D;
        if (mode != null) {
            if (z5) {
                ((F.b) menuItem).setIconTintMode(mode);
            } else {
                AbstractC0083o.j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.f13071C;
        if (colorStateList != null) {
            if (z5) {
                ((F.b) menuItem).setIconTintList(colorStateList);
            } else {
                AbstractC0083o.i(menuItem, colorStateList);
            }
        }
    }
}
