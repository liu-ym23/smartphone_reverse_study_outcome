package kotlin.reflect.full;

import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KCallables$callSuspendBy$1<R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f34861a;

    /* renamed from: b, reason: collision with root package name */
    public Object f34862b;

    /* renamed from: c, reason: collision with root package name */
    public Object f34863c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f34864d;

    /* renamed from: e, reason: collision with root package name */
    public int f34865e;

    public KCallables$callSuspendBy$1(InterfaceC4014c<? super KCallables$callSuspendBy$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f34864d = obj;
        this.f34865e |= Integer.MIN_VALUE;
        return KCallables.a(null, null, this);
    }
}
