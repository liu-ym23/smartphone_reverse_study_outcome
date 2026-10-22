package com.obric.agent.trace;

import com.obric.capabilitykit.common.AppAction;
import com.obric.funcall_api.bean.IntentAppAction;

/* JADX INFO: compiled from: IOmniReportService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IOmniReportService {
    void init();

    void recordDispatchIntentEnd(String r1, String r2, IntentAppAction r3, String r4);

    void recordDispatchIntentStart(String r1, String r2, AppAction r3);

    void recordNetworkError(String r1, String r2, String r3);
}
