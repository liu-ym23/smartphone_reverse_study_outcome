package com.obric.aiagent.executionengine.capabilitymanager.data.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: IntentBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0332a f16447a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f16451e;
    private final String f;
    private final boolean g;
    private final int h;
    private final String i;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.capabilitymanager.data.bean.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IntentBean.kt */
    public static final class C0332a {
        public /* synthetic */ C0332a(h r1) {
            this();
        }

        private C0332a() {
        }
    }

    static {
        f16447a = new C0332a(null);
    }

    public String toString() {
        return "IntentBean(name=" + this.f16448b + ", packageName=" + this.f16449c + ", implClassName=" + this.f16450d + ", isStaticRegister=" + this.f16451e + ", key=" + this.f + ", registered=" + this.g + ", state=" + this.h + ", service=" + this.i + ')';
    }

    public a(String r2, String r3, String r4, boolean r5, String r6, boolean r7, int r8, String r9) {
        o.e(r2, "name");
        o.e(r3, "packageName");
        o.e(r4, "implClassName");
        o.e(r6, "key");
        this.f16448b = r2;
        this.f16449c = r3;
        this.f16450d = r4;
        this.f16451e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public final String a() {
        return this.f16448b;
    }

    public final String b() {
        return this.f16449c;
    }

    public final String c() {
        return this.f16450d;
    }

    public final boolean d() {
        return this.f16451e;
    }

    public /* synthetic */ a(String r12, String r13, String r14, boolean r15, String r16, boolean r17, int r18, String r19, int r20, h r21) {
        if ((r20 & 16) == 0) goto L5;
        String r7 = r13 + r12;
    L7:
        if ((r20 & 32) == 0) goto L9;
        boolean r8 = false;
    L11:
        if ((r20 & 64) == 0) goto L13;
        int r9 = 1;
    L15:
        if ((r20 & 128) == 0) goto L17;
        String r10 = null;
    L18:
        this(r12, r13, r14, r15, r7, r8, r9, r10);
        return;
    L17:
        r10 = r19;
        goto L18
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    public final String e() {
        return this.f;
    }

    public final boolean f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final String h() {
        return this.i;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if (o.a(r2, r3) == true) goto L12;
        return false;
    L12:
        o.a(r7, "null cannot be cast to non-null type com.obric.aiagent.executionengine.capabilitymanager.data.bean.IntentBean");
        a r4 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f, ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin")).f) == true) goto L16;
        return false;
    L16:
        if (o.a(this.f16450d, ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin")).f16450d) == false) goto L23;
        if (this.f16451e != ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin")).f16451e) goto L23;
        if (o.a(this.i, ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin")).i) == false) goto L23;
        return true;
    L23:
        return false;
    L8:
        r3 = null;
        goto L10
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f, this.f16450d, this.i});
    }
}
