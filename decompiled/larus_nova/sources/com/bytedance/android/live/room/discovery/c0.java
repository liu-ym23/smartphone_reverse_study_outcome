package com.bytedance.android.live.room.discovery;

import com.bytedance.android.livehostapi.business.depend.hashtag.ILiveHashTagCallback;
import com.bytedance.android.livehostapi.business.depend.hashtag.LiveCircleHashTag;
import com.bytedance.android.livehostapi.business.depend.hashtag.LiveHashTag;
import com.bytedance.android.livesdkapi.depend.model.live.LiveHashTagUseInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes47.dex */
public final class c0 implements ILiveHashTagCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHashtagWidget f99373a;

    @Override // com.bytedance.android.livehostapi.business.depend.hashtag.ILiveHashTagCallback
    public final void onHashTagJoinFailed() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.hashtag.ILiveHashTagCallback
    public final void onHashTagPanelDismiss() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.hashtag.ILiveHashTagCallback
    public final void onHashTagPanelShow() {
    }

    public c0(LiveHashtagWidget r100) {
        this.f99373a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.hashtag.ILiveHashTagCallback
    public final void onHashTagJoinSuccess(LiveHashTag r100) {
        LiveHashtagWidget r101 = this.f99373a;
        DataCenter r102 = r101.dataCenter;
        if (r102 == null) goto L10;
        if (r100 == null) goto L10;
        r100.setCreationId((String) r102.get("log_challenge_creation_id", null));
        r101.xq(r100);
        LiveHashTagUseInfo r103 = (LiveHashTagUseInfo) r101.dataCenter.get("data_hash_tag_use_info", new LiveHashTagUseInfo());
        if (r103 != null) goto L9;
        r103 = new LiveHashTagUseInfo();
    L9:
        r103.useHashTagSource(r100.getSource());
        r101.dataCenter.put("data_hash_tag_use_info", r103);
    L10:
        this.f99373a.zq(r100.getId(), r100.getName());
    }

    @Override // com.bytedance.android.livehostapi.business.depend.hashtag.ILiveHashTagCallback
    public final void onHashTagRefreshSuccess(String r100) {
        DataCenter r101 = this.f99373a.dataCenter;
        if (r101 == null) goto L6;
        r101.put("log_challenge_creation_id", r100);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.hashtag.ILiveHashTagCallback
    public final void onLiveCircleSelectSuccess(LiveCircleHashTag r100) {
        r100.getCircleName();
    }
}
