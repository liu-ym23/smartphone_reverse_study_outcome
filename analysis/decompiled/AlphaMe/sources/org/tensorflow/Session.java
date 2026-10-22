package org.tensorflow;

import androidx.appcompat.widget.C0238z;
import java.util.ArrayList;
import r3.b;

/* loaded from: classes2.dex */
public final class Session implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Graph f13819a;

    /* renamed from: b, reason: collision with root package name */
    public final b f13820b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13821c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public long f13822d;

    /* renamed from: e, reason: collision with root package name */
    public int f13823e;

    public Session(Graph graph) {
        this.f13819a = graph;
        b bVar = new b(graph);
        try {
            this.f13822d = allocate(bVar.a());
            this.f13820b = new b(graph);
        } finally {
            bVar.close();
        }
    }

    private static native long allocate(long j4);

    private static native void delete(long j4);

    /* JADX INFO: Access modifiers changed from: private */
    public static native byte[] run(long j4, byte[] bArr, long[] jArr, long[] jArr2, int[] iArr, long[] jArr3, int[] iArr2, long[] jArr4, boolean z4, long[] jArr5);

    public final C0238z b() {
        C0238z c0238z = new C0238z();
        c0238z.f3217f = this;
        c0238z.f3212a = new ArrayList();
        c0238z.f3213b = new ArrayList();
        c0238z.f3214c = new ArrayList();
        c0238z.f3215d = new ArrayList();
        c0238z.f3216e = null;
        return c0238z;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f13820b.close();
        synchronized (this.f13821c) {
            try {
                if (this.f13822d == 0) {
                    return;
                }
                while (this.f13823e > 0) {
                    try {
                        this.f13821c.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                delete(this.f13822d);
                this.f13822d = 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
