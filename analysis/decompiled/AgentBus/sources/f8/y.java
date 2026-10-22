package f8;

/* loaded from: classes.dex */
public abstract class y {
    public static <R, D> R accept(z zVar, l lVar, D d6) {
        q7.k.e(lVar, "visitor");
        return (R) lVar.G(zVar, d6);
    }

    public static j getContainingDeclaration(z zVar) {
        return null;
    }
}
