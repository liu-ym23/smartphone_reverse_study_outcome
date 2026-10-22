package com.bytedance.android.openlive.inner;

import com.bytedance.android.live.saas.middleware.alog.ALogConfig;
import com.bytedance.android.live.saas.middleware.applog.AppLogConfig;
import com.bytedance.android.live.saas.middleware.baselib.BaseLibConfig;
import com.bytedance.android.live.saas.middleware.fresco.FrescoConfig;
import com.bytedance.android.live.saas.middleware.monitor.MonitorConfig;
import com.bytedance.android.live.saas.middleware.network.NetworkConfigSimple;
import com.bytedance.android.live.saas.middleware.npth.NpthConfig;
import com.bytedance.android.live.saas.middleware.sec.SecConfig;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0017J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0017J\b\u0010\u000e\u001a\u00020\u000fH\u0017J\b\u0010\u0010\u001a\u00020\u0011H\u0017¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/openlive/inner/IMiddlewareParams;", "", "getALogConfig", "Lcom/bytedance/android/live/saas/middleware/alog/ALogConfig;", "getAppLogConfig", "Lcom/bytedance/android/live/saas/middleware/applog/AppLogConfig;", "getBaseLibConfig", "Lcom/bytedance/android/live/saas/middleware/baselib/BaseLibConfig;", "getFrescoConfig", "Lcom/bytedance/android/live/saas/middleware/fresco/FrescoConfig;", "getMonitorConfig", "Lcom/bytedance/android/live/saas/middleware/monitor/MonitorConfig;", "getNetworkConfig", "Lcom/bytedance/android/live/saas/middleware/network/NetworkConfigSimple;", "getNpthConfig", "Lcom/bytedance/android/live/saas/middleware/npth/NpthConfig;", "getSecConfig", "Lcom/bytedance/android/live/saas/middleware/sec/SecConfig;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareParams {

    /* JADX INFO: renamed from: com.bytedance.android.openlive.inner.IMiddlewareParams$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ALogConfig $default$getALogConfig(IMiddlewareParams r100) {
            return new ALogConfig(null, true);
        }

        public static BaseLibConfig $default$getBaseLibConfig(IMiddlewareParams r100) {
            return new BaseLibConfig(null, false, 2, null);
        }

        @Deprecated(message = "Fresco使用宿主实现，不建议修改")
        public static FrescoConfig $default$getFrescoConfig(IMiddlewareParams r100) {
            return new FrescoConfig(false, false, null, 4, null);
        }

        public static MonitorConfig $default$getMonitorConfig(IMiddlewareParams r100) {
            return new MonitorConfig(null, true, false, null, true, 12, null);
        }

        @Deprecated(message = "网络库使用宿主实现，不建议修改")
        public static NetworkConfigSimple $default$getNetworkConfig(IMiddlewareParams r100) {
            return new NetworkConfigSimple(false, true, false, null);
        }

        @Deprecated(message = "崩溃上报使用宿主实现，不建议修改")
        public static NpthConfig $default$getNpthConfig(IMiddlewareParams r100) {
            return new NpthConfig(false, false, null, null, 12, null);
        }

        @Deprecated(message = "安全SDK使用宿主实现，不建议修改")
        public static SecConfig $default$getSecConfig(IMiddlewareParams r100) {
            return new SecConfig(null, false, false, null, null, 24, null);
        }

        public static /* synthetic */ ALogConfig access$getALogConfig$jd(IMiddlewareParams r100) {
            return $default$getALogConfig(r100);
        }

        public static /* synthetic */ BaseLibConfig access$getBaseLibConfig$jd(IMiddlewareParams r100) {
            return $default$getBaseLibConfig(r100);
        }

        public static /* synthetic */ FrescoConfig access$getFrescoConfig$jd(IMiddlewareParams r100) {
            return $default$getFrescoConfig(r100);
        }

        public static /* synthetic */ MonitorConfig access$getMonitorConfig$jd(IMiddlewareParams r100) {
            return $default$getMonitorConfig(r100);
        }

        public static /* synthetic */ NetworkConfigSimple access$getNetworkConfig$jd(IMiddlewareParams r100) {
            return $default$getNetworkConfig(r100);
        }

        public static /* synthetic */ NpthConfig access$getNpthConfig$jd(IMiddlewareParams r100) {
            return $default$getNpthConfig(r100);
        }

        public static /* synthetic */ SecConfig access$getSecConfig$jd(IMiddlewareParams r100) {
            return $default$getSecConfig(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static ALogConfig getALogConfig(IMiddlewareParams r100) {
            return CC.access$getALogConfig$jd(r100);
        }

        public static BaseLibConfig getBaseLibConfig(IMiddlewareParams r100) {
            return CC.access$getBaseLibConfig$jd(r100);
        }

        @Deprecated(message = "Fresco使用宿主实现，不建议修改")
        public static FrescoConfig getFrescoConfig(IMiddlewareParams r100) {
            return CC.access$getFrescoConfig$jd(r100);
        }

        public static MonitorConfig getMonitorConfig(IMiddlewareParams r100) {
            return CC.access$getMonitorConfig$jd(r100);
        }

        @Deprecated(message = "网络库使用宿主实现，不建议修改")
        public static NetworkConfigSimple getNetworkConfig(IMiddlewareParams r100) {
            return CC.access$getNetworkConfig$jd(r100);
        }

        @Deprecated(message = "崩溃上报使用宿主实现，不建议修改")
        public static NpthConfig getNpthConfig(IMiddlewareParams r100) {
            return CC.access$getNpthConfig$jd(r100);
        }

        @Deprecated(message = "安全SDK使用宿主实现，不建议修改")
        public static SecConfig getSecConfig(IMiddlewareParams r100) {
            return CC.access$getSecConfig$jd(r100);
        }
    }

    ALogConfig getALogConfig();

    AppLogConfig getAppLogConfig();

    BaseLibConfig getBaseLibConfig();

    @Deprecated(message = "Fresco使用宿主实现，不建议修改")
    FrescoConfig getFrescoConfig();

    MonitorConfig getMonitorConfig();

    @Deprecated(message = "网络库使用宿主实现，不建议修改")
    NetworkConfigSimple getNetworkConfig();

    @Deprecated(message = "崩溃上报使用宿主实现，不建议修改")
    NpthConfig getNpthConfig();

    @Deprecated(message = "安全SDK使用宿主实现，不建议修改")
    SecConfig getSecConfig();
}
