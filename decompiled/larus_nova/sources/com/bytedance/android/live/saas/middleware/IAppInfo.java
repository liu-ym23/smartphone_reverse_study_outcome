package com.bytedance.android.live.saas.middleware;

import com.heytap.mcssdk.constant.b;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\u0005H&J\b\u0010\u0014\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0003H&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "", "apiHost", "", "appIcon", "", "appId", "appName", "boeLane", "channel", "clientKey", "devicesId", "hostAppId", "isBoe", "", "isDebug", "isPPE", "ppeLane", b.C, "updateVersionCode", RuleConditionBean.VERSION_CODE_KEY, "versionName", "Companion", "middleware_release"}, k = 1, mv = {1, 4, 3})
public interface IAppInfo {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/IAppInfo$Companion;", "", "()V", "STUB", "Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "getSTUB", "()Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "middleware_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final IAppInfo STUB = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            STUB = new IAppInfo$Companion$STUB$1();
        }

        public final IAppInfo getSTUB() {
            return STUB;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    String apiHost();

    int appIcon();

    int appId();

    String appName();

    String boeLane();

    String channel();

    String clientKey();

    String devicesId();

    String hostAppId();

    boolean isBoe();

    boolean isDebug();

    boolean isPPE();

    String ppeLane();

    int sdkVersion();

    int updateVersionCode();

    int versionCode();

    String versionName();
}
