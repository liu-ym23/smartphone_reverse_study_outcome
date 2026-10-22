package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH'R6\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00118gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Landroidx/lifecycle/Lifecycle;", "", "<init>", "()V", "value", "Landroidx/lifecycle/AtomicReference;", "internalScopeRef", "getInternalScopeRef", "()Landroidx/lifecycle/AtomicReference;", "setInternalScopeRef", "(Landroidx/lifecycle/AtomicReference;)V", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "removeObserver", "currentState", "Landroidx/lifecycle/Lifecycle$State;", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "currentStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "Event", "State", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Lifecycle {
    private AtomicReference<Object> internalScopeRef;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/Lifecycle$Event;", "", "<init>", "(Ljava/lang/String;I)V", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "targetState", "Landroidx/lifecycle/Lifecycle$State;", "getTargetState", "()Landroidx/lifecycle/Lifecycle$State;", "Companion", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Event extends Enum<Event> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final Companion Companion = null;
        public static final Event ON_ANY = null;
        public static final Event ON_CREATE = null;
        public static final Event ON_DESTROY = null;
        public static final Event ON_PAUSE = null;
        public static final Event ON_RESUME = null;
        public static final Event ON_START = null;
        public static final Event ON_STOP = null;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/Lifecycle$Event$Companion;", "", "<init>", "()V", "downFrom", "Landroidx/lifecycle/Lifecycle$Event;", "state", "Landroidx/lifecycle/Lifecycle$State;", "downTo", "upFrom", "upTo", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {

            /* JADX INFO: loaded from: classes6.dex */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                static {
                    int[] r100 = new int[State.values().length];
                    r100[State.CREATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
                L15:
                    r100[State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
                L23:
                    r100[State.RESUMED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
                L17:
                    r100[State.DESTROYED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
                L19:
                    r100[State.INITIALIZED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
                L8:
                    $EnumSwitchMapping$0 = r100;
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            @JvmStatic
            public final Event downFrom(State r100) {
                Intrinsics.checkNotNullParameter(r100, "state");
                int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
                if (r101 == 1) goto L12;
                if (r101 == 2) goto L15;
                if (r101 == 3) goto L14;
                return null;
            L14:
                return Event.ON_PAUSE;
            L15:
                return Event.ON_STOP;
            L12:
                return Event.ON_DESTROY;
            }

            @JvmStatic
            public final Event downTo(State r100) {
                Intrinsics.checkNotNullParameter(r100, "state");
                int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
                if (r101 == 1) goto L12;
                if (r101 == 2) goto L15;
                if (r101 == 4) goto L14;
                return null;
            L14:
                return Event.ON_DESTROY;
            L15:
                return Event.ON_PAUSE;
            L12:
                return Event.ON_STOP;
            }

            @JvmStatic
            public final Event upFrom(State r100) {
                Intrinsics.checkNotNullParameter(r100, "state");
                int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
                if (r101 == 1) goto L12;
                if (r101 == 2) goto L15;
                if (r101 == 5) goto L14;
                return null;
            L14:
                return Event.ON_CREATE;
            L15:
                return Event.ON_RESUME;
            L12:
                return Event.ON_START;
            }

            @JvmStatic
            public final Event upTo(State r100) {
                Intrinsics.checkNotNullParameter(r100, "state");
                int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
                if (r101 == 1) goto L12;
                if (r101 == 2) goto L15;
                if (r101 == 3) goto L14;
                return null;
            L14:
                return Event.ON_RESUME;
            L15:
                return Event.ON_START;
            L12:
                return Event.ON_CREATE;
            }
        }

        /* JADX INFO: loaded from: classes6.dex */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r100 = new int[Event.values().length];
                r100[Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r100[Event.ON_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r100[Event.ON_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r100[Event.ON_RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r100[Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r100[Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                $EnumSwitchMapping$0 = r100;
            }
        }

        private static final /* synthetic */ Event[] $values() {
            return new Event[]{ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_ANY};
        }

        @JvmStatic
        public static final Event downFrom(State r100) {
            return Companion.downFrom(r100);
        }

        @JvmStatic
        public static final Event downTo(State r100) {
            return Companion.downTo(r100);
        }

        public static EnumEntries<Event> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        public static final Event upFrom(State r100) {
            return Companion.upFrom(r100);
        }

        @JvmStatic
        public static final Event upTo(State r100) {
            return Companion.upTo(r100);
        }

        static {
            ON_CREATE = new Event("ON_CREATE", 0);
            ON_START = new Event("ON_START", 1);
            ON_RESUME = new Event("ON_RESUME", 2);
            ON_PAUSE = new Event("ON_PAUSE", 3);
            ON_STOP = new Event("ON_STOP", 4);
            ON_DESTROY = new Event("ON_DESTROY", 5);
            ON_ANY = new Event("ON_ANY", 6);
            Event[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
            Companion = new Companion(null);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        public final State getTargetState() {
            switch(WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1: goto L15;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L13;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L7;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalArgumentException(this + " has no target state");
        L9:
            return State.DESTROYED;
        L11:
            return State.RESUMED;
        L13:
            return State.STARTED;
        L15:
            return State.CREATED;
        }

        public static Event valueOf(String r100) {
            return (Event) r27.a.a(Event.class, r100);
        }

        private Event(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0000j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Landroidx/lifecycle/Lifecycle$State;", "", "<init>", "(Ljava/lang/String;I)V", "DESTROYED", "INITIALIZED", "CREATED", "STARTED", "RESUMED", "isAtLeast", "", "state", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CREATED = null;
        public static final State DESTROYED = null;
        public static final State INITIALIZED = null;
        public static final State RESUMED = null;
        public static final State STARTED = null;

        private static final /* synthetic */ State[] $values() {
            return new State[]{DESTROYED, INITIALIZED, CREATED, STARTED, RESUMED};
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        static {
            DESTROYED = new State("DESTROYED", 0);
            INITIALIZED = new State("INITIALIZED", 1);
            CREATED = new State("CREATED", 2);
            STARTED = new State("STARTED", 3);
            RESUMED = new State("RESUMED", 4);
            State[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public final boolean isAtLeast(State r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (compareTo(r100) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ void e(z0 r100, LifecycleOwner r101, Event r102) {
        _get_currentStateFlow_$lambda$0(r100, r101, r102);
    }

    public abstract void addObserver(LifecycleObserver r100);

    public abstract State getCurrentState();

    public abstract void removeObserver(LifecycleObserver r100);

    public Lifecycle() {
        this.internalScopeRef = new AtomicReference(null);
    }

    public i1<State> getCurrentStateFlow() {
        final StateFlowImpl r100 = j1.a(getCurrentState());
        addObserver(new g(r100));
        return kotlinx.coroutines.flow.e.b(r100);
    }

    public final AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    public final void setInternalScopeRef(AtomicReference<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.internalScopeRef = r100;
    }

    private static final void _get_currentStateFlow_$lambda$0(z0 r100, LifecycleOwner r101, Event r102) {
        Intrinsics.checkNotNullParameter(r101, "<unused var>");
        Intrinsics.checkNotNullParameter(r102, "event");
        r100.setValue(r102.getTargetState());
    }
}
