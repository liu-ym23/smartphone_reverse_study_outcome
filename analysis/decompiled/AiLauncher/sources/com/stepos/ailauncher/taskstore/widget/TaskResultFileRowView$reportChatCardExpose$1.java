package com.stepos.ailauncher.taskstore.widget;

import Ua.C1056g;
import com.stepos.ailauncher.taskstore.chat.TaskResultFileItem;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.widget.TaskResultFileRowView$reportChatCardExpose$1", f = "TaskResultFileRowView.kt", l = {659}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskResultFileRowView$reportChatCardExpose$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ List<Triple<TaskResultFileItem, Integer, String>> $pending;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $taskId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskResultFileRowView$reportChatCardExpose$1(List<Triple<TaskResultFileItem, Integer, String>> list, String str, String str2, InterfaceC4014c<? super TaskResultFileRowView$reportChatCardExpose$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$pending = list;
        this.$taskId = str;
        this.$sessionId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskResultFileRowView$reportChatCardExpose$1(this.$pending, this.$taskId, this.$sessionId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskResultFileRowView$reportChatCardExpose$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.I iB = Ua.Y.b();
            TaskResultFileRowView$reportChatCardExpose$1$taskStatus$1 taskResultFileRowView$reportChatCardExpose$1$taskStatus$1 = new TaskResultFileRowView$reportChatCardExpose$1$taskStatus$1(this.$taskId, null);
            this.label = 1;
            obj = C1056g.j(iB, taskResultFileRowView$reportChatCardExpose$1$taskStatus$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        String str = (String) obj;
        List<Triple<TaskResultFileItem, Integer, String>> list = this.$pending;
        String str2 = this.$sessionId;
        String str3 = this.$taskId;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Triple triple = (Triple) it.next();
            TaskResultFileItem taskResultFileItem = (TaskResultFileItem) triple.a();
            int iIntValue = ((Number) triple.b()).intValue();
            M5.c.d(M5.c.INSTANCE, com.stepos.ailauncher.taskstore.chat.G.b(taskResultFileItem, str2, str3), str2, "chatview", null, str, (String) triple.c(), String.valueOf(iIntValue), 8, null);
        }
        return Y8.t.f7040a;
    }
}
