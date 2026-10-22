package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.m0;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\"\u0010\u0014\u001a\u00020\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleRandomMatchReservationContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/m0;", "", "subtitle", "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "setSubtitle", "(Ljava/lang/String;)V", "openingTimeTitle", "getOpeningTimeTitle", "setOpeningTimeTitle", "reserveUserNum", "getReserveUserNum", "setReserveUserNum", "realReserveUserNum", "getRealReserveUserNum", "setRealReserveUserNum", "", "isReserve", "Z", "()Z", "setReserve", "(Z)V", "leftEffectiveText", "getLeftEffectiveText", "setLeftEffectiveText", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomBattleRandomMatchReservationContent extends FlexModelBase<m0> implements m0, h {

    @SerializedName("is_reserve")
    protected boolean isReserve;

    @SerializedName("left_effective_text")
    protected String leftEffectiveText;

    @SerializedName("opening_time_title")
    protected String openingTimeTitle;

    @SerializedName("real_reserve_num")
    protected String realReserveUserNum;

    @SerializedName("show_reserve_num")
    protected String reserveUserNum;

    @SerializedName("subtitle")
    protected String subtitle;

    public RoomBattleRandomMatchReservationContent() {
        super(m0.class);
    }

    public RoomBattleRandomMatchReservationContent(g r100) {
        super(m0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.leftEffectiveText = am3.h.c(r100);
        goto L3
    L9:
        this.isReserve = am3.h.a(r100);
        goto L3
    L10:
        this.realReserveUserNum = am3.h.c(r100);
        goto L3
    L11:
        this.reserveUserNum = am3.h.c(r100);
        goto L3
    L12:
        this.openingTimeTitle = am3.h.c(r100);
        goto L3
    L13:
        this.subtitle = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.m0
    public String getLeftEffectiveText() {
        return this.leftEffectiveText;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.m0
    public String getOpeningTimeTitle() {
        return this.openingTimeTitle;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.m0
    public String getRealReserveUserNum() {
        return this.realReserveUserNum;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.m0
    public String getReserveUserNum() {
        return this.reserveUserNum;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.m0
    public String getSubtitle() {
        return this.subtitle;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.m0
    public boolean isReserve() {
        return this.isReserve;
    }

    public void setLeftEffectiveText(String r100) {
        this.leftEffectiveText = r100;
    }

    public void setOpeningTimeTitle(String r100) {
        this.openingTimeTitle = r100;
    }

    public void setRealReserveUserNum(String r100) {
        this.realReserveUserNum = r100;
    }

    public void setReserve(boolean r100) {
        this.isReserve = r100;
    }

    public void setReserveUserNum(String r100) {
        this.reserveUserNum = r100;
    }

    public void setSubtitle(String r100) {
        this.subtitle = r100;
    }
}
