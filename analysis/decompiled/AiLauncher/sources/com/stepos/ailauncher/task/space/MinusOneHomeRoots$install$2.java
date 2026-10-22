package com.stepos.ailauncher.task.space;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.MinusOneHomeRoots$install$2", f = "MinusOneHomeRoots.kt", l = {70}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class MinusOneHomeRoots$install$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.MinusOneHomeRoots$install$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Xa.c {
        public static final AnonymousClass1<T> INSTANCE = new AnonymousClass1<>();

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object b(boolean r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof com.stepos.ailauncher.task.space.MinusOneHomeRoots$install$2$1$emit$1
                if (r0 == 0) goto L13
                r0 = r8
                com.stepos.ailauncher.task.space.MinusOneHomeRoots$install$2$1$emit$1 r0 = (com.stepos.ailauncher.task.space.MinusOneHomeRoots$install$2$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.ailauncher.task.space.MinusOneHomeRoots$install$2$1$emit$1 r0 = new com.stepos.ailauncher.task.space.MinusOneHomeRoots$install$2$1$emit$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r8 = f9.C4063a.g()
                int r1 = r0.label
                java.lang.String r2 = "overlay-host-fg="
                java.lang.Class<com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator> r3 = com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator.class
                r4 = 1
                if (r1 == 0) goto L38
                if (r1 != r4) goto L30
                boolean r7 = r0.Z$0
                kotlin.C4849c.b(r6)
                goto L6c
            L30:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L38:
                kotlin.C4849c.b(r6)
                D5.a r6 = D5.a.INSTANCE
                java.lang.Object r6 = r6.a(r3)
                com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator r6 = (com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator) r6
                if (r6 == 0) goto L57
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r2)
                r1.append(r7)
                java.lang.String r1 = r1.toString()
                r6.notifyTopologyChanged(r1)
            L57:
                com.stepos.ailauncher.container.m0 r6 = com.stepos.ailauncher.container.m0.INSTANCE
                boolean r6 = r6.h()
                if (r6 == 0) goto L95
                r0.Z$0 = r7
                r0.label = r4
                r4 = 80
                java.lang.Object r6 = Ua.U.a(r4, r0)
                if (r6 != r8) goto L6c
                return r8
            L6c:
                com.stepos.ailauncher.container.m0 r6 = com.stepos.ailauncher.container.m0.INSTANCE
                boolean r6 = r6.g()
                if (r6 != r7) goto L95
                D5.a r6 = D5.a.INSTANCE
                java.lang.Object r6 = r6.a(r3)
                com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator r6 = (com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator) r6
                if (r6 == 0) goto L95
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                r8.append(r2)
                r8.append(r7)
                java.lang.String r7 = "-settled"
                r8.append(r7)
                java.lang.String r7 = r8.toString()
                r6.notifyTopologyChanged(r7)
            L95:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.MinusOneHomeRoots$install$2.AnonymousClass1.b(boolean, e9.c):java.lang.Object");
        }

        @Override // Xa.c
        public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
            return b(((Boolean) obj).booleanValue(), interfaceC4014c);
        }
    }

    public MinusOneHomeRoots$install$2(InterfaceC4014c<? super MinusOneHomeRoots$install$2> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new MinusOneHomeRoots$install$2(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((MinusOneHomeRoots$install$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.t<Boolean> tVarB = com.stepos.ailauncher.container.m0.INSTANCE.b();
            Xa.c<? super Boolean> cVar = AnonymousClass1.INSTANCE;
            this.label = 1;
            if (tVarB.collect(cVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
