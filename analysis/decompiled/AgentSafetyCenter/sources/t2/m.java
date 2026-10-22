package t2;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m implements l7.a {

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f13164c;

    /* renamed from: f, reason: collision with root package name */
    public l f13165f;

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        j jVar = (j) this.f13164c.get();
        boolean zCancel = this.f13165f.cancel(z10);
        if (zCancel && jVar != null) {
            jVar.f13159a = null;
            jVar.f13160b = null;
            jVar.f13161c.j(null);
        }
        return zCancel;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f13165f.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f13165f.f13156c instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f13165f.isDone();
    }

    public final String toString() {
        return this.f13165f.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) {
        return this.f13165f.get(j10, timeUnit);
    }
}
