package S;

import Z2.C0141o;
import Z2.InterfaceC0140n;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class p extends q {

    /* renamed from: a, reason: collision with root package name */
    public final Function2 f1764a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0140n f1765b;

    /* renamed from: c, reason: collision with root package name */
    public final N f1766c;

    /* renamed from: d, reason: collision with root package name */
    public final CoroutineContext f1767d;

    public p(Function2 transform, C0141o ack, N n4, CoroutineContext callerContext) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(ack, "ack");
        Intrinsics.checkNotNullParameter(callerContext, "callerContext");
        this.f1764a = transform;
        this.f1765b = ack;
        this.f1766c = n4;
        this.f1767d = callerContext;
    }
}
