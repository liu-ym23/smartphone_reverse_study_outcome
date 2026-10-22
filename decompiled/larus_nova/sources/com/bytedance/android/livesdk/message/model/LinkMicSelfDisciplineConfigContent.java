package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicSelfDisciplineConfigContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkMicSelfDisciplineConfigContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/k2;", "", "toString", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "currentTarget", "Ljava/lang/String;", "getCurrentTarget", "()Ljava/lang/String;", "setCurrentTarget", "(Ljava/lang/String;)V", "targetIconUri", "getTargetIconUri", "setTargetIconUri", "source", "getSource", "setSource", "", "punchDuration", "J", "getPunchDuration", "()J", "setPunchDuration", "(J)V", "toast", "getToast", "setToast", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkMicSelfDisciplineConfigContent extends FlexModelBase<com.bytedance.android.live.base.model.message.k2> implements com.bytedance.android.live.base.model.message.k2, vh7.h {

    @SerializedName("current_target")
    protected String currentTarget;

    @SerializedName("punch_duration")
    protected long punchDuration;

    @SerializedName("text")
    protected String source;

    @SerializedName(EventConstants.ExtraJson.SWITCH_STATUS)
    protected int status;

    @SerializedName("target_icon_uri")
    protected String targetIconUri;

    @SerializedName("toast")
    protected String toast;

    public LinkMicSelfDisciplineConfigContent() {
        super(com.bytedance.android.live.base.model.message.k2.class);
        this.punchDuration = 600;
    }

    public String toString() {
        return "configContent status=" + getStatus() + " currentTarget=" + getCurrentTarget();
    }

    @Override // com.bytedance.android.live.base.model.message.k2
    public String getCurrentTarget() {
        return this.currentTarget;
    }

    @Override // com.bytedance.android.live.base.model.message.k2
    public long getPunchDuration() {
        return this.punchDuration;
    }

    @Override // com.bytedance.android.live.base.model.message.k2
    public String getSource() {
        return this.source;
    }

    @Override // com.bytedance.android.live.base.model.message.k2
    public int getStatus() {
        return this.status;
    }

    @Override // com.bytedance.android.live.base.model.message.k2
    public String getTargetIconUri() {
        return this.targetIconUri;
    }

    @Override // com.bytedance.android.live.base.model.message.k2
    public String getToast() {
        return this.toast;
    }

    public LinkMicSelfDisciplineConfigContent(am3.g r100) {
        super(com.bytedance.android.live.base.model.message.k2.class);
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.toast = am3.h.c(r100);
        goto L3
    L9:
        this.punchDuration = r100.j();
        r101 = r101 | true;
        goto L3
    L10:
        this.source = am3.h.c(r100);
        goto L3
    L11:
        this.targetIconUri = am3.h.c(r100);
        goto L3
    L12:
        this.currentTarget = am3.h.c(r100);
        goto L3
    L13:
        this.status = r100.i();
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L14:
        r100.d(r102);
        setThreadSafe(true);
        if ((true & r101) == true) goto L34;
        this.punchDuration = 600;
        return;
    }

    public void setCurrentTarget(String r100) {
        this.currentTarget = r100;
    }

    public void setPunchDuration(long r100) {
        this.punchDuration = r100;
    }

    public void setSource(String r100) {
        this.source = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }

    public void setTargetIconUri(String r100) {
        this.targetIconUri = r100;
    }

    public void setToast(String r100) {
        this.toast = r100;
    }
}
