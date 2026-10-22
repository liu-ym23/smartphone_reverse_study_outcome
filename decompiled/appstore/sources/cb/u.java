package cb;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.obric.capabilitykit.m f6111e;

    public u(long r10, String r11, String r12, int r13, com.obric.capabilitykit.m r14) {
        kotlin.jvm.internal.q.g(r11, "id");
        kotlin.jvm.internal.q.g(r12, "data");
        kotlin.jvm.internal.q.g(r14, "action");
        this.f6107a = r10;
        this.f6108b = r11;
        this.f6109c = r12;
        this.f6110d = r13;
        this.f6111e = r14;
    }

    public final com.obric.capabilitykit.m a() {
        return this.f6111e;
    }

    public final String b() {
        return this.f6109c;
    }

    public final String c() {
        return this.f6108b;
    }

    public final long d() {
        return this.f6107a;
    }

    public final int e() {
        return this.f6110d;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof u) == true) goto L8;
        return false;
    L8:
        u r11 = (u) r10;
        if (this.f6107a == r11.f6107a) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.f6108b, r11.f6108b) == true) goto L15;
        return false;
    L15:
        if (kotlin.jvm.internal.q.b(this.f6109c, r11.f6109c) == true) goto L18;
        return false;
    L18:
        if (this.f6110d == r11.f6110d) goto L21;
        return false;
    L21:
        if (this.f6111e == r11.f6111e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f6107a) * 31) + this.f6108b.hashCode()) * 31) + this.f6109c.hashCode()) * 31) + Integer.hashCode(this.f6110d)) * 31) + this.f6111e.hashCode();
    }

    public String toString() {
        return "EntityHistoryDao(indexId=" + this.f6107a + ", id=" + this.f6108b + ", data=" + this.f6109c + ", type=" + this.f6110d + ", action=" + this.f6111e + ')';
    }

    public /* synthetic */ u(long r10, String r11, String r12, int r13, com.obric.capabilitykit.m r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        r10 = -1;
    L5:
        this(r10, r11, r12, r13, r14);
    }
}
