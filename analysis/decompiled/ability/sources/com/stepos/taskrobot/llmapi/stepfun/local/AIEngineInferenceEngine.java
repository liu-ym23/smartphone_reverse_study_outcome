package com.stepos.taskrobot.llmapi.stepfun.local;

import C7.r;
import D7.v;
import H4.o;
import J7.c;
import S7.n;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.algorithm.guiagent.GuiAgentCallback;
import com.stepos.aiengine.algorithm.guiagent.IGuiAgent;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.client.AlgorithmClient;
import com.stepos.aiengine.clients.AlgorithmClients;
import f6.AbstractC1436a;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.sync.a;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.C1718k;
import m9.InterfaceC1733z;
import stepai.aios.guiagent.llm.local.LocalInferenceConfig;
import stepai.aios.guiagent.llm.local.LocalInferenceEngine;
import stepai.aios.guiagent.llm.local.LocalInferenceResult;
import stepai.aios.guiagent.llm.local.LocalMessage;
import u9.d;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u0004\u0018\u00010\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u001f\u0010\u0014\u001a\u0004\u0018\u00010\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015JD\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0082@¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010#J\u0018\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b%\u0010&J&\u0010)\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010(\u001a\u00020'H\u0096@¢\u0006\u0004\b)\u0010*J\u0010\u0010,\u001a\u00020+H\u0096@¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010.R\u001a\u0010/\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/local/AIEngineInferenceEngine;", "Lstepai/aios/guiagent/llm/local/LocalInferenceEngine;", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "Lcom/stepos/aiengine/algorithm/guiagent/IGuiAgent;", "ensureAgent", "()Lcom/stepos/aiengine/algorithm/guiagent/IGuiAgent;", "", "reason", "loadAndPreloadAgent", "(Ljava/lang/String;)Lcom/stepos/aiengine/algorithm/guiagent/IGuiAgent;", "", "Lstepai/aios/guiagent/llm/local/LocalMessage;", "messages", "extractSystemPrompt", "(Ljava/util/List;)Ljava/lang/String;", "extractUserPrompt", "Landroid/graphics/Bitmap;", "extractBitmap", "(Ljava/util/List;)Landroid/graphics/Bitmap;", "guiAgent", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "bitmap", "userPrompt", "systemPrompt", "Landroid/os/Bundle;", "args", "Lstepai/aios/guiagent/llm/local/LocalInferenceResult;", "decideAndAwait", "(Lcom/stepos/aiengine/algorithm/guiagent/IGuiAgent;Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;LH7/c;)Ljava/lang/Object;", "base64", "decodeBase64ToBitmap", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "", "isAvailable", "(Landroid/content/Context;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/llm/local/LocalInferenceConfig;", "config", "chat", "(Ljava/util/List;Lstepai/aios/guiagent/llm/local/LocalInferenceConfig;LH7/c;)Ljava/lang/Object;", "LC7/r;", "release", "(LH7/c;)Ljava/lang/Object;", "Landroid/content/Context;", "engineId", "Ljava/lang/String;", "getEngineId", "()Ljava/lang/String;", "Lw9/a;", "mutex", "Lw9/a;", "agent", "Lcom/stepos/aiengine/algorithm/guiagent/IGuiAgent;", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AIEngineInferenceEngine implements LocalInferenceEngine {
    private static final String TAG = "AIEngineInference";
    private volatile IGuiAgent agent;
    private final Context context;
    private final String engineId;
    private final InterfaceC2108a mutex;

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.local.AIEngineInferenceEngine$chat$2", f = "AIEngineInferenceEngine.kt", l = {227, 71}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lstepai/aios/guiagent/llm/local/LocalInferenceResult;", "<anonymous>", "(Lm9/z;)Lstepai/aios/guiagent/llm/local/LocalInferenceResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.local.AIEngineInferenceEngine$chat$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ LocalInferenceConfig $config;
        final /* synthetic */ List<LocalMessage> $messages;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<LocalMessage> list, LocalInferenceConfig localInferenceConfig, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$messages = list;
            this.$config = localInferenceConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return AIEngineInferenceEngine.this.new AnonymousClass2(this.$messages, this.$config, cVar);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(7:(1:(1:(8:6|47|7|8|33|34|41|42)(2:13|14))(1:15))(3:16|(1:19)|31)|45|20|(2:51|22)(1:28)|29|(5:32|33|34|41|42)|31) */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00c0, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00c1, code lost:
        
            r2 = r15;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v14, types: [w9.a] */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v4 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 323
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.local.AIEngineInferenceEngine.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super LocalInferenceResult> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.local.AIEngineInferenceEngine$isAvailable$2", f = "AIEngineInferenceEngine.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.local.AIEngineInferenceEngine$isAvailable$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11912 extends SuspendLambda implements n {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11912(Context context, H7.c<? super C11912> cVar) {
            super(2, cVar);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C11912(this.$context, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AlgorithmClients algorithmClients;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            boolean z10 = false;
            try {
                algorithmClients = AlgorithmClients.INSTANCE;
            } catch (Exception e) {
                AbstractC1436a.c(AIEngineInferenceEngine.TAG, "isAvailable check failed: " + e.getMessage(), e);
            }
            if (!algorithmClients.getGuiAgent().isSupported(this.$context)) {
                return Boolean.FALSE;
            }
            if (algorithmClients.getGuiAgent().checkResources(this.$context) == 1) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
            return ((C11912) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.local.AIEngineInferenceEngine$release$2", f = "AIEngineInferenceEngine.kt", l = {227}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.local.AIEngineInferenceEngine$release$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11922 extends SuspendLambda implements n {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        public C11922(H7.c<? super C11922> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return AIEngineInferenceEngine.this.new C11922(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InterfaceC2108a interfaceC2108a;
            AIEngineInferenceEngine aIEngineInferenceEngine;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                InterfaceC2108a interfaceC2108a2 = AIEngineInferenceEngine.this.mutex;
                AIEngineInferenceEngine aIEngineInferenceEngine2 = AIEngineInferenceEngine.this;
                this.L$0 = interfaceC2108a2;
                this.L$1 = aIEngineInferenceEngine2;
                this.I$0 = 0;
                this.label = 1;
                if (interfaceC2108a2.lock(null, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                interfaceC2108a = interfaceC2108a2;
                aIEngineInferenceEngine = aIEngineInferenceEngine2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aIEngineInferenceEngine = (AIEngineInferenceEngine) this.L$1;
                interfaceC2108a = (InterfaceC2108a) this.L$0;
                b.b(obj);
            }
            try {
                IGuiAgent iGuiAgent = aIEngineInferenceEngine.agent;
                r rVar = r.f317a;
                if (iGuiAgent == null) {
                    return rVar;
                }
                try {
                    aIEngineInferenceEngine.agent = null;
                    AlgorithmClients.INSTANCE.getGuiAgent().releaseClient();
                    AbstractC1436a.d(AIEngineInferenceEngine.TAG, "AIEngine guiAgent released", true);
                } catch (Exception e) {
                    aIEngineInferenceEngine.agent = null;
                    AbstractC1436a.c(AIEngineInferenceEngine.TAG, "release failed: " + e.getMessage(), e);
                }
                return rVar;
            } finally {
                interfaceC2108a.unlock(null);
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11922) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public AIEngineInferenceEngine(Context context) {
        k.f(context, "context");
        this.context = context;
        this.engineId = "aiengine-gui-agent";
        this.mutex = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object decideAndAwait(final IGuiAgent iGuiAgent, final AlgorithmToken algorithmToken, Bitmap bitmap, String str, String str2, Bundle bundle, H7.c<? super LocalInferenceResult> cVar) {
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        final StringBuilder sb = new StringBuilder();
        GuiAgentCallback guiAgentCallback = new GuiAgentCallback() { // from class: com.stepos.taskrobot.llmapi.stepfun.local.AIEngineInferenceEngine$decideAndAwait$2$callback$1
            @Override // com.stepos.aiengine.algorithm.guiagent.GuiAgentCallback
            public void onDone(String result) {
                k.f(result, "result");
                if (sb.length() > 0) {
                    result = sb.toString();
                }
                String str3 = result;
                k.c(str3);
                AbstractC1436a.d("AIEngineInference", "decide done, length=" + str3.length(), true);
                kotlin.collections.b.a(3000, 3000);
                int length = str3.length();
                int i = 0;
                ArrayList arrayList = new ArrayList((length / 3000) + (length % 3000 == 0 ? 0 : 1));
                int i6 = 0;
                while (i6 >= 0 && i6 < length) {
                    int i10 = i6 + 3000;
                    CharSequence it = str3.subSequence(i6, (i10 < 0 || i10 > length) ? length : i10);
                    k.f(it, "it");
                    arrayList.add(it.toString());
                    i6 = i10;
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    int i11 = i + 1;
                    if (i < 0) {
                        o.X();
                        throw null;
                    }
                    AbstractC1436a.d("AIEngineInference", "decide done raw chunk[" + i + "]=[" + ((String) next) + "]", true);
                    i = i11;
                }
                if (c1718k.isActive()) {
                    c1718k.resumeWith(new LocalInferenceResult(str3, false, null, 6, null));
                }
            }

            @Override // com.stepos.aiengine.algorithm.guiagent.GuiAgentCallback
            public void onError(int code, String message) {
                k.f(message, "message");
                AbstractC1436a.b("AIEngineInference", "decide error: code=" + code + ", msg=" + message, true);
                if (c1718k.isActive()) {
                    c1718k.resumeWith(new LocalInferenceResult("", false, androidx.constraintlayout.core.dsl.a.c(code, "AIEngine GUI Agent error(", "): ", message)));
                }
            }

            @Override // com.stepos.aiengine.algorithm.guiagent.GuiAgentCallback
            public void onNext(String token) {
                k.f(token, "token");
                sb.append(token);
            }
        };
        List<Bitmap> listM = bitmap != null ? o.M(bitmap) : EmptyList.f4893a;
        int size = listM.size();
        int length = str.length();
        String strN0 = m.N0(1000, str);
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(size, "decide submit: bitmaps=", length, ", promptLen=", ", prompt=[");
        sbS.append(strN0);
        sbS.append("]");
        AbstractC1436a.d(TAG, sbS.toString(), true);
        EmptyList emptyList = EmptyList.f4893a;
        int iDecide = iGuiAgent.decide(algorithmToken, emptyList, emptyList, listM, str, str2, bundle, guiAgentCallback);
        if (iDecide == 0) {
            c1718k.j(new S7.k() { // from class: com.stepos.taskrobot.llmapi.stepfun.local.AIEngineInferenceEngine$decideAndAwait$2$1
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return r.f317a;
                }

                public final void invoke(Throwable th) {
                    try {
                        iGuiAgent.cancel(algorithmToken.getIdentity());
                    } catch (Exception unused) {
                    }
                }
            });
        } else if (c1718k.isActive()) {
            c1718k.resumeWith(new LocalInferenceResult("", false, B7.a.h(iDecide, "decide 提交失败: ret=")));
        }
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    private final Bitmap decodeBase64ToBitmap(String base64) {
        try {
            byte[] bArrDecode = Base64.decode(base64, 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e) {
            AbstractC1436a.c(TAG, "decode base64 failed: " + e.getMessage(), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGuiAgent ensureAgent() {
        IGuiAgent iGuiAgent = this.agent;
        return iGuiAgent != null ? iGuiAgent : loadAndPreloadAgent("ensure");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap extractBitmap(List<LocalMessage> messages) {
        Iterator it = v.S0(messages).iterator();
        while (it.hasNext()) {
            String imageBase64 = ((LocalMessage) it.next()).getImageBase64();
            if (imageBase64 != null && !m.s0(imageBase64)) {
                return decodeBase64ToBitmap(imageBase64);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String extractSystemPrompt(List<LocalMessage> messages) {
        Object next;
        String text;
        Iterator<T> it = messages.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (k.b(((LocalMessage) next).getRole(), "system")) {
                break;
            }
        }
        LocalMessage localMessage = (LocalMessage) next;
        if (localMessage == null || (text = localMessage.getText()) == null || m.s0(text)) {
            return null;
        }
        return text;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String extractUserPrompt(List<LocalMessage> messages) {
        String text;
        ArrayList arrayList = new ArrayList();
        for (Object obj : messages) {
            if (k.b(((LocalMessage) obj).getRole(), BffConstant.Role.User)) {
                arrayList.add(obj);
            }
        }
        LocalMessage localMessage = (LocalMessage) v.L0(arrayList);
        if (localMessage != null && (text = localMessage.getText()) != null) {
            return text;
        }
        LocalMessage localMessage2 = (LocalMessage) v.L0(messages);
        return localMessage2 != null ? localMessage2.getText() : "";
    }

    private final IGuiAgent loadAndPreloadAgent(String reason) {
        IGuiAgent iGuiAgent = (IGuiAgent) AlgorithmClient.loadAlgorithm$default(AlgorithmClients.INSTANCE.getGuiAgent(), this.context, null, 2, null);
        if (iGuiAgent == null) {
            throw new IllegalStateException("loadAlgorithm(guiAgent) 返回 null，请确认 AIEngine 服务已安装且模型已下载");
        }
        iGuiAgent.preload(new Bundle());
        this.agent = iGuiAgent;
        AbstractC1436a.d(TAG, "guiAgent loaded and preloaded, reason=" + reason, true);
        return iGuiAgent;
    }

    @Override // stepai.aios.guiagent.llm.local.LocalInferenceEngine
    public Object chat(List<LocalMessage> list, LocalInferenceConfig localInferenceConfig, H7.c<? super LocalInferenceResult> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(list, localInferenceConfig, null), cVar);
    }

    @Override // stepai.aios.guiagent.llm.local.LocalInferenceEngine
    public String getEngineId() {
        return this.engineId;
    }

    @Override // stepai.aios.guiagent.llm.local.LocalInferenceEngine
    public Object isAvailable(Context context, H7.c<? super Boolean> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C11912(context, null), cVar);
    }

    @Override // stepai.aios.guiagent.llm.local.LocalInferenceEngine
    public Object release(H7.c<? super r> cVar) throws Throwable {
        d dVar = AbstractC1691I.f5315a;
        Object objW = AbstractC1683A.w(u9.c.f6743a, new C11922(null), cVar);
        return objW == CoroutineSingletons.f4909a ? objW : r.f317a;
    }
}
