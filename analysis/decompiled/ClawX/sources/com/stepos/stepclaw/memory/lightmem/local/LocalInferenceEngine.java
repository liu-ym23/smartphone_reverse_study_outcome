package com.stepos.stepclaw.memory.lightmem.local;

import a6.f0;
import a6.i0;
import a6.r0;
import android.content.Context;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.remote.MessageItem;
import f5.c;
import h5.e;
import h6.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u000b\u0010\bJ*\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J0\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0013\u0010,\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b*\u0010+R$\u00103\u001a\u00020-2\u0006\u0010.\u001a\u00020-8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00106\u001a\u00020-2\u0006\u0010.\u001a\u00020-8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u0011\u00107\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\b7\u00100¨\u00069"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferenceEngine;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferSupportState;", "checkSupport", "(Landroid/content/Context;Lf5/c;)Ljava/lang/Object;", "Lv2/c;", "Lcom/stepos/aiservice/algorithm/memory/IMemory;", "loadAlgorithm", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "userQuery", "dialogHistory", "systemPrompt", "Lcom/stepos/stepclaw/memory/lightmem/local/MemoryRecallDecision;", "decideMemoryRecall", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "text", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "embedText", "(Ljava/lang/String;Landroid/content/Context;Lf5/c;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "texts", "embedAllTexts", "(Ljava/util/List;Landroid/content/Context;Lf5/c;)Ljava/lang/Object;", "Lkotlin/Function0;", "host", "Lp5/a;", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalMemoryRuntime;", "memory", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalMemoryRuntime;", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalBgeEmbedding;", "bge", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalBgeEmbedding;", "applicationContext", "Landroid/content/Context;", "getApplicationContext$step_memory_release", "()Landroid/content/Context;", "setApplicationContext$step_memory_release", "(Landroid/content/Context;)V", "getSupportState", "()Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferSupportState;", "supportState", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "value", "getMemoryEnabled", "()Z", "setMemoryEnabled", "(Z)V", "memoryEnabled", "getEmbeddingEnabled", "setEmbeddingEnabled", "embeddingEnabled", "isReady", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LocalInferenceEngine {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEFAULT_SYSTEM_PROMPT = "你是记忆检索决策器。\n\n输入是用户最近的一段对话消息，主要依据最新一条或最后几条用户消息判断：\n回复当前请求前，是否需要先检索历史记忆。\n\n你的任务不是回答用户问题，而是输出一个 JSON 决策结果：\n{\"need_memory_recall\": <bool>, \"query\": <str>}\n\n规则：\n1. 只输出 JSON，不要输出解释、分析、markdown、代码块。\n2. 若 need_memory_recall=false，query 必须是空字符串 \"\"。\n3. 若 need_memory_recall=true，query 必须描述“应该检索哪些历史信息”，不能复述当前请求，不能写成回答内容。\n4. 当边界不清时，轻度偏向 need_memory_recall=true。\n5. 输入里如果同时包含“最近用户原始消息”和“大段历史背景/summary/Source/日志”，必须优先依据“最近用户原始消息”判断。\n6. 对长输入，先定位最后一条或最后几条真实用户请求，再判断；不要被更早的摘要、工具日志、旧任务带偏。\n\n优先判为 true 的情况：\n- 用户在问和“之前”有关的事：日程、待办、联系人、位置、偏好、历史设置、身份设定、称呼、名字、过去说过的话。\n- 用户要求执行任务，而历史偏好/配置/上下文会影响执行：日历、提醒、飞书、GitHub、技能、配置、餐饮推荐、地点推荐、行程安排、持续任务、定时任务。\n- 用户说“继续”“再试一次”“还是那个任务”“帮我看看今天/明天/下午有什么安排”这类明显依赖上下文的请求。\n- 用户在确认助手身份、昵称、角色设定，或询问你/我叫什么、你是谁、你现在叫啥。\n\n优先判为 false 的情况：\n- 纯打招呼、纯寒暄、无个性化依赖的极简闲聊。\n- 不需要任何历史信息即可直接回答的通用事实问题。\n\nquery 写法要求：\n- 写成“要查的记忆维度”，不是“当前要做的动作”。\n- 尽量覆盖偏好、限制条件、已有配置、历史事件、联系人、时间地点等关键维度。\n- 保持简洁具体，避免空泛词，如“相关信息”“用户信息”“历史记录”。\n\n正确示例：\n{\"need_memory_recall\": true, \"query\": \"用户今天的日程安排、待办事项、日历事件和提醒设置\"}\n{\"need_memory_recall\": true, \"query\": \"用户给助手设定的昵称、身份设定和称呼偏好\"}\n{\"need_memory_recall\": false, \"query\": \"\"}\n\n错误示例：\n{\"need_memory_recall\": true, \"query\": \"今天下午有什么日程\"}  # 这是复述当前请求\n{\"need_memory_recall\": true, \"query\": \"帮我打开微博发消息\"}  # 这是动作，不是要查的记忆\n\n现在请严格输出 JSON。";
    private Context applicationContext;
    private final LocalBgeEmbedding bge;
    private final a host;
    private final LocalMemoryRuntime memory;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferenceEngine$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "DEFAULT_SYSTEM_PROMPT", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "buildDialogHistory", "messages", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final String buildDialogHistory(List<MessageItem> messages) {
            p.e(messages, "messages");
            return LocalMemoryRuntime.INSTANCE.buildDialogHistory(messages);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"La6/f0;", "Lv2/c;", "Lcom/stepos/aiservice/algorithm/memory/IMemory;", "<anonymous>", "(La6/f0;)Lv2/c;"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.memory.lightmem.local.LocalInferenceEngine$loadAlgorithm$2", f = "LocalInferenceEngine.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.local.LocalInferenceEngine$loadAlgorithm$2, reason: invalid class name */
    public static final class AnonymousClass2 extends h5.i implements p5.p {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, c cVar) {
            super(2, cVar);
            this.$context = context;
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            return LocalInferenceEngine.this.new AnonymousClass2(this.$context, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            LocalInferenceEngine.this.setApplicationContext$step_memory_release(this.$context);
            return LocalInferenceEngine.this.memory.reloadMemoryAlgorithm();
        }
    }

    public LocalInferenceEngine() {
        b7.c cVar = new b7.c(11, this);
        this.host = cVar;
        this.memory = new LocalMemoryRuntime(cVar);
        this.bge = new LocalBgeEmbedding(cVar);
    }

    public static /* synthetic */ Object decideMemoryRecall$default(LocalInferenceEngine localInferenceEngine, String str, String str2, String str3, c cVar, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str3 = "你是记忆检索决策器。\n\n输入是用户最近的一段对话消息，主要依据最新一条或最后几条用户消息判断：\n回复当前请求前，是否需要先检索历史记忆。\n\n你的任务不是回答用户问题，而是输出一个 JSON 决策结果：\n{\"need_memory_recall\": <bool>, \"query\": <str>}\n\n规则：\n1. 只输出 JSON，不要输出解释、分析、markdown、代码块。\n2. 若 need_memory_recall=false，query 必须是空字符串 \"\"。\n3. 若 need_memory_recall=true，query 必须描述“应该检索哪些历史信息”，不能复述当前请求，不能写成回答内容。\n4. 当边界不清时，轻度偏向 need_memory_recall=true。\n5. 输入里如果同时包含“最近用户原始消息”和“大段历史背景/summary/Source/日志”，必须优先依据“最近用户原始消息”判断。\n6. 对长输入，先定位最后一条或最后几条真实用户请求，再判断；不要被更早的摘要、工具日志、旧任务带偏。\n\n优先判为 true 的情况：\n- 用户在问和“之前”有关的事：日程、待办、联系人、位置、偏好、历史设置、身份设定、称呼、名字、过去说过的话。\n- 用户要求执行任务，而历史偏好/配置/上下文会影响执行：日历、提醒、飞书、GitHub、技能、配置、餐饮推荐、地点推荐、行程安排、持续任务、定时任务。\n- 用户说“继续”“再试一次”“还是那个任务”“帮我看看今天/明天/下午有什么安排”这类明显依赖上下文的请求。\n- 用户在确认助手身份、昵称、角色设定，或询问你/我叫什么、你是谁、你现在叫啥。\n\n优先判为 false 的情况：\n- 纯打招呼、纯寒暄、无个性化依赖的极简闲聊。\n- 不需要任何历史信息即可直接回答的通用事实问题。\n\nquery 写法要求：\n- 写成“要查的记忆维度”，不是“当前要做的动作”。\n- 尽量覆盖偏好、限制条件、已有配置、历史事件、联系人、时间地点等关键维度。\n- 保持简洁具体，避免空泛词，如“相关信息”“用户信息”“历史记录”。\n\n正确示例：\n{\"need_memory_recall\": true, \"query\": \"用户今天的日程安排、待办事项、日历事件和提醒设置\"}\n{\"need_memory_recall\": true, \"query\": \"用户给助手设定的昵称、身份设定和称呼偏好\"}\n{\"need_memory_recall\": false, \"query\": \"\"}\n\n错误示例：\n{\"need_memory_recall\": true, \"query\": \"今天下午有什么日程\"}  # 这是复述当前请求\n{\"need_memory_recall\": true, \"query\": \"帮我打开微博发消息\"}  # 这是动作，不是要查的记忆\n\n现在请严格输出 JSON。";
        }
        return localInferenceEngine.decideMemoryRecall(str, str2, str3, cVar);
    }

    public static /* synthetic */ Object embedAllTexts$default(LocalInferenceEngine localInferenceEngine, List list, Context context, c cVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            context = null;
        }
        return localInferenceEngine.embedAllTexts(list, context, cVar);
    }

    public static /* synthetic */ Object embedText$default(LocalInferenceEngine localInferenceEngine, String str, Context context, c cVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            context = null;
        }
        return localInferenceEngine.embedText(str, context, cVar);
    }

    public final Object checkSupport(Context context, c cVar) {
        return this.memory.checkSupport(context, cVar);
    }

    public final Object decideMemoryRecall(String str, String str2, String str3, c cVar) {
        return this.memory.decideMemoryRecall(str, str2, str3, cVar);
    }

    public final Object embedAllTexts(List<String> list, Context context, c cVar) {
        return this.bge.embedAll(list, context, cVar);
    }

    public final Object embedText(String str, Context context, c cVar) {
        return this.bge.embedText(str, context, cVar);
    }

    /* renamed from: getApplicationContext$step_memory_release, reason: from getter */
    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    public final boolean getEmbeddingEnabled() {
        return this.bge.getEmbeddingEnabled();
    }

    public final boolean getMemoryEnabled() {
        return this.memory.getMemoryEnabled();
    }

    public final LocalInferSupportState getSupportState() {
        return this.memory.getSupportState();
    }

    public final boolean isReady() {
        return this.memory.isReady();
    }

    public final Object loadAlgorithm(Context context, c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(d.f3059c, new AnonymousClass2(context, null), cVar);
    }

    public final void setApplicationContext$step_memory_release(Context context) {
        this.applicationContext = context;
    }

    public final void setEmbeddingEnabled(boolean z) {
        this.bge.setEmbeddingEnabled(z);
    }

    public final void setMemoryEnabled(boolean z) {
        this.memory.setMemoryEnabled(z);
    }
}
