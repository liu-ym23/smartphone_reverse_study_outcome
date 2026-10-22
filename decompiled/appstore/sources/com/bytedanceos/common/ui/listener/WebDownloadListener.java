package com.bytedanceos.common.ui.listener;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.WebParam;
import com.bytedanceos.common.toolbox.e;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class WebDownloadListener implements DownloadListener {
    private AppInfo mAppInfo;
    private WebParam mParam;
    private WeakReference<Activity> mWeakActivity;

    public WebDownloadListener(Activity r10) {
        this.mWeakActivity = new WeakReference(r10);
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String r10, String r11, String r12, String r13, long r14) {
        WeakReference<Activity> r15 = this.mWeakActivity;
        if (r15 != null) goto L5;
        return;
    L5:
        if (r15.get() != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        return;
    L9:
        if (this.mParam != null) goto L12;
        return;
    L12:
        if (e.k0(r10) == true) goto L14;
        return;
    L14:
        if (this.mAppInfo != null) goto L21;
        AppInfo r16 = new AppInfo();
        this.mAppInfo = r16;
        if (TextUtils.isEmpty(this.mParam.getAppName()) == false) goto L18;
        String r17 = this.mParam.getPkg();
    L19:
        r16.appName = r17;
        this.mAppInfo.appBytes = r14;
        goto L21
    L18:
        r17 = this.mParam.getAppName();
    L21:
        if (TextUtils.isEmpty(this.mAppInfo.appPackageName) == false) goto L27;
        AppInfo r18 = this.mAppInfo;
        if (TextUtils.isEmpty(this.mParam.getPkg()) == false) goto L25;
        String r19 = "null";
    L26:
        r18.appPackageName = r19;
        goto L27
    L25:
        r19 = this.mParam.getPkg();
    L27:
        AppInfo r20 = this.mAppInfo;
        r20.appDownloadUrl = r10;
        r20.appSource = "ad";
        r20.mAdExtra = this.mParam.getAdExtra();
        AppInfo r21 = this.mAppInfo;
        r21.mAdDsp = this.mParam.getAdDsp();
    }

    public void setAppInfo(AppInfo r10) {
        this.mAppInfo = r10;
    }

    public void setParam(WebParam r10) {
        this.mParam = r10;
    }
}
