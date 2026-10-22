package com.obric.aiagent.ipc.idl;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.d;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class FileIDLIpcWrapper implements IFileIDL {
    boolean log;
    final IFileIDL origin;

    FileIDLIpcWrapper(IFileIDL r3) {
        this((IFileIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFileIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FileIDLIpcWrapper(IFileIDL r3, boolean r4) {
        this.origin = (IFileIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFileIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public ParcelFileDescriptor openFile(FilePath r23, int r24) {
        long r7 = SystemClock.elapsedRealtimeNanos();
        ParcelFileDescriptor r13 = null;
    L14:
        e = move-exception;
        j.f18676a.a("IFileIDLIPC", "openFile(" + r23 + ", " + r24 + ")", e);     // Catch: Throwable -> L17
        g r3 = new g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r20 - r7) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFileIDLIPC", "openFile(" + r23 + ", " + r24 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        d.f18654a.a("IFileIDLIPC", "openFile", r3, r6, r20);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFileIDLIPC", "openFile(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFileIDLIPC", "openFile(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r13 = this.origin.openFile(r23, r24);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFileIDLIPC", "openFile = " + r13);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFileIDLIPC", "openFile(" + r23 + ", " + r24 + ") = " + r13, r14);     // Catch: Exception -> L14 Throwable -> L17
        d.f18654a.a("IFileIDLIPC", "openFile", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return r13;
    L16:
        return r13;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List listDir(FilePath r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        List r11 = null;
    L14:
        e = move-exception;
        j.f18676a.a("IFileIDLIPC", "listDir(" + r22 + ")", e);     // Catch: Throwable -> L17
        g r2 = new g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFileIDLIPC", "listDir(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        d.f18654a.a("IFileIDLIPC", "listDir", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFileIDLIPC", "listDir(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFileIDLIPC", "listDir(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.listDir(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFileIDLIPC", "listDir = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFileIDLIPC", "listDir(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        d.f18654a.a("IFileIDLIPC", "listDir", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List listAllFile(FilePath r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        List r11 = null;
    L14:
        e = move-exception;
        j.f18676a.a("IFileIDLIPC", "listAllFile(" + r22 + ")", e);     // Catch: Throwable -> L17
        g r2 = new g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFileIDLIPC", "listAllFile(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        d.f18654a.a("IFileIDLIPC", "listAllFile", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFileIDLIPC", "listAllFile(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFileIDLIPC", "listAllFile(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.listAllFile(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFileIDLIPC", "listAllFile = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFileIDLIPC", "listAllFile(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        d.f18654a.a("IFileIDLIPC", "listAllFile", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public boolean deleteFile(FilePath r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        j.f18676a.a("IFileIDLIPC", "deleteFile(" + r22 + ")", e);     // Catch: Throwable -> L17
        g r2 = new g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        k.f18677a.a("IFileIDLIPC", "deleteFile(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        d.f18654a.a("IFileIDLIPC", "deleteFile", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IFileIDLIPC", "deleteFile(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IFileIDLIPC", "deleteFile(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.deleteFile(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        j.f18676a.c("IFileIDLIPC", "deleteFile = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        k.f18677a.a("IFileIDLIPC", "deleteFile(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        d.f18654a.a("IFileIDLIPC", "deleteFile", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
