package com.bytedance.android.chunkstreamprediction.network;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f42525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f42526b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f42527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile long f42528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile long f42529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f42530d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f42531e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile long f42532f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile int f42533g;

        public final String toString() {
            return super.toString() + ", startTs: " + this.f42527a + ", endTs: " + this.f42532f + ", readFinishTs: " + this.f42529c + ", deserializeFinishTs: " + this.f42530d + ", distributeFinishTs: " + this.f42531e + ", byteCount: " + this.f42533g;
        }

        public a() {
        }
    }

    public final synchronized List<a> a() {
        monitor-enter(this);
        List<a> r100 = this.f42525a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public c() {
        this.f42525a = new ArrayList();
    }

    public c(List<a> r100, long r101) {
        this.f42525a = new ArrayList(r100);
        this.f42526b = r101;
    }
}
