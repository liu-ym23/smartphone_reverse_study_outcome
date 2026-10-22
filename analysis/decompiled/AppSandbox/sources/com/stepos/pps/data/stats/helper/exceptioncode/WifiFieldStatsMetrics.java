package com.stepos.pps.data.stats.helper.exceptioncode;

import android.util.Log;
import com.stepos.pps.data.stats.helper.StatsdHelper;
import com.stepos.pps.data.stats.utilities.IMetrics;
import stepos.com.android.internal.os.StatsdConfigProto;

/* loaded from: classes.dex */
public class WifiFieldStatsMetrics implements IMetrics {
    private static final String TAG = "WifiFieldStatsMetrics";

    @Override // com.stepos.pps.data.stats.utilities.IMetrics
    public void addConfig(StatsdConfigProto.StatsdConfig.Builder builder) {
        int iHashCode = "wifi_code_report_stats_metric".hashCode();
        int iHashCode2 = "event".hashCode() + 120000;
        Log.d(TAG, "addConfig metric id: " + iHashCode);
        builder.addEventMetric(StatsdConfigProto.EventMetric.newBuilder().setWhat((long) iHashCode2).setId((long) iHashCode)).addAtomMatcher(StatsdHelper.getSimpleAtomMatcher(iHashCode2, 120000));
    }
}
