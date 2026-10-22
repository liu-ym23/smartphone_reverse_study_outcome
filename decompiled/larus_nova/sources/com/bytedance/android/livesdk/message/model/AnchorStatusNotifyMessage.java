package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RealtimeStatusNotifyMessage")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b1\u00102J\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0003R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/AnchorStatusNotifyMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Ljava/io/Serializable;", "", "isSuggestType", "isBarType", "isSuggestLegal", "Lcom/bytedance/android/livesdk/message/model/gj;", "suggest", "Lcom/bytedance/android/livesdk/message/model/gj;", "getSuggest", "()Lcom/bytedance/android/livesdk/message/model/gj;", "setSuggest", "(Lcom/bytedance/android/livesdk/message/model/gj;)V", "Lcom/bytedance/android/livesdk/message/model/j1;", "bizMessage", "Lcom/bytedance/android/livesdk/message/model/j1;", "getBizMessage", "()Lcom/bytedance/android/livesdk/message/model/j1;", "setBizMessage", "(Lcom/bytedance/android/livesdk/message/model/j1;)V", "Lcom/bytedance/android/livesdk/message/model/l0;", "barMessage", "Lcom/bytedance/android/livesdk/message/model/l0;", "getBarMessage", "()Lcom/bytedance/android/livesdk/message/model/l0;", "setBarMessage", "(Lcom/bytedance/android/livesdk/message/model/l0;)V", "", "showType", "I", "getShowType", "()I", "setShowType", "(I)V", "Lcom/bytedance/android/livesdk/message/model/m0;", "barStyle", "Lcom/bytedance/android/livesdk/message/model/m0;", "getBarStyle", "()Lcom/bytedance/android/livesdk/message/model/m0;", "setBarStyle", "(Lcom/bytedance/android/livesdk/message/model/m0;)V", "", "schemaUrl", "Ljava/lang/String;", "getSchemaUrl", "()Ljava/lang/String;", "setSchemaUrl", "(Ljava/lang/String;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorStatusNotifyMessage extends o0 implements Serializable, vh7.h {

    @SerializedName("bar_message")
    protected l0 barMessage;

    @SerializedName("bar_style")
    protected m0 barStyle;

    @SerializedName("biz_message")
    protected j1 bizMessage;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    protected String schemaUrl;

    @SerializedName("show_type")
    protected int showType;

    @SerializedName("suggest")
    protected gj suggest;

    public final boolean isBarType() {
        if (this.showType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSuggestLegal() {
        gj r100 = this.suggest;
        if (r100 == null) goto L19;
        String r101 = r100.text;
        if (r101 == null) goto L19;
        if (com.bytedance.android.livesdk.utils.r2.a(r101) != true) goto L19;
        gj r102 = this.suggest;
        Integer r103 = null;
        if (r102 == null) goto L11;
        Integer r104 = Integer.valueOf(r102.duration);
    L12:
        if (r104 == null) goto L19;
        gj r105 = this.suggest;
        if (r105 == null) goto L16;
        r103 = Integer.valueOf(r105.duration);
    L16:
        Intrinsics.checkNotNull(r103);
        if (r103.intValue() <= 0) goto L19;
        return true;
    L11:
        r104 = null;
    L19:
        return false;
    }

    public final boolean isSuggestType() {
        if (this.showType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public AnchorStatusNotifyMessage() {
        this.type = MessageType.ANCHOR_STATUS_SUGGEST_MESSAGE;
    }

    public final l0 getBarMessage() {
        return this.barMessage;
    }

    public final m0 getBarStyle() {
        return this.barStyle;
    }

    public final j1 getBizMessage() {
        return this.bizMessage;
    }

    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    public final int getShowType() {
        return this.showType;
    }

    public final gj getSuggest() {
        return this.suggest;
    }

    public AnchorStatusNotifyMessage(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L6;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.schemaUrl = am3.h.c(r100);
        goto L3
    L8:
        this.barStyle = new m0(r100);
        goto L3
    L9:
        this.showType = r100.i();
        goto L3
    L10:
        this.barMessage = new l0(r100);
        goto L3
    L11:
        this.bizMessage = new j1(r100);
        goto L3
    L12:
        this.suggest = new gj(r100);
        goto L3
    L13:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        this.type = MessageType.ANCHOR_STATUS_SUGGEST_MESSAGE;
    }

    public final void setBarMessage(l0 r100) {
        this.barMessage = r100;
    }

    public final void setBarStyle(m0 r100) {
        this.barStyle = r100;
    }

    public final void setBizMessage(j1 r100) {
        this.bizMessage = r100;
    }

    public final void setSchemaUrl(String r100) {
        this.schemaUrl = r100;
    }

    public final void setShowType(int r100) {
        this.showType = r100;
    }

    public final void setSuggest(gj r100) {
        this.suggest = r100;
    }
}
