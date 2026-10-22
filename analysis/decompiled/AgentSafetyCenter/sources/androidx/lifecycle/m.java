package androidx.lifecycle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {
    public static o a(p pVar) {
        pVar.getClass();
        int iOrdinal = pVar.ordinal();
        if (iOrdinal == 2) {
            return o.ON_DESTROY;
        }
        if (iOrdinal == 3) {
            return o.ON_STOP;
        }
        if (iOrdinal != 4) {
            return null;
        }
        return o.ON_PAUSE;
    }
}
