package l8;

import ad.n;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f7752a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7753b;

    /* renamed from: c, reason: collision with root package name */
    public final n f7754c;

    public a(int i, String str, n nVar) {
        this.f7752a = i;
        this.f7753b = str;
        this.f7754c = nVar;
    }

    public final boolean a() {
        int i = this.f7752a;
        return 200 <= i && i < 300;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f7752a == aVar.f7752a && this.f7753b.equals(aVar.f7753b) && this.f7754c.equals(aVar.f7754c);
    }

    public final int hashCode() {
        return androidx.activity.b.d(Integer.hashCode(this.f7752a) * 31, 31, this.f7753b) + Arrays.hashCode(this.f7754c.f548c);
    }

    public final String toString() {
        return "GatewayHttpSnapshot(code=" + this.f7752a + ", body=" + this.f7753b + ", headers=" + this.f7754c + ")";
    }
}
