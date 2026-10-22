package m;

import android.os.Handler;
import androidx.datastore.preferences.protobuf.f;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: b, reason: collision with root package name */
    public final Object f10434b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f10435c = Executors.newFixedThreadPool(4, new a());

    /* renamed from: d, reason: collision with root package name */
    public volatile Handler f10436d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f10437a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f10437a.getAndIncrement());
            return thread;
        }
    }
}
