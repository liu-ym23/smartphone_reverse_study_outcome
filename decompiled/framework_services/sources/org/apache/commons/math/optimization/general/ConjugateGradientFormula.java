package org.apache.commons.math.optimization.general;

/* JADX INFO: loaded from: classes3.dex */
public final enum ConjugateGradientFormula extends Enum<ConjugateGradientFormula> {
    private static final /* synthetic */ ConjugateGradientFormula[] $VALUES = null;
    public static final ConjugateGradientFormula FLETCHER_REEVES = null;
    public static final ConjugateGradientFormula POLAK_RIBIERE = null;

    private static /* synthetic */ ConjugateGradientFormula[] $values() {
        return new ConjugateGradientFormula[]{FLETCHER_REEVES, POLAK_RIBIERE};
    }

    private ConjugateGradientFormula(String r1, int r2) {
        super(r1, r2);
    }

    public static ConjugateGradientFormula valueOf(String name) {
        return (ConjugateGradientFormula) Enum.valueOf(ConjugateGradientFormula.class, name);
    }

    public static ConjugateGradientFormula[] values() {
        return (ConjugateGradientFormula[]) $VALUES.clone();
    }

    static {
        FLETCHER_REEVES = new ConjugateGradientFormula("FLETCHER_REEVES", 0);
        POLAK_RIBIERE = new ConjugateGradientFormula("POLAK_RIBIERE", 1);
        $VALUES = $values();
    }
}
