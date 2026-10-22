package kotlinx.coroutines.flow;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "kotlinx.coroutines.flow.StartedLazily$command$1$1", f = "SharingStarted.kt", l = {155}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartedLazily$command$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f36641a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36642b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StartedLazily$command$1$1<T> f36643c;

    /* renamed from: d, reason: collision with root package name */
    public int f36644d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StartedLazily$command$1$1$emit$1(StartedLazily$command$1$1<? super T> startedLazily$command$1$1, InterfaceC4014c<? super StartedLazily$command$1$1$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36643c = startedLazily$command$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36642b = obj;
        this.f36644d |= Integer.MIN_VALUE;
        return this.f36643c.b(0, this);
    }
}
