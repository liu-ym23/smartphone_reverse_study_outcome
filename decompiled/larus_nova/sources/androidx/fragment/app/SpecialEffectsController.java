package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
abstract class SpecialEffectsController {
    private final ViewGroup mContainer;
    boolean mIsContainerPostponed;
    boolean mOperationDirectionIsPop;
    final ArrayList<Operation> mPendingOperations;
    final ArrayList<Operation> mRunningOperations;

    /* JADX INFO: renamed from: androidx.fragment.app.SpecialEffectsController$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = null;
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = null;

        static {
            int[] r100 = new int[Operation.LifecycleImpact.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = r100;
            r100[Operation.LifecycleImpact.ADDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[Operation.LifecycleImpact.REMOVING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[Operation.LifecycleImpact.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            int[] r101 = new int[Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = r101;
            r101[Operation.State.REMOVED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[Operation.State.VISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L21:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[Operation.State.GONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L25:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[Operation.State.INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    public static class FragmentStateManagerOperation extends Operation {
        private final FragmentStateManager mFragmentStateManager;

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void complete() {
            super.complete();
            this.mFragmentStateManager.moveToExpectedState();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void onStart() {
            if (getLifecycleImpact() != Operation.LifecycleImpact.ADDING) goto L19;
            Fragment r100 = this.mFragmentStateManager.getFragment();
            View r101 = r100.mView.findFocus();
            if (r101 == null) goto L9;
            r100.setFocusedView(r101);
            if (FragmentManager.isLoggingEnabled(2) == false) goto L9;
            r101.toString();
            r100.toString();
        L9:
            View r102 = getFragment().requireView();
            if (r102.getParent() != null) goto L13;
            this.mFragmentStateManager.addViewToContainer();
            r102.setAlpha(0.0f);
        L13:
            if (r102.getAlpha() == 0.0f) goto L15;
        L17:
            r102.setAlpha(r100.getPostOnViewCreatedAlpha());
            return;
        L15:
            if (r102.getVisibility() != 0) goto L17;
            r102.setVisibility(4);
            goto L17
        L19:
            if (getLifecycleImpact() != Operation.LifecycleImpact.REMOVING) goto L26;
            Fragment r103 = this.mFragmentStateManager.getFragment();
            View r104 = r103.requireView();
            if (FragmentManager.isLoggingEnabled(2) == false) goto L23;
            Objects.toString(r104.findFocus());
            r104.toString();
            r103.toString();
        L23:
            r104.clearFocus();
            return;
        }

        public FragmentStateManagerOperation(Operation.State r100, Operation.LifecycleImpact r101, FragmentStateManager r102, CancellationSignal r103) {
            super(r100, r101, r102.getFragment(), r103);
            this.mFragmentStateManager = r102;
        }
    }

    public static class Operation {
        private final List<Runnable> mCompletionListeners;
        private State mFinalState;
        private final Fragment mFragment;
        private boolean mIsCanceled;
        private boolean mIsComplete;
        private LifecycleImpact mLifecycleImpact;
        private final HashSet<CancellationSignal> mSpecialEffectsSignals;

        public static final enum LifecycleImpact extends Enum<LifecycleImpact> {
            private static final /* synthetic */ LifecycleImpact[] $VALUES = null;
            public static final LifecycleImpact ADDING = null;
            public static final LifecycleImpact NONE = null;
            public static final LifecycleImpact REMOVING = null;

            static {
                LifecycleImpact r100 = new LifecycleImpact(UserProfileEvent.POSITION_NONE, 0);
                NONE = r100;
                LifecycleImpact r101 = new LifecycleImpact("ADDING", 1);
                ADDING = r101;
                LifecycleImpact r102 = new LifecycleImpact("REMOVING", 2);
                REMOVING = r102;
                $VALUES = new LifecycleImpact[]{r100, r101, r102};
            }

            public static LifecycleImpact[] values() {
                return (LifecycleImpact[]) $VALUES.clone();
            }

            public static LifecycleImpact valueOf(String r100) {
                return (LifecycleImpact) r27.a.a(LifecycleImpact.class, r100);
            }

            private LifecycleImpact(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum State extends Enum<State> {
            private static final /* synthetic */ State[] $VALUES = null;
            public static final State GONE = null;
            public static final State INVISIBLE = null;
            public static final State REMOVED = null;
            public static final State VISIBLE = null;

            static {
                State r100 = new State("REMOVED", 0);
                REMOVED = r100;
                State r101 = new State("VISIBLE", 1);
                VISIBLE = r101;
                State r102 = new State("GONE", 2);
                GONE = r102;
                State r103 = new State("INVISIBLE", 3);
                INVISIBLE = r103;
                $VALUES = new State[]{r100, r101, r102, r103};
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }

            public static State from(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 4) goto L12;
                if (r100 != 8) goto L10;
                return GONE;
            L10:
                throw new IllegalArgumentException("Unknown visibility " + r100);
            L12:
                return INVISIBLE;
            L14:
                return VISIBLE;
            }

            public static State valueOf(String r100) {
                return (State) r27.a.a(State.class, r100);
            }

            public void applyState(View r100) {
                int r101 = AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[ordinal()];
                if (r101 == 1) goto L22;
                if (r101 == 2) goto L19;
                if (r101 == 3) goto L15;
                if (r101 == 4) goto L11;
                return;
            L11:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L13;
                Objects.toString(r100);
            L13:
                r100.setVisibility(4);
                return;
            L15:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L17;
                Objects.toString(r100);
            L17:
                r100.setVisibility(8);
                return;
            L19:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L21;
                Objects.toString(r100);
            L21:
                r100.setVisibility(0);
                return;
            L22:
                ViewGroup r102 = (ViewGroup) r100.getParent();
                if (r102 != null) goto L25;
                return;
            L25:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L27;
                r100.toString();
                r102.toString();
            L27:
                r102.removeView(r100);
            }

            public static State from(View r100) {
                if (r100.getAlpha() != 0.0f) goto L9;
                if (r100.getVisibility() != 0) goto L9;
                return INVISIBLE;
            L9:
                return from(r100.getVisibility());
            }

            private State(String r100, int r101) {
                super(r100, r101);
            }
        }

        public void onStart() {
        }

        public void complete() {
            if (this.mIsComplete == false) goto L6;
            return;
        L6:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
            toString();
        L8:
            this.mIsComplete = true;
            Iterator<Runnable> r100 = this.mCompletionListeners.iterator();
        L10:
            if (r100.hasNext() == false) goto L12;
            r100.next().run();
            goto L10
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.mFinalState + "} {mLifecycleImpact = " + this.mLifecycleImpact + "} {mFragment = " + this.mFragment + i.f25855d;
        }

        public final void cancel() {
            if (isCanceled() == false) goto L5;
            return;
        L5:
            this.mIsCanceled = true;
            if (this.mSpecialEffectsSignals.isEmpty() == false) goto L8;
            complete();
            return;
        L8:
            Iterator r100 = new ArrayList(this.mSpecialEffectsSignals).iterator();
        L10:
            if (r100.hasNext() == false) goto L14;
            ((CancellationSignal) r100.next()).cancel();
            goto L10
        }

        public State getFinalState() {
            return this.mFinalState;
        }

        public final Fragment getFragment() {
            return this.mFragment;
        }

        public LifecycleImpact getLifecycleImpact() {
            return this.mLifecycleImpact;
        }

        public final boolean isCanceled() {
            return this.mIsCanceled;
        }

        public final boolean isComplete() {
            return this.mIsComplete;
        }

        public final void addCompletionListener(Runnable r100) {
            this.mCompletionListeners.add(r100);
        }

        public final void completeSpecialEffect(CancellationSignal r100) {
            if (this.mSpecialEffectsSignals.remove(r100) == true) goto L5;
            return;
        L5:
            if (this.mSpecialEffectsSignals.isEmpty() == false) goto L9;
            complete();
            return;
        }

        public final void markStartedSpecialEffect(CancellationSignal r100) {
            onStart();
            this.mSpecialEffectsSignals.add(r100);
        }

        public final void mergeWith(State r100, LifecycleImpact r101) {
            int r102 = AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[r101.ordinal()];
            if (r102 == 1) goto L19;
            if (r102 == 2) goto L15;
            if (r102 == 3) goto L9;
            return;
        L9:
            if (this.mFinalState != State.REMOVED) goto L11;
            return;
        L11:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L13;
            Objects.toString(this.mFragment);
            Objects.toString(this.mFinalState);
            Objects.toString(r100);
        L13:
            this.mFinalState = r100;
            return;
        L15:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L17;
            Objects.toString(this.mFragment);
            Objects.toString(this.mFinalState);
            Objects.toString(this.mLifecycleImpact);
        L17:
            this.mFinalState = State.REMOVED;
            this.mLifecycleImpact = LifecycleImpact.REMOVING;
            return;
        L19:
            if (this.mFinalState == State.REMOVED) goto L21;
            return;
        L21:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L23;
            Objects.toString(this.mFragment);
            Objects.toString(this.mLifecycleImpact);
        L23:
            this.mFinalState = State.VISIBLE;
            this.mLifecycleImpact = LifecycleImpact.ADDING;
        }

        public Operation(State r100, LifecycleImpact r101, Fragment r102, CancellationSignal r103) {
            this.mCompletionListeners = new ArrayList();
            this.mSpecialEffectsSignals = new HashSet();
            this.mIsCanceled = false;
            this.mIsComplete = false;
            this.mFinalState = r100;
            this.mLifecycleImpact = r101;
            this.mFragment = r102;
            r103.setOnCancelListener(new AnonymousClass1(this));
        }
    }

    public abstract void executeOperations(List<Operation> r100, boolean r101);

    public void forceCompleteAllOperations() {
        FragmentManager.isLoggingEnabled(2);
        boolean r100 = ViewCompat.isAttachedToWindow(this.mContainer);
        ArrayList<Operation> r101 = this.mPendingOperations;
        monitor-enter(r101);
        updateFinalState();     // Catch: Throwable -> L32
        Iterator<Operation> r102 = this.mPendingOperations.iterator();     // Catch: Throwable -> L32
    L6:
        if (r102.hasNext() == false) goto L8;
        r102.next().onStart();     // Catch: Throwable -> L32
        goto L6
    L8:
        Iterator r103 = new ArrayList(this.mRunningOperations).iterator();     // Catch: Throwable -> L32
    L10:
        if (r103.hasNext() == false) goto L19;
        Operation r104 = (Operation) r103.next();     // Catch: Throwable -> L32
        if (FragmentManager.isLoggingEnabled(2) == false) goto L18;
        if (r100 == true) goto L17;
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L32
        r105.append("Container ");     // Catch: Throwable -> L32
        r105.append(this.mContainer);     // Catch: Throwable -> L32
        r105.append(" is not attached to window. ");     // Catch: Throwable -> L32
    L17:
        Objects.toString(r104);     // Catch: Throwable -> L32
    L18:
        r104.cancel();     // Catch: Throwable -> L32
        goto L10
    L19:
        Iterator r106 = new ArrayList(this.mPendingOperations).iterator();     // Catch: Throwable -> L32
    L21:
        if (r106.hasNext() == false) goto L30;
        Operation r107 = (Operation) r106.next();     // Catch: Throwable -> L32
        if (FragmentManager.isLoggingEnabled(2) == false) goto L29;
        if (r100 == true) goto L28;
        StringBuilder r108 = new StringBuilder();     // Catch: Throwable -> L32
        r108.append("Container ");     // Catch: Throwable -> L32
        r108.append(this.mContainer);     // Catch: Throwable -> L32
        r108.append(" is not attached to window. ");     // Catch: Throwable -> L32
    L28:
        Objects.toString(r107);     // Catch: Throwable -> L32
    L29:
        r107.cancel();     // Catch: Throwable -> L32
        goto L21
    L30:
        monitor-exit(r101);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    }

    private void updateFinalState() {
        Iterator<Operation> r100 = this.mPendingOperations.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Operation r101 = r100.next();
        if (r101.getLifecycleImpact() != Operation.LifecycleImpact.ADDING) goto L4;
        r101.mergeWith(Operation.State.from(r101.getFragment().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
        goto L4
    }

    public void executePendingOperations() {
        if (this.mIsContainerPostponed == false) goto L6;
        return;
    L6:
        if (ViewCompat.isAttachedToWindow(this.mContainer) == true) goto L9;
        forceCompleteAllOperations();
        this.mOperationDirectionIsPop = false;
        return;
    L9:
        ArrayList<Operation> r100 = this.mPendingOperations;
        monitor-enter(r100);
    L29:
        th = move-exception;
        throw th;
    L12:
        if (this.mPendingOperations.isEmpty() == true) goto L27;
        ArrayList r101 = new ArrayList(this.mRunningOperations);     // Catch: Throwable -> L29
        this.mRunningOperations.clear();     // Catch: Throwable -> L29
        Iterator r102 = r101.iterator();     // Catch: Throwable -> L29
    L15:
        if (r102.hasNext() == false) goto L22;
        Operation r103 = (Operation) r102.next();     // Catch: Throwable -> L29
        if (FragmentManager.isLoggingEnabled(2) == false) goto L19;
        Objects.toString(r103);     // Catch: Throwable -> L29
    L19:
        r103.cancel();     // Catch: Throwable -> L29
        if (r103.isComplete() == true) goto L15;
        this.mRunningOperations.add(r103);     // Catch: Throwable -> L29
        goto L15
    L22:
        updateFinalState();     // Catch: Throwable -> L29
        ArrayList r104 = new ArrayList(this.mPendingOperations);     // Catch: Throwable -> L29
        this.mPendingOperations.clear();     // Catch: Throwable -> L29
        this.mRunningOperations.addAll(r104);     // Catch: Throwable -> L29
        FragmentManager.isLoggingEnabled(2);     // Catch: Throwable -> L29
        Iterator r105 = r104.iterator();     // Catch: Throwable -> L29
    L24:
        if (r105.hasNext() == false) goto L26;
        ((Operation) r105.next()).onStart();     // Catch: Throwable -> L29
        goto L24
    L26:
        executeOperations(r104, this.mOperationDirectionIsPop);     // Catch: Throwable -> L29
        this.mOperationDirectionIsPop = false;     // Catch: Throwable -> L29
        FragmentManager.isLoggingEnabled(2);     // Catch: Throwable -> L29
    L27:
        monitor-exit(r100);     // Catch: Throwable -> L29
    }

    public void forcePostponedExecutePendingOperations() {
        if (this.mIsContainerPostponed == false) goto L6;
        FragmentManager.isLoggingEnabled(2);
        this.mIsContainerPostponed = false;
        executePendingOperations();
        return;
    }

    public void markPostponedState() {
        ArrayList<Operation> r100 = this.mPendingOperations;
        monitor-enter(r100);
        updateFinalState();     // Catch: Throwable -> L13
        this.mIsContainerPostponed = false;     // Catch: Throwable -> L13
        int r101 = this.mPendingOperations.size() - 1;     // Catch: Throwable -> L13
    L5:
        if (r101 < 0) goto L11;
        Operation r102 = this.mPendingOperations.get(r101);     // Catch: Throwable -> L13
        Operation.State r103 = Operation.State.from(r102.getFragment().mView);     // Catch: Throwable -> L13
        Operation.State r104 = r102.getFinalState();     // Catch: Throwable -> L13
        Operation.State r105 = Operation.State.VISIBLE;     // Catch: Throwable -> L13
        if (r104 != r105) goto L10;
        if (r103 == r105) goto L10;
        this.mIsContainerPostponed = r102.getFragment().isPostponed();     // Catch: Throwable -> L13
    L10:
        r101 = r101 - 1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public ViewGroup getContainer() {
        return this.mContainer;
    }

    public SpecialEffectsController(ViewGroup r100) {
        this.mPendingOperations = new ArrayList();
        this.mRunningOperations = new ArrayList();
        this.mOperationDirectionIsPop = false;
        this.mIsContainerPostponed = false;
        this.mContainer = r100;
    }

    private Operation findPendingOperation(Fragment r100) {
        Iterator<Operation> r101 = this.mPendingOperations.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Operation r102 = r101.next();
        if (r102.getFragment().equals(r100) == false) goto L4;
        if (r102.isCanceled() == true) goto L4;
        return r102;
    L10:
        return null;
    }

    private Operation findRunningOperation(Fragment r100) {
        Iterator<Operation> r101 = this.mRunningOperations.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Operation r102 = r101.next();
        if (r102.getFragment().equals(r100) == false) goto L4;
        if (r102.isCanceled() == true) goto L4;
        return r102;
    L10:
        return null;
    }

    public void enqueueHide(FragmentStateManager r100) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Objects.toString(r100.getFragment());
    L5:
        enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, r100);
    }

    public void enqueueRemove(FragmentStateManager r100) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Objects.toString(r100.getFragment());
    L5:
        enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, r100);
    }

    public void enqueueShow(FragmentStateManager r100) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Objects.toString(r100.getFragment());
    L5:
        enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, r100);
    }

    public Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(FragmentStateManager r100) {
        Operation r101 = findPendingOperation(r100.getFragment());
        if (r101 == null) goto L5;
        Operation.LifecycleImpact r102 = r101.getLifecycleImpact();
    L6:
        Operation r103 = findRunningOperation(r100.getFragment());
        if (r103 == null) goto L13;
        if (r102 == null) goto L12;
        if (r102 != Operation.LifecycleImpact.NONE) goto L13;
    L12:
        return r103.getLifecycleImpact();
    L13:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public void updateOperationDirection(boolean r100) {
        this.mOperationDirectionIsPop = r100;
    }

    public static SpecialEffectsController getOrCreateController(ViewGroup r100, SpecialEffectsControllerFactory r101) {
        Object r102 = r100.getTag(R.id.special_effects_controller_view_tag);
        if ((r102 instanceof SpecialEffectsController) == true) goto L5;
        SpecialEffectsController r103 = r101.createController(r100);
        r100.setTag(R.id.special_effects_controller_view_tag, r103);
        return r103;
    L5:
        return (SpecialEffectsController) r102;
    }

    public void enqueueAdd(Operation.State r100, FragmentStateManager r101) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Objects.toString(r101.getFragment());
    L5:
        enqueue(r100, Operation.LifecycleImpact.ADDING, r101);
    }

    public static SpecialEffectsController getOrCreateController(ViewGroup r100, FragmentManager r101) {
        return getOrCreateController(r100, r101.getSpecialEffectsControllerFactory());
    }

    private void enqueue(Operation.State r100, Operation.LifecycleImpact r101, FragmentStateManager r102) {
        ArrayList<Operation> r103 = this.mPendingOperations;
        monitor-enter(r103);
        CancellationSignal r104 = new CancellationSignal();     // Catch: Throwable -> L12
        Operation r105 = findPendingOperation(r102.getFragment());     // Catch: Throwable -> L12
        if (r105 == null) goto L9;
        r105.mergeWith(r100, r101);     // Catch: Throwable -> L12
        monitor-exit(r103);     // Catch: Throwable -> L12
        return;
    L9:
        final FragmentStateManagerOperation r106 = new FragmentStateManagerOperation(r100, r101, r102, r104);     // Catch: Throwable -> L12
        this.mPendingOperations.add(r106);     // Catch: Throwable -> L12
        r106.addCompletionListener(new AnonymousClass1(this, r106));     // Catch: Throwable -> L12
        r106.addCompletionListener(new AnonymousClass2(this, r106));     // Catch: Throwable -> L12
        monitor-exit(r103);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
