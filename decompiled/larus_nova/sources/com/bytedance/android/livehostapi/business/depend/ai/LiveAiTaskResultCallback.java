package com.bytedance.android.livehostapi.business.depend.ai;

import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/ai/LiveAiTaskResultCallback;", "", "onTaskResult", "", "taskToken", "", "resultCode", "", "resultJson", "bufferList", "", "Lcom/bytedance/android/livehostapi/business/depend/ai/LiveAiPackageBuffer;", "businessInfo", "Lorg/json/JSONObject;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiveAiTaskResultCallback {
    void onTaskResult(String r100, int r101, String r102, List<LiveAiPackageBuffer> r103, JSONObject r104);
}
