package a2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final String f145a;

    /* renamed from: b, reason: collision with root package name */
    public final xb.p f146b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f147c;

    public x(String str, xb.p pVar) {
        this.f145a = str;
        this.f146b = pVar;
    }

    public final String toString() {
        return "AccessibilityKey: " + this.f145a;
    }

    public /* synthetic */ x(String str) {
        this(str, t.f114v);
    }

    public x(String str, int i) {
        this(str);
        this.f147c = true;
    }

    public x(String str, boolean z10, xb.p pVar) {
        this(str, pVar);
        this.f147c = z10;
    }
}
