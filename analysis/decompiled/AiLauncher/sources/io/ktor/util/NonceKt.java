package io.ktor.util;

import Ua.C1056g;
import Ua.C1073o0;
import Ua.CoroutineName;
import Ua.Y;
import Z8.C1173v;
import Z8.F;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011\"\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011\" \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\"\u001a\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010\u0002¨\u0006 "}, d2 = {"LY8/t;", "ensureNonceGeneratorRunning", "()V", "Ljava/security/SecureRandom;", "lookupSecureRandom", "()Ljava/security/SecureRandom;", "", "name", "getInstanceOrNull", "(Ljava/lang/String;)Ljava/security/SecureRandom;", NonceKt.SHA1PRNG, "Ljava/lang/String;", "", "SECURE_RANDOM_PROVIDERS", "Ljava/util/List;", "", "SECURE_RESEED_PERIOD", "I", "SECURE_NONCE_COUNT", "INSECURE_NONCE_COUNT_FACTOR", "LWa/g;", "seedChannel", "LWa/g;", "getSeedChannel", "()LWa/g;", "LUa/L;", "NonceGeneratorCoroutineName", "LUa/L;", "Lkotlinx/coroutines/g;", "nonceGeneratorJob", "Lkotlinx/coroutines/g;", "getNonceGeneratorJob$annotations", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NonceKt {
    private static final int INSECURE_NONCE_COUNT_FACTOR = 4;
    private static final CoroutineName NonceGeneratorCoroutineName;
    private static final int SECURE_NONCE_COUNT = 8;
    private static final int SECURE_RESEED_PERIOD = 30000;
    private static final String SHA1PRNG = "SHA1PRNG";
    private static final kotlinx.coroutines.g nonceGeneratorJob;
    private static final List<String> SECURE_RANDOM_PROVIDERS = C1173v.p("NativePRNGNonBlocking", "WINDOWS-PRNG", "DRBG");
    private static final Wa.g<String> seedChannel = Wa.j.b(1024, null, null, 6, null);

    static {
        CoroutineName coroutineName = new CoroutineName("nonce-generator");
        NonceGeneratorCoroutineName = coroutineName;
        nonceGeneratorJob = C1056g.c(C1073o0.f6391a, Y.a().plus(kotlinx.coroutines.h.f36771a).plus(coroutineName), CoroutineStart.LAZY, new NonceKt$nonceGeneratorJob$1(null));
    }

    public static final void ensureNonceGeneratorRunning() {
        nonceGeneratorJob.start();
    }

    private static final SecureRandom getInstanceOrNull(String str) {
        try {
            return str != null ? SecureRandom.getInstance(str) : new SecureRandom();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static /* synthetic */ SecureRandom getInstanceOrNull$default(String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        return getInstanceOrNull(str);
    }

    private static /* synthetic */ void getNonceGeneratorJob$annotations() {
    }

    public static final Wa.g<String> getSeedChannel() {
        return seedChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SecureRandom lookupSecureRandom() {
        SecureRandom instanceOrNull;
        String property = System.getProperty("io.ktor.random.secure.random.provider");
        if (property != null && (instanceOrNull = getInstanceOrNull(property)) != null) {
            return instanceOrNull;
        }
        Iterator<String> it = SECURE_RANDOM_PROVIDERS.iterator();
        while (it.hasNext()) {
            SecureRandom instanceOrNull2 = getInstanceOrNull(it.next());
            if (instanceOrNull2 != null) {
                return instanceOrNull2;
            }
        }
        vc.e.m("io.ktor.util.random").warn("None of the " + F.A0(SECURE_RANDOM_PROVIDERS, ", ", null, null, 0, null, null, 62, null) + " found, fallback to default");
        SecureRandom instanceOrNull$default = getInstanceOrNull$default(null, 1, null);
        if (instanceOrNull$default != null) {
            return instanceOrNull$default;
        }
        throw new IllegalStateException("No SecureRandom implementation found");
    }
}
