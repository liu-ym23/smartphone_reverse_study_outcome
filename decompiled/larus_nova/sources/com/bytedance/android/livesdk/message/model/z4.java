package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.GameInviteMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/z4;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdk/message/model/z4$a;", "inviteItem", "Lcom/bytedance/android/livesdk/message/model/z4$a;", FaceService.neutralLabel, "()Lcom/bytedance/android/livesdk/message/model/z4$a;", "setInviteItem", "(Lcom/bytedance/android/livesdk/message/model/z4$a;)V", "Lcom/bytedance/android/livesdk/message/model/z4$b;", "invitationSwitch", "Lcom/bytedance/android/livesdk/message/model/z4$b;", "G", "()Lcom/bytedance/android/livesdk/message/model/z4$b;", "setInvitationSwitch", "(Lcom/bytedance/android/livesdk/message/model/z4$b;)V", "", "configExtra", "Ljava/lang/String;", ExifInterface.LONGITUDE_EAST, "()Ljava/lang/String;", "setConfigExtra", "(Ljava/lang/String;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z4 extends o0 implements vh7.h {

    @SerializedName("config_extra")
    protected String configExtra;

    @SerializedName("invitation_switch")
    protected b invitationSwitch;

    @SerializedName("invite_item")
    protected a inviteItem;

    @ProtoMessage("webcast.data.GameInvite")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\b¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/message/model/z4$a;", "", "", "id", "J", "b", "()J", "setId", "(J)V", "", "idStr", "Ljava/lang/String;", "getIdStr", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "", "kind", "I", "c", "()I", "setKind", "(I)V", "createTime", "getCreateTime", "setCreateTime", "nowTime", "d", "setNowTime", Keys.API_PARAM_KEY_SDK_EXPIRETIME, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setExpireTime", "status", "f", "setStatus", "roomId", "e", "setRoomId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("create_time")
        protected long createTime;

        @SerializedName("expire_time")
        protected long expireTime;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        protected long f153704id;

        @SerializedName("id_str")
        protected String idStr;

        @SerializedName("kind")
        protected int kind;

        @SerializedName("now_time")
        protected long nowTime;

        @SerializedName("room_id")
        protected long roomId;

        @SerializedName("status")
        protected int status;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.message.model.z4$a$a, reason: collision with other inner class name */
        public static final class C2366a {
        }

        static {
        }

        public a() {
        }

        public final long a() {
            return this.expireTime;
        }

        public final long b() {
            return this.f153704id;
        }

        public final int c() {
            return this.kind;
        }

        public final long d() {
            return this.nowTime;
        }

        public final long e() {
            return this.roomId;
        }

        public final int f() {
            return this.status;
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            switch(r102) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            this.idStr = am3.h.c(r100);
            goto L3
        L8:
            this.roomId = r100.j();
            goto L3
        L9:
            this.status = (int) r100.j();
            goto L3
        L10:
            this.expireTime = r100.j();
            goto L3
        L11:
            this.nowTime = r100.j();
            goto L3
        L12:
            this.createTime = r100.j();
            goto L3
        L13:
            this.kind = (int) r100.j();
            goto L3
        L14:
            this.f153704id = r100.j();
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.data.InvitationSwitch")
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b1\u00102R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001f¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/z4$b;", "", "", "switchId", "J", "h", "()J", "setSwitchId", "(J)V", "", "gameKind", "I", "d", "()I", "setGameKind", "(I)V", "gameId", "c", "setGameId", "playKind", "f", "setPlayKind", "status", com.amap.api.col.s.ce.f26391f, RXScreenCaptureService.KEY_INDEX, "", "message", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/message/model/z4$c;", "extraBase", "Lcom/bytedance/android/livesdk/message/model/z4$c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/message/model/z4$c;", "setExtraBase", "(Lcom/bytedance/android/livesdk/message/model/z4$c;)V", "Lcom/bytedance/android/livesdk/message/model/z4$d;", "extraForOpen", "Lcom/bytedance/android/livesdk/message/model/z4$d;", "b", "()Lcom/bytedance/android/livesdk/message/model/z4$d;", "setExtraForOpen", "(Lcom/bytedance/android/livesdk/message/model/z4$d;)V", "idStr", "getIdStr", "setIdStr", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("extra_base")
        protected c extraBase;

        @SerializedName("extra_for_open")
        protected d extraForOpen;

        @SerializedName("game_id")
        protected long gameId;

        @SerializedName("game_kind")
        protected int gameKind;

        @SerializedName("id_str")
        protected String idStr;

        @SerializedName("message")
        protected String message;

        @SerializedName("play_kind")
        protected int playKind;

        @SerializedName("status")
        protected int status;

        @SerializedName("id")
        protected long switchId;

        public static final class a {
        }

        static {
        }

        public b() {
        }

        public final c a() {
            return this.extraBase;
        }

        public final d b() {
            return this.extraForOpen;
        }

        public final long c() {
            return this.gameId;
        }

        public final int d() {
            return this.gameKind;
        }

        public final String e() {
            return this.message;
        }

        public final int f() {
            return this.playKind;
        }

        public final int g() {
            return this.status;
        }

        public final long h() {
            return this.switchId;
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L16;
            switch(r102) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            this.idStr = am3.h.c(r100);
            goto L3
        L8:
            this.extraForOpen = new d(r100);
            goto L3
        L9:
            this.extraBase = new c(r100);
            goto L3
        L10:
            this.message = am3.h.c(r100);
            goto L3
        L11:
            this.status = (int) r100.j();
            goto L3
        L12:
            this.playKind = (int) r100.j();
            goto L3
        L13:
            this.gameId = r100.j();
            goto L3
        L14:
            this.gameKind = r100.i();
            goto L3
        L15:
            this.switchId = r100.j();
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L16:
            r100.d(r101);
        }

        public final void i(int r100) {
            this.status = 1;
        }
    }

    @ProtoMessage("webcast.data.SwitchExtraBase")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/z4$c;", "", "", "schemaForCheck", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setSchemaForCheck", "(Ljava/lang/String;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c implements vh7.h {

        @SerializedName("schema_for_check")
        protected String schemaForCheck;

        public c() {
        }

        public c(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.schemaForCheck = am3.h.c(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }

        public final String a() {
            return this.schemaForCheck;
        }
    }

    @ProtoMessage("webcast.data.SwitchExtraForOpen")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/z4$d;", "", "", "schemaForOpen", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setSchemaForOpen", "(Ljava/lang/String;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d implements vh7.h {

        @SerializedName("schema_for_open")
        protected String schemaForOpen;

        public d() {
        }

        public d(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.schemaForOpen = am3.h.c(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }

        public final String a() {
            return this.schemaForOpen;
        }
    }

    public z4() {
        this.type = MessageType.GAME_INVITE_MESSAGE;
    }

    public final String E() {
        return this.configExtra;
    }

    public final b G() {
        return this.invitationSwitch;
    }

    public final a H() {
        return this.inviteItem;
    }

    public z4(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.inviteItem = new a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.invitationSwitch = new b(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.configExtra = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.GAME_INVITE_MESSAGE;
    }
}
