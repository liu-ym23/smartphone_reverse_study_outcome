package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/cc;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "", "Lcom/bytedance/android/livesdk/gift/model/f1;", "getImages", "()Ljava/util/List;", "getImages$annotations", "()V", "images", "Lcom/bytedance/android/livesdk/gift/model/g1;", "getText", "getText$annotations", "text", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface cc extends vh7.c<cc>, yh6.c {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ int getAction();

    /* synthetic */ long getAssetId();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    /* synthetic */ long getEndTime();

    /* synthetic */ long getFadeInDuration();

    /* synthetic */ long getFadeOutDuration();

    @FieldName(name = "images")
    List<com.bytedance.android.livesdk.gift.model.f1> getImages();

    /* synthetic */ long getPriority();

    /* synthetic */ String getScene();

    @FieldName(name = "texts")
    List<com.bytedance.android.livesdk.gift.model.g1> getText();

    /* synthetic */ bc getTopEffectExtra();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
