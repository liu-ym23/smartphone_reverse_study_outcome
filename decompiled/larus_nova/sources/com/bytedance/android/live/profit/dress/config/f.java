package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\"\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\f\u0010\u0005R\"\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\u0005R\"\u0010\u0014\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0012\u0010\u0005R\"\u0010\u0017\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0015\u0010\u0005R\"\u0010\u001a\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u0018\u0010\u0005R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/f;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAdvanScatterDecoA", "()Lpy/k;", "getAdvanScatterDecoA$annotations", "()V", "advanScatterDecoA", "getAdvanScatterDecoB", "getAdvanScatterDecoB$annotations", "advanScatterDecoB", "getBuoyAreaBg", "getBuoyAreaBg$annotations", "buoyAreaBg", "getBuoyBall", "getBuoyBall$annotations", "buoyBall", "getBuoyTailing", "getBuoyTailing$annotations", "buoyTailing", "getUnivScatterDecoA", "getUnivScatterDecoA$annotations", "univScatterDecoA", "getUnivScatterDecoB", "getUnivScatterDecoB$annotations", "univScatterDecoB", "", "getScoreColor", "()Ljava/lang/String;", "getScoreColor$annotations", "scoreColor", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f extends vh7.c<f> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "advan_scatter_deco_a")
    py.k getAdvanScatterDecoA();

    @FieldName(name = "advan_scatter_deco_b")
    py.k getAdvanScatterDecoB();

    @FieldName(name = "buoy_area_bg")
    py.k getBuoyAreaBg();

    @FieldName(name = "buoy_ball")
    py.k getBuoyBall();

    @FieldName(name = "buoy_tailing")
    py.k getBuoyTailing();

    @FieldName(name = "score_color")
    String getScoreColor();

    @FieldName(name = "univ_scatter_deco_a")
    py.k getUnivScatterDecoA();

    @FieldName(name = "univ_scatter_deco_b")
    py.k getUnivScatterDecoB();
}
