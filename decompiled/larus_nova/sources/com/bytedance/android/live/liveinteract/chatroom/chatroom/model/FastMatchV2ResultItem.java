package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import am3.g;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/FastMatchV2ResultItem;", "", "()V", "anchor", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "tag", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/FastMatchV2Tag;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FastMatchV2ResultItem implements h {

    @SerializedName("anchor")
    public IBaseUser anchor;

    @SerializedName("room")
    public IRoom room;

    @SerializedName("tag")
    public FastMatchV2Tag tag;

    public FastMatchV2ResultItem() {
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoom, java.lang.Object] */
    public FastMatchV2ResultItem(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.room = f.a(r100, IRoom.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.anchor = f.a(r100, IBaseUser.class);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.tag = new FastMatchV2Tag(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
