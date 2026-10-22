package com.obric.assistant.dm.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.agent.dm.InputParams;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.k;
import d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: EcaDataService.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.agent.dm.e f22479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f22480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.agent.dm.f f22481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.obric.agent.dm.b f22482e;
    private com.obric.agent.dm.b f;
    private InputParams g;

    /* JADX INFO: compiled from: EcaDataService.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public c(com.obric.agent.dm.e r2) {
        o.e(r2, "ecaData");
        this.f22479b = r2;
        g();
    }

    public final com.obric.agent.dm.e a() {
        return this.f22479b;
    }

    public final boolean b() {
        return this.f22480c;
    }

    private final void f() {
        this.f22480c = true;
        if (this.f22481d != null) goto L5;
    L37:
        ILogDepend.Companion.d(TAG, "Main data is missing currentJob:" + this.f22481d + " currentSelectAction:" + this.f22482e + " currentAction:" + this.f);
        this.f22480c = false;
        return;
    L5:
        if (this.f22482e == null) goto L37;
        if (this.f == null) goto L37;
        InputParams r0 = this.g;
        if (r0 == null) goto L36;
        o.a(r0);
        if (r0.getCandidate() == null) goto L36;
        InputParams r1 = this.g;
        o.a(r1);
        com.obric.agent.dm.a r2 = r1.getCandidate();
        o.a(r2);
        if (r2.a() == null) goto L36;
        InputParams r3 = this.g;
        if (r3 == null) goto L35;
        o.a(r3);
        if (r3.getType() == null) goto L35;
        InputParams r4 = this.g;
        o.a(r4);
        com.obric.agent.dm.d r5 = r4.getType();
        o.a(r5);
        if (r5.a() == null) goto L35;
        j r6 = j.f22497a;
        InputParams r7 = this.g;
        o.a(r7);
        com.obric.agent.dm.d r8 = r7.getType();
        o.a(r8);
        String r9 = r8.a();
        if (r9 != null) goto L27;
        r9 = "";
    L27:
        if (r6.a(r9) == true) goto L29;
        ILogDepend.Companion r10 = ILogDepend.Companion;
        String r11 = TAG;
        StringBuilder r12 = new StringBuilder().append("currentSelectAction type data not support:");
        InputParams r13 = this.g;
        o.a(r13);
        com.obric.agent.dm.d r14 = r13.getType();
        o.a(r14);
        r10.d(r11, r12.append(r14.a()).toString());
        this.f22480c = false;
        return;
    L29:
        com.obric.agent.dm.b r15 = this.f;
        o.a(r15);
        if (r15.c() != null) goto L32;
        ILogDepend.Companion.d(TAG, "CurrentAction target data missing inputParams:" + this.f);
        this.f22480c = false;
        return;
    L32:
        List<String> r16 = e().a();
        o.a(r16);
        if (r16.isEmpty() == false) goto L41;
        ILogDepend.Companion.d(TAG, "CurrentAction target data missing candidate:" + this.f22482e);
        this.f22480c = false;
        return;
    L41:
        return;
    L35:
        ILogDepend.Companion.d(TAG, "currentSelectAction type data missing inputParams:" + this.f22482e);
        this.f22480c = false;
        return;
    L36:
        ILogDepend.Companion.d(TAG, "currentSelectAction candidate data missing inputParams:" + this.f22482e);
        this.f22480c = false;
    }

    public final int c() {
        com.obric.agent.dm.b r0 = this.f22482e;
        o.a(r0);
        return r0.b();
    }

    public final boolean a(int r9) {
        ILogDepend.Companion r0 = ILogDepend.Companion;
        String r1 = TAG;
        r0.d(r1, "pickupData " + this.f22482e);
        if (r9 >= 0) goto L5;
        InputParams r2 = this.g;
        o.a(r2);
        com.obric.agent.dm.a r3 = r2.getCandidate();
        o.a(r3);
        List<String> r4 = r3.a();
        o.a(r4);
        r9 = r9 + r4.size();
    L5:
        InputParams r5 = this.g;
        o.a(r5);
        com.obric.agent.dm.a r6 = r5.getCandidate();
        o.a(r6);
        List<String> r7 = r6.a();
        o.a(r7);
        if (r9 >= r7.size()) goto L20;
        if (r9 < 0) goto L20;
        InputParams r8 = this.g;
        o.a(r8);
        com.obric.agent.dm.a r10 = r8.getCandidate();
        o.a(r10);
        List<String> r11 = r10.a();
        o.a(r11);
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.get(r9), String.class, "com.obric.aiagent.plugin");
        com.obric.agent.dm.b r13 = this.f;
        o.a(r13);
        JsonObject r14 = r13.c();
        o.a(r14);
        a(r14, r12);
        ILogDepend.Companion r15 = ILogDepend.Companion;
        StringBuilder r16 = new StringBuilder().append("after replaceOutputParamsValue ");
        com.obric.agent.dm.b r17 = this.f;
        o.a(r17);
        r15.d(r1, r16.append(r17.c()).toString());
        com.obric.agent.dm.f r18 = this.f22481d;
        o.a(r18);
        com.obric.agent.dm.f r19 = this.f22481d;
        o.a(r19);
        List<com.obric.agent.dm.b> r20 = r19.a();
        o.a(r20);
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.aiagent.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r23 = r21.iterator();
    L10:
        boolean r24 = true;
        if (r23.hasNext() == false) goto L18;
        Object r25 = r23.next();
        int r26 = ((com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(r25, com.obric.agent.dm.b.class, "com.obric.aiagent.plugin")).b();
        com.obric.agent.dm.b r27 = this.f22482e;
        o.a(r27);
        if (r26 == r27.b()) goto L16;
        r24 = false;
    L16:
        if (r24 == true) goto L10;
        r22.add(r25);
        goto L10
    L18:
        this.f22481d = r18.a((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.aiagent.plugin"));
        return true;
    L20:
        ILogDepend.Companion.e(r1, "invalid index " + r9);
        return false;
    }

    public final boolean a(List<Integer> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        o.e(r13, "indexes");
        ILogDepend.Companion.d(TAG, "filterEntities " + this.f22482e);
        InputParams r0 = this.g;
        InputParams r2 = null;
        if (r0 == null) goto L5;
        com.obric.agent.dm.a r1 = r0.getCandidate();
    L6:
        if (r1 == null) goto L8;
        List<String> r3 = r1.a();
    L10:
        if (r1 == null) goto L32;
        if (r3 == null) goto L33;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
        int r8 = 0;
    L14:
        if (r7.hasNext() == false) goto L22;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L18;
        p.c();
    L18:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
        if (r13.contains(Integer.valueOf(r8)) == false) goto L21;
        r6.add(r9);
    L21:
        r8 = r10;
        goto L14
    L22:
        List<String> r14 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        com.obric.agent.dm.a r15 = r1.a(r14);
        InputParams r16 = this.g;
        if (r16 == null) goto L25;
        r2 = InputParams.copy$default(r16, r15, null, null, 6, null);
    L25:
        this.g = r2;
        if (r3.size() == r14.size()) goto L34;
        return true;
    L34:
        return false;
    L33:
        return false;
    L32:
        return false;
    L8:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final InputParams d() {
        return this.g;
    }

    public final com.obric.agent.dm.a e() {
        ILogDepend.Companion.d(TAG, "getCandidate " + this.g);
        InputParams r4 = this.g;
        o.a(r4);
        com.obric.agent.dm.a r5 = r4.getCandidate();
        o.a(r5);
        return r5;
    }

    private final void g() {
        List<com.obric.agent.dm.f> r0 = this.f22479b.a();
        o.a(r0);
        Iterator<com.obric.agent.dm.f> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        com.obric.agent.dm.f r2 = (com.obric.agent.dm.f) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.agent.dm.f.class, "com.obric.aiagent.plugin");
        List<com.obric.agent.dm.b> r3 = r2.a();
        o.a(r3);
        Iterator<com.obric.agent.dm.b> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        com.obric.agent.dm.b r5 = (com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.agent.dm.b.class, "com.obric.aiagent.plugin");
        if (d.a.i.b(com.obric.agent.dm.g.a(), r5.a()) == false) goto L7;
        this.f22481d = r2;
        this.f22482e = r5;
        this.g = (InputParams) ZeusTransformUtils.preCheckCast(new Gson().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r5.c(), JsonElement.class, "com.obric.aiagent.plugin"), InputParams.class), InputParams.class, "com.obric.aiagent.plugin");
    L12:
        if (this.f22481d == null) goto L4;
    L14:
        if (this.f22479b.b() == true) goto L31;
        com.obric.agent.dm.f r6 = this.f22481d;
        if (r6 == null) goto L31;
        List<com.obric.agent.dm.b> r7 = r6.a();
        o.a(r7);
        Iterator<com.obric.agent.dm.b> r8 = r7.iterator();
    L19:
        if (r8.hasNext() == false) goto L31;
        com.obric.agent.dm.b r9 = (com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.agent.dm.b.class, "com.obric.aiagent.plugin");
        if (d.a.i.b(com.obric.agent.dm.g.a(), r9.a()) == true) goto L30;
        JsonObject r10 = r9.c();
        if (r10 == null) goto L30;
        m<Boolean, Integer> r11 = a(r10);
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11.a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L30;
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(r11.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        com.obric.agent.dm.b r13 = this.f22482e;
        o.a(r13);
        if (r12 != r13.b()) goto L30;
        this.f = r9;
    L30:
        if (this.f == null) goto L19;
    L31:
        f();
    }

    static {
        f22478a = new a(null);
        TAG = "[DM] EcaDataService";
    }

    private final m<Boolean, Integer> a(JsonObject r7) {
        Pattern r0 = Pattern.compile("\\$(\\d+)\\.outputParams");
        Iterator<Map.Entry<String, JsonElement>> r8 = r7.entrySet().iterator();
    L3:
        int r2 = -1;
        if (r8.hasNext() == false) goto L27;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o.a(r1);
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r4 = (JsonElement) ZeusTransformUtils.preCheckCast(r1.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, JsonObject.class) == true) goto L7;
        if (r4 == null) goto L25;
        String r5 = r4.getAsString();
        if (i.a(r5) == false) goto L3;
        Matcher r6 = r0.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r6.find() == false) goto L3;
        String r9 = r6.group(1);
        if (r9 == null) goto L18;
        Integer r10 = d.o.o.d(r9);
    L20:
        if (r10 == null) goto L23;
        r2 = r10.intValue();
    L23:
        return new m(true, Integer.valueOf(r2));
    L18:
        r10 = null;
        goto L20
    L25:
        throw new k();
    L7:
        m<Boolean, Integer> r11 = a((JsonObject) ZeusTransformUtils.preCheckCast(r4, JsonObject.class, "com.obric.aiagent.plugin"));
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11.a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L3;
        return r11;
    L27:
        return new m(false, -1);
    }

    private final JsonObject a(JsonObject r10, String r11) {
        ILogDepend.Companion.d(TAG, "replaceOutputParamsValue copyObject:" + r10 + " newValue:" + r11);
        Pattern r0 = Pattern.compile("\\$(\\d+)\\.outputParams");
        Iterator<Map.Entry<String, JsonElement>> r1 = r10.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L31;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o.a(r2);
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r4 = (JsonElement) ZeusTransformUtils.preCheckCast(r2.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, JsonObject.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r4, JsonPrimitive.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, JsonArray.class) == true) goto L17;
        r10.add(r3, r4);
        goto L4
    L17:
        JsonArray r5 = new JsonArray();
        Iterator<JsonElement> r6 = ((JsonArray) ZeusTransformUtils.preCheckCast(r4, JsonArray.class, "com.obric.aiagent.plugin")).iterator();
        o.c(r6, "iterator(...)");
    L19:
        if (r6.hasNext() == false) goto L29;
        JsonElement r7 = (JsonElement) ZeusTransformUtils.preCheckCast(r6.next(), JsonElement.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, JsonPrimitive.class) == true) goto L22;
        r5.add(r7);
        goto L19
    L22:
        String r8 = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(r7, JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsString();
        if (i.a(r8) == false) goto L19;
        Matcher r9 = r0.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r9.find() == true) goto L26;
        r5.add(r7);
        goto L19
    L26:
        r5.add(r9.replaceAll(Matcher.quoteReplacement(r11)));
        goto L19
    L29:
        r10.add(r3, (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L4
    L10:
        String r12 = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(r4, JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsString();
        if (i.a(r12) == false) goto L4;
        Matcher r13 = r0.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r13.find() == false) goto L4;
        r10.addProperty(r3, r13.replaceAll(Matcher.quoteReplacement(r11)));
        goto L4
    L7:
        r10.add(r3, (JsonElement) ZeusTransformUtils.preCheckCast(a((JsonObject) ZeusTransformUtils.preCheckCast(r4, JsonObject.class, "com.obric.aiagent.plugin"), r11), JsonElement.class, "com.obric.aiagent.plugin"));
        goto L4
    L31:
        return r10;
    }
}
