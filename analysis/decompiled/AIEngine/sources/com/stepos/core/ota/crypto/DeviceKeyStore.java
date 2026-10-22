package com.stepos.core.ota.crypto;

import java.security.PrivateKey;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface DeviceKeyStore {
    void delete();

    boolean isUsable();

    PrivateKey privateKeyOrNull();

    String publicKeyFingerprint();

    /* renamed from: regenerate-IoAF18A, reason: not valid java name */
    Object mo119regenerateIoAF18A(byte[] bArr);
}
