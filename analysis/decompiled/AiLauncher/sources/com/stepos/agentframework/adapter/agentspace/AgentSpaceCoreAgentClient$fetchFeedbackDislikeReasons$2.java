package com.stepos.agentframework.adapter.agentspace;

import La.H;
import Ua.M;
import Y8.t;
import Z8.C1173v;
import Z8.r;
import android.content.Context;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.gson.Gson;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import tb.AbstractC5529B;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import tb.z;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentspace.AgentSpaceCoreAgentClient$fetchFeedbackDislikeReasons$2", f = "AgentSpaceCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSpaceCoreAgentClient$fetchFeedbackDislikeReasons$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends String>>, Object> {
    int label;
    final /* synthetic */ AgentSpaceCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSpaceCoreAgentClient$fetchFeedbackDislikeReasons$2(AgentSpaceCoreAgentClient agentSpaceCoreAgentClient, InterfaceC4014c<? super AgentSpaceCoreAgentClient$fetchFeedbackDislikeReasons$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSpaceCoreAgentClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSpaceCoreAgentClient$fetchFeedbackDislikeReasons$2(this.this$0, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<String>> interfaceC4014c) {
        return ((AgentSpaceCoreAgentClient$fetchFeedbackDislikeReasons$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AgentSpaceConfigQueryResponse agentSpaceConfigQueryResponse;
        String value;
        List listM;
        List listM2;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Context context = this.this$0.appContext;
        if (context == null) {
            return C1173v.m();
        }
        try {
            String str = H.G1(C4.a.INSTANCE.a(context).a(), JsonPointer.SEPARATOR) + "/dictionary/api/v1/get/key";
            Gson gson = this.this$0.gson;
            String packageName = context.getPackageName();
            kotlin.jvm.internal.p.h(packageName, "getPackageName(...)");
            String json = gson.toJson(new AgentSpaceConfigQueryRequest(packageName, e.INSTANCE.b(context), null, 4, null));
            AbstractC5529B.Companion companion = AbstractC5529B.INSTANCE;
            kotlin.jvm.internal.p.f(json);
            C5528A.a aVarO = new C5528A.a().t(str).o(companion.b(json, AgentSpaceCoreAgentClient.JSON_MEDIA));
            String str2 = this.this$0.bearerToken;
            if (str2 != null) {
                aVarO.l("Authorization", "Bearer " + str2);
            }
            C4148a.j("AgentSpaceCoreAgentClient", "fetchFeedbackDislikeReasons request: url=" + str + ", authorization=" + ((str2 == null || H.x0(str2)) ? "null" : "Bearer ***") + ", body=" + json, true);
            z zVar = this.this$0.okHttpClient;
            if (zVar == null) {
                kotlin.jvm.internal.p.A("okHttpClient");
                zVar = null;
            }
            C5530C c5530cExecute = zVar.a(aVarO.b()).execute();
            AgentSpaceCoreAgentClient agentSpaceCoreAgentClient = this.this$0;
            try {
                AbstractC5531D body = c5530cExecute.getBody();
                String strA = body != null ? body.A() : null;
                if (strA == null) {
                    strA = "";
                }
                C4148a.j("AgentSpaceCoreAgentClient", "fetchFeedbackDislikeReasons response: code=" + c5530cExecute.getCode() + ", body=" + strA, true);
                if (!c5530cExecute.getIsSuccessful()) {
                    C4148a.h("AgentSpaceCoreAgentClient", "fetchFeedbackDislikeReasons HTTP " + c5530cExecute.getCode(), false, 4, null);
                    listM2 = C1173v.m();
                } else if (H.x0(strA) || (agentSpaceConfigQueryResponse = (AgentSpaceConfigQueryResponse) agentSpaceCoreAgentClient.gson.fromJson(strA, AgentSpaceConfigQueryResponse.class)) == null) {
                    listM2 = C1173v.m();
                } else if (agentSpaceConfigQueryResponse.getCode() != 200) {
                    C4148a.h("AgentSpaceCoreAgentClient", "fetchFeedbackDislikeReasons code=" + agentSpaceConfigQueryResponse.getCode() + " msg=" + agentSpaceConfigQueryResponse.getMsg(), false, 4, null);
                    listM2 = C1173v.m();
                } else {
                    AgentSpaceConfigItem data = agentSpaceConfigQueryResponse.getData();
                    if (data == null) {
                        listM2 = C1173v.m();
                    } else {
                        if (!kotlin.jvm.internal.p.d(data.getKey(), "feedback_options")) {
                            data = null;
                        }
                        if (data != null && (value = data.getValue()) != null) {
                            try {
                                Object objFromJson = agentSpaceCoreAgentClient.gson.fromJson(value, (Class<Object>) String[].class);
                                kotlin.jvm.internal.p.h(objFromJson, "fromJson(...)");
                                listM = r.T0((Object[]) objFromJson);
                            } catch (Exception e10) {
                                C4148a.g("AgentSpaceCoreAgentClient", "parse value: " + e10.getMessage(), e10, false, 8, null);
                                listM = C1173v.m();
                            }
                            l9.b.a(c5530cExecute, null);
                            return listM;
                        }
                        listM2 = C1173v.m();
                    }
                }
                l9.b.a(c5530cExecute, null);
                return listM2;
            } finally {
            }
        } catch (Exception e11) {
            C4148a.g("AgentSpaceCoreAgentClient", "fetchFeedbackDislikeReasons: " + e11.getMessage(), e11, false, 8, null);
            return C1173v.m();
        }
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<String>>) interfaceC4014c);
    }
}
