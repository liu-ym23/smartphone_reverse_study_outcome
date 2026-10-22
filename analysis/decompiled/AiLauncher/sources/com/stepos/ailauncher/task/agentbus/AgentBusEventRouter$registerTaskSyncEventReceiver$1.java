package com.stepos.ailauncher.task.agentbus;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.taskstore.sync.TaskSyncManager;
import com.stepos.ailauncher.taskstore.sync.TaskSyncOp;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerTaskSyncEventReceiver$1", f = "AgentBusEventRouter.kt", l = {732}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$registerTaskSyncEventReceiver$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerTaskSyncEventReceiver$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Xa.c {
        final /* synthetic */ M $$this$launchInMain;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerTaskSyncEventReceiver$1$1$a */
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TaskSyncOp.values().length];
                try {
                    iArr[TaskSyncOp.DELETE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TaskSyncOp.BATCH_DELETE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TaskSyncOp.CANCEL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public AnonymousClass1(M m10) {
            this.$$this$launchInMain = m10;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(com.stepos.ailauncher.taskstore.sync.a r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerTaskSyncEventReceiver$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r8
                com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerTaskSyncEventReceiver$1$1$emit$1 r0 = (com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerTaskSyncEventReceiver$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerTaskSyncEventReceiver$1$1$emit$1 r0 = new com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerTaskSyncEventReceiver$1$1$emit$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L3c
                if (r2 != r4) goto L34
                java.lang.Object r6 = r0.L$1
                Ua.M r6 = (Ua.M) r6
                java.lang.Object r6 = r0.L$0
                com.stepos.ailauncher.taskstore.sync.a r6 = (com.stepos.ailauncher.taskstore.sync.a) r6
                kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
                goto L87
            L32:
                r6 = move-exception
                goto L8e
            L34:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L3c:
                kotlin.C4849c.b(r8)
                boolean r8 = r7 instanceof com.stepos.ailauncher.taskstore.sync.a.Success
                if (r8 != 0) goto L46
                Y8.t r6 = Y8.t.f7040a
                return r6
            L46:
                r8 = r7
                com.stepos.ailauncher.taskstore.sync.a$c r8 = (com.stepos.ailauncher.taskstore.sync.a.Success) r8
                com.stepos.ailauncher.taskstore.sync.TaskSyncOp r2 = r8.getOp()
                int[] r5 = com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerTaskSyncEventReceiver$1.AnonymousClass1.a.$EnumSwitchMapping$0
                int r2 = r2.ordinal()
                r2 = r5[r2]
                r5 = 2
                if (r2 == r4) goto Lb0
                if (r2 == r5) goto Lb0
                r8 = 3
                if (r2 == r8) goto L5e
                goto Lc4
            L5e:
                Ua.M r6 = r6.$$this$launchInMain
                kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
                com.stepos.ailauncher.taskstore.TaskStoreModule r8 = com.stepos.ailauncher.taskstore.TaskStoreModule.INSTANCE     // Catch: java.lang.Throwable -> L32
                com.stepos.ailauncher.taskstore.repository.a r8 = r8.n()     // Catch: java.lang.Throwable -> L32
                r2 = r7
                com.stepos.ailauncher.taskstore.sync.a$c r2 = (com.stepos.ailauncher.taskstore.sync.a.Success) r2     // Catch: java.lang.Throwable -> L32
                java.lang.String r2 = r2.getTaskId()     // Catch: java.lang.Throwable -> L32
                java.lang.Object r7 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L32
                r0.L$0 = r7     // Catch: java.lang.Throwable -> L32
                java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
                r0.L$1 = r6     // Catch: java.lang.Throwable -> L32
                r6 = 0
                r0.I$0 = r6     // Catch: java.lang.Throwable -> L32
                r0.label = r4     // Catch: java.lang.Throwable -> L32
                java.lang.Object r8 = r8.q(r2, r0)     // Catch: java.lang.Throwable -> L32
                if (r8 != r1) goto L87
                return r1
            L87:
                com.stepos.ailauncher.taskstore.entity.TaskInfoCard r8 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCard) r8     // Catch: java.lang.Throwable -> L32
                java.lang.Object r6 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L32
                goto L98
            L8e:
                kotlin.Result$a r7 = kotlin.Result.INSTANCE
                java.lang.Object r6 = kotlin.C4849c.a(r6)
                java.lang.Object r6 = kotlin.Result.b(r6)
            L98:
                boolean r7 = kotlin.Result.g(r6)
                if (r7 == 0) goto L9f
                goto La0
            L9f:
                r3 = r6
            La0:
                com.stepos.ailauncher.taskstore.entity.TaskInfoCard r3 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCard) r3
                if (r3 == 0) goto Lc4
                boolean r6 = com.stepos.ailauncher.taskstore.entity.TaskInfoCardKt.isImageTaskCard(r3)
                if (r6 == 0) goto Lc4
                com.stepos.ailauncher.task.agentbus.AgentBusEventRouter r6 = com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.INSTANCE
                com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.r(r6, r3)
                goto Lc4
            Lb0:
                com.stepos.ailauncher.task.agentbus.AgentBusEventRouter r6 = com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.INSTANCE
                java.lang.String r7 = r8.getTaskId()
                com.stepos.ailauncher.taskstore.sync.TaskSyncOp r0 = r8.getOp()
                com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.v(r6, r7, r0)
                java.lang.String r7 = r8.getTaskId()
                com.stepos.ailauncher.task.agentbus.AgentBusEventRouter.v0(r6, r7, r3, r5, r3)
            Lc4:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerTaskSyncEventReceiver$1.AnonymousClass1.emit(com.stepos.ailauncher.taskstore.sync.a, e9.c):java.lang.Object");
        }
    }

    public AgentBusEventRouter$registerTaskSyncEventReceiver$1(InterfaceC4014c<? super AgentBusEventRouter$registerTaskSyncEventReceiver$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusEventRouter$registerTaskSyncEventReceiver$1 agentBusEventRouter$registerTaskSyncEventReceiver$1 = new AgentBusEventRouter$registerTaskSyncEventReceiver$1(interfaceC4014c);
        agentBusEventRouter$registerTaskSyncEventReceiver$1.L$0 = obj;
        return agentBusEventRouter$registerTaskSyncEventReceiver$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AgentBusEventRouter$registerTaskSyncEventReceiver$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.o<com.stepos.ailauncher.taskstore.sync.a> oVarU = TaskSyncManager.INSTANCE.u();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(m10);
            this.L$0 = g9.h.a(m10);
            this.label = 1;
            if (oVarU.collect(anonymousClass1, this) == objG) {
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
