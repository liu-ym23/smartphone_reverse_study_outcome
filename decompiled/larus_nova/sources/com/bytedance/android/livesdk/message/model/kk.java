package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.FlexImageModel;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RoomBottomMessage")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b3\u00104R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R$\u0010-\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0011\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/kk;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "_content", "Ljava/lang/String;", "get_content", "()Ljava/lang/String;", "set_content", "(Ljava/lang/String;)V", "_color", "get_color", "set_color", "_traceId", "get_traceId", "set_traceId", "Lcom/bytedance/android/live/base/model/ImageModel;", "_icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_icon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_icon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_actionContent", "get_actionContent", "set_actionContent", "", "_actionType", "J", "get_actionType", "()J", "set_actionType", "(J)V", "_pushDisplayTime", "get_pushDisplayTime", "set_pushDisplayTime", "Lcom/bytedance/android/live/base/model/FlexImageModel;", "_backgroundImage", "Lcom/bytedance/android/live/base/model/FlexImageModel;", "get_backgroundImage", "()Lcom/bytedance/android/live/base/model/FlexImageModel;", "set_backgroundImage", "(Lcom/bytedance/android/live/base/model/FlexImageModel;)V", "_newBackgroundImage", "get_newBackgroundImage", "set_newBackgroundImage", "_actionIcon", "get_actionIcon", "set_actionIcon", "_source", "get_source", "X", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class kk extends o0 implements vh7.h {

    @SerializedName("action_content")
    protected String _actionContent;

    @SerializedName("action_icon")
    protected ImageModel _actionIcon;

    @SerializedName("action_type")
    protected long _actionType;

    @IgnoreProtoFieldCheck
    @SerializedName("background_image")
    private FlexImageModel _backgroundImage;

    @SerializedName("color")
    protected String _color;

    @IgnoreProtoFieldCheck
    @SerializedName("content")
    private String _content;

    @IgnoreProtoFieldCheck
    @SerializedName("icon")
    private ImageModel _icon;

    @SerializedName("new_background_image")
    protected FlexImageModel _newBackgroundImage;

    @SerializedName("push_message_display_time")
    protected long _pushDisplayTime;

    @SerializedName("source")
    protected String _source;

    @IgnoreProtoFieldCheck
    @SerializedName("traceid")
    private String _traceId;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @IgnoreProtoFieldCheck
    public transient int f153662a;

    public static final class a {
    }

    static {
    }

    public kk() {
        this.type = MessageType.ROOM_PUSH;
    }

    @Override // com.bytedance.android.livesdk.message.model.o0, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean supportDisplayText() {
        CommonMessageData r100 = getBaseMessage();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.supportDisplayText() != true) goto L7;
        return true;
    }

    public final ImageModel E() {
        return this._actionIcon;
    }

    public final long G() {
        return this._actionType;
    }

    public final FlexImageModel H() {
        return this._newBackgroundImage;
    }

    public final long P() {
        return this._pushDisplayTime;
    }

    public final String getActionContent() {
        return this._actionContent;
    }

    public final String getColor() {
        return this._color;
    }

    public final String getContent() {
        return this._content;
    }

    public final String getSource() {
        return this._source;
    }

    public final String getTraceId() {
        return this._traceId;
    }

    public kk(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L25;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this._color = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 6) goto L12;
        this._actionContent = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 7) goto L14;
        this._actionType = r100.j();
        goto L3
    L14:
        if (r102 != 8) goto L15;
        this._pushDisplayTime = r100.j();
        goto L3
    L15:
        switch(r102) {
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L17;
            default: goto L16;
        };
    L17:
        this._source = am3.h.c(r100);
        goto L3
    L18:
        this._newBackgroundImage = com.bytedance.android.live.base.model.v.a(r100);
        goto L3
    L19:
        this._actionIcon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L16:
        am3.h.e(r100);
        goto L3
    L25:
        r100.d(r101);
        this.type = MessageType.ROOM_PUSH;
    }

    public final void Q(String r100) {
        this._actionContent = r100;
    }

    public final void T(String r100) {
        this._actionType = CastLongProtector.parseLong(r100);
    }

    public final void V(long r100) {
        this._pushDisplayTime = r100;
    }

    public final void X(String r100) {
        this._source = r100;
    }

    public final void setColor(String r100) {
        this._color = r100;
    }

    public final void setContent(String r100) {
        this._content = r100;
    }

    public final void setIcon(ImageModel r100) {
        this._icon = r100;
    }

    public final void setSource(String r100) {
        this._source = r100;
    }

    public final void setTraceId(String r100) {
        this._traceId = r100;
    }
}
