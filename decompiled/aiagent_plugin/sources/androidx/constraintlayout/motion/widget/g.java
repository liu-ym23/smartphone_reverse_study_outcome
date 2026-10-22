package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.aiagent.apm.impl.BuildConfig;
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
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static final String TAG = "KeyFrames";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static HashMap<String, Constructor<? extends d>> f885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<Integer, ArrayList<d>> f886b;

    static {
        HashMap<String, Constructor<? extends d>> r0 = new HashMap();
        f885a = r0;
        r0.put("KeyAttribute", e.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        f885a.put("KeyPosition", h.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        f885a.put("KeyCycle", f.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        f885a.put("KeyTimeCycle", j.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        f885a.put("KeyTrigger", k.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        a(TAG, "unable to load", e);
    }

    public void a(d r4) {
        if (this.f886b.containsKey(Integer.valueOf(r4.f880c)) == true) goto L5;
        this.f886b.put(Integer.valueOf(r4.f880c), new ArrayList());
    L5:
        ArrayList r3 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f886b.get(Integer.valueOf(r4.f880c)), ArrayList.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        r3.add(r4);
        return;
    }

    public g() {
        this.f886b = new HashMap();
    }

    public g(Context r8, XmlPullParser r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.aiagent.plugin");
        this.f886b = new HashMap();
        d r0 = null;
        int r2 = r11.getEventType();     // Catch: IOException -> L43 XmlPullParserException -> L45
    L5:
        if (r2 == 1) goto L69;
        if (r2 != 2) goto L9;
        String r3 = r11.getName();     // Catch: IOException -> L43 XmlPullParserException -> L45
        if (f885a.containsKey(r3) == false) goto L30;
        Constructor r4 = (Constructor) ZeusTransformUtils.preCheckCast(f885a.get(r3), Constructor.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25 IOException -> L43 XmlPullParserException -> L45
        if (r4 == null) goto L24;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r4.newInstance(new Object[0]), d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25 IOException -> L43 XmlPullParserException -> L45
        r5.a(r10, Xml.asAttributeSet(r11));     // Catch: Exception -> L21 IOException -> L43 XmlPullParserException -> L45
        a(r5);     // Catch: Exception -> L21 IOException -> L43 XmlPullParserException -> L45
    L28:
        r0 = r5;
    L41:
        r2 = r11.next();     // Catch: IOException -> L43 XmlPullParserException -> L45
    L21:
        Exception e2 = e;
    L27:
        a(TAG, "unable to create ", e2);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L28
    L24:
        throw new NullPointerException("Keymaker for " + r3 + " not found");     // Catch: Exception -> L25 IOException -> L43 XmlPullParserException -> L45
    L25:
        e = move-exception;
        r5 = r0;
        e2 = e;
        goto L27
    L30:
        if (r3.equalsIgnoreCase("CustomAttribute") == false) goto L36;
        if (r0 == null) goto L41;
        if (r0.f == null) goto L41;
        androidx.constraintlayout.widget.a.a(r10, r11, r0.f);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L41
    L36:
        if (r3.equalsIgnoreCase("CustomMethod") == false) goto L41;
        if (r0 == null) goto L41;
        if (r0.f == null) goto L41;
        androidx.constraintlayout.widget.a.a(r10, r11, r0.f);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L41
    L9:
        if (r2 != 3) goto L41;
        if ("KeyFrameSet".equals(r11.getName()) == false) goto L41;
        return;
    L69:
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
        return;
    L45:
        e = move-exception;
        e.printStackTrace();
    }

    public void a(m r3) {
        ArrayList<d> r2 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f886b.get(-1), ArrayList.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r3.a(r2);
        return;
    }

    public void b(m r5) {
        ArrayList<d> r0 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f886b.get(Integer.valueOf(r5.f898c)), ArrayList.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r5.a(r0);
    L5:
        ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f886b.get(-1), ArrayList.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L19;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r6.next(), d.class, "com.obric.aiagent.plugin");
        if (r1.a(((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5.f897b.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin")).constraintTag) == false) goto L9;
        r5.a(r1);
        goto L9
    L19:
        return;
    }

    public ArrayList<d> a(int r2) {
        return (ArrayList) ZeusTransformUtils.preCheckCast(this.f886b.get(Integer.valueOf(r2)), ArrayList.class, "com.obric.aiagent.plugin");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
