package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.o0;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/d;", "Lvh7/e;", "Lcom/bytedance/android/live/base/model/message/o0;", "Lyh6/c;", "Lcom/bytedance/android/live/multilink/common/message/MultiLinkImMessage;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends vh7.e<o0>, o0, yh6.c {
    @Override // com.bytedance.android.live.base.model.message.o0, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.live.base.model.message.o0, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "action")
    /* synthetic */ long getAction();

    /* synthetic */ m0 getCommonData();

    @FieldName(name = "extra")
    /* synthetic */ o0.b getExtraInfo();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "public_area_common")
    /* synthetic */ IPublicAreaCommon getPublicAreaCommon();

    @FieldName(name = "tips")
    /* synthetic */ String getTips();

    @FieldName(name = "action#setter")
    /* synthetic */ void setAction(long r100);

    /* synthetic */ void setCommonData(m0 r100);
}
