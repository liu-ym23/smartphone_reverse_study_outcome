package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes13.dex */
public abstract class Lifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<CoroutineScope> f180804a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/lifecycle/Lifecycle$Event;", "", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Event extends Enum<Event> {
        public static final Event ON_ANY = null;
        public static final Event ON_CREATE = null;
        public static final Event ON_DESTROY = null;
        public static final Event ON_PAUSE = null;
        public static final Event ON_RESUME = null;
        public static final Event ON_START = null;
        public static final Event ON_STOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Event[] f180805a = null;

        static {
            Event r100 = new Event("ON_CREATE", 0);
            ON_CREATE = r100;
            Event r101 = new Event("ON_START", 1);
            ON_START = r101;
            Event r102 = new Event("ON_RESUME", 2);
            ON_RESUME = r102;
            Event r103 = new Event("ON_PAUSE", 3);
            ON_PAUSE = r103;
            Event r104 = new Event("ON_STOP", 4);
            ON_STOP = r104;
            Event r105 = new Event("ON_DESTROY", 5);
            ON_DESTROY = r105;
            Event r106 = new Event("ON_ANY", 6);
            ON_ANY = r106;
            f180805a = new Event[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static Event valueOf(String r100) {
            return (Event) r27.a.a(Event.class, r100);
        }

        public static Event[] values() {
            return (Event[]) f180805a.clone();
        }

        public Event(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/lifecycle/Lifecycle$State;", "", "state", "", "isAtLeast", "DESTROYED", "INITIALIZED", "CREATED", "STARTED", "RESUMED", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State CREATED = null;
        public static final State DESTROYED = null;
        public static final State INITIALIZED = null;
        public static final State RESUMED = null;
        public static final State STARTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f180806a = null;

        static {
            State r100 = new State("DESTROYED", 0);
            DESTROYED = r100;
            State r101 = new State("INITIALIZED", 1);
            INITIALIZED = r101;
            State r102 = new State("CREATED", 2);
            CREATED = r102;
            State r103 = new State("STARTED", 3);
            STARTED = r103;
            State r104 = new State("RESUMED", 4);
            RESUMED = r104;
            f180806a = new State[]{r100, r101, r102, r103, r104};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f180806a.clone();
        }

        public final boolean isAtLeast(State r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (compareTo(r100) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract void a(d r100);

    public abstract State b();

    public abstract void c(d r100);

    public Lifecycle() {
        this.f180804a = new AtomicReference();
    }
}
