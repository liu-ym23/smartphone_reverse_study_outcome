package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.ShareListResponse.ResponseGroupData")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/k1;", "", "", "groupId", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "", "descText", "Ljava/lang/String;", "getDescText", "()Ljava/lang/String;", "", "sortScore", FaceService.girlLabel, "b", "()F", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k1 implements vh7.h {

    @SerializedName("Text")
    protected String descText;

    @SerializedName("GroupId")
    protected long groupId;

    @SerializedName("Score")
    protected float sortScore;

    public k1() {
        this.descText = "";
    }

    public final long a() {
        return this.groupId;
    }

    public final float b() {
        return this.sortScore;
    }

    public k1(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.groupId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.descText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.sortScore = (float) Double.longBitsToDouble(r100.h());
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.descText != null) goto L31;
        this.descText = "";
        return;
    }
}
