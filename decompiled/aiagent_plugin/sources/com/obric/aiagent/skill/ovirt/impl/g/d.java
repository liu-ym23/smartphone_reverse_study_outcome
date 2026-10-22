package com.obric.aiagent.skill.ovirt.impl.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.k;
import d.x;

/* JADX INFO: compiled from: ShellOutputSanitiser.kt */
/* JADX INFO: loaded from: classes3.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f21366a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f21367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21368c;

    /* JADX INFO: compiled from: ShellOutputSanitiser.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ShellOutputSanitiser.kt */
    private static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f21369a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f21370b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f21371c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f21372d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f21373e = null;
        public static final b f = null;
        private static final /* synthetic */ b[] g = null;
        private static final /* synthetic */ d.d.a h = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f21369a, f21370b, f21371c, f21372d, f21373e, f};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f21369a = new b("NORMAL", 0);
            f21370b = new b("ESCAPE", 1);
            f21371c = new b("CHARSET", 2);
            f21372d = new b("CSI", 3);
            f21373e = new b("OSC", 4);
            f = new b("OSC_ESC", 5);
            b[] r0 = a();
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

    /* JADX INFO: compiled from: ShellOutputSanitiser.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21374a = null;

        static {
            int[] r0 = new int[b.values().length];
            r0[b.f21369a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[b.f21370b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[b.f21371c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[b.f21372d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[b.f21373e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[b.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f21374a = r0;
        }
    }

    static {
        f21366a = new a(null);
    }

    public d() {
        this.f21367b = b.f21369a;
    }

    public final void a(String r6, d.h.a.b<? super Character, x> r7) {
        d.h.a.b<? super Character, x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r6, "input");
        o.e(r8, "emit");
        int r0 = r6.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        char r2 = r6.charAt(r1);
        b r3 = this.f21367b;
        switch(c.f21374a[r3.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        e(r2);
    L14:
        r1 = r1 + 1;
        goto L3
    L9:
        d(r2);
        goto L14
    L10:
        c(r2);
        goto L14
    L11:
        b(r2);
        goto L14
    L12:
        a(r2);
        goto L14
    L13:
        a(r2, r8);
        goto L14
    L7:
        throw new k();
    }

    private final void a(char r3, d.h.a.b<? super Character, x> r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r3 != 27) goto L5;
        this.f21367b = b.f21370b;
        this.f21368c = 1;
        return;
    L5:
        if (r3 != 155) goto L7;
        this.f21367b = b.f21372d;
        this.f21368c = 1;
        return;
    L7:
        if (r3 == 157) goto L9;
        r5.invoke(Character.valueOf(r3));
        return;
    L9:
        this.f21367b = b.f21373e;
        this.f21368c = 1;
    }

    private final void a(char r2) {
        this.f21368c++;
        if (r2 != '%') goto L5;
    L13:
        b r3 = b.f21371c;
    L14:
        this.f21367b = r3;
        a();
        return;
    L5:
        if (r2 != '[') goto L7;
        r3 = b.f21372d;
        goto L14
    L7:
        if (r2 == ']') goto L11;
        switch(r2) {
            case 40: goto L13;
            case 41: goto L13;
            case 42: goto L13;
            case 43: goto L13;
            default: goto L9;
        };
    L9:
        switch(r2) {
            case 45: goto L13;
            case 46: goto L13;
            case 47: goto L13;
            default: goto L10;
        };
    L10:
        r3 = b.f21369a;
        goto L14
    L11:
        r3 = b.f21373e;
        goto L14
    }

    private final void b(char r1) {
        this.f21368c++;
        this.f21367b = b.f21369a;
        this.f21368c = 0;
    }

    private final void c(char r4) {
        boolean r1 = true;
        this.f21368c++;
        if ('@' <= r4) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        this.f21367b = b.f21369a;
        this.f21368c = 0;
        return;
    L10:
        a();
        return;
    L5:
        if (r4 >= 127) goto L7;
        goto L7
    }

    private final void d(char r2) {
        this.f21368c++;
        if (r2 != 7) goto L5;
        this.f21367b = b.f21369a;
        this.f21368c = 0;
        return;
    L5:
        if (r2 == 27) goto L7;
        a();
        return;
    L7:
        this.f21367b = b.f;
    }

    private final void e(char r2) {
        this.f21368c++;
        if (r2 != '\\') goto L5;
        b r3 = b.f21369a;
    L6:
        this.f21367b = r3;
        if (r3 != b.f21369a) goto L9;
        this.f21368c = 0;
        return;
    L9:
        a();
        return;
    L5:
        r3 = b.f21373e;
        goto L6
    }

    private final void a() {
        if (this.f21368c <= 4096) goto L6;
        this.f21367b = b.f21369a;
        this.f21368c = 0;
        return;
    }
}
