package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.user.VisibleListData.GroupInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/x1;", "", "", "groupId", "Ljava/lang/String;", "", "memberCount", "J", "nickName", "avatarUrl", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x1 implements vh7.h {

    @SerializedName("avatar_url")
    public String avatarUrl;

    @SerializedName("group_id")
    public String groupId;

    @SerializedName("member_count")
    public long memberCount;

    @SerializedName("name")
    public String nickName;

    public x1() {
        this.nickName = "";
    }

    public x1(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.groupId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.memberCount = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.nickName = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.avatarUrl = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.nickName != null) goto L37;
        this.nickName = "";
        return;
    }
}
