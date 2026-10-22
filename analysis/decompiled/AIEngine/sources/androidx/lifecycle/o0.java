package androidx.lifecycle;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public final s f2295a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f2296b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public a f2297c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final s f2298a;

        /* renamed from: b, reason: collision with root package name */
        public final Lifecycle.Event f2299b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2300c;

        public a(s registry, Lifecycle.Event event) {
            kotlin.jvm.internal.g.f(registry, "registry");
            kotlin.jvm.internal.g.f(event, "event");
            this.f2298a = registry;
            this.f2299b = event;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f2300c) {
                return;
            }
            this.f2298a.f(this.f2299b);
            this.f2300c = true;
        }
    }

    public o0(u uVar) {
        this.f2295a = new s(uVar);
    }

    public final void a(Lifecycle.Event event) {
        a aVar = this.f2297c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.f2295a, event);
        this.f2297c = aVar2;
        this.f2296b.postAtFrontOfQueue(aVar2);
    }
}
