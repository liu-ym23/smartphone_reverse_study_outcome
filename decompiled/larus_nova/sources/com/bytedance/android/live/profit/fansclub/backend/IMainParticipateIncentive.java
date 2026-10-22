package com.bytedance.android.live.profit.fansclub.backend;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IMainParticipateIncentive;", "Lvh7/e;", "Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubParticipateIncentive;", "", "getPopupData", "()Ljava/lang/String;", "getPopupData$annotations", "()V", "popupData", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@ForMain
public interface IMainParticipateIncentive extends e<IFansclubParticipateIncentive>, IFansclubParticipateIncentive {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubParticipateIncentive, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.live.profit.fansclub.backend.IFansclubParticipateIncentive, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "popup_data")
    String getPopupData();
}
