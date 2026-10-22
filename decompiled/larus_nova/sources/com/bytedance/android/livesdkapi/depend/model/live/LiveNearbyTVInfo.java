package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.TVStation")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveNearbyTVInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveNearbyTVInfo;", "()V", "isIdle", "", "()Z", "setIdle", "(Z)V", "statesDesc", "", "getStatesDesc", "()Ljava/lang/String;", "setStatesDesc", "(Ljava/lang/String;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveNearbyTVInfo extends FlexModelBase<ILiveNearbyTVInfo> implements ILiveNearbyTVInfo, h {

    @SerializedName("is_idle")
    protected boolean isIdle;

    @SerializedName("state_desc")
    protected String statesDesc;

    public LiveNearbyTVInfo() {
        super(ILiveNearbyTVInfo.class);
    }

    public LiveNearbyTVInfo(g r100) {
        super(ILiveNearbyTVInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.isIdle = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.statesDesc = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveNearbyTVInfo
    public String getStatesDesc() {
        return this.statesDesc;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveNearbyTVInfo
    public boolean isIdle() {
        return this.isIdle;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveNearbyTVInfo
    public void setIdle(boolean r100) {
        this.isIdle = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveNearbyTVInfo
    public void setStatesDesc(String r100) {
        this.statesDesc = r100;
    }
}
