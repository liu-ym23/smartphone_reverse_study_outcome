package fg;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f19715h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f19716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f19721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p f19722g;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f19715h = new a(null);
    }

    public p() {
        this.f19716a = new byte[8192];
        this.f19720e = true;
        this.f19719d = false;
    }

    public final void a() {
        p r10 = this.f19722g;
        if (r10 == this) goto L31;
        if (r10 != null) goto L7;
        kotlin.jvm.internal.q.s();
    L7:
        if (r10.f19720e == true) goto L9;
        return;
    L9:
        int r11 = this.f19718c - this.f19717b;
        p r12 = this.f19722g;
        if (r12 != null) goto L12;
        kotlin.jvm.internal.q.s();
    L12:
        int r13 = 8192 - r12.f19718c;
        p r14 = this.f19722g;
        if (r14 != null) goto L16;
        kotlin.jvm.internal.q.s();
    L16:
        if (r14.f19719d == false) goto L18;
        int r15 = 0;
    L23:
        if (r11 <= (r13 + r15)) goto L25;
        return;
    L25:
        p r16 = this.f19722g;
        if (r16 != null) goto L28;
        kotlin.jvm.internal.q.s();
    L28:
        g(r16, r11);
        b();
        q.a(this);
        return;
    L18:
        p r17 = this.f19722g;
        if (r17 != null) goto L21;
        kotlin.jvm.internal.q.s();
    L21:
        r15 = r17.f19717b;
        goto L23
    L31:
        throw new IllegalStateException("cannot compact");
    }

    public final p b() {
        p r10 = this.f19721f;
        if (r10 != this) goto L6;
        r10 = null;
    L6:
        p r11 = this.f19722g;
        if (r11 != null) goto L9;
        kotlin.jvm.internal.q.s();
    L9:
        r11.f19721f = this.f19721f;
        p r12 = this.f19721f;
        if (r12 != null) goto L12;
        kotlin.jvm.internal.q.s();
    L12:
        r12.f19722g = this.f19722g;
        this.f19721f = null;
        this.f19722g = null;
        return r10;
    }

    public final p c(p r10) {
        kotlin.jvm.internal.q.h(r10, "segment");
        r10.f19722g = this;
        r10.f19721f = this.f19721f;
        p r11 = this.f19721f;
        if (r11 != null) goto L5;
        kotlin.jvm.internal.q.s();
    L5:
        r11.f19722g = r10;
        this.f19721f = r10;
        return r10;
    }

    public final p d() {
        this.f19719d = true;
        return new p(this.f19716a, this.f19717b, this.f19718c, true, false);
    }

    public final p e(int r10) {
        if (r10 <= 0) goto L15;
        if (r10 > (this.f19718c - this.f19717b)) goto L15;
        if (r10 < 1024) goto L8;
        p r11 = d();
    L9:
        r11.f19718c = r11.f19717b + r10;
        this.f19717b += r10;
        p r12 = this.f19722g;
        if (r12 != null) goto L12;
        kotlin.jvm.internal.q.s();
    L12:
        r12.c(r11);
        return r11;
    L8:
        r11 = q.b();
        b.a(this.f19716a, this.f19717b, r11.f19716a, 0, r10);
    L15:
        throw new IllegalArgumentException("byteCount out of range");
    }

    public final p f() {
        byte[] r10 = this.f19716a;
        byte[] r11 = Arrays.copyOf(r10, r10.length);
        kotlin.jvm.internal.q.c(r11, "java.util.Arrays.copyOf(this, size)");
        return new p(r11, this.f19717b, this.f19718c, false, true);
    }

    public final void g(p r10, int r11) {
        kotlin.jvm.internal.q.h(r10, "sink");
        if (r10.f19720e == false) goto L18;
        int r12 = r10.f19718c;
        if ((r12 + r11) > 8192) goto L7;
    L15:
        b.a(this.f19716a, this.f19717b, r10.f19716a, r10.f19718c, r11);
        r10.f19718c += r11;
        this.f19717b += r11;
        return;
    L7:
        if (r10.f19719d == true) goto L14;
        int r13 = r10.f19717b;
        if (((r12 + r11) - r13) > 8192) goto L12;
        byte[] r14 = r10.f19716a;
        b.a(r14, r13, r14, 0, r12 - r13);
        r10.f19718c -= r10.f19717b;
        r10.f19717b = 0;
        goto L15
    L12:
        throw new IllegalArgumentException();
    L14:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalStateException("only owner can write");
    }

    public p(byte[] r10, int r11, int r12, boolean r13, boolean r14) {
        kotlin.jvm.internal.q.h(r10, "data");
        this.f19716a = r10;
        this.f19717b = r11;
        this.f19718c = r12;
        this.f19719d = r13;
        this.f19720e = r14;
    }
}
