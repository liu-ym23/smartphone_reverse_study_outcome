package com.stepos.ailauncher.taskstore.widget;

import com.stepos.ailauncher.foundation.task.TaskModule;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.widget.TextToImageCardView$reportChatCardExpose$1$taskStatus$1", f = "TextToImageCardView.kt", l = {1723}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TextToImageCardView$reportChatCardExpose$1$taskStatus$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super String>, Object> {
    final /* synthetic */ TaskInfoCard $card;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextToImageCardView$reportChatCardExpose$1$taskStatus$1(TaskInfoCard taskInfoCard, InterfaceC4014c<? super TextToImageCardView$reportChatCardExpose$1$taskStatus$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$card = taskInfoCard;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TextToImageCardView$reportChatCardExpose$1$taskStatus$1(this.$card, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super String> interfaceC4014c) {
        return ((TextToImageCardView$reportChatCardExpose$1$taskStatus$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        TaskModule taskModule = TaskModule.INSTANCE;
        String taskId = this.$card.getTaskId();
        this.label = 1;
        Object objI = taskModule.i(taskId, this);
        return objI == objG ? objG : objI;
    }
}
