package com.stepos.ailauncher.chat.view;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ChatView$cancelUnfinishedTasksOfTopSession$1", f = "ChatView.kt", l = {929}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatView$cancelUnfinishedTasksOfTopSession$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ List<String> $taskIds;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatView$cancelUnfinishedTasksOfTopSession$1(List<String> list, InterfaceC4014c<? super ChatView$cancelUnfinishedTasksOfTopSession$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskIds = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ChatView$cancelUnfinishedTasksOfTopSession$1 chatView$cancelUnfinishedTasksOfTopSession$1 = new ChatView$cancelUnfinishedTasksOfTopSession$1(this.$taskIds, interfaceC4014c);
        chatView$cancelUnfinishedTasksOfTopSession$1.L$0 = obj;
        return chatView$cancelUnfinishedTasksOfTopSession$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatView$cancelUnfinishedTasksOfTopSession$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0077 -> B:19:0x007a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = r10.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r10.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L30
            if (r2 != r3) goto L28
            int r2 = r10.I$0
            java.lang.Object r5 = r10.L$5
            Ua.M r5 = (Ua.M) r5
            java.lang.Object r5 = r10.L$4
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r10.L$2
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r10.L$1
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            kotlin.C4849c.b(r11)     // Catch: java.lang.Throwable -> L26
            goto L7a
        L26:
            r11 = move-exception
            goto L88
        L28:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L30:
            kotlin.C4849c.b(r11)
            java.util.List<java.lang.String> r11 = r10.$taskIds
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r2 = r11.iterator()
            r6 = r11
            r5 = r2
            r2 = r4
        L3e:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto L92
            java.lang.Object r11 = r5.next()
            r7 = r11
            java.lang.String r7 = (java.lang.String) r7
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L26
            com.stepos.ailauncher.foundation.task.TaskModule r8 = com.stepos.ailauncher.foundation.task.TaskModule.INSTANCE     // Catch: java.lang.Throwable -> L26
            r10.L$0 = r0     // Catch: java.lang.Throwable -> L26
            java.lang.Object r9 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L26
            r10.L$1 = r9     // Catch: java.lang.Throwable -> L26
            r10.L$2 = r5     // Catch: java.lang.Throwable -> L26
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L26
            r10.L$3 = r11     // Catch: java.lang.Throwable -> L26
            java.lang.Object r11 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L26
            r10.L$4 = r11     // Catch: java.lang.Throwable -> L26
            java.lang.Object r11 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L26
            r10.L$5 = r11     // Catch: java.lang.Throwable -> L26
            r10.I$0 = r2     // Catch: java.lang.Throwable -> L26
            r10.I$1 = r4     // Catch: java.lang.Throwable -> L26
            r10.I$2 = r4     // Catch: java.lang.Throwable -> L26
            r10.label = r3     // Catch: java.lang.Throwable -> L26
            java.lang.Object r11 = r8.b(r7, r10)     // Catch: java.lang.Throwable -> L26
            if (r11 != r1) goto L7a
            return r1
        L7a:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L26
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L26
            java.lang.Boolean r11 = g9.C4109a.a(r11)     // Catch: java.lang.Throwable -> L26
            kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> L26
            goto L3e
        L88:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r11 = kotlin.C4849c.a(r11)
            kotlin.Result.b(r11)
            goto L3e
        L92:
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ChatView$cancelUnfinishedTasksOfTopSession$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
