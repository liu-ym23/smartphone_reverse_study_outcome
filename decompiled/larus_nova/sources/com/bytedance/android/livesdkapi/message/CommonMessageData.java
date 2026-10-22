package com.bytedance.android.livesdkapi.message;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.live.base.model.m;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.lazy.ITextWrapper;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class CommonMessageData extends FlexModelBase<m0> implements m0 {
    public static final long FOLD_TYPE_ABSOLUTELY = 1;
    public static final long FOLD_TYPE_DEFAULT = 0;
    public static final long FOLD_TYPE_FOLD_ON_HOT_ROOM = 2;
    public static final long FOLD_TYPE_ON_HOT_ROOM = 2;
    public static final long FOLD_TYPE_UNFOLD_ON_COLD_ROOM = 3;
    public static final int MONITOR_ACK = 1;
    public static final int MONITOR_NONE = 0;
    public static final int MONITOR_RETRY = 2;
    public static final int NEED_FOLD = 1;
    public static final int UNFOLD = 0;

    @SerializedName("anchor_fold_duration")
    public long anchorFoldDuration;

    @SerializedName("anchor_fold_type")
    public long anchorFoldType;

    @SerializedName("anchor_fold_type_v2")
    public long anchorFoldTypeV2;

    @SerializedName("channel_id")
    public long channelId;

    @SerializedName("create_time")
    public long createTime;

    @SerializedName("describe")
    public String describe;

    @SerializedName("diff_sei2abs_second")
    public long diffSei2absSecond;

    @SerializedName("display_text")
    ITextWrapper displayText;

    @SerializedName("fold_type")
    public long foldType;
    private transient Text internalDisplayText;

    @SerializedName("is_dispatch")
    public boolean isDispatch;

    @SerializedName("log_id")
    public String logId;

    @SerializedName("msg_id")
    public long messageId;

    @SerializedName(e.f25671s)
    public String method;

    @SerializedName("monitor")
    public int monitor;

    @SerializedName("msg_process_filter_k")
    public String msgProcessFilterK;

    @SerializedName("msg_process_filter_v")
    public String msgProcessFilterV;

    @SerializedName("priority_score")
    public long priorityScore;

    @SerializedName("process_at_sei_time_ms")
    public long process_at_sei_time_ms;

    @SerializedName("random_dispatch_ms")
    public long randomDispatchMs;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("is_show_msg")
    public boolean showMsg;

    @SerializedName("user")
    public IBaseUser user;

    public CommonMessageData() {
        super(m0.class);
        this.diffSei2absSecond = 0;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public Text getDisplayText() {
        if (this.internalDisplayText != null) goto L11;
        ITextWrapper r100 = this.displayText;
        if (r100 == null) goto L7;
        a5 r101 = r100.getText();
    L8:
        if (r101 == null) goto L11;
        setDisplayText(r101);
        goto L11
    L7:
        r101 = null;
    L11:
        return this.internalDisplayText;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public boolean supportDisplayText() {
        if (this.displayText == null) goto L5;
    L8:
        return true;
    L5:
        if (this.internalDisplayText != null) goto L8;
        return false;
    }

    public String toString() {
        return "CommonMessageData{createTime=" + this.createTime + ", roomId=" + this.roomId + ", messageId=" + this.messageId + ", method='" + this.method + "', describe='" + this.describe + "', showMsg=" + this.showMsg + ", monitor=" + this.monitor + ", displayText=" + this.internalDisplayText + ", foldType=" + this.foldType + ", anchorFoldType=" + this.anchorFoldType + ", priorityScore=" + this.priorityScore + ", isDispatch=" + this.isDispatch + '}';
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public long getAnchorFoldDuration() {
        return this.anchorFoldDuration;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public long getAnchorFoldType() {
        return this.anchorFoldType;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public long getAnchorFoldTypeV2() {
        return this.anchorFoldTypeV2;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public long getChannelId() {
        return this.channelId;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public long getCreateTime() {
        return this.createTime;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public String getDescribe() {
        return this.describe;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public long getDiffSei2absSecond() {
        return this.diffSei2absSecond;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public long getFoldType() {
        return this.foldType;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public String getLogId() {
        return this.logId;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public long getMessageId() {
        return this.messageId;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public String getMethod() {
        return this.method;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public int getMonitor() {
        return this.monitor;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public String getMsgProcessFilterK() {
        return this.msgProcessFilterK;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public String getMsgProcessFilterV() {
        return this.msgProcessFilterV;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public long getPriorityScore() {
        return this.priorityScore;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public long getRandomDispatchMs() {
        return this.randomDispatchMs;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public long getRoomId() {
        return this.roomId;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public IBaseUser getUser() {
        return this.user;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public boolean isDispatch() {
        return this.isDispatch;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public /* bridge */ /* synthetic */ a5 getDisplayText() {
        return getDisplayText();
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public void setChannelId(long r100) {
        this.channelId = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public void setDescribe(String r100) {
        this.describe = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public void setDisplayText(a5 r100) {
        this.internalDisplayText = (Text) m.b(r100, Text.class);
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public void setMessageId(long r100) {
        this.messageId = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public void setMethod(String r100) {
        this.method = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public void setRoomId(long r100) {
        this.roomId = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.m0
    public void setShowMsg(boolean r100) {
        this.showMsg = r100;
    }

    public static CommonMessageData fake(long r100, boolean r101) {
        CommonMessageData r102 = new CommonMessageData();
        r102.createTime = System.currentTimeMillis();
        r102.roomId = r100;
        r102.messageId = -1;
        r102.showMsg = r101;
        return r102;
    }
}
