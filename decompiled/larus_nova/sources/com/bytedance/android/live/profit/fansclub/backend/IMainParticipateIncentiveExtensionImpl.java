package com.bytedance.android.live.profit.fansclub.backend;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IMainParticipateIncentiveExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubParticipateIncentive;", "Lcom/bytedance/android/live/profit/fansclub/backend/IMainParticipateIncentive;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getPopupData", "()Ljava/lang/String;", "popupData", "getAwardUnit", "awardUnit", "", "getGoldCoinsCount", "()Ljava/lang/Long;", "goldCoinsCount", "base", "<init>", "(Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubParticipateIncentive;)V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class IMainParticipateIncentiveExtensionImpl extends ModelExtensionBase<IFansclubParticipateIncentive, IMainParticipateIncentive> implements IMainParticipateIncentive, IFansclubParticipateIncentive {
    private final /* synthetic */ IFansclubParticipateIncentive $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<IFansclubParticipateIncentive>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<IFansclubParticipateIncentive>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubParticipateIncentive
    public String getAwardUnit() {
        return this.$$delegate_0.getAwardUnit();
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubParticipateIncentive
    public Long getGoldCoinsCount() {
        return this.$$delegate_0.getGoldCoinsCount();
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IMainParticipateIncentive
    public String getPopupData() {
        return (String) get(3, IMainParticipateIncentive.class);
    }

    public IMainParticipateIncentiveExtensionImpl(IFansclubParticipateIncentive r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
