package com.stepos.taskrobot.llmapi.stepfun.trace;

import C7.r;
import J7.c;
import S7.n;
import android.util.Log;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.AgentCache;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import f6.AbstractC1436a;
import j9.m;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.builders.MapBuilder;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;
import stepai.aios.guiagent.app.PathDataKt;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

@c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2$postTaskStart$2", f = "GuiAgentTraceManagerV2.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lkotlin/Result;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class GuiAgentTraceManagerV2$postTaskStart$2 extends SuspendLambda implements n {
    final /* synthetic */ String $appName;
    final /* synthetic */ Map<String, Object> $metadata;
    final /* synthetic */ String $subSessionId;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $taskName;
    final /* synthetic */ String $traceId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiAgentTraceManagerV2$postTaskStart$2(Map<String, ? extends Object> map, String str, String str2, String str3, String str4, String str5, H7.c<? super GuiAgentTraceManagerV2$postTaskStart$2> cVar) {
        super(2, cVar);
        this.$metadata = map;
        this.$taskId = str;
        this.$traceId = str2;
        this.$appName = str3;
        this.$taskName = str4;
        this.$subSessionId = str5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        GuiAgentTraceManagerV2$postTaskStart$2 guiAgentTraceManagerV2$postTaskStart$2 = new GuiAgentTraceManagerV2$postTaskStart$2(this.$metadata, this.$taskId, this.$traceId, this.$appName, this.$taskName, this.$subSessionId, cVar);
        guiAgentTraceManagerV2$postTaskStart$2.L$0 = obj;
        return guiAgentTraceManagerV2$postTaskStart$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        b.b(obj);
        Map<String, Object> map = this.$metadata;
        String str = this.$taskId;
        String traceId = this.$traceId;
        String str2 = this.$appName;
        String str3 = this.$taskName;
        String str4 = this.$subSessionId;
        try {
            String stringParam = PathDataKt.getStringParam(map, GuiAgentConfigKt.META_KEY_TOOL_CALL_ID);
            if (stringParam == null) {
                stringParam = "";
            }
            Log.d("RobotTraceV2", "postTaskStart uplink,taskId=" + str + ",traceId=" + traceId + ",toolCallId:" + stringParam);
            String json = GuiAgentTraceManagerV2.gson.toJson(kotlin.collections.a.R(new Pair("appName", str2), new Pair(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, str3)));
            GuiAgentTraceManagerV2 guiAgentTraceManagerV2 = GuiAgentTraceManagerV2.INSTANCE;
            k.c(json);
            Map commonFields = GuiAgentTraceManagerV2.buildCommonFields$stepfun_release$default(guiAgentTraceManagerV2, traceId, AgentCache.AGENT_CACHE_MSG_TYPE_UP_LINK, json, null, str4, 8, null);
            String str5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
            MapBuilder mapBuilder = new MapBuilder();
            if (!m.s0(str)) {
                mapBuilder.put("task_id", str);
            }
            mapBuilder.put(GuiAgentConfigKt.META_KEY_TOOL_CALL_ID, stringParam);
            mapBuilder.put("title", str3);
            k.c(str5);
            mapBuilder.put("createdAt", str5);
            mapBuilder.put("metadata", GuiAgentTraceManagerV2Kt.buildLocalAppMetadata());
            MapBuilder mapBuilderB = mapBuilder.b();
            AbstractC1436a.a("RobotTraceV2", "[commonFields]: " + GuiAgentTraceManagerV2.gson.toJson(commonFields) + " ", true);
            k.f(traceId, "traceId");
            k.f(commonFields, "commonFields");
            AbstractC1436a.d("RobotTraceV2", "[" + str + "] report event done: msg_type=uplink, traceId=" + traceId + ", success=" + AgentCacheSdk.reportEvent$default(AgentCacheSdk.INSTANCE, traceId, "gui_agent_call", commonFields, mapBuilderB, null, null, 200, 48, null), true);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA == null) {
            return new Result(objA);
        }
        Log.e("RobotTraceV2", "postTaskStart failed", thA);
        throw thA;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Result<r>> cVar) {
        return ((GuiAgentTraceManagerV2$postTaskStart$2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
