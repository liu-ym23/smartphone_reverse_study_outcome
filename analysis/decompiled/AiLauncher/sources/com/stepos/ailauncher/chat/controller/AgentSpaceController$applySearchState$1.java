package com.stepos.ailauncher.chat.controller;

import com.stepos.ailauncher.chat.view.ChatHistoryView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.AgentSpaceController$applySearchState$1", f = "AgentSpaceController.kt", l = {2550, 2552}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentSpaceController$applySearchState$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ChatHistoryView $historyView;
    final /* synthetic */ String $keyword;
    int label;
    final /* synthetic */ AgentSpaceController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSpaceController$applySearchState$1(String str, AgentSpaceController agentSpaceController, ChatHistoryView chatHistoryView, InterfaceC4014c<? super AgentSpaceController$applySearchState$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$keyword = str;
        this.this$0 = agentSpaceController;
        this.$historyView = chatHistoryView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSpaceController$applySearchState$1(this.$keyword, this.this$0, this.$historyView, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSpaceController$applySearchState$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if (r0 == r6) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.AgentSpaceController$applySearchState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
