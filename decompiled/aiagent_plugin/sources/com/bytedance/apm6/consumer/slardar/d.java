package com.bytedance.apm6.consumer.slardar;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: SeqNumGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MappedByteBuffer f5105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f5106b;

    /* JADX INFO: compiled from: SeqNumGenerator.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f5107a = null;

        static /* synthetic */ d a() {
            return f5107a;
        }

        static {
            f5107a = new d();
        }
    }

    public d() {
        this.f5106b = 0;
    }

    public static d a() {
        return a.a();
    }

    public long b() {
        if (this.f5105a == null) goto L19;
    L13:
        MappedByteBuffer r0 = this.f5105a;
        if (r0 == null) goto L17;
        long r4 = r0.getLong(0) + 1;
        this.f5106b = r4;
        this.f5105a.putLong(0, r4);
        return this.f5106b;
    L17:
        long r1 = this.f5106b;
        this.f5106b = 1 + r1;
        return r1;
    L19:
        File r2 = new File(b.b(), com.bytedance.apm6.foundation.context.a.f().replace(".", "_").replace(":", "-") + "_seq_num.txt");     // Catch: Throwable -> L11
        boolean r3 = r2.exists();     // Catch: Throwable -> L11
        if (r3 == true) goto L7;
        r2.createNewFile();     // Catch: Throwable -> L11
    L7:
        MappedByteBuffer r5 = new RandomAccessFile(r2, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 8);     // Catch: Throwable -> L11
        this.f5105a = r5;     // Catch: Throwable -> L11
        if (r3 == true) goto L13;
        r5.putLong(0, 0);     // Catch: Throwable -> L11
        return 0;
    L11:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "prepare seq_number fail.", th);
        goto L13
    }
}
