package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdk.message.model.hc;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/f;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/message/model/hc;", "Lyh6/c;", "Lcom/bytedance/android/live/multilink/common/message/MultiLinkImMessage;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f extends vh7.e<hc>, hc, yh6.c {
    @Override // com.bytedance.android.livesdk.message.model.hc, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.message.model.hc, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "bg_type")
    /* synthetic */ Integer getBgType();

    /* synthetic */ m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "ReviewPass")
    /* synthetic */ Integer getReviewPass();

    @FieldName(name = "show_text")
    /* synthetic */ String getToastText();

    @FieldName(name = "bg_list")
    /* synthetic */ IVoiceLiveTheme getVoiceLiveTheme();

    @FieldName(name = "bg_type#setter")
    /* synthetic */ void setBgType(Integer r100);

    /* synthetic */ void setCommonData(m0 r100);

    @FieldName(name = "ReviewPass#setter")
    /* synthetic */ void setReviewPass(Integer r100);

    @FieldName(name = "show_text#setter")
    /* synthetic */ void setToastText(String r100);

    @FieldName(name = "bg_list#setter")
    /* synthetic */ void setVoiceLiveTheme(IVoiceLiveTheme r100);
}
