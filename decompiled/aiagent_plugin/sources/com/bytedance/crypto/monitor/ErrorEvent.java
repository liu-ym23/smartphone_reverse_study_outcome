package com.bytedance.crypto.monitor;

import com.bytedance.crypto.monitor.proto.CloudSyncData;
import com.bytedance.crypto.monitor.proto.CryptoSDKInfo;
import com.bytedance.crypto.monitor.proto.ErrorTrace;
import com.bytedance.crypto.monitor.proto.NormalTrace;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ErrorEvent {
    private static final String TAG = "ErrorEvent";

    public ErrorEvent() {
    }

    public static void eventTrace(int r3, int r4, String r5, String r6, int r7, long r8, Object r10) {
        LogUtils.i(TAG, "eventTrace, module: " + r3 + ", event: " + r4 + ", pkgName: " + r5 + ", appid: " + r6 + ", errCode: " + r7);
        ErrorTrace r0 = ErrorTrace.newBuilder().setModuleId(r3).setEventId(r4).setPackageName(r5).setErrCode(r7).build();
        if (r10 != null) goto L5;
    L7:
        Monitor.writeEvent(CryptoSDKInfo.newBuilder().setVersion(1).setTimestamp(System.currentTimeMillis()).addErrorTrace(r0).addNormalTrace(NormalTrace.newBuilder().setModuleId(r3).setEventId(r4).setPackageName(r5).setAppId(r6).setUserid(0).setErrCode(r7).setTotalCalls(1).setTimeConsumption(r8).setTotalDataSize(0)).build().toBuilder());
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r10, CloudSyncData.class) == false) goto L7;
        r0 = r0.toBuilder().setCloudSyncData((CloudSyncData) ZeusTransformUtils.preCheckCast(r10, CloudSyncData.class, "com.obric.aiagent.plugin")).build();
        goto L7
    }
}
