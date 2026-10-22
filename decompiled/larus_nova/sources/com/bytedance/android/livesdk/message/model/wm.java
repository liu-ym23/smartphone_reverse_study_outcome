package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.UserStatsMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/wm;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "mContent", "Ljava/lang/String;", "", "mUserId", "J", "openId", "mActionType", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class wm extends o0 implements vh7.h {

    @SerializedName("action_type")
    protected long mActionType;

    @SerializedName("content")
    protected String mContent;

    @SerializedName("user_id")
    protected long mUserId;

    @SerializedName("user_open_id")
    protected String openId;

    public static final class a {
    }

    static {
    }

    public final String getUserIdStr() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this.mUserId);
        String r102 = this.openId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    public wm() {
        this.type = MessageType.USER_STATS;
    }

    public final long E() {
        return this.mActionType;
    }

    public wm(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.mContent = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.mUserId = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.mActionType = r100.j();
        goto L3
    L14:
        if (r102 != 5000) goto L15;
        this.openId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        this.type = MessageType.USER_STATS;
    }
}
