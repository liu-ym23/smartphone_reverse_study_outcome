package com.bytedance.android.livehostapi.business.castscreen.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveQualityInfo;", "", "()V", "qualityInfoList", "", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveQualityDetail;", "getQualityInfoList", "()Ljava/util/List;", "setQualityInfoList", "(Ljava/util/List;)V", "targetQualityKey", "", "getTargetQualityKey", "()Ljava/lang/String;", "setTargetQualityKey", "(Ljava/lang/String;)V", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCastLiveQualityInfo {
    private List<LiveCastLiveQualityDetail> qualityInfoList;
    private String targetQualityKey;

    public LiveCastLiveQualityInfo() {
        this.qualityInfoList = new ArrayList();
        this.targetQualityKey = "";
    }

    public final List<LiveCastLiveQualityDetail> getQualityInfoList() {
        return this.qualityInfoList;
    }

    public final String getTargetQualityKey() {
        return this.targetQualityKey;
    }

    public final void setQualityInfoList(List<LiveCastLiveQualityDetail> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.qualityInfoList = r100;
    }

    public final void setTargetQualityKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.targetQualityKey = r100;
    }
}
