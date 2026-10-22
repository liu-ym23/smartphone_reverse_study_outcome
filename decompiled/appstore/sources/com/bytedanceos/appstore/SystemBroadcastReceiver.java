package com.bytedanceos.appstore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedanceos.appstore.download.receiver.AppInstallReceiver;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.core.install.PackageAddAndRemoveService;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.utils.PerformanceMonitor;

/* JADX INFO: loaded from: classes2.dex */
public class SystemBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SystemBroadcastReceiverKtx f8274a;

    public SystemBroadcastReceiver() {
        this.f8274a = new SystemBroadcastReceiverKtx();
    }

    public final void a(Context r10, Intent r11) {
        r11.setExtrasClassLoader(getClass().getClassLoader());     // Catch: Exception -> L5
        long r12 = r11.getLongExtra("extra_download_id", -1);     // Catch: Exception -> L5
        j.n("[AppStatus][SystemBroadcastReceiver][DownloadManager] ACTION_DOWNLOAD_COMPLETE id is " + String.valueOf(r12));     // Catch: Exception -> L5
        Intent r13 = new Intent(BaseApplication.c(), AppInstallReceiver.class);     // Catch: Exception -> L5
        r13.setAction("com.bytedanceos.app.download_complete");     // Catch: Exception -> L5
        r13.putExtra("extra_download_id", r12);     // Catch: Exception -> L5
        r10.sendBroadcast(r13);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        j.b("maybe receive attack: " + e.getMessage());
    }

    public final void b(Context r10, Intent r11) {
        j.n("[AppStatus][SystemBroadcastReceiver] handlePackageAddAndRemove " + r11.getAction());
        if (TextUtils.equals(r11.getAction(), "android.intent.action.PACKAGE_ADDED") == false) goto L5;
    L8:
        Intent r12 = new Intent(r10, PackageAddAndRemoveService.class);
        r12.setAction(r11.getAction());
        if (r11.getDataString() != null) goto L12;
        j.b("handlePackageAddAndRemove, intent.getDataString() is null!");
        return;
    L12:
        r12.putExtra("PackageName", r11.getDataString().substring(8));
        r10.startService(r12);
        return;
    L5:
        if (r11.getBooleanExtra("android.intent.extra.REPLACING", false) == false) goto L8;
        j.n("[AppStatus][SystemBroadcastReceiver] handlePackageAddAndRemove package replace ");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        BaseApplication.u("SystemBroadcastReceiver", false);
        j.n("SystemBroadcastReceiver Receiver Intent:" + r11);
        String r12 = null;
        if (TextUtils.equals(r11.getAction(), "android.intent.action.PACKAGE_ADDED") == false) goto L5;
    L16:
        String r13 = r11.getStringExtra("PackageName");
        if (TextUtils.isEmpty(r13) == true) goto L41;
    L30:
        boolean r14 = r11.getBooleanExtra("android.intent.extra.REPLACING", false);
        boolean r15 = TextUtils.equals(r11.getAction(), "android.intent.action.PACKAGE_ADDED");
        if (r13 == null) goto L36;
        if (r15 == false) goto L34;
        le.b.b(r13, r14);
        goto L36
    L34:
        le.b.c(r13, r14);
    L36:
        if (TextUtils.equals(r11.getAction(), "android.intent.action.PACKAGE_ADDED") == false) goto L38;
        PerformanceMonitor.a(r13);
        this.f8274a.a(r13);
    L38:
        b(r10, r11);
    L39:
        BaseApplication.u("SystemBroadcastReceiver", true);
        return;
    L41:
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L19:
        if (r11.getData() == null) goto L23;
        r12 = r11.getData().toString();     // Catch: Exception -> L28
    L23:
        if (TextUtils.isEmpty(r12) == true) goto L30;
        if (r12.startsWith("package:") == false) goto L30;
        r13 = r12.substring(8);     // Catch: Exception -> L28
        goto L30
    L5:
        if (TextUtils.equals(r11.getAction(), "android.intent.action.PACKAGE_REMOVED") == true) goto L16;
        if (TextUtils.equals(r11.getAction(), "android.intent.action.BOOT_COMPLETED") == false) goto L11;
        com.bytedanceos.appstore.utils.a.v(132, null, null);
        goto L39
    L11:
        if (TextUtils.equals("android.intent.action.DOWNLOAD_COMPLETE", r11.getAction()) == false) goto L14;
        m4.a.c().e();
        a(r10, r11);
        goto L39
    L14:
        if (TextUtils.equals("android.intent.action.USER_PRESENT", r11.getAction()) == false) goto L39;
        com.bytedanceos.common.utils.j.k();
        com.bytedanceos.appstore.utils.e.a(r10, false);
        goto L39
    }
}
