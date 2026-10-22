package org.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: compiled from: DumperOptions.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f40306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private EnumC1093a f40307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f40308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f40309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f40310e;
    private int f;
    private int g;
    private boolean h;
    private int i;
    private boolean j;
    private b k;
    private boolean l;
    private boolean m;
    private TimeZone n;
    private int o;
    private boolean p;
    private c q;
    private e r;
    private Map<String, String> s;
    private Boolean t;
    private org.c.a.k.a u;

    /* JADX INFO: renamed from: org.c.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DumperOptions.java */
    public static final enum EnumC1093a extends Enum<EnumC1093a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC1093a f40311a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC1093a f40312b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC1093a f40313c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ EnumC1093a[] f40314e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Boolean f40315d;

        public static EnumC1093a valueOf(String r2) {
            return (EnumC1093a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC1093a.class, r2), EnumC1093a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC1093a[] values() {
            return (EnumC1093a[]) ZeusTransformUtils.preCheckCast(f40314e.clone(), EnumC1093a[].class, "com.obric.aiagent.plugin");
        }

        static {
            EnumC1093a r0 = new EnumC1093a("FLOW", 0, Boolean.TRUE);
            f40311a = r0;
            EnumC1093a r1 = new EnumC1093a("BLOCK", 1, Boolean.FALSE);
            f40312b = r1;
            EnumC1093a r2 = new EnumC1093a("AUTO", 2, null);
            f40313c = r2;
            f40314e = new EnumC1093a[]{r0, r1, r2};
        }

        private EnumC1093a(String r1, int r2, Boolean r3) {
            super(r1, r2);
            this.f40315d = r3;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Flow style: '" + this.f40315d + "'";
        }
    }

    /* JADX INFO: compiled from: DumperOptions.java */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f40316a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f40317b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f40318c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ b[] f40319e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f40320d;

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f40319e.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("WIN", 0, "\r\n");
            f40316a = r0;
            b r1 = new b("MAC", 1, "\r");
            f40317b = r1;
            b r3 = new b("UNIX", 2, "\n");
            f40318c = r3;
            f40319e = new b[]{r0, r1, r3};
        }

        private b(String r1, int r2, String r3) {
            super(r1, r2);
            this.f40320d = r3;
        }

        public String a() {
            return this.f40320d;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Line break: " + name();
        }

        public static b b() {
            String r0 = System.getProperty("line.separator");
            b[] r1 = values();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L9;
            b r4 = r1[r3];
            if (r4.f40320d.equals(r0) == true) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            return r4;
        L9:
            return f40318c;
        }
    }

    /* JADX INFO: compiled from: DumperOptions.java */
    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f40321a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f40322b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ c[] f40323c = null;

        private c(String r1, int r2) {
            super(r1, r2);
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f40323c.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        static {
            c r0 = new c("BINARY", 0);
            f40321a = r0;
            c r1 = new c("ESCAPE", 1);
            f40322b = r1;
            f40323c = new c[]{r0, r1};
        }
    }

    /* JADX INFO: compiled from: DumperOptions.java */
    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f40324a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f40325b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f40326c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f40327d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f40328e = null;
        private static final /* synthetic */ d[] g = null;
        private Character f;

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(g.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        static {
            d r0 = new d("DOUBLE_QUOTED", 0, '\"');
            f40324a = r0;
            d r1 = new d("SINGLE_QUOTED", 1, '\'');
            f40325b = r1;
            d r2 = new d("LITERAL", 2, '|');
            f40326c = r2;
            d r4 = new d("FOLDED", 3, '>');
            f40327d = r4;
            d r6 = new d("PLAIN", 4, null);
            f40328e = r6;
            g = new d[]{r0, r1, r2, r4, r6};
        }

        private d(String r1, int r2, Character r3) {
            super(r1, r2);
            this.f = r3;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Scalar style: '" + this.f + "'";
        }

        public static d a(Character r3) {
            if (r3 == null) goto L4;
            char r0 = r3.charValue();
            if (r0 == '\"') goto L22;
            if (r0 == '\'') goto L20;
            if (r0 == '>') goto L18;
            if (r0 != '|') goto L16;
            return f40326c;
        L16:
            throw new org.c.a.c.c("Unknown scalar style character: " + r3);
        L18:
            return f40327d;
        L20:
            return f40325b;
        L22:
            return f40324a;
        L4:
            return f40328e;
        }
    }

    /* JADX INFO: compiled from: DumperOptions.java */
    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f40329a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f40330b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ e[] f40331d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer[] f40332c;

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f40331d.clone(), e[].class, "com.obric.aiagent.plugin");
        }

        static {
            e r0 = new e("V1_0", 0, new Integer[]{1, 0});
            f40329a = r0;
            e r2 = new e("V1_1", 1, new Integer[]{1, 1});
            f40330b = r2;
            f40331d = new e[]{r0, r2};
        }

        private e(String r1, int r2, Integer[] r3) {
            super(r1, r2);
            this.f40332c = r3;
        }

        public int a() {
            return this.f40332c[0].intValue();
        }

        public String b() {
            return this.f40332c[0] + "." + this.f40332c[1];
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Version: " + b();
        }
    }

    public a() {
        this.f40306a = d.f40328e;
        this.f40307b = EnumC1093a.f40313c;
        this.f40308c = false;
        this.f40309d = true;
        this.f40310e = false;
        this.f = 2;
        this.g = 0;
        this.h = false;
        this.i = 80;
        this.j = true;
        this.k = b.f40318c;
        this.l = false;
        this.m = false;
        this.n = null;
        this.o = 128;
        this.p = false;
        this.q = c.f40321a;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new org.c.a.k.b(0);
    }

    public boolean a() {
        return this.f40309d;
    }

    public void a(int r2) {
        if (r2 < 1) goto L11;
        if (r2 > 10) goto L9;
        this.f = r2;
        return;
    L9:
        throw new org.c.a.c.c("Indent must be at most 10");
    L11:
        throw new org.c.a.c.c("Indent must be at least 1");
    }

    public int b() {
        return this.f;
    }

    public void b(int r2) {
        if (r2 < 0) goto L10;
        if (r2 > 9) goto L8;
        this.g = r2;
        return;
    L8:
        throw new org.c.a.c.c("Indicator indent must be at most Emitter.MAX_INDENT-1: 9");
    L10:
        throw new org.c.a.c.c("Indicator indent must be non-negative.");
    }

    public int c() {
        return this.g;
    }

    public boolean d() {
        return this.h;
    }

    public void a(boolean r1) {
        this.h = r1;
    }

    public void b(boolean r1) {
        this.f40308c = r1;
    }

    public boolean e() {
        return this.f40308c;
    }

    public boolean f() {
        return this.t.booleanValue();
    }

    public int g() {
        return this.i;
    }

    public void c(boolean r1) {
        this.j = r1;
    }

    public boolean h() {
        return this.j;
    }

    public b i() {
        return this.k;
    }

    public void a(EnumC1093a r2) {
        Objects.requireNonNull(r2, "Use FlowStyle enum.");
        this.f40307b = r2;
    }

    public EnumC1093a j() {
        return this.f40307b;
    }

    public void a(b r2) {
        Objects.requireNonNull(r2, "Specify line break.");
        this.k = r2;
    }

    public int k() {
        return this.o;
    }

    public boolean l() {
        return this.p;
    }
}
