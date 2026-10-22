package n;

/* loaded from: classes.dex */
public interface h1 {
    boolean a();

    long c(n nVar, n nVar2, n nVar3);

    default n o(n nVar, n nVar2, n nVar3) {
        return r(c(nVar, nVar2, nVar3), nVar, nVar2, nVar3);
    }

    n r(long j2, n nVar, n nVar2, n nVar3);

    n s(long j2, n nVar, n nVar2, n nVar3);
}
