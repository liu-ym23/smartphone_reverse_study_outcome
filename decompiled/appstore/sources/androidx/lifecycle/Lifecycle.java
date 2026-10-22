package androidx.lifecycle;

import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class Lifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicReference f3427a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Landroidx/lifecycle/Lifecycle$Event;", "", "<init>", "(Ljava/lang/String;I)V", "Landroidx/lifecycle/Lifecycle$State;", "getTargetState", "()Landroidx/lifecycle/Lifecycle$State;", "targetState", "Companion", "a", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum Event extends Enum<Event> {
        private static final /* synthetic */ Event[] $VALUES = null;

        @NotNull
        public static final a Companion = null;
        public static final Event ON_ANY = null;
        public static final Event ON_CREATE = null;
        public static final Event ON_DESTROY = null;
        public static final Event ON_PAUSE = null;
        public static final Event ON_RESUME = null;
        public static final Event ON_START = null;
        public static final Event ON_STOP = null;

        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.Lifecycle$Event$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0030a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f3428a = null;

                static {
                    int[] r10 = new int[State.values().length];
                    r10[State.CREATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
                L15:
                    r10[State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
                L23:
                    r10[State.RESUMED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
                L17:
                    r10[State.DESTROYED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
                L19:
                    r10[State.INITIALIZED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
                L8:
                    f3428a = r10;
                }
            }

            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public final Event a(State r10) {
                kotlin.jvm.internal.q.g(r10, WsConstants.KEY_CONNECTION_STATE);
                int r11 = C0030a.f3428a[r10.ordinal()];
                if (r11 == 1) goto L12;
                if (r11 == 2) goto L15;
                if (r11 == 3) goto L14;
                return null;
            L14:
                return Event.ON_PAUSE;
            L15:
                return Event.ON_STOP;
            L12:
                return Event.ON_DESTROY;
            }

            public final Event b(State r10) {
                kotlin.jvm.internal.q.g(r10, WsConstants.KEY_CONNECTION_STATE);
                int r11 = C0030a.f3428a[r10.ordinal()];
                if (r11 == 1) goto L12;
                if (r11 == 2) goto L15;
                if (r11 == 4) goto L14;
                return null;
            L14:
                return Event.ON_DESTROY;
            L15:
                return Event.ON_PAUSE;
            L12:
                return Event.ON_STOP;
            }

            public final Event c(State r10) {
                kotlin.jvm.internal.q.g(r10, WsConstants.KEY_CONNECTION_STATE);
                int r11 = C0030a.f3428a[r10.ordinal()];
                if (r11 == 1) goto L12;
                if (r11 == 2) goto L15;
                if (r11 == 5) goto L14;
                return null;
            L14:
                return Event.ON_CREATE;
            L15:
                return Event.ON_RESUME;
            L12:
                return Event.ON_START;
            }

            public final Event d(State r10) {
                kotlin.jvm.internal.q.g(r10, WsConstants.KEY_CONNECTION_STATE);
                int r11 = C0030a.f3428a[r10.ordinal()];
                if (r11 == 1) goto L12;
                if (r11 == 2) goto L15;
                if (r11 == 3) goto L14;
                return null;
            L14:
                return Event.ON_RESUME;
            L15:
                return Event.ON_START;
            L12:
                return Event.ON_CREATE;
            }

            public a() {
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3429a = null;

            static {
                int[] r10 = new int[Event.values().length];
                r10[Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r10[Event.ON_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r10[Event.ON_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r10[Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r10[Event.ON_RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r10[Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r10[Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                f3429a = r10;
            }
        }

        private static final /* synthetic */ Event[] $values() {
            return new Event[]{ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_ANY};
        }

        static {
            ON_CREATE = new Event("ON_CREATE", 0);
            ON_START = new Event("ON_START", 1);
            ON_RESUME = new Event("ON_RESUME", 2);
            ON_PAUSE = new Event("ON_PAUSE", 3);
            ON_STOP = new Event("ON_STOP", 4);
            ON_DESTROY = new Event("ON_DESTROY", 5);
            ON_ANY = new Event("ON_ANY", 6);
            $VALUES = $values();
            Companion = new a(null);
        }

        private Event(String r10, int r11) {
            super(r10, r11);
        }

        @JvmStatic
        @Nullable
        public static final Event downFrom(@NotNull State r10) {
            return Companion.a(r10);
        }

        @JvmStatic
        @Nullable
        public static final Event downTo(@NotNull State r10) {
            return Companion.b(r10);
        }

        @JvmStatic
        @Nullable
        public static final Event upFrom(@NotNull State r10) {
            return Companion.c(r10);
        }

        @JvmStatic
        @Nullable
        public static final Event upTo(@NotNull State r10) {
            return Companion.d(r10);
        }

        public static Event valueOf(String r10) {
            return (Event) Enum.valueOf(Event.class, r10);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        @NotNull
        public final State getTargetState() {
            switch(b.f3429a[ordinal()]) {
                case 1: goto L13;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L11;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L5;
            };
        L5:
            throw new IllegalArgumentException(this + " has no target state");
        L7:
            return State.DESTROYED;
        L9:
            return State.RESUMED;
        L11:
            return State.STARTED;
        L13:
            return State.CREATED;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/Lifecycle$State;", "", "(Ljava/lang/String;I)V", "isAtLeast", "", WsConstants.KEY_CONNECTION_STATE, "DESTROYED", "INITIALIZED", "CREATED", "STARTED", "RESUMED", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CREATED = null;
        public static final State DESTROYED = null;
        public static final State INITIALIZED = null;
        public static final State RESUMED = null;
        public static final State STARTED = null;

        private static final /* synthetic */ State[] $values() {
            return new State[]{DESTROYED, INITIALIZED, CREATED, STARTED, RESUMED};
        }

        static {
            DESTROYED = new State("DESTROYED", 0);
            INITIALIZED = new State("INITIALIZED", 1);
            CREATED = new State("CREATED", 2);
            STARTED = new State("STARTED", 3);
            RESUMED = new State("RESUMED", 4);
            $VALUES = $values();
        }

        private State(String r10, int r11) {
            super(r10, r11);
        }

        public static State valueOf(String r10) {
            return (State) Enum.valueOf(State.class, r10);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public final boolean isAtLeast(@NotNull State r10) {
            kotlin.jvm.internal.q.g(r10, WsConstants.KEY_CONNECTION_STATE);
            if (compareTo(r10) < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public Lifecycle() {
        this.f3427a = new AtomicReference();
    }

    public abstract void a(LifecycleObserver r10);

    public abstract State b();

    public final AtomicReference c() {
        return this.f3427a;
    }

    public abstract void d(LifecycleObserver r10);
}
