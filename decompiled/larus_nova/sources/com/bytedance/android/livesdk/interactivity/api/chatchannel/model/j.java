package com.bytedance.android.livesdk.interactivity.api.chatchannel.model;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.room_channel.ChannelInviteResponse.ResponseData")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/j;", "", "", "inviteId", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setInviteId", "(J)V", "", "shareText", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setShareText", "(Ljava/lang/String;)V", "", "roomType", "I", "b", "()I", "setRoomType", "(I)V", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j implements vh7.h {

    @SerializedName("invite_id")
    protected long inviteId;

    @SerializedName(IPerformanceManager.Params.room_type)
    protected int roomType;

    @SerializedName("share_text")
    protected String shareText;

    public j() {
    }

    public final long a() {
        return this.inviteId;
    }

    public final int b() {
        return this.roomType;
    }

    public final String c() {
        return this.shareText;
    }

    public j(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.inviteId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.shareText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.roomType = (int) r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
