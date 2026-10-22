package q1;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f11486a = new LinkedHashMap();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: q1.a$a, reason: collision with other inner class name */
    public static final class C0127a extends a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0127a f11487b = new C0127a();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return g.b(this.f11486a, ((a) obj).f11486a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f11486a.hashCode();
    }

    public final String toString() {
        return "CreationExtras(extras=" + this.f11486a + ')';
    }
}
