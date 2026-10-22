package Z2;

import ch.qos.logback.core.CoreConstants;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class E extends AbstractCoroutineContextElement {

    /* renamed from: b, reason: collision with root package name */
    public static final D f2164b = new D();

    /* renamed from: a, reason: collision with root package name */
    public final String f2165a;

    public E(String str) {
        super(f2164b);
        this.f2165a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof E) && Intrinsics.areEqual(this.f2165a, ((E) obj).f2165a);
    }

    public final int hashCode() {
        return this.f2165a.hashCode();
    }

    public final String toString() {
        return B0.g.q(new StringBuilder("CoroutineName("), this.f2165a, CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }
}
