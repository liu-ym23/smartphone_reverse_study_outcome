package com.bytedance.reparo.core.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SoInfoParser.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, List<a>> f9247a = null;

    /* JADX INFO: compiled from: SoInfoParser.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Map<String, String> f9250c;

        public a() {
            this.f9250c = new HashMap();
        }

        public void a(String r1, String r2) {
            this.f9250c.put(r1, r2);
        }

        public Map<String, String> a() {
            return this.f9250c;
        }
    }

    static {
        f9247a = new HashMap();
    }

    public static List<a> a(File r5) {
        if (com.bytedance.reparo.core.a.b.b.b(r5) == true) goto L5;
        return null;
    L5:
        Map<String, List<a>> r0 = f9247a;
        List<a> r2 = (List) ZeusTransformUtils.preCheckCast(r0.get(r5.getAbsolutePath()), List.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        return r2;
    L8:
        List<a> r3 = b(r5);
        if (r3.size() != 0) goto L11;
        return null;
    L11:
        r0.put(r5.getAbsolutePath(), r3);
        return r3;
    }

    private static List<a> b(File r10) {
        ArrayList r0 = new ArrayList();
        FileInputStream r1 = null;
        FileInputStream r4 = new FileInputStream(r10);     // Catch: Throwable -> L32 IOException -> L34
    L64:
        BufferedReader r5 = new BufferedReader(new InputStreamReader(r4, Charset.forName("UTF-8")));     // Catch: Throwable -> L26 IOException -> L29
    L62:
        String r2 = r5.readLine();     // Catch: Throwable -> L22 IOException -> L24
        if (r2 == null) goto L50;
        String[] r3 = r2.split(" ");     // Catch: Throwable -> L22 IOException -> L24
        a r6 = new a();     // Catch: Throwable -> L22 IOException -> L24
        r6.f9248a = r3[0];     // Catch: Throwable -> L22 IOException -> L24
        r6.f9249b = Boolean.parseBoolean(r3[1]);     // Catch: Throwable -> L22 IOException -> L24
        int r7 = 2;
    L9:
        if (r7 >= r3.length) goto L11;
        String[] r8 = r3[r7].split("=");     // Catch: Throwable -> L22 IOException -> L24
        r6.a(r8[0], r8[1]);     // Catch: Throwable -> L22 IOException -> L24
        r7 = r7 + 1;     // Catch: Throwable -> L22 IOException -> L24
        goto L9
    L11:
        r0.add(r6);     // Catch: Throwable -> L22 IOException -> L24
        goto L62
    L50:
        r4.close();     // Catch: IOException -> L15
    L56:
        r5.close();     // Catch: IOException -> L19
    L21:
        return r0;
    L19:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L56
    L24:
        e = e;
    L31:
        r1 = r4;
    L54:
    L38:
        th = th;
    L39:
        if (r1 != null) goto L52;
    L44:
        if (r5 == null) goto L67;
        r5.close();     // Catch: IOException -> L47
        throw th;
    L47:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L67:
        throw th;
    L52:
        r1.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L37:
        throw new com.bytedance.reparo.core.b.i(String.format("read %s failed. ", new Object[]{r10.getAbsolutePath()}), e, 0);     // Catch: Throwable -> L38
    L22:
        th = th;
    L28:
        r1 = r4;
        goto L39
    L29:
        e = e;
        r5 = null;
    L26:
        th = th;
        r5 = null;
    L34:
        e = e;
        r5 = null;
    L32:
        th = th;
        r5 = null;
        goto L39
    }
}
