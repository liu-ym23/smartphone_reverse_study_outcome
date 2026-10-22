package com.bytedance.android.livehostapi.business.ug;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/ug/IUGGoldBoxService;", "Lcom/bytedance/android/live/base/IService;", "getCurrentCountDownTime", "Lcom/bytedance/android/livehostapi/business/ug/IncentiveEnhanceCountDownInfo;", "showNormalExtendView", "", "extendData", "Lcom/bytedance/android/livehostapi/business/ug/NormalizedExtendData;", "isTaskDone", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUGGoldBoxService extends IService {
    IncentiveEnhanceCountDownInfo getCurrentCountDownTime();

    void showNormalExtendView(NormalizedExtendData r100, boolean r101);
}
