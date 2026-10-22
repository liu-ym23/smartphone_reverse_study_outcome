package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0019\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/config/re1;", "", "", "level", "I", "getLevel", "()I", "setLevel", "(I)V", "", "updateInterval", "J", "getUpdateInterval", "()J", "setUpdateInterval", "(J)V", "updateMsgCountLimitUpper", "getUpdateMsgCountLimitUpper", "setUpdateMsgCountLimitUpper", "updateMsgCountLimitFloor", "getUpdateMsgCountLimitFloor", "setUpdateMsgCountLimitFloor", "updateListTimeLimitUpper", "getUpdateListTimeLimitUpper", "setUpdateListTimeLimitUpper", "updateListTimeLimitFloor", "getUpdateListTimeLimitFloor", "setUpdateListTimeLimitFloor", "updateFoldTimeLimitUpper", "getUpdateFoldTimeLimitUpper", "setUpdateFoldTimeLimitUpper", "updateFoldTimeLimitFloor", "getUpdateFoldTimeLimitFloor", "setUpdateFoldTimeLimitFloor", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class re1 {

    @SerializedName("level")
    private int level;

    @SerializedName("fold_fl")
    private int updateFoldTimeLimitFloor;

    @SerializedName("fold_up")
    private int updateFoldTimeLimitUpper;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private long updateInterval;

    @SerializedName("list_fl")
    private int updateListTimeLimitFloor;

    @SerializedName("list_up")
    private int updateListTimeLimitUpper;

    @SerializedName("msg_fl")
    private int updateMsgCountLimitFloor;

    @SerializedName("msg_up")
    private int updateMsgCountLimitUpper;

    public re1() {
        this(2, 500, 3, 2, 1, 1, 5, 3);
    }

    public re1(int r100, long r101, int r102, int r103, int r104, int r105, int r106, int r107) {
        this.level = r100;
        this.updateInterval = r101;
        this.updateMsgCountLimitUpper = r102;
        this.updateMsgCountLimitFloor = r103;
        this.updateListTimeLimitUpper = r104;
        this.updateListTimeLimitFloor = r105;
        this.updateFoldTimeLimitUpper = r106;
        this.updateFoldTimeLimitFloor = r107;
    }
}
