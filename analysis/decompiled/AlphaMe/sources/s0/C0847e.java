package s0;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: s0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0847e {

    /* renamed from: i, reason: collision with root package name */
    public static final C0847e f14184i;

    /* renamed from: a, reason: collision with root package name */
    public final u f14185a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f14186b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14187c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14188d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14189e;

    /* renamed from: f, reason: collision with root package name */
    public final long f14190f;

    /* renamed from: g, reason: collision with root package name */
    public final long f14191g;

    /* renamed from: h, reason: collision with root package name */
    public final Set f14192h;

    static {
        u requiredNetworkType = u.f14214a;
        Intrinsics.checkNotNullParameter(requiredNetworkType, "requiredNetworkType");
        Intrinsics.checkNotNullParameter(requiredNetworkType, "requiredNetworkType");
        f14184i = new C0847e(requiredNetworkType, false, false, false, false, -1L, -1L, SetsKt.emptySet());
    }

    public C0847e(C0847e other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.f14186b = other.f14186b;
        this.f14187c = other.f14187c;
        this.f14185a = other.f14185a;
        this.f14188d = other.f14188d;
        this.f14189e = other.f14189e;
        this.f14192h = other.f14192h;
        this.f14190f = other.f14190f;
        this.f14191g = other.f14191g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(C0847e.class, obj.getClass())) {
            return false;
        }
        C0847e c0847e = (C0847e) obj;
        if (this.f14186b == c0847e.f14186b && this.f14187c == c0847e.f14187c && this.f14188d == c0847e.f14188d && this.f14189e == c0847e.f14189e && this.f14190f == c0847e.f14190f && this.f14191g == c0847e.f14191g && this.f14185a == c0847e.f14185a) {
            return Intrinsics.areEqual(this.f14192h, c0847e.f14192h);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((((((this.f14185a.hashCode() * 31) + (this.f14186b ? 1 : 0)) * 31) + (this.f14187c ? 1 : 0)) * 31) + (this.f14188d ? 1 : 0)) * 31) + (this.f14189e ? 1 : 0)) * 31;
        long j4 = this.f14190f;
        int i4 = (iHashCode + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.f14191g;
        return this.f14192h.hashCode() + ((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31);
    }

    public final String toString() {
        return "Constraints{requiredNetworkType=" + this.f14185a + ", requiresCharging=" + this.f14186b + ", requiresDeviceIdle=" + this.f14187c + ", requiresBatteryNotLow=" + this.f14188d + ", requiresStorageNotLow=" + this.f14189e + ", contentTriggerUpdateDelayMillis=" + this.f14190f + ", contentTriggerMaxDelayMillis=" + this.f14191g + ", contentUriTriggers=" + this.f14192h + ", }";
    }

    public C0847e(u requiredNetworkType, boolean z4, boolean z5, boolean z6, boolean z7, long j4, long j5, Set contentUriTriggers) {
        Intrinsics.checkNotNullParameter(requiredNetworkType, "requiredNetworkType");
        Intrinsics.checkNotNullParameter(contentUriTriggers, "contentUriTriggers");
        this.f14185a = requiredNetworkType;
        this.f14186b = z4;
        this.f14187c = z5;
        this.f14188d = z6;
        this.f14189e = z7;
        this.f14190f = j4;
        this.f14191g = j5;
        this.f14192h = contentUriTriggers;
    }
}
