package com.google.crypto.tink.subtle.prf;

import b8.z;
import com.google.crypto.tink.prf.Prf;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class PrfImpl implements Prf {
    private final StreamingPrf prfStreamer;

    private PrfImpl(StreamingPrf streamingPrf) {
        this.prfStreamer = streamingPrf;
    }

    private static byte[] readBytesFromStream(InputStream inputStream, int i) throws GeneralSecurityException, IOException {
        try {
            byte[] bArr = new byte[i];
            int i3 = 0;
            while (i3 < i) {
                int i10 = inputStream.read(bArr, i3, i - i3);
                if (i10 <= 0) {
                    throw new GeneralSecurityException("Provided StreamingPrf terminated before providing requested number of bytes.");
                }
                i3 += i10;
            }
            return bArr;
        } catch (IOException e10) {
            throw new GeneralSecurityException(e10);
        }
    }

    public static PrfImpl wrap(StreamingPrf streamingPrf) {
        return new PrfImpl(streamingPrf);
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
        if (bArr == null) {
            z.l("Invalid input provided.");
            return null;
        }
        if (i > 0) {
            return readBytesFromStream(this.prfStreamer.computePrf(bArr), i);
        }
        z.l("Invalid outputLength specified.");
        return null;
    }
}
