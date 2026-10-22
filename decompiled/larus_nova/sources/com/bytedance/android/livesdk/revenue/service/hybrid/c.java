package com.bytedance.android.livesdk.revenue.service.hybrid;

import android.net.Uri;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public interface c {
    void onLoadFailed(View r100, String r101);

    void onLoadStart(Uri r100, View r101);

    void onRuntimeReady();
}
