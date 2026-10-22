package com.bytedance.android.livesdkapi.message;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.m;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes12.dex */
@IgnoreProtoFieldCheck
public abstract class BaseMessage implements t {
    public static final int MESSAGE_CHANNEL_RTM = 1;
    public static final int MESSAGE_CHANNEL_TTLIVE = 0;

    @IgnoreProtoFieldCheck
    @SerializedName("common")
    public CommonMessageData baseMessage;
    private long consumeTime;
    private boolean currUserIsAnchor;
    private long decodeEndTime;
    private long decodeStartTime;
    private long enqueueDispatchTime;
    public int fromChannel;
    private int generalMessageType;
    private long httpSendTime;
    public boolean isFirstRequest;
    private boolean isInsert;
    private boolean isWRDSMessage;
    public volatile long localTimestamp;
    public Map<String, String> messageExtra;
    private int messageFrom;
    private String messageMethod;
    private long offset;
    public transient byte[] rawPayload;
    private long receiveTime;
    public transient long timestamp;
    private String wrdsSubKey;
    private long wrdsVersion;

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean canText() {
        return false;
    }

    public void checkValid() {
    }

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public abstract /* synthetic */ int getIntType();

    public int getPriority() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public abstract /* synthetic */ boolean isFirstHistoryMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean isFromOtherIntercomRoom() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public abstract /* synthetic */ boolean isTooMuchMsg();

    @Override // com.bytedance.android.live.base.model.message.t
    public abstract /* synthetic */ void setIsFirstHistoryMessage(boolean r100);

    public abstract /* synthetic */ void setLocalInsertMsg(boolean r100);

    @Override // com.bytedance.android.live.base.model.message.t
    public abstract /* synthetic */ void setTooMuchMsg(boolean r100);

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean supportDisplayText() {
        return false;
    }

    @Override // tlc.d
    public long getDelayDispatchMs() {
        CommonMessageData r100 = this.baseMessage;
        if (r100 == null) goto L8;
        long r101 = r100.randomDispatchMs;
        if (r101 <= 0) goto L8;
        return Random.Default.nextLong(r101);
    L8:
        return 0;
    }

    @Override // tlc.d
    public long getRoomId() {
        CommonMessageData r100 = this.baseMessage;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getRoomId();
    }

    @Override // tlc.d
    public boolean isGlobalMessage() {
        CommonMessageData r100 = this.baseMessage;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.roomId != (-1)) goto L7;
        return true;
    }

    public boolean isTimeCostCanUse() {
        if (this.isInsert == false) goto L5;
        return false;
    L5:
        long r100 = this.httpSendTime;
        if (r100 > 0) goto L8;
    L10:
        long r101 = this.decodeEndTime;
        if (r101 <= this.decodeStartTime) goto L18;
        long r102 = this.enqueueDispatchTime;
        if (r102 > r101) goto L15;
        return false;
    L15:
        if (this.consumeTime <= r102) goto L20;
        return true;
    L20:
        return false;
    L18:
        return false;
    L8:
        if (this.receiveTime > r100) goto L10;
        return false;
    }

    public BaseMessage() {
        this.currUserIsAnchor = false;
        this.generalMessageType = 0;
        this.offset = 0;
        this.rawPayload = null;
        this.isFirstRequest = false;
        this.localTimestamp = SystemClock.elapsedRealtime();
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public /* bridge */ /* synthetic */ m0 getBaseMessage() {
        return getBaseMessage();
    }

    @Override // tlc.d
    public long getMessageId() {
        if (getBaseMessage() != null) goto L7;
        return 0;
    L7:
        return getBaseMessage().getMessageId();
    }

    @Override // tlc.d
    public boolean needMonitor() {
        if (getBaseMessage() != null) goto L5;
    L7:
        return false;
    L5:
        if (getBaseMessage().getMonitor() == 0) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean currUserIsAnchor() {
        return this.currUserIsAnchor;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public long getConsumeTime() {
        return this.consumeTime;
    }

    public long getDecodeEndTime() {
        return this.decodeEndTime;
    }

    public long getDecodeStartTime() {
        return this.decodeStartTime;
    }

    public long getEnqueueDispatchTime() {
        return this.enqueueDispatchTime;
    }

    @Override // tlc.d
    public int getGeneralMessageType() {
        return this.generalMessageType;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public long getHttpSendTime() {
        return this.httpSendTime;
    }

    public long getLocalTimestamp() {
        return this.localTimestamp;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public Map<String, String> getMessageExtra() {
        return this.messageExtra;
    }

    @Override // tlc.d
    public int getMessageFrom() {
        return this.messageFrom;
    }

    @Override // tlc.d
    public String getMessageMethod() {
        return this.messageMethod;
    }

    public long getOffset() {
        return this.offset;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public byte[] getRawPayload() {
        return this.rawPayload;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public long getReceiveTime() {
        return this.receiveTime;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // xlc.b
    public String getWRDSKey() {
        return this.messageMethod;
    }

    @Override // xlc.b
    public String getWRDSSubKey() {
        return this.wrdsSubKey;
    }

    @Override // xlc.b
    public long getWRDSVersion() {
        return this.wrdsVersion;
    }

    @Override // tlc.d
    public boolean isFromFirstRequest() {
        return this.isFirstRequest;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean isInsert() {
        return this.isInsert;
    }

    @Override // xlc.b
    public boolean isWRDSMessage() {
        return this.isWRDSMessage;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public CommonMessageData getBaseMessage() {
        return this.baseMessage;
    }

    public long getReceiveNtpTime(long r100) {
        if (this.fromChannel != 1) goto L6;
        return this.receiveTime;
    L6:
        return r100 + this.receiveTime;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public boolean isCurrentRoom(long r100) {
        CommonMessageData r101 = this.baseMessage;
        if (r101 == null) goto L5;
        long r102 = r101.roomId;
    L7:
        if (r100 != 0) goto L9;
    L11:
        return false;
    L9:
        if (r100 != r102) goto L11;
        return true;
    L5:
        r102 = 0;
        goto L7
    }

    public void setBaseMessage(m0 r100) {
        this.baseMessage = (CommonMessageData) m.b(r100, CommonMessageData.class);
    }

    @Override // tlc.d
    public void setConsumeTime(long r100) {
        this.consumeTime = r100;
    }

    public void setCurrUserIsAnchor(boolean r100) {
        this.currUserIsAnchor = r100;
    }

    @Override // tlc.d
    public void setDecodeEndTime(long r100) {
        this.decodeEndTime = r100;
    }

    @Override // tlc.d
    public void setDecodeStartTime(long r100) {
        this.decodeStartTime = r100;
    }

    @Override // tlc.d
    public void setEnqueueDispatchTime(long r100) {
        this.enqueueDispatchTime = r100;
    }

    public void setGeneralMessageType(int r100) {
        this.generalMessageType = r100;
    }

    @Override // tlc.d
    public void setHttpSendTime(long r100) {
        this.httpSendTime = r100;
    }

    @Override // tlc.d
    public void setIsFromFirstRequest(boolean r100) {
        this.isFirstRequest = r100;
    }

    @Override // tlc.d
    public void setIsInsert(boolean r100) {
        this.isInsert = r100;
    }

    public void setMessageFrom(int r100) {
        this.messageFrom = r100;
    }

    @Override // tlc.d
    public void setMessageMethod(String r100) {
        this.messageMethod = r100;
    }

    public void setOffset(long r100) {
        this.offset = r100;
    }

    @Override // tlc.d
    public void setReceiveTime(long r100) {
        this.receiveTime = r100;
    }

    @Override // xlc.b
    public void setWRDSMessage(boolean r100) {
        this.isWRDSMessage = r100;
    }

    public void setWRDSSubKey(String r100) {
        this.wrdsSubKey = r100;
    }

    @Override // xlc.b
    public void setWRDSVersion(long r100) {
        this.wrdsVersion = r100;
    }
}
