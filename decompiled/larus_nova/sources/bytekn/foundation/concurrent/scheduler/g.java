package bytekn.foundation.concurrent.scheduler;

import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements i {

    public static final class a implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Handler f21744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f21745b;

        public a() {
            this.f21744a = new Handler(Looper.getMainLooper());
            this.f21745b = new Object();
        }

        @Override // bytekn.foundation.concurrent.scheduler.i.a
        public final void a(long r100, Function0<Unit> r101) {
            if (this.f21744a == null) goto L14;
            Object r102 = this.f21745b;
            monitor-enter(r102);
            Handler r103 = this.f21744a;     // Catch: Throwable -> L11
            if (r103 == null) goto L9;
            r103.postDelayed(new h(r101), r100);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r102);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    public g() {
    }

    @Override // bytekn.foundation.concurrent.scheduler.i
    public final i.a a() {
        return new a();
    }
}
