package com.bytedance.android.openlive;

import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.heytap.mcssdk.constant.b;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/openlive/MiddlewareAppInfo;", "Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "appContext", "Lcom/bytedance/android/openlive/LiveContext;", "(Lcom/bytedance/android/openlive/LiveContext;)V", "getAppContext", "()Lcom/bytedance/android/openlive/LiveContext;", "apiHost", "", "appIcon", "", "appId", "appName", "boeLane", "channel", "clientKey", "devicesId", "hostAppId", "isBoe", "", "isDebug", "isPPE", "ppeLane", b.C, "updateVersionCode", RuleConditionBean.VERSION_CODE_KEY, "versionName", "live-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class MiddlewareAppInfo implements IAppInfo {
    private final LiveContext appContext;

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String boeLane() {
        return "";
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public boolean isPPE() {
        return false;
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String ppeLane() {
        return "";
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int sdkVersion() {
        return 4210;
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int updateVersionCode() {
        return 42100000;
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String apiHost() {
        if (this.appContext.isBoe() == false) goto L5;
        return "webcast-open.byted.org";
    L5:
        return "webcast-open.douyin.com";
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int appIcon() {
        return this.appContext.getAppIcon();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int appId() {
        return this.appContext.getAid();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String appName() {
        return this.appContext.getAppName();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String channel() {
        return this.appContext.getChannel();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String clientKey() {
        return this.appContext.getClientKey();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String hostAppId() {
        return this.appContext.getGeneralAppId();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public boolean isBoe() {
        return this.appContext.isBoe();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public boolean isDebug() {
        return this.appContext.getDebug();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public int versionCode() {
        return this.appContext.getVersionCode();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String versionName() {
        return this.appContext.getVersion();
    }

    @Override // com.bytedance.android.live.saas.middleware.IAppInfo
    public String devicesId() {
        IAppLog r100 = BDLiveSdk.appLog();
        if (r100 == null) goto L6;
        String r101 = r100.getDid();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final LiveContext getAppContext() {
        return this.appContext;
    }

    public MiddlewareAppInfo(LiveContext r100) {
        Intrinsics.checkNotNullParameter(r100, "appContext");
        this.appContext = r100;
    }
}
