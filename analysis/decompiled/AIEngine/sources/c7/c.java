package c7;

import java.io.File;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface c {
    boolean armNativeDecrypt(File file);

    boolean decryptWeightInto(String str, ByteBuffer byteBuffer);

    void disarmNativeDecrypt();

    boolean isEncryptedFile(File file);

    Object migrateIfNeeded(File file, qb.b<? super Boolean> bVar);

    Object resolveForBackend(File file, qb.b<? super d> bVar);
}
