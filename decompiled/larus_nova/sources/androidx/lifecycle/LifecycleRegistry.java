package androidx.lifecycle;

import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000 <2\u00020\u0001:\u0002;<B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eH\u0017J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u000eH\u0002J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000bH\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u000bH\u0017J\b\u0010/\u001a\u00020\u0019H\u0002J\u0010\u00100\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u00101\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u000bH\u0017J\u0010\u00105\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u00106\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u00107\u001a\u00020\u0019H\u0002J\u0010\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020:H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0016j\b\u0012\u0004\u0012\u00020\u000e`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010*\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u00102\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006="}, d2 = {"Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", ShortVideoSegments.KEY_PROP_PROVIDER, "Landroidx/lifecycle/LifecycleOwner;", "enforceMainThread", "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "(Landroidx/lifecycle/LifecycleOwner;)V", "observerMap", "Landroidx/arch/core/internal/FastSafeIterableMap;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "state", "Landroidx/lifecycle/Lifecycle$State;", "lifecycleOwner", "Ljava/lang/ref/WeakReference;", "addingObserverCounter", "", "handlingEvent", "newEventOccurred", "parentStates", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "markState", "", "currentState", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "setCurrentState", "(Landroidx/lifecycle/Lifecycle$State;)V", "_currentStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "currentStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "handleLifecycleEvent", "event", "Landroidx/lifecycle/Lifecycle$Event;", "moveToState", TeaEventTrack.ACTION_DRAMA_NEXT, "isSynced", "()Z", "calculateTargetState", "observer", "addObserver", "popParentState", "pushParentState", "removeObserver", "observerCount", "getObserverCount", "()I", "forwardPass", "backwardPass", DocumentType.DOCX_SYNC_BLOCK_NAME, "enforceMainThreadIfNeeded", "methodName", "", "ObserverWithState", "Companion", "lifecycle-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class LifecycleRegistry extends Lifecycle {
    public static final Companion Companion = null;
    private final z0<Lifecycle.State> _currentStateFlow;
    private int addingObserverCounter;
    private final boolean enforceMainThread;
    private boolean handlingEvent;
    private final WeakReference<LifecycleOwner> lifecycleOwner;
    private boolean newEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> observerMap;
    private ArrayList<Lifecycle.State> parentStates;
    private Lifecycle.State state;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$Companion;", "", "<init>", "()V", "createUnsafe", "Landroidx/lifecycle/LifecycleRegistry;", "owner", "Landroidx/lifecycle/LifecycleOwner;", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "Landroidx/lifecycle/Lifecycle$State;", "state1", "state2", "min$lifecycle_runtime", "lifecycle-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final LifecycleRegistry createUnsafe(LifecycleOwner r100) {
            Intrinsics.checkNotNullParameter(r100, "owner");
            return new LifecycleRegistry(r100, false, null);
        }

        @JvmStatic
        public final Lifecycle.State min$lifecycle_runtime(Lifecycle.State r100, Lifecycle.State r101) {
            Intrinsics.checkNotNullParameter(r100, "state1");
            if (r101 != null) goto L5;
            return r100;
        L5:
            if (r101.compareTo(r100) < 0) goto L7;
            return r100;
        L7:
            return r101;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "initialState", "Landroidx/lifecycle/Lifecycle$State;", "<init>", "(Landroidx/lifecycle/LifecycleObserver;Landroidx/lifecycle/Lifecycle$State;)V", "state", "getState", "()Landroidx/lifecycle/Lifecycle$State;", "setState", "(Landroidx/lifecycle/Lifecycle$State;)V", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "getLifecycleObserver", "()Landroidx/lifecycle/LifecycleEventObserver;", "setLifecycleObserver", "(Landroidx/lifecycle/LifecycleEventObserver;)V", "dispatchEvent", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ObserverWithState {
        private LifecycleEventObserver lifecycleObserver;
        private Lifecycle.State state;

        public final LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        public final Lifecycle.State getState() {
            return this.state;
        }

        public final void setLifecycleObserver(LifecycleEventObserver r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.lifecycleObserver = r100;
        }

        public final void setState(Lifecycle.State r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.state = r100;
        }

        public ObserverWithState(LifecycleObserver r100, Lifecycle.State r101) {
            Intrinsics.checkNotNullParameter(r101, "initialState");
            Intrinsics.checkNotNull(r100);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(r100);
            this.state = r101;
        }

        public final void dispatchEvent(LifecycleOwner r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r101, "event");
            Lifecycle.State r102 = r101.getTargetState();
            this.state = LifecycleRegistry.Companion.min$lifecycle_runtime(this.state, r102);
            LifecycleEventObserver r103 = this.lifecycleObserver;
            Intrinsics.checkNotNull(r100);
            r103.onStateChanged(r100, r101);
            this.state = r102;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ LifecycleRegistry(LifecycleOwner r100, boolean r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    @JvmStatic
    public static final LifecycleRegistry createUnsafe(LifecycleOwner r100) {
        return Companion.createUnsafe(r100);
    }

    @JvmStatic
    public static final Lifecycle.State min$lifecycle_runtime(Lifecycle.State r100, Lifecycle.State r101) {
        return Companion.min$lifecycle_runtime(r100, r101);
    }

    private final boolean isSynced() {
        if (this.observerMap.size() != 0) goto L5;
        return true;
    L5:
        Map.Entry<LifecycleObserver, ObserverWithState> r100 = this.observerMap.eldest();
        Intrinsics.checkNotNull(r100);
        Lifecycle.State r101 = r100.getValue().getState();
        Map.Entry<LifecycleObserver, ObserverWithState> r102 = this.observerMap.newest();
        Intrinsics.checkNotNull(r102);
        Lifecycle.State r103 = r102.getValue().getState();
        if (r101 == r103) goto L8;
    L10:
        return false;
    L8:
        if (this.state != r103) goto L10;
        return true;
    }

    private final void popParentState() {
        ArrayList<Lifecycle.State> r100 = this.parentStates;
        ListProtector.remove(r100, r100.size() - 1);
    }

    private final void sync() {
        LifecycleOwner r100 = this.lifecycleOwner.get();
        if (r100 == null) goto L18;
    L5:
        if (isSynced() == true) goto L15;
        this.newEventOccurred = false;
        Lifecycle.State r101 = this.state;
        Map.Entry<LifecycleObserver, ObserverWithState> r102 = this.observerMap.eldest();
        Intrinsics.checkNotNull(r102);
        if (r101.compareTo(r102.getValue().getState()) >= 0) goto L9;
        backwardPass(r100);
    L9:
        Map.Entry<LifecycleObserver, ObserverWithState> r103 = this.observerMap.newest();
        if (this.newEventOccurred == true) goto L5;
        if (r103 == null) goto L5;
        if (this.state.compareTo(r103.getValue().getState()) <= 0) goto L5;
        forwardPass(r100);
        goto L5
    L15:
        this.newEventOccurred = false;
        this._currentStateFlow.setValue(getCurrentState());
        return;
    L18:
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    @Override // androidx.lifecycle.Lifecycle
    public i1<Lifecycle.State> getCurrentStateFlow() {
        return kotlinx.coroutines.flow.e.b(this._currentStateFlow);
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.observerMap.size();
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State getCurrentState() {
        return this.state;
    }

    public LifecycleRegistry(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this(r100, true);
    }

    private final void backwardPass(LifecycleOwner r100) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> r101 = this.observerMap.descendingIterator();
    L4:
        if (r101.hasNext() == false) goto L19;
        if (this.newEventOccurred == true) goto L27;
        Map.Entry<LifecycleObserver, ObserverWithState> r102 = r101.next();
        Intrinsics.checkNotNull(r102);
        LifecycleObserver r103 = r102.getKey();
        ObserverWithState r104 = r102.getValue();
    L9:
        if (r104.getState().compareTo(this.state) <= 0) goto L4;
        if (this.newEventOccurred == true) goto L4;
        if (this.observerMap.contains(r103) == false) goto L4;
        Lifecycle.Event r105 = Lifecycle.Event.Companion.downFrom(r104.getState());
        if (r105 == null) goto L18;
        pushParentState(r105.getTargetState());
        r104.dispatchEvent(r100, r105);
        popParentState();
        goto L9
    L18:
        throw new IllegalStateException("no event down from " + r104.getState());
    L27:
        return;
    }

    private final Lifecycle.State calculateTargetState(LifecycleObserver r100) {
        Map.Entry<LifecycleObserver, ObserverWithState> r101 = this.observerMap.ceil(r100);
        Lifecycle.State r102 = null;
        if (r101 == null) goto L7;
        ObserverWithState r103 = r101.getValue();
        if (r103 == null) goto L7;
        Lifecycle.State r104 = r103.getState();
    L9:
        if ((!this.parentStates.isEmpty()) == false) goto L11;
        ArrayList<Lifecycle.State> r105 = this.parentStates;
        r102 = (Lifecycle.State) ListProtector.get(r105, r105.size() - 1);
    L11:
        Companion r106 = Companion;
        return r106.min$lifecycle_runtime(r106.min$lifecycle_runtime(this.state, r104), r102);
    L7:
        r104 = null;
        goto L9
    }

    private final void enforceMainThreadIfNeeded(String r100) {
        if (this.enforceMainThread == true) goto L5;
        return;
    L5:
        if (LifecycleRegistry_androidKt.isMainThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(("Method " + r100 + " must be called on the main thread").toString());
    }

    private final void forwardPass(LifecycleOwner r100) {
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions r101 = this.observerMap.iteratorWithAdditions();
    L4:
        if (r101.hasNext() == false) goto L19;
        if (this.newEventOccurred == true) goto L27;
        Map.Entry r102 = r101.next();
        LifecycleObserver r103 = (LifecycleObserver) r102.getKey();
        ObserverWithState r104 = (ObserverWithState) r102.getValue();
    L9:
        if (r104.getState().compareTo(this.state) >= 0) goto L4;
        if (this.newEventOccurred == true) goto L4;
        if (this.observerMap.contains(r103) == false) goto L4;
        pushParentState(r104.getState());
        Lifecycle.Event r105 = Lifecycle.Event.Companion.upFrom(r104.getState());
        if (r105 == null) goto L18;
        r104.dispatchEvent(r100, r105);
        popParentState();
        goto L9
    L18:
        throw new IllegalStateException("no event up from " + r104.getState());
    L27:
        return;
    }

    private final void moveToState(Lifecycle.State r100) {
        if (this.state != r100) goto L5;
        return;
    L5:
        LifecycleRegistryKt.checkLifecycleStateTransition(this.lifecycleOwner.get(), this.state, r100);
        this.state = r100;
        if (this.handlingEvent == false) goto L8;
    L14:
        this.newEventOccurred = true;
        return;
    L8:
        if (this.addingObserverCounter != 0) goto L14;
        this.handlingEvent = true;
        sync();
        this.handlingEvent = false;
        if (this.state != Lifecycle.State.DESTROYED) goto L16;
        this.observerMap = new FastSafeIterableMap();
        return;
    }

    private final void pushParentState(Lifecycle.State r100) {
        this.parentStates.add(r100);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State r101 = this.state;
        Lifecycle.State r102 = Lifecycle.State.DESTROYED;
        if (r101 == r102) goto L6;
        r102 = Lifecycle.State.INITIALIZED;
    L6:
        ObserverWithState r103 = new ObserverWithState(r100, r102);
        if (this.observerMap.putIfAbsent(r100, r103) == null) goto L9;
        return;
    L9:
        LifecycleOwner r104 = this.lifecycleOwner.get();
        if (r104 != null) goto L13;
        return;
    L13:
        if (this.addingObserverCounter == 0) goto L15;
    L18:
        boolean r105 = true;
    L19:
        Lifecycle.State r106 = calculateTargetState(r100);
        this.addingObserverCounter++;
    L21:
        if (r103.getState().compareTo(r106) >= 0) goto L29;
        if (this.observerMap.contains(r100) == false) goto L29;
        pushParentState(r103.getState());
        Lifecycle.Event r107 = Lifecycle.Event.Companion.upFrom(r103.getState());
        if (r107 == null) goto L28;
        r103.dispatchEvent(r104, r107);
        popParentState();
        r106 = calculateTargetState(r100);
        goto L21
    L28:
        throw new IllegalStateException("no event up from " + r103.getState());
    L29:
        if (r105 == true) goto L31;
        sync();
    L31:
        this.addingObserverCounter--;
        return;
    L15:
        if (this.handlingEvent == true) goto L18;
        r105 = false;
        goto L19
    }

    public void handleLifecycleEvent(Lifecycle.Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(r100.getTargetState());
    }

    @Deprecated(message = "Override [currentState].")
    public void markState(Lifecycle.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        enforceMainThreadIfNeeded("markState");
        setCurrentState(r100);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(r100);
    }

    public void setCurrentState(Lifecycle.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(r100);
    }

    private LifecycleRegistry(LifecycleOwner r100, boolean r101) {
        this.enforceMainThread = r101;
        this.observerMap = new FastSafeIterableMap();
        Lifecycle.State r102 = Lifecycle.State.INITIALIZED;
        this.state = r102;
        this.parentStates = new ArrayList();
        this.lifecycleOwner = new WeakReference(r100);
        this._currentStateFlow = j1.a(r102);
    }
}
