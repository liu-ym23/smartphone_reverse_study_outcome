package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class HarShmPacketsReader {
    public ByteBuffer a;
    public SharedMemory b;

    public HarShmPacketsReader() {
    }

    public static int getSingleBufferSize() {
        return 65536;
    }

    public void closeShm() {
        ByteBuffer r0 = this.a;
        if (r0 == null) goto L5;
        SharedMemory.unmap(r0);
        this.a = null;
    L5:
        SharedMemory r1 = this.b;
        if (r1 == null) goto L9;
        r1.close();
        this.b = null;
        return;
    }

    public ByteBuffer getHarShmMappedBuffer() {
        return this.a;
    }

    public boolean openShm(ParcelFileDescriptor r4) {
        this.b = SharedMemory.fromFileDescriptor(r4);     // Catch: Throwable -> L6 ErrnoException -> L8
        r4.close();     // Catch: Throwable -> L6 ErrnoException -> L8
        SharedMemory r5 = this.b;     // Catch: Throwable -> L6 ErrnoException -> L8
        this.a = r5.map(OsConstants.PROT_READ, 0, r5.getSize());     // Catch: Throwable -> L6 ErrnoException -> L8
        return true;
    L6:
        e = move-exception;
        this.a = null;
        e.printStackTrace();
        return false;
    }

    public List<UnifiedDataPacket> processDataBatch(ByteBuffer r9, int r10, int r11) {
        int r12 = r10 * 65536;
        ArrayList r1 = new ArrayList();
        int r3 = 0;
    L4:
        if (r3 >= r11) goto L25;
        r9.position(r12 + r3);
        if (r9.remaining() < 4) goto L7;
        int r4 = r9.getInt();
        if (r4 <= 0) goto L24;
        if (r4 > 65536) goto L24;
        if (r9.remaining() < r4) goto L14;
        byte[] r5 = new byte[r4];
        r9.get(r5);
        Parcelable.Creator<UnifiedDataPacket> r6 = UnifiedDataPacket.CREATOR;
        Parcel r7 = Parcel.obtain();
        r7.unmarshall(r5, 0, r4);     // Catch: Throwable -> L21
        r7.setDataPosition(0);     // Catch: Throwable -> L21
        UnifiedDataPacket r8 = r6.createFromParcel(r7);     // Catch: Throwable -> L21
        r7.recycle();
        UnifiedDataPacket r13 = r8;
        if (r13 == null) goto L20;
        r1.add(r13);
    L20:
        r3 = r3 + (r4 + 4);
    L21:
        th = move-exception;
        r7.recycle();
        throw th;
    L14:
        Log.e("HarShmPacketsReader", "Buffer underflow when reading packet data. Declared length: " + r4);
    L24:
        Log.e("HarShmPacketsReader", "Invalid packet length detected: " + r4);
        goto L25
    L7:
        Log.e("HarShmPacketsReader", "Buffer underflow when reading packet length.");
    L25:
        return r1;
    }
}
