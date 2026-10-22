package com.obric.autoaction.vdplayer.legacy.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r implements com.obric.autoaction.vdplayer.legacy.b.b {

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25944a = null;

        static {
            f25944a = new a();
        }

        private a() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f25945a = null;

        static {
            f25945a = new b();
        }

        private b() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class c extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f25946a = null;

        static {
            f25946a = new c();
        }

        private c() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class d extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f25947a = null;

        static {
            f25947a = new d();
        }

        private d() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class e extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f25948a;

        public e() {
            this(false, 1, null);
        }

        public e(boolean r2) {
            super(null);
            this.f25948a = r2;
        }

        public /* synthetic */ e(boolean r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = true;
        L5:
            this(r1);
        }

        public final boolean a() {
            return this.f25948a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class f extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.vdplayer.api.a.a f25949a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f25949a, r6.f25949a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f25949a.hashCode();
        }

        public String toString() {
            return "OnAgentActionReceived(action=" + this.f25949a + ')';
        }

        public f(com.obric.autogui.vdplayer.api.a.a r2) {
            d.h.b.o.e(r2, "action");
            super(null);
            this.f25949a = r2;
        }

        public final com.obric.autogui.vdplayer.api.a.a a() {
            return this.f25949a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class g extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autoaction.vdplayer.legacy.d.d f25950a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f25950a, r6.f25950a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f25950a.hashCode();
        }

        public String toString() {
            return "OnAgentContextUpdate(context=" + this.f25950a + ')';
        }

        public g(com.obric.autoaction.vdplayer.legacy.d.d r2) {
            d.h.b.o.e(r2, "context");
            super(null);
            this.f25950a = r2;
        }

        public final com.obric.autoaction.vdplayer.legacy.d.d getContext() {
            return this.f25950a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class h extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f25951a;

        public h(boolean r2) {
            super(null);
            this.f25951a = r2;
        }

        public final boolean a() {
            return this.f25951a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class i extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f25952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f25953b;

        public i(String r2, String r3) {
            d.h.b.o.e(r2, "type");
            super(null);
            this.f25952a = r2;
            this.f25953b = r3;
        }

        public final String a() {
            return this.f25953b;
        }

        public final String getType() {
            return this.f25952a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class j extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f25954a = null;

        static {
            f25954a = new j();
        }

        private j() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class k extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f25955a;

        public k(String r2) {
            d.h.b.o.e(r2, "option");
            super(null);
            this.f25955a = r2;
        }

        public final String a() {
            return this.f25955a;
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class l extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f25956a = null;

        static {
            f25956a = new l();
        }

        private l() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class m extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f25957a = null;

        static {
            f25957a = new m();
        }

        private m() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class n extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f25958a = null;

        static {
            f25958a = new n();
        }

        private n() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class o extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f25959a = null;

        static {
            f25959a = new o();
        }

        private o() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VDPlayerIntent.kt */
    public static final class p extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f25960a = null;

        static {
            f25960a = new p();
        }

        private p() {
            super(null);
        }
    }

    public /* synthetic */ r(d.h.b.h r1) {
        this();
    }

    private r() {
    }
}
