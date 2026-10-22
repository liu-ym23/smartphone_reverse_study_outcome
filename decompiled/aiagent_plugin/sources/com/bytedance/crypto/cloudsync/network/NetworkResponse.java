package com.bytedance.crypto.cloudsync.network;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NetworkResponse {
    private int code;
    private List<SyncKeyData> keyDataList;
    private String message;
    private String serverPubKey;

    public NetworkResponse(int r3, String r4, List<SyncKeyData> r5, String r6) {
        List<SyncKeyData> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.code = r3;
        this.message = r4;
        this.keyDataList = r7;
        this.serverPubKey = r6;
    }

    public int getCode() {
        return this.code;
    }

    public List<SyncKeyData> getKeyDataList() {
        return this.keyDataList;
    }

    public String getMessage() {
        return this.message;
    }

    public String getServerPubKey() {
        return this.serverPubKey;
    }
}
