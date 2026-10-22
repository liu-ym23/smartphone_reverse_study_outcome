package com.stepos.statsapp.v3;

import android.webkit.JavascriptInterface;
import com.stepos.personal.info.PersonalInfoHelper;
import com.stepos.statsapp.v3.utils.log.Logger;

/* loaded from: classes2.dex */
public class UsageStatsJavascriptInterface {
    private final String TAG = "UsageStatsJavascriptInterface";

    public static UsageStatsJavascriptInterface getInstance() {
        return new UsageStatsJavascriptInterface();
    }

    @JavascriptInterface
    public String getStepOSUid() {
        Logger.d("UsageStatsJavascriptInterface", "getStepOSUid");
        return PersonalInfoHelper.getStepOSUid();
    }

    @JavascriptInterface
    public String getUMID() {
        Logger.d("UsageStatsJavascriptInterface", "getUMID");
        return UsageStatsProxy3.getInstance().getUMID();
    }
}
