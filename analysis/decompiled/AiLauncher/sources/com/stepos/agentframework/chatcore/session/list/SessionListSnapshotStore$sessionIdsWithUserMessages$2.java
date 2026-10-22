package com.stepos.agentframework.chatcore.session.list;

import Ua.M;
import Y8.t;
import Z8.F;
import Z8.Y;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "", "<anonymous>", "(LUa/M;)Ljava/util/Set;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.list.SessionListSnapshotStore$sessionIdsWithUserMessages$2", f = "SessionListSnapshotStore.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionListSnapshotStore$sessionIdsWithUserMessages$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Set<? extends String>>, Object> {
    final /* synthetic */ List<String> $ids;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionListSnapshotStore$sessionIdsWithUserMessages$2(List<String> list, InterfaceC4014c<? super SessionListSnapshotStore$sessionIdsWithUserMessages$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$ids = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionListSnapshotStore$sessionIdsWithUserMessages$2(this.$ids, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Set<String>> interfaceC4014c) {
        return ((SessionListSnapshotStore$sessionIdsWithUserMessages$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            return F.r1(FwkDatabase.INSTANCE.n().j0().x(this.$ids));
        } catch (IllegalStateException unused) {
            C4148a.u("SessionList", "sessionIdsWithUserMessages skipped: account database is unavailable", false, 4, null);
            return Y.e();
        } catch (Throwable th) {
            C4148a.h("SessionList", "sessionIdsWithUserMessages failed: " + th.getClass().getSimpleName(), false, 4, null);
            return Y.e();
        }
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Set<? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Set<String>>) interfaceC4014c);
    }
}
