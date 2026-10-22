package com.bytedance.android.live.base.model.message;

import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface t extends tlc.d, xlc.b {
    boolean canText();

    boolean currUserIsAnchor();

    m0 getBaseMessage();

    long getConsumeTime();

    long getHttpSendTime();

    Map<String, String> getMessageExtra();

    byte[] getRawPayload();

    long getReceiveTime();

    long getTimestamp();

    boolean isCurrentRoom(long r100);

    boolean isFirstHistoryMessage();

    boolean isFromOtherIntercomRoom();

    boolean isInsert();

    boolean isTooMuchMsg();

    void setIsFirstHistoryMessage(boolean r100);

    void setTooMuchMsg(boolean r100);

    boolean supportDisplayText();
}
