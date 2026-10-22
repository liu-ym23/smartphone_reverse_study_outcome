package com.stepos.ailauncher.taskstore.livenotification;

import com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeChatActivity$1;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$observeChatActivity$1$2", f = "TaskLiveNotificationDispatcher.kt", l = {425, 426, 427}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$observeChatActivity$1$2$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskLiveNotificationDispatcher$observeChatActivity$1.AnonymousClass2<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TaskLiveNotificationDispatcher$observeChatActivity$1$2$emit$1(TaskLiveNotificationDispatcher$observeChatActivity$1.AnonymousClass2<? super T> anonymousClass2, InterfaceC4014c<? super TaskLiveNotificationDispatcher$observeChatActivity$1$2$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = anonymousClass2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
