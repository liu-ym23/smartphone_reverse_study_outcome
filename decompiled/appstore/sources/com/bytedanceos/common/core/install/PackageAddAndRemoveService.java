package com.bytedanceos.common.core.install;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public class PackageAddAndRemoveService extends IntentService {
    public PackageAddAndRemoveService() {
        super("PackageAddAndRemoveService");
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent r10) {
        if (r10 != null) goto L5;
        j.e("intent is null.");
        return;
    L5:
        String r11 = r10.getStringExtra("PackageName");
        if (TextUtils.isEmpty(r11) == false) goto L9;
        j.e("PackageAddAndRemoveService packageNAme is null.");
        return;
    L9:
        j.n("PackageAddAndRemoveService [action]:" + r10.getAction() + ",[packageName]:" + r11);
        if (TextUtils.equals(r10.getAction(), "android.intent.action.PACKAGE_ADDED") == false) goto L13;
        AdsReportManager.h().p(r11);
        BaseApplication.c().b().h0(r11);
        e.n(r11);
        return;
    L13:
        if (TextUtils.equals(r10.getAction(), "android.intent.action.PACKAGE_REMOVED") == true) goto L15;
        return;
    L15:
        if (BaseApplication.c().b().Z(r11) == true) goto L20;
        BaseApplication.c().b().i0(r11);
        return;
    }
}
