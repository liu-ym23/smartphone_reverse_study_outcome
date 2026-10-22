package com.stepos.perfbinder.service;

import Y8.t;
import android.annotation.SuppressLint;
import android.os.Parcelable;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/perfbinder/service/SharedMemory;", "", "<init>", "()V", "TAG", "", "getDataFromFileDescriptor", "", "parcelable", "Landroid/os/Parcelable;", "getFileDescriptorFromData", "data", "perfbinder-service_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedMemory {
    public static final SharedMemory INSTANCE = new SharedMemory();
    private static final String TAG = "SharedMemory";

    private SharedMemory() {
    }

    public static final byte[] getDataFromFileDescriptor(Parcelable parcelable) {
        p.i(parcelable, "parcelable");
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
                    return bArr;
                } catch (Exception unused) {
                    t tVar = t.f7040a;
                    return bArr;
                }
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
                    t tVar2 = t.f7040a;
                }
            }
            throw th;
        }
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    public static final Parcelable getFileDescriptorFromData(byte[] data) {
        p.i(data, "data");
        ByteBuffer byteBufferMapReadWrite = null;
        try {
            android.os.SharedMemory sharedMemoryCreate = android.os.SharedMemory.create(UUID.randomUUID().toString(), data.length);
            p.h(sharedMemoryCreate, "create(...)");
            byteBufferMapReadWrite = sharedMemoryCreate.mapReadWrite();
            byteBufferMapReadWrite.put(data, 0, data.length);
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
                    t tVar = t.f7040a;
                }
            }
            throw new RuntimeException("Big data encode error", th);
        }
    }
}
