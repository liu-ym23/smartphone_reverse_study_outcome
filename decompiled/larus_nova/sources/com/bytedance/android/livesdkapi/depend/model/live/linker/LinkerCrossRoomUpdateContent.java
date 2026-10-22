package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.p1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerCrossRoomUpdateContent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR,\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR,\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001e\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerCrossRoomUpdateContent;", "", "()V", "clientUIInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUIInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "setClientUIInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "fromRoomId", "", "getFromRoomId", "()J", "setFromRoomId", "(J)V", "linkerContentMap", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/RoomLinkerContent;", "getLinkerContentMap", "()Ljava/util/Map;", "setLinkerContentMap", "(Ljava/util/Map;)V", "mLinkUsers", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/AnchorLinkUser;", "getMLinkUsers", "()Ljava/util/List;", "setMLinkUsers", "(Ljava/util/List;)V", "toRoomId", "getToRoomId", "setToRoomId", "updateInfo", "", "getUpdateInfo", "setUpdateInfo", "version", "getVersion", "setVersion", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkerCrossRoomUpdateContent implements h {

    @SerializedName("client_ui_info")
    protected ClientUIInfo clientUIInfo;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    protected long fromRoomId;

    @SerializedName("linker_content_map")
    protected Map<Long, ? extends RoomLinkerContent> linkerContentMap;

    @SerializedName("linked_users")
    protected List<AnchorLinkUser> mLinkUsers;

    @SerializedName("to_room_id")
    protected long toRoomId;

    @SerializedName("update_info")
    protected Map<String, String> updateInfo;

    @SerializedName("version")
    protected long version;

    public LinkerCrossRoomUpdateContent() {
    }

    public final ClientUIInfo getClientUIInfo() {
        return this.clientUIInfo;
    }

    public final long getFromRoomId() {
        return this.fromRoomId;
    }

    public final Map<Long, RoomLinkerContent> getLinkerContentMap() {
        return this.linkerContentMap;
    }

    public final List<AnchorLinkUser> getMLinkUsers() {
        return this.mLinkUsers;
    }

    public final long getToRoomId() {
        return this.toRoomId;
    }

    public final Map<String, String> getUpdateInfo() {
        return this.updateInfo;
    }

    public final long getVersion() {
        return this.version;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [com.bytedance.android.livesdkapi.depend.message.ClientUIInfo, java.lang.Object] */
    public LinkerCrossRoomUpdateContent(g r110) {
        this.updateInfo = new HashMap();
        this.mLinkUsers = new ArrayList();
        this.linkerContentMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L45;
        Object r102 = null;
        switch(r101) {
            case 1: goto L44;
            case 2: goto L43;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this.clientUIInfo = f.a(r110, ClientUIInfo.class);
        goto L3
    L9:
        long r103 = r110.c();
        Object r104 = null;
    L10:
        int r111 = r110.f();
        if (r111 == (-1)) goto L17;
        if (r111 != 1) goto L13;
        r102 = Long.valueOf(r110.j());
        goto L10
    L13:
        if (r111 != 2) goto L14;
        r104 = p1.a(r110);
        goto L10
    L14:
        am3.h.e(r110);
        goto L10
    L17:
        r110.d(r103);
        Map r105 = this.linkerContentMap;
        if (r102 == null) goto L24;
        if (r104 == null) goto L22;
    L38:
        r105.put(r102, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this.version = r110.j();
        goto L3
    L26:
        this.mLinkUsers.add(new AnchorLinkUser(r110));
        goto L3
    L27:
        long r106 = r110.c();
        r104 = null;
    L28:
        int r112 = r110.f();
        if (r112 == (-1)) goto L35;
        if (r112 != 1) goto L31;
        r102 = am3.h.c(r110);
        goto L28
    L31:
        if (r112 != 2) goto L32;
        r104 = am3.h.c(r110);
        goto L28
    L32:
        am3.h.e(r110);
        goto L28
    L35:
        r110.d(r106);
        r105 = this.updateInfo;
        if (r102 == null) goto L42;
        if (r104 != null) goto L38;
        throw new IllegalStateException("Value must not be null");
    L42:
        throw new IllegalStateException("Key must not be null");
    L43:
        this.toRoomId = r110.j();
        goto L3
    L44:
        this.fromRoomId = r110.j();
        goto L3
    L7:
        am3.h.e(r110);
        goto L3
    L45:
        r110.d(r100);
    }

    public final void setClientUIInfo(ClientUIInfo r100) {
        this.clientUIInfo = r100;
    }

    public final void setFromRoomId(long r100) {
        this.fromRoomId = r100;
    }

    public final void setLinkerContentMap(Map<Long, ? extends RoomLinkerContent> r100) {
        this.linkerContentMap = r100;
    }

    public final void setMLinkUsers(List<AnchorLinkUser> r100) {
        this.mLinkUsers = r100;
    }

    public final void setToRoomId(long r100) {
        this.toRoomId = r100;
    }

    public final void setUpdateInfo(Map<String, String> r100) {
        this.updateInfo = r100;
    }

    public final void setVersion(long r100) {
        this.version = r100;
    }
}
