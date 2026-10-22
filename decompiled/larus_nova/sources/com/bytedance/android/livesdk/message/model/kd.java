package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\bH\u0010IR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/kd;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "msgType", "J", "getMsgType", "()J", "setMsgType", "(J)V", "Lcom/bytedance/android/livesdk/message/model/u2;", "midiRankContent", "Lcom/bytedance/android/livesdk/message/model/u2;", FaceService.neutralLabel, "()Lcom/bytedance/android/livesdk/message/model/u2;", "setMidiRankContent", "(Lcom/bytedance/android/livesdk/message/model/u2;)V", "Lcom/bytedance/android/livesdk/message/model/l2;", "chorusFinishContent", "Lcom/bytedance/android/livesdk/message/model/l2;", "getChorusFinishContent", "()Lcom/bytedance/android/livesdk/message/model/l2;", "setChorusFinishContent", "(Lcom/bytedance/android/livesdk/message/model/l2;)V", "Lcom/bytedance/android/livesdk/message/model/z2;", "chorusUserChangedContent", "Lcom/bytedance/android/livesdk/message/model/z2;", "G", "()Lcom/bytedance/android/livesdk/message/model/z2;", "setChorusUserChangedContent", "(Lcom/bytedance/android/livesdk/message/model/z2;)V", "Lcom/bytedance/android/livesdk/message/model/i2;", "chorusCDNSingersOnlyContent", "Lcom/bytedance/android/livesdk/message/model/i2;", "getChorusCDNSingersOnlyContent", "()Lcom/bytedance/android/livesdk/message/model/i2;", "setChorusCDNSingersOnlyContent", "(Lcom/bytedance/android/livesdk/message/model/i2;)V", "Lcom/bytedance/android/livesdk/message/model/h2;", "chorusAccompanimentInfoContent", "Lcom/bytedance/android/livesdk/message/model/h2;", "getChorusAccompanimentInfoContent", "()Lcom/bytedance/android/livesdk/message/model/h2;", "setChorusAccompanimentInfoContent", "(Lcom/bytedance/android/livesdk/message/model/h2;)V", "Lcom/bytedance/android/livesdk/message/model/r2;", "chorusLeaderSettingContent", "Lcom/bytedance/android/livesdk/message/model/r2;", "getChorusLeaderSettingContent", "()Lcom/bytedance/android/livesdk/message/model/r2;", "setChorusLeaderSettingContent", "(Lcom/bytedance/android/livesdk/message/model/r2;)V", "Lcom/bytedance/android/livesdk/message/model/j2;", "chorusComponentSwitchContent", "Lcom/bytedance/android/livesdk/message/model/j2;", "getChorusComponentSwitchContent", "()Lcom/bytedance/android/livesdk/message/model/j2;", "setChorusComponentSwitchContent", "(Lcom/bytedance/android/livesdk/message/model/j2;)V", "Lcom/bytedance/android/livesdk/message/model/p2;", "chorusInfoChangedContent", "Lcom/bytedance/android/livesdk/message/model/p2;", "getChorusInfoChangedContent", "()Lcom/bytedance/android/livesdk/message/model/p2;", "setChorusInfoChangedContent", "(Lcom/bytedance/android/livesdk/message/model/p2;)V", "Lcom/bytedance/android/livesdk/message/model/aj;", "chorusInfo", "Lcom/bytedance/android/livesdk/message/model/aj;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdk/message/model/aj;", "setChorusInfo", "(Lcom/bytedance/android/livesdk/message/model/aj;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class kd extends o0 implements vh7.h {

    @SerializedName("chorus_accompaniment_info_content")
    protected h2 chorusAccompanimentInfoContent;

    @SerializedName("chorus_cdn_singers_only_content")
    protected i2 chorusCDNSingersOnlyContent;

    @SerializedName("chorus_component_switch_content")
    protected j2 chorusComponentSwitchContent;

    @SerializedName("chorus_finish_content")
    protected l2 chorusFinishContent;

    @SerializedName("chorus_info")
    protected aj chorusInfo;

    @SerializedName("chorus_info_changed_content")
    protected p2 chorusInfoChangedContent;

    @SerializedName("chorus_leader_setting_content")
    protected r2 chorusLeaderSettingContent;

    @SerializedName("chorus_user_changed_content")
    protected z2 chorusUserChangedContent;

    @SerializedName("chorus_midi_rank_content")
    protected u2 midiRankContent;

    @SerializedName("message_type")
    protected long msgType;

    public static final class a {
    }

    static {
    }

    public kd() {
        this.type = MessageType.REAL_TIME_CHORUS_MESSAGE;
    }

    public final aj E() {
        return this.chorusInfo;
    }

    public final z2 G() {
        return this.chorusUserChangedContent;
    }

    public final u2 H() {
        return this.midiRankContent;
    }

    public final long getMsgType() {
        return this.msgType;
    }

    public kd(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L20;
        if (r102 != 101) goto L7;
        this.chorusInfo = new aj(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            default: goto L8;
        };
    L9:
        this.chorusInfoChangedContent = new p2(r100);
        goto L3
    L10:
        this.chorusComponentSwitchContent = new j2(r100);
        goto L3
    L11:
        this.chorusLeaderSettingContent = new r2(r100);
        goto L3
    L12:
        this.chorusAccompanimentInfoContent = new h2(r100);
        goto L3
    L13:
        this.chorusCDNSingersOnlyContent = new i2(r100);
        goto L3
    L14:
        this.chorusUserChangedContent = new z2(r100);
        goto L3
    L15:
        this.chorusFinishContent = new l2(r100);
        goto L3
    L16:
        this.midiRankContent = new u2(r100);
        goto L3
    L17:
        this.msgType = r100.j();
        goto L3
    L18:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        this.type = MessageType.REAL_TIME_CHORUS_MESSAGE;
    }
}
