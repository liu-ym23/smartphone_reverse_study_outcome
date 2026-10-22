package com.stepos.ailauncher.chat.view;

import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.stepos.agentframework.chatcore.SessionHandler;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "answers", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ChatView$initEvents$1$2$1", f = "ChatView.kt", l = {805}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatView$initEvents$1$2$1 extends SuspendLambda implements p9.p<List<? extends String>, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $askUserMessageId;
    final /* synthetic */ String $inqId;
    final /* synthetic */ String $sid;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatView$initEvents$1$2$1(ChatView chatView, String str, String str2, String str3, InterfaceC4014c<? super ChatView$initEvents$1$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatView;
        this.$sid = str;
        this.$inqId = str2;
        this.$askUserMessageId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ChatView$initEvents$1$2$1 chatView$initEvents$1$2$1 = new ChatView$initEvents$1$2$1(this.this$0, this.$sid, this.$inqId, this.$askUserMessageId, interfaceC4014c);
        chatView$initEvents$1$2$1.L$0 = obj;
        return chatView$initEvents$1$2$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(List<String> list, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((ChatView$initEvents$1$2$1) create(list, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<String> list = (List) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        boolean z10 = false;
        if (i10 == 0) {
            C4849c.b(obj);
            SessionHandler sessionHandler = this.this$0.getInputView().getSessionHandler();
            if (sessionHandler != null) {
                String str = this.$sid;
                String str2 = this.$inqId;
                String str3 = this.$askUserMessageId;
                this.L$0 = g9.h.a(list);
                this.label = 1;
                obj = sessionHandler.v0(str, str2, list, str3, this);
                if (obj == objG) {
                    return objG;
                }
            }
            return C4109a.a(z10);
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        InquiryAnswerResult inquiryAnswerResult = (InquiryAnswerResult) obj;
        if (inquiryAnswerResult != null && inquiryAnswerResult.getOk()) {
            z10 = true;
        }
        return C4109a.a(z10);
    }
}
