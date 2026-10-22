package d5;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class h extends l {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f4298a;

    public h(int[] iArr) {
        this.f4298a = iArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return Arrays.equals(this.f4298a, ((h) obj).f4298a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f4298a);
    }

    public final String toString() {
        return B7.a.m("IntArrayValue(value=", Arrays.toString(this.f4298a), ")");
    }
}
