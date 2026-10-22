package b5;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.AbstractC0457b;
import androidx.core.view.C0472q;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class k extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    private static final Class<?>[] f11893e;

    /* renamed from: f, reason: collision with root package name */
    private static final Class<?>[] f11894f;

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f11895a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f11896b;

    /* renamed from: c, reason: collision with root package name */
    private Context f11897c;

    /* renamed from: d, reason: collision with root package name */
    private Object f11898d;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        private static final Class<?>[] f11899c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        private Object f11900a;

        /* renamed from: b, reason: collision with root package name */
        private Method f11901b;

        public a(Object obj, String str) {
            this.f11900a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f11901b = cls.getMethod(str, f11899c);
            } catch (Exception e6) {
                throw new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName(), e6);
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.f11901b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f11901b.invoke(this.f11900a, menuItem)).booleanValue();
                }
                this.f11901b.invoke(this.f11900a, menuItem);
                return true;
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    private class b {

        /* renamed from: a, reason: collision with root package name */
        private Menu f11902a;

        /* renamed from: b, reason: collision with root package name */
        private int f11903b;

        /* renamed from: c, reason: collision with root package name */
        private int f11904c;

        /* renamed from: d, reason: collision with root package name */
        private int f11905d;

        /* renamed from: e, reason: collision with root package name */
        private int f11906e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f11907f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f11908g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f11909h;

        /* renamed from: i, reason: collision with root package name */
        private int f11910i;

        /* renamed from: j, reason: collision with root package name */
        private int f11911j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f11912k;

        /* renamed from: l, reason: collision with root package name */
        private CharSequence f11913l;

        /* renamed from: m, reason: collision with root package name */
        private int f11914m;

        /* renamed from: n, reason: collision with root package name */
        private char f11915n;

        /* renamed from: o, reason: collision with root package name */
        private char f11916o;

        /* renamed from: p, reason: collision with root package name */
        private int f11917p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f11918q;

        /* renamed from: r, reason: collision with root package name */
        private boolean f11919r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f11920s;

        /* renamed from: t, reason: collision with root package name */
        private int f11921t;

        /* renamed from: u, reason: collision with root package name */
        private int f11922u;

        /* renamed from: v, reason: collision with root package name */
        private String f11923v;

        /* renamed from: w, reason: collision with root package name */
        private String f11924w;

        /* renamed from: x, reason: collision with root package name */
        private String f11925x;

        /* renamed from: y, reason: collision with root package name */
        private AbstractC0457b f11926y;

        public b(Menu menu) {
            this.f11902a = menu;
            i();
        }

        private char d(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T f(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = k.this.f11897c.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e6) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e6);
                return null;
            }
        }

        private void j(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z5 = false;
            menuItem.setChecked(this.f11918q).setVisible(this.f11919r).setEnabled(this.f11920s).setCheckable(this.f11917p >= 1).setTitleCondensed(this.f11913l).setIcon(this.f11914m).setAlphabeticShortcut(this.f11915n).setNumericShortcut(this.f11916o);
            int i5 = this.f11921t;
            if (i5 >= 0) {
                C0472q.l(menuItem, i5);
            }
            if (this.f11925x != null) {
                if (k.this.f11897c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(k.this.h(), this.f11925x));
            }
            boolean z6 = menuItem instanceof stepos.support.v7.view.menu.f;
            if (z6) {
            }
            if (this.f11917p >= 2) {
                if (z6) {
                    ((stepos.support.v7.view.menu.f) menuItem).x(true);
                } else if (menuItem instanceof c5.g) {
                    ((c5.g) menuItem).i(true);
                }
            }
            String str = this.f11923v;
            if (str != null) {
                C0472q.f(menuItem, (View) f(str, k.f11893e, k.this.f11895a));
                z5 = true;
            }
            int i6 = this.f11922u;
            if (i6 > 0) {
                if (z5) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    C0472q.e(menuItem, i6);
                }
            }
            AbstractC0457b abstractC0457b = this.f11926y;
            if (abstractC0457b != null) {
                C0472q.d(menuItem, abstractC0457b);
            }
        }

        public void b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f11909h = true;
            j(this.f11902a.add(this.f11903b, this.f11910i, this.f11911j, this.f11912k));
        }

        public SubMenu c() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f11909h = true;
            SubMenu subMenuAddSubMenu = this.f11902a.addSubMenu(this.f11903b, this.f11910i, this.f11911j, this.f11912k);
            j(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean e() {
            return this.f11909h;
        }

        public void g(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = k.this.f11897c.obtainStyledAttributes(attributeSet, g.j.f17166o1);
            this.f11903b = typedArrayObtainStyledAttributes.getResourceId(g.j.f17176q1, 0);
            this.f11904c = typedArrayObtainStyledAttributes.getInt(g.j.f17186s1, 0);
            this.f11905d = typedArrayObtainStyledAttributes.getInt(g.j.f17191t1, 0);
            this.f11906e = typedArrayObtainStyledAttributes.getInt(g.j.f17196u1, 0);
            this.f11907f = typedArrayObtainStyledAttributes.getBoolean(g.j.f17181r1, true);
            this.f11908g = typedArrayObtainStyledAttributes.getBoolean(g.j.f17171p1, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void h(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = k.this.f11897c.obtainStyledAttributes(attributeSet, g.j.f17201v1);
            this.f11910i = typedArrayObtainStyledAttributes.getResourceId(g.j.f17216y1, 0);
            this.f11911j = (typedArrayObtainStyledAttributes.getInt(g.j.f16989B1, this.f11904c) & (-65536)) | (typedArrayObtainStyledAttributes.getInt(g.j.f16994C1, this.f11905d) & ExifInterface.COLOR_SPACE_UNCALIBRATED);
            this.f11912k = typedArrayObtainStyledAttributes.getText(g.j.f16999D1);
            this.f11913l = typedArrayObtainStyledAttributes.getText(g.j.f17004E1);
            this.f11914m = typedArrayObtainStyledAttributes.getResourceId(g.j.f17206w1, 0);
            this.f11915n = d(typedArrayObtainStyledAttributes.getString(g.j.f17009F1));
            this.f11916o = d(typedArrayObtainStyledAttributes.getString(g.j.f17014G1));
            int i5 = g.j.f17019H1;
            if (typedArrayObtainStyledAttributes.hasValue(i5)) {
                this.f11917p = typedArrayObtainStyledAttributes.getBoolean(i5, false) ? 1 : 0;
            } else {
                this.f11917p = this.f11906e;
            }
            this.f11918q = typedArrayObtainStyledAttributes.getBoolean(g.j.f17221z1, false);
            this.f11919r = typedArrayObtainStyledAttributes.getBoolean(g.j.f16984A1, this.f11907f);
            this.f11920s = typedArrayObtainStyledAttributes.getBoolean(g.j.f17211x1, this.f11908g);
            this.f11921t = typedArrayObtainStyledAttributes.getInt(g.j.f17060R1, -1);
            this.f11925x = typedArrayObtainStyledAttributes.getString(g.j.f17024I1);
            this.f11922u = typedArrayObtainStyledAttributes.getResourceId(g.j.f17028J1, 0);
            this.f11923v = typedArrayObtainStyledAttributes.getString(g.j.f17036L1);
            String string = typedArrayObtainStyledAttributes.getString(g.j.f17032K1);
            this.f11924w = string;
            boolean z5 = string != null;
            if (z5 && this.f11922u == 0 && this.f11923v == null) {
                this.f11926y = (AbstractC0457b) f(string, k.f11894f, k.this.f11896b);
            } else {
                if (z5) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f11926y = null;
            }
            typedArrayObtainStyledAttributes.recycle();
            this.f11909h = false;
        }

        public void i() {
            this.f11903b = 0;
            this.f11904c = 0;
            this.f11905d = 0;
            this.f11906e = 0;
            this.f11907f = true;
            this.f11908g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f11893e = clsArr;
        f11894f = clsArr;
    }

    public k(Context context) {
        super(context);
        this.f11897c = context;
        Object[] objArr = {context};
        this.f11895a = objArr;
        this.f11896b = objArr;
    }

    private Object g(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? g(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object h() {
        if (this.f11898d == null) {
            this.f11898d = g(this.f11897c);
        }
        return this.f11898d;
    }

    private void i(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z5 = false;
        boolean z6 = false;
        String str = null;
        while (!z5) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z6 && name2.equals(str)) {
                        z6 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        bVar.i();
                    } else if (name2.equals("item")) {
                        if (!bVar.e()) {
                            if (bVar.f11926y == null || !bVar.f11926y.a()) {
                                bVar.b();
                            } else {
                                bVar.c();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z5 = true;
                    }
                }
            } else if (!z6) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.h(attributeSet);
                } else if (name3.equals("menu")) {
                    i(xmlPullParser, attributeSet, bVar.c());
                } else {
                    str = name3;
                    z6 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i5, Menu menu) {
        if (!(menu instanceof A.a)) {
            super.inflate(i5, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f11897c.getResources().getLayout(i5);
                    i(layout, Xml.asAttributeSet(layout), menu);
                } catch (IOException e6) {
                    throw new InflateException("Error inflating menu XML", e6);
                }
            } catch (XmlPullParserException e7) {
                throw new InflateException("Error inflating menu XML", e7);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }
}
