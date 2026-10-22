package u3;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class s extends b {
    public static s b(f fVar, a7.d dVar, Integer num) throws GeneralSecurityException {
        i4.a aVar = (i4.a) dVar.f411g;
        f fVar2 = f.f10021q;
        if (fVar != fVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + fVar + " the value of idRequirement must be non-null");
        }
        if (fVar == fVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (aVar.f4640a.length != 32) {
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + aVar.f4640a.length);
        }
        if (fVar == fVar2) {
            i4.a.a(new byte[0]);
        } else if (fVar == f.f10020p) {
            i4.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        } else {
            if (fVar != f.f10019o) {
                throw new IllegalStateException("Unknown Variant: " + fVar);
            }
            i4.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        return new s();
    }
}
