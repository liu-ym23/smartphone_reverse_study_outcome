package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/IBackgroundMaterial;", "Lvh7/c;", "Lpy/k;", "getBuoyAreaBg", "()Lpy/k;", "getBuoyAreaBg$annotations", "()V", "buoyAreaBg", "getGlobalBg", "getGlobalBg$annotations", "globalBg", "getScoreboardBg", "getScoreboardBg$annotations", "scoreboardBg", "", "getToneLineStart", "()Ljava/lang/String;", "getToneLineStart$annotations", "toneLineStart", "getToneLineEnd", "getToneLineEnd$annotations", "toneLineEnd", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBackgroundMaterial extends c<IBackgroundMaterial> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "buoy_area_bg")
        public static /* synthetic */ void getBuoyAreaBg$annotations() {
        }

        @FieldName(name = "global_bg")
        public static /* synthetic */ void getGlobalBg$annotations() {
        }

        @FieldName(name = "scoreboard_bg")
        public static /* synthetic */ void getScoreboardBg$annotations() {
        }

        @FieldName(name = "tone_line_end")
        public static /* synthetic */ void getToneLineEnd$annotations() {
        }

        @FieldName(name = "tone_line_start")
        public static /* synthetic */ void getToneLineStart$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "buoy_area_bg")
    k getBuoyAreaBg();

    @FieldName(name = "global_bg")
    k getGlobalBg();

    @FieldName(name = "scoreboard_bg")
    k getScoreboardBg();

    @FieldName(name = "tone_line_end")
    String getToneLineEnd();

    @FieldName(name = "tone_line_start")
    String getToneLineStart();
}
