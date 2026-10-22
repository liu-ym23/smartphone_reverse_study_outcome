package Z2;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: Z2.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0144s {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2240a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f2241b;

    public C0144s(Object obj, Function1 function1) {
        this.f2240a = obj;
        this.f2241b = function1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0144s)) {
            return false;
        }
        C0144s c0144s = (C0144s) obj;
        return Intrinsics.areEqual(this.f2240a, c0144s.f2240a) && Intrinsics.areEqual(this.f2241b, c0144s.f2241b);
    }

    public final int hashCode() {
        Object obj = this.f2240a;
        return this.f2241b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public final String toString() {
        return "CompletedWithCancellation(result=" + this.f2240a + ", onCancellation=" + this.f2241b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
