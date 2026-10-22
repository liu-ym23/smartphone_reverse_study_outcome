package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface m0 extends vh7.c<m0> {
    public static final long FOLD_TYPE_ABSOLUTELY = 1;
    public static final long FOLD_TYPE_DEFAULT = 0;
    public static final long FOLD_TYPE_FOLD_ON_HOT_ROOM = 2;
    public static final long FOLD_TYPE_UNFOLD_ON_COLD_ROOM = 3;
    public static final int MESSAGE_CHANNEL_RTM = 1;
    public static final int MESSAGE_CHANNEL_TTLIVE = 0;
    public static final int MONITOR_ACK = 1;
    public static final int MONITOR_NONE = 0;
    public static final int MONITOR_RETRY = 2;
    public static final int NEED_FOLD = 1;
    public static final int UNFOLD = 0;

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    long getAnchorFoldDuration();

    long getAnchorFoldType();

    long getAnchorFoldTypeV2();

    long getChannelId();

    long getCreateTime();

    String getDescribe();

    long getDiffSei2absSecond();

    a5 getDisplayText();

    long getFoldType();

    String getLogId();

    long getMessageId();

    String getMethod();

    int getMonitor();

    String getMsgProcessFilterK();

    String getMsgProcessFilterV();

    long getPriorityScore();

    long getRandomDispatchMs();

    long getRoomId();

    IBaseUser getUser();

    boolean isDispatch();

    void setChannelId(long r100);

    void setCreateTime(long r100);

    void setDescribe(String r100);

    void setDisplayText(a5 r100);

    void setMessageId(long r100);

    void setMethod(String r100);

    void setRoomId(long r100);

    void setShowMsg(boolean r100);

    boolean supportDisplayText();
}
