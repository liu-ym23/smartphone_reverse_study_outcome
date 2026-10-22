package com.stepos.core.ota.crypto;

import java.io.InputStream;
import kotlin.Result;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ModelDecryptProvider {
    String getId();

    Object isAvailable(b<? super Boolean> bVar);

    /* renamed from: openDecryptedStream-gIAlu-s */
    Object mo132openDecryptedStreamgIAlus(DecryptRequest decryptRequest, b<? super Result<? extends InputStream>> bVar);

    boolean supports(String str, CryptoAlgorithm cryptoAlgorithm);
}
