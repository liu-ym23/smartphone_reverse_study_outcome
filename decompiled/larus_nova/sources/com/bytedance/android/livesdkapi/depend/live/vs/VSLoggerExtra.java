package com.bytedance.android.livesdkapi.depend.live.vs;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt2.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u001f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\"\u0010$\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001a\u0010'\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\"\u0010)\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010\u0011R\u001a\u0010,\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R\u001a\u0010/\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011R\u001a\u00102\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011R\u001a\u00105\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000f\"\u0004\b7\u0010\u0011R\u001a\u00108\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\b\"\u0004\b:\u0010\n¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/vs/VSLoggerExtra;", "", "args", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "defaultCameraId", "", "getDefaultCameraId", "()J", "setDefaultCameraId", "(J)V", "enterLiveAdType", "", "kotlin.jvm.PlatformType", "getEnterLiveAdType", "()Ljava/lang/String;", "setEnterLiveAdType", "(Ljava/lang/String;)V", "extensionType", "getExtensionType", "setExtensionType", "fromEpisodeId", "getFromEpisodeId", "setFromEpisodeId", "fromModuleName", "getFromModuleName", "setFromModuleName", "fromOthersHomePageAccountType", "", "getFromOthersHomePageAccountType", "()I", "setFromOthersHomePageAccountType", "(I)V", "fromOthersHomePageUid", "getFromOthersHomePageUid", "setFromOthersHomePageUid", "hasChaseRecord", "getHasChaseRecord", "setHasChaseRecord", "isAutoEnterFromFirstShow", "setAutoEnterFromFirstShow", "liveReason", "getLiveReason", "setLiveReason", "order", "getOrder", "setOrder", "previousPage", "getPreviousPage", "setPreviousPage", "vsDrawerPage", "getVsDrawerPage", "setVsDrawerPage", "vsEnterType", "getVsEnterType", "setVsEnterType", "watchShowDuration", "getWatchShowDuration", "setWatchShowDuration", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLoggerExtra {
    private long defaultCameraId;
    private String enterLiveAdType;
    private String extensionType;
    private String fromEpisodeId;
    private String fromModuleName;
    private int fromOthersHomePageAccountType;
    private String fromOthersHomePageUid;
    private String hasChaseRecord;
    private int isAutoEnterFromFirstShow;
    private String liveReason;
    private String order;
    private String previousPage;
    private String vsDrawerPage;
    private String vsEnterType;
    private long watchShowDuration;

    public final long getDefaultCameraId() {
        return this.defaultCameraId;
    }

    public final String getEnterLiveAdType() {
        return this.enterLiveAdType;
    }

    public final String getExtensionType() {
        return this.extensionType;
    }

    public final String getFromEpisodeId() {
        return this.fromEpisodeId;
    }

    public final String getFromModuleName() {
        return this.fromModuleName;
    }

    public final int getFromOthersHomePageAccountType() {
        return this.fromOthersHomePageAccountType;
    }

    public final String getFromOthersHomePageUid() {
        return this.fromOthersHomePageUid;
    }

    public final String getHasChaseRecord() {
        return this.hasChaseRecord;
    }

    public final String getLiveReason() {
        return this.liveReason;
    }

    public final String getOrder() {
        return this.order;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getVsDrawerPage() {
        return this.vsDrawerPage;
    }

    public final String getVsEnterType() {
        return this.vsEnterType;
    }

    public final long getWatchShowDuration() {
        return this.watchShowDuration;
    }

    public final int isAutoEnterFromFirstShow() {
        return this.isAutoEnterFromFirstShow;
    }

    public VSLoggerExtra(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        String r101 = "";
        this.fromEpisodeId = r100.getString(VSConstants.EXTRA_VS_FROM_EPISODE_ID, "");
        this.fromModuleName = r100.getString(VSConstants.EXTRA_ENTER_VS_FROM_MODULE_NAME, "");
        this.extensionType = r100.getString(VSConstants.EXTRA_ENTER_VS_EXTENSION_TYPE, "");
        this.watchShowDuration = r100.getLong(VSConstants.EXTRA_VS_SHOW_WATCH_RECORD, -1);
        this.hasChaseRecord = r100.getString(VSConstants.EXTRA_VS_HAS_CHASE_RECORD, "");
        this.isAutoEnterFromFirstShow = r100.getInt(VSConstants.EXTRA_VS_AUTO_ENTER_FROM_FIRST_SHOW, -1);
        Bundle r102 = a.b(r100, VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        if (r102 == null) goto L6;
        String r103 = r102.getString("previous_page", "");
        if (r103 == null) goto L6;
    L7:
        this.previousPage = r103;
        Bundle r104 = a.b(r100, VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        if (r104 == null) goto L11;
        String r105 = r104.getString(VSConstants.EXTRA_VS_FROM_OTHERS_HOMEPAGE_UID, "");
        if (r105 == null) goto L11;
    L12:
        this.fromOthersHomePageUid = r105;
        Bundle r106 = a.b(r100, VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        int r107 = 0;
        if (r106 == null) goto L15;
        r107 = r106.getInt(VSConstants.EXTRA_VS_FROM_OTHERS_HOMEPAGE_ACCOUNT_TYPE, 0);
    L15:
        this.fromOthersHomePageAccountType = r107;
        this.enterLiveAdType = r100.getString("enter_from_ad_type", "");
        String r108 = "default";
        if (r100.getString(VSConstants.EXTRA_VS_ENTER_TYPE, null) == null) goto L18;
        r108 = r100.getString(VSConstants.EXTRA_VS_ENTER_TYPE, "default");
    L24:
        this.vsEnterType = r108;
        this.liveReason = r100.getString("live_reason", "");
        Bundle r109 = a.b(r100, VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        if (r109 == null) goto L28;
        String r110 = r109.getString(VSConstants.EXTRA_VS_DRAWER_ORDER, "");
        if (r110 == null) goto L28;
    L29:
        this.order = r110;
        Bundle r111 = a.b(r100, VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        if (r111 == null) goto L35;
        String r112 = r111.getString(VSConstants.EXTRA_VS_DRAWER_PAGE, "");
        if (r112 == null) goto L35;
        r101 = r112;
    L35:
        this.vsDrawerPage = r101;
        this.defaultCameraId = r100.getLong(VSConstants.EXTRA_VS_CAMERA_ID, 0);
        return;
    L28:
        r110 = "";
        goto L29
    L18:
        Bundle r113 = a.b(r100, VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        if (r113 == null) goto L24;
        String r114 = r113.getString(VSConstants.EXTRA_VS_ENTER_TYPE, "default");
        if (r114 == null) goto L24;
        r108 = r114;
    L11:
        r105 = "";
    L6:
        r103 = "";
        goto L7
    }

    public final void setAutoEnterFromFirstShow(int r100) {
        this.isAutoEnterFromFirstShow = r100;
    }

    public final void setDefaultCameraId(long r100) {
        this.defaultCameraId = r100;
    }

    public final void setEnterLiveAdType(String r100) {
        this.enterLiveAdType = r100;
    }

    public final void setExtensionType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extensionType = r100;
    }

    public final void setFromEpisodeId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fromEpisodeId = r100;
    }

    public final void setFromModuleName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fromModuleName = r100;
    }

    public final void setFromOthersHomePageAccountType(int r100) {
        this.fromOthersHomePageAccountType = r100;
    }

    public final void setFromOthersHomePageUid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fromOthersHomePageUid = r100;
    }

    public final void setHasChaseRecord(String r100) {
        this.hasChaseRecord = r100;
    }

    public final void setLiveReason(String r100) {
        this.liveReason = r100;
    }

    public final void setOrder(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.order = r100;
    }

    public final void setPreviousPage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.previousPage = r100;
    }

    public final void setVsDrawerPage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.vsDrawerPage = r100;
    }

    public final void setVsEnterType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.vsEnterType = r100;
    }

    public final void setWatchShowDuration(long r100) {
        this.watchShowDuration = r100;
    }
}
