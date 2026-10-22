package com.bytedance.android.gamecp.business.download.custommade.bean;

import androidx.camera.video.AudioStats;
import com.bytedance.android.gamecp.business.download.custommade.BeforeInstallGuide;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\b\u0010'\u001a\u00020\u0003H\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u0010\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b%\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014¨\u0006("}, d2 = {"Lcom/bytedance/android/gamecp/business/download/custommade/bean/CustomInstallInfo;", "Ljava/io/Serializable;", "pkgName", "", "gameName", "gameIcon", RuleConditionBean.VERSION_CODE_KEY, "", "versionName", "pkgSize", "", "beforeInstallGuide", "Lcom/bytedance/android/gamecp/business/download/custommade/BeforeInstallGuide;", "inInstallGuide", "Lcom/bytedance/android/gamecp/business/download/custommade/bean/InInstallGuide;", "appName", "isFromOrder", "routeOutCertData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Lcom/bytedance/android/gamecp/business/download/custommade/BeforeInstallGuide;Lcom/bytedance/android/gamecp/business/download/custommade/bean/InInstallGuide;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getBeforeInstallGuide", "()Lcom/bytedance/android/gamecp/business/download/custommade/BeforeInstallGuide;", "getGameIcon", "getGameName", "getInInstallGuide", "()Lcom/bytedance/android/gamecp/business/download/custommade/bean/InInstallGuide;", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPkgName", "getPkgSize", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getRouteOutCertData", "setRouteOutCertData", "getVersionCode", "getVersionName", "toString", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomInstallInfo implements Serializable {
    private String appName;
    private final BeforeInstallGuide beforeInstallGuide;
    private final String gameIcon;
    private final String gameName;
    private final InInstallGuide inInstallGuide;
    private final Integer isFromOrder;
    private final String pkgName;
    private final Double pkgSize;
    private String routeOutCertData;
    private final Integer versionCode;
    private final String versionName;

    public CustomInstallInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public String toString() {
        return "CustomInstallInfo(pkgName = " + this.pkgName + ", gameName = " + this.gameName + ", gameIcon = " + this.gameIcon + ", versionCode = " + this.versionCode + ", versionName = " + this.versionName + ", pkgSize = " + this.pkgSize + ", beforeInstallGuide = " + this.beforeInstallGuide + ", inInstallGuide = " + this.inInstallGuide + ", appName = " + this.appName + ", isFromOrder=" + this.isFromOrder + ", routeOutCertData=" + this.routeOutCertData + ')';
    }

    public final String getAppName() {
        return this.appName;
    }

    public final BeforeInstallGuide getBeforeInstallGuide() {
        return this.beforeInstallGuide;
    }

    public final String getGameIcon() {
        return this.gameIcon;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final InInstallGuide getInInstallGuide() {
        return this.inInstallGuide;
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final Double getPkgSize() {
        return this.pkgSize;
    }

    public final String getRouteOutCertData() {
        return this.routeOutCertData;
    }

    public final Integer getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final Integer isFromOrder() {
        return this.isFromOrder;
    }

    public final void setAppName(String r100) {
        this.appName = r100;
    }

    public final void setRouteOutCertData(String r100) {
        this.routeOutCertData = r100;
    }

    public CustomInstallInfo(String r100, String r101, String r102, Integer r103, String r104, Double r105, BeforeInstallGuide r106, InInstallGuide r107, String r108, Integer r110, String r111) {
        this.pkgName = r100;
        this.gameName = r101;
        this.gameIcon = r102;
        this.versionCode = r103;
        this.versionName = r104;
        this.pkgSize = r105;
        this.beforeInstallGuide = r106;
        this.inInstallGuide = r107;
        this.appName = r108;
        this.isFromOrder = r110;
        this.routeOutCertData = r111;
    }

    public /* synthetic */ CustomInstallInfo(String r110, String r111, String r112, Integer r113, String r114, Double r115, BeforeInstallGuide r210, InInstallGuide r211, String r212, Integer r213, String r214, int r215, DefaultConstructorMarker r216) {
        String r100 = "";
        if ((r215 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r215 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r215 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r215 & 8) == 0) goto L17;
        Integer r104 = 0;
    L19:
        if ((r215 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r215 & 32) == 0) goto L25;
        Double r106 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L26:
        String r116 = null;
        if ((r215 & 64) == 0) goto L29;
        BeforeInstallGuide r107 = null;
    L31:
        if ((r215 & 128) == 0) goto L33;
        InInstallGuide r117 = null;
    L35:
        if ((r215 & 256) != 0) goto L39;
        r100 = r212;
    L39:
        if ((r215 & 512) == 0) goto L41;
        Integer r108 = 0;
    L43:
        if ((r215 & 1024) != 0) goto L46;
        r116 = r214;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r117, r100, r108, r116);
        return;
    L41:
        r108 = r213;
        goto L43
    L33:
        r117 = r211;
        goto L35
    L29:
        r107 = r210;
        goto L31
    L25:
        r106 = r115;
        goto L26
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
