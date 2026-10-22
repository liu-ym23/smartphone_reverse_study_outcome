package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSWatermarkIcon;", "Lvh7/c;", "Lpy/k;", "getIconFlex", "()Lpy/k;", "getIconFlex$annotations", "()V", "iconFlex", "", "getIconWidthFlex", "()Ljava/lang/Long;", "getIconWidthFlex$annotations", "iconWidthFlex", "getIconTypeFlex", "getIconTypeFlex$annotations", "iconTypeFlex", "getLandscapeMarginFlex", "getLandscapeMarginFlex$annotations", "landscapeMarginFlex", "getPortraitMarginFlex", "getPortraitMarginFlex$annotations", "portraitMarginFlex", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IVSWatermarkIcon extends c<IVSWatermarkIcon> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "icon")
        public static /* synthetic */ void getIconFlex$annotations() {
        }

        @FieldName(name = "icon_type")
        public static /* synthetic */ void getIconTypeFlex$annotations() {
        }

        @FieldName(name = "icon_width")
        public static /* synthetic */ void getIconWidthFlex$annotations() {
        }

        @FieldName(name = "landscape_dis")
        public static /* synthetic */ void getLandscapeMarginFlex$annotations() {
        }

        @FieldName(name = "vertical_dis")
        public static /* synthetic */ void getPortraitMarginFlex$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "icon")
    k getIconFlex();

    @FieldName(name = "icon_type")
    Long getIconTypeFlex();

    @FieldName(name = "icon_width")
    Long getIconWidthFlex();

    @FieldName(name = "landscape_dis")
    Long getLandscapeMarginFlex();

    @FieldName(name = "vertical_dis")
    Long getPortraitMarginFlex();
}
