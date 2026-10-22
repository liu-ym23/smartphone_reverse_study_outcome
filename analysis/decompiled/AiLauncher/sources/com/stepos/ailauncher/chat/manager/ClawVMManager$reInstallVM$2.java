package com.stepos.ailauncher.chat.manager;

import com.stepos.ailauncher.chat.model.ReInstallVMResult;
import com.stepos.common.ReInstallMode;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.manager.ClawVMManager$reInstallVM$2", f = "ClawVMManager.kt", l = {387, 392}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ClawVMManager$reInstallVM$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $deleteMemory;
    final /* synthetic */ ReInstallMode $mode;
    final /* synthetic */ InterfaceC5074l<ReInstallVMResult, Y8.t> $onResult;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ClawVMManager this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.manager.ClawVMManager$reInstallVM$2$1", f = "ClawVMManager.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.manager.ClawVMManager$reInstallVM$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5074l<ReInstallVMResult, Y8.t> $onResult;
        final /* synthetic */ ReInstallVMResult $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super ReInstallVMResult, Y8.t> interfaceC5074l, ReInstallVMResult reInstallVMResult, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onResult = interfaceC5074l;
            this.$result = reInstallVMResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$onResult, this.$result, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.$onResult.invoke(this.$result);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ClawVMManager$reInstallVM$2(ReInstallMode reInstallMode, ClawVMManager clawVMManager, String str, InterfaceC5074l<? super ReInstallVMResult, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClawVMManager$reInstallVM$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$mode = reInstallMode;
        this.this$0 = clawVMManager;
        this.$deleteMemory = str;
        this.$onResult = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ClawVMManager$reInstallVM$2(this.$mode, this.this$0, this.$deleteMemory, this.$onResult, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ClawVMManager$reInstallVM$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b4, code lost:
    
        if (Ua.C1056g.j(r0, r3, r10) == r1) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r1 = f9.C4063a.g()
            int r0 = r10.label
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L2e
            if (r0 == r3) goto L1f
            if (r0 != r2) goto L17
            java.lang.Object r10 = r10.L$0
            com.stepos.ailauncher.chat.model.ReInstallVMResult r10 = (com.stepos.ailauncher.chat.model.ReInstallVMResult) r10
            kotlin.C4849c.b(r11)
            goto Lb7
        L17:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L1f:
            java.lang.Object r0 = r10.L$1
            com.stepos.ailauncher.chat.model.ReInstallVMResult$Companion r0 = (com.stepos.ailauncher.chat.model.ReInstallVMResult.Companion) r0
            java.lang.Object r3 = r10.L$0
            K6.z r3 = (kotlin.ReInstallVMRequest) r3
            kotlin.C4849c.b(r11)     // Catch: java.lang.Exception -> L2b
            goto L7c
        L2b:
            r0 = move-exception
            r11 = r0
            goto L83
        L2e:
            kotlin.C4849c.b(r11)
            K6.z r11 = new K6.z     // Catch: java.lang.Exception -> L2b
            java.lang.String r0 = ""
            com.stepos.common.ReInstallMode r4 = r10.$mode     // Catch: java.lang.Exception -> L2b
            r11.<init>(r0, r4)     // Catch: java.lang.Exception -> L2b
            com.stepos.ailauncher.chat.manager.ClawVMManager r0 = r10.this$0     // Catch: java.lang.Exception -> L2b
            java.lang.String r0 = com.stepos.ailauncher.chat.manager.ClawVMManager.h(r0)     // Catch: java.lang.Exception -> L2b
            com.stepos.common.ReInstallMode r4 = r10.$mode     // Catch: java.lang.Exception -> L2b
            java.lang.String r5 = r10.$deleteMemory     // Catch: java.lang.Exception -> L2b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2b
            r6.<init>()     // Catch: java.lang.Exception -> L2b
            java.lang.String r7 = "start to reInstallVM, mode: "
            r6.append(r7)     // Catch: java.lang.Exception -> L2b
            r6.append(r4)     // Catch: java.lang.Exception -> L2b
            java.lang.String r4 = ", deleteMemory: "
            r6.append(r4)     // Catch: java.lang.Exception -> L2b
            r6.append(r5)     // Catch: java.lang.Exception -> L2b
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Exception -> L2b
            android.util.Log.d(r0, r4)     // Catch: java.lang.Exception -> L2b
            com.stepos.ailauncher.chat.model.ReInstallVMResult$Companion r0 = com.stepos.ailauncher.chat.model.ReInstallVMResult.INSTANCE     // Catch: java.lang.Exception -> L2b
            com.stepos.ailauncher.chat.manager.ClawVMManager r4 = r10.this$0     // Catch: java.lang.Exception -> L2b
            com.stepos.ailauncher.chat.api.VMApi r4 = com.stepos.ailauncher.chat.manager.ClawVMManager.i(r4)     // Catch: java.lang.Exception -> L2b
            java.lang.String r5 = r10.$deleteMemory     // Catch: java.lang.Exception -> L2b
            java.lang.Object r6 = g9.h.a(r11)     // Catch: java.lang.Exception -> L2b
            r10.L$0 = r6     // Catch: java.lang.Exception -> L2b
            r10.L$1 = r0     // Catch: java.lang.Exception -> L2b
            r10.label = r3     // Catch: java.lang.Exception -> L2b
            java.lang.Object r11 = r4.reInstallVM(r11, r5, r10)     // Catch: java.lang.Exception -> L2b
            if (r11 != r1) goto L7c
            goto Lb6
        L7c:
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Exception -> L2b
            com.stepos.ailauncher.chat.model.ReInstallVMResult r11 = r0.fromJson(r11)     // Catch: java.lang.Exception -> L2b
            goto L9a
        L83:
            com.stepos.ailauncher.chat.manager.ClawVMManager r0 = r10.this$0
            java.lang.String r0 = com.stepos.ailauncher.chat.manager.ClawVMManager.h(r0)
            java.lang.String r3 = "reInstallVM failed"
            android.util.Log.w(r0, r3, r11)
            com.stepos.ailauncher.chat.model.ReInstallVMResult r4 = new com.stepos.ailauncher.chat.model.ReInstallVMResult
            r8 = 7
            r9 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            r11 = r4
        L9a:
            Ua.A0 r0 = Ua.Y.c()
            com.stepos.ailauncher.chat.manager.ClawVMManager$reInstallVM$2$1 r3 = new com.stepos.ailauncher.chat.manager.ClawVMManager$reInstallVM$2$1
            p9.l<com.stepos.ailauncher.chat.model.ReInstallVMResult, Y8.t> r4 = r10.$onResult
            r5 = 0
            r3.<init>(r4, r11, r5)
            java.lang.Object r11 = g9.h.a(r11)
            r10.L$0 = r11
            r10.L$1 = r5
            r10.label = r2
            java.lang.Object r10 = Ua.C1056g.j(r0, r3, r10)
            if (r10 != r1) goto Lb7
        Lb6:
            return r1
        Lb7:
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ClawVMManager$reInstallVM$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
