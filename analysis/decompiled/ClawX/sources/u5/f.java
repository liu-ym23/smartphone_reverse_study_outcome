package u5;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends d {
    public static final f d = new f(1, 0, 1);

    @Override // u5.d
    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        if (isEmpty() && ((f) obj).isEmpty()) {
            return true;
        }
        f fVar = (f) obj;
        return this.f5663a == fVar.f5663a && this.f5664b == fVar.f5664b;
    }

    @Override // u5.d
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f5663a * 31) + this.f5664b;
    }

    @Override // u5.d
    public final boolean isEmpty() {
        return this.f5663a > this.f5664b;
    }

    @Override // u5.d
    public final String toString() {
        return this.f5663a + ".." + this.f5664b;
    }
}
