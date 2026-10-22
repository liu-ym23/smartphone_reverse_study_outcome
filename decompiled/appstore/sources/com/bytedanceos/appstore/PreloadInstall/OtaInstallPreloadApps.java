package com.bytedanceos.appstore.PreloadInstall;

import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.core.install.PackageInstallDispatcher;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.utils.k;
import com.bytedanceos.common.utils.s;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class OtaInstallPreloadApps implements PackageInstallDispatcher.PackageInstallListener, UnzipFileCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f8262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f8263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedBlockingDeque f8264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PackageInstallDispatcher f8265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CountDownLatch f8266e;

    public static class StopOtaException extends Exception {
        public StopOtaException(String r10) {
            super(r10);
        }
    }

    public OtaInstallPreloadApps() {
        this.f8262a = new HashMap();
        this.f8263b = new ArrayList();
        this.f8264c = new LinkedBlockingDeque();
        this.f8265d = null;
        this.f8266e = null;
    }

    public final void a(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        Iterator r12 = this.f8263b.iterator();
    L9:
        if (r12.hasNext() == false) goto L19;
        PreLoadAppInfo r13 = (PreLoadAppInfo) r12.next();
        if (r10.equals(r13.getFileName()) == false) goto L9;
        r13.setFilePath(r11);
        return;
    L19:
        return;
    }

    public final PreLoadAppInfo b(String r10) {
        HashMap r11 = this.f8262a;
        if (r11 == null) goto L5;
        PreLoadAppInfo r12 = (PreLoadAppInfo) r11.remove(r10);
        r12.setFilePath(new File(com.bytedanceos.appstore.utils.a.k(), r12.getFileName()).getAbsolutePath());
        return r12;
    L5:
        return null;
    }

    public final boolean c(String r10) {
        return new File(r10).exists();
    }

    public final void d() {
        String r10 = e.U(false);
        String r11 = com.bytedanceos.appstore.utils.a.j();
        j.e("lastOtaVersion  " + r11 + "  currentOatVersion " + r10);
        if (TextUtils.isEmpty(r10) == true) goto L18;
        if (r10.equals(r11) == true) goto L16;
        if (TextUtils.isEmpty(r11) == false) goto L9;
    L13:
        b.b();
        j.e("mPreload app from local : " + this.f8262a.size());
        return;
    L9:
        if (e.w0(r10, r11) == false) goto L13;
        com.bytedanceos.appstore.utils.a.t();
        throw new StopOtaException("lastOtaVersion > currentOtaVersion");
    L16:
        throw new StopOtaException("lastOtaVersion == currentOtaVersion");
    L18:
        throw new StopOtaException("currentOtaVersion is empty");
    }

    public final void e() {
        com.bytedanceos.appstore.utils.a.t();
        if (this.f8263b.isEmpty() == false) goto L6;
        j.n("no ota app");
        return;
    L6:
        int r10 = 2;
        if (this.f8263b.size() > 2) goto L10;
        r10 = this.f8263b.size();
    L10:
        PackageInstallDispatcher r11 = this.f8265d;
        if (r11 != null) goto L13;
    L14:
        PackageInstallDispatcher r12 = new PackageInstallDispatcher(this.f8264c, this);
        this.f8265d = r12;
        r12.start();
    L15:
        j.e("install begin: " + r10);
        Iterator r13 = this.f8263b.iterator();
        int r14 = 0;
    L17:
        if (r13.hasNext() == false) goto L50;
        PreLoadAppInfo r15 = (PreLoadAppInfo) r13.next();
        if (r14 >= r10) goto L50;
        boolean r16 = b0.n().l(r15.getPackageName(), null, BaseApplication.c()).booleanValue();
        if (e.x0(r15.getPackageName()) == true) goto L17;
        if (c(r15.getFilePath()) == false) goto L17;
        if (r16 == true) goto L17;
        r14 = r14 + 1;
        AppInfo r17 = new AppInfo();
        r17.appName = r15.getPackageName();
        r17.appPackageName = r15.getPackageName();
        r17.mInstallFlag = 0;
        r17.downloadFilePath = r15.getFilePath();
        if (this.f8264c.contains(r17) == true) goto L30;
        this.f8264c.addLast(r17);
    L30:
        j.e("install preload appinfo: " + r15.toString());
    L50:
        if (r14 > 0) goto L51;
    L45:
        PackageInstallDispatcher r18 = this.f8265d;
        if (r18 != null) goto L40;
    L48:
        d9.a.e().c();
        j.e("install end:" + r14);
        return;
    L40:
        r18.c();
        this.f8265d = null;
        goto L48
    L51:
        CountDownLatch r19 = new CountDownLatch(r14);     // Catch: Throwable -> L34 InterruptedException -> L36
        this.f8266e = r19;     // Catch: Throwable -> L34 InterruptedException -> L36
        r19.await(5, TimeUnit.MINUTES);     // Catch: Throwable -> L34 InterruptedException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L34
        r18 = this.f8265d;
        if (r18 == null) goto L48;
    L34:
        th = move-exception;
        PackageInstallDispatcher r20 = this.f8265d;
        if (r20 == null) goto L44;
        r20.c();
        this.f8265d = null;
    L44:
        throw th;
    L13:
        if (r11.isAlive() == true) goto L15;
        goto L14
    }

    public final ArrayList f() {
        ArrayList r10 = new ArrayList();
        Iterator r11 = this.f8263b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((PreLoadAppInfo) r11.next()).getFileName());
        goto L4
    L6:
        return r10;
    }

    public final void g() {
        HashMap r10 = this.f8262a;
        if (r10 != null) goto L5;
    L10:
        j.e("need install apps count from local: " + this.f8263b.size());
        return;
    L5:
        if (r10.isEmpty() == true) goto L10;
        Iterator r11 = new HashSet(this.f8262a.keySet()).iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        this.f8263b.add(b((String) r11.next()));
        goto L8
    }

    public void h() {
        d();     // Catch: StopOtaException -> L4
        g();     // Catch: StopOtaException -> L4
        i();     // Catch: StopOtaException -> L4
        e();     // Catch: StopOtaException -> L4
        return;
    L4:
        e = move-exception;
        j.e("stop ota exception: " + e.getMessage());
    }

    public final void i() {
        ArrayList r10 = this.f8263b;
        if (r10 != null) goto L5;
    L9:
        j.e("mNeedInstallApps is null");
        return;
    L5:
        if (r10.isEmpty() == true) goto L9;
        com.bytedanceos.appstore.utils.a.J("/pre-install.zip", this, f());
    }

    @Override // com.bytedanceos.common.core.install.PackageInstallDispatcher.PackageInstallListener
    public void onInstallFinished(AppInfo r10, int r11) {
        if (r10 == null) goto L7;
        j.e("OtaAppS install finished package=" + r10.appPackageName + " returnCode=" + r11);
        if (r11 != 1) goto L6;
        b0.n().C(r10.appPackageName, true, null, BaseApplication.c());
        d9.a.e().D(r10.appPackageName);
    L8:
        CountDownLatch r12 = this.f8266e;
        if (r12 == null) goto L12;
        r12.countDown();
        return;
    L12:
        return;
    L6:
        String r13 = k.e(r11);
        b0.n().C(r10.appPackageName, false, null, BaseApplication.c());
        s.b("3", r10, r13);
        goto L8
    L7:
        j.e("app ota finish,unkown package name");
        goto L8
    }

    @Override // com.bytedanceos.appstore.PreloadInstall.UnzipFileCallback
    public void unzipFileFinished(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L9;
        a(r10, r11);
        return;
    }
}
