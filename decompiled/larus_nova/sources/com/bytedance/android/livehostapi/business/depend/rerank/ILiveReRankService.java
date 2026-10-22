package com.bytedance.android.livehostapi.business.depend.rerank;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/rerank/ILiveReRankService;", "", "getDelegate", "Lcom/bytedance/android/livehostapi/business/depend/rerank/IWebcastReRankDelegate;", "getRecentItems", "", "updateLastServerSideParam", "", "satiParamForPitaya", "updateUserSideParam", "userExtraInfo", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveReRankService {
    IWebcastReRankDelegate getDelegate();

    String getRecentItems();

    void updateLastServerSideParam(String r100);

    void updateUserSideParam(String r100);
}
