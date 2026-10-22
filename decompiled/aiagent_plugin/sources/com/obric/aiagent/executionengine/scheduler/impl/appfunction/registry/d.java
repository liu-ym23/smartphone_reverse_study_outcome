package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AppFunctionAppMetadataReader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final String TAG = "AppFuncAppMetadata";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18246a = null;

    static {
        f18246a = new d();
    }

    private d() {
    }

    public final c a(String r10) {
        d.h.b.o.e(r10, "packageName");
        PackageManager r1 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();
        List<PackageManager.Property> r4 = r1.queryApplicationProperty("android.app.appfunctions.app_metadata");     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        d.h.b.o.c(r4, "queryApplicationProperty(...)");     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
    L5:
        if (r5.hasNext() == false) goto L9;
        Object r6 = r5.next();     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        if (d.h.b.o.a(((PackageManager.Property) ZeusTransformUtils.preCheckCast(r6, PackageManager.Property.class, "com.obric.aiagent.plugin")).getPackageName(), r10) == false) goto L5;
    L10:
        PackageManager.Property r7 = (PackageManager.Property) ZeusTransformUtils.preCheckCast(r6, PackageManager.Property.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        if (r7 != null) goto L14;
        d r9 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        ILogDepend.Companion.w(TAG, "no android.app.appfunctions.app_metadata property for " + r10);     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        return null;
    L14:
        int r11 = r7.getResourceId();     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        if (r11 != 0) goto L18;
        ILogDepend.Companion.w(TAG, "android.app.appfunctions.app_metadata is not a resource for " + r10);     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        return null;
    L18:
        Resources r8 = r1.getResourcesForApplication(r10);     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        d.h.b.o.c(r8, "getResourcesForApplication(...)");     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        AutoCloseable r12 = (AutoCloseable) ZeusTransformUtils.preCheckCast(r8.getXml(r11), AutoCloseable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        XmlResourceParser r13 = (XmlResourceParser) ZeusTransformUtils.preCheckCast(r12, XmlResourceParser.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        d r14 = f18246a;     // Catch: Throwable -> L50
        d.h.b.o.a(r13);     // Catch: Throwable -> L50
        c r15 = r14.a(r13, r8);     // Catch: Throwable -> L50
        int r16 = 0;
        if (r15 != null) goto L59;
    L30:
        ILogDepend.Companion r2 = ILogDepend.Companion;     // Catch: Throwable -> L50
        StringBuilder r17 = new StringBuilder().append("read package=").append(r10).append(", found=");     // Catch: Throwable -> L50
        if (r15 == null) goto L33;
        boolean r18 = true;
    L34:
        StringBuilder r19 = r17.append(r18).append(", descriptionLength=");     // Catch: Throwable -> L50
        if (r15 == null) goto L39;
        String r20 = r15.a();     // Catch: Throwable -> L50
        if (r20 == null) goto L39;
        int r21 = r20.length();     // Catch: Throwable -> L50
    L40:
        StringBuilder r22 = r19.append(r21).append(", descriptionLines=");     // Catch: Throwable -> L50
        if (r15 == null) goto L47;
        String r23 = r15.a();     // Catch: Throwable -> L50
        if (r23 == null) goto L47;
        List<String> r24 = d.o.o.g((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L50
        if (r24 == null) goto L47;
        r16 = r24.size();     // Catch: Throwable -> L50
    L47:
        r2.i(TAG, r22.append(r16).toString());     // Catch: Throwable -> L50
        d.g.a.a(r12, null);     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        return r15;
    L39:
        r21 = 0;
        goto L40
    L33:
        r18 = false;
        goto L34
    L59:
        d.n.a r25 = d.n.f38560a;     // Catch: Throwable -> L24
        ApplicationInfo r26 = r1.getApplicationInfo(r10, 0);     // Catch: Throwable -> L24
        d.h.b.o.c(r26, "getApplicationInfo(...)");     // Catch: Throwable -> L24
        Object r3 = d.n.f(r1.getApplicationLabel(r26).toString());     // Catch: Throwable -> L24
    L27:
        if (d.n.b(r3) == false) goto L29;
        r3 = null;
    L29:
        r15.a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L50
    L24:
        th = move-exception;
        d.n.a r27 = d.n.f38560a;     // Catch: Throwable -> L50
        r3 = d.n.f(d.o.a(th));     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        d.g.a.a(r12, th);     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
        throw th;     // Catch: Exception -> L55 PackageManager.NameNotFoundException -> L58
    L9:
        r6 = null;
    L55:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "read failed: package=" + r10, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L70:
        return null;
    }

    private final c a(XmlResourceParser r18, Resources r19) {
        XmlResourceParser r2 = (XmlResourceParser) ZeusTransformUtils.wrapperContextForParams(r18, XmlResourceParser.class, "com.obric.aiagent.plugin");
    L3:
        String r6 = null;
        if (r2.getEventType() == 1) goto L47;
        if (r2.getEventType() != 2) goto L46;
        if (d.h.b.o.a(r2.getName(), "AppFunctionAppMetadata") == false) goto L46;
        String r5 = a(r2, r19, "http://schemas.android.com/apk/androidx.appfunctions", "description");
        if (r5 == null) goto L12;
        String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L14:
        if (r7 != null) goto L16;
        String r9 = "";
    L17:
        String r4 = a(r2, r19, "http://schemas.android.com/apk/androidx.appfunctions", "displayDescription");
        if (r4 == null) goto L20;
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L21:
        if (r8 != null) goto L23;
        String r10 = "";
    L24:
        String r11 = a(r2, r19, "skillName");
        if (r11 == null) goto L27;
        String r12 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L28:
        if (r12 != null) goto L30;
        String r13 = "";
    L31:
        String r14 = a(r2, r19, "skillDescription");
        if (r14 == null) goto L34;
        String r15 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L35:
        if (r15 != null) goto L37;
        String r16 = "";
    L38:
        String r0 = a(r2, r19, "triggerExamples");
        if (r0 == null) goto L41;
        r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L41:
        if (r6 != null) goto L43;
        String r17 = "";
    L45:
        return new c(r9, r10, null, r13, r16, r17, 4, null);
    L43:
        r17 = r6;
        goto L45
    L37:
        r16 = r15;
        goto L38
    L34:
        r15 = null;
        goto L35
    L30:
        r13 = r12;
        goto L31
    L27:
        r12 = null;
        goto L28
    L23:
        r10 = r8;
        goto L24
    L20:
        r8 = null;
        goto L21
    L16:
        r9 = r7;
        goto L17
    L12:
        r7 = null;
    L46:
        r2.next();
        goto L3
    L47:
        return null;
    }

    private final String a(XmlResourceParser r2, Resources r3, String r4, String r5) {
        XmlResourceParser r1 = (XmlResourceParser) ZeusTransformUtils.wrapperContextForParams(r2, XmlResourceParser.class, "com.obric.aiagent.plugin");
        int r6 = r1.getAttributeResourceValue(r4, r5, 0);
        if (r6 == 0) goto L6;
        return r3.getString(r6);
    L6:
        return r1.getAttributeValue(r4, r5);
    }

    private final String a(XmlResourceParser r6, Resources r7, String r8) {
        XmlResourceParser r5 = (XmlResourceParser) ZeusTransformUtils.wrapperContextForParams(r6, XmlResourceParser.class, "com.obric.aiagent.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(0, r5.getAttributeCount()), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        Object r2 = r9.next();
        if (d.h.b.o.a(r5.getAttributeName(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue()), r8) == false) goto L4;
    L9:
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L16;
        int r11 = r10.intValue();
        int r12 = r5.getAttributeResourceValue(r11, 0);
        if (r12 == 0) goto L15;
        return r7.getString(r12);
    L15:
        return r5.getAttributeValue(r11);
    L16:
        return null;
    L8:
        r2 = null;
        goto L9
    }
}
