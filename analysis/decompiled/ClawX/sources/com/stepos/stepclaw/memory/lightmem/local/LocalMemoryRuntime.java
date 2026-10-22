package com.stepos.stepclaw.memory.lightmem.local;

import a6.f0;
import a6.i0;
import a6.r0;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.gateway.d;
import com.stepos.stepclaw.memory.lightmem.local.LocalInferSupportState;
import com.stepos.stepclaw.memory.lightmem.remote.MessageItem;
import d3.b;
import h5.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import p5.a;
import v2.c;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u001e\u0010\u0017\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b%\u0010\"¨\u0006'"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/local/LocalMemoryRuntime;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/Function0;", "Landroid/content/Context;", "hostContext", "<init>", "(Lp5/a;)V", "context", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferSupportState;", "checkSupport", "(Landroid/content/Context;Lf5/c;)Ljava/lang/Object;", "Lv2/c;", "Lcom/stepos/aiservice/algorithm/memory/IMemory;", "reloadMemoryAlgorithm", "()Lv2/c;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "userQuery", "dialogHistory", "systemPrompt", "Lcom/stepos/stepclaw/memory/lightmem/local/MemoryRecallDecision;", "decideMemoryRecall", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "Lp5/a;", "memoryAlgorithm", "Lv2/c;", "value", "supportState", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferSupportState;", "getSupportState", "()Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferSupportState;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "memoryEnabled", "Z", "getMemoryEnabled", "()Z", "setMemoryEnabled", "(Z)V", "isReady", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LocalMemoryRuntime {
    private static final String BUNDLE_KEY_SYSTEM_PROMPT = "system_prompt";
    public static final String DEFAULT_SYSTEM_PROMPT = "你是记忆检索决策器。\n\n输入是用户最近的一段对话消息，主要依据最新一条或最后几条用户消息判断：\n回复当前请求前，是否需要先检索历史记忆。\n\n你的任务不是回答用户问题，而是输出一个 JSON 决策结果：\n{\"need_memory_recall\": <bool>, \"query\": <str>}\n\n规则：\n1. 只输出 JSON，不要输出解释、分析、markdown、代码块。\n2. 若 need_memory_recall=false，query 必须是空字符串 \"\"。\n3. 若 need_memory_recall=true，query 必须描述“应该检索哪些历史信息”，不能复述当前请求，不能写成回答内容。\n4. 当边界不清时，轻度偏向 need_memory_recall=true。\n5. 输入里如果同时包含“最近用户原始消息”和“大段历史背景/summary/Source/日志”，必须优先依据“最近用户原始消息”判断。\n6. 对长输入，先定位最后一条或最后几条真实用户请求，再判断；不要被更早的摘要、工具日志、旧任务带偏。\n\n优先判为 true 的情况：\n- 用户在问和“之前”有关的事：日程、待办、联系人、位置、偏好、历史设置、身份设定、称呼、名字、过去说过的话。\n- 用户要求执行任务，而历史偏好/配置/上下文会影响执行：日历、提醒、飞书、GitHub、技能、配置、餐饮推荐、地点推荐、行程安排、持续任务、定时任务。\n- 用户说“继续”“再试一次”“还是那个任务”“帮我看看今天/明天/下午有什么安排”这类明显依赖上下文的请求。\n- 用户在确认助手身份、昵称、角色设定，或询问你/我叫什么、你是谁、你现在叫啥。\n\n优先判为 false 的情况：\n- 纯打招呼、纯寒暄、无个性化依赖的极简闲聊。\n- 不需要任何历史信息即可直接回答的通用事实问题。\n\nquery 写法要求：\n- 写成“要查的记忆维度”，不是“当前要做的动作”。\n- 尽量覆盖偏好、限制条件、已有配置、历史事件、联系人、时间地点等关键维度。\n- 保持简洁具体，避免空泛词，如“相关信息”“用户信息”“历史记录”。\n\n正确示例：\n{\"need_memory_recall\": true, \"query\": \"用户今天的日程安排、待办事项、日历事件和提醒设置\"}\n{\"need_memory_recall\": true, \"query\": \"用户给助手设定的昵称、身份设定和称呼偏好\"}\n{\"need_memory_recall\": false, \"query\": \"\"}\n\n错误示例：\n{\"need_memory_recall\": true, \"query\": \"今天下午有什么日程\"}  # 这是复述当前请求\n{\"need_memory_recall\": true, \"query\": \"帮我打开微博发消息\"}  # 这是动作，不是要查的记忆\n\n现在请严格输出 JSON。";
    private final a hostContext;
    private c memoryAlgorithm;
    private volatile boolean memoryEnabled;
    private volatile LocalInferSupportState supportState;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Json json = JsonKt.Json$default(null, new d(7), 1, null);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\fJ\u0014\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/local/LocalMemoryRuntime$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "json", "Lkotlinx/serialization/json/Json;", "DEFAULT_SYSTEM_PROMPT", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "BUNDLE_KEY_SYSTEM_PROMPT", "parseThinkBlock", "Lcom/stepos/stepclaw/memory/lightmem/local/ThinkParseResult;", "raw", "parseThinkBlock$step_memory_release", "buildDialogHistory", "messages", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final String buildDialogHistory(List<MessageItem> messages) {
            p.e(messages, "messages");
            return LocalMemoryRuntime.json.encodeToString(BuiltinSerializersKt.ListSerializer(MessageItem.INSTANCE.serializer()), messages);
        }

        public final ThinkParseResult parseThinkBlock$step_memory_release(String raw) {
            p.e(raw, "raw");
            int iR1 = n.r1(raw, "<think>", 0, false, 6);
            int iR12 = n.r1(raw, "</think>", 0, false, 6);
            if (iR1 < 0 || iR1 >= iR12) {
                return new ThinkParseResult(null, n.T1(raw).toString());
            }
            String strSubstring = raw.substring(iR1 + 7, iR12);
            p.d(strSubstring, "substring(...)");
            String string = n.T1(strSubstring).toString();
            String strSubstring2 = raw.substring(iR12 + 8);
            p.d(strSubstring2, "substring(...)");
            return new ThinkParseResult(string.length() != 0 ? string : null, n.T1(strSubstring2).toString());
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferSupportState;", "<anonymous>", "(La6/f0;)Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferSupportState;"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.memory.lightmem.local.LocalMemoryRuntime$checkSupport$3", f = "LocalMemoryRuntime.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.local.LocalMemoryRuntime$checkSupport$3, reason: invalid class name */
    public static final class AnonymousClass3 extends h5.i implements p5.p {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ LocalMemoryRuntime this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context, LocalMemoryRuntime localMemoryRuntime, f5.c cVar) {
            super(2, cVar);
            this.$context = context;
            this.this$0 = localMemoryRuntime;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass3(this.$context, this.this$0, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass3) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws RemoteException {
            int i8;
            e3.a aVarI;
            Bundle bundleCall;
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            LocalInferSupportState.Companion companion = LocalInferSupportState.INSTANCE;
            b bVar = e3.e.f2364c;
            Context context = this.$context;
            String str = bVar.f1793a;
            try {
                aVarI = e3.d.i(context);
                try {
                    System.currentTimeMillis();
                    bundleCall = aVarI.f2353a.call("checkResources", str, null);
                } finally {
                }
            } catch (Exception e9) {
                Log.d("AlgorithmClient", "checkResourcesImpl: " + e9.getMessage());
                e3.d dVar = e3.d.f2358j;
                synchronized (dVar) {
                    b3.c cVar = (b3.c) dVar.c(context, dVar.f2359g);
                    if (cVar == null) {
                        throw new RemoteException("checkResources failed, engine is null");
                    }
                    b3.a aVar2 = (b3.a) cVar;
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.meizu.aiservice.api.service.IAIEngine");
                        parcelObtain.writeString(str);
                        aVar2.f846a.transact(11, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        int i9 = parcelObtain2.readInt();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        i8 = i9;
                    } catch (Throwable th) {
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                }
            }
            if (bundleCall == null) {
                throw new RemoteException("result null");
            }
            i8 = bundleCall.getInt("int");
            aVarI.close();
            LocalInferSupportState localInferSupportStateFromCode = companion.fromCode(i8);
            this.this$0.supportState = localInferSupportStateFromCode;
            return localInferSupportStateFromCode;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.memory.lightmem.local.LocalMemoryRuntime", f = "LocalMemoryRuntime.kt", l = {79, 214}, m = "decideMemoryRecall", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.local.LocalMemoryRuntime$decideMemoryRecall$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocalMemoryRuntime.this.decideMemoryRecall(null, null, null, this);
        }
    }

    public LocalMemoryRuntime(a hostContext) {
        p.e(hostContext, "hostContext");
        this.hostContext = hostContext;
        this.memoryEnabled = true;
    }

    public static /* synthetic */ Object decideMemoryRecall$default(LocalMemoryRuntime localMemoryRuntime, String str, String str2, String str3, f5.c cVar, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str3 = "你是记忆检索决策器。\n\n输入是用户最近的一段对话消息，主要依据最新一条或最后几条用户消息判断：\n回复当前请求前，是否需要先检索历史记忆。\n\n你的任务不是回答用户问题，而是输出一个 JSON 决策结果：\n{\"need_memory_recall\": <bool>, \"query\": <str>}\n\n规则：\n1. 只输出 JSON，不要输出解释、分析、markdown、代码块。\n2. 若 need_memory_recall=false，query 必须是空字符串 \"\"。\n3. 若 need_memory_recall=true，query 必须描述“应该检索哪些历史信息”，不能复述当前请求，不能写成回答内容。\n4. 当边界不清时，轻度偏向 need_memory_recall=true。\n5. 输入里如果同时包含“最近用户原始消息”和“大段历史背景/summary/Source/日志”，必须优先依据“最近用户原始消息”判断。\n6. 对长输入，先定位最后一条或最后几条真实用户请求，再判断；不要被更早的摘要、工具日志、旧任务带偏。\n\n优先判为 true 的情况：\n- 用户在问和“之前”有关的事：日程、待办、联系人、位置、偏好、历史设置、身份设定、称呼、名字、过去说过的话。\n- 用户要求执行任务，而历史偏好/配置/上下文会影响执行：日历、提醒、飞书、GitHub、技能、配置、餐饮推荐、地点推荐、行程安排、持续任务、定时任务。\n- 用户说“继续”“再试一次”“还是那个任务”“帮我看看今天/明天/下午有什么安排”这类明显依赖上下文的请求。\n- 用户在确认助手身份、昵称、角色设定，或询问你/我叫什么、你是谁、你现在叫啥。\n\n优先判为 false 的情况：\n- 纯打招呼、纯寒暄、无个性化依赖的极简闲聊。\n- 不需要任何历史信息即可直接回答的通用事实问题。\n\nquery 写法要求：\n- 写成“要查的记忆维度”，不是“当前要做的动作”。\n- 尽量覆盖偏好、限制条件、已有配置、历史事件、联系人、时间地点等关键维度。\n- 保持简洁具体，避免空泛词，如“相关信息”“用户信息”“历史记录”。\n\n正确示例：\n{\"need_memory_recall\": true, \"query\": \"用户今天的日程安排、待办事项、日历事件和提醒设置\"}\n{\"need_memory_recall\": true, \"query\": \"用户给助手设定的昵称、身份设定和称呼偏好\"}\n{\"need_memory_recall\": false, \"query\": \"\"}\n\n错误示例：\n{\"need_memory_recall\": true, \"query\": \"今天下午有什么日程\"}  # 这是复述当前请求\n{\"need_memory_recall\": true, \"query\": \"帮我打开微博发消息\"}  # 这是动作，不是要查的记忆\n\n现在请严格输出 JSON。";
        }
        return localMemoryRuntime.decideMemoryRecall(str, str2, str3, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setEncodeDefaults(false);
        return a0.f883a;
    }

    public final Object checkSupport(Context context, f5.c cVar) {
        LocalInferSupportState localInferSupportState = this.supportState;
        if (localInferSupportState != null) {
            return localInferSupportState;
        }
        h6.e eVar = r0.f210a;
        return i0.A(h6.d.f3059c, new AnonymousClass3(context, this, null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object decideMemoryRecall(final java.lang.String r10, java.lang.String r11, java.lang.String r12, f5.c r13) throws com.stepos.stepclaw.memory.lightmem.local.LocalInferenceException, a6.o0 {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.local.LocalMemoryRuntime.decideMemoryRecall(java.lang.String, java.lang.String, java.lang.String, f5.c):java.lang.Object");
    }

    public final boolean getMemoryEnabled() {
        return this.memoryEnabled;
    }

    public final LocalInferSupportState getSupportState() {
        return this.supportState;
    }

    public final boolean isReady() {
        LocalInferSupportState localInferSupportState = this.supportState;
        return localInferSupportState != null && localInferSupportState.isReady();
    }

    public final c reloadMemoryAlgorithm() {
        Context context = (Context) this.hostContext.invoke();
        if (context == null) {
            return null;
        }
        b bVar = e3.e.f2364c;
        Bundle bundle = new Bundle();
        bundle.putString("targetModel", "qwen3-0p6-stepinfer");
        c cVar = (c) bVar.d(context, bundle);
        this.memoryAlgorithm = cVar;
        return cVar;
    }

    public final void setMemoryEnabled(boolean z) {
        this.memoryEnabled = z;
    }
}
