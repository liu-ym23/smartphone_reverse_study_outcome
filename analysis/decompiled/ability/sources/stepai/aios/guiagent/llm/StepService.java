package stepai.aios.guiagent.llm;

import C7.r;
import H4.o;
import J7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.llm.MessageContent;
import stepai.android.llm.base.ContentBuilder;
import stepai.android.llm.base.ImageContentBuilder;
import stepai.android.llm.base.LLMRequestBuilder;
import stepai.android.llm.base.MessageBuilder;
import stepai.android.llm.base.Role;
import stepai.android.mindx.client.StepLLMClient;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001b8\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lstepai/aios/guiagent/llm/StepService;", "Lstepai/aios/guiagent/llm/LlmService;", AppAgent.CONSTRUCT, "()V", "", "isAvailable", "(LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/llm/MessageRole;", "role", "Lstepai/android/llm/base/Role;", "transformRole", "(Lstepai/aios/guiagent/llm/MessageRole;)Lstepai/android/llm/base/Role;", "Lstepai/aios/guiagent/llm/biz/LlmChatBizRequest;", "bizRequest", "Lstepai/aios/guiagent/llm/LlmChatResponse;", "chat", "(Lstepai/aios/guiagent/llm/biz/LlmChatBizRequest;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/llm/LlmChatRequest;", "request", "Lp9/c;", "Lstepai/aios/guiagent/llm/LlmStreamResponse;", "chatStream", "(Lstepai/aios/guiagent/llm/LlmChatRequest;)Lp9/c;", "", "Lstepai/aios/guiagent/llm/LlmModel;", "getSupportedModels", "()Ljava/util/List;", "", "modelName", "Lstepai/aios/guiagent/llm/ModelCapabilities;", "getModelCapabilities", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "serviceId", "Ljava/lang/String;", "getServiceId", "()Ljava/lang/String;", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepService implements LlmService {
    private static final String TAG = "mindx-client";
    private final String serviceId = "step";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageRole.values().length];
            try {
                iArr[MessageRole.SYSTEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageRole.USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageRole.ASSISTANT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageRole.TOOL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @c(c = "stepai.aios.guiagent.llm.StepService", f = "StepService.kt", l = {40, 42}, m = "chat", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.llm.StepService$chat$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StepService.this.chat(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r chatStream$lambda$0$0$0(StepService stepService, Message message, MessageBuilder message2) {
        k.f(message2, "$this$message");
        message2.role(stepService.transformRole(message.getRole()));
        Iterator<T> it = message.getContent().iterator();
        while (it.hasNext()) {
            message2.content(new a((MessageContent) it.next(), 5));
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r chatStream$lambda$0$0$0$0$0(MessageContent messageContent, ContentBuilder content) {
        k.f(content, "$this$content");
        if (messageContent instanceof MessageContent.Image) {
            if (!m.s0(((MessageContent.Image) messageContent).getImageUrl())) {
                content.image(new a((MessageContent.Image) messageContent, 3));
            }
        } else if (messageContent instanceof MessageContent.ImageBase64) {
            if (!m.s0(((MessageContent.ImageBase64) messageContent).getBase64())) {
                content.image(new a((MessageContent.ImageBase64) messageContent, 4));
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
                ContentBuilder.text$default(content, text.getText(), null, 2, null);
            }
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r chatStream$lambda$0$0$0$0$0$0(MessageContent messageContent, ImageContentBuilder image) {
        k.f(image, "$this$image");
        image.base64ByFD(((MessageContent.Image) messageContent).getImageUrl());
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r chatStream$lambda$0$0$0$0$0$1(MessageContent messageContent, ImageContentBuilder image) {
        k.f(image, "$this$image");
        image.base64ByFD("data:image/png;base64," + ((MessageContent.ImageBase64) messageContent).getBase64());
        return r.f317a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        if (r7 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // stepai.aios.guiagent.llm.LlmService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object chat(stepai.aios.guiagent.llm.biz.LlmChatBizRequest r6, H7.c<? super stepai.aios.guiagent.llm.LlmChatResponse> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof stepai.aios.guiagent.llm.StepService.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            stepai.aios.guiagent.llm.StepService$chat$1 r0 = (stepai.aios.guiagent.llm.StepService.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            stepai.aios.guiagent.llm.StepService$chat$1 r0 = new stepai.aios.guiagent.llm.StepService$chat$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            stepai.aios.guiagent.llm.LlmChatRequest r5 = (stepai.aios.guiagent.llm.LlmChatRequest) r5
            java.lang.Object r5 = r0.L$0
            stepai.aios.guiagent.llm.biz.LlmChatBizRequest r5 = (stepai.aios.guiagent.llm.biz.LlmChatBizRequest) r5
            kotlin.b.b(r7)
            goto L6d
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            java.lang.Object r6 = r0.L$0
            stepai.aios.guiagent.llm.biz.LlmChatBizRequest r6 = (stepai.aios.guiagent.llm.biz.LlmChatBizRequest) r6
            kotlin.b.b(r7)
            goto L52
        L42:
            kotlin.b.b(r7)
            r0.L$0 = r6
            r0.label = r4
            stepai.aios.guiagent.util.b r7 = stepai.aios.guiagent.util.b.f6178a
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L52
            goto L6c
        L52:
            stepai.aios.guiagent.llm.LlmChatRequest r6 = r6.getLlmChatRequest()
            u9.d r7 = m9.AbstractC1691I.f5315a
            u9.c r7 = u9.c.f6743a
            stepai.aios.guiagent.llm.StepService$chat$response$1 r2 = new stepai.aios.guiagent.llm.StepService$chat$response$1
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.L$0 = r4
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r7 = m9.AbstractC1683A.w(r7, r2, r0)
            if (r7 != r1) goto L6d
        L6c:
            return r1
        L6d:
            stepai.aios.guiagent.llm.LlmChatResponse r7 = (stepai.aios.guiagent.llm.LlmChatResponse) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.StepService.chat(stepai.aios.guiagent.llm.biz.LlmChatBizRequest, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public p9.c chatStream(LlmChatRequest request) {
        k.f(request, "request");
        LLMRequestBuilder lLMRequestBuilder = new LLMRequestBuilder();
        lLMRequestBuilder.model(request.getModel());
        Iterator<T> it = request.getMessages().iterator();
        while (it.hasNext()) {
            lLMRequestBuilder.message(new b(this, (Message) it.next(), 1));
        }
        Float temperature = request.getTemperature();
        if (temperature != null) {
            lLMRequestBuilder.temperature(temperature.floatValue());
        }
        Float topP = request.getTopP();
        if (topP != null) {
            lLMRequestBuilder.topP(topP.floatValue());
        }
        lLMRequestBuilder.maxTokens(request.getMaxTokens());
        return new p9.m(new StepService$chatStream$$inlined$transform$1(StepLLMClient.INSTANCE.stream(lLMRequestBuilder.build(), stepai.android.mindx.base.c.f6199a), null));
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public Object getModelCapabilities(String str, H7.c<? super ModelCapabilities> cVar) {
        return new ModelCapabilities(false, true, true, new Integer(8192), new Integer(32768), null, null, 96, null);
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public /* bridge */ boolean getPrefersBase64Image() {
        return super.getPrefersBase64Image();
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public String getServiceId() {
        return this.serviceId;
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public List<LlmModel> getSupportedModels() {
        return o.k(new LlmModel("step1ot-gui-agent-code-toolcall-0702", "step1ot-gui-agent-code-toolcall-0702", "step model", 32768, false, null, 48, null));
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public Object isAvailable(H7.c<? super Boolean> cVar) {
        return Boolean.TRUE;
    }

    public final Role transformRole(MessageRole role) {
        k.f(role, "role");
        int i = WhenMappings.$EnumSwitchMapping$0[role.ordinal()];
        if (i == 1) {
            return Role.System.INSTANCE;
        }
        if (i == 2) {
            return Role.User.INSTANCE;
        }
        if (i == 3) {
            return Role.Assistant.INSTANCE;
        }
        if (i == 4) {
            return Role.System.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
