package d3;

import Z2.F;
import ch.qos.logback.core.CoreConstants;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes2.dex */
public final class f implements F {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f12451a;

    public f(CoroutineContext coroutineContext) {
        this.f12451a = coroutineContext;
    }

    @Override // Z2.F
    public final CoroutineContext e() {
        return this.f12451a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f12451a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
