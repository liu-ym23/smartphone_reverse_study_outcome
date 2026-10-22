package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.OfficialAccount")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/n;", "", "", "appId", "I", "", "userId", "J", "", "nickName", "Ljava/lang/String;", "avatarUri", "secUid", "fansNum", "", "isFollow", "Z", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n implements vh7.h {

    @SerializedName("app_id")
    public int appId;

    @SerializedName("avatar_uri")
    public String avatarUri;

    @SerializedName("fans_num")
    public String fansNum;

    @SerializedName("is_follow")
    public boolean isFollow;

    @SerializedName("nick_name")
    public String nickName;

    @SerializedName("sec_uid")
    public String secUid;

    @SerializedName("user_id")
    public long userId;

    public n() {
        this.nickName = "";
        this.avatarUri = "";
        this.fansNum = "";
    }

    public n(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.isFollow = am3.h.a(r100);
        goto L3
    L8:
        this.fansNum = am3.h.c(r100);
        goto L3
    L9:
        this.secUid = am3.h.c(r100);
        goto L3
    L10:
        this.avatarUri = am3.h.c(r100);
        goto L3
    L11:
        this.nickName = am3.h.c(r100);
        goto L3
    L12:
        this.userId = r100.j();
        goto L3
    L13:
        this.appId = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.nickName != null) goto L18;
        this.nickName = "";
    L18:
        if (this.avatarUri != null) goto L21;
        this.avatarUri = "";
    L21:
        if (this.fansNum != null) goto L42;
        this.fansNum = "";
        return;
    }
}
