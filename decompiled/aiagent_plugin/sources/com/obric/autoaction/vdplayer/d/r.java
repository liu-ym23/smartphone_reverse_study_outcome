package com.obric.autoaction.vdplayer.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r implements com.obric.autoaction.vdplayer.c.b {

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25539a = null;

        static {
            f25539a = new a();
        }

        private a() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f25540a = null;

        static {
            f25540a = new b();
        }

        private b() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class c extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f25541a = null;

        static {
            f25541a = new c();
        }

        private c() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class d extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f25542a = null;

        static {
            f25542a = new d();
        }

        private d() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class e extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f25543a = null;

        static {
            f25543a = new e();
        }

        private e() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class f extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f25544a;

        public f() {
            this(false, 1, null);
        }

        public f(boolean r2) {
            super(null);
            this.f25544a = r2;
        }

        public /* synthetic */ f(boolean r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = true;
        L5:
            this(r1);
        }

        public final boolean a() {
            return this.f25544a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class g extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.vdplayer.api.a.a f25545a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f25545a, r6.f25545a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f25545a.hashCode();
        }

        public String toString() {
            return "OnAgentActionReceived(action=" + this.f25545a + ')';
        }

        public g(com.obric.autogui.vdplayer.api.a.a r2) {
            d.h.b.o.e(r2, "action");
            super(null);
            this.f25545a = r2;
        }

        public final com.obric.autogui.vdplayer.api.a.a a() {
            return this.f25545a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class h extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autoaction.vdplayer.d.d f25546a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
            return false;
        L8:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f25546a, r6.f25546a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f25546a.hashCode();
        }

        public String toString() {
            return "OnAgentContextUpdate(context=" + this.f25546a + ')';
        }

        public h(com.obric.autoaction.vdplayer.d.d r2) {
            d.h.b.o.e(r2, "context");
            super(null);
            this.f25546a = r2;
        }

        public final com.obric.autoaction.vdplayer.d.d getContext() {
            return this.f25546a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class i extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f25547a;

        public i(boolean r2) {
            super(null);
            this.f25547a = r2;
        }

        public final boolean a() {
            return this.f25547a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class j extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f25548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f25549b;

        public j(String r2, String r3) {
            d.h.b.o.e(r2, "type");
            super(null);
            this.f25548a = r2;
            this.f25549b = r3;
        }

        public final String a() {
            return this.f25549b;
        }

        public final String getType() {
            return this.f25548a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class k extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f25550a = null;

        static {
            f25550a = new k();
        }

        private k() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class l extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f25551a = null;

        static {
            f25551a = new l();
        }

        private l() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class m extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f25552a;

        public m(String r2) {
            d.h.b.o.e(r2, "option");
            super(null);
            this.f25552a = r2;
        }

        public final String a() {
            return this.f25552a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class n extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f25553a = null;

        static {
            f25553a = new n();
        }

        private n() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class o extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f25554a = null;

        static {
            f25554a = new o();
        }

        private o() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class p extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f25555a = null;

        static {
            f25555a = new p();
        }

        private p() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class q extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f25556a = null;

        static {
            f25556a = new q();
        }

        private q() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.d.r$r, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class C0625r extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0625r f25557a = null;

        static {
            f25557a = new C0625r();
        }

        private C0625r() {
            super(null);
        }
    }

    public /* synthetic */ r(d.h.b.h r1) {
        this();
    }

    private r() {
    }
}
