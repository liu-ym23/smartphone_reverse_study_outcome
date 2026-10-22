package w9;

import android.annotation.SuppressLint;
import android.os.SharedMemory;
import com.stepos.deepbinder.core.log.IPCLog;
import java.nio.ByteBuffer;
import java.util.UUID;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {
    @SuppressLint({"DiscouragedPrivateApi"})
    public static final SharedMemory a(byte[] bArr) {
        ByteBuffer byteBufferMapReadWrite = null;
        try {
            SharedMemory sharedMemoryCreate = SharedMemory.create(UUID.randomUUID().toString(), bArr.length);
            kotlin.jvm.internal.g.e(sharedMemoryCreate, "create(...)");
            byteBufferMapReadWrite = sharedMemoryCreate.mapReadWrite();
            byteBufferMapReadWrite.put(bArr, 0, bArr.length);
            SharedMemory.unmap(byteBufferMapReadWrite);
            byteBufferMapReadWrite.clear();
            return sharedMemoryCreate;
        } catch (Throwable th) {
            IPCLog.INSTANCE.w("SharedMemory", "[getFileDescriptorFromData] Failed to encode big data", "exception", th);
            if (byteBufferMapReadWrite != null) {
                try {
                    SharedMemory.unmap(byteBufferMapReadWrite);
                    byteBufferMapReadWrite.clear();
                } catch (Exception unused) {
                    n nVar = n.f10413a;
                }
            }
            throw new RuntimeException("Big data encode error", th);
        }
    }
}
