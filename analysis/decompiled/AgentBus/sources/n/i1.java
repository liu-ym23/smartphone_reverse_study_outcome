package n;

/* loaded from: classes.dex */
public interface i1 extends j1 {
    @Override // n.h1
    default long c(n nVar, n nVar2, n nVar3) {
        return (v() + m()) * 1000000;
    }

    int m();

    int v();
}
