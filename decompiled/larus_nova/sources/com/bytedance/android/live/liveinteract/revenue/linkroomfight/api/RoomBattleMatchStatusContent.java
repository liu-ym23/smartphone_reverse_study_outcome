package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.j0;
import com.bytedance.android.livesdk.multilink.base.model.l0;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchStatusContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/j0;", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleRandomMatchNoExTimeLeftContent;", "noExpectedTimeLeftContent", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleRandomMatchNoExTimeLeftContent;", "getNoExpectedTimeLeftContent", "()Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleRandomMatchNoExTimeLeftContent;", "setNoExpectedTimeLeftContent", "(Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleRandomMatchNoExTimeLeftContent;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomBattleMatchStatusContent extends FlexModelBase<j0> implements j0, h {

    @SerializedName("no_expected_time_left_content")
    protected RoomBattleRandomMatchNoExTimeLeftContent noExpectedTimeLeftContent;

    public RoomBattleMatchStatusContent() {
        super(j0.class);
    }

    public RoomBattleMatchStatusContent(g r100) {
        super(j0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 2) goto L7;
        this.noExpectedTimeLeftContent = new RoomBattleRandomMatchNoExTimeLeftContent(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.j0
    public /* bridge */ /* synthetic */ l0 getNoExpectedTimeLeftContent() {
        return getNoExpectedTimeLeftContent();
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.j0
    public RoomBattleRandomMatchNoExTimeLeftContent getNoExpectedTimeLeftContent() {
        return this.noExpectedTimeLeftContent;
    }

    public void setNoExpectedTimeLeftContent(RoomBattleRandomMatchNoExTimeLeftContent r100) {
        this.noExpectedTimeLeftContent = r100;
    }
}
