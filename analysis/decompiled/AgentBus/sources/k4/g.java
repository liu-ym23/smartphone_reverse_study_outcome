package k4;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5615a;

    public g(boolean z4) {
        this.f5615a = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.f5615a == ((g) obj).f5615a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f5615a) + (Boolean.hashCode(true) * 31);
    }

    public final String toString() {
        return "BffSendOutcome(accepted=true, queued=" + this.f5615a + ")";
    }
}
