package com.stepos.core.ota.domain.port;

import java.io.InputStream;
import kotlin.Result;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface PayloadDecryptor {
    /* renamed from: isEncrypted-gIAlu-s */
    Object mo136isEncryptedgIAlus(String str, b<? super Result<Boolean>> bVar);

    void onInstallSucceeded(String str, int i10);

    /* renamed from: openDecryptedStream-yxL6bBk */
    Object mo137openDecryptedStreamyxL6bBk(String str, String str2, int i10, String str3, b<? super Result<? extends InputStream>> bVar);
}
