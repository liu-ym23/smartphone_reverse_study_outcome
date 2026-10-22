package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.widget.I;
import androidx.appcompat.widget.a0;
import androidx.core.view.AbstractC0457b;
import androidx.core.view.C0472q;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import g.j;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import l.MenuItemC0818c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    static final Class<?>[] f7728e;

    /* renamed from: f, reason: collision with root package name */
    static final Class<?>[] f7729f;

    /* renamed from: a, reason: collision with root package name */
    final Object[] f7730a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f7731b;

    /* renamed from: c, reason: collision with root package name */
    Context f7732c;

    /* renamed from: d, reason: collision with root package name */
    private Object f7733d;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        private static final Class<?>[] f7734c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        private Object f7735a;

        /* renamed from: b, reason: collision with root package name */
        private Method f7736b;

        public a(Object obj, String str) {
            this.f7735a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f7736b = cls.getMethod(str, f7734c);
            } catch (Exception e6) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e6);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.f7736b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f7736b.invoke(this.f7735a, menuItem)).booleanValue();
                }
                this.f7736b.invoke(this.f7735a, menuItem);
                return true;
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    private class b {

        /* renamed from: A, reason: collision with root package name */
        AbstractC0457b f7737A;

        /* renamed from: B, reason: collision with root package name */
        private CharSequence f7738B;

        /* renamed from: C, reason: collision with root package name */
        private CharSequence f7739C;

        /* renamed from: D, reason: collision with root package name */
        private ColorStateList f7740D = null;

        /* renamed from: E, reason: collision with root package name */
        private PorterDuff.Mode f7741E = null;

        /* renamed from: a, reason: collision with root package name */
        private Menu f7743a;

        /* renamed from: b, reason: collision with root package name */
        private int f7744b;

        /* renamed from: c, reason: collision with root package name */
        private int f7745c;

        /* renamed from: d, reason: collision with root package name */
        private int f7746d;

        /* renamed from: e, reason: collision with root package name */
        private int f7747e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f7748f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f7749g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f7750h;

        /* renamed from: i, reason: collision with root package name */
        private int f7751i;

        /* renamed from: j, reason: collision with root package name */
        private int f7752j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f7753k;

        /* renamed from: l, reason: collision with root package name */
        private CharSequence f7754l;

        /* renamed from: m, reason: collision with root package name */
        private int f7755m;

        /* renamed from: n, reason: collision with root package name */
        private char f7756n;

        /* renamed from: o, reason: collision with root package name */
        private int f7757o;

        /* renamed from: p, reason: collision with root package name */
        private char f7758p;

        /* renamed from: q, reason: collision with root package name */
        private int f7759q;

        /* renamed from: r, reason: collision with root package name */
        private int f7760r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f7761s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f7762t;

        /* renamed from: u, reason: collision with root package name */
        private boolean f7763u;

        /* renamed from: v, reason: collision with root package name */
        private int f7764v;

        /* renamed from: w, reason: collision with root package name */
        private int f7765w;

        /* renamed from: x, reason: collision with root package name */
        private String f7766x;

        /* renamed from: y, reason: collision with root package name */
        private String f7767y;

        /* renamed from: z, reason: collision with root package name */
        private String f7768z;

        public b(Menu menu) {
            this.f7743a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f7732c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e6) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e6);
                return null;
            }
        }

        private void i(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z5 = false;
            menuItem.setChecked(this.f7761s).setVisible(this.f7762t).setEnabled(this.f7763u).setCheckable(this.f7760r >= 1).setTitleCondensed(this.f7754l).setIcon(this.f7755m);
            int i5 = this.f7764v;
            if (i5 >= 0) {
                menuItem.setShowAsAction(i5);
            }
            if (this.f7768z != null) {
                if (g.this.f7732c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f7768z));
            }
            if (this.f7760r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof MenuItemC0818c) {
                    ((MenuItemC0818c) menuItem).h(true);
                }
            }
            String str = this.f7766x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f7728e, g.this.f7730a));
                z5 = true;
            }
            int i6 = this.f7765w;
            if (i6 > 0) {
                if (z5) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i6);
                }
            }
            AbstractC0457b abstractC0457b = this.f7737A;
            if (abstractC0457b != null) {
                C0472q.d(menuItem, abstractC0457b);
            }
            C0472q.h(menuItem, this.f7738B);
            C0472q.m(menuItem, this.f7739C);
            C0472q.g(menuItem, this.f7756n, this.f7757o);
            C0472q.k(menuItem, this.f7758p, this.f7759q);
            PorterDuff.Mode mode = this.f7741E;
            if (mode != null) {
                C0472q.j(menuItem, mode);
            }
            ColorStateList colorStateList = this.f7740D;
            if (colorStateList != null) {
                C0472q.i(menuItem, colorStateList);
            }
        }

        public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f7750h = true;
            i(this.f7743a.add(this.f7744b, this.f7751i, this.f7752j, this.f7753k));
        }

        public SubMenu b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f7750h = true;
            SubMenu subMenuAddSubMenu = this.f7743a.addSubMenu(this.f7744b, this.f7751i, this.f7752j, this.f7753k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.f7750h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f7732c.obtainStyledAttributes(attributeSet, j.f17166o1);
            this.f7744b = typedArrayObtainStyledAttributes.getResourceId(j.f17176q1, 0);
            this.f7745c = typedArrayObtainStyledAttributes.getInt(j.f17186s1, 0);
            this.f7746d = typedArrayObtainStyledAttributes.getInt(j.f17191t1, 0);
            this.f7747e = typedArrayObtainStyledAttributes.getInt(j.f17196u1, 0);
            this.f7748f = typedArrayObtainStyledAttributes.getBoolean(j.f17181r1, true);
            this.f7749g = typedArrayObtainStyledAttributes.getBoolean(j.f17171p1, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            a0 a0VarU = a0.u(g.this.f7732c, attributeSet, j.f17201v1);
            this.f7751i = a0VarU.n(j.f17216y1, 0);
            this.f7752j = (a0VarU.k(j.f16989B1, this.f7745c) & (-65536)) | (a0VarU.k(j.f16994C1, this.f7746d) & ExifInterface.COLOR_SPACE_UNCALIBRATED);
            this.f7753k = a0VarU.p(j.f16999D1);
            this.f7754l = a0VarU.p(j.f17004E1);
            this.f7755m = a0VarU.n(j.f17206w1, 0);
            this.f7756n = c(a0VarU.o(j.f17009F1));
            this.f7757o = a0VarU.k(j.f17040M1, RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
            this.f7758p = c(a0VarU.o(j.f17014G1));
            this.f7759q = a0VarU.k(j.f17056Q1, RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
            int i5 = j.f17019H1;
            if (a0VarU.s(i5)) {
                this.f7760r = a0VarU.a(i5, false) ? 1 : 0;
            } else {
                this.f7760r = this.f7747e;
            }
            this.f7761s = a0VarU.a(j.f17221z1, false);
            this.f7762t = a0VarU.a(j.f16984A1, this.f7748f);
            this.f7763u = a0VarU.a(j.f17211x1, this.f7749g);
            this.f7764v = a0VarU.k(j.f17060R1, -1);
            this.f7768z = a0VarU.o(j.f17024I1);
            this.f7765w = a0VarU.n(j.f17028J1, 0);
            this.f7766x = a0VarU.o(j.f17036L1);
            String strO = a0VarU.o(j.f17032K1);
            this.f7767y = strO;
            boolean z5 = strO != null;
            if (z5 && this.f7765w == 0 && this.f7766x == null) {
                this.f7737A = (AbstractC0457b) e(strO, g.f7729f, g.this.f7731b);
            } else {
                if (z5) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f7737A = null;
            }
            this.f7738B = a0VarU.p(j.f17044N1);
            this.f7739C = a0VarU.p(j.f17064S1);
            int i6 = j.f17052P1;
            if (a0VarU.s(i6)) {
                this.f7741E = I.d(a0VarU.k(i6, -1), this.f7741E);
            } else {
                this.f7741E = null;
            }
            int i7 = j.f17048O1;
            if (a0VarU.s(i7)) {
                this.f7740D = a0VarU.c(i7);
            } else {
                this.f7740D = null;
            }
            a0VarU.x();
            this.f7750h = false;
        }

        public void h() {
            this.f7744b = 0;
            this.f7745c = 0;
            this.f7746d = 0;
            this.f7747e = 0;
            this.f7748f = true;
            this.f7749g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f7728e = clsArr;
        f7729f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f7732c = context;
        Object[] objArr = {context};
        this.f7730a = objArr;
        this.f7731b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
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
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            AbstractC0457b abstractC0457b = bVar.f7737A;
                            if (abstractC0457b == null || !abstractC0457b.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z5 = true;
                    }
                }
            } else if (!z6) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z6 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    Object b() {
        if (this.f7733d == null) {
            this.f7733d = a(this.f7732c);
        }
        return this.f7733d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i5, Menu menu) {
        if (!(menu instanceof A.a)) {
            super.inflate(i5, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z5 = false;
        try {
            try {
                layout = this.f7732c.getResources().getLayout(i5);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof androidx.appcompat.view.menu.e) {
                    androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) menu;
                    if (eVar.F()) {
                        eVar.e0();
                        z5 = true;
                    }
                }
                c(layout, attributeSetAsAttributeSet, menu);
                if (z5) {
                    ((androidx.appcompat.view.menu.e) menu).d0();
                }
                if (layout != null) {
                    layout.close();
                }
            } catch (IOException e6) {
                throw new InflateException("Error inflating menu XML", e6);
            } catch (XmlPullParserException e7) {
                throw new InflateException("Error inflating menu XML", e7);
            }
        } catch (Throwable th) {
            if (z5) {
                ((androidx.appcompat.view.menu.e) menu).d0();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
