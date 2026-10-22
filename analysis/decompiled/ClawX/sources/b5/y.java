package b5;

import org.bouncycastle.crypto.hpke.HPKE;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final x f918b = new x();

    /* renamed from: a, reason: collision with root package name */
    public final short f919a;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.p.g(this.f919a & HPKE.aead_EXPORT_ONLY, ((y) obj).f919a & HPKE.aead_EXPORT_ONLY);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof y) {
            return this.f919a == ((y) obj).f919a;
        }
        return false;
    }

    public final int hashCode() {
        return Short.hashCode(this.f919a);
    }

    public final String toString() {
        return String.valueOf(this.f919a & HPKE.aead_EXPORT_ONLY);
    }
}
