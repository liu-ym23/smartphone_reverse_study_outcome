package Z2;

import ch.qos.logback.core.CoreConstants;
import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: Z2.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0143q {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2232a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC0124f f2233b;

    /* renamed from: c, reason: collision with root package name */
    public final Function1 f2234c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2235d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f2236e;

    public /* synthetic */ C0143q(Object obj, AbstractC0124f abstractC0124f, Function1 function1, CancellationException cancellationException, int i4) {
        this(obj, (i4 & 2) != 0 ? null : abstractC0124f, (i4 & 4) != 0 ? null : function1, (Object) null, (i4 & 16) != 0 ? null : cancellationException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Throwable] */
    public static C0143q a(C0143q c0143q, AbstractC0124f abstractC0124f, CancellationException cancellationException, int i4) {
        Object obj = c0143q.f2232a;
        if ((i4 & 2) != 0) {
            abstractC0124f = c0143q.f2233b;
        }
        AbstractC0124f abstractC0124f2 = abstractC0124f;
        Function1 function1 = c0143q.f2234c;
        Object obj2 = c0143q.f2235d;
        CancellationException cancellationException2 = cancellationException;
        if ((i4 & 16) != 0) {
            cancellationException2 = c0143q.f2236e;
        }
        c0143q.getClass();
        return new C0143q(obj, abstractC0124f2, function1, obj2, cancellationException2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0143q)) {
            return false;
        }
        C0143q c0143q = (C0143q) obj;
        return Intrinsics.areEqual(this.f2232a, c0143q.f2232a) && Intrinsics.areEqual(this.f2233b, c0143q.f2233b) && Intrinsics.areEqual(this.f2234c, c0143q.f2234c) && Intrinsics.areEqual(this.f2235d, c0143q.f2235d) && Intrinsics.areEqual(this.f2236e, c0143q.f2236e);
    }

    public final int hashCode() {
        Object obj = this.f2232a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        AbstractC0124f abstractC0124f = this.f2233b;
        int iHashCode2 = (iHashCode + (abstractC0124f == null ? 0 : abstractC0124f.hashCode())) * 31;
        Function1 function1 = this.f2234c;
        int iHashCode3 = (iHashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.f2235d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f2236e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f2232a + ", cancelHandler=" + this.f2233b + ", onCancellation=" + this.f2234c + ", idempotentResume=" + this.f2235d + ", cancelCause=" + this.f2236e + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public C0143q(Object obj, AbstractC0124f abstractC0124f, Function1 function1, Object obj2, Throwable th) {
        this.f2232a = obj;
        this.f2233b = abstractC0124f;
        this.f2234c = function1;
        this.f2235d = obj2;
        this.f2236e = th;
    }
}
