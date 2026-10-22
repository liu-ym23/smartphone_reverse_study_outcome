package C3;

import androidx.emoji2.text.flatbuffer.Utf8Old;
import com.fasterxml.jackson.core.util.JsonRecyclerPools;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.function.Supplier;
import reactor.core.scheduler.Schedulers;
import reactor.util.concurrent.Queues;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f284a;

    public /* synthetic */ a(int i) {
        this.f284a = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f284a) {
            case 0:
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                return contextClassLoader == null ? d.class.getClassLoader() : contextClassLoader;
            case 1:
                return Instant.now();
            case 2:
                return Utf8Old.lambda$static$0();
            case 3:
                return JsonRecyclerPools.ConcurrentDequePool.construct();
            case 4:
                return JsonRecyclerPools.LockFreePool.construct();
            case 5:
                return new LinkedHashMap();
            case 6:
                return Queues.lambda$static$3();
            case 7:
                return Queues.lambda$static$4();
            case 8:
                return Queues.lambda$static$5();
            case 9:
                return Queues.lambda$static$6();
            case 10:
                return Queues.lambda$static$7();
            case 11:
                return Queues.lambda$static$8();
            case 12:
                return Queues.lambda$unboundedMultiproducer$2();
            default:
                return Schedulers.parallel();
        }
    }
}
