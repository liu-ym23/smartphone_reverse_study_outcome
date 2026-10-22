package com.bytedance.android.sdk.bdticketguard.key;

import com.bytedance.android.sdk.bdticketguard.data.RecoverConditionNotMetException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes12.dex */
public final class m extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f163908a = null;

    @Override // com.bytedance.android.sdk.bdticketguard.key.o
    public final String a() {
        return "reflect";
    }

    static {
        f163908a = new m();
    }

    public m() {
    }

    public final PublicKey c(String r100) {
        int r101 = TeeKeyRecoveryKt.c();
        if (r101 != 1) goto L40;
        TeeApi.f163814f.getClass();
        KeyStore r102 = TeeApi.f();
        Field r103 = KeyStore.class.getDeclaredField("keyStoreSpi");
        r103.setAccessible(true);
        Object r104 = r103.get(r102);
        Field r105 = r104.getClass().getDeclaredField("mKeyStore");
        r105.setAccessible(true);
        Object r106 = r105.get(r104);
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r107 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r108 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L43;
        Class<?> r109 = Class.forName("android.security.keystore.AndroidKeyStoreProvider");     // Catch: Throwable -> L10
        if (r108 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a("android.security.keystore.AndroidKeyStoreProvider");     // Catch: Throwable -> L10
    L32:
        Method r110 = r109.getDeclaredMethod("loadAndroidKeyStorePublicKeyFromKeystore", new Class[]{r106.getClass(), String.class, Integer.TYPE});
        r110.setAccessible(true);
        Object r111 = r110.invoke(null, new Object[]{r106, "USRPKEY_" + r100, -1});
        if (r111 == null) goto L37;
        return (PublicKey) r111;
    L37:
        throw new TypeCastException("null cannot be cast to non-null type java.security.PublicKey");
    L10:
        th = move-exception;
        if (r108 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L14;
        FastClassNotFoundHandler.b("android.security.keystore.AndroidKeyStoreProvider");
    L14:
        throw th;
    L43:
        r109 = Class.forName("android.security.keystore.AndroidKeyStoreProvider");     // Catch: Throwable -> L19
        if (r108 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a("android.security.keystore.AndroidKeyStoreProvider");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        if (r108 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L24;
        FastClassNotFoundHandler.b("android.security.keystore.AndroidKeyStoreProvider");
    L24:
        if ((th instanceof PluginClassNotFoundException) == false) goto L26;
        throw th;
    L26:
        if ((th instanceof ClassNotFoundException) == false) goto L28;
    L31:
        r109 = MiraPluginFix.forName("android.security.keystore.AndroidKeyStoreProvider");
        goto L32
    L28:
        if ((th instanceof NoClassDefFoundError) == true) goto L31;
        throw th;
    L40:
        throw new UnsupportedOperationException("KeyStore1 reflect recovery not supported, current version: " + r101);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.o
    public final com.bytedance.android.sdk.bdticketguard.data.b b(String r100, com.bytedance.android.sdk.bdticketguard.utils.c<? extends PrivateKey> r101, com.bytedance.android.sdk.bdticketguard.utils.c<? extends PublicKey> r102) {
        r101.getClass();     // Catch: Throwable -> L13
        if ((r101 instanceof com.bytedance.android.sdk.bdticketguard.utils.c.C2503c) == false) goto L6;
        Object r103 = ((com.bytedance.android.sdk.bdticketguard.utils.c.C2503c) r101).f164086b;     // Catch: Throwable -> L13
    L8:
        PrivateKey r104 = (PrivateKey) r103;     // Catch: Throwable -> L13
        if (r104 == null) goto L12;
        return new com.bytedance.android.sdk.bdticketguard.data.b.C2498b(c(r100), r104, false, null);
    L12:
        throw new RecoverConditionNotMetException("Private key must be successful");     // Catch: Throwable -> L13
    L6:
        if ((r101 instanceof com.bytedance.android.sdk.bdticketguard.utils.c.b) == false) goto L16;
        r103 = null;
        goto L8
    L16:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        return new com.bytedance.android.sdk.bdticketguard.data.b.a(th);
    }
}
