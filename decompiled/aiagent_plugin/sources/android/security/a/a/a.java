package android.security.a.a;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: compiled from: BDKeyManagerRef.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "BDKeyManagerRef";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f3a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f4b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f5c;

    public a() {
    }

    public List<X509Certificate> a(String r7) {
        c();
        Method r0 = this.f4b.getDeclaredMethod("getCertChain", new Class[]{String.class});     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return (List) ZeusTransformUtils.preCheckCast(r0.invoke(this.f5c, new Object[]{r7}), List.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "getCertChain failed, " + e.getMessage());
        return null;
    }

    public PrivateKey b(String r7) {
        c();
        Method r0 = this.f4b.getDeclaredMethod("getPrivateKey", new Class[]{String.class});     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return (PrivateKey) ZeusTransformUtils.preCheckCast(r0.invoke(this.f5c, new Object[]{r7}), PrivateKey.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "getPrivateKey failed, " + e.getMessage());
        return null;
    }

    public long c(String r7) {
        c();
        Method r0 = this.f4b.getDeclaredMethod("getDoSignAddress", new Class[]{String.class});     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return ((Long) ZeusTransformUtils.preCheckCast(r0.invoke(this.f5c, new Object[]{r7}), Long.class, "com.obric.aiagent.plugin")).longValue();
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "getDoSignAddress failed, " + e.getMessage());
        return -1;
    }

    public long a() {
        c();
        Method r0 = this.f4b.getDeclaredMethod("getAlgorithmAddress", new Class[0]);     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return ((Long) ZeusTransformUtils.preCheckCast(r0.invoke(this.f5c, new Object[0]), Long.class, "com.obric.aiagent.plugin")).longValue();
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "getAlgorithmAddress failed, " + e.getMessage());
        return -1;
    }

    public boolean d(String r7) {
        c();
        Method r1 = this.f4b.getDeclaredMethod("isContainsKey", new Class[]{String.class});     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        return ((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(this.f5c, new Object[]{r7}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "isContainsKey failed, " + e.getMessage());
        return false;
    }

    private void c() {
        if (this.f5c != null) goto L5;
    L6:
        ILogDepend.Companion.d(TAG, "Initializing KeyManager: com.obric.security.ssl.ObricKeyManager");
    L14:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "init failed, " + e.getMessage());
        return;
    L9:
        if (ObricProductSdk.INSTANCE.platformService().romInfo().useAssistantApi() == false) goto L11;
        this.f4b = ZeusTransformUtils.forName("com.aiassistant.security.ssl.AssistantKeyManager", "com.obric.aiagent.plugin");     // Catch: Exception -> L14
    L12:
        this.f5c = this.f4b.newInstance();     // Catch: Exception -> L14
        return;
    L11:
        this.f4b = ZeusTransformUtils.forName("com.obric.security.ssl.ObricKeyManager", "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        goto L12
    L5:
        if (this.f4b == null) goto L6;
    }

    public static a b() {
        if (f3a != null) goto L6;
        f3a = new a();
    L6:
        return f3a;
    }
}
