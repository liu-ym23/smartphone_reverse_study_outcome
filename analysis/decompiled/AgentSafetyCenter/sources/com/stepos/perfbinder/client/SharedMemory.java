package com.stepos.perfbinder.client;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.UUID;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class SharedMemory {
    public static final SharedMemory INSTANCE = new SharedMemory();
    private static final String TAG = "SharedMemory";

    private SharedMemory() {
    }

    public static final byte[] getDataFromFileDescriptor(Parcelable parcelable) {
        parcelable.getClass();
        ByteBuffer byteBufferMapReadOnly = null;
        try {
            try {
                android.os.SharedMemory sharedMemory = (android.os.SharedMemory) parcelable;
                byteBufferMapReadOnly = sharedMemory.mapReadOnly();
                byte[] bArr = new byte[byteBufferMapReadOnly.limit()];
                byteBufferMapReadOnly.get(bArr);
                sharedMemory.close();
                android.os.SharedMemory.unmap(byteBufferMapReadOnly);
                byteBufferMapReadOnly.clear();
                try {
                    android.os.SharedMemory.unmap(byteBufferMapReadOnly);
                    byteBufferMapReadOnly.clear();
                } catch (Exception unused) {
                }
                return bArr;
            } catch (Exception e10) {
                Log.w(TAG, "[getDataFromFileDescriptor] Failed to decode big data", e10);
                e10.printStackTrace();
                throw new RuntimeException("OS above 8.0 big data decode error", e10);
            }
        } catch (Throwable th) {
            if (byteBufferMapReadOnly != null) {
                try {
                    android.os.SharedMemory.unmap(byteBufferMapReadOnly);
                    byteBufferMapReadOnly.clear();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    public static final Parcelable getFileDescriptorFromData(byte[] bArr) {
        bArr.getClass();
        ByteBuffer byteBufferMapReadWrite = null;
        try {
            android.os.SharedMemory sharedMemoryCreate = android.os.SharedMemory.create(UUID.randomUUID().toString(), bArr.length);
            sharedMemoryCreate.getClass();
            byteBufferMapReadWrite = sharedMemoryCreate.mapReadWrite();
            byteBufferMapReadWrite.put(bArr, 0, bArr.length);
            android.os.SharedMemory.unmap(byteBufferMapReadWrite);
            byteBufferMapReadWrite.clear();
            return sharedMemoryCreate;
        } catch (Throwable th) {
            Log.w(TAG, "[getFileDescriptorFromData] Failed to encode big data", th);
            if (byteBufferMapReadWrite != null) {
                try {
                    android.os.SharedMemory.unmap(byteBufferMapReadWrite);
                    byteBufferMapReadWrite.clear();
                } catch (Exception unused) {
                }
            }
            f.g("Big data encode error", th);
            return null;
        }
    }
}
