package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/base/model/user/g;", "", "", "hasAudienceAuthSwitch", "J", "userGiftSwitch", "userGiftOffReason", "", "failMessage", "Ljava/lang/String;", "anchorRelationSwitch", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g implements vh7.h {

    @SerializedName("anchor_user_relation_switch")
    public long anchorRelationSwitch;

    @IgnoreProtoFieldCheck
    @SerializedName("fail_message")
    public String failMessage;

    @SerializedName("profile_style")
    public long hasAudienceAuthSwitch;

    @SerializedName("user_gift_off_reason")
    public long userGiftOffReason;

    @SerializedName("user_gift_switch")
    public long userGiftSwitch;

    public static final class a {
    }

    static {
    }

    public g() {
        this.userGiftSwitch = 2;
    }

    public g(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        if (r103 != 1) goto L7;
        this.hasAudienceAuthSwitch = r100.j();
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.userGiftSwitch = r100.j();
        r102 = r102 | true;
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.userGiftOffReason = r100.j();
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this.failMessage = am3.h.c(r100);
        goto L3
    L13:
        if (r103 != 5) goto L14;
        this.anchorRelationSwitch = r100.j();
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if ((r102 & true) == true) goto L42;
        this.userGiftSwitch = 2;
        return;
    }
}
