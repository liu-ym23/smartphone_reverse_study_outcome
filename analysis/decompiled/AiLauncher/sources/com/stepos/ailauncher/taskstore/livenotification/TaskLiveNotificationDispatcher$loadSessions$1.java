package com.stepos.ailauncher.taskstore.livenotification;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher", f = "TaskLiveNotificationDispatcher.kt", l = {487}, m = "loadSessions", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$loadSessions$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskLiveNotificationDispatcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDispatcher$loadSessions$1(TaskLiveNotificationDispatcher taskLiveNotificationDispatcher, InterfaceC4014c<? super TaskLiveNotificationDispatcher$loadSessions$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = taskLiveNotificationDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o0(this);
    }
}
