package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.callback.IPatchConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PatchMessageHandler extends BaseMessageHandler {
    private static final String KEY_MD5 = "md5";
    private static final String KEY_URL = "url";
    private IPatchConsumer mPatchConsumer;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.PATCH;
    }

    public PatchMessageHandler() {
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r5) throws Exception {
        JSONObject r0 = new JSONObject(r5.getParams());
        if (this.mPatchConsumer != null) goto L7;
        return false;
    L7:
        if (checkWifiOnly(r0, r5) == false) goto L9;
        return true;
    L9:
        String r1 = r0.optString("url");
        String r2 = r0.optString(KEY_MD5);
        this.mPatchConsumer.handlePatchMessage(r1, r2);
        ConsumerResult r3 = this.mPatchConsumer.getConsumerResult();
        if (r3.isSuccess() == false) goto L12;
        uploadSuccessStatus(r5);
    L13:
        return true;
    L12:
        uploadFailStatus(r3.getErrMsg(), r3.getSpecificParams(), r5);
        goto L13
    }

    public void setPatchConsumer(IPatchConsumer r1) {
        this.mPatchConsumer = r1;
    }
}
