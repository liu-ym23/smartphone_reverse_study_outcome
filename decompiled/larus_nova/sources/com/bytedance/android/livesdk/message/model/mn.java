package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.GameExtraInfo;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.GameStatusUpdateMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b,\u0010-R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\b¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/mn;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "_anchorId", "J", "get_anchorId", "()J", "set_anchorId", "(J)V", "_roomId", "get_roomId", "set_roomId", "_gameId", "get_gameId", "set_gameId", "", "_gameKind", "I", "get_gameKind", "()I", "set_gameKind", "(I)V", "_roundId", "get_roundId", "set_roundId", "_eventTime", "get_eventTime", "set_eventTime", "_updatePresentMsgType", "get_updatePresentMsgType", "set_updatePresentMsgType", "", "_configExtra", "Ljava/lang/String;", "get_configExtra", "()Ljava/lang/String;", "set_configExtra", "(Ljava/lang/String;)V", "_playKind", "get_playKind", "set_playKind", "_switchID", "get_switchID", "set_switchID", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class mn extends o0 implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153670a = 0;

    @SerializedName("anchor_id")
    protected long _anchorId;

    @SerializedName("config_extra")
    protected String _configExtra;

    @SerializedName("event_time")
    protected int _eventTime;

    @SerializedName("game_id")
    protected long _gameId;

    @SerializedName("game_kind")
    protected int _gameKind;

    @SerializedName("play_kind")
    protected long _playKind;

    @SerializedName("room_id")
    protected long _roomId;

    @SerializedName("round_id")
    protected long _roundId;

    @SerializedName("switch_id")
    protected long _switchID;

    @SerializedName("present_msg_type")
    protected int _updatePresentMsgType;

    public static final class a {
        public static mn a(GameExtraInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "extraInfo");
            mn r101 = new mn();
            r101._updatePresentMsgType = r100.getStatus();
            r101._gameId = r100.getGameId();
            r101._gameKind = r100.getGameKind();
            r101._roundId = r100.getRoundId();
            r101._playKind = r100.getKind();
            return r101;
        }
    }

    static {
    }

    public mn() {
        this.type = MessageType.GAME_UPDATE_PRESENT_MESSAGE;
    }

    public mn(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        this._switchID = r100.j();
        goto L3
    L8:
        this._playKind = r100.j();
        goto L3
    L9:
        this._configExtra = am3.h.c(r100);
        goto L3
    L10:
        this._updatePresentMsgType = r100.i();
        goto L3
    L11:
        this._eventTime = r100.i();
        goto L3
    L12:
        this._roundId = r100.j();
        goto L3
    L13:
        this._gameId = r100.j();
        goto L3
    L14:
        this._gameKind = r100.i();
        goto L3
    L15:
        this._roomId = r100.j();
        goto L3
    L16:
        this._anchorId = r100.j();
        goto L3
    L17:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.GAME_UPDATE_PRESENT_MESSAGE;
    }
}
