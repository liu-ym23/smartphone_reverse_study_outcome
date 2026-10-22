package com.obric.autogui.agents.vlm.models.impl.d;

import android.content.Context;
import android.graphics.PointF;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.scripted.api.IJSScriptService;
import com.obric.autogui.agents.vlm.models.impl.n;
import com.obric.autogui.common.a.k;
import com.obric.autogui.common.api.AODeviceSpecificTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.i;
import d.h.b.l;
import d.h.b.o;
import d.n.j;
import d.n.m;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: StdModelStepParserImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class f implements com.obric.autogui.agents.vlm.models.impl.d.a, com.obric.autogui.agents.vlm.models.impl.d.b {
    private static final String TAG = "M-Std-Resp/Parser";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27782a = null;

    /* JADX INFO: compiled from: StdModelStepParserImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StdModelStepParserImpl.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Collection<com.obric.autogui.operator.e.C0780e> f27783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f27784b;

        public b(Collection<com.obric.autogui.operator.e.C0780e> r3, String r4) {
            Collection<com.obric.autogui.operator.e.C0780e> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
            o.e(r5, "ops");
            this.f27783a = r5;
            this.f27784b = r4;
        }

        public final Collection<com.obric.autogui.operator.e.C0780e> a() {
            return this.f27783a;
        }

        public final String b() {
            return this.f27784b;
        }
    }

    /* JADX INFO: compiled from: StdModelStepParserImpl.kt */
    public static final class c implements com.obric.autogui.agents.vlm.models.impl.d.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f27786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f27787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final j<com.obric.autogui.agents.vlm.models.impl.g> f27788d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f27785a == r6.f27785a) goto L12;
            return false;
        L12:
            if (o.a(this.f27786b, r6.f27786b) == true) goto L15;
            return false;
        L15:
            if (this.f27787c == r6.f27787c) goto L18;
            return false;
        L18:
            if (o.a(this.f27788d, r6.f27788d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f27785a) * 31;
            String r1 = this.f27786b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((r0 + r2) * 31) + Integer.hashCode(this.f27787c)) * 31) + this.f27788d.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ParsedResult(ok=" + this.f27785a + ", reason=" + this.f27786b + ", expectedStepsCount=" + this.f27787c + ", validSteps=" + this.f27788d + ')';
        }

        public c(boolean r3, String r4, int r5, j<? extends com.obric.autogui.agents.vlm.models.impl.g> r6) {
            j<com.obric.autogui.agents.vlm.models.impl.g> r7 = (j) ZeusTransformUtils.wrapperContextForParams(r6, j.class, "com.obric.aiagent.plugin");
            o.e(r7, "validSteps");
            this.f27785a = r3;
            this.f27786b = r4;
            this.f27787c = r5;
            this.f27788d = r7;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.d.b.a
        public com.obric.autogui.agents.vlm.models.impl.g e() {
            return com.obric.autogui.agents.vlm.models.impl.d.b.a.C0691a.a(this);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.d.b.a
        public boolean a() {
            return this.f27785a;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.d.b.a
        public String b() {
            return this.f27786b;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.d.b.a
        public int c() {
            return this.f27787c;
        }

        public /* synthetic */ c(boolean r2, String r3, int r4, j r5, int r6, d.h.b.h r7) {
            j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = 0;
        L9:
            if ((r6 & 8) == 0) goto L11;
            r8 = m.a();
        L11:
            this(r2, r3, r4, r8);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.d.b.a
        public j<com.obric.autogui.agents.vlm.models.impl.g> d() {
            return this.f27788d;
        }
    }

    /* JADX INFO: compiled from: StdModelStepParserImpl.kt */
    public static final class d implements com.obric.autogui.agents.vlm.models.impl.d.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.impl.g f27789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f27790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f27791c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f27792d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f27789a, r6.f27789a) == true) goto L12;
            return false;
        L12:
            if (this.f27790b == r6.f27790b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f27789a.hashCode() * 31) + Integer.hashCode(this.f27790b);
        }

        public String toString() {
            return "SingleStepResult(step=" + this.f27789a + ", expectedStepsCount=" + this.f27790b + ')';
        }

        public d(com.obric.autogui.agents.vlm.models.impl.g r2, int r3) {
            o.e(r2, "step");
            this.f27789a = r2;
            this.f27790b = r3;
            this.f27791c = true;
        }

        public /* synthetic */ d(com.obric.autogui.agents.vlm.models.impl.g r1, int r2, int r3, d.h.b.h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = 1;
        L5:
            this(r1, r2);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.d.b.a
        public com.obric.autogui.agents.vlm.models.impl.g e() {
            return com.obric.autogui.agents.vlm.models.impl.d.b.a.C0691a.a(this);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.d.b.a
        public int c() {
            return this.f27790b;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.d.b.a
        public boolean a() {
            return this.f27791c;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.d.b.a
        public String b() {
            return this.f27792d;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.d.b.a
        public j<com.obric.autogui.agents.vlm.models.impl.g> d() {
            return m.a(new com.obric.autogui.agents.vlm.models.impl.g[]{this.f27789a});
        }
    }

    /* JADX INFO: compiled from: StdModelStepParserImpl.kt */
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27793a = null;

        static {
            int[] r0 = new int[com.obric.autogui.operator.b.EnumC0777b.values().length];
            r0[com.obric.autogui.operator.b.EnumC0777b.f29869a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f27793a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.d.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StdModelStepParserImpl.kt */
    /* synthetic */ class C0692f implements com.obric.autogui.agents.vlm.models.impl.d.a, i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f27794a;

        C0692f(f r1) {
            this.f27794a = r1;
        }

        @Override // d.h.b.i
        public final d.c<?> a() {
            return (d.c) ZeusTransformUtils.preCheckCast(new l(3, this.f27794a, f.class, "genOpsFromResponse", "genOpsFromResponse(Lcom/obric/autogui/agents/vlm/models/impl/StandardModel$ModelInferenceContext;Ljava/lang/String;Lcom/google/gson/JsonArray;)Lcom/obric/autogui/common/StatusData;", 0), d.c.class, "com.obric.aiagent.plugin");
        }

        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.agents.vlm.models.impl.d.a.class) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, i.class) == true) goto L7;
            return false;
        L7:
            return o.a(((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin")).a(), ((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin")).a());
        }

        public final int hashCode() {
            return ((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin")).a().hashCode();
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.d.a
        public final com.obric.autogui.common.d<b> a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r2, String r3, JsonArray r4) {
            o.e(r2, "p0");
            o.e(r3, "p1");
            o.e(r4, "p2");
            return this.f27794a.a(r2, r3, r4);
        }
    }

    static {
        f27782a = new a(null);
    }

    public com.obric.autogui.agents.vlm.models.impl.g a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r1, com.obric.autogui.agents.vlm.models.impl.g r2) {
        o.e(r1, "inferenceContext");
        o.e(r2, "generatedStep");
        return null;
    }

    public f() {
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.d.b
    public com.obric.autogui.agents.vlm.models.impl.d.b.a a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r9, JsonObject r10) {
        o.e(r9, "inferenceContext");
        o.e(r10, "response");
        return b(r9, r10);
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "failed to parse response body:" + r10, th);
        return (com.obric.autogui.agents.vlm.models.impl.d.b.a) ZeusTransformUtils.preCheckCast(new c(false, "failed to parse response body: " + th, 0, null, 12, null), com.obric.autogui.agents.vlm.models.impl.d.b.a.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.autogui.agents.vlm.models.impl.d.b.a b(com.obric.autogui.agents.vlm.models.impl.d.C0690d r14, JsonObject r15) {
        long r0 = System.currentTimeMillis();
        String r2 = r15.get("action_type").getAsString();
        JsonArray r3 = r15.get("action_args").getAsJsonArray();
        long r4 = System.currentTimeMillis();
        com.obric.autogui.common.d.a r6 = com.obric.autogui.common.d.f29012a;
        o.a(r2);
        o.a(r3);
        com.obric.autogui.common.d r16 = r6.a(a(r14, r2, r3, r15));
        Loog.INSTANCE.d(TAG, "genStepWithArgs cost: " + (System.currentTimeMillis() - r4) + "ms");
        if (r14.a().a().c() == false) goto L10;
        com.obric.autogui.agents.vlm.models.impl.g r5 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r16.a(), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L10;
        String r7 = r14.a().a().v();
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        r5.n(r7);
    L10:
        long r8 = System.currentTimeMillis();
        com.obric.autogui.agents.vlm.models.impl.g r9 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r16.a(), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        com.obric.autogui.agents.vlm.models.impl.g r13 = a(r14, r9);
        if (r13 == null) goto L15;
        Loog.INSTANCE.i(TAG, " - [adjustedStep]: " + r16.a() + " --> " + r13);
        r16.a(r13);
        r13.d(r13.u() | 1);
    L15:
        Loog.INSTANCE.d(TAG, "adjustStepFromResponse cost: " + (System.currentTimeMillis() - r8) + "ms");
        com.obric.autogui.agents.vlm.models.impl.g r17 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r16.a(), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L20;
        int r18 = r17.l();
        if (r18 == (-1)) goto L20;
        r14.a().a().b(r18);
    L20:
        com.obric.autogui.agents.vlm.models.impl.g r19 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r16.a(), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
        if (r19 != null) goto L24;
        Loog.INSTANCE.w(TAG, "parsed a NULL step.");
        return (com.obric.autogui.agents.vlm.models.impl.d.b.a) ZeusTransformUtils.preCheckCast(new c(false, r16.h(), 0, null, 12, null), com.obric.autogui.agents.vlm.models.impl.d.b.a.class, "com.obric.aiagent.plugin");
    L24:
        Loog.INSTANCE.d(TAG, "Total genStepFromResponse cost: " + (System.currentTimeMillis() - r0) + "ms");
        return (com.obric.autogui.agents.vlm.models.impl.d.b.a) ZeusTransformUtils.preCheckCast(new d(r19, 0, 2, null), com.obric.autogui.agents.vlm.models.impl.d.b.a.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.obric.autogui.common.d<? extends com.obric.autogui.agents.vlm.models.impl.g> a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r9, String r10, JsonArray r11, JsonObject r12) {
        o.e(r9, "inferenceContext");
        o.e(r10, "acName");
        o.e(r11, "acParam");
        o.e(r12, "responseJson");
        int r5 = 0;
        Object r6 = null;
        String r7 = null;
        String r8 = null;
        Object r13 = null;
        String r14 = null;
        switch(r10.hashCode()) {
            case -1046022900: goto L119;
            case -570883966: goto L106;
            case 3540994: goto L52;
            case 853581410: goto L27;
            case 1325627418: goto L11;
            case 1379812394: goto L6;
            default: goto L154;
        };
    L154:
        com.obric.autogui.common.d<b> r15 = a(r9, r10, r11);
        if (r15.g() == false) goto L157;
        b r16 = (b) ZeusTransformUtils.preCheckCast(r15.a(), b.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L179;
        com.obric.autogui.agents.vlm.models.impl.e r17 = a(r12, r16);
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(a(r10, r11), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L162:
        if (r18.hasNext() == false) goto L164;
        r17.a().add((PointF) ZeusTransformUtils.preCheckCast(r18.next(), PointF.class, "com.obric.aiagent.plugin"));
        goto L162
    L164:
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r17.Q(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L166:
        if (r19.hasNext() == false) goto L173;
        Object r110 = r19.next();
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r110, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.j) goto L170;
        Object[] r111 = true;
    L171:
        if (r111 == false) goto L166;
        r6 = r110;
        goto L173
    L170:
        r111 = false;
    L173:
        com.obric.autogui.operator.e.C0780e r20 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L177;
        com.obric.autogui.operator.b.a r21 = r20.b();
        o.a(r21, "null cannot be cast to non-null type com.obric.autogui.operator.impl.op.OpSwipeUI.Input");
        r17.a(((com.obric.autogui.operator.a.b.e.b) ZeusTransformUtils.preCheckCast(r21, com.obric.autogui.operator.a.b.e.b.class, "com.obric.aiagent.plugin")).d());
    L177:
        return com.obric.autogui.common.d.f29012a.a(r17);
    L179:
        return com.obric.autogui.common.d.f29012a.a("cannot generate ops for step: " + r10);
    L157:
        return com.obric.autogui.common.d.f29012a.a((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin"));
    L6:
        if (r10.equals("Unknown") == false) goto L154;
        return new com.obric.autogui.common.d(false, "unknown action, the model was unable to generate a step.", 0, new n());
    L11:
        if (r10.equals("set_time_task") == false) goto L154;
        com.obric.autogui.common.d.a r22 = com.obric.autogui.common.d.f29012a;
        com.obric.autogui.agents.vlm.models.impl.m r112 = new com.obric.autogui.agents.vlm.models.impl.m();
        JsonElement r0 = r11.get(0);
        if (r0 == null) goto L16;
        String r1 = r0.getAsString();
    L17:
        r112.j(r1);
        JsonElement r2 = r11.get(1);
        if (r2 == null) goto L20;
        String r3 = r2.getAsString();
    L21:
        r112.k(r3);
        JsonElement r113 = r11.get(2);
        if (r113 == null) goto L24;
        r7 = r113.getAsString();
    L24:
        r112.l(r7);
        x r114 = x.f38692a;
        return r22.a(a((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(a((com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(r112, com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin"), r12), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin"), r12));
    L20:
        r3 = null;
        goto L21
    L16:
        r1 = null;
        goto L17
    L27:
        if (r10.equals("clarify") == false) goto L154;
        com.obric.autogui.common.d.a r23 = com.obric.autogui.common.d.f29012a;
        com.obric.autogui.agents.vlm.models.impl.i r115 = new com.obric.autogui.agents.vlm.models.impl.i();
        JsonElement r4 = r11.get(0);
        if (r4 == null) goto L32;
        String r24 = r4.getAsString();
    L33:
        r115.j(r24);
        JsonElement r116 = r11.get(1);
        if (r116 == null) goto L42;
        JsonArray r117 = r116.getAsJsonArray();
        if (r117 == null) goto L42;
        Iterable r118 = (Iterable) ZeusTransformUtils.preCheckCast(r117, Iterable.class, "com.obric.aiagent.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r118, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r119 = r118.iterator();
    L39:
        if (r119.hasNext() == false) goto L41;
        r25.add(((JsonElement) ZeusTransformUtils.preCheckCast(r119.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsString());
        goto L39
    L41:
        List<String> r120 = (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin");
    L43:
        r115.a(r120);
        JsonElement r121 = r12.get("candidates_style_options");
        List<String> r26 = r115.F();
        if (r26 == null) goto L46;
        r5 = r26.size();
    L46:
        r115.a(g.a(r121, r5));
        JsonElement r122 = r12.get("security_level");
        if (r122 == null) goto L49;
        r8 = r122.getAsString();
    L49:
        r115.k(r8);
        x r123 = x.f38692a;
        return r23.a(a((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(a((com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(r115, com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin"), r12), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin"), r12));
    L42:
        r120 = null;
        goto L43
    L32:
        r24 = null;
        goto L33
    L52:
        if (r10.equals("stop") == false) goto L154;
        com.obric.autogui.common.d.a r27 = com.obric.autogui.common.d.f29012a;
        com.obric.autogui.agents.vlm.models.impl.j r124 = new com.obric.autogui.agents.vlm.models.impl.j();
        JsonElement r28 = r11.get(0);
        if (r28 == null) goto L57;
        String r29 = r28.getAsString();
    L58:
        r124.j(r29);
        d.n.a r30 = d.n.f38560a;     // Catch: Throwable -> L65
        JsonElement r31 = r11.get(1);     // Catch: Throwable -> L65
        if (r31 == null) goto L62;
        String r32 = r31.getAsString();     // Catch: Throwable -> L65
    L63:
        Object r33 = d.n.f(Boolean.valueOf(o.a(r32, "success")));     // Catch: Throwable -> L65
    L68:
        if (d.n.b(r33) == false) goto L70;
        r33 = null;
    L70:
        Boolean r34 = (Boolean) ZeusTransformUtils.preCheckCast(r33, Boolean.class, "com.obric.aiagent.plugin");
        if (r34 == null) goto L73;
        boolean r35 = r34.booleanValue();
    L74:
        r124.c(r35);
        d.n.a r36 = d.n.f38560a;     // Catch: Throwable -> L81
        JsonElement r37 = r11.get(2);     // Catch: Throwable -> L81
        if (r37 == null) goto L78;
        Boolean r38 = Boolean.valueOf(r37.getAsBoolean());     // Catch: Throwable -> L81
    L79:
        Object r39 = d.n.f(r38);     // Catch: Throwable -> L81
    L84:
        if (d.n.b(r39) == false) goto L86;
        r39 = null;
    L86:
        Boolean r40 = (Boolean) ZeusTransformUtils.preCheckCast(r39, Boolean.class, "com.obric.aiagent.plugin");
        if (r40 == null) goto L89;
        boolean r41 = r40.booleanValue();
    L90:
        r124.d(r41);
        d.n.a r42 = d.n.f38560a;     // Catch: Throwable -> L97
        JsonElement r125 = r11.get(3);     // Catch: Throwable -> L97
        if (r125 == null) goto L94;
        String r126 = r125.getAsString();     // Catch: Throwable -> L97
    L95:
        Object r127 = d.n.f(r126);     // Catch: Throwable -> L97
    L100:
        if (d.n.b(r127) == true) goto L103;
        r13 = r127;
    L103:
        r124.k((String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin"));
        x r128 = x.f38692a;
        return r27.a(a((com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(a((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r124, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin"), r12), com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin"), r12));
    L94:
        r126 = null;
    L97:
        th = move-exception;
        d.n.a r43 = d.n.f38560a;
        r127 = d.n.f(d.o.a(th));
        goto L100
    L89:
        Loog.INSTANCE.e(TAG, " - failed to parse openApp, use default value `false`");
        Boolean r44 = false;
        r41 = r44.booleanValue();
        goto L90
    L78:
        r38 = null;
    L81:
        th = move-exception;
        d.n.a r45 = d.n.f38560a;
        r39 = d.n.f(d.o.a(th));
        goto L84
    L73:
        Loog.INSTANCE.e(TAG, " - failed to parse modelSuccess, use default value `true`");
        Boolean r46 = true;
        r35 = r46.booleanValue();
        goto L74
    L62:
        r32 = null;
    L65:
        th = move-exception;
        d.n.a r47 = d.n.f38560a;
        r33 = d.n.f(d.o.a(th));
        goto L68
    L57:
        r29 = null;
        goto L58
    L106:
        if (r10.equals("run_script_by_ability") == false) goto L154;
        IJSScriptService r48 = (IJSScriptService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJSScriptService.class), IJSScriptService.class, "com.obric.aiagent.plugin");
        if (r48 != null) goto L111;
    L113:
        Object[] r49 = false;
    L114:
        if (r49 == true) goto L116;
        Loog.INSTANCE.e(TAG, "should not reach here");
        goto L154
    L116:
        return com.obric.autogui.agents.vlm.models.impl.d.e.f27780a.a().a(r9, r11, r12, (com.obric.autogui.agents.vlm.models.impl.d.a) ZeusTransformUtils.preCheckCast(new C0692f(this), com.obric.autogui.agents.vlm.models.impl.d.a.class, "com.obric.aiagent.plugin"));
    L111:
        if (r48.isScriptEnable() != true) goto L113;
        r49 = true;
        goto L114
    L119:
        if (r10.equals("call_user") == false) goto L154;
        com.obric.autogui.common.d.a r50 = com.obric.autogui.common.d.f29012a;
        com.obric.autogui.agents.vlm.models.impl.h r129 = new com.obric.autogui.agents.vlm.models.impl.h();
        JsonElement r51 = r11.get(0);
        if (r51 == null) goto L124;
        String r52 = r51.getAsString();
    L125:
        r129.j(r52);
        d.n.a r53 = d.n.f38560a;     // Catch: Throwable -> L132
        JsonElement r54 = r11.get(1);     // Catch: Throwable -> L132
        if (r54 == null) goto L129;
        String r55 = r54.getAsString();     // Catch: Throwable -> L132
    L130:
        Object r56 = d.n.f(r55);     // Catch: Throwable -> L132
    L135:
        if (d.n.b(r56) == false) goto L137;
        r56 = null;
    L137:
        r129.k((String) ZeusTransformUtils.preCheckCast(r56, String.class, "com.obric.aiagent.plugin"));
        d.n.a r57 = d.n.f38560a;     // Catch: Throwable -> L144
        JsonElement r130 = r11.get(2);     // Catch: Throwable -> L144
        if (r130 == null) goto L141;
        String r131 = r130.getAsString();     // Catch: Throwable -> L144
    L142:
        Object r132 = d.n.f(r131);     // Catch: Throwable -> L144
    L147:
        if (d.n.b(r132) == false) goto L149;
        r132 = null;
    L149:
        r129.l((String) ZeusTransformUtils.preCheckCast(r132, String.class, "com.obric.aiagent.plugin"));
        JsonElement r133 = r12.get("security_level");
        if (r133 == null) goto L152;
        r14 = r133.getAsString();
    L152:
        r129.m(r14);
        x r134 = x.f38692a;
        return r50.a(a((com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(a((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r129, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin"), r12), com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin"), r12));
    L141:
        r131 = null;
    L144:
        th = move-exception;
        d.n.a r58 = d.n.f38560a;
        r132 = d.n.f(d.o.a(th));
        goto L147
    L129:
        r55 = null;
    L132:
        th = move-exception;
        d.n.a r59 = d.n.f38560a;
        r56 = d.n.f(d.o.a(th));
        goto L135
    L124:
        r52 = null;
        goto L125
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.autogui.agents.vlm.models.impl.d.a
    public com.obric.autogui.common.d<b> a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r28, String r29, JsonArray r30) {
        o.e(r28, "inferenceContext");
        o.e(r29, "acType");
        o.e(r30, "acParam");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r28.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        k r4 = r28.a().c();
        if (r4 == null) goto L173;
        boolean r15 = true;
        int r13 = 0;
        switch(r29.hashCode()) {
            case -774747152: goto L149;
            case -504325460: goto L132;
            case -326696768: goto L107;
            case 3575610: goto L64;
            case 3641717: goto L50;
            case 94750088: goto L46;
            case 106931267: goto L30;
            case 109854522: goto L16;
            case 1002921482: goto L11;
            case 1374143386: goto L8;
            default: goto L6;
        };
    L6:
        String r5 = r29;
        Collection r14 = null;
    L166:
        String r0 = r14;
    L167:
        if (r14 != null) goto L171;
        return com.obric.autogui.common.d.f29012a.a("as per the current configuration, the action `" + r5 + "` is not supported.");
    L171:
        return com.obric.autogui.common.d.f29012a.a(new b(r14, r0));
    L107:
        r5 = r29;
        r14 = null;
        if (r5.equals("long_press") == false) goto L166;
    L110:
        com.obric.autogui.operator.e.C0780e r1 = b(r5, r30);
        if (r1 == null) goto L113;
        r14 = (Collection) ZeusTransformUtils.preCheckCast(p.a(r1), Collection.class, "com.obric.aiagent.plugin");
        int r2 = r29.hashCode();
        if (r2 == (-326696768)) goto L127;
        if (r2 == 94750088) goto L124;
        if (r2 != 1374143386) goto L131;
        if (r5.equals("double_click") == false) goto L131;
        int r6 = ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_double_click, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_desc_string_double_click");
    L129:
        r0 = r3.getString(r6);
    L131:
        throw new IllegalStateException("Unexpected action name: " + r5);
    L124:
        if (r5.equals("click") == false) goto L131;
        r6 = ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_click, r14, "agent_action_desc_string_click");
        goto L129
    L127:
        if (r5.equals("long_press") == false) goto L131;
        r6 = ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_long_click, r14, "agent_action_desc_string_long_click");
        goto L129
    L113:
        return com.obric.autogui.common.d.f29012a.a("cannot perform click with given param.");
    L132:
        r5 = r29;
        r14 = null;
        if (r5.equals("open_app") == false) goto L166;
        String r7 = r30.get(0).getAsString();
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L142
        JsonPrimitive r9 = r30.get(1).getAsJsonPrimitive();     // Catch: Throwable -> L142
        if (r9.isString() == false) goto L139;
        String r10 = r9.getAsString();     // Catch: Throwable -> L142
        o.c(r10, "getAsString(...)");     // Catch: Throwable -> L142
        String r11 = r10.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L142
        o.c(r11, "toLowerCase(...)");     // Catch: Throwable -> L142
        boolean r12 = Boolean.parseBoolean(r11);     // Catch: Throwable -> L142
    L140:
        Object r16 = d.n.f(Boolean.valueOf(r12));     // Catch: Throwable -> L142
    L145:
        if (d.n.c(r16) == null) goto L148;
        Loog.INSTANCE.w(TAG, " - cannot parse `restart` of method `open_app`; using default value `false`");
        r16 = false;
    L148:
        r14 = (Collection) ZeusTransformUtils.preCheckCast(p.a(new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.f29869a, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.a.a.b(null, null, r7, null, null, false, new com.obric.autogui.operator.a.b.a.a.h(((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), false, false, 6, null), 59, null), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"))), Collection.class, "com.obric.aiagent.plugin");
        r0 = r3.getString(ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_open_app, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_desc_string_open_app"), new Object[]{r7});
        goto L167
    L139:
        r12 = r9.getAsBoolean();     // Catch: Throwable -> L142
    L142:
        th = move-exception;
        d.n.a r17 = d.n.f38560a;
        r16 = d.n.f(d.o.a(th));
        goto L145
    L149:
        r5 = r29;
        r14 = null;
        JsonArray r18 = null;
        if (r5.equals("browser_use") == false) goto L166;
        if (r30.size() == 1) goto L156;
        r15 = false;
    L156:
        if (r15 == false) goto L158;
        r18 = r30;
    L158:
        if (r18 == null) goto L165;
        JsonElement r19 = r18.get(0);
        if (r19 == null) goto L165;
        JsonObject r20 = a(r19);
        if (r20 == null) goto L165;
        r14 = (Collection) ZeusTransformUtils.preCheckCast(p.a(new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.i, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.a.e(r20, 0, 2, null), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"))), Collection.class, "com.obric.aiagent.plugin");
        r0 = "Browser_Use";
    L165:
        return com.obric.autogui.common.d.f29012a.a("browser_use requires one valid params object in action_args");
    L8:
        if (r29.equals("double_click") == false) goto L6;
    L48:
        r5 = r29;
        goto L110
    L11:
        if (r29.equals("get_memory") == false) goto L6;
        String r21 = r30.get(0).getAsString();
        com.obric.autogui.operator.b.EnumC0777b r22 = com.obric.autogui.operator.b.EnumC0777b.h;
        o.a(r21);
        String r23 = r30.get(1).getAsString();
        o.c(r23, "getAsString(...)");
        r14 = (Collection) ZeusTransformUtils.preCheckCast(p.a(new com.obric.autogui.operator.e.C0780e(r22, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.d.b(r21, r23), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"))), Collection.class, "com.obric.aiagent.plugin");
        String r24 = r3.getString(ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_get_memory, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_desc_string_get_memory"));
    L14:
        r5 = r29;
        r0 = r24;
        goto L167
    L16:
        if (r29.equals("swipe") == false) goto L6;
        String r25 = r30.get(0).getAsString();
        com.obric.autogui.operator.a.b.e.a[] r26 = com.obric.autogui.operator.a.b.e.a.values();
        int r27 = r26.length;
    L19:
        if (r13 >= r27) goto L24;
        com.obric.autogui.operator.a.b.e.a r31 = r26[r13];
        String r32 = r31.a();
        o.a(r25);
        if (r32.contentEquals((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L22;
        r13 = r13 + 1;
        goto L19
    L22:
        com.obric.autogui.operator.a.b.e.a r110 = r31;
    L25:
        if (r110 == null) goto L27;
        r14 = (Collection) ZeusTransformUtils.preCheckCast(p.a(new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.j, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.e.b(r110, null, null, 0, 0, 30, null), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"))), Collection.class, "com.obric.aiagent.plugin");
        r24 = r3.getString(ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_swipe, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_desc_string_swipe"));
        goto L14
    L27:
        return com.obric.autogui.common.d.f29012a.a("failed to parse direction type: " + r25);
    L24:
        r110 = null;
        goto L25
    L30:
        if (r29.equals("press") == false) goto L6;
        String r33 = r30.get(0).getAsString();
        d.n.a r34 = d.n.f38560a;     // Catch: Throwable -> L35
        o.a(r33);     // Catch: Throwable -> L35
        Object r35 = d.n.f(com.obric.autogui.operator.a.b.c.b.valueOf(r33));     // Catch: Throwable -> L35
    L38:
        if (d.n.b(r35) == false) goto L40;
        r35 = null;
    L40:
        com.obric.autogui.operator.a.b.c.b r36 = (com.obric.autogui.operator.a.b.c.b) ZeusTransformUtils.preCheckCast(r35, com.obric.autogui.operator.a.b.c.b.class, "com.obric.aiagent.plugin");
        if (r36 == null) goto L43;
        Collection r37 = (Collection) ZeusTransformUtils.preCheckCast(p.a(new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.g, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.c.C0765c(r36), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"))), Collection.class, "com.obric.aiagent.plugin");
        r5 = r29;
        r0 = r3.getString(ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_press, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_desc_string_press"), new Object[]{r3.getString(r36.a())});
        r14 = r37;
        goto L167
    L43:
        return com.obric.autogui.common.d.f29012a.a("failed to parse action type " + r33);
    L35:
        th = move-exception;
        d.n.a r38 = d.n.f38560a;
        r35 = d.n.f(d.o.a(th));
        goto L38
    L46:
        if (r29.equals("click") == true) goto L48;
    L50:
        if (r29.equals("wait") == false) goto L6;
        d.n.a r39 = d.n.f38560a;     // Catch: Throwable -> L54
        f r40 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        Object r41 = d.n.f(Integer.valueOf(r30.get(0).getAsInt()));     // Catch: Throwable -> L54
    L56:
        Integer r42 = r4.a().d();
        if (d.n.b(r41) == false) goto L59;
        r41 = r42;
    L59:
        int r43 = ((Number) ZeusTransformUtils.preCheckCast(r41, Number.class, "com.obric.aiagent.plugin")).intValue();
        List r44 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.e.C0780e r45 = a();
        if (r45 == null) goto L62;
        r44.add(r45);
        Loog.INSTANCE.d(TAG, " - [Wait] add restart app op");
    L62:
        r44.add(new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.f29872d, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.g.a(r43), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin")));
        r14 = (Collection) ZeusTransformUtils.preCheckCast(r44, Collection.class, "com.obric.aiagent.plugin");
        r24 = r3.getString(ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_wait, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_desc_string_wait"));
    L54:
        th = move-exception;
        d.n.a r46 = d.n.f38560a;
        r41 = d.n.f(d.o.a(th));
        goto L56
    L64:
        if (r29.equals("type") == false) goto L6;
        String r47 = r30.get(1).getAsString();
        com.obric.autogui.operator.e.C0780e r48 = b(r29, r30);
        if (r48 == null) goto L69;
        com.obric.autogui.operator.e.C0780e r49 = new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.f29873e, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.h.a(500, 50), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"));
    L174:
        d.n.a r50 = d.n.f38560a;     // Catch: Throwable -> L77
        JsonPrimitive r51 = r30.get(2).getAsJsonPrimitive();     // Catch: Throwable -> L77
        if (r51.isString() == false) goto L74;
        String r52 = r51.getAsString();     // Catch: Throwable -> L77
        o.c(r52, "getAsString(...)");     // Catch: Throwable -> L77
        String r53 = r52.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L77
        o.c(r53, "toLowerCase(...)");     // Catch: Throwable -> L77
        boolean r54 = Boolean.parseBoolean(r53);     // Catch: Throwable -> L77
    L75:
        Loog.INSTANCE.d(TAG, " - parse `isReplace`: `" + r51 + "` --> `" + r54 + '`');     // Catch: Throwable -> L77
        Object r55 = d.n.f(Boolean.valueOf(r54));     // Catch: Throwable -> L77
    L79:
        Throwable r56 = d.n.c(r55);
        if (r56 == null) goto L83;
        Loog.INSTANCE.w(TAG, " - cannot parse `isReplace` of method `type` (" + r56 + "); using default value `true`");
        r55 = true;
    L83:
        boolean r210 = ((Boolean) ZeusTransformUtils.preCheckCast(r55, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        o.a(r47);
        if (d.o.o.c(r47, "\n", false, 2, null) == false) goto L87;
        Loog.INSTANCE.d(TAG, " - [TypeText-Enter] need to press enter after typing (pure-\\n)");
        o.a(r47);
        r47 = r47.substring(0, r47.length() - 1);
        o.c(r47, "substring(...)");
    L86:
        boolean r57 = true;
    L91:
        com.obric.autogui.operator.b.EnumC0777b r58 = com.obric.autogui.operator.b.EnumC0777b.f;
        o.a(r47);
        com.obric.autogui.operator.a.b.f.b r59 = new com.obric.autogui.operator.a.b.f.b(false, r47, r210, 1, null);
        r59.a(false);
        com.obric.autogui.operator.e.C0780e r60 = new com.obric.autogui.operator.e.C0780e(r58, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(r59, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"));
        List r61 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        if (r48 == null) goto L96;
        r61.add(r48);
        r61.add(new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.f29872d, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.g.a(100), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin")));
        if (r49 == null) goto L96;
        r61.add(r49);
    L96:
        if (r57 == false) goto L101;
        com.obric.autogui.operator.e.C0780e r62 = new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.g, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.c.C0765c(com.obric.autogui.operator.a.b.c.b.f29640d), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"));
        o.a(r47);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r47, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L100;
        Loog.INSTANCE.d(TAG, " - [TypeText-Enter] pure-enter for OpTypeText");
        r61.add(r62);
    L102:
        r14 = (Collection) ZeusTransformUtils.preCheckCast(r61, Collection.class, "com.obric.aiagent.plugin");
        if (r47.length() <= 10) goto L105;
        String r63 = r3.getString(ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_type_long_text, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_desc_string_type_long_text"));
    L106:
        r5 = r29;
        r0 = r63;
        goto L167
    L105:
        r63 = r3.getString(ZeusTransformUtils.mapRes(R.string.agent_action_desc_string_type, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_action_desc_string_type"), new Object[]{r47});
        goto L106
    L100:
        r61.add(r60);
        r61.add(r62);
        goto L102
    L101:
        r61.add(r60);
        goto L102
    L87:
        o.a(r47);
        if (d.o.o.c(r47, "\\n", false, 2, null) == false) goto L90;
        Loog.INSTANCE.d(TAG, " - [TypeText-Enter] need to press enter after typing (literal-\\n)");
        o.a(r47);
        r47 = r47.substring(0, r47.length() - 2);
        o.c(r47, "substring(...)");
        goto L86
    L90:
        r57 = false;
        goto L91
    L74:
        r54 = r51.getAsBoolean();     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        d.n.a r64 = d.n.f38560a;
        r55 = d.n.f(d.o.a(th));
        goto L79
    L69:
        r49 = null;
        goto L174
    L173:
        throw new IllegalStateException("model config is null during genOpsFromResponse.");
    }

    private final com.obric.autogui.agents.vlm.models.impl.e a(JsonObject r4, b r5) {
        com.obric.autogui.agents.vlm.models.impl.e r3 = a((com.obric.autogui.agents.vlm.models.impl.e) ZeusTransformUtils.preCheckCast(a((com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.e(), com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin"), r4), com.obric.autogui.agents.vlm.models.impl.e.class, "com.obric.aiagent.plugin"), r4);
        r3.a(r5.a());
        r3.b(r5.b());
        return r3;
    }

    private final <T extends com.obric.autogui.agents.vlm.models.impl.e> T a(T r4, JsonObject r5) {
        JsonElement r3 = r5.get("action");
        JsonElement r0 = null;
        String r1 = "";
        if (r3 != null) goto L5;
    L11:
        String r6 = "";
    L12:
        r4.a(r6);
        JsonElement r7 = r5.get("action_type");
        if (r7 != null) goto L15;
    L21:
        String r8 = "";
    L22:
        r4.c(r8);
        JsonElement r9 = r5.get("action_grounding");
        if (r9 != null) goto L25;
    L32:
        r4.d(r1);
        return r4;
    L25:
        if (r9.isJsonPrimitive() == false) goto L27;
        r0 = r9;
    L27:
        if (r0 == null) goto L32;
        String r10 = r0.getAsString();
        if (r10 == null) goto L32;
        r1 = r10;
        goto L32
    L15:
        if (r7.isJsonPrimitive() == true) goto L18;
        r7 = null;
    L18:
        if (r7 == null) goto L21;
        r8 = r7.getAsString();
        if (r8 != null) goto L22;
    L5:
        if (r3.isJsonPrimitive() == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L11;
        r6 = r3.getAsString();
        if (r6 != null) goto L12;
        goto L11
    }

    private final <T extends com.obric.autogui.agents.vlm.models.impl.g> T a(T r8, JsonObject r9) {
        JsonElement r7 = r9.get("observation");
        String r0 = "";
        if (r7 == null) goto L6;
        String r10 = r7.getAsString();
        if (r10 == null) goto L6;
    L7:
        r8.e(r10);
        JsonElement r11 = r9.get(VDPlayerEffectProviderImpl.KEY_THOUGHT);
        if (r11 == null) goto L11;
        String r12 = r11.getAsString();
        if (r12 == null) goto L11;
    L12:
        r8.f(r12);
        JsonElement r13 = r9.get("summary");
        if (r13 == null) goto L16;
        String r14 = r13.getAsString();
        if (r14 == null) goto L16;
    L17:
        r8.g(r14);
        JsonElement r15 = r9.get("status");
        int r1 = 0;
        if (r15 == null) goto L20;
        int r16 = r15.getAsInt();
    L21:
        r8.a(r16);
        r8.a(r9);
        JsonObject r17 = null;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L33
        JsonElement r3 = r9.get("robots_msg");     // Catch: Throwable -> L33
        if (r3 != null) goto L25;
    L30:
        String r4 = null;
    L31:
        Object r5 = d.n.f(r4);     // Catch: Throwable -> L33
    L36:
        if (d.n.b(r5) == false) goto L38;
        r5 = null;
    L38:
        r8.h((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"));
        JsonElement r6 = r9.get("step_index");
        if (r6 == null) goto L41;
        int r18 = r6.getAsInt();
    L42:
        r8.c(r18);
        com.obric.autogui.operator.e r19 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        JsonElement r20 = r9.get("step_id");
        if (r20 == null) goto L48;
        String r21 = r20.getAsString();
        if (r21 == null) goto L48;
        r0 = r21;
    L48:
        r19.n(r0);
        JsonElement r22 = r9.get("server_time");
        long r23 = 0;
        if (r22 == null) goto L51;
        long r24 = r22.getAsLong();
    L52:
        r8.b(r24);
        JsonElement r25 = r9.get("inference_time");
        if (r25 == null) goto L55;
        r23 = r25.getAsLong();
    L55:
        r8.c(r23);
        d.n.a r26 = d.n.f38560a;     // Catch: Throwable -> L74
        JsonElement r27 = r9.get("usage_tokens");     // Catch: Throwable -> L74
        if (r27 == null) goto L59;
        r17 = r27.getAsJsonObject();     // Catch: Throwable -> L74
    L59:
        if (r17 == null) goto L72;
        com.obric.autogui.agents.vlm.models.impl.g.b r28 = r8.m();     // Catch: Throwable -> L74
        JsonElement r29 = r17.get("completion_tokens");     // Catch: Throwable -> L74
        if (r29 == null) goto L63;
        int r30 = r29.getAsInt();     // Catch: Throwable -> L74
    L64:
        r28.a(r30);     // Catch: Throwable -> L74
        com.obric.autogui.agents.vlm.models.impl.g.b r31 = r8.m();     // Catch: Throwable -> L74
        JsonElement r32 = r17.get("prompt_tokens");     // Catch: Throwable -> L74
        if (r32 == null) goto L67;
        int r33 = r32.getAsInt();     // Catch: Throwable -> L74
    L68:
        r31.b(r33);     // Catch: Throwable -> L74
        com.obric.autogui.agents.vlm.models.impl.g.b r34 = r8.m();     // Catch: Throwable -> L74
        JsonElement r35 = r17.get("total_tokens");     // Catch: Throwable -> L74
        if (r35 == null) goto L71;
        r1 = r35.getAsInt();     // Catch: Throwable -> L74
    L71:
        r34.c(r1);     // Catch: Throwable -> L74
        goto L72
    L67:
        r33 = 0;
        goto L68
    L63:
        r30 = 0;
    L72:
        d.n.f(x.f38692a);     // Catch: Throwable -> L74
    L76:
        r8.y().a(r8.j());
        r8.y().b(r8.k());
        ((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin")).a_(r8.i());
        return r8;
    L74:
        th = move-exception;
        d.n.a r36 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L76
    L51:
        r24 = 0;
        goto L52
    L41:
        r18 = 0;
        goto L42
    L25:
        if (r3.isJsonPrimitive() == true) goto L28;
        r3 = null;
    L28:
        if (r3 == null) goto L30;
        r4 = r3.getAsString();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        d.n.a r37 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L36
    L20:
        r16 = 0;
    L16:
        r14 = "";
    L11:
        r12 = "";
    L6:
        r10 = "";
        goto L7
    }

    public List<PointF> a(String r2, JsonArray r3) {
        o.e(r2, "acName");
        o.e(r3, "opParam");
        PointF r1 = c(r3);
        if (r1 == null) goto L7;
        ArrayList r0 = new ArrayList(2);
        r0.add(r1);
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L7:
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(2), List.class, "com.obric.aiagent.plugin");
    }

    public PointF a(JsonArray r4) {
        o.e(r4, "opParam");
        PointF r3 = c(r4);
        if (r3 != null) goto L6;
        return null;
    L6:
        return AODeviceSpecificTools.denormaliseOperatingSpacePosition$default(AODeviceSpecificTools.INSTANCE, r3, false, 2, null);
    }

    private final PointF c(JsonArray r4) {
        if (r4.size() >= 1) goto L20;
        return null;
    L20:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        Object r5 = d.n.f(r4.get(0).getAsJsonArray());     // Catch: Throwable -> L7
    L10:
        if (d.n.b(r5) == false) goto L12;
        r5 = null;
    L12:
        JsonArray r6 = (JsonArray) ZeusTransformUtils.preCheckCast(r5, JsonArray.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L16;
        return null;
    L16:
        if (r6.isEmpty() == false) goto L19;
        return null;
    L19:
        return b(r6);
    L7:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L10
    }

    public final PointF b(JsonArray r2) {
        o.e(r2, "position");
        return new PointF(r2.get(0).getAsNumber().floatValue(), r2.get(1).getAsNumber().floatValue());
    }

    private final com.obric.autogui.operator.e.C0780e b(String r7, JsonArray r8) {
        PointF r6 = a(r8);
        if (r6 != null) goto L5;
        return null;
    L5:
        int r3 = -1;
        if (o.a(r7, "long_press") == true) goto L8;
    L28:
        com.obric.autogui.operator.b.EnumC0777b r9 = com.obric.autogui.operator.b.EnumC0777b.f29870b;
        com.obric.autogui.operator.a.b.b.a r1 = new com.obric.autogui.operator.a.b.b.a(0, 0, 3, null);
        com.obric.autogui.operator.a.a.e r0 = r1.b();
        com.obric.autogui.operator.a.a.f r4 = new com.obric.autogui.operator.a.a.f();
        r4.a(r6.x);
        r4.b(r6.y);
        r0.a(r4);
        if (r3 <= 0) goto L32;
        r1.a(r3);
    L32:
        if (o.a(r7, "double_click") == false) goto L35;
        r1.b(2);
    L35:
        return new com.obric.autogui.operator.e.C0780e(r9, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"));
    L8:
        if (r8.size() <= 1) goto L28;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L22
        JsonElement r10 = r8.get(1);     // Catch: Throwable -> L22
        if (r10.isJsonPrimitive() == false) goto L19;
        JsonPrimitive r11 = r10.getAsJsonPrimitive();     // Catch: Throwable -> L22
        if (r11.isNumber() == false) goto L15;
        int r12 = r11.getAsInt();     // Catch: Throwable -> L22
    L20:
        Object r13 = d.n.f(Integer.valueOf(r12));     // Catch: Throwable -> L22
    L25:
        if (d.n.b(r13) == false) goto L27;
        r13 = -1;
    L27:
        r3 = ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).intValue();
        goto L28
    L15:
        if (r11.isString() == false) goto L19;
        String r14 = r11.getAsString();     // Catch: Throwable -> L22
        o.c(r14, "getAsString(...)");     // Catch: Throwable -> L22
        Integer r15 = d.o.o.d(r14);     // Catch: Throwable -> L22
        if (r15 == null) goto L19;
        r12 = r15.intValue();     // Catch: Throwable -> L22
    L19:
        r12 = -1;
    L22:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        r13 = d.n.f(d.o.a(th));
        goto L25
    }

    private final com.obric.autogui.operator.e.C0780e a() {
        if (com.obric.autogui.common.a.d.f28974a.S() == true) goto L5;
        return null;
    L5:
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 == null) goto L74;
        List<com.obric.autogui.operator.e> r1 = r0.p();
        if (r1 == null) goto L74;
        if (r1.size() >= 2) goto L13;
        return null;
    L13:
        int r2 = r1.size() - 1;
        com.obric.autogui.operator.e.C0780e r4 = null;
    L14:
        boolean r5 = false;
        if (r2 < 0) goto L34;
        if ((!((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r1.get(r2), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin")).Q().isEmpty()) == false) goto L34;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r1.get(r2), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin")).Q(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L21;
    L23:
        Iterator r8 = r7.iterator();
    L25:
        if (r8.hasNext() == false) goto L22;
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f29872d) goto L29;
        boolean r9 = true;
    L30:
        if (r9 == true) goto L25;
        boolean r10 = false;
    L32:
        if (r10 == false) goto L34;
        r4 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r1.get(r2), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin")).Q(), Iterable.class, "com.obric.aiagent.plugin")), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        r2 = r2 - 1;
        goto L14
    L29:
        r9 = false;
    L22:
        r10 = true;
        goto L32
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L23;
    L34:
        if (r2 >= 0) goto L36;
        return null;
    L36:
        com.obric.autogui.operator.e r3 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r1.get(r2), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r3.Q(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L39;
    L41:
        Iterator r11 = r6.iterator();
    L43:
        if (r11.hasNext() == false) goto L50;
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L47;
        boolean r12 = true;
    L48:
        if (r12 == false) goto L43;
        r5 = true;
        goto L50
    L47:
        r12 = false;
    L50:
        if (r5 == true) goto L52;
        return null;
    L52:
        Iterator r13 = p.l((Iterable) ZeusTransformUtils.preCheckCast(r3.Q(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r13.hasNext() == false) goto L57;
        com.obric.autogui.operator.e.C0780e r14 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (e.f27793a[r14.a().ordinal()] != 1) goto L57;
    L58:
        if (r14 == null) goto L74;
        if (r4 == null) goto L74;
        IAutoActionAgentEventListener.AgentStepInfo r15 = r3.T();
        if (r15 == null) goto L74;
        if ((AOSystemTools.INSTANCE.nowTimeMillis() - r15.getFinishTimeMills()) >= com.obric.autogui.common.a.d.f28974a.M()) goto L66;
        return null;
    L66:
        com.obric.autogui.operator.b.a r16 = r14.b();
        if (ZeusTransformUtils.instanceOf(r16, com.obric.autogui.operator.a.b.a.a.b.class) == false) goto L69;
        com.obric.autogui.operator.a.b.a.a.b r17 = (com.obric.autogui.operator.a.b.a.a.b) ZeusTransformUtils.preCheckCast(r16, com.obric.autogui.operator.a.b.a.a.b.class, "com.obric.aiagent.plugin");
    L70:
        if (r17 != null) goto L73;
        return null;
    L73:
        return new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.f29869a, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(com.obric.autogui.operator.a.b.a.a.b.a(r17, null, null, null, null, null, false, new com.obric.autogui.operator.a.b.a.a.h(true, true, true), 63, null), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"));
    L69:
        r17 = null;
    L57:
        r14 = null;
        goto L58
    L39:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L41;
    L74:
        return null;
    }

    private final JsonObject a(JsonElement r7) {
        boolean r2 = false;
        if (r7.isJsonPrimitive() == true) goto L5;
    L7:
        boolean r1 = false;
    L52:
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L17
        f r6 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r7.isJsonObject() == false) goto L12;
        JsonObject r8 = r7.getAsJsonObject();     // Catch: Throwable -> L17
    L15:
        Object r9 = d.n.f(r8);     // Catch: Throwable -> L17
    L20:
        if (d.n.b(r9) == false) goto L22;
        r9 = null;
    L22:
        JsonObject r10 = (JsonObject) ZeusTransformUtils.preCheckCast(r9, JsonObject.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L54;
        JsonElement r11 = r10.get("action");
        if (r11 != null) goto L27;
    L37:
        String r12 = null;
    L38:
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L41;
    L42:
        r2 = true;
    L44:
        if ((!r2) == true) goto L47;
        r10 = null;
    L47:
        if (r10 == null) goto L55;
        if (r1 == false) goto L51;
        Loog.INSTANCE.w(TAG, "decoded malformed BrowserUse action_args string element");
    L51:
        return r10;
    L55:
        return null;
    L41:
        if (d.o.o.d(r13) == false) goto L44;
    L27:
        if (r11.isJsonPrimitive() == true) goto L29;
    L31:
        boolean r14 = false;
    L32:
        if (r14 == true) goto L35;
        r11 = null;
    L35:
        if (r11 == null) goto L37;
        r12 = r11.getAsString();
        goto L38
    L29:
        if (r11.getAsJsonPrimitive().isString() == false) goto L31;
        r14 = true;
        goto L32
    L54:
        return null;
    L12:
        if (r1 == false) goto L14;
        r8 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r7.getAsString(), JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        goto L15
    L14:
        r8 = null;
    L17:
        th = move-exception;
        d.n.a r15 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L20
    L5:
        if (r7.getAsJsonPrimitive().isString() == false) goto L7;
        r1 = true;
        goto L52
    }
}
