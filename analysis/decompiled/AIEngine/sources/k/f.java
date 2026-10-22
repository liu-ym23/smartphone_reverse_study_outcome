package k;

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
import androidx.appcompat.widget.f0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class<?>[] f9790e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class<?>[] f9791f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f9792a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f9793b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f9794c;

    /* renamed from: d, reason: collision with root package name */
    public Object f9795d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        public static final Class<?>[] f9796c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        public Object f9797a;

        /* renamed from: b, reason: collision with root package name */
        public Method f9798b;

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Object obj = this.f9797a;
            Method method = this.f9798b;
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
        public CharSequence A;
        public CharSequence B;

        /* renamed from: a, reason: collision with root package name */
        public final Menu f9799a;
        public boolean h;

        /* renamed from: i, reason: collision with root package name */
        public int f9806i;

        /* renamed from: j, reason: collision with root package name */
        public int f9807j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f9808k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f9809l;

        /* renamed from: m, reason: collision with root package name */
        public int f9810m;

        /* renamed from: n, reason: collision with root package name */
        public char f9811n;

        /* renamed from: o, reason: collision with root package name */
        public int f9812o;

        /* renamed from: p, reason: collision with root package name */
        public char f9813p;

        /* renamed from: q, reason: collision with root package name */
        public int f9814q;
        public int r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f9815s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f9816t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f9817u;

        /* renamed from: v, reason: collision with root package name */
        public int f9818v;

        /* renamed from: w, reason: collision with root package name */
        public int f9819w;

        /* renamed from: x, reason: collision with root package name */
        public String f9820x;

        /* renamed from: y, reason: collision with root package name */
        public String f9821y;
        public v0.b z;
        public ColorStateList C = null;
        public PorterDuff.Mode D = null;

        /* renamed from: b, reason: collision with root package name */
        public int f9800b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f9801c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f9802d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f9803e = 0;

        /* renamed from: f, reason: collision with root package name */
        public boolean f9804f = true;

        /* renamed from: g, reason: collision with root package name */
        public boolean f9805g = true;

        public b(Menu menu) {
            this.f9799a = menu;
        }

        public final <T> T a(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, f.this.f9794c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e10) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
                return null;
            }
        }

        public final void b(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            f fVar = f.this;
            Context context = fVar.f9794c;
            boolean z = false;
            menuItem.setChecked(this.f9815s).setVisible(this.f9816t).setEnabled(this.f9817u).setCheckable(this.r >= 1).setTitleCondensed(this.f9809l).setIcon(this.f9810m);
            int i10 = this.f9818v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f9821y != null) {
                if (context.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                if (fVar.f9795d == null) {
                    fVar.f9795d = f.findRealOwner(context);
                }
                Object obj = fVar.f9795d;
                String str = this.f9821y;
                a aVar = new a();
                aVar.f9797a = obj;
                Class<?> cls = obj.getClass();
                try {
                    aVar.f9798b = cls.getMethod(str, a.f9796c);
                    menuItem.setOnMenuItemClickListener(aVar);
                } catch (Exception e10) {
                    StringBuilder sbQ = a0.a.q("Couldn't resolve menu item onClick handler ", str, " in class ");
                    sbQ.append(cls.getName());
                    InflateException inflateException = new InflateException(sbQ.toString());
                    inflateException.initCause(e10);
                    throw inflateException;
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.h) {
                    androidx.appcompat.view.menu.h hVar = (androidx.appcompat.view.menu.h) menuItem;
                    hVar.A = (hVar.A & (-5)) | 4;
                } else if (menuItem instanceof l.c) {
                    l.c cVar = (l.c) menuItem;
                    p0.b bVar = cVar.f10170e;
                    try {
                        if (cVar.h == null) {
                            cVar.h = bVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        cVar.h.invoke(bVar, Boolean.TRUE);
                    } catch (Exception e11) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e11);
                    }
                }
            }
            String str2 = this.f9820x;
            if (str2 != null) {
                menuItem.setActionView((View) a(str2, f.f9790e, fVar.f9792a));
                z = true;
            }
            int i11 = this.f9819w;
            if (i11 > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i11);
                }
            }
            v0.b bVar2 = this.z;
            if (bVar2 != null) {
                if (menuItem instanceof p0.b) {
                    ((p0.b) menuItem).a(bVar2);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.A;
            boolean z3 = menuItem instanceof p0.b;
            if (z3) {
                ((p0.b) menuItem).setContentDescription(charSequence);
            } else {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.B;
            if (z3) {
                ((p0.b) menuItem).setTooltipText(charSequence2);
            } else {
                menuItem.setTooltipText(charSequence2);
            }
            char c9 = this.f9811n;
            int i12 = this.f9812o;
            if (z3) {
                ((p0.b) menuItem).setAlphabeticShortcut(c9, i12);
            } else {
                menuItem.setAlphabeticShortcut(c9, i12);
            }
            char c10 = this.f9813p;
            int i13 = this.f9814q;
            if (z3) {
                ((p0.b) menuItem).setNumericShortcut(c10, i13);
            } else {
                menuItem.setNumericShortcut(c10, i13);
            }
            PorterDuff.Mode mode = this.D;
            if (mode != null) {
                if (z3) {
                    ((p0.b) menuItem).setIconTintMode(mode);
                } else {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.C;
            if (colorStateList != null) {
                if (z3) {
                    ((p0.b) menuItem).setIconTintList(colorStateList);
                } else {
                    menuItem.setIconTintList(colorStateList);
                }
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f9790e = clsArr;
        f9791f = clsArr;
    }

    public f(Context context) {
        super(context);
        this.f9794c = context;
        Object[] objArr = {context};
        this.f9792a = objArr;
        this.f9793b = objArr;
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
        boolean z = false;
        try {
            try {
                layout = this.f9794c.getResources().getLayout(i10);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof androidx.appcompat.view.menu.f) {
                    androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) menu;
                    if (!fVar.f491s) {
                        fVar.w();
                        z = true;
                    }
                }
                parseMenu(layout, attributeSetAsAttributeSet, menu);
                if (z) {
                    ((androidx.appcompat.view.menu.f) menu).v();
                }
                layout.close();
            } catch (IOException e10) {
                throw new InflateException("Error inflating menu XML", e10);
            } catch (XmlPullParserException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } catch (Throwable th) {
            if (z) {
                ((androidx.appcompat.view.menu.f) menu).v();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }

    public final void parseMenu(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        int i10;
        XmlPullParser xmlPullParser2;
        ColorStateList colorStateList;
        int resourceId;
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            i10 = 2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z3 = false;
        String str = null;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != i10) {
                if (eventType != 3) {
                    xmlPullParser2 = xmlPullParser;
                    z = z;
                } else {
                    String name2 = xmlPullParser.getName();
                    if (z3 && name2.equals(str)) {
                        xmlPullParser2 = xmlPullParser;
                        z3 = false;
                        str = null;
                    } else {
                        if (name2.equals("group")) {
                            bVar.f9800b = 0;
                            bVar.f9801c = 0;
                            bVar.f9802d = 0;
                            bVar.f9803e = 0;
                            bVar.f9804f = true;
                            bVar.f9805g = true;
                        } else if (name2.equals("item")) {
                            if (!bVar.h) {
                                v0.b bVar2 = bVar.z;
                                if (bVar2 == null || !bVar2.a()) {
                                    bVar.h = true;
                                    bVar.b(bVar.f9799a.add(bVar.f9800b, bVar.f9806i, bVar.f9807j, bVar.f9808k));
                                } else {
                                    bVar.h = true;
                                    bVar.b(bVar.f9799a.addSubMenu(bVar.f9800b, bVar.f9806i, bVar.f9807j, bVar.f9808k).getItem());
                                }
                            }
                        } else if (name2.equals("menu")) {
                            xmlPullParser2 = xmlPullParser;
                            z = true;
                        }
                        xmlPullParser2 = xmlPullParser;
                        z = z;
                    }
                }
                eventType = xmlPullParser2.next();
                i10 = 2;
                z = z;
                z3 = z3;
            } else {
                if (!z3) {
                    String name3 = xmlPullParser.getName();
                    boolean zEquals = name3.equals("group");
                    Context context = this.f9794c;
                    if (zEquals) {
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f8935p);
                        bVar.f9800b = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                        bVar.f9801c = typedArrayObtainStyledAttributes.getInt(3, 0);
                        bVar.f9802d = typedArrayObtainStyledAttributes.getInt(4, 0);
                        bVar.f9803e = typedArrayObtainStyledAttributes.getInt(5, 0);
                        bVar.f9804f = typedArrayObtainStyledAttributes.getBoolean(2, true);
                        bVar.f9805g = typedArrayObtainStyledAttributes.getBoolean(0, true);
                        typedArrayObtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals("item")) {
                            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.a.f8936q);
                            bVar.f9806i = typedArrayObtainStyledAttributes2.getResourceId(2, 0);
                            bVar.f9807j = (typedArrayObtainStyledAttributes2.getInt(5, bVar.f9801c) & (-65536)) | (typedArrayObtainStyledAttributes2.getInt(6, bVar.f9802d) & 65535);
                            bVar.f9808k = typedArrayObtainStyledAttributes2.getText(7);
                            bVar.f9809l = typedArrayObtainStyledAttributes2.getText(8);
                            bVar.f9810m = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
                            String string = typedArrayObtainStyledAttributes2.getString(9);
                            bVar.f9811n = string == null ? (char) 0 : string.charAt(0);
                            bVar.f9812o = typedArrayObtainStyledAttributes2.getInt(16, 4096);
                            String string2 = typedArrayObtainStyledAttributes2.getString(10);
                            bVar.f9813p = string2 == null ? (char) 0 : string2.charAt(0);
                            bVar.f9814q = typedArrayObtainStyledAttributes2.getInt(20, 4096);
                            if (typedArrayObtainStyledAttributes2.hasValue(11)) {
                                bVar.r = typedArrayObtainStyledAttributes2.getBoolean(11, false) ? 1 : 0;
                            } else {
                                bVar.r = bVar.f9803e;
                            }
                            bVar.f9815s = typedArrayObtainStyledAttributes2.getBoolean(3, false);
                            bVar.f9816t = typedArrayObtainStyledAttributes2.getBoolean(4, bVar.f9804f);
                            bVar.f9817u = typedArrayObtainStyledAttributes2.getBoolean(1, bVar.f9805g);
                            bVar.f9818v = typedArrayObtainStyledAttributes2.getInt(21, -1);
                            bVar.f9821y = typedArrayObtainStyledAttributes2.getString(12);
                            bVar.f9819w = typedArrayObtainStyledAttributes2.getResourceId(13, 0);
                            bVar.f9820x = typedArrayObtainStyledAttributes2.getString(15);
                            String string3 = typedArrayObtainStyledAttributes2.getString(14);
                            boolean z10 = string3 != null;
                            if (z10 && bVar.f9819w == 0 && bVar.f9820x == null) {
                                bVar.z = (v0.b) bVar.a(string3, f9791f, this.f9793b);
                            } else {
                                if (z10) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                bVar.z = null;
                            }
                            bVar.A = typedArrayObtainStyledAttributes2.getText(17);
                            bVar.B = typedArrayObtainStyledAttributes2.getText(22);
                            if (typedArrayObtainStyledAttributes2.hasValue(19)) {
                                bVar.D = f0.c(typedArrayObtainStyledAttributes2.getInt(19, -1), bVar.D);
                            } else {
                                bVar.D = null;
                            }
                            if (typedArrayObtainStyledAttributes2.hasValue(18)) {
                                if (!typedArrayObtainStyledAttributes2.hasValue(18) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(18, 0)) == 0 || (colorStateList = androidx.core.content.a.b(resourceId, context)) == null) {
                                    colorStateList = typedArrayObtainStyledAttributes2.getColorStateList(18);
                                }
                                bVar.C = colorStateList;
                            } else {
                                bVar.C = null;
                            }
                            typedArrayObtainStyledAttributes2.recycle();
                            bVar.h = false;
                            xmlPullParser2 = xmlPullParser;
                        } else if (name3.equals("menu")) {
                            bVar.h = true;
                            SubMenu subMenuAddSubMenu = bVar.f9799a.addSubMenu(bVar.f9800b, bVar.f9806i, bVar.f9807j, bVar.f9808k);
                            bVar.b(subMenuAddSubMenu.getItem());
                            xmlPullParser2 = xmlPullParser;
                            parseMenu(xmlPullParser2, attributeSet, subMenuAddSubMenu);
                        } else {
                            xmlPullParser2 = xmlPullParser;
                            str = name3;
                            z3 = true;
                        }
                        eventType = xmlPullParser2.next();
                        i10 = 2;
                        z = z;
                        z3 = z3;
                    }
                }
                xmlPullParser2 = xmlPullParser;
                z = z;
            }
            eventType = xmlPullParser2.next();
            i10 = 2;
            z = z;
            z3 = z3;
        }
    }
}
