package com.obric.aiagent.network;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.o.o;
import d.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AgentNetworkConfigValidator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "AiagentConfigValidator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18724a = null;

    static {
        f18724a = new a();
    }

    private a() {
    }

    public final r<List<String>, List<String>, List<String>> a(List<String> r5, List<String> r6, List<String> r7) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L12;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");
        String r3 = f18724a.a(r2);
        if (r3 == null) goto L6;
        r1.add(r3);
        goto L6
    L10:
        List r12 = p.c((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), 100);
        if (r12 == null) goto L12;
    L13:
        if (r8 == null) goto L22;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r13.iterator();
    L16:
        if (r15.hasNext() == false) goto L20;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        String r17 = f18724a.b(r16);
        if (r17 == null) goto L16;
        r14.add(r17);
        goto L16
    L20:
        List r18 = p.c((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), 100);
        if (r18 == null) goto L22;
    L23:
        if (r9 == null) goto L32;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r21 = r19.iterator();
    L26:
        if (r21.hasNext() == false) goto L30;
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.aiagent.plugin");
        String r23 = f18724a.c(r22);
        if (r23 == null) goto L26;
        r20.add(r23);
        goto L26
    L30:
        List r24 = p.c((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), 100);
        if (r24 == null) goto L32;
    L34:
        return new r(r12, r18, r24);
    L32:
        r24 = p.b();
    L22:
        r18 = p.b();
    L12:
        r12 = p.b();
        goto L13
    }

    private final String a(String r8) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return (String) ZeusTransformUtils.preCheckCast(d("host is empty"), String.class, "com.obric.aiagent.plugin");
    L13:
        if (r8.length() <= 256) goto L17;
        return (String) ZeusTransformUtils.preCheckCast(d("host exceeds max length: " + r8), String.class, "com.obric.aiagent.plugin");
    L17:
        if (o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("://", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L21;
        return (String) ZeusTransformUtils.preCheckCast(d("host contains scheme: " + r8), String.class, "com.obric.aiagent.plugin");
    L21:
        if (o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L25;
        return (String) ZeusTransformUtils.preCheckCast(d("host contains path: " + r8), String.class, "com.obric.aiagent.plugin");
    L25:
        if (o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("*", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L27;
        return r8;
    L27:
        return (String) ZeusTransformUtils.preCheckCast(d("host contains wildcard: " + r8), String.class, "com.obric.aiagent.plugin");
    L5:
        if (o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final String b(String r8) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return (String) ZeusTransformUtils.preCheckCast(d("path is empty"), String.class, "com.obric.aiagent.plugin");
    L13:
        if (r8.length() <= 256) goto L17;
        return (String) ZeusTransformUtils.preCheckCast(d("path exceeds max length: " + r8), String.class, "com.obric.aiagent.plugin");
    L17:
        if (o.b(r8, "/", false, 2, null) == true) goto L21;
        return (String) ZeusTransformUtils.preCheckCast(d("path does not start with /: " + r8), String.class, "com.obric.aiagent.plugin");
    L21:
        if (d.h.b.o.a(r8, "/") == false) goto L25;
        return (String) ZeusTransformUtils.preCheckCast(d("path is root /, rejected"), String.class, "com.obric.aiagent.plugin");
    L25:
        if (o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L27;
        return r8;
    L27:
        return (String) ZeusTransformUtils.preCheckCast(d("path contains query params: " + r8), String.class, "com.obric.aiagent.plugin");
    L5:
        if (o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final String c(String r12) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return (String) ZeusTransformUtils.preCheckCast(d("urlPrefix is empty"), String.class, "com.obric.aiagent.plugin");
    L13:
        if (r12.length() <= 256) goto L17;
        return (String) ZeusTransformUtils.preCheckCast(d("urlPrefix exceeds max length: " + r12), String.class, "com.obric.aiagent.plugin");
    L17:
        if (o.b(r12, "https://", false, 2, null) == false) goto L19;
    L22:
        int r2 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), "://", 0, false, 6, null) + 3;
        if (r2 >= r12.length()) goto L36;
        if (r12.charAt(r2) == '/') goto L36;
        if (o.c((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L34;
        if (o.c((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L34;
        return r12;
    L34:
        return (String) ZeusTransformUtils.preCheckCast(d("urlPrefix contains illegal characters: " + r12), String.class, "com.obric.aiagent.plugin");
    L36:
        return (String) ZeusTransformUtils.preCheckCast(d("urlPrefix has empty host: " + r12), String.class, "com.obric.aiagent.plugin");
    L19:
        if (o.b(r12, "http://", false, 2, null) == true) goto L22;
        return (String) ZeusTransformUtils.preCheckCast(d("urlPrefix missing valid scheme: " + r12), String.class, "com.obric.aiagent.plugin");
    L5:
        if (o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final Void d(String r3) {
        ILogDepend.Companion.w(TAG, "Config validation failed, discarded: " + r3);
        return null;
    }
}
