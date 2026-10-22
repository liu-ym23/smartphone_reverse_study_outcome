package com.bytedance.android.livesdkapi.depend.model.live;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0018\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0011\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006R\"\u0010\u0015\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006R\"\u0010\u0019\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewSwitch;", "Lvh7/c;", "", "getTitle", "()I", d.f25925o, "(I)V", "getTitle$annotations", "()V", "title", "getPreviewGuide", "setPreviewGuide", "getPreviewGuide$annotations", "previewGuide", "getDynamicLabel", "setDynamicLabel", "getDynamicLabel$annotations", "dynamicLabel", "getAssistLabel", "setAssistLabel", "getAssistLabel$annotations", "assistLabel", "getExtendArea", "setExtendArea", "getExtendArea$annotations", "extendArea", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IPreviewSwitch extends c<IPreviewSwitch> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "assist_label")
        public static /* synthetic */ void getAssistLabel$annotations() {
        }

        @FieldName(name = "dynamic_label")
        public static /* synthetic */ void getDynamicLabel$annotations() {
        }

        @FieldName(name = "extend_area")
        public static /* synthetic */ void getExtendArea$annotations() {
        }

        @FieldName(name = "preview_guide")
        public static /* synthetic */ void getPreviewGuide$annotations() {
        }

        @FieldName(name = "title")
        public static /* synthetic */ void getTitle$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "assist_label")
    int getAssistLabel();

    @FieldName(name = "dynamic_label")
    int getDynamicLabel();

    @FieldName(name = "extend_area")
    int getExtendArea();

    @FieldName(name = "preview_guide")
    int getPreviewGuide();

    @FieldName(name = "title")
    int getTitle();

    @FieldName(name = "assist_label#setter")
    void setAssistLabel(int r100);

    @FieldName(name = "dynamic_label#setter")
    void setDynamicLabel(int r100);

    @FieldName(name = "extend_area#setter")
    void setExtendArea(int r100);

    @FieldName(name = "preview_guide#setter")
    void setPreviewGuide(int r100);

    @FieldName(name = "title#setter")
    void setTitle(int r100);
}
