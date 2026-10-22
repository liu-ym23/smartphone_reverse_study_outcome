package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.anchor.AnchorPermissionStatusResponse.Data")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/h;", "", "", "applyStatus", "I", "getApplyStatus", "()I", "setApplyStatus", "(I)V", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/broadcast/api/model/e;", "applyDetail", "Lcom/bytedance/android/live/broadcast/api/model/e;", "getApplyDetail", "()Lcom/bytedance/android/live/broadcast/api/model/e;", "setApplyDetail", "(Lcom/bytedance/android/live/broadcast/api/model/e;)V", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements vh7.h {

    @SerializedName("apply_detail")
    protected e applyDetail;

    @SerializedName("apply_status")
    protected int applyStatus;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    protected String desc;

    public h() {
    }

    public h(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.applyStatus = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.desc = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.applyDetail = new e(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
