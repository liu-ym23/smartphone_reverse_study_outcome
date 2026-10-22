package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap f1857b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f1858a;

    static {
        HashMap r10 = new HashMap();
        f1857b = r10;
        r10.put("KeyAttribute", d.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        f1857b.put("KeyPosition", g.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        f1857b.put("KeyCycle", e.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        f1857b.put("KeyTimeCycle", i.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        f1857b.put("KeyTrigger", j.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        Log.e("KeyFrames", "unable to load", e);
    }

    public f() {
        this.f1858a = new HashMap();
    }

    public void a(l r10) {
        ArrayList r11 = (ArrayList) this.f1858a.get(-1);
        if (r11 == null) goto L6;
        r10.b(r11);
        return;
    }

    public void b(l r10) {
        ArrayList r11 = (ArrayList) this.f1858a.get(Integer.valueOf(r10.f1902c));
        if (r11 == null) goto L5;
        r10.b(r11);
    L5:
        ArrayList r12 = (ArrayList) this.f1858a.get(-1);
        if (r12 == null) goto L13;
        Iterator r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L19;
        c r14 = (c) r13.next();
        if (r14.f(((ConstraintLayout.LayoutParams) r10.f1901b.getLayoutParams()).f2192c0) == false) goto L9;
        r10.a(r14);
        goto L9
    L19:
        return;
    }

    public void c(c r10) {
        if (this.f1858a.containsKey(Integer.valueOf(r10.f1835b)) == true) goto L5;
        this.f1858a.put(Integer.valueOf(r10.f1835b), new ArrayList());
    L5:
        ArrayList r11 = (ArrayList) this.f1858a.get(Integer.valueOf(r10.f1835b));
        if (r11 == null) goto L9;
        r11.add(r10);
        return;
    }

    public ArrayList d(int r10) {
        return (ArrayList) this.f1858a.get(Integer.valueOf(r10));
    }

    public f(Context r10, XmlPullParser r11) {
        this.f1858a = new HashMap();
        int r12 = r11.getEventType();     // Catch: IOException -> L14 XmlPullParserException -> L16
        c r13 = null;
    L5:
        if (r12 == 1) goto L70;
        if (r12 != 2) goto L9;
        String r14 = r11.getName();     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (f1857b.containsKey(r14) == false) goto L33;
        Constructor r15 = (Constructor) f1857b.get(r14);     // Catch: Exception -> L27
        if (r15 == null) goto L30;
        c r16 = (c) r15.newInstance(null);     // Catch: Exception -> L27
        r16.e(r10, Xml.asAttributeSet(r11));     // Catch: Exception -> L25
        c(r16);     // Catch: Exception -> L25
    L24:
        r13 = r16;
    L44:
        r12 = r11.next();     // Catch: IOException -> L14 XmlPullParserException -> L16
    L25:
        Exception e10 = e;
    L31:
        Log.e("KeyFrames", "unable to create ", e10);     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L24
    L30:
        throw new NullPointerException("Keymaker for " + r14 + " not found");     // Catch: Exception -> L27
    L27:
        e = move-exception;
        c r17 = r13;
        e10 = e;
        r16 = r17;
        goto L31
    L33:
        if (r14.equalsIgnoreCase("CustomAttribute") == false) goto L39;
        if (r13 == null) goto L44;
        HashMap r18 = r13.f1838e;     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (r18 == null) goto L44;
        ConstraintAttribute.h(r10, r11, r18);     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L44
    L39:
        if (r14.equalsIgnoreCase("CustomMethod") == false) goto L44;
        if (r13 == null) goto L44;
        HashMap r19 = r13.f1838e;     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (r19 == null) goto L44;
        ConstraintAttribute.h(r10, r11, r19);     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L44
    L9:
        if (r12 != 3) goto L44;
        if ("KeyFrameSet".equals(r11.getName()) == false) goto L44;
        return;
    L70:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }
}
