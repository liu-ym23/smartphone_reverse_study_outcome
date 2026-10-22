package androidx.room.coroutines;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import i1.InterfaceC4162d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import n9.C4946a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.room.coroutines.PassthroughConnection$usePrepared$2", f = "PassthroughConnectionPool.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PassthroughConnection$usePrepared$2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Object>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14711a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PassthroughConnection f14712b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f14713c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ InterfaceC5074l<InterfaceC4162d, R> f14714d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PassthroughConnection$usePrepared$2(PassthroughConnection passthroughConnection, String str, InterfaceC5074l<? super InterfaceC4162d, ? extends R> interfaceC5074l, InterfaceC4014c<? super PassthroughConnection$usePrepared$2> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f14712b = passthroughConnection;
        this.f14713c = str;
        this.f14714d = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new PassthroughConnection$usePrepared$2(this.f14712b, this.f14713c, this.f14714d, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InterfaceC4014c<Object> interfaceC4014c) {
        return ((PassthroughConnection$usePrepared$2) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        C4063a.g();
        if (this.f14711a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        InterfaceC4162d interfaceC4162dQ1 = this.f14712b.f().q1(this.f14713c);
        try {
            Object objInvoke = this.f14714d.invoke(interfaceC4162dQ1);
            C4946a.a(interfaceC4162dQ1, null);
            return objInvoke;
        } finally {
        }
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Object invoke(InterfaceC4014c<? super Object> interfaceC4014c) {
        return invoke2((InterfaceC4014c<Object>) interfaceC4014c);
    }
}
