package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/MCUContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/e0;", "", "toString", "currentStreamId", "Ljava/lang/String;", "getCurrentStreamId", "()Ljava/lang/String;", "setCurrentStreamId", "(Ljava/lang/String;)V", "rivalsStreamId", "getRivalsStreamId", "setRivalsStreamId", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MCUContent extends FlexModelBase<e0> implements e0, vh7.h {

    @SerializedName("current_stream_id")
    protected String currentStreamId;

    @SerializedName("rivals_stream_id")
    protected String rivalsStreamId;

    public MCUContent() {
        super(e0.class);
        this.currentStreamId = "";
        this.rivalsStreamId = "";
    }

    public String toString() {
        return "MCUContent(currentStreamId=" + getCurrentStreamId() + ", rivalsStreamId=" + getRivalsStreamId() + ')';
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.e0
    public String getCurrentStreamId() {
        return this.currentStreamId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.e0
    public String getRivalsStreamId() {
        return this.rivalsStreamId;
    }

    public MCUContent(am3.g r100) {
        super(e0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.currentStreamId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.rivalsStreamId = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this.currentStreamId != null) goto L16;
        this.currentStreamId = "";
    L16:
        if (this.rivalsStreamId != null) goto L28;
        this.rivalsStreamId = "";
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.e0
    public void setCurrentStreamId(String r100) {
        this.currentStreamId = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.e0
    public void setRivalsStreamId(String r100) {
        this.rivalsStreamId = r100;
    }
}
