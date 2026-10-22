package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PicAuditResultMessage")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/PicAuditResultMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Ljava/io/Serializable;", "", "auditId", "Ljava/lang/String;", "getAuditId", "()Ljava/lang/String;", "setAuditId", "(Ljava/lang/String;)V", "uri", "getUri", "setUri", "url", "getUrl", "setUrl", "", "auditStatus", "Ljava/lang/Integer;", "getAuditStatus", "()Ljava/lang/Integer;", "setAuditStatus", "(Ljava/lang/Integer;)V", "toast", "getToast", "setToast", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PicAuditResultMessage extends o0 implements Serializable, h {

    @SerializedName("audit_id")
    protected String auditId;

    @SerializedName("audit_status")
    protected Integer auditStatus;

    @SerializedName("toast")
    protected String toast;

    @SerializedName("uri")
    protected String uri;

    @SerializedName("url")
    protected String url;

    public PicAuditResultMessage() {
        this.type = MessageType.LIVE_PIC_AUDIT_RESULT;
    }

    public final String getAuditId() {
        return this.auditId;
    }

    public final Integer getAuditStatus() {
        return this.auditStatus;
    }

    public final String getToast() {
        return this.toast;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getUrl() {
        return this.url;
    }

    public PicAuditResultMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.toast = am3.h.c(r100);
        goto L3
    L8:
        this.auditStatus = Integer.valueOf(r100.i());
        goto L3
    L9:
        this.url = am3.h.c(r100);
        goto L3
    L10:
        this.uri = am3.h.c(r100);
        goto L3
    L11:
        this.auditId = am3.h.c(r100);
        goto L3
    L12:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        this.type = MessageType.LIVE_PIC_AUDIT_RESULT;
    }

    public final void setAuditId(String r100) {
        this.auditId = r100;
    }

    public final void setAuditStatus(Integer r100) {
        this.auditStatus = r100;
    }

    public final void setToast(String r100) {
        this.toast = r100;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
