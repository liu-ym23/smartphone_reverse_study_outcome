package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerGuestExitCastScreenContent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerGuestExitCastScreenContent;", "", "()V", "openId", "", "getOpenId", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "userId", "", "getUserId", "()Ljava/lang/Long;", "setUserId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkerGuestExitCastScreenContent implements h {

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openId;

    @SerializedName("user_id")
    protected Long userId;

    public LinkerGuestExitCastScreenContent() {
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final Long getUserId() {
        return this.userId;
    }

    public LinkerGuestExitCastScreenContent(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.userId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 5000) goto L9;
        this.openId = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setOpenId(String r100) {
        this.openId = r100;
    }

    public final void setUserId(Long r100) {
        this.userId = r100;
    }
}
