package com.stepos.ailauncher.task.search;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.search.TaskSearchHit;
import com.stepos.agentframework.chatcore.search.TaskSearchSnapshot;
import com.stepos.agentframework.chatcore.search.TaskSearchSnapshotStore;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/agentframework/chatcore/search/n;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl$search$2$1$tasks$1", f = "UnifiedSessionSearchServiceImpl.kt", l = {101}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class UnifiedSessionSearchServiceImpl$search$2$1$tasks$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends TaskSearchHit>>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ int $limit;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnifiedSessionSearchServiceImpl$search$2$1$tasks$1(String str, int i10, InterfaceC4014c<? super UnifiedSessionSearchServiceImpl$search$2$1$tasks$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$keyword = str;
        this.$limit = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new UnifiedSessionSearchServiceImpl$search$2$1$tasks$1(this.$keyword, this.$limit, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<TaskSearchHit>> interfaceC4014c) {
        return ((UnifiedSessionSearchServiceImpl$search$2$1$tasks$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            TaskSearchSnapshotStore taskSearchSnapshotStore = TaskSearchSnapshotStore.INSTANCE;
            String str = this.$keyword;
            int i11 = this.$limit;
            this.label = 1;
            obj = taskSearchSnapshotStore.c(str, i11, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return ((TaskSearchSnapshot) obj).a();
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends TaskSearchHit>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<TaskSearchHit>>) interfaceC4014c);
    }
}
