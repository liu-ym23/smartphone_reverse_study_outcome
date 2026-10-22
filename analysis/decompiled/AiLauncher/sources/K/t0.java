package K;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class t0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4009a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Class<? extends s0>> f4010b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<Class<? extends s0>> f4011c;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4012a = true;

        /* renamed from: b, reason: collision with root package name */
        public Set<Class<? extends s0>> f4013b;

        /* renamed from: c, reason: collision with root package name */
        public Set<Class<? extends s0>> f4014c;

        public t0 a() {
            return new t0(this.f4012a, this.f4013b, this.f4014c);
        }

        public b b(Set<Class<? extends s0>> set) {
            this.f4014c = new HashSet(set);
            return this;
        }

        public b c(Set<Class<? extends s0>> set) {
            this.f4013b = new HashSet(set);
            return this;
        }

        public b d(boolean z10) {
            this.f4012a = z10;
            return this;
        }
    }

    public static t0 b() {
        return new b().d(true).a();
    }

    public boolean a(Class<? extends s0> cls, boolean z10) {
        if (this.f4010b.contains(cls)) {
            return true;
        }
        return !this.f4011c.contains(cls) && this.f4009a && z10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t0)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        t0 t0Var = (t0) obj;
        return this.f4009a == t0Var.f4009a && Objects.equals(this.f4010b, t0Var.f4010b) && Objects.equals(this.f4011c, t0Var.f4011c);
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f4009a), this.f4010b, this.f4011c);
    }

    public String toString() {
        return "QuirkSettings{enabledWhenDeviceHasQuirk=" + this.f4009a + ", forceEnabledQuirks=" + this.f4010b + ", forceDisabledQuirks=" + this.f4011c + '}';
    }

    public t0(boolean z10, Set<Class<? extends s0>> set, Set<Class<? extends s0>> set2) {
        this.f4009a = z10;
        this.f4010b = set == null ? Collections.EMPTY_SET : new HashSet<>(set);
        this.f4011c = set2 == null ? Collections.EMPTY_SET : new HashSet<>(set2);
    }
}
