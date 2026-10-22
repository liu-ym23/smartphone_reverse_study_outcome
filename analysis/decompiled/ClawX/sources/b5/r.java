package b5;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final q f911b = new q();

    /* renamed from: a, reason: collision with root package name */
    public final int f912a;

    public /* synthetic */ r(int i8) {
        this.f912a = i8;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return kotlin.jvm.internal.p.g(this.f912a ^ Integer.MIN_VALUE, ((r) obj).f912a ^ Integer.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f912a == ((r) obj).f912a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f912a);
    }

    public final String toString() {
        return String.valueOf(this.f912a & 4294967295L);
    }
}
