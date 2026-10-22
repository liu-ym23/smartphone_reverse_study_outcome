package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.TempStateAreaReachMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/TempStateAreaReachMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "elementType", "J", "G", "()J", "setElementType", "(J)V", "elementId", ExifInterface.LONGITUDE_EAST, "setElementId", "itemId", "getItemId", "setItemId", "status", "getStatus", "setStatus", "Lcom/bytedance/android/livesdk/message/model/TempStateAreaReachMessage$a;", "resource", "Lcom/bytedance/android/livesdk/message/model/TempStateAreaReachMessage$a;", FaceService.neutralLabel, "()Lcom/bytedance/android/livesdk/message/model/TempStateAreaReachMessage$a;", "setResource", "(Lcom/bytedance/android/livesdk/message/model/TempStateAreaReachMessage$a;)V", "<init>", "()V", "ELEM_TYPE", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Status", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TempStateAreaReachMessage extends o0 implements vh7.h {

    @SerializedName("elem_id")
    protected long elementId;

    @SerializedName("elem_type")
    protected long elementType;

    @SerializedName("item_id")
    protected long itemId;

    @SerializedName("resource")
    protected a resource;

    @SerializedName("status")
    protected long status;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/TempStateAreaReachMessage$ELEM_TYPE;", "", "", "type", "J", "getType", "()J", "OPEN_GAME", "PREDICTOR", "INTERACTION_MORE", "KTV_GROUP", "PLAY_TOGETHER", "GUEST_BATTLE_ADMIN", "TEAM_FIGHT_ADMIN", "ROOM_FIGHT_ADMIN", "INTERACT_SONG_ADMIN", "PROFIT_OPEN_GAME_ENTRANCE", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ELEM_TYPE extends Enum<ELEM_TYPE> {
        public static final ELEM_TYPE GUEST_BATTLE_ADMIN = null;
        public static final ELEM_TYPE INTERACTION_MORE = null;
        public static final ELEM_TYPE INTERACT_SONG_ADMIN = null;
        public static final ELEM_TYPE KTV_GROUP = null;
        public static final ELEM_TYPE OPEN_GAME = null;
        public static final ELEM_TYPE PLAY_TOGETHER = null;
        public static final ELEM_TYPE PREDICTOR = null;
        public static final ELEM_TYPE PROFIT_OPEN_GAME_ENTRANCE = null;
        public static final ELEM_TYPE ROOM_FIGHT_ADMIN = null;
        public static final ELEM_TYPE TEAM_FIGHT_ADMIN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ELEM_TYPE[] f153617a = null;
        private final long type;

        public static ELEM_TYPE valueOf(String r100) {
            return (ELEM_TYPE) r27.a.a(ELEM_TYPE.class, r100);
        }

        public static ELEM_TYPE[] values() {
            return (ELEM_TYPE[]) f153617a.clone();
        }

        static {
            ELEM_TYPE r100 = new ELEM_TYPE("OPEN_GAME", 0, 1);
            OPEN_GAME = r100;
            ELEM_TYPE r101 = new ELEM_TYPE("PREDICTOR", 1, 2);
            PREDICTOR = r101;
            ELEM_TYPE r102 = new ELEM_TYPE("INTERACTION_MORE", 2, 3);
            INTERACTION_MORE = r102;
            ELEM_TYPE r103 = new ELEM_TYPE("KTV_GROUP", 3, 4);
            KTV_GROUP = r103;
            ELEM_TYPE r104 = new ELEM_TYPE("PLAY_TOGETHER", 4, 5);
            PLAY_TOGETHER = r104;
            ELEM_TYPE r105 = new ELEM_TYPE("GUEST_BATTLE_ADMIN", 5, 6);
            GUEST_BATTLE_ADMIN = r105;
            ELEM_TYPE r106 = new ELEM_TYPE("TEAM_FIGHT_ADMIN", 6, 7);
            TEAM_FIGHT_ADMIN = r106;
            ELEM_TYPE r107 = new ELEM_TYPE("ROOM_FIGHT_ADMIN", 7, 8);
            ROOM_FIGHT_ADMIN = r107;
            ELEM_TYPE r108 = new ELEM_TYPE("INTERACT_SONG_ADMIN", 8, 9);
            INTERACT_SONG_ADMIN = r108;
            ELEM_TYPE r109 = new ELEM_TYPE("PROFIT_OPEN_GAME_ENTRANCE", 9, 10);
            PROFIT_OPEN_GAME_ENTRANCE = r109;
            f153617a = new ELEM_TYPE[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
        }

        public final long getType() {
            return this.type;
        }

        public ELEM_TYPE(String r100, int r101, long r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/TempStateAreaReachMessage$Status;", "", "", "value", "I", "getValue", "()I", "ADD", "UPDATE", "DELETE", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Status extends Enum<Status> {
        public static final Status ADD = null;
        public static final Status DELETE = null;
        public static final Status UPDATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f153618a = null;
        private final int value;

        static {
            Status r100 = new Status("ADD", 0, 1);
            ADD = r100;
            Status r101 = new Status("UPDATE", 1, 2);
            UPDATE = r101;
            Status r102 = new Status("DELETE", 2, 3);
            DELETE = r102;
            f153618a = new Status[]{r100, r101, r102};
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public static Status[] values() {
            return (Status[]) f153618a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @ProtoMessage("webcast.im.TempStateAreaReachMessage.Resource")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/TempStateAreaReachMessage$a;", "", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "iconUrl", "b", "setIconUrl", "description", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDescription", "extra", "getExtra", "setExtra", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("description")
        protected String description;

        @SerializedName("extra")
        protected String extra;

        @SerializedName("icon")
        protected String iconUrl;

        @SerializedName("name")
        protected String name;

        public a() {
            this.name = "";
            this.iconUrl = "";
            this.description = "";
            this.extra = "";
        }

        public final String a() {
            return this.description;
        }

        public final String b() {
            return this.iconUrl;
        }

        public final String c() {
            return this.name;
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.name = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.iconUrl = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.description = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.extra = am3.h.c(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
            if (this.name != null) goto L22;
            this.name = "";
        L22:
            if (this.iconUrl != null) goto L25;
            this.iconUrl = "";
        L25:
            if (this.description != null) goto L28;
            this.description = "";
        L28:
            if (this.extra != null) goto L46;
            this.extra = "";
            return;
        }
    }

    public TempStateAreaReachMessage() {
        setType(MessageType.TEMP_STATE_AREA_MESSAGE);
    }

    public final long E() {
        return this.elementId;
    }

    public final long G() {
        return this.elementType;
    }

    public final a H() {
        return this.resource;
    }

    public final long getItemId() {
        return this.itemId;
    }

    public final long getStatus() {
        return this.status;
    }

    public TempStateAreaReachMessage(am3.g r100) {
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
        this.resource = new a(r100);
        goto L3
    L8:
        this.status = r100.j();
        goto L3
    L9:
        this.itemId = r100.j();
        goto L3
    L10:
        this.elementId = r100.j();
        goto L3
    L11:
        this.elementType = r100.j();
        goto L3
    L12:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        setType(MessageType.TEMP_STATE_AREA_MESSAGE);
    }
}
