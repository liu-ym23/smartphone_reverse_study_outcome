package kotlinx.coroutines;

import kotlin.coroutines.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface CoroutineExceptionHandler extends d.a {
    public static final Key Key = Key.$$INSTANCE;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Key implements d.b<CoroutineExceptionHandler> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    void handleException(d dVar, Throwable th);
}
