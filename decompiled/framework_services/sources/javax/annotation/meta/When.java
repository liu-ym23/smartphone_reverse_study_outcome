package javax.annotation.meta;

/* JADX INFO: loaded from: classes3.dex */
public final enum When extends Enum<When> {
    private static final /* synthetic */ When[] $VALUES = null;
    public static final When ALWAYS = null;
    public static final When MAYBE = null;
    public static final When NEVER = null;
    public static final When UNKNOWN = null;

    private static /* synthetic */ When[] $values() {
        return new When[]{ALWAYS, UNKNOWN, MAYBE, NEVER};
    }

    private When(String r1, int r2) {
        super(r1, r2);
    }

    public static When valueOf(String name) {
        return (When) Enum.valueOf(When.class, name);
    }

    public static When[] values() {
        return (When[]) $VALUES.clone();
    }

    static {
        ALWAYS = new When("ALWAYS", 0);
        UNKNOWN = new When("UNKNOWN", 1);
        MAYBE = new When("MAYBE", 2);
        NEVER = new When("NEVER", 3);
        $VALUES = $values();
    }
}
