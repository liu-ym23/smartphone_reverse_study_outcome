package com.bytedance.android.openlive.inner.host;

import android.app.Activity;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IShareParams;

/* JADX INFO: loaded from: classes12.dex */
public interface IOpenHostShare {
    boolean isShareAvailable(String r100, Activity r101);

    boolean isSupportLiveShare();

    void showNativeShareDialog(Activity r100, IShareParams r101, IShareCallback r102);

    void showShareDialog(Activity r100, IShareParams r101, IShareCallback r102);
}
