package m0;

import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3891a;

    public c(String str) {
        this.f3891a = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        return p.a(this.f3891a, ((c) obj).f3891a);
    }

    public final int hashCode() {
        return this.f3891a.hashCode();
    }

    public final String toString() {
        return this.f3891a;
    }
}
