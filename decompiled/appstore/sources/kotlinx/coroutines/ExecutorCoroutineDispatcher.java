package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Key f21282c = null;

    public static final class Key extends kotlin.coroutines.b {
        public /* synthetic */ Key(DefaultConstructorMarker r10) {
            this();
        }

        public Key() {
            super(CoroutineDispatcher.f21279b, AnonymousClass1.INSTANCE);
        }
    }

    static {
        f21282c = new Key(null);
    }

    public ExecutorCoroutineDispatcher() {
    }
}
