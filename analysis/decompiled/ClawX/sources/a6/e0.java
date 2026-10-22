package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e0 extends f5.a {

    /* renamed from: c, reason: collision with root package name */
    public static final c0 f153c = new c0();

    /* renamed from: b, reason: collision with root package name */
    public final String f154b;

    public e0(String str) {
        super(f153c);
        this.f154b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e0) && kotlin.jvm.internal.p.a(this.f154b, ((e0) obj).f154b);
    }

    public final int hashCode() {
        return this.f154b.hashCode();
    }

    public final String toString() {
        return "CoroutineName(" + this.f154b + ')';
    }
}
