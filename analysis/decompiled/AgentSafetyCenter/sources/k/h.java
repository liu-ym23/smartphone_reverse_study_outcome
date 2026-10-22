package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import l.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {
    public CharSequence A;
    public CharSequence B;
    public ColorStateList C;
    public PorterDuff.Mode D;
    public /* synthetic */ i E;

    /* renamed from: a, reason: collision with root package name */
    public Menu f6819a;

    /* renamed from: b, reason: collision with root package name */
    public int f6820b;

    /* renamed from: c, reason: collision with root package name */
    public int f6821c;

    /* renamed from: d, reason: collision with root package name */
    public int f6822d;

    /* renamed from: e, reason: collision with root package name */
    public int f6823e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6824f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6825g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6826h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f6827j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f6828k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f6829l;

    /* renamed from: m, reason: collision with root package name */
    public int f6830m;

    /* renamed from: n, reason: collision with root package name */
    public char f6831n;

    /* renamed from: o, reason: collision with root package name */
    public int f6832o;

    /* renamed from: p, reason: collision with root package name */
    public char f6833p;

    /* renamed from: q, reason: collision with root package name */
    public int f6834q;

    /* renamed from: r, reason: collision with root package name */
    public int f6835r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6836s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6837t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f6838u;

    /* renamed from: v, reason: collision with root package name */
    public int f6839v;

    /* renamed from: w, reason: collision with root package name */
    public int f6840w;

    /* renamed from: x, reason: collision with root package name */
    public String f6841x;

    /* renamed from: y, reason: collision with root package name */
    public String f6842y;

    /* renamed from: z, reason: collision with root package name */
    public n3.d f6843z;

    public final Object a(String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.E.f6848c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e10) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
            return null;
        }
    }

    public final void b(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        i iVar = this.E;
        Context context = iVar.f6848c;
        boolean z10 = false;
        menuItem.setChecked(this.f6836s).setVisible(this.f6837t).setEnabled(this.f6838u).setCheckable(this.f6835r >= 1).setTitleCondensed(this.f6829l).setIcon(this.f6830m);
        int i = this.f6839v;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        if (this.f6842y != null) {
            if (context.isRestricted()) {
                od.f.e("The android:onClick attribute cannot be used within a restricted context");
                return;
            }
            if (iVar.f6849d == null) {
                iVar.f6849d = i.a(context);
            }
            Object obj = iVar.f6849d;
            String str = this.f6842y;
            g gVar = new g();
            gVar.f6817a = obj;
            Class<?> cls = obj.getClass();
            try {
                gVar.f6818b = cls.getMethod(str, g.f6816c);
                menuItem.setOnMenuItemClickListener(gVar);
            } catch (Exception e10) {
                StringBuilder sbO = androidx.activity.b.o("Couldn't resolve menu item onClick handler ", str, " in class ");
                sbO.append(cls.getName());
                InflateException inflateException = new InflateException(sbO.toString());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }
        if (this.f6835r >= 2) {
            if (menuItem instanceof l.n) {
                l.n nVar = (l.n) menuItem;
                nVar.f7632x = (nVar.f7632x & (-5)) | 4;
            } else if (menuItem instanceof s) {
                s sVar = (s) menuItem;
                h3.b bVar = sVar.f7642c;
                try {
                    if (sVar.f7643d == null) {
                        sVar.f7643d = bVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    sVar.f7643d.invoke(bVar, Boolean.TRUE);
                } catch (Exception e11) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e11);
                }
            }
        }
        String str2 = this.f6841x;
        if (str2 != null) {
            menuItem.setActionView((View) a(str2, i.f6844e, iVar.f6846a));
            z10 = true;
        }
        int i3 = this.f6840w;
        if (i3 > 0) {
            if (z10) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i3);
            }
        }
        n3.d dVar = this.f6843z;
        if (dVar != null) {
            if (menuItem instanceof h3.b) {
                ((h3.b) menuItem).b(dVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.A;
        boolean z11 = menuItem instanceof h3.b;
        if (z11) {
            ((h3.b) menuItem).setContentDescription(charSequence);
        } else {
            menuItem.setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.B;
        if (z11) {
            ((h3.b) menuItem).setTooltipText(charSequence2);
        } else {
            menuItem.setTooltipText(charSequence2);
        }
        char c9 = this.f6831n;
        int i10 = this.f6832o;
        if (z11) {
            ((h3.b) menuItem).setAlphabeticShortcut(c9, i10);
        } else {
            menuItem.setAlphabeticShortcut(c9, i10);
        }
        char c10 = this.f6833p;
        int i11 = this.f6834q;
        if (z11) {
            ((h3.b) menuItem).setNumericShortcut(c10, i11);
        } else {
            menuItem.setNumericShortcut(c10, i11);
        }
        PorterDuff.Mode mode = this.D;
        if (mode != null) {
            if (z11) {
                ((h3.b) menuItem).setIconTintMode(mode);
            } else {
                menuItem.setIconTintMode(mode);
            }
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList != null) {
            if (z11) {
                ((h3.b) menuItem).setIconTintList(colorStateList);
            } else {
                menuItem.setIconTintList(colorStateList);
            }
        }
    }
}
