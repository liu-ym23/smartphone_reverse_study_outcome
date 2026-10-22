package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.NoticeMessage")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b0\u00101R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0005R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0005R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0005R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0005R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0005R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R$\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\fR\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0005R\u0018\u0010%\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0017R\u0018\u0010&\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u0010\u0017R\u0018\u0010'\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0005R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010\u0005R\u0016\u0010*\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010\u0005R\u0016\u0010.\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u0010\u0005¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/kj;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/message/w3;", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "", "noticeType", "I", "s", "()I", "G", "(I)V", "version", "popupWindowUrl", "popupWindowExtra", "style", "Lcom/bytedance/android/livesdkapi/message/Text;", "title", "Lcom/bytedance/android/livesdkapi/message/Text;", "iconUrl", "violationReason", "illegalText", "bottomTip", "tipUrl", "noticeTitle", "noticeContent", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdkapi/message/Text;", "setNoticeContent", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "noticeTime", "limitNoticeKey", "buttonConfirm", "buttonCancel", "eventName", "decorationAuditedContent", "", "punishTime", "J", "countDownTime", "educationUrl", "educationTaskId", "logExtra", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class kj extends o0 implements com.bytedance.android.live.base.model.message.w3, vh7.h {

    @SerializedName("tips_title")
    public Text bottomTip;

    @SerializedName("button_cancel")
    public Text buttonCancel;

    @SerializedName("button_confirm")
    public Text buttonConfirm;

    @SerializedName("content")
    protected String content;

    @SerializedName("countdown_time")
    public long countDownTime;

    @SerializedName("decoration_audited_content")
    public String decorationAuditedContent;

    @SerializedName("education_task_record_id")
    public long educationTaskId;

    @SerializedName("education_url")
    public String educationUrl;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    public String eventName;

    @SerializedName("top_icon_url")
    public String iconUrl;

    @SerializedName("display_text")
    public Text illegalText;

    @SerializedName("limit_notice_key")
    public String limitNoticeKey;

    @SerializedName("log_extra")
    public String logExtra;

    @SerializedName("notice_content")
    protected Text noticeContent;

    @SerializedName("notice_time")
    public int noticeTime;

    @SerializedName("notice_title")
    public Text noticeTitle;

    @SerializedName("notice_type")
    protected int noticeType;

    @SerializedName("popup_window_extra")
    public String popupWindowExtra;

    @SerializedName("popup_window_url")
    public String popupWindowUrl;

    @SerializedName("punish_time")
    public long punishTime;

    @SerializedName("style")
    public String style;

    @SerializedName("tips_url")
    public String tipUrl;

    @SerializedName("title")
    public Text title;

    @SerializedName("version")
    public int version;

    @SerializedName("violation_reason")
    public Text violationReason;

    public static final class a {
    }

    static {
    }

    public final void G() {
        this.noticeType = 2;
    }

    public kj() {
        this.type = MessageType.REMIND;
    }

    @Override // com.bytedance.android.livesdk.message.model.o0, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean supportDisplayText() {
        if (getBaseMessage() == null) goto L7;
        CommonMessageData r100 = getBaseMessage();
        Intrinsics.checkNotNull(r100);
        if (r100.supportDisplayText() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final Text E() {
        return this.noticeContent;
    }

    @Override // com.bytedance.android.live.base.model.message.w3
    public final String getContent() {
        return this.content;
    }

    @Override // com.bytedance.android.live.base.model.message.w3
    public final Text o() {
        return this.noticeContent;
    }

    @Override // com.bytedance.android.live.base.model.message.w3
    public final int s() {
        return this.noticeType;
    }

    public kj(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L33;
        switch(r102) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L18;
            case 16: goto L17;
            case 17: goto L16;
            case 18: goto L15;
            case 19: goto L14;
            case 20: goto L13;
            case 21: goto L12;
            case 22: goto L11;
            case 23: goto L10;
            case 24: goto L9;
            case 25: goto L8;
            case 26: goto L7;
            default: goto L6;
        };
    L7:
        this.popupWindowExtra = am3.h.c(r100);
        goto L3
    L8:
        this.popupWindowUrl = am3.h.c(r100);
        goto L3
    L9:
        this.version = (int) r100.j();
        goto L3
    L10:
        this.logExtra = am3.h.c(r100);
        goto L3
    L11:
        this.educationTaskId = r100.j();
        goto L3
    L12:
        this.educationUrl = am3.h.c(r100);
        goto L3
    L13:
        this.countDownTime = r100.j();
        goto L3
    L14:
        this.punishTime = r100.j();
        goto L3
    L15:
        this.decorationAuditedContent = am3.h.c(r100);
        goto L3
    L16:
        this.iconUrl = am3.h.c(r100);
        goto L3
    L17:
        this.eventName = am3.h.c(r100);
        goto L3
    L18:
        this.buttonCancel = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L19:
        this.buttonConfirm = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L20:
        this.limitNoticeKey = am3.h.c(r100);
        goto L3
    L21:
        this.noticeTime = (int) r100.j();
        goto L3
    L22:
        this.noticeContent = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L23:
        this.noticeTitle = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L24:
        this.tipUrl = am3.h.c(r100);
        goto L3
    L25:
        this.bottomTip = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L26:
        this.illegalText = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L27:
        this.violationReason = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L28:
        this.title = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L29:
        this.style = am3.h.c(r100);
        goto L3
    L30:
        this.noticeType = (int) r100.j();
        goto L3
    L31:
        this.content = am3.h.c(r100);
        goto L3
    L32:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L33:
        r100.d(r101);
        this.type = MessageType.REMIND;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }
}
