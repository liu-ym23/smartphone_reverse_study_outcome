package d.m;

/* JADX INFO: compiled from: KFunction.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface e<R> extends d.c<R>, b<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // d.m.b
    boolean isSuspend();
}
