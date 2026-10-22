package com.obric.autogui.operator.a.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OpenAppStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29521a = null;
    private static final c i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f29522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f29523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f29524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autogui.common.a.b f29525e;
    private final String f;
    private final boolean g;
    private final com.obric.autogui.operator.a.b.a.b.a h;

    /* JADX INFO: compiled from: OpenAppStatus.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final c a() {
            return c.g();
        }
    }

    public c() {
        this(null, null, null, null, null, false, null, 127, null);
    }

    public static /* synthetic */ c a(c r9, b r10, String r11, String r12, com.obric.autogui.common.a.b r13, String r14, boolean r15, com.obric.autogui.operator.a.b.a.b.a r16, int r17, Object r18) {
        com.obric.autogui.operator.a.b.a.b.a r1 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.wrapperContextForParams(r16, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
        if ((r17 & 1) == 0) goto L5;
        b r2 = r9.f29522b;
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r3 = r9.f29523c;
    L11:
        if ((r17 & 4) == 0) goto L13;
        String r4 = r9.f29524d;
    L15:
        if ((r17 & 8) == 0) goto L17;
        com.obric.autogui.common.a.b r5 = r9.f29525e;
    L19:
        if ((r17 & 16) == 0) goto L21;
        String r6 = r9.f;
    L23:
        if ((r17 & 32) == 0) goto L25;
        boolean r7 = r9.g;
    L27:
        if ((r17 & 64) == 0) goto L30;
        r1 = r9.h;
    L30:
        return r9.a(r2, r3, r4, r5, r6, r7, r1);
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final c a(b r9, String r10, String r11, com.obric.autogui.common.a.b r12, String r13, boolean r14, com.obric.autogui.operator.a.b.a.b.a r15) {
        com.obric.autogui.operator.a.b.a.b.a r7 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
        o.e(r9, "reason");
        o.e(r10, "messageForUser");
        o.e(r12, "postExecAction");
        return new c(r9, r10, r11, r12, r13, r14, r7);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f29522b == r6.f29522b) goto L12;
        return false;
    L12:
        if (o.a(this.f29523c, r6.f29523c) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f29524d, r6.f29524d) == true) goto L18;
        return false;
    L18:
        if (this.f29525e == r6.f29525e) goto L21;
        return false;
    L21:
        if (o.a(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (this.g == r6.g) goto L27;
        return false;
    L27:
        if (o.a(this.h, r6.h) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f29522b.hashCode() * 31) + this.f29523c.hashCode()) * 31;
        String r1 = this.f29524d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.f29525e.hashCode()) * 31;
        String r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Boolean.hashCode(this.g)) * 31;
        com.obric.autogui.operator.a.b.a.b.a r8 = this.h;
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
        return "OpenAppStatus(reason=" + this.f29522b + ", messageForUser=" + this.f29523c + ", debugInfo=" + this.f29524d + ", postExecAction=" + this.f29525e + ", expectedPackageName=" + this.f + ", shallTryOtherStrategies=" + this.g + ", opener=" + this.h + ')';
    }

    public c(b r3, String r4, String r5, com.obric.autogui.common.a.b r6, String r7, boolean r8, com.obric.autogui.operator.a.b.a.b.a r9) {
        com.obric.autogui.operator.a.b.a.b.a r10 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "reason");
        o.e(r4, "messageForUser");
        o.e(r6, "postExecAction");
        this.f29522b = r3;
        this.f29523c = r4;
        this.f29524d = r5;
        this.f29525e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r10;
    }

    public static final /* synthetic */ c g() {
        return i;
    }

    public /* synthetic */ c(b r10, String r11, String r12, com.obric.autogui.common.a.b r13, String r14, boolean r15, com.obric.autogui.operator.a.b.a.b.a r16, int r17, h r18) {
        com.obric.autogui.operator.a.b.a.b.a r0 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.wrapperContextForParams(r16, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
        if ((r17 & 1) == 0) goto L5;
        b r1 = b.f29445a;
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r17 & 4) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r17 & 8) == 0) goto L17;
        com.obric.autogui.common.a.b r5 = com.obric.autogui.common.a.b.f28963a;
    L19:
        if ((r17 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r17 & 32) == 0) goto L25;
        boolean r7 = true;
    L27:
        if ((r17 & 64) == 0) goto L29;
        r0 = null;
    L29:
        this(r1, r2, r3, r5, r6, r7, r0);
        return;
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final b a() {
        return this.f29522b;
    }

    public final String b() {
        return this.f29523c;
    }

    public final String c() {
        return this.f29524d;
    }

    public final String d() {
        return this.f;
    }

    public final boolean e() {
        return this.g;
    }

    public final com.obric.autogui.operator.a.b.a.b.a f() {
        return this.h;
    }

    static {
        f29521a = new a(null);
        i = new c(null, null, null, null, null, false, null, 127, null);
    }
}
