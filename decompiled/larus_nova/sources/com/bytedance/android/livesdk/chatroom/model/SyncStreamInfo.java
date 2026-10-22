package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/SyncStreamInfo;", "", "timestamp", "", "key", "", "info", "(JLjava/lang/String;Ljava/lang/String;)V", "getInfo", "()Ljava/lang/String;", "setInfo", "(Ljava/lang/String;)V", "getKey", "getTimestamp", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SyncStreamInfo {

    @SerializedName("info")
    private String info;

    @SerializedName("key")
    private final String key;

    @SerializedName("timestamp")
    private final long timestamp;

    public SyncStreamInfo() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ SyncStreamInfo copy$default(SyncStreamInfo r100, long r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.timestamp;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.key;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.info;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final String component2() {
        return this.key;
    }

    public final String component3() {
        return this.info;
    }

    public final SyncStreamInfo copy(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "info");
        return new SyncStreamInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SyncStreamInfo) == false) goto L12;
        SyncStreamInfo r101 = (SyncStreamInfo) r100;
        if (this.timestamp == r101.timestamp) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.info, r101.info) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        long r100 = this.timestamp;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.key;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.info;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return r105 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "SyncStreamInfo(timestamp=" + this.timestamp + ", key=" + this.key + ", info=" + this.info + ")";
    }

    public final String getInfo() {
        return this.info;
    }

    public final String getKey() {
        return this.key;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.info = r100;
    }

    public SyncStreamInfo(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "info");
        this.timestamp = r100;
        this.key = r101;
        this.info = r102;
    }

    public /* synthetic */ SyncStreamInfo(long r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
