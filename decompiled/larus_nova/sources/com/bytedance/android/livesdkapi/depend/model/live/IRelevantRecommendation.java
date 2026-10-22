package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u0012R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRelevantRecommendation;", "Lvh7/c;", "", "getRelevantType", "()Ljava/lang/Integer;", "getRelevantType$annotations", "()V", "relevantType", "getBottomBarType", "getBottomBarType$annotations", "bottomBarType", "Lpy/k;", "getIcon", "()Lpy/k;", "getIcon$annotations", "icon", "", "getPreText", "()Ljava/lang/String;", "getPreText$annotations", "preText", "getNextText", "getNextText$annotations", "nextText", "Lcom/bytedance/android/livesdkapi/depend/model/live/IVsInfo;", "getVsInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IVsInfo;", "getVsInfo$annotations", "vsInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IWhiteCategoryInfo;", "getWhiteCategoryInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IWhiteCategoryInfo;", "getWhiteCategoryInfo$annotations", "whiteCategoryInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IRelevantRecommendation extends c<IRelevantRecommendation> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "bottom_bar_category")
        public static /* synthetic */ void getBottomBarType$annotations() {
        }

        @FieldName(name = "icon")
        public static /* synthetic */ void getIcon$annotations() {
        }

        @FieldName(name = "bar_text_postfix")
        public static /* synthetic */ void getNextText$annotations() {
        }

        @FieldName(name = "bar_text_prefix")
        public static /* synthetic */ void getPreText$annotations() {
        }

        @FieldName(name = "relevant_type")
        public static /* synthetic */ void getRelevantType$annotations() {
        }

        @FieldName(name = "vs_info")
        public static /* synthetic */ void getVsInfo$annotations() {
        }

        @FieldName(name = "white_category_info")
        public static /* synthetic */ void getWhiteCategoryInfo$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "bottom_bar_category")
    Integer getBottomBarType();

    @FieldName(name = "icon")
    k getIcon();

    @FieldName(name = "bar_text_postfix")
    String getNextText();

    @FieldName(name = "bar_text_prefix")
    String getPreText();

    @FieldName(name = "relevant_type")
    Integer getRelevantType();

    @FieldName(name = "vs_info")
    IVsInfo getVsInfo();

    @FieldName(name = "white_category_info")
    IWhiteCategoryInfo getWhiteCategoryInfo();
}
