package com.obric.autogui.vdplayer.api.a;

import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: AgentAction.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.obric.autogui.vdplayer.api.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AgentAction.kt */
    public static final class C0870a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f31676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f31677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f31678c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f31679d;

        public C0870a() {
            this(false, null, null, null, 15, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0870a.class) == true) goto L8;
            return false;
        L8:
            C0870a r6 = (C0870a) ZeusTransformUtils.preCheckCast(r5, C0870a.class, "com.obric.aiagent.plugin");
            if (this.f31676a == r6.f31676a) goto L12;
            return false;
        L12:
            if (o.a(this.f31677b, r6.f31677b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f31678c, r6.f31678c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f31679d, r6.f31679d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f31676a) * 31;
            String r1 = this.f31677b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f31678c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f31679d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "EnterCallUser(supportUserAddition=" + this.f31676a + ", thought=" + this.f31677b + ", actionForUser=" + this.f31678c + ", securityLevel=" + this.f31679d + ')';
        }

        public /* synthetic */ C0870a(boolean r2, String r3, String r4, String r5, int r6, h r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = true;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }

        public final boolean a() {
            return this.f31676a;
        }

        public final String b() {
            return this.f31677b;
        }

        public final String c() {
            return this.f31678c;
        }

        public final String d() {
            return this.f31679d;
        }

        public C0870a(boolean r2, String r3, String r4, String r5) {
            super(null);
            this.f31676a = r2;
            this.f31677b = r3;
            this.f31678c = r4;
            this.f31679d = r5;
        }
    }

    /* JADX INFO: compiled from: AgentAction.kt */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f31680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f31681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<C0871a> f31682c;

        /* JADX INFO: renamed from: com.obric.autogui.vdplayer.api.a.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AgentAction.kt */
        public static final class C0871a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0872a f31683a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f31684b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f31685c;

            /* JADX INFO: renamed from: com.obric.autogui.vdplayer.api.a.a$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: AgentAction.kt */
            public static final class C0872a {
                public /* synthetic */ C0872a(h r1) {
                    this();
                }

                private C0872a() {
                }
            }

            static {
                f31683a = new C0872a(null);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0871a.class) == true) goto L8;
                return false;
            L8:
                C0871a r6 = (C0871a) ZeusTransformUtils.preCheckCast(r5, C0871a.class, "com.obric.aiagent.plugin");
                if (o.a(this.f31684b, r6.f31684b) == true) goto L12;
                return false;
            L12:
                if (o.a(this.f31685c, r6.f31685c) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r0 = this.f31684b.hashCode() * 31;
                String r1 = this.f31685c;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "ClarifyOption(option=" + this.f31684b + ", specialStyle=" + this.f31685c + ')';
            }

            public C0871a(String r2, String r3) {
                o.e(r2, "option");
                this.f31684b = r2;
                this.f31685c = r3;
            }

            public final String a() {
                return this.f31684b;
            }

            public final String b() {
                return this.f31685c;
            }
        }

        public b() {
            this(null, null, null, 7, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f31680a, r6.f31680a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f31681b, r6.f31681b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f31682c, r6.f31682c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.f31680a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f31681b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            List<C0871a> r7 = this.f31682c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "EnterClarify(thought=" + this.f31680a + ", securityLevel=" + this.f31681b + ", options=" + this.f31682c + ')';
        }

        public /* synthetic */ b(String r2, String r3, List r4, int r5, h r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r7 = null;
        L11:
            this(r2, r3, r7);
        }

        public final String a() {
            return this.f31680a;
        }

        public final String b() {
            return this.f31681b;
        }

        public final List<C0871a> c() {
            return this.f31682c;
        }

        public b(String r3, String r4, List<C0871a> r5) {
            List<C0871a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            super(null);
            this.f31680a = r3;
            this.f31681b = r4;
            this.f31682c = r6;
        }
    }

    /* JADX INFO: compiled from: AgentAction.kt */
    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f31686a = null;

        static {
            f31686a = new c();
        }

        private c() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: AgentAction.kt */
    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f31687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f31688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f31689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f31690d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f31691e;
        private final String f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (this.f31687a == r6.f31687a) goto L12;
            return false;
        L12:
            if (this.f31688b == r6.f31688b) goto L15;
            return false;
        L15:
            if (o.a(this.f31689c, r6.f31689c) == true) goto L18;
            return false;
        L18:
            if (this.f31690d == r6.f31690d) goto L21;
            return false;
        L21:
            if (this.f31691e == r6.f31691e) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((Boolean.hashCode(this.f31687a) * 31) + Boolean.hashCode(this.f31688b)) * 31) + this.f31689c.hashCode()) * 31) + Boolean.hashCode(this.f31690d)) * 31) + Boolean.hashCode(this.f31691e)) * 31;
            String r2 = this.f;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "TaskEnd(isSuccess=" + this.f31687a + ", isUserTerm=" + this.f31688b + ", thought=" + this.f31689c + ", openApp=" + this.f31690d + ", exitWithCountDown=" + this.f31691e + ", securityLevel=" + this.f + ')';
        }

        public /* synthetic */ d(boolean r8, boolean r9, String r10, boolean r11, boolean r12, String r13, int r14, h r15) {
            if ((r14 & 4) == 0) goto L5;
            r10 = "";
        L5:
            String r3 = r10;
            if ((r14 & 8) == 0) goto L8;
            boolean r4 = false;
        L10:
            if ((r14 & 16) == 0) goto L12;
            boolean r5 = false;
        L14:
            if ((r14 & 32) == 0) goto L16;
            r13 = null;
        L16:
            this(r8, r9, r3, r4, r5, r13);
            return;
        L12:
            r5 = r12;
            goto L14
        L8:
            r4 = r11;
            goto L10
        }

        public final boolean a() {
            return this.f31687a;
        }

        public final boolean b() {
            return this.f31688b;
        }

        public final String c() {
            return this.f31689c;
        }

        public final boolean d() {
            return this.f31690d;
        }

        public final String e() {
            return this.f;
        }

        public d(boolean r2, boolean r3, String r4, boolean r5, boolean r6, String r7) {
            o.e(r4, VDPlayerEffectProviderImpl.KEY_THOUGHT);
            super(null);
            this.f31687a = r2;
            this.f31688b = r3;
            this.f31689c = r4;
            this.f31690d = r5;
            this.f31691e = r6;
            this.f = r7;
        }
    }

    /* JADX INFO: compiled from: AgentAction.kt */
    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f31692a = null;

        static {
            f31692a = new e();
        }

        private e() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: AgentAction.kt */
    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f31693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f31694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<Float> f31695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<Float> f31696d;

        public f() {
            this(null, false, null, null, 15, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (o.a(this.f31693a, r6.f31693a) == true) goto L12;
            return false;
        L12:
            if (this.f31694b == r6.f31694b) goto L15;
            return false;
        L15:
            if (o.a(this.f31695c, r6.f31695c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f31696d, r6.f31696d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            String r0 = this.f31693a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + Boolean.hashCode(this.f31694b)) * 31;
            List<Float> r4 = this.f31695c;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            List<Float> r7 = this.f31696d;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "TaskRunning(thought=" + this.f31693a + ", supportUserAddition=" + this.f31694b + ", swipePos=" + this.f31695c + ", clickPos=" + this.f31696d + ')';
        }

        public /* synthetic */ f(String r2, boolean r3, List r4, List r5, int r6, h r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = true;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r8 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r9 = null;
        L14:
            this(r2, r3, r8, r9);
        }

        public final String a() {
            return this.f31693a;
        }

        public final boolean b() {
            return this.f31694b;
        }

        public final List<Float> c() {
            return this.f31695c;
        }

        public final List<Float> d() {
            return this.f31696d;
        }

        public f(String r3, boolean r4, List<Float> r5, List<Float> r6) {
            List<Float> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            List<Float> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            super(null);
            this.f31693a = r3;
            this.f31694b = r4;
            this.f31695c = r7;
            this.f31696d = r8;
        }
    }

    public /* synthetic */ a(h r1) {
        this();
    }

    private a() {
    }
}
