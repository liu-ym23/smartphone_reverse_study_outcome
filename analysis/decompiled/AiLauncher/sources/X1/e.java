package X1;

import java.time.ZoneOffset;
import java.util.Objects;

/* loaded from: classes.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f6846c = new e(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f6847a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6848b;

    public e(int i10, int i11) {
        this.f6847a = i10;
        this.f6848b = i11;
    }

    public static e e(int i10, int i11) {
        return new e(i10, i11);
    }

    public int a() {
        return this.f6847a;
    }

    public int b() {
        return this.f6848b;
    }

    public int c() {
        return this == f6846c ? 1 : 6;
    }

    public int d() {
        return (this.f6847a * 3600) + (this.f6848b * 60);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            e eVar = (e) obj;
            if (this.f6847a == eVar.f6847a && this.f6848b == eVar.f6848b) {
                return true;
            }
        }
        return false;
    }

    public ZoneOffset f() {
        return equals(f6846c) ? ZoneOffset.UTC : ZoneOffset.ofHoursMinutes(this.f6847a, this.f6848b);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f6847a), Integer.valueOf(this.f6848b));
    }

    public String toString() {
        return "TimezoneOffset{hours=" + this.f6847a + ", minutes=" + this.f6848b + '}';
    }
}
