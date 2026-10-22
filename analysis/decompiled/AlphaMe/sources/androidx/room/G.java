package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public abstract class G {

    @NotNull
    private final A database;

    @NotNull
    private final AtomicBoolean lock;

    @NotNull
    private final Lazy stmt$delegate;

    public G(A database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.database = database;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = LazyKt.lazy(new S.A(3, this));
    }

    @NotNull
    public k0.j acquire() {
        assertNotMainThread();
        if (this.lock.compareAndSet(false, true)) {
            return (k0.j) this.stmt$delegate.getValue();
        }
        return this.database.compileStatement(createQuery());
    }

    public void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    public abstract String createQuery();

    public void release(@NotNull k0.j statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        if (statement == ((k0.j) this.stmt$delegate.getValue())) {
            this.lock.set(false);
        }
    }
}
