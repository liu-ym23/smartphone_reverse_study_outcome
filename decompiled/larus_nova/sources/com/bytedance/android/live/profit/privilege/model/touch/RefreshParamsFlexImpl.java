package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.data.RefreshParams")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/RefreshParamsFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/m;", "", "<set-?>", "refreshMechanism$delegate", "Ljava/lang/Object;", "getRefreshMechanism", "()I", "setRefreshMechanism", "(I)V", "refreshMechanism", "", "pollingInterval$delegate", "getPollingInterval", "()Ljava/lang/Long;", "setPollingInterval", "(Ljava/lang/Long;)V", "pollingInterval", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RefreshParamsFlexImpl extends FlexModelBase<m> implements m, vh7.h {

    @SerializedName("polling_interval")
    protected Long _$$pollingInterval;

    @SerializedName("refresh_mechanism")
    protected int _$$refreshMechanism;

    public RefreshParamsFlexImpl() {
        super(m.class);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.m
    public final Long getPollingInterval() {
        return this._$$pollingInterval;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.m
    public final int getRefreshMechanism() {
        return this._$$refreshMechanism;
    }

    public RefreshParamsFlexImpl(am3.g r100) {
        super(m.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$refreshMechanism = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$pollingInterval = Long.valueOf(r100.j());
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.m
    public final void setPollingInterval(Long r100) {
        this._$$pollingInterval = r100;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.m
    public final void setRefreshMechanism(int r100) {
        this._$$refreshMechanism = r100;
    }
}
