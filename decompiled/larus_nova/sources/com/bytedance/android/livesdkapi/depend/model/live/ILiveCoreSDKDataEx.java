package com.bytedance.android.livesdkapi.depend.model.live;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKDataEx;", "", "getDefaultQuality", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "getPullData", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPullData;", "getQualityList", "", "getQualityStrategy", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILiveCoreSDKDataEx {
    IQuality getDefaultQuality();

    IPullData getPullData();

    List<IQuality> getQualityList();

    String getQualityStrategy();
}
