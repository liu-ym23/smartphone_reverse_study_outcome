package com.bytedance.android.gamecp.common.model.live;

import am3.g;
import com.bytedance.android.gamecp.host_api.model.ImageModelLive;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.api.feed.RankRoundBanner.Item")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006 "}, d2 = {"Lcom/bytedance/android/gamecp/common/model/live/d;", "", "Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;", "icon", "Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;", "getIcon", "()Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;", "setIcon", "(Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;)V", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/gamecp/common/model/live/c;", "userList", "Ljava/util/List;", "getUserList", "()Ljava/util/List;", "setUserList", "(Ljava/util/List;)V", "url", "getUrl", "setUrl", "background", "getBackground", "setBackground", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements h {

    @SerializedName("background")
    protected ImageModelLive background;

    @SerializedName("icon")
    protected ImageModelLive icon;

    @SerializedName("name")
    protected String name;

    @SerializedName("url")
    protected String url;

    @SerializedName("list")
    protected List<c> userList;

    public d() {
    }

    public d(g r100) {
        this.userList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.url = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.userList.add(new c(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.name = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.icon = new ImageModelLive(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.background = new ImageModelLive(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
