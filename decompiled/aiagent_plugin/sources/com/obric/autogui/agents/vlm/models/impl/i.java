package com.obric.autogui.agents.vlm.models.impl;

import android.os.Bundle;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.agent.model.ClarifyFunctionParams;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StandardModelClarifyStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public class i extends e implements com.obric.autogui.agents.vlm.models.a.b {
    private static final String TAG = "M-Std-Step/Clarify";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f27924c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f27925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f27926e;
    private List<Boolean> g;
    private Map<Integer, String> h;
    private String i;
    private final String j;
    private final Map<String, String> k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;

    /* JADX INFO: compiled from: StandardModelClarifyStep.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StandardModelClarifyStep.kt */
    @d.c.b.a.f(b = "StandardModelClarifyStep.kt", c = {48}, d = "executeStep$suspendImpl", e = "com.obric.autogui.agents.vlm.models.impl.StandardModelClarifyStep")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f27927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f27928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27929c;

        b(i r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27928b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27927a = r3;
            this.f27929c |= Integer.MIN_VALUE;
            return i.a(this.f27928b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModelClarifyStep.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.m<com.obric.autogui.session.a, String, Boolean> {
        c(Object r8) {
            super(2, r8, i.class, "onClarifyText", "onClarifyText(Lcom/obric/autogui/session/AOSession;Ljava/lang/String;)Z", 0);
        }

        public final Boolean a(com.obric.autogui.session.a r3, String r4) {
            d.h.b.o.e(r3, "p0");
            d.h.b.o.e(r4, "p1");
            return Boolean.valueOf(((i) ZeusTransformUtils.preCheckCast(this.receiver, i.class, "com.obric.aiagent.plugin")).a(r3, r4));
        }

        @Override // d.h.a.m
        public /* synthetic */ Boolean invoke(com.obric.autogui.session.a r3, String r4) {
            return a((com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f27924c = new a(null);
    }

    public static /* synthetic */ x lambda$AkAXBbmZ3AjV4ZlSCrqoyLF2VK0(i r0, com.obric.autogui.session.functions.impl.c r1) {
        return a(r0, r1);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g
    public Object a(com.obric.autogui.session.a r3, d.c.d<? super com.obric.autogui.operator.g> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public boolean a(com.obric.autogui.session.a r1, String r2) {
        d.h.b.o.e(r1, SensitiveType.SESSION);
        d.h.b.o.e(r2, "text");
        return true;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.a.b
    public String d() {
        return "clarify";
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public boolean h() {
        return false;
    }

    public i() {
        this.j = "model_request";
        this.k = ao.b();
        this.l = -1;
        this.m = -2;
        this.n = -3;
        this.o = 1;
        this.p = -1;
        this.q = -2;
    }

    public final String E() {
        return this.f27925d;
    }

    public final void j(String r1) {
        this.f27925d = r1;
    }

    public final List<String> F() {
        return this.f27926e;
    }

    public final void a(List<String> r3) {
        this.f27926e = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void b(List<Boolean> r3) {
        this.g = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void a(Map<Integer, String> r3) {
        this.h = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final void k(String r1) {
        this.i = r1;
    }

    public String G() {
        return this.j;
    }

    public Map<String, String> H() {
        return this.k;
    }

    static /* synthetic */ Object a(final i r6, com.obric.autogui.session.a r7, d.c.d<? super com.obric.autogui.operator.g> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if ((r0.f27929c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27929c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f27927a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27929c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r10);
    L21:
        return new com.obric.autogui.operator.o((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin"), true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L17;
        Loog.INSTANCE.i(TAG, "[clarify] - content=" + r6.f27925d);
    L17:
        com.obric.autogui.session.functions.c r11 = r7.n();
        d.h.a.b r4 = new $$Lambda$i$AkAXBbmZ3AjV4ZlSCrqoyLF2VK0(r6);
        r0.f27929c = 1;
        r10 = r11.a(com.obric.autogui.session.functions.impl.c.class, r4, r0);
        if (r10 != r2) goto L21;
        return r2;
    L7:
        r0 = new b(r6, r9);
        goto L8
    }

    private static final x a(i r7, com.obric.autogui.session.functions.impl.c r8) {
        d.h.b.o.e(r8, "$this$attachFunction");
        r8.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r7), d.h.a.m.class, "com.obric.aiagent.plugin"));
        r7.a(r8);
        r8.b(r7.G());
        r8.a(r7.H());
        r8.a(new ClarifyFunctionParams(r7.f27925d, r7.f27926e, r7.g, r7.i, r7.h));
        return x.f38692a;
    }

    public void a(com.obric.autogui.session.functions.impl.c r2) {
        d.h.b.o.e(r2, "clarifyFunction");
        b(r2);
    }

    private final void b(com.obric.autogui.session.functions.impl.c r18) {
        List<String> r1 = this.f27926e;
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin");
        int r5 = 0;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        ((Map) ZeusTransformUtils.preCheckCast(r18.e(), Map.class, "com.obric.aiagent.plugin")).put("gui_clarify_status", Integer.valueOf(this.p));
        return;
    L13:
        ((Map) ZeusTransformUtils.preCheckCast(r18.e(), Map.class, "com.obric.aiagent.plugin")).put("gui_clarify_options", d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
        if (r1.size() >= 2) goto L17;
        ((Map) ZeusTransformUtils.preCheckCast(r18.e(), Map.class, "com.obric.aiagent.plugin")).put("gui_clarify_skip_reason", Integer.valueOf(this.n));
        ((Map) ZeusTransformUtils.preCheckCast(r18.e(), Map.class, "com.obric.aiagent.plugin")).put("gui_clarify_status", Integer.valueOf(this.q));
        return;
    L17:
        if (r1.size() <= 2) goto L19;
        ((Map) ZeusTransformUtils.preCheckCast(r18.e(), Map.class, "com.obric.aiagent.plugin")).put("gui_clarify_skip_reason", Integer.valueOf(this.l));
        ((Map) ZeusTransformUtils.preCheckCast(r18.e(), Map.class, "com.obric.aiagent.plugin")).put("gui_clarify_status", Integer.valueOf(this.q));
        return;
    L19:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L22;
    L24:
        Iterator r6 = r4.iterator();
        int r7 = 0;
    L26:
        if (r6.hasNext() == false) goto L45;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L30;
        boolean r10 = true;
    L31:
        if (r10 == false) goto L40;
        int r11 = r9.length();
        if (2 <= r11) goto L35;
    L37:
        boolean r12 = false;
    L38:
        if (r12 == false) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == false) goto L26;
        r7 = r7 + 1;
        if (r7 >= 0) goto L26;
        d.a.p.d();
        goto L26
    L35:
        if (r11 >= 6) goto L37;
        r12 = true;
    L40:
        r13 = false;
        goto L41
    L30:
        r10 = false;
        goto L31
    L45:
        r5 = r7;
    L46:
        if (r5 == 2) goto L48;
        ((Map) ZeusTransformUtils.preCheckCast(r18.e(), Map.class, "com.obric.aiagent.plugin")).put("gui_clarify_skip_reason", Integer.valueOf(this.m));
        ((Map) ZeusTransformUtils.preCheckCast(r18.e(), Map.class, "com.obric.aiagent.plugin")).put("gui_clarify_status", Integer.valueOf(this.q));
        return;
    L48:
        ((Map) ZeusTransformUtils.preCheckCast(r18.e(), Map.class, "com.obric.aiagent.plugin")).put("gui_clarify_status", Integer.valueOf(this.o));
        return;
    L22:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L24;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L10
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public com.obric.autogui.agents.vlm.models.a.d.b C() {
        return com.obric.autogui.agents.vlm.models.a.d.b.f27245d;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.a.b
    public String e() {
        String r0 = this.f27925d;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public Bundle g() {
        Bundle r0 = super.g();
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        List<String> r1 = this.f27926e;
        boolean[] r2 = null;
        if (r1 == null) goto L8;
        String[] r3 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
    L9:
        r0.putStringArray("clarify_options", r3);
        List<Boolean> r5 = this.g;
        if (r5 == null) goto L12;
        r2 = d.a.p.b((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
    L12:
        r0.putBooleanArray("clarify_positiveness", r2);
        return r0;
    L8:
        r3 = null;
        goto L9
    }
}
