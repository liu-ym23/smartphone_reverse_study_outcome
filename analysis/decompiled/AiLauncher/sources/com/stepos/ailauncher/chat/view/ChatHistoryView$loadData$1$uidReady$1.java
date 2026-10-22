package com.stepos.ailauncher.chat.view;

import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ChatHistoryView$loadData$1$uidReady$1", f = "ChatHistoryView.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatHistoryView$loadData$1$uidReady$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Boolean>, Object> {
    int label;

    public ChatHistoryView$loadData$1$uidReady$1(InterfaceC4014c<? super ChatHistoryView$loadData$1$uidReady$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatHistoryView$loadData$1$uidReady$1(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((ChatHistoryView$loadData$1$uidReady$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (ChatCoreSdk.INSTANCE.g()) {
            com.stepos.ailauncher.chat.manager.Y.INSTANCE.b();
        }
        return C4109a.a(FwkDatabase.INSTANCE.B());
    }
}
