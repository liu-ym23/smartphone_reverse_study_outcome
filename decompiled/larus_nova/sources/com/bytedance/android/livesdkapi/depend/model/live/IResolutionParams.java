package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u001c\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0011\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006R\"\u0010\u0015\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006R\"\u0010\u0019\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0006R\"\u0010\u001d\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IResolutionParams;", "Lvh7/c;", "", "getWidth", "()I", "setWidth", "(I)V", "getWidth$annotations", "()V", "width", "getHeight", "setHeight", "getHeight$annotations", "height", "getDefaultBitrate", "setDefaultBitrate", "getDefaultBitrate$annotations", "defaultBitrate", "getMinBitrate", "setMinBitrate", "getMinBitrate$annotations", "minBitrate", "getMaxBitrate", "setMaxBitrate", "getMaxBitrate$annotations", "maxBitrate", "getFps", "setFps", "getFps$annotations", "fps", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IResolutionParams extends c<IResolutionParams> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "default_bitrate")
        public static /* synthetic */ void getDefaultBitrate$annotations() {
        }

        @FieldName(name = "fps")
        public static /* synthetic */ void getFps$annotations() {
        }

        @FieldName(name = "height")
        public static /* synthetic */ void getHeight$annotations() {
        }

        @FieldName(name = "max_bitrate")
        public static /* synthetic */ void getMaxBitrate$annotations() {
        }

        @FieldName(name = "min_bitrate")
        public static /* synthetic */ void getMinBitrate$annotations() {
        }

        @FieldName(name = "width")
        public static /* synthetic */ void getWidth$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "default_bitrate")
    int getDefaultBitrate();

    @FieldName(name = "fps")
    int getFps();

    @FieldName(name = "height")
    int getHeight();

    @FieldName(name = "max_bitrate")
    int getMaxBitrate();

    @FieldName(name = "min_bitrate")
    int getMinBitrate();

    @FieldName(name = "width")
    int getWidth();

    @FieldName(name = "default_bitrate#setter")
    void setDefaultBitrate(int r100);

    @FieldName(name = "fps#setter")
    void setFps(int r100);

    @FieldName(name = "height#setter")
    void setHeight(int r100);

    @FieldName(name = "max_bitrate#setter")
    void setMaxBitrate(int r100);

    @FieldName(name = "min_bitrate#setter")
    void setMinBitrate(int r100);

    @FieldName(name = "width#setter")
    void setWidth(int r100);
}
