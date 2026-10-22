package com.obric.agent;

import android.app.Application;
import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.RCSearchParams;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: RecorderCardHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    private static final String TAG = "RecorderCardHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f16080a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f16081b = null;

    /* JADX INFO: compiled from: RecorderCardHelper.kt */
    /* synthetic */ class a extends d.h.b.l implements d.h.a.a<List<? extends RecordingEntity>> {
        a(Object r8) {
            super(0, r8, v.class, "fetchLatestRecordingEntities", "fetchLatestRecordingEntities()Ljava/util/List;", 0);
        }

        public final List<RecordingEntity> a() {
            return ((v) ZeusTransformUtils.preCheckCast(this.receiver, v.class, "com.obric.aiagent.plugin")).a();
        }

        @Override // d.h.a.a
        public /* synthetic */ List<? extends RecordingEntity> invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: RecorderCardHelper.kt */
    /* synthetic */ class b extends d.h.b.l implements d.h.a.b<String, JsonElement> {
        b(Object r8) {
            super(1, r8, JsonObject.class, MonitorConstants.CONNECT_TYPE_GET, "get(Ljava/lang/String;)Lcom/google/gson/JsonElement;", 0);
        }

        public final JsonElement a(String r3) {
            return ((JsonObject) ZeusTransformUtils.preCheckCast(this.receiver, JsonObject.class, "com.obric.aiagent.plugin")).get(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ JsonElement invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ JsonElement lambda$Dt9Tn955LoyCMVfYFCPrtVKhOAg(JsonElement r0) {
        return a(r0);
    }

    public static /* synthetic */ d.n.j lambda$Fyn8CbFDlepCKXv0PaKgpv6lmEs(JsonElement r0) {
        return b(r0);
    }

    public static /* synthetic */ RecordingEntity lambda$O6LGWhRDIVggCsVEI1hp3IMdK_c(v r0, JsonElement r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ d.r lambda$Tz80o_7Q9iQEiDjcYZzceyHtRAo(RecordingEntity r0) {
        return a(r0);
    }

    private v() {
    }

    static {
        f16080a = new v();
        f16081b = ax.a(new String[]{"start", "pause", "resume", "stop"});
    }

    public final String a(String r4) {
        if (r4 == null) goto L21;
        int r3 = r4.hashCode();
        if (r3 == (-995321554)) goto L18;
        if (r3 == 3227604) goto L14;
        if (r3 != 993558001) goto L21;
        if (r4.equals("recording") == false) goto L21;
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_recorder_status_recording, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_recorder_status_recording"));
    L14:
        if (r4.equals("idle") == false) goto L21;
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_recorder_status_finished, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_recorder_status_finished"));
    L18:
        if (r4.equals("paused") == false) goto L21;
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_recorder_status_paused, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_recorder_status_paused"));
    L21:
        return null;
    }

    public final List<RecordingEntity> a() {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L38
        r1.put("name", "assistantQuery");     // Catch: Exception -> L38
        boolean r3 = true;
        r1.put("recordingAudios", true);     // Catch: Exception -> L38
        RCSearchParams r2 = new RCSearchParams(r1.toString());     // Catch: Exception -> L38
        long r4 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;     // Catch: Exception -> L38
        ILogDepend.Companion.i(TAG, "fetchLatestRecordingEntities, invoke RCSearch, reqId=" + r4);     // Catch: Exception -> L38
        List<RecordingEntity> r5 = null;
        IntentResult r6 = (IntentResult) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.a.f33793a.a(r2, new DispatchContext((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Long.valueOf(r4), null)).getData(), IntentResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        if (r6 == null) goto L17;
        Object r7 = r6.getEntity();     // Catch: Exception -> L38
        if ((r7 instanceof Object[]) == false) goto L8;
        Object[] r8 = (Object[]) ZeusTransformUtils.preCheckCast(r7, Object[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
    L9:
        if (r8 == null) goto L17;
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        int r10 = r8.length;     // Catch: Exception -> L38
        int r11 = 0;
    L11:
        if (r11 >= r10) goto L16;
        Object r12 = r8[r11];     // Catch: Exception -> L38
        if (ZeusTransformUtils.instanceOf(r12, RecordingEntity.class) == false) goto L15;
        r9.add(r12);     // Catch: Exception -> L38
    L15:
        r11 = r11 + 1;     // Catch: Exception -> L38
        goto L11
    L16:
        r5 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        goto L17
    L8:
        r8 = null;
    L17:
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        if (r13 != null) goto L20;
    L23:
        if (r3 == false) goto L26;
        ILogDepend.Companion.i(TAG, "fetchLatestRecordingEntities, RCSearch returned empty");     // Catch: Exception -> L38
        return d.a.p.b();
    L26:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L38
    L28:
        if (r14.hasNext() == false) goto L32;
        RecordingEntity r15 = (RecordingEntity) ZeusTransformUtils.preCheckCast(r14.next(), RecordingEntity.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        r15.setExtraData("fictitious");     // Catch: Exception -> L38
        String r16 = f16080a.a(r15.getRecordStatus());     // Catch: Exception -> L38
        if (r16 == null) goto L28;
        r15.setName(r16);     // Catch: Exception -> L38
        goto L28
    L32:
        ILogDepend.Companion r17 = ILogDepend.Companion;     // Catch: Exception -> L38
        StringBuilder r18 = new StringBuilder().append("fetchLatestRecordingEntities, RCSearch success, size=").append(r5.size()).append(", statuses=");     // Catch: Exception -> L38
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r19, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        Iterator r21 = r19.iterator();     // Catch: Exception -> L38
    L34:
        if (r21.hasNext() == false) goto L36;
        r20.add(((RecordingEntity) ZeusTransformUtils.preCheckCast(r21.next(), RecordingEntity.class, "com.obric.aiagent.plugin")).getRecordStatus());     // Catch: Exception -> L38
        goto L34
    L36:
        r17.i(TAG, r18.append((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin")).toString());     // Catch: Exception -> L38
        return r5;
    L20:
        if (r13.isEmpty() == true) goto L23;
        r3 = false;
    L38:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "fetchLatestRecordingEntities, RCSearch failed: " + e.getMessage());
        return d.a.p.b();
    }

    public final void a(List<RecordingEntity> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "entities");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        RecordingEntity r6 = (RecordingEntity) ZeusTransformUtils.preCheckCast(r5.next(), RecordingEntity.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6.getName(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L4;
        String r1 = f16080a.a(r6.getRecordStatus());
        if (r1 == null) goto L4;
        r6.setName(r1);
        goto L4
    }

    public static /* synthetic */ boolean a(v r1, IntentExecutionRecord r2, String r3, d.h.a.a r4, int r5, Object r6) {
        d.h.a.a<? extends List<RecordingEntity>> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r7 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r1), d.h.a.a.class, "com.obric.aiagent.plugin");
    L6:
        return r1.a(r2, r3, r7);
    }

    public final boolean a(IntentExecutionRecord r4, String r5, d.h.a.a<? extends List<RecordingEntity>> r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, MemorySourceLinkType.INTENT);
        d.h.b.o.e(r5, "inputParam");
        d.h.b.o.e(r7, "entityFetcher");
        if (d.h.b.o.a(r4.getIntentName(), "Recorder_Operate") == true) goto L5;
    L23:
        return false;
    L5:
        if (r4.getResult().getRet() != 0) goto L23;
        if (a(r4.getResult().getEntity()) == true) goto L23;
        if (b(r5) == false) goto L23;
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L13
        Object r8 = d.n.f(r7.invoke());     // Catch: Throwable -> L13
    L15:
        List r9 = d.a.p.b();
        if (d.n.b(r8) == false) goto L18;
        r8 = r9;
    L18:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r10.isEmpty() == false) goto L21;
        return false;
    L21:
        IntentResult<?> r11 = r4.getResult();
        d.h.b.o.a(r11, "null cannot be cast to non-null type com.obric.capabilitykit.common.intent.IntentResult<kotlin.Array<com.obric.capabilitykit.entity.app.RecordingEntity>>");
        r11.setEntity(((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).toArray(new RecordingEntity[0]));
        return true;
    L13:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L15
    }

    public final boolean b(String r4) {
        d.h.b.o.e(r4, "inputParam");
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16081b, Iterable.class, "com.obric.aiagent.plugin"), d(r4));
    }

    public final List<RecordingEntity> a(String r3, int r4, List<RecordingEntity> r5, String r6) {
        List<RecordingEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "intentName");
        d.h.b.o.e(r7, "resultEntities");
        d.h.b.o.e(r6, "inputParam");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L5;
    L10:
        return r7;
    L5:
        if (d.h.b.o.a(r3, "Recorder_Delete") == false) goto L10;
        if (r4 != 0) goto L10;
        return c(r6);
    }

    private final List<RecordingEntity> c(String r4) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L17
        final v r3 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        JsonElement r5 = JsonParser.parseString(r4);     // Catch: Throwable -> L17
        if (r5.isJsonObject() == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L14;
        JsonObject r6 = r5.getAsJsonObject();     // Catch: Throwable -> L17
        if (r6 == null) goto L14;
        List r7 = d.n.m.g(d.n.m.f(d.n.m.e(d.n.m.c(d.n.m.d(d.n.m.e(d.n.m.a(new String[]{"targets", "candidates"}), (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r6), d.h.a.b.class, "com.obric.aiagent.plugin")), $$Lambda$v$Dt9Tn955LoyCMVfYFCPrtVKhOAg.INSTANCE), $$Lambda$v$Fyn8CbFDlepCKXv0PaKgpv6lmEs.INSTANCE), new $$Lambda$v$O6LGWhRDIVggCsVEI1hp3IMdK_c(r3)), $$Lambda$v$Tz80o_7Q9iQEiDjcYZzceyHtRAo.INSTANCE));     // Catch: Throwable -> L17
    L15:
        Object r8 = d.n.f(r7);     // Catch: Throwable -> L17
    L19:
        List r9 = d.a.p.b();
        if (d.n.b(r8) == false) goto L23;
        r8 = r9;
    L23:
        return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
    L14:
        r7 = d.a.p.b();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L19
    L5:
        return d.a.p.b();
    }

    private static final JsonElement a(JsonElement r2) {
        d.h.b.o.e(r2, "value");
        if (r2.isJsonObject() == false) goto L5;
        JsonElement r1 = r2;
    L6:
        if (r1 == null) goto L13;
        JsonObject r3 = r1.getAsJsonObject();
        if (r3 == null) goto L14;
        JsonElement r0 = r3.get("value");
        if (r0 != null) goto L12;
        return r2;
    L12:
        return r0;
    L14:
        return r2;
    L13:
        return r2;
    L5:
        r1 = null;
        goto L6
    }

    private static final d.n.j b(JsonElement r2) {
        d.h.b.o.e(r2, "value");
        if (r2.isJsonArray() == false) goto L6;
        JsonArray r3 = r2.getAsJsonArray();
        d.h.b.o.c(r3, "getAsJsonArray(...)");
        return d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"));
    L6:
        if (r2.isJsonObject() == false) goto L9;
        return d.n.m.a(new JsonElement[]{r2});
    L9:
        return d.n.m.a();
    }

    private static final RecordingEntity a(v r3, JsonElement r4) {
        Object r0 = null;
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L9
        AppEntity.CREATOR r2 = AppEntity.CREATOR;     // Catch: Throwable -> L9
        String r5 = r4.toString();     // Catch: Throwable -> L9
        d.h.b.o.c(r5, "toString(...)");     // Catch: Throwable -> L9
        AppEntity r6 = r2.fromJson(r5);     // Catch: Throwable -> L9
        if (ZeusTransformUtils.instanceOf(r6, RecordingEntity.class) == false) goto L6;
        RecordingEntity r7 = (RecordingEntity) ZeusTransformUtils.preCheckCast(r6, RecordingEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
    L7:
        Object r8 = d.n.f(r7);     // Catch: Throwable -> L9
    L12:
        if (d.n.b(r8) == true) goto L16;
        r0 = r8;
    L16:
        return (RecordingEntity) ZeusTransformUtils.preCheckCast(r0, RecordingEntity.class, "com.obric.aiagent.plugin");
    L6:
        r7 = null;
    L9:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L12
    }

    private static final d.r a(RecordingEntity r3) {
        d.h.b.o.e(r3, "entity");
        return new d.r(r3.get_packageName(), Integer.valueOf(r3.getType()), r3.getId());
    }

    private final String d(String r4) {
        Object r2 = null;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L41;
        return null;
    L41:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L33
        v r3 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        JsonElement r5 = JsonParser.parseString(r4);     // Catch: Throwable -> L33
        if (r5.isJsonObject() == true) goto L9;
        r5 = null;
    L9:
        if (r5 == null) goto L30;
        JsonObject r6 = r5.getAsJsonObject();     // Catch: Throwable -> L33
        if (r6 == null) goto L30;
        JsonElement r7 = r6.get("action");     // Catch: Throwable -> L33
        if (r7 == null) goto L30;
        if (r7.isJsonPrimitive() == false) goto L18;
        String r8 = r7.getAsString();     // Catch: Throwable -> L33
    L28:
        if (r8 == null) goto L30;
        String r9 = r8.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L33
        d.h.b.o.c(r9, "toLowerCase(...)");     // Catch: Throwable -> L33
    L31:
        Object r10 = d.n.f(r9);     // Catch: Throwable -> L33
    L36:
        if (d.n.b(r10) == true) goto L40;
        r2 = r10;
    L40:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L18:
        if (r7.isJsonObject() == false) goto L27;
        JsonElement r11 = r7.getAsJsonObject().get("value");     // Catch: Throwable -> L33
        if (r11 == null) goto L27;
        if (r11.isJsonPrimitive() == true) goto L25;
        r11 = null;
    L25:
        if (r11 == null) goto L27;
        r8 = r11.getAsString();     // Catch: Throwable -> L33
    L27:
        r8 = null;
    L30:
        r9 = null;
    L33:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
        goto L36
    }

    private final boolean a(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, RecordingEntity.class) == false) goto L6;
    L13:
        return true;
    L6:
        if ((r6 instanceof Object[]) == false) goto L16;
        Object[] r5 = (Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.aiagent.plugin");
        int r7 = r5.length;
        int r2 = 0;
    L8:
        if (r2 >= r7) goto L17;
        if (ZeusTransformUtils.instanceOf(r5[r2], RecordingEntity.class) == true) goto L13;
        r2 = r2 + 1;
        goto L8
    L17:
        return false;
    L16:
        return false;
    }
}
