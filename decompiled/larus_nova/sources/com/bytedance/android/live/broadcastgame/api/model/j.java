package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.stamp.GroupProperty")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/j;", "", "", "name", "Ljava/lang/String;", "", "capacity", "J", "afterLiveDescLinkUrl", "beforeLiveDesc", "groupId", "Lcom/bytedance/android/live/broadcastgame/api/model/n0;", "selector", "Lcom/bytedance/android/live/broadcastgame/api/model/n0;", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j implements vh7.h {

    @SerializedName("after_live_desc_link_url")
    public String afterLiveDescLinkUrl;

    @SerializedName("before_live_desc")
    public String beforeLiveDesc;

    @SerializedName("capacity")
    public long capacity;

    @SerializedName("group_id")
    public long groupId;

    @SerializedName("name")
    public String name;

    @SerializedName("selector")
    public n0 selector;

    public j() {
        this.name = "";
        this.capacity = 0;
        this.afterLiveDescLinkUrl = "";
        this.beforeLiveDesc = "";
        this.groupId = 0;
        this.selector = null;
    }

    public j(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L13;
        switch(r103) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.selector = new n0(r100);
        goto L3
    L8:
        this.beforeLiveDesc = am3.h.c(r100);
        goto L3
    L9:
        this.afterLiveDescLinkUrl = am3.h.c(r100);
        goto L3
    L10:
        this.groupId = r100.j();
        r102 = r102 | 2;
        goto L3
    L11:
        this.capacity = r100.j();
        r102 = r102 | 1;
        goto L3
    L12:
        this.name = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.name != null) goto L17;
        this.name = "";
    L17:
        if ((r102 & 1) != 0) goto L20;
        this.capacity = 0;
    L20:
        if (this.afterLiveDescLinkUrl != null) goto L23;
        this.afterLiveDescLinkUrl = "";
    L23:
        if (this.beforeLiveDesc != null) goto L26;
        this.beforeLiveDesc = "";
    L26:
        if ((r102 & 2) != 0) goto L29;
        this.groupId = 0;
    L29:
        if (this.selector != null) goto L48;
        this.selector = null;
        return;
    }
}
