package com.bytedance.apm6.consumer.slardar.send;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm.ZstdDictManager;
import com.bytedance.apm.doctor.DoctorConstants;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeController;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.apm6.service.http.HttpRequest;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.common.utility.date.DateDef;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import com.bytedance.services.slardar.config.IConfigManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkSender {
    private static final String FORCE_ZSTD_TIMESTAMP = "force_zstd_timestamp";
    private static final String HEADER_LEVEL = "Content-Encoding-Level";
    private static final int LEVEL = 15;
    private static final int MIN_COMPRESS_LEN = 128;
    private static final String RESPONSE_DELAY = "delay";
    private static final String RESPONSE_DOWNGRADE_RULE = "downgrade_rule";
    private static final String RESPONSE_MESSAGE = "message";
    private static final String RESPONSE_MESSAGE_DROP_DATA = "drop data";
    private static final String RESPONSE_MESSAGE_SUCCESS = "success";
    private static final String RESPONSE_REDIRECT = "redirect";
    private static final String RESPONSE_SERVER_CODE = "server_code";
    private static final long SERVER_CODE_ZSTD_DICT_FIND_FAILED = 10001;
    private static final String TT_LOG_ID = "x-tt-logid";
    private static volatile int compressType;
    private static HashMap<UploadLogInfo, NetworkSender> map;
    private int callstackDepth;
    private int channelPosition;
    private String lastChannelUrl;
    private volatile boolean moreChannelSwitch;
    private Boolean preNetworkError;
    private String redirectHost;
    private List<String> urls;
    private IZstdDict zstdDict;
    private IZstdCompress zstdService;

    static {
        map = new HashMap();
    }

    private NetworkSender(UploadLogInfo r2) {
        this.lastChannelUrl = null;
        this.callstackDepth = 0;
        this.urls = r2.getUrls();
    }

    public static NetworkSender getInstance(UploadLogInfo r2) {
        if (map.containsKey(r2) == true) goto L5;
        map.put(r2, new NetworkSender(r2));
        return map.get(r2);
    L5:
        return map.get(r2);
    }

    public static void setCompressType(int r4) {
        if (r4 != 2) goto L8;
        long r0 = ApmContext.getContext().getSharedPreferences(ZstdDictManager.DICT_INTERVAL, 0).getLong(FORCE_ZSTD_TIMESTAMP, 0);
        if ((System.currentTimeMillis() - r0) > DateDef.HOUR) goto L8;
        compressType = 1;
        return;
    L8:
        compressType = r4;
    }

    private void updateZstdHost(String r2) {
        if (this.zstdDict != null) goto L6;
        this.zstdDict = (IZstdDict) ServiceManager.getService(IZstdDict.class);
    L6:
        if (this.zstdDict == null) goto L12;
        URL r0 = new URL(r2);     // Catch: MalformedURLException -> L9
        this.zstdDict.setDomain(r0.getHost());     // Catch: MalformedURLException -> L9
        return;
    L13:
        return;
    }

    public static void restart() {
        map.clear();
    }

    byte[] appendSettingsParams(byte[] r4) throws JSONException {
        JSONObject r3 = new JSONObject(new String(r4));
        IConfigManager r5 = (IConfigManager) com.bytedance.news.common.service.manager.ServiceManager.getService(IConfigManager.class);
        if (r5 == null) goto L10;
        JSONObject r6 = r5.retrieveSettingsParams();
        JSONObject r0 = new JSONObject();
        String r1 = String.valueOf(ApmContext.getAid());
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if (r1.equals("0") == true) goto L10;
        r0.put(r1, r6);
        r3.put("settings_params", r0);
    L10:
        return r3.toString().getBytes();
    }

    boolean sendLog(byte[] r22) {
        if (r22 != null) goto L5;
    L113:
        return true;
    L5:
        if (r22.length == 0) goto L113;
        String r11 = getReportUrl();     // Catch: Throwable -> L110
        updateZstdHost(r11);     // Catch: Throwable -> L110
        byte[] r0 = appendSettingsParams(r22);     // Catch: JSONException -> L11 Throwable -> L110
    L14:
        HttpRequest r2 = createRequest(r11, r0, false);     // Catch: Throwable -> L110
        if (ApmContext.isDebugMode() == false) goto L18;
        DoctorManager.getInstance().onEvent(DoctorConstants.APM_SEND_DATA, "url:" + r2.url + " header:" + r2.headerMap);     // Catch: Throwable -> L110
        Logger.d(Constants.TAG, "sendLog createRequest: origin Bytes=" + r0.length + " compressed Bytes=" + r2.data.length + " url=" + r2.url + " headers=" + r2.headerMap);     // Catch: Throwable -> L110
    L18:
        HttpResponse r5 = ApmContext.doPost(r2.url, r2.headerMap, r2.data);     // Catch: Throwable -> L110
        if (ApmContext.isDebugMode() == false) goto L25;
        String r7 = Constants.TAG;     // Catch: Throwable -> L110
        StringBuilder r12 = new StringBuilder("http result:");     // Catch: Throwable -> L110
        if (r5 != null) goto L23;
        Object r6 = -1;     // Catch: Throwable -> L110
    L24:
        Logger.d(r7, r12.append(r6).toString());     // Catch: Throwable -> L110
        goto L25
    L23:
        r6 = r5.getStatusCode() + " header:" + r5.getHeaders();     // Catch: Throwable -> L110
    L25:
        this.redirectHost = null;     // Catch: Throwable -> L110
        this.lastChannelUrl = null;     // Catch: Throwable -> L110
        if (r5 != null) goto L28;
    L102:
        this.moreChannelSwitch = true;     // Catch: Throwable -> L110
        Boolean r1 = this.preNetworkError;     // Catch: Throwable -> L110
        if (r1 != null) goto L105;
    L107:
        this.preNetworkError = true;     // Catch: Throwable -> L110
        return false;
    L105:
        if (r1.booleanValue() == false) goto L107;
        LogReportController.getInstance().shortBackOff();     // Catch: Throwable -> L110
        goto L107
    L28:
        if (r5.getStatusCode() <= 0) goto L102;
        this.moreChannelSwitch = false;     // Catch: Throwable -> L110
        if (500 <= r5.getStatusCode()) goto L33;
    L41:
        JSONObject r8 = getData(r5);     // Catch: Throwable -> L110
        if (r8 != null) goto L44;
    L100:
        this.preNetworkError = true;     // Catch: Throwable -> L110
        return false;
    L44:
        if (r5.getStatusCode() != 200) goto L100;
        String r9 = r8.optString("message");     // Catch: Throwable -> L110
        String r13 = r8.optString("redirect");     // Catch: Throwable -> L110
        long r14 = r8.optLong("delay");     // Catch: Throwable -> L110
        if (r8.optLong(RESPONSE_SERVER_CODE, 0) == SERVER_CODE_ZSTD_DICT_FIND_FAILED) goto L49;
    L56:
        JSONObject r3 = r8.optJSONObject("settings_info");     // Catch: Throwable -> L110
        if (r3 == null) goto L64;
        IConfigManager r10 = (IConfigManager) com.bytedance.news.common.service.manager.ServiceManager.getService(IConfigManager.class);     // Catch: Throwable -> L110
        if (r10 == null) goto L64;
        JSONObject r4 = r3.optJSONObject(String.valueOf(ApmContext.getAid()));     // Catch: Throwable -> L110
        if (r4 == null) goto L64;
        r10.updateWithSpecificAidResult(r4);     // Catch: Throwable -> L110
    L64:
        if ("success".equals(r9) == false) goto L66;
        LogReportController.getInstance().restore();     // Catch: Throwable -> L110
        this.lastChannelUrl = r11;     // Catch: Throwable -> L110
        this.preNetworkError = false;     // Catch: Throwable -> L110
        boolean r15 = true;
        boolean r16 = false;
    L115:
    L85:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L110
    L87:
        JSONObject r17 = r8.optJSONObject(RESPONSE_DOWNGRADE_RULE);     // Catch: Throwable -> L110
        if (r17 == null) goto L90;
        DowngradeController.getInstance().setDowngradeInfo(DowngradeInfo.parse(r17), true);     // Catch: Throwable -> L110
    L90:
        this.redirectHost = r13;     // Catch: Throwable -> L110
        if (r14 <= 0) goto L93;
        LogReportController.getInstance().delayReport(r14);     // Catch: Throwable -> L110
    L93:
        if (r16 == false) goto L98;
        LogReportController.getInstance().dropData();     // Catch: Throwable -> L110
        if (r5.getHeaders() == null) goto L97;
        DropDataMonitor.getInstance().setServerLogId(r5.getHeaders().get("x-tt-logid"));     // Catch: Throwable -> L110
    L97:
        DropDataMonitor.getInstance().setServerTimeStamp(System.currentTimeMillis());     // Catch: Throwable -> L110
    L99:
        return r15;
    L98:
        LogReportController.getInstance().recoveryFromDropData();     // Catch: Throwable -> L110
        goto L99
    L71:
        if (ApmContext.isDebugMode() == false) goto L87;
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L85
        r18.put(DoctorConstants.RESPONSE_DATA_URL, r2.url);     // Catch: Throwable -> L85
        if (r5.getHeaders() == null) goto L83;
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L85
        Iterator<Map.Entry<String, String>> r20 = r5.getHeaders().entrySet().iterator();     // Catch: Throwable -> L85
    L76:
        if (r20.hasNext() == false) goto L82;
        Map.Entry<String, String> r110 = r20.next();     // Catch: Throwable -> L85
        if (r110.getKey() == null) goto L76;
        r19.put(r110.getKey(), r110.getValue());     // Catch: Throwable -> L114
        goto L76
    L82:
        r18.put(DoctorConstants.RESPONSE_DATA_HEADERS, r19);     // Catch: Throwable -> L85
    L83:
        r18.put(DoctorConstants.RESPONSE_DATA_BODY_TEXT, r8);     // Catch: Throwable -> L85
        DoctorDataUtil.sendResponseEvent(r0, r18);     // Catch: Throwable -> L85
    L66:
        this.preNetworkError = true;     // Catch: Throwable -> L110
        r16 = "drop data".equals(r9);     // Catch: Throwable -> L110
        if (ApmContext.isDebugMode() == false) goto L69;
        Logger.d(Constants.TAG, "responseMessage:" + r9);     // Catch: Throwable -> L110
    L69:
        r15 = false;
        goto L115
    L49:
        if (compressType != 2) goto L56;
        if (this.zstdService == null) goto L56;
        if (this.callstackDepth != 0) goto L56;
        compressType = 1;     // Catch: Throwable -> L110
        ApmContext.getContext().getSharedPreferences(ZstdDictManager.DICT_INTERVAL, 0).edit().putLong(ZstdDictManager.DICT_INTERVAL, 0).putLong(FORCE_ZSTD_TIMESTAMP, System.currentTimeMillis()).commit();     // Catch: Throwable -> L110
        this.callstackDepth++;     // Catch: Throwable -> L110
        boolean r21 = sendLog(r0);     // Catch: Throwable -> L110
        this.callstackDepth--;     // Catch: Throwable -> L110
        return r21;
    L33:
        if (r5.getStatusCode() > 600) goto L41;
        Boolean r23 = this.preNetworkError;     // Catch: Throwable -> L110
        if (r23 != null) goto L37;
    L39:
        this.preNetworkError = true;     // Catch: Throwable -> L110
        return false;
    L37:
        if (r23.booleanValue() == false) goto L39;
        LogReportController.getInstance().longBackOff();     // Catch: Throwable -> L110
        goto L39
    L11:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "NetworkSender->sendLog(byte[] bytes)");     // Catch: Throwable -> L110
        Logger.e(Constants.TAG, " appendSettingsParams wrong ");     // Catch: Throwable -> L110
        r0 = r22;
    L110:
        th = move-exception;
        Logger.e(Constants.TAG, "sendLog failed.", th);
        return false;
    }

    private JSONObject getData(HttpResponse r8) {
        JSONObject r3 = new JSONObject(new String(r8.getResponseBytes()));     // Catch: Exception -> L25
        Map<String, String> r9 = r8.getHeaders();     // Catch: Exception -> L25
        if (r9 != null) goto L6;
    L11:
        String r4 = null;
    L27:
        String r10 = r3.optString("data");     // Catch: Throwable -> L23
        boolean r6 = true;
        if (r10.isEmpty() == false) goto L15;
    L18:
        handleResponse(r3);     // Catch: Throwable -> L23
        if (r6 == true) goto L22;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L23
        r7.put("message", "success");     // Catch: Throwable -> L23
        return r7;
    L22:
        return r3;
    L15:
        if (TextUtils.isEmpty(r4) == true) goto L17;
        String r11 = decodeData(r10.getBytes(), r4);     // Catch: Throwable -> L23
        r3 = new JSONObject(r11);     // Catch: Throwable -> L23
        r6 = true ^ TextUtils.isEmpty(r11);     // Catch: Throwable -> L23
        goto L18
    L17:
        r3 = new JSONObject(new String(r10.getBytes()));     // Catch: Throwable -> L23
    L23:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L25
        r12.put("message", "success");     // Catch: Exception -> L25
        return r12;
    L6:
        if (r9.isEmpty() == true) goto L11;
        r4 = r9.get("ran");     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r4) == false) goto L27;
        r4 = r9.get(CommonConsts.KEY_DECODE_RAN);     // Catch: Exception -> L25
    L25:
        return null;
    }

    private String getReportUrl() {
        List<String> r1 = this.urls;
        if (TextUtils.isEmpty(this.redirectHost) == true) goto L13;
        if (r1 != null) goto L7;
    L11:
        return null;
    L7:
        if (r1.size() <= 0) goto L11;
        return "https://" + this.redirectHost + new URL(r1.get(0)).getPath();
    L13:
        if (TextUtils.isEmpty(this.lastChannelUrl) == true) goto L17;
        return this.lastChannelUrl;
    L17:
        if (this.moreChannelSwitch == false) goto L19;
        this.channelPosition++;
    L19:
        int r0 = r1.size();
        int r2 = this.channelPosition;
        if (r0 <= r2) goto L23;
        if (r2 < 0) goto L23;
        return r1.get(r2);
    L23:
        this.channelPosition = 0;
        return r1.get(0);
    }

    private HttpRequest createRequest(String r9, byte[] r10, boolean r11) {
        HashMap r0 = new HashMap();
        HashMap r1 = new HashMap(ApmContext.getUrlParams());
        r0.put("Accept-Encoding", "gzip");
        byte[] r5 = null;
        if (r10.length > 128) goto L5;
    L38:
        if (r5 == null) goto L41;
        r10 = r5;
    L41:
        r0.put("Content-Type", "application/json; charset=utf-8");
        if (LogReportController.getInstance().isEncrypt() == false) goto L56;
        byte[] r12 = encrypt(r10);
        if (r12 == null) goto L55;
        r1.put("tt_data", "a");
        String r13 = UrlUtils.addParamsToURL(r9, r1);
        r0.put("Content-Type", "application/octet-stream;tt-data=a");
        if (ApmContext.isDebugMode() == false) goto L48;
        Logger.d(Constants.TAG, "before encrypt url:" + r13);
    L48:
        LinkedList r14 = new LinkedList();
        String r8 = tryEncryptRequest(r13, r14);
        if (TextUtils.isEmpty(r8) == true) goto L52;
        r13 = r8;
    L52:
        if (ApmContext.isDebugMode() == false) goto L54;
        Logger.d(Constants.TAG, "after encrypt url:" + r13);
    L54:
        r0.putAll(ListUtils.listToMap(r14));
        r10 = r12;
    L57:
        r0.put("Version-Code", "1");
        return new HttpRequest(r13, r0, r10);
    L55:
        r13 = UrlUtils.addParamsToURL(r9, r1);
        goto L57
    L56:
        r13 = UrlUtils.addParamsToURL(r9, r1);
        goto L57
    L5:
        if (r11 == false) goto L7;
    L34:
        if (r5 != null) goto L38;
        r5 = compress(r10);
        if (r5 == null) goto L38;
        r0.put("Content-Encoding", "gzip");
        goto L38
    L7:
        if (this.zstdService != null) goto L10;
        this.zstdService = (IZstdCompress) ServiceManager.getService(IZstdCompress.class);
    L10:
        if (compressType != 1) goto L18;
        IZstdCompress r15 = this.zstdService;
        if (r15 == null) goto L18;
        byte[] r16 = r15.compress(r10, 15);
        if (r16 == null) goto L16;
        r0.put("Content-Encoding", NetConst.TYPE_ZSTD);
        r0.put(HEADER_LEVEL, String.valueOf(15));
    L16:
        r5 = r16;
    L18:
        if (compressType != 2) goto L34;
        if (this.zstdService == null) goto L34;
        if (this.zstdDict != null) goto L24;
        this.zstdDict = (IZstdDict) ServiceManager.getService(IZstdDict.class);
    L24:
        IZstdDict r17 = this.zstdDict;
        if (r17 == null) goto L29;
        Pair<byte[], String> r18 = r17.getDictAndDictVersion();
        byte[] r4 = (byte[]) r18.first;
        String r19 = (String) r18.second;
        if (r4 == null) goto L30;
        r5 = this.zstdService.compress(r10, r4, 15);
    L30:
        if (r5 == null) goto L34;
        r0.put("Content-Encoding", NetConst.TYPE_ZSTD_DICT);
        r0.put(HEADER_LEVEL, String.valueOf(15));
        if (TextUtils.isEmpty(r19) == true) goto L34;
        r0.put(ZstdDictManager.DICT_VERSION_HEADER_KEY, r19);
        r1.put(ZstdDictManager.DICT_VERSION_HEADER_KEY, r19);
        goto L34
    L29:
        r19 = null;
        goto L30
    }

    private byte[] compress(byte[] r3) {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r0 = null;
        GZIPOutputStream r1 = new GZIPOutputStream(r2);     // Catch: Throwable -> L9 IOException -> L12
        r1.write(r3);     // Catch: Throwable -> L7 IOException -> L15
        IOUtils.closeQuietly(r1);
        return r2.toByteArray();
    L7:
        th = th;
        r0 = r1;
    L10:
        IOUtils.closeQuietly(r0);
        throw th;
    L13:
        IOUtils.closeQuietly(r1);
        return null;
    L12:
        r1 = null;
    L9:
        th = th;
        goto L10
    }

    private byte[] encrypt(byte[] r1) {
        IEncrypt r0 = (IEncrypt) ServiceManager.getService(IEncrypt.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.encrypt(r1);
    }

    private String tryEncryptRequest(String r1, List<Pair<String, String>> r2) {
        EncryptService r0 = (EncryptService) ServiceManager.getService(EncryptService.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.tryEncryptRequest(r1, r2);
    }

    private String decodeData(byte[] r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L12;
        return "";
    L12:
        SecretKeySpec r2 = new SecretKeySpec(r4.getBytes(), "AES");     // Catch: Throwable -> L7
        Cipher r5 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Throwable -> L7
        r5.init(2, r2);     // Catch: Throwable -> L7
        return new String(r5.doFinal(Base64.decode(r3, 0))).replaceAll("\\$+$", "");
    L7:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L11;
        Logger.e(Constants.TAG, "decodeData", th);
    L11:
        return "";
    }

    private void handleResponse(JSONObject r1) {
        if (JsonUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        JSONObject r0 = r1.optJSONObject(Constants.KEY_CONFIG);
        if (JsonUtils.isEmpty(r0) == false) goto L8;
        return;
    L8:
        SlardarResponseService r2 = (SlardarResponseService) ServiceManager.getService(SlardarResponseService.class);
        if (r2 == null) goto L12;
        r2.onResponse(r0);
        return;
    }
}
