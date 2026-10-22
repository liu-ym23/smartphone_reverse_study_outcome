package kotlinx.coroutines.flow;

import Xa.b;
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

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LWa/p;", "", "LY8/t;", "<anonymous>", "(LWa/p;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", f = "Delay.kt", l = {204}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__DelayKt$debounceInternal$1$values$1 extends SuspendLambda implements p<Wa.p<? super Object>, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f36425a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36426b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b<T> f36427c;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Wa.p<Object> f36428a;

        public AnonymousClass1(Wa.p<Object> pVar) {
            this.f36428a = pVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // Xa.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) r0
                int r1 = r0.f36432d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f36432d = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f36430b
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.f36432d
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.C4849c.b(r6)
                goto L4b
            L29:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L31:
                kotlin.C4849c.b(r6)
                Wa.p<java.lang.Object> r4 = r4.f36428a
                if (r5 != 0) goto L3b
                Za.C r6 = Ya.k.f7051a
                goto L3c
            L3b:
                r6 = r5
            L3c:
                java.lang.Object r5 = g9.h.a(r5)
                r0.f36429a = r5
                r0.f36432d = r3
                java.lang.Object r4 = r4.send(r6, r0)
                if (r4 != r1) goto L4b
                return r1
            L4b:
                Y8.t r4 = Y8.t.f7040a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1.AnonymousClass1.emit(java.lang.Object, e9.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$values$1(b<? extends T> bVar, InterfaceC4014c<? super FlowKt__DelayKt$debounceInternal$1$values$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36427c = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        FlowKt__DelayKt$debounceInternal$1$values$1 flowKt__DelayKt$debounceInternal$1$values$1 = new FlowKt__DelayKt$debounceInternal$1$values$1(this.f36427c, interfaceC4014c);
        flowKt__DelayKt$debounceInternal$1$values$1.f36426b = obj;
        return flowKt__DelayKt$debounceInternal$1$values$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Wa.p<Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FlowKt__DelayKt$debounceInternal$1$values$1) create(pVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Wa.p pVar = (Wa.p) this.f36426b;
        Object objG = C4063a.g();
        int i10 = this.f36425a;
        if (i10 == 0) {
            C4849c.b(obj);
            b<T> bVar = this.f36427c;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(pVar);
            this.f36426b = h.a(pVar);
            this.f36425a = 1;
            if (bVar.collect(anonymousClass1, this) == objG) {
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

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Wa.p<? super Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return invoke2((Wa.p<Object>) pVar, interfaceC4014c);
    }
}
