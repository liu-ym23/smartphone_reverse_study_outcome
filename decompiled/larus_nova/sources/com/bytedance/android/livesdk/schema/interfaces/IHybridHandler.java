package com.bytedance.android.livesdk.schema.interfaces;

import android.net.Uri;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;

/* JADX INFO: loaded from: classes11.dex */
public interface IHybridHandler {
    BaseWebDialogFragment createBottomPanel(String r100, Uri r101);

    String getUrl(Uri r100);
}
