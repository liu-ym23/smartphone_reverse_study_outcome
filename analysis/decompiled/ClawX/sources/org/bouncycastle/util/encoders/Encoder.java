package org.bouncycastle.util.encoders;

import java.io.OutputStream;

/* loaded from: classes.dex */
public interface Encoder {
    int decode(String str, OutputStream outputStream);

    int decode(byte[] bArr, int i8, int i9, OutputStream outputStream);

    int encode(byte[] bArr, int i8, int i9, OutputStream outputStream);

    int getEncodedLength(int i8);

    int getMaxDecodedLength(int i8);
}
