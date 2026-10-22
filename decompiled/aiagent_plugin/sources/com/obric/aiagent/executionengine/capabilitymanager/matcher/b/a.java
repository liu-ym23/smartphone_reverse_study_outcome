package com.obric.aiagent.executionengine.capabilitymanager.matcher.b;

import android.content.Context;
import android.util.Xml;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f.k;
import d.h.b.n;
import d.h.b.o;
import d.o.d;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ConfigRead.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "ConfigRead";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16513a = null;

    static {
        f16513a = new a();
    }

    private a() {
    }

    public final List<com.obric.aiagent.executionengine.capabilitymanager.api.publish.a> a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        File r0 = new File(r6.getFilesDir(), "intentMatchConfig.xml");
        ILogDepend.Companion.d(TAG, "readPushedConfigFile: " + r0.getAbsolutePath());
        if (r0.exists() == false) goto L6;
        byte[] r7 = k.a(r0, null, 1, null).getBytes(d.f38623b);
        o.c(r7, "getBytes(...)");
        return a((InputStream) ZeusTransformUtils.preCheckCast(new ByteArrayInputStream(r7), InputStream.class, "com.obric.aiagent.plugin"));
    L6:
        return null;
    }

    private final List<com.obric.aiagent.executionengine.capabilitymanager.api.publish.a> a(InputStream r10) {
        List<com.obric.aiagent.executionengine.capabilitymanager.api.publish.a> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        XmlPullParser r0 = Xml.newPullParser();
        ILogDepend.Companion.d(TAG, "in parseIntents");
        r0.setInput(r10, null);     // Catch: Throwable -> L25 IOException -> L27 XmlPullParserException -> L29
        int r4 = r0.getEventType();     // Catch: Throwable -> L25 IOException -> L27 XmlPullParserException -> L29
    L5:
        if (r4 == 1) goto L23;
        if (r4 != 2) goto L22;
        if (o.a(r0.getName(), MemorySourceLinkType.INTENT) == false) goto L22;
        String r5 = r0.getAttributeValue(null, "name");     // Catch: Throwable -> L25 IOException -> L27 XmlPullParserException -> L29
        if (r5 != null) goto L13;
        r5 = "Unknown";
    L13:
        String r6 = r0.getAttributeValue(null, "defpackage");     // Catch: Throwable -> L25 IOException -> L27 XmlPullParserException -> L29
        String r7 = "";
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        String r8 = r0.getAttributeValue(null, "implClassName");     // Catch: Throwable -> L25 IOException -> L27 XmlPullParserException -> L29
        if (r8 == null) goto L21;
        r7 = r8;
    L21:
        r9.add(new com.obric.aiagent.executionengine.capabilitymanager.api.publish.a(r5, p.a(new AppIntentImplInfo(r6, r7)), (Type) ZeusTransformUtils.preCheckCast(n.class, Type.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L25 IOException -> L27 XmlPullParserException -> L29
    L22:
        r4 = r0.next();     // Catch: Throwable -> L25 IOException -> L27 XmlPullParserException -> L29
        goto L5
    L23:
        ILogDepend.Companion.d(TAG, "parseIntents size: " + r9.size());     // Catch: Throwable -> L25 IOException -> L27 XmlPullParserException -> L29
    L31:
        r10.close();
        return r9;
    L25:
        th = move-exception;
        r10.close();
        throw th;
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L25
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L25
        goto L31
    }
}
