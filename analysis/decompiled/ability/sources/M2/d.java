package M2;

import com.tencent.mmkv.MMKV;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class d {
    public static final d c = new d(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f963a;
    public final int b;

    public d(int i, int i6) {
        this.f963a = i;
        this.b = i6;
    }

    public final int a() {
        return (this.b * 60) + (this.f963a * MMKV.ExpireInHour);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f963a == dVar.f963a && this.b == dVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f963a), Integer.valueOf(this.b));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TimezoneOffset{hours=");
        sb.append(this.f963a);
        sb.append(", minutes=");
        return B7.a.o(sb, this.b, '}');
    }
}
