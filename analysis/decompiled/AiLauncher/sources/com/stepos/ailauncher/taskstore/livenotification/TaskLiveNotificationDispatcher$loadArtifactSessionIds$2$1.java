package com.stepos.ailauncher.taskstore.livenotification;

import com.stepos.ailauncher.chat.manager.AgentConfig;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "", "<anonymous>", "(LUa/M;)Ljava/util/Set;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$loadArtifactSessionIds$2$1", f = "TaskLiveNotificationDispatcher.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$loadArtifactSessionIds$2$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Set<? extends String>>, Object> {
    final /* synthetic */ Set<String> $ids;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDispatcher$loadArtifactSessionIds$2$1(Set<String> set, InterfaceC4014c<? super TaskLiveNotificationDispatcher$loadArtifactSessionIds$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$ids = set;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskLiveNotificationDispatcher$loadArtifactSessionIds$2$1(this.$ids, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<? super Set<String>> interfaceC4014c) {
        return ((TaskLiveNotificationDispatcher$loadArtifactSessionIds$2$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return AgentConfig.INSTANCE.a().n().C3(this.$ids);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super Set<? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Set<String>>) interfaceC4014c);
    }
}
