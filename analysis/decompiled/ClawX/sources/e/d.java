package e;

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
import f.j;
import g.n0;
import java.io.IOException;
import k4.z;
import org.bouncycastle.crypto.digests.Blake2xsDigest;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f2279e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f2280f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f2281a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f2282b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f2283c;
    public Object d;

    static {
        Class[] clsArr = {Context.class};
        f2279e = clsArr;
        f2280f = clsArr;
    }

    public d(Context context) {
        super(context);
        this.f2283c = context;
        Object[] objArr = {context};
        this.f2281a = objArr;
        this.f2282b = objArr;
    }

    public static Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        int i8;
        XmlPullParser xmlPullParser2;
        ColorStateList colorStateList;
        int resourceId;
        c cVar = new c(this, menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            i8 = 2;
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
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != i8) {
                if (eventType != 3) {
                    xmlPullParser2 = xmlPullParser;
                    z = z;
                } else {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        xmlPullParser2 = xmlPullParser;
                        z2 = false;
                        str = null;
                    } else {
                        if (name2.equals("group")) {
                            cVar.f2257b = 0;
                            cVar.f2258c = 0;
                            cVar.d = 0;
                            cVar.f2259e = 0;
                            cVar.f2260f = true;
                            cVar.f2261g = true;
                        } else if (name2.equals("item")) {
                            if (!cVar.f2262h) {
                                cVar.f2262h = true;
                                cVar.b(cVar.f2256a.add(cVar.f2257b, cVar.f2263i, cVar.f2264j, cVar.f2265k));
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
                i8 = 2;
                z = z;
                z2 = z2;
            } else {
                if (!z2) {
                    String name3 = xmlPullParser.getName();
                    boolean zEquals = name3.equals("group");
                    Context context = this.f2283c;
                    if (zEquals) {
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.f1025m);
                        cVar.f2257b = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                        cVar.f2258c = typedArrayObtainStyledAttributes.getInt(3, 0);
                        cVar.d = typedArrayObtainStyledAttributes.getInt(4, 0);
                        cVar.f2259e = typedArrayObtainStyledAttributes.getInt(5, 0);
                        cVar.f2260f = typedArrayObtainStyledAttributes.getBoolean(2, true);
                        cVar.f2261g = typedArrayObtainStyledAttributes.getBoolean(0, true);
                        typedArrayObtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals("item")) {
                            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, c.a.f1026n);
                            cVar.f2263i = typedArrayObtainStyledAttributes2.getResourceId(2, 0);
                            cVar.f2264j = (typedArrayObtainStyledAttributes2.getInt(5, cVar.f2258c) & (-65536)) | (typedArrayObtainStyledAttributes2.getInt(6, cVar.d) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
                            cVar.f2265k = typedArrayObtainStyledAttributes2.getText(7);
                            cVar.f2266l = typedArrayObtainStyledAttributes2.getText(8);
                            cVar.f2267m = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
                            String string = typedArrayObtainStyledAttributes2.getString(9);
                            cVar.f2268n = string == null ? (char) 0 : string.charAt(0);
                            cVar.f2269o = typedArrayObtainStyledAttributes2.getInt(16, 4096);
                            String string2 = typedArrayObtainStyledAttributes2.getString(10);
                            cVar.f2270p = string2 == null ? (char) 0 : string2.charAt(0);
                            cVar.f2271q = typedArrayObtainStyledAttributes2.getInt(20, 4096);
                            if (typedArrayObtainStyledAttributes2.hasValue(11)) {
                                cVar.f2272r = typedArrayObtainStyledAttributes2.getBoolean(11, false) ? 1 : 0;
                            } else {
                                cVar.f2272r = cVar.f2259e;
                            }
                            cVar.f2273s = typedArrayObtainStyledAttributes2.getBoolean(3, false);
                            cVar.f2274t = typedArrayObtainStyledAttributes2.getBoolean(4, cVar.f2260f);
                            cVar.f2275u = typedArrayObtainStyledAttributes2.getBoolean(1, cVar.f2261g);
                            cVar.f2276v = typedArrayObtainStyledAttributes2.getInt(21, -1);
                            cVar.y = typedArrayObtainStyledAttributes2.getString(12);
                            cVar.f2277w = typedArrayObtainStyledAttributes2.getResourceId(13, 0);
                            cVar.f2278x = typedArrayObtainStyledAttributes2.getString(15);
                            String string3 = typedArrayObtainStyledAttributes2.getString(14);
                            boolean z8 = string3 != null;
                            if (z8 && cVar.f2277w == 0 && cVar.f2278x == null) {
                                if (cVar.a(string3, f2280f, this.f2282b) != null) {
                                    throw new ClassCastException();
                                }
                            } else if (z8) {
                                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            cVar.z = typedArrayObtainStyledAttributes2.getText(17);
                            cVar.A = typedArrayObtainStyledAttributes2.getText(22);
                            if (typedArrayObtainStyledAttributes2.hasValue(19)) {
                                cVar.C = n0.a(typedArrayObtainStyledAttributes2.getInt(19, -1), cVar.C);
                            } else {
                                cVar.C = null;
                            }
                            if (typedArrayObtainStyledAttributes2.hasValue(18)) {
                                if (!typedArrayObtainStyledAttributes2.hasValue(18) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(18, 0)) == 0 || (colorStateList = z.t(context, resourceId)) == null) {
                                    colorStateList = typedArrayObtainStyledAttributes2.getColorStateList(18);
                                }
                                cVar.B = colorStateList;
                            } else {
                                cVar.B = null;
                            }
                            typedArrayObtainStyledAttributes2.recycle();
                            cVar.f2262h = false;
                            xmlPullParser2 = xmlPullParser;
                        } else if (name3.equals("menu")) {
                            cVar.f2262h = true;
                            SubMenu subMenuAddSubMenu = cVar.f2256a.addSubMenu(cVar.f2257b, cVar.f2263i, cVar.f2264j, cVar.f2265k);
                            cVar.b(subMenuAddSubMenu.getItem());
                            xmlPullParser2 = xmlPullParser;
                            b(xmlPullParser2, attributeSet, subMenuAddSubMenu);
                        } else {
                            xmlPullParser2 = xmlPullParser;
                            str = name3;
                            z2 = true;
                        }
                        eventType = xmlPullParser2.next();
                        i8 = 2;
                        z = z;
                        z2 = z2;
                    }
                }
                xmlPullParser2 = xmlPullParser;
                z = z;
            }
            eventType = xmlPullParser2.next();
            i8 = 2;
            z = z;
            z2 = z2;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i8, Menu menu) {
        if (!(menu instanceof j)) {
            super.inflate(i8, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z = false;
        try {
            try {
                layout = this.f2283c.getResources().getLayout(i8);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof j) {
                    j jVar = (j) menu;
                    if (!jVar.f2465m) {
                        jVar.s();
                        z = true;
                    }
                }
                b(layout, attributeSetAsAttributeSet, menu);
                if (z) {
                    ((j) menu).r();
                }
                layout.close();
            } catch (IOException e9) {
                throw new InflateException("Error inflating menu XML", e9);
            } catch (XmlPullParserException e10) {
                throw new InflateException("Error inflating menu XML", e10);
            }
        } catch (Throwable th) {
            if (z) {
                ((j) menu).r();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
