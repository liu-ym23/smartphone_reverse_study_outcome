package com.bytedance.common.wschannel.c.b;

/* JADX INFO: compiled from: HeartBeatMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f6804a;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.c.b.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: HeartBeatMonitor.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.c.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeartBeatMonitor.java */
    private static final class C0153a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f6805a = null;

        static /* synthetic */ a a() {
            return f6805a;
        }

        static {
            f6805a = new a(null);
        }
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    private a() {
    }

    public static a a() {
        return C0153a.a();
    }

    @Override // com.bytedance.common.wschannel.c.b.b
    public void b() {
        b r0 = this.f6804a;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.common.wschannel.c.b.b
    public void c() {
        b r0 = this.f6804a;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.bytedance.common.wschannel.c.b.b
    public void a(Throwable r1) {
        b r0 = this.f6804a;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }
}
