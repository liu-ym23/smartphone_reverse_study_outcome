package com.obric.android.alog;

import android.content.Context;
import android.text.TextUtils;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Alog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f22402a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f22403b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f22404c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f22405d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f22406e = 0;
    private static final int f = 0;
    private static volatile List<com.obric.android.alog.b> g;
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
        public static final a f22407a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f22408b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f22409c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f22410e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f22411d;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f22410e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("NONE", 0, 0);
            f22407a = r0;
            a r1 = new a("EC_SECP256K1", 1, 1);
            f22408b = r1;
            a r3 = new a("EC_SECP256R1", 2, 2);
            f22409c = r3;
            f22410e = new a[]{r0, r1, r3};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f22411d = r3;
        }

        int a() {
            return this.f22411d;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f22412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f22413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f22414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f22415d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f22416e;
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

        public b(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f22413b = 0;
            this.f22414c = false;
            this.f22415d = null;
            this.f22416e = null;
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
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L5;
            r5 = r0;
        L5:
            this.f22412a = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        }

        public b a(int r1) {
            this.f22413b = r1;
            return this;
        }

        public b a(boolean r1) {
            this.f22414c = r1;
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
            this.f22415d = r4;
            goto L13
        }

        public b b(String r1) {
            this.f22416e = r1;
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

        public Alog a() {
            if (this.f22415d != null) goto L5;
            this.f22415d = DownloadSettingKeys.BugFix.DEFAULT;
        L5:
            ArrayList r1 = Alog.l();
            monitor-enter(r1);
            Iterator r2 = Alog.l().iterator();     // Catch: Throwable -> L36
        L9:
            if (r2.hasNext() == false) goto L14;
            if (((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin")).equals(this.f22415d) == false) goto L9;
            monitor-exit(r1);     // Catch: Throwable -> L36
            return null;
        L14:
            Alog.l().add(this.f22415d);     // Catch: Throwable -> L36
            monitor-exit(r1);     // Catch: Throwable -> L36
            if (this.f22416e != null) goto L23;
            File r3 = this.f22412a.getExternalFilesDir(null);
            if (r3 == null) goto L21;
            this.f22416e = r3.getPath() + "/alog";
            goto L23
        L21:
            this.f22416e = this.f22412a.getFilesDir() + "/alog";
        L23:
            if (this.i != null) goto L26;
            this.i = this.f22412a.getFilesDir() + "/alog";
        L26:
            if (this.l != null) goto L28;
            this.l = com.obric.android.alog.e.a(this.f22412a);
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
            return new Alog(this.f22412a, this.f22413b, this.f22414c, this.f22415d, this.f22416e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s);
        L36:
            th = move-exception;
            throw th;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f22417a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f22418b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f22419c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ c[] f22420e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f22421d;

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f22420e.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        static {
            c r0 = new c("NONE", 0, 0);
            f22417a = r0;
            c r1 = new c("ZLIB", 1, 1);
            f22418b = r1;
            c r3 = new c("ZSTD", 2, 2);
            f22419c = r3;
            f22420e = new c[]{r0, r1, r3};
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
            this.f22421d = r3;
        }

        int a() {
            return this.f22421d;
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f22422a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f22423b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d[] f22424d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f22425c;

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f22424d.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        static {
            d r0 = new d("SPEED", 0, 0);
            f22422a = r0;
            d r1 = new d("SAFE", 1, 1);
            f22423b = r1;
            f22424d = new d[]{r0, r1};
        }

        private d(String r1, int r2, int r3) {
            super(r1, r2);
            this.f22425c = r3;
        }

        int a() {
            return this.f22425c;
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f22426a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f22427b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ e[] f22428d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f22429c;

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f22428d.clone(), e[].class, "com.obric.aiagent.plugin");
        }

        static {
            e r0 = new e("DEFAULT", 0, 0);
            f22426a = r0;
            e r1 = new e("LEGACY", 1, 1);
            f22427b = r1;
            f22428d = new e[]{r0, r1};
        }

        private e(String r1, int r2, int r3) {
            super(r1, r2);
            this.f22429c = r3;
        }

        int a() {
            return this.f22429c;
        }
    }

    public static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f22430a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f22431b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f22432c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final f f22433d = null;
        private static final /* synthetic */ f[] f = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f22434e;

        public static f valueOf(String r2) {
            return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
        }

        public static f[] values() {
            return (f[]) ZeusTransformUtils.preCheckCast(f.clone(), f[].class, "com.obric.aiagent.plugin");
        }

        static {
            f r0 = new f("NONE", 0, 0);
            f22430a = r0;
            f r1 = new f("TEA_16", 1, 1);
            f22431b = r1;
            f r3 = new f("TEA_32", 2, 2);
            f22432c = r3;
            f r5 = new f("TEA_64", 3, 3);
            f22433d = r5;
            f = new f[]{r0, r1, r3, r5};
        }

        private f(String r1, int r2, int r3) {
            super(r1, r2);
            this.f22434e = r3;
        }

        int a() {
            return this.f22434e;
        }
    }

    public static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f22435a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f22436b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ g[] f22437d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f22438c;

        public static g valueOf(String r2) {
            return (g) ZeusTransformUtils.preCheckCast(Enum.valueOf(g.class, r2), g.class, "com.obric.aiagent.plugin");
        }

        public static g[] values() {
            return (g[]) ZeusTransformUtils.preCheckCast(f22437d.clone(), g[].class, "com.obric.aiagent.plugin");
        }

        static {
            g r0 = new g("RAW", 0, 1);
            f22435a = r0;
            g r1 = new g("ISO_8601", 1, 1);
            f22436b = r1;
            f22437d = new g[]{r0, r1};
        }

        private g(String r1, int r2, int r3) {
            super(r1, r2);
            this.f22438c = r3;
        }

        int a() {
            return this.f22438c;
        }
    }

    private static native void nativeAsyncFlush(long r0);

    private static native long nativeCreate(int r0, boolean r1, String r2, String r3, int r4, int r5, int r6, String r7, int r8, int r9, String r10, int r11, int r12, int r13, int r14, int r15, int r16, String r17);

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
        return f22402a;
    }

    static /* synthetic */ int g() {
        return f22403b;
    }

    static /* synthetic */ int h() {
        return f22404c;
    }

    static /* synthetic */ int i() {
        return f22405d;
    }

    static /* synthetic */ int j() {
        return f22406e;
    }

    static /* synthetic */ int k() {
        return f;
    }

    static /* synthetic */ ArrayList l() {
        return h;
    }

    static {
        f22402a = d.f22423b.a();
        f22403b = g.f22435a.a();
        f22404c = e.f22426a.a();
        f22405d = c.f22419c.a();
        f22406e = f.f22431b.a();
        f = a.f22408b.a();
        g = null;
        h = new ArrayList();
        i = false;
    }

    public static synchronized void a(com.obric.android.alog.a r3) {
        monitor-enter(Alog.class);
        com.obric.android.alog.a r4 = (com.obric.android.alog.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.android.alog.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (i == false) goto L8;
        monitor-exit(Alog.class);
        return;
    L8:
        if (r4 != null) goto L10;
        System.loadLibrary("oalog");     // Catch: Throwable -> L14
    L11:
        i = true;     // Catch: Throwable -> L14
        monitor-exit(Alog.class);
        return;
    L10:
        r4.a("oalog");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public Alog(Context r7, int r8, boolean r9, String r10, String r11, int r12, int r13, int r14, String r15, int r16, int r17, String r18, int r19, int r20, int r21, int r22, int r23, int r24, String r25) {
        this.j = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.k = r8;
        this.l = r11;
        this.m = r15;
        this.n = r16;
        this.o = r17 / r16;
        this.p = null;
        this.q = r10;
        this.r = nativeCreate(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
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
        com.obric.android.alog.d r0 = new com.obric.android.alog.d(r5, r6, r7);
        Iterator<com.obric.android.alog.b> r8 = g.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        r0 = ((com.obric.android.alog.b) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.android.alog.b.class, "com.obric.aiagent.plugin")).a(r0);
        goto L12
    L14:
        if (r0 != null) goto L16;
        return;
    L16:
        nativeWrite(this.r, r0.f22440a, r0.f22441b, r0.f22442c);
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
        com.obric.android.alog.d r1 = new com.obric.android.alog.d(r13, r14, r15);
        Iterator<com.obric.android.alog.b> r2 = g.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        r1 = ((com.obric.android.alog.b) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.android.alog.b.class, "com.obric.aiagent.plugin")).a(r1);
        goto L12
    L14:
        if (r1 != null) goto L16;
        return;
    L16:
        nativeWriteAsyncMsg(this.r, r1.f22440a, r1.f22441b, r1.f22442c, r16, r18);
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

    public void c() {
        long r0 = this.r;
        if (r0 == 0) goto L6;
        nativeSyncFlush(r0);
        return;
    }

    public void a(int r5) {
        this.k = r5;
        long r0 = this.r;
        if (r0 == 0) goto L6;
        nativeSetLevel(r0, r5);
        return;
    }

    public long d() {
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

    public long e() {
        return this.r;
    }
}
