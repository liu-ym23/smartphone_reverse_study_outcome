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
@ProtoMessage("webcast.data.LinkerUsers")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomLinkerUsers;", "", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "linkUsers", "", "Lcom/bytedance/android/live/base/model/user/User;", "getLinkUsers", "()Ljava/util/List;", "setLinkUsers", "(Ljava/util/List;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomLinkerUsers implements h {

    @SerializedName("count")
    protected int count;

    @SerializedName("users_info")
    protected List<? extends User> linkUsers;

    public RoomLinkerUsers() {
    }

    public final int getCount() {
        return this.count;
    }

    public final List<User> getLinkUsers() {
        return this.linkUsers;
    }

    public RoomLinkerUsers(g r100) {
        this.linkUsers = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.count = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.linkUsers.add(new User(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setCount(int r100) {
        this.count = r100;
    }

    public final void setLinkUsers(List<? extends User> r100) {
        this.linkUsers = r100;
    }
}
