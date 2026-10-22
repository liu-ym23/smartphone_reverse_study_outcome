package com.bytedance.android.livesdk.chatroom;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/c1;", "", "Lcom/bytedance/android/livesdk/chatroom/g1;", "refluxInfo", "Lcom/bytedance/android/livesdk/chatroom/g1;", "getRefluxInfo", "()Lcom/bytedance/android/livesdk/chatroom/g1;", "Lcom/bytedance/android/livesdk/chatroom/d1;", "panelInfo", "Lcom/bytedance/android/livesdk/chatroom/d1;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/chatroom/d1;", "", "", "roomInfo", "Ljava/util/Map;", "getRoomInfo", "()Ljava/util/Map;", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c1 {

    @SerializedName("panel_info")
    private final d1 panelInfo;

    @SerializedName("reflux_info")
    private final g1 refluxInfo;

    @SerializedName("room_info")
    private final Map<String, String> roomInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c1) == false) goto L12;
        c1 r101 = (c1) r100;
        if (Intrinsics.areEqual(this.refluxInfo, r101.refluxInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.panelInfo, r101.panelInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.roomInfo, r101.roomInfo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        g1 r100 = this.refluxInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d1 r104 = this.panelInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.roomInfo;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShareCouponShareInfo(refluxInfo=" + this.refluxInfo + ", panelInfo=" + this.panelInfo + ", roomInfo=" + this.roomInfo + ")";
    }

    public c1() {
        this.refluxInfo = null;
        this.panelInfo = null;
        this.roomInfo = null;
    }

    public final d1 a() {
        return this.panelInfo;
    }
}
