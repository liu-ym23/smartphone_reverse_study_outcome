package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f26722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f26723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f26724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final s f26725e;
    private final r f;
    private final Long g;
    private final Long h;
    private final c i;
    private final List<p> j;
    private final g k;

    /* JADX INFO: compiled from: ActionEffectTimingModels.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f26721a = new a(null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, v.class) == true) goto L8;
        return false;
    L8:
        v r10 = (v) ZeusTransformUtils.preCheckCast(r9, v.class, "com.obric.aiagent.plugin");
        if (this.f26722b == r10.f26722b) goto L12;
        return false;
    L12:
        if (this.f26723c == r10.f26723c) goto L15;
        return false;
    L15:
        if (this.f26724d == r10.f26724d) goto L18;
        return false;
    L18:
        if (this.f26725e == r10.f26725e) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.h, r10.h) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.i, r10.i) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.j, r10.j) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.k, r10.k) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.f26722b) * 31) + Boolean.hashCode(this.f26723c)) * 31) + Long.hashCode(this.f26724d)) * 31;
        s r1 = this.f26725e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        r r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Long r11 = this.h;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((((r10 + r12) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        g r14 = this.k;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionEffectTimingReport(schemaVersion=" + this.f26722b + ", isFinal=" + this.f26723c + ", lifecycleWallElapsedMs=" + this.f26724d + ", lifecycleFinishReason=" + this.f26725e + ", cancellationReason=" + this.f + ", frameworkRegistrationToCallbackElapsedMs=" + this.g + ", frameworkCallbackProcessingElapsedMs=" + this.h + ", blocking=" + this.i + ", snapshots=" + this.j + ", evaluation=" + this.k + ')';
    }

    public v(int r3, boolean r4, long r5, s r7, r r8, Long r9, Long r10, c r11, List<p> r12, g r13) {
        List<p> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "blocking");
        d.h.b.o.e(r14, "snapshots");
        this.f26722b = r3;
        this.f26723c = r4;
        this.f26724d = r5;
        this.f26725e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r14;
        this.k = r13;
    }

    public final int a() {
        return this.f26722b;
    }

    public final boolean b() {
        return this.f26723c;
    }

    public final long c() {
        return this.f26724d;
    }

    public final s d() {
        return this.f26725e;
    }

    public final r e() {
        return this.f;
    }

    public final Long f() {
        return this.g;
    }

    public final Long g() {
        return this.h;
    }

    public final c h() {
        return this.i;
    }

    public final List<p> i() {
        return this.j;
    }

    public final g j() {
        return this.k;
    }
}
