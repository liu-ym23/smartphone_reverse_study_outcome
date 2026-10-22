package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003R\u001e\u0010\n\u001a\u00060\u0004j\u0002`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0010j\b\u0012\u0004\u0012\u00020\u000b`\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0018\u001a\u00060\u0004j\u0002`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0016\u0010\u0007R\u001a\u0010\u001b\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\t\u001a\u0004\b\u0019\u0010\rR*\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0010j\b\u0012\u0004\u0012\u00020\u000b`\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\t\u001a\u0004\b\u001c\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ra;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getBoxId", "()J", "getBoxId$annotations", "()V", "boxId", "", "getBoxIdStr", "()Ljava/lang/String;", "getBoxIdStr$annotations", "boxIdStr", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getRewardedDetail", "()Ljava/util/List;", "getRewardedDetail$annotations", "rewardedDetail", "getRewardMessageType", "getRewardMessageType$annotations", "rewardMessageType", "getRelatedItemId", "getRelatedItemId$annotations", "relatedItemId", "getRewardUserId", "getRewardUserId$annotations", "rewardUserId", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ra extends vh7.c<ra>, yh6.c {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "box_id")
    long getBoxId();

    @FieldName(name = "box_id_str")
    String getBoxIdStr();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "related_item_id")
    String getRelatedItemId();

    @FieldName(name = "reward_message_type")
    long getRewardMessageType();

    @FieldName(name = "rewarded_user_id")
    List<String> getRewardUserId();

    @FieldName(name = "rewarded_detail")
    List<String> getRewardedDetail();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
