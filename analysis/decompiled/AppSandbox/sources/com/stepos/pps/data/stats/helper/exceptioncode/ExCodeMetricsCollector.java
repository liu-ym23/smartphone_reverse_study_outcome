package com.stepos.pps.data.stats.helper.exceptioncode;

import android.content.Context;
import android.util.Log;
import com.stepos.pps.data.stats.helper.StatsdHelper;
import com.stepos.pps.data.stats.utilities.ICollector;
import com.stepos.pps.data.stats.utilities.IMetrics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import stepos.com.android.internal.os.StatsdConfigProto;
import stepos.com.android.os.StatsLog;

/* loaded from: classes.dex */
public class ExCodeMetricsCollector implements ICollector<Integer> {
    public static final String DIR_EXCEPTION_CODE_METRICS_STEPOS = "exception_code_metrics";
    private static final String LOG_TAG = "PPS:ExCodeMetricsCollector";
    private static final long METRICS_DATA_EXPIRED_MILLIS = 604800000;
    public static final String STEPOS_EXCEPTION_CODE_METRIC_CONFIG_ID = "stepos_exception_code_metrics_config_id";
    private Context mContext;

    public ExCodeMetricsCollector(Context context) {
        this.mContext = context;
    }

    @Override // com.stepos.pps.data.stats.utilities.ICollector
    public boolean startCollecting() {
        Log.d(LOG_TAG, "startCollecting");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BluetoothFieldStatsMetrics());
        arrayList.add(new GnssFieldStatsMetrics());
        arrayList.add(new ModemFieldStatsMetrics());
        arrayList.add(new NfcFieldStatsMetrics());
        arrayList.add(new PerfFieldStatsMetrics());
        arrayList.add(new KernelFiledStatsMetrics());
        arrayList.add(new PowerFiledStatsMetrics());
        arrayList.add(new StabilityFiledStatsMetrics());
        arrayList.add(new WifiFieldStatsMetrics());
        arrayList.add(new FrameworkFieldStatsMetrics());
        StatsdConfigProto.StatsdConfig.Builder simpleSources = StatsdHelper.getSimpleSources(STEPOS_EXCEPTION_CODE_METRIC_CONFIG_ID.hashCode());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((IMetrics) it.next()).addConfig(simpleSources);
        }
        simpleSources.setHashStringsInMetricReport(false);
        simpleSources.setVersionStringsInMetricReport(true);
        StatsdHelper.addConfig(STEPOS_EXCEPTION_CODE_METRIC_CONFIG_ID.hashCode(), simpleSources.build().toByteArray());
        Log.d(LOG_TAG, "StatsdHelper.addConfig exception code config id: " + STEPOS_EXCEPTION_CODE_METRIC_CONFIG_ID.hashCode());
        return false;
    }

    @Override // com.stepos.pps.data.stats.utilities.ICollector
    public Map<String, Integer> getMetrics() throws JSONException, IOException {
        String str = LOG_TAG;
        Log.d(str, "exception code metrics getMetrics begin");
        getMetric(DIR_EXCEPTION_CODE_METRICS_STEPOS, STEPOS_EXCEPTION_CODE_METRIC_CONFIG_ID);
        Log.d(str, "exception code metrics getMetrics finish");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x027b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void getMetric(java.lang.String r20, java.lang.String r21) throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 888
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.data.stats.helper.exceptioncode.ExCodeMetricsCollector.getMetric(java.lang.String, java.lang.String):void");
    }

    private boolean hasMetricsData(StatsLog.ConfigMetricsReportList configMetricsReportList) {
        if (configMetricsReportList != null && configMetricsReportList.getReportsList() != null && configMetricsReportList.getReportsList().size() != 0) {
            for (StatsLog.ConfigMetricsReport configMetricsReport : configMetricsReportList.getReportsList()) {
                if (configMetricsReport.getMetricsList() != null) {
                    for (StatsLog.StatsLogReport statsLogReport : configMetricsReport.getMetricsList()) {
                        if (statsLogReport.getEventMetrics() != null && statsLogReport.getEventMetrics().getDataCount() > 0) {
                            return true;
                        }
                        if (statsLogReport.getDurationMetrics() != null && statsLogReport.getDurationMetrics().getDataCount() > 0) {
                            return true;
                        }
                        if (statsLogReport.getCountMetrics() != null && statsLogReport.getCountMetrics().getDataCount() > 0) {
                            return true;
                        }
                        if (statsLogReport.getGaugeMetrics() != null && statsLogReport.getGaugeMetrics().getDataCount() > 0) {
                            return true;
                        }
                        if (statsLogReport.getValueMetrics() != null && statsLogReport.getValueMetrics().getDataCount() > 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.stepos.pps.data.stats.utilities.ICollector
    public boolean stopCollecting() {
        return StatsdHelper.removeStatsConfig(STEPOS_EXCEPTION_CODE_METRIC_CONFIG_ID.hashCode());
    }

    private String getFileName(String str) {
        return System.currentTimeMillis() + "_" + str.hashCode();
    }
}
