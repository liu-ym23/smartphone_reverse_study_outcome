package com.bytedance.android.live.core.resources;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R\"\u0010\u0015\u001a\u00020\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0019\u001a\u00020\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/core/resources/a;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getTextImageModel", "()Lpy/k;", "setTextImageModel", "(Lpy/k;)V", "getTextImageModel$annotations", "()V", "textImageModel", "getPictureImageModel", "setPictureImageModel", "getPictureImageModel$annotations", "pictureImageModel", "", "getTextMaxShowTimes", "()I", "setTextMaxShowTimes", "(I)V", "getTextMaxShowTimes$annotations", "textMaxShowTimes", "getImageMaxShowTimes", "setImageMaxShowTimes", "getImageMaxShowTimes$annotations", "imageMaxShowTimes", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a> {

    /* JADX INFO: renamed from: com.bytedance.android.live.core.resources.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C1073a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "max_picture_display_num")
    int getImageMaxShowTimes();

    @FieldName(name = "picture")
    py.k getPictureImageModel();

    @FieldName(name = "text")
    py.k getTextImageModel();

    @FieldName(name = "max_text_display_num")
    int getTextMaxShowTimes();

    @FieldName(name = "max_picture_display_num#setter")
    void setImageMaxShowTimes(int r100);

    @FieldName(name = "picture#setter")
    void setPictureImageModel(py.k r100);

    @FieldName(name = "text#setter")
    void setTextImageModel(py.k r100);

    @FieldName(name = "max_text_display_num#setter")
    void setTextMaxShowTimes(int r100);
}
