package j;

import K.AbstractC0072d;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import androidx.appcompat.widget.AbstractC0220p0;
import com.baidu.platform.comapi.map.MapController;
import g.AbstractC0560a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import k.C0661o;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class k extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f13100e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f13101f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f13102a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f13103b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f13104c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13105d;

    static {
        Class[] clsArr = {Context.class};
        f13100e = clsArr;
        f13101f = clsArr;
    }

    public k(Context context) {
        super(context);
        this.f13104c = context;
        Object[] objArr = {context};
        this.f13102a = objArr;
        this.f13103b = objArr;
    }

    public static Object a(Context context) {
        return (!(context instanceof Activity) && (context instanceof ContextWrapper)) ? a(((ContextWrapper) context).getBaseContext()) : context;
    }

    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        int i4;
        ColorStateList colorStateList;
        j jVar = new j(this, menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            i4 = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlResourceParser.next();
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z4 = false;
        boolean z5 = false;
        String str = null;
        while (!z4) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != i4) {
                if (eventType != 3) {
                    z4 = z4;
                } else {
                    String name2 = xmlResourceParser.getName();
                    if (z5 && name2.equals(str)) {
                        z5 = false;
                        str = null;
                    } else {
                        if (name2.equals("group")) {
                            jVar.f13075b = 0;
                            jVar.f13076c = 0;
                            jVar.f13077d = 0;
                            jVar.f13078e = 0;
                            jVar.f13079f = true;
                            jVar.f13080g = true;
                        } else if (name2.equals(MapController.ITEM_LAYER_TAG)) {
                            if (!jVar.f13081h) {
                                AbstractC0072d abstractC0072d = jVar.f13099z;
                                if (abstractC0072d == null || !abstractC0072d.a()) {
                                    jVar.f13081h = true;
                                    jVar.b(jVar.f13074a.add(jVar.f13075b, jVar.f13082i, jVar.f13083j, jVar.f13084k));
                                } else {
                                    jVar.f13081h = true;
                                    jVar.b(jVar.f13074a.addSubMenu(jVar.f13075b, jVar.f13082i, jVar.f13083j, jVar.f13084k).getItem());
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z4 = true;
                        }
                        z4 = z4;
                    }
                }
                eventType = xmlResourceParser.next();
                i4 = 2;
                z4 = z4;
                z5 = z5;
            } else {
                if (!z5) {
                    String name3 = xmlResourceParser.getName();
                    boolean zEquals = name3.equals("group");
                    k kVar = jVar.f13073E;
                    if (zEquals) {
                        TypedArray typedArrayObtainStyledAttributes = kVar.f13104c.obtainStyledAttributes(attributeSet, AbstractC0560a.f12603p);
                        jVar.f13075b = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                        jVar.f13076c = typedArrayObtainStyledAttributes.getInt(3, 0);
                        jVar.f13077d = typedArrayObtainStyledAttributes.getInt(4, 0);
                        jVar.f13078e = typedArrayObtainStyledAttributes.getInt(5, 0);
                        jVar.f13079f = typedArrayObtainStyledAttributes.getBoolean(2, true);
                        jVar.f13080g = typedArrayObtainStyledAttributes.getBoolean(0, true);
                        typedArrayObtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals(MapController.ITEM_LAYER_TAG)) {
                            Context context = kVar.f13104c;
                            android.support.v4.media.session.c cVar = new android.support.v4.media.session.c(context, context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12604q));
                            jVar.f13082i = cVar.r(2, 0);
                            jVar.f13083j = (cVar.p(5, jVar.f13076c) & (-65536)) | (cVar.p(6, jVar.f13077d) & 65535);
                            jVar.f13084k = cVar.u(7);
                            jVar.f13085l = cVar.u(8);
                            jVar.f13086m = cVar.r(0, 0);
                            String strS = cVar.s(9);
                            jVar.f13087n = strS == null ? (char) 0 : strS.charAt(0);
                            jVar.f13088o = cVar.p(16, 4096);
                            String strS2 = cVar.s(10);
                            jVar.f13089p = strS2 == null ? (char) 0 : strS2.charAt(0);
                            jVar.f13090q = cVar.p(20, 4096);
                            if (cVar.v(11)) {
                                jVar.f13091r = cVar.g(11, false) ? 1 : 0;
                            } else {
                                jVar.f13091r = jVar.f13078e;
                            }
                            jVar.f13092s = cVar.g(3, false);
                            jVar.f13093t = cVar.g(4, jVar.f13079f);
                            jVar.f13094u = cVar.g(1, jVar.f13080g);
                            jVar.f13095v = cVar.p(21, -1);
                            jVar.f13098y = cVar.s(12);
                            jVar.f13096w = cVar.r(13, 0);
                            jVar.f13097x = cVar.s(15);
                            String strS3 = cVar.s(14);
                            boolean z6 = strS3 != null;
                            if (z6 && jVar.f13096w == 0 && jVar.f13097x == null) {
                                jVar.f13099z = (AbstractC0072d) jVar.a(strS3, f13101f, kVar.f13103b);
                            } else {
                                if (z6) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                jVar.f13099z = null;
                            }
                            jVar.f13069A = cVar.u(17);
                            jVar.f13070B = cVar.u(22);
                            if (cVar.v(19)) {
                                jVar.f13072D = AbstractC0220p0.b(cVar.p(19, -1), jVar.f13072D);
                                colorStateList = null;
                            } else {
                                colorStateList = null;
                                jVar.f13072D = null;
                            }
                            if (cVar.v(18)) {
                                jVar.f13071C = cVar.h(18);
                            } else {
                                jVar.f13071C = colorStateList;
                            }
                            cVar.A();
                            jVar.f13081h = false;
                        } else if (name3.equals("menu")) {
                            jVar.f13081h = true;
                            SubMenu subMenuAddSubMenu = jVar.f13074a.addSubMenu(jVar.f13075b, jVar.f13082i, jVar.f13083j, jVar.f13084k);
                            jVar.b(subMenuAddSubMenu.getItem());
                            b(xmlResourceParser, attributeSet, subMenuAddSubMenu);
                        } else {
                            str = name3;
                            z5 = true;
                        }
                        eventType = xmlResourceParser.next();
                        i4 = 2;
                        z4 = z4;
                        z5 = z5;
                    }
                }
                z4 = z4;
            }
            eventType = xmlResourceParser.next();
            i4 = 2;
            z4 = z4;
            z5 = z5;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i4, Menu menu) {
        if (!(menu instanceof F.a)) {
            super.inflate(i4, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z4 = false;
        try {
            try {
                layout = this.f13104c.getResources().getLayout(i4);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof C0661o) {
                    C0661o c0661o = (C0661o) menu;
                    if (!c0661o.f13253p) {
                        c0661o.w();
                        z4 = true;
                    }
                }
                b(layout, attributeSetAsAttributeSet, menu);
                if (z4) {
                    ((C0661o) menu).v();
                }
                layout.close();
            } catch (IOException e4) {
                throw new InflateException("Error inflating menu XML", e4);
            } catch (XmlPullParserException e5) {
                throw new InflateException("Error inflating menu XML", e5);
            }
        } catch (Throwable th) {
            if (z4) {
                ((C0661o) menu).v();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
