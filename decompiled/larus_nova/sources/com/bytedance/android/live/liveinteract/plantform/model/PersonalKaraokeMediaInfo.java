package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/PersonalKaraokeMediaInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/i0;", "", "toString", "liveCoreExtInfo", "Ljava/lang/String;", "getLiveCoreExtInfo", "()Ljava/lang/String;", "setLiveCoreExtInfo", "(Ljava/lang/String;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PersonalKaraokeMediaInfo extends FlexModelBase<i0> implements i0, vh7.h {

    @SerializedName("personal_karaoke_live_core_ext_info")
    protected String liveCoreExtInfo;

    public PersonalKaraokeMediaInfo() {
        super(i0.class);
        this.liveCoreExtInfo = "";
    }

    public String toString() {
        return "liveCoreExtInfo: " + getLiveCoreExtInfo();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.i0
    public String getLiveCoreExtInfo() {
        return this.liveCoreExtInfo;
    }

    public PersonalKaraokeMediaInfo(am3.g r100) {
        super(i0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.liveCoreExtInfo = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
        if (this.liveCoreExtInfo != null) goto L19;
        this.liveCoreExtInfo = "";
        return;
    }

    public void setLiveCoreExtInfo(String r100) {
        this.liveCoreExtInfo = r100;
    }
}
