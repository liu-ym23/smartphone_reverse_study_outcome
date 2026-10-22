package com.obric.autogui.session.state.a;

import android.graphics.Bitmap;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.Gson;
import com.obric.autogui.agents.vlm.models.omni.ac;
import com.obric.autogui.agents.vlm.models.omni.w;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.model.CallUserFunctionParams;
import com.obric.autogui.common.api.agent.model.ClarifyFunctionParams;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StatePaused.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends com.obric.autogui.session.state.a implements com.obric.autogui.agents.vlm.models.omni.intent.e, c, d {
    private static final String TAG = "S-PAUSED";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f31246b = null;

    /* JADX INFO: compiled from: StatePaused.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StatePaused.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f31247a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f31248b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f31249c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f31250d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f31251e = null;
        private static final /* synthetic */ b[] g = null;
        private static final /* synthetic */ d.d.a h = null;
        private final int f;

        private static final /* synthetic */ b[] b() {
            return new b[]{f31247a, f31248b, f31249c, f31250d, f31251e};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f = r3;
        }

        public final int a() {
            return this.f;
        }

        static {
            f31247a = new b("UNKNOWN", 0, 0);
            f31248b = new b("ENTERED_CALL_USER", 1, BizStatus.StatusChangedReason.PAUSED__ENTERED_CALL_USER);
            f31249c = new b("STARTED_USER_ADDITION", 2, 1201);
            f31250d = new b("ENTERED_CLARIFY", 3, BizStatus.StatusChangedReason.PAUSED__STARTED_USER_CLARIFY);
            f31251e = new b("STARTED_MANUAL_OPERATION", 4, BizStatus.StatusChangedReason.PAUSED__STARTED_MANUAL_OPERATING);
            b[] r0 = b();
            g = r0;
            h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(g.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f31246b = new a(null);
    }

    public i(com.obric.autogui.session.state.b r9, com.obric.autogui.session.a r10) {
        d.h.b.o.e(r9, "machine");
        d.h.b.o.e(r10, SensitiveType.SESSION);
        super(BizStatus.PAUSED, r10, r9, false, 8, null);
    }

    @Override // com.obric.autogui.session.state.a
    public Object a(com.obric.autogui.session.state.a r8, d.c.d<? super com.obric.autogui.common.e> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r8, this) == true) goto L6;
        a(new BizStatus.StatusChangedReasonStruct(0, null, null, null, 14, null));
    L6:
        return com.obric.autogui.common.e.f29014b.a();
    }

    @Override // com.obric.autogui.session.state.a, com.obric.autogui.util.c.a, com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r4) {
        com.obric.autogui.util.c.b r5 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "fromState");
        super.b(r5);
        com.obric.autogui.util.h.f31557a.b(d(), "paused");
        com.obric.autogui.agents.b.f26789a.a().a();
        String r6 = d().v();
        if (r6 == null) goto L5;
        Loog.INSTANCE.w(TAG, " - suspended step-generation tracking [step/" + r6 + ']');
    L5:
        d().b(null);
        com.obric.autogui.agents.b.f26789a.a().b(d());
        d().j();
        l();
    }

    @Override // com.obric.autogui.session.state.a
    public int g() {
        Loog.INSTANCE.i(TAG, " - [pause] pausedReason = " + f());
        return f().getReason();
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.intent.e
    public IntentResult<Bitmap> a() {
        int r0 = f().getReason();
        if (r0 != b.f31248b.a()) goto L6;
        return j();
    L6:
        if (r0 != b.f31250d.a()) goto L9;
        return k();
    L9:
        if (r0 != b.f31249c.a()) goto L12;
        return com.obric.autogui.agents.vlm.models.omni.intent.d.a(com.obric.autogui.agents.vlm.models.omni.intent.c.m, null, 1, null);
    L12:
        if (r0 != b.f31251e.a()) goto L15;
        return com.obric.autogui.agents.vlm.models.omni.intent.d.a(com.obric.autogui.agents.vlm.models.omni.intent.c.o, null, 1, null);
    L15:
        return com.obric.autogui.agents.vlm.models.omni.intent.d.a(com.obric.autogui.agents.vlm.models.omni.intent.c.k, null, 1, null);
    }

    private final IntentResult<Bitmap> j() {
        com.obric.autogui.session.functions.impl.b r6 = (com.obric.autogui.session.functions.impl.b) ZeusTransformUtils.preCheckCast(d().n().a(com.obric.autogui.session.functions.impl.b.class), com.obric.autogui.session.functions.impl.b.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L5;
        CallUserFunctionParams r7 = r6.f();
    L6:
        com.obric.autogui.agents.vlm.models.omni.intent.c r0 = com.obric.autogui.agents.vlm.models.omni.intent.c.l;
        d.m[] r1 = new d.m[2];
        String r3 = "";
        if (r7 == null) goto L10;
        String r4 = r7.getContent();
        if (r4 == null) goto L10;
    L11:
        r1[0] = s.a("content", r4);
        if (r7 == null) goto L17;
        String r8 = r7.getAction();
        if (r8 == null) goto L17;
        r3 = r8;
    L17:
        r1[1] = s.a("action", r3);
        return com.obric.autogui.agents.vlm.models.omni.intent.d.a(r0, ao.a(r1));
    L10:
        r4 = "";
        goto L11
    L5:
        r7 = null;
        goto L6
    }

    private final IntentResult<Bitmap> k() {
        Object r6 = f().getObj();
        List<String> r1 = null;
        if (ZeusTransformUtils.instanceOf(r6, ClarifyFunctionParams.class) == false) goto L5;
        ClarifyFunctionParams r7 = (ClarifyFunctionParams) ZeusTransformUtils.preCheckCast(r6, ClarifyFunctionParams.class, "com.obric.aiagent.plugin");
    L6:
        com.obric.autogui.agents.vlm.models.omni.intent.c r0 = com.obric.autogui.agents.vlm.models.omni.intent.c.n;
        d.m[] r2 = new d.m[2];
        if (r7 == null) goto L10;
        String r4 = r7.getContent();
        if (r4 == null) goto L10;
    L11:
        r2[0] = s.a("content", r4);
        Gson r5 = com.obric.capabilitykit.common.a.a();
        if (r7 == null) goto L14;
        r1 = r7.getOptions();
    L14:
        r2[1] = s.a("options", r5.toJson(r1));
        return com.obric.autogui.agents.vlm.models.omni.intent.d.a(r0, ao.a(r2));
    L10:
        r4 = "";
        goto L11
    L5:
        r7 = null;
        goto L6
    }

    private final void l() {
        if (w.f28887a.a(d().l().getTaskExtras()) == true) goto L5;
        return;
    L5:
        int r0 = f().getReason();
        String r2 = null;
        if (r0 != b.f31248b.a()) goto L13;
        com.obric.autogui.session.functions.impl.b r1 = (com.obric.autogui.session.functions.impl.b) ZeusTransformUtils.preCheckCast(d().n().a(com.obric.autogui.session.functions.impl.b.class), com.obric.autogui.session.functions.impl.b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L15;
        CallUserFunctionParams r3 = r1.f();
        if (r3 == null) goto L15;
        r2 = r3.getReason();
    L15:
        ac r4 = w.f28887a.a(f().getReason(), r2);
        com.obric.autogui.session.state.termination.a.a(d().J(), null, r4.a(), null, ao.a(r4.b(), m()), 5, null);
        return;
    L13:
        if (r0 != b.f31250d.a()) goto L15;
        r2 = f().getMsg();
        goto L15
    }

    private final Map<String, String> m() {
        if (f().getReason() != b.f31250d.a()) goto L5;
        Map<String, Object> r6 = f().getExtra();
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<String, Object>> r7 = r6.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L18;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        Object r2 = r1.getValue();
        d.m r5 = null;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L12;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L13:
        if (r4 == null) goto L15;
        r5 = s.a(r3, r4);
    L15:
        if (r5 == null) goto L8;
        r0.add(r5);
        goto L8
    L12:
        r4 = null;
        goto L13
    L18:
        return ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L5:
        return ao.b();
    }
}
