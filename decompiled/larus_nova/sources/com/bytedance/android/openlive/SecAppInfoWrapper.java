package com.bytedance.android.openlive;

import android.content.Context;
import com.bytedance.android.live.core.utils.SystemPropertiesUtil;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.heytap.mcssdk.constant.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\tH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0011\u001a\u00020\tH\u0096\u0001J\t\u0010\u0012\u001a\u00020\tH\u0096\u0001J\b\u0010\u0013\u001a\u00020\tH\u0016J\t\u0010\u0014\u001a\u00020\tH\u0096\u0001J\t\u0010\u0015\u001a\u00020\tH\u0096\u0001J\t\u0010\u0016\u001a\u00020\tH\u0096\u0001J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\t\u0010\u0019\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u001a\u001a\u00020\tH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u001e\u001a\u00020\tH\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/openlive/SecAppInfoWrapper;", "Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "appInfo", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Lcom/bytedance/android/live/saas/middleware/IAppInfo;Landroid/content/Context;)V", "debugValueByPass", "", "propChannel", "", "propIsBoe", "Ljava/lang/Boolean;", "propIsDebug", "apiHost", "appIcon", "", "appId", "appName", "boeLane", "channel", "clientKey", "devicesId", "hostAppId", "isBoe", "isDebug", "isPPE", "ppeLane", b.C, "updateVersionCode", RuleConditionBean.VERSION_CODE_KEY, "versionName", "live-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class SecAppInfoWrapper implements IAppInfo {
    private final IAppInfo appInfo;
    private boolean debugValueByPass;
    private String propChannel;
    private Boolean propIsBoe;
    private Boolean propIsDebug;

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String apiHost() {
        return this.appInfo.apiHost();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int appIcon() {
        return this.appInfo.appIcon();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int appId() {
        return this.appInfo.appId();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String appName() {
        return this.appInfo.appName();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String boeLane() {
        return this.appInfo.boeLane();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String clientKey() {
        return this.appInfo.clientKey();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String devicesId() {
        return this.appInfo.devicesId();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String hostAppId() {
        return this.appInfo.hostAppId();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public boolean isPPE() {
        return this.appInfo.isPPE();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String ppeLane() {
        return this.appInfo.ppeLane();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int sdkVersion() {
        return this.appInfo.sdkVersion();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int updateVersionCode() {
        return this.appInfo.updateVersionCode();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int versionCode() {
        return this.appInfo.versionCode();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String versionName() {
        return this.appInfo.versionName();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String channel() {
        String r100 = this.propChannel;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.debugValueByPass == true) goto L12;
        String r101 = this.appInfo.channel();
        if (Intrinsics.areEqual(r101, "local_host") == false) goto L13;
        return "host";
    L13:
        return r101;
    L12:
        return this.appInfo.channel();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public boolean isBoe() {
        Boolean r100 = this.propIsBoe;
        if (r100 == null) goto L7;
        return r100.booleanValue();
    L7:
        if (this.debugValueByPass == true) goto L11;
        return false;
    L11:
        return this.appInfo.isBoe();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public boolean isDebug() {
        Boolean r100 = this.propIsDebug;
        if (r100 == null) goto L7;
        return r100.booleanValue();
    L7:
        if (this.debugValueByPass == true) goto L11;
        return false;
    L11:
        return this.appInfo.isDebug();
    }

    public SecAppInfoWrapper(IAppInfo r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "appInfo");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.appInfo = r100;
        this.debugValueByPass = SetsKt.setOf(new String[]{"com.example.livesaasdemo", "com.example.live.zeus.demo", "com.example.live.mira.demo", "com.bytedance.dpdemo"}).contains(r101.getPackageName());
        String r102 = SystemPropertiesUtil.getProp("debug.ttlive.debug.enable");
        boolean r103 = true;
        String r104 = null;
        if (r102 != null) goto L5;
    L12:
        Boolean r105 = null;
    L13:
        this.propIsDebug = r105;
        String r106 = SystemPropertiesUtil.getProp("debug.ttlive.boe.enable");
        if (r106 != null) goto L16;
    L23:
        Boolean r107 = null;
    L24:
        this.propIsBoe = r107;
        String r108 = SystemPropertiesUtil.getProp("debug.ttlive.channel");
        if (r108 != null) goto L27;
    L33:
        this.propChannel = r104;
        return;
    L27:
        if (r108.length() == 0) goto L30;
        r103 = false;
    L30:
        if (r103 == true) goto L33;
        r104 = r108;
        goto L33
    L16:
        if (r106.length() != 0) goto L18;
        boolean r109 = true;
    L19:
        if (r109 == false) goto L21;
        r106 = null;
    L21:
        if (r106 == null) goto L23;
        r107 = Boolean.valueOf(Boolean.parseBoolean(r106));
        goto L24
    L18:
        r109 = false;
        goto L19
    L5:
        if (r102.length() != 0) goto L7;
        boolean r110 = true;
    L8:
        if (r110 == false) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        r105 = Boolean.valueOf(Boolean.parseBoolean(r102));
        goto L13
    L7:
        r110 = false;
        goto L8
    }
}
