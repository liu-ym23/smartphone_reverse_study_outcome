package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.FansGroupGuideMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/FansGroupGuideMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "content", "getContent", "setContent", "", "guideType", "I", "getGuideType", "()I", "setGuideType", "(I)V", "duration", "getDuration", "setDuration", "Lcom/bytedance/android/livesdkapi/message/Text;", "richText", "Lcom/bytedance/android/livesdkapi/message/Text;", "getRichText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setRichText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "schemeUrl", "getSchemeUrl", "setSchemeUrl", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansGroupGuideMessage extends o0 implements vh7.h {
    public static final a Companion = null;
    private static final Text EMPTY_TEXT = null;
    public static final int TYPE_ANCHOR_CREATION = 4;
    public static final int TYPE_ANCHOR_OPEN_APPLICATION = 5;
    public static final int TYPE_GUIDE_FANS_INTO_GROUP = 1;
    public static final int TYPE_SHARE_INTERESTING_CONTENT = 3;
    public static final int TYPE_SHARE_SCREEN_CONTENT = 2;

    @SerializedName("content")
    protected String content;

    @SerializedName("auto_record_duration_ms")
    protected int duration;

    @SerializedName("type")
    protected int guideType;

    @SerializedName("rich_text")
    protected Text richText;

    @SerializedName("scheme_url")
    protected String schemeUrl;

    @SerializedName("title")
    protected String title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        EMPTY_TEXT = new Text();
    }

    public FansGroupGuideMessage() {
        this.richText = EMPTY_TEXT;
        this.schemeUrl = "";
        this.type = MessageType.FANS_GROUP_GUIDE_MESSAGE;
    }

    public static final /* synthetic */ Text access$getEMPTY_TEXT$cp() {
        return EMPTY_TEXT;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getGuideType() {
        return this.guideType;
    }

    public final Text getRichText() {
        return this.richText;
    }

    public final String getSchemeUrl() {
        return this.schemeUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public FansGroupGuideMessage(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.schemeUrl = am3.h.c(r100);
        goto L3
    L8:
        this.richText = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L9:
        this.duration = (int) r100.j();
        goto L3
    L10:
        this.content = am3.h.c(r100);
        goto L3
    L11:
        this.title = am3.h.c(r100);
        goto L3
    L12:
        this.guideType = r100.i();
        goto L3
    L13:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.richText != null) goto L18;
        this.richText = EMPTY_TEXT;
    L18:
        if (this.schemeUrl != null) goto L20;
        this.schemeUrl = "";
    L20:
        this.type = MessageType.FANS_GROUP_GUIDE_MESSAGE;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setDuration(int r100) {
        this.duration = r100;
    }

    public final void setGuideType(int r100) {
        this.guideType = r100;
    }

    public final void setRichText(Text r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.richText = r100;
    }

    public final void setSchemeUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.schemeUrl = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
