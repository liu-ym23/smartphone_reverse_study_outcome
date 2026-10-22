package r3;

import com.google.android.gms.common.internal.C1669j;
import java.io.Closeable;

/* renamed from: r3.H, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5206H implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f38757a;

    public /* synthetic */ C5206H(m mVar, C5205G c5205g) {
        this.f38757a = mVar;
        C1669j.n(((Thread) mVar.f38805d.getAndSet(Thread.currentThread())) == null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f38757a.f38805d.set(null);
        this.f38757a.d();
    }
}
