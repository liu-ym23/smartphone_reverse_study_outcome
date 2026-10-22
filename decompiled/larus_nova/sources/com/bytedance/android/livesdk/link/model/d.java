package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/d;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.c>, com.bytedance.android.livesdk.link.model.bridge.c, yh6.c {
    @Override // com.bytedance.android.livesdk.link.model.bridge.c, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.c, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "ai_user_id")
    /* synthetic */ String getAIUserId();

    @FieldName(name = "channel_id")
    /* synthetic */ String getChannelId();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "silence_status")
    /* synthetic */ Integer getSilenceStatus();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
