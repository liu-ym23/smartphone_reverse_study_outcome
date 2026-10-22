package com.stepos.agentframework.chatcore.search;

import Ua.M;
import Y8.t;
import Z8.F;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)I"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.search.TaskSearchSnapshotStore$delete$2", f = "TaskSearchSnapshotStore.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class TaskSearchSnapshotStore$delete$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Integer>, Object> {
    final /* synthetic */ List<String> $taskIds;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskSearchSnapshotStore$delete$2(List<String> list, InterfaceC4014c<? super TaskSearchSnapshotStore$delete$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskIds = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskSearchSnapshotStore$delete$2(this.$taskIds, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return ((TaskSearchSnapshotStore$delete$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        List<String> listD0 = SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(F.d0(this.$taskIds), TaskSearchSnapshotStore$delete$2$normalizedIds$1.INSTANCE), TaskSearchSnapshotStore$delete$2$normalizedIds$2.INSTANCE)));
        int iD = 0;
        if (listD0.isEmpty()) {
            return C4109a.f(0);
        }
        TaskSearchSnapshotStore taskSearchSnapshotStore = TaskSearchSnapshotStore.INSTANCE;
        FwkDatabase.Companion companion = FwkDatabase.INSTANCE;
        if (companion.B()) {
            try {
                iD = companion.n().q0().d(listD0);
            } catch (IllegalStateException unused) {
                C4148a.u("TaskSearch", ChatTracker.CLICK_DELETE + " skipped: account database is unavailable", false, 4, null);
            } catch (Throwable th) {
                C4148a.h("TaskSearch", ChatTracker.CLICK_DELETE + " failed: " + th.getClass().getSimpleName(), false, 4, null);
            }
        } else {
            C4148a.u("TaskSearch", ChatTracker.CLICK_DELETE + " skipped: uid not ready", false, 4, null);
        }
        return C4109a.f(iD);
    }
}
