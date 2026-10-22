package retrofit2;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {119}, m = "suspendAndThrow")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KotlinExtensions$suspendAndThrow$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f39897a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f39898b;

    /* renamed from: c, reason: collision with root package name */
    public int f39899c;

    public KotlinExtensions$suspendAndThrow$1(InterfaceC4014c<? super KotlinExtensions$suspendAndThrow$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39898b = obj;
        this.f39899c |= Integer.MIN_VALUE;
        return KotlinExtensions.e(null, this);
    }
}
