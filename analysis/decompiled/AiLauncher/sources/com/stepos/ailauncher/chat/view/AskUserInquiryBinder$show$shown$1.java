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
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "answers", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.AskUserInquiryBinder$show$shown$1", f = "AskUserInquiryBinder.kt", l = {69}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AskUserInquiryBinder$show$shown$1 extends SuspendLambda implements p9.p<List<? extends String>, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ BaseInputView $input;
    final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $onShownChanged;
    final /* synthetic */ AskUserRequest $request;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AskUserInquiryBinder$show$shown$1(BaseInputView baseInputView, AskUserRequest askUserRequest, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, InterfaceC4014c<? super AskUserInquiryBinder$show$shown$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$input = baseInputView;
        this.$request = askUserRequest;
        this.$onShownChanged = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AskUserInquiryBinder$show$shown$1 askUserInquiryBinder$show$shown$1 = new AskUserInquiryBinder$show$shown$1(this.$input, this.$request, this.$onShownChanged, interfaceC4014c);
        askUserInquiryBinder$show$shown$1.L$0 = obj;
        return askUserInquiryBinder$show$shown$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(List<String> list, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((AskUserInquiryBinder$show$shown$1) create(list, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AskUserInquiryBinder$show$shown$1 askUserInquiryBinder$show$shown$1;
        boolean z10;
        InterfaceC5074l<Boolean, Y8.t> interfaceC5074l;
        List<String> list = (List) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            SessionHandler sessionHandler = this.$input.getSessionHandler();
            if (sessionHandler == null) {
                askUserInquiryBinder$show$shown$1 = this;
                if (z10 && (interfaceC5074l = askUserInquiryBinder$show$shown$1.$onShownChanged) != null) {
                    interfaceC5074l.invoke(C4109a.a(false));
                }
                return C4109a.a(z10);
            }
            String sessionId = this.$request.getSessionId();
            String inquiryId = this.$request.getInquiryId();
            String askUserMessageId = this.$request.getAskUserMessageId();
            this.L$0 = g9.h.a(list);
            this.label = 1;
            askUserInquiryBinder$show$shown$1 = this;
            obj = sessionHandler.v0(sessionId, inquiryId, list, askUserMessageId, askUserInquiryBinder$show$shown$1);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            askUserInquiryBinder$show$shown$1 = this;
        }
        InquiryAnswerResult inquiryAnswerResult = (InquiryAnswerResult) obj;
        z10 = inquiryAnswerResult != null && inquiryAnswerResult.getOk();
        if (z10) {
            interfaceC5074l.invoke(C4109a.a(false));
        }
        return C4109a.a(z10);
    }
}
