package com.bytedanceos.common.core.install;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.os.Build;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.d;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.DeviceType;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.k;
import com.bytedanceos.common.utils.PerformanceMonitor;
import com.ttnet.org.chromium.net.NetError;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public class PackageInstallDispatcher extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PackageInstallListener f9633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BlockingQueue f9634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f9635c;

    public interface PackageInstallListener {
        void onInstallFinished(AppInfo r10, int r11);
    }

    public static /* synthetic */ class a {
    }

    public class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayMap f9636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PackageInstallDispatcher f9637b;

        public class a implements Observable.OnSubscribe {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Intent f9638a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f9639b;

            public a(b r10, Intent r11) {
                this.f9639b = r10;
                this.f9638a = r11;
            }

            public void a(Subscriber r10) {
            L15:
                th = move-exception;
                monitor-enter(this.f9639b.f9637b);
                this.f9639b.f9637b.notifyAll();     // Catch: Throwable -> L52
                throw th;
            L52:
                th = move-exception;
                throw th;
            L17:
                e = move-exception;
                j.n("[AppStatus][PackageInstallDispatcher][InstallStatusReceiver] " + e.getMessage());     // Catch: Throwable -> L15
                monitor-enter(this.f9639b.f9637b);
                this.f9639b.f9637b.notifyAll();     // Catch: Throwable -> L44
                return;
            L44:
                th = move-exception;
                throw th;
            L3:
                if (TextUtils.equals("com.bytedance.common.ACTION_INSTALL_STATUS", this.f9638a.getAction()) == false) goto L30;
                int r11 = this.f9638a.getIntExtra("android.content.pm.extra.LEGACY_STATUS", -99);     // Catch: Throwable -> L15 Exception -> L17
                String r12 = this.f9638a.getStringExtra("android.content.pm.extra.PACKAGE_NAME");     // Catch: Throwable -> L15 Exception -> L17
                AppInfo r13 = b.c(this.f9639b, r12);     // Catch: Throwable -> L15 Exception -> L17
                if (r13 != null) goto L20;
                j.n("[AppStatus][PackageInstallDispatcher][InstallStatusReceiver] app info miss:" + r12 + ", return code = " + r11);     // Catch: Throwable -> L15 Exception -> L17
                PackageInstallDispatcher r14 = this.f9639b.f9637b;
                monitor-enter(r14);
                this.f9639b.f9637b.notifyAll();     // Catch: Throwable -> L12
                monitor-exit(r14);     // Catch: Throwable -> L12
                return;
            L12:
                th = move-exception;
                throw th;
            L20:
                if (r11 == 1) goto L28;
                StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L15 Exception -> L17
                r15.append("[AppStatus][PackageInstallDispatcher][InstallStatusReceiver] install failed: [" + r12 + "]/[" + r13.appPackageName + "]returnCode = " + r11);     // Catch: Throwable -> L15 Exception -> L17
                r15.append("[url:" + r13.appDownloadUrl + "]");     // Catch: Throwable -> L15 Exception -> L24
                r15.append("[path:" + r13.downloadFilePath + "]");     // Catch: Throwable -> L15 Exception -> L24
                r15.append("[Md5:" + k.e(new File(r13.downloadFilePath)) + "]");     // Catch: Throwable -> L15 Exception -> L24
            L26:
                j.n(r15.toString());     // Catch: Throwable -> L15 Exception -> L17
            L24:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L15 Exception -> L17
                r15.append("[exception:" + e.getMessage() + "]");     // Catch: Throwable -> L15 Exception -> L17
            L28:
                if (PackageInstallDispatcher.a(this.f9639b.f9637b) == null) goto L30;
                j.n("[AppStatus][PackageInstallDispatcher][InstallStatusReceiver] mInstallListener.onInstallFinished returnCode " + r11);     // Catch: Throwable -> L15 Exception -> L17
                PackageInstallDispatcher.a(this.f9639b.f9637b).onInstallFinished(r13, r11);     // Catch: Throwable -> L15 Exception -> L17
            L30:
                PackageInstallDispatcher r16 = this.f9639b.f9637b;
                monitor-enter(r16);
                this.f9639b.f9637b.notifyAll();     // Catch: Throwable -> L35
                monitor-exit(r16);     // Catch: Throwable -> L35
                return;
            L35:
                th = move-exception;
                throw th;
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Subscriber r10) {
                a(r10);
            }
        }

        public b(PackageInstallDispatcher r10) {
            this.f9637b = r10;
            this.f9636a = new ArrayMap();
        }

        public static /* synthetic */ void a(b r10, AppInfo r11) {
            r10.d(r11);
        }

        public static /* synthetic */ void b(b r10, AppInfo r11) {
            r10.f(r11);
        }

        public static /* synthetic */ AppInfo c(b r10, String r11) {
            return r10.e(r11);
        }

        public final void d(AppInfo r10) {
            this.f9636a.put(r10.appPackageName, r10);
        }

        public final AppInfo e(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L12;
            if (DeviceType.isOneOf(new DeviceType[]{DeviceType.U1}) == false) goto L7;
        L8:
            Iterator r11 = this.f9636a.values().iterator();
            if (r11.hasNext() == false) goto L14;
            AppInfo r12 = (AppInfo) r11.next();
            j.n("PackageInstallDispatcher find app:" + r10);
            return r12;
        L14:
            return null;
        L7:
            if (this.f9636a.size() == 1) goto L8;
            return null;
        L12:
            return (AppInfo) this.f9636a.get(r10);
        }

        public final void f(AppInfo r10) {
            this.f9636a.remove(r10.appPackageName);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            Observable.y(new a(this, r11)).s(pg.a.c()).o();
        }

        public /* synthetic */ b(PackageInstallDispatcher r10, a r11) {
            this(r10);
        }
    }

    public PackageInstallDispatcher(BlockingQueue r10, PackageInstallListener r11) {
        this.f9634b = null;
        this.f9635c = false;
        this.f9634b = r10;
        this.f9633a = r11;
    }

    public static /* synthetic */ PackageInstallListener a(PackageInstallDispatcher r10) {
        return r10.f9633a;
    }

    public final void b(AppInfo r10, boolean r11) {
        PerformanceMonitor.b(r10.appPackageName);
        PackageInstaller.Session r12 = null;
        j.n("[AppStatus][PackageInstallDispatcher] installing begin packageName =" + r10.appPackageName + ",path:" + r10.downloadFilePath + ", isAutoDownload: " + r10.isAutoDownload + ", retry: " + r11);     // Catch: Throwable -> L6 Exception -> L8
        PackageInstaller r13 = BaseApplication.c().getPackageManager().getPackageInstaller();     // Catch: Throwable -> L6 Exception -> L8
        PackageInstaller.SessionParams r14 = new PackageInstaller.SessionParams(1);     // Catch: Throwable -> L6 Exception -> L8
        r14.installFlags = r14.installFlags | r10.mInstallFlag;     // Catch: Throwable -> L6 Exception -> L8
        PackageInfo r15 = e.V(BaseApplication.c(), r10.downloadFilePath, 8192);     // Catch: Throwable -> L6 Exception -> L8
        if (r15 == null) goto L10;
        r14.setInstallLocation(r15.installLocation);     // Catch: Throwable -> L6 Exception -> L8
    L10:
        r14.setInstallReason(4);     // Catch: Throwable -> L6 Exception -> L8
        int r16 = r13.createSession(r14);     // Catch: Throwable -> L6 Exception -> L8
        PackageInstaller.Session r17 = r13.openSession(r16);     // Catch: Throwable -> L6 Exception -> L8
        d(r17, r10.downloadFilePath, r10.appPackageName + ".apk", r10);     // Catch: Throwable -> L6 Exception -> L8
        if (TextUtils.isEmpty(r10.mMemFilePath) == true) goto L14;
        j.n("[AppStatus][PackageInstallDispatcher]  writeSplitToInstallSession memFilePath " + r10.mMemFilePath);     // Catch: Throwable -> L6 Exception -> L8
        d(r17, r10.mMemFilePath, r10.appPackageName + "_mem_info.dm", r10);     // Catch: Throwable -> L6 Exception -> L8
    L14:
        if (TextUtils.isEmpty(r10.mDmFilePath) == true) goto L16;
        j.n("[AppStatus][PackageInstallDispatcher]  writeSplitToInstallSession dmFilePath " + r10.mDmFilePath);     // Catch: Throwable -> L6 Exception -> L8
        d(r17, r10.mDmFilePath, r10.appPackageName + ".dm", r10);     // Catch: Throwable -> L6 Exception -> L8
    L16:
        Intent r18 = new Intent("com.bytedance.common.ACTION_INSTALL_STATUS");     // Catch: Throwable -> L6 Exception -> L8
        r18.setPackage(BaseApplication.c().getPackageName());     // Catch: Throwable -> L6 Exception -> L8
        r17.commit(PendingIntent.getBroadcast(BaseApplication.c(), 0, r18, 1107296256).getIntentSender());     // Catch: Throwable -> L6 Exception -> L8
        j.n("[AppStatus][PackageInstallDispatcher] waiting for installing " + r10.appPackageName + " sessionId " + r16);     // Catch: Throwable -> L6 Exception -> L8
        monitor-enter(this);     // Catch: Throwable -> L6 Exception -> L8
        wait(180000);     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        j.n("[AppStatus][PackageInstallDispatcher]  waiting for installing after three minutes " + r10.appPackageName);     // Catch: Throwable -> L6 Exception -> L8
        if (r10.isAutoDownload == false) goto L24;
        j.n("[AppStatus][PackageInstallDispatcher]  sleep 60s to install next," + r10.appPackageName);     // Catch: Throwable -> L6 Exception -> L8
        Thread.sleep(60000);     // Catch: Throwable -> L6 Exception -> L8
    L24:
        r17.close();
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L6 Exception -> L8
    L6:
        th = move-exception;
        if (0 == 0) goto L32;
        r12.close();
    L32:
        throw th;
    L8:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    }

    public void c() {
        this.f9635c = true;
        interrupt();
    }

    public final void d(PackageInstaller.Session r10, String r11, String r12, AppInfo r13) {
        j.n("[AppStatus][PackageInstallDispatcher]  inPath: " + r11 + " splitName: " + r12);
        File r14 = new File(r11);
        if (r14.isFile() == false) goto L52;
        long r15 = r14.length();
        FileInputStream r16 = null;
        OutputStream r17 = null;
        r17 = null;
        r16 = null;
        FileInputStream r18 = new FileInputStream(r11);     // Catch: Throwable -> L24 IOException -> L26
    L60:
        r17 = r10.openWrite(r12, 0, r15);     // Catch: Throwable -> L11 IOException -> L13
        byte[] r19 = new byte[65536];     // Catch: Throwable -> L11 IOException -> L13
        int r20 = 0;
    L8:
        int r21 = r18.read(r19);     // Catch: Throwable -> L11 IOException -> L13
        if (r21 == (-1)) goto L15;
        r20 = r20 + r21;     // Catch: Throwable -> L11 IOException -> L13
        r17.write(r19, 0, r21);     // Catch: Throwable -> L11 IOException -> L13
        goto L8
    L15:
        r10.fsync(r17);     // Catch: Throwable -> L11 IOException -> L13
        j.n("[AppStatus][PackageInstallDispatcher]  Success: streamed " + r20 + " inPath " + r11);     // Catch: Throwable -> L11 IOException -> L13
        r18.close();     // Catch: IOException -> L19
        if (r17 == null) goto L21;
        r17.close();     // Catch: IOException -> L19
    L21:
        r10.close();     // Catch: IOException -> L19
        return;
    L13:
        e = e;
        OutputStream r110 = r17;
        r16 = r18;
    L54:
        j.n("[AppStatus][PackageInstallDispatcher] Error: failed to write; " + e.getMessage());     // Catch: Throwable -> L32
        if (this.f9633a == null) goto L34;
        j.n("[AppStatus][PackageInstallDispatcher] writeSplitToInstallSession onInstallFinished  PackageManager.INSTALL_FAILED_ABORTED ");     // Catch: Throwable -> L32
        this.f9633a.onInstallFinished(r13, NetError.ERR_PROXY_AUTH_UNSUPPORTED);     // Catch: Throwable -> L32
    L34:
        if (r16 == null) goto L36;
        r16.close();     // Catch: IOException -> L19
    L36:
        if (r110 == null) goto L38;
        r110.close();     // Catch: IOException -> L19
    L38:
        if (r10 == null) goto L64;
        r10.close();     // Catch: IOException -> L19
        return;
    L64:
        return;
    L32:
        th = th;
    L41:
        if (r16 != null) goto L56;
    L45:
        if (r110 == null) goto L47;
        r110.close();     // Catch: IOException -> L43
    L47:
        if (r10 == null) goto L51;
        r10.close();     // Catch: IOException -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L56:
        r16.close();     // Catch: IOException -> L43
    L11:
        th = th;
        r110 = r17;
        r16 = r18;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L26:
        e = e;
        r110 = null;
    L24:
        th = th;
        r110 = null;
        goto L41
    L52:
        j.n("[AppStatus][PackageInstallDispatcher] is not file: ");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a r10 = null;
        b r11 = null;
        AppInfo r12 = null;
    L4:
        if (this.f9635c == true) goto L78;
        AppInfo r13 = (AppInfo) this.f9634b.take();     // Catch: Throwable -> L45 Exception -> L47
        j.n("[AppStatus][PackageInstallDispatcher] install task dequeue. " + d.a(r13));     // Catch: Throwable -> L34 Exception -> L42
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.U1}) == true) goto L9;
        if (r11 == null) goto L9;
    L20:
        b.a(r11, r13);     // Catch: Throwable -> L34 Exception -> L42
        j.n("[AppStatus][PackageInstallDispatcher] install task start. " + d.a(r13));     // Catch: Throwable -> L34 Exception -> L42
        int r14 = 1;
    L22:
        if (r14 != 1) goto L24;
        boolean r15 = true;
    L80:
        b(r13, r15);     // Catch: Throwable -> L34 Exception -> L36
        j.n("[AppStatus][PackageInstallDispatcher] install task end. " + d.a(r13));
        if (r13 == null) goto L30;
        b.b(r11, r13);
        j.n("PackageInstallDispatcher installing finish," + r13.appPackageName);
    L30:
        if (this.f9634b.size() != 0) goto L33;
        BaseApplication.c().unregisterReceiver(r11);
    L32:
        r11 = null;
    L33:
        r12 = r13;
    L36:
        e = move-exception;
        j.n("[AppStatus][PackageInstallDispatcher] install task err. " + d.a(r13) + ", err: " + e.getMessage());     // Catch: Throwable -> L34 Exception -> L42
        if (this.f9635c == true) goto L44;
        if (r14 >= 3) goto L44;
        e.printStackTrace();     // Catch: Throwable -> L34 Exception -> L42
        j.n("[AppStatus][PackageInstallDispatcher] install task retry in 5 sec. " + d.a(r13) + ", retryCount " + r14);     // Catch: Throwable -> L34 Exception -> L42
        Thread.sleep(PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);     // Catch: Throwable -> L34 Exception -> L42
        r14 = r14 + 1;     // Catch: Throwable -> L34 Exception -> L42
    L44:
        throw e;     // Catch: Throwable -> L34 Exception -> L42
    L24:
        r15 = false;
    L9:
        b r16 = new b(this, r10);     // Catch: Throwable -> L34 Exception -> L42
        IntentFilter r17 = new IntentFilter("com.bytedance.common.ACTION_INSTALL_STATUS");     // Catch: Throwable -> L13 Exception -> L16
        if (Build.VERSION.SDK_INT < 33) goto L18;
        BaseApplication.c().registerReceiver(r16, r17, 2);     // Catch: Throwable -> L13 Exception -> L16
    L19:
        r11 = r16;
        goto L20
    L18:
        BaseApplication.c().registerReceiver(r16, r17);     // Catch: Throwable -> L13 Exception -> L16
        goto L19
    L13:
        th = th;
        r11 = r16;
    L15:
        r12 = r13;
    L70:
        j.n("[AppStatus][PackageInstallDispatcher] install task end. " + d.a(r12));
        if (r11 == null) goto L77;
        if (r12 == null) goto L75;
        b.b(r11, r12);
        j.n("PackageInstallDispatcher installing finish," + r12.appPackageName);
    L75:
        if (this.f9634b.size() != 0) goto L77;
        BaseApplication.c().unregisterReceiver(r11);
    L77:
        throw th;
    L16:
        Exception e10 = e;
    L49:
        e10.printStackTrace();     // Catch: Throwable -> L13
        j.n("[AppStatus][PackageInstallDispatcher] loop err. mQuit   " + this.f9635c + "  " + e10.getMessage());     // Catch: Throwable -> L13
        if (this.f9635c == true) goto L51;
        if (this.f9633a == null) goto L62;
        j.n("[AppStatus][PackageInstallDispatcher]  loop err, report onInstallFinished  PackageManager.INSTALL_FAILED_ABORTED ");     // Catch: Throwable -> L13
        this.f9633a.onInstallFinished(r13, NetError.ERR_PROXY_AUTH_UNSUPPORTED);     // Catch: Throwable -> L13
    L62:
        j.n("[AppStatus][PackageInstallDispatcher] install task end. " + d.a(r13));
        if (r16 == null) goto L69;
        if (r13 == null) goto L67;
        b.b(r16, r13);
        j.n("PackageInstallDispatcher installing finish," + r13.appPackageName);
    L67:
        if (this.f9634b.size() != 0) goto L69;
        BaseApplication.c().unregisterReceiver(r16);
    L69:
        r11 = r16;
        goto L33
    L51:
        j.n("[AppStatus][PackageInstallDispatcher] install task end. " + d.a(r13));
        if (r16 == null) goto L98;
        if (r13 == null) goto L56;
        b.b(r16, r13);
        j.n("PackageInstallDispatcher installing finish," + r13.appPackageName);
    L56:
        if (this.f9634b.size() != 0) goto L99;
        BaseApplication.c().unregisterReceiver(r16);
        return;
    L99:
        return;
    L98:
        return;
    L42:
        e = move-exception;
        r16 = r11;
        e10 = e;
    L34:
        th = th;
        goto L15
    L47:
        e = move-exception;
        AppInfo r18 = r12;
        r16 = r11;
        e10 = e;
        r13 = r18;
    L45:
        th = th;
        goto L70
    L78:
        j.n("PackageInstallDispatcher exit install thread,size:" + this.f9634b.size());
    }
}
