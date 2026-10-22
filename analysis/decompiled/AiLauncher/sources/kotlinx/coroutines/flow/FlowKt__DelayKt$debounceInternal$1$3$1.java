package kotlinx.coroutines.flow;

import Xa.c;
import Y8.t;
import Ya.k;
import Za.C;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", l = {226}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f36413a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c<T> f36414b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<Object> f36415c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$1(c<? super T> cVar, Ref$ObjectRef<Object> ref$ObjectRef, InterfaceC4014c<? super FlowKt__DelayKt$debounceInternal$1$3$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f36414b = cVar;
        this.f36415c = ref$ObjectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(this.f36414b, this.f36415c, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f36413a;
        if (i10 == 0) {
            C4849c.b(obj);
            c<T> cVar = this.f36414b;
            C c10 = k.f7051a;
            Object obj2 = this.f36415c.f34820a;
            if (obj2 == c10) {
                obj2 = null;
            }
            this.f36413a = 1;
            if (cVar.emit(obj2, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        this.f36415c.f34820a = null;
        return t.f7040a;
    }
}
