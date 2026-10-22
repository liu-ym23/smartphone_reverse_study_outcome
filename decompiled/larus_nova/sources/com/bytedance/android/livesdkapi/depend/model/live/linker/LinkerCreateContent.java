package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerCreateContent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerCreateContent;", "", "()V", "linkType", "", "getLinkType", "()I", "setLinkType", "(I)V", "ownerId", "", "getOwnerId", "()J", "setOwnerId", "(J)V", "ownerOpenId", "", "getOwnerOpenId", "()Ljava/lang/String;", "setOwnerOpenId", "(Ljava/lang/String;)V", "ownerRoomId", "getOwnerRoomId", "setOwnerRoomId", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkerCreateContent implements h {

    @SerializedName("link_type")
    protected int linkType;

    @SerializedName("owner_id")
    protected long ownerId;

    @SerializedName("owner_open_id")
    protected String ownerOpenId;

    @SerializedName("owner_room_id")
    protected long ownerRoomId;

    public LinkerCreateContent() {
    }

    public final int getLinkType() {
        return this.linkType;
    }

    public final long getOwnerId() {
        return this.ownerId;
    }

    public final String getOwnerOpenId() {
        return this.ownerOpenId;
    }

    public final long getOwnerRoomId() {
        return this.ownerRoomId;
    }

    public LinkerCreateContent(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.ownerId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.ownerRoomId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.linkType = (int) r100.j();
        goto L3
    L12:
        if (r102 != 5000) goto L13;
        this.ownerOpenId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setLinkType(int r100) {
        this.linkType = r100;
    }

    public final void setOwnerId(long r100) {
        this.ownerId = r100;
    }

    public final void setOwnerOpenId(String r100) {
        this.ownerOpenId = r100;
    }

    public final void setOwnerRoomId(long r100) {
        this.ownerRoomId = r100;
    }
}
