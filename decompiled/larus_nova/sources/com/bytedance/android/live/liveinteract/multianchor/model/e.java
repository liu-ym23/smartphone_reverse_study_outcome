package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.message.model.ab;
import com.bytedance.android.livesdk.message.model.d9;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/e;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/message/model/d9;", "Lyh6/c;", "Lcom/bytedance/android/live/multilink/common/message/MultiLinkImMessage;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e extends vh7.e<d9>, d9, yh6.c {
    @Override // com.bytedance.android.livesdk.message.model.d9, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.message.model.d9, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "paied_or_time_limit_change_content")
    /* synthetic */ ab getPaidOrTimeLimitChangeContent();

    @FieldName(name = "settings")
    /* synthetic */ List<y> getSettings();

    /* synthetic */ void setCommonData(m0 r100);
}
