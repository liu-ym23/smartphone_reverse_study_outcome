package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelInfo;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RoomAnchorFansChannelMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/RoomAnchorFansChannelMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "fansClubChannel", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "getFansClubChannel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "", "fansClubChannelList", "Ljava/util/List;", "getFansClubChannelList", "()Ljava/util/List;", "subscribeChannel", "getSubscribeChannel", "", "", "fansGroupChannelMap", "Ljava/util/Map;", "getFansGroupChannelMap", "()Ljava/util/Map;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomAnchorFansChannelMessage extends o0 implements vh7.h {

    @SerializedName("fans_club_channel")
    protected RoomChannelInfo fansClubChannel;

    @SerializedName("fans_club_channel_list")
    protected List<RoomChannelInfo> fansClubChannelList;

    @SerializedName("fans_group_channel_map")
    protected Map<Long, RoomChannelInfo> fansGroupChannelMap;

    @SerializedName("subscribe_channel")
    protected RoomChannelInfo subscribeChannel;

    public RoomAnchorFansChannelMessage() {
        this.type = MessageType.ANCHOR_CHANNEL_SYNC;
    }

    public final RoomChannelInfo getFansClubChannel() {
        return this.fansClubChannel;
    }

    public final List<RoomChannelInfo> getFansClubChannelList() {
        return this.fansClubChannelList;
    }

    public final Map<Long, RoomChannelInfo> getFansGroupChannelMap() {
        return this.fansGroupChannelMap;
    }

    public final RoomChannelInfo getSubscribeChannel() {
        return this.subscribeChannel;
    }

    public RoomAnchorFansChannelMessage(am3.g r110) {
        this.fansClubChannelList = new ArrayList();
        this.fansGroupChannelMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L36;
        if (r101 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.fansClubChannel = new RoomChannelInfo(r110);
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.subscribeChannel = new RoomChannelInfo(r110);
        goto L3
    L12:
        if (r101 != 4) goto L14;
        long r102 = r110.c();
        Long r103 = null;
        RoomChannelInfo r104 = null;
    L18:
        int r105 = r110.f();
        if (r105 == (-1)) goto L25;
        if (r105 != 1) goto L21;
        r103 = Long.valueOf(r110.j());
        goto L18
    L21:
        if (r105 != 2) goto L22;
        r104 = new RoomChannelInfo(r110);
        goto L18
    L22:
        am3.h.e(r110);
        goto L18
    L25:
        r110.d(r102);
        Map<Long, RoomChannelInfo> r106 = this.fansGroupChannelMap;
        if (r103 == null) goto L32;
        if (r104 == null) goto L30;
        r106.put(r103, r104);
        goto L3
    L30:
        throw new IllegalStateException("Value must not be null");
    L32:
        throw new IllegalStateException("Key must not be null");
    L14:
        if (r101 != 5) goto L15;
        this.fansClubChannelList.add(new RoomChannelInfo(r110));
        goto L3
    L15:
        am3.h.e(r110);
        goto L3
    L36:
        r110.d(r100);
        this.type = MessageType.ANCHOR_CHANNEL_SYNC;
    }
}
