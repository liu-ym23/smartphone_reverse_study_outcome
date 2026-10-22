package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/c;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/b;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.b>, com.bytedance.android.livesdk.link.model.bridge.b, yh6.c {
    @Override // com.bytedance.android.livesdk.link.model.bridge.b, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.b, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "ai_user")
    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.d getAIUser();

    @FieldName(name = "ai_user_type")
    /* synthetic */ Integer getAIUserType();

    @FieldName(name = "channel_id")
    /* synthetic */ String getChannelId();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "leave_reason")
    /* synthetic */ String getLeaveReason();

    @FieldName(name = "toast")
    /* synthetic */ String getToast();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
