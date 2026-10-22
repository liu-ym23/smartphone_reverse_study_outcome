package kotlin.reflect.jvm.internal.impl.name;

/* JADX INFO: compiled from: FqNamesUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
final enum State extends Enum<State> {
    private static final /* synthetic */ State[] $VALUES = null;
    public static final State AFTER_DOT = null;
    public static final State BEGINNING = null;
    public static final State MIDDLE = null;

    private static final /* synthetic */ State[] $values() {
        return new State[]{BEGINNING, MIDDLE, AFTER_DOT};
    }

    public static State valueOf(String r1) {
        return (State) Enum.valueOf(State.class, r1);
    }

    public static State[] values() {
        return (State[]) $VALUES.clone();
    }

    private State(String r1, int r2) {
        super(r1, r2);
    }

    static {
        BEGINNING = new State("BEGINNING", 0);
        MIDDLE = new State("MIDDLE", 1);
        AFTER_DOT = new State("AFTER_DOT", 2);
        $VALUES = $values();
    }
}
