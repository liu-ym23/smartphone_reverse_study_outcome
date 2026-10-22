package com.google.crypto.tink.mac;

import b8.z;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ChunkedMacWrapper implements PrimitiveWrapper<ChunkedMac, ChunkedMac> {
    private static final ChunkedMacWrapper WRAPPER = new ChunkedMacWrapper();

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class WrappedChunkedMac implements ChunkedMac {
        private final PrimitiveSet<ChunkedMac> primitives;

        private WrappedChunkedMac(PrimitiveSet<ChunkedMac> primitiveSet) {
            this.primitives = primitiveSet;
        }

        private ChunkedMac getChunkedMac(PrimitiveSet.Entry<ChunkedMac> entry) {
            return entry.getFullPrimitive();
        }

        @Override // com.google.crypto.tink.mac.ChunkedMac
        public ChunkedMacComputation createComputation() {
            return getChunkedMac(this.primitives.getPrimary()).createComputation();
        }

        @Override // com.google.crypto.tink.mac.ChunkedMac
        public ChunkedMacVerification createVerification(byte[] bArr) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            ArrayList arrayList = new ArrayList();
            Iterator<PrimitiveSet.Entry<ChunkedMac>> it = this.primitives.getPrimitive(bArrCopyOf).iterator();
            while (it.hasNext()) {
                arrayList.add(getChunkedMac(it.next()).createVerification(bArr));
            }
            Iterator<PrimitiveSet.Entry<ChunkedMac>> it2 = this.primitives.getRawPrimitives().iterator();
            while (it2.hasNext()) {
                arrayList.add(getChunkedMac(it2.next()).createVerification(bArr));
            }
            return new WrappedChunkedMacVerification(arrayList);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class WrappedChunkedMacVerification implements ChunkedMacVerification {
        private final List<ChunkedMacVerification> verifications;

        private WrappedChunkedMacVerification(List<ChunkedMacVerification> list) {
            this.verifications = list;
        }

        @Override // com.google.crypto.tink.mac.ChunkedMacVerification
        public void update(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.mark();
            for (ChunkedMacVerification chunkedMacVerification : this.verifications) {
                byteBufferDuplicate.reset();
                chunkedMacVerification.update(byteBufferDuplicate);
            }
            byteBuffer.position(byteBuffer.limit());
        }

        @Override // com.google.crypto.tink.mac.ChunkedMacVerification
        public void verifyMac() throws GeneralSecurityException {
            GeneralSecurityException generalSecurityException = new GeneralSecurityException("MAC verification failed for all suitable keys in keyset");
            Iterator<ChunkedMacVerification> it = this.verifications.iterator();
            while (it.hasNext()) {
                try {
                    it.next().verifyMac();
                    return;
                } catch (GeneralSecurityException e10) {
                    generalSecurityException.addSuppressed(e10);
                }
            }
            throw generalSecurityException;
        }
    }

    private ChunkedMacWrapper() {
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(WRAPPER);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<ChunkedMac> getInputPrimitiveClass() {
        return ChunkedMac.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<ChunkedMac> getPrimitiveClass() {
        return ChunkedMac.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public ChunkedMac wrap(PrimitiveSet<ChunkedMac> primitiveSet) throws GeneralSecurityException {
        if (primitiveSet == null) {
            z.l("primitive set must be non-null");
            return null;
        }
        if (primitiveSet.getPrimary() == null) {
            z.l("no primary in primitive set");
            return null;
        }
        Iterator<List<PrimitiveSet.Entry<ChunkedMac>>> it = primitiveSet.getAll().iterator();
        while (it.hasNext()) {
            Iterator<PrimitiveSet.Entry<ChunkedMac>> it2 = it.next().iterator();
            while (it2.hasNext()) {
                it2.next().getFullPrimitive();
            }
        }
        return new WrappedChunkedMac(primitiveSet);
    }
}
