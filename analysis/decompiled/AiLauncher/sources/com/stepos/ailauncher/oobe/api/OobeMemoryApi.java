package com.stepos.ailauncher.oobe.api;

import Ua.C1056g;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.C1173v;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import com.stepos.ailauncher.foundation.account.f;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import g9.h;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.AbstractC5529B;
import tb.AbstractC5531D;
import tb.x;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/oobe/api/OobeMemoryApi;", "", "<init>", "()V", "", "getAuthToken", "()Ljava/lang/String;", "tabType", "tabTypeToCustomMemoryName", "(Ljava/lang/String;)Ljava/lang/String;", "", "Lcom/stepos/ailauncher/oobe/api/OobeMemoryApi$MemoryEntry;", "entries", "addMemory", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "BASE_URL_KEY", "Ltb/x;", "JSON_MEDIA_TYPE", "Ltb/x;", "TAB_ABOUT_ME", "TAB_COMMUNICATION", "TAB_MEMO", "MemoryEntry", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OobeMemoryApi {
    private static final String BASE_URL_KEY = "securityAuditing";
    public static final OobeMemoryApi INSTANCE = new OobeMemoryApi();
    private static final x JSON_MEDIA_TYPE = x.INSTANCE.a("application/json; charset=utf-8");
    public static final String TAB_ABOUT_ME = "about_me";
    public static final String TAB_COMMUNICATION = "communication";
    public static final String TAB_MEMO = "memo";
    private static final String TAG = "AILauncher-OobeMemory";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/oobe/api/OobeMemoryApi$MemoryEntry;", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "memoryName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getMemoryName", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MemoryEntry {
        private final String content;
        private final String memoryName;

        public MemoryEntry(String content, String memoryName) {
            p.i(content, "content");
            p.i(memoryName, "memoryName");
            this.content = content;
            this.memoryName = memoryName;
        }

        public static /* synthetic */ MemoryEntry copy$default(MemoryEntry memoryEntry, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = memoryEntry.content;
            }
            if ((i10 & 2) != 0) {
                str2 = memoryEntry.memoryName;
            }
            return memoryEntry.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMemoryName() {
            return this.memoryName;
        }

        public final MemoryEntry copy(String content, String memoryName) {
            p.i(content, "content");
            p.i(memoryName, "memoryName");
            return new MemoryEntry(content, memoryName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemoryEntry)) {
                return false;
            }
            MemoryEntry memoryEntry = (MemoryEntry) other;
            return p.d(this.content, memoryEntry.content) && p.d(this.memoryName, memoryEntry.memoryName);
        }

        public final String getContent() {
            return this.content;
        }

        public final String getMemoryName() {
            return this.memoryName;
        }

        public int hashCode() {
            return (this.content.hashCode() * 31) + this.memoryName.hashCode();
        }

        public String toString() {
            return "MemoryEntry(content=" + this.content + ", memoryName=" + this.memoryName + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0004\u001a\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "", "", "kotlin.jvm.PlatformType", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.oobe.api.OobeMemoryApi$addMemory$2", f = "OobeMemoryApi.kt", l = {99}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.oobe.api.OobeMemoryApi$addMemory$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super List<? extends String>>, Object> {
        final /* synthetic */ List<MemoryEntry> $entries;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<MemoryEntry> list, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$entries = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$entries, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super List<String>> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objIngestMemory;
            Object objG = C4063a.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    if (this.$entries.isEmpty()) {
                        C4148a.d(OobeMemoryApi.TAG, "addMemory skip: empty entries", false, 4, null);
                        return C1173v.m();
                    }
                    OobeMemoryIngestService oobeMemoryIngestService = (OobeMemoryIngestService) HttpManager.INSTANCE.create(OobeMemoryIngestService.class, "securityAuditing");
                    String authToken = OobeMemoryApi.INSTANCE.getAuthToken();
                    JSONObject jSONObject = new JSONObject();
                    List<MemoryEntry> list = this.$entries;
                    JSONArray jSONArray = new JSONArray();
                    for (MemoryEntry memoryEntry : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("memory_name", memoryEntry.getMemoryName());
                        jSONObject2.put("action", "add");
                        jSONObject2.put(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, memoryEntry.getContent());
                        jSONArray.put(jSONObject2);
                    }
                    t tVar = t.f7040a;
                    jSONObject.put("ingest_memories", jSONArray);
                    String string = jSONObject.toString();
                    p.h(string, "toString(...)");
                    y yVar = y.f34840a;
                    String str = String.format("addMemory params: size=%d, body=%s , auth=%s", Arrays.copyOf(new Object[]{C4109a.f(this.$entries.size()), string, authToken}, 3));
                    p.h(str, "format(...)");
                    C4148a.d(OobeMemoryApi.TAG, str, false, 4, null);
                    AbstractC5529B abstractC5529BB = AbstractC5529B.INSTANCE.b(string, OobeMemoryApi.JSON_MEDIA_TYPE);
                    this.L$0 = h.a(oobeMemoryIngestService);
                    this.L$1 = h.a(authToken);
                    this.L$2 = h.a(string);
                    this.L$3 = h.a(abstractC5529BB);
                    this.label = 1;
                    objIngestMemory = oobeMemoryIngestService.ingestMemory(authToken, abstractC5529BB, this);
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
                y yVar2 = y.f34840a;
                String str2 = String.format("addMemory(ingest) response: status=%s, body=%s", Arrays.copyOf(new Object[]{jSONObject3.optString("status"), strA}, 2));
                p.h(str2, "format(...)");
                C4148a.d(OobeMemoryApi.TAG, str2, false, 4, null);
                String strOptString = jSONObject3.optString("status");
                if (!p.d(strOptString, "success") && !p.d(strOptString, "partial_success")) {
                    String str3 = String.format("addMemory failed: %s", Arrays.copyOf(new Object[]{strA}, 1));
                    p.h(str3, "format(...)");
                    C4148a.u(OobeMemoryApi.TAG, str3, false, 4, null);
                    return null;
                }
                JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray("single_memory_ids");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                    int length = jSONArrayOptJSONArray.length();
                    ArrayList arrayList = new ArrayList(length);
                    for (int i11 = 0; i11 < length; i11++) {
                        arrayList.add(jSONArrayOptJSONArray.optString(i11));
                    }
                    return arrayList;
                }
                return C1173v.m();
            } catch (CancellationException e10) {
                throw e10;
            } catch (Exception e11) {
                C4148a.g(OobeMemoryApi.TAG, "addMemory exception", e11, false, 8, null);
                return null;
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends String>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super List<String>>) interfaceC4014c);
        }
    }

    private OobeMemoryApi() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAuthToken() {
        String token;
        AccountInfo accountInfoL = f.INSTANCE.l();
        if (accountInfoL == null || (token = accountInfoL.getToken()) == null) {
            token = "";
        }
        if (token.length() <= 0) {
            return "";
        }
        return "Bearer " + token;
    }

    public final Object addMemory(List<MemoryEntry> list, InterfaceC4014c<? super List<String>> interfaceC4014c) {
        return C1056g.j(Y.b(), new AnonymousClass2(list, null), interfaceC4014c);
    }

    public final String tabTypeToCustomMemoryName(String tabType) {
        p.i(tabType, "tabType");
        int iHashCode = tabType.hashCode();
        if (iHashCode == -1035284522) {
            return !tabType.equals("communication") ? "user_custom" : "agent_语气";
        }
        if (iHashCode != 3347770) {
            return (iHashCode == 1619363722 && tabType.equals("about_me")) ? "agent_称呼与人称" : "user_custom";
        }
        tabType.equals("memo");
        return "user_custom";
    }
}
