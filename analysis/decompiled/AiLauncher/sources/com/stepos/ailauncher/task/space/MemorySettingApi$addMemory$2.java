package com.stepos.ailauncher.task.space;

import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.AbstractC5529B;
import tb.AbstractC5531D;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.MemorySettingApi$addMemory$2", f = "MemorySettingApi.kt", l = {521}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class MemorySettingApi$addMemory$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super String>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $memoryName;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemorySettingApi$addMemory$2(String str, String str2, InterfaceC4014c<? super MemorySettingApi$addMemory$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$memoryName = str;
        this.$content = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new MemorySettingApi$addMemory$2(this.$memoryName, this.$content, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super String> interfaceC4014c) {
        return ((MemorySettingApi$addMemory$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objIngestMemory;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                InterfaceC3667s0 interfaceC3667s0 = (InterfaceC3667s0) HttpManager.INSTANCE.create(InterfaceC3667s0.class, ContentSafetyApi.BASE_URL_KEY);
                String strH = MemorySettingApi.INSTANCE.H();
                AbstractC5529B.Companion companion = AbstractC5529B.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                String str = this.$memoryName;
                String str2 = this.$content;
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("memory_name", str);
                jSONObject2.put("action", "add");
                jSONObject2.put(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, str2);
                jSONArray.put(jSONObject2);
                Y8.t tVar = Y8.t.f7040a;
                jSONObject.put("ingest_memories", jSONArray);
                String string = jSONObject.toString();
                kotlin.jvm.internal.p.h(string, "toString(...)");
                AbstractC5529B abstractC5529BB = companion.b(string, MemorySettingApi.JSON_MEDIA_TYPE);
                this.L$0 = g9.h.a(interfaceC3667s0);
                this.L$1 = g9.h.a(strH);
                this.L$2 = g9.h.a(abstractC5529BB);
                this.label = 1;
                objIngestMemory = interfaceC3667s0.ingestMemory(strH, abstractC5529BB, this);
                if (objIngestMemory == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                objIngestMemory = obj;
            }
            String strA = ((AbstractC5531D) objIngestMemory).A();
            JSONObject jSONObject3 = new JSONObject(strA);
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str3 = String.format("addMemory(ingest) response: status=%s", Arrays.copyOf(new Object[]{jSONObject3.optString("status")}, 1));
            kotlin.jvm.internal.p.h(str3, "format(...)");
            C4148a.d("AILauncher-MemorySetting", str3, false, 4, null);
            String strOptString = jSONObject3.optString("status");
            if (!kotlin.jvm.internal.p.d(strOptString, "success") && !kotlin.jvm.internal.p.d(strOptString, "partial_success")) {
                String str4 = String.format("addMemory failed: %s", Arrays.copyOf(new Object[]{strA}, 1));
                kotlin.jvm.internal.p.h(str4, "format(...)");
                C4148a.u("AILauncher-MemorySetting", str4, false, 4, null);
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray("single_memory_ids");
            String strOptString2 = (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) ? "" : jSONArrayOptJSONArray.optString(0);
            MemorySettingApi memorySettingApi = MemorySettingApi.INSTANCE;
            String str5 = this.$memoryName;
            kotlin.jvm.internal.p.f(strOptString2);
            memorySettingApi.t(str5, strOptString2, this.$content);
            return strOptString2;
        } catch (Exception e10) {
            C4148a.g("AILauncher-MemorySetting", "addMemory exception", e10, false, 8, null);
            return null;
        }
    }
}
