package b5;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final m f905b = new m();

    /* renamed from: a, reason: collision with root package name */
    public final byte f906a;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.p.g(this.f906a & 255, ((n) obj).f906a & 255);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f906a == ((n) obj).f906a;
        }
        return false;
    }

    public final int hashCode() {
        return Byte.hashCode(this.f906a);
    }

    public final String toString() {
        return String.valueOf(this.f906a & 255);
    }
}
