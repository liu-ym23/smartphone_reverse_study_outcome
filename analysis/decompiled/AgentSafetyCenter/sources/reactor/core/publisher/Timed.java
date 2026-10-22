package reactor.core.publisher;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public interface Timed<T> extends Supplier<T> {
    Duration elapsed();

    Duration elapsedSinceSubscription();

    @Override // java.util.function.Supplier
    T get();

    Instant timestamp();
}
