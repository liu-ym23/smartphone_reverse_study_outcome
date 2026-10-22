package com.obric.common.upgrade.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.common.upgrade.VersionCheckResponse;
import com.obric.common.upgrade.e;
import com.obric.common.upgrade.util.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.ab;
import okhttp3.ad;

/* JADX INFO: compiled from: UpgradeFileManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0893a f32601a = null;
    private static volatile a h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f32602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private VersionCheckResponse f32603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f32604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f32605e;
    private final f f;
    private final Object g;

    /* JADX INFO: renamed from: com.obric.common.upgrade.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UpgradeFileManager.kt */
    public static final class C0893a {
        public /* synthetic */ C0893a(h r1) {
            this();
        }

        private C0893a() {
        }

        public final a a(Context r4, VersionCheckResponse r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r6, "context");
            o.e(r5, "upgradeInfo");
            a r0 = a.c();
            if (r0 == null) goto L5;
            a.a(r0, r5);
        L10:
            return r0;
        L5:
            monitor-enter(this);
            r0 = a.c();     // Catch: Throwable -> L11
            if (r0 != null) goto L9;
            Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            o.c(r7, "context.applicationContext");     // Catch: Throwable -> L11
            r0 = new a(r7, r5, null);     // Catch: Throwable -> L11
            C0893a r8 = a.f32601a;     // Catch: Throwable -> L11
            a.b(r0);     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);
        L11:
            th = move-exception;
            throw th;
        }

        public final boolean a() {
            a r2 = a.c();
            if (r2 == null) goto L8;
            if (a.a(r2) != true) goto L8;
            return true;
        L8:
            return false;
        }
    }

    /* JADX INFO: compiled from: UpgradeFileManager.kt */
    static final class b extends p implements d.h.a.a<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f32606a;

        b(a r1) {
            this.f32606a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ File invoke() {
            return a();
        }

        public final File a() {
            File r0 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.c(this.f32606a), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getFilesDir(), "upgrade");
            if (r0.exists() == true) goto L5;
            r0.mkdirs();
        L5:
            return r0;
        }
    }

    static {
        f32601a = new C0893a(null);
    }

    public /* synthetic */ a(Context r2, VersionCheckResponse r3, h r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    private a(Context r3, VersionCheckResponse r4) {
        this.f32602b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f32603c = r4;
        this.f32604d = "OAppUpgrade";
        this.f = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.g = new Object();
    }

    public static final /* synthetic */ void a(a r0, VersionCheckResponse r1) {
        r0.f32603c = r1;
    }

    public static final /* synthetic */ boolean a(a r0) {
        return r0.f32605e;
    }

    public static final /* synthetic */ void b(a r0) {
        h = r0;
    }

    public static final /* synthetic */ Context c(a r0) {
        return r0.f32602b;
    }

    public static final /* synthetic */ a c() {
        return h;
    }

    private final File d() {
        return (File) ZeusTransformUtils.preCheckCast(this.f.b(), File.class, "com.obric.aiagent.plugin");
    }

    public final synchronized void a() {
        monitor-enter(this);
        File[] r0 = d().listFiles();     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        int r1 = 0;
        int r2 = r0.length;     // Catch: Throwable -> L11
    L6:
        if (r1 >= r2) goto L9;
        a(r0[r1]);     // Catch: Throwable -> L11
        r1 = r1 + 1;
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private final void a(File r3) {
        boolean r2 = true;
        if (r3 != null) goto L5;
    L7:
        r2 = false;
    L8:
        if (r2 == true) goto L10;
        return;
    L10:
        if (r3.delete() == true) goto L14;
        r3.deleteOnExit();
        return;
    L14:
        return;
    L5:
        if (r3.exists() != true) goto L7;
        goto L7
    }

    private final String a(String r6) {
        String r5 = d.o.o.d(r6, "/", null, 2, null);
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(".apk", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L5;
        return r5;
    L5:
        return d.o.o.c(r5, ".apk", null, 2, null) + ".apk";
    }

    public final synchronized File b() {
        monitor-enter(this);
        a(this.f32604d, "升级弹窗 upgradeInfo：" + this.f32603c);     // Catch: Throwable -> L13
        String r0 = this.f32603c.getApkUrl();     // Catch: Throwable -> L13
        File r2 = null;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L8;
        b(this.f32604d, "invoke method getApk , but the apkUrl is null");     // Catch: Throwable -> L13
        monitor-exit(this);
        return null;
    L8:
        String r1 = a(r0);     // Catch: Throwable -> L13
        File r3 = new File(d(), r1);     // Catch: Throwable -> L13
        a(this.f32604d, "升级弹窗 ，apkName：" + r1 + " download_url: " + r0 + ",mCacheDir:" + d() + "，apkFile：" + r3 + "，apkFile.exists()：" + r3.exists());     // Catch: Throwable -> L13
        if (r3.exists() == false) goto L11;
        r2 = r3;
    L11:
        monitor-exit(this);
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    public final boolean a(com.obric.common.upgrade.g r22) {
        com.obric.common.upgrade.g r2 = (com.obric.common.upgrade.g) ZeusTransformUtils.wrapperContextForParams(r22, com.obric.common.upgrade.g.class, "com.obric.aiagent.plugin");
        o.e(r2, "callback");
        Object r3 = this.g;
        monitor-enter(r3);
        File r0 = b();     // Catch: Throwable -> L32
        if (r0 == null) goto L9;
        this.f32603c.setApkPath(r0.getAbsolutePath());     // Catch: Throwable -> L32
        this.f32603c.setNewDownload(false);     // Catch: Throwable -> L32
        r2.a(this.f32603c);     // Catch: Throwable -> L32
        monitor-exit(r3);
        return true;
    L9:
        c.f32650a.b("download apk begin");     // Catch: Throwable -> L32
        a();     // Catch: Throwable -> L32
        String r1 = this.f32603c.getApkUrl();     // Catch: Throwable -> L32
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L13;
        monitor-exit(r3);
        return false;
    L13:
        c.f32650a.b("upgrade_downloadapk_start");     // Catch: Throwable -> L32
        com.obric.common.upgrade.d.a.a(com.obric.common.upgrade.d.a.f32620a.a(), 2, this.f32603c.getTaskId(), e.f32625a.a().a().c(), this.f32603c.getVersionCode(), null, 16, null);     // Catch: Throwable -> L32
        ab r6 = new ab.a().a(r1).b();     // Catch: Throwable -> L32
        String r7 = a(r1);     // Catch: Throwable -> L32
        File r8 = new File(d(), r7);     // Catch: Throwable -> L32
        File r9 = new File(d(), r7 + "_temp");     // Catch: Throwable -> L32
        this.f32605e = true;     // Catch: Throwable -> L25
        ad r10 = com.obric.common.upgrade.util.e.f32653a.a().a(r6).b();     // Catch: Throwable -> L25
        o.c(r10, "response");     // Catch: Throwable -> L25
        a(r10, r9, r2, r1);     // Catch: Throwable -> L25
        String r4 = com.obric.common.upgrade.util.b.f32649a.a(r9);     // Catch: Throwable -> L25
        if (d.o.o.a(r4, this.f32603c.getMd5(), true) == false) goto L24;
        if (r9.renameTo(r8) == true) goto L19;
        a(r9, r8);     // Catch: Throwable -> L25
        a(r9);     // Catch: Throwable -> L25
        c.f32650a.b("renameTo fail . path =" + r8.getAbsolutePath());     // Catch: Throwable -> L25
    L19:
        this.f32603c.setApkPath(r8.getAbsolutePath());     // Catch: Throwable -> L25
        this.f32603c.setNewDownload(true);     // Catch: Throwable -> L25
        com.obric.common.upgrade.d.a.a(com.obric.common.upgrade.d.a.f32620a.a(), 3, this.f32603c.getTaskId(), e.f32625a.a().a().c(), this.f32603c.getVersionCode(), null, 16, null);     // Catch: Throwable -> L25
        r2.a(this.f32603c);     // Catch: Throwable -> L25
        c.f32650a.b("download apk success . path =" + r8.getAbsolutePath());     // Catch: Throwable -> L25
        this.f32605e = false;     // Catch: Throwable -> L32
        monitor-exit(r3);
        return true;
    L24:
        throw new Throwable("md5 check  error , tmpFile md5 =" + r4 + ", info md5 =" + this.f32603c.getMd5());     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        a(r8);     // Catch: Throwable -> L32
        a(r9);     // Catch: Throwable -> L32
        a(this.f32604d, "download apk error", th);     // Catch: Throwable -> L32
        com.obric.common.upgrade.d.a r11 = com.obric.common.upgrade.d.a.f32620a.a();     // Catch: Throwable -> L32
        long r12 = this.f32603c.getTaskId();     // Catch: Throwable -> L32
        long r13 = e.f32625a.a().a().c();     // Catch: Throwable -> L32
        long r14 = this.f32603c.getVersionCode();     // Catch: Throwable -> L32
        String r5 = th.getMessage();     // Catch: Throwable -> L32
        if (r5 != null) goto L29;
        r5 = "";
    L29:
        r11.b(4, r12, r13, r14, r5);     // Catch: Throwable -> L32
        r2.a(-4, "网络下载过程中失败 " + th.getMessage());     // Catch: Throwable -> L32
        this.f32605e = false;     // Catch: Throwable -> L32
        return false;
    L32:
        th = move-exception;
        throw th;
    }

    private final void a(File r9, File r10) {
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r9), Closeable.class, "com.obric.aiagent.plugin");
        FileInputStream r11 = (FileInputStream) ZeusTransformUtils.preCheckCast(r8, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r10), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        FileOutputStream r1 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r12, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        r11.getChannel().transferTo(0, r11.getChannel().size(), (WritableByteChannel) ZeusTransformUtils.preCheckCast(r1.getChannel(), WritableByteChannel.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
    L6:
        d.f.c.a(r12, null);     // Catch: Throwable -> L14
        d.f.c.a(r8, null);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        d.f.c.a(r12, th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        d.f.c.a(r8, th);
        throw th;
    }

    private final void a(ad r22, File r23, com.obric.common.upgrade.g r24, String r25) {
        com.obric.common.upgrade.g r0 = (com.obric.common.upgrade.g) ZeusTransformUtils.wrapperContextForParams(r24, com.obric.common.upgrade.g.class, "com.obric.aiagent.plugin");
        InputStream r2 = r22.g().e();
        if (r2 == null) goto L49;
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.aiagent.plugin");
        InputStream r10 = (InputStream) ZeusTransformUtils.preCheckCast(r9, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        OutputStream r3 = (OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r23), OutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        if (ZeusTransformUtils.instanceOf(r3, BufferedOutputStream.class) == false) goto L8;
        BufferedOutputStream r4 = (BufferedOutputStream) ZeusTransformUtils.preCheckCast(r3, BufferedOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
    L9:
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        BufferedOutputStream r1 = (BufferedOutputStream) ZeusTransformUtils.preCheckCast(r11, BufferedOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        long r12 = r22.g().c();     // Catch: Throwable -> L36
        byte[] r14 = new byte[1024];     // Catch: Throwable -> L36
        int r5 = 0;
        long r6 = 0;
    L11:
        int r7 = r10.read(r14);     // Catch: Throwable -> L36
        if (r7 == (-1)) goto L25;
        r1.write(r14, 0, r7);     // Catch: Throwable -> L36
        long r8 = r6 + ((long) r7);     // Catch: Throwable -> L36
        if (r12 < 0) goto L24;
        int r13 = 100;
        if (r12 == r8) goto L19;
        r13 = (int) (((r8 * 1.0f) / r12) * 100);     // Catch: Throwable -> L36
    L19:
        if (r13 != 0) goto L21;
        r13 = 1;
    L21:
        int r15 = r13;
        if (r5 == r15) goto L24;
        r0.a(r15, r8, r12, r25);     // Catch: Throwable -> L36
        r6 = r8;
        r5 = r15;
    L24:
        r6 = r8;
        goto L11
    L25:
        r1.flush();     // Catch: Throwable -> L36
        if (r12 > 0) goto L28;
    L32:
        x r16 = x.f38692a;     // Catch: Throwable -> L36
        d.f.c.a(r11, null);     // Catch: Throwable -> L43
        x r17 = x.f38692a;     // Catch: Throwable -> L43
        d.f.c.a(r9, null);
        goto L49
    L28:
        if (r12 == r6) goto L32;
        throw new Throwable("io error , totalLength != sum");     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        d.f.c.a(r11, th);     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L8:
        r4 = new BufferedOutputStream(r3, 8192);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        d.f.c.a(r9, th);
        throw th;
    L49:
        r22.close();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
