package com.bytedance.privacy.pcc.network.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* JADX INFO: loaded from: classes.dex */
public class UploadChannelRetResponse {
    private final String logId;

    private UploadChannelRetResponse(String r1) {
        this.logId = r1;
    }

    public String getLogId() {
        return this.logId;
    }

    public static UploadChannelRetResponse parse(String r3) {
        JsonObject r4 = JsonParser.parseString(r3).getAsJsonObject();
        int r0 = r4.get(MonitorConstants.CODE).getAsInt();
        if (r0 != 0) goto L11;
        if (r4.has("log_id") == false) goto L7;
        String r5 = r4.get("log_id").getAsString();
    L9:
        return new UploadChannelRetResponse(r5);
    L7:
        r5 = "";
        goto L9
    L11:
        throw new Exception("unexpected server code=" + r0);
    }
}
