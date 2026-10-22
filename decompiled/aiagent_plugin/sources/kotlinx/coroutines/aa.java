package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f38824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f38825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d.h.a.b<Throwable, d.x> f38826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f38827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f38828e;

    public static /* synthetic */ aa a(aa r6, Object r7, m r8, d.h.a.b r9, Object r10, Throwable r11, int r12, Object r13) {
        m r14 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.aiagent.plugin");
        d.h.a.b<Throwable, d.x> r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.f38824a;
    L5:
        Object r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r14 = r6.f38825b;
    L8:
        m r2 = r14;
        if ((r12 & 4) == 0) goto L11;
        r15 = r6.f38826c;
    L11:
        d.h.a.b<Throwable, d.x> r3 = r15;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.f38827d;
    L14:
        Object r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r11 = r6.f38828e;
    L18:
        return r6.a(r1, r2, r3, r4, r11);
    }

    public final aa a(Object r8, m r9, d.h.a.b<? super Throwable, d.x> r10, Object r11, Throwable r12) {
        return new aa(r8, (m) ZeusTransformUtils.wrapperContextForParams(r9, m.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin"), r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, aa.class) == true) goto L8;
        return false;
    L8:
        aa r6 = (aa) ZeusTransformUtils.preCheckCast(r5, aa.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f38824a, r6.f38824a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f38825b, r6.f38825b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f38826c, r6.f38826c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f38827d, r6.f38827d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f38828e, r6.f38828e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Object r0 = this.f38824a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        m r4 = this.f38825b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        d.h.a.b<Throwable, d.x> r7 = this.f38826c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Object r10 = this.f38827d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Throwable r13 = this.f38828e;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f38824a + ", cancelHandler=" + this.f38825b + ", onCancellation=" + this.f38826c + ", idempotentResume=" + this.f38827d + ", cancelCause=" + this.f38828e + ')';
    }

    public aa(Object r3, m r4, d.h.a.b<? super Throwable, d.x> r5, Object r6, Throwable r7) {
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        d.h.a.b<Throwable, d.x> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        this.f38824a = r3;
        this.f38825b = r8;
        this.f38826c = r9;
        this.f38827d = r6;
        this.f38828e = r7;
    }

    public /* synthetic */ aa(Object r8, m r9, d.h.a.b r10, Object r11, Throwable r12, int r13, d.h.b.h r14) {
        m r15 = (m) ZeusTransformUtils.wrapperContextForParams(r9, m.class, "com.obric.aiagent.plugin");
        d.h.a.b r16 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r13 & 2) == 0) goto L5;
        m r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        d.h.a.b r4 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        Object r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L17;
        Throwable r6 = null;
    L18:
        this(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r3 = r15;
        goto L7
    }

    public final boolean a() {
        if (this.f38828e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void a(o<?> r2, Throwable r3) {
        m r0 = this.f38825b;
        if (r0 == null) goto L5;
        r2.a(r0, r3);
    L5:
        d.h.a.b<Throwable, d.x> r1 = this.f38826c;
        if (r1 == null) goto L9;
        r2.a(r1, r3);
        return;
    }
}
