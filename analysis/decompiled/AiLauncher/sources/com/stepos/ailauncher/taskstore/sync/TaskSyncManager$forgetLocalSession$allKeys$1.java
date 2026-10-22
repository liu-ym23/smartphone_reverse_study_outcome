package com.stepos.ailauncher.taskstore.sync;

import Ua.M;
import Y8.t;
import Z8.F;
import com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.sync.TaskSyncManager$forgetLocalSession$allKeys$1", f = "TaskSyncManager.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskSyncManager$forgetLocalSession$allKeys$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends String>>, Object> {
    final /* synthetic */ List<String> $keys;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskSyncManager$forgetLocalSession$allKeys$1(List<String> list, InterfaceC4014c<? super TaskSyncManager$forgetLocalSession$allKeys$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$keys = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskSyncManager$forgetLocalSession$allKeys$1(this.$keys, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<String>> interfaceC4014c) {
        return ((TaskSyncManager$forgetLocalSession$allKeys$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<String> list = this.$keys;
        linkedHashSet.addAll(list);
        linkedHashSet.addAll(TaskLiveNotificationDispatcher.INSTANCE.b0(list));
        return F.m1(linkedHashSet);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<String>>) interfaceC4014c);
    }
}
