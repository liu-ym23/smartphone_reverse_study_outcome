package com.bytedance.android.livehostapi.business.depend.publish;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&J\"\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&J$\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/publish/MatchPublishStatusListener;", "", "getPublishId", "", "onFinish", "", "state", "Lcom/bytedance/android/livehostapi/business/depend/publish/MatchRecordStatus;", "publishId", "coverPath", "onProgress", "progress", "", "onStageUpdate", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MatchPublishStatusListener {
    String getPublishId();

    void onFinish(MatchRecordStatus r100, String r101, String r102);

    void onProgress(int r100, String r101, String r102);

    void onStageUpdate(MatchRecordStatus r100, String r101, String r102);
}
