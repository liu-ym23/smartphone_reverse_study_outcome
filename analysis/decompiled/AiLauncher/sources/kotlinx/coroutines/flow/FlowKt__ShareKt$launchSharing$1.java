package kotlinx.coroutines.flow;

import Ua.M;
import Xa.b;
import Xa.j;
import Xa.o;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", l = {210, 214, 215, 221}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f36535a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f36536b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b<T> f36537c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j<T> f36538d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ T f36539e;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<Integer, InterfaceC4014c<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f36540a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ int f36541b;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
            anonymousClass1.f36541b = ((Number) obj).intValue();
            return anonymousClass1;
        }

        public final Object f(int i10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return ((AnonymousClass1) create(Integer.valueOf(i10), interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(Integer num, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return f(num.intValue(), interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i10 = this.f36541b;
            C4063a.g();
            if (this.f36540a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return C4109a.a(i10 > 0);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", "it", "LY8/t;", "<anonymous>", "(Lkotlinx/coroutines/flow/SharingCommand;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", l = {223}, m = "invokeSuspend", v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<SharingCommand, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f36542a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f36543b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b<T> f36544c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j<T> f36545d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ T f36546e;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$a */
        public static final /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f36547a;

            static {
                int[] iArr = new int[SharingCommand.values().length];
                try {
                    iArr[SharingCommand.START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SharingCommand.STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f36547a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(b<? extends T> bVar, j<T> jVar, T t10, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f36544c = bVar;
            this.f36545d = jVar;
            this.f36546e = t10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f36544c, this.f36545d, this.f36546e, interfaceC4014c);
            anonymousClass2.f36543b = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SharingCommand sharingCommand, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(sharingCommand, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            SharingCommand sharingCommand = (SharingCommand) this.f36543b;
            Object objG = C4063a.g();
            int i10 = this.f36542a;
            if (i10 == 0) {
                C4849c.b(obj);
                int i11 = a.f36547a[sharingCommand.ordinal()];
                if (i11 == 1) {
                    b<T> bVar = this.f36544c;
                    o oVar = this.f36545d;
                    this.f36543b = h.a(sharingCommand);
                    this.f36542a = 1;
                    if (bVar.collect(oVar, this) == objG) {
                        return objG;
                    }
                } else if (i11 != 2) {
                    if (i11 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    T t10 = this.f36546e;
                    if (t10 == Xa.p.f6900a) {
                        this.f36545d.e();
                    } else {
                        C4109a.a(this.f36545d.a(t10));
                    }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ShareKt$launchSharing$1(a aVar, b<? extends T> bVar, j<T> jVar, T t10, InterfaceC4014c<? super FlowKt__ShareKt$launchSharing$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36536b = aVar;
        this.f36537c = bVar;
        this.f36538d = jVar;
        this.f36539e = t10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FlowKt__ShareKt$launchSharing$1(this.f36536b, this.f36537c, this.f36538d, this.f36539e, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FlowKt__ShareKt$launchSharing$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
    
        if (r8.collect(r1, r7) == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
    
        if (r8.collect(r1, r7) != r0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
    
        if (Xa.d.j(r8, r1, r7) == r0) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.f36535a
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L25
            if (r1 == r5) goto L21
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L21
            if (r1 != r2) goto L15
            goto L21
        L15:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1d:
            kotlin.C4849c.b(r8)
            goto L5c
        L21:
            kotlin.C4849c.b(r8)
            goto L8d
        L25:
            kotlin.C4849c.b(r8)
            kotlinx.coroutines.flow.a r8 = r7.f36536b
            kotlinx.coroutines.flow.a$a r1 = kotlinx.coroutines.flow.a.INSTANCE
            kotlinx.coroutines.flow.a r6 = r1.c()
            if (r8 != r6) goto L3f
            Xa.b<T> r8 = r7.f36537c
            Xa.j<T> r1 = r7.f36538d
            r7.f36535a = r5
            java.lang.Object r7 = r8.collect(r1, r7)
            if (r7 != r0) goto L8d
            goto L8c
        L3f:
            kotlinx.coroutines.flow.a r8 = r7.f36536b
            kotlinx.coroutines.flow.a r1 = r1.d()
            r5 = 0
            if (r8 != r1) goto L69
            Xa.j<T> r8 = r7.f36538d
            Xa.t r8 = r8.c()
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1
            r1.<init>(r5)
            r7.f36535a = r4
            java.lang.Object r8 = Xa.d.z(r8, r1, r7)
            if (r8 != r0) goto L5c
            goto L8c
        L5c:
            Xa.b<T> r8 = r7.f36537c
            Xa.j<T> r1 = r7.f36538d
            r7.f36535a = r3
            java.lang.Object r7 = r8.collect(r1, r7)
            if (r7 != r0) goto L8d
            goto L8c
        L69:
            kotlinx.coroutines.flow.a r8 = r7.f36536b
            Xa.j<T> r1 = r7.f36538d
            Xa.t r1 = r1.c()
            Xa.b r8 = r8.a(r1)
            Xa.b r8 = Xa.d.q(r8)
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2
            Xa.b<T> r3 = r7.f36537c
            Xa.j<T> r4 = r7.f36538d
            T r6 = r7.f36539e
            r1.<init>(r3, r4, r6, r5)
            r7.f36535a = r2
            java.lang.Object r7 = Xa.d.j(r8, r1, r7)
            if (r7 != r0) goto L8d
        L8c:
            return r0
        L8d:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
