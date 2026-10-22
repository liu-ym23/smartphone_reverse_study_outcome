package kotlinx.coroutines.channels;

import Ua.M;
import Wa.s;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lkotlinx/coroutines/channels/a;", "LY8/t;", "<anonymous>", "(LUa/M;)Lkotlinx/coroutines/channels/a;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", l = {39}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super a<? extends t>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f36337a;

    /* renamed from: b, reason: collision with root package name */
    public int f36338b;

    /* renamed from: c, reason: collision with root package name */
    public int f36339c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f36340d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ s<E> f36341e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ E f36342f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__ChannelsKt$trySendBlocking$2(s<? super E> sVar, E e10, InterfaceC4014c<? super ChannelsKt__ChannelsKt$trySendBlocking$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36341e = sVar;
        this.f36342f = e10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.f36341e, this.f36342f, interfaceC4014c);
        channelsKt__ChannelsKt$trySendBlocking$2.f36340d = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super a<t>> interfaceC4014c) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        M m10 = (M) this.f36340d;
        Object objG = C4063a.g();
        int i10 = this.f36339c;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                s<E> sVar = this.f36341e;
                E e10 = this.f36342f;
                Result.Companion companion = Result.INSTANCE;
                this.f36340d = h.a(m10);
                this.f36337a = h.a(m10);
                this.f36338b = 0;
                this.f36339c = 1;
                if (sVar.send(e10, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return a.b(Result.h(objB) ? a.INSTANCE.c(t.f7040a) : a.INSTANCE.a(Result.e(objB)));
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super a<? extends t>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super a<t>>) interfaceC4014c);
    }
}
