package io.ktor.util;

import La.C0951a;
import La.C0953c;
import La.H;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import e9.InterfaceC4014c;
import g9.C4109a;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\n\u0010\u000bB5\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\n\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lio/ktor/util/StatelessHmacNonceManager;", "Lio/ktor/util/NonceManager;", "Ljavax/crypto/spec/SecretKeySpec;", "keySpec", "", "algorithm", "", "timeoutMillis", "Lkotlin/Function0;", "nonceGenerator", "<init>", "(Ljavax/crypto/spec/SecretKeySpec;Ljava/lang/String;JLp9/a;)V", "", "key", "([BLjava/lang/String;JLp9/a;)V", "newNonce", "(Le9/c;)Ljava/lang/Object;", Parameters.UXIP_REQUEST_PARAM_NONCE, "", "verifyNonce", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Ljavax/crypto/spec/SecretKeySpec;", "getKeySpec", "()Ljavax/crypto/spec/SecretKeySpec;", "Ljava/lang/String;", "getAlgorithm", "()Ljava/lang/String;", "J", "getTimeoutMillis", "()J", "Lp9/a;", "getNonceGenerator", "()Lp9/a;", "", "macLength", "I", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StatelessHmacNonceManager implements NonceManager {
    private final String algorithm;
    private final SecretKeySpec keySpec;
    private final int macLength;
    private final InterfaceC5063a<String> nonceGenerator;
    private final long timeoutMillis;

    public StatelessHmacNonceManager(SecretKeySpec keySpec, String algorithm, long j10, InterfaceC5063a<String> nonceGenerator) throws NoSuchAlgorithmException, InvalidKeyException {
        kotlin.jvm.internal.p.i(keySpec, "keySpec");
        kotlin.jvm.internal.p.i(algorithm, "algorithm");
        kotlin.jvm.internal.p.i(nonceGenerator, "nonceGenerator");
        this.keySpec = keySpec;
        this.algorithm = algorithm;
        this.timeoutMillis = j10;
        this.nonceGenerator = nonceGenerator;
        Mac mac = Mac.getInstance(algorithm);
        mac.init(keySpec);
        this.macLength = mac.getMacLength();
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final SecretKeySpec getKeySpec() {
        return this.keySpec;
    }

    public final InterfaceC5063a<String> getNonceGenerator() {
        return this.nonceGenerator;
    }

    public final long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    @Override // io.ktor.util.NonceManager
    public Object newNonce(InterfaceC4014c<? super String> interfaceC4014c) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        String strInvoke = this.nonceGenerator.invoke();
        String string = Long.toString(System.nanoTime(), C0951a.a(16));
        kotlin.jvm.internal.p.h(string, "toString(...)");
        String strJ0 = H.J0(string, 16, '0');
        Mac mac = Mac.getInstance(this.algorithm);
        mac.init(this.keySpec);
        byte[] bytes = (strInvoke + ':' + strJ0).getBytes(C0953c.ISO_8859_1);
        kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
        mac.update(bytes);
        byte[] bArrDoFinal = mac.doFinal();
        kotlin.jvm.internal.p.h(bArrDoFinal, "doFinal(...)");
        return strInvoke + '+' + strJ0 + '+' + CryptoKt.hex(bArrDoFinal);
    }

    @Override // io.ktor.util.NonceManager
    public Object verifyNonce(String str, InterfaceC4014c<? super Boolean> interfaceC4014c) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        List listA1 = H.a1(str, new char[]{'+'}, false, 0, 6, null);
        if (listA1.size() != 3) {
            return C4109a.a(false);
        }
        String str2 = (String) listA1.get(0);
        String str3 = (String) listA1.get(1);
        String str4 = (String) listA1.get(2);
        if (str2.length() >= 8 && str4.length() == this.macLength * 2 && str3.length() == 16 && Long.parseLong(str3, C0951a.a(16)) + TimeUnit.MILLISECONDS.toNanos(this.timeoutMillis) >= System.nanoTime()) {
            Mac mac = Mac.getInstance(this.algorithm);
            mac.init(this.keySpec);
            byte[] bytes = (str2 + ':' + str3).getBytes(C0953c.ISO_8859_1);
            kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
            mac.update(bytes);
            byte[] bArrDoFinal = mac.doFinal();
            kotlin.jvm.internal.p.h(bArrDoFinal, "doFinal(...)");
            String strHex = CryptoKt.hex(bArrDoFinal);
            int iMin = Math.min(strHex.length(), str4.length());
            int i10 = 0;
            for (int i11 = 0; i11 < iMin; i11++) {
                if (strHex.charAt(i11) == str4.charAt(i11)) {
                    i10++;
                }
            }
            return C4109a.a(i10 == this.macLength * 2);
        }
        return C4109a.a(false);
    }

    public /* synthetic */ StatelessHmacNonceManager(SecretKeySpec secretKeySpec, String str, long j10, InterfaceC5063a interfaceC5063a, int i10, kotlin.jvm.internal.i iVar) {
        this(secretKeySpec, (i10 & 2) != 0 ? "HmacSHA256" : str, (i10 & 4) != 0 ? 60000L : j10, (InterfaceC5063a<String>) ((i10 & 8) != 0 ? new InterfaceC5063a() { // from class: io.ktor.util.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CryptoKt.generateNonce();
            }
        } : interfaceC5063a));
    }

    public /* synthetic */ StatelessHmacNonceManager(byte[] bArr, String str, long j10, InterfaceC5063a interfaceC5063a, int i10, kotlin.jvm.internal.i iVar) {
        this(bArr, (i10 & 2) != 0 ? "HmacSHA256" : str, (i10 & 4) != 0 ? 60000L : j10, (InterfaceC5063a<String>) ((i10 & 8) != 0 ? new InterfaceC5063a() { // from class: io.ktor.util.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CryptoKt.generateNonce();
            }
        } : interfaceC5063a));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatelessHmacNonceManager(byte[] key, String algorithm, long j10, InterfaceC5063a<String> nonceGenerator) {
        this(new SecretKeySpec(key, algorithm), algorithm, j10, nonceGenerator);
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(algorithm, "algorithm");
        kotlin.jvm.internal.p.i(nonceGenerator, "nonceGenerator");
    }
}
