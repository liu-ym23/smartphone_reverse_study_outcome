package com.ss.android.socialbase.downloader.monitor;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCdnListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IMonitorConfig;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadCdnStats;
import com.ss.android.socialbase.downloader.model.DownloadDBInitInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadThreadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDefaultDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadMonitorHelper {
    private static final String DEFAULT_MONITOR_SCENE = "default";

    private static class DownloadMonitorInfo {
        boolean addListenerToSameTask;
        long allConnectTime;
        AsyncHandleStatus asyncHandleStatus;
        long backCurBytes;
        boolean backUpUrlUsed;
        List<String> backUpUrls;
        ByteInvalidRetryStatus byteInvalidRetryStatus;
        String contentEncoding;
        int curBackUpUrlIndex;
        long curBytes;
        int curNetworkRetryCount;
        long curRetryTime;
        long curRetryTimeInTotal;
        double downloadSpeed;
        DownloadThreadInfo downloadThreadInfo;
        long downloadTime;
        DownloadTimingInfo downloadTimingInfo;
        int enqueueType;
        String eventPage;
        BaseException exception;
        String extra;
        boolean fastDownload;
        long firstSpeedTime;
        List<String> forbiddenBackupUrls;
        boolean force;
        String httpRequestHeader;
        String httpResponseHeader;
        boolean httpsToHttpRetryUsed;
        int id;
        boolean isCacheExistsInDownloading;
        String md5;
        long md5Time;
        String mimeType;
        int monitorStatus;
        String name;
        boolean needDefaultHttpServiceBackUp;
        boolean needHttpsToHttpRetry;
        boolean needIndependentProcess;
        String networkQuality;
        boolean onlyWifi;
        JSONObject pcdnStats;
        long realBackDownloadTime;
        long realDownloadTime;
        String requestLog;
        int retryCount;
        String savePath;
        long throttleNetSpeed;
        long totalBytes;
        String url;

        private DownloadMonitorInfo() {
            this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
            this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        }

        /* synthetic */ DownloadMonitorInfo(AnonymousClass1 r1) {
            this();
        }
    }

    public DownloadMonitorHelper() {
    }

    static /* synthetic */ JSONObject access$100(DownloadMonitorInfo r0) {
        return parseMonitorJson(r0);
    }

    static /* synthetic */ void access$200(DownloadMonitorInfo r0, JSONObject r1) {
        putMonitorJsonStatus(r0, r1);
    }

    private static DownloadMonitorInfo translateDownloadMonitorInfo(String r3, DownloadInfo r4, DownloadTask r5, BaseException r6, int r7) {
        DownloadMonitorInfo r0 = new DownloadMonitorInfo(null);
        r0.monitorStatus = r7;
        r0.exception = r6;
        r0.eventPage = r3;
        if (r4 == null) goto L15;
        r0.id = r4.getId();
        r0.name = r4.getName();
        r0.url = r4.getUrl();
        r0.savePath = r4.getSavePath();
        r0.downloadTime = r4.getDownloadTime();
        r0.curBytes = r4.getCurBytes();
        r0.backCurBytes = r4.getBackCurBytes();
        r0.totalBytes = r4.getTotalBytes();
        r0.networkQuality = r4.getNetworkQuality();
        r0.onlyWifi = r4.isOnlyWifi();
        r0.needHttpsToHttpRetry = r4.isNeedHttpsToHttpRetry();
        r0.httpsToHttpRetryUsed = r4.isHttpsToHttpRetryUsed();
        r0.md5 = r4.getMd5();
        r0.force = r4.isForce();
        r0.retryCount = r4.getRetryCount();
        r0.needDefaultHttpServiceBackUp = r4.isNeedDefaultHttpServiceBackUp();
        r0.byteInvalidRetryStatus = r4.getByteInvalidRetryStatus();
        r0.asyncHandleStatus = r4.getAsyncHandleStatus();
        r0.needIndependentProcess = r4.isNeedIndependentProcess();
        r0.extra = r4.getExtra();
        r0.addListenerToSameTask = r4.isAddListenerToSameTask();
        r0.backUpUrls = r4.getBackUpUrls();
        r0.curBackUpUrlIndex = r4.getCurBackUpUrlIndex();
        r0.forbiddenBackupUrls = r4.getForbiddenBackupUrls();
        r0.curNetworkRetryCount = r4.getCurNetworkRetryCount();
        r0.isCacheExistsInDownloading = r4.isCacheExistsInDownloading();
        r0.mimeType = r4.getMimeType();
        r0.contentEncoding = r4.getContentEncoding();
        r0.fastDownload = r4.isFastDownload();
        r0.pcdnStats = r4.getPcdnStats();
        r0.throttleNetSpeed = r4.getThrottleNetSpeed();
        r0.httpRequestHeader = r4.getHttpRequestHeader();
        r0.httpResponseHeader = r4.getHttpResponseHeader();
        r0.requestLog = r4.getRequestLog();
        r0.enqueueType = r4.getEnqueueType().ordinal();
        if (r7 != (-3)) goto L7;
    L12:
        r0.allConnectTime = r4.getAllConnectTime();
        r0.firstSpeedTime = r4.getFirstSpeedTime();
        r0.realDownloadTime = r4.getRealDownloadTime();
        r0.realBackDownloadTime = r4.getRealBackDownloadTime();
        r0.backUpUrlUsed = r4.isBackUpUrlUsed();
        r0.curRetryTime = r4.getCurRetryTime();
        r0.curRetryTimeInTotal = r4.getCurRetryTimeInTotal();
        r0.md5Time = r4.getMd5Time();
    L13:
        if (r7 != (-3)) goto L15;
        r0.downloadSpeed = r4.getDownloadSpeed();
        goto L15
    L7:
        if (r7 == (-4)) goto L12;
        if (r7 == (-1)) goto L12;
        if (r7 != (-2)) goto L13;
    L15:
        if (r5 == null) goto L17;
        r0.downloadTimingInfo = r5.getTimingInfo().copy();
        r0.downloadThreadInfo = r5.getThreadInfo().copy();
    L17:
        return r0;
    }

    public static void monitorSend(DownloadTask r4, BaseException r5, int r6) {
        if (r4 != null) goto L27;
        return;
    L27:
        DownloadInfo r0 = r4.getDownloadInfo();     // Catch: Throwable -> L24
        if (r0 != null) goto L7;
        return;
    L7:
        IDownloadMonitorDepend r1 = r4.getMonitorDepend();     // Catch: Throwable -> L24
        boolean r2 = DownloadStatus.isMonitorStatus(r6);     // Catch: Throwable -> L24
        if (r2 == true) goto L15;
        r2 = isMonitorStatus(r0.getExtraMonitorStatus(), r6);     // Catch: Throwable -> L24
        if (r2 == true) goto L15;
        if (r1 == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r1, AbsDownloadMonitorDepend.class) == false) goto L15;
        r2 = isMonitorStatus(((AbsDownloadMonitorDepend) ZeusTransformUtils.preCheckCast(r1, AbsDownloadMonitorDepend.class, "com.obric.aiagent.plugin")).getAdditionalMonitorStatus(), r6);     // Catch: Throwable -> L24
    L15:
        if (r2 == false) goto L31;
        IDownloadDepend r3 = r4.getDepend();     // Catch: Throwable -> L20
        if (r3 == null) goto L22;
        r3.monitorLogSend(r0, r5, r6);     // Catch: Throwable -> L20
    L22:
        monitorSendWithTaskMonitor(r1, r0, r5, r6);     // Catch: Throwable -> L24
        monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), r4, r0, r5, r6);     // Catch: Throwable -> L24
        return;
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L24
        goto L22
    L31:
        return;
    L24:
        th = move-exception;
        monitorDownloadOtherError(th);
        th.printStackTrace();
    }

    private static boolean isMonitorStatus(int[] r3, int r4) {
        if (r3 != null) goto L5;
    L14:
        return false;
    L5:
        if (r3.length <= 0) goto L14;
        int r1 = 0;
    L8:
        if (r1 >= r3.length) goto L14;
        if (r4 == r3[r1]) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return true;
    }

    public static void monitorSendWithTaskMonitor(IDownloadMonitorDepend r2, DownloadInfo r3, BaseException r4, int r5) {
        final IDownloadMonitorDepend r6 = (IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadMonitorDepend.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        String r0 = r6.getEventPage();
        if (TextUtils.isEmpty(r0) == false) goto L8;
        r0 = "default";
    L8:
        final DownloadMonitorInfo r7 = translateDownloadMonitorInfo(r0, r3, null, r4, r5);
        DownloadComponentManager.submitCPUTask(new AnonymousClass1(r7, r6));
    }

    public static void monitorSendWithGlobalSdkMonitor(IDownloadMonitorListener r2, DownloadTask r3, DownloadInfo r4, BaseException r5, int r6) {
        final IDownloadMonitorListener r7 = (IDownloadMonitorListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadMonitorListener.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r4.isNeedSDKMonitor() == false) goto L10;
        final DownloadMonitorInfo r8 = translateDownloadMonitorInfo(r4.getMonitorScene(), r4, r3, r5, r6);
        DownloadComponentManager.submitCPUTask(new AnonymousClass2(r8, r7));
        return;
    }

    private static void putMonitorJsonStatus(DownloadMonitorInfo r4, JSONObject r5) {
        int r0 = r4.monitorStatus;
        if (r0 != (-5)) goto L5;
        String r6 = "download_uncomplete";
    L26:
        r5.put("status", r6);
        return;
    L5:
        if (r0 != (-4)) goto L7;
        r6 = "download_cancel";
        goto L26
    L7:
        if (r0 == (-3)) goto L21;
        if (r0 == (-2)) goto L19;
        if (r0 != 0) goto L12;
        r6 = "download_create";
        goto L26
    L12:
        if (r0 != 2) goto L14;
        r6 = "download_start";
        goto L26
    L14:
        if (r0 == 6) goto L16;
        r6 = "";
        goto L26
    L16:
        r6 = "download_first_start";
        goto L26
    L19:
        r6 = "download_pause";
        goto L26
    L21:
        if (r4.downloadSpeed < 0.0d) goto L23;
        r5.put(MonitorConstants.DOWNLOAD_SPEED, r4.downloadSpeed);
    L23:
        r5.put(MonitorConstants.THROTTLE_SPEED, r4.throttleNetSpeed);
        r6 = "download_success";
        goto L26
    }

    private static JSONObject parseMonitorJson(DownloadMonitorInfo r10) {
        JSONObject r1 = null;
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L128
        IMonitorConfig r3 = DownloadComponentManager.getMonitorConfig();     // Catch: JSONException -> L126
        int r4 = 0;
        String r5 = "";
        if (r3 == null) goto L8;
        String r6 = r3.getDeviceId();     // Catch: JSONException -> L126
        String r7 = DownloadUtils.parseDevicePostfix(r6);     // Catch: JSONException -> L126
        String r8 = r3.getAppId();     // Catch: JSONException -> L126
        int r9 = r3.getUpdateVersion();     // Catch: JSONException -> L126
    L9:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r10.eventPage);     // Catch: JSONException -> L126
        r2.put("app_id", r8);     // Catch: JSONException -> L126
        r2.put("device_id", r6);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DEVICE_ID_POSTFIX, r7);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_UPDATE_VERSION, r9);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, r10.monitorStatus);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_TTNET_TNC_ABHIT, DownloadComponentManager.getTTNetHandler().getABTestInfo());     // Catch: JSONException -> L126
        r2.put(DownloadSettingKeys.SETTING_TAG, DownloadSetting.obtain(r10.id).optString(DownloadSettingKeys.SETTING_TAG));     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_ID, r10.id);     // Catch: JSONException -> L126
        r2.put("name", r10.name);     // Catch: JSONException -> L126
        r2.put("url", r10.url);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_SAVE_PATH, r10.savePath);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_TIME, r10.downloadTime);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, r10.curBytes);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_BACKGROUND_DOWNLOAD_BYTES, r10.backCurBytes);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, r10.totalBytes);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_NETWORK_QUALITY, r10.networkQuality);     // Catch: JSONException -> L126
        int r11 = 1;
        if (r10.onlyWifi == false) goto L12;
        int r12 = 1;
    L13:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, r12);     // Catch: JSONException -> L126
        if (r10.needHttpsToHttpRetry == false) goto L16;
        int r13 = 1;
    L17:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_HTTPS_DEGRADE, r13);     // Catch: JSONException -> L126
        if (r10.httpsToHttpRetryUsed == false) goto L20;
        int r14 = 1;
    L21:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_HTTPS_DEGRADE_RETRY_USED, r14);     // Catch: JSONException -> L126
        if (r10.md5 != null) goto L24;
        String r15 = "";
    L25:
        r2.put("md5", r15);     // Catch: JSONException -> L126
        if (r10.force == false) goto L28;
        int r16 = 1;
    L29:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, r16);     // Catch: JSONException -> L126
        r2.put("retry_count", r10.retryCount);     // Catch: JSONException -> L126
        if (r10.needDefaultHttpServiceBackUp == false) goto L32;
        int r17 = 1;
    L33:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_DEFAULT_HTTP_SERVICE_BACKUP, r17);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_BYTE_ERROR_RETRY_STATUS, r10.byteInvalidRetryStatus.ordinal());     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_HANDLER_STATUS, r10.asyncHandleStatus.ordinal());     // Catch: JSONException -> L126
        if (r10.needIndependentProcess == false) goto L36;
        int r18 = 1;
    L37:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, r18);     // Catch: JSONException -> L126
        if (r10.extra == null) goto L40;
        String r19 = r10.extra;     // Catch: JSONException -> L126
    L41:
        r2.put("extra", r19);     // Catch: JSONException -> L126
        if (r10.addListenerToSameTask == false) goto L44;
        int r20 = 1;
    L45:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_ADD_LISTENER_TO_SAME_TASK, r20);     // Catch: JSONException -> L126
        if (r10.backUpUrls == null) goto L48;
        int r21 = r10.backUpUrls.size();     // Catch: JSONException -> L126
    L49:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, r21);     // Catch: JSONException -> L126
        if (r10.backUpUrls == null) goto L52;
        String r22 = r10.backUpUrls.toString();     // Catch: JSONException -> L126
    L53:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL, r22);     // Catch: JSONException -> L126
        if (r10.backUpUrls == null) goto L56;
        int r23 = r10.curBackUpUrlIndex;     // Catch: JSONException -> L126
    L57:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, r23);     // Catch: JSONException -> L126
        if (r10.forbiddenBackupUrls == null) goto L60;
        String r24 = r10.forbiddenBackupUrls.toString();     // Catch: JSONException -> L126
    L61:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_URLS, r24);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_NETWORK_RETRY_COUNT, r10.curNetworkRetryCount);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_CACHE_EXISTS_IN_DOWNLOADING, r10.isCacheExistsInDownloading);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_CONTENT_TYPE, r10.mimeType);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_CONTENT_ENCODING, r10.contentEncoding);     // Catch: JSONException -> L126
        if (r10.fastDownload == false) goto L64;
        int r25 = 1;
    L65:
        r2.put(MonitorConstants.EXTRA_FAST_DOWNLOAD, r25);     // Catch: JSONException -> L126
        if (r10.requestLog != null) goto L68;
        String r26 = "";
    L69:
        r2.put(MonitorConstants.REQUEST_LOG, r26);     // Catch: JSONException -> L126
        if (r10.httpRequestHeader != null) goto L72;
        String r27 = "";
    L73:
        r2.put(MonitorConstants.REQUEST_HEADER, r27);     // Catch: JSONException -> L126
        if (r10.httpResponseHeader != null) goto L76;
        String r28 = "";
    L77:
        r2.put(MonitorConstants.RESPONSE_HEADER, r28);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.ENQUEUE_TYPE, r10.enqueueType);     // Catch: JSONException -> L126
        if (r10.pcdnStats == null) goto L81;
        r2.put(MonitorConstants.EXTRA_PCDN_LOG, r10.pcdnStats);     // Catch: JSONException -> L126
    L81:
        if (r10.downloadTimingInfo == null) goto L84;
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_ORIGIN_TIMING_INFO, r10.downloadTimingInfo.obtainOriginStats());     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_TIMING_INFO, r10.downloadTimingInfo.obtainDurationStats());     // Catch: JSONException -> L126
    L84:
        if (r10.downloadThreadInfo == null) goto L87;
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_THREAD_INFO, r10.downloadThreadInfo.obtainStats());     // Catch: JSONException -> L126
    L87:
        if (r10.monitorStatus != (-3)) goto L89;
    L94:
        r2.put(MonitorConstants.ALL_CONNECT_TIME, r10.allConnectTime);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.FIRST_SPEED_TIME, r10.firstSpeedTime);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.REAL_DOWNLOAD_TIME, r10.realDownloadTime);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_BACKGROUND_DOWNLOAD_TIME, r10.realBackDownloadTime);     // Catch: JSONException -> L126
        if (r10.backUpUrlUsed == true) goto L98;
        r11 = 0;
    L98:
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_USED, r11);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_RETRY_TIME, r10.curRetryTime);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_CUR_RETRY_TIME_IN_TOTAL, r10.curRetryTimeInTotal);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DOWNLOAD_MD5_TIME, r10.md5Time);     // Catch: JSONException -> L126
        r2.put(MonitorConstants.EXTRA_DEVICE_AVAILABLE_SPACE, ((DownloadUtils.getAvailableSpaceBytes(r10.savePath) / 1024) / 1024) / 100);     // Catch: Throwable -> L101
    L135:
    L116:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L126
    L119:
        if (r10.exception == null) goto L121;
        r4 = r10.exception.getErrorCode();     // Catch: JSONException -> L126
    L121:
        r2.put("error_code", r4);     // Catch: JSONException -> L126
        if (r10.exception == null) goto L124;
        r5 = r10.exception.getErrorMessage();     // Catch: JSONException -> L126
    L124:
        r2.put("error_msg", r5);     // Catch: JSONException -> L126
        return r2;
    L104:
        if (TextUtils.isEmpty(r10.url) == true) goto L113;
        Uri r0 = Uri.parse(r10.url);     // Catch: Throwable -> L116
        String r29 = r0.getHost();     // Catch: Throwable -> L116
        String r30 = r0.getPath();     // Catch: Throwable -> L116
        String r31 = r0.getLastPathSegment();     // Catch: Throwable -> L116
        if (TextUtils.isEmpty(r30) == false) goto L108;
    L114:
        r2.put(MonitorConstants.URL_HOST, r29);     // Catch: Throwable -> L116
        r2.put(MonitorConstants.URL_PATH, r30);     // Catch: Throwable -> L116
        r2.put(MonitorConstants.URL_LAST_PATH_SEGMENT, r31);     // Catch: Throwable -> L116
    L108:
        if (TextUtils.isEmpty(r31) == true) goto L114;
        r30 = r30.substring(0, r30.length() - r31.length());     // Catch: Throwable -> L111
    L111:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L116
        goto L114
    L113:
        r31 = "";
        r29 = r31;
        r30 = r29;
    L101:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L126
        goto L135
    L89:
        if (r10.monitorStatus == (-4)) goto L94;
        if (r10.monitorStatus == (-1)) goto L94;
        if (r10.monitorStatus != (-2)) goto L135;
    L76:
        r28 = r10.httpResponseHeader;     // Catch: JSONException -> L126
        goto L77
    L72:
        r27 = r10.httpRequestHeader;     // Catch: JSONException -> L126
        goto L73
    L68:
        r26 = r10.requestLog;     // Catch: JSONException -> L126
        goto L69
    L64:
        r25 = 0;
        goto L65
    L60:
        r24 = "";
        goto L61
    L56:
        r23 = -1;
        goto L57
    L52:
        r22 = "";
        goto L53
    L48:
        r21 = 0;
        goto L49
    L44:
        r20 = 0;
        goto L45
    L40:
        r19 = "";
        goto L41
    L36:
        r18 = 0;
        goto L37
    L32:
        r17 = 0;
        goto L33
    L28:
        r16 = 0;
        goto L29
    L24:
        r15 = r10.md5;     // Catch: JSONException -> L126
        goto L25
    L20:
        r14 = 0;
        goto L21
    L16:
        r13 = 0;
        goto L17
    L12:
        r12 = 0;
        goto L13
    L8:
        r9 = 0;
        r6 = "";
        r7 = r6;
        r8 = r7;
    L126:
        e = e;
        r1 = r2;
    L129:
        monitorDownloadOtherError(e);
        e.printStackTrace();
        return r1;
    L128:
        e = e;
        goto L129
    }

    public static void monitorDownloadConnect(IDownloadHeadHttpConnection r13, String r14, String r15, long r16, String r18, int r19, IOException r20, DownloadInfo r21) {
        IDownloadHeadHttpConnection r4 = (IDownloadHeadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r13, IDownloadHeadHttpConnection.class, "com.obric.aiagent.plugin");
        if (r21 != null) goto L5;
        return;
    L5:
        DownloadSetting r5 = DownloadSetting.obtain(r21.getId());
        int r7 = r5.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT, 0);
        if (r7 > 0) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r14) == false) goto L11;
        return;
    L11:
        int r8 = -1;
        if (r4 != null) goto L72;
    L21:
        String r6 = null;
    L23:
        if (r8 < 200) goto L26;
        if (r8 >= 400) goto L26;
    L41:
        String r0 = null;
    L42:
        Uri r1 = Uri.parse(r14);     // Catch: Throwable -> L66
        String r3 = r1.getHost();     // Catch: Throwable -> L66
        String r10 = r1.getPath();     // Catch: Throwable -> L66
        String r2 = r1.getLastPathSegment();     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r10) == false) goto L45;
    L47:
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L66
        r9.put(DownloadSettingKeys.SETTING_TAG, r5.optString(DownloadSettingKeys.SETTING_TAG));     // Catch: JSONException -> L53 Throwable -> L66
        r9.put(MonitorConstants.URL_HOST, r3);     // Catch: JSONException -> L53 Throwable -> L66
        r9.putOpt(MonitorConstants.HOST_IP, r15);     // Catch: JSONException -> L53 Throwable -> L66
        r9.putOpt(MonitorConstants.HOST_REAL_IP, r6);     // Catch: JSONException -> L53 Throwable -> L66
        r9.put(MonitorConstants.URL_PATH, r10);     // Catch: JSONException -> L53 Throwable -> L66
        r9.put(MonitorConstants.URL_LAST_PATH_SEGMENT, r2);     // Catch: JSONException -> L53 Throwable -> L66
        r9.put(MonitorConstants.NET_LIB, r19);     // Catch: JSONException -> L53 Throwable -> L66
        r9.put(MonitorConstants.CONNECT_TYPE, r18);     // Catch: JSONException -> L53 Throwable -> L66
        r9.put(MonitorConstants.STATUS_CODE, r8);     // Catch: JSONException -> L53 Throwable -> L66
        if (r0 == null) goto L51;
        r9.put("error_msg", DownloadHelper.getFixLengthString(r0, r5.optInt(DownloadSettingKeys.KEY_EXCEPTION_MSG_LENGTH, 500)));     // Catch: JSONException -> L53 Throwable -> L66
    L51:
        r9.put(MonitorConstants.CONNECT_TIME, r16);     // Catch: JSONException -> L53 Throwable -> L66
        r9.put("pkg_name", r21.getPackageName());     // Catch: JSONException -> L53 Throwable -> L66
        r9.put("name", r21.getTitle());     // Catch: JSONException -> L53 Throwable -> L66
    L56:
        if (r7 == 1) goto L58;
        if (r7 == 3) goto L58;
    L62:
        if (r7 == 2) goto L64;
        if (r7 == 3) goto L64;
        return;
    L64:
        DownloadComponentManager.getEventListener().onEvent(r21.getId(), MonitorConstants.DOWNLOAD_CONNECT, r9);     // Catch: Throwable -> L66
        return;
    L58:
        IDownloadMonitorListener r11 = DownloadComponentManager.getDownloadMonitorListener();     // Catch: Throwable -> L66
        if (r11 == null) goto L62;
        r11.monitorEvent(MonitorConstants.DOWNLOAD_CONNECT, r9, null, null);     // Catch: Throwable -> L66
    L53:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L56
    L45:
        if (TextUtils.isEmpty(r2) == true) goto L47;
        r10 = r10.substring(0, r10.length() - r2.length());     // Catch: Throwable -> L69
    L26:
        if (r21.getCurRetryTime() == 0) goto L31;
        int r12 = r21.getHttpStatusCode();     // Catch: Throwable -> L66
        if (r12 < 200) goto L30;
        if (r12 < 400) goto L31;
        return;
    L30:
        return;
    L31:
        if (r20 == null) goto L41;
        if (DownloadUtils.isNetworkConnected((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L35;
    L76:
        DownloadHelper.parseException(r20, "");     // Catch: BaseException -> L39 Throwable -> L66
    L39:
        e = move-exception;
        r8 = e.getErrorCode();     // Catch: Throwable -> L66
        r0 = e.getErrorMessage();     // Catch: Throwable -> L66
        goto L42
    L35:
        if (DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.DISABLE_CHECK_NO_NETWORK) == true) goto L76;
        r8 = DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE;
        goto L41
    L72:
        r8 = r4.getResponseCode();     // Catch: Throwable -> L15
    L19:
        if (ZeusTransformUtils.instanceOf(r4, AbsDownloadHttpConnection.class) == false) goto L21;
        r6 = ((AbsDownloadHttpConnection) ZeusTransformUtils.preCheckCast(r4, AbsDownloadHttpConnection.class, "com.obric.aiagent.plugin")).getHostIp();     // Catch: Throwable -> L66
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorDownloadIO(DownloadSetting r23, DownloadInfo r24, String r25, IDownloadHttpConnection r26, boolean r27, boolean r28, BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, JSONObject r41) {
        IDownloadHttpConnection r7 = (IDownloadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r26, IDownloadHttpConnection.class, "com.obric.aiagent.plugin");
        monitorIO(MonitorConstants.DOWNLOAD_IO, r23.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_IO), r23, r24, r25, null, null, r7, r27, r28, r29, r30, r32, r34, r35, r37, r39, null);
    }

    public static void monitorSegmentIO(DownloadSetting r23, DownloadInfo r24, String r25, String r26, String r27, boolean r28, IDownloadHttpConnection r29, BaseException r30, long r31, long r33) {
        IDownloadHttpConnection r7 = (IDownloadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r29, IDownloadHttpConnection.class, "com.obric.aiagent.plugin");
        monitorIO(MonitorConstants.SEGMENT_IO, r23.optInt(DownloadSettingKeys.MONITOR_SEGMENT_IO), r23, r24, r25, r26, r27, r7, r28, false, r30, r31, r33, false, -1, -1, -1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.ss.android.socialbase.downloader.monitor.InnerEventListener] */
    /* JADX WARN: Type inference failed for: r11v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v16, types: [com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener] */
    private static void monitorIO(String r19, int r20, DownloadSetting r21, DownloadInfo r22, String r23, String r24, String r25, IDownloadHttpConnection r26, boolean r27, boolean r28, BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, JSONObject r41) {
        IDownloadHttpConnection r6 = (IDownloadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r26, IDownloadHttpConnection.class, "com.obric.aiagent.plugin");
        if (r20 > 0) goto L5;
        return;
    L5:
        if (r32 <= 0) goto L80;
        Uri r8 = Uri.parse(r23);     // Catch: Throwable -> L70
        String r9 = r8.getHost();     // Catch: Throwable -> L70
        String r10 = r8.getPath();     // Catch: Throwable -> L70
        String r11 = r8.getLastPathSegment();     // Catch: Throwable -> L70
        if (TextUtils.isEmpty(r10) == false) goto L10;
    L12:
        if (r27 == false) goto L15;
        int r12 = 1;
    L14:
        String r15 = null;
    L26:
        ?? r13 = new JSONObject();     // Catch: Throwable -> L70
        String r16 = "";
        ?? r17 = -1;
        if (r6 != null) goto L29;
        String r7 = "";
        int r14 = -1;
        ?? r18 = -1;
    L48:
        double r0 = r30 / 1048576.0d;     // Catch: Throwable -> L70
        double r3 = r32;
        double r1 = r3 / TimeUnit.SECONDS.toNanos(1);     // Catch: Throwable -> L70
        r13.put(DownloadSettingKeys.SETTING_TAG, r21.optString(DownloadSettingKeys.SETTING_TAG));     // Catch: Throwable -> L70
        r13.put(MonitorConstants.URL_HOST, r9);     // Catch: Throwable -> L70
        r13.putOpt(MonitorConstants.HOST_IP, r24);     // Catch: Throwable -> L70
        r13.putOpt(MonitorConstants.HOST_REAL_IP, r25);     // Catch: Throwable -> L70
        r13.put(MonitorConstants.URL_PATH, r10);     // Catch: Throwable -> L70
        r13.put(MonitorConstants.URL_LAST_PATH_SEGMENT, r11);     // Catch: Throwable -> L70
        r13.put(MonitorConstants.NET_LIB, r14);     // Catch: Throwable -> L70
        r13.put(MonitorConstants.HIT_CDN_CACHE, r18);     // Catch: Throwable -> L70
        r13.put(MonitorConstants.STATUS_CODE, r12);     // Catch: Throwable -> L70
        r13.put(MonitorConstants.REQUEST_LOG, r7);     // Catch: Throwable -> L70
        if (r15 == null) goto L51;
        r13.put("error_msg", DownloadHelper.getFixLengthString(r15, r21.optInt(DownloadSettingKeys.KEY_EXCEPTION_MSG_LENGTH, 500)));     // Catch: Throwable -> L70
    L51:
        r13.put(MonitorConstants.DOWNLOAD_SEC, r1);     // Catch: Throwable -> L70
        r13.put(MonitorConstants.DOWNLOAD_MB, r0);     // Catch: Throwable -> L70
        if (r1 <= 0.0d) goto L54;
        r13.put(MonitorConstants.DOWNLOAD_SPEED, r0 / r1);     // Catch: Throwable -> L70
    L54:
        if (r34 == false) goto L56;
        r13.put(MonitorConstants.RW_READ_TIME, r35 / r3);     // Catch: Throwable -> L70
        r13.put(MonitorConstants.RW_WRITE_TIME, r37 / r3);     // Catch: Throwable -> L70
        r13.put(MonitorConstants.RW_SYNC_TIME, r39 / r3);     // Catch: Throwable -> L70
    L56:
        r13.put("pkg_name", r22.getPackageName());     // Catch: Throwable -> L70
        r13.put("name", r22.getTitle());     // Catch: Throwable -> L70
        if (r20 == 1) goto L61;
        if (r20 == 3) goto L61;
        int r2 = 2;
        String r4 = r19;
    L66:
        if (r20 == r2) goto L68;
        if (r20 == 3) goto L68;
        return;
    L68:
        DownloadComponentManager.getEventListener().onEvent(r22.getId(), r4, r13);     // Catch: Throwable -> L70
        return;
    L61:
        ?? r5 = DownloadComponentManager.getDownloadMonitorListener();     // Catch: Throwable -> L70
        if (r5 == 0) goto L64;
        r4 = r19;
        r5.monitorEvent(r4, r13, null, null);     // Catch: Throwable -> L70
    L65:
        r2 = 2;
        goto L66
    L64:
        r4 = r19;
        goto L65
    L29:
        if (ZeusTransformUtils.instanceOf(r6, IDefaultDownloadHttpConnection.class) == false) goto L31;
        int r110 = 0;
    L32:
        String r111 = r6.getResponseHeaderField(DownloadHelper.X_CACHE);     // Catch: Throwable -> L70
        if (TextUtils.isEmpty(r111) == true) goto L37;
        r17 = r111.toLowerCase().contains("hit");     // Catch: Throwable -> L70
    L37:
        if (r21.optInt(DownloadSettingKeys.MONITOR_SLA, 1) != 1) goto L44;
        if (r27 == true) goto L44;
        if (r28 == true) goto L44;
        if (ZeusTransformUtils.instanceOf(r6, AbsDownloadHttpConnection.class) == false) goto L44;
        ((AbsDownloadHttpConnection) ZeusTransformUtils.preCheckCast(r6, AbsDownloadHttpConnection.class, "com.obric.aiagent.plugin")).monitorNetworkInfo(r13, true);     // Catch: Throwable -> L70
    L44:
        if (ZeusTransformUtils.instanceOf(r6, AbsDownloadHttpConnection.class) == false) goto L46;
        r16 = ((AbsDownloadHttpConnection) ZeusTransformUtils.preCheckCast(r6, AbsDownloadHttpConnection.class, "com.obric.aiagent.plugin")).getRequestLog();     // Catch: Throwable -> L70
    L46:
        r14 = r110;
        r7 = r16;
        r18 = r17;
        goto L48
    L31:
        r110 = 1;
        goto L32
    L15:
        if (r28 == false) goto L17;
        r12 = 2;
        goto L14
    L17:
        if (r29 != null) goto L19;
        r12 = 0;
        goto L14
    L19:
        if (DownloadUtils.isNetworkConnected((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L21;
    L23:
        r12 = r29.getErrorCode();     // Catch: Throwable -> L70
    L24:
        r15 = r29.getErrorMessage();     // Catch: Throwable -> L70
        goto L26
    L21:
        if (DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.DISABLE_CHECK_NO_NETWORK) == true) goto L23;
        r12 = DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE;
        goto L24
    L10:
        if (TextUtils.isEmpty(r11) == true) goto L12;
        r10 = r10.substring(0, r10.length() - r11.length());     // Catch: Throwable -> L73
    L70:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static void monitorSegmentsError(DownloadInfo r4, List<Segment> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put(DBDefinition.SEGMENT_TABLE_NAME, Segment.toString(r6));     // Catch: Throwable -> L7
        r1.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, r4.getCurBytes());     // Catch: Throwable -> L7
        r1.put(MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, r4.getTotalBytes());     // Catch: Throwable -> L7
        InnerEventListener r7 = DownloadComponentManager.getEventListener();     // Catch: Throwable -> L7
        if (r7 == null) goto L12;
        r7.onEvent(r4.getId(), "segments_error", r1);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorDownloadDB(DownloadDBInitInfo r5) {
        IDownloadMonitorListener r0 = DownloadComponentManager.getDownloadMonitorListener();
        if (r0 != null) goto L10;
        return;
    L10:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put(MonitorConstants.DB_INIT_DURATION, r5.initDuration);     // Catch: Throwable -> L7
        r1.put(MonitorConstants.DB_INIT_DISK_CACHE_COUNT, r5.diskCacheCount);     // Catch: Throwable -> L7
        r1.put(MonitorConstants.DB_INIT_MEMORY_CACHE_COUNT, r5.memoryCacheCount);     // Catch: Throwable -> L7
        r1.put(MonitorConstants.DB_INIT_DISK_CACHE_SIZE, r5.diskCacheSize);     // Catch: Throwable -> L7
        r0.monitorEvent(MonitorConstants.DOWNLOAD_DB, r1, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorDownloadCDN(String r5, IDownloadHttpConnection r6, Throwable r7, IDownloadCdnListener r8) {
        IDownloadHttpConnection r9 = (IDownloadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r6, IDownloadHttpConnection.class, "com.obric.aiagent.plugin");
        IDownloadCdnListener r10 = (IDownloadCdnListener) ZeusTransformUtils.wrapperContextForParams(r8, IDownloadCdnListener.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L45;
        if (r5 == null) goto L47;
        DownloadCdnStats r0 = new DownloadCdnStats();
        boolean r2 = false;
        boolean r3 = true;
        if (r9 != null) goto L9;
    L19:
        if (r7 != null) goto L21;
        r3 = r2;
    L34:
        if (r3 == false) goto L46;
        r0.host = Uri.parse(r5).getHost();     // Catch: Throwable -> L38
    L36:
        r10.onCollectStats(r0);
        return;
    L46:
        return;
    L21:
        if (r0.responseCode > 0) goto L43;
        r0.responseCode = ((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getTTNetHandler().getResponseCode(r7);
    L43:
        DownloadHelper.parseException(r7, "monitor_cdn");     // Catch: BaseException -> L25 DownloadTTNetException -> L27
    L32:
        r0.errorMsg = r7.toString();
        goto L34
    L27:
        e = move-exception;
        if (r0.ip != null) goto L31;
        r0.ip = e.getRemoteIp();
    L31:
        r0.errorCode = e.getErrorCode();
    L25:
        e = move-exception;
        r0.errorCode = e.getErrorCode();
        goto L32
    L9:
        if (ZeusTransformUtils.instanceOf(r9, AbsDownloadHttpConnection.class) == false) goto L19;
        AbsDownloadHttpConnection r11 = (AbsDownloadHttpConnection) ZeusTransformUtils.preCheckCast(r9, AbsDownloadHttpConnection.class, "com.obric.aiagent.plugin");
    L16:
        th = move-exception;
        th.printStackTrace();
    L18:
        r2 = true;
        goto L19
    L12:
        if (r11.isOkhttp() == true) goto L14;
        r2 = true;
    L14:
        r0.isTTNet = r2;     // Catch: Throwable -> L16
        r0.responseCode = r11.getResponseCode();     // Catch: Throwable -> L16
        r0.ip = r11.getHostIp();     // Catch: Throwable -> L16
        r0.cacheHit = DownloadHelper.isCdnCacheHit(r11.getResponseHeaders());     // Catch: Throwable -> L16
        goto L18
    L47:
        return;
    }

    public static void monitorDownloadOtherError(Throwable r4) {
        IDownloadMonitorListener r0 = DownloadComponentManager.getDownloadMonitorListener();
        if (r0 != null) goto L10;
        return;
    L10:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put("error_code", DownloadErrorCode.ERROR_MONITOR_REPORT);     // Catch: Throwable -> L7
        r1.put("error_msg", r4.toString());     // Catch: Throwable -> L7
        r1.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, -1);     // Catch: Throwable -> L7
        r1.put(MonitorConstants.EXTRA_DOWNLOAD_ERROR_STACK, Log.getStackTraceString(r4));     // Catch: Throwable -> L7
        r0.monitorEvent(MonitorConstants.EXTRA_DOWNLOAD_SERVICE_NAME_FAIL, r1, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorDownloadApp(DownloadInfo r5, String r6, int r7) {
        IDownloadMonitorListener r0 = DownloadComponentManager.getDownloadMonitorListener();
        if (r0 != null) goto L10;
        return;
    L10:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r5.getMonitorScene());     // Catch: Throwable -> L7
        r1.put("url", r5.getUrl());     // Catch: Throwable -> L7
        r1.put(MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, r5.getTotalBytes());     // Catch: Throwable -> L7
        r1.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, r5.getCurBytes());     // Catch: Throwable -> L7
        r1.put(MonitorConstants.EXTRA_DOWNLOAD_SAVE_PATH, r5.getSavePath());     // Catch: Throwable -> L7
        r1.put(MonitorConstants.APP_INSTALL_STATUS, r6);     // Catch: Throwable -> L7
        r1.put(MonitorConstants.APP_INSTALL_RESULT_CODE, r7);     // Catch: Throwable -> L7
        r0.monitorEvent(MonitorConstants.DOWNLOAD_INSTALL_APP, r1, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }
}
