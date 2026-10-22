package com.bytedance.android.livesdkapi.feed.data;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/data/FeedViewRoomInfoStore;", "", "onlineList", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "(Ljava/util/List;Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "getOnlineList", "()Ljava/util/List;", "setOnlineList", "(Ljava/util/List;)V", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedViewRoomInfoStore {
    private List<ILinkPlayerInfoBridge> onlineList;
    private IRoom room;

    /* JADX WARN: Multi-variable type inference failed */
    public FeedViewRoomInfoStore() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.onlineList.size());
        r100.append(" ;; ");
        IRoom r101 = this.room;
        if (r101 == null) goto L5;
        String r102 = r101.getOwnerUserIdString();
    L6:
        r100.append(r102);
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final List<ILinkPlayerInfoBridge> getOnlineList() {
        return this.onlineList;
    }

    public final IRoom getRoom() {
        return this.room;
    }

    public final void setOnlineList(List<ILinkPlayerInfoBridge> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.onlineList = r100;
    }

    public final void setRoom(IRoom r100) {
        this.room = r100;
    }

    public FeedViewRoomInfoStore(List<ILinkPlayerInfoBridge> r100, IRoom r101) {
        Intrinsics.checkNotNullParameter(r100, "onlineList");
        this.onlineList = r100;
        this.room = r101;
    }

    public /* synthetic */ FeedViewRoomInfoStore(List r100, IRoom r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
