package com.bytedance.android.livesdkapi.depend.model.live.roomchannel;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.FansChannelCreateInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/FansChannelCreateInfo;", "", "()V", "fansChannelType", "", "getFansChannelType", "()J", "setFansChannelType", "(J)V", "groupId", "getGroupId", "setGroupId", "groupIdStr", "", "getGroupIdStr", "()Ljava/lang/String;", "setGroupIdStr", "(Ljava/lang/String;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansChannelCreateInfo implements h {

    @SerializedName("fans_channel_type")
    protected long fansChannelType;

    @SerializedName("group_id")
    protected long groupId;

    @SerializedName("group_id_str")
    protected String groupIdStr;

    public FansChannelCreateInfo() {
    }

    public final long getFansChannelType() {
        return this.fansChannelType;
    }

    public final long getGroupId() {
        return this.groupId;
    }

    public final String getGroupIdStr() {
        return this.groupIdStr;
    }

    public FansChannelCreateInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.fansChannelType = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.groupId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.groupIdStr = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setFansChannelType(long r100) {
        this.fansChannelType = r100;
    }

    public final void setGroupId(long r100) {
        this.groupId = r100;
    }

    public final void setGroupIdStr(String r100) {
        this.groupIdStr = r100;
    }
}
