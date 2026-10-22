package androidx.window.layout;

import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final List<a> f2757a;

    /* JADX WARN: Multi-variable type inference failed */
    public m(List<? extends a> displayFeatures) {
        kotlin.jvm.internal.g.f(displayFeatures, "displayFeatures");
        this.f2757a = displayFeatures;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !m.class.equals(obj.getClass())) {
            return false;
        }
        return kotlin.jvm.internal.g.b(this.f2757a, ((m) obj).f2757a);
    }

    public final int hashCode() {
        return this.f2757a.hashCode();
    }

    public final String toString() {
        return kotlin.collections.a.z0(this.f2757a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", null, 56);
    }
}
