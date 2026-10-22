package com.ss.bduploader;

import android.text.TextUtils;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.TreeMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BDVideoUploader extends BDVideoUploaderBase {
    public static final int RoutingQUIC = 0;
    public static final int RoutingTCP = 1;
    private boolean hasInit;
    private int mEstimatedFileSize;
    private int mEstimatedVideoDuration;
    private JSONObject mEstimatedVideoInfo;
    private int mEstimatedVideoRate;
    private com.ss.bduploader.b.b mSmartRouting;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public BDVideoUploader() {
        this.hasInit = false;
        this.mEstimatedVideoRate = 0;
        this.mEstimatedVideoDuration = 0;
        this.mEstimatedFileSize = -1;
    }

    public void setProcessActionType(int r5) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, 65, r5);
    }

    public void setPolicyParams(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 == null) goto L12;
        String r6 = t.a(r5);
        if (TextUtils.isEmpty(r6) == true) goto L11;
        setStringValue(55, r6);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void setConfig(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 == null) goto L12;
        String r6 = t.a(r5);
        if (r6 == null) goto L11;
        setStringValue(56, r6);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void setQueryAuth(String r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(this.mHandle, 15, r5);
        return;
    L9:
        return;
    }

    public void setExternFileReader(a r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        if (this.mHandle == 0) goto L8;
        if (r6 == null) goto L9;
        _setIntValue(this.mHandle, 71, 1);
        _setObject(this.mHandle, 200, r6);
        return;
    L9:
        return;
    }

    public void setCustomConfig(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L21;
        if (r5 == null) goto L22;
        JSONObject r6 = t.b(r5);
        if (r6 != null) goto L9;
        return;
    L9:
        JSONObject r0 = new JSONObject();
        r0.put("custom_config", r6);     // Catch: Throwable -> L15
        String r7 = r0.toString();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r7) == true) goto L20;
        setStringValue(63, r7);
        return;
    L20:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L22:
        return;
    }

    @Override // com.ss.bduploader.BDVideoUploaderBase
    public void allowMergeUpload() {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _mergeUpload(this.mHandle);
    }

    @Override // com.ss.bduploader.BDVideoUploaderBase
    public void setPreUploadEncryptionMode(int r5) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, 74, r5);
    }

    public void cancelUpload() {
        this.mWriteLock.lock();
        if (this.mHandle != 0) goto L6;
        this.mWriteLock.unlock();
        return;
    L6:
        _cancelUpload(this.mHandle);
        this.mWriteLock.unlock();
    }

    public void setNetworkType(int r5, int r6) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, r5, r6);
    }

    public void setSpeedTestValue(int r5) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, 405, r5);
    }

    public void setSpeedTestThresh(int r5) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, 406, r5);
    }

    public void setExternMinSIze(int r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 <= 0) goto L9;
        _setIntValue(this.mHandle, 77, r5);
        return;
    L9:
        return;
    }

    public void setDataTransportProtocol(int r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(this.mHandle, 411, r5);
        return;
    L9:
        return;
    }

    public void setContext(String r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        _setContext(this.mHandle, r5);
        return;
    L9:
        return;
    }

    public void setExternalReaderMode(int r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(this.mHandle, 412, r5);
        return;
    L9:
        return;
    }

    public void setPrivateVideo(boolean r5) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, BDVideoUploaderBase.KeyIsPrivateVideo, r5 ? 1 : 0);
    }

    public void setAuthType(int r5) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, 416, r5);
    }

    public void setUserReference(String r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(this.mHandle, 62, r5);
        return;
    L9:
        return;
    }

    public void setCustomNetworkTimeoutParams(int r5, int r6, int r7, int r8, int r9) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSocketConnectTimeout, r5);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSocketReadTimeout, r6);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSocketWriteTimeout, r7);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsTotalRequestTimeout, r8);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSDKRetryPolicy, r9);
    }

    public void setRetryStatesOption(int r5) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsRetryStatesOption, r5);
    }

    public void setTTNetEngineFallbackOption(int r5) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, 437, r5);
    }

    public void setEstimatedVideoInfo(TreeMap<String, Object> r6) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L18;
        JSONObject r7 = t.b(r6);
        this.mEstimatedVideoInfo = r7;
        if (r7 != null) goto L10;
        return;
    L10:
        INVOKESTATIC_com_ss_bduploader_BDVideoUploader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ttmn", "Estimated video info:" + this.mEstimatedVideoInfo);
        this.mEstimatedVideoDuration = this.mEstimatedVideoInfo.getInt("durationMs") / 1000;     // Catch: JSONException -> L13
        this.mEstimatedVideoRate = this.mEstimatedVideoInfo.getInt("bitrateKb");     // Catch: JSONException -> L13
        _setStringValue(this.mHandle, 436, this.mEstimatedVideoInfo.toString());     // Catch: JSONException -> L13
        INVOKESTATIC_com_ss_bduploader_BDVideoUploader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ttmn", "Grab estimated video info" + this.mEstimatedVideoInfo + " duration:" + this.mEstimatedVideoDuration + " bitrate:" + this.mEstimatedVideoRate);     // Catch: JSONException -> L13
        return;
    L13:
        INVOKESTATIC_com_ss_bduploader_BDVideoUploader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ttmn", "Grab estimated video info error, duration:" + this.mEstimatedVideoDuration + " bitrate:" + this.mEstimatedVideoRate);
        return;
    }

    @Override // com.ss.bduploader.BDAbstractUpload
    public String intelligentInterface(int r3, String r4) {
        INVOKESTATIC_com_ss_bduploader_BDVideoUploader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ttmn", "intelligentInterface:what:" + r3 + ",value:" + r4);
        if (r3 != 0) goto L5;
        checkAndInit(r4);
        preloadModel();
    L9:
        JSONObject r2 = null;
    L10:
        if (r2 != null) goto L13;
        return "";
    L13:
        INVOKESTATIC_com_ss_bduploader_BDVideoUploader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("intelligent_routing", "prediction result: " + r2.toString());
        return r2.toString();
    L5:
        if (r3 != 1) goto L9;
        r2 = processIntelligentPrediction(predictIntelligentTCPQUIC(insertFileSizeInfo(r4)));
        goto L10
    }

    private JSONObject processIntelligentPrediction(float r7) {
        INVOKESTATIC_com_ss_bduploader_BDVideoUploader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("intelligent routing", "process prediction result:" + r7);
        JSONObject r6 = new JSONObject();
        if (r7 >= 0.0f) goto L5;
    L15:
        return null;
    L5:
        if (r7 > 1.0f) goto L15;
        if (r7 < 0.5d) goto L10;
        r6.put("intelligentRoutingResult", 1);     // Catch: JSONException -> L13
    L16:
        return r6;
    L10:
        r6.put("intelligentRoutingResult", 0);     // Catch: JSONException -> L13
    L19:
        return null;
    }

    private float predictIntelligentTCPQUIC(String r3) {
        if (this.mSmartRouting != null) goto L9;
        return -1.0f;
    L9:
        JSONObject r0 = new JSONObject(r3);     // Catch: Exception -> L8
        return this.mSmartRouting.a(r0);
    L8:
        return -1.0f;
    }

    private String insertFileSizeInfo(String r5) {
        int r0 = this.mEstimatedVideoDuration * this.mEstimatedVideoRate;     // Catch: Exception -> L8
        if (r0 <= 0) goto L5;
        int r1 = r0;
    L6:
        this.mEstimatedFileSize = r1;     // Catch: Exception -> L8
        INVOKESTATIC_com_ss_bduploader_BDVideoUploader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("ttmn", "Used estimated file size: " + this.mEstimatedFileSize + "calculated:" + r0);     // Catch: Exception -> L8
        JSONObject r2 = new JSONObject(r5);     // Catch: Exception -> L8
        r2.put("est_file_size", this.mEstimatedFileSize / 1024);     // Catch: Exception -> L8
    L9:
        if (r2 != null) goto L12;
        return r5;
    L12:
        return r2.toString();
    L5:
        r1 = this.mEstimatedFileSize;     // Catch: Exception -> L8
    L8:
        r2 = null;
        goto L9
    }

    private void checkAndInit(String r2) {
        if (this.hasInit == false) goto L5;
        return;
    L5:
        this.hasInit = true;
        com.ss.bduploader.b.b r0 = new com.ss.bduploader.b.b();
        this.mSmartRouting = r0;
        r0.a();
        this.mSmartRouting.a(r2);
        this.mSmartRouting.b();
    }

    private void preloadModel() {
        com.ss.bduploader.b.b r0 = this.mSmartRouting;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_bduploader_BDVideoUploader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
