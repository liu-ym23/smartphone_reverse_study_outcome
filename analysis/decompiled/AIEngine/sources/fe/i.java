package fe;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class<?>[] f8888e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class<?>[] f8889f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f8890a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f8891b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f8892c;

    /* renamed from: d, reason: collision with root package name */
    public Object f8893d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        public static final Class<?>[] f8894c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        public Object f8895a;

        /* renamed from: b, reason: collision with root package name */
        public Method f8896b;

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Object obj = this.f8895a;
            Method method = this.f8896b;
            try {
                if (method.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
                }
                method.invoke(obj, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public final Menu f8897a;

        /* renamed from: b, reason: collision with root package name */
        public int f8898b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f8899c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f8900d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f8901e = 0;

        /* renamed from: f, reason: collision with root package name */
        public boolean f8902f = true;

        /* renamed from: g, reason: collision with root package name */
        public boolean f8903g = true;
        public boolean h;

        /* renamed from: i, reason: collision with root package name */
        public int f8904i;

        /* renamed from: j, reason: collision with root package name */
        public int f8905j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f8906k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f8907l;

        /* renamed from: m, reason: collision with root package name */
        public int f8908m;

        /* renamed from: n, reason: collision with root package name */
        public char f8909n;

        /* renamed from: o, reason: collision with root package name */
        public char f8910o;

        /* renamed from: p, reason: collision with root package name */
        public int f8911p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f8912q;
        public boolean r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f8913s;

        /* renamed from: t, reason: collision with root package name */
        public int f8914t;

        /* renamed from: u, reason: collision with root package name */
        public int f8915u;

        /* renamed from: v, reason: collision with root package name */
        public String f8916v;

        /* renamed from: w, reason: collision with root package name */
        public String f8917w;

        /* renamed from: x, reason: collision with root package name */
        public v0.b f8918x;

        public b(Menu menu) {
            this.f8897a = menu;
        }

        public final <T> T a(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = i.this.f8892c.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e10) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
                return null;
            }
        }

        public final void b(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            i iVar = i.this;
            Context context = iVar.f8892c;
            boolean z = false;
            menuItem.setChecked(this.f8912q).setVisible(this.r).setEnabled(this.f8913s).setCheckable(this.f8911p >= 1).setTitleCondensed(this.f8907l).setIcon(this.f8908m).setAlphabeticShortcut(this.f8909n).setNumericShortcut(this.f8910o);
            int i10 = this.f8914t;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f8917w != null) {
                if (context.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                if (iVar.f8893d == null) {
                    iVar.f8893d = i.findRealOwner(context);
                }
                Object obj = iVar.f8893d;
                String str = this.f8917w;
                a aVar = new a();
                aVar.f8895a = obj;
                Class<?> cls = obj.getClass();
                try {
                    aVar.f8896b = cls.getMethod(str, a.f8894c);
                    menuItem.setOnMenuItemClickListener(aVar);
                } catch (Exception e10) {
                    StringBuilder sbQ = a0.a.q("Couldn't resolve menu item onClick handler ", str, " in class ");
                    sbQ.append(cls.getName());
                    throw new InflateException(sbQ.toString(), e10);
                }
            }
            boolean z3 = menuItem instanceof stepos.support.v7.view.menu.e;
            if (z3) {
            }
            if (this.f8911p >= 2) {
                if (z3) {
                    stepos.support.v7.view.menu.e eVar = (stepos.support.v7.view.menu.e) menuItem;
                    eVar.A = (eVar.A & (-5)) | 4;
                } else if (menuItem instanceof ge.h) {
                    ge.h hVar = (ge.h) menuItem;
                    Object obj2 = hVar.f9167a;
                    try {
                        if (hVar.f9168e == null) {
                            hVar.f9168e = ((p0.b) obj2).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        hVar.f9168e.invoke(obj2, Boolean.TRUE);
                    } catch (Exception e11) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e11);
                    }
                }
            }
            String str2 = this.f8916v;
            if (str2 != null) {
                menuItem.setActionView((View) a(str2, i.f8888e, iVar.f8890a));
                z = true;
            }
            int i11 = this.f8915u;
            if (i11 > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i11);
                }
            }
            v0.b bVar = this.f8918x;
            if (bVar != null) {
                if (menuItem instanceof p0.b) {
                    ((p0.b) menuItem).a(bVar);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f8888e = clsArr;
        f8889f = clsArr;
    }

    public i(Context context) {
        super(context);
        this.f8892c = context;
        Object[] objArr = {context};
        this.f8890a = objArr;
        this.f8891b = objArr;
    }

    public static Object findRealOwner(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? findRealOwner(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i10, Menu menu) {
        if (!(menu instanceof p0.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f8892c.getResources().getLayout(i10);
                    parseMenu(layout, Xml.asAttributeSet(layout), menu);
                    layout.close();
                } catch (IOException e10) {
                    throw new InflateException("Error inflating menu XML", e10);
                }
            } catch (XmlPullParserException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void parseMenu(org.xmlpull.v1.XmlPullParser r17, android.util.AttributeSet r18, android.view.Menu r19) throws org.xmlpull.v1.XmlPullParserException, java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.i.parseMenu(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }
}
