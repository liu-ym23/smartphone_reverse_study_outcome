package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RealtimeStatusPanelMessage")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/AnchorStatusPanelMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Ljava/io/Serializable;", "", "tabKey", "Ljava/lang/String;", "getTabKey", "()Ljava/lang/String;", "setTabKey", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "", "params", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorStatusPanelMessage extends o0 implements Serializable, vh7.h {

    @SerializedName("content")
    protected String content;

    @SerializedName("params")
    protected Map<String, String> params;

    @SerializedName("tab_key")
    protected String tabKey;

    public AnchorStatusPanelMessage() {
        this.tabKey = "";
        this.content = "";
        this.type = MessageType.ANCHOR_STATUS_PANEL_MESSAGE;
    }

    public final String getContent() {
        return this.content;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final String getTabKey() {
        return this.tabKey;
    }

    public AnchorStatusPanelMessage(am3.g r110) {
        this.params = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        if (r101 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.tabKey = am3.h.c(r110);
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.content = am3.h.c(r110);
        goto L3
    L12:
        if (r101 != 4) goto L13;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L15:
        int r105 = r110.f();
        if (r105 == (-1)) goto L22;
        if (r105 != 1) goto L18;
        r103 = am3.h.c(r110);
        goto L15
    L18:
        if (r105 != 2) goto L19;
        r104 = am3.h.c(r110);
        goto L15
    L19:
        am3.h.e(r110);
        goto L15
    L22:
        r110.d(r102);
        Map<String, String> r106 = this.params;
        if (r103 == null) goto L29;
        if (r104 == null) goto L27;
        r106.put(r103, r104);
        goto L3
    L27:
        throw new IllegalStateException("Value must not be null");
    L29:
        throw new IllegalStateException("Key must not be null");
    L13:
        am3.h.e(r110);
        goto L3
    L33:
        r110.d(r100);
        if (this.tabKey != null) goto L37;
        this.tabKey = "";
    L37:
        if (this.content != null) goto L39;
        this.content = "";
    L39:
        this.type = MessageType.ANCHOR_STATUS_PANEL_MESSAGE;
    }

    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }

    public final void setParams(Map<String, String> r100) {
        this.params = r100;
    }

    public final void setTabKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabKey = r100;
    }
}
