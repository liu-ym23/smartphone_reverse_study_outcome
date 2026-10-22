package com.bytedance.android.sdk.bdticketguard.key;

import android.content.SharedPreferences;
import android.util.Base64;
import com.bytedance.android.sdk.bdticketguard.data.RecoverConditionNotMetException;
import com.bytedance.crypto.utils.CryptoConst;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
public final class l extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f163907a = null;

    @Override // com.bytedance.android.sdk.bdticketguard.key.o
    public final String a() {
        return "storage";
    }

    static {
        f163907a = new l();
    }

    public l() {
    }

    public final PublicKey c(String r100) {
        StringBuilder r101 = new StringBuilder("tee_backup_key_");
        if (r100 == null) goto L5;
        String r102 = r100;
    L6:
        r101.append(r102);
        String r103 = r101.toString();
        Lazy r104 = TeeKeyRecoveryKt.f163838b;
        KProperty r105 = TeeKeyRecoveryKt.f163837a[0];
        SharedPreferences r106 = (SharedPreferences) r104.getValue();
        if (r106 == null) goto L13;
        String r107 = r106.getString(r103, null);
        if (r107 == null) goto L13;
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(Base64.decode(r107, 2)));
    L13:
        throw new IllegalStateException("No backup public key found in SP for alias: " + r100);
    L5:
        r102 = "";
        goto L6
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.o
    public final com.bytedance.android.sdk.bdticketguard.data.b b(String r100, com.bytedance.android.sdk.bdticketguard.utils.c<? extends PrivateKey> r101, com.bytedance.android.sdk.bdticketguard.utils.c<? extends PublicKey> r102) {
        r101.getClass();     // Catch: Throwable -> L13
        if ((r101 instanceof com.bytedance.android.sdk.bdticketguard.utils.c.C2503c) == false) goto L6;
        Object r103 = ((com.bytedance.android.sdk.bdticketguard.utils.c.C2503c) r101).f164086b;     // Catch: Throwable -> L13
    L8:
        PrivateKey r104 = (PrivateKey) r103;     // Catch: Throwable -> L13
        if (r104 == null) goto L12;
        return new com.bytedance.android.sdk.bdticketguard.data.b.C2498b(c(r100), r104, true, null);
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
