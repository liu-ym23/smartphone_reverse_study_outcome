package com.baidu.bbalbscesium;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f30099g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f30100h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f30101i = "CuidV270Manager";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f30102j = "bohrium";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f30103k = "libbh.so";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f30104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.baidu.bbalbscesium.n.a.C0628a f30105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile FileLock f30106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile RandomAccessFile f30107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.baidu.bbalbscesium.j.b f30108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    d f30109f;

    public static class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final String f30110g = "dik";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final String f30111h = "v270fk";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final String f30112i = "cck";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final String f30113j = "ek";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final String f30114k = "ctk";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f30115l = "vsk";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final int f30116m = 1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String[] f30117n = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f30118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f30119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f30120c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f30121d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f30122e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f30123f;

        /* JADX INFO: renamed from: com.baidu.bbalbscesium.h$a$a, reason: collision with other inner class name */
        public interface InterfaceC0624a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final String f30124a = "0";

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final String f30125b = "O";

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final String f30126c = "V";
        }

        static {
            f30117n = new String[]{"V", "O", "0"};
        }

        public a() {
            this.f30123f = 1;
        }

        public static /* synthetic */ int a(a r100, int r101) {
            r100.f30123f = r101;
            return r101;
        }

        public static /* synthetic */ long a(a r100, long r101) {
            r100.f30121d = r101;
            return r101;
        }

        public static /* synthetic */ String a(a r100) {
            return r100.f30118a;
        }

        public static /* synthetic */ String a(a r100, String r101) {
            r100.f30118a = r101;
            return r101;
        }

        public static /* synthetic */ String b(a r100) {
            return r100.f30119b;
        }

        public static /* synthetic */ String b(a r100, String r101) {
            r100.f30120c = r101;
            return r101;
        }

        public static /* synthetic */ String c(a r100, String r101) {
            r100.f30122e = r101;
            return r101;
        }

        public static /* synthetic */ String d(a r100, String r101) {
            r100.f30119b = r101;
            return r101;
        }

        public String a() {
            return this.f30120c;
        }

        public String b() {
            return this.f30118a;
        }

        public String c() {
            return this.f30122e;
        }

        public String d() {
            String r100 = this.f30119b;
            if (TextUtils.isEmpty(r100) == false) goto L5;
            r100 = "0";
        L5:
            StringBuilder r101 = new StringBuilder();
            r101.append(this.f30118a);
            r101.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            r101.append(r100);
            if ("V".equals(r100) == false) goto L9;
            r101.append(this.f30120c);
        L9:
            if (TextUtils.isEmpty(this.f30122e) == true) goto L12;
            r101.append(this.f30122e);
        L12:
            return r101.toString().trim();
        }

        public String e() {
            return this.f30119b;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L26:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L26;
            a r101 = (a) r100;
            if (this.f30123f == r101.f30123f) goto L13;
        L24:
            return false;
        L13:
            if (this.f30118a.equals(r101.f30118a) == false) goto L24;
            if (this.f30119b.equals(r101.f30119b) == false) goto L24;
            if (this.f30120c.equals(r101.f30120c) == false) goto L24;
            String r102 = this.f30122e;
            String r103 = r101.f30122e;
            if (r102 == r103) goto L27;
            if (r102 == null) goto L24;
            if (r102.equals(r103) == false) goto L24;
            return true;
        L27:
            return true;
        }

        public String f() {
            JSONObject r100 = new JSONObject();     // Catch: JSONException -> L16
            r100.put(f30110g, this.f30118a);     // Catch: JSONException -> L16
            r100.put(f30111h, this.f30119b);     // Catch: JSONException -> L16
            r100.put(f30112i, this.f30120c);     // Catch: JSONException -> L16
            r100.put(f30115l, this.f30123f);     // Catch: JSONException -> L16
            r100.put(f30114k, this.f30121d);     // Catch: JSONException -> L16
            r100.put(f30113j, this.f30122e);     // Catch: JSONException -> L16
            return r100.toString();
        L16:
            e = move-exception;
            com.baidu.bbalbscesium.o.c.a(e);
            return null;
        }

        public f g() {
            f r100 = new f();
            r100.f30082a = this.f30118a;
            StringBuilder r101 = new StringBuilder();
            r101.append(this.f30119b);
            if ("V".equals(this.f30119b) == false) goto L6;
            r101.append(this.f30120c);
        L6:
            if (TextUtils.isEmpty(this.f30122e) == true) goto L8;
            r101.append(this.f30122e);
        L8:
            r100.f30083b = r101.toString().trim();
            return r100;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f30118a, this.f30119b, this.f30120c, this.f30122e, Integer.valueOf(this.f30123f)});
        }
    }

    public h(Context r100, com.baidu.bbalbscesium.n.a r101, d r102) {
        if (r100 == null) goto L7;
        this.f30104a = r100.getApplicationContext();
        com.baidu.bbalbscesium.n.a.C0628a r103 = r101.c().b(f30102j);
        this.f30105b = r103;
        r103.a();
        this.f30109f = r102;
        a(r101);
        return;
    L7:
        throw new NullPointerException("context should not be null!!!");
    }

    public static a a(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L11:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        String r103 = a(r100);     // Catch: Exception -> L9
        long r104 = System.currentTimeMillis();     // Catch: Exception -> L9
        a r105 = new a();     // Catch: Exception -> L9
        a.a(r105, r100);     // Catch: Exception -> L9
        a.b(r105, r103);     // Catch: Exception -> L9
        a.a(r105, r104);     // Catch: Exception -> L9
        a.a(r105, 1);     // Catch: Exception -> L9
        a.c(r105, r102);     // Catch: Exception -> L9
        a.d(r105, r101);     // Catch: Exception -> L9
        return r105;
    L9:
        e = move-exception;
        com.baidu.bbalbscesium.o.c.a(e);
        goto L11
    }

    private String a(Context r100) {
        String r101 = f30100h;
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return "123456";
    L6:
        return r101;
    }

    private static String a(String r100) {
        byte[] r101 = new com.baidu.bbalbscesium.i.a().a(r100.getBytes("UTF-8"));     // Catch: Exception -> L4
        return new com.baidu.bbalbscesium.o.a(com.baidu.bbalbscesium.o.a.f30412d, false, false).a(r101);
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private String a(boolean r100) {
        return this.f30105b.a(f30103k, r100);
    }

    private void a(com.baidu.bbalbscesium.n.a r100) {
        com.baidu.bbalbscesium.j.b r101 = new com.baidu.bbalbscesium.j.b(new b());
        com.baidu.bbalbscesium.j.a.b r102 = new com.baidu.bbalbscesium.j.a.b();
        r102.f30187a = this.f30104a;
        r102.f30188b = r100;
        com.baidu.bbalbscesium.j.a.d r103 = new com.baidu.bbalbscesium.j.a.d();
        Iterator r104 = r101.a().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        com.baidu.bbalbscesium.j.a r105 = (com.baidu.bbalbscesium.j.a) r104.next();
        r105.a(r102);
        r105.a(r103);
        goto L4
    L6:
        this.f30108e = r101;
    }

    public static a b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return null;
    L12:
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L9
        String r102 = r101.optString("dik", "");     // Catch: Exception -> L9
        String r103 = r101.optString("cck", "");     // Catch: Exception -> L9
        long r104 = r101.optLong("ctk", 0);     // Catch: Exception -> L9
        int r105 = r101.optInt("vsk", 1);     // Catch: Exception -> L9
        String r106 = r101.optString("ek", "");     // Catch: Exception -> L9
        String r107 = r101.optString("v270fk", "V");     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r102) == true) goto L11;
        a r108 = new a();     // Catch: Exception -> L9
        a.a(r108, r102);     // Catch: Exception -> L9
        a.b(r108, r103);     // Catch: Exception -> L9
        a.a(r108, r104);     // Catch: Exception -> L9
        a.a(r108, r105);     // Catch: Exception -> L9
        a.c(r108, r106);     // Catch: Exception -> L9
        a.d(r108, r107);     // Catch: Exception -> L9
        return r108;
    L11:
        return null;
    L9:
        e = move-exception;
        com.baidu.bbalbscesium.o.c.a(e);
        goto L11
    }

    public static void d(String r100) {
        f30100h = r100;
    }

    public a a(f r100) {
        if (r100 == null) goto L22;
        a r101 = new a();
        a.a(r101, System.currentTimeMillis());
        a.a(r101, 1);
        boolean r102 = false;
        a.d(r101, r100.f30083b.substring(0, 1));     // Catch: Exception -> L19
        a.a(r101, r100.f30082a);
        a.b(r101, a(r100.f30082a));
        String[] r103 = a.f30117n;
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L11;
        if (r103[r105].equals(a.b(r101)) == true) goto L12;
        r105 = r105 + 1;
    L12:
        if (r102 == false) goto L18;
        String r106 = r100.f30083b;
        if (r106 == null) goto L18;
        if (r106.length() < 2) goto L18;
        a.c(r101, r100.f30083b.substring(1));
    L18:
        return r101;
    L11:
        r102 = true;
    L19:
        return null;
    L22:
        throw new IllegalArgumentException("arg non-nullable is expected");
    }

    public a a(String r100, String r101) {
        com.baidu.bbalbscesium.j.a r102 = this.f30108e.a(r101);
        com.baidu.bbalbscesium.j.a.g r103 = new com.baidu.bbalbscesium.j.a.g();
        r103.f30203a = true;
        com.baidu.bbalbscesium.j.a.h r104 = r102.a(r100, r103);
        if (r104 != null) goto L5;
        return null;
    L5:
        if (r104.b() == true) goto L7;
        return null;
    L7:
        return r104.f30208a;
    }

    public void a(a r100) {
        com.baidu.bbalbscesium.j.a.e r101 = new com.baidu.bbalbscesium.j.a.e();
        Iterator r102 = this.f30108e.a().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.baidu.bbalbscesium.j.a) r102.next()).a(r101, r100);
        goto L4
    }

    public synchronized boolean a() {
        monitor-enter(this);
        File r100 = this.f30105b.a(".lock");     // Catch: Throwable -> L30
        if (r100.exists() == true) goto L35;
        r100.createNewFile();     // Catch: IOException -> L7 Throwable -> L30
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L30
    L35:
        RandomAccessFile r101 = new RandomAccessFile(r100, "rw");     // Catch: Exception -> L23 Throwable -> L30
        int r102 = 0;
    L13:
        if (r102 >= 100) goto L28;
        this.f30106c = r101.getChannel().lock();     // Catch: Exception -> L18 OverlappingFileLockException -> L20 Throwable -> L30
        this.f30107d = r101;     // Catch: Exception -> L18 OverlappingFileLockException -> L20 Throwable -> L30
        goto L21
    L15:
        monitor-exit(this);
        return true;
    L18:
        e = e;
    L25:
        com.baidu.bbalbscesium.o.c.a(e);     // Catch: Throwable -> L30
        if (this.f30106c != null) goto L28;
        com.baidu.bbalbscesium.o.c.a(r101);     // Catch: Throwable -> L30
    L21:
        Thread.sleep(100);     // Catch: Exception -> L18 Throwable -> L30
        r102 = r102 + 1;
    L28:
        monitor-exit(this);
        return false;
    L23:
        e = e;
        r101 = null;
    L30:
        th = move-exception;
        throw th;
    }

    public boolean a(a r100, boolean r101, boolean r102) {
        if (r100 == null) goto L22;
        if (TextUtils.isEmpty(a.a(r100)) == true) goto L22;
        if (r102 == false) goto L23;
    L16:
        String r103 = r100.f();     // Catch: Exception -> L18
        return this.f30105b.a(f30103k, r103, r101);
    L18:
        e = move-exception;
        e.printStackTrace();
        return false;
    L23:
        if (new PolarisFileWrapper(this.f30105b.b(), f30103k).exists() == false) goto L16;
        a r104 = b(a(true));     // Catch: Exception -> L18
        if (r104 == null) goto L16;
        String r105 = r104.d();     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r105) == true) goto L16;
        if (r105.equals(r100.d()) == false) goto L16;
        return true;
    L22:
        throw new NullPointerException("content should not be null");
    }

    public a b() {
        if (new PolarisFileWrapper(this.f30105b.b(), f30103k).exists() == true) goto L7;
        return null;
    L7:
        return b(a(true));
    }

    public a c(String r100) {
        String r101 = com.baidu.bbalbscesium.m.c.a(("com.baidu" + a(this.f30104a)).getBytes(), true);
        a r102 = new a();
        a.a(r102, System.currentTimeMillis());
        a.a(r102, 1);
        a.a(r102, r101);
        a.d(r102, ExifInterface.LONGITUDE_EAST);
        a.b(r102, a(r101));
        a.c(r102, "RO");
        return r102;
    }

    public synchronized void c() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f30106c != null) goto L19;
    L11:
        com.baidu.bbalbscesium.o.c.a(this.f30107d);     // Catch: Throwable -> L14
        this.f30107d = null;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L19:
        this.f30106c.release();     // Catch: IOException -> L8 Throwable -> L14
    L10:
        this.f30106c = null;     // Catch: Throwable -> L14
        goto L11
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L10
    }

    public a d() {
        com.baidu.bbalbscesium.j.a.g r100 = new com.baidu.bbalbscesium.j.a.g();
        r100.f30203a = true;
        List r101 = this.f30108e.a();
        Collections.sort(r101, com.baidu.bbalbscesium.j.a.f30182f);
        List r102 = this.f30109f.b(this.f30104a);
        if (r102 == null) goto L23;
        Iterator r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L39;
        c r104 = (c) r103.next();
        if (r104.f30063d == true) goto L6;
        if (r104.f30062c == false) goto L6;
        Iterator r105 = r101.iterator();
    L15:
        if (r105.hasNext() == false) goto L6;
        com.baidu.bbalbscesium.j.a.h r106 = ((com.baidu.bbalbscesium.j.a) r105.next()).a(r104.f30060a.packageName, r100);
        if (r106 == null) goto L15;
        if (r106.b() == false) goto L15;
        a r107 = r106.f30208a;
        if (r107 == null) goto L15;
        return r107;
    L39:
        return null;
    L23:
        return null;
    }
}
