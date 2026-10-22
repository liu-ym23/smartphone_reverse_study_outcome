package android.view;

import Xa.k;
import Xa.u;
import android.view.Lifecycle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import l.C4853a;
import l.C4854b;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0002%\u0010B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u0016J\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\bJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010\bJ\u000f\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010\u001aJ\u0017\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020(0'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u001b\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010,R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010.R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00100R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010&R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010&R&\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u001304j\b\u0012\u0004\u0012\u00020\u0013`58\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00106R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0013088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010>\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b%\u0010<\"\u0004\b=\u0010\u0016R\u0014\u0010@\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010?¨\u0006A"}, d2 = {"Landroidx/lifecycle/q;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/LifecycleOwner;", Const.JSON_KEY_PROVIDER, "", "enforceMainThread", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/lifecycle/Lifecycle$Event;", "event", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/lifecycle/o;", "observer", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/o;)V", Const.INTENT_KEY_UMID, "Landroidx/lifecycle/Lifecycle$State;", "next", "k", "(Landroidx/lifecycle/Lifecycle$State;)V", "f", "(Landroidx/lifecycle/o;)Landroidx/lifecycle/Lifecycle$State;", "l", "()V", VoiceWakeupReceiver.EXTRA_STATE, "m", "lifecycleOwner", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "e", "o", "", "methodName", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "Z", "Ll/a;", "Landroidx/lifecycle/q$b;", "c", "Ll/a;", "observerMap", "Landroidx/lifecycle/Lifecycle$State;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "", "I", "addingObserverCounter", "handlingEvent", "newEventOccurred", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "parentStates", "LXa/k;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LXa/k;", "_currentStateFlow", "()Landroidx/lifecycle/Lifecycle$State;", "n", "currentState", "()Z", "isSynced", "lifecycle-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.lifecycle.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1399q extends Lifecycle {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean enforceMainThread;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public C4853a<InterfaceC1397o, b> observerMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Lifecycle.State state;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final WeakReference<LifecycleOwner> lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int addingObserverCounter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean handlingEvent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean newEventOccurred;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public ArrayList<Lifecycle.State> parentStates;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final k<Lifecycle.State> _currentStateFlow;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/lifecycle/q$a;", "", "<init>", "()V", "Landroidx/lifecycle/Lifecycle$State;", "state1", "state2", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/Lifecycle$State;)Landroidx/lifecycle/Lifecycle$State;", "lifecycle-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.lifecycle.q$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Lifecycle.State a(Lifecycle.State state1, Lifecycle.State state2) {
            p.i(state1, "state1");
            return (state2 == null || state2.compareTo(state1) >= 0) ? state1 : state2;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroidx/lifecycle/q$b;", "", "Landroidx/lifecycle/o;", "observer", "Landroidx/lifecycle/Lifecycle$State;", "initialState", "<init>", "(Landroidx/lifecycle/o;Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Lifecycle$Event;", "event", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/lifecycle/Lifecycle$State;", Const.INTENT_KEY_PKGNAME, "()Landroidx/lifecycle/Lifecycle$State;", "setState", "(Landroidx/lifecycle/Lifecycle$State;)V", VoiceWakeupReceiver.EXTRA_STATE, "Landroidx/lifecycle/m;", "Landroidx/lifecycle/m;", "getLifecycleObserver", "()Landroidx/lifecycle/m;", "setLifecycleObserver", "(Landroidx/lifecycle/m;)V", "lifecycleObserver", "lifecycle-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.lifecycle.q$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public Lifecycle.State state;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public InterfaceC1395m lifecycleObserver;

        public b(InterfaceC1397o interfaceC1397o, Lifecycle.State initialState) {
            p.i(initialState, "initialState");
            p.f(interfaceC1397o);
            this.lifecycleObserver = C1403v.f(interfaceC1397o);
            this.state = initialState;
        }

        public final void a(LifecycleOwner owner, Lifecycle.Event event) {
            p.i(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.state = C1399q.INSTANCE.a(this.state, targetState);
            InterfaceC1395m interfaceC1395m = this.lifecycleObserver;
            p.f(owner);
            interfaceC1395m.onStateChanged(owner, event);
            this.state = targetState;
        }

        /* renamed from: b, reason: from getter */
        public final Lifecycle.State getState() {
            return this.state;
        }
    }

    public C1399q(LifecycleOwner lifecycleOwner, boolean z10) {
        this.enforceMainThread = z10;
        this.observerMap = new C4853a<>();
        Lifecycle.State state = Lifecycle.State.INITIALIZED;
        this.state = state;
        this.parentStates = new ArrayList<>();
        this.lifecycleOwner = new WeakReference<>(lifecycleOwner);
        this._currentStateFlow = u.a(state);
    }

    @Override // android.view.Lifecycle
    public void a(InterfaceC1397o observer) {
        LifecycleOwner lifecycleOwner;
        p.i(observer, "observer");
        g("addObserver");
        Lifecycle.State state = this.state;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        b bVar = new b(observer, state2);
        if (this.observerMap.j(observer, bVar) == null && (lifecycleOwner = this.lifecycleOwner.get()) != null) {
            boolean z10 = this.addingObserverCounter != 0 || this.handlingEvent;
            Lifecycle.State stateF = f(observer);
            this.addingObserverCounter++;
            while (bVar.getState().compareTo(stateF) < 0 && this.observerMap.contains(observer)) {
                m(bVar.getState());
                Lifecycle.Event eventC = Lifecycle.Event.INSTANCE.c(bVar.getState());
                if (eventC == null) {
                    throw new IllegalStateException("no event up from " + bVar.getState());
                }
                bVar.a(lifecycleOwner, eventC);
                l();
                stateF = f(observer);
            }
            if (!z10) {
                o();
            }
            this.addingObserverCounter--;
        }
    }

    @Override // android.view.Lifecycle
    /* renamed from: b, reason: from getter */
    public Lifecycle.State getState() {
        return this.state;
    }

    @Override // android.view.Lifecycle
    public void d(InterfaceC1397o observer) {
        p.i(observer, "observer");
        g("removeObserver");
        this.observerMap.k(observer);
    }

    public final void e(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<InterfaceC1397o, b>> itDescendingIterator = this.observerMap.descendingIterator();
        p.h(itDescendingIterator, "descendingIterator(...)");
        while (itDescendingIterator.hasNext() && !this.newEventOccurred) {
            Map.Entry<InterfaceC1397o, b> next = itDescendingIterator.next();
            p.f(next);
            InterfaceC1397o key = next.getKey();
            b value = next.getValue();
            while (value.getState().compareTo(this.state) > 0 && !this.newEventOccurred && this.observerMap.contains(key)) {
                Lifecycle.Event eventA = Lifecycle.Event.INSTANCE.a(value.getState());
                if (eventA == null) {
                    throw new IllegalStateException("no event down from " + value.getState());
                }
                m(eventA.getTargetState());
                value.a(lifecycleOwner, eventA);
                l();
            }
        }
    }

    public final Lifecycle.State f(InterfaceC1397o observer) {
        b value;
        Map.Entry<InterfaceC1397o, b> entryL = this.observerMap.l(observer);
        Lifecycle.State state = null;
        Lifecycle.State state2 = (entryL == null || (value = entryL.getValue()) == null) ? null : value.getState();
        if (!this.parentStates.isEmpty()) {
            state = this.parentStates.get(r0.size() - 1);
        }
        Companion companion = INSTANCE;
        return companion.a(companion.a(this.state, state2), state);
    }

    public final void g(String methodName) {
        if (!this.enforceMainThread || C1401t.a()) {
            return;
        }
        throw new IllegalStateException(("Method " + methodName + " must be called on the main thread").toString());
    }

    public final void h(LifecycleOwner lifecycleOwner) {
        C4854b<InterfaceC1397o, b>.d dVarE = this.observerMap.e();
        p.h(dVarE, "iteratorWithAdditions(...)");
        while (dVarE.hasNext() && !this.newEventOccurred) {
            Map.Entry next = dVarE.next();
            InterfaceC1397o interfaceC1397o = (InterfaceC1397o) next.getKey();
            b bVar = (b) next.getValue();
            while (bVar.getState().compareTo(this.state) < 0 && !this.newEventOccurred && this.observerMap.contains(interfaceC1397o)) {
                m(bVar.getState());
                Lifecycle.Event eventC = Lifecycle.Event.INSTANCE.c(bVar.getState());
                if (eventC == null) {
                    throw new IllegalStateException("no event up from " + bVar.getState());
                }
                bVar.a(lifecycleOwner, eventC);
                l();
            }
        }
    }

    public void i(Lifecycle.Event event) {
        p.i(event, "event");
        g("handleLifecycleEvent");
        k(event.getTargetState());
    }

    public final boolean j() {
        if (this.observerMap.size() == 0) {
            return true;
        }
        Map.Entry<InterfaceC1397o, b> entryB = this.observerMap.b();
        p.f(entryB);
        Lifecycle.State state = entryB.getValue().getState();
        Map.Entry<InterfaceC1397o, b> entryF = this.observerMap.f();
        p.f(entryF);
        Lifecycle.State state2 = entryF.getValue().getState();
        return state == state2 && this.state == state2;
    }

    public final void k(Lifecycle.State next) {
        if (this.state == next) {
            return;
        }
        r.a(this.lifecycleOwner.get(), this.state, next);
        this.state = next;
        if (this.handlingEvent || this.addingObserverCounter != 0) {
            this.newEventOccurred = true;
            return;
        }
        this.handlingEvent = true;
        o();
        this.handlingEvent = false;
        if (this.state == Lifecycle.State.DESTROYED) {
            this.observerMap = new C4853a<>();
        }
    }

    public final void l() {
        this.parentStates.remove(r1.size() - 1);
    }

    public final void m(Lifecycle.State state) {
        this.parentStates.add(state);
    }

    public void n(Lifecycle.State state) {
        p.i(state, "state");
        g("setCurrentState");
        k(state);
    }

    public final void o() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!j()) {
            this.newEventOccurred = false;
            Lifecycle.State state = this.state;
            Map.Entry<InterfaceC1397o, b> entryB = this.observerMap.b();
            p.f(entryB);
            if (state.compareTo(entryB.getValue().getState()) < 0) {
                e(lifecycleOwner);
            }
            Map.Entry<InterfaceC1397o, b> entryF = this.observerMap.f();
            if (!this.newEventOccurred && entryF != null && this.state.compareTo(entryF.getValue().getState()) > 0) {
                h(lifecycleOwner);
            }
        }
        this.newEventOccurred = false;
        this._currentStateFlow.setValue(getState());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1399q(LifecycleOwner provider) {
        this(provider, true);
        p.i(provider, "provider");
    }
}
