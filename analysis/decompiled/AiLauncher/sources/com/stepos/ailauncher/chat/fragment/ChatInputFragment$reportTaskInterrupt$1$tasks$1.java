package com.stepos.ailauncher.chat.fragment;

import Z8.C1173v;
import com.stepos.ailauncher.foundation.task.TaskModule;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatInputFragment$reportTaskInterrupt$1$tasks$1", f = "ChatInputFragment.kt", l = {915}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatInputFragment$reportTaskInterrupt$1$tasks$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super List<? extends UiTask>>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ChatInputFragment$reportTaskInterrupt$1$tasks$1(InterfaceC4014c<? super ChatInputFragment$reportTaskInterrupt$1$tasks$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ChatInputFragment$reportTaskInterrupt$1$tasks$1 chatInputFragment$reportTaskInterrupt$1$tasks$1 = new ChatInputFragment$reportTaskInterrupt$1$tasks$1(interfaceC4014c);
        chatInputFragment$reportTaskInterrupt$1$tasks$1.L$0 = obj;
        return chatInputFragment$reportTaskInterrupt$1$tasks$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<? super List<UiTask>> interfaceC4014c) {
        return ((ChatInputFragment$reportTaskInterrupt$1$tasks$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                Result.Companion companion = Result.INSTANCE;
                TaskModule taskModule = TaskModule.INSTANCE;
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = taskModule.f(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b((List) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("ChatInputFragment", "getUnfinishedTaskList failed", thE, false, 8, null);
        }
        return Result.g(objB) ? C1173v.m() : objB;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super List<? extends UiTask>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<UiTask>>) interfaceC4014c);
    }
}
