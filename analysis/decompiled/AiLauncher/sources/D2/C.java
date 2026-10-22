package D2;

import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2205a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public Queue f2206b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2207c;

    public final void a(B b10) {
        synchronized (this.f2205a) {
            try {
                if (this.f2206b == null) {
                    this.f2206b = new ArrayDeque();
                }
                this.f2206b.add(b10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(i iVar) {
        B b10;
        synchronized (this.f2205a) {
            if (this.f2206b != null && !this.f2207c) {
                this.f2207c = true;
                while (true) {
                    synchronized (this.f2205a) {
                        try {
                            b10 = (B) this.f2206b.poll();
                            if (b10 == null) {
                                this.f2207c = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    b10.c(iVar);
                }
            }
        }
    }
}
