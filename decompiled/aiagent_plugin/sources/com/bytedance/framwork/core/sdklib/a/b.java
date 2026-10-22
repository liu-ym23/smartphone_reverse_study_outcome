package com.bytedance.framwork.core.sdklib.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: LogFile.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f8591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<c> f8592d;

    public b(int r3, int r4, List<c> r5) {
        List<c> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f8589a = r3;
        this.f8590b = r4;
        this.f8592d = r6;
    }

    public int a() {
        return this.f8590b;
    }

    public List<c> b() {
        return this.f8592d;
    }

    public File c() {
        return this.f8591c;
    }

    public static b a(ByteBuffer r15) {
    L15:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "construct LogFile failed.", th);
        return null;
    L4:
        if (r15.getInt() == 1095781686) goto L6;
        return null;
    L6:
        r15.getInt();     // Catch: Throwable -> L15
        int r3 = r15.getInt();     // Catch: Throwable -> L15
        int r4 = r15.getInt();     // Catch: Throwable -> L15
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L15
        int r6 = 0;
        int r7 = 0;
    L7:
        if (r6 >= r3) goto L14;
        int r8 = r15.getInt();     // Catch: Throwable -> L15
        r7 = r7 + r8;     // Catch: Throwable -> L15
        if (r7 > r4) goto L10;
        long r10 = r15.getLong();     // Catch: Throwable -> L15
        long r12 = r15.getLong();     // Catch: Throwable -> L15
        byte[] r9 = new byte[r8];     // Catch: Throwable -> L15
        r15.get(r9);     // Catch: Throwable -> L15
        r5.add(new c(r9, r10, r12));     // Catch: Throwable -> L15
        r6 = r6 + 1;     // Catch: Throwable -> L15
        goto L7
    L10:
        com.bytedance.framwork.core.sdklib.a.c.d.c("APM-SDK", "construct LogFile failed.");     // Catch: Throwable -> L15
        return null;
    L14:
        return new b(r3, r4, r5);
    }

    public static b a(File r2) {
        byte[] r1 = com.bytedance.apm6.util.c.a(r2);     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        b r3 = a(ByteBuffer.wrap(r1));     // Catch: Throwable -> L12
        if (r3 == null) goto L8;
        r3.f8591c = r2;     // Catch: Throwable -> L12
    L9:
        return r3;
    L8:
        com.bytedance.framwork.core.sdklib.a.c.d.c("APM-SDK", "fromMemory bytes is null");     // Catch: Throwable -> L12
        goto L9
    L10:
        com.bytedance.framwork.core.sdklib.a.c.d.c("APM-SDK", "fromFile bytes is null");     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.a.c.d.a("APM-SDK", "fromFile", th);
        return null;
    }

    public String toString() {
        return "LogFile{totalCount=" + this.f8589a + ", totalBytes=" + this.f8590b + ", source=" + this.f8591c + ", logList=" + this.f8592d + '}';
    }
}
