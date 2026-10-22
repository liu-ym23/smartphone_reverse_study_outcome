package z1;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s extends b {
    public static s b(f fVar, androidx.emoji2.text.m mVar, Integer num) throws GeneralSecurityException {
        m2.a aVar = (m2.a) mVar.f621a;
        f fVar2 = f.f6381q;
        if (fVar != fVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + fVar + " the value of idRequirement must be non-null");
        }
        if (fVar == fVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (aVar.f3894a.length != 32) {
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + aVar.f3894a.length);
        }
        if (fVar == fVar2) {
            m2.a.a(new byte[0]);
        } else if (fVar == f.f6380p) {
            m2.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        } else {
            if (fVar != f.f6379o) {
                throw new IllegalStateException("Unknown Variant: " + fVar);
            }
            m2.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        return new s();
    }
}
