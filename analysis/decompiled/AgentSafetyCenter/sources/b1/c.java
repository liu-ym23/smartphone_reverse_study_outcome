package b1;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f1810a;

    public static final /* synthetic */ c a(int i) {
        c cVar = new c();
        cVar.f1810a = i;
        VarHandle.storeStoreFence();
        return cVar;
    }

    public static String b(int i) {
        return i == 1 ? "Next" : i == 2 ? "Previous" : i == 3 ? "Left" : i == 4 ? "Right" : i == 5 ? "Up" : i == 6 ? "Down" : i == 7 ? "Enter" : i == 8 ? "Exit" : "Invalid FocusDirection";
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && this.f1810a == ((c) obj).f1810a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f1810a);
    }

    public final String toString() {
        return b(this.f1810a);
    }
}
