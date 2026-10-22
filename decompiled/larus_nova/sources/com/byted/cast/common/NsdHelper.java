package com.byted.cast.common;

import com.byted.cast.common.config.ConfigConstants;
import com.byted.cast.common.config.ConfigManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class NsdHelper {
    private static final String TAG = "NsdHelper";
    private static volatile NsdHelper sInstance;
    private static Boolean sIsDNSSDClassExists;
    private static Boolean sIsJmDNSClassExists;
    private final ContextManager.CastContext mCastContext;

    public static final enum NsdType extends Enum<NsdType> {
        private static final /* synthetic */ NsdType[] $VALUES = null;
        public static final NsdType TypeDnssd = null;
        public static final NsdType TypeJmDNS = null;
        public static final NsdType TypeNsdManager = null;

        static {
            NsdType r100 = new NsdType("TypeNsdManager", 0);
            TypeNsdManager = r100;
            NsdType r101 = new NsdType("TypeDnssd", 1);
            TypeDnssd = r101;
            NsdType r102 = new NsdType("TypeJmDNS", 2);
            TypeJmDNS = r102;
            $VALUES = new NsdType[]{r100, r101, r102};
        }

        public static NsdType[] values() {
            return (NsdType[]) $VALUES.clone();
        }

        public static NsdType valueOf(String r100) {
            return (NsdType) a.a(NsdType.class, r100);
        }

        private NsdType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static NsdHelper getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(CastLogger.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NsdHelper(null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CastLogger.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private boolean isConfigEnableDnssd() {
        ConfigManager r100 = ContextManager.getConfigManager(this.mCastContext);
        boolean r101 = r100.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_DNSSD_SWITCH, false);
        Boolean r102 = Boolean.TRUE;
        if (r102.equals(r100.getInitConfig().isForceDnssd()) == false) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (sIsDNSSDClassExists != null) goto L16;
        INVOKESTATIC_com_byted_cast_common_NsdHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.byted.cast.dnssd.DNSSD");     // Catch: Exception -> L13
        sIsDNSSDClassExists = r102;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ContextManager.getLogger(this.mCastContext).w(TAG, "can't find class DNSSD: " + e.getMessage());
        sIsDNSSDClassExists = Boolean.FALSE;
    L16:
        if (sIsDNSSDClassExists.booleanValue() == false) goto L23;
        if (r101 == true) goto L19;
        if (r103 == true) goto L19;
        return false;
    L19:
        return true;
    L23:
        return false;
    L5:
        if (r100.getOptionByBoolean(10033, false) == true) goto L8;
        r103 = false;
        goto L10
    }

    private boolean isConfigEnableJmdns() {
        ConfigManager r100 = ContextManager.getConfigManager(this.mCastContext);
        boolean r101 = r100.getLocalGrayConfigByBoolean(ConfigConstants.FEATURE_JMDNS_SWITCH, false);
        Boolean r102 = Boolean.TRUE;
        if (r102.equals(r100.getInitConfig().isForceJmDNS()) == false) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (sIsJmDNSClassExists != null) goto L16;
        INVOKESTATIC_com_byted_cast_common_NsdHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("javax.jmdns.JmDNS");     // Catch: Exception -> L13
        ContextManager.getLogger(this.mCastContext).i(TAG, "JmDNS exists");     // Catch: Exception -> L13
        sIsJmDNSClassExists = r102;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ContextManager.getLogger(this.mCastContext).w(TAG, "can't find class JmDNS: " + e.getMessage());
        sIsJmDNSClassExists = Boolean.FALSE;
    L16:
        if (sIsJmDNSClassExists.booleanValue() == false) goto L23;
        if (r101 == true) goto L19;
        if (r103 == true) goto L19;
        return false;
    L19:
        return true;
    L23:
        return false;
    L5:
        if (r100.getOptionByBoolean(10074, false) == true) goto L8;
        r103 = false;
        goto L10
    }

    public NsdType getNsdType() {
        if (isConfigEnableJmdns() == false) goto L7;
        return NsdType.TypeJmDNS;
    L7:
        if (isConfigEnableDnssd() == false) goto L11;
        return NsdType.TypeDnssd;
    L11:
        return NsdType.TypeNsdManager;
    }

    public boolean isEnableDnssd() {
        if (getNsdType() != NsdType.TypeDnssd) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEnableJmdns() {
        if (getNsdType() != NsdType.TypeJmDNS) goto L5;
        return true;
    L5:
        return false;
    }

    private NsdHelper(ContextManager.CastContext r100) {
        this.mCastContext = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_byted_cast_common_NsdHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static NsdHelper createInstance(ContextManager.CastContext r100) {
        if (r100 != null) goto L6;
        return getInstance();
    L6:
        return new NsdHelper(r100);
    }
}
