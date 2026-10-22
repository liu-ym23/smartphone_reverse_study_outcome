package com.monitor.cloudmessage.handler.impl;

import com.monitor.cloudmessage.callback.IPluginConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.monitor.cloudmessage.handler.BaseMessageHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PluginMessageHandler extends BaseMessageHandler {
    private static final String KEY_MD5 = "md5";
    private static final String KEY_PACKAGENAME = "packageName";
    private static final String KEY_URL = "url";
    private static final String KEY_VERSIONCODE = "versionCode";
    private static final String KEY_WIFIONLY = "wifiOnly";
    private IPluginConsumer mPluginConsumer;

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public String getCloudControlType() {
        return CloudControlInf.PLUGIN;
    }

    public PluginMessageHandler() {
    }

    @Override // com.monitor.cloudmessage.handler.BaseMessageHandler
    public boolean handleMessage(CloudMessage r10) throws Exception {
        JSONObject r0 = new JSONObject(r10.getParams());
        if (this.mPluginConsumer != null) goto L5;
        return false;
    L5:
        String r4 = r0.optString(KEY_PACKAGENAME);
        int r5 = r0.optInt(KEY_VERSIONCODE);
        String r6 = r0.optString("url");
        String r7 = r0.optString(KEY_MD5);
        boolean r8 = r0.optBoolean(KEY_WIFIONLY, false);
        this.mPluginConsumer.handlePluginMessage(r4, r5, r6, r7, r8);
        ConsumerResult r1 = this.mPluginConsumer.getConsumerResult();
        if (r1.isSuccess() == false) goto L8;
        uploadSuccessStatus(r10);
        return true;
    L8:
        uploadFailStatus(r1.getErrMsg(), r1.getSpecificParams(), r10);
        return true;
    }

    public void setPluginConsumer(IPluginConsumer r1) {
        this.mPluginConsumer = r1;
    }
}
