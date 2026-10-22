package com.monitor.cloudmessage.entity;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CloudMessage {
    private String mCommandId;
    private String mParams;
    private JSONObject mParamsJson;

    @Deprecated
    private long mSendTime;
    private String mType;
    private String messageString;

    public CloudMessage() {
    }

    public String getParams() {
        return this.mParams;
    }

    public String getMessageString() {
        return this.messageString;
    }

    public static CloudMessage fromString(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L15;
        return null;
    L15:
        CloudMessage r0 = new CloudMessage();     // Catch: Exception -> L10
        JSONObject r2 = new JSONObject(r5);     // Catch: Exception -> L10
        r0.mCommandId = r2.optString("command_id");     // Catch: Exception -> L10
        r0.mType = r2.optString("type");     // Catch: Exception -> L10
        String r3 = r2.optString("params");     // Catch: Exception -> L10
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r4 = new JSONObject(r3);     // Catch: Exception -> L10
    L8:
        r0.mParams = r3;     // Catch: Exception -> L10
        r0.mParamsJson = r4;     // Catch: Exception -> L10
        r0.messageString = r5;     // Catch: Exception -> L10
        return r0;
    L10:
        e = move-exception;
        if (ApmContext.isDebugMode() == false) goto L14;
        Logger.printErrStackTrace("cloudmessage", e, new String[]{"Parse CloudMessage Error."});
    L14:
        return null;
    }

    public JSONObject getParamsJson() {
        return this.mParamsJson;
    }

    public boolean isWifiOnly() {
        return this.mParamsJson.optBoolean("wifiOnly");
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String r1) {
        this.mType = r1;
    }

    @Deprecated
    public long getSendTime() {
        return this.mSendTime;
    }

    @Deprecated
    public void setSendTime(long r1) {
        this.mSendTime = r1;
    }

    public String getCommandId() {
        return this.mCommandId;
    }

    public String toString() {
        return "CloudMessage{mParams='" + this.mParams + "', mType=" + this.mType + ", send_time=" + this.mSendTime + ", command_id='" + this.mCommandId + "'}";
    }
}
