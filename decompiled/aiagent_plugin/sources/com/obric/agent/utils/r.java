package com.obric.agent.utils;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LarkPinyinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r {
    private static final String TAG = "LarkPinyinHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f16062a = null;

    private r() {
    }

    static {
        r r0 = new r();
        f16062a = r0;
        final Map<String, String[]> r1 = r0.a();
        com.b.b.a.c.a(com.b.b.a.c.a().a((com.b.b.a.h) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r1), com.b.b.a.h.class, "com.obric.aiagent.plugin")));
    }

    public final String a(String r7) {
        d.h.b.o.e(r7, "personName");
        StringBuilder r6 = new StringBuilder(r7.length() * 2);
        int r0 = r7.length();
        Boolean r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        char r3 = r7.charAt(r2);
        boolean r4 = com.b.b.a.c.b(r3);
        if (r1 != null) goto L7;
    L9:
        if (r4 == false) goto L11;
        r6.append(com.b.b.a.c.a(r3));
    L12:
        r1 = Boolean.valueOf(r4);
        r2 = r2 + 1;
        goto L3
    L11:
        r6.append(r3);
        goto L12
    L7:
        if (d.h.b.o.a(r1, Boolean.valueOf(r4)) == true) goto L9;
        r6.append(' ');
        goto L9
    L13:
        String r8 = r6.toString();
        d.h.b.o.c(r8, "toString(...)");
        return r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, String[]> a() {
        Map<String, String[]> r15 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        ClassLoader r0 = r.class.getClassLoader();     // Catch: Exception -> L38
        if (r0 == null) goto L37;
        InputStream r1 = r0.getResourceAsStream("pinyin_corrections.txt");     // Catch: Exception -> L38
        if (r1 == null) goto L37;
        Reader r2 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r1, d.o.d.f38623b), Reader.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        if (ZeusTransformUtils.instanceOf(r2, BufferedReader.class) == false) goto L10;
        BufferedReader r3 = (BufferedReader) ZeusTransformUtils.preCheckCast(r2, BufferedReader.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
    L11:
        Reader r4 = (Reader) ZeusTransformUtils.preCheckCast(r3, Reader.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        if (ZeusTransformUtils.instanceOf(r4, BufferedReader.class) == false) goto L14;
        BufferedReader r5 = (BufferedReader) ZeusTransformUtils.preCheckCast(r4, BufferedReader.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
    L15:
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r5, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        Iterator<String> r7 = d.f.t.a((BufferedReader) ZeusTransformUtils.preCheckCast(r6, BufferedReader.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L32
    L18:
        if (r7.hasNext() == false) goto L29;
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L32
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L18;
        if (d.o.o.b(r8, "#", false, 2, null) == true) goto L18;
        List r10 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"="}, false, 2, 2, null);     // Catch: Throwable -> L32
        if (r10.size() != 2) goto L18;
        r15.put(r10.get(0), new String[]{r10.get(1)});     // Catch: Throwable -> L32
        goto L18
    L22:
        r9 = false;
        goto L23
    L29:
        d.x r11 = d.x.f38692a;     // Catch: Throwable -> L32
        d.f.c.a(r6, null);     // Catch: Exception -> L38
    L40:
        return r15;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        d.f.c.a(r6, th);     // Catch: Exception -> L38
        throw th;     // Catch: Exception -> L38
    L14:
        r5 = new BufferedReader(r4, 8192);     // Catch: Exception -> L38
        goto L15
    L10:
        r3 = new BufferedReader(r2, 8192);     // Catch: Exception -> L38
    L37:
        return r15;
    L38:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "loadPinyinCorrections error: " + e.getMessage());
        goto L40
    }
}
