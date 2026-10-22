package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import V4.AbstractC0262i;
import V4.C0257d;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.stepos.agentframework.adapter.netcore.EventListener;
import com.stepos.taskrobot.taskmemory.entity.TaskStepEntity;
import f6.AbstractC1436a;
import j9.AbstractC1607a;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1717j;
import m9.InterfaceC1733z;
import org.json.JSONArray;
import org.json.JSONObject;
import stepai.aios.guiagent.llm.LlmChatResponse;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlStepService$chat$4$1", f = "ZyqlStepService.kt", l = {211}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class ZyqlStepService$chat$4$1 extends SuspendLambda implements S7.n {
    final /* synthetic */ InterfaceC1717j $continuation;
    final /* synthetic */ byte[] $data;
    final /* synthetic */ TaskStepEntity $lastTaskStepEntity;
    final /* synthetic */ boolean $shouldTrackAsAction;
    final /* synthetic */ String $taskId;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ZyqlStepService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZyqlStepService$chat$4$1(String str, ZyqlStepService zyqlStepService, byte[] bArr, boolean z10, TaskStepEntity taskStepEntity, InterfaceC1717j interfaceC1717j, H7.c<? super ZyqlStepService$chat$4$1> cVar) {
        super(2, cVar);
        this.$taskId = str;
        this.this$0 = zyqlStepService;
        this.$data = bArr;
        this.$shouldTrackAsAction = z10;
        this.$lastTaskStepEntity = taskStepEntity;
        this.$continuation = interfaceC1717j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new ZyqlStepService$chat$4$1(this.$taskId, this.this$0, this.$data, this.$shouldTrackAsAction, this.$lastTaskStepEntity, this.$continuation, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ZyqlGuiAgentTask task;
        String traceId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final String currentTimeString = ZyqlGuiAgentTask.INSTANCE.getCurrentTimeString();
            String str = this.$taskId;
            String str2 = "";
            if (str != null && (task = SystemSdkBridge.INSTANCE.getTask(str)) != null && (traceId = task.getTraceId()) != null) {
                str2 = traceId;
            }
            ZyqlStepService zyqlStepService = this.this$0;
            byte[] bArr = this.$data;
            kotlin.jvm.internal.k.c(bArr);
            final boolean z10 = this.$shouldTrackAsAction;
            final TaskStepEntity taskStepEntity = this.$lastTaskStepEntity;
            final String str3 = this.$taskId;
            final InterfaceC1717j interfaceC1717j = this.$continuation;
            EventListener eventListener = new EventListener() { // from class: com.stepos.taskrobot.llmapi.stepfun.ZyqlStepService$chat$4$1.1
                @Override // com.stepos.agentframework.adapter.netcore.EventListener
                public /* bridge */ void onClosed(V4.l lVar) {
                    super.onClosed(lVar);
                }

                @Override // com.stepos.agentframework.adapter.netcore.EventListener
                public void onEvent(V4.l chatRequestInfo, V4.k chatReplyInfo) {
                    String str4;
                    AbstractC0262i abstractC0262i;
                    String str5;
                    Object objA;
                    kotlin.jvm.internal.k.f(chatRequestInfo, "chatRequestInfo");
                    kotlin.jvm.internal.k.f(chatReplyInfo, "chatReplyInfo");
                    Object obj2 = null;
                    GuiActionRecord guiActionRecord = z10 ? new GuiActionRecord("llm_chat", null, currentTimeString, null, null, null, null, null, null, "llm", null, 1530, null) : null;
                    try {
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        String currentTimeString2 = ZyqlGuiAgentTask.INSTANCE.getCurrentTimeString();
                        if (guiActionRecord != null) {
                            guiActionRecord.setEndTime(currentTimeString2);
                        }
                        AbstractC1436a.d("ZyqlStepService", "chat 耗时: " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + "ms", true);
                        if (z10) {
                            TaskStepEntity taskStepEntity2 = taskStepEntity;
                            if (taskStepEntity2 != null) {
                                taskStepEntity2.p = jCurrentTimeMillis2 - jCurrentTimeMillis;
                            }
                            s6.f fVarB = s6.f.b();
                            String str6 = str3;
                            TaskStepEntity taskStepEntity3 = taskStepEntity;
                            fVarB.getClass();
                            s6.f.a(str6, taskStepEntity3);
                        }
                        List list = chatReplyInfo.c;
                        if (list != null) {
                            for (Object obj3 : list) {
                                if (((AbstractC0262i) obj3) instanceof C0257d) {
                                    abstractC0262i = (AbstractC0262i) obj3;
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        abstractC0262i = null;
                        C0257d c0257d = abstractC0262i instanceof C0257d ? (C0257d) abstractC0262i : null;
                        byte[] bArr2 = c0257d != null ? c0257d.b : null;
                        if (bArr2 == null) {
                            if (guiActionRecord != null) {
                                guiActionRecord.setMessage("返回数据为空");
                            }
                            if (guiActionRecord != null) {
                                guiActionRecord.setActionResult("fail");
                            }
                            if (z10 && (str5 = str3) != null && guiActionRecord != null) {
                                GuiTaskRecordManager.INSTANCE.addActionRecord(str5, guiActionRecord);
                            }
                            interfaceC1717j.resumeWith(kotlin.b.a(new Exception("Response byteArray is null")));
                            return;
                        }
                        String str7 = new String(bArr2, AbstractC1607a.f4778a);
                        if (guiActionRecord != null) {
                            guiActionRecord.setMessage(str7);
                        }
                        AbstractC1436a.d("ZyqlStepService", "chat response by utf-8: " + str7, true);
                        String strQ = p7.b.H(bArr2).G().q();
                        JSONObject jSONObject = new JSONObject(strQ);
                        JSONArray jSONArray = jSONObject.getJSONArray("choices");
                        kotlin.jvm.internal.k.e(jSONArray, "getJSONArray(...)");
                        String string = jSONObject.getString("id");
                        kotlin.jvm.internal.k.e(string, "getString(...)");
                        String string2 = jSONArray.getJSONObject(0).getJSONObject("message").getString("content");
                        if (guiActionRecord != null) {
                            guiActionRecord.setMessage(strQ);
                        }
                        if (guiActionRecord != null) {
                            guiActionRecord.setActionResult("success");
                        }
                        if (z10) {
                            String str8 = str3;
                            if (str8 != null) {
                                GuitaskreportManager guitaskreportManager = GuitaskreportManager.INSTANCE;
                                kotlin.jvm.internal.k.c(string2);
                                guitaskreportManager.addLlmChatAction(str8, string2);
                            }
                            String str9 = str3;
                            if (str9 != null && guiActionRecord != null) {
                                GuiTaskRecordManager.INSTANCE.addActionRecord(str9, guiActionRecord);
                            }
                        }
                        try {
                            objA = JsonParser.parseString(strQ);
                        } catch (Throwable th) {
                            objA = kotlin.b.a(th);
                        }
                        if (!(objA instanceof Result.Failure)) {
                            obj2 = objA;
                        }
                        InterfaceC1717j interfaceC1717j2 = interfaceC1717j;
                        kotlin.jvm.internal.k.c(string2);
                        interfaceC1717j2.resumeWith(new LlmChatResponse(string, string2, 0L, false, null, null, null, null, (JsonElement) obj2, 252, null));
                    } catch (Exception e) {
                        AbstractC1436a.c("ZyqlStepService", "chat parse error: " + e.getMessage(), e);
                        String currentTimeString3 = ZyqlGuiAgentTask.INSTANCE.getCurrentTimeString();
                        if (guiActionRecord != null) {
                            guiActionRecord.setEndTime(currentTimeString3);
                        }
                        if (guiActionRecord != null) {
                            guiActionRecord.setActionResult("fail");
                        }
                        if (guiActionRecord != null) {
                            guiActionRecord.setMessage("chat parse error: " + e.getMessage() + ",message: " + guiActionRecord.getMessage());
                        }
                        if (z10 && (str4 = str3) != null && guiActionRecord != null) {
                            GuiTaskRecordManager.INSTANCE.addActionRecord(str4, guiActionRecord);
                        }
                        interfaceC1717j.resumeWith(kotlin.b.a(e));
                    }
                }

                @Override // com.stepos.agentframework.adapter.netcore.EventListener
                public /* bridge */ void onFailure(V4.l lVar, Integer num, String str4) {
                    super.onFailure(lVar, num, str4);
                }

                @Override // com.stepos.agentframework.adapter.netcore.EventListener
                public /* bridge */ void onHandle(Object obj2) {
                    super.onHandle(obj2);
                }

                @Override // com.stepos.agentframework.adapter.netcore.EventListener
                public /* bridge */ void onOpen(V4.l lVar) {
                    super.onOpen(lVar);
                }
            };
            this.L$0 = null;
            this.L$1 = null;
            this.J$0 = jCurrentTimeMillis;
            this.label = 1;
            if (zyqlStepService.chat(bArr, str2, eventListener, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((ZyqlStepService$chat$4$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
