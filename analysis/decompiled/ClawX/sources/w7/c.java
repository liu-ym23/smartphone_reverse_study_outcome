package w7;

import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f6226a;

    public c(int[] iArr) {
        this.f6226a = Arrays.clone(iArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return Arrays.areEqual(this.f6226a, ((c) obj).f6226a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f6226a);
    }
}
