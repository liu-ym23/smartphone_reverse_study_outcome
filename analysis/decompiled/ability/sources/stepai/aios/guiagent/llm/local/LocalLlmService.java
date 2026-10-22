package stepai.aios.guiagent.llm.local;

import H4.o;
import J7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.AgentCache;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.args.ExecutionBundle;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.llm.LlmChatRequest;
import stepai.aios.guiagent.llm.LlmModel;
import stepai.aios.guiagent.llm.LlmService;
import stepai.aios.guiagent.llm.MessageRole;
import stepai.aios.guiagent.llm.ModelCapabilities;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lstepai/aios/guiagent/llm/local/LocalLlmService;", "Lstepai/aios/guiagent/llm/LlmService;", AppAgent.CONSTRUCT, "()V", "Lstepai/aios/guiagent/llm/MessageRole;", "", "toLocalRole", "(Lstepai/aios/guiagent/llm/MessageRole;)Ljava/lang/String;", "", "isAvailable", "(LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/llm/biz/LlmChatBizRequest;", "bizRequest", "Lstepai/aios/guiagent/llm/LlmChatResponse;", "chat", "(Lstepai/aios/guiagent/llm/biz/LlmChatBizRequest;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/llm/LlmChatRequest;", "request", "Lp9/c;", "Lstepai/aios/guiagent/llm/LlmStreamResponse;", "chatStream", "(Lstepai/aios/guiagent/llm/LlmChatRequest;)Lp9/c;", "", "Lstepai/aios/guiagent/llm/LlmModel;", "getSupportedModels", "()Ljava/util/List;", "modelName", "Lstepai/aios/guiagent/llm/ModelCapabilities;", "getModelCapabilities", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/llm/local/LocalInferenceEngine;", "engine", "Lstepai/aios/guiagent/llm/local/LocalInferenceEngine;", "serviceId", "Ljava/lang/String;", "getServiceId", "()Ljava/lang/String;", "prefersBase64Image", "Z", "getPrefersBase64Image", "()Z", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocalLlmService implements LlmService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "LocalLlmService";
    private static volatile LocalInferenceEngine defaultEngine;
    private volatile LocalInferenceEngine engine = defaultEngine;
    private final String serviceId = ExecutionBundle.PREF_LOCAL;
    private final boolean prefersBase64Image = true;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lstepai/aios/guiagent/llm/local/LocalLlmService$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "defaultEngine", "Lstepai/aios/guiagent/llm/local/LocalInferenceEngine;", "getDefaultEngine", "()Lstepai/aios/guiagent/llm/local/LocalInferenceEngine;", "setDefaultEngine", "(Lstepai/aios/guiagent/llm/local/LocalInferenceEngine;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final LocalInferenceEngine getDefaultEngine() {
            return LocalLlmService.defaultEngine;
        }

        public final void setDefaultEngine(LocalInferenceEngine localInferenceEngine) {
            LocalLlmService.defaultEngine = localInferenceEngine;
        }

        private Companion() {
        }
    }

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

    @c(c = "stepai.aios.guiagent.llm.local.LocalLlmService", f = "LocalLlmService.kt", l = {82}, m = "chat", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.llm.local.LocalLlmService$chat$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalLlmService.this.chat(null, this);
        }
    }

    @c(c = "stepai.aios.guiagent.llm.local.LocalLlmService", f = "LocalLlmService.kt", l = {38}, m = "isAvailable", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.llm.local.LocalLlmService$isAvailable$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19441 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C19441(H7.c<? super C19441> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalLlmService.this.isAvailable(this);
        }
    }

    private final String toLocalRole(MessageRole messageRole) {
        int i = WhenMappings.$EnumSwitchMapping$0[messageRole.ordinal()];
        if (i == 1) {
            return "system";
        }
        if (i == 2) {
            return BffConstant.Role.User;
        }
        if (i == 3) {
            return "assistant";
        }
        if (i == 4) {
            return AgentCache.AGENT_CACHE_TASK_TYPE_TOOL;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // stepai.aios.guiagent.llm.LlmService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object chat(stepai.aios.guiagent.llm.biz.LlmChatBizRequest r21, H7.c<? super stepai.aios.guiagent.llm.LlmChatResponse> r22) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.local.LocalLlmService.chat(stepai.aios.guiagent.llm.biz.LlmChatBizRequest, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public p9.c chatStream(LlmChatRequest request) {
        k.f(request, "request");
        throw new NotImplementedError("An operation is not implemented: 本地模型流式推理暂未实现");
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public Object getModelCapabilities(String str, H7.c<? super ModelCapabilities> cVar) {
        return new ModelCapabilities(true, false, false, new Integer(2048), new Integer(4096), null, null, 96, null);
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public boolean getPrefersBase64Image() {
        return this.prefersBase64Image;
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public String getServiceId() {
        return this.serviceId;
    }

    @Override // stepai.aios.guiagent.llm.LlmService
    public List<LlmModel> getSupportedModels() {
        return o.M(new LlmModel("local-vlm", "Local VLM", "端侧视觉语言模型（AIEngine）", 4096, false, new ModelCapabilities(true, false, false, 2048, 4096, null, null, 96, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // stepai.aios.guiagent.llm.LlmService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object isAvailable(H7.c<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof stepai.aios.guiagent.llm.local.LocalLlmService.C19441
            if (r0 == 0) goto L13
            r0 = r5
            stepai.aios.guiagent.llm.local.LocalLlmService$isAvailable$1 r0 = (stepai.aios.guiagent.llm.local.LocalLlmService.C19441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            stepai.aios.guiagent.llm.local.LocalLlmService$isAvailable$1 r0 = new stepai.aios.guiagent.llm.local.LocalLlmService$isAvailable$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r5)
            goto L44
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r5)
            stepai.aios.guiagent.llm.local.LocalInferenceEngine r4 = r4.engine
            if (r4 == 0) goto L4b
            android.app.Application r5 = new android.app.Application
            r5.<init>()
            r0.label = r3
            java.lang.Object r5 = r4.isAvailable(r5, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r4 = r5.booleanValue()
            goto L4c
        L4b:
            r4 = 0
        L4c:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.local.LocalLlmService.isAvailable(H7.c):java.lang.Object");
    }
}
