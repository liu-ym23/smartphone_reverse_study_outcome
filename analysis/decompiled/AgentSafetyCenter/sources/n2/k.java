package n2;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public int f8662a;

    public static final /* synthetic */ k a(int i) {
        k kVar = new k();
        kVar.f8662a = i;
        VarHandle.storeStoreFence();
        return kVar;
    }

    public static String b(int i) {
        return i == 1 ? "Left" : i == 2 ? "Right" : i == 3 ? "Center" : i == 4 ? "Justify" : i == 5 ? "Start" : i == 6 ? "End" : i == Integer.MIN_VALUE ? "Unspecified" : "Invalid";
    }

    public final boolean equals(Object obj) {
        return (obj instanceof k) && this.f8662a == ((k) obj).f8662a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f8662a);
    }

    public final String toString() {
        return b(this.f8662a);
    }
}
