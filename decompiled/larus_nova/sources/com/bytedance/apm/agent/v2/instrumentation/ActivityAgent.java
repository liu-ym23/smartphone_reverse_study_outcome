package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import com.bytedance.apm.agent.helper.PageShowCallback;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.agent.v2.InstructOperationSwitch;

/* JADX INFO: loaded from: classes14.dex */
public class ActivityAgent {
    private static final String TAG = "ActivityInstrumentation";

    public ActivityAgent() {
    }

    public static void onTrace(String r100, String r101, boolean r102) {
        if (r102 == false) goto L9;
        if (InstructOperationSwitch.sUiSwitch == false) goto L9;
        if (TextUtils.equals("onResume", r101) == false) goto L9;
        PageShowCallback.onPageShowHideAction(r100, true);
    L9:
        if (InstructOperationSwitch.sPageLoadSwitch == true) goto L11;
        return;
    L11:
        AutoPageTraceHelper.onTrace(r100, r101, r102);
    }
}
