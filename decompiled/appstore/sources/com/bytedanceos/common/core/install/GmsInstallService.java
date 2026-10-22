package com.bytedanceos.common.core.install;

import android.R;
import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.R$style;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.j;
import com.obric.capabilitykit.common.ErrorCode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class GmsInstallService extends Service implements PackageInstallDispatcher.PackageInstallListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Looper f9619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d f9620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile e f9621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinkedBlockingDeque f9622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PackageInstallDispatcher f9623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CountDownLatch f9624f;

    public static class StopGmsException extends Exception {
        private int mExceptionType;

        public StopGmsException(int r10, String r11) {
            super(r11);
            this.mExceptionType = r10;
        }

        public int getExceptionType() {
            return this.mExceptionType;
        }
    }

    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppInfo f9625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GmsInstallService f9626b;

        public a(GmsInstallService r10, AppInfo r11) {
            this.f9626b = r10;
            this.f9625a = r11;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
        L8:
            GmsInstallService.d(this.f9626b, r10, this.f9625a);
            StringBuilder r12 = new StringBuilder();
            r12.append("DownloadManager.remove:");
            AppInfo r13 = this.f9625a;
            if (r13 == null) goto L11;
            String r14 = r13.appPackageName;
        L12:
            r12.append(r14);
            j.a(r12.toString());
            return;
        L11:
            r14 = "";
            goto L12
        L3:
            if (this.f9625a != null) goto L6;
            j.e("GmsInstallService,the info is null");     // Catch: IllegalArgumentException -> L8
            return;
        L6:
            GmsInstallService.c(this.f9626b);     // Catch: IllegalArgumentException -> L8
            r10.cancel();     // Catch: IllegalArgumentException -> L8
            j.a("click ok btn:" + this.f9625a.appPackageName);     // Catch: IllegalArgumentException -> L8
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppInfo f9627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GmsInstallService f9628b;

        public b(GmsInstallService r10, AppInfo r11) {
            this.f9628b = r10;
            this.f9627a = r11;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            GmsInstallService.d(this.f9628b, r10, this.f9627a);
            StringBuilder r12 = new StringBuilder();
            r12.append("click cancel btn:");
            AppInfo r13 = this.f9627a;
            if (r13 == null) goto L5;
            String r14 = r13.appPackageName;
        L6:
            r12.append(r14);
            j.a(r12.toString());
            return;
        L5:
            r14 = "";
            goto L6
        }
    }

    public class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppInfo f9629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GmsInstallService f9630b;

        public c(GmsInstallService r10, AppInfo r11) {
            this.f9630b = r10;
            this.f9629a = r11;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r10) {
            GmsInstallService.d(this.f9630b, r10, this.f9629a);
            StringBuilder r11 = new StringBuilder();
            r11.append("click outside:");
            AppInfo r12 = this.f9629a;
            if (r12 == null) goto L5;
            String r13 = r12.appPackageName;
        L6:
            r11.append(r13);
            j.a(r11.toString());
            return;
        L5:
            r13 = "";
            goto L6
        }
    }

    public final class d extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GmsInstallService f9631a;

        public d(GmsInstallService r10, Looper r11) {
            this.f9631a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            Intent r11 = (Intent) r10.obj;
            int r12 = r11.getIntExtra("message_what", -1);
            AppInfo r13 = (AppInfo) r11.getSerializableExtra(DownloadInfoColumns.TABLE);
            if (r13 != null) goto L6;
            j.e("appinfo is null.");
            return;
        L6:
            j.a("msgWhat:" + r12);
            if (r12 != 1000) goto L9;
        L14:
            GmsInstallService.a(this.f9631a, r13, r10.arg1);
            return;
        L9:
            if (r12 != 1001) goto L11;
            GmsInstallService.b(this.f9631a, 1001, r13, r10.arg1);
            return;
        L11:
            if (r12 == 1004) goto L14;
        }
    }

    public final class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GmsInstallService f9632a;

        public e(GmsInstallService r10) {
            this.f9632a = r10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            if (r10.what != 2011) goto L6;
            this.f9632a.stopSelf();
            return;
        }

        public /* synthetic */ e(GmsInstallService r10, a r11) {
            this(r10);
        }
    }

    public GmsInstallService() {
        this.f9622d = new LinkedBlockingDeque();
        this.f9623e = null;
        this.f9624f = null;
    }

    public static /* synthetic */ void a(GmsInstallService r10, AppInfo r11, int r12) {
        r10.h(r11, r12);
    }

    public static /* synthetic */ void b(GmsInstallService r10, int r11, AppInfo r12, int r13) {
        r10.j(r11, r12, r13);
    }

    public static /* synthetic */ void c(GmsInstallService r10) {
        r10.k();
    }

    public static /* synthetic */ void d(GmsInstallService r10, DialogInterface r11, AppInfo r12) {
        r10.e(r11, r12);
    }

    public final void e(DialogInterface r10, AppInfo r11) {
        com.bytedanceos.common.toolbox.e.c();
        BaseApplication.c().b().k0(r11);
        k();
        r10.cancel();
    }

    public final void f(long r10) {
        List r11 = BaseApplication.c().b().v("DOWNLOAD");
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        AppInfo r14 = (AppInfo) r13.next();
        if (TextUtils.equals(r14.appPackageName, "com.bytedance.gms") == true) goto L7;
        if (r14.mIsNeedGms == false) goto L4;
        r12.add(Long.valueOf(r14.downloadId));
        goto L4
    L7:
        BaseApplication.c().b().k0(r14);
        goto L4
    L11:
        int r15 = r12.size();
        if (r15 <= 0) goto L17;
        long[] r16 = new long[r15];
        int r17 = 0;
    L14:
        if (r17 >= r15) goto L16;
        r16[r17] = ((Long) r12.get(r17)).longValue();
        r17 = r17 + 1;
        goto L14
    L16:
        q8.a.j(false, r16);
    L17:
        j.a("update downloads:size = " + r15);
    }

    public final ArrayList g(ArrayList r10) {
        HashMap r11 = new HashMap();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L25;
        File r13 = (File) r12.next();
        PackageInfo r14 = com.bytedanceos.common.toolbox.e.V(this, r13.getAbsolutePath(), 0);     // Catch: Exception -> L23
        if (r14 == null) goto L22;
        if (com.bytedanceos.common.toolbox.d.f10014f.contains(r14.packageName) == true) goto L10;
        j.a("delete:" + r13 + " | " + r13.delete());     // Catch: Exception -> L23
        goto L4
    L10:
        AppInfo r15 = new AppInfo();     // Catch: Exception -> L23
        r15.appName = r14.applicationInfo.name;     // Catch: Exception -> L23
        r15.appPackageName = r14.packageName;     // Catch: Exception -> L23
        r15.appVersionCode = r14.versionCode;     // Catch: Exception -> L23
        File r16 = new File(r13.getParentFile(), r14.packageName + "_bak.apk");     // Catch: Exception -> L23
        if (r16.exists() == false) goto L13;
        r16.delete();     // Catch: Exception -> L23
    L13:
        boolean r17 = r13.renameTo(r16);     // Catch: Exception -> L23
        if (r17 == true) goto L16;
        r17 = r13.renameTo(r16);     // Catch: Exception -> L23
    L16:
        if (r17 == false) goto L18;
        r15.downloadFilePath = r16.getAbsolutePath();     // Catch: Exception -> L23
        r11.put(r14.packageName, r15);     // Catch: Exception -> L23
        goto L4
    L18:
        r13.delete();     // Catch: Exception -> L23
        throw new StopGmsException(2013, "rename failed:" + r13.getAbsolutePath());     // Catch: Exception -> L23
    L22:
        throw new StopGmsException(2013, "no find package name:" + r13.getAbsolutePath());     // Catch: Exception -> L23
    L24:
        throw new StopGmsException(2013, "parse exception:" + r13.getAbsolutePath());
    L25:
        ArrayList r18 = new ArrayList();
        int r19 = 0;
    L26:
        List r20 = com.bytedanceos.common.toolbox.d.f10014f;
        if (r19 >= r20.size()) goto L50;
        String r21 = (String) r20.get(r19);
        PackageInfo r22 = getPackageManager().getPackageInfo(r21, 0);     // Catch: Exception -> L31
    L33:
        if (r22 == null) goto L35;
    L39:
        AppInfo r23 = (AppInfo) r11.get(r21);
        if (r23 == null) goto L45;
        if (r22 != null) goto L43;
    L44:
        r18.add(r23);
    L49:
        r19 = r19 + 1;
        goto L26
    L43:
        if (r22.versionCode < r23.appVersionCode) goto L44;
    L45:
        if (r23 == null) goto L49;
        if (TextUtils.isEmpty(r23.downloadFilePath) == true) goto L49;
        File r24 = new File(r23.downloadFilePath);
        r24.delete();
        j.a("delete old file:" + r24);
        goto L49
    L35:
        if (r11.containsKey(r21) == true) goto L39;
        throw new StopGmsException(2013, "app lost:" + r21);
    L31:
        e = move-exception;
        j.a(e.getMessage());
        r22 = null;
        goto L33
    L50:
        return r18;
    }

    public final void h(AppInfo r10, int r11) {
        if (r10 != null) goto L7;
        k();     // Catch: StopGmsException -> L5
        j.n("handleGmsDownloadSucess, the appinfo is null");     // Catch: StopGmsException -> L5
        return;
    L7:
        ArrayList r12 = g(l(r10));     // Catch: StopGmsException -> L5
        this.f9624f = new CountDownLatch(r12.size());     // Catch: StopGmsException -> L5
        Iterator r13 = r12.iterator();     // Catch: StopGmsException -> L5
    L9:
        if (r13.hasNext() == false) goto L23;
        i((AppInfo) r13.next());     // Catch: StopGmsException -> L5
        goto L9
    L23:
        this.f9624f.await(10, TimeUnit.MINUTES);     // Catch: StopGmsException -> L5 InterruptedException -> L14
    L16:
        f(r10.downloadId);     // Catch: StopGmsException -> L5
        k();     // Catch: StopGmsException -> L5
        return;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: StopGmsException -> L5
    L5:
        e = move-exception;
        e.printStackTrace();
        if (2016 != e.getExceptionType()) goto L21;
        k();
        return;
    L21:
        j(e.getExceptionType(), r10, r11);
    }

    public final void i(AppInfo r10) {
        if (r10 == null) goto L18;
        if (r10.downloadFilePath == null) goto L18;
        if (new File(r10.downloadFilePath).exists() == false) goto L18;
        if (((b0.n().p(r10.appPackageName, "com.bytedanceos.app.status", this) + 900000) - System.currentTimeMillis()) > 0) goto L15;
        r10.mInstallFlag = com.bytedanceos.common.toolbox.e.f(getPackageManager(), r10.appPackageName, false);
        if (this.f9622d.contains(r10) == true) goto L12;
        this.f9622d.addLast(r10);
    L13:
        b0.n().F(r10.appPackageName, System.currentTimeMillis(), "com.bytedanceos.app.status", BaseApplication.c());
        return;
    L12:
        j.n(r10.appName + ", is exist in packageInstall queue");
        goto L13
    L15:
        com.bytedanceos.common.toolbox.e.m(r10, 1000);
        j.e("gms maybe is installing,:" + r10.appPackageName);
        throw new StopGmsException(2016, "install exception:" + r10.appPackageName);
    L18:
        throw new StopGmsException(2014, "file not find:" + r10.appPackageName);
    }

    public final void j(int r10, AppInfo r11, int r12) {
        AlertDialog.Builder r13 = new AlertDialog.Builder(new ContextThemeWrapper(BaseApplication.c(), R$style.AppStoreDialogTheme));
        r13.setTitle(R$string.gms_download_failed_title);
        if (1001 != r10) goto L6;
        r13.setMessage(R$string.gms_download_failed_msg);
    L22:
        int r14 = R.string.yes;
        if (2015 == r10) goto L25;
        r13.setPositiveButton(R.string.yes, new a(this, r11));
        r14 = R.string.cancel;
    L25:
        r13.setNegativeButton(r14, new b(this, r11));
        r13.setOnCancelListener(new c(this, r11));
        AlertDialog r15 = r13.create();
        r15.getWindow().setType(ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_FOR_PAST_TIMES_ERROR);
        r15.show();
        return;
    L6:
        if (2012 != r10) goto L8;
    L21:
        r13.setMessage(R$string.gms_unzip_failed_msg);
        goto L22
    L8:
        if (2013 == r10) goto L21;
        if (2014 != r10) goto L13;
        r13.setMessage(R$string.gms_install_failed_msg);
        goto L22
    L13:
        if (2015 != r10) goto L15;
        r13.setMessage(R$string.gms_install_failed_no_space);
        goto L22
    L15:
        StringBuilder r16 = new StringBuilder();
        r16.append("unkown type:");
        r16.append(r10);
        r16.append("  ");
        if (r11 == null) goto L18;
        String r17 = r11.appPackageName;
    L19:
        r16.append(r17);
        j.a(r16.toString());
        return;
    L18:
        r17 = "";
        goto L19
    }

    public final void k() {
        if (this.f9621c != null) goto L6;
        this.f9621c = new e(this, null);
    L6:
        if (this.f9621c.hasMessages(2011) == true) goto L8;
        Message r10 = Message.obtain();
        r10.what = 2011;
        this.f9621c.sendMessageDelayed(r10, 300000);
    L8:
        j.a("stop service");
    }

    public final ArrayList l(AppInfo r10) {
        ArrayList r11 = new ArrayList();
        ZipInputStream r12 = null;
        FileOutputStream r13 = null;
        ZipInputStream r14 = new ZipInputStream(new FileInputStream(new File(r10.downloadFilePath)));     // Catch: Throwable -> L61 Exception -> L63
        File r15 = com.bytedanceos.common.toolbox.e.H();     // Catch: Throwable -> L7 Exception -> L9
        if (r15.exists() == true) goto L11;
        r15.mkdirs();     // Catch: Throwable -> L7 Exception -> L9
    L11:
        ZipEntry r16 = r14.getNextEntry();     // Catch: Throwable -> L7 Exception -> L9
        if (r16 != null) goto L14;
        r14.close();     // Catch: IOException -> L58
    L60:
        return r11;
    L58:
        e = move-exception;
        e.printStackTrace();
        goto L60
    L14:
        if (r16.isDirectory() == true) goto L11;
        r16.getSize();     // Catch: Throwable -> L7 Exception -> L9
        File r17 = new File(r15, r16.getName());     // Catch: Throwable -> L7 Exception -> L9
        if (r17.exists() == true) goto L19;
    L88:
        FileOutputStream r18 = new FileOutputStream(r17);     // Catch: Throwable -> L40 Exception -> L42
    L73:
        byte[] r19 = new byte[1024];     // Catch: Throwable -> L30 Exception -> L32
    L27:
        int r20 = r14.read(r19);     // Catch: Throwable -> L30 Exception -> L32
        if (r20 <= 0) goto L34;
        r18.write(r19, 0, r20);     // Catch: Throwable -> L30 Exception -> L32
        goto L27
    L34:
        r11.add(r17);     // Catch: Throwable -> L30 Exception -> L32
        r18.flush();     // Catch: Throwable -> L7 Exception -> L9 IOException -> L37
        r18.close();     // Catch: Throwable -> L7 Exception -> L9 IOException -> L37
    L37:
        e = e;
    L38:
        e.printStackTrace();     // Catch: Throwable -> L7 Exception -> L9
    L30:
        th = th;
        r13 = r18;
    L50:
        if (r13 != null) goto L77;
    L55:
        throw th;     // Catch: Throwable -> L7 Exception -> L9
    L77:
        r13.flush();     // Catch: Throwable -> L7 Exception -> L9 IOException -> L53
        r13.close();     // Catch: Throwable -> L7 Exception -> L9 IOException -> L53
    L53:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7 Exception -> L9
    L32:
        e = e;
    L44:
        e.printStackTrace();     // Catch: Throwable -> L30
        if (r18 == null) goto L11;
        r18.flush();     // Catch: Throwable -> L7 Exception -> L9 IOException -> L48
        r18.close();     // Catch: Throwable -> L7 Exception -> L9 IOException -> L48
    L48:
        e = e;
    L42:
        e = e;
        r18 = null;
    L40:
        th = th;
        goto L50
    L19:
        if ((System.currentTimeMillis() - r17.lastModified()) >= 900000) goto L23;
        if (r16.getSize() != r17.length()) goto L23;
        r11.add(r17);     // Catch: Throwable -> L7 Exception -> L9
    L23:
        r17.delete();     // Catch: Throwable -> L7 Exception -> L9
    L9:
        e = e;
    L64:
        e.printStackTrace();     // Catch: Throwable -> L61
        throw new StopGmsException(2012, "unZip Gms failed");     // Catch: Throwable -> L61
    L7:
        th = th;
        r12 = r14;
    L66:
        if (r12 != null) goto L75;
    L71:
        throw th;
    L75:
        r12.close();     // Catch: IOException -> L69
    L69:
        e = move-exception;
        e.printStackTrace();
    L61:
        th = th;
    L63:
        e = e;
        goto L64
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        BaseApplication.u("GmsInstallService", false);
        HandlerThread r10 = new HandlerThread("IntentService[GmsInstallService]");
        r10.start();
        this.f9619a = r10.getLooper();
        this.f9620b = new d(this, this.f9619a);
        this.f9621c = new e(this, null);
        PackageInstallDispatcher r11 = new PackageInstallDispatcher(this.f9622d, this);
        this.f9623e = r11;
        r11.start();
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f9621c == null) goto L6;
        this.f9621c.removeMessages(2011);
    L6:
        if (this.f9619a == null) goto L8;
        this.f9619a.quit();
    L8:
        PackageInstallDispatcher r10 = this.f9623e;
        if (r10 == null) goto L11;
        r10.c();
    L11:
        BaseApplication.u("GmsInstallService", true);
        j.n("onDestroy");
    }

    @Override // com.bytedanceos.common.core.install.PackageInstallDispatcher.PackageInstallListener
    public void onInstallFinished(AppInfo r10, int r11) {
        CountDownLatch r12 = this.f9624f;
        if (r12 == null) goto L5;
        r12.countDown();
    L5:
        if (r10 == null) goto L8;
        j.n(" [GmsInstallService] " + r10.appPackageName + "  returnCode:" + r11);
        b0.n().I(r10.appPackageName, "com.bytedanceos.app.status", getApplication());
        return;
    }

    @Override // android.app.Service
    public void onStart(Intent r10, int r11) {
        Message r12 = this.f9620b.obtainMessage();
        r12.arg1 = r11;
        r12.obj = r10;
        this.f9620b.sendMessage(r12);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        if (this.f9621c.hasMessages(2011) == false) goto L5;
        this.f9621c.removeMessages(2011);
    L5:
        onStart(r10, r12);
        return 2;
    }
}
