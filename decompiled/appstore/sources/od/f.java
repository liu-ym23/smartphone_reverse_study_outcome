package od;

import com.bytedance.apm.constant.CommonKey;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f22580b;

    public f(long r10, d r11) {
        q.g(r11, CommonKey.KEY_VALUE);
        this.f22579a = r10;
        this.f22580b = r11;
    }

    public final long a() {
        return this.f22579a;
    }

    public final d b() {
        return this.f22580b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (this.f22579a == r11.f22579a) goto L12;
        return false;
    L12:
        if (q.b(this.f22580b, r11.f22580b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.f22579a) * 31) + this.f22580b.hashCode();
    }

    public String toString() {
        return "Keyframe(timeMs=" + this.f22579a + ", value=" + this.f22580b + ')';
    }
}
