package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\bA\b\u0007\u0018\u00002\u00020\u0001B\u0093\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003¢\u0006\u0002\u0010\u001eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u001e\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010&R\u001e\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010&R\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u001e\u0010\u001d\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010&R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u001e\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010&R\u001e\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010 \"\u0004\b8\u0010&R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010 R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010 R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010 R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010 \"\u0004\b=\u0010&R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010 R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010 R\u001e\u0010\u001c\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010 \"\u0004\bA\u0010&R\u001e\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010 \"\u0004\bC\u0010&¨\u0006D"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerConfig;", "", "enableRePullStream", "", "audioFocusRefactor", "printCallStack", "foldScreenAdapt", "foldScreenAdaptV2", "removeClientWhenStop", "repeatPullStreamFix", "checkStreamDataValid", "fixObserverMemLeak", "fixBackgroundMute", "fixExBlackScreen", "fixResolutionInit", "audioRoomOptimize", "extraSurface", "extraSurfaceRoundedCorner", "preCreateSurface", "bpeaEnable", "fixSearchExtraView", "fgNotResponseAudioFocus", "vrEnable", "enableNetworkUtilsOpt", "enableNetworkOperateCodeOpt", "fixSurfaceViewCLearWhenBind", "fixSurfaceCallbackIsNullForReuseAfterRelease", "enableRePullByStreamId", "resolutionStackEnable", "endLogParamsEnable", "(ZZZZZZZZZZZZZZZZZZZZZZZZZZZ)V", "getAudioFocusRefactor", "()Z", "getAudioRoomOptimize", "getBpeaEnable", "getCheckStreamDataValid", "getEnableNetworkOperateCodeOpt", "setEnableNetworkOperateCodeOpt", "(Z)V", "getEnableNetworkUtilsOpt", "setEnableNetworkUtilsOpt", "getEnableRePullByStreamId", "getEnableRePullStream", "getEndLogParamsEnable", "setEndLogParamsEnable", "getExtraSurface", "getExtraSurfaceRoundedCorner", "getFgNotResponseAudioFocus", "getFixBackgroundMute", "getFixExBlackScreen", "getFixObserverMemLeak", "getFixResolutionInit", "getFixSearchExtraView", "getFixSurfaceCallbackIsNullForReuseAfterRelease", "setFixSurfaceCallbackIsNullForReuseAfterRelease", "getFixSurfaceViewCLearWhenBind", "setFixSurfaceViewCLearWhenBind", "getFoldScreenAdapt", "getFoldScreenAdaptV2", "getPreCreateSurface", "getPrintCallStack", "setPrintCallStack", "getRemoveClientWhenStop", "getRepeatPullStreamFix", "getResolutionStackEnable", "setResolutionStackEnable", "getVrEnable", "setVrEnable", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerConfig {

    @SerializedName("audio_focus_refactor")
    private final boolean audioFocusRefactor;

    @SerializedName("audio_room_optimize")
    private final boolean audioRoomOptimize;

    @SerializedName("bpea_enable")
    private final boolean bpeaEnable;

    @SerializedName("check_stream_data_valid")
    private final boolean checkStreamDataValid;

    @SerializedName("enable_network_operate_code_opt")
    private boolean enableNetworkOperateCodeOpt;

    @SerializedName("enable_network_utils_opt")
    private boolean enableNetworkUtilsOpt;

    @SerializedName("enable_repull_by_stream_id_diff")
    private final boolean enableRePullByStreamId;

    @SerializedName("enadble_re_pullstream")
    private final boolean enableRePullStream;

    @SerializedName("end_log_params_enable")
    private boolean endLogParamsEnable;

    @SerializedName("extra_surface")
    private final boolean extraSurface;

    @SerializedName("extra_surface_rounded_corner")
    private final boolean extraSurfaceRoundedCorner;

    @SerializedName("fg_not_response_audio_focus")
    private final boolean fgNotResponseAudioFocus;

    @SerializedName("fix_background_mute")
    private final boolean fixBackgroundMute;

    @SerializedName("fix_ex_black_screen")
    private final boolean fixExBlackScreen;

    @SerializedName("fix_observer_mem_leak")
    private final boolean fixObserverMemLeak;

    @SerializedName("fix_resolution_init")
    private final boolean fixResolutionInit;

    @SerializedName("fix_search_extra_view")
    private final boolean fixSearchExtraView;

    @SerializedName("fix_surface_callback_is_null_for_reuse_after_release")
    private boolean fixSurfaceCallbackIsNullForReuseAfterRelease;

    @SerializedName("fix_surface_view_clear_when_bind")
    private boolean fixSurfaceViewCLearWhenBind;

    @SerializedName("fold_screen_adapter")
    private final boolean foldScreenAdapt;

    @SerializedName("fold_screen_adapter_v2")
    private final boolean foldScreenAdaptV2;

    @SerializedName("pre_create_surface")
    private final boolean preCreateSurface;

    @SerializedName("print_call_stack")
    private boolean printCallStack;

    @SerializedName("remove_client_when_stop")
    private final boolean removeClientWhenStop;

    @SerializedName("repeat_pull_stream_fix")
    private final boolean repeatPullStreamFix;

    @SerializedName("resolution_stack_enable")
    private boolean resolutionStackEnable;

    @SerializedName("vr_enable")
    private boolean vrEnable;

    public PlayerConfig() {
        this(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 134217727, null);
    }

    public final boolean getAudioFocusRefactor() {
        return this.audioFocusRefactor;
    }

    public final boolean getAudioRoomOptimize() {
        return this.audioRoomOptimize;
    }

    public final boolean getBpeaEnable() {
        return this.bpeaEnable;
    }

    public final boolean getCheckStreamDataValid() {
        return this.checkStreamDataValid;
    }

    public final boolean getEnableNetworkOperateCodeOpt() {
        return this.enableNetworkOperateCodeOpt;
    }

    public final boolean getEnableNetworkUtilsOpt() {
        return this.enableNetworkUtilsOpt;
    }

    public final boolean getEnableRePullByStreamId() {
        return this.enableRePullByStreamId;
    }

    public final boolean getEnableRePullStream() {
        return this.enableRePullStream;
    }

    public final boolean getEndLogParamsEnable() {
        return this.endLogParamsEnable;
    }

    public final boolean getExtraSurface() {
        return this.extraSurface;
    }

    public final boolean getExtraSurfaceRoundedCorner() {
        return this.extraSurfaceRoundedCorner;
    }

    public final boolean getFgNotResponseAudioFocus() {
        return this.fgNotResponseAudioFocus;
    }

    public final boolean getFixBackgroundMute() {
        return this.fixBackgroundMute;
    }

    public final boolean getFixExBlackScreen() {
        return this.fixExBlackScreen;
    }

    public final boolean getFixObserverMemLeak() {
        return this.fixObserverMemLeak;
    }

    public final boolean getFixResolutionInit() {
        return this.fixResolutionInit;
    }

    public final boolean getFixSearchExtraView() {
        return this.fixSearchExtraView;
    }

    public final boolean getFixSurfaceCallbackIsNullForReuseAfterRelease() {
        return this.fixSurfaceCallbackIsNullForReuseAfterRelease;
    }

    public final boolean getFixSurfaceViewCLearWhenBind() {
        return this.fixSurfaceViewCLearWhenBind;
    }

    public final boolean getFoldScreenAdapt() {
        return this.foldScreenAdapt;
    }

    public final boolean getFoldScreenAdaptV2() {
        return this.foldScreenAdaptV2;
    }

    public final boolean getPreCreateSurface() {
        return this.preCreateSurface;
    }

    public final boolean getPrintCallStack() {
        return this.printCallStack;
    }

    public final boolean getRemoveClientWhenStop() {
        return this.removeClientWhenStop;
    }

    public final boolean getRepeatPullStreamFix() {
        return this.repeatPullStreamFix;
    }

    public final boolean getResolutionStackEnable() {
        return this.resolutionStackEnable;
    }

    public final boolean getVrEnable() {
        return this.vrEnable;
    }

    public final void setEnableNetworkOperateCodeOpt(boolean r100) {
        this.enableNetworkOperateCodeOpt = r100;
    }

    public final void setEnableNetworkUtilsOpt(boolean r100) {
        this.enableNetworkUtilsOpt = r100;
    }

    public final void setEndLogParamsEnable(boolean r100) {
        this.endLogParamsEnable = r100;
    }

    public final void setFixSurfaceCallbackIsNullForReuseAfterRelease(boolean r100) {
        this.fixSurfaceCallbackIsNullForReuseAfterRelease = r100;
    }

    public final void setFixSurfaceViewCLearWhenBind(boolean r100) {
        this.fixSurfaceViewCLearWhenBind = r100;
    }

    public final void setPrintCallStack(boolean r100) {
        this.printCallStack = r100;
    }

    public final void setResolutionStackEnable(boolean r100) {
        this.resolutionStackEnable = r100;
    }

    public final void setVrEnable(boolean r100) {
        this.vrEnable = r100;
    }

    public PlayerConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r119, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, boolean r219) {
        this.enableRePullStream = r100;
        this.audioFocusRefactor = r101;
        this.printCallStack = r102;
        this.foldScreenAdapt = r103;
        this.foldScreenAdaptV2 = r104;
        this.removeClientWhenStop = r105;
        this.repeatPullStreamFix = r106;
        this.checkStreamDataValid = r110;
        this.fixObserverMemLeak = r111;
        this.fixBackgroundMute = r112;
        this.fixExBlackScreen = r113;
        this.fixResolutionInit = r114;
        this.audioRoomOptimize = r115;
        this.extraSurface = r116;
        this.extraSurfaceRoundedCorner = r117;
        this.preCreateSurface = r118;
        this.bpeaEnable = r119;
        this.fixSearchExtraView = r210;
        this.fgNotResponseAudioFocus = r211;
        this.vrEnable = r212;
        this.enableNetworkUtilsOpt = r213;
        this.enableNetworkOperateCodeOpt = r214;
        this.fixSurfaceViewCLearWhenBind = r215;
        this.fixSurfaceCallbackIsNullForReuseAfterRelease = r216;
        this.enableRePullByStreamId = r217;
        this.resolutionStackEnable = r218;
        this.endLogParamsEnable = r219;
    }

    public /* synthetic */ PlayerConfig(boolean r210, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, boolean r315, boolean r316, boolean r317, boolean r318, boolean r319, boolean r410, boolean r411, boolean r412, boolean r413, boolean r414, boolean r415, boolean r416, boolean r417, boolean r418, boolean r419, boolean r510, boolean r511, boolean r512, boolean r513, boolean r514, boolean r515, int r516, DefaultConstructorMarker r517) {
        if ((r516 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r516 & 2) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r516 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r516 & 8) == 0) goto L17;
        boolean r103 = true;
    L19:
        if ((r516 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r516 & 32) == 0) goto L25;
        boolean r105 = true;
    L27:
        if ((r516 & 64) == 0) goto L29;
        boolean r106 = true;
    L31:
        if ((r516 & 128) == 0) goto L33;
        boolean r110 = true;
    L35:
        if ((r516 & 256) == 0) goto L37;
        boolean r111 = true;
    L39:
        if ((r516 & 512) == 0) goto L41;
        boolean r112 = true;
    L43:
        if ((r516 & 1024) == 0) goto L45;
        boolean r113 = true;
    L47:
        if ((r516 & 2048) == 0) goto L49;
        boolean r114 = true;
    L51:
        if ((r516 & 4096) == 0) goto L53;
        boolean r115 = true;
    L55:
        if ((r516 & 8192) == 0) goto L57;
        boolean r107 = false;
    L59:
        if ((r516 & 16384) == 0) goto L61;
        boolean r108 = true;
    L63:
        if ((r516 & 32768) == 0) goto L65;
        boolean r116 = false;
    L67:
        if ((r516 & 65536) == 0) goto L69;
        boolean r117 = true;
    L71:
        if ((r516 & 131072) == 0) goto L73;
        boolean r118 = true;
    L75:
        if ((r516 & 262144) == 0) goto L77;
        boolean r119 = true;
    L79:
        if ((r516 & 524288) == 0) goto L81;
        boolean r211 = true;
    L83:
        if ((r516 & 1048576) == 0) goto L85;
        boolean r212 = true;
    L87:
        if ((r516 & 2097152) == 0) goto L89;
        boolean r213 = false;
    L91:
        if ((r516 & 4194304) == 0) goto L93;
        boolean r214 = true;
    L95:
        if ((r516 & 8388608) == 0) goto L97;
        boolean r215 = false;
    L99:
        if ((r516 & 16777216) == 0) goto L101;
        boolean r216 = false;
    L103:
        if ((r516 & 33554432) == 0) goto L105;
        boolean r217 = false;
    L107:
        if ((r516 & 67108864) == 0) goto L109;
        boolean r109 = true;
    L110:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r118, r119, r211, r212, r213, r214, r215, r216, r217, r109);
        return;
    L109:
        r109 = r515;
        goto L110
    L105:
        r217 = r514;
        goto L107
    L101:
        r216 = r513;
        goto L103
    L97:
        r215 = r512;
        goto L99
    L93:
        r214 = r511;
        goto L95
    L89:
        r213 = r510;
        goto L91
    L85:
        r212 = r419;
        goto L87
    L81:
        r211 = r418;
        goto L83
    L77:
        r119 = r417;
        goto L79
    L73:
        r118 = r416;
        goto L75
    L69:
        r117 = r415;
        goto L71
    L65:
        r116 = r414;
        goto L67
    L61:
        r108 = r413;
        goto L63
    L57:
        r107 = r412;
        goto L59
    L53:
        r115 = r411;
        goto L55
    L49:
        r114 = r410;
        goto L51
    L45:
        r113 = r319;
        goto L47
    L41:
        r112 = r318;
        goto L43
    L37:
        r111 = r317;
        goto L39
    L33:
        r110 = r316;
        goto L35
    L29:
        r106 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
