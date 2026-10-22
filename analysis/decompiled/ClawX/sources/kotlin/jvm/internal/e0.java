package kotlin.jvm.internal;

import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e0 implements v5.d {

    /* renamed from: a, reason: collision with root package name */
    public final h f3667a;

    /* renamed from: b, reason: collision with root package name */
    public volatile List f3668b;

    public e0(h hVar) {
        v5.l lVar = v5.l.f5989a;
        this.f3667a = hVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e0) {
            return this.f3667a.equals(((e0) obj).f3667a);
        }
        return false;
    }

    public final int hashCode() {
        return (this.f3667a.hashCode() * 31) + 749883007;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        v5.l lVar = v5.l.f5989a;
        sb.append("PluginConfigT");
        return sb.toString();
    }
}
