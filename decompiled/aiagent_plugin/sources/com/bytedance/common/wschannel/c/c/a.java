package com.bytedance.common.wschannel.c.c;

/* JADX INFO: compiled from: NormalHeartBeatMeta.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.common.wschannel.c.a.b<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6807b;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.c.c.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: NormalHeartBeatMeta.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.c.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NormalHeartBeatMeta.java */
    private static class C0154a extends a {
        /* synthetic */ C0154a(AnonymousClass1 r1) {
            this();
        }

        private C0154a() {
            super(-1, 5000);
        }
    }

    public a() {
    }

    public a(long r1, long r3) {
        this.f6806a = r1;
        this.f6807b = r3;
    }

    public long a() {
        return this.f6806a;
    }

    void a(long r1) {
        this.f6806a = r1;
    }

    public long b() {
        return this.f6807b;
    }

    public a c() {
        return new C0154a(null);
    }
}
