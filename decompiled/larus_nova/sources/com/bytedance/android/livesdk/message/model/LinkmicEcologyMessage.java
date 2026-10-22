package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicEcologyMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0006456789B\u0007¢\u0006\u0004\b2\u00103J/\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\n\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\n\u0010\tR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010(8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R \u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u0006:"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdk/message/model/g9;", "Lvh7/c$a;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castToOrNull", "(Ljava/lang/Class;)Lvh7/e;", "castTo", "", SeiMessageConst.MSG_TYPE, "I", "getMsg_type", "()I", "setMsg_type", "(I)V", "Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$LiveMatrixEntranceChangeContent;", "changeContent", "Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$LiveMatrixEntranceChangeContent;", "getChangeContent", "()Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$LiveMatrixEntranceChangeContent;", "setChangeContent", "(Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$LiveMatrixEntranceChangeContent;)V", "Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$XPlayInitContent;", "xplayINitContent", "Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$XPlayInitContent;", "getXplayINitContent", "()Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$XPlayInitContent;", "Lcom/bytedance/android/live/base/model/message/e1;", "hamletAvatarStartContent", "Lcom/bytedance/android/live/base/model/message/e1;", "getHamletAvatarStartContent", "()Lcom/bytedance/android/live/base/model/message/e1;", "Lcom/bytedance/android/live/base/model/message/i3;", "notifyMultiAvatarPublicStream", "Lcom/bytedance/android/live/base/model/message/i3;", "getNotifyMultiAvatarPublicStream", "()Lcom/bytedance/android/live/base/model/message/i3;", "Lcom/bytedance/android/live/base/model/message/s;", "audioShowMediaContent", "Lcom/bytedance/android/live/base/model/message/s;", "getAudioShowMediaContent", "()Lcom/bytedance/android/live/base/model/message/s;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "<init>", "()V", "AudioShowMediaContent", "HamletAvatarStartContent", "LiveMatrixEntranceChangeContent", "NotifyMultiAvatarPublicStream", "XPlayInitContent", "XplayHamletAvatarInitContent", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicEcologyMessage extends o0 implements g9, vh7.c.a<g9>, vh7.h {

    @SerializedName("audio_show_media_content")
    protected com.bytedance.android.live.base.model.message.s audioShowMediaContent;

    @SerializedName("live_matrix_entrance_change_content")
    protected LiveMatrixEntranceChangeContent changeContent;
    private final transient FlexModelDelegate<g9> delegate;

    @SerializedName("hamlet_avatar_start_content")
    protected com.bytedance.android.live.base.model.message.e1 hamletAvatarStartContent;

    @SerializedName(SeiMessageConst.MSG_TYPE)
    protected int msg_type;

    @SerializedName("notify_multi_avatar_publick_stream")
    protected com.bytedance.android.live.base.model.message.i3 notifyMultiAvatarPublicStream;

    @SerializedName("xplay_init_content")
    protected XPlayInitContent xplayINitContent;

    @ProtoMessage("webcast.im.AudioShowMediaContent")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$AudioShowMediaContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/s;", "", "status", "J", "getStatus", "()J", "setStatus", "(J)V", "", "linkMicID", "Ljava/lang/String;", "getLinkMicID", "()Ljava/lang/String;", "showUserId", "getShowUserId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AudioShowMediaContent extends FlexModelBase<com.bytedance.android.live.base.model.message.s> implements com.bytedance.android.live.base.model.message.s, vh7.h {

        @SerializedName("linkmic_id")
        protected String linkMicID;

        @SerializedName("show_user_id")
        protected String showUserId;

        @SerializedName("status")
        protected long status;

        public AudioShowMediaContent() {
            super(com.bytedance.android.live.base.model.message.s.class);
        }

        @Override // com.bytedance.android.live.base.model.message.s
        public String getLinkMicID() {
            return this.linkMicID;
        }

        @Override // com.bytedance.android.live.base.model.message.s
        public String getShowUserId() {
            return this.showUserId;
        }

        @Override // com.bytedance.android.live.base.model.message.s
        public long getStatus() {
            return this.status;
        }

        public AudioShowMediaContent(am3.g r100) {
            super(com.bytedance.android.live.base.model.message.s.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            am3.g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.linkMicID = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.status = r100.i();
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.showUserId = am3.h.c(r100);
            goto L3
        L11:
            am3.h.d(r103, r100);
            goto L3
        L15:
            r100.d(r101);
            setThreadSafe(true);
        }

        public void setStatus(long r100) {
            this.status = r100;
        }
    }

    @ProtoMessage("webcast.im.HamletAvatarStartContent")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$HamletAvatarStartContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/e1;", "", "multiAvatarMode", "Z", "getMultiAvatarMode", "()Z", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class HamletAvatarStartContent extends FlexModelBase<com.bytedance.android.live.base.model.message.e1> implements com.bytedance.android.live.base.model.message.e1, vh7.h {

        @SerializedName("multi_avatar_mode")
        protected boolean multiAvatarMode;

        public HamletAvatarStartContent() {
            super(com.bytedance.android.live.base.model.message.e1.class);
        }

        public HamletAvatarStartContent(am3.g r100) {
            super(com.bytedance.android.live.base.model.message.e1.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            am3.g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L7;
            this.multiAvatarMode = am3.h.a(r100);
            goto L3
        L7:
            am3.h.d(r103, r100);
            goto L3
        L9:
            r100.d(r101);
            setThreadSafe(true);
        }

        @Override // com.bytedance.android.live.base.model.message.e1
        public boolean getMultiAvatarMode() {
            return this.multiAvatarMode;
        }
    }

    @ProtoMessage("webcast.im.LiveMatrixEntranceChangeContent")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$LiveMatrixEntranceChangeContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/b3;", "", "roomId", "I", "getRoomId", "()I", "setRoomId", "(I)V", "", "matrixId", "J", "getMatrixId", "()J", "setMatrixId", "(J)V", "", "matrixName", "Ljava/lang/String;", "getMatrixName", "()Ljava/lang/String;", "setMatrixName", "(Ljava/lang/String;)V", "", "show", "Z", "getShow", "()Z", "setShow", "(Z)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LiveMatrixEntranceChangeContent extends FlexModelBase<com.bytedance.android.live.base.model.message.b3> implements com.bytedance.android.live.base.model.message.b3, vh7.h {

        @SerializedName("matrix_id")
        protected long matrixId;

        @SerializedName("name")
        protected String matrixName;

        @SerializedName("room_id")
        protected int roomId;

        @SerializedName("show")
        protected boolean show;

        public LiveMatrixEntranceChangeContent() {
            super(com.bytedance.android.live.base.model.message.b3.class);
            this.matrixName = "";
        }

        @Override // com.bytedance.android.live.base.model.message.b3
        public long getMatrixId() {
            return this.matrixId;
        }

        @Override // com.bytedance.android.live.base.model.message.b3
        public String getMatrixName() {
            return this.matrixName;
        }

        @Override // com.bytedance.android.live.base.model.message.b3
        public int getRoomId() {
            return this.roomId;
        }

        @Override // com.bytedance.android.live.base.model.message.b3
        public boolean getShow() {
            return this.show;
        }

        public LiveMatrixEntranceChangeContent(am3.g r100) {
            super(com.bytedance.android.live.base.model.message.b3.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            am3.g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.roomId = (int) r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.matrixId = r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.matrixName = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.show = am3.h.a(r100);
            goto L3
        L13:
            am3.h.d(r103, r100);
            goto L3
        L18:
            r100.d(r101);
            setThreadSafe(true);
            if (this.matrixName != null) goto L37;
            this.matrixName = "";
            return;
        }

        public void setMatrixId(long r100) {
            this.matrixId = r100;
        }

        public void setMatrixName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.matrixName = r100;
        }

        public void setRoomId(int r100) {
            this.roomId = r100;
        }

        public void setShow(boolean r100) {
            this.show = r100;
        }
    }

    @ProtoMessage("webcast.im.NotifyMultiAvatarPublicStream")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$NotifyMultiAvatarPublicStream;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/i3;", "", "status", "J", "getStatus", "()J", "setStatus", "(J)V", "", EventConstant.Key.RETAIN_PROMPT, "Ljava/lang/String;", "getPrompt", "()Ljava/lang/String;", "rtcRoomId", "getRtcRoomId", "rtcUserId", "getRtcUserId", "mixStreamTaskId", "getMixStreamTaskId", "publicStreamId", "getPublicStreamId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class NotifyMultiAvatarPublicStream extends FlexModelBase<com.bytedance.android.live.base.model.message.i3> implements com.bytedance.android.live.base.model.message.i3, vh7.h {

        @SerializedName("mix_stream_task_id")
        protected String mixStreamTaskId;

        @SerializedName(EventConstant.Key.RETAIN_PROMPT)
        protected String prompt;

        @SerializedName("public_stream_id")
        protected String publicStreamId;

        @SerializedName("rtc_room_id")
        protected String rtcRoomId;

        @SerializedName("rtc_user_id")
        protected String rtcUserId;

        @SerializedName("status")
        protected long status;

        public NotifyMultiAvatarPublicStream() {
            super(com.bytedance.android.live.base.model.message.i3.class);
        }

        @Override // com.bytedance.android.live.base.model.message.i3
        public String getMixStreamTaskId() {
            return this.mixStreamTaskId;
        }

        @Override // com.bytedance.android.live.base.model.message.i3
        public String getPrompt() {
            return this.prompt;
        }

        @Override // com.bytedance.android.live.base.model.message.i3
        public String getPublicStreamId() {
            return this.publicStreamId;
        }

        @Override // com.bytedance.android.live.base.model.message.i3
        public String getRtcRoomId() {
            return this.rtcRoomId;
        }

        @Override // com.bytedance.android.live.base.model.message.i3
        public String getRtcUserId() {
            return this.rtcUserId;
        }

        @Override // com.bytedance.android.live.base.model.message.i3
        public long getStatus() {
            return this.status;
        }

        public NotifyMultiAvatarPublicStream(am3.g r100) {
            super(com.bytedance.android.live.base.model.message.i3.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L24;
            am3.g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.status = r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.prompt = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.rtcRoomId = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this.rtcUserId = am3.h.c(r100);
            goto L3
        L14:
            if (r102 != 6) goto L16;
            this.mixStreamTaskId = am3.h.c(r100);
            goto L3
        L16:
            if (r102 != 7) goto L17;
            this.publicStreamId = am3.h.c(r100);
            goto L3
        L17:
            am3.h.d(r103, r100);
            goto L3
        L24:
            r100.d(r101);
            setThreadSafe(true);
        }

        public void setStatus(long r100) {
            this.status = r100;
        }
    }

    @ProtoMessage("webcast.im.XplayInitContent")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001$B\u0007¢\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0005\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0097D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u00118\u0016X\u0097D¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$XPlayInitContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/x5;", "", "toString", "channel", "Ljava/lang/String;", "getChannel", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", "gameId", "getGameId", "setGameId", "initParam", "getInitParam", "setInitParam", "", "initType", "J", "getInitType", "()J", "videoSimulcast", "getVideoSimulcast", "videoSimulcastIndex", "getVideoSimulcastIndex", "Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$XplayHamletAvatarInitContent;", "hamletAvatarInit", "Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$XplayHamletAvatarInitContent;", "getHamletAvatarInit", "()Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$XplayHamletAvatarInitContent;", "rtcAppId", "getRtcAppId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class XPlayInitContent extends FlexModelBase<com.bytedance.android.live.base.model.message.x5> implements com.bytedance.android.live.base.model.message.x5, vh7.h {
        public static final a Companion = null;

        @SerializedName("channel")
        protected String channel;

        @SerializedName("game_id")
        protected String gameId;

        @SerializedName("hamlet_avatar_init")
        protected XplayHamletAvatarInitContent hamletAvatarInit;

        @SerializedName("init_param")
        protected String initParam;

        @SerializedName("init_type")
        protected long initType;

        @SerializedName("rtc_app_id")
        protected String rtcAppId;

        @SerializedName("video_simulcast")
        protected String videoSimulcast;

        @SerializedName("video_simulcast_index")
        protected long videoSimulcastIndex;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public XPlayInitContent() {
            super(com.bytedance.android.live.base.model.message.x5.class);
            this.channel = "";
            this.gameId = "";
            this.initParam = "";
            this.videoSimulcast = "";
        }

        public String toString() {
            return "XPlayInitContent(channel='" + getChannel() + "', gameId='" + getGameId() + "', initParam='" + getInitParam() + "', initType=" + getInitType() + ", videoSimulcast='" + getVideoSimulcast() + "', videoSimulcastIndex=" + getVideoSimulcastIndex() + ", hamletAvatarInit=" + getHamletAvatarInit() + ", rtcAppId=" + getRtcAppId() + ')';
        }

        @Override // com.bytedance.android.live.base.model.message.x5
        public /* bridge */ /* synthetic */ com.bytedance.android.live.base.model.message.w5 getHamletAvatarInit() {
            return getHamletAvatarInit();
        }

        @Override // com.bytedance.android.live.base.model.message.x5
        public String getChannel() {
            return this.channel;
        }

        @Override // com.bytedance.android.live.base.model.message.x5
        public String getGameId() {
            return this.gameId;
        }

        @Override // com.bytedance.android.live.base.model.message.x5
        public String getInitParam() {
            return this.initParam;
        }

        @Override // com.bytedance.android.live.base.model.message.x5
        public long getInitType() {
            return this.initType;
        }

        @Override // com.bytedance.android.live.base.model.message.x5
        public String getRtcAppId() {
            return this.rtcAppId;
        }

        @Override // com.bytedance.android.live.base.model.message.x5
        public String getVideoSimulcast() {
            return this.videoSimulcast;
        }

        @Override // com.bytedance.android.live.base.model.message.x5
        public long getVideoSimulcastIndex() {
            return this.videoSimulcastIndex;
        }

        @Override // com.bytedance.android.live.base.model.message.x5
        public XplayHamletAvatarInitContent getHamletAvatarInit() {
            return this.hamletAvatarInit;
        }

        public XPlayInitContent(am3.g r100) {
            super(com.bytedance.android.live.base.model.message.x5.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L19;
            am3.g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.channel = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.gameId = am3.h.c(r100);
            goto L3
        L9:
            switch(r102) {
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                default: goto L10;
            };
        L11:
            this.hamletAvatarInit = new XplayHamletAvatarInitContent(r100);
            goto L3
        L12:
            this.videoSimulcastIndex = r100.j();
            goto L3
        L13:
            this.videoSimulcast = am3.h.c(r100);
            goto L3
        L14:
            this.rtcAppId = am3.h.c(r100);
            goto L3
        L15:
            this.initType = r100.i();
            goto L3
        L16:
            this.initParam = am3.h.c(r100);
            goto L3
        L10:
            am3.h.d(r103, r100);
            goto L3
        L19:
            r100.d(r101);
            setThreadSafe(true);
            if (this.channel != null) goto L23;
            this.channel = "";
        L23:
            if (this.gameId != null) goto L26;
            this.gameId = "";
        L26:
            if (this.initParam != null) goto L29;
            this.initParam = "";
        L29:
            if (this.videoSimulcast != null) goto L54;
            this.videoSimulcast = "";
            return;
        }

        public void setChannel(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.channel = r100;
        }

        public void setGameId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.gameId = r100;
        }

        @Override // com.bytedance.android.live.base.model.message.x5
        public void setInitParam(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.initParam = r100;
        }
    }

    @ProtoMessage("webcast.im.XplayHamletAvatarInitContent")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicEcologyMessage$XplayHamletAvatarInitContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/w5;", "", "toString", "", "", "allAvatarIds", "Ljava/util/List;", "getAllAvatarIds", "()Ljava/util/List;", "avatarId", "J", "getAvatarId", "()J", "setAvatarId", "(J)V", "", "multiAvatarMode", "Z", "getMultiAvatarMode", "()Z", "setMultiAvatarMode", "(Z)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class XplayHamletAvatarInitContent extends FlexModelBase<com.bytedance.android.live.base.model.message.w5> implements com.bytedance.android.live.base.model.message.w5, vh7.h {

        @SerializedName("all_avatar_ids")
        protected List<Long> allAvatarIds;

        @SerializedName("avatar_id")
        protected long avatarId;

        @SerializedName("multi_avatar_mode")
        protected boolean multiAvatarMode;

        public XplayHamletAvatarInitContent() {
            super(com.bytedance.android.live.base.model.message.w5.class);
            this.allAvatarIds = new ArrayList();
        }

        public String toString() {
            return "XplayHamletAvatarInitContent(allAvatarIds=" + CollectionsKt.joinToString$default(getAllAvatarIds(), ", ", "[", "]", 0, null, null, 56, null) + ", avatarId=" + getAvatarId() + ", multiAvatarMode=" + getMultiAvatarMode() + ')';
        }

        @Override // com.bytedance.android.live.base.model.message.w5
        public List<Long> getAllAvatarIds() {
            return this.allAvatarIds;
        }

        @Override // com.bytedance.android.live.base.model.message.w5
        public long getAvatarId() {
            return this.avatarId;
        }

        @Override // com.bytedance.android.live.base.model.message.w5
        public boolean getMultiAvatarMode() {
            return this.multiAvatarMode;
        }

        public XplayHamletAvatarInitContent(am3.g r100) {
            super(com.bytedance.android.live.base.model.message.w5.class);
            this.allAvatarIds = new ArrayList();
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            am3.g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.allAvatarIds.add(Long.valueOf(r100.j()));
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.avatarId = r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.multiAvatarMode = am3.h.a(r100);
            goto L3
        L11:
            am3.h.d(r103, r100);
            goto L3
        L15:
            r100.d(r101);
            setThreadSafe(true);
            if (this.allAvatarIds.isEmpty() == false) goto L31;
            this.allAvatarIds = new ArrayList();
            return;
        }

        @Override // com.bytedance.android.live.base.model.message.w5
        public void setAvatarId(long r100) {
            this.avatarId = r100;
        }

        @Override // com.bytedance.android.live.base.model.message.w5
        public void setMultiAvatarMode(boolean r100) {
            this.multiAvatarMode = r100;
        }
    }

    public LinkmicEcologyMessage() {
        this.delegate = new FlexModelDelegate(g9.class, this);
        this.type = MessageType.LIVE_MATRIX_ENTRANCE_MESSAGE;
    }

    @Override // com.bytedance.android.livesdk.message.model.g9
    public /* bridge */ /* synthetic */ com.bytedance.android.live.base.model.message.b3 getChangeContent() {
        return getChangeContent();
    }

    @Override // com.bytedance.android.livesdk.message.model.g9
    public /* bridge */ /* synthetic */ com.bytedance.android.live.base.model.message.x5 getXplayINitContent() {
        return getXplayINitContent();
    }

    @Override // com.bytedance.android.livesdk.message.model.g9
    public com.bytedance.android.live.base.model.message.s getAudioShowMediaContent() {
        return this.audioShowMediaContent;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<g9> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.livesdk.message.model.g9
    public com.bytedance.android.live.base.model.message.e1 getHamletAvatarStartContent() {
        return this.hamletAvatarStartContent;
    }

    @Override // com.bytedance.android.livesdk.message.model.g9
    public int getMsg_type() {
        return this.msg_type;
    }

    @Override // com.bytedance.android.livesdk.message.model.g9
    public com.bytedance.android.live.base.model.message.i3 getNotifyMultiAvatarPublicStream() {
        return this.notifyMultiAvatarPublicStream;
    }

    @Override // com.bytedance.android.livesdk.message.model.g9
    public LiveMatrixEntranceChangeContent getChangeContent() {
        return this.changeContent;
    }

    @Override // com.bytedance.android.livesdk.message.model.g9
    public XPlayInitContent getXplayINitContent() {
        return this.xplayINitContent;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.live.base.model.message.s, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.base.model.message.e1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.base.model.message.i3, java.lang.Object] */
    public LinkmicEcologyMessage(am3.g r100) {
        this.delegate = new FlexModelDelegate(g9.class, this);
        getDelegate().setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = getDelegate().decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L7;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this.audioShowMediaContent = vh7.f.a(r100, com.bytedance.android.live.base.model.message.s.class);
        goto L3
    L9:
        this.notifyMultiAvatarPublicStream = vh7.f.a(r100, com.bytedance.android.live.base.model.message.i3.class);
        goto L3
    L10:
        this.hamletAvatarStartContent = vh7.f.a(r100, com.bytedance.android.live.base.model.message.e1.class);
        goto L3
    L11:
        this.xplayINitContent = new XPlayInitContent(r100);
        goto L3
    L12:
        this.changeContent = new LiveMatrixEntranceChangeContent(r100);
        goto L3
    L13:
        this.msg_type = r100.i();
        goto L3
    L14:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        getDelegate().setThreadSafe(true);
        this.type = MessageType.LIVE_MATRIX_ENTRANCE_MESSAGE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.message.model.g9, vh7.c
    public <R extends vh7.e<g9>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) getDelegate().castTo(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.message.model.g9, vh7.c
    public <R extends vh7.e<g9>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) getDelegate().castToOrNull(r100);
    }

    public void setChangeContent(LiveMatrixEntranceChangeContent r100) {
        this.changeContent = r100;
    }

    public void setMsg_type(int r100) {
        this.msg_type = r100;
    }
}
