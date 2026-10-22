package com.android.server.biometrics.sensors.face.aidl;

import android.hardware.common.NativeHandle;
import android.os.ParcelFileDescriptor;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class AidlNativeHandleUtils {
    public AidlNativeHandleUtils() {
    }

    public static NativeHandle dup(android.os.NativeHandle handle) throws IOException {
        if (handle != null) goto L5;
        return null;
    L5:
        NativeHandle res = new NativeHandle();
        FileDescriptor[] fds = handle.getFileDescriptors();
        res.ints = (int[]) handle.getInts().clone();
        res.fds = new ParcelFileDescriptor[fds.length];
        int i = 0;
    L7:
        if (i >= fds.length) goto L10;
        res.fds[i] = ParcelFileDescriptor.dup(fds[i]);
        i = i + 1;
        goto L7
    L10:
        return res;
    }

    public static void close(NativeHandle handle) throws IOException {
        if (handle == null) goto L10;
        ParcelFileDescriptor[] r0 = handle.fds;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        ParcelFileDescriptor fd = r0[r2];
        if (fd == null) goto L9;
        fd.close();
    L9:
        r2 = r2 + 1;
        goto L5
    L14:
        return;
    }
}
