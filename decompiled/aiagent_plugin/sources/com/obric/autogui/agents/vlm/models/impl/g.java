package com.obric.autogui.agents.vlm.models.impl;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.autoaction.presentation.SurfaceCardActivity;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.obric.capabilitykit.entity.ResultCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.au;
import org.json.JSONObject;

/* JADX INFO: compiled from: StandardModelBaseStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public class g extends com.obric.autogui.operator.e implements com.obric.autogui.agents.vlm.models.a.c, com.obric.autogui.agents.vlm.models.a.d {
    private static final String TAG = "M-Std-Step/B";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f27904b = null;
    private final c A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27905a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f27906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f27907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f27908e;
    private byte[] g;
    private long h;
    private long i;
    private int j;
    private String k;
    private boolean l;
    private int m;
    private JsonObject n;
    private final List<String> o;
    private final b p;
    private com.obric.autogui.agents.vlm.models.a.a.b q;
    private com.obric.autogui.agents.vlm.models.impl.c.b r;
    private volatile au<com.obric.autogui.agents.vlm.models.a.a.b> s;
    private volatile com.obric.autogui.agents.vlm.models.impl.f.a t;
    private volatile com.obric.autogui.agents.vlm.models.impl.b u;
    private int v;
    private ActionSystemAnimationMonitor w;
    private volatile com.obric.autogui.agents.vlm.models.impl.c x;
    private com.obric.autogui.operator.g y;
    private int z;

    /* JADX INFO: compiled from: StandardModelBaseStep.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final <T extends g> T a(T r8, JsonObject r9) {
            d.h.b.o.e(r8, "<this>");
            d.h.b.o.e(r9, "parsedData");
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
            JsonElement r17 = r9.get("step_index");
            if (r17 == null) goto L24;
            int r18 = r17.getAsInt();
        L25:
            r8.c(r18);
            com.obric.autogui.operator.e r19 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
            JsonElement r3 = r9.get("step_id");
            if (r3 == null) goto L31;
            String r4 = r3.getAsString();
            if (r4 == null) goto L31;
            r0 = r4;
        L31:
            r19.n(r0);
            JsonElement r20 = r9.get("server_time");
            long r5 = 0;
            if (r20 == null) goto L34;
            long r6 = r20.getAsLong();
        L35:
            r8.b(r6);
            JsonElement r21 = r9.get("inference_time");
            if (r21 == null) goto L38;
            r5 = r21.getAsLong();
        L38:
            r8.c(r5);
            d.n.a r22 = d.n.f38560a;     // Catch: Throwable -> L58
            JsonElement r23 = r9.get("usage_tokens");     // Catch: Throwable -> L58
            if (r23 == null) goto L42;
            JsonObject r24 = r23.getAsJsonObject();     // Catch: Throwable -> L58
        L43:
            if (r24 == null) goto L56;
            b r25 = r8.m();     // Catch: Throwable -> L58
            JsonElement r2 = r24.get("completion_tokens");     // Catch: Throwable -> L58
            if (r2 == null) goto L47;
            int r26 = r2.getAsInt();     // Catch: Throwable -> L58
        L48:
            r25.a(r26);     // Catch: Throwable -> L58
            b r27 = r8.m();     // Catch: Throwable -> L58
            JsonElement r28 = r24.get("prompt_tokens");     // Catch: Throwable -> L58
            if (r28 == null) goto L51;
            int r29 = r28.getAsInt();     // Catch: Throwable -> L58
        L52:
            r27.b(r29);     // Catch: Throwable -> L58
            b r30 = r8.m();     // Catch: Throwable -> L58
            JsonElement r31 = r24.get("total_tokens");     // Catch: Throwable -> L58
            if (r31 == null) goto L55;
            r1 = r31.getAsInt();     // Catch: Throwable -> L58
        L55:
            r30.c(r1);     // Catch: Throwable -> L58
            goto L56
        L51:
            r29 = 0;
            goto L52
        L47:
            r26 = 0;
        L56:
            d.n.f(x.f38692a);     // Catch: Throwable -> L58
        L60:
            r8.y().a(r8.j());
            r8.y().b(r8.k());
            ((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin")).a_(r8.i());
            return r8;
        L42:
            r24 = null;
        L58:
            th = move-exception;
            d.n.a r32 = d.n.f38560a;
            d.n.f(d.o.a(th));
            goto L60
        L34:
            r6 = 0;
            goto L35
        L24:
            r18 = 0;
            goto L25
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

        public final <T extends e> T a(T r4, JsonObject r5) {
            d.h.b.o.e(r4, "<this>");
            d.h.b.o.e(r5, "parsedData");
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
    }

    /* JADX INFO: compiled from: StandardModelBaseStep.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f27909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f27910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f27911c;

        public b() {
            this(0, 0, 0, 7, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f27909a == r6.f27909a) goto L12;
            return false;
        L12:
            if (this.f27910b == r6.f27910b) goto L15;
            return false;
        L15:
            if (this.f27911c == r6.f27911c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f27909a) * 31) + Integer.hashCode(this.f27910b)) * 31) + Integer.hashCode(this.f27911c);
        }

        public String toString() {
            return "ModelTokenUsage(completionTokens=" + this.f27909a + ", promptTokens=" + this.f27910b + ", totalTokens=" + this.f27911c + ')';
        }

        public b(int r1, int r2, int r3) {
            this.f27909a = r1;
            this.f27910b = r2;
            this.f27911c = r3;
        }

        public /* synthetic */ b(int r2, int r3, int r4, int r5, d.h.b.h r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 0;
        L11:
            this(r2, r3, r4);
        }

        public final int a() {
            return this.f27909a;
        }

        public final void a(int r1) {
            this.f27909a = r1;
        }

        public final int b() {
            return this.f27910b;
        }

        public final void b(int r1) {
            this.f27910b = r1;
        }

        public final int c() {
            return this.f27911c;
        }

        public final void c(int r1) {
            this.f27911c = r1;
        }
    }

    /* JADX INFO: compiled from: StandardModelBaseStep.kt */
    public static final class c extends com.obric.autogui.operator.e.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f27912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f27913b;

        public c() {
            this(0, 0, 3, null);
        }

        public /* synthetic */ c(long r3, long r5, int r7, d.h.b.h r8) {
            if ((r7 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r7 & 2) == 0) goto L8;
            r5 = 0;
        L8:
            this(r3, r5);
        }

        public final long a() {
            return this.f27912a;
        }

        public final void a(long r1) {
            this.f27912a = r1;
        }

        public final long b() {
            return this.f27913b;
        }

        public final void b(long r1) {
            this.f27913b = r1;
        }

        public c(long r12, long r14) {
            super(0, 0, 0, 0, 15, null);
            this.f27912a = r12;
            this.f27913b = r14;
        }
    }

    /* JADX INFO: compiled from: StandardModelBaseStep.kt */
    @d.c.b.a.f(b = "StandardModelBaseStep.kt", c = {ResultCode.ERROR_MULTI_DETAIL}, d = "doOperations", e = "com.obric.autogui.agents.vlm.models.impl.StandardModelBaseStep")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f27915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f27916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f27917d;

        d(g r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27916c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27915b = r3;
            this.f27917d |= Integer.MIN_VALUE;
            return this.f27916c.c(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f27904b = new a(null);
    }

    public Object a(com.obric.autogui.session.a r3, d.c.d<? super com.obric.autogui.operator.g> r4) {
        return b(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.operator.e
    public Object b(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.agents.vlm.models.a.d
    public boolean A() {
        return com.obric.autogui.agents.vlm.models.a.d.a.b(this);
    }

    @Override // com.obric.autogui.agents.vlm.models.a.d
    public boolean B() {
        return com.obric.autogui.agents.vlm.models.a.d.a.c(this);
    }

    @Override // com.obric.autogui.agents.vlm.models.a.d
    public com.obric.autogui.agents.vlm.models.a.d.b C() {
        return com.obric.autogui.agents.vlm.models.a.d.a.d(this);
    }

    @Override // com.obric.autogui.operator.e
    public /* synthetic */ com.obric.autogui.operator.e.d D() {
        return (com.obric.autogui.operator.e.d) ZeusTransformUtils.preCheckCast(y(), com.obric.autogui.operator.e.d.class, "com.obric.aiagent.plugin");
    }

    public boolean h() {
        return com.obric.autogui.agents.vlm.models.a.d.a.e(this);
    }

    @Override // com.obric.autogui.agents.vlm.models.a.d
    public String z() {
        return com.obric.autogui.agents.vlm.models.a.d.a.a(this);
    }

    public g() {
        this.f27905a = "";
        this.f27906c = "";
        this.f27907d = "";
        this.m = -1;
        this.o = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.p = new b(0, 0, 0, 7, null);
        this.x = new com.obric.autogui.agents.vlm.models.impl.c(false, false, 0, false, 15, null);
        this.A = new c(0, 0, 3, null);
    }

    public final void e(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.f27905a = r2;
    }

    public final void f(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.f27906c = r2;
    }

    public final String i() {
        return this.f27906c;
    }

    public final void g(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.f27907d = r2;
    }

    public final void a(int r1) {
        this.f27908e = r1;
    }

    public final void a(byte[] r1) {
        this.g = r1;
    }

    public final void b(long r1) {
        this.h = r1;
    }

    public final long j() {
        return this.h;
    }

    public final void c(long r1) {
        this.i = r1;
    }

    public final long k() {
        return this.i;
    }

    public final void b(int r1) {
        this.j = r1;
    }

    public final void h(String r1) {
        this.k = r1;
    }

    public final void a(boolean r1) {
        this.l = r1;
    }

    public final void c(int r1) {
        this.m = r1;
    }

    public final int l() {
        return this.m;
    }

    public final void a(JsonObject r1) {
        this.n = r1;
    }

    public final b m() {
        return this.p;
    }

    public final void i(String r2) {
        d.h.b.o.e(r2, "msg");
        this.o.add(r2);
    }

    public final com.obric.autogui.agents.vlm.models.a.a.b n() {
        return this.q;
    }

    public final void a(com.obric.autogui.agents.vlm.models.impl.c.b r1) {
        this.r = r1;
    }

    public final com.obric.autogui.agents.vlm.models.impl.c.b o() {
        return this.r;
    }

    public final void a(au<com.obric.autogui.agents.vlm.models.a.a.b> r3) {
        this.s = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
    }

    public final au<com.obric.autogui.agents.vlm.models.a.a.b> p() {
        return this.s;
    }

    public final void a(com.obric.autogui.agents.vlm.models.impl.f.a r2) {
        d.h.b.o.e(r2, "cache");
        this.t = r2;
    }

    public final com.obric.autogui.agents.vlm.models.impl.f.a d(long r2) {
        com.obric.autogui.agents.vlm.models.impl.f.a r1 = this.t;
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.a(r2) == false) goto L9;
        return r1;
    L9:
        return null;
    }

    public final com.obric.autogui.agents.vlm.models.impl.f.a e(long r3) {
        com.obric.autogui.agents.vlm.models.impl.f.a r0 = this.t;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.t = null;
        if (r0.a(r3) == false) goto L9;
        return r0;
    L9:
        return null;
    }

    public final void a(com.obric.autogui.agents.vlm.models.impl.b r2) {
        d.h.b.o.e(r2, "cache");
        this.u = r2;
    }

    public final com.obric.autogui.agents.vlm.models.impl.b f(long r3) {
        com.obric.autogui.agents.vlm.models.impl.b r0 = this.u;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.u = null;
        if (r0.a(r3) == false) goto L9;
        return r0;
    L9:
        return null;
    }

    static /* synthetic */ Object a(g r6, com.obric.autogui.session.a r7, d.c.d<? super x> r8) {
        d.c.d<? super x> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (r6.v <= 0) goto L5;
        r6.t = null;
        r6.u = null;
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] pre-exec cache cleared before framework retry step_id=" + com.obric.autogui.agents.a.b.a(r6.W(), 0, 1, null) + ", physical_execution=" + (r6.v + 1));
    L5:
        r6.v++;
        Object r10 = super.b(r7, r9);
        if (r10 != d.c.a.b.a()) goto L9;
        return r10;
    L9:
        return x.f38692a;
    }

    @Override // com.obric.autogui.operator.e
    public void a(com.obric.autogui.session.a r2) {
        d.h.b.o.e(r2, SensitiveType.SESSION);
        super.a(r2);     // Catch: Throwable -> L6
        this.t = null;
        this.u = null;
        return;
    L6:
        th = move-exception;
        this.t = null;
        this.u = null;
        throw th;
    }

    public final void a(ActionSystemAnimationMonitor r3) {
        this.w = (ActionSystemAnimationMonitor) ZeusTransformUtils.wrapperContextForParams(r3, ActionSystemAnimationMonitor.class, "com.obric.aiagent.plugin");
    }

    public final ActionSystemAnimationMonitor q() {
        return this.w;
    }

    public final com.obric.autogui.agents.vlm.models.impl.c r() {
        return this.x;
    }

    public final void b(boolean r10) {
        this.x = new com.obric.autogui.agents.vlm.models.impl.c(r10, false, 0, false, 14, null);
    }

    public final void a(boolean r9, long r10, boolean r12) {
        this.x = com.obric.autogui.agents.vlm.models.impl.c.a(this.x, false, r9, d.l.n.a(r10, 0), r12, 1, null);
    }

    public final void s() {
        this.x = com.obric.autogui.agents.vlm.models.impl.c.a(this.x, false, true, 0, false, 13, null);
    }

    public final void a(com.obric.autogui.operator.g r3) {
        this.y = (com.obric.autogui.operator.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
    }

    public final com.obric.autogui.operator.g t() {
        return this.y;
    }

    public final void d(int r1) {
        this.z = r1;
    }

    public final int u() {
        return this.z;
    }

    @Override // com.obric.autogui.operator.e
    public final Object c(com.obric.autogui.session.a r8, d.c.d<? super com.obric.autogui.operator.g> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.aiagent.plugin");
        if ((r0.f27917d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27917d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f27915b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27917d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        g this = (g) ZeusTransformUtils.preCheckCast(r0.f27914a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L20:
        com.obric.autogui.operator.g r12 = (com.obric.autogui.operator.g) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");
        this.y = r12;
        return r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        Loog.INSTANCE.i(TAG, "[exec step]; id=" + W() + ", x=" + this.m);
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L17;
        Loog.INSTANCE.i(TAG, "[exec step]; tho=" + this.f27906c + ", obs=" + this.f27905a + ", sum=" + this.f27907d + ", stat=" + this.f27908e);
    L17:
        r0.f27914a = this;
        r0.f27917d = 1;
        r11 = a(r8, r0);
        if (r11 != r2) goto L20;
        return r2;
    L7:
        r0 = new d(this, r10);
        goto L8
    }

    static /* synthetic */ Object b(g r2, com.obric.autogui.session.a r3, d.c.d<? super com.obric.autogui.operator.g> r4) {
        return super.c(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.agents.vlm.models.a.c
    public JsonObject v() {
        JsonObject r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Loog.INSTANCE.i(TAG, "[getStepRecordJson] using generated StepRecord.");
        JsonObject r1 = c();
        this.n = r1;
        return r1;
    }

    public JsonObject c() {
        JsonObject r0 = new JsonObject();
        r0.addProperty(VDPlayerEffectProviderImpl.KEY_THOUGHT, this.f27906c);
        r0.addProperty("observation", this.f27905a);
        r0.addProperty("summary", this.f27907d);
        r0.addProperty("status", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(this.f27908e), Number.class, "com.obric.aiagent.plugin"));
        return r0;
    }

    @Override // com.obric.autogui.agents.vlm.models.a.d
    public String w() {
        return this.f27906c;
    }

    public Bundle g() {
        Bundle r0 = com.obric.autogui.agents.vlm.models.a.d.a.f(this);
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        r0.putLong("latency", this.h);
        r0.putInt("trials", this.j);
        JsonObject r1 = this.n;
        if (r1 == null) goto L8;
        r0.putString("model_output", r1.toString());
    L8:
        r0.putBoolean(SurfaceCardActivity.FROM_STREAMING_KEY, this.l);
        String r4 = this.k;
        if (r4 != null) goto L11;
    L16:
        return r0;
    L11:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L16;
        r0.putString("robots_msg", r4);
        goto L16
    }

    public final String a(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "context");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.o, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L5;
        com.obric.autogui.operator.g r9 = this.y;
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.operator.k.class) == false) goto L11;
        String r12 = ((com.obric.autogui.operator.k) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.operator.k.class, "com.obric.aiagent.plugin")).a(r11);
        if (r12 == null) goto L13;
        return r12;
    L13:
        return null;
    L11:
        return null;
    L5:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(this.o, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null);
    }

    @Override // com.obric.autogui.operator.e
    public void x() {
        super.x();
        ActionSystemAnimationMonitor r0 = this.w;
        if (r0 != null) goto L5;
    L6:
        this.w = null;
    L7:
        this.g = null;
        com.obric.autogui.agents.vlm.models.a.a.b r1 = this.q;
        if (r1 == null) goto L10;
        r1.e();
    L10:
        this.t = null;
        this.u = null;
        this.v = 0;
        this.r = null;
        this.x = new com.obric.autogui.agents.vlm.models.impl.c(false, false, 0, false, 15, null);
        this.q = null;
        this.s = null;
        return;
    L5:
        if (r0.unregister() == false) goto L7;
        goto L6
    }

    public final void a(IScreenshot r10, ComponentName r11, List<ViewHierarchyDump> r12) {
        IScreenshot r13 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r10, IScreenshot.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L6;
        this.q = new com.obric.autogui.agents.vlm.models.a.a.b(null, r11, r5, null, 8, null);
        return;
    L6:
        this.q = new com.obric.autogui.agents.vlm.models.a.a.b((IScreenshot) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.a.h(r13, false, 2, null), IScreenshot.class, "com.obric.aiagent.plugin"), r11, r5, null, 8, null);
    }

    public c y() {
        return this.A;
    }

    @Override // com.obric.autogui.operator.e
    public void a(JSONObject r4) {
        d.h.b.o.e(r4, "metricsForUpload");
        super.a(r4);
        r4.put("latency_pred_model", y().a());
        r4.put("latency_pred_inference", y().b());
        r4.put("token_completion", this.p.a());
        r4.put("token_prompt", this.p.b());
        r4.put("token_total", this.p.c());
    }

    @Override // com.obric.autogui.operator.e
    public void a(com.obric.autogui.operator.e r5) {
        d.h.b.o.e(r5, "from");
        super.a(r5);
        if (ZeusTransformUtils.instanceOf(r5, g.class) == false) goto L6;
        this.m = ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).m;
        this.n = ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).n;
        this.g = ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).g;
        this.h = ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).h;
        this.i = ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).i;
        this.j = ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).j;
        this.q = ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).q;
        this.r = ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).r;
        this.s = ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).s;
        this.y = ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).y;
        return;
    }
}
