package com.bytedance.android.live.base.model.message;

import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface d3 extends tlc.d, xlc.b {
    long getConsumeTime();

    long getDecodeEndTime();

    long getDecodeStartTime();

    long getEnqueueDispatchTime();

    long getHttpSendTime();

    byte[] getRawPayload();

    long getReceiveTime();

    boolean isTimeCostCanUse();

    void setCommonMessageData(m0 r100);

    void setGeneralMessageType(int r100);

    void setMessageExtra(Map<String, String> r100);

    void setMessageFrom(int r100);

    void setRawPayload(byte[] r100);

    void setTimestamp(long r100);
}
