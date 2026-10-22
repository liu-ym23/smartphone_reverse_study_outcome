package androidx.lifecycle;

import kotlin.NoWhenBranchMatchedException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class Lifecycle {

    /* renamed from: a, reason: collision with root package name */
    public final b f2212a = new b(0);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Event {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ Event[] $VALUES;
        public static final a Companion;
        public static final Event ON_ANY;
        public static final Event ON_CREATE;
        public static final Event ON_DESTROY;
        public static final Event ON_PAUSE;
        public static final Event ON_RESUME;
        public static final Event ON_START;
        public static final Event ON_STOP;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class a {
            public static Event a(State state) {
                kotlin.jvm.internal.g.f(state, "state");
                int iOrdinal = state.ordinal();
                if (iOrdinal == 2) {
                    return Event.ON_DESTROY;
                }
                if (iOrdinal == 3) {
                    return Event.ON_STOP;
                }
                if (iOrdinal != 4) {
                    return null;
                }
                return Event.ON_PAUSE;
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f2213a;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f2213a = iArr;
            }
        }

        static {
            Event event = new Event("ON_CREATE", 0);
            ON_CREATE = event;
            Event event2 = new Event("ON_START", 1);
            ON_START = event2;
            Event event3 = new Event("ON_RESUME", 2);
            ON_RESUME = event3;
            Event event4 = new Event("ON_PAUSE", 3);
            ON_PAUSE = event4;
            Event event5 = new Event("ON_STOP", 4);
            ON_STOP = event5;
            Event event6 = new Event("ON_DESTROY", 5);
            ON_DESTROY = event6;
            Event event7 = new Event("ON_ANY", 6);
            ON_ANY = event7;
            Event[] eventArr = {event, event2, event3, event4, event5, event6, event7};
            $VALUES = eventArr;
            $ENTRIES = kotlin.enums.a.a(eventArr);
            Companion = new a();
        }

        public Event() {
            throw null;
        }

        public static Event valueOf(String str) {
            return (Event) Enum.valueOf(Event.class, str);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        public final State a() {
            switch (b.f2213a[ordinal()]) {
                case 1:
                case 2:
                    return State.f2216c;
                case 3:
                case 4:
                    return State.f2217d;
                case 5:
                    return State.f2218e;
                case 6:
                    return State.f2214a;
                case 7:
                    throw new IllegalArgumentException(this + " has no target state");
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f2214a;

        /* renamed from: b, reason: collision with root package name */
        public static final State f2215b;

        /* renamed from: c, reason: collision with root package name */
        public static final State f2216c;

        /* renamed from: d, reason: collision with root package name */
        public static final State f2217d;

        /* renamed from: e, reason: collision with root package name */
        public static final State f2218e;
        public static final /* synthetic */ State[] h;

        static {
            State state = new State("DESTROYED", 0);
            f2214a = state;
            State state2 = new State("INITIALIZED", 1);
            f2215b = state2;
            State state3 = new State("CREATED", 2);
            f2216c = state3;
            State state4 = new State("STARTED", 3);
            f2217d = state4;
            State state5 = new State("RESUMED", 4);
            f2218e = state5;
            State[] stateArr = {state, state2, state3, state4, state5};
            h = stateArr;
            kotlin.enums.a.a(stateArr);
        }

        public State() {
            throw null;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) h.clone();
        }

        public final boolean a(State state) {
            return compareTo(state) >= 0;
        }
    }

    public abstract void a(p pVar);

    public abstract State b();

    public abstract void c(p pVar);
}
