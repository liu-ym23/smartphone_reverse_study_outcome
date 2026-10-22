package com.bytedance.android.livesdkapi.depend.model.live.roomchannel;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.SecretChatInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR,\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/SecretChatInfo;", "", "()V", "guestUid", "", "getGuestUid", "()J", "setGuestUid", "(J)V", "ownerUid", "getOwnerUid", "setOwnerUid", "status", "getStatus", "setStatus", "userAvatarList", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "getUserAvatarList", "()Ljava/util/Map;", "setUserAvatarList", "(Ljava/util/Map;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SecretChatInfo implements h {

    @SerializedName("guest_uid")
    protected long guestUid;

    @SerializedName("owner_uid")
    protected long ownerUid;

    @SerializedName("status")
    protected long status;

    @SerializedName("user_avatar_thumb_map")
    protected Map<Long, ? extends ImageModel> userAvatarList;

    public SecretChatInfo() {
    }

    public final long getGuestUid() {
        return this.guestUid;
    }

    public final long getOwnerUid() {
        return this.ownerUid;
    }

    public final long getStatus() {
        return this.status;
    }

    public final Map<Long, ImageModel> getUserAvatarList() {
        return this.userAvatarList;
    }

    public SecretChatInfo(g r110) {
        this.userAvatarList = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        if (r101 != 1) goto L8;
        this.ownerUid = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.guestUid = r110.j();
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.status = r110.j();
        goto L3
    L12:
        if (r101 != 4) goto L13;
        long r102 = r110.c();
        Long r103 = null;
        ImageModel r104 = null;
    L15:
        int r105 = r110.f();
        if (r105 == (-1)) goto L22;
        if (r105 != 1) goto L18;
        r103 = Long.valueOf(r110.j());
        goto L15
    L18:
        if (r105 != 2) goto L19;
        r104 = x.a(r110);
        goto L15
    L19:
        am3.h.e(r110);
        goto L15
    L22:
        r110.d(r102);
        Map<Long, ? extends ImageModel> r106 = this.userAvatarList;
        if (r103 == null) goto L29;
        if (r104 == null) goto L27;
        r106.put(r103, r104);
        goto L3
    L27:
        throw new IllegalStateException("Value must not be null");
    L29:
        throw new IllegalStateException("Key must not be null");
    L13:
        am3.h.e(r110);
        goto L3
    L33:
        r110.d(r100);
    }

    public final void setGuestUid(long r100) {
        this.guestUid = r100;
    }

    public final void setOwnerUid(long r100) {
        this.ownerUid = r100;
    }

    public final void setStatus(long r100) {
        this.status = r100;
    }

    public final void setUserAvatarList(Map<Long, ? extends ImageModel> r100) {
        this.userAvatarList = r100;
    }
}
