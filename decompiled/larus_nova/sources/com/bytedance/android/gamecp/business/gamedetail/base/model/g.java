package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.FansGroup")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/g;", "", "", "name", "Ljava/lang/String;", "avatarUri", "notice", "", "memberCount", "J", "groupId", "groupOwnerId", "", "applyStatus", "I", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/f;", "entryLimit", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/f;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g implements vh7.h {

    @SerializedName("apply_status")
    public int applyStatus;

    @SerializedName("avatar_uri")
    public String avatarUri;

    @SerializedName("entry_limit")
    public f entryLimit;

    @SerializedName("group_id")
    public String groupId;

    @SerializedName("owner_uid")
    public long groupOwnerId;

    @SerializedName("member_count")
    public long memberCount;

    @SerializedName("name")
    public String name;

    @SerializedName("notice")
    public String notice;

    public g() {
        this.avatarUri = "";
    }

    public g(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.groupOwnerId = r100.j();
        goto L3
    L8:
        this.entryLimit = new f(r100);
        goto L3
    L9:
        this.applyStatus = r100.i();
        goto L3
    L10:
        this.groupId = am3.h.c(r100);
        goto L3
    L11:
        this.memberCount = r100.j();
        goto L3
    L12:
        this.notice = am3.h.c(r100);
        goto L3
    L13:
        this.avatarUri = am3.h.c(r100);
        goto L3
    L14:
        this.name = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.avatarUri != null) goto L39;
        this.avatarUri = "";
        return;
    }
}
