package io.ktor.util;

import e9.InterfaceC4014c;
import io.ktor.utils.io.InternalAPI;
import java.nio.charset.Charset;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"io/ktor/util/CryptoKt__CryptoJvmKt", "io/ktor/util/CryptoKt__CryptoKt"}, k = 4, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CryptoKt {
    public static final int NONCE_SIZE_IN_BYTES = 16;

    public static final Digest Digest(String str) {
        return CryptoKt__CryptoJvmKt.Digest(str);
    }

    @InternalAPI
    public static final Object build(Digest digest, String str, Charset charset, InterfaceC4014c<? super byte[]> interfaceC4014c) {
        return CryptoKt__CryptoKt.build(digest, str, charset, interfaceC4014c);
    }

    public static final String generateNonce() {
        return CryptoKt__CryptoJvmKt.generateNonce();
    }

    public static final InterfaceC5074l<String, byte[]> getDigestFunction(String str, InterfaceC5074l<? super String, String> interfaceC5074l) {
        return CryptoKt__CryptoJvmKt.getDigestFunction(str, interfaceC5074l);
    }

    public static final String hex(byte[] bArr) {
        return CryptoKt__CryptoKt.hex(bArr);
    }

    public static final byte[] sha1(byte[] bArr) {
        return CryptoKt__CryptoJvmKt.sha1(bArr);
    }

    @InternalAPI
    public static final Object build(Digest digest, byte[] bArr, InterfaceC4014c<? super byte[]> interfaceC4014c) {
        return CryptoKt__CryptoKt.build(digest, bArr, interfaceC4014c);
    }

    public static final byte[] generateNonce(int i10) {
        return CryptoKt__CryptoKt.generateNonce(i10);
    }

    public static final byte[] hex(String str) {
        return CryptoKt__CryptoKt.hex(str);
    }
}
