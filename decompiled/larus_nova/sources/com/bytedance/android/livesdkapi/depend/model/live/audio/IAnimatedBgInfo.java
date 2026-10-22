package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAnimatedBgInfo;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAnimatedBgInfoDef;", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;", "getThemeShowArea", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;", "setThemeShowArea", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;)V", "getThemeShowArea$annotations", "()V", "themeShowArea", "Lpy/k;", "getAnimatedBg", "()Lpy/k;", "setAnimatedBg", "(Lpy/k;)V", "getAnimatedBg$annotations", "animatedBg", "", "getFileFormat", "()Ljava/lang/String;", "setFileFormat", "(Ljava/lang/String;)V", "getFileFormat$annotations", "fileFormat", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IAnimatedBgInfo extends c<IAnimatedBgInfo>, IAnimatedBgInfoDef {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "animatedBg")
        public static /* synthetic */ void getAnimatedBg$annotations() {
        }

        @FieldName(name = "fileFormat")
        public static /* synthetic */ void getFileFormat$annotations() {
        }

        @FieldName(name = "showArea")
        public static /* synthetic */ void getThemeShowArea$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "animatedBg")
    k getAnimatedBg();

    @FieldName(name = "fileFormat")
    String getFileFormat();

    @FieldName(name = "showArea")
    IThemeShowArea getThemeShowArea();

    @FieldName(name = "animatedBg#setter")
    void setAnimatedBg(k r100);

    @FieldName(name = "fileFormat#setter")
    void setFileFormat(String r100);

    @FieldName(name = "showArea#setter")
    void setThemeShowArea(IThemeShowArea r100);
}
