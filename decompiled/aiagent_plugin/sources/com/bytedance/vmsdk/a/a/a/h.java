package com.bytedance.vmsdk.a.a.a;

import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: LightHttpServer.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    private static final String TAG = "LightHttpServer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.vmsdk.a.a.a.b f11688a;

    /* JADX INFO: renamed from: com.bytedance.vmsdk.a.a.a.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: LightHttpServer.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: LightHttpServer.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedInputStream f11689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final StringBuilder f11690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final C0261a f11691c;

        /* JADX INFO: renamed from: com.bytedance.vmsdk.a.a.a.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LightHttpServer.java */
        private static class C0261a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f11692a;

            private C0261a() {
                this.f11692a = 1;
            }

            /* synthetic */ C0261a(AnonymousClass1 r1) {
                this();
            }

            public void a(char r6) {
                int r0 = this.f11692a;
                if (r0 != 1) goto L5;
                if (r6 != '\r') goto L23;
                this.f11692a = 2;
                return;
            L23:
                return;
            L5:
                if (r0 == 2) goto L13;
                if (r0 != 3) goto L11;
                if (r6 != '\r') goto L9;
                this.f11692a = 2;
                return;
            L9:
                this.f11692a = 1;
                return;
            L11:
                throw new IllegalArgumentException("Unknown state: " + this.f11692a);
            L13:
                if (r6 != '\n') goto L15;
                this.f11692a = 3;
                return;
            L15:
                this.f11692a = 1;
            }

            public int a() {
                return this.f11692a;
            }
        }

        public a(BufferedInputStream r3) {
            this.f11690b = new StringBuilder();
            this.f11691c = new C0261a(null);
            this.f11689a = r3;
        }

        public String a() {
        L2:
            int r0 = this.f11689a.read();
            if (r0 < 0) goto L4;
            char r1 = (char) r0;
            this.f11691c.a(r1);
            int r2 = this.f11691c.a();
            if (r2 != 1) goto L9;
            this.f11690b.append(r1);
            goto L2
        L9:
            if (r2 != 3) goto L2;
            String r3 = this.f11690b.toString();
            this.f11690b.setLength(0);
            return r3;
        L4:
            return null;
        }
    }

    /* JADX INFO: compiled from: LightHttpServer.java */
    public static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final byte[] f11693b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedOutputStream f11694a;

        static {
            f11693b = "\r\n".getBytes();
        }

        public b(BufferedOutputStream r1) {
            this.f11694a = r1;
        }

        public void a(String r5) {
            int r0 = r5.length();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            char r2 = r5.charAt(r1);
            this.f11694a.write(r2);
            r1 = r1 + 1;
            goto L3
        L5:
            this.f11694a.write(f11693b);
        }

        public void a() {
            this.f11694a.write(f11693b);
        }

        public void b() {
            this.f11694a.flush();
        }
    }

    public h(com.bytedance.vmsdk.a.a.a.b r1) {
        this.f11688a = r1;
    }

    public void a(com.bytedance.vmsdk.a.a.d r7) {
        com.bytedance.vmsdk.a.a.b r0 = new com.bytedance.vmsdk.a.a.b(r7.a(), 1024);
        OutputStream r1 = r7.b();
        a r2 = new a(r0);
        b r3 = new b(new BufferedOutputStream(r1));
        com.bytedance.vmsdk.a.a.d r4 = new com.bytedance.vmsdk.a.a.d(r7, r0);
        f r8 = new f();
        g r5 = new g();
    L3:
        f r6 = a(r8, r2);
        if (r6 == null) goto L9;
        r5.a();
        if (a(r4, r6, r5) == false) goto L12;
        a(r5, r3, r1);
        goto L3
    L12:
        return;
    }

    private boolean a(com.bytedance.vmsdk.a.a.d r3, f r4, g r5) {
        c r2 = this.f11688a.a(r4.f11683d.getPath());
        if (r2 != null) goto L16;
        r5.f11685c = 404;
        r5.f11686d = "Not found";
        r5.f11687e = d.a("No handler found\n", "text/plain");
        return true;
    L16:
        return r2.a(r3, r4, r5);
    L8:
        e = move-exception;
        r5.f11685c = 500;
        r5.f11686d = "Internal Server Error";
        StringWriter r6 = new StringWriter();
        PrintWriter r7 = new PrintWriter(r6);
        e.printStackTrace(r7);     // Catch: Throwable -> L13
        r7.close();
        r5.f11687e = d.a(r6.toString(), "text/plain");
        return true;
    L13:
        th = move-exception;
        r7.close();
        throw th;
    }

    private static f a(f r4, a r5) {
        r4.a();
        String r0 = r5.a();
        if (r0 != null) goto L6;
        return null;
    L6:
        String[] r1 = r0.split(" ", 3);
        if (r1.length != 3) goto L11;
        r4.f11682c = r1[0];
        r4.f11683d = Uri.parse(r1[1]);
        r4.f11684e = r1[2];
        a(r4, r5);
        return r4;
    L11:
        throw new IOException("Invalid request line: " + r0);
    }

    private static void a(e r4, a r5) {
    L2:
        String r0 = r5.a();
        if (r0 == null) goto L13;
        if ("".equals(r0) == true) goto L6;
        String[] r1 = r0.split(": ", 2);
        if (r1.length != 2) goto L11;
        String r2 = r1[0];
        String r3 = r1[1];
        r4.f11680a.add(r2);
        r4.f11681b.add(r3);
        goto L2
    L11:
        throw new IOException("Malformed header: " + r0);
    L6:
        return;
    L13:
        throw new EOFException();
    }

    private static void a(g r0, b r1, OutputStream r2) {
        r0.b();
        a(r0, r1);
        if (r0.f11687e == null) goto L6;
        r0.f11687e.a(r2);
        return;
    }

    public static void a(g r6, b r7) {
        r7.a("HTTP/1.1 " + r6.f11685c + " " + r6.f11686d);
        int r0 = r6.f11680a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r7.a(((String) ZeusTransformUtils.preCheckCast(r6.f11680a.get(r1), String.class, "com.obric.aiagent.plugin")) + ": " + ((String) ZeusTransformUtils.preCheckCast(r6.f11681b.get(r1), String.class, "com.obric.aiagent.plugin")));
        r1 = r1 + 1;
        goto L3
    L5:
        r7.a();
        r7.b();
    }
}
