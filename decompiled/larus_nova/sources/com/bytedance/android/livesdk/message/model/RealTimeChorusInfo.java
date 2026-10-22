package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/RealTimeChorusInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/kb;", "", "chorusID", "J", "getChorusID", "()J", "setChorusID", "(J)V", "", "chorusIDStr", "Ljava/lang/String;", "getChorusIDStr", "()Ljava/lang/String;", "setChorusIDStr", "(Ljava/lang/String;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusInfo extends FlexModelBase<kb> implements kb, vh7.h {

    @SerializedName("chorus_id")
    protected long chorusID;

    @SerializedName("chorus_id_str")
    protected String chorusIDStr;

    public RealTimeChorusInfo() {
        super(kb.class);
        this.chorusIDStr = "0";
    }

    @Override // com.bytedance.android.livesdk.message.model.kb
    public long getChorusID() {
        return this.chorusID;
    }

    @Override // com.bytedance.android.livesdk.message.model.kb
    public String getChorusIDStr() {
        return this.chorusIDStr;
    }

    public RealTimeChorusInfo(am3.g r100) {
        super(kb.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.chorusID = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.chorusIDStr = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this.chorusIDStr != null) goto L25;
        this.chorusIDStr = "0";
        return;
    }

    public void setChorusID(long r100) {
        this.chorusID = r100;
    }

    public void setChorusIDStr(String r100) {
        this.chorusIDStr = r100;
    }
}
