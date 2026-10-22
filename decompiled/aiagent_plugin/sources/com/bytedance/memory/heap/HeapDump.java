package com.bytedance.memory.heap;

import com.bytedance.memory.b.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class HeapDump implements Serializable {
    public boolean computeRetainedHeapSize;
    public long currentTime;
    public final long gcDurationMs;
    public final long heapDumpDurationMs;
    public File heapDumpFile;
    public long heapDumpFileSize;
    public boolean isDebug;
    public String referenceClassName;
    public final String referenceKey;
    public final String referenceName;
    public String shrinkFilePath;
    public final long watchDurationMs;

    /* JADX INFO: renamed from: com.bytedance.memory.heap.HeapDump$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f8834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        File f8835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f8836c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f8837d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f8838e;
        String f;
        long g;
        long h;
        long i;
        boolean j;
        long k;

        a() {
            this.f8835b = null;
            this.f8838e = null;
            this.f8834a = true;
            this.f = "";
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = true;
        }

        public a a(long r1) {
            this.k = r1;
            return this;
        }

        public a a(boolean r1) {
            this.f8834a = r1;
            return this;
        }

        public a a(File r3) {
            this.f8835b = (File) ZeusTransformUtils.preCheckCast(g.a(r3, "heapDumpFile"), File.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(String r1) {
            this.f8837d = r1;
            return this;
        }

        public a b(long r1) {
            this.f8836c = r1;
            return this;
        }

        public a b(boolean r1) {
            this.f8834a = r1;
            return this;
        }

        public a b(String r3) {
            this.f8838e = (String) ZeusTransformUtils.preCheckCast(g.a(r3, "referenceKey"), String.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a c(String r3) {
            this.f = (String) ZeusTransformUtils.preCheckCast(g.a(r3, "referenceName"), String.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a c(long r1) {
            this.g = r1;
            return this;
        }

        public a d(long r1) {
            this.h = r1;
            return this;
        }

        public a e(long r1) {
            this.i = r1;
            return this;
        }

        public a c(boolean r1) {
            this.j = r1;
            return this;
        }

        public HeapDump a() {
            g.a(this.f8835b, "heapDumpFile");
            return new HeapDump(this, null);
        }
    }

    /* synthetic */ HeapDump(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static a newBuilder() {
        return new a();
    }

    @Deprecated
    public HeapDump(File r2, String r3, String r4, long r5, long r7, long r9, boolean r11) {
        this(new a().a(r2).b(r3).c(r4).a(r11).c(true).c(r5).d(r7).e(r9));
    }

    private HeapDump(a r3) {
        this.isDebug = true;
        this.computeRetainedHeapSize = true;
        this.isDebug = r3.f8834a;
        this.currentTime = r3.k;
        this.heapDumpFile = r3.f8835b;
        this.referenceKey = r3.f8838e;
        this.referenceName = r3.f;
        this.computeRetainedHeapSize = r3.j;
        this.watchDurationMs = r3.g;
        this.shrinkFilePath = r3.f8837d;
        this.gcDurationMs = r3.h;
        this.heapDumpDurationMs = r3.i;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(" heapDumpFilePath ").append(this.heapDumpFile.getPath()).append("\n").append(" heapDumpFileSize ").append(this.heapDumpFile.length()).append("\n").append(" referenceName ").append(this.referenceName).append("\n").append(" isDebug ").append(this.isDebug).append("\n").append(" currentTime ").append(this.currentTime).append("\n").append(" watchDurationMs ").append(this.watchDurationMs).append("ms\n").append(" gcDurationMs ").append(this.gcDurationMs).append("ms\n").append(" shrinkFilePath ").append(this.shrinkFilePath).append("\n").append(" heapDumpDurationMs ").append(this.heapDumpDurationMs).append("ms\n");
        return r0.toString();
    }
}
