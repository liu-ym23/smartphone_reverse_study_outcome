package com.obric.structure.omvvm.core.flux;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: compiled from: FluxComponentLifecycle.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u000b"}, d2 = {"Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle;", "", "()V", "addObserver", "", "observer", "Lcom/obric/structure/omvvm/core/flux/FluxLifecycleObserver;", "removeObserver", "Event", "State", "StateEvent", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class FluxComponentLifecycle {

    /* JADX INFO: compiled from: FluxComponentLifecycle.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$Event;", "", "(Ljava/lang/String;I)V", "isDown", "", "isUp", "targetState", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$State;", "ON_CREATE", "ON_BIND", "ON_DISPLAY", "ON_HIDE", "ON_UNBIND", "ON_DESTROY", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum Event extends Enum<Event> {
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final Event ON_BIND = null;
        public static final Event ON_CREATE = null;
        public static final Event ON_DESTROY = null;
        public static final Event ON_DISPLAY = null;
        public static final Event ON_HIDE = null;
        public static final Event ON_UNBIND = null;

        /* JADX INFO: compiled from: FluxComponentLifecycle.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[Event.values().length];
                r0[Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[Event.ON_BIND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[Event.ON_DISPLAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[Event.ON_HIDE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[Event.ON_UNBIND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                $EnumSwitchMapping$0 = r0;
            }
        }

        private static final /* synthetic */ Event[] $values() {
            return new Event[]{ON_CREATE, ON_BIND, ON_DISPLAY, ON_HIDE, ON_UNBIND, ON_DESTROY};
        }

        public static Event valueOf(String r1) {
            return (Event) Enum.valueOf(Event.class, r1);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        private Event(String r1, int r2) {
            super(r1, r2);
        }

        static {
            ON_CREATE = new Event("ON_CREATE", 0);
            ON_BIND = new Event("ON_BIND", 1);
            ON_DISPLAY = new Event("ON_DISPLAY", 2);
            ON_HIDE = new Event("ON_HIDE", 3);
            ON_UNBIND = new Event("ON_UNBIND", 4);
            ON_DESTROY = new Event("ON_DESTROY", 5);
            $VALUES = $values();
        }

        public final State targetState() {
            switch(WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1: goto L12;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L13:
            return State.DESTROYED;
        L14:
            return State.CREATED;
        L15:
            return State.BOUND;
        L16:
            return State.DISPLAYED;
        L17:
            return State.BOUND;
        L12:
            return State.CREATED;
        }

        public final boolean isUp() {
            switch(WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1: goto L7;
                case 2: goto L7;
                case 3: goto L7;
                case 4: goto L6;
                case 5: goto L6;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            return false;
        L7:
            return true;
        L5:
            throw new NoWhenBranchMatchedException();
        }

        public final boolean isDown() {
            return !isUp();
        }
    }

    /* JADX INFO: compiled from: FluxComponentLifecycle.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$State;", "", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$StateEvent;", "(Ljava/lang/String;I)V", "toAndroidLifecycle", "Landroidx/lifecycle/Lifecycle$State;", "DESTROYED", DebugCoroutineInfoImplKt.CREATED, "BOUND", "DISPLAYED", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum State extends Enum<State> implements StateEvent {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State BOUND = null;
        public static final State CREATED = null;
        public static final State DESTROYED = null;
        public static final State DISPLAYED = null;

        /* JADX INFO: compiled from: FluxComponentLifecycle.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$State$BOUND;", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$State;", "down", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$Event;", "up", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class BOUND extends State {
            BOUND(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // com.obric.structure.omvvm.core.flux.FluxComponentLifecycle.StateEvent
            public Event up() {
                return Event.ON_DISPLAY;
            }

            @Override // com.obric.structure.omvvm.core.flux.FluxComponentLifecycle.StateEvent
            public Event down() {
                return Event.ON_UNBIND;
            }
        }

        /* JADX INFO: compiled from: FluxComponentLifecycle.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$State$CREATED;", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$State;", "down", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$Event;", "up", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class CREATED extends State {
            CREATED(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // com.obric.structure.omvvm.core.flux.FluxComponentLifecycle.StateEvent
            public Event up() {
                return Event.ON_BIND;
            }

            @Override // com.obric.structure.omvvm.core.flux.FluxComponentLifecycle.StateEvent
            public Event down() {
                return Event.ON_DESTROY;
            }
        }

        /* JADX INFO: compiled from: FluxComponentLifecycle.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$State$DESTROYED;", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$State;", "down", "", "up", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$Event;", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class DESTROYED extends State {
            /* JADX INFO: renamed from: down, reason: collision with other method in class */
            public Void m769down() {
                return null;
            }

            DESTROYED(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // com.obric.structure.omvvm.core.flux.FluxComponentLifecycle.StateEvent
            public /* bridge */ /* synthetic */ Event down() {
                return (Event) m769down();
            }

            @Override // com.obric.structure.omvvm.core.flux.FluxComponentLifecycle.StateEvent
            public Event up() {
                return Event.ON_CREATE;
            }
        }

        /* JADX INFO: compiled from: FluxComponentLifecycle.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$State$DISPLAYED;", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$State;", "down", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$Event;", "up", "", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class DISPLAYED extends State {
            /* JADX INFO: renamed from: up, reason: collision with other method in class */
            public Void m770up() {
                return null;
            }

            DISPLAYED(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // com.obric.structure.omvvm.core.flux.FluxComponentLifecycle.StateEvent
            public /* bridge */ /* synthetic */ Event up() {
                return (Event) m770up();
            }

            @Override // com.obric.structure.omvvm.core.flux.FluxComponentLifecycle.StateEvent
            public Event down() {
                return Event.ON_HIDE;
            }
        }

        /* JADX INFO: compiled from: FluxComponentLifecycle.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[State.values().length];
                r0[State.DESTROYED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[State.CREATED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[State.BOUND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[State.DISPLAYED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                $EnumSwitchMapping$0 = r0;
            }
        }

        private static final /* synthetic */ State[] $values() {
            return new State[]{DESTROYED, CREATED, BOUND, DISPLAYED};
        }

        public /* synthetic */ State(String r1, int r2, DefaultConstructorMarker r3) {
            this(r1, r2);
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
            DESTROYED = new DESTROYED("DESTROYED", 0);
            CREATED = new CREATED(DebugCoroutineInfoImplKt.CREATED, 1);
            BOUND = new BOUND("BOUND", 2);
            DISPLAYED = new DISPLAYED("DISPLAYED", 3);
            $VALUES = $values();
        }

        public final Lifecycle.State toAndroidLifecycle() {
            int r1 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L19;
            if (r1 == 3) goto L18;
            if (r1 != 4) goto L12;
            return Lifecycle.State.RESUMED;
        L12:
            throw new NoWhenBranchMatchedException();
        L18:
            return Lifecycle.State.STARTED;
        L19:
            return Lifecycle.State.CREATED;
        L16:
            return Lifecycle.State.DESTROYED;
        }
    }

    /* JADX INFO: compiled from: FluxComponentLifecycle.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$StateEvent;", "", "down", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$Event;", "up", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface StateEvent {
        Event down();

        Event up();
    }

    public abstract void addObserver(FluxLifecycleObserver r1);

    public abstract void removeObserver(FluxLifecycleObserver r1);

    public FluxComponentLifecycle() {
    }
}
