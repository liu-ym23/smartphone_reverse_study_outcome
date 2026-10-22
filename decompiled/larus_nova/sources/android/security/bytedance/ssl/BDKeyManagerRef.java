package android.security.bytedance.ssl;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import el9.a;
import java.lang.reflect.Method;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import t9a.b;

/* JADX INFO: loaded from: classes3.dex */
public class BDKeyManagerRef {
    private static final String TAG = "BDKeyManagerRef";
    public static final String TLS_PRO_CERT = "SYSTEM_Device_TLS_cert";
    public static final String TLS_PRO_PKEY = "SYSTEM_Device_TLS_pkey";
    public static final String TLS_TEST_CERT = "SYSTEM_Device_TLS_cert_test";
    public static final String TLS_TEST_PKEY = "SYSTEM_Device_TLS_pkey_test";
    private static BDKeyManagerRef sInstance;
    private Object mBDKeyManager;
    private Class<?> mClazz;

    public BDKeyManagerRef() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static BDKeyManagerRef getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new BDKeyManagerRef();
    L6:
        return sInstance;
    }

    private void init() {
        if (this.mBDKeyManager != null) goto L5;
    L15:
    L12:
        e = move-exception;
        FLogger.f375446a.e(TAG, "init failed, " + e.getMessage());
        return;
    L7:
        if (b.b().b().d() == false) goto L9;
        this.mClazz = INVOKESTATIC_android_security_bytedance_ssl_BDKeyManagerRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.aiassistant.security.ssl.AssistantKeyManager");     // Catch: Exception -> L12
    L10:
        this.mBDKeyManager = this.mClazz.newInstance();     // Catch: Exception -> L12
        return;
    L9:
        this.mClazz = INVOKESTATIC_android_security_bytedance_ssl_BDKeyManagerRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.obric.security.ssl.ObricKeyManager");     // Catch: Exception -> L12
        goto L10
    L5:
        if (this.mClazz == null) goto L15;
    }

    public long getAlgorithmAddress() {
        init();
        Method r100 = this.mClazz.getDeclaredMethod("getAlgorithmAddress", new Class[0]);     // Catch: Exception -> L5
        r100.setAccessible(true);     // Catch: Exception -> L5
        return ((Long) r100.invoke(this.mBDKeyManager, new Object[0])).longValue();
    L5:
        e = move-exception;
        FLogger.f375446a.e(TAG, "getAlgorithmAddress failed, " + e.getMessage());
        return -1;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_android_security_bytedance_ssl_BDKeyManagerRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public List<X509Certificate> getCertChain(String r100) {
        init();
        Method r101 = this.mClazz.getDeclaredMethod("getCertChain", new Class[]{String.class});     // Catch: Exception -> L5
        r101.setAccessible(true);     // Catch: Exception -> L5
        return (List) r101.invoke(this.mBDKeyManager, new Object[]{r100});
    L5:
        e = move-exception;
        FLogger.f375446a.e(TAG, "getCertChain failed, " + e.getMessage());
        return null;
    }

    public long getDoSignAddress(String r100) {
        init();
        Method r101 = this.mClazz.getDeclaredMethod("getDoSignAddress", new Class[]{String.class});     // Catch: Exception -> L5
        r101.setAccessible(true);     // Catch: Exception -> L5
        return ((Long) r101.invoke(this.mBDKeyManager, new Object[]{r100})).longValue();
    L5:
        e = move-exception;
        FLogger.f375446a.e(TAG, "getDoSignAddress failed, " + e.getMessage());
        return -1;
    }

    public PrivateKey getPrivateKey(String r100) {
        init();
        Method r101 = this.mClazz.getDeclaredMethod("getPrivateKey", new Class[]{String.class});     // Catch: Exception -> L5
        r101.setAccessible(true);     // Catch: Exception -> L5
        return (PrivateKey) r101.invoke(this.mBDKeyManager, new Object[]{r100});
    L5:
        e = move-exception;
        FLogger.f375446a.e(TAG, "getPrivateKey failed, " + e.getMessage());
        return null;
    }

    public boolean isContainsKey(String r100) {
        init();
        Method r101 = this.mClazz.getDeclaredMethod("isContainsKey", new Class[]{String.class});     // Catch: Exception -> L5
        r101.setAccessible(true);     // Catch: Exception -> L5
        return ((Boolean) r101.invoke(this.mBDKeyManager, new Object[]{r100})).booleanValue();
    L5:
        e = move-exception;
        FLogger.f375446a.e(TAG, "isContainsKey failed, " + e.getMessage());
        return false;
    }
}
