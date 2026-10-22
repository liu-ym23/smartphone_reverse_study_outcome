package kotlinx.coroutines.flow;

import Xa.c;
import Y8.t;
import Ya.k;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.a;
import p9.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/channels/a;", "", UxipConstants.f30680s, "LY8/t;", "<anonymous>", "(Lkotlinx/coroutines/channels/a;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", l = {236}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements p<kotlinx.coroutines.channels.a<? extends Object>, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f36416a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36417b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36418c;

    /* renamed from: d, reason: collision with root package name */
    public int f36419d;

    /* renamed from: e, reason: collision with root package name */
    public int f36420e;

    /* renamed from: f, reason: collision with root package name */
    public int f36421f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f36422g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<Object> f36423h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c<T> f36424i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref$ObjectRef<Object> ref$ObjectRef, c<? super T> cVar, InterfaceC4014c<? super FlowKt__DelayKt$debounceInternal$1$3$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36423h = ref$ObjectRef;
        this.f36424i = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.f36423h, this.f36424i, interfaceC4014c);
        flowKt__DelayKt$debounceInternal$1$3$2.f36422g = ((kotlinx.coroutines.channels.a) obj).getHolder();
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    public final Object f(Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(kotlinx.coroutines.channels.a.b(obj), interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.a<? extends Object> aVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return f(aVar.getHolder(), interfaceC4014c);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4, types: [T, Za.C] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref$ObjectRef<Object> ref$ObjectRef;
        Ref$ObjectRef<Object> ref$ObjectRef2;
        ?? r02 = this.f36422g;
        Object objG = C4063a.g();
        int i10 = this.f36421f;
        if (i10 == 0) {
            C4849c.b(obj);
            ref$ObjectRef = this.f36423h;
            boolean z10 = r02 instanceof a.c;
            if (!z10) {
                ref$ObjectRef.f34820a = r02;
            }
            c<T> cVar = this.f36424i;
            if (z10) {
                Throwable thE = kotlinx.coroutines.channels.a.e(r02);
                if (thE != null) {
                    throw thE;
                }
                Object obj2 = ref$ObjectRef.f34820a;
                if (obj2 != null) {
                    if (obj2 == k.f7051a) {
                        obj2 = null;
                    }
                    this.f36422g = h.a(r02);
                    this.f36416a = r02;
                    this.f36417b = ref$ObjectRef;
                    this.f36418c = h.a(thE);
                    this.f36419d = 0;
                    this.f36420e = 0;
                    this.f36421f = 1;
                    if (cVar.emit(obj2, this) == objG) {
                        return objG;
                    }
                    ref$ObjectRef2 = ref$ObjectRef;
                }
                ref$ObjectRef.f34820a = k.f7053c;
            }
            return t.f7040a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ref$ObjectRef2 = (Ref$ObjectRef) this.f36417b;
        C4849c.b(obj);
        ref$ObjectRef = ref$ObjectRef2;
        ref$ObjectRef.f34820a = k.f7053c;
        return t.f7040a;
    }
}
