package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface j1 {
    boolean a();

    long b(n nVar, n nVar2, n nVar3);

    n h(long j10, n nVar, n nVar2, n nVar3);

    n k(long j10, n nVar, n nVar2, n nVar3);

    default n s(n nVar, n nVar2, n nVar3) {
        return h(b(nVar, nVar2, nVar3), nVar, nVar2, nVar3);
    }
}
