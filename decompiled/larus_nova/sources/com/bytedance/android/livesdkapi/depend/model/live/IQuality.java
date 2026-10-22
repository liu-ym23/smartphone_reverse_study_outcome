package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0013\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003R\"\u0010\u000b\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\"\u0010\u0016\u001a\u00020\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001e\u001a\u00020\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\n\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\"\u001a\u00020\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\n\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseQuality;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQualityKt;", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getName$annotations", "()V", "name", "getSubName", "setSubName", "getSubName$annotations", "subName", "", "getFps", "()I", "setFps", "(I)V", "getFps$annotations", "fps", "getResolution", "setResolution", "getResolution$annotations", "resolution", "getEncodeFormat", "setEncodeFormat", "getEncodeFormat$annotations", "encodeFormat", "getLevel", "setLevel", "getLevel$annotations", "level", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IQuality extends c<IQuality>, IBaseQuality, IQualityKt {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "v_codec")
        public static /* synthetic */ void getEncodeFormat$annotations() {
        }

        @FieldName(name = "fps")
        public static /* synthetic */ void getFps$annotations() {
        }

        @FieldName(name = "level")
        public static /* synthetic */ void getLevel$annotations() {
        }

        @FieldName(name = "name")
        public static /* synthetic */ void getName$annotations() {
        }

        @FieldName(name = "resolution")
        public static /* synthetic */ void getResolution$annotations() {
        }

        @FieldName(name = "additional_content")
        public static /* synthetic */ void getSubName$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "v_codec")
    String getEncodeFormat();

    @FieldName(name = "fps")
    int getFps();

    @FieldName(name = "level")
    int getLevel();

    @FieldName(name = "name")
    String getName();

    @FieldName(name = "resolution")
    String getResolution();

    @FieldName(name = "additional_content")
    String getSubName();

    @FieldName(name = "v_codec#setter")
    void setEncodeFormat(String r100);

    @FieldName(name = "fps#setter")
    void setFps(int r100);

    @FieldName(name = "level#setter")
    void setLevel(int r100);

    @FieldName(name = "name#setter")
    void setName(String r100);

    @FieldName(name = "resolution#setter")
    void setResolution(String r100);

    @FieldName(name = "additional_content#setter")
    void setSubName(String r100);
}
