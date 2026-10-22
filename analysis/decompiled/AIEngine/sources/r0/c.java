package r0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Deprecated
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11673a;

    /* renamed from: b, reason: collision with root package name */
    public a f11674b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11675c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void onCancel();
    }

    public final void a(a aVar) {
        synchronized (this) {
            while (this.f11675c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (this.f11674b == aVar) {
                return;
            }
            this.f11674b = aVar;
            if (this.f11673a) {
                aVar.onCancel();
            }
        }
    }
}
