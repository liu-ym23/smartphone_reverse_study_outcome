package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes17.dex */
@Target({})
@Retention(RetentionPolicy.CLASS)
public @interface BuiltInTypeConverters {

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DISABLED = null;
        public static final State ENABLED = null;
        public static final State INHERITED = null;

        static {
            State r100 = new State("ENABLED", 0);
            ENABLED = r100;
            State r101 = new State("DISABLED", 1);
            DISABLED = r101;
            State r102 = new State("INHERITED", 2);
            INHERITED = r102;
            $VALUES = new State[]{r100, r101, r102};
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }
    }

    State enums() default State.INHERITED;

    State uuid() default State.INHERITED;
}
