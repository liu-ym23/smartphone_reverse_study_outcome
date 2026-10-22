package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0003\u0010\u0011\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R$\u0010\u000f\u001a\u0004\u0018\u00010\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKDataEx;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPushData;", "getPushData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IPushData;", "getPushData$annotations", "()V", "pushData", "", "getSize", "()Ljava/lang/String;", "setSize", "(Ljava/lang/String;)V", "getSize$annotations", "size", "ICameraHorizontalPosition", "IDisplay", "IGameABParams", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILiveCoreSDKData extends c<ILiveCoreSDKData>, ILiveCoreSDKDataEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "push_data")
        public static /* synthetic */ void getPushData$annotations() {
        }

        @FieldName(name = "size")
        public static /* synthetic */ void getSize$annotations() {
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0012\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0015\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$ICameraHorizontalPosition;", "Lvh7/c;", "", "getAnchor", "()I", "getAnchor$annotations", "()V", "anchor", "", "getX", "()F", "getX$annotations", "x", "getY", "getY$annotations", "y", "getW", "getW$annotations", "w", "getH", "getH$annotations", "h", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @ForMain
    public interface ICameraHorizontalPosition extends c<ICameraHorizontalPosition> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class DefaultImpls {
            @FieldName(name = "anchor")
            public static /* synthetic */ void getAnchor$annotations() {
            }

            @FieldName(name = "h")
            public static /* synthetic */ void getH$annotations() {
            }

            @FieldName(name = "w")
            public static /* synthetic */ void getW$annotations() {
            }

            @FieldName(name = "x")
            public static /* synthetic */ void getX$annotations() {
            }

            @FieldName(name = "y")
            public static /* synthetic */ void getY$annotations() {
            }
        }

        @Override // vh7.c
        /* synthetic */ e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ e castToOrNull(Class r100);

        @FieldName(name = "anchor")
        int getAnchor();

        @FieldName(name = "h")
        float getH();

        @FieldName(name = "w")
        float getW();

        @FieldName(name = "x")
        float getX();

        @FieldName(name = "y")
        float getY();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IDisplay;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IDisplayEx;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @ForMain
    public interface IDisplay extends c<IDisplay>, IDisplayEx {
        @Override // vh7.c
        /* synthetic */ e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ e castToOrNull(Class r100);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\bf\u0018\u00002\u00020\u0001:\u0002\u0014\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IGameABParams;", "", "defaultResolution", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IGameABParams$IPushBase;", "getDefaultResolution$annotations", "()V", "getDefaultResolution", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IGameABParams$IPushBase;", PlayerResolution.SDKKEY.HD, "getHd$annotations", "getHd", PlayerResolution.SDKKEY.LD, "getLd$annotations", "getLd", PlayerResolution.SDKKEY.SD, "getSd$annotations", "getSd", PlayerResolution.SDKKEY.UHD, "getUhd$annotations", "getUhd", "IPushBase", "IResolutionParams", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface IGameABParams {

        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class DefaultImpls {
            @FieldName(name = "default")
            public static /* synthetic */ void getDefaultResolution$annotations() {
            }

            @FieldName(name = PlayerResolution.SDKKEY.HD)
            public static /* synthetic */ void getHd$annotations() {
            }

            @FieldName(name = PlayerResolution.SDKKEY.LD)
            public static /* synthetic */ void getLd$annotations() {
            }

            @FieldName(name = PlayerResolution.SDKKEY.SD)
            public static /* synthetic */ void getSd$annotations() {
            }

            @FieldName(name = PlayerResolution.SDKKEY.UHD)
            public static /* synthetic */ void getUhd$annotations() {
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IGameABParams$IPushBase;", "", "params", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IGameABParams$IResolutionParams;", "getParams$annotations", "()V", "getParams", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IGameABParams$IResolutionParams;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
        public interface IPushBase {

            @Metadata(k = 3, mv = {1, 5, 1})
            public static final class DefaultImpls {
                @FieldName(name = "PushBase")
                public static /* synthetic */ void getParams$annotations() {
                }
            }

            IResolutionParams getParams();
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u001a\u0010\u0017\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IGameABParams$IResolutionParams;", "", "defaultBitrate", "", "getDefaultBitrate$annotations", "()V", "getDefaultBitrate", "()I", "fps", "getFps$annotations", "getFps", "gopSec", "getGopSec$annotations", "getGopSec", "height", "getHeight$annotations", "getHeight", "maxBitrate", "getMaxBitrate$annotations", "getMaxBitrate", "minBitrate", "getMinBitrate$annotations", "getMinBitrate", "width", "getWidth$annotations", "getWidth", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
        public interface IResolutionParams {

            @Metadata(k = 3, mv = {1, 5, 1})
            public static final class DefaultImpls {
                @FieldName(name = "defaultBitrate")
                public static /* synthetic */ void getDefaultBitrate$annotations() {
                }

                @FieldName(name = "fps")
                public static /* synthetic */ void getFps$annotations() {
                }

                @FieldName(name = "gopSec")
                public static /* synthetic */ void getGopSec$annotations() {
                }

                @FieldName(name = "height")
                public static /* synthetic */ void getHeight$annotations() {
                }

                @FieldName(name = "maxBitrate")
                public static /* synthetic */ void getMaxBitrate$annotations() {
                }

                @FieldName(name = "minBitrate")
                public static /* synthetic */ void getMinBitrate$annotations() {
                }

                @FieldName(name = "width")
                public static /* synthetic */ void getWidth$annotations() {
                }
            }

            int getDefaultBitrate();

            int getFps();

            int getGopSec();

            int getHeight();

            int getMaxBitrate();

            int getMinBitrate();

            int getWidth();
        }

        IPushBase getDefaultResolution();

        IPushBase getHd();

        IPushBase getLd();

        IPushBase getSd();

        IPushBase getUhd();
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "push_data")
    IPushData getPushData();

    @FieldName(name = "size")
    String getSize();

    @FieldName(name = "size#setter")
    void setSize(String r100);
}
