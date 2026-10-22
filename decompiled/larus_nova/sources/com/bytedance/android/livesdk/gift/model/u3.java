package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0013\u001a\u00060\u000ej\u0002`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0015\u0010\u0016R:\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\u001a8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\n\u0018\u00010\u001fj\u0004\u0018\u0001` 8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0007\u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/u3;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getPostEffectImg", "()Lpy/k;", "getPostEffectImg$annotations", "()V", "postEffectImg", "", "getPostSchema", "()Ljava/lang/String;", "getPostSchema$annotations", "postSchema", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getPostDuration", "()J", "getPostDuration$annotations", "postDuration", "", "getPostEffectSource", "()I", "getPostEffectSource$annotations", "postEffectSource", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getEventTrackingMap", "()Ljava/util/Map;", "getEventTrackingMap$annotations", "eventTrackingMap", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getPostEffectSubtitle", "()Lcom/bytedance/android/live/base/model/message/a5;", "getPostEffectSubtitle$annotations", "postEffectSubtitle", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u3 extends vh7.c<u3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "event_tracking")
    Map<String, String> getEventTrackingMap();

    @FieldName(name = "post_duration")
    long getPostDuration();

    @FieldName(name = "post_effect_img")
    py.k getPostEffectImg();

    @FieldName(name = "post_effect_source")
    int getPostEffectSource();

    @FieldName(name = BdpAppEventConstant.PARAMS_SUB_TITLE)
    a5 getPostEffectSubtitle();

    @FieldName(name = "post_schema")
    String getPostSchema();
}
