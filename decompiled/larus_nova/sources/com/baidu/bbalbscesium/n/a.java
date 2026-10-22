package com.baidu.bbalbscesium.n;

import android.content.Context;
import com.baidu.bbalbscesium.k.b.c;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f30402c = "Cesium";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f30403d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f30404e = ".cesium";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f30405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0628a f30406b;

    /* JADX INFO: renamed from: com.baidu.bbalbscesium.n.a$a, reason: collision with other inner class name */
    public final class C0628a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private File f30407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f30408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private C0628a f30409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f30410d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f30411e;

        public C0628a(a r100, File r101) {
            this.f30411e = r100;
            this.f30410d = true;
            this.f30407a = r101;
            this.f30408b = r101.getName();
        }

        public C0628a(a r100, String r101, C0628a r102) {
            this.f30411e = r100;
            this.f30408b = r101;
            this.f30409c = r102;
            this.f30410d = false;
        }

        public C0628a a(File r100) {
            if (this.f30410d == true) goto L13;
            ArrayList r101 = new ArrayList();
            C0628a r102 = this;
        L5:
            r101.add(r102.c());
            r102 = r102.d();
            if (r102 != null) goto L5;
            int r103 = r101.size() - 1;
        L8:
            if (r103 < 0) goto L11;
            PolarisFileWrapper r104 = new PolarisFileWrapper(r100, (String) ListProtector.get(r101, r103));
            r103 = r103 - 1;
            r100 = r104;
            goto L8
        L11:
            return new C0628a(this.f30411e, r100);
        L13:
            throw new IllegalStateException("isolate session is not support");
        }

        public File a(String r100) {
            return new PolarisFileWrapper(this.f30407a, r100);
        }

        public String a(String r100, boolean r101) {
            return a.a(b(), r100, "UTF-8", r101);
        }

        public void a() {
            b().mkdirs();
        }

        public boolean a(String r100, String r101, boolean r102) {
            return a.a(b(), r100, r101, "UTF-8", r102);
        }

        public C0628a b(String r100) {
            return new C0628a(this.f30411e, r100, this);
        }

        public File b() {
            File r100 = this.f30407a;
            if (r100 == null) goto L6;
            return r100;
        L6:
            if (this.f30409c != null) goto L8;
            PolarisFileWrapper r101 = new PolarisFileWrapper(this.f30411e.a(), this.f30408b);
        L9:
            this.f30407a = r101;
            return r101;
        L8:
            r101 = new PolarisFileWrapper(this.f30409c.b(), this.f30408b);
            goto L9
        }

        public String c() {
            return this.f30408b;
        }

        public C0628a d() {
            return this.f30409c;
        }
    }

    public a(Context r100) {
        this.f30405a = r100;
        b().mkdirs();
    }

    public static String a(File r100, String r101, String r102, boolean r103) {
        a(r100);
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100, r101);
        ByteArrayOutputStream r105 = null;
        ByteArrayOutputStream r106 = new ByteArrayOutputStream();     // Catch: Throwable -> L22 Exception -> L26
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r104);     // Catch: Throwable -> L18 Exception -> L20
    L32:
        byte[] r108 = new byte[8192];     // Catch: Throwable -> L16 Exception -> L29
    L7:
        int r109 = r107.read(r108);     // Catch: Throwable -> L16 Exception -> L29
        if (r109 <= 0) goto L10;
        r106.write(r108, 0, r109);     // Catch: Throwable -> L16 Exception -> L29
        goto L7
    L10:
        byte[] r110 = r106.toByteArray();     // Catch: Throwable -> L16 Exception -> L29
        if (r103 == false) goto L13;
        r110 = new c().a(r110);     // Catch: Throwable -> L16 Exception -> L29
    L13:
        String r111 = new String(r110, r102);     // Catch: Throwable -> L16 Exception -> L29
        com.baidu.bbalbscesium.o.c.a(r107);
        com.baidu.bbalbscesium.o.c.a(r106);
        return r111;
    L16:
        th = move-exception;
        th = th;
        r105 = r106;
    L24:
        com.baidu.bbalbscesium.o.c.a(r107);
        com.baidu.bbalbscesium.o.c.a(r105);
        throw th;
    L21:
        r105 = r106;
    L27:
        com.baidu.bbalbscesium.o.c.a(r107);
        com.baidu.bbalbscesium.o.c.a(r105);
        return "";
    L20:
        r107 = null;
    L18:
        th = move-exception;
        r107 = null;
        r105 = r106;
        th = th;
        goto L24
    L26:
        r107 = null;
    L22:
        th = th;
        r107 = null;
        goto L24
    }

    public static void a(File r100) {
        r100.mkdirs();
    }

    public static boolean a(File r100, String r101, String r102, String r103, boolean r104) {
        a(r100);
        PolarisFileWrapper r105 = new PolarisFileWrapper(r100, r101);
        PolarisFileOutputStreamWrapper r106 = null;
        PolarisFileOutputStreamWrapper r107 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Throwable -> L12 Exception -> L17
        goto L15
    L20:
        if (r104 == false) goto L6;
        r107.write(new c().b(r102.getBytes()));     // Catch: Throwable -> L9 Exception -> L11
    L7:
        com.baidu.bbalbscesium.o.c.a(r107);
        return true;
    L6:
        r107.write(r102.getBytes(r103));     // Catch: Throwable -> L9 Exception -> L11
    L11:
        r106 = r107;
    L9:
        th = move-exception;
        th = th;
        r106 = r107;
    L13:
        com.baidu.bbalbscesium.o.c.a(r106);
        throw th;
    L12:
        th = th;
    L15:
        com.baidu.bbalbscesium.o.c.a(r106);
        return false;
    }

    private File b() {
        return new PolarisFileWrapper(a(), f30404e);
    }

    public File a() {
        return new PolarisFileWrapper(this.f30405a.getApplicationInfo().dataDir);
    }

    public synchronized C0628a c() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f30406b != null) goto L6;
        this.f30406b = new C0628a(this, f30404e, null);     // Catch: Throwable -> L9
    L6:
        C0628a r100 = this.f30406b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }
}
