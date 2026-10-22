package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.AnchorLinkmicEntranceInfo.LeadInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILeadInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/q4;", "Lpy/k;", "leadImage", "Lpy/k;", "getLeadImage", "()Lpy/k;", "setLeadImage", "(Lpy/k;)V", "", "bubbleText$delegate", "Ljava/lang/Object;", "getBubbleText", "()Ljava/lang/String;", "bubbleText", "", "bubblePanel$delegate", "getBubblePanel", "()I", "bubblePanel", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILeadInfoFlexImpl extends FlexModelBase<q4> implements q4, vh7.h {

    @SerializedName("bubble_panel")
    protected int _$$bubblePanel;

    @SerializedName("bubble_text")
    protected String _$$bubbleText;

    @SerializedName("lead_image")
    protected py.k leadImage;

    public ILeadInfoFlexImpl() {
        super(q4.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.q4
    public final int getBubblePanel() {
        return this._$$bubblePanel;
    }

    @Override // com.bytedance.android.livesdk.link.model.q4
    public final String getBubbleText() {
        return this._$$bubbleText;
    }

    @Override // com.bytedance.android.livesdk.link.model.q4
    public py.k getLeadImage() {
        return this.leadImage;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public ILeadInfoFlexImpl(am3.g r100) {
        super(q4.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.leadImage = vh7.f.a(r100, py.k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$bubbleText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$bubblePanel = r100.i();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setLeadImage(py.k r100) {
        this.leadImage = r100;
    }
}
