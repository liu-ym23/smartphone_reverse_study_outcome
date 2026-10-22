package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomReqUserData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomReqUserData;", "", "()V", "enterUserDeviceType", "", "getEnterUserDeviceType", "()I", "setEnterUserDeviceType", "(I)V", "shareScore", "", "getShareScore", "()F", "setShareScore", "(F)V", "getAudienceType", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomReqUserData implements h {

    @SerializedName("enter_user_device_type")
    protected int enterUserDeviceType;

    @SerializedName("user_share_room_score")
    protected float shareScore;

    public RoomReqUserData() {
    }

    public final String getAudienceType() {
        int r100 = this.enterUserDeviceType;
        if (r100 != 0) goto L5;
        return SourceType.DEFAULT;
    L5:
        if (r100 != 2) goto L7;
        return "anchor_audience";
    L7:
        if (r100 == 3) goto L9;
        return "";
    L9:
        return "second_device";
    }

    public final int getEnterUserDeviceType() {
        return this.enterUserDeviceType;
    }

    public final float getShareScore() {
        return this.shareScore;
    }

    public RoomReqUserData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.shareScore = Float.intBitsToFloat(r100.g());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.enterUserDeviceType = r100.i();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setEnterUserDeviceType(int r100) {
        this.enterUserDeviceType = r100;
    }

    public final void setShareScore(float r100) {
        this.shareScore = r100;
    }
}
