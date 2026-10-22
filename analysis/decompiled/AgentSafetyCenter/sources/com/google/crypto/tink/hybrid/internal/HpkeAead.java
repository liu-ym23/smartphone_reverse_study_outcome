package com.google.crypto.tink.hybrid.internal;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
interface HpkeAead {
    byte[] getAeadId();

    int getKeyLength();

    int getNonceLength();

    byte[] open(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    byte[] seal(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);
}
