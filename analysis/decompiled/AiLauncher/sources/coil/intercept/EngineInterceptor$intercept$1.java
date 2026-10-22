package coil.intercept;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {75}, m = "intercept")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EngineInterceptor$intercept$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f15742a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15743b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f15744c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ EngineInterceptor f15745d;

    /* renamed from: e, reason: collision with root package name */
    public int f15746e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$intercept$1(EngineInterceptor engineInterceptor, InterfaceC4014c<? super EngineInterceptor$intercept$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f15745d = engineInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15744c = obj;
        this.f15746e |= Integer.MIN_VALUE;
        return this.f15745d.a(null, this);
    }
}
