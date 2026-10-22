package se;

import android.content.Context;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import te.m;
import te.r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public Menu f12232a;

    /* renamed from: b, reason: collision with root package name */
    public int f12233b;

    /* renamed from: c, reason: collision with root package name */
    public int f12234c;

    /* renamed from: d, reason: collision with root package name */
    public int f12235d;

    /* renamed from: e, reason: collision with root package name */
    public int f12236e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12237f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12238g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12239h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f12240j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f12241k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f12242l;

    /* renamed from: m, reason: collision with root package name */
    public int f12243m;

    /* renamed from: n, reason: collision with root package name */
    public char f12244n;

    /* renamed from: o, reason: collision with root package name */
    public char f12245o;

    /* renamed from: p, reason: collision with root package name */
    public int f12246p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12247q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12248r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12249s;

    /* renamed from: t, reason: collision with root package name */
    public int f12250t;

    /* renamed from: u, reason: collision with root package name */
    public int f12251u;

    /* renamed from: v, reason: collision with root package name */
    public String f12252v;

    /* renamed from: w, reason: collision with root package name */
    public String f12253w;

    /* renamed from: x, reason: collision with root package name */
    public n3.d f12254x;

    /* renamed from: y, reason: collision with root package name */
    public /* synthetic */ j f12255y;

    public final Object a(String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<?> constructor = this.f12255y.f12260c.getClassLoader().loadClass(str).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e10) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        j jVar = this.f12255y;
        Context context = jVar.f12260c;
        boolean z10 = false;
        menuItem.setChecked(this.f12247q).setVisible(this.f12248r).setEnabled(this.f12249s).setCheckable(this.f12246p >= 1).setTitleCondensed(this.f12242l).setIcon(this.f12243m).setAlphabeticShortcut(this.f12244n).setNumericShortcut(this.f12245o);
        int i = this.f12250t;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        if (this.f12253w != null) {
            if (context.isRestricted()) {
                od.f.e("The android:onClick attribute cannot be used within a restricted context");
                return;
            }
            if (jVar.f12261d == null) {
                jVar.f12261d = j.a(context);
            }
            Object obj = jVar.f12261d;
            String str = this.f12253w;
            h hVar = new h();
            hVar.f12230a = obj;
            Class<?> cls = obj.getClass();
            try {
                hVar.f12231b = cls.getMethod(str, h.f12229c);
                menuItem.setOnMenuItemClickListener(hVar);
            } catch (Exception e10) {
                StringBuilder sbO = androidx.activity.b.o("Couldn't resolve menu item onClick handler ", str, " in class ");
                sbO.append(cls.getName());
                throw new InflateException(sbO.toString(), e10);
            }
        }
        boolean z11 = menuItem instanceof m;
        if (z11) {
        }
        if (this.f12246p >= 2) {
            if (z11) {
                m mVar = (m) menuItem;
                mVar.f13385x = (mVar.f13385x & (-5)) | 4;
            } else if (menuItem instanceof r) {
                r rVar = (r) menuItem;
                Object obj2 = rVar.f13336a;
                try {
                    if (rVar.f13393d == null) {
                        rVar.f13393d = ((h3.b) obj2).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    rVar.f13393d.invoke(obj2, Boolean.TRUE);
                } catch (Exception e11) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e11);
                }
            }
        }
        String str2 = this.f12252v;
        if (str2 != null) {
            menuItem.setActionView((View) a(str2, j.f12256e, jVar.f12258a));
            z10 = true;
        }
        int i3 = this.f12251u;
        if (i3 > 0) {
            if (z10) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i3);
            }
        }
        n3.d dVar = this.f12254x;
        if (dVar != null) {
            if (menuItem instanceof h3.b) {
                ((h3.b) menuItem).b(dVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
    }
}
