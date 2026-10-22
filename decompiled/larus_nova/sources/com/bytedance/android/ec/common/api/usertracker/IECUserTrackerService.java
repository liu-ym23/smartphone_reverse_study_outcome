package com.bytedance.android.ec.common.api.usertracker;

import com.bytedance.android.ecom.service_annotation.ReturnSubService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import of.a;
import of.b;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0007H'¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/common/api/usertracker/IECUserTrackerService;", "", "Lof/b;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "enterPage", "leavePage", "Lof/a;", "getMarketingService", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IECUserTrackerService {
    void enterPage(b r100);

    @ReturnSubService
    a getMarketingService();

    void leavePage(b r100);
}
