package androidx.room.coroutines;

import Ua.M;
import Y8.t;
import c1.h;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.room.coroutines.Pool$acquireWithTimeout$2", f = "ConnectionPoolImpl.kt", l = {231}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class Pool$acquireWithTimeout$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f14746a;

    /* renamed from: b, reason: collision with root package name */
    public int f14747b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<h> f14748c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Pool f14749d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pool$acquireWithTimeout$2(Ref$ObjectRef<h> ref$ObjectRef, Pool pool, InterfaceC4014c<? super Pool$acquireWithTimeout$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14748c = ref$ObjectRef;
        this.f14749d = pool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new Pool$acquireWithTimeout$2(this.f14748c, this.f14749d, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((Pool$acquireWithTimeout$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        T t10;
        Ref$ObjectRef<h> ref$ObjectRef;
        Object objG = C4063a.g();
        int i10 = this.f14747b;
        if (i10 == 0) {
            C4849c.b(obj);
            Ref$ObjectRef<h> ref$ObjectRef2 = this.f14748c;
            Pool pool = this.f14749d;
            this.f14746a = ref$ObjectRef2;
            this.f14747b = 1;
            Object objA = pool.a(this);
            if (objA == objG) {
                return objG;
            }
            t10 = objA;
            ref$ObjectRef = ref$ObjectRef2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) this.f14746a;
            C4849c.b(obj);
            t10 = obj;
        }
        ref$ObjectRef.f34820a = t10;
        return t.f7040a;
    }
}
