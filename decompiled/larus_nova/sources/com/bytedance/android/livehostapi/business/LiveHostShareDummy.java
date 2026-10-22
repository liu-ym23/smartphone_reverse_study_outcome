package com.bytedance.android.livehostapi.business;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.wrap.AbsHostShare;

/* JADX INFO: loaded from: classes7.dex */
public class LiveHostShareDummy extends AbsHostShare {
    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShare
    public String getIMContactConversationId(f r100) {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShare
    public void getShortUrl(String r100, IHostShare.ValueCallback r101) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShare
    public boolean isShareAvailable(String r100, Activity r101) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShare
    public void promotion(Activity r100, ShareParams r101) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShare
    public void share(Activity r100, ShareParams r101, IShareCallback r102) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShare
    public void shareLive(Context r100, f r101, ShareParams r102, IShareCallback r103) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShare
    public void showReportDialog(Activity r100, ShareParams r101, String r102) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShare
    public void showShareDialog(Activity r100, ShareParams r101, IShareCallback r102) {
    }

    public LiveHostShareDummy() {
    }
}
