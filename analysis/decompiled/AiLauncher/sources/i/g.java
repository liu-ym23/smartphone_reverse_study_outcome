package i;

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
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.B;
import androidx.appcompat.widget.U;
import androidx.core.view.AbstractC1314b;
import androidx.core.view.C1329q;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import j.MenuItemC4738c;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import v0.InterfaceMenuC5650a;

/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class<?>[] f33009e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class<?>[] f33010f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f33011a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f33012b;

    /* renamed from: c, reason: collision with root package name */
    public Context f33013c;

    /* renamed from: d, reason: collision with root package name */
    public Object f33014d;

    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        public static final Class<?>[] f33015c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        public Object f33016a;

        /* renamed from: b, reason: collision with root package name */
        public Method f33017b;

        public a(Object obj, String str) {
            this.f33016a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f33017b = cls.getMethod(str, f33015c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.f33017b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f33017b.invoke(this.f33016a, menuItem)).booleanValue();
                }
                this.f33017b.invoke(this.f33016a, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public class b {

        /* renamed from: A, reason: collision with root package name */
        public AbstractC1314b f33018A;

        /* renamed from: B, reason: collision with root package name */
        public CharSequence f33019B;

        /* renamed from: C, reason: collision with root package name */
        public CharSequence f33020C;

        /* renamed from: D, reason: collision with root package name */
        public ColorStateList f33021D = null;

        /* renamed from: E, reason: collision with root package name */
        public PorterDuff.Mode f33022E = null;

        /* renamed from: a, reason: collision with root package name */
        public Menu f33024a;

        /* renamed from: b, reason: collision with root package name */
        public int f33025b;

        /* renamed from: c, reason: collision with root package name */
        public int f33026c;

        /* renamed from: d, reason: collision with root package name */
        public int f33027d;

        /* renamed from: e, reason: collision with root package name */
        public int f33028e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f33029f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f33030g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f33031h;

        /* renamed from: i, reason: collision with root package name */
        public int f33032i;

        /* renamed from: j, reason: collision with root package name */
        public int f33033j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f33034k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f33035l;

        /* renamed from: m, reason: collision with root package name */
        public int f33036m;

        /* renamed from: n, reason: collision with root package name */
        public char f33037n;

        /* renamed from: o, reason: collision with root package name */
        public int f33038o;

        /* renamed from: p, reason: collision with root package name */
        public char f33039p;

        /* renamed from: q, reason: collision with root package name */
        public int f33040q;

        /* renamed from: r, reason: collision with root package name */
        public int f33041r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f33042s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f33043t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f33044u;

        /* renamed from: v, reason: collision with root package name */
        public int f33045v;

        /* renamed from: w, reason: collision with root package name */
        public int f33046w;

        /* renamed from: x, reason: collision with root package name */
        public String f33047x;

        /* renamed from: y, reason: collision with root package name */
        public String f33048y;

        /* renamed from: z, reason: collision with root package name */
        public String f33049z;

        public b(Menu menu) {
            this.f33024a = menu;
            h();
        }

        public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f33031h = true;
            i(this.f33024a.add(this.f33025b, this.f33032i, this.f33033j, this.f33034k));
        }

        public SubMenu b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f33031h = true;
            SubMenu subMenuAddSubMenu = this.f33024a.addSubMenu(this.f33025b, this.f33032i, this.f33033j, this.f33034k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public final char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        public boolean d() {
            return this.f33031h;
        }

        public final <T> T e(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f33013c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e10) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f33013c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.f33025b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f33026c = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f33027d = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f33028e = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f33029f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f33030g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            U u10 = U.u(g.this.f33013c, attributeSet, R$styleable.MenuItem);
            this.f33032i = u10.n(R$styleable.MenuItem_android_id, 0);
            this.f33033j = (u10.k(R$styleable.MenuItem_android_menuCategory, this.f33026c) & (-65536)) | (u10.k(R$styleable.MenuItem_android_orderInCategory, this.f33027d) & 65535);
            this.f33034k = u10.p(R$styleable.MenuItem_android_title);
            this.f33035l = u10.p(R$styleable.MenuItem_android_titleCondensed);
            this.f33036m = u10.n(R$styleable.MenuItem_android_icon, 0);
            this.f33037n = c(u10.o(R$styleable.MenuItem_android_alphabeticShortcut));
            this.f33038o = u10.k(R$styleable.MenuItem_alphabeticModifiers, 4096);
            this.f33039p = c(u10.o(R$styleable.MenuItem_android_numericShortcut));
            this.f33040q = u10.k(R$styleable.MenuItem_numericModifiers, 4096);
            int i10 = R$styleable.MenuItem_android_checkable;
            if (u10.s(i10)) {
                this.f33041r = u10.a(i10, false) ? 1 : 0;
            } else {
                this.f33041r = this.f33028e;
            }
            this.f33042s = u10.a(R$styleable.MenuItem_android_checked, false);
            this.f33043t = u10.a(R$styleable.MenuItem_android_visible, this.f33029f);
            this.f33044u = u10.a(R$styleable.MenuItem_android_enabled, this.f33030g);
            this.f33045v = u10.k(R$styleable.MenuItem_showAsAction, -1);
            this.f33049z = u10.o(R$styleable.MenuItem_android_onClick);
            this.f33046w = u10.n(R$styleable.MenuItem_actionLayout, 0);
            this.f33047x = u10.o(R$styleable.MenuItem_actionViewClass);
            String strO = u10.o(R$styleable.MenuItem_actionProviderClass);
            this.f33048y = strO;
            boolean z10 = strO != null;
            if (z10 && this.f33046w == 0 && this.f33047x == null) {
                this.f33018A = (AbstractC1314b) e(strO, g.f33010f, g.this.f33012b);
            } else {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f33018A = null;
            }
            this.f33019B = u10.p(R$styleable.MenuItem_contentDescription);
            this.f33020C = u10.p(R$styleable.MenuItem_tooltipText);
            int i11 = R$styleable.MenuItem_iconTintMode;
            if (u10.s(i11)) {
                this.f33022E = B.d(u10.k(i11, -1), this.f33022E);
            } else {
                this.f33022E = null;
            }
            int i12 = R$styleable.MenuItem_iconTint;
            if (u10.s(i12)) {
                this.f33021D = u10.c(i12);
            } else {
                this.f33021D = null;
            }
            u10.x();
            this.f33031h = false;
        }

        public void h() {
            this.f33025b = 0;
            this.f33026c = 0;
            this.f33027d = 0;
            this.f33028e = 0;
            this.f33029f = true;
            this.f33030g = true;
        }

        public final void i(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z10 = false;
            menuItem.setChecked(this.f33042s).setVisible(this.f33043t).setEnabled(this.f33044u).setCheckable(this.f33041r >= 1).setTitleCondensed(this.f33035l).setIcon(this.f33036m);
            int i10 = this.f33045v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f33049z != null) {
                if (g.this.f33013c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f33049z));
            }
            if (this.f33041r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof MenuItemC4738c) {
                    ((MenuItemC4738c) menuItem).h(true);
                }
            }
            String str = this.f33047x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f33009e, g.this.f33011a));
                z10 = true;
            }
            int i11 = this.f33046w;
            if (i11 > 0) {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i11);
                }
            }
            AbstractC1314b abstractC1314b = this.f33018A;
            if (abstractC1314b != null) {
                C1329q.d(menuItem, abstractC1314b);
            }
            C1329q.h(menuItem, this.f33019B);
            C1329q.m(menuItem, this.f33020C);
            C1329q.g(menuItem, this.f33037n, this.f33038o);
            C1329q.k(menuItem, this.f33039p, this.f33040q);
            PorterDuff.Mode mode = this.f33022E;
            if (mode != null) {
                C1329q.j(menuItem, mode);
            }
            ColorStateList colorStateList = this.f33021D;
            if (colorStateList != null) {
                C1329q.i(menuItem, colorStateList);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f33009e = clsArr;
        f33010f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f33013c = context;
        Object[] objArr = {context};
        this.f33011a = objArr;
        this.f33012b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.f33014d == null) {
            this.f33014d = a(this.f33013c);
        }
        return this.f33014d;
    }

    public final void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals(ChatTracker.TOPBAR_MENU)) {
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
        boolean z10 = false;
        boolean z11 = false;
        String str = null;
        while (!z10) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z11 && name2.equals(str)) {
                        z11 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            AbstractC1314b abstractC1314b = bVar.f33018A;
                            if (abstractC1314b == null || !abstractC1314b.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals(ChatTracker.TOPBAR_MENU)) {
                        z10 = true;
                    }
                }
            } else if (!z11) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals(ChatTracker.TOPBAR_MENU)) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z11 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i10, Menu menu) {
        if (!(menu instanceof InterfaceMenuC5650a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z10 = false;
        try {
            try {
                layout = this.f33013c.getResources().getLayout(i10);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof androidx.appcompat.view.menu.e) {
                    androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) menu;
                    if (eVar.H()) {
                        eVar.i0();
                        z10 = true;
                    }
                }
                c(layout, attributeSetAsAttributeSet, menu);
                if (z10) {
                    ((androidx.appcompat.view.menu.e) menu).h0();
                }
                if (layout != null) {
                    layout.close();
                }
            } catch (IOException e10) {
                throw new InflateException("Error inflating menu XML", e10);
            } catch (XmlPullParserException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } catch (Throwable th) {
            if (z10) {
                ((androidx.appcompat.view.menu.e) menu).h0();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
