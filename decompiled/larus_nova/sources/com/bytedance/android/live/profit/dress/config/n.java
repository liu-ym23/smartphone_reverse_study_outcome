package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u000bR\"\u0010\u0013\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u001e\u001a\u001e\u0012\b\u0012\u00060\bj\u0002`\t\u0018\u00010\u0019j\u000e\u0012\b\u0012\u00060\bj\u0002`\t\u0018\u0001`\u001a8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u001f8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b \u0010!R\"\u0010&\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0006\u001a\u0004\b$\u0010\u000bR\"\u0010)\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0006\u001a\u0004\b'\u0010\u000bR\u001c\u0010.\u001a\u0004\u0018\u00010*8&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0006\u001a\u0004\b+\u0010,R\"\u00101\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0006\u001a\u0004\b/\u0010\u000bR\"\u00104\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0006\u001a\u0004\b2\u0010\u000b¨\u00065"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/n;", "Lvh7/c;", "Lcom/bytedance/android/live/profit/dress/config/f;", "getMidiConfig", "()Lcom/bytedance/android/live/profit/dress/config/f;", "getMidiConfig$annotations", "()V", "midiConfig", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getSongTitleBgImage", "()Lpy/k;", "getSongTitleBgImage$annotations", "songTitleBgImage", "getJoinChorusBtnImage", "getJoinChorusBtnImage$annotations", "joinChorusBtnImage", "getCloseEffectImage", "getCloseEffectImage$annotations", "closeEffectImage", "Lcom/bytedance/android/live/profit/dress/config/e;", "getEvaluateConfig", "()Lcom/bytedance/android/live/profit/dress/config/e;", "getEvaluateConfig$annotations", "evaluateConfig", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getVoiceWaveImages", "()Ljava/util/List;", "getVoiceWaveImages$annotations", "voiceWaveImages", "Lcom/bytedance/android/live/profit/dress/config/g;", "getStageEffectConfig", "()Lcom/bytedance/android/live/profit/dress/config/g;", "getStageEffectConfig$annotations", "stageEffectConfig", "getShareBgImage", "getShareBgImage$annotations", "shareBgImage", "getBgImage", "getBgImage$annotations", "bgImage", "", "getThemeColor", "()Ljava/lang/String;", "getThemeColor$annotations", "themeColor", "getLeadSingerIconImage", "getLeadSingerIconImage$annotations", "leadSingerIconImage", "getEnterBtnImage", "getEnterBtnImage$annotations", "enterBtnImage", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n extends vh7.c<n> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "bg_image")
    py.k getBgImage();

    @FieldName(name = "close_effect_image")
    py.k getCloseEffectImage();

    @FieldName(name = "enter_btn_image")
    py.k getEnterBtnImage();

    @FieldName(name = "evaluate_config")
    e getEvaluateConfig();

    @FieldName(name = "join_chorus_btn_image")
    py.k getJoinChorusBtnImage();

    @FieldName(name = "lead_singer_icon_image")
    py.k getLeadSingerIconImage();

    @FieldName(name = "midi_config")
    f getMidiConfig();

    @FieldName(name = "share_bg_image")
    py.k getShareBgImage();

    @FieldName(name = "song_title_bg_image")
    py.k getSongTitleBgImage();

    @FieldName(name = "stage_effect_config")
    g getStageEffectConfig();

    @FieldName(name = "theme_color")
    String getThemeColor();

    @FieldName(name = "voice_wave_images")
    List<py.k> getVoiceWaveImages();
}
