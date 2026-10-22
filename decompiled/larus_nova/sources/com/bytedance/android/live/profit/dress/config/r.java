package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\"\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\"\u0010\u000f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\u001e\u0010\u0015\u001a\u00060\u0010j\u0002`\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\b\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001d\u001a\u00060\u0010j\u0002`\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001b\u0010\u0013R\"\u0010 \u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001e\u0010\u0006R\"\u0010#\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\b\u001a\u0004\b!\u0010\u0006R\u001c\u0010&\u001a\u0004\u0018\u00010\u00168&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\b\u001a\u0004\b$\u0010\u0018R\"\u0010)\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\b\u001a\u0004\b'\u0010\u0006R\u001a\u0010.\u001a\u00020*8&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\b\u001a\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/r;", "Lvh7/c;", "", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getOverallBgImg", "()Lpy/k;", "getOverallBgImg$annotations", "()V", "overallBgImg", "getPanelOpenEffect", "getPanelOpenEffect$annotations", "panelOpenEffect", "getPanelLoopEffect", "getPanelLoopEffect$annotations", "panelLoopEffect", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getParallaxAssetId", "()J", "getParallaxAssetId$annotations", "parallaxAssetId", "Lcom/bytedance/android/live/base/model/d;", "getBorderPoint9", "()Lcom/bytedance/android/live/base/model/d;", "getBorderPoint9$annotations", "borderPoint9", "getProfileDisplayAssetId", "getProfileDisplayAssetId$annotations", "profileDisplayAssetId", "getBorderPng", "getBorderPng$annotations", "borderPng", "getRightPng", "getRightPng$annotations", "rightPng", "getMainButtonPng", "getMainButtonPng$annotations", "mainButtonPng", "getMainButtonWebp", "getMainButtonWebp$annotations", "mainButtonWebp", "", "getFlashCardId", "()I", "getFlashCardId$annotations", "flashCardId", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r extends vh7.c<r> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "border_png")
    py.k getBorderPng();

    @FieldName(name = "border_point_9")
    com.bytedance.android.live.base.model.d getBorderPoint9();

    @FieldName(name = "flash_card_id")
    int getFlashCardId();

    @FieldName(name = "main_button_png")
    com.bytedance.android.live.base.model.d getMainButtonPng();

    @FieldName(name = "main_button_webp")
    py.k getMainButtonWebp();

    @FieldName(name = "overall_bg_img")
    py.k getOverallBgImg();

    @FieldName(name = "panel_loop_effect")
    py.k getPanelLoopEffect();

    @FieldName(name = "panel_open_effect")
    py.k getPanelOpenEffect();

    @FieldName(name = "parallax_asset_id")
    long getParallaxAssetId();

    @FieldName(name = "profile_display_asset_id")
    long getProfileDisplayAssetId();

    @FieldName(name = "right_png")
    py.k getRightPng();
}
