package com.obric.aiagent.skill.ovirt.impl.g;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.x;

/* JADX INFO: compiled from: ShellOutputSanitiser.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f21419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f21420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f21421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f21422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StringBuilder f21423e;

    private final boolean a(char r3) {
        if (r3 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L19;
        if (128 <= r3) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L19;
        if (r3 == 127) goto L19;
    L28:
        return false;
    L12:
        if (r3 >= 160) goto L14;
        r2 = true;
    L19:
        if (r3 == '\n') goto L28;
        if (r3 == '\r') goto L28;
        if (r3 == '\b') goto L28;
        if (r3 == '\t') goto L28;
        return true;
    L5:
        if (r3 >= ' ') goto L7;
        r1 = true;
        goto L8
    }

    public static /* synthetic */ x lambda$OSJPBjhZVfnm673cUiqpRgmUhI4(h r0, z.a r1, char r2) {
        return a(r0, r1, r2);
    }

    public h() {
        this.f21419a = new StringBuilder();
        this.f21420b = new StringBuilder();
        this.f21421c = new d();
        this.f21423e = new StringBuilder();
    }

    public final g a(String r4) {
        o.e(r4, MonitorConstants.CHUNK);
        d.o.o.a(this.f21423e);
        final z.a r0 = new z.a();
        this.f21421c.a(r4, new $$Lambda$h$OSJPBjhZVfnm673cUiqpRgmUhI4(this, r0));
        if (r0.f38499a == true) goto L7;
        String r3 = this.f21423e.toString();
        o.c(r3, "toString(...)");
        return (g) ZeusTransformUtils.preCheckCast(new g.a(r3), g.class, "com.obric.aiagent.plugin");
    L7:
        return (g) ZeusTransformUtils.preCheckCast(new g.b(a()), g.class, "com.obric.aiagent.plugin");
    }

    private static final x a(h r1, z.a r2, char r3) {
        if (r1.a(r3, r1.f21423e) == false) goto L6;
        r2.f38499a = true;
    L6:
        return x.f38692a;
    }

    public final String a() {
        StringBuilder r1 = new StringBuilder(this.f21419a.length() + this.f21420b.length());
        r1.append((CharSequence) ZeusTransformUtils.preCheckCast(this.f21419a, CharSequence.class, "com.obric.aiagent.plugin"));
        r1.append((CharSequence) ZeusTransformUtils.preCheckCast(this.f21420b, CharSequence.class, "com.obric.aiagent.plugin"));
        String r4 = r1.toString();
        o.c(r4, "toString(...)");
        return r4;
    }

    private final boolean a(char r5, StringBuilder r6) {
        if (r5 != '\r') goto L5;
        this.f21422d = true;
    L30:
        return false;
    L5:
        switch(r5) {
            case 8: goto L20;
            case 9: goto L17;
            case 10: goto L15;
            default: goto L7;
        };
    L15:
        this.f21419a.append((CharSequence) ZeusTransformUtils.preCheckCast(this.f21420b, CharSequence.class, "com.obric.aiagent.plugin"));
        this.f21419a.append('\n');
        d.o.o.a(this.f21420b);
        this.f21422d = false;
        r6.append('\n');
        goto L30
    L17:
        boolean r1 = b();
        this.f21420b.append(r5);
        if (r1 == true) goto L31;
        r6.append(r5);
        return r1;
    L31:
        return r1;
    L20:
        this.f21422d = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f21420b, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L30;
        StringBuilder r4 = this.f21420b;
        o.c(r4.deleteCharAt(d.o.o.e((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))), "deleteCharAt(...)");
        return true;
    L23:
        r7 = false;
        goto L24
    L7:
        if (a(r5) == true) goto L9;
        boolean r2 = b();
    L11:
        if (a(r5) == true) goto L27;
        this.f21420b.append(r5);
        if (r2 == true) goto L28;
        r6.append(r5);
        return r2;
    L28:
        return r2;
    L27:
        return r2;
    L9:
        r2 = false;
        goto L11
    }

    private final boolean b() {
        boolean r1 = false;
        if (this.f21422d == true) goto L5;
        return false;
    L5:
        this.f21422d = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f21420b, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L8;
        r1 = true;
    L8:
        d.o.o.a(this.f21420b);
        return r1;
    }
}
