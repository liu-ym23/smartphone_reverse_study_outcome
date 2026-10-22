package kotlinx.coroutines.flow.internal;

import Ua.M;
import Xa.c;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", l = {47}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class FlowCoroutineKt$scopedFlow$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f36752a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36753b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q<M, c<? super R>, InterfaceC4014c<? super t>, Object> f36754c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c<R> f36755d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowCoroutineKt$scopedFlow$1$1(q<? super M, ? super c<? super R>, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, c<? super R> cVar, InterfaceC4014c<? super FlowCoroutineKt$scopedFlow$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36754c = qVar;
        this.f36755d = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(this.f36754c, this.f36755d, interfaceC4014c);
        flowCoroutineKt$scopedFlow$1$1.f36753b = obj;
        return flowCoroutineKt$scopedFlow$1$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FlowCoroutineKt$scopedFlow$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        M m10 = (M) this.f36753b;
        Object objG = C4063a.g();
        int i10 = this.f36752a;
        if (i10 == 0) {
            C4849c.b(obj);
            q<M, c<? super R>, InterfaceC4014c<? super t>, Object> qVar = this.f36754c;
            Object obj2 = this.f36755d;
            this.f36753b = h.a(m10);
            this.f36752a = 1;
            if (qVar.invoke(m10, obj2, this) == objG) {
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
