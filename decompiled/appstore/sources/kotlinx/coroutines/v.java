package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f21763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1 f21764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f21765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f21766e;

    public v(Object r10, l r11, Function1 r12, Object r13, Throwable r14) {
        this.f21762a = r10;
        this.f21763b = r11;
        this.f21764c = r12;
        this.f21765d = r13;
        this.f21766e = r14;
    }

    public static /* synthetic */ v b(v r10, Object r11, l r12, Function1 r13, Object r14, Throwable r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.f21762a;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.f21763b;
    L8:
        l r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.f21764c;
    L11:
        Function1 r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.f21765d;
    L14:
        Object r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.f21766e;
    L17:
        Object r21 = r11;
        return r10.a(r21, r18, r19, r20, r15);
    }

    public final v a(Object r10, l r11, Function1 r12, Object r13, Throwable r14) {
        return new v(r10, r11, r12, r13, r14);
    }

    public final boolean c() {
        if (this.f21766e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(n r10, Throwable r11) {
        l r12 = this.f21763b;
        if (r12 == null) goto L5;
        r10.h(r12, r11);
    L5:
        Function1 r13 = this.f21764c;
        if (r13 == null) goto L9;
        r10.i(r13, r11);
        return;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof v) == true) goto L8;
        return false;
    L8:
        v r11 = (v) r10;
        if (kotlin.jvm.internal.q.b(this.f21762a, r11.f21762a) == true) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.f21763b, r11.f21763b) == true) goto L15;
        return false;
    L15:
        if (kotlin.jvm.internal.q.b(this.f21764c, r11.f21764c) == true) goto L18;
        return false;
    L18:
        if (kotlin.jvm.internal.q.b(this.f21765d, r11.f21765d) == true) goto L21;
        return false;
    L21:
        if (kotlin.jvm.internal.q.b(this.f21766e, r11.f21766e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Object r10 = this.f21762a;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        l r14 = this.f21763b;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Function1 r17 = this.f21764c;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Object r20 = this.f21765d;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        Throwable r23 = this.f21766e;
        if (r23 == null) goto L23;
        r11 = r23.hashCode();
    L23:
        return r22 + r11;
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f21762a + ", cancelHandler=" + this.f21763b + ", onCancellation=" + this.f21764c + ", idempotentResume=" + this.f21765d + ", cancelCause=" + this.f21766e + ')';
    }

    public /* synthetic */ v(Object r10, l r11, Function1 r12, Object r13, Throwable r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 2) == 0) goto L5;
        l r17 = null;
    L7:
        if ((r15 & 4) == 0) goto L9;
        Function1 r18 = null;
    L11:
        if ((r15 & 8) == 0) goto L13;
        Object r19 = null;
    L15:
        if ((r15 & 16) == 0) goto L17;
        Throwable r20 = null;
    L18:
        this(r10, r17, r18, r19, r20);
        return;
    L17:
        r20 = r14;
        goto L18
    L13:
        r19 = r13;
        goto L15
    L9:
        r18 = r12;
        goto L11
    L5:
        r17 = r11;
        goto L7
    }
}
