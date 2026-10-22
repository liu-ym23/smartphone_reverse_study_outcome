package com.stepos.ailauncher.chat.controller;

import com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SidebarSessionMutations$delete$1$1$1$1", f = "SidebarSessionMutations.kt", l = {78}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SidebarSessionMutations$delete$1$1$1$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $callback;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ List<String> $sessionKeys;
    final /* synthetic */ boolean $success;
    final /* synthetic */ ITaskStoreService $taskStoreService;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SidebarSessionMutations$delete$1$1$1$1(boolean z10, ITaskStoreService iTaskStoreService, List<String> list, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, String str, InterfaceC4014c<? super SidebarSessionMutations$delete$1$1$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$success = z10;
        this.$taskStoreService = iTaskStoreService;
        this.$sessionKeys = list;
        this.$callback = interfaceC5074l;
        this.$sessionId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SidebarSessionMutations$delete$1$1$1$1 sidebarSessionMutations$delete$1$1$1$1 = new SidebarSessionMutations$delete$1$1$1$1(this.$success, this.$taskStoreService, this.$sessionKeys, this.$callback, this.$sessionId, interfaceC4014c);
        sidebarSessionMutations$delete$1$1$1$1.L$0 = obj;
        return sidebarSessionMutations$delete$1$1$1$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SidebarSessionMutations$delete$1$1$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r7.label
            r3 = 1
            if (r2 == 0) goto L22
            if (r2 != r3) goto L1a
            java.lang.Object r0 = r7.L$1
            Ua.M r0 = (Ua.M) r0
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L17
            goto L49
        L17:
            r0 = move-exception
            r8 = r0
            goto L52
        L1a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L22:
            kotlin.C4849c.b(r8)
            boolean r8 = r7.$success
            if (r8 == 0) goto L82
            com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService r8 = r7.$taskStoreService
            java.util.List<java.lang.String> r2 = r7.$sessionKeys
            kotlin.Result$a r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L17
            if (r8 == 0) goto L4c
            java.lang.Object r4 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L17
            r7.L$0 = r4     // Catch: java.lang.Throwable -> L17
            java.lang.Object r0 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L17
            r7.L$1 = r0     // Catch: java.lang.Throwable -> L17
            r0 = 0
            r7.I$0 = r0     // Catch: java.lang.Throwable -> L17
            r7.label = r3     // Catch: java.lang.Throwable -> L17
            java.lang.Object r8 = r8.forgetLocalSession(r2, r7)     // Catch: java.lang.Throwable -> L17
            if (r8 != r1) goto L49
            return r1
        L49:
            Y8.t r8 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L17
            goto L4d
        L4c:
            r8 = 0
        L4d:
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L17
            goto L5c
        L52:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.C4849c.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
        L5c:
            java.lang.String r0 = r7.$sessionId
            java.lang.Throwable r3 = kotlin.Result.e(r8)
            if (r3 == 0) goto L7e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "forget local session after delete failed: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r2 = r1.toString()
            r5 = 8
            r6 = 0
            java.lang.String r1 = "SidebarSessionMutations"
            r4 = 0
            h8.C4148a.t(r1, r2, r3, r4, r5, r6)
        L7e:
            kotlin.Result.a(r8)
            goto L8b
        L82:
            com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService r8 = r7.$taskStoreService
            if (r8 == 0) goto L8b
            java.util.List<java.lang.String> r0 = r7.$sessionKeys
            r8.releaseSessionDeletionGuard(r0)
        L8b:
            p9.l<java.lang.Boolean, Y8.t> r8 = r7.$callback
            boolean r7 = r7.$success
            java.lang.Boolean r7 = g9.C4109a.a(r7)
            r8.invoke(r7)
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.SidebarSessionMutations$delete$1$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
