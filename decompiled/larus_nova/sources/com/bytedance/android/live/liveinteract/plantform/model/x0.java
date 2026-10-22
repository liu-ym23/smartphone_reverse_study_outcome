package com.bytedance.android.live.liveinteract.plantform.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/x0;", "", "", "rtcRoomId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "rtcUserId", "b", "e", "", "needMixStream", "Z", "getNeedMixStream", "()Z", "c", "(Z)V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class x0 {

    @SerializedName("need_mix_stream")
    private boolean needMixStream;

    @SerializedName("rtc_room_id")
    private String rtcRoomId;

    @SerializedName("rtc_user_id")
    private String rtcUserId;

    public x0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x0) == false) goto L12;
        x0 r101 = (x0) r100;
        if (Intrinsics.areEqual(this.rtcRoomId, r101.rtcRoomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.rtcUserId, r101.rtcUserId) == true) goto L10;
        return false;
    L10:
        if (this.needMixStream == r101.needMixStream) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.rtcRoomId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.rtcUserId;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.needMixStream;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSingAvatarCloudGameRtcInfo(rtcRoomId=" + this.rtcRoomId + ", rtcUserId=" + this.rtcUserId + ", needMixStream=" + this.needMixStream + ")";
    }

    public final String a() {
        return this.rtcRoomId;
    }

    public final String b() {
        return this.rtcUserId;
    }

    public x0(int r100) {
        this.rtcRoomId = null;
        this.rtcUserId = null;
        this.needMixStream = false;
    }

    public final void c(boolean r100) {
        this.needMixStream = r100;
    }

    public final void d(String r100) {
        this.rtcRoomId = r100;
    }

    public final void e(String r100) {
        this.rtcUserId = r100;
    }
}
