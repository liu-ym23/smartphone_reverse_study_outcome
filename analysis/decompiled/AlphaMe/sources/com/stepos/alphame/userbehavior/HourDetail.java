package com.stepos.alphame.userbehavior;

import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.predict.PredictManager;
import java.util.HashMap;

/* loaded from: classes.dex */
public class HourDetail {
    final HashMap<String, HourAppInfo> appUseTime = new HashMap<>();
    int notifications;
    int screenOnTimes;
    long totalUsedTime;

    private boolean isValidPkg(String str) {
        PredictManager predictManager = PredictManager.getInstance(ApplicationImpl.getApplication());
        return predictManager.isAppOnLauncher(str) && predictManager.isAvailable(str);
    }

    public String toString(boolean z4) {
        StringBuilder sb = new StringBuilder();
        for (String str : this.appUseTime.keySet()) {
            if (!z4 || isValidPkg(str)) {
                HourAppInfo hourAppInfo = this.appUseTime.get(str);
                if (hourAppInfo != null) {
                    sb.append(hourAppInfo.toString());
                    sb.append(",");
                }
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return this.totalUsedTime + "," + this.screenOnTimes + "," + this.notifications + "," + (sb.length() > 0 ? sb.toString() : null);
    }
}
