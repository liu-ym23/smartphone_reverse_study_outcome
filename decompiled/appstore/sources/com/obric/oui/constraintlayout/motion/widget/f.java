package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap f13689b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f13690a;

    static {
        HashMap r10 = new HashMap();
        f13689b = r10;
        r10.put("KeyAttribute", d.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        f13689b.put("KeyPosition", g.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        f13689b.put("KeyCycle", e.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        f13689b.put("KeyTimeCycle", i.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        f13689b.put("KeyTrigger", j.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        Log.e("KeyFrames", "unable to load", e);
    }

    public f() {
        this.f13690a = new HashMap();
    }

    public void a(l r10) {
        ArrayList r11 = (ArrayList) this.f13690a.get(-1);
        if (r11 == null) goto L6;
        r10.b(r11);
        return;
    }

    public void b(l r10) {
        ArrayList r11 = (ArrayList) this.f13690a.get(Integer.valueOf(r10.f13774c));
        if (r11 == null) goto L5;
        r10.b(r11);
    L5:
        ArrayList r12 = (ArrayList) this.f13690a.get(-1);
        if (r12 == null) goto L13;
        Iterator r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L19;
        c r14 = (c) r13.next();
        if (r14.f(((ConstraintLayout.LayoutParams) r10.f13773b.getLayoutParams()).f14091c0) == false) goto L9;
        r10.a(r14);
        goto L9
    L19:
        return;
    }

    public void c(c r10) {
        if (this.f13690a.containsKey(Integer.valueOf(r10.f13646b)) == true) goto L5;
        this.f13690a.put(Integer.valueOf(r10.f13646b), new ArrayList());
    L5:
        ArrayList r11 = (ArrayList) this.f13690a.get(Integer.valueOf(r10.f13646b));
        if (r11 == null) goto L9;
        r11.add(r10);
        return;
    }

    public ArrayList d(int r10) {
        return (ArrayList) this.f13690a.get(Integer.valueOf(r10));
    }

    public f(Context r10, XmlPullParser r11) {
        this.f13690a = new HashMap();
        int r12 = r11.getEventType();     // Catch: IOException -> L13 XmlPullParserException -> L15
        c r13 = null;
    L5:
        if (r12 == 1) goto L84;
        if (r12 == 2) goto L17;
        if (r12 == 3) goto L11;
    L63:
        r12 = r11.next();     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L5
    L11:
        if ("KeyFrameSet".equals(r11.getName()) == false) goto L63;
        return;
    L17:
        String r14 = r11.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (f13689b.containsKey(r14) == false) goto L52;
        switch(r14.hashCode()) {
            case -300573030: goto L35;
            case -298435811: goto L32;
            case 540053991: goto L29;
            case 1153397896: goto L26;
            case 1308496505: goto L23;
            default: goto L37;
        };     // Catch: IOException -> L13 XmlPullParserException -> L15
    L37:
        byte r15 = -1;
    L38:
        if (r15 == 0) goto L49;
        if (r15 == 1) goto L48;
        if (r15 == 2) goto L47;
        if (r15 == 3) goto L46;
        if (r15 != 4) goto L45;
        c r16 = new j();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L50:
        r16.e(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L13 XmlPullParserException -> L15
        c(r16);     // Catch: IOException -> L13 XmlPullParserException -> L15
        r13 = r16;
        goto L63
    L45:
        throw new NullPointerException("Key " + r14 + " not found");     // Catch: IOException -> L13 XmlPullParserException -> L15
    L46:
        r16 = new i();     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L50
    L47:
        r16 = new e();     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L50
    L48:
        r16 = new g();     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L50
    L49:
        r16 = new d();     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L50
    L23:
        if (r14.equals("KeyTrigger") == false) goto L37;
        r15 = 4;
        goto L38
    L26:
        if (r14.equals("KeyPosition") == false) goto L37;
        r15 = 1;
        goto L38
    L29:
        if (r14.equals("KeyCycle") == false) goto L37;
        r15 = 2;
        goto L38
    L32:
        if (r14.equals("KeyAttribute") == false) goto L37;
        r15 = 0;
        goto L38
    L35:
        if (r14.equals("KeyTimeCycle") == false) goto L37;
        r15 = 3;
        goto L38
    L52:
        if (r14.equalsIgnoreCase("CustomAttribute") == false) goto L58;
        if (r13 == null) goto L63;
        HashMap r17 = r13.f13649e;     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (r17 == null) goto L63;
        ConstraintAttribute.i(r10, r11, r17);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L63
    L58:
        if (r14.equalsIgnoreCase("CustomMethod") == false) goto L63;
        if (r13 == null) goto L63;
        HashMap r18 = r13.f13649e;     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (r18 == null) goto L63;
        ConstraintAttribute.i(r10, r11, r18);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L63
    L84:
        return;
    L13:
        e = move-exception;
        Log.e("KeyFrames", "Error parsing XML resource", e);
        return;
    L15:
        e = move-exception;
        Log.e("KeyFrames", "Error parsing XML resource", e);
    }
}
