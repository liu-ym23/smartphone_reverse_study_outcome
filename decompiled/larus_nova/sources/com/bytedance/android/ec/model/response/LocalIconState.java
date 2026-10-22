package com.bytedance.android.ec.model.response;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001e\u0010#\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\u001e\u0010&\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014¨\u0006)"}, d2 = {"Lcom/bytedance/android/ec/model/response/LocalIconState;", "Ljava/io/Serializable;", "()V", "businessKey", "", "getBusinessKey", "()Ljava/lang/String;", "setBusinessKey", "(Ljava/lang/String;)V", "curRoomSkipTimestamp", "", "getCurRoomSkipTimestamp", "()J", "setCurRoomSkipTimestamp", "(J)V", "curRoomTimes", "", "getCurRoomTimes", "()I", "setCurRoomTimes", "(I)V", "expiredTimestamp", "getExpiredTimestamp", "setExpiredTimestamp", "iconKey", "getIconKey", "setIconKey", "isOutOfTimes", "", "()Z", "setOutOfTimes", "(Z)V", "limitKey", "getLimitKey", "setLimitKey", "skipTimestamp", "getSkipTimestamp", "setSkipTimestamp", "totalTimes", "getTotalTimes", "setTotalTimes", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class LocalIconState implements Serializable {

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_BUSINESS_KEY_STRING)
    private String businessKey;

    @SerializedName("cur_room_skip_timestamp")
    private long curRoomSkipTimestamp;

    @SerializedName("cur_room_times")
    private int curRoomTimes;

    @SerializedName("expired_timestamp")
    private long expiredTimestamp;

    @SerializedName("icon_key")
    private String iconKey;

    @SerializedName("out_of_times")
    private boolean isOutOfTimes;

    @SerializedName("limit_key")
    private String limitKey;

    @SerializedName("skip_timestamp")
    private long skipTimestamp;

    @SerializedName("total_times")
    private int totalTimes;

    public LocalIconState() {
        this.expiredTimestamp = System.currentTimeMillis();
    }

    public final String getBusinessKey() {
        return this.businessKey;
    }

    public final long getCurRoomSkipTimestamp() {
        return this.curRoomSkipTimestamp;
    }

    public final int getCurRoomTimes() {
        return this.curRoomTimes;
    }

    public final long getExpiredTimestamp() {
        return this.expiredTimestamp;
    }

    public final String getIconKey() {
        return this.iconKey;
    }

    public final String getLimitKey() {
        return this.limitKey;
    }

    public final long getSkipTimestamp() {
        return this.skipTimestamp;
    }

    public final int getTotalTimes() {
        return this.totalTimes;
    }

    public final boolean isOutOfTimes() {
        return this.isOutOfTimes;
    }

    public final void setBusinessKey(String r100) {
        this.businessKey = r100;
    }

    public final void setCurRoomSkipTimestamp(long r100) {
        this.curRoomSkipTimestamp = r100;
    }

    public final void setCurRoomTimes(int r100) {
        this.curRoomTimes = r100;
    }

    public final void setExpiredTimestamp(long r100) {
        this.expiredTimestamp = r100;
    }

    public final void setIconKey(String r100) {
        this.iconKey = r100;
    }

    public final void setLimitKey(String r100) {
        this.limitKey = r100;
    }

    public final void setOutOfTimes(boolean r100) {
        this.isOutOfTimes = r100;
    }

    public final void setSkipTimestamp(long r100) {
        this.skipTimestamp = r100;
    }

    public final void setTotalTimes(int r100) {
        this.totalTimes = r100;
    }
}
