package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ShowLinkedLiveRoomsMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/gl;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "episodeId", "J", "getEpisodeId", "()J", "setEpisodeId", "(J)V", "", "entryTitle", "Ljava/lang/String;", "getEntryTitle", "()Ljava/lang/String;", "setEntryTitle", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/livesdk/message/model/gl$a;", "showLinkedLiveRooms", "Ljava/util/List;", "getShowLinkedLiveRooms", "()Ljava/util/List;", "setShowLinkedLiveRooms", "(Ljava/util/List;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class gl extends o0 implements vh7.h {

    @SerializedName("entry_title")
    protected String entryTitle;

    @SerializedName("episode_id")
    protected long episodeId;

    @SerializedName("linked_live_rooms")
    protected List<a> showLinkedLiveRooms;

    @ProtoMessage("webcast.im.ShowLinkedLiveRoomsMessage.ShowLinkedLiveRoomInfo")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/message/model/gl$a;", "", "", "userId", "J", "getUserId", "()J", "setUserId", "(J)V", "roomId", "getRoomId", "setRoomId", "", "roomTitle", "Ljava/lang/String;", "getRoomTitle", "()Ljava/lang/String;", "setRoomTitle", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "avatarThumb", "Lcom/bytedance/android/live/base/model/ImageModel;", "getAvatarThumb", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setAvatarThumb", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "avatarMedium", "getAvatarMedium", "setAvatarMedium", "avatarLarge", "getAvatarLarge", "setAvatarLarge", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("avatar_large")
        protected ImageModel avatarLarge;

        @SerializedName("avatar_medium")
        protected ImageModel avatarMedium;

        @SerializedName("avatar_thumb")
        protected ImageModel avatarThumb;

        @SerializedName("room_id")
        protected long roomId;

        @SerializedName("room_title")
        protected String roomTitle;

        @SerializedName("owner_user_id")
        protected long userId;

        public a() {
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L13;
            switch(r102) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            this.avatarLarge = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L8:
            this.avatarMedium = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L9:
            this.avatarThumb = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L10:
            this.roomTitle = am3.h.c(r100);
            goto L3
        L11:
            this.roomId = r100.j();
            goto L3
        L12:
            this.userId = r100.j();
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L13:
            r100.d(r101);
        }
    }

    public gl() {
        this.type = MessageType.SHOW_LINKED_ROOM_MESSAGE;
    }

    public gl(am3.g r100) {
        this.showLinkedLiveRooms = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.episodeId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.entryTitle = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.showLinkedLiveRooms.add(new a(r100));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.SHOW_LINKED_ROOM_MESSAGE;
    }
}
