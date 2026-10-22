package io.ktor.util;

import La.C0951a;
import La.C0953c;
import La.D;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.aiengine.args.SingleFileBundle;
import e9.InterfaceC4014c;
import fb.C4074a;
import fb.x;
import io.ktor.http.ContentDisposition;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.InternalAPI;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0005\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0087@¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\f\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\f\b\u0002\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0087@¢\u0006\u0004\b\f\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0016\u001a\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"", SingleFileBundle.KEY_BYTES, "", "hex", "([B)Ljava/lang/String;", "s", "(Ljava/lang/String;)[B", "", ContentDisposition.Parameters.Size, "generateNonce", "(I)[B", "Lio/ktor/util/Digest;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "(Lio/ktor/util/Digest;[BLe9/c;)Ljava/lang/Object;", "string", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "(Lio/ktor/util/Digest;Ljava/lang/String;Ljava/nio/charset/Charset;Le9/c;)Ljava/lang/Object;", "", "digits", "[C", "NONCE_SIZE_IN_BYTES", "I", "ktor-utils"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "io/ktor/util/CryptoKt")
/* loaded from: classes4.dex */
final /* synthetic */ class CryptoKt__CryptoKt {
    private static final char[] digits = CharsetKt.toCharArray("0123456789abcdef");

    @InternalAPI
    public static final Object build(Digest digest, byte[] bArr, InterfaceC4014c<? super byte[]> interfaceC4014c) {
        digest.plusAssign(bArr);
        return digest.build(interfaceC4014c);
    }

    public static /* synthetic */ Object build$default(Digest digest, String str, Charset charset, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = C0953c.UTF_8;
        }
        return CryptoKt.build(digest, str, charset, interfaceC4014c);
    }

    public static final byte[] generateNonce(int i10) {
        C4074a c4074a = new C4074a();
        while (BytePacketBuilderKt.getSize(c4074a) < i10) {
            StringsKt.writeText$default(c4074a, CryptoKt.generateNonce(), 0, 0, (Charset) null, 14, (Object) null);
        }
        return x.d(c4074a, i10);
    }

    public static final String hex(byte[] bytes) {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        char[] cArr = new char[bytes.length * 2];
        char[] cArr2 = digits;
        int i10 = 0;
        for (byte b10 : bytes) {
            int i11 = i10 + 1;
            cArr[i10] = cArr2[(b10 & 255) >> 4];
            i10 += 2;
            cArr[i11] = cArr2[b10 & 15];
        }
        return D.B(cArr);
    }

    @InternalAPI
    public static final Object build(Digest digest, String str, Charset charset, InterfaceC4014c<? super byte[]> interfaceC4014c) {
        digest.plusAssign(StringsKt.toByteArray(str, charset));
        return digest.build(interfaceC4014c);
    }

    public static final byte[] hex(String s10) {
        kotlin.jvm.internal.p.i(s10, "s");
        int length = s10.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (Integer.parseInt(String.valueOf(s10.charAt(i11 + 1)), C0951a.a(16)) | (Integer.parseInt(String.valueOf(s10.charAt(i11)), C0951a.a(16)) << 4));
        }
        return bArr;
    }
}
