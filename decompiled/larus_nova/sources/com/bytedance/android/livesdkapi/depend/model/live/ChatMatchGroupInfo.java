package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.ChatMatchGroupInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ChatMatchGroupInfo;", "", "()V", "disbandTime", "", "getDisbandTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "groupId", "", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "groupUserList", "", "Lcom/bytedance/android/live/base/model/user/User;", "getGroupUserList", "()Ljava/util/List;", "status", "", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "tagId", "getTagId", "version", "getVersion", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatMatchGroupInfo implements h {

    @SerializedName("disband_time")
    protected Long disbandTime;

    @SerializedName("group_id")
    protected String groupId;

    @SerializedName("group_user_list")
    protected List<User> groupUserList;

    @SerializedName("status")
    protected Integer status;

    @SerializedName("tag_id")
    protected Long tagId;

    @SerializedName("version")
    protected Long version;

    public ChatMatchGroupInfo() {
        this.tagId = 0L;
        this.disbandTime = 0L;
        this.status = 0;
        this.version = 0L;
    }

    public final Long getDisbandTime() {
        return this.disbandTime;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final List<User> getGroupUserList() {
        return this.groupUserList;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Long getTagId() {
        return this.tagId;
    }

    public final Long getVersion() {
        return this.version;
    }

    public ChatMatchGroupInfo(g r100) {
        this.groupUserList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.version = Long.valueOf(r100.j());
        goto L3
    L8:
        this.groupUserList.add(new User(r100));
        goto L3
    L9:
        this.status = Integer.valueOf(r100.i());
        goto L3
    L10:
        this.disbandTime = Long.valueOf(r100.j());
        goto L3
    L11:
        this.tagId = Long.valueOf(r100.j());
        goto L3
    L12:
        this.groupId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.tagId != null) goto L17;
        this.tagId = 0L;
    L17:
        if (this.disbandTime != null) goto L20;
        this.disbandTime = 0L;
    L20:
        if (this.status != null) goto L23;
        this.status = 0;
    L23:
        if (this.version != null) goto L42;
        this.version = 0L;
        return;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }
}
