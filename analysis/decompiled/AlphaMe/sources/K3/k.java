package K3;

import K.AbstractC0072d;
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
import android.view.SubMenu;
import com.baidu.platform.comapi.map.MapController;
import g.AbstractC0560a;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public final class k extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f1120e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f1121f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f1122a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f1123b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f1124c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1125d;

    static {
        Class[] clsArr = {Context.class};
        f1120e = clsArr;
        f1121f = clsArr;
    }

    public k(Context context) {
        super(context);
        this.f1124c = context;
        Object[] objArr = {context};
        this.f1122a = objArr;
        this.f1123b = objArr;
    }

    public static Object a(Context context) {
        return (!(context instanceof Activity) && (context instanceof ContextWrapper)) ? a(((ContextWrapper) context).getBaseContext()) : context;
    }

    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        int i4;
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
                            jVar.f1096b = 0;
                            jVar.f1097c = 0;
                            jVar.f1098d = 0;
                            jVar.f1099e = 0;
                            jVar.f1100f = true;
                            jVar.f1101g = true;
                        } else if (name2.equals(MapController.ITEM_LAYER_TAG)) {
                            if (!jVar.f1102h) {
                                AbstractC0072d abstractC0072d = jVar.f1118x;
                                if (abstractC0072d == null || !abstractC0072d.a()) {
                                    jVar.f1102h = true;
                                    jVar.b(jVar.f1095a.add(jVar.f1096b, jVar.f1103i, jVar.f1104j, jVar.f1105k));
                                } else {
                                    jVar.f1102h = true;
                                    jVar.b(jVar.f1095a.addSubMenu(jVar.f1096b, jVar.f1103i, jVar.f1104j, jVar.f1105k).getItem());
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
                    k kVar = jVar.f1119y;
                    if (zEquals) {
                        TypedArray typedArrayObtainStyledAttributes = kVar.f1124c.obtainStyledAttributes(attributeSet, AbstractC0560a.f12603p);
                        jVar.f1096b = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                        jVar.f1097c = typedArrayObtainStyledAttributes.getInt(3, 0);
                        jVar.f1098d = typedArrayObtainStyledAttributes.getInt(4, 0);
                        jVar.f1099e = typedArrayObtainStyledAttributes.getInt(5, 0);
                        jVar.f1100f = typedArrayObtainStyledAttributes.getBoolean(2, true);
                        jVar.f1101g = typedArrayObtainStyledAttributes.getBoolean(0, true);
                        typedArrayObtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals(MapController.ITEM_LAYER_TAG)) {
                            TypedArray typedArrayObtainStyledAttributes2 = kVar.f1124c.obtainStyledAttributes(attributeSet, AbstractC0560a.f12604q);
                            jVar.f1103i = typedArrayObtainStyledAttributes2.getResourceId(2, 0);
                            jVar.f1104j = (typedArrayObtainStyledAttributes2.getInt(6, jVar.f1098d) & 65535) | (typedArrayObtainStyledAttributes2.getInt(5, jVar.f1097c) & (-65536));
                            jVar.f1105k = typedArrayObtainStyledAttributes2.getText(7);
                            jVar.f1106l = typedArrayObtainStyledAttributes2.getText(8);
                            jVar.f1107m = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
                            String string = typedArrayObtainStyledAttributes2.getString(9);
                            jVar.f1108n = string == null ? (char) 0 : string.charAt(0);
                            String string2 = typedArrayObtainStyledAttributes2.getString(10);
                            jVar.f1109o = string2 == null ? (char) 0 : string2.charAt(0);
                            if (typedArrayObtainStyledAttributes2.hasValue(11)) {
                                jVar.f1110p = typedArrayObtainStyledAttributes2.getBoolean(11, false) ? 1 : 0;
                            } else {
                                jVar.f1110p = jVar.f1099e;
                            }
                            jVar.f1111q = typedArrayObtainStyledAttributes2.getBoolean(3, false);
                            jVar.f1112r = typedArrayObtainStyledAttributes2.getBoolean(4, jVar.f1100f);
                            jVar.f1113s = typedArrayObtainStyledAttributes2.getBoolean(1, jVar.f1101g);
                            jVar.f1114t = typedArrayObtainStyledAttributes2.getInt(21, -1);
                            jVar.f1117w = typedArrayObtainStyledAttributes2.getString(12);
                            jVar.f1115u = typedArrayObtainStyledAttributes2.getResourceId(13, 0);
                            jVar.f1116v = typedArrayObtainStyledAttributes2.getString(15);
                            String string3 = typedArrayObtainStyledAttributes2.getString(14);
                            boolean z6 = string3 != null;
                            if (z6 && jVar.f1115u == 0 && jVar.f1116v == null) {
                                jVar.f1118x = (AbstractC0072d) jVar.a(string3, f1121f, kVar.f1123b);
                            } else {
                                if (z6) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                jVar.f1118x = null;
                            }
                            typedArrayObtainStyledAttributes2.recycle();
                            jVar.f1102h = false;
                        } else if (name3.equals("menu")) {
                            jVar.f1102h = true;
                            SubMenu subMenuAddSubMenu = jVar.f1095a.addSubMenu(jVar.f1096b, jVar.f1103i, jVar.f1104j, jVar.f1105k);
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
        try {
            try {
                try {
                    layout = this.f1124c.getResources().getLayout(i4);
                    b(layout, Xml.asAttributeSet(layout), menu);
                    layout.close();
                } catch (IOException e4) {
                    throw new InflateException("Error inflating menu XML", e4);
                }
            } catch (XmlPullParserException e5) {
                throw new InflateException("Error inflating menu XML", e5);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
