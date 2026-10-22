package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003R\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/p7;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getBizType", "()I", "getBizType$annotations", "()V", "bizType", "", "Lcom/bytedance/android/livesdk/message/model/cb;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPetEffectInfo", "()Ljava/util/List;", "getPetEffectInfo$annotations", "petEffectInfo", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface p7 extends vh7.c<p7>, yh6.c {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "biz_type")
    int getBizType();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "pet_effect_info")
    List<cb> getPetEffectInfo();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
