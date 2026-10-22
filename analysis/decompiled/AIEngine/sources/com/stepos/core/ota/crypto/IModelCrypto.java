package com.stepos.core.ota.crypto;

import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Result;
import lb.n;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IModelCrypto {
    /* renamed from: decryptToBuffer-BWLJW6A, reason: not valid java name */
    Object mo122decryptToBufferBWLJW6A(String str, byte[] bArr, ByteBuffer byteBuffer, b<? super Result<n>> bVar);

    /* renamed from: decryptToFile-BWLJW6A, reason: not valid java name */
    Object mo123decryptToFileBWLJW6A(String str, String str2, byte[] bArr, b<? super Result<String>> bVar);

    /* renamed from: isEncrypted-gIAlu-s, reason: not valid java name */
    Object mo124isEncryptedgIAlus(String str, b<? super Result<Boolean>> bVar);

    /* renamed from: openDecryptedStream-0E7RQCE, reason: not valid java name */
    Object mo125openDecryptedStream0E7RQCE(String str, byte[] bArr, b<? super Result<? extends InputStream>> bVar);

    /* renamed from: readHeader-gIAlu-s, reason: not valid java name */
    Object mo126readHeadergIAlus(String str, b<? super Result<CryptoHeader>> bVar);
}
