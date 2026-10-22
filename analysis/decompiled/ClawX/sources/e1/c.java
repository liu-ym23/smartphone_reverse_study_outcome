package e1;

import android.animation.TimeInterpolator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public long f2344a;

    /* renamed from: b, reason: collision with root package name */
    public long f2345b;

    /* renamed from: c, reason: collision with root package name */
    public TimeInterpolator f2346c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f2347e;

    public final TimeInterpolator a() {
        TimeInterpolator timeInterpolator = this.f2346c;
        return timeInterpolator != null ? timeInterpolator : a.f2340b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f2344a == cVar.f2344a && this.f2345b == cVar.f2345b && this.d == cVar.d && this.f2347e == cVar.f2347e) {
            return a().getClass().equals(cVar.a().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f2344a;
        long j8 = this.f2345b;
        return ((((a().getClass().hashCode() + (((((int) (j4 ^ (j4 >>> 32))) * 31) + ((int) ((j8 >>> 32) ^ j8))) * 31)) * 31) + this.d) * 31) + this.f2347e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(c.class.getName());
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.f2344a);
        sb.append(" duration: ");
        sb.append(this.f2345b);
        sb.append(" interpolator: ");
        sb.append(a().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.d);
        sb.append(" repeatMode: ");
        return f.e(sb, this.f2347e, "}\n");
    }
}
