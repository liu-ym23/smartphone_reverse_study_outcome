package H4;

/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final long f748a;
    public final long b;

    public p(long j5, long j6) {
        this.f748a = j5;
        this.b = j6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f748a == pVar.f748a && this.b == pVar.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f748a) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TrainingAudioTimestamp(framePosition=");
        sb.append(this.f748a);
        sb.append(", nanoTime=");
        return androidx.constraintlayout.core.dsl.a.e(this.b, ")", sb);
    }
}
