package io.ktor.util;

import La.C0953c;
import Ua.C1058h;
import com.stepos.aiengine.args.SingleFileBundle;
import io.ktor.http.auth.AuthScheme;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a5\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a3\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0002H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\r\u001a\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u000f\u0010\u0015\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0016"}, d2 = {"", "algorithm", "Lkotlin/Function1;", "salt", "", "getDigestFunction", "(Ljava/lang/String;Lp9/l;)Lp9/l;", "text", "getDigest$CryptoKt__CryptoJvmKt", "(Ljava/lang/String;Ljava/lang/String;Lp9/l;)[B", "getDigest", SingleFileBundle.KEY_BYTES, "sha1", "([B)[B", "name", "Lio/ktor/util/Digest;", AuthScheme.Digest, "(Ljava/lang/String;)Lio/ktor/util/Digest;", "generateNonce", "()Ljava/lang/String;", "generateNonceBlocking$CryptoKt__CryptoJvmKt", "generateNonceBlocking", "ktor-utils"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "io/ktor/util/CryptoKt")
/* loaded from: classes4.dex */
final /* synthetic */ class CryptoKt__CryptoJvmKt {
    public static final Digest Digest(String name) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.p.i(name, "name");
        MessageDigest messageDigest = MessageDigest.getInstance(name);
        kotlin.jvm.internal.p.h(messageDigest, "getInstance(...)");
        return DigestImpl.m184boximpl(DigestImpl.m186constructorimpl(messageDigest));
    }

    public static final String generateNonce() {
        String str = (String) kotlinx.coroutines.channels.a.f(NonceKt.getSeedChannel().s());
        return str != null ? str : generateNonceBlocking$CryptoKt__CryptoJvmKt();
    }

    private static final String generateNonceBlocking$CryptoKt__CryptoJvmKt() {
        NonceKt.ensureNonceGeneratorRunning();
        return (String) C1058h.b(null, new CryptoKt__CryptoJvmKt$generateNonceBlocking$1(null), 1, null);
    }

    private static final byte[] getDigest$CryptoKt__CryptoJvmKt(String str, String str2, InterfaceC5074l<? super String, String> interfaceC5074l) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        String strInvoke = interfaceC5074l.invoke(str);
        Charset charset = C0953c.UTF_8;
        byte[] bytes = strInvoke.getBytes(charset);
        kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
        messageDigest.update(bytes);
        byte[] bytes2 = str.getBytes(charset);
        kotlin.jvm.internal.p.h(bytes2, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes2);
        kotlin.jvm.internal.p.h(bArrDigest, "with(...)");
        return bArrDigest;
    }

    public static final InterfaceC5074l<String, byte[]> getDigestFunction(final String algorithm, final InterfaceC5074l<? super String, String> salt) {
        kotlin.jvm.internal.p.i(algorithm, "algorithm");
        kotlin.jvm.internal.p.i(salt, "salt");
        return new InterfaceC5074l() { // from class: io.ktor.util.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CryptoKt__CryptoJvmKt.getDigestFunction$lambda$0$CryptoKt__CryptoJvmKt(algorithm, salt, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] getDigestFunction$lambda$0$CryptoKt__CryptoJvmKt(String str, InterfaceC5074l interfaceC5074l, String e10) {
        kotlin.jvm.internal.p.i(e10, "e");
        return getDigest$CryptoKt__CryptoJvmKt(e10, str, interfaceC5074l);
    }

    public static final byte[] sha1(byte[] bytes) {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(bytes);
        kotlin.jvm.internal.p.h(bArrDigest, "digest(...)");
        return bArrDigest;
    }
}
