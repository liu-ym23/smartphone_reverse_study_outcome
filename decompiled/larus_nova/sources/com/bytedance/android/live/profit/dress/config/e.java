package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R*\u0010\u0012\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/e;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getPerfectIcon", "()Lpy/k;", "setPerfectIcon", "(Lpy/k;)V", "getPerfectIcon$annotations", "()V", "perfectIcon", "getGoodIcon", "setGoodIcon", "getGoodIcon$annotations", "goodIcon", "getNiceIcon", "setNiceIcon", "getNiceIcon$annotations", "niceIcon", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e extends vh7.c<e> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "good_icon")
    py.k getGoodIcon();

    @FieldName(name = "nice_icon")
    py.k getNiceIcon();

    @FieldName(name = "perfect_icon")
    py.k getPerfectIcon();

    @FieldName(name = "good_icon#setter")
    void setGoodIcon(py.k r100);

    @FieldName(name = "nice_icon#setter")
    void setNiceIcon(py.k r100);

    @FieldName(name = "perfect_icon#setter")
    void setPerfectIcon(py.k r100);
}
