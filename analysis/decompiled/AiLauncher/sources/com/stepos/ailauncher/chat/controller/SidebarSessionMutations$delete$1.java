package com.stepos.ailauncher.chat.controller;

import Ua.C1060i;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.chat.wake.C3172w;
import com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SidebarSessionMutations$delete$1", f = "SidebarSessionMutations.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SidebarSessionMutations$delete$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $callback;
    final /* synthetic */ boolean $clearOnly;
    final /* synthetic */ Ua.M $scope;
    final /* synthetic */ SessionHandler $sessionHandler;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ List<String> $sessionKeys;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SidebarSessionMutations$delete$1(boolean z10, List<String> list, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, SessionHandler sessionHandler, String str, Ua.M m10, InterfaceC4014c<? super SidebarSessionMutations$delete$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$clearOnly = z10;
        this.$sessionKeys = list;
        this.$callback = interfaceC5074l;
        this.$sessionHandler = sessionHandler;
        this.$sessionId = str;
        this.$scope = m10;
    }

    public static final Y8.t h(Ua.M m10, ITaskStoreService iTaskStoreService, List list, InterfaceC5074l interfaceC5074l, String str, boolean z10) {
        C1060i.d(m10, null, null, new SidebarSessionMutations$delete$1$1$1$1(z10, iTaskStoreService, list, interfaceC5074l, str, null), 3, null);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SidebarSessionMutations$delete$1 sidebarSessionMutations$delete$1 = new SidebarSessionMutations$delete$1(this.$clearOnly, this.$sessionKeys, this.$callback, this.$sessionHandler, this.$sessionId, this.$scope, interfaceC4014c);
        sidebarSessionMutations$delete$1.L$0 = obj;
        return sidebarSessionMutations$delete$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SidebarSessionMutations$delete$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Object objB2;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        final ITaskStoreService iTaskStoreService = (ITaskStoreService) D5.a.INSTANCE.a(ITaskStoreService.class);
        if (this.$clearOnly) {
            SessionHandler sessionHandler = this.$sessionHandler;
            String str = this.$sessionId;
            try {
                Result.Companion companion = Result.INSTANCE;
                sessionHandler.Z0(str);
                objB2 = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th));
            }
            String str2 = this.$sessionId;
            Throwable thE = Result.e(objB2);
            if (thE != null) {
                C4148a.g("SidebarSessionMutations", "Clear sidebar session failed: " + str2, thE, false, 8, null);
            }
            boolean zH = Result.h(objB2);
            if (iTaskStoreService != null) {
                iTaskStoreService.releaseSessionDeletionGuard(this.$sessionKeys);
            }
            this.$callback.invoke(C4109a.a(zH));
            return Y8.t.f7040a;
        }
        C3172w c3172w = C3172w.INSTANCE;
        String strH = c3172w.h();
        if (strH != null && this.$sessionKeys.contains(strH)) {
            c3172w.g();
        }
        SessionHandler sessionHandler2 = this.$sessionHandler;
        final String str3 = this.$sessionId;
        final Ua.M m10 = this.$scope;
        final List<String> list = this.$sessionKeys;
        final InterfaceC5074l<Boolean, Y8.t> interfaceC5074l = this.$callback;
        try {
            Result.Companion companion3 = Result.INSTANCE;
            sessionHandler2.g1(str3, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.v1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return SidebarSessionMutations$delete$1.h(m10, iTaskStoreService, list, interfaceC5074l, str3, ((Boolean) obj2).booleanValue());
                }
            });
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        String str4 = this.$sessionId;
        List<String> list2 = this.$sessionKeys;
        InterfaceC5074l<Boolean, Y8.t> interfaceC5074l2 = this.$callback;
        Throwable thE2 = Result.e(objB);
        if (thE2 != null) {
            C4148a.g("SidebarSessionMutations", "Delete sidebar session failed: " + str4, thE2, false, 8, null);
            if (iTaskStoreService != null) {
                iTaskStoreService.releaseSessionDeletionGuard(list2);
            }
            interfaceC5074l2.invoke(C4109a.a(false));
        }
        return Y8.t.f7040a;
    }
}
