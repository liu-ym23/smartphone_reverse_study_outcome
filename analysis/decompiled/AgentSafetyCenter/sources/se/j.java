package se;

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
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class j extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f12256e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f12257f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f12258a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f12259b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f12260c;

    /* renamed from: d, reason: collision with root package name */
    public Object f12261d;

    static {
        Class[] clsArr = {Context.class};
        f12256e = clsArr;
        f12257f = clsArr;
    }

    public j(Context context) {
        super(context);
        this.f12260c = context;
        Object[] objArr = {context};
        this.f12258a = objArr;
        this.f12259b = objArr;
    }

    public static Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        int i;
        int i3;
        XmlPullParser xmlPullParser2;
        boolean z10;
        i iVar = new i();
        iVar.f12255y = this;
        iVar.f12232a = menu;
        iVar.f12233b = 0;
        iVar.f12234c = 0;
        iVar.f12235d = 0;
        iVar.f12236e = 0;
        iVar.f12237f = true;
        iVar.f12238g = true;
        VarHandle.storeStoreFence();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            i = 2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    od.f.o("Expecting menu, got ".concat(name));
                    return;
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z11 = false;
        boolean z12 = false;
        String str = null;
        while (!z11) {
            if (eventType == 1) {
                od.f.o("Unexpected end of document");
                return;
            }
            if (eventType != i) {
                if (eventType != 3) {
                    xmlPullParser2 = xmlPullParser;
                    z10 = z11;
                } else {
                    String name2 = xmlPullParser.getName();
                    if (z12 && name2.equals(str)) {
                        xmlPullParser2 = xmlPullParser;
                        z12 = false;
                        i3 = i;
                        str = null;
                    } else {
                        if (name2.equals("group")) {
                            iVar.f12233b = 0;
                            iVar.f12234c = 0;
                            iVar.f12235d = 0;
                            iVar.f12236e = 0;
                            iVar.f12237f = true;
                            iVar.f12238g = true;
                        } else if (name2.equals("item")) {
                            if (!iVar.f12239h) {
                                n3.d dVar = iVar.f12254x;
                                if (dVar == null || !dVar.a()) {
                                    iVar.f12239h = true;
                                    iVar.b(iVar.f12232a.add(iVar.f12233b, iVar.i, iVar.f12240j, iVar.f12241k));
                                } else {
                                    iVar.f12239h = true;
                                    iVar.b(iVar.f12232a.addSubMenu(iVar.f12233b, iVar.i, iVar.f12240j, iVar.f12241k).getItem());
                                }
                            }
                        } else if (name2.equals("menu")) {
                            xmlPullParser2 = xmlPullParser;
                            z10 = true;
                        }
                        xmlPullParser2 = xmlPullParser;
                        z10 = z11;
                    }
                }
                eventType = xmlPullParser2.next();
                i = i3;
                z11 = z11;
                z12 = z12;
            } else {
                if (!z12) {
                    String name3 = xmlPullParser.getName();
                    boolean zEquals = name3.equals("group");
                    Context context = this.f12260c;
                    if (zEquals) {
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f4112p);
                        iVar.f12233b = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                        iVar.f12234c = typedArrayObtainStyledAttributes.getInt(3, 0);
                        iVar.f12235d = typedArrayObtainStyledAttributes.getInt(4, 0);
                        iVar.f12236e = typedArrayObtainStyledAttributes.getInt(5, 0);
                        i3 = 2;
                        iVar.f12237f = typedArrayObtainStyledAttributes.getBoolean(2, true);
                        iVar.f12238g = typedArrayObtainStyledAttributes.getBoolean(0, true);
                        typedArrayObtainStyledAttributes.recycle();
                        xmlPullParser2 = xmlPullParser;
                        z11 = z11;
                        eventType = xmlPullParser2.next();
                        i = i3;
                        z11 = z11;
                        z12 = z12;
                    } else {
                        i3 = 2;
                        if (name3.equals("item")) {
                            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.a.f4113q);
                            iVar.i = typedArrayObtainStyledAttributes2.getResourceId(2, 0);
                            iVar.f12240j = (typedArrayObtainStyledAttributes2.getInt(5, iVar.f12234c) & (-65536)) | (typedArrayObtainStyledAttributes2.getInt(6, iVar.f12235d) & ExifInterface.COLOR_SPACE_UNCALIBRATED);
                            iVar.f12241k = typedArrayObtainStyledAttributes2.getText(7);
                            iVar.f12242l = typedArrayObtainStyledAttributes2.getText(8);
                            iVar.f12243m = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
                            String string = typedArrayObtainStyledAttributes2.getString(9);
                            iVar.f12244n = string == null ? (char) 0 : string.charAt(0);
                            String string2 = typedArrayObtainStyledAttributes2.getString(10);
                            iVar.f12245o = string2 == null ? (char) 0 : string2.charAt(0);
                            if (typedArrayObtainStyledAttributes2.hasValue(11)) {
                                iVar.f12246p = typedArrayObtainStyledAttributes2.getBoolean(11, false) ? 1 : 0;
                            } else {
                                iVar.f12246p = iVar.f12236e;
                            }
                            iVar.f12247q = typedArrayObtainStyledAttributes2.getBoolean(3, false);
                            iVar.f12248r = typedArrayObtainStyledAttributes2.getBoolean(4, iVar.f12237f);
                            iVar.f12249s = typedArrayObtainStyledAttributes2.getBoolean(1, iVar.f12238g);
                            iVar.f12250t = typedArrayObtainStyledAttributes2.getInt(21, -1);
                            iVar.f12253w = typedArrayObtainStyledAttributes2.getString(12);
                            iVar.f12251u = typedArrayObtainStyledAttributes2.getResourceId(13, 0);
                            iVar.f12252v = typedArrayObtainStyledAttributes2.getString(15);
                            String string3 = typedArrayObtainStyledAttributes2.getString(14);
                            boolean z13 = string3 != null;
                            if (z13 && iVar.f12251u == 0 && iVar.f12252v == null) {
                                iVar.f12254x = (n3.d) iVar.a(string3, f12257f, this.f12259b);
                            } else {
                                if (z13) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                iVar.f12254x = null;
                            }
                            typedArrayObtainStyledAttributes2.recycle();
                            iVar.f12239h = false;
                            xmlPullParser2 = xmlPullParser;
                        } else if (name3.equals("menu")) {
                            iVar.f12239h = true;
                            SubMenu subMenuAddSubMenu = iVar.f12232a.addSubMenu(iVar.f12233b, iVar.i, iVar.f12240j, iVar.f12241k);
                            iVar.b(subMenuAddSubMenu.getItem());
                            xmlPullParser2 = xmlPullParser;
                            b(xmlPullParser2, attributeSet, subMenuAddSubMenu);
                        } else {
                            xmlPullParser2 = xmlPullParser;
                            z12 = true;
                            str = name3;
                        }
                        eventType = xmlPullParser2.next();
                        i = i3;
                        z11 = z11;
                        z12 = z12;
                    }
                }
                xmlPullParser2 = xmlPullParser;
                z10 = z11;
            }
            i3 = i;
            z11 = z10;
            eventType = xmlPullParser2.next();
            i = i3;
            z11 = z11;
            z12 = z12;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof h3.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f12260c.getResources().getLayout(i);
                    b(layout, Xml.asAttributeSet(layout), menu);
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
}
