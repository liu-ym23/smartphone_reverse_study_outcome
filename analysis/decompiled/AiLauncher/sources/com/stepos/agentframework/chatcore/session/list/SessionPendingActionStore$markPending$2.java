package com.stepos.agentframework.chatcore.session.list;

import La.H;
import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.session.PushMessageCenter;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import w4.SessionPendingActionEntity;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.list.SessionPendingActionStore$markPending$2", f = "SessionPendingActionStore.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionPendingActionStore$markPending$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $agentId;
    final /* synthetic */ long $createdAt;
    final /* synthetic */ Long $expiresAt;
    final /* synthetic */ SessionPendingActionKind $kind;
    final /* synthetic */ String $requestId;
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionPendingActionStore$markPending$2(String str, String str2, String str3, SessionPendingActionKind sessionPendingActionKind, long j10, Long l10, InterfaceC4014c<? super SessionPendingActionStore$markPending$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$sessionId = str;
        this.$requestId = str2;
        this.$agentId = str3;
        this.$kind = sessionPendingActionKind;
        this.$createdAt = j10;
        this.$expiresAt = l10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionPendingActionStore$markPending$2(this.$sessionId, this.$requestId, this.$agentId, this.$kind, this.$createdAt, this.$expiresAt, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((SessionPendingActionStore$markPending$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        String string = H.D1(this.$sessionId).toString();
        String string2 = H.D1(this.$requestId).toString();
        boolean z10 = false;
        if (string.length() == 0 || string2.length() == 0) {
            C4148a.u("SessionPendingAction", "markPending ignored: blank sessionId/requestId", false, 4, null);
            return C4109a.a(false);
        }
        try {
            FwkDatabase.INSTANCE.n().o0().c(new SessionPendingActionEntity(string2, string, H.D1(this.$agentId).toString(), this.$kind.getStorageValue(), this.$createdAt, this.$expiresAt));
            PushMessageCenter.INSTANCE.b0();
            z10 = true;
        } catch (CancellationException e10) {
            throw e10;
        } catch (Throwable th) {
            C4148a.h("SessionPendingAction", "markPending failed: " + th.getClass().getSimpleName(), false, 4, null);
        }
        return C4109a.a(z10);
    }
}
