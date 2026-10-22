package com.stepos.pps.data.stats.helper;

import android.util.Log;
import com.stepos.pps.data.stats.utilities.IMetrics;
import java.util.ArrayList;
import stepos.com.android.internal.os.StatsdConfigProto;
import stepos.com.android.os.AtomsProto;

/* loaded from: classes.dex */
public class CrashMetrics implements IMetrics {
    private static final String TAG = "CrashMetrics";

    @Override // com.stepos.pps.data.stats.utilities.IMetrics
    public void addConfig(StatsdConfigProto.StatsdConfig.Builder builder) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(78);
        arrayList.add(79);
        arrayList.add(Integer.valueOf(AtomsProto.Atom.SYSTEM_SERVER_WATCHDOG_OCCURRED_FIELD_NUMBER));
        arrayList.add(110001);
        arrayList.add(110000);
        for (int i = 0; i < arrayList.size(); i++) {
            int iIntValue = ((Integer) arrayList.get(i)).intValue();
            int iHashCode = "event_metric_id".hashCode() + iIntValue;
            int iHashCode2 = "matcher_id".hashCode() + iIntValue;
            Log.d(TAG, "addConfig metric id: " + iHashCode);
            builder.addEventMetric(StatsdConfigProto.EventMetric.newBuilder().setId((long) iHashCode).setWhat((long) iHashCode2).build()).addAtomMatcher(StatsdHelper.getSimpleAtomMatcher(iHashCode2, iIntValue));
        }
    }
}
