package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public abstract class Worker extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.work.impl.utils.futures.a f5374e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Worker f5375a;

        public a(Worker r10) {
            this.f5375a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a r10 = this.f5375a.n();     // Catch: Throwable -> L4
            this.f5375a.f5374e.p(r10);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            this.f5375a.f5374e.q(th);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.work.impl.utils.futures.a f5376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Worker f5377b;

        public b(Worker r10, androidx.work.impl.utils.futures.a r11) {
            this.f5377b = r10;
            this.f5376a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            d r10 = this.f5377b.o();     // Catch: Throwable -> L4
            this.f5376a.p(r10);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            this.f5376a.q(th);
        }
    }

    public Worker(@NonNull Context r10, @NonNull WorkerParameters r11) {
        super(r10, r11);
    }

    @Override // androidx.work.h
    public ListenableFuture c() {
        androidx.work.impl.utils.futures.a r10 = androidx.work.impl.utils.futures.a.t();
        b().execute(new b(this, r10));
        return r10;
    }

    @Override // androidx.work.h
    public final ListenableFuture l() {
        this.f5374e = androidx.work.impl.utils.futures.a.t();
        b().execute(new a(this));
        return this.f5374e;
    }

    public abstract h.a n();

    public d o() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
    }
}
