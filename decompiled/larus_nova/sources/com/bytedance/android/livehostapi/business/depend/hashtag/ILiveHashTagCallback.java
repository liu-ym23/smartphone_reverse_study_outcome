package com.bytedance.android.livehostapi.business.depend.hashtag;

/* JADX INFO: loaded from: classes7.dex */
public interface ILiveHashTagCallback {
    void onHashTagJoinFailed();

    void onHashTagJoinSuccess(LiveHashTag r100);

    void onHashTagPanelDismiss();

    void onHashTagPanelShow();

    void onHashTagRefreshSuccess(String r100);

    void onLiveCircleSelectSuccess(LiveCircleHashTag r100);
}
