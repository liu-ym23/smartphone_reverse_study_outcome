package com.obric.autogui.agents.vlm.models.impl;

import android.content.Context;
import android.graphics.PointF;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.autogui.common.api.AODeviceSpecificTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: StandardModelScriptStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends com.obric.autogui.agents.vlm.models.impl.e {
    private static final String TAG = "Script-StandardModelScriptStep";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f27933c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.d.C0690d f27934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.d.a f27935e;
    private final String g;
    private final JsonObject h;
    private final com.obric.autogui.agents.vlm.models.impl.e.f.c i;
    private final com.obric.autogui.agents.vlm.models.impl.e.f.b j;
    private final com.obric.autogui.agents.vlm.models.impl.e.c.f k;
    private final com.obric.autogui.agents.vlm.models.impl.e.c.b l;

    /* JADX INFO: compiled from: StandardModelScriptStep.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StandardModelScriptStep.kt */
    public static abstract class b<T> {

        /* JADX INFO: compiled from: StandardModelScriptStep.kt */
        public static abstract class a extends b {

            /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.l$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: StandardModelScriptStep.kt */
            public static final class C0698a extends a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final String f27936a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final String f27937b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final String f27938c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private final boolean f27939d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                private final boolean f27940e;

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String e() {
                    return null;
                }

                public boolean equals(Object r5) {
                    if (this != r5) goto L6;
                    return true;
                L6:
                    if (ZeusTransformUtils.instanceOf(r5, C0698a.class) == true) goto L8;
                    return false;
                L8:
                    C0698a r6 = (C0698a) ZeusTransformUtils.preCheckCast(r5, C0698a.class, "com.obric.aiagent.plugin");
                    if (d.h.b.o.a(this.f27936a, r6.f27936a) == true) goto L12;
                    return false;
                L12:
                    if (d.h.b.o.a(this.f27937b, r6.f27937b) == true) goto L15;
                    return false;
                L15:
                    if (d.h.b.o.a(this.f27938c, r6.f27938c) == true) goto L18;
                    return false;
                L18:
                    if (this.f27939d == r6.f27939d) goto L21;
                    return false;
                L21:
                    if (this.f27940e == r6.f27940e) goto L23;
                    return false;
                L23:
                    return true;
                }

                public int hashCode() {
                    int r0 = ((this.f27936a.hashCode() * 31) + this.f27937b.hashCode()) * 31;
                    String r1 = this.f27938c;
                    if (r1 != null) goto L5;
                    int r2 = 0;
                L7:
                    return ((((r0 + r2) * 31) + Boolean.hashCode(this.f27939d)) * 31) + Boolean.hashCode(this.f27940e);
                L5:
                    r2 = r1.hashCode();
                    goto L7
                }

                public String toString() {
                    return "EngineError(result=" + this.f27936a + ", error=" + this.f27937b + ", errorStack=" + this.f27938c + ", shouldRecordBlock=" + this.f27939d + ", blockAbilityInSession=" + this.f27940e + ')';
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String a() {
                    return this.f27936a;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public boolean b() {
                    return this.f27939d;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public boolean c() {
                    return this.f27940e;
                }

                public C0698a(String r2, String r3, String r4, boolean r5, boolean r6) {
                    d.h.b.o.e(r2, "result");
                    d.h.b.o.e(r3, WsConstants.KEY_CONNECTION_ERROR);
                    super(null);
                    this.f27936a = r2;
                    this.f27937b = r3;
                    this.f27938c = r4;
                    this.f27939d = r5;
                    this.f27940e = r6;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String d() {
                    return this.f27937b;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String f() {
                    return this.f27938c;
                }
            }

            /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.l$b$a$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: StandardModelScriptStep.kt */
            public static final class C0699b extends a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final String f27941a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final Throwable f27942b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final boolean f27943c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private final boolean f27944d;

                public boolean equals(Object r5) {
                    if (this != r5) goto L6;
                    return true;
                L6:
                    if (ZeusTransformUtils.instanceOf(r5, C0699b.class) == true) goto L8;
                    return false;
                L8:
                    C0699b r6 = (C0699b) ZeusTransformUtils.preCheckCast(r5, C0699b.class, "com.obric.aiagent.plugin");
                    if (d.h.b.o.a(this.f27941a, r6.f27941a) == true) goto L12;
                    return false;
                L12:
                    if (d.h.b.o.a(this.f27942b, r6.f27942b) == true) goto L15;
                    return false;
                L15:
                    if (this.f27943c == r6.f27943c) goto L18;
                    return false;
                L18:
                    if (this.f27944d == r6.f27944d) goto L20;
                    return false;
                L20:
                    return true;
                }

                public int hashCode() {
                    return (((((this.f27941a.hashCode() * 31) + this.f27942b.hashCode()) * 31) + Boolean.hashCode(this.f27943c)) * 31) + Boolean.hashCode(this.f27944d);
                }

                public String toString() {
                    return "ExceptionError(result=" + this.f27941a + ", cause=" + this.f27942b + ", shouldRecordBlock=" + this.f27943c + ", blockAbilityInSession=" + this.f27944d + ')';
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String a() {
                    return this.f27941a;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public boolean b() {
                    return this.f27943c;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public boolean c() {
                    return this.f27944d;
                }

                public C0699b(String r2, Throwable r3, boolean r4, boolean r5) {
                    d.h.b.o.e(r2, "result");
                    d.h.b.o.e(r3, "cause");
                    super(null);
                    this.f27941a = r2;
                    this.f27942b = r3;
                    this.f27943c = r4;
                    this.f27944d = r5;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String d() {
                    return aa.b(this.f27942b.getClass()).b();
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String e() {
                    return this.f27942b.getMessage();
                }
            }

            /* JADX INFO: compiled from: StandardModelScriptStep.kt */
            public static final class c extends a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final String f27945a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final String f27946b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final boolean f27947c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private final boolean f27948d;

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String e() {
                    return null;
                }

                public boolean equals(Object r5) {
                    if (this != r5) goto L6;
                    return true;
                L6:
                    if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
                    return false;
                L8:
                    c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
                    if (d.h.b.o.a(this.f27945a, r6.f27945a) == true) goto L12;
                    return false;
                L12:
                    if (d.h.b.o.a(this.f27946b, r6.f27946b) == true) goto L15;
                    return false;
                L15:
                    if (this.f27947c == r6.f27947c) goto L18;
                    return false;
                L18:
                    if (this.f27948d == r6.f27948d) goto L20;
                    return false;
                L20:
                    return true;
                }

                public int hashCode() {
                    return (((((this.f27945a.hashCode() * 31) + this.f27946b.hashCode()) * 31) + Boolean.hashCode(this.f27947c)) * 31) + Boolean.hashCode(this.f27948d);
                }

                public String toString() {
                    return "LocalError(result=" + this.f27945a + ", message=" + this.f27946b + ", shouldRecordBlock=" + this.f27947c + ", blockAbilityInSession=" + this.f27948d + ')';
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String a() {
                    return this.f27945a;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public boolean b() {
                    return this.f27947c;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public boolean c() {
                    return this.f27948d;
                }

                public c(String r2, String r3, boolean r4, boolean r5) {
                    d.h.b.o.e(r2, "result");
                    d.h.b.o.e(r3, "message");
                    super(null);
                    this.f27945a = r2;
                    this.f27946b = r3;
                    this.f27947c = r4;
                    this.f27948d = r5;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String d() {
                    return this.f27946b;
                }
            }

            /* JADX INFO: compiled from: StandardModelScriptStep.kt */
            public static final class d extends a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final String f27949a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final com.obric.autogui.operator.b.EnumC0777b f27950b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final String f27951c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private final boolean f27952d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                private final boolean f27953e;

                public boolean equals(Object r5) {
                    if (this != r5) goto L6;
                    return true;
                L6:
                    if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
                    return false;
                L8:
                    d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
                    if (d.h.b.o.a(this.f27949a, r6.f27949a) == true) goto L12;
                    return false;
                L12:
                    if (this.f27950b == r6.f27950b) goto L15;
                    return false;
                L15:
                    if (d.h.b.o.a(this.f27951c, r6.f27951c) == true) goto L18;
                    return false;
                L18:
                    if (this.f27952d == r6.f27952d) goto L21;
                    return false;
                L21:
                    if (this.f27953e == r6.f27953e) goto L23;
                    return false;
                L23:
                    return true;
                }

                public int hashCode() {
                    int r0 = ((this.f27949a.hashCode() * 31) + this.f27950b.hashCode()) * 31;
                    String r1 = this.f27951c;
                    if (r1 != null) goto L5;
                    int r2 = 0;
                L7:
                    return ((((r0 + r2) * 31) + Boolean.hashCode(this.f27952d)) * 31) + Boolean.hashCode(this.f27953e);
                L5:
                    r2 = r1.hashCode();
                    goto L7
                }

                public String toString() {
                    return "OperationError(result=" + this.f27949a + ", opType=" + this.f27950b + ", detail=" + this.f27951c + ", shouldRecordBlock=" + this.f27952d + ", blockAbilityInSession=" + this.f27953e + ')';
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String a() {
                    return this.f27949a;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public boolean b() {
                    return this.f27952d;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public boolean c() {
                    return this.f27953e;
                }

                public d(String r2, com.obric.autogui.operator.b.EnumC0777b r3, String r4, boolean r5, boolean r6) {
                    d.h.b.o.e(r2, "result");
                    d.h.b.o.e(r3, "opType");
                    super(null);
                    this.f27949a = r2;
                    this.f27950b = r3;
                    this.f27951c = r4;
                    this.f27952d = r5;
                    this.f27953e = r6;
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String d() {
                    return this.f27950b.name();
                }

                @Override // com.obric.autogui.agents.vlm.models.impl.l.b.a
                public String e() {
                    return this.f27951c;
                }
            }

            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            public abstract String a();

            public abstract boolean b();

            public abstract boolean c();

            public abstract String d();

            public abstract String e();

            public String f() {
                return null;
            }

            private a() {
                super(null);
            }

            public final String g() {
                Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.e(new String[]{d(), e()}), Iterable.class, "com.obric.aiagent.plugin");
                Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
                Iterator<T> r13 = r12.iterator();
            L4:
                if (r13.hasNext() == false) goto L9;
                T r3 = r13.next();
                if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
                r0.add(r3);
                goto L4
            L9:
                return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(": ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
            }

            public final String h() {
                Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.e(new String[]{d(), e(), f()}), Iterable.class, "com.obric.aiagent.plugin");
                Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
                Iterator<T> r12 = r11.iterator();
            L4:
                if (r12.hasNext() == false) goto L9;
                T r3 = r12.next();
                if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
                r0.add(r3);
                goto L4
            L9:
                return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(": ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.l$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: StandardModelScriptStep.kt */
        public static final class C0700b<T> extends b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final T f27954a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0700b.class) == true) goto L8;
                return false;
            L8:
                C0700b r6 = (C0700b) ZeusTransformUtils.preCheckCast(r5, C0700b.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f27954a, r6.f27954a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                T r0 = this.f27954a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public String toString() {
                return "Success(data=" + this.f27954a + ')';
            }

            public C0700b(T r2) {
                super(null);
                this.f27954a = r2;
            }

            public final T a() {
                return this.f27954a;
            }
        }

        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: StandardModelScriptStep.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27955a = null;

        static {
            int[] r0 = new int[com.obric.autogui.operator.a.b.e.a.values().length];
            r0[com.obric.autogui.operator.a.b.e.a.f29659b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[com.obric.autogui.operator.a.b.e.a.f29660c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[com.obric.autogui.operator.a.b.e.a.f29661d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[com.obric.autogui.operator.a.b.e.a.f29662e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f27955a = r0;
        }
    }

    /* JADX INFO: compiled from: StandardModelScriptStep.kt */
    @d.c.b.a.f(b = "StandardModelScriptStep.kt", c = {ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION}, d = "executeStep", e = "com.obric.autogui.agents.vlm.models.impl.StandardModelScriptStep")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f27958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ l f27959d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27960e;

        d(l r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27959d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27958c = r3;
            this.f27960e |= Integer.MIN_VALUE;
            return this.f27959d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModelScriptStep.kt */
    public static final class e implements com.obric.autogui.agents.vlm.models.impl.e.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f27961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f27962b;

        e(l r1, com.obric.autogui.session.a r2) {
            this.f27961a = r1;
            this.f27962b = r2;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.e.b.d
        public Context getContext() {
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a().a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.e.b.d
        public com.obric.autogui.agents.vlm.models.impl.d.C0690d a() {
            return l.a(this.f27961a);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.e.b.d
        public com.obric.autogui.agents.vlm.models.impl.d.a b() {
            return l.b(this.f27961a);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.e.b.d
        public String c() {
            return this.f27961a.i();
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.e.b.d
        public l d() {
            return this.f27961a;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.e.b.d
        public void a(String r3, List<com.obric.autogui.operator.e.C0780e> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "newThought");
            d.h.b.o.e(r5, "ops");
            l.a(this.f27961a, this.f27962b, r3, r5);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.e.b.d
        public Object a(com.obric.autogui.operator.b r3, d.c.d<? super com.obric.autogui.operator.c> r4) {
            d.c.d<? super com.obric.autogui.operator.c> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return this.f27961a.a(r3, r5);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.e.b.d
        public b<com.obric.autogui.agents.vlm.models.impl.e.d.b> a(com.obric.autogui.agents.vlm.models.impl.e.f.d r4) {
            d.h.b.o.e(r4, "stats");
            com.obric.autogui.agents.vlm.models.impl.e.d.a r0 = new com.obric.autogui.agents.vlm.models.impl.e.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a().a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
            b<x> r3 = r0.a();
            if (ZeusTransformUtils.instanceOf(r3, b.C0700b.class) == true) goto L7;
            d.h.b.o.a(r3, "null cannot be cast to non-null type com.obric.autogui.agents.vlm.models.impl.StandardModelScriptStep.ScriptLogicResult.ScriptFailure");
            return (b) ZeusTransformUtils.preCheckCast((b.a) ZeusTransformUtils.preCheckCast(r3, b.a.class, "com.obric.aiagent.plugin"), b.class, "com.obric.aiagent.plugin");
        L7:
            return (b) ZeusTransformUtils.preCheckCast(new b.C0700b(r0), b.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f27933c = new a(null);
    }

    public static final /* synthetic */ com.obric.autogui.agents.vlm.models.impl.d.C0690d a(l r0) {
        return r0.f27934d;
    }

    public static final /* synthetic */ void a(l r2, com.obric.autogui.session.a r3, String r4, List r5) {
        r2.a(r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ com.obric.autogui.agents.vlm.models.impl.d.a b(l r0) {
        return r0.f27935e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(com.obric.autogui.agents.vlm.models.impl.d.C0690d r3, com.obric.autogui.agents.vlm.models.impl.d.a r4, JsonArray r5) {
        com.obric.autogui.agents.vlm.models.impl.d.a r6 = (com.obric.autogui.agents.vlm.models.impl.d.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.agents.vlm.models.impl.d.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "inferenceContext");
        d.h.b.o.e(r6, "genOpsFromResponse");
        d.h.b.o.e(r5, "acParam");
        this.f27934d = r3;
        this.f27935e = r6;
        JsonElement r7 = r5.get(0);
        d.h.a.a r8 = null;
        Object[] r9 = 0;
        Object[] r10 = 0;
        if (r7 == null) goto L5;
        String r11 = r7.getAsString();
    L6:
        this.g = r11;
        JsonElement r12 = r5.get(1);
        if (r12 == null) goto L9;
        JsonObject r13 = r12.getAsJsonObject();
    L10:
        this.h = r13;
        this.i = (com.obric.autogui.agents.vlm.models.impl.e.f.c) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.e.f.a(), com.obric.autogui.agents.vlm.models.impl.e.f.c.class, "com.obric.aiagent.plugin");
        this.j = (com.obric.autogui.agents.vlm.models.impl.e.f.b) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.scripted.impl.l.f27011a, com.obric.autogui.agents.vlm.models.impl.e.f.b.class, "com.obric.aiagent.plugin");
        this.k = new com.obric.autogui.agents.vlm.models.impl.e.c.f();
        this.l = new com.obric.autogui.agents.vlm.models.impl.e.c.b(r8, r10 == true ? 1 : 0, 3, r9 == true ? 1 : 0);
        return;
    L9:
        r13 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public final String E() {
        return this.g;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g
    public Object a(com.obric.autogui.session.a r23, d.c.d<? super com.obric.autogui.operator.g> r24) {
        l r1 = this;
        com.obric.autogui.session.a r8 = r23;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L7;
        d r2 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        if ((r2.f27960e & Integer.MIN_VALUE) == 0) goto L7;
        r2.f27960e -= Integer.MIN_VALUE;
    L8:
        d r7 = r2;
        Object r3 = r7.f27958c;
        Object r10 = d.c.a.b.a();
        int r4 = r7.f27960e;
        boolean r12 = true;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        com.obric.autogui.session.a r5 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r7.f27957b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        l r6 = (l) ZeusTransformUtils.preCheckCast(r7.f27956a, l.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: CancellationException -> L14
        r8 = r5;
        r1 = r6;
    L22:
        com.obric.autogui.operator.g r9 = (com.obric.autogui.operator.g) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L108
        String r11 = null;
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.agents.vlm.models.impl.e.b.a.class) == false) goto L26;
        com.obric.autogui.agents.vlm.models.impl.e.b.a r13 = (com.obric.autogui.agents.vlm.models.impl.e.b.a) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.agents.vlm.models.impl.e.b.a.class, "com.obric.aiagent.plugin");
    L27:
        if (r13 == null) goto L29;
        List<String> r14 = r13.h();
    L30:
        if (r13 == null) goto L32;
        String r15 = r13.i();
    L33:
        if (r13 == null) goto L35;
        String r16 = r13.j();
    L37:
        if (r9.a() == true) goto L39;
        StringBuilder r17 = new StringBuilder();
        r17.append(r1.g + "执行成功");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L80;
    L83:
        boolean r19 = true;
    L84:
        if (r19 == true) goto L86;
        r17.append("，返回内容: " + d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null));
    L86:
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
        if (r20 != null) goto L89;
    L92:
        boolean r21 = true;
    L93:
        if (r21 == true) goto L95;
        r17.append("，脚本错误: " + r15);
    L95:
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin");
        if (r22 != null) goto L98;
    L101:
        if (r12 == true) goto L103;
        r17.append(12290 + r16);
    L103:
        String r25 = r17.toString();
        d.h.b.o.c(r25, "toString(...)");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L106;
        Loog.INSTANCE.d(TAG, r25);
    L106:
        r1.i(r25);
    L107:
        return r9;
    L98:
        if (r22.length() == 0) goto L101;
        r12 = false;
        goto L101
    L89:
        if (r20.length() == 0) goto L92;
        r21 = false;
        goto L93
    L80:
        if (r18.isEmpty() == true) goto L83;
        r19 = false;
        goto L84
    L39:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.operator.k.class) == false) goto L41;
        r11 = ((com.obric.autogui.operator.k) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.operator.k.class, "com.obric.aiagent.plugin")).a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.f27934d.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L41:
        StringBuilder r26 = new StringBuilder();
        r26.append("执行失败");
        CharSequence r110 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r110 != null) goto L44;
    L47:
        boolean r111 = true;
    L48:
        if (r111 == true) goto L50;
        r26.append(": " + r11);
    L50:
        CharSequence r27 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
        if (r27 != null) goto L53;
    L56:
        boolean r28 = true;
    L57:
        if (r28 == true) goto L59;
        r26.append("。脚本错误: " + r15);
    L59:
        Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin");
        if (r29 != null) goto L62;
    L65:
        boolean r30 = true;
    L66:
        if (r30 == true) goto L68;
        r26.append("。返回内容: " + d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null));
    L68:
        CharSequence r31 = (CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin");
        if (r31 != null) goto L71;
    L74:
        if (r12 == true) goto L76;
        r26.append(12290 + r16);
    L76:
        String r32 = r26.toString();
        d.h.b.o.c(r32, "toString(...)");
        r1.i(r32);
        goto L107
    L71:
        if (r31.length() == 0) goto L74;
        r12 = false;
        goto L74
    L62:
        if (r29.isEmpty() == true) goto L65;
        r30 = false;
        goto L66
    L53:
        if (r27.length() == 0) goto L56;
        r28 = false;
        goto L57
    L44:
        if (r110.length() == 0) goto L47;
        r111 = false;
        goto L48
    L35:
        r16 = null;
        goto L37
    L32:
        r15 = null;
        goto L33
    L29:
        r14 = null;
        goto L30
    L26:
        r13 = null;
    L108:
        CancellationException e2 = e;
    L109:
        BizStatus r33 = r8.m().e().b();
        if (r33 != BizStatus.USER_INTERRUPTED) goto L114;
        r1.a((com.obric.autogui.operator.g) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.i(true, false, 0, 4, null), com.obric.autogui.operator.g.class, "com.obric.aiagent.plugin"));
        r1.i("剧本执行已被用户中断，部分操作可能已经执行。请以当前页面状态为准重新判断下一步，不要假设剧本完全未执行或直接从头重复执行。");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L114;
        Loog.INSTANCE.d(TAG, "Recorded script interruption feedback for model. ability=" + r1.g + ", status=" + r33);
    L114:
        throw e2;
    L14:
        e2 = e;
        r8 = r5;
        r1 = r6;
        goto L109
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r3);
        com.obric.autogui.agents.vlm.models.impl.e.b.e r34 = new com.obric.autogui.agents.vlm.models.impl.e.b.e((com.obric.autogui.agents.vlm.models.impl.e.e.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.e.e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.f27934d.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), com.obric.autogui.agents.vlm.models.impl.e.e.b.class, "com.obric.aiagent.plugin"), (com.obric.autogui.agents.vlm.models.impl.e.a.d) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.e.a.e(), com.obric.autogui.agents.vlm.models.impl.e.a.d.class, "com.obric.aiagent.plugin"), (com.obric.autogui.agents.vlm.models.impl.e.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.e.a.c(), com.obric.autogui.agents.vlm.models.impl.e.a.b.class, "com.obric.aiagent.plugin"), (com.obric.autogui.agents.vlm.models.impl.e.c.e) ZeusTransformUtils.preCheckCast(r1.k, com.obric.autogui.agents.vlm.models.impl.e.c.e.class, "com.obric.aiagent.plugin"), (com.obric.autogui.agents.vlm.models.impl.e.c.a) ZeusTransformUtils.preCheckCast(r1.l, com.obric.autogui.agents.vlm.models.impl.e.c.a.class, "com.obric.aiagent.plugin"), r1.i, r1.j);
        e r35 = new e(r1, r8);
        String r36 = r1.g;     // Catch: CancellationException -> L108
        JsonObject r37 = r1.h;     // Catch: CancellationException -> L108
        com.obric.autogui.agents.vlm.models.impl.e.b.d r38 = (com.obric.autogui.agents.vlm.models.impl.e.b.d) ZeusTransformUtils.preCheckCast(r35, com.obric.autogui.agents.vlm.models.impl.e.b.d.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L108
        r7.f27956a = r1;     // Catch: CancellationException -> L108
        r7.f27957b = r8;     // Catch: CancellationException -> L108
        r7.f27960e = 1;     // Catch: CancellationException -> L108
        r3 = r34.a(r23, r36, r37, r38, r7);     // Catch: CancellationException -> L108
        if (r3 != r10) goto L22;
        return r10;
    L7:
        r2 = new d(r1, r0);
        goto L8
    }

    private final void a(com.obric.autogui.session.a r23, String r24, List<com.obric.autogui.operator.e.C0780e> r25) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        f(r24);
        a().clear();
        a(0);
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L75;
        com.obric.autogui.operator.e.C0780e r3 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.a.b.b.a r7 = null;
        com.obric.autogui.operator.a.b.e.b r8 = null;
        if (r3.a() == com.obric.autogui.operator.b.EnumC0777b.f29870b) goto L7;
        if (r3.a() != com.obric.autogui.operator.b.EnumC0777b.j) goto L4;
        com.obric.autogui.operator.b.a r4 = r3.b();
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.operator.a.b.e.b.class) == false) goto L36;
        r8 = (com.obric.autogui.operator.a.b.e.b) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.operator.a.b.e.b.class, "com.obric.aiagent.plugin");
    L36:
        if (r8 == null) goto L4;
        a(r8.d());
        if (r8.a() != com.obric.autogui.operator.a.b.e.a.f29658a) goto L40;
        PointF r5 = r8.b();
        PointF r6 = r8.c();
    L62:
        if (r5.x <= 0.0f) goto L64;
    L65:
        PointF r9 = AODeviceSpecificTools.INSTANCE.normaliseOperatingSpacePosition(r5);
        if (r9 == null) goto L69;
        a().add(r9);
    L69:
        if (r6.x > 0.0f) goto L72;
        if (r6.y <= 0.0f) goto L4;
    L72:
        PointF r10 = AODeviceSpecificTools.INSTANCE.normaliseOperatingSpacePosition(r6);
        if (r10 == null) goto L4;
        a().add(r10);
        goto L4
    L64:
        if (r5.y <= 0.0f) goto L69;
    L40:
        d.m<Integer, Integer> r11 = AODeviceSpecificTools.INSTANCE.getScreenDimensions();
        if (r11 == null) goto L60;
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(r11.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
        float r13 = r12 / 2.0f;
        float r14 = ((Number) ZeusTransformUtils.preCheckCast(r11.b(), Number.class, "com.obric.aiagent.plugin")).intValue() / 2.0f;
        if (r8.e() <= 0) goto L45;
        int r15 = r8.e();
    L46:
        float r16 = r15 / 2.0f;
        int r17 = c.f27955a[r8.a().ordinal()];
        if (r17 != 1) goto L49;
        PointF r18 = new PointF(r13, r14 + r16);
        PointF r19 = new PointF(r13, r14 - r16);
    L59:
        r5 = r18;
        r6 = r19;
        goto L62
    L49:
        if (r17 != 2) goto L51;
        r18 = new PointF(r13, r14 - r16);
        r19 = new PointF(r13, r14 + r16);
        goto L59
    L51:
        if (r17 != 3) goto L53;
        r18 = new PointF(r13 + r16, r14);
        r19 = new PointF(r13 - r16, r14);
        goto L59
    L53:
        if (r17 == 4) goto L55;
        r5 = new PointF();
        r6 = new PointF();
        goto L62
    L55:
        r18 = new PointF(r13 - r16, r14);
        r19 = new PointF(r13 + r16, r14);
        goto L59
    L45:
        r15 = r12 / 2;
        goto L46
    L60:
        r5 = new PointF();
        r6 = new PointF();
        goto L62
    L7:
        com.obric.autogui.operator.b.a r20 = r3.b();
        if (ZeusTransformUtils.instanceOf(r20, com.obric.autogui.operator.a.b.b.a.class) == false) goto L10;
        r7 = (com.obric.autogui.operator.a.b.b.a) ZeusTransformUtils.preCheckCast(r20, com.obric.autogui.operator.a.b.b.a.class, "com.obric.aiagent.plugin");
    L10:
        float r21 = -1.0f;
        if (r7 == null) goto L17;
        com.obric.autogui.operator.a.a.e r22 = r7.b();
        if (r22 == null) goto L17;
        com.obric.autogui.operator.a.a.f r26 = r22.a();
        if (r26 == null) goto L17;
        float r27 = r26.a();
    L18:
        if (r7 == null) goto L25;
        com.obric.autogui.operator.a.a.e r28 = r7.b();
        if (r28 == null) goto L25;
        com.obric.autogui.operator.a.a.f r29 = r28.a();
        if (r29 == null) goto L25;
        r21 = r29.b();
    L25:
        if (r27 < 0.0f) goto L4;
        if (r21 < 0.0f) goto L4;
        PointF r30 = AODeviceSpecificTools.INSTANCE.normaliseOperatingSpacePosition(new PointF(r27, r21));
        if (r30 == null) goto L4;
        a().add(r30);
    L17:
        r27 = -1.0f;
        goto L18
    L75:
        com.obric.autogui.b.a.f28928a.onAgentStep(r23.d(), new IAutoActionAgentEventListener.AgentStepInfo(d(), e(), w(), z(), !B(), A(), f(), C().getIdentifier(), h(), AOSystemTools.INSTANCE.nowTimeMillis(), 0, g(), 1024, null));
    }

    @Override // com.obric.autogui.operator.e
    public Object a(com.obric.autogui.operator.b r3, d.c.d<? super com.obric.autogui.operator.c> r4) {
        return super.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.operator.e
    public void x() {
        super.x();
    }
}
