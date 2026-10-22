package Ic;

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
import androidx.appcompat.R$styleable;
import androidx.core.view.AbstractC1314b;
import androidx.core.view.C1329q;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import v0.InterfaceMenuC5650a;

/* loaded from: classes5.dex */
public class k extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class<?>[] f3490e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class<?>[] f3491f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f3492a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f3493b;

    /* renamed from: c, reason: collision with root package name */
    public Context f3494c;

    /* renamed from: d, reason: collision with root package name */
    public Object f3495d;

    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        public static final Class<?>[] f3496c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        public Object f3497a;

        /* renamed from: b, reason: collision with root package name */
        public Method f3498b;

        public a(Object obj, String str) {
            this.f3497a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f3498b = cls.getMethod(str, f3496c);
            } catch (Exception e10) {
                throw new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName(), e10);
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.f3498b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f3498b.invoke(this.f3497a, menuItem)).booleanValue();
                }
                this.f3498b.invoke(this.f3497a, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public Menu f3499a;

        /* renamed from: b, reason: collision with root package name */
        public int f3500b;

        /* renamed from: c, reason: collision with root package name */
        public int f3501c;

        /* renamed from: d, reason: collision with root package name */
        public int f3502d;

        /* renamed from: e, reason: collision with root package name */
        public int f3503e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f3504f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f3505g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f3506h;

        /* renamed from: i, reason: collision with root package name */
        public int f3507i;

        /* renamed from: j, reason: collision with root package name */
        public int f3508j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f3509k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f3510l;

        /* renamed from: m, reason: collision with root package name */
        public int f3511m;

        /* renamed from: n, reason: collision with root package name */
        public char f3512n;

        /* renamed from: o, reason: collision with root package name */
        public char f3513o;

        /* renamed from: p, reason: collision with root package name */
        public int f3514p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f3515q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f3516r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f3517s;

        /* renamed from: t, reason: collision with root package name */
        public int f3518t;

        /* renamed from: u, reason: collision with root package name */
        public int f3519u;

        /* renamed from: v, reason: collision with root package name */
        public String f3520v;

        /* renamed from: w, reason: collision with root package name */
        public String f3521w;

        /* renamed from: x, reason: collision with root package name */
        public String f3522x;

        /* renamed from: y, reason: collision with root package name */
        public AbstractC1314b f3523y;

        public b(Menu menu) {
            this.f3499a = menu;
            i();
        }

        public void b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f3506h = true;
            j(this.f3499a.add(this.f3500b, this.f3507i, this.f3508j, this.f3509k));
        }

        public SubMenu c() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f3506h = true;
            SubMenu subMenuAddSubMenu = this.f3499a.addSubMenu(this.f3500b, this.f3507i, this.f3508j, this.f3509k);
            j(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public final char d(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        public boolean e() {
            return this.f3506h;
        }

        public final <T> T f(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = k.this.f3494c.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e10) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
                return null;
            }
        }

        public void g(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = k.this.f3494c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.f3500b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f3501c = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f3502d = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f3503e = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f3504f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f3505g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void h(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = k.this.f3494c.obtainStyledAttributes(attributeSet, R$styleable.MenuItem);
            this.f3507i = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuItem_android_id, 0);
            this.f3508j = (typedArrayObtainStyledAttributes.getInt(R$styleable.MenuItem_android_menuCategory, this.f3501c) & (-65536)) | (typedArrayObtainStyledAttributes.getInt(R$styleable.MenuItem_android_orderInCategory, this.f3502d) & 65535);
            this.f3509k = typedArrayObtainStyledAttributes.getText(R$styleable.MenuItem_android_title);
            this.f3510l = typedArrayObtainStyledAttributes.getText(R$styleable.MenuItem_android_titleCondensed);
            this.f3511m = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuItem_android_icon, 0);
            this.f3512n = d(typedArrayObtainStyledAttributes.getString(R$styleable.MenuItem_android_alphabeticShortcut));
            this.f3513o = d(typedArrayObtainStyledAttributes.getString(R$styleable.MenuItem_android_numericShortcut));
            int i10 = R$styleable.MenuItem_android_checkable;
            if (typedArrayObtainStyledAttributes.hasValue(i10)) {
                this.f3514p = typedArrayObtainStyledAttributes.getBoolean(i10, false) ? 1 : 0;
            } else {
                this.f3514p = this.f3503e;
            }
            this.f3515q = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_checked, false);
            this.f3516r = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_visible, this.f3504f);
            this.f3517s = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_enabled, this.f3505g);
            this.f3518t = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuItem_showAsAction, -1);
            this.f3522x = typedArrayObtainStyledAttributes.getString(R$styleable.MenuItem_android_onClick);
            this.f3519u = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuItem_actionLayout, 0);
            this.f3520v = typedArrayObtainStyledAttributes.getString(R$styleable.MenuItem_actionViewClass);
            String string = typedArrayObtainStyledAttributes.getString(R$styleable.MenuItem_actionProviderClass);
            this.f3521w = string;
            boolean z10 = string != null;
            if (z10 && this.f3519u == 0 && this.f3520v == null) {
                this.f3523y = (AbstractC1314b) f(string, k.f3491f, k.this.f3493b);
            } else {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f3523y = null;
            }
            typedArrayObtainStyledAttributes.recycle();
            this.f3506h = false;
        }

        public void i() {
            this.f3500b = 0;
            this.f3501c = 0;
            this.f3502d = 0;
            this.f3503e = 0;
            this.f3504f = true;
            this.f3505g = true;
        }

        public final void j(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z10 = false;
            menuItem.setChecked(this.f3515q).setVisible(this.f3516r).setEnabled(this.f3517s).setCheckable(this.f3514p >= 1).setTitleCondensed(this.f3510l).setIcon(this.f3511m).setAlphabeticShortcut(this.f3512n).setNumericShortcut(this.f3513o);
            int i10 = this.f3518t;
            if (i10 >= 0) {
                C1329q.l(menuItem, i10);
            }
            if (this.f3522x != null) {
                if (k.this.f3494c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(k.this.h(), this.f3522x));
            }
            boolean z11 = menuItem instanceof stepos.support.v7.view.menu.e;
            if (z11) {
            }
            if (this.f3514p >= 2) {
                if (z11) {
                    ((stepos.support.v7.view.menu.e) menuItem).x(true);
                } else if (menuItem instanceof Jc.h) {
                    ((Jc.h) menuItem).i(true);
                }
            }
            String str = this.f3520v;
            if (str != null) {
                C1329q.f(menuItem, (View) f(str, k.f3490e, k.this.f3492a));
                z10 = true;
            }
            int i11 = this.f3519u;
            if (i11 > 0) {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    C1329q.e(menuItem, i11);
                }
            }
            AbstractC1314b abstractC1314b = this.f3523y;
            if (abstractC1314b != null) {
                C1329q.d(menuItem, abstractC1314b);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f3490e = clsArr;
        f3491f = clsArr;
    }

    public k(Context context) {
        super(context);
        this.f3494c = context;
        Object[] objArr = {context};
        this.f3492a = objArr;
        this.f3493b = objArr;
    }

    public final Object g(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? g(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public final Object h() {
        if (this.f3495d == null) {
            this.f3495d = g(this.f3494c);
        }
        return this.f3495d;
    }

    public final void i(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
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
                        bVar.i();
                    } else if (name2.equals("item")) {
                        if (!bVar.e()) {
                            if (bVar.f3523y == null || !bVar.f3523y.a()) {
                                bVar.b();
                            } else {
                                bVar.c();
                            }
                        }
                    } else if (name2.equals(ChatTracker.TOPBAR_MENU)) {
                        z10 = true;
                    }
                }
            } else if (!z11) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.h(attributeSet);
                } else if (name3.equals(ChatTracker.TOPBAR_MENU)) {
                    i(xmlPullParser, attributeSet, bVar.c());
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
        try {
            try {
                try {
                    layout = this.f3494c.getResources().getLayout(i10);
                    i(layout, Xml.asAttributeSet(layout), menu);
                } catch (IOException e10) {
                    throw new InflateException("Error inflating menu XML", e10);
                }
            } catch (XmlPullParserException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }
}
