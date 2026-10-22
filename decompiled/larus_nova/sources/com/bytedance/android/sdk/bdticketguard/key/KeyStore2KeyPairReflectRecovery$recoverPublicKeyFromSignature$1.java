package com.bytedance.android.sdk.bdticketguard.key;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.security.interfaces.ECPublicKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"encoded", "", "Ljava/security/interfaces/ECPublicKey;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class KeyStore2KeyPairReflectRecovery$recoverPublicKeyFromSignature$1 extends Lambda implements Function1<ECPublicKey, byte[]> {
    public static final KeyStore2KeyPairReflectRecovery$recoverPublicKeyFromSignature$1 INSTANCE = null;

    static {
        INSTANCE = new KeyStore2KeyPairReflectRecovery$recoverPublicKeyFromSignature$1();
    }

    public KeyStore2KeyPairReflectRecovery$recoverPublicKeyFromSignature$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ byte[] invoke(ECPublicKey r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final byte[] invoke2(ECPublicKey r100) {
        return r100.getEncoded();
    }
}
