package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.FlexActivity.BasicInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u0011\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBasicInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/l0;", "", "title$delegate", "Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "title", "description$delegate", "getDescription", "description", "registerButtonText$delegate", "getRegisterButtonText", "registerButtonText", "ruleUrl$delegate", "getRuleUrl", "ruleUrl", "Lcom/bytedance/android/livesdk/link/model/IBasicInfo_CountDownFlexImpl;", "countdown$delegate", "getCountdown", "()Lcom/bytedance/android/livesdk/link/model/IBasicInfo_CountDownFlexImpl;", "countdown", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBasicInfoFlexImpl extends FlexModelBase<l0> implements l0, vh7.h {

    @SerializedName("countdown")
    protected IBasicInfo_CountDownFlexImpl _$$countdown;

    @SerializedName("description")
    protected String _$$description;

    @SerializedName("register_button_text")
    protected String _$$registerButtonText;

    @SerializedName("rule_url")
    protected String _$$ruleUrl;

    @SerializedName("title")
    protected String _$$title;

    public IBasicInfoFlexImpl() {
        super(l0.class);
        this._$$title = "";
        this._$$description = "";
        this._$$registerButtonText = "";
        this._$$ruleUrl = "";
    }

    public IBasicInfoFlexImpl(am3.g r100) {
        super(l0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$title = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$description = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$registerButtonText = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$ruleUrl = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._$$countdown = new IBasicInfo_CountDownFlexImpl(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$title != null) goto L25;
        this._$$title = "";
    L25:
        if (this._$$description != null) goto L28;
        this._$$description = "";
    L28:
        if (this._$$registerButtonText != null) goto L31;
        this._$$registerButtonText = "";
    L31:
        if (this._$$ruleUrl != null) goto L52;
        this._$$ruleUrl = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.l0
    public /* bridge */ /* synthetic */ l0.a getCountdown() {
        return getCountdown();
    }

    @Override // com.bytedance.android.livesdk.link.model.l0
    public final String getDescription() {
        return this._$$description;
    }

    @Override // com.bytedance.android.livesdk.link.model.l0
    public final String getRegisterButtonText() {
        return this._$$registerButtonText;
    }

    @Override // com.bytedance.android.livesdk.link.model.l0
    public final String getRuleUrl() {
        return this._$$ruleUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.l0
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.livesdk.link.model.l0
    public final IBasicInfo_CountDownFlexImpl getCountdown() {
        return this._$$countdown;
    }
}
