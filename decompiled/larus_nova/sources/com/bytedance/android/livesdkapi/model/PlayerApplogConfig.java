package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\u0002\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerApplogConfig;", "", "anchorLogUseAppLog", "", "audienceLogUseAppLog", "audiencePlayerInternalUseAppLog", "audiencePlayerInternalUseAppLogEventMask", "", "streamLogUseHostAppLog", "playerLogUseHostAppLog", "playerLogPackageInfoOpt", "extraLivePlayerParamsWhiteList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(ZZZJZZZLjava/util/ArrayList;)V", "getAnchorLogUseAppLog", "()Z", "getAudienceLogUseAppLog", "getAudiencePlayerInternalUseAppLog", "setAudiencePlayerInternalUseAppLog", "(Z)V", "getAudiencePlayerInternalUseAppLogEventMask", "()J", "setAudiencePlayerInternalUseAppLogEventMask", "(J)V", "getExtraLivePlayerParamsWhiteList", "()Ljava/util/ArrayList;", "setExtraLivePlayerParamsWhiteList", "(Ljava/util/ArrayList;)V", "getPlayerLogPackageInfoOpt", "setPlayerLogPackageInfoOpt", "getPlayerLogUseHostAppLog", "getStreamLogUseHostAppLog", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerApplogConfig {

    @SerializedName("anchor_monitor_log_use_app_log")
    private final boolean anchorLogUseAppLog;

    @SerializedName("audience_monitor_log_use_app_log")
    private final boolean audienceLogUseAppLog;

    @SerializedName("audience_player_internal_use_app_log")
    private boolean audiencePlayerInternalUseAppLog;

    @SerializedName("audience_player_internal_use_app_log_event_mask")
    private long audiencePlayerInternalUseAppLogEventMask;

    @SerializedName("extra_live_player_params_white_list")
    private ArrayList<String> extraLivePlayerParamsWhiteList;

    @SerializedName("player_log_package_info_opt")
    private boolean playerLogPackageInfoOpt;

    @SerializedName("player_log_use_host_app_log")
    private final boolean playerLogUseHostAppLog;

    @SerializedName("stream_log_use_host_app_log")
    private final boolean streamLogUseHostAppLog;

    public PlayerApplogConfig() {
        this(false, false, false, 0, false, false, false, null, 255, null);
    }

    public final boolean getAnchorLogUseAppLog() {
        return this.anchorLogUseAppLog;
    }

    public final boolean getAudienceLogUseAppLog() {
        return this.audienceLogUseAppLog;
    }

    public final boolean getAudiencePlayerInternalUseAppLog() {
        return this.audiencePlayerInternalUseAppLog;
    }

    public final long getAudiencePlayerInternalUseAppLogEventMask() {
        return this.audiencePlayerInternalUseAppLogEventMask;
    }

    public final ArrayList<String> getExtraLivePlayerParamsWhiteList() {
        return this.extraLivePlayerParamsWhiteList;
    }

    public final boolean getPlayerLogPackageInfoOpt() {
        return this.playerLogPackageInfoOpt;
    }

    public final boolean getPlayerLogUseHostAppLog() {
        return this.playerLogUseHostAppLog;
    }

    public final boolean getStreamLogUseHostAppLog() {
        return this.streamLogUseHostAppLog;
    }

    public final void setAudiencePlayerInternalUseAppLog(boolean r100) {
        this.audiencePlayerInternalUseAppLog = r100;
    }

    public final void setAudiencePlayerInternalUseAppLogEventMask(long r100) {
        this.audiencePlayerInternalUseAppLogEventMask = r100;
    }

    public final void setExtraLivePlayerParamsWhiteList(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraLivePlayerParamsWhiteList = r100;
    }

    public final void setPlayerLogPackageInfoOpt(boolean r100) {
        this.playerLogPackageInfoOpt = r100;
    }

    public PlayerApplogConfig(boolean r100, boolean r101, boolean r102, long r103, boolean r104, boolean r105, boolean r106, ArrayList<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "extraLivePlayerParamsWhiteList");
        this.anchorLogUseAppLog = r100;
        this.audienceLogUseAppLog = r101;
        this.audiencePlayerInternalUseAppLog = r102;
        this.audiencePlayerInternalUseAppLogEventMask = r103;
        this.streamLogUseHostAppLog = r104;
        this.playerLogUseHostAppLog = r105;
        this.playerLogPackageInfoOpt = r106;
        this.extraLivePlayerParamsWhiteList = r110;
    }

    public /* synthetic */ PlayerApplogConfig(boolean r110, boolean r111, boolean r112, long r113, boolean r114, boolean r115, boolean r116, ArrayList r117, int r210, DefaultConstructorMarker r211) {
        boolean r100 = false;
        if ((r210 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r210 & 2) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r210 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r104 = 0;
    L19:
        if ((r210 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r210 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r210 & 128) == 0) goto L33;
        ArrayList r107 = new ArrayList();
    L34:
        this(r101, r102, r103, r104, r105, r106, r100, r107);
        return;
    L33:
        r107 = r117;
        goto L34
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
