package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0014\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IEpisodePreviewImage;", "Lvh7/c;", "Lpy/k;", "getPreviewImageUp", "()Lpy/k;", "setPreviewImageUp", "(Lpy/k;)V", "getPreviewImageUp$annotations", "()V", "previewImageUp", "getPreviewImageDown", "setPreviewImageDown", "getPreviewImageDown$annotations", "previewImageDown", "", "getPreviewType", "()I", "setPreviewType", "(I)V", "getPreviewType$annotations", "previewType", "", "getPreviewWordUp", "()Ljava/lang/String;", "setPreviewWordUp", "(Ljava/lang/String;)V", "getPreviewWordUp$annotations", "previewWordUp", "getPreviewWordDown", "setPreviewWordDown", "getPreviewWordDown$annotations", "previewWordDown", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IEpisodePreviewImage extends c<IEpisodePreviewImage> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "preview_uri_down")
        public static /* synthetic */ void getPreviewImageDown$annotations() {
        }

        @FieldName(name = "preview_uri_up")
        public static /* synthetic */ void getPreviewImageUp$annotations() {
        }

        @FieldName(name = "preview_type")
        public static /* synthetic */ void getPreviewType$annotations() {
        }

        @FieldName(name = "preview_word_down")
        public static /* synthetic */ void getPreviewWordDown$annotations() {
        }

        @FieldName(name = "preview_word_up")
        public static /* synthetic */ void getPreviewWordUp$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "preview_uri_down")
    k getPreviewImageDown();

    @FieldName(name = "preview_uri_up")
    k getPreviewImageUp();

    @FieldName(name = "preview_type")
    int getPreviewType();

    @FieldName(name = "preview_word_down")
    String getPreviewWordDown();

    @FieldName(name = "preview_word_up")
    String getPreviewWordUp();

    @FieldName(name = "preview_uri_down#setter")
    void setPreviewImageDown(k r100);

    @FieldName(name = "preview_uri_up#setter")
    void setPreviewImageUp(k r100);

    @FieldName(name = "preview_type#setter")
    void setPreviewType(int r100);

    @FieldName(name = "preview_word_down#setter")
    void setPreviewWordDown(String r100);

    @FieldName(name = "preview_word_up#setter")
    void setPreviewWordUp(String r100);
}
