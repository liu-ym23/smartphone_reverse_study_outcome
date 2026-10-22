package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.StreamUrl.StreamUrlExtra")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0019\b\u0007\u0018\u0000 \u008b\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002:\u0004\u008b\u0001\u008c\u0001B\u0005¢\u0006\u0002\u0010\u0004J\n\u0010X\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020\fH\u0016J\b\u0010[\u001a\u00020\fH\u0016J\n\u0010\\\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010]\u001a\u00020\fH\u0016J\b\u0010^\u001a\u00020\fH\u0016J\b\u0010_\u001a\u00020`H\u0016J\b\u0010a\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020*H\u0016J\b\u0010c\u001a\u00020\fH\u0016J\b\u0010d\u001a\u00020\fH\u0016J\n\u0010e\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010f\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010g\u001a\u00020\fH\u0016J\b\u0010h\u001a\u00020\fH\u0016J\b\u0010i\u001a\u00020\fH\u0016J\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010UJ\n\u0010k\u001a\u0004\u0018\u00010WH\u0016J\b\u0010l\u001a\u00020\fH\u0016J\b\u0010m\u001a\u00020*H\u0016J\b\u0010n\u001a\u00020!H\u0016J\b\u0010o\u001a\u00020!H\u0016J\b\u0010p\u001a\u00020!H\u0016J\b\u0010q\u001a\u00020!H\u0016J\b\u0010r\u001a\u00020!H\u0016J\u000e\u0010s\u001a\u00020t2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010u\u001a\u00020t2\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010v\u001a\u00020t2\u0006\u0010\u0014\u001a\u00020\fH\u0007J\u000e\u0010w\u001a\u00020t2\u0006\u0010\u001d\u001a\u00020\fJ\u0010\u0010x\u001a\u00020t2\u0006\u0010 \u001a\u00020!H\u0007J\u0010\u0010y\u001a\u00020t2\u0006\u0010&\u001a\u00020!H\u0007J\u000e\u0010z\u001a\u00020t2\u0006\u0010M\u001a\u00020\fJ\u0010\u0010{\u001a\u00020t2\u0006\u0010)\u001a\u00020`H\u0007J\u000e\u0010|\u001a\u00020t2\u0006\u0010/\u001a\u00020!J\u000e\u0010}\u001a\u00020t2\u0006\u00102\u001a\u00020\fJ\u000e\u0010~\u001a\u00020t2\u0006\u0010;\u001a\u00020\fJ\u000e\u0010\u007f\u001a\u00020t2\u0006\u0010>\u001a\u00020\fJ\u0011\u0010\u0080\u0001\u001a\u00020t2\b\u0010A\u001a\u0004\u0018\u00010\u0018J\u0011\u0010\u0081\u0001\u001a\u00020t2\b\u0010D\u001a\u0004\u0018\u00010\u0018J\u000f\u0010\u0082\u0001\u001a\u00020t2\u0006\u0010G\u001a\u00020\fJ\u001d\u0010\u0083\u0001\u001a\u00020t2\u0014\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010UJ\u0012\u0010\u0084\u0001\u001a\u00020t2\u0007\u0010\u0085\u0001\u001a\u00020!H\u0007J\u0012\u0010\u0086\u0001\u001a\u00020t2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010WJ\u0012\u0010\u0088\u0001\u001a\u00020t2\u0007\u0010\u0089\u0001\u001a\u00020!H\u0007J\u000f\u0010\u008a\u0001\u001a\u00020t2\u0006\u0010J\u001a\u00020\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001e\u00102\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R\u001e\u00105\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%R\u001e\u00108\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010#\"\u0004\b:\u0010%R\u001e\u0010;\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000e\"\u0004\b=\u0010\u0010R\u001e\u0010>\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000e\"\u0004\b@\u0010\u0010R \u0010A\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001a\"\u0004\bC\u0010\u001cR \u0010D\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001a\"\u0004\bF\u0010\u001cR\u001e\u0010G\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000e\"\u0004\bI\u0010\u0010R\u001e\u0010J\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u000e\"\u0004\bL\u0010\u0010R\u001e\u0010M\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u000e\"\u0004\bO\u0010\u0010R\u001a\u0010P\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010#\"\u0004\bQ\u0010%R\u000e\u0010R\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R \u0010T\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010U8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\u0004\u0018\u00010W8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u008d\u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrlExtra;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrlExtra;", "()V", "_adaptionInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/AdaptionInfo;", "get_adaptionInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/AdaptionInfo;", "set_adaptionInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/AdaptionInfo;)V", "_anchorInteractProfile", "", "get_anchorInteractProfile", "()I", "set_anchorInteractProfile", "(I)V", "_audienceInteractProfile", "get_audienceInteractProfile", "set_audienceInteractProfile", "_bitrateAdaptStrategy", "get_bitrateAdaptStrategy", "set_bitrateAdaptStrategy", "_businessName", "", "get_businessName", "()Ljava/lang/String;", "set_businessName", "(Ljava/lang/String;)V", "_defaultBitrate", "get_defaultBitrate", "set_defaultBitrate", "_enableBFrame", "", "get_enableBFrame", "()Z", "set_enableBFrame", "(Z)V", "_enableH265", "get_enableH265", "set_enableH265", "_gopSec", "", "get_gopSec", "()J", "set_gopSec", "(J)V", "_hardwareEncode", "get_hardwareEncode", "set_hardwareEncode", "_height", "get_height", "set_height", "_isRoi", "get_isRoi", "set_isRoi", "_isSwRoi", "get_isSwRoi", "set_isSwRoi", "_maxBitrate", "get_maxBitrate", "set_maxBitrate", "_minBitrate", "get_minBitrate", "set_minBitrate", "_ngbPushUrl", "get_ngbPushUrl", "set_ngbPushUrl", "_ngbPushUrlPrefix", "get_ngbPushUrlPrefix", "set_ngbPushUrlPrefix", "_profile", "get_profile", "set_profile", "_width", "get_width", "set_width", "fps", "getFps", "setFps", "isEnableAudio", "setEnableAudio", "previewHeight", "previewWidth", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "Lkotlin/Pair;", "srConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrlExtra$SrConfig;", "getAdaptionInfo", "getAnchorInteractProfile", "getAudienceInteractProfile", "getBitrateAdaptStrategy", "getBusinessName", "getDefaultBitrate", "getFPS", "getGopSec", "", "getHeight", "getHeightFlex", "getMaxBitrate", "getMinBitrate", "getNgbPushUrl", "getNgbPushUrlPrefix", "getPreviewHeight", "getPreviewWidth", "getProfile", "getRatio", "getSrConfig", "getWidth", "getWidthFlex", "isEnableBFrame", "isEnableH265", "isHardwareEncode", "isRoi", "isSwRoi", "setAnchorInteractProfile", "", "setAudienceInteractProfile", "setBitrateAdaptStrategy", "setDefaultBitrate", "setEnableBFrame", "setEnableH265", "setFPS", "setGopSec", "setHardwareEncode", "setHeight", "setMaxBitrate", "setMinBitrate", "setNgbPushUrl", "setNgbPushUrlPrefix", "setProfile", "setRatio", "setRoi", "_roi", "setSrConfig", "_srConfig", "setSwRoi", "_swRoi", "setWidth", "Companion", "SrConfig", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StreamUrlExtra extends FlexModelBase<IStreamUrlExtra> implements IBaseStreamUrlExtra, IStreamUrlExtra, h {
    public static final Companion Companion = null;
    private static final int DEFAULT_DEFAULT_BITRATE = 500;
    private static final int DEFAULT_FPS = 15;
    private static final int DEFAULT_HEIGHT = 640;
    private static final int DEFAULT_MAX_BITRATE = 800;
    private static final int DEFAULT_MIN_BITRATE = 200;
    private static final int DEFAULT_PREVIEW_HEIGHT = 1280;
    private static final int DEFAULT_PREVIEW_WIDTH = 720;
    private static final int DEFAULT_PROFILE = 1;
    private static final int DEFAULT_WIDTH = 360;

    @SerializedName("adaption_info")
    protected AdaptionInfo _adaptionInfo;

    @SerializedName("anchor_interact_profile")
    protected int _anchorInteractProfile;

    @SerializedName("audience_interact_profile")
    protected int _audienceInteractProfile;

    @SerializedName("bitrate_adapt_strategy")
    protected int _bitrateAdaptStrategy;

    @SerializedName("business_name")
    protected String _businessName;

    @SerializedName("default_bitrate")
    protected int _defaultBitrate;

    @SerializedName("bframe_enable")
    protected boolean _enableBFrame;

    @SerializedName("h265_enable")
    protected boolean _enableH265;

    @SerializedName("gop_sec")
    protected long _gopSec;

    @SerializedName("hardware_encode")
    protected boolean _hardwareEncode;

    @SerializedName("height")
    protected int _height;

    @SerializedName("roi")
    protected boolean _isRoi;

    @SerializedName("sw_roi")
    protected boolean _isSwRoi;

    @SerializedName("max_bitrate")
    protected int _maxBitrate;

    @SerializedName("min_bitrate")
    protected int _minBitrate;

    @IgnoreProtoFieldCheck
    @SerializedName("ngb_push_url")
    private String _ngbPushUrl;

    @IgnoreProtoFieldCheck
    @SerializedName("ngb_push_url_postfix")
    private String _ngbPushUrlPrefix;

    @SerializedName("video_profile")
    protected int _profile;

    @SerializedName("width")
    protected int _width;

    @SerializedName("fps")
    protected int fps;
    private boolean isEnableAudio;
    private final int previewHeight;
    private final int previewWidth;
    public Pair<Integer, Integer> ratio;

    @SerializedName("super_resolution")
    public SrConfig srConfig;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrlExtra$Companion;", "", "()V", "DEFAULT_DEFAULT_BITRATE", "", "DEFAULT_FPS", "DEFAULT_HEIGHT", "DEFAULT_MAX_BITRATE", "DEFAULT_MIN_BITRATE", "DEFAULT_PREVIEW_HEIGHT", "DEFAULT_PREVIEW_WIDTH", "DEFAULT_PROFILE", "DEFAULT_WIDTH", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @ProtoMessage("webcast.data.StreamUrl.StreamUrlExtra.SuperResolution")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B%\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001e\u0010\u0005\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrlExtra$SrConfig;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ISrConfig;", "enabled", "", "antiAlias", TextureRenderKeys.KEY_IS_STRENGTH_FLOAT, "", "(ZZI)V", "getAntiAlias", "()Z", "setAntiAlias", "(Z)V", "getEnabled", "setEnabled", "getStrength", "()I", "setStrength", "(I)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SrConfig extends FlexModelBase<ISrConfig> implements ISrConfig, h {

        @SerializedName("antialiasing")
        protected boolean antiAlias;

        @SerializedName("enable")
        protected boolean enabled;

        @SerializedName(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT)
        protected int strength;

        public SrConfig(boolean r100, boolean r101, int r102) {
            super(ISrConfig.class);
            this.enabled = r100;
            this.antiAlias = r101;
            this.strength = r102;
        }

        public SrConfig() {
            super(ISrConfig.class);
            this.enabled = false;
            this.antiAlias = false;
            this.strength = 0;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ISrConfig
        public boolean getAntiAlias() {
            return this.antiAlias;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ISrConfig
        public boolean getEnabled() {
            return this.enabled;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ISrConfig
        public int getStrength() {
            return this.strength;
        }

        public SrConfig(g r100) {
            super(ISrConfig.class);
            setThreadSafe(false);
            long r101 = r100.c();
            int r102 = 0;
        L3:
            int r103 = r100.f();
            if (r103 == (-1)) goto L15;
            g.a r104 = decodeExtensionFields(r103, r100);
            if (r103 != 1) goto L8;
            this.enabled = am3.h.a(r100);
            r102 = r102 | 1;
            goto L3
        L8:
            if (r103 != 2) goto L10;
            this.strength = (int) r100.j();
            r102 = r102 | 4;
            goto L3
        L10:
            if (r103 != 3) goto L11;
            this.antiAlias = am3.h.a(r100);
            r102 = r102 | 2;
            goto L3
        L11:
            am3.h.d(r104, r100);
            goto L3
        L15:
            r100.d(r101);
            setThreadSafe(true);
            if ((r102 & 1) != 0) goto L19;
            this.enabled = false;
        L19:
            if ((r102 & 2) != 0) goto L22;
            this.antiAlias = false;
        L22:
            if ((r102 & 4) != 0) goto L37;
            this.strength = 0;
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ISrConfig
        public void setAntiAlias(boolean r100) {
            this.antiAlias = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ISrConfig
        public void setEnabled(boolean r100) {
            this.enabled = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.ISrConfig
        public void setStrength(int r100) {
            this.strength = r100;
        }

        public /* synthetic */ SrConfig(boolean r100, boolean r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = false;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 0;
        L11:
            this(r100, r101, r102);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StreamUrlExtra() {
        super(IStreamUrlExtra.class);
        this._ngbPushUrl = "";
        this._ngbPushUrlPrefix = "";
        this.isEnableAudio = true;
        this._height = 640;
        this._width = 360;
        this._minBitrate = 200;
        this._defaultBitrate = 500;
        this._maxBitrate = 800;
        this._profile = 1;
        this.fps = 15;
        this._gopSec = 2;
        this._businessName = "";
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public int getDefaultBitrate() {
        if (this._defaultBitrate != 0) goto L6;
        this._defaultBitrate = 500;
    L6:
        return this._defaultBitrate;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public int getFPS() {
        if (this.fps != 0) goto L6;
        this.fps = 15;
    L6:
        return this.fps;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public float getGopSec() {
        return this._gopSec;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public int getHeight() {
        if (this._height != 0) goto L6;
        this._height = 640;
    L6:
        return this._height;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public long getHeightFlex() {
        return this._height;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public int getMaxBitrate() {
        if (this._maxBitrate != 0) goto L6;
        this._maxBitrate = (getDefaultBitrate() * 2) - getMinBitrate();
    L6:
        return this._maxBitrate;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public int getMinBitrate() {
        if (this._minBitrate != 0) goto L6;
        this._minBitrate = 200;
    L6:
        return this._minBitrate;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra
    public int getPreviewHeight() {
        int r100 = this.previewHeight;
        if (r100 != 0) goto L6;
        return 1280;
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra
    public int getPreviewWidth() {
        int r100 = this.previewWidth;
        if (r100 != 0) goto L6;
        return 720;
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public int getWidth() {
        if (this._width != 0) goto L6;
        this._width = 360;
    L6:
        return this._width;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public long getWidthFlex() {
        return this._width;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public /* bridge */ /* synthetic */ ISrConfig getSrConfig() {
        return getSrConfig();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public AdaptionInfo getAdaptionInfo() {
        return this._adaptionInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public int getAnchorInteractProfile() {
        return this._anchorInteractProfile;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public int getAudienceInteractProfile() {
        return this._audienceInteractProfile;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public int getBitrateAdaptStrategy() {
        return this._bitrateAdaptStrategy;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public String getBusinessName() {
        return this._businessName;
    }

    public final int getFps() {
        return this.fps;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public String getNgbPushUrl() {
        return this._ngbPushUrl;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public String getNgbPushUrlPrefix() {
        return this._ngbPushUrlPrefix;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public int getProfile() {
        return this._profile;
    }

    public final Pair<Integer, Integer> getRatio() {
        return this.ratio;
    }

    public final AdaptionInfo get_adaptionInfo() {
        return this._adaptionInfo;
    }

    public final int get_anchorInteractProfile() {
        return this._anchorInteractProfile;
    }

    public final int get_audienceInteractProfile() {
        return this._audienceInteractProfile;
    }

    public final int get_bitrateAdaptStrategy() {
        return this._bitrateAdaptStrategy;
    }

    public final String get_businessName() {
        return this._businessName;
    }

    public final int get_defaultBitrate() {
        return this._defaultBitrate;
    }

    public final boolean get_enableBFrame() {
        return this._enableBFrame;
    }

    public final boolean get_enableH265() {
        return this._enableH265;
    }

    public final long get_gopSec() {
        return this._gopSec;
    }

    public final boolean get_hardwareEncode() {
        return this._hardwareEncode;
    }

    public final int get_height() {
        return this._height;
    }

    public final boolean get_isRoi() {
        return this._isRoi;
    }

    public final boolean get_isSwRoi() {
        return this._isSwRoi;
    }

    public final int get_maxBitrate() {
        return this._maxBitrate;
    }

    public final int get_minBitrate() {
        return this._minBitrate;
    }

    public final String get_ngbPushUrl() {
        return this._ngbPushUrl;
    }

    public final String get_ngbPushUrlPrefix() {
        return this._ngbPushUrlPrefix;
    }

    public final int get_profile() {
        return this._profile;
    }

    public final int get_width() {
        return this._width;
    }

    public final boolean isEnableAudio() {
        return this.isEnableAudio;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra
    public boolean isEnableBFrame() {
        return this._enableBFrame;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public boolean isEnableH265() {
        return this._enableH265;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public boolean isHardwareEncode() {
        return this._hardwareEncode;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public boolean isRoi() {
        return this._isRoi;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public boolean isSwRoi() {
        return this._isSwRoi;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlExtra, com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra
    public SrConfig getSrConfig() {
        return this.srConfig;
    }

    public StreamUrlExtra(g r100) {
        super(IStreamUrlExtra.class);
        this._ngbPushUrl = "";
        this._ngbPushUrlPrefix = "";
        this.isEnableAudio = true;
        int r101 = 0;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L27;
        g.a r104 = decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            case 11: goto L7;
            case 12: goto L16;
            case 13: goto L7;
            case 14: goto L15;
            case 15: goto L14;
            case 16: goto L13;
            case 17: goto L12;
            case 18: goto L11;
            case 19: goto L10;
            case 20: goto L7;
            case 21: goto L7;
            case 22: goto L9;
            case 23: goto L8;
            default: goto L7;
        };
    L8:
        this._businessName = am3.h.c(r100);
        goto L3
    L9:
        this._adaptionInfo = new AdaptionInfo(r100);
        goto L3
    L10:
        this._isSwRoi = am3.h.a(r100);
        goto L3
    L11:
        this._isRoi = am3.h.a(r100);
        goto L3
    L12:
        this._enableBFrame = am3.h.a(r100);
        goto L3
    L13:
        this._gopSec = r100.j();
        r101 = r101 | 128;
        goto L3
    L14:
        this._enableH265 = am3.h.a(r100);
        goto L3
    L15:
        this.srConfig = new SrConfig(r100);
        goto L3
    L16:
        this._profile = (int) r100.j();
        r101 = r101 | 32;
        goto L3
    L17:
        this._hardwareEncode = am3.h.a(r100);
        goto L3
    L18:
        this._audienceInteractProfile = (int) r100.j();
        goto L3
    L19:
        this._anchorInteractProfile = (int) r100.j();
        goto L3
    L20:
        this._bitrateAdaptStrategy = (int) r100.j();
        goto L3
    L21:
        this._defaultBitrate = (int) r100.j();
        r101 = r101 | 8;
        goto L3
    L22:
        this._minBitrate = (int) r100.j();
        r101 = r101 | 4;
        goto L3
    L23:
        this._maxBitrate = (int) r100.j();
        r101 = r101 | 16;
        goto L3
    L24:
        this.fps = (int) r100.j();
        r101 = r101 | 64;
        goto L3
    L25:
        this._width = (int) r100.j();
        r101 = r101 | 2;
        goto L3
    L26:
        this._height = (int) r100.j();
        r101 = r101 | 1;
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L27:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & 1) != 0) goto L31;
        this._height = 640;
    L31:
        if ((r101 & 2) != 0) goto L34;
        this._width = 360;
    L34:
        if ((r101 & 4) != 0) goto L37;
        this._minBitrate = 200;
    L37:
        if ((r101 & 8) != 0) goto L40;
        this._defaultBitrate = 500;
    L40:
        if ((r101 & 16) != 0) goto L43;
        this._maxBitrate = 800;
    L43:
        if ((r101 & 32) != 0) goto L46;
        this._profile = 1;
    L46:
        if ((r101 & 64) != 0) goto L49;
        this.fps = 15;
    L49:
        if ((r101 & 128) != 0) goto L52;
        this._gopSec = 2;
    L52:
        if (this._businessName != null) goto L97;
        this._businessName = "";
        return;
    }

    public final void setAnchorInteractProfile(int r100) {
        this._anchorInteractProfile = r100;
    }

    public final void setAudienceInteractProfile(int r100) {
        this._audienceInteractProfile = r100;
    }

    @SerializedName("bitrate_adapt_strategy")
    public final void setBitrateAdaptStrategy(int r100) {
        this._bitrateAdaptStrategy = r100;
    }

    public final void setDefaultBitrate(int r100) {
        this._defaultBitrate = r100;
    }

    public final void setEnableAudio(boolean r100) {
        this.isEnableAudio = r100;
    }

    @SerializedName("bframe_enable")
    public final void setEnableBFrame(boolean r100) {
        this._enableBFrame = r100;
    }

    @SerializedName("h265_enable")
    public final void setEnableH265(boolean r100) {
        this._enableH265 = r100;
    }

    public final void setFPS(int r100) {
        this.fps = r100;
    }

    public final void setFps(int r100) {
        this.fps = r100;
    }

    @SerializedName("gop_sec")
    public final void setGopSec(float r100) {
        this._gopSec = (long) r100;
    }

    public final void setHardwareEncode(boolean r100) {
        this._hardwareEncode = r100;
    }

    public final void setHeight(int r100) {
        this._height = r100;
    }

    public final void setMaxBitrate(int r100) {
        this._maxBitrate = r100;
    }

    public final void setMinBitrate(int r100) {
        this._minBitrate = r100;
    }

    public final void setNgbPushUrl(String r100) {
        this._ngbPushUrl = r100;
    }

    public final void setNgbPushUrlPrefix(String r100) {
        this._ngbPushUrlPrefix = r100;
    }

    public final void setProfile(int r100) {
        this._profile = r100;
    }

    public final void setRatio(Pair<Integer, Integer> r100) {
        this.ratio = r100;
    }

    @SerializedName("roi")
    public final void setRoi(boolean r100) {
        this._isRoi = r100;
    }

    public final void setSrConfig(SrConfig r100) {
        this.srConfig = r100;
    }

    @SerializedName("sw_roi")
    public final void setSwRoi(boolean r100) {
        this._isSwRoi = r100;
    }

    public final void setWidth(int r100) {
        this._width = r100;
    }

    public final void set_adaptionInfo(AdaptionInfo r100) {
        this._adaptionInfo = r100;
    }

    public final void set_anchorInteractProfile(int r100) {
        this._anchorInteractProfile = r100;
    }

    public final void set_audienceInteractProfile(int r100) {
        this._audienceInteractProfile = r100;
    }

    public final void set_bitrateAdaptStrategy(int r100) {
        this._bitrateAdaptStrategy = r100;
    }

    public final void set_businessName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this._businessName = r100;
    }

    public final void set_defaultBitrate(int r100) {
        this._defaultBitrate = r100;
    }

    public final void set_enableBFrame(boolean r100) {
        this._enableBFrame = r100;
    }

    public final void set_enableH265(boolean r100) {
        this._enableH265 = r100;
    }

    public final void set_gopSec(long r100) {
        this._gopSec = r100;
    }

    public final void set_hardwareEncode(boolean r100) {
        this._hardwareEncode = r100;
    }

    public final void set_height(int r100) {
        this._height = r100;
    }

    public final void set_isRoi(boolean r100) {
        this._isRoi = r100;
    }

    public final void set_isSwRoi(boolean r100) {
        this._isSwRoi = r100;
    }

    public final void set_maxBitrate(int r100) {
        this._maxBitrate = r100;
    }

    public final void set_minBitrate(int r100) {
        this._minBitrate = r100;
    }

    public final void set_ngbPushUrl(String r100) {
        this._ngbPushUrl = r100;
    }

    public final void set_ngbPushUrlPrefix(String r100) {
        this._ngbPushUrlPrefix = r100;
    }

    public final void set_profile(int r100) {
        this._profile = r100;
    }

    public final void set_width(int r100) {
        this._width = r100;
    }
}
