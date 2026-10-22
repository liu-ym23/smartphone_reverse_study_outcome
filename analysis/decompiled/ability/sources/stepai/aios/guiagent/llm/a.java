package stepai.aios.guiagent.llm;

import S7.k;
import stepai.android.llm.base.ContentBuilder;
import stepai.android.llm.base.ImageContentBuilder;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6029a;
    public final /* synthetic */ MessageContent b;

    public /* synthetic */ a(MessageContent messageContent, int i) {
        this.f6029a = i;
        this.b = messageContent;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f6029a;
        MessageContent messageContent = this.b;
        switch (i) {
            case 0:
                return StepService$chat$response$1.invokeSuspend$lambda$0$0$0$0$0(messageContent, (ContentBuilder) obj);
            case 1:
                return StepService$chat$response$1.invokeSuspend$lambda$0$0$0$0$0$0(messageContent, (ImageContentBuilder) obj);
            case 2:
                return StepService$chat$response$1.invokeSuspend$lambda$0$0$0$0$0$1(messageContent, (ImageContentBuilder) obj);
            case 3:
                return StepService.chatStream$lambda$0$0$0$0$0$0(messageContent, (ImageContentBuilder) obj);
            case 4:
                return StepService.chatStream$lambda$0$0$0$0$0$1(messageContent, (ImageContentBuilder) obj);
            default:
                return StepService.chatStream$lambda$0$0$0$0$0(messageContent, (ContentBuilder) obj);
        }
    }
}
