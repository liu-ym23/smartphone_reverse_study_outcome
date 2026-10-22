package kotlinx.coroutines.flow.internal;

import Ua.M;
import Xa.b;
import Xa.c;
import Y8.t;
import Ya.o;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge$collectTo$2$1", f = "Merge.kt", l = {92}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class ChannelLimitedFlowMerge$collectTo$2$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f36722a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b<T> f36723b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o<T> f36724c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelLimitedFlowMerge$collectTo$2$1(b<? extends T> bVar, o<T> oVar, InterfaceC4014c<? super ChannelLimitedFlowMerge$collectTo$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36723b = bVar;
        this.f36724c = oVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChannelLimitedFlowMerge$collectTo$2$1(this.f36723b, this.f36724c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ChannelLimitedFlowMerge$collectTo$2$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f36722a;
        if (i10 == 0) {
            C4849c.b(obj);
            b<T> bVar = this.f36723b;
            c cVar = this.f36724c;
            this.f36722a = 1;
            if (bVar.collect(cVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
