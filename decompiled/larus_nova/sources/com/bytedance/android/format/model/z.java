package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/format/model/z;", "", "", "playId", "Ljava/lang/String;", "getPlayId", "()Ljava/lang/String;", "", "playType", "Ljava/lang/Integer;", "getPlayType", "()Ljava/lang/Integer;", "enterFrom", "getEnterFrom", "enterMethod", "getEnterMethod", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private final String playId;

    @SerializedName("play_type")
    private final Integer playType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L16;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.playId, r101.playId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.playType, r101.playType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.playId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.playType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.enterFrom;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.enterMethod;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.extra;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GetActiveRoomIdRequest(playId=" + this.playId + ", playType=" + this.playType + ", enterFrom=" + this.enterFrom + ", enterMethod=" + this.enterMethod + ", extra=" + this.extra + ")";
    }
}
