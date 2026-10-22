package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R*\u0010\u0011\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAnimatedBgInfoDef;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;", "getThemeShowArea", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;", "setThemeShowArea", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;)V", "getThemeShowArea$annotations", "()V", "themeShowArea", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAnimatedBg", "()Lpy/k;", "setAnimatedBg", "(Lpy/k;)V", "getAnimatedBg$annotations", "animatedBg", "", "getFileFormat", "()Ljava/lang/String;", "setFileFormat", "(Ljava/lang/String;)V", "getFileFormat$annotations", "fileFormat", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IAnimatedBgInfoDef {

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

    k getAnimatedBg();

    String getFileFormat();

    IThemeShowArea getThemeShowArea();

    void setAnimatedBg(k r100);

    void setFileFormat(String r100);

    void setThemeShowArea(IThemeShowArea r100);
}
