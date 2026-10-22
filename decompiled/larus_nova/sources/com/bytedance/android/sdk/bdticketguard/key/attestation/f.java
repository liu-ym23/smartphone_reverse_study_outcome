package com.bytedance.android.sdk.bdticketguard.key.attestation;

import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.android.sdk.bdticketguard.r0;
import com.bytedance.android.sdk.bdticketguard.setting.l;
import com.bytedance.android.sdk.bdticketguard.setting.m;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.reflect.KProperty;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f163880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f163881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f163882c = null;

    @Override // com.bytedance.android.sdk.bdticketguard.key.attestation.d
    public final String e() {
        return "Huawei";
    }

    static {
        f163882c = new f();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.attestation.d
    public final KeyStore b() {
        KeyStore r100 = KeyStore.getInstance("HwKeystore");
        r100.load(null);
        return r100;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.attestation.d
    public final boolean f() {
        boolean r100 = true;
        if (f163881b == false) goto L5;
        return true;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (f163881b == false) goto L24;
        monitor-exit(this);
        return true;
    L24:
        Object r101 = h("com.huawei.security.keystore.HwUniversalKeyStoreProvider").newInstance();     // Catch: Throwable -> L15
        if (r101 == null) goto L14;
        Security.addProvider((Provider) r101);     // Catch: Throwable -> L15
        KeyStore.getInstance("HwKeystore");     // Catch: Throwable -> L15
        r0.c("HuaweiAttestationAdapter", "install hw provider success");     // Catch: Throwable -> L15
        f163881b = true;     // Catch: Throwable -> L15
    L18:
        monitor-exit(this);
        return r100;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type java.security.Provider");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r0.d(6, "HuaweiAttestationAdapter", "install hw provider failed", th);     // Catch: Throwable -> L20
        r100 = false;
        goto L18
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.attestation.d
    public final boolean g() {
        l.f164015l0.getClass();
        m r100 = l.A;
        KProperty r101 = l.f163998d[22];
        return ((Boolean) r100.f164030a.a()).booleanValue();
    }

    public f() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class h(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    @Override // com.bytedance.android.sdk.bdticketguard.key.attestation.d
    public final KeyPairGenerator d(KeyGenParameterSpec r100) {
        KeyPairGenerator r101 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC, "HwUniversalKeyStoreProvider");
        r101.initialize(r100);
        return r101;
    }
}
