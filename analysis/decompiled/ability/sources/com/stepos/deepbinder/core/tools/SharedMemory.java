package com.stepos.deepbinder.core.tools;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/deepbinder/core/tools/SharedMemory;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "getDataFromFileDescriptor", "", "parcelable", "Landroid/os/Parcelable;", "getFileDescriptorFromData", SettingsConfig.KEY_DATA, "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SharedMemory {
    public static final SharedMemory INSTANCE = new SharedMemory();
    private static final String TAG = "SharedMemory";

    private SharedMemory() {
    }

    public static final byte[] getDataFromFileDescriptor(Parcelable parcelable) {
        k.f(parcelable, "parcelable");
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
        } catch (Exception e) {
            IPCLog.INSTANCE.w(TAG, "[getDataFromFileDescriptor] Failed to decode big data", "exception", e);
            e.printStackTrace();
            throw new RuntimeException("OS above 8.0 big data decode error", e);
        }
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    public static final Parcelable getFileDescriptorFromData(byte[] data) {
        k.f(data, "data");
        ByteBuffer byteBufferMapReadWrite = null;
        try {
            android.os.SharedMemory sharedMemoryCreate = android.os.SharedMemory.create(UUID.randomUUID().toString(), data.length);
            k.e(sharedMemoryCreate, "create(...)");
            byteBufferMapReadWrite = sharedMemoryCreate.mapReadWrite();
            byteBufferMapReadWrite.put(data, 0, data.length);
            android.os.SharedMemory.unmap(byteBufferMapReadWrite);
            byteBufferMapReadWrite.clear();
            return sharedMemoryCreate;
        } catch (Throwable th) {
            IPCLog.INSTANCE.w(TAG, "[getFileDescriptorFromData] Failed to encode big data", "exception", th);
            if (byteBufferMapReadWrite != null) {
                try {
                    android.os.SharedMemory.unmap(byteBufferMapReadWrite);
                    byteBufferMapReadWrite.clear();
                } catch (Exception unused) {
                }
            }
            throw new RuntimeException("Big data encode error", th);
        }
    }
}
