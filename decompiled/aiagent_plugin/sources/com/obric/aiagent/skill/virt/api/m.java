package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShellCommandSummary.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21579a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f21582d;

    /* JADX INFO: compiled from: ShellCommandSummary.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f21579a = new a(null);
    }

    public m() {
        this(null, null, 0, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f21580b, r6.f21580b) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f21581c, r6.f21581c) == true) goto L15;
        return false;
    L15:
        if (this.f21582d == r6.f21582d) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f21580b.hashCode() * 31) + this.f21581c.hashCode()) * 31) + Integer.hashCode(this.f21582d);
    }

    public String toString() {
        return "ShellCommandSummary(primaryCommand=" + this.f21580b + ", commandFamily=" + this.f21581c + ", commandCount=" + this.f21582d + ')';
    }

    public m(String r2, String r3, int r4) {
        d.h.b.o.e(r2, "primaryCommand");
        d.h.b.o.e(r3, "commandFamily");
        this.f21580b = r2;
        this.f21581c = r3;
        this.f21582d = r4;
    }

    public /* synthetic */ m(String r2, String r3, int r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "other";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "other";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }

    public final String a() {
        return this.f21580b;
    }

    public final String b() {
        return this.f21581c;
    }

    public final int c() {
        return this.f21582d;
    }
}
