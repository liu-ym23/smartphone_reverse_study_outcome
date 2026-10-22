package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/w3;", "", "", "userId", "J", "d", "()J", "setUserId", "(J)V", "roomId", "c", "setRoomId", "", "liveStatus", "I", "b", "()I", "setLiveStatus", "(I)V", "", "filterReason", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setFilterReason", "(Ljava/lang/String;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w3 {

    @SerializedName("filter_reason")
    private String filterReason;

    @SerializedName("live_status")
    private int liveStatus;

    @SerializedName("room_id")
    private long roomId;

    @SerializedName("user_id")
    private long userId;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "LiveStatus{userId=" + this.userId + ", roomId=" + this.roomId + ", liveStatus=" + this.liveStatus + '}';
    }

    public w3() {
        this.filterReason = "";
    }

    public final String a() {
        return this.filterReason;
    }

    public final int b() {
        return this.liveStatus;
    }

    public final long c() {
        return this.roomId;
    }

    public final long d() {
        return this.userId;
    }
}
