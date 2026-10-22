package com.obric.aiagent.ipc.idl;

import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.d;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class FileIDLStubWrapper extends IFileIDL.Stub {
    boolean log;
    final IFileIDL.Stub origin;

    FileIDLStubWrapper(IFileIDL.Stub r2) {
        this(r2, true);
    }

    FileIDLStubWrapper(IFileIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public ParcelFileDescriptor openFile(FilePath r23, int r24) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FileIDLStub", "openFile(" + r23 + ", " + r24 + ")", e);
        g r3 = new g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        k.f18677a.b("FileIDLStub", "openFile(" + r23 + ", " + r24 + ") = fail", r3, r6);
        d.f18654a.b("FileIDLStub", "openFile", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FileIDLStub", "openFile(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L11
    L6:
        ParcelFileDescriptor r13 = this.origin.openFile(r23, r24);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FileIDLStub", "openFile = " + r13);     // Catch: Exception -> L11
    L9:
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r20 - r7) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FileIDLStub", "openFile(" + r23 + ", " + r24 + ") = " + r13, r14);     // Catch: Exception -> L11
        d.f18654a.b("FileIDLStub", "openFile", r14, r20);     // Catch: Exception -> L11
        return r13;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List listDir(FilePath r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FileIDLStub", "listDir(" + r21 + ")", e);
        g r2 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        k.f18677a.b("FileIDLStub", "listDir(" + r21 + ") = fail", r2, r4);
        d.f18654a.b("FileIDLStub", "listDir", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FileIDLStub", "listDir(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        List r11 = this.origin.listDir(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FileIDLStub", "listDir = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FileIDLStub", "listDir(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        d.f18654a.b("FileIDLStub", "listDir", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List listAllFile(FilePath r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FileIDLStub", "listAllFile(" + r21 + ")", e);
        g r2 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        k.f18677a.b("FileIDLStub", "listAllFile(" + r21 + ") = fail", r2, r4);
        d.f18654a.b("FileIDLStub", "listAllFile", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FileIDLStub", "listAllFile(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        List r11 = this.origin.listAllFile(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FileIDLStub", "listAllFile = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FileIDLStub", "listAllFile(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        d.f18654a.b("FileIDLStub", "listAllFile", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public boolean deleteFile(FilePath r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("FileIDLStub", "deleteFile(" + r21 + ")", e);
        g r2 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        k.f18677a.b("FileIDLStub", "deleteFile(" + r21 + ") = fail", r2, r4);
        d.f18654a.b("FileIDLStub", "deleteFile", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("FileIDLStub", "deleteFile(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        boolean r11 = this.origin.deleteFile(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("FileIDLStub", "deleteFile = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("FileIDLStub", "deleteFile(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        d.f18654a.b("FileIDLStub", "deleteFile", r14, r19);     // Catch: Exception -> L11
        return r11;
    }
}
