package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: KeyFrames.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {
    private static final String TAG = "KeyFrames";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static HashMap<String, Constructor<? extends d>> f34868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<Integer, ArrayList<d>> f34869b;

    static {
        HashMap<String, Constructor<? extends d>> r0 = new HashMap();
        f34868a = r0;
        r0.put("KeyAttribute", e.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        f34868a.put("KeyPosition", h.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        f34868a.put("KeyCycle", f.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        f34868a.put("KeyTimeCycle", j.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        f34868a.put("KeyTrigger", k.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        a(TAG, "unable to load", e);
    }

    public void a(d r4) {
        if (this.f34869b.containsKey(Integer.valueOf(r4.f34863c)) == true) goto L5;
        this.f34869b.put(Integer.valueOf(r4.f34863c), new ArrayList());
    L5:
        ArrayList r3 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f34869b.get(Integer.valueOf(r4.f34863c)), ArrayList.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        r3.add(r4);
        return;
    }

    public g() {
        this.f34869b = new HashMap();
    }

    public g(Context r10, XmlPullParser r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r13 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.aiagent.plugin");
        this.f34869b = new HashMap();
        d r2 = null;
        int r3 = r13.getEventType();     // Catch: IOException -> L60 XmlPullParserException -> L62
    L5:
        if (r3 == 1) goto L81;
        if (r3 == 2) goto L13;
        if (r3 == 3) goto L11;
    L58:
        r3 = r13.next();     // Catch: IOException -> L60 XmlPullParserException -> L62
        goto L5
    L11:
        if ("KeyFrameSet".equals(r13.getName()) == false) goto L58;
        return;
    L13:
        String r4 = r13.getName();     // Catch: IOException -> L60 XmlPullParserException -> L62
        if (f34868a.containsKey(r4) == false) goto L47;
        byte r5 = -1;
        switch(r4.hashCode()) {
            case -300573030: goto L31;
            case -298435811: goto L28;
            case 540053991: goto L25;
            case 1153397896: goto L22;
            case 1308496505: goto L19;
            default: goto L33;
        };     // Catch: IOException -> L60 XmlPullParserException -> L62
    L33:
        if (r5 == 0) goto L44;
        if (r5 == 1) goto L43;
        if (r5 == 2) goto L42;
        if (r5 == 3) goto L41;
        if (r5 != 4) goto L40;
        r2 = new k();     // Catch: IOException -> L60 XmlPullParserException -> L62
    L45:
        r2.a(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L60 XmlPullParserException -> L62
        a(r2);     // Catch: IOException -> L60 XmlPullParserException -> L62
        goto L58
    L40:
        throw new NullPointerException("Key " + r4 + " not found");     // Catch: IOException -> L60 XmlPullParserException -> L62
    L41:
        r2 = new j();     // Catch: IOException -> L60 XmlPullParserException -> L62
        goto L45
    L42:
        r2 = new f();     // Catch: IOException -> L60 XmlPullParserException -> L62
        goto L45
    L43:
        r2 = new h();     // Catch: IOException -> L60 XmlPullParserException -> L62
        goto L45
    L44:
        r2 = new e();     // Catch: IOException -> L60 XmlPullParserException -> L62
        goto L45
    L19:
        if (r4.equals("KeyTrigger") == false) goto L33;
        r5 = 4;
        goto L33
    L22:
        if (r4.equals("KeyPosition") == false) goto L33;
        r5 = 1;
        goto L33
    L25:
        if (r4.equals("KeyCycle") == false) goto L33;
        r5 = 2;
        goto L33
    L28:
        if (r4.equals("KeyAttribute") == false) goto L33;
        r5 = 0;
        goto L33
    L31:
        if (r4.equals("KeyTimeCycle") == false) goto L33;
        r5 = 3;
        goto L33
    L47:
        if (r4.equalsIgnoreCase("CustomAttribute") == false) goto L53;
        if (r2 == null) goto L58;
        if (r2.f == null) goto L58;
        com.obric.oui.constraintlayout.widget.a.a(r12, r13, r2.f);     // Catch: IOException -> L60 XmlPullParserException -> L62
        goto L58
    L53:
        if (r4.equalsIgnoreCase("CustomMethod") == false) goto L58;
        if (r2 == null) goto L58;
        if (r2.f == null) goto L58;
        com.obric.oui.constraintlayout.widget.a.a(r12, r13, r2.f);     // Catch: IOException -> L60 XmlPullParserException -> L62
        goto L58
    L81:
        return;
    L60:
        e = move-exception;
        a(TAG, "Error parsing XML resource", e);
        return;
    L62:
        e = move-exception;
        a(TAG, "Error parsing XML resource", e);
    }

    public void a(m r3) {
        ArrayList<d> r2 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f34869b.get(-1), ArrayList.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r3.a(r2);
        return;
    }

    public void b(m r5) {
        ArrayList<d> r0 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f34869b.get(Integer.valueOf(r5.f34881c)), ArrayList.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r5.a(r0);
    L5:
        ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f34869b.get(-1), ArrayList.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L19;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r6.next(), d.class, "com.obric.aiagent.plugin");
        if (r1.a(((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5.f34880b.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin")).constraintTag) == false) goto L9;
        r5.a(r1);
        goto L9
    L19:
        return;
    }

    public ArrayList<d> a(int r2) {
        return (ArrayList) ZeusTransformUtils.preCheckCast(this.f34869b.get(Integer.valueOf(r2)), ArrayList.class, "com.obric.aiagent.plugin");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
