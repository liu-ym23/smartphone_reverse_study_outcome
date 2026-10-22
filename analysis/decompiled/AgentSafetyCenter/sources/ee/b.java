package ee;

import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final be.a f3851a;

    /* renamed from: b, reason: collision with root package name */
    public final Pattern f3852b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3853c;

    public b(be.a aVar, Pattern pattern, int i) {
        this.f3851a = aVar;
        this.f3852b = pattern;
        this.f3853c = i;
    }

    public final String toString() {
        return "Tuple tag=" + this.f3851a + " regexp=" + this.f3852b + " limit=" + this.f3853c;
    }
}
