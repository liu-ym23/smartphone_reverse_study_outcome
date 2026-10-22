package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\"\u0010\u0010\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u000eR\"\u0010\u0016\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/v;", "Lvh7/c;", "", "getTitle", "()Ljava/lang/String;", "getTitle$annotations", "()V", "title", "getSubtitle", "getSubtitle$annotations", "subtitle", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getEffect", "()Lpy/k;", "getEffect$annotations", "effect", "getFortuneLabel", "getFortuneLabel$annotations", "fortuneLabel", "getExclusiveGiftIcon", "getExclusiveGiftIcon$annotations", "exclusiveGiftIcon", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v extends vh7.c<v> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "effect")
    py.k getEffect();

    @FieldName(name = "exclusive_gift_icon")
    py.k getExclusiveGiftIcon();

    @FieldName(name = "fortune_label")
    py.k getFortuneLabel();

    @FieldName(name = "subtitle")
    String getSubtitle();

    @FieldName(name = "title")
    String getTitle();
}
