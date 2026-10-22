package org.apache.commons.math.optimization.linear;

/* JADX INFO: loaded from: classes3.dex */
public final enum Relationship extends Enum<Relationship> {
    private static final /* synthetic */ Relationship[] $VALUES = null;
    public static final Relationship EQ = null;
    public static final Relationship GEQ = null;
    public static final Relationship LEQ = null;
    private final String stringValue;

    private static /* synthetic */ Relationship[] $values() {
        return new Relationship[]{EQ, LEQ, GEQ};
    }

    public static Relationship valueOf(String name) {
        return (Relationship) Enum.valueOf(Relationship.class, name);
    }

    public static Relationship[] values() {
        return (Relationship[]) $VALUES.clone();
    }

    static {
        EQ = new Relationship("EQ", 0, "=");
        LEQ = new Relationship("LEQ", 1, "<=");
        GEQ = new Relationship("GEQ", 2, ">=");
        $VALUES = $values();
    }

    private Relationship(String r1, int r2, String stringValue) {
        super(r1, r2);
        this.stringValue = stringValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.stringValue;
    }

    public Relationship oppositeRelationship() {
        switch(ordinal()) {
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return EQ;
    L7:
        return LEQ;
    L9:
        return GEQ;
    }
}
