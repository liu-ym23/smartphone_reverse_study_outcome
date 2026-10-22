package com.bytedance.apm6.consumer.slardar.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: LogFile.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f5094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<b> f5095e;

    public a(long r3, int r5, int r6, List<b> r7) {
        List<b> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.f5091a = r3;
        this.f5092b = r5;
        this.f5093c = r6;
        this.f5095e = r8;
    }

    public long a() {
        return this.f5091a;
    }

    public int b() {
        return this.f5092b;
    }

    public int c() {
        return this.f5093c;
    }

    public List<b> d() {
        return this.f5095e;
    }

    public File e() {
        return this.f5094d;
    }

    public static a a(ByteBuffer r10) {
    L14:
        return null;
    L4:
        if (r10.getShort() == 2082) goto L6;
        return null;
    L6:
        long r4 = r10.getLong();     // Catch: Throwable -> L14
        int r6 = r10.getInt();     // Catch: Throwable -> L14
        int r7 = r10.getInt();     // Catch: Throwable -> L14
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L14
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r6) goto L12;
        int r3 = r10.getInt();     // Catch: Throwable -> L14
        r2 = r2 + r3;     // Catch: Throwable -> L14
        if (r2 > r7) goto L10;
        byte[] r5 = new byte[r3];     // Catch: Throwable -> L14
        r10.get(r5);     // Catch: Throwable -> L14
        r8.add(new b(r5));     // Catch: Throwable -> L14
        r1 = r1 + 1;     // Catch: Throwable -> L14
        goto L7
    L10:
        return null;
    L12:
        return new a(r4, r6, r7, r8);
    }

    public static a a(File r2) {
        byte[] r0 = com.bytedance.apm6.util.c.a(r2);     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        a r1 = a(ByteBuffer.wrap(r0));     // Catch: Throwable -> L11
        if (r1 == null) goto L7;
        r1.f5094d = r2;     // Catch: Throwable -> L11
    L8:
        return r1;
    L7:
        com.bytedance.apm6.util.c.b.d(com.bytedance.apm6.consumer.slardar.a.f5054a, "fromMemory bytes is null");     // Catch: Throwable -> L11
        goto L8
    L9:
        com.bytedance.apm6.util.c.b.d(com.bytedance.apm6.consumer.slardar.a.f5054a, "fromFile bytes is null");     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "fromFile", th);
        return null;
    }

    public String toString() {
        return "LogFile{startID=" + this.f5091a + ", totalCount=" + this.f5092b + ", totalBytes=" + this.f5093c + ", source=" + this.f5094d + ", logList=" + this.f5095e + '}';
    }
}
