package com.obric.aiagent.executionengine.capabilitymanager.publish.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f.c;
import d.h.b.o;
import d.n;
import d.x;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: IntentParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "IntentParser";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16562a = null;

    static {
        f16562a = new a();
    }

    private a() {
    }

    public final List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> a(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r5, "packageName");
        ApplicationInfo r0 = r6.getPackageManager().getApplicationInfo(r5, 128);     // Catch: Throwable -> L8
        o.a(r0);
        List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r3 = (List) ZeusTransformUtils.preCheckCast(a(r6, p.a(r0)).get(r5), List.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        return r3;
    L7:
        return p.b();
    L8:
        th = move-exception;
        ILogDepend.Companion.w(TAG, "cannot find appInfo for `" + r5 + "`; err=" + th.getMessage(), th);
        return p.b();
    }

    private final Map<String, List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a>> a(Context r10, List<? extends ApplicationInfo> r11) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        PackageManager r13 = r9.getPackageManager();
        HashMap r14 = new HashMap();
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r15.hasNext() == false) goto L32;
        ApplicationInfo r1 = (ApplicationInfo) ZeusTransformUtils.preCheckCast(r15.next(), ApplicationInfo.class, "com.obric.aiagent.plugin");
        if (r1.metaData == null) goto L4;
        Resources r2 = r13.getResourcesForApplication(r1.packageName);     // Catch: Exception -> L29
        o.c(r2, "getResourcesForApplication(...)");     // Catch: Exception -> L29
        String r3 = r1.metaData.getString("assistant.app.intents.v2");     // Catch: Exception -> L29
        if (r3 != null) goto L12;
        Integer r4 = Integer.valueOf(r1.metaData.getInt("assistant.app.intents"));     // Catch: Exception -> L29
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() == 0) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == true) goto L23;
        r4 = null;
    L23:
        if (r4 == null) goto L4;
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Exception -> L29
        a r7 = f16562a;     // Catch: Exception -> L29
        String r8 = r1.packageName;     // Catch: Exception -> L29
        o.c(r8, "packageName");     // Catch: Exception -> L29
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
        String r17 = r1.packageName;     // Catch: Exception -> L29
        Object r18 = r16.get(r17);     // Catch: Exception -> L29
        if (r18 != null) goto L27;
        r18 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
        r16.put(r17, r18);     // Catch: Exception -> L29
    L27:
        r7.a(r2, r6, r8, (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L29
        goto L4
    L19:
        r5 = false;
        goto L20
    L12:
        a r19 = f16562a;     // Catch: Exception -> L29
        String r20 = r1.packageName;     // Catch: Exception -> L29
        o.c(r20, "packageName");     // Catch: Exception -> L29
        Map r21 = (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
        String r22 = r1.packageName;     // Catch: Exception -> L29
        Object r23 = r21.get(r22);     // Catch: Exception -> L29
        if (r23 != null) goto L15;
        r23 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
        r21.put(r22, r23);     // Catch: Exception -> L29
    L15:
        r19.a(r2, r3, r20, (List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L29
    L29:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "parse intent failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L4
    L32:
        return (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin");
    }

    private final void a(Resources r19, String r20, String r21, List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r22) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r3 = n.f(r19.getAssets().open(r20));     // Catch: Throwable -> L5
    L8:
        if (n.b(r3) == false) goto L10;
        r3 = null;
    L10:
        InputStream r4 = (InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L55;
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.aiagent.plugin");
        InputStream r6 = (InputStream) ZeusTransformUtils.preCheckCast(r5, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
        XmlPullParser r7 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: Throwable -> L49
        r7.setInput(r6, "UTF-8");     // Catch: Throwable -> L49
    L14:
        boolean r8 = true;
        if (r7.getEventType() == 1) goto L47;
        if (r7.getEventType() != 2) goto L46;
        if (o.a(r7.getName(), MemorySourceLinkType.INTENT) == false) goto L46;
        String r9 = r7.getAttributeValue(null, "name");     // Catch: Throwable -> L49
        String r10 = r7.getAttributeValue(null, "impl");     // Catch: Throwable -> L49
        String r15 = r7.getAttributeValue(null, WsConstants.KEY_SERVICE);     // Catch: Throwable -> L49
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
        if (r11 != null) goto L23;
    L26:
        boolean r12 = true;
    L27:
        if (r12 == true) goto L46;
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L49
        if (r13 != null) goto L31;
    L34:
        if (r8 == true) goto L46;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L49
    L37:
        if (r14.hasNext() == false) goto L41;
        Object r16 = r14.next();     // Catch: Throwable -> L49
        if (o.a(((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r16, com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).a(), r9) == false) goto L37;
    L43:
        if (r16 == null) goto L45;
        ILogDepend.Companion.e(TAG, "Duplicate intent declared " + r9);     // Catch: Throwable -> L49
        goto L46
    L45:
        ILogDepend.Companion.i(TAG, "Parse intent " + r9 + ' ' + r21 + ' ' + r10);     // Catch: Throwable -> L49
        r2.add(new com.obric.aiagent.executionengine.capabilitymanager.data.bean.a(r9, r21, r10, true, null, false, 0, r15, 112, null));     // Catch: Throwable -> L49
        goto L46
    L41:
        r16 = null;
        goto L43
    L31:
        if (r13.length() == 0) goto L34;
        r8 = false;
        goto L34
    L23:
        if (r11.length() == 0) goto L26;
        r12 = false;
    L46:
        r7.next();     // Catch: Throwable -> L49
        goto L14
    L47:
        x r17 = x.f38692a;     // Catch: Throwable -> L49
        c.a(r5, null);
        return;
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        c.a(r5, th);
        throw th;
    L55:
        return;
    L5:
        th = move-exception;
        n.a r18 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L8
    }

    private final void a(Resources r19, int r20, String r21, List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r22) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        XmlResourceParser r4 = r19.getXml(r20);
        o.c(r4, "getXml(...)");
    L3:
        boolean r6 = true;
        if (r4.getEventType() == 1) goto L35;
        if (r4.getEventType() != 2) goto L34;
        if (o.a(r4.getName(), MemorySourceLinkType.INTENT) == false) goto L34;
        String r8 = a(r4, r19, "name");
        String r10 = a(r4, r19, "impl");
        Object r5 = null;
        String r15 = r4.getAttributeValue(null, WsConstants.KEY_SERVICE);
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L12;
    L15:
        boolean r9 = true;
    L16:
        if (r9 == true) goto L34;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L20;
    L23:
        if (r6 == true) goto L34;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L26:
        if (r12.hasNext() == false) goto L31;
        Object r13 = r12.next();
        if (o.a(((com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin")).a(), r8) == false) goto L26;
        r5 = r13;
    L31:
        if (r5 == null) goto L33;
        ILogDepend.Companion.e(TAG, "Duplicate intent declared " + r8);
        goto L34
    L33:
        ILogDepend.Companion.i(TAG, "Parse intent " + r8 + ' ' + r21 + ' ' + r10);
        r2.add(new com.obric.aiagent.executionengine.capabilitymanager.data.bean.a(r8, r21, r10, true, null, false, 0, r15, 112, null));
        goto L34
    L20:
        if (r11.length() == 0) goto L23;
        r6 = false;
        goto L23
    L12:
        if (r7.length() == 0) goto L15;
        r9 = false;
    L34:
        r4.next();
        goto L3
    }

    private final String a(XmlResourceParser r5, Resources r6, String r7) {
        String r4 = ((XmlResourceParser) ZeusTransformUtils.wrapperContextForParams(r5, XmlResourceParser.class, "com.obric.aiagent.plugin")).getAttributeValue(null, r7);     // Catch: Resources.NotFoundException -> L16
        o.a(r4);     // Catch: Resources.NotFoundException -> L16
        if (d.o.o.b(r4, "@", false, 2, null) == true) goto L18;
    L15:
        return r4;
    L18:
        n.a r1 = n.f38560a;     // Catch: Throwable -> L7
        String r2 = r4.substring(1);     // Catch: Throwable -> L7
        o.c(r2, "substring(...)");     // Catch: Throwable -> L7
        Object r8 = n.f(r6.getString(Integer.parseInt(r2)));     // Catch: Throwable -> L7
    L10:
        if (n.b(r8) == false) goto L12;
        r8 = null;
    L12:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");     // Catch: Resources.NotFoundException -> L16
        if (r9 == null) goto L15;
        return r9;
    L7:
        th = move-exception;
        n.a r3 = n.f38560a;     // Catch: Resources.NotFoundException -> L16
        r8 = n.f(d.o.a(th));     // Catch: Resources.NotFoundException -> L16
    L16:
        ILogDepend.Companion.w(TAG, "getAttributeValue " + r7 + " not found");
        return null;
    }
}
