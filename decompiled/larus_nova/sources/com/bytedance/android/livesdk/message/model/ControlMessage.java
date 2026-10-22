package com.bytedance.android.livesdk.message.model;

import android.content.res.Resources;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PublicAreaCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ControlMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 J2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0003:\u0002KLB\u0007¢\u0006\u0004\bH\u0010IJ\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0017J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J-\u0010\u0018\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001a\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u0019R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010=\u001a\u00020 2\u0006\u0010:\u001a\u00020 8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&R(\u0010@\u001a\u0004\u0018\u00010\u000b2\b\u0010:\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b>\u0010*\"\u0004\b?\u0010,R\u0016\u0010D\u001a\u0004\u0018\u00010A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR(\u0010G\u001a\u0004\u0018\u00010\u00072\b\u0010:\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bE\u00107\"\u0004\bF\u00109¨\u0006M"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ControlMessage;", "Lcom/bytedance/android/livesdk/message/model/p0;", "Lvh7/c$a;", "Lcom/bytedance/android/live/base/model/message/o0;", "Lcom/ss/ugc/live/sdk/message/stream/IStreamMessage;", "Lcom/bytedance/android/live/base/model/message/u3;", "Lcom/bytedance/android/live/base/model/message/n0;", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "getOrInitPublicAreaCommon", "", "isMediaRoom", "", "getActionString", "canText", "supportDisplayText", "isStreamMessage", "Lcom/ss/ugc/live/sdk/message/stream/IStreamMessage$DelayMode;", "getDelayMode", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUserInMessage", "Lvh7/e;", "R", "Ljava/lang/Class;", "aClass", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "", "_action", "J", "get_action", "()J", "set_action", "(J)V", "_tips", "Ljava/lang/String;", "get_tips", "()Ljava/lang/String;", "set_tips", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/message/model/ControlMessage$Extra;", "_extraInfo", "Lcom/bytedance/android/livesdk/message/model/ControlMessage$Extra;", "get_extraInfo", "()Lcom/bytedance/android/livesdk/message/model/ControlMessage$Extra;", "set_extraInfo", "(Lcom/bytedance/android/livesdk/message/model/ControlMessage$Extra;)V", "_publicAreaCommon", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "get_publicAreaCommon", "()Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "set_publicAreaCommon", "(Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;)V", "value", "getAction", "setAction", "action", "getTips", "setTips", "tips", "Lcom/bytedance/android/live/base/model/message/o0$b;", "getExtraInfo", "()Lcom/bytedance/android/live/base/model/message/o0$b;", "extraInfo", "getPublicAreaCommon", "setPublicAreaCommon", "publicAreaCommon", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Extra", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ControlMessage extends p0 implements vh7.c.a<com.bytedance.android.live.base.model.message.o0>, com.bytedance.android.live.base.model.message.u3, com.bytedance.android.live.base.model.message.n0, com.bytedance.android.live.base.model.message.o0, vh7.h {
    private static final long ACTION_END = 0;
    private static final long ACTION_PAUSE = 0;
    private static final long ACTION_RESUME = 0;
    private static final long ACTION_ROOM_BANNED = 0;
    private static final long ACTION_SWITCH_STREAM = 0;
    public static final a Companion = null;

    @SerializedName("action")
    protected long _action;

    @SerializedName("extra")
    protected Extra _extraInfo;

    @SerializedName("public_area_common")
    protected PublicAreaCommon _publicAreaCommon;

    @SerializedName("tips")
    protected String _tips;
    private final transient FlexModelDelegate<com.bytedance.android.live.base.model.message.o0> delegate;

    @ProtoMessage("webcast.im.ControlMessage.Extra")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b/\u00100R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R$\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\u0016\u0010\"\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0007R\u0014\u0010$\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u000eR\u0016\u0010(\u001a\u0004\u0018\u00010%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u0004\u0018\u00010%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0016\u0010,\u001a\u0004\u0018\u00010%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0016\u0010.\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0007¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ControlMessage$Extra;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/o0$b;", "", "_banInfoUrl", "Ljava/lang/String;", "get_banInfoUrl", "()Ljava/lang/String;", "set_banInfoUrl", "(Ljava/lang/String;)V", "", "_reasonNo", "J", "get_reasonNo", "()J", "set_reasonNo", "(J)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "_title", "Lcom/bytedance/android/livesdkapi/message/Text;", "get_title", "()Lcom/bytedance/android/livesdkapi/message/Text;", "set_title", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "_violationReason", "get_violationReason", "set_violationReason", "_illegalText", "get_illegalText", "set_illegalText", "_source", "get_source", "set_source", "getBanInfoUrl", "banInfoUrl", "getReasonNo", "reasonNo", "Lcom/bytedance/android/live/base/model/message/a5;", "getTitle", "()Lcom/bytedance/android/live/base/model/message/a5;", "title", "getViolationReason", "violationReason", "getIllegalText", "illegalText", "getSource", "source", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Extra extends FlexModelBase<com.bytedance.android.live.base.model.message.o0.b> implements com.bytedance.android.live.base.model.message.o0.b, vh7.h {

        @SerializedName("ban_info_url")
        protected String _banInfoUrl;

        @SerializedName("content")
        protected Text _illegalText;

        @SerializedName("reason_no")
        protected long _reasonNo;

        @SerializedName("source")
        protected String _source;

        @SerializedName("title")
        protected Text _title;

        @SerializedName("violation_reason")
        protected Text _violationReason;

        public Extra() {
            super(com.bytedance.android.live.base.model.message.o0.b.class);
        }

        @Override // com.bytedance.android.live.base.model.message.o0.b
        public String getBanInfoUrl() {
            return this._banInfoUrl;
        }

        @Override // com.bytedance.android.live.base.model.message.o0.b
        public com.bytedance.android.live.base.model.message.a5 getIllegalText() {
            return this._illegalText;
        }

        @Override // com.bytedance.android.live.base.model.message.o0.b
        public long getReasonNo() {
            return this._reasonNo;
        }

        @Override // com.bytedance.android.live.base.model.message.o0.b
        public String getSource() {
            return this._source;
        }

        @Override // com.bytedance.android.live.base.model.message.o0.b
        public com.bytedance.android.live.base.model.message.a5 getTitle() {
            return this._title;
        }

        @Override // com.bytedance.android.live.base.model.message.o0.b
        public com.bytedance.android.live.base.model.message.a5 getViolationReason() {
            return this._violationReason;
        }

        public final String get_banInfoUrl() {
            return this._banInfoUrl;
        }

        public final Text get_illegalText() {
            return this._illegalText;
        }

        public final long get_reasonNo() {
            return this._reasonNo;
        }

        public final String get_source() {
            return this._source;
        }

        public final Text get_title() {
            return this._title;
        }

        public final Text get_violationReason() {
            return this._violationReason;
        }

        public Extra(am3.g r100) {
            super(com.bytedance.android.live.base.model.message.o0.b.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L24;
            am3.g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this._banInfoUrl = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this._reasonNo = r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this._title = _Text_ProtoDecoder.decodeStatic(r100);
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this._violationReason = _Text_ProtoDecoder.decodeStatic(r100);
            goto L3
        L14:
            if (r102 != 5) goto L16;
            this._illegalText = _Text_ProtoDecoder.decodeStatic(r100);
            goto L3
        L16:
            if (r102 != 8) goto L17;
            this._source = am3.h.c(r100);
            goto L3
        L17:
            am3.h.d(r103, r100);
            goto L3
        L24:
            r100.d(r101);
            setThreadSafe(true);
        }

        public final void set_banInfoUrl(String r100) {
            this._banInfoUrl = r100;
        }

        public final void set_illegalText(Text r100) {
            this._illegalText = r100;
        }

        public final void set_reasonNo(long r100) {
            this._reasonNo = r100;
        }

        public final void set_source(String r100) {
            this._source = r100;
        }

        public final void set_title(Text r100) {
            this._title = r100;
        }

        public final void set_violationReason(Text r100) {
            this._violationReason = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public IBaseUser getUserInMessage() {
        return null;
    }

    static {
        Companion = new a();
        ACTION_PAUSE = 1;
        ACTION_RESUME = 2;
        ACTION_END = 3;
        ACTION_ROOM_BANNED = 4;
        ACTION_SWITCH_STREAM = 5;
    }

    public ControlMessage() {
        this.delegate = new FlexModelDelegate(com.bytedance.android.live.base.model.message.o0.class, this);
        this.type = MessageType.CONTROL;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public boolean canText() {
        if (getBaseMessage() == null) goto L7;
        if (getBaseMessage().supportDisplayText() == false) goto L7;
        return true;
    L7:
        if (getActionString(false).length() != 0) goto L9;
        boolean r100 = true;
    L10:
        if (r100 == false) goto L15;
        return false;
    L15:
        return true;
    L9:
        r100 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public PublicAreaCommon getOrInitPublicAreaCommon() {
        if (getPublicAreaCommon() != null) goto L6;
        setPublicAreaCommon(new PublicAreaCommon());
    L6:
        return getPublicAreaCommon();
    }

    @Override // com.bytedance.android.live.base.model.message.o0
    public /* bridge */ /* synthetic */ IPublicAreaCommon getPublicAreaCommon() {
        return getPublicAreaCommon();
    }

    @Override // com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public boolean isStreamMessage() {
        if (getAction() != ACTION_PAUSE) goto L5;
    L8:
        return true;
    L5:
        if (getAction() == ACTION_RESUME) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.message.model.o0, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public boolean supportDisplayText() {
        if (getBaseMessage() != null) goto L5;
    L7:
        return false;
    L5:
        if (getBaseMessage().supportDisplayText() == false) goto L7;
        return true;
    }

    public static final /* synthetic */ long access$getACTION_END$cp() {
        return ACTION_END;
    }

    public static final /* synthetic */ long access$getACTION_PAUSE$cp() {
        return ACTION_PAUSE;
    }

    public static final /* synthetic */ long access$getACTION_RESUME$cp() {
        return ACTION_RESUME;
    }

    public static final /* synthetic */ long access$getACTION_ROOM_BANNED$cp() {
        return ACTION_ROOM_BANNED;
    }

    public static final /* synthetic */ long access$getACTION_SWITCH_STREAM$cp() {
        return ACTION_SWITCH_STREAM;
    }

    @Override // com.bytedance.android.live.base.model.message.n0, com.bytedance.android.live.base.model.message.o0
    public long getAction() {
        return this._action;
    }

    @Override // com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public IStreamMessage.DelayMode getDelayMode() {
        return IStreamMessage.DelayMode.NOW;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<com.bytedance.android.live.base.model.message.o0> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.live.base.model.message.n0, com.bytedance.android.live.base.model.message.o0
    public com.bytedance.android.live.base.model.message.o0.b getExtraInfo() {
        return this._extraInfo;
    }

    @Override // com.bytedance.android.live.base.model.message.o0
    public String getTips() {
        return this._tips;
    }

    public final long get_action() {
        return this._action;
    }

    public final Extra get_extraInfo() {
        return this._extraInfo;
    }

    public final PublicAreaCommon get_publicAreaCommon() {
        return this._publicAreaCommon;
    }

    public final String get_tips() {
        return this._tips;
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public /* bridge */ /* synthetic */ IPublicAreaCommon getOrInitPublicAreaCommon() {
        return getOrInitPublicAreaCommon();
    }

    @Override // com.bytedance.android.live.base.model.message.o0
    public PublicAreaCommon getPublicAreaCommon() {
        return this._publicAreaCommon;
    }

    public ControlMessage(am3.g r100) {
        this.delegate = new FlexModelDelegate(com.bytedance.android.live.base.model.message.o0.class, this);
        getDelegate().setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = getDelegate().decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._action = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._tips = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._extraInfo = new Extra(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._publicAreaCommon = new PublicAreaCommon(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        getDelegate().setThreadSafe(true);
        this.type = MessageType.CONTROL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<com.bytedance.android.live.base.model.message.o0>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castTo(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<com.bytedance.android.live.base.model.message.o0>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castToOrNull(r100);
    }

    @Override // com.bytedance.android.live.base.model.message.n0
    public String getActionString(boolean r100) {
        Resources r101 = com.bytedance.android.live.core.utils.s1.getContext().getResources();
        if (getAction() != ACTION_PAUSE) goto L7;
        return r101.getString(R.string.ttlive_live_pause);
    L7:
        if (getAction() != ACTION_RESUME) goto L15;
        int r102 = com.bytedance.android.livesdk.interactivity.service.model.e.f140912a;
        if (com.bytedance.android.livesdk.interactivity.service.model.e.a.a().controlMessage == true) goto L17;
        if (r100 == false) goto L14;
        return r101.getString(R.string.ttlive_live_resume_media);
    L14:
        return r101.getString(R.string.ttlive_live_resume);
    L17:
        return r101.getString(R.string.ttlive_live_resume);
    L15:
        return "";
    }

    @Override // com.bytedance.android.live.base.model.message.o0
    public void setAction(long r100) {
        this._action = r100;
    }

    public void setPublicAreaCommon(PublicAreaCommon r100) {
        this._publicAreaCommon = r100;
    }

    public void setTips(String r100) {
        this._tips = r100;
    }

    public final void set_action(long r100) {
        this._action = r100;
    }

    public final void set_extraInfo(Extra r100) {
        this._extraInfo = r100;
    }

    public final void set_publicAreaCommon(PublicAreaCommon r100) {
        this._publicAreaCommon = r100;
    }

    public final void set_tips(String r100) {
        this._tips = r100;
    }
}
