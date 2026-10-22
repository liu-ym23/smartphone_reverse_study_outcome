package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ob;", "Lvh7/e;", "Lcom/bytedance/android/live/base/model/message/l5;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ob extends vh7.e<com.bytedance.android.live.base.model.message.l5>, com.bytedance.android.live.base.model.message.l5, yh6.c {
    @Override // com.bytedance.android.live.base.model.message.l5, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.live.base.model.message.l5, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "component_type")
    /* synthetic */ int getComponentType();

    @FieldName(name = "event_type")
    /* synthetic */ int getEventType();

    @FieldName(name = "extra")
    /* synthetic */ String getExtraData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "group_id")
    /* synthetic */ int getGroupId();

    /* synthetic */ List<com.bytedance.android.live.base.model.message.k5> getHighList();

    @FieldName(name = "icon")
    /* synthetic */ py.k getIcon();

    /* synthetic */ List<com.bytedance.android.live.base.model.message.k5> getLowList();

    /* synthetic */ String getMsgLogId();

    @FieldName(name = "op_type")
    /* synthetic */ int getOpType();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    /* synthetic */ String getSchema();

    @FieldName(name = "show_type")
    /* synthetic */ long getShowType();

    @FieldName(name = "text")
    /* synthetic */ String getText();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
