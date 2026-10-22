package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b0 extends kotlin.coroutines.a implements ThreadContextElement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21316b = null;

    public static final class a implements CoroutineContext.Key {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f21316b = new a(null);
    }

    public abstract long a();
}
