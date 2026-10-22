package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.AdminData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AdminRecordAdminInfo;", "", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "openId", "uid", "", "getUidStr", "setUidStr", "", "uidStr", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdminRecordAdminInfo implements h {

    @SerializedName("name")
    protected String name;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openId;

    @SerializedName("uid")
    protected long uid;

    public AdminRecordAdminInfo() {
    }

    public final String getUidStr() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this.uid);
        String r102 = this.openId;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public final String getName() {
        return this.name;
    }

    public AdminRecordAdminInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.uid = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.name = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 5000) goto L11;
        this.openId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setUidStr(String r100) {
        o0.f58946a.getClass();
        this.uid = 0;
        this.openId = r100;
    }
}
