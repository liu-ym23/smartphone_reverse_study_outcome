package stepai.aios.guiagent.llm;

import C7.r;
import J7.c;
import S7.n;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import j9.m;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import stepai.aios.guiagent.llm.MessageContent;
import stepai.android.llm.base.ContentBuilder;
import stepai.android.llm.base.ImageContentBuilder;
import stepai.android.llm.base.LLMRequest;
import stepai.android.llm.base.LLMRequestBuilder;
import stepai.android.llm.base.MessageBuilder;
import stepai.android.mindx.client.StepLLMClient;
import stepai.android.mindx.client.config.StepChatResult;

@c(c = "stepai.aios.guiagent.llm.StepService$chat$response$1", f = "StepService.kt", l = {85}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lstepai/aios/guiagent/llm/LlmChatResponse;", "<anonymous>", "(Lm9/z;)Lstepai/aios/guiagent/llm/LlmChatResponse;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
public final class StepService$chat$response$1 extends SuspendLambda implements n {
    final /* synthetic */ LlmChatRequest $request;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ StepService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepService$chat$response$1(LlmChatRequest llmChatRequest, StepService stepService, H7.c<? super StepService$chat$response$1> cVar) {
        super(2, cVar);
        this.$request = llmChatRequest;
        this.this$0 = stepService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r invokeSuspend$lambda$0$0$0(StepService stepService, Message message, MessageBuilder messageBuilder) {
        messageBuilder.role(stepService.transformRole(message.getRole()));
        Iterator<T> it = message.getContent().iterator();
        while (it.hasNext()) {
            messageBuilder.content(new a((MessageContent) it.next(), 0));
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r invokeSuspend$lambda$0$0$0$0$0(MessageContent messageContent, ContentBuilder contentBuilder) {
        if (messageContent instanceof MessageContent.Image) {
            if (!m.s0(((MessageContent.Image) messageContent).getImageUrl())) {
                contentBuilder.image(new a((MessageContent.Image) messageContent, 1));
            }
        } else if (messageContent instanceof MessageContent.ImageBase64) {
            if (!m.s0(((MessageContent.ImageBase64) messageContent).getBase64())) {
                contentBuilder.image(new a((MessageContent.ImageBase64) messageContent, 2));
            }
        } else {
            if (!(messageContent instanceof MessageContent.Text)) {
                if (messageContent instanceof MessageContent.ToolCalls) {
                    throw new NotImplementedError();
                }
                throw new NoWhenBranchMatchedException();
            }
            MessageContent.Text text = (MessageContent.Text) messageContent;
            if (!m.s0(text.getText())) {
                ContentBuilder.text$default(contentBuilder, text.getText(), null, 2, null);
            }
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r invokeSuspend$lambda$0$0$0$0$0$0(MessageContent messageContent, ImageContentBuilder imageContentBuilder) {
        imageContentBuilder.base64ByFD(((MessageContent.Image) messageContent).getImageUrl());
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r invokeSuspend$lambda$0$0$0$0$0$1(MessageContent messageContent, ImageContentBuilder imageContentBuilder) {
        imageContentBuilder.base64ByFD("data:image/jpeg;base64," + ((MessageContent.ImageBase64) messageContent).getBase64());
        return r.f317a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new StepService$chat$response$1(this.$request, this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            LlmChatRequest llmChatRequest = this.$request;
            LLMRequestBuilder lLMRequestBuilder = new LLMRequestBuilder();
            LlmChatRequest llmChatRequest2 = this.$request;
            StepService stepService = this.this$0;
            lLMRequestBuilder.model(llmChatRequest.getModel());
            Iterator<T> it = llmChatRequest.getMessages().iterator();
            while (it.hasNext()) {
                lLMRequestBuilder.message(new b(stepService, (Message) it.next(), 0));
            }
            Float temperature = llmChatRequest2.getTemperature();
            lLMRequestBuilder.temperature(temperature != null ? temperature.floatValue() : 0.0f);
            Float topP = llmChatRequest2.getTopP();
            lLMRequestBuilder.topP(topP != null ? topP.floatValue() : 0.01f);
            Integer maxTokens = llmChatRequest2.getMaxTokens();
            if (maxTokens == null) {
                maxTokens = llmChatRequest.getMaxTokens();
            }
            lLMRequestBuilder.maxTokens(maxTokens);
            LLMRequest lLMRequestBuild = lLMRequestBuilder.build();
            StepLLMClient stepLLMClient = StepLLMClient.INSTANCE;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            obj = stepLLMClient.chat(lLMRequestBuild, stepai.android.mindx.base.c.b, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        StepChatResult stepChatResult = (StepChatResult) obj;
        if (stepChatResult instanceof StepChatResult.Error) {
            StepChatResult.Error error = (StepChatResult.Error) stepChatResult;
            return new LlmChatResponse(error.getId(), "", 0L, false, error.getMessage(), null, null, null, null, 484, null);
        }
        if (!(stepChatResult instanceof StepChatResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        StepChatResult.Success success = (StepChatResult.Success) stepChatResult;
        return new LlmChatResponse(success.getId(), success.getMessage(), 0L, false, null, null, null, null, null, TypedValues.PositionType.TYPE_CURVE_FIT, null);
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super LlmChatResponse> cVar) {
        return ((StepService$chat$response$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
