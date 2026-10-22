package com.bytedance.android.live.saas.middleware;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.dy.saas.utuid.d;
import com.bytedance.android.live.saas.middleware.alog.ALogConfig;
import com.bytedance.android.live.saas.middleware.alog.ALogProxy;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;
import com.bytedance.android.live.saas.middleware.applog.AppLogConfig;
import com.bytedance.android.live.saas.middleware.applog.AppLogProxy;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.base.FunctionFactory;
import com.bytedance.android.live.saas.middleware.baselib.BaseLibConfig;
import com.bytedance.android.live.saas.middleware.baselib.BaseLibProxy;
import com.bytedance.android.live.saas.middleware.fresco.FrescoConfig;
import com.bytedance.android.live.saas.middleware.fresco.FrescoProxy;
import com.bytedance.android.live.saas.middleware.login.ILogin;
import com.bytedance.android.live.saas.middleware.login.LoginConfig;
import com.bytedance.android.live.saas.middleware.login.LoginProxy;
import com.bytedance.android.live.saas.middleware.middlelayer.MiddleLayerConfig;
import com.bytedance.android.live.saas.middleware.middlelayer.MiddleLayerProxy;
import com.bytedance.android.live.saas.middleware.monitor.IMonitorReport;
import com.bytedance.android.live.saas.middleware.monitor.MonitorConfig;
import com.bytedance.android.live.saas.middleware.monitor.MonitorProxy;
import com.bytedance.android.live.saas.middleware.network.NetworkConfig;
import com.bytedance.android.live.saas.middleware.network.NetworkProxy;
import com.bytedance.android.live.saas.middleware.npth.INpthHelper;
import com.bytedance.android.live.saas.middleware.npth.NpthConfig;
import com.bytedance.android.live.saas.middleware.npth.NpthProxy;
import com.bytedance.android.live.saas.middleware.sec.ISecSdk;
import com.bytedance.android.live.saas.middleware.sec.SecConfig;
import com.bytedance.android.live.saas.middleware.sec.SecProxy;
import com.bytedance.android.live.saas.middleware.utuid.UtUidProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ry.e;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0002+*B\t\b\u0002¢\u0006\u0004\b(\u0010)J#\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006RS\u0010\n\u001a>\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u0007j\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00020\u00010\b`\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR)\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "cls", "getFunctionImp", "(Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/util/HashMap;", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "Lkotlin/collections/HashMap;", "mFunctionMap", "Ljava/util/HashMap;", "getMFunctionMap", "()Ljava/util/HashMap;", "", "mTaskList", "Ljava/util/List;", "getMTaskList", "()Ljava/util/List;", "Lcom/bytedance/android/live/saas/middleware/applog/AppLogProxy;", "mApplog", "Lcom/bytedance/android/live/saas/middleware/applog/AppLogProxy;", "getMApplog", "()Lcom/bytedance/android/live/saas/middleware/applog/AppLogProxy;", "setMApplog", "(Lcom/bytedance/android/live/saas/middleware/applog/AppLogProxy;)V", "Lry/e;", "hostPermission", "Lry/e;", "getHostPermission", "()Lry/e;", "setHostPermission", "(Lry/e;)V", "", "disableBroadcast", "Z", "getDisableBroadcast", "()Z", "setDisableBroadcast", "(Z)V", "<init>", "()V", "Companion", "Builder", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class BDLiveSdkConfig {
    public static final Companion Companion = null;
    private static final BDLiveSdkConfig STUB = null;
    private static final String TAG = null;
    private static String generalAppId;
    private boolean disableBroadcast;
    private e hostPermission;
    public AppLogProxy mApplog;
    private final HashMap<Class<?>, BaseFunction<?, ? extends Object>> mFunctionMap;
    private final List<BaseFunction<?, ? extends Object>> mTaskList;

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b7\u00108J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001e\u001a\u00020\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig$Builder;", "", "", "disableBroadcast", "setDisableBroadcast", "Lry/e;", "hostPermission", "setHostPermission", "Lcom/bytedance/android/live/saas/middleware/login/LoginConfig;", "config", "accountConfig", "Lcom/bytedance/android/live/saas/middleware/applog/AppLogConfig;", "appLogConfig", "Lcom/bytedance/android/live/saas/middleware/alog/ALogConfig;", "aLogConfig", "Lcom/bytedance/android/live/saas/middleware/network/NetworkConfig;", "networkConfig", "Lcom/bytedance/android/live/saas/middleware/monitor/MonitorConfig;", "monitorConfig", "Lcom/bytedance/android/live/saas/middleware/npth/NpthConfig;", "npthConfig", "Lcom/bytedance/android/dy/saas/utuid/e;", "utUidConfig", "Lcom/bytedance/android/live/saas/middleware/fresco/FrescoConfig;", "frescoConfig", "Lcom/bytedance/android/live/saas/middleware/sec/SecConfig;", "secConfig", "Lcom/bytedance/android/live/saas/middleware/baselib/BaseLibConfig;", "baseLibConfig", "Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;", "build", "mLoginConfig", "Lcom/bytedance/android/live/saas/middleware/login/LoginConfig;", "mAppLogConfig", "Lcom/bytedance/android/live/saas/middleware/applog/AppLogConfig;", "mNetworkConfig", "Lcom/bytedance/android/live/saas/middleware/network/NetworkConfig;", "mALogConfig", "Lcom/bytedance/android/live/saas/middleware/alog/ALogConfig;", "mMonitorConfig", "Lcom/bytedance/android/live/saas/middleware/monitor/MonitorConfig;", "mNpthConfig", "Lcom/bytedance/android/live/saas/middleware/npth/NpthConfig;", "mUtUidConfig", "Lcom/bytedance/android/dy/saas/utuid/e;", "mFrescoConfig", "Lcom/bytedance/android/live/saas/middleware/fresco/FrescoConfig;", "mSecConfig", "Lcom/bytedance/android/live/saas/middleware/sec/SecConfig;", "mBaseLibConfig", "Lcom/bytedance/android/live/saas/middleware/baselib/BaseLibConfig;", "mHostPermission", "Lry/e;", "mDisableBroadcast", "Z", "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {
        private ALogConfig mALogConfig;
        private AppLogConfig mAppLogConfig;
        private BaseLibConfig mBaseLibConfig;
        private boolean mDisableBroadcast;
        private FrescoConfig mFrescoConfig;
        private e mHostPermission;
        private LoginConfig mLoginConfig;
        private MonitorConfig mMonitorConfig;
        private NetworkConfig mNetworkConfig;
        private NpthConfig mNpthConfig;
        private SecConfig mSecConfig;
        private com.bytedance.android.dy.saas.utuid.e mUtUidConfig;

        public Builder() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final BDLiveSdkConfig build() {
            Object[] r100 = 0;
            Object[] r101 = 0;
            BDLiveSdkConfig r102 = new BDLiveSdkConfig(null);
            boolean r103 = false;
            if (this.mBaseLibConfig != null) goto L5;
            BDLiveSdkConfig.Companion.getTAG();
            Object[] r104 = r101 == true ? 1 : 0;
            this.mBaseLibConfig = new BaseLibConfig(r104, r103, 2, r100 == true ? 1 : 0);
        L5:
            FunctionFactory r105 = FunctionFactory.INSTANCE;
            BaseLibConfig r106 = this.mBaseLibConfig;
            Intrinsics.checkNotNull(r106);
            BaseFunction<?, ? extends Object> r107 = r105.provide(r106, new BaseLibProxy());
            if (r107 == null) goto L9;
            r102.getMTaskList().add(r107);
        L9:
            if (this.mNetworkConfig != null) goto L11;
            BDLiveSdkConfig.Companion.getTAG();
            this.mNetworkConfig = new NetworkConfig(null, false, false, false, null, 28, null);
        L11:
            NetworkConfig r108 = this.mNetworkConfig;
            Intrinsics.checkNotNull(r108);
            BaseFunction<?, ? extends Object> r109 = r105.provide(r108, new NetworkProxy());
            r102.getMTaskList().add(r109);
            if (this.mLoginConfig != null) goto L14;
            BDLiveSdkConfig.Companion.getTAG();
            this.mLoginConfig = new LoginConfig(null);
        L14:
            LoginConfig r110 = this.mLoginConfig;
            Intrinsics.checkNotNull(r110);
            BaseFunction<?, ? extends Object> r111 = r105.provide(r110, new LoginProxy());
            r102.getMFunctionMap().put(ILogin.class, r111);
            r102.getMTaskList().add(r111);
            if (this.mALogConfig != null) goto L17;
            BDLiveSdkConfig.Companion.getTAG();
            this.mALogConfig = new ALogConfig(null, false);
        L17:
            ALogConfig r112 = this.mALogConfig;
            Intrinsics.checkNotNull(r112);
            BaseFunction<?, ? extends Object> r113 = r105.provide(r112, new ALogProxy());
            r102.getMFunctionMap().put(ILogProtocol.class, r113);
            r102.getMTaskList().add(r113);
            if (this.mAppLogConfig != null) goto L20;
            BDLiveSdkConfig.Companion.getTAG();
            this.mAppLogConfig = new AppLogConfig(null, false);
        L20:
            AppLogConfig r114 = this.mAppLogConfig;
            Intrinsics.checkNotNull(r114);
            BaseFunction<?, ? extends Object> r115 = r105.provide(r114, new AppLogProxy());
            r102.getMFunctionMap().put(IAppLog.class, r115);
            r102.getMTaskList().add(r115);
            if (this.mMonitorConfig != null) goto L23;
            BDLiveSdkConfig.Companion.getTAG();
            this.mMonitorConfig = new MonitorConfig(null, false, false, null, false, 28, null);
        L23:
            MonitorConfig r116 = this.mMonitorConfig;
            Intrinsics.checkNotNull(r116);
            BaseFunction<?, ? extends Object> r117 = r105.provide(r116, new MonitorProxy());
            r102.getMFunctionMap().put(IMonitorReport.class, r117);
            r102.getMTaskList().add(r117);
            if (this.mNpthConfig != null) goto L26;
            BDLiveSdkConfig.Companion.getTAG();
            this.mNpthConfig = new NpthConfig(false, false, null, null, 12, null);
        L26:
            NpthConfig r118 = this.mNpthConfig;
            Intrinsics.checkNotNull(r118);
            BaseFunction<?, ? extends Object> r119 = r105.provide(r118, new NpthProxy());
            r102.getMFunctionMap().put(INpthHelper.class, r119);
            r102.getMTaskList().add(r119);
            if (this.mUtUidConfig != null) goto L29;
            BDLiveSdkConfig.Companion.getTAG();
            this.mUtUidConfig = new com.bytedance.android.dy.saas.utuid.e(false, "", "", "", "", "", "");
        L29:
            com.bytedance.android.dy.saas.utuid.e r120 = this.mUtUidConfig;
            Intrinsics.checkNotNull(r120);
            BaseFunction<?, ? extends Object> r121 = r105.provide(r120, new UtUidProxy());
            r102.getMFunctionMap().put(d.class, r121);
            r102.getMTaskList().add(r121);
            BaseFunction<?, ? extends Object> r122 = r105.provide(new MiddleLayerConfig(), new MiddleLayerProxy());
            r102.getMTaskList().add(r122);
            if (this.mFrescoConfig != null) goto L32;
            BDLiveSdkConfig.Companion.getTAG();
            this.mFrescoConfig = new FrescoConfig(false, false, null, 4, null);
        L32:
            FrescoConfig r123 = this.mFrescoConfig;
            Intrinsics.checkNotNull(r123);
            BaseFunction<?, ? extends Object> r124 = r105.provide(r123, new FrescoProxy());
            r102.getMTaskList().add(r124);
            if (this.mSecConfig != null) goto L35;
            BDLiveSdkConfig.Companion.getTAG();
            this.mSecConfig = new SecConfig(null, false, false, null, null, 24, null);
        L35:
            SecConfig r125 = this.mSecConfig;
            if (r125 != null) goto L38;
        L40:
            SecConfig r126 = this.mSecConfig;
            Intrinsics.checkNotNull(r126);
            BaseFunction<?, ? extends Object> r127 = r105.provide(r126, new SecProxy());
            r102.getMFunctionMap().put(ISecSdk.class, r127);
            r102.getMTaskList().add(r127);
            r102.setHostPermission(this.mHostPermission);
            r102.setDisableBroadcast(this.mDisableBroadcast);
            return r102;
        L38:
            if (r125.isToBVersion() == true) goto L40;
            r125.getStandalone();
            goto L40
        }

        public final Builder aLogConfig(ALogConfig r100) {
            this.mALogConfig = r100;
            return this;
        }

        public final Builder accountConfig(LoginConfig r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.mLoginConfig = r100;
            return this;
        }

        public final Builder appLogConfig(AppLogConfig r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.mAppLogConfig = r100;
            return this;
        }

        public final Builder baseLibConfig(BaseLibConfig r100) {
            this.mBaseLibConfig = r100;
            return this;
        }

        public final Builder frescoConfig(FrescoConfig r100) {
            this.mFrescoConfig = r100;
            return this;
        }

        public final Builder monitorConfig(MonitorConfig r100) {
            this.mMonitorConfig = r100;
            return this;
        }

        public final Builder networkConfig(NetworkConfig r100) {
            this.mNetworkConfig = r100;
            return this;
        }

        public final Builder npthConfig(NpthConfig r100) {
            this.mNpthConfig = r100;
            return this;
        }

        public final Builder secConfig(SecConfig r100) {
            this.mSecConfig = r100;
            return this;
        }

        public final Builder setDisableBroadcast(boolean r100) {
            this.mDisableBroadcast = r100;
            return this;
        }

        public final Builder setHostPermission(e r100) {
            this.mHostPermission = r100;
            return this;
        }

        public final Builder utUidConfig(com.bytedance.android.dy.saas.utuid.e r100) {
            this.mUtUidConfig = r100;
            if (r100 == null) goto L7;
            String r101 = r100.f42646c;
            if (r101 == null) goto L7;
            Companion.access$setGeneralAppId$p(BDLiveSdkConfig.Companion, r101);
        L7:
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig$Companion;", "", "()V", "STUB", "Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;", "getSTUB", "()Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;", "TAG", "", "getTAG", "()Ljava/lang/String;", "<set-?>", "generalAppId", "getGeneralAppId", "setGeneralAppId", "(Ljava/lang/String;)V", "middleware_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final String getGeneralAppId() {
            return BDLiveSdkConfig.access$getGeneralAppId$cp();
        }

        public final BDLiveSdkConfig getSTUB() {
            return BDLiveSdkConfig.access$getSTUB$cp();
        }

        public final String getTAG() {
            return BDLiveSdkConfig.access$getTAG$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static final /* synthetic */ String access$getGeneralAppId$p(Companion r100) {
            return r100.getGeneralAppId();
        }

        private final void setGeneralAppId(String r100) {
            BDLiveSdkConfig.access$setGeneralAppId$cp(r100);
        }

        public static final /* synthetic */ void access$setGeneralAppId$p(Companion r100, String r101) {
            r100.setGeneralAppId(r101);
        }
    }

    static {
        Companion = new Companion(null);
        TAG = "BDLiveSdkConfig";
        STUB = new BDLiveSdkConfig();
        generalAppId = "";
    }

    public final AppLogProxy getMApplog() {
        AppLogProxy r100 = this.mApplog;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mApplog");
    L5:
        return r100;
    }

    private BDLiveSdkConfig() {
        this.mFunctionMap = new HashMap();
        this.mTaskList = new ArrayList();
    }

    public static final /* synthetic */ String access$getGeneralAppId$cp() {
        return generalAppId;
    }

    public static final /* synthetic */ BDLiveSdkConfig access$getSTUB$cp() {
        return STUB;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final boolean getDisableBroadcast() {
        return this.disableBroadcast;
    }

    public final e getHostPermission() {
        return this.hostPermission;
    }

    public final HashMap<Class<?>, BaseFunction<?, ? extends Object>> getMFunctionMap() {
        return this.mFunctionMap;
    }

    public final List<BaseFunction<?, ? extends Object>> getMTaskList() {
        return this.mTaskList;
    }

    public /* synthetic */ BDLiveSdkConfig(DefaultConstructorMarker r100) {
        this();
    }

    public static final /* synthetic */ void access$setGeneralAppId$cp(String r100) {
        generalAppId = r100;
    }

    public final <T> T getFunctionImp(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        BaseFunction<?, ? extends Object> r101 = this.mFunctionMap.get(r100);
        if (r101 == null) goto L5;
        Object r102 = r101.getImpl();
    L7:
        if ((r102 instanceof Object) == true) goto L10;
        return null;
    L10:
        return (T) r102;
    L5:
        r102 = null;
        goto L7
    }

    public final void setDisableBroadcast(boolean r100) {
        this.disableBroadcast = r100;
    }

    public final void setHostPermission(e r100) {
        this.hostPermission = r100;
    }

    public final void setMApplog(AppLogProxy r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mApplog = r100;
    }
}
