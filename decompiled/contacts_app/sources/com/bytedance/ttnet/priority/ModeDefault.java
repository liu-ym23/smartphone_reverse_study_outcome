package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class ModeDefault extends TTHttpCallPriorityControl.BaseModeControl {
    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStart() {
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStop() {
    }

    public ModeDefault() {
    }

    private int getDispatchDelayTime(Request r3) {
        List<Header> r2 = r3.headers("x-tt-request-tag");
        if (r2 != null) goto L5;
    L9:
        String r4 = "";
    L11:
        return URLDispatcher.inst().getDelayResult(r3.getUrl(), r4);
    L5:
        if (r2.size() < 1) goto L9;
        if (TextUtils.isEmpty(r2.get(0).getValue()) == true) goto L9;
        r4 = r2.get(0).getValue();
        goto L11
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r9, RetrofitMetrics r10) throws Exception {
        long r5 = getDispatchDelayTime(r9);
        if (Logger.debug() == false) goto L5;
        Logger.d("ModeDefault", "get tag delay time " + r5 + HanziToPinyin.Token.SEPARATOR + r9.getPath());
    L5:
        this.mRequestDelayController.requestBlockingDelay(r9, true, false, r5, r10);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r10, RetrofitMetrics r11, Executor r12, Runnable r13) throws Exception {
        long r4 = getDispatchDelayTime(r10);
        if (Logger.debug() == false) goto L6;
        Logger.d("ModeDefault", "get tag delay time " + r4 + HanziToPinyin.Token.SEPARATOR + r10.getPath());
    L6:
        return this.mRequestDelayController.requestAsyncDelay(r10, true, r4, r13, r12, r11);
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    TTHttpCallPriorityControl.ModeType modeType() {
        return TTHttpCallPriorityControl.ModeType.DEFAULT;
    }
}
