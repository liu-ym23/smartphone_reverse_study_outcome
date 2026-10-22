package com.byted.cast.common;

import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class SourceMonitorUtils {
    private static final String TAG = "SourceMonitorUtils";
    private CastMonitor mMonitor;
    private TeaEventTrack teaEventTrack;

    public SourceMonitorUtils(CastMonitor r100) {
        this.mMonitor = r100;
    }

    public void sendDlnaSearchSendSuccess(HashMap<String, String> r100) {
        HashMap r101 = new HashMap();
        r101.put("browse_id", this.mMonitor.browseId);
        this.mMonitor.sendSourceEvent(CastMonitor.BDDLNA_SEARCH_SEND_SUCCESS, r100, r101, "");
    }

    public void trackBDLinkDiskCacheCheckResult(boolean r100) {
        HashMap r101 = new HashMap();
        if (r100 == false) goto L5;
        String r102 = "success";
    L6:
        r101.put("result", r102);
        HashMap r103 = new HashMap();
        r103.put("browse_id", this.mMonitor.browseId);
        this.mMonitor.sendSourceEvent(CastMonitor.BDLINK_DISK_CACHE_CHECK_RESULT, r101, r103, "");
        return;
    L5:
        r102 = "failure";
        goto L6
    }

    public void trackNsdBrowseSuccessEvent(String r100) {
        HashMap r101 = new HashMap();
        r101.put("nsd_type", r100);
        HashMap r102 = new HashMap();
        r102.put("browse_id", this.mMonitor.browseId);
        this.mMonitor.sendSourceEvent(CastMonitor.NSD_SERVICE_BROWSE_SUCCESS, r101, r102, "");
    }

    public void trackSsdpBrowseEvent(String r100, Map<String, String> r101) {
        HashMap r102 = new HashMap();
        r102.put("browse_id", this.mMonitor.browseId);
        this.mMonitor.sendSourceEvent(r100, r101, r102, "");
    }

    public void sendDlnaBrowseError(int r100, String r101, HashMap<String, String> r102) {
        HashMap r103 = new HashMap();
        r103.put("error_code", String.valueOf(r100));
        r103.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r101);
        if (r102 == null) goto L5;
        r103.putAll(r102);
    L5:
        HashMap r104 = new HashMap();
        r104.put("browse_id", this.mMonitor.browseId);
        this.mMonitor.sendSourceEvent(CastMonitor.BDDLNA_BROWSE_ERROR, r103, r104, "");
    }

    public void trackBrowseEvent(String r100, String r101, String r102) {
        CastMonitor r103 = this.mMonitor;
        r103.sendCustomEvent(r100, r101, r102, null, r103.browseId);
    }

    public void trackSsdpErrorEvent(String r100, int r101, String r102) {
        HashMap r103 = new HashMap();
        r103.put("error_code", String.valueOf(r101));
        r103.put("error_message", r102);
        HashMap r104 = new HashMap();
        r104.put("browse_id", this.mMonitor.browseId);
        this.mMonitor.sendSourceEvent(r100, r103, r104, "");
    }

    public void trackBDDLNAParseUrlFailureInfo(String r100, String r101, String r102, String r103) {
        HashMap r104 = new HashMap();
        r104.put("type", r100);
        HashMap r105 = new HashMap();
        r105.put("url", r101);
        r105.put("http_connection_error_message", r102);
        r105.put("http_request_error_message", r103);
        this.mMonitor.sendSourceEvent(CastMonitor.BDDLNA_PARSE_URL_FAILURE_INFO, r104, r105, "");
    }
}
