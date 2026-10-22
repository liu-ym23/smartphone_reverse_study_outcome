package H8;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* renamed from: H8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0242c implements t {
    static {
        int i = h.b;
    }

    public final AbstractC0241b b(ByteArrayInputStream byteArrayInputStream, h hVar) throws IOException {
        AbstractC0241b abstractC0241b;
        try {
            int i = byteArrayInputStream.read();
            if (i == -1) {
                abstractC0241b = null;
            } else {
                if ((i & 128) != 0) {
                    i &= 127;
                    int i6 = 7;
                    while (true) {
                        if (i6 >= 32) {
                            while (i6 < 64) {
                                int i10 = byteArrayInputStream.read();
                                if (i10 == -1) {
                                    throw InvalidProtocolBufferException.a();
                                }
                                if ((i10 & 128) != 0) {
                                    i6 += 7;
                                }
                            }
                            throw new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
                        }
                        int i11 = byteArrayInputStream.read();
                        if (i11 == -1) {
                            throw InvalidProtocolBufferException.a();
                        }
                        i |= (i11 & 127) << i6;
                        if ((i11 & 128) == 0) {
                            break;
                        }
                        i6 += 7;
                    }
                }
                C0245f c0245f = new C0245f(new C0240a(byteArrayInputStream, i, 0));
                abstractC0241b = (AbstractC0241b) a(c0245f, hVar);
                try {
                    c0245f.a(0);
                } catch (InvalidProtocolBufferException e) {
                    e.f5100a = abstractC0241b;
                    throw e;
                }
            }
            if (abstractC0241b == null || abstractC0241b.isInitialized()) {
                return abstractC0241b;
            }
            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(new UninitializedMessageException().getMessage());
            invalidProtocolBufferException.f5100a = abstractC0241b;
            throw invalidProtocolBufferException;
        } catch (IOException e6) {
            throw new InvalidProtocolBufferException(e6.getMessage());
        }
    }
}
