package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.coroutines.b;
import kotlin.coroutines.d;
import kotlin.jvm.internal.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable, AutoCloseable {
    public static final Key Key = new Key(null);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Key extends b<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        public /* synthetic */ Key(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ExecutorCoroutineDispatcher _init_$lambda$0(d.a aVar) {
            if (aVar instanceof ExecutorCoroutineDispatcher) {
                return (ExecutorCoroutineDispatcher) aVar;
            }
            return null;
        }

        private Key() {
            super(CoroutineDispatcher.Key, new com.stepos.core.common.cloud.d(28));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();
}
