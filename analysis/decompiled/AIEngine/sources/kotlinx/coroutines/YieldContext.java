package kotlinx.coroutines;

import kotlin.coroutines.a;
import kotlin.coroutines.d;
import kotlin.jvm.internal.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class YieldContext extends a {
    public static final Key Key = new Key(null);
    public boolean dispatcherWasUnconfined;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Key implements d.b<YieldContext> {
        public /* synthetic */ Key(e eVar) {
            this();
        }

        private Key() {
        }
    }

    public YieldContext() {
        super(Key);
    }
}
