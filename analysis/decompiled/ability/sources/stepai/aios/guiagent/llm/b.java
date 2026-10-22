package stepai.aios.guiagent.llm;

import S7.k;
import stepai.android.llm.base.MessageBuilder;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6030a;
    public final /* synthetic */ StepService b;
    public final /* synthetic */ Message c;

    public /* synthetic */ b(StepService stepService, Message message, int i) {
        this.f6030a = i;
        this.b = stepService;
        this.c = message;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f6030a) {
            case 0:
                return StepService$chat$response$1.invokeSuspend$lambda$0$0$0(this.b, this.c, (MessageBuilder) obj);
            default:
                return StepService.chatStream$lambda$0$0$0(this.b, this.c, (MessageBuilder) obj);
        }
    }
}
