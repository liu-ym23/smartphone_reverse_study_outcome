package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Alog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f4060a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f4061b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f4062c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f4063d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f4064e = 0;
    private static final int f = 0;
    private static volatile List<com.bytedance.android.alog.c> g;
    private static final ArrayList<String> h = null;
    private static boolean i;
    private Context j;
    private int k;
    private String l;
    private String m;
    private int n;
    private int o;
    private String p;
    private String q;
    private long r;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4065a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4066b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f4067c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f4068e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f4069d;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f4068e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("NONE", 0, 0);
            f4065a = r0;
            a r1 = new a("EC_SECP256K1", 1, 1);
            f4066b = r1;
            a r3 = new a("EC_SECP256R1", 2, 2);
            f4067c = r3;
            f4068e = new a[]{r0, r1, r3};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f4069d = r3;
        }

        int a() {
            return this.f4069d;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f4070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4072c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f4073d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f4074e;
        private int f;
        private int g;
        private int h;
        private String i;
        private int j;
        private int k;
        private String l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;
        private String s;
        private boolean t;

        public b(Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            this.f4071b = 0;
            this.f4072c = false;
            this.f4073d = null;
            this.f4074e = null;
            this.f = UiType.FLAG_REMOTE_CARD;
            this.g = 20971520;
            this.h = 7;
            this.i = null;
            this.j = 65536;
            this.k = 196608;
            this.l = null;
            this.m = Alog.f();
            this.n = Alog.g();
            this.o = Alog.h();
            this.p = Alog.i();
            this.q = Alog.j();
            this.r = Alog.k();
            this.s = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
            this.t = false;
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L5;
            r6 = r0;
        L5:
            this.f4070a = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        }

        public b a(int r1) {
            this.f4071b = r1;
            return this;
        }

        public b a(boolean r1) {
            this.f4072c = r1;
            return this;
        }

        public b a(String r4) {
            if (TextUtils.isEmpty(r4) == false) goto L5;
        L13:
            return this;
        L5:
            if (r4.contains("-") == false) goto L8;
            r4 = r4.replace("-", "");
        L8:
            if (r4.contains("_") == false) goto L11;
            r4 = r4.replace("_", "");
        L11:
            if (TextUtils.isEmpty(r4) == true) goto L13;
            this.f4073d = r4;
            goto L13
        }

        public b b(String r1) {
            this.f4074e = r1;
            return this;
        }

        public b b(int r1) {
            this.f = r1;
            return this;
        }

        public b c(int r1) {
            this.g = r1;
            return this;
        }

        public b d(int r1) {
            this.h = r1;
            return this;
        }

        public b c(String r1) {
            this.i = r1;
            return this;
        }

        public b e(int r1) {
            this.j = r1;
            return this;
        }

        public b f(int r1) {
            this.k = r1;
            return this;
        }

        public b a(d r1) {
            this.m = r1.a();
            return this;
        }

        public b a(g r1) {
            this.n = r1.a();
            return this;
        }

        public b a(e r1) {
            this.o = r1.a();
            return this;
        }

        public b a(c r1) {
            this.p = r1.a();
            return this;
        }

        public b a(f r1) {
            this.q = r1.a();
            return this;
        }

        public b a(a r1) {
            this.r = r1.a();
            return this;
        }

        public b d(String r1) {
            this.s = r1;
            return this;
        }

        public b b(boolean r1) {
            this.t = r1;
            return this;
        }

        public Alog a() {
            if (this.f4073d != null) goto L5;
            this.f4073d = DownloadSettingKeys.BugFix.DEFAULT;
        L5:
            ArrayList r1 = Alog.l();
            monitor-enter(r1);
            Iterator r2 = Alog.l().iterator();     // Catch: Throwable -> L36
        L9:
            if (r2.hasNext() == false) goto L14;
            if (((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin")).equals(this.f4073d) == false) goto L9;
            monitor-exit(r1);     // Catch: Throwable -> L36
            return null;
        L14:
            Alog.l().add(this.f4073d);     // Catch: Throwable -> L36
            monitor-exit(r1);     // Catch: Throwable -> L36
            if (this.f4074e != null) goto L23;
            File r3 = this.f4070a.getExternalFilesDir(null);
            if (r3 == null) goto L21;
            this.f4074e = r3.getPath() + "/alog";
            goto L23
        L21:
            this.f4074e = this.f4070a.getFilesDir() + "/alog";
        L23:
            if (this.i != null) goto L26;
            this.i = this.f4070a.getFilesDir() + "/alog";
        L26:
            if (this.l != null) goto L28;
            this.l = com.bytedance.android.alog.f.a(this.f4070a);
        L28:
            int r4 = (this.j / 4096) * 4096;
            this.j = r4;
            int r5 = (this.k / 4096) * 4096;
            this.k = r5;
            if (r4 >= 4096) goto L31;
            this.j = 4096;
        L31:
            int r6 = this.j;
            if (r5 >= (r6 * 2)) goto L35;
            this.k = r6 * 2;
        L35:
            return new Alog(this.f4070a, this.f4071b, this.f4072c, this.f4073d, this.f4074e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t);
        L36:
            th = move-exception;
            throw th;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f4075a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f4076b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f4077c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ c[] f4078e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f4079d;

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f4078e.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        static {
            c r0 = new c("NONE", 0, 0);
            f4075a = r0;
            c r1 = new c("ZLIB", 1, 1);
            f4076b = r1;
            c r3 = new c("ZSTD", 2, 2);
            f4077c = r3;
            f4078e = new c[]{r0, r1, r3};
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
            this.f4079d = r3;
        }

        int a() {
            return this.f4079d;
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f4080a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f4081b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d[] f4082d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f4083c;

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f4082d.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        static {
            d r0 = new d("SPEED", 0, 0);
            f4080a = r0;
            d r1 = new d("SAFE", 1, 1);
            f4081b = r1;
            f4082d = new d[]{r0, r1};
        }

        private d(String r1, int r2, int r3) {
            super(r1, r2);
            this.f4083c = r3;
        }

        int a() {
            return this.f4083c;
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f4084a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f4085b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ e[] f4086d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f4087c;

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f4086d.clone(), e[].class, "com.obric.aiagent.plugin");
        }

        static {
            e r0 = new e("DEFAULT", 0, 0);
            f4084a = r0;
            e r1 = new e("LEGACY", 1, 1);
            f4085b = r1;
            f4086d = new e[]{r0, r1};
        }

        private e(String r1, int r2, int r3) {
            super(r1, r2);
            this.f4087c = r3;
        }

        int a() {
            return this.f4087c;
        }
    }

    public static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f4088a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f4089b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f4090c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final f f4091d = null;
        private static final /* synthetic */ f[] f = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f4092e;

        public static f valueOf(String r2) {
            return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
        }

        public static f[] values() {
            return (f[]) ZeusTransformUtils.preCheckCast(f.clone(), f[].class, "com.obric.aiagent.plugin");
        }

        static {
            f r0 = new f("NONE", 0, 0);
            f4088a = r0;
            f r1 = new f("TEA_16", 1, 1);
            f4089b = r1;
            f r3 = new f("TEA_32", 2, 2);
            f4090c = r3;
            f r5 = new f("TEA_64", 3, 3);
            f4091d = r5;
            f = new f[]{r0, r1, r3, r5};
        }

        private f(String r1, int r2, int r3) {
            super(r1, r2);
            this.f4092e = r3;
        }

        int a() {
            return this.f4092e;
        }
    }

    public static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f4093a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f4094b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ g[] f4095d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f4096c;

        public static g valueOf(String r2) {
            return (g) ZeusTransformUtils.preCheckCast(Enum.valueOf(g.class, r2), g.class, "com.obric.aiagent.plugin");
        }

        public static g[] values() {
            return (g[]) ZeusTransformUtils.preCheckCast(f4095d.clone(), g[].class, "com.obric.aiagent.plugin");
        }

        static {
            g r0 = new g("RAW", 0, 0);
            f4093a = r0;
            g r1 = new g("ISO_8601", 1, 1);
            f4094b = r1;
            f4095d = new g[]{r0, r1};
        }

        private g(String r1, int r2, int r3) {
            super(r1, r2);
            this.f4096c = r3;
        }

        int a() {
            return this.f4096c;
        }
    }

    private static native void nativeAsyncFlush(long r0);

    private static native long nativeCreate(int r0, boolean r1, String r2, String r3, int r4, int r5, int r6, String r7, int r8, int r9, String r10, int r11, int r12, int r13, int r14, int r15, int r16, String r17, boolean r18);

    private static native void nativeDestroy(long r0);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native long nativeGetNativeWriteFuncAddr();

    static native void nativeSetDefaultInstance(long r0);

    private static native void nativeSetLevel(long r0, int r2);

    private static native void nativeSetSyslog(long r0, boolean r2);

    private static native void nativeSyncFlush(long r0);

    private static native void nativeTimedSyncFlush(long r0, int r2);

    private static native void nativeWrite(long r0, int r2, String r3, String r4);

    private static native void nativeWriteAsyncMsg(long r0, int r2, String r3, String r4, long r5, long r7);

    static /* synthetic */ int f() {
        return f4060a;
    }

    static /* synthetic */ int g() {
        return f4061b;
    }

    static /* synthetic */ int h() {
        return f4062c;
    }

    static /* synthetic */ int i() {
        return f4063d;
    }

    static /* synthetic */ int j() {
        return f4064e;
    }

    static /* synthetic */ int k() {
        return f;
    }

    static /* synthetic */ ArrayList l() {
        return h;
    }

    static {
        f4060a = d.f4081b.a();
        f4061b = g.f4093a.a();
        f4062c = e.f4084a.a();
        f4063d = c.f4077c.a();
        f4064e = f.f4089b.a();
        f = a.f4066b.a();
        g = null;
        h = new ArrayList();
        i = false;
    }

    public static synchronized void a(com.bytedance.android.alog.b r3) {
        monitor-enter(Alog.class);
        com.bytedance.android.alog.b r4 = (com.bytedance.android.alog.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.android.alog.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (i == false) goto L8;
        monitor-exit(Alog.class);
        return;
    L8:
        if (r4 != null) goto L10;
        System.loadLibrary("alog");     // Catch: Throwable -> L14
    L11:
        i = true;     // Catch: Throwable -> L14
        monitor-exit(Alog.class);
        return;
    L10:
        r4.a("alog");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public Alog(Context r7, int r8, boolean r9, String r10, String r11, int r12, int r13, int r14, String r15, int r16, int r17, String r18, int r19, int r20, int r21, int r22, int r23, int r24, String r25, boolean r26) {
        this.j = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.k = r8;
        this.l = r11;
        this.m = r15;
        this.n = r16;
        this.o = r17 / r16;
        this.p = null;
        this.q = r10;
        this.r = nativeCreate(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public void a() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.r == 0) goto L6;
        this.j = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        this.k = 6;     // Catch: Throwable -> L8
        nativeDestroy(this.r);     // Catch: Throwable -> L8
        this.r = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    public void finalize() {
        super.finalize();     // Catch: Throwable -> L5
        a();
        return;
    L5:
        th = move-exception;
        a();
        throw th;
    }

    public void a(int r5, String r6, String r7) {
        if (this.r != 0) goto L5;
        return;
    L5:
        if (r5 < this.k) goto L21;
        if (r6 == null) goto L22;
        if (r7 != null) goto L9;
        return;
    L9:
        if (g == null) goto L17;
        com.bytedance.android.alog.e r0 = new com.bytedance.android.alog.e(r5, r6, r7);
        Iterator<com.bytedance.android.alog.c> r8 = g.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        r0 = ((com.bytedance.android.alog.c) ZeusTransformUtils.preCheckCast(r8.next(), com.bytedance.android.alog.c.class, "com.obric.aiagent.plugin")).a(r0);
        goto L12
    L14:
        if (r0 != null) goto L16;
        return;
    L16:
        nativeWrite(this.r, r0.f4107a, r0.f4108b, r0.f4109c);
        return;
    L17:
        nativeWrite(this.r, r5, r6, r7);
        return;
    L22:
        return;
    }

    public void a(int r13, String r14, String r15, long r16, long r18) {
        if (this.r != 0) goto L5;
        return;
    L5:
        if (r13 < this.k) goto L21;
        if (r14 == null) goto L22;
        if (r15 != null) goto L9;
        return;
    L9:
        if (g == null) goto L17;
        com.bytedance.android.alog.e r1 = new com.bytedance.android.alog.e(r13, r14, r15);
        Iterator<com.bytedance.android.alog.c> r2 = g.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        r1 = ((com.bytedance.android.alog.c) ZeusTransformUtils.preCheckCast(r2.next(), com.bytedance.android.alog.c.class, "com.obric.aiagent.plugin")).a(r1);
        goto L12
    L14:
        if (r1 != null) goto L16;
        return;
    L16:
        nativeWriteAsyncMsg(this.r, r1.f4107a, r1.f4108b, r1.f4109c, r16, r18);
        return;
    L17:
        nativeWriteAsyncMsg(this.r, r13, r14, r15, r16, r18);
        return;
    L22:
        return;
    }

    public void b() {
        long r0 = this.r;
        if (r0 == 0) goto L6;
        nativeAsyncFlush(r0);
        return;
    }

    public void a(boolean r5) {
        long r0 = this.r;
        if (r0 == 0) goto L6;
        nativeSetSyslog(r0, r5);
        return;
    }

    public long c() {
        if (this.r != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyWriteFuncAddr();
    }

    public void a(String r2, String r3) {
        a(0, r2, r3);
    }

    public void b(String r2, String r3) {
        a(1, r2, r3);
    }

    public void c(String r2, String r3) {
        a(2, r2, r3);
    }

    public void d(String r2, String r3) {
        a(3, r2, r3);
    }

    public void e(String r2, String r3) {
        a(4, r2, r3);
    }

    public File[] a(String r8, String r9, long r10, long r12) {
        return com.bytedance.android.alog.a.a(this.l, r8, r9, r10, r12);
    }

    public HashMap<String, String> d() {
        return com.bytedance.android.alog.a.a();
    }

    public long e() {
        return this.r;
    }
}
