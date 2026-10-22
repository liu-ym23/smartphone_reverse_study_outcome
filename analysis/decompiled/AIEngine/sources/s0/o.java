package s0;

import android.os.Handler;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o<T> implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public h f11869a;

    /* renamed from: b, reason: collision with root package name */
    public i f11870b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f11871c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f11872a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f11873b;

        public a(i iVar, Object obj) {
            this.f11872a = iVar;
            this.f11873b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f11872a.accept(this.f11873b);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        try {
            objCall = this.f11869a.call();
        } catch (Exception unused) {
            objCall = null;
        }
        this.f11871c.post(new a(this.f11870b, objCall));
    }
}
