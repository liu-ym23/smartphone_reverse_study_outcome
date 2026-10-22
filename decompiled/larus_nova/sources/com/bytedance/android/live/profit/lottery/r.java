package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/r;", "Lvh7/e;", "Lcom/bytedance/android/live/profit/lottery/h;", "", "getRemarks", "()Ljava/lang/String;", "getRemarks$annotations", "()V", "remarks", "getBizInfo", "getBizInfo$annotations", "bizInfo", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface r extends vh7.e<h>, h {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.live.profit.lottery.h, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.live.profit.lottery.h, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "biz_info")
    String getBizInfo();

    @FieldName(name = "condition_id")
    /* synthetic */ long getConditionId();

    @FieldName(name = "content")
    /* synthetic */ String getContent();

    @FieldName(name = "description")
    /* synthetic */ String getDescription();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "gift_count")
    /* synthetic */ long getGiftCount();

    @FieldName(name = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    /* synthetic */ long getGiftId();

    @FieldName(name = "gift_name")
    /* synthetic */ String getGiftName();

    @FieldName(name = "min_fans_level")
    /* synthetic */ long getMinFansLevel();

    @FieldName(name = "need_diamond_count")
    /* synthetic */ long getNeedDiamondCount();

    @FieldName(name = "remarks")
    String getRemarks();

    @FieldName(name = "status")
    /* synthetic */ int getStatus();

    @FieldName(name = "type")
    /* synthetic */ int getType();
}
