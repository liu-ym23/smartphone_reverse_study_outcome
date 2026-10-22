package com.bytedance.android.live.profile.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes47.dex */
public final class ProfileRoomProxy implements ps0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IRoom f86058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f86059b;

    @Override // ps0.b
    public final long getId() {
        return ((Number) this.f86059b.getValue()).longValue();
    }

    @Override // ps0.b
    public final IRoom b() {
        return this.f86058a;
    }

    public final int c() {
        IRoom r100 = this.f86058a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return (int) r100.getRoomLayout();
    }

    @Override // ps0.b
    public final Long getAutoCover() {
        IRoom r100 = this.f86058a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r100.getAutoCover());
    }

    @Override // ps0.b
    public final String getLabels() {
        IRoom r100 = this.f86058a;
        if (r100 == null) goto L6;
        String r101 = r100.getLabels();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // ps0.b
    public final IBaseUser getOwner() {
        IRoom r100 = this.f86058a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getOwner();
    }

    @Override // ps0.b
    public final String getOwnerUserIdStr() {
        IRoom r100 = this.f86058a;
        if (r100 == null) goto L6;
        String r101 = r100.getOwnerUserIdString();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "0";
    }

    @Override // ps0.b
    public final String getRequestId() {
        IRoom r100 = this.f86058a;
        if (r100 == null) goto L6;
        String r101 = r100.getRequestId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // ps0.b
    public final LiveMode getStreamType() {
        IRoom r100 = this.f86058a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getStreamType();
    }

    @Override // ps0.b
    public final boolean isMediaRoom() {
        IRoom r100 = this.f86058a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isMediaRoom();
    }

    @Override // ps0.b
    public final boolean isVSRoom() {
        IRoom r100 = this.f86058a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isMergeVSRoom() != true) goto L7;
        return true;
    }

    @Override // ps0.b
    public final IRoomOthersData k3() {
        IRoom r100 = this.f86058a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRoomOthers();
    }

    public ProfileRoomProxy() {
        this.f86059b = LazyKt.lazy(new ProfileRoomProxy$id$2(this));
    }

    @Override // ps0.b
    public final boolean a() {
        return os0.b.c().getIMicRoomService().isMicRoom(this.f86058a);
    }

    public ProfileRoomProxy(IRoom r100) {
        this();
        this.f86058a = r100;
    }
}
