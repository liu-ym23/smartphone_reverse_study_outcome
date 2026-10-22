package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.r;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightCreateRoomBattleResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/r;", "Lcom/bytedance/android/live/liveinteract/multiscene/a;", "teamFightInfo", "Lcom/bytedance/android/live/liveinteract/multiscene/a;", "getTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/multiscene/a;", "setTeamFightInfo", "(Lcom/bytedance/android/live/liveinteract/multiscene/a;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRoomFightCreateRoomBattleResult extends FlexModelBase<r> implements r, h {

    @SerializedName("teamfight_info")
    protected com.bytedance.android.live.liveinteract.multiscene.a teamFightInfo;

    public LinkRoomFightCreateRoomBattleResult() {
        super(r.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.liveinteract.multiscene.a, java.lang.Object] */
    public LinkRoomFightCreateRoomBattleResult(g r100) {
        super(r.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.teamFightInfo = f.a(r100, com.bytedance.android.live.liveinteract.multiscene.a.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.r
    public com.bytedance.android.live.liveinteract.multiscene.a getTeamFightInfo() {
        return this.teamFightInfo;
    }

    public void setTeamFightInfo(com.bytedance.android.live.liveinteract.multiscene.a r100) {
        this.teamFightInfo = r100;
    }
}
