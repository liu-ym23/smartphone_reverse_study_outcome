package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.room.AuditTextV2Response.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\bJ\n\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/DecorationTextAuditResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/x0;", "", "getAuditStatus", "auditStatus", "", "setAuditStatus", "", "getAuditNotPassWarnText", "auditNotPassWarnText", "setAuditNotPassWarnText", "getPrompt", "", "isIsCanEdit", "I", "Ljava/lang/String;", "canEdit", "Z", EventConstant.Key.RETAIN_PROMPT, "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DecorationTextAuditResult extends FlexModelBase<x0> implements x0, vh7.h {
    public static final int AUDIT_STATUS_DEFAULT = 35;
    public static final int AUDIT_STATUS_LIVE_DECO_TEXT_PASS_BY_HUMAN = 33;
    public static final int AUDIT_STATUS_LIVE_DECO_TEXT_PASS_BY_MACHINE = 32;
    public static final int AUDIT_STATUS_RATELIMIT = 34;
    public static final a Companion = null;

    @SerializedName("audit_nopass_warn")
    public String auditNotPassWarnText;

    @SerializedName("audit_status")
    public int auditStatus;

    @SerializedName("can_edit")
    public boolean canEdit;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    public String prompt;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DecorationTextAuditResult() {
        super(x0.class);
        this.prompt = "";
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.x0
    public String getAuditNotPassWarnText() {
        return this.auditNotPassWarnText;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.x0
    public int getAuditStatus() {
        return this.auditStatus;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.x0
    public String getPrompt() {
        return this.prompt;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.x0
    public boolean isIsCanEdit() {
        return this.canEdit;
    }

    public DecorationTextAuditResult(am3.g r100) {
        super(x0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.auditStatus = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.auditNotPassWarnText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.canEdit = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.prompt = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
        if (this.prompt != null) goto L37;
        this.prompt = "";
        return;
    }

    public final void setAuditNotPassWarnText(String r100) {
        this.auditNotPassWarnText = r100;
    }

    public final void setAuditStatus(int r100) {
        this.auditStatus = r100;
    }
}
