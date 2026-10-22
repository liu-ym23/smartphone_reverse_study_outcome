package kotlin.reflect.jvm.internal.impl.name;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class State {

    /* renamed from: a, reason: collision with root package name */
    public static final State f5098a;
    public static final State b;
    public static final State c;
    public static final /* synthetic */ State[] d;

    static {
        State state = new State("BEGINNING", 0);
        f5098a = state;
        State state2 = new State("MIDDLE", 1);
        b = state2;
        State state3 = new State("AFTER_DOT", 2);
        c = state3;
        State[] stateArr = {state, state2, state3};
        d = stateArr;
        kotlin.enums.a.a(stateArr);
    }

    public static State valueOf(String str) {
        return (State) Enum.valueOf(State.class, str);
    }

    public static State[] values() {
        return (State[]) d.clone();
    }
}
