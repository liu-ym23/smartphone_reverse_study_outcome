package u5;

import java.util.List;
import kotlin.jvm.internal.k;

/* renamed from: u5.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2040d {

    /* renamed from: a, reason: collision with root package name */
    public final String f6709a;
    public final List b;

    public C2040d(String str, List pins) {
        k.f(pins, "pins");
        this.f6709a = str;
        this.b = pins;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2040d)) {
            return false;
        }
        C2040d c2040d = (C2040d) obj;
        return k.b(this.f6709a, c2040d.f6709a) && k.b(this.b, c2040d.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f6709a.hashCode() * 31);
    }

    public final String toString() {
        return "PinSpec(hostname=" + this.f6709a + ", pins=" + this.b + ")";
    }
}
