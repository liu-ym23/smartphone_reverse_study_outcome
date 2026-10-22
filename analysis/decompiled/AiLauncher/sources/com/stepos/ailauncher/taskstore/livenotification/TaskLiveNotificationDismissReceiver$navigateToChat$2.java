package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import android.util.Log;
import com.stepos.ailauncher.chat.sheet.C2739j;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lkotlin/Result;", "", "<anonymous>", "(LUa/M;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDismissReceiver$navigateToChat$2", f = "TaskLiveNotificationDismissReceiver.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDismissReceiver$navigateToChat$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Result<? extends String>>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ String $target;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDismissReceiver$navigateToChat$2(Context context, String str, InterfaceC4014c<? super TaskLiveNotificationDismissReceiver$navigateToChat$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$appContext = context;
        this.$target = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TaskLiveNotificationDismissReceiver$navigateToChat$2 taskLiveNotificationDismissReceiver$navigateToChat$2 = new TaskLiveNotificationDismissReceiver$navigateToChat$2(this.$appContext, this.$target, interfaceC4014c);
        taskLiveNotificationDismissReceiver$navigateToChat$2.L$0 = obj;
        return taskLiveNotificationDismissReceiver$navigateToChat$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<? super Result<String>> interfaceC4014c) {
        return ((TaskLiveNotificationDismissReceiver$navigateToChat$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Context context = this.$appContext;
        String str = this.$target;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C2739j.v(context, str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str2 = this.$target;
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w("TaskLiveNotification", "open ChatActivity nine-split failed sessionId=" + str2, thE);
        }
        return Result.a(objB);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super Result<? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Result<String>>) interfaceC4014c);
    }
}
