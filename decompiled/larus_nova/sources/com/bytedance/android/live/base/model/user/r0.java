package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ForMain
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/base/model/user/r0;", "", "", "setStatus", "Z", "", "userGiftSwitch", "J", "userGiftOffReason", "", "failMessage", "Ljava/lang/String;", "anchorRelationSwitch", "faceGiftSwitch", "giftDiamondLevel", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class r0 implements vh7.h {

    @SerializedName("anchor_user_relation_switch")
    public long anchorRelationSwitch;

    @SerializedName("face_gift_switch")
    public long faceGiftSwitch;

    @IgnoreProtoFieldCheck
    @SerializedName("fail_message")
    public String failMessage;

    @SerializedName("gift_diamond_level")
    public long giftDiamondLevel;

    @SerializedName("set_status")
    public boolean setStatus;

    @SerializedName("user_gift_off_reason")
    public long userGiftOffReason;

    @SerializedName("user_gift_switch")
    public long userGiftSwitch;

    public r0() {
        this.userGiftSwitch = 2;
        this.anchorRelationSwitch = 1;
        this.faceGiftSwitch = 1;
    }

    public r0(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.giftDiamondLevel = r100.j();
        goto L3
    L8:
        this.faceGiftSwitch = r100.j();
        r102 = r102 | 4;
        goto L3
    L9:
        this.anchorRelationSwitch = r100.j();
        r102 = r102 | 2;
        goto L3
    L10:
        this.failMessage = am3.h.c(r100);
        goto L3
    L11:
        this.userGiftOffReason = r100.j();
        goto L3
    L12:
        this.userGiftSwitch = r100.j();
        r102 = r102 | 1;
        goto L3
    L13:
        this.setStatus = am3.h.a(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L18;
        this.userGiftSwitch = 2;
    L18:
        if ((r102 & 2) != 0) goto L21;
        this.anchorRelationSwitch = 1;
    L21:
        if ((r102 & 4) != 0) goto L42;
        this.faceGiftSwitch = 1;
        return;
    }
}
