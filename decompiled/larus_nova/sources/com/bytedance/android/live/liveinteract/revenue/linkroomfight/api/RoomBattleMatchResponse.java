package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.i0;
import com.bytedance.android.livesdk.multilink.base.model.j0;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/i0;", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchStatusContent;", "statusContent", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchStatusContent;", "getStatusContent", "()Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchStatusContent;", "setStatusContent", "(Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchStatusContent;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomBattleMatchResponse extends FlexModelBase<i0> implements i0, h {

    @SerializedName("status")
    protected int status;

    @SerializedName("status_content")
    protected RoomBattleMatchStatusContent statusContent;

    public RoomBattleMatchResponse() {
        super(i0.class);
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.i0
    public /* bridge */ /* synthetic */ j0 getStatusContent() {
        return getStatusContent();
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.i0
    public int getStatus() {
        return this.status;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.i0
    public RoomBattleMatchStatusContent getStatusContent() {
        return this.statusContent;
    }

    public RoomBattleMatchResponse(g r100) {
        super(i0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.status = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.statusContent = new RoomBattleMatchStatusContent(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setStatus(int r100) {
        this.status = r100;
    }

    public void setStatusContent(RoomBattleMatchStatusContent r100) {
        this.statusContent = r100;
    }
}
