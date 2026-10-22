package com.byted.cast.common;

import android.text.TextUtils;
import com.byted.cast.common.auth.DefaultAuthWrapper;
import com.byted.cast.common.auth.ICastAuth;
import com.byted.cast.common.config.ConfigManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public final class ContextManager {
    private static final String DEFAULT_CONTEXT_ID = "default_context_id";
    private static final String TAG = null;
    private static final Object sAppLogWrapperLock = null;
    private static final ConcurrentHashMap<CastContext, AppLogWrapper> sAppLogWrapperMap = null;
    private static final Object sAuthLock = null;
    private static final ConcurrentHashMap<CastContext, ICastAuth> sAuthManagerMap = null;
    private static final Object sConfigLock = null;
    private static final ConcurrentHashMap<CastContext, ConfigManager> sConfigManagerMap = null;
    private static final Object sDeviceInfoManagerLock = null;
    private static final ConcurrentHashMap<CastContext, DeviceInfoManager> sDeviceInfoManagerMap = null;
    private static final Object sLoggerLock = null;
    private static final ConcurrentHashMap<CastContext, CastLogger> sLoggerMap = null;
    private static final Object sMonitorLock = null;
    private static final ConcurrentHashMap<CastContext, CastMonitor> sMonitorMap = null;
    private static final Object sNsdHelperLock = null;
    private static final ConcurrentHashMap<CastContext, NsdHelper> sNsdHelperMap = null;
    private static final Object sTeaEventTrackLock = null;
    private static final ConcurrentHashMap<CastContext, TeaEventTrack> sTeaEventTrackMap = null;

    public static final class CastContext {
        private int httpPort;
        private final String mContextId;
        private boolean mIsBleBrowse;
        private boolean mIsBlePublish;
        private String mProjectId;
        private final String mRealContextId;

        public int hashCode() {
            String r100 = this.mContextId;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public boolean isRoleSource() {
            String[] r100 = this.mContextId.split("_");
            if (r100.length > 0) goto L5;
        L6:
            return true;
        L5:
            if (TextUtils.equals(r100[0], Constants.ROLE_SINK) == false) goto L6;
            return false;
        }

        public String toString() {
            return "CastContext: " + this.mContextId;
        }

        public String getContextId() {
            return this.mContextId;
        }

        public int getHttpPort() {
            return this.httpPort;
        }

        public String getProjectId() {
            return this.mProjectId;
        }

        public String getRealContextId() {
            return this.mRealContextId;
        }

        public boolean isBleBrowse() {
            return this.mIsBleBrowse;
        }

        public boolean isBlePublish() {
            return this.mIsBlePublish;
        }

        public CastContext(String r100) {
            if (TextUtils.isEmpty(r100) == true) goto L11;
            this.mContextId = r100;
            String[] r101 = r100.split("_");
            if (r101.length <= 1) goto L7;
            String r102 = r101[1];
        L8:
            this.mRealContextId = r102;
            return;
        L7:
            r102 = "";
            goto L8
        L11:
            throw new IllegalArgumentException("contextId couldn't be null");
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof CastContext) == true) goto L5;
        L7:
            return false;
        L5:
            if (TextUtils.equals(((CastContext) r100).mContextId, this.mContextId) == false) goto L7;
            return true;
        }

        public void setBleBrowse(boolean r100) {
            this.mIsBleBrowse = r100;
        }

        public void setBlePublish(boolean r100) {
            this.mIsBlePublish = r100;
        }

        public void setHttpPort(int r100) {
            this.httpPort = r100;
        }

        public void setProjectId(String r100) {
            this.mProjectId = r100;
        }
    }

    public ContextManager() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static void clear(CastContext r100) {
    }

    static {
        TAG = "ContextManager";
        sAuthManagerMap = new ConcurrentHashMap();
        sConfigManagerMap = new ConcurrentHashMap();
        sLoggerMap = new ConcurrentHashMap();
        sMonitorMap = new ConcurrentHashMap();
        sTeaEventTrackMap = new ConcurrentHashMap();
        sDeviceInfoManagerMap = new ConcurrentHashMap();
        sAppLogWrapperMap = new ConcurrentHashMap();
        sNsdHelperMap = new ConcurrentHashMap();
        sAuthLock = new Object();
        sConfigLock = new Object();
        sLoggerLock = new Object();
        sMonitorLock = new Object();
        sTeaEventTrackLock = new Object();
        sDeviceInfoManagerLock = new Object();
        sAppLogWrapperLock = new Object();
        sNsdHelperLock = new Object();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_byted_cast_common_ContextManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static AppLogWrapper getAppLogWrapper(CastContext r100) {
        if (r100 == null) goto L4;
        ConcurrentHashMap<CastContext, AppLogWrapper> r101 = sAppLogWrapperMap;
        if (r101.get(r100) != null) goto L18;
        Object r102 = sAppLogWrapperLock;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (r101.get(r100) != null) goto L12;
        r101.put(r100, AppLogWrapper.createInstance(r100));     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
    L18:
        return r101.get(r100);
    L4:
        return AppLogWrapper.getInstance();
    }

    public static ICastAuth getAuthManager(CastContext r100) {
        if (PreferenceUtils.isByteUserToB() == false) goto L31;
        if (r100 != null) goto L6;
        r100 = new CastContext(DEFAULT_CONTEXT_ID);
    L6:
        ConcurrentHashMap<CastContext, ICastAuth> r101 = sAuthManagerMap;
        if (r101.get(r100) != null) goto L29;
        Object r102 = sAuthLock;
        monitor-enter(r102);
    L25:
        th = move-exception;
        throw th;
    L11:
        ICastAuth r103 = null;
        if (r101.get(r100) == null) goto L34;
    L20:
        if (r103 != null) goto L22;
        r103 = DefaultAuthWrapper.getInstance();     // Catch: Throwable -> L25
    L22:
        sAuthManagerMap.put(r100, r103);     // Catch: Throwable -> L25
        monitor-exit(r102);     // Catch: Throwable -> L25
        goto L29
    L34:
        ICastAuth r104 = (ICastAuth) INVOKESTATIC_com_byted_cast_common_ContextManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.cast.auth.AuthWrapper").getDeclaredConstructor(new Class[]{CastContext.class}).newInstance(new Object[]{r100});     // Catch: Throwable -> L18
        Logger.i(TAG, "AuthManager: " + r104);     // Catch: Throwable -> L16
        r103 = r104;
    L16:
        th = th;
        r103 = r104;
    L19:
        Logger.i(TAG, "getAuthManager error: " + th.getMessage());     // Catch: Throwable -> L25
    L18:
        th = th;
    L29:
        return sAuthManagerMap.get(r100);
    L31:
        return DefaultAuthWrapper.getInstance();
    }

    public static ConfigManager getConfigManager(CastContext r100) {
        if (r100 == null) goto L4;
        ConcurrentHashMap<CastContext, ConfigManager> r101 = sConfigManagerMap;
        if (r101.get(r100) != null) goto L18;
        Object r102 = sConfigLock;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (r101.get(r100) != null) goto L12;
        r101.put(r100, ConfigManager.createInstance(r100));     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
    L18:
        return r101.get(r100);
    L4:
        return ConfigManager.getInstance();
    }

    public static DeviceInfoManager getDeviceInfoManager(CastContext r100) {
        if (r100 == null) goto L4;
        ConcurrentHashMap<CastContext, DeviceInfoManager> r101 = sDeviceInfoManagerMap;
        if (r101.get(r100) != null) goto L18;
        Object r102 = sDeviceInfoManagerLock;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (r101.get(r100) != null) goto L12;
        r101.put(r100, DeviceInfoManager.createInstance(r100));     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
    L18:
        return r101.get(r100);
    L4:
        return DeviceInfoManager.getInstance();
    }

    public static CastLogger getLogger(CastContext r100) {
        if (r100 == null) goto L4;
        ConcurrentHashMap<CastContext, CastLogger> r101 = sLoggerMap;
        if (r101.get(r100) != null) goto L18;
        Object r102 = sLoggerLock;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (r101.get(r100) != null) goto L12;
        r101.put(r100, CastLogger.createInstance(r100));     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
    L18:
        return r101.get(r100);
    L4:
        return CastLogger.getInstance();
    }

    public static CastMonitor getMonitor(CastContext r100) {
        if (r100 == null) goto L4;
        ConcurrentHashMap<CastContext, CastMonitor> r101 = sMonitorMap;
        if (r101.get(r100) != null) goto L18;
        Object r102 = sMonitorLock;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (r101.get(r100) != null) goto L12;
        r101.put(r100, CastMonitor.createInstance(r100));     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
    L18:
        return r101.get(r100);
    L4:
        return CastMonitor.getInstance();
    }

    public static NsdHelper getNsdHelper(CastContext r100) {
        if (r100 == null) goto L4;
        ConcurrentHashMap<CastContext, NsdHelper> r101 = sNsdHelperMap;
        if (r101.get(r100) != null) goto L18;
        Object r102 = sNsdHelperLock;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (r101.get(r100) != null) goto L12;
        r101.put(r100, NsdHelper.createInstance(r100));     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
    L18:
        return r101.get(r100);
    L4:
        return NsdHelper.getInstance();
    }

    public static SourceMonitorUtils getSourceMonitor(CastContext r100) {
        return getMonitor(r100).getSourceMonitor();
    }

    public static TeaEventTrack getTeaEventTrack(CastContext r100) {
        if (r100 == null) goto L4;
        ConcurrentHashMap<CastContext, TeaEventTrack> r101 = sTeaEventTrackMap;
        if (r101.get(r100) != null) goto L18;
        Object r102 = sTeaEventTrackLock;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (r101.get(r100) != null) goto L12;
        r101.put(r100, TeaEventTrack.createInstance(r100));     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
    L18:
        return r101.get(r100);
    L4:
        return TeaEventTrack.getInstance();
    }
}
