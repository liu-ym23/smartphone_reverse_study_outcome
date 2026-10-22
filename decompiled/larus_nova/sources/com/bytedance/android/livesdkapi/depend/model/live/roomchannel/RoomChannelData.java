package com.bytedance.android.livesdkapi.depend.model.live.roomchannel;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomChannelData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001e\u0010\"\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001e\u0010%\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R,\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\n\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R,\u0010/\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\n\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R,\u00102\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\n\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelData;", "", "()V", "background", "Lcom/bytedance/android/live/base/model/ImageModel;", "getBackground", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setBackground", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "canCreate", "", "getCanCreate", "()Z", "setCanCreate", "(Z)V", "canLinkMic", "getCanLinkMic", "setCanLinkMic", "channelCountLimit", "", "getChannelCountLimit", "()I", "setChannelCountLimit", "(I)V", "channelList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "getChannelList", "()Ljava/util/List;", "setChannelList", "(Ljava/util/List;)V", "hideLandscapeEntry", "getHideLandscapeEntry", "setHideLandscapeEntry", "mode", "getMode", "setMode", "status", "getStatus", "setStatus", "userChannelApplyMap", "", "", "getUserChannelApplyMap", "()Ljava/util/Map;", "setUserChannelApplyMap", "(Ljava/util/Map;)V", "userFansGroupMap", "getUserFansGroupMap", "setUserFansGroupMap", "userInFansClubMap", "getUserInFansClubMap", "setUserInFansClubMap", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomChannelData implements h {

    @SerializedName("background")
    protected ImageModel background;

    @SerializedName("can_create")
    protected boolean canCreate;

    @SerializedName("can_link_mic")
    protected boolean canLinkMic;

    @SerializedName("limit_of_num")
    protected int channelCountLimit;

    @SerializedName("channel_list")
    protected List<RoomChannelInfo> channelList;

    @SerializedName("hide_landscape")
    protected boolean hideLandscapeEntry;

    @SerializedName("support_room_channel_mode")
    protected int mode;

    @SerializedName("status")
    protected int status;

    @SerializedName("user_channel_apply_map")
    protected Map<Long, Boolean> userChannelApplyMap;

    @SerializedName("user_in_fans_group_map")
    protected Map<Long, Boolean> userFansGroupMap;

    @SerializedName("user_in_fans_club_map")
    protected Map<Long, Boolean> userInFansClubMap;

    public RoomChannelData() {
    }

    public final ImageModel getBackground() {
        return this.background;
    }

    public final boolean getCanCreate() {
        return this.canCreate;
    }

    public final boolean getCanLinkMic() {
        return this.canLinkMic;
    }

    public final int getChannelCountLimit() {
        return this.channelCountLimit;
    }

    public final List<RoomChannelInfo> getChannelList() {
        return this.channelList;
    }

    public final boolean getHideLandscapeEntry() {
        return this.hideLandscapeEntry;
    }

    public final int getMode() {
        return this.mode;
    }

    public final int getStatus() {
        return this.status;
    }

    public final Map<Long, Boolean> getUserChannelApplyMap() {
        return this.userChannelApplyMap;
    }

    public final Map<Long, Boolean> getUserFansGroupMap() {
        return this.userFansGroupMap;
    }

    public final Map<Long, Boolean> getUserInFansClubMap() {
        return this.userInFansClubMap;
    }

    public RoomChannelData(g r110) {
        this.channelList = new ArrayList();
        this.userFansGroupMap = new HashMap();
        this.userChannelApplyMap = new HashMap();
        this.userInFansClubMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L67;
        if (r101 != 101) goto L7;
        this.hideLandscapeEntry = am3.h.a(r110);
        goto L3
    L7:
        switch(r101) {
            case 1: goto L65;
            case 2: goto L64;
            case 3: goto L63;
            case 4: goto L62;
            case 5: goto L61;
            case 6: goto L60;
            default: goto L8;
        };
    L60:
        this.background = x.a(r110);
        goto L3
    L61:
        this.canCreate = am3.h.a(r110);
        goto L3
    L62:
        this.channelCountLimit = r110.i();
        goto L3
    L63:
        this.mode = r110.i();
        goto L3
    L64:
        this.channelList.add(new RoomChannelInfo(r110));
        goto L3
    L65:
        this.status = r110.i();
        goto L3
    L8:
        Long r102 = null;
        switch(r101) {
            case 8: goto L59;
            case 9: goto L43;
            case 10: goto L27;
            case 11: goto L11;
            default: goto L10;
        };
    L11:
        long r103 = r110.c();
        Boolean r104 = null;
    L12:
        int r111 = r110.f();
        if (r111 == (-1)) goto L19;
        if (r111 != 1) goto L15;
        r102 = Long.valueOf(r110.j());
        goto L12
    L15:
        if (r111 != 2) goto L16;
        r104 = Boolean.valueOf(am3.h.a(r110));
        goto L12
    L16:
        am3.h.e(r110);
        goto L12
    L19:
        r110.d(r103);
        Map<Long, Boolean> r105 = this.userInFansClubMap;
        if (r102 == null) goto L26;
        if (r104 == null) goto L24;
    L54:
        r105.put(r102, r104);
        goto L3
    L24:
        throw new IllegalStateException("Value must not be null");
    L26:
        throw new IllegalStateException("Key must not be null");
    L27:
        long r106 = r110.c();
        r104 = null;
    L28:
        int r112 = r110.f();
        if (r112 == (-1)) goto L35;
        if (r112 != 1) goto L31;
        r102 = Long.valueOf(r110.j());
        goto L28
    L31:
        if (r112 != 2) goto L32;
        r104 = Boolean.valueOf(am3.h.a(r110));
        goto L28
    L32:
        am3.h.e(r110);
        goto L28
    L35:
        r110.d(r106);
        r105 = this.userChannelApplyMap;
        if (r102 == null) goto L42;
        if (r104 != null) goto L54;
        throw new IllegalStateException("Value must not be null");
    L42:
        throw new IllegalStateException("Key must not be null");
    L43:
        long r107 = r110.c();
        r104 = null;
    L44:
        int r113 = r110.f();
        if (r113 == (-1)) goto L51;
        if (r113 != 1) goto L47;
        r102 = Long.valueOf(r110.j());
        goto L44
    L47:
        if (r113 != 2) goto L48;
        r104 = Boolean.valueOf(am3.h.a(r110));
        goto L44
    L48:
        am3.h.e(r110);
        goto L44
    L51:
        r110.d(r107);
        r105 = this.userFansGroupMap;
        if (r102 == null) goto L58;
        if (r104 != null) goto L54;
        throw new IllegalStateException("Value must not be null");
    L58:
        throw new IllegalStateException("Key must not be null");
    L59:
        this.canLinkMic = am3.h.a(r110);
        goto L3
    L10:
        am3.h.e(r110);
        goto L3
    L67:
        r110.d(r100);
    }

    public final void setBackground(ImageModel r100) {
        this.background = r100;
    }

    public final void setCanCreate(boolean r100) {
        this.canCreate = r100;
    }

    public final void setCanLinkMic(boolean r100) {
        this.canLinkMic = r100;
    }

    public final void setChannelCountLimit(int r100) {
        this.channelCountLimit = r100;
    }

    public final void setChannelList(List<RoomChannelInfo> r100) {
        this.channelList = r100;
    }

    public final void setHideLandscapeEntry(boolean r100) {
        this.hideLandscapeEntry = r100;
    }

    public final void setMode(int r100) {
        this.mode = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setUserChannelApplyMap(Map<Long, Boolean> r100) {
        this.userChannelApplyMap = r100;
    }

    public final void setUserFansGroupMap(Map<Long, Boolean> r100) {
        this.userFansGroupMap = r100;
    }

    public final void setUserInFansClubMap(Map<Long, Boolean> r100) {
        this.userInFansClubMap = r100;
    }
}
