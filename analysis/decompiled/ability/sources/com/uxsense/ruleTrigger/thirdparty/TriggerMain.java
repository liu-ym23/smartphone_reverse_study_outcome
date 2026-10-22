package com.uxsense.ruleTrigger.thirdparty;

import android.content.Intent;
import android.view.View;
import androidx.annotation.UiThread;

/* loaded from: classes3.dex */
public class TriggerMain {
    private static final String TAG = "TriggerMain";

    private static void handleRequestRules(Intent intent) {
        RulesPolicyHandler.requestTriggerRules(intent);
    }

    @UiThread
    private static Object handleTriggerEvent(View view, Intent intent) {
        return RulesPolicyHandler.handleTriggerEvent(view, intent);
    }
}
