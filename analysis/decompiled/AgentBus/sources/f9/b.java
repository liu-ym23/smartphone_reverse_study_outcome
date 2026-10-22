package f9;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class b implements w {
    static {
        int i2 = h.f3559b;
    }

    public final a b(ByteArrayInputStream byteArrayInputStream, h hVar) throws IOException {
        a aVar;
        try {
            int i2 = byteArrayInputStream.read();
            if (i2 == -1) {
                aVar = null;
            } else {
                if ((i2 & 128) != 0) {
                    i2 &= 127;
                    int i10 = 7;
                    while (true) {
                        if (i10 >= 32) {
                            while (i10 < 64) {
                                int i11 = byteArrayInputStream.read();
                                if (i11 == -1) {
                                    throw r.a();
                                }
                                if ((i11 & 128) != 0) {
                                    i10 += 7;
                                }
                            }
                            throw new r("CodedInputStream encountered a malformed varint.");
                        }
                        int i12 = byteArrayInputStream.read();
                        if (i12 == -1) {
                            throw r.a();
                        }
                        i2 |= (i12 & 127) << i10;
                        if ((i12 & 128) == 0) {
                            break;
                        }
                        i10 += 7;
                    }
                }
                e eVar = new e(new com.google.protobuf.a(byteArrayInputStream, i2, 1));
                aVar = (a) a(eVar, hVar);
                try {
                    eVar.a(0);
                } catch (r e10) {
                    e10.f3597f = aVar;
                    throw e10;
                }
            }
            if (aVar == null || aVar.isInitialized()) {
                return aVar;
            }
            r rVar = new r(new a4.u(4).getMessage());
            rVar.f3597f = aVar;
            throw rVar;
        } catch (IOException e11) {
            throw new r(e11.getMessage());
        }
    }
}
