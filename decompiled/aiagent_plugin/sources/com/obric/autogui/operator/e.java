package com.obric.autogui.operator;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.oui.oswitch.SwitchCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AOStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    private static final String TAG = "Step";
    public static final a f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<d.m<C0780e, com.obric.autogui.operator.b>> f29882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p f29883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f29886e;
    private int g;
    private int h;
    private Collection<C0780e> i;
    private com.obric.autogui.agents.vlm.models.a j;
    private IAutoActionAgentEventListener.AgentStepInfo k;
    private c l;
    private boolean m;
    private boolean n;
    private String o;
    private com.obric.autogui.session.c.a p;
    private final d q;

    /* JADX INFO: compiled from: AOStep.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AOStep.kt */
    public static final class b implements com.obric.autogui.operator.g, k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f29887a = null;

        static {
            f29887a = new b();
        }

        @Override // com.obric.autogui.operator.g
        public boolean a() {
            return true;
        }

        private b() {
        }

        @Override // com.obric.autogui.operator.g
        public String c() {
            return com.obric.autogui.operator.g.b.a(this);
        }

        @Override // com.obric.autogui.operator.g
        public int d() {
            return com.obric.autogui.operator.g.b.b(this);
        }

        @Override // com.obric.autogui.operator.g
        public com.obric.autogui.operator.g.e e() {
            return com.obric.autogui.operator.g.b.c(this);
        }

        @Override // com.obric.autogui.operator.g
        public Object f() {
            return com.obric.autogui.operator.g.b.d(this);
        }

        @Override // com.obric.autogui.operator.g
        public com.obric.autogui.operator.f g() {
            return com.obric.autogui.operator.g.b.e(this);
        }

        @Override // com.obric.autogui.operator.g
        public com.obric.autogui.operator.g.c b() {
            return com.obric.autogui.operator.g.c.f29923b;
        }

        @Override // com.obric.autogui.operator.k
        public String a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r2, "context");
            String r4 = r2.getString(ZeusTransformUtils.mapRes(R.string.espe_param_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "espe_param_error"));
            d.h.b.o.c(r4, "getString(...)");
            return r4;
        }
    }

    /* JADX INFO: compiled from: AOStep.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f29888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f29889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f29890c;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
            return false;
        L8:
            c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
            if (this.f29888a == r8.f29888a) goto L12;
            return false;
        L12:
            if (this.f29889b == r8.f29889b) goto L15;
            return false;
        L15:
            if (this.f29890c == r8.f29890c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f29888a) * 31) + Boolean.hashCode(this.f29889b)) * 31) + Long.hashCode(this.f29890c);
        }

        public String toString() {
            return "RetryInfo(retryCount=" + this.f29888a + ", isRetrying=" + this.f29889b + ", lastRetryTimestamp=" + this.f29890c + ')';
        }

        public c(int r1, boolean r2, long r3) {
            this.f29888a = r1;
            this.f29889b = r2;
            this.f29890c = r3;
        }

        public final int a() {
            return this.f29888a;
        }

        public final void a(int r1) {
            this.f29888a = r1;
        }

        public final void a(boolean r1) {
            this.f29889b = r1;
        }

        public final boolean b() {
            return this.f29889b;
        }

        public final void a(long r1) {
            this.f29890c = r1;
        }
    }

    /* JADX INFO: compiled from: AOStep.kt */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f29891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f29892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f29893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f29894d;

        public d() {
            this(0, 0, 0, 0, 15, null);
        }

        public d(long r1, long r3, long r5, long r7) {
            this.f29891a = r1;
            this.f29892b = r3;
            this.f29893c = r5;
            this.f29894d = r7;
        }

        public /* synthetic */ d(long r3, long r5, long r7, long r9, int r11, d.h.b.h r12) {
            if ((r11 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r5 = 0;
        L9:
            if ((r11 & 4) == 0) goto L12;
            r7 = 0;
        L12:
            if ((r11 & 8) == 0) goto L14;
            r9 = 0;
        L14:
            this(r3, r5, r7, r9);
        }

        public final long c() {
            return this.f29891a;
        }

        public final void c(long r1) {
            this.f29891a = r1;
        }

        public final long d() {
            return this.f29892b;
        }

        public final void d(long r1) {
            this.f29892b = r1;
        }

        public final long e() {
            return this.f29893c;
        }

        public final void e(long r1) {
            this.f29893c = r1;
        }

        public final long f() {
            return this.f29894d;
        }

        public final void f(long r1) {
            this.f29894d = r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.operator.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOStep.kt */
    public static final class C0780e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.operator.b.EnumC0777b f29895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.operator.b.a f29896b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0780e.class) == true) goto L8;
            return false;
        L8:
            C0780e r6 = (C0780e) ZeusTransformUtils.preCheckCast(r5, C0780e.class, "com.obric.aiagent.plugin");
            if (this.f29895a == r6.f29895a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f29896b, r6.f29896b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f29895a.hashCode() * 31) + this.f29896b.hashCode();
        }

        public String toString() {
            return "StepOperation(opType=" + this.f29895a + ", opInput=" + this.f29896b + ')';
        }

        public C0780e(com.obric.autogui.operator.b.EnumC0777b r3, com.obric.autogui.operator.b.a r4) {
            com.obric.autogui.operator.b.a r5 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "opType");
            d.h.b.o.e(r5, "opInput");
            this.f29895a = r3;
            this.f29896b = r5;
        }

        public final com.obric.autogui.operator.b.EnumC0777b a() {
            return this.f29895a;
        }

        public final com.obric.autogui.operator.b.a b() {
            return this.f29896b;
        }
    }

    /* JADX INFO: compiled from: AOStep.kt */
    @d.c.b.a.f(b = "AOStep.kt", c = {SwitchCompat.TRACK_ANIMATION_DURATION_ON}, d = "beforeExecution$suspendImpl", e = "com.obric.autogui.operator.AOStep")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f29899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f29900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29901e;

        f(e r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29900d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29899c = r3;
            this.f29901e |= Integer.MIN_VALUE;
            return e.b(this.f29900d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOStep.kt */
    @d.c.b.a.f(b = "AOStep.kt", c = {107, 108}, d = "doOperations$suspendImpl", e = "com.obric.autogui.operator.AOStep")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f29905d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f29906e;
        Object f;
        int g;
        /* synthetic */ Object h;
        final /* synthetic */ e i;
        int j;

        g(e r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return e.a(this.i, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOStep.kt */
    @d.c.b.a.f(b = "AOStep.kt", c = {276}, d = "doPreCheck$suspendImpl", e = "com.obric.autogui.operator.AOStep")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29910d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f29911e;
        int f;

        h(e r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29911e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29910d = r3;
            this.f |= Integer.MIN_VALUE;
            return e.a(this.f29911e, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOStep.kt */
    @d.c.b.a.f(b = "AOStep.kt", c = {171}, d = "notifyBeforeOperation", e = "com.obric.autogui.operator.AOStep")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f29913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f29914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29915d;

        i(e r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29914c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29913b = r3;
            this.f29915d |= Integer.MIN_VALUE;
            return e.a(this.f29914c, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f = new a(null);
    }

    public Object a(com.obric.autogui.operator.b r3, d.c.d<? super com.obric.autogui.operator.c> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public Object a(d.c.d<? super x> r3) {
        return a(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public Object b(com.obric.autogui.session.a r3, d.c.d<? super x> r4) {
        return b(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public Object c(com.obric.autogui.session.a r3, d.c.d<? super com.obric.autogui.operator.g> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public e() {
        this.f29882a = new ArrayList();
        this.f29885d = "";
        this.i = (Collection) ZeusTransformUtils.preCheckCast(d.a.p.b(), Collection.class, "com.obric.aiagent.plugin");
        this.o = "";
        this.q = new d(0, 0, 0, 0, 15, null);
    }

    public static final /* synthetic */ Object a(e r2, C0780e r3, com.obric.autogui.operator.b r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final int M() {
        return this.f29884c;
    }

    public final void e(int r1) {
        this.f29884c = r1;
    }

    public void a_(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.f29885d = r2;
    }

    public String k_() {
        return this.f29885d;
    }

    public final int N() {
        return this.f29886e;
    }

    public final void f(int r1) {
        this.f29886e = r1;
    }

    public final int O() {
        return this.g;
    }

    public final void g(int r1) {
        this.g = r1;
    }

    public final int P() {
        return this.h;
    }

    public final void h(int r1) {
        this.h = r1;
    }

    public Collection<C0780e> Q() {
        return this.i;
    }

    public void a(Collection<C0780e> r3) {
        Collection<C0780e> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<set-?>");
        this.i = r4;
    }

    public final com.obric.autogui.agents.vlm.models.a R() {
        return this.j;
    }

    public final void a(com.obric.autogui.agents.vlm.models.a r1) {
        this.j = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11, types: [com.obric.autogui.operator.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v13, types: [com.obric.autogui.operator.b] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r15v1, types: [com.obric.autogui.common.api.logging.LogUtil] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Class, java.lang.Class<com.obric.autogui.operator.e>] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v15, types: [com.obric.autogui.operator.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.obric.autogui.operator.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.autogui.operator.e] */
    /* JADX WARN: Type inference failed for: r1v24, types: [com.obric.autogui.operator.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v25, types: [com.obric.autogui.operator.e] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.autogui.common.api.logging.LogUtil] */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.obric.autogui.operator.b] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v6, types: [com.obric.autogui.operator.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x01a6 -> B:99:0x01fb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01dd -> B:58:0x01e0). Please report as a decompilation issue!!! */
    static /* synthetic */ Object a(e r22, com.obric.autogui.session.a r23, d.c.d<? super com.obric.autogui.operator.g> r24) {
        ?? r1 = e.class;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, g.class) == false) goto L7;
        g r4 = (g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin");
        if ((r4.j & Integer.MIN_VALUE) == 0) goto L7;
        r4.j -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.h;
        Object r5 = d.c.a.b.a();
        ?? r6 = r4.j;
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L17;
        if (r6 != 2) goto L16;
        int r0 = r4.g;
        com.obric.autogui.operator.b r7 = (com.obric.autogui.operator.b) ZeusTransformUtils.preCheckCast(r4.f, com.obric.autogui.operator.b.class, "com.obric.aiagent.plugin");
        C0780e r11 = (C0780e) ZeusTransformUtils.preCheckCast(r4.f29906e, C0780e.class, "com.obric.aiagent.plugin");
        Iterator r12 = (Iterator) ZeusTransformUtils.preCheckCast(r4.f29905d, Iterator.class, "com.obric.aiagent.plugin");
        List r13 = (List) ZeusTransformUtils.preCheckCast(r4.f29904c, List.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r4.f29903b, String.class, "com.obric.aiagent.plugin");
        e r8 = (e) ZeusTransformUtils.preCheckCast(r4.f29902a, r1, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L20
        r1 = r8;
        r6 = r7;
    L58:
        r1.a(r11, (com.obric.autogui.operator.c) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L20
        com.obric.autogui.operator.c r9 = (com.obric.autogui.operator.c) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        List r10 = r13;
        String r20 = r14;
        C0780e r15 = r11;
        ?? r16 = r6;
        Iterator r17 = r12;
        int r18 = r0;
        ?? r19 = r1;
    L99:
        d.m r21 = new d.m(r15.a(), r9);     // Catch: Throwable -> L80
        if (r9.a() == true) goto L63;
    L79:
        r18 = r18 + 1;
        r19.a(r16, r15, null);
        d.m r110 = r21;
        String r25 = r20;
        ?? r26 = r19;
    L38:
        if (r17.hasNext() == false) goto L86;
        d.m r111 = (d.m) ZeusTransformUtils.preCheckCast(r17.next(), d.m.class, "com.obric.aiagent.plugin");
        r15 = (C0780e) ZeusTransformUtils.preCheckCast(r111.c(), C0780e.class, "com.obric.aiagent.plugin");
        ?? r112 = (com.obric.autogui.operator.b) ZeusTransformUtils.preCheckCast(r111.d(), com.obric.autogui.operator.b.class, "com.obric.aiagent.plugin");
        r112.a(r26);     // Catch: Throwable -> L80
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(r26), "executeStep，stepId:" + ((e) r26).o + ", operation #" + r18 + ": " + r15.a().name());     // Catch: Throwable -> L80
        com.obric.autogui.operator.a.c.b r27 = r112.a();     // Catch: Throwable -> L80
        if (r27 == null) goto L43;
        r9 = r27.a();     // Catch: Throwable -> L80
    L44:
        if (r9 != null) goto L46;
    L48:
        boolean r28 = false;
    L49:
        if (r28 == false) goto L51;
        r26.b(r15, r9);     // Catch: Throwable -> L80
        r20 = r25;
        r19 = r26;
        r16 = r112;
        goto L99
    L51:
        r4.f29902a = r26;     // Catch: Throwable -> L80
        r4.f29903b = r25;     // Catch: Throwable -> L80
        r4.f29904c = r10;     // Catch: Throwable -> L80
        r4.f29905d = r17;     // Catch: Throwable -> L80
        r4.f29906e = r15;     // Catch: Throwable -> L80
        r4.f = r112;     // Catch: Throwable -> L80
        r4.g = r18;     // Catch: Throwable -> L80
        r4.j = 1;     // Catch: Throwable -> L80
        if (r26.a(r15, r112, r4) != r5) goto L54;
        return r5;
    L54:
        r14 = r25;
        r0 = r18;
        r12 = r17;
        ?? r29 = r112;
        r11 = r15;
        r13 = r10;
        ?? r30 = r26;
    L55:
        r4.f29902a = r30;     // Catch: Throwable -> L20
        r4.f29903b = r14;     // Catch: Throwable -> L20
        r4.f29904c = r13;     // Catch: Throwable -> L20
        r4.f29905d = r12;     // Catch: Throwable -> L20
        r4.f29906e = r11;     // Catch: Throwable -> L20
        r4.f = r29;     // Catch: Throwable -> L20
        r4.g = r0;     // Catch: Throwable -> L20
        r4.j = 2;     // Catch: Throwable -> L20
        r3 = r30.a(r29, r4);     // Catch: Throwable -> L20
        r1 = r30;
        r6 = r29;
        if (r3 != r5) goto L58;
        return r5;
    L46:
        if (r9.a() != true) goto L48;
        r28 = true;
        goto L49
    L43:
        r9 = null;
        goto L44
    L86:
        if (r110 == null) goto L88;
        com.obric.autogui.operator.b.EnumC0777b r113 = (com.obric.autogui.operator.b.EnumC0777b) ZeusTransformUtils.preCheckCast(r110.a(), com.obric.autogui.operator.b.EnumC0777b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.c r114 = (com.obric.autogui.operator.c) ZeusTransformUtils.preCheckCast(r110.b(), com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        if (r10.size() != 1) goto L92;
        boolean r115 = true;
    L94:
        return new m(r113, r114, r115, true, r25);
    L92:
        r115 = false;
        goto L94
    L88:
        return new com.obric.autogui.operator.g.d(r25);
    L63:
        if (r9.c() != com.obric.autogui.operator.c.EnumC0779c.f29878b) goto L79;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r19), "early terminated execution of step at operation #" + r18 + " (unsuccessful)");     // Catch: Throwable -> L80
        com.obric.autogui.operator.b.EnumC0777b r116 = r15.a();     // Catch: Throwable -> L80
        if ((r18 + 1) != r10.size()) goto L67;
        boolean r31 = true;
    L69:
        if (r10.size() != 1) goto L71;
        boolean r117 = true;
    L73:
        if (r31 == false) goto L75;
        boolean r118 = true;
    L76:
        m r32 = new m(r116, r9, r117, r118, r20);     // Catch: Throwable -> L80
        r19.a(r16, r15, null);
        return r32;
    L75:
        r118 = false;
        goto L76
    L71:
        r117 = false;
        goto L73
    L67:
        r31 = false;
    L80:
        th = move-exception;
        Throwable r33 = th;
        ?? r34 = r16;
        r11 = r15;
        ?? r35 = r19;
    L95:
        throw r33;     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        r35.a(r34, r11, r33);
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r0 = r4.g;
        com.obric.autogui.operator.b r36 = (com.obric.autogui.operator.b) ZeusTransformUtils.preCheckCast(r4.f, com.obric.autogui.operator.b.class, "com.obric.aiagent.plugin");
        r11 = (C0780e) ZeusTransformUtils.preCheckCast(r4.f29906e, C0780e.class, "com.obric.aiagent.plugin");
        r12 = (Iterator) ZeusTransformUtils.preCheckCast(r4.f29905d, Iterator.class, "com.obric.aiagent.plugin");
        r13 = (List) ZeusTransformUtils.preCheckCast(r4.f29904c, List.class, "com.obric.aiagent.plugin");
        r14 = (String) ZeusTransformUtils.preCheckCast(r4.f29903b, String.class, "com.obric.aiagent.plugin");
        e r37 = (e) ZeusTransformUtils.preCheckCast(r4.f29902a, r1, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L20
        r30 = r37;
        r29 = r36;
        goto L55
    L22:
        d.o.a(r3);
        if (ZeusTransformUtils.instanceOf(r22, com.obric.autogui.agents.vlm.models.a.d.class) == false) goto L25;
        com.obric.autogui.agents.vlm.models.a.d r38 = (com.obric.autogui.agents.vlm.models.a.d) ZeusTransformUtils.preCheckCast(r22, com.obric.autogui.agents.vlm.models.a.d.class, "com.obric.aiagent.plugin");
    L26:
        if (r38 == null) goto L28;
        String r39 = r38.z();
    L29:
        com.obric.autogui.common.d<List<d.m<C0780e, com.obric.autogui.operator.b>>> r40 = r22.Y();
        if (r40.g() == true) goto L33;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r22), "early terminated of step at operation (param error)");
        return b.f29887a;
    L33:
        r10 = (List) ZeusTransformUtils.preCheckCast(r40.a(), List.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L36;
        r10 = d.a.p.b();
    L36:
        r17 = r10.iterator();
        r110 = null;
        r18 = 0;
        String r210 = r39;
        r26 = r22;
        r25 = r210;
        goto L38
    L28:
        r39 = null;
        goto L29
    L25:
        r38 = null;
    L20:
        th = move-exception;
        r33 = th;
        r35 = r1;
        r34 = r6;
    L7:
        r4 = new g(r22, r2);
        goto L8
    }

    static /* synthetic */ Object a(e r2, com.obric.autogui.operator.b r3, d.c.d<? super com.obric.autogui.operator.c> r4) {
        d.c.d<? super com.obric.autogui.operator.c> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return r3.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    }

    private final Object a(C0780e r6, com.obric.autogui.operator.b r7, d.c.d<? super x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, i.class) == false) goto L7;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.aiagent.plugin");
        if ((r0.f29915d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f29915d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f29913b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f29915d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r6 = (C0780e) ZeusTransformUtils.preCheckCast(r0.f29912a, C0780e.class, "com.obric.aiagent.plugin");
        d.o.a(r10);     // Catch: Throwable -> L22 CancellationException -> L26
    L28:
    L25:
        return x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r10);
        p r5 = this.f29883b;     // Catch: Throwable -> L22 CancellationException -> L26
        if (r5 == null) goto L28;
        r0.f29912a = r6;     // Catch: Throwable -> L22 CancellationException -> L26
        r0.f29915d = 1;     // Catch: Throwable -> L22 CancellationException -> L26
        if (r5.a(r6, r7, r0) != r2) goto L28;
        return r2;
    L26:
        e = move-exception;
        throw e;
    L22:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect][StepObserver] before callback failed, op=" + r6.a() + ", error_type=" + th.getClass().getSimpleName());
    L7:
        r0 = new i(this, r9);
        goto L8
    }

    private final void a(C0780e r3, com.obric.autogui.operator.c r4) {
        com.obric.autogui.operator.c r5 = (com.obric.autogui.operator.c) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        p r2 = this.f29883b;     // Catch: Throwable -> L7
        if (r2 == null) goto L12;
        r2.a(r3, r5);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect][StepObserver] after callback failed, op=" + r3.a() + ", error_type=" + th.getClass().getSimpleName());
    }

    private final void b(C0780e r3, com.obric.autogui.operator.c r4) {
        com.obric.autogui.operator.c r5 = (com.obric.autogui.operator.c) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        p r2 = this.f29883b;     // Catch: Throwable -> L7
        if (r2 == null) goto L12;
        r2.b(r3, r5);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect][StepObserver] skipped callback failed, op=" + r3.a() + ", error_type=" + th.getClass().getSimpleName());
    }

    private final void a(com.obric.autogui.operator.b r7, C0780e r8, Throwable r9) {
        r7.b(this);     // Catch: Throwable -> L5
        th = null;
    L23:
        com.obric.autogui.operator.a.c.b r10 = r7.a();     // Catch: Throwable -> L11
        if (r10 == null) goto L17;
        r10.a(this);     // Catch: Throwable -> L11
    L17:
        if (th != null) goto L19;
        return;
    L19:
        if (r9 == null) goto L22;
        d.a.a(r9, th);
        return;
    L22:
        throw th;
    L11:
        th = move-exception;
        Throwable r11 = (Throwable) ZeusTransformUtils.preCheckCast(th, Throwable.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L15;
        d.a.a(r11, th);
    L16:
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect][StepBinding] prechecker unbind failed, op=" + r8.a() + ", error_type=" + th.getClass().getSimpleName());
        goto L17
    L15:
        th = th;
    L5:
        th = th;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect][StepBinding] operator unbind failed, op=" + r8.a() + ", error_type=" + th.getClass().getSimpleName());
        goto L23
    }

    public final void S() {
        com.obric.autogui.common.d<List<d.m<C0780e, com.obric.autogui.operator.b>>> r0 = Y();
        if (r0.g() == true) goto L5;
        return;
    L5:
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0.a(), List.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
        return;
    L8:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r2.hasNext() == false) goto L18;
        d.m r3 = (d.m) ZeusTransformUtils.preCheckCast(r2.next(), d.m.class, "com.obric.aiagent.plugin");
        C0780e r4 = (C0780e) ZeusTransformUtils.preCheckCast(r3.c(), C0780e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.c.b r5 = ((com.obric.autogui.operator.b) ZeusTransformUtils.preCheckCast(r3.d(), com.obric.autogui.operator.b.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L16
        if (r5 == null) goto L10;
        r5.a(this);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect][StepBinding] prechecker early unbind failed, op=" + r4.a() + ", error_type=" + th.getClass().getSimpleName());
        goto L10
    }

    static /* synthetic */ Object b(e r5, com.obric.autogui.session.a r6, d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.aiagent.plugin");
        if ((r0.f29901e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f29901e -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f29899c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f29901e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r0.f29898b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r5 = (e) ZeusTransformUtils.preCheckCast(r0.f29897a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L17:
        r5.b(r6);
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        r0.f29897a = r5;
        r0.f29898b = r6;
        r0.f29901e = 1;
        if (r5.a(r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new f(r5, r8);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00c0 -> B:37:0x011b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00d8 -> B:30:0x00db). Please report as a decompilation issue!!! */
    static /* synthetic */ Object a(e r9, d.c.d<? super x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r11, h.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f29910d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator r13 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f29909c, Iterator.class, "com.obric.aiagent.plugin");
        z.d r4 = (z.d) ZeusTransformUtils.preCheckCast(r0.f29908b, z.d.class, "com.obric.aiagent.plugin");
        e r5 = (e) ZeusTransformUtils.preCheckCast(r0.f29907a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
    L30:
        com.obric.autogui.operator.c r14 = (com.obric.autogui.operator.c) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.operator.c.class, "com.obric.aiagent.plugin");
        if (r14.a() == true) goto L33;
    L36:
        e r15 = r5;
    L37:
        r4.f38502a++;
    L23:
        if (r13.hasNext() == false) goto L39;
        d.m r6 = (d.m) ZeusTransformUtils.preCheckCast(r13.next(), d.m.class, "com.obric.aiagent.plugin");
        C0780e r7 = (C0780e) ZeusTransformUtils.preCheckCast(r6.c(), C0780e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.c.b r8 = ((com.obric.autogui.operator.b) ZeusTransformUtils.preCheckCast(r6.d(), com.obric.autogui.operator.b.class, "com.obric.aiagent.plugin")).a();
        if (r8 == null) goto L37;
        r8.a(r15, r7.b());
        r0.f29907a = r15;
        r0.f29908b = r4;
        r0.f29909c = r13;
        r0.f = 1;
        Object r16 = r8.a(r0);
        if (r16 != r2) goto L29;
        return r2;
    L29:
        r5 = r15;
        r12 = r16;
        goto L30
    L39:
        return x.f38692a;
    L33:
        if (r14.c() != com.obric.autogui.operator.c.EnumC0779c.f29878b) goto L36;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r5), "early pre-check of step at operation #" + r4.f38502a + " (unsuccessful)");
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        com.obric.autogui.common.d<List<d.m<C0780e, com.obric.autogui.operator.b>>> r17 = r9.Y();
        if (r17.g() == false) goto L17;
        List r18 = (List) ZeusTransformUtils.preCheckCast(r17.a(), List.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L21;
        r18 = d.a.p.b();
    L21:
        r4 = new z.d();
        Iterator r19 = r18.iterator();
        r15 = r9;
        r13 = r19;
        goto L23
    L17:
        return x.f38692a;
    L7:
        r0 = new h(r9, r11);
        goto L8
    }

    public void b(com.obric.autogui.session.a r2) {
        d.h.b.o.e(r2, SensitiveType.SESSION);
        IAutoActionAgentEventListener.AgentStepInfo r0 = T();
        if (r0 != null) goto L5;
        return;
    L5:
        r2.a(this);
        com.obric.autogui.b.a.f28928a.onAgentStep(r2.d(), r0);
    }

    public void a(com.obric.autogui.session.a r3) {
        d.h.b.o.e(r3, SensitiveType.SESSION);
        c r4 = this.l;
        if (r4 == null) goto L5;
        r4.a(false);
    L5:
        IAutoActionAgentEventListener.AgentStepInfo r2 = this.k;
        if (r2 == null) goto L9;
        r2.setFinishTimeMills(AOSystemTools.INSTANCE.nowTimeMillis());
        return;
    }

    public final IAutoActionAgentEventListener.AgentStepInfo T() {
        IAutoActionAgentEventListener.AgentStepInfo r1 = this.k;
        if (r1 == null) goto L6;
        return r1;
    L6:
        if (ZeusTransformUtils.instanceOf(this, com.obric.autogui.agents.vlm.models.a.d.class) == true) goto L9;
        return null;
    L9:
        String r2 = "";
        if (ZeusTransformUtils.instanceOf(this, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L12;
        String r5 = ((com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin")).d();
    L14:
        if (ZeusTransformUtils.instanceOf(this, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L16;
        String r11 = ((com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin")).f();
    L18:
        if (ZeusTransformUtils.instanceOf(this, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L20;
        r2 = ((com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin")).e();
    L20:
        IAutoActionAgentEventListener.AgentStepInfo r3 = new IAutoActionAgentEventListener.AgentStepInfo(r5, r2, ((com.obric.autogui.agents.vlm.models.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.a.d.class, "com.obric.aiagent.plugin")).w(), ((com.obric.autogui.agents.vlm.models.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.a.d.class, "com.obric.aiagent.plugin")).z(), !((com.obric.autogui.agents.vlm.models.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.a.d.class, "com.obric.aiagent.plugin")).B(), ((com.obric.autogui.agents.vlm.models.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.a.d.class, "com.obric.aiagent.plugin")).A(), r11, ((com.obric.autogui.agents.vlm.models.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.a.d.class, "com.obric.aiagent.plugin")).C().getIdentifier(), ((com.obric.autogui.agents.vlm.models.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.a.d.class, "com.obric.aiagent.plugin")).h(), AOSystemTools.INSTANCE.nowTimeMillis(), 0, ((com.obric.autogui.agents.vlm.models.a.d) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.agents.vlm.models.a.d.class, "com.obric.aiagent.plugin")).g(), 1024, null);
        this.k = r3;
        return r3;
    L16:
        r11 = "";
        goto L18
    L12:
        r5 = "";
        goto L14
    }

    public final c U() {
        return this.l;
    }

    public final void a(d.h.a.b<? super c, x> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "updater");
        c r0 = this.l;
        if (r0 == null) goto L5;
        r0.a(r0.a() + 1);
        r0.a(true);
        r0.a(AOSystemTools.INSTANCE.nowTimeMillis());
        r7.invoke(r0);
        return;
    L5:
        e r5 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");
        c r1 = new c(1, true, AOSystemTools.INSTANCE.nowTimeMillis());
        r7.invoke(r1);
        r5.l = r1;
    }

    public final void a(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "observer");
        this.f29883b = r4;
    }

    public final void b(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "observer");
        if (this.f29883b != r4) goto L6;
        this.f29883b = null;
        return;
    }

    public final void e(boolean r1) {
        this.m = r1;
    }

    public final boolean V() {
        return this.n;
    }

    public final void f(boolean r1) {
        this.n = r1;
    }

    public final String W() {
        return this.o;
    }

    public final void n(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.o = r2;
    }

    public final com.obric.autogui.session.c.a X() {
        return this.p;
    }

    public final void a(com.obric.autogui.session.c.a r1) {
        this.p = r1;
    }

    public d D() {
        return this.q;
    }

    public void a(JSONObject r4) {
        d.h.b.o.e(r4, "metricsForUpload");
        r4.put("latency_all", D().c());
        r4.put("latency_pred_all", D().d());
        r4.put("latency_pred_remote", D().e());
        r4.put("latency_pred_local", D().f());
        r4.put("preparation_flags", this.f29884c);
    }

    public void x() {
        this.f29883b = null;
        com.obric.autogui.operator.a.b.f29284a.b();
    }

    public void a(e r2) {
        d.h.b.o.e(r2, "from");
        this.f29884c = r2.f29884c;
        a_(r2.k_());
        this.j = r2.j;
        this.o = r2.o;
        this.f29886e = r2.f29886e;
        this.g = r2.g;
        this.h = r2.h;
        this.p = r2.p;
    }

    public final synchronized com.obric.autogui.common.d<List<d.m<C0780e, com.obric.autogui.operator.b>>> Y() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f29882a, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L8;
        com.obric.autogui.common.d<List<d.m<C0780e, com.obric.autogui.operator.b>>> r0 = com.obric.autogui.common.d.f29012a.a(this.f29882a);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r0;
    L8:
        com.obric.autogui.common.d.a r1 = com.obric.autogui.common.d.f29012a;     // Catch: Throwable -> L20
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(Q(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L20
    L10:
        if (r4.hasNext() == false) goto L17;
        C0780e r5 = (C0780e) ZeusTransformUtils.preCheckCast(r4.next(), C0780e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        com.obric.autogui.operator.b r6 = r5.a().a().a(r5.b());     // Catch: Throwable -> L20
        if (r6 == null) goto L13;
        r3.add(new d.m(r5, r6));     // Catch: Throwable -> L20
        goto L10
    L13:
        com.obric.autogui.common.d<List<d.m<C0780e, com.obric.autogui.operator.b>>> r7 = com.obric.autogui.common.d.f29012a.a("create operator for " + r5.a() + " failed");     // Catch: Throwable -> L20
        monitor-exit(this);
        return r7;
    L17:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        this.f29882a.addAll((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L20
        com.obric.autogui.common.d<List<d.m<C0780e, com.obric.autogui.operator.b>>> r9 = r1.a(r8);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r9;
    }
}
