package com.android.server.wm;

import android.os.Trace;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.SparseArray;
import android.util.SparseLongArray;
import android.util.proto.ProtoOutputStream;
import android.view.InsetsSource;
import android.view.InsetsSourceControl;
import android.view.InsetsState;
import android.view.WindowInsets;
import android.view.inputmethod.ImeTracker;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.inputmethod.InputMethodManagerInternal;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
class InsetsStateController {
    private final ArrayMap<InsetsControlTarget, ArrayList<InsetsSourceProvider>> mControlTargetProvidersMap;
    private final Consumer<WindowState> mDispatchInsetsChanged;
    private final DisplayContent mDisplayContent;
    private final InsetsControlTarget mEmptyImeControlTarget;
    private int mForcedConsumingTypes;
    private final SparseArray<InsetsControlTarget> mIdControlTargetMap;
    private final SparseArray<InsetsControlTarget> mIdFakeControlTargetMap;
    private final InsetsState mLastState;
    private final ArrayMap<InsetsControlTarget, ArrayList<InsetsSourceProvider>> mPendingTargetProvidersMap;
    private final SparseArray<InsetsSourceProvider> mProviders;
    private final InsetsState mState;
    private final SparseLongArray mSurfaceTransactionIds;

    /* JADX INFO: renamed from: com.android.server.wm.InsetsStateController$1, reason: invalid class name */
    class AnonymousClass1 implements InsetsControlTarget {
        final /* synthetic */ InsetsStateController this$0;

        public static /* synthetic */ void $r8$lambda$UjLlQbcGcYIO1UklJ0WxgRK60HM(int r0) {
            lambda$notifyInsetsControlChanged$0(r0);
        }

        AnonymousClass1(InsetsStateController this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.wm.InsetsControlTarget
        public void notifyInsetsControlChanged(final int displayId) {
            InsetsSourceControl[] controls = this.this$0.getControlsForDispatch(this);
            if (controls != null) goto L5;
            return;
        L5:
            int r1 = controls.length;
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L11;
            InsetsSourceControl control = controls[r2];
            if (control.getType() != WindowInsets.Type.ime()) goto L10;
            InsetsStateController.m10020$$Nest$fgetmDisplayContent(this.this$0).mWmService.mH.post(new InsetsStateController$1$$ExternalSyntheticLambda0(displayId));
        L10:
            r2 = r2 + 1;
            goto L6
        }

        private static /* synthetic */ void lambda$notifyInsetsControlChanged$0(int displayId) {
            InputMethodManagerInternal.get().removeImeSurface(displayId);
        }
    }

    public static /* synthetic */ ArrayList $r8$lambda$9P0lIIOEjVyKR81E86PJUW6hJRs(InsetsControlTarget r0) {
        return lambda$addToPendingControlMaps$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$ByGwbLxcGKvL9evJ-S2rqZyHoIw, reason: not valid java name */
    public static /* synthetic */ void m10019$r8$lambda$ByGwbLxcGKvL9evJS2rqZyHoIw(WindowState r0) {
        lambda$new$0(r0);
    }

    public static /* synthetic */ ArrayList $r8$lambda$TzYyjwJniEoBgyDjbMpQVgjWyYo(InsetsControlTarget r0) {
        return lambda$addToControlMaps$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$a0HV9ad2Wd_wQT3ba_TprluaiHw(InsetsStateController r0, int r1, SparseLongArray r2) {
        r0.lambda$notifyPendingInsetsControlChanged$4(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$tyu8cagOKV5anXv5qidgt8V37vE(InsetsStateController r0, ArrayList r1, WindowState r2) {
        r0.lambda$onDisplayFramesUpdated$1(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayContent, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayContent m10020$$Nest$fgetmDisplayContent(InsetsStateController r0) {
        return r0.mDisplayContent;
    }

    private static /* synthetic */ void lambda$new$0(WindowState w) {
        if (w.isReadyToDispatchInsetsState() == false) goto L6;
        w.notifyInsetsChanged();
        return;
    }

    InsetsStateController(DisplayContent displayContent) {
        this.mLastState = new InsetsState();
        this.mState = new InsetsState();
        this.mProviders = new SparseArray();
        this.mSurfaceTransactionIds = new SparseLongArray();
        this.mControlTargetProvidersMap = new ArrayMap();
        this.mPendingTargetProvidersMap = new ArrayMap();
        this.mIdControlTargetMap = new SparseArray();
        this.mIdFakeControlTargetMap = new SparseArray();
        this.mDispatchInsetsChanged = new InsetsStateController$$ExternalSyntheticLambda3();
        this.mEmptyImeControlTarget = new AnonymousClass1(this);
        this.mDisplayContent = displayContent;
    }

    InsetsState getRawInsetsState() {
        return this.mState;
    }

    InsetsSourceControl[] getControlsForDispatch(InsetsControlTarget target) {
        ArrayList<InsetsSourceProvider> controlled = this.mControlTargetProvidersMap.get(target);
        if (controlled != null) goto L6;
        return null;
    L6:
        int size = controlled.size();
        InsetsSourceControl[] result = new InsetsSourceControl[size];
        int i = 0;
    L7:
        if (i >= size) goto L10;
        result[i] = controlled.get(i).getControl(target);
        i = i + 1;
        goto L7
    L10:
        return result;
    }

    SparseArray<InsetsSourceProvider> getSourceProviders() {
        return this.mProviders;
    }

    InsetsSourceProvider getOrCreateSourceProvider(int id, int type) {
        InsetsSourceProvider provider = this.mProviders.get(id);
        if (provider == null) goto L5;
        return provider;
    L5:
        InsetsSource source = this.mState.getOrCreateSource(id, type);
        if (id != InsetsSource.ID_IME) goto L8;
        InsetsSourceProvider provider2 = new ImeInsetsSourceProvider(source, this, this.mDisplayContent);
    L10:
        if ((this.mForcedConsumingTypes & type) == 0) goto L12;
        int r0 = 4;
    L13:
        provider2.setFlags(r0, 4);
        this.mProviders.put(id, provider2);
        return provider2;
    L12:
        r0 = 0;
        goto L13
    L8:
        provider2 = new InsetsSourceProvider(source, this, this.mDisplayContent);
        goto L10
    }

    ImeInsetsSourceProvider getImeSourceProvider() {
        return (ImeInsetsSourceProvider) getOrCreateSourceProvider(InsetsSource.ID_IME, WindowInsets.Type.ime());
    }

    void removeSourceProvider(int id) {
        if (id == InsetsSource.ID_IME) goto L6;
        this.mState.removeSource(id);
        this.mProviders.remove(id);
        return;
    }

    void setForcedConsumingTypes(int types) {
        if (this.mForcedConsumingTypes == types) goto L18;
        this.mForcedConsumingTypes = types;
        boolean changed = false;
        int i = this.mProviders.size() - 1;
    L5:
        if (i < 0) goto L12;
        InsetsSourceProvider provider = this.mProviders.valueAt(i);
        if ((provider.getSource().getType() & types) == 0) goto L9;
        int r3 = 4;
    L10:
        changed = changed | provider.setFlags(r3, 4);
        i = i - 1;
        goto L5
    L9:
        r3 = 0;
        goto L10
    L12:
        if (changed == false) goto L19;
        notifyInsetsChanged();
        return;
    L19:
        return;
    }

    void onPostLayout() {
        Trace.traceBegin(32, "ISC.onPostLayout");
        int i = this.mProviders.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mProviders.valueAt(i).onPostLayout();
        i = i - 1;
        goto L3
    L6:
        if (this.mLastState.equals(this.mState) == true) goto L8;
        this.mLastState.set(this.mState, true);
        notifyInsetsChanged();
    L8:
        Trace.traceEnd(32);
    }

    void updateAboveInsetsState(boolean notifyInsetsChange) {
        InsetsState aboveInsetsState = new InsetsState();
        aboveInsetsState.set(this.mState, (WindowInsets.Type.displayCutout() | WindowInsets.Type.systemGestures()) | WindowInsets.Type.mandatorySystemGestures());
        SparseArray<InsetsSource> localInsetsSourcesFromParent = new SparseArray();
        ArraySet<WindowState> insetsChangedWindows = new ArraySet();
        this.mDisplayContent.updateAboveInsetsState(aboveInsetsState, localInsetsSourcesFromParent, insetsChangedWindows);
        if (notifyInsetsChange == false) goto L7;
        int i = insetsChangedWindows.size() - 1;
    L5:
        if (i < 0) goto L9;
        this.mDispatchInsetsChanged.accept(insetsChangedWindows.valueAt(i));
        i = i - 1;
        goto L5
    L9:
        return;
    }

    void onDisplayFramesUpdated(boolean notifyInsetsChange) {
        final ArrayList<WindowState> insetsChangedWindows = new ArrayList();
        this.mDisplayContent.forAllWindows(new InsetsStateController$$ExternalSyntheticLambda2(this, insetsChangedWindows), true);
        if (notifyInsetsChange == false) goto L7;
        int i = insetsChangedWindows.size() - 1;
    L5:
        if (i < 0) goto L9;
        this.mDispatchInsetsChanged.accept(insetsChangedWindows.get(i));
        i = i - 1;
        goto L5
    L9:
        return;
    }

    private /* synthetic */ void lambda$onDisplayFramesUpdated$1(ArrayList insetsChangedWindows, WindowState w) {
        w.mAboveInsetsState.set(this.mState, WindowInsets.Type.displayCutout());
        insetsChangedWindows.add(w);
    }

    void onRequestedVisibleTypesChanged(InsetsTarget caller, int changedTypes, ImeTracker.Token statsToken) {
        boolean changed = false;
        int i = this.mProviders.size() - 1;
    L3:
        if (i < 0) goto L24;
        InsetsSourceProvider provider = this.mProviders.valueAt(i);
        int type = provider.getSource().getType();
        boolean r6 = false;
        if (type != WindowInsets.Type.ime()) goto L7;
        boolean isImeProvider = true;
    L9:
        if ((type & changedTypes) == 0) goto L20;
        if (isImeProvider == false) goto L12;
        ImeTracker.Token r7 = statsToken;
    L14:
        if (provider.updateClientVisibility(caller, r7) == false) goto L16;
    L17:
        r6 = true;
    L18:
        changed = changed | r6;
    L22:
        i = i - 1;
        goto L3
    L16:
        if (caller != provider.getFakeControlTarget()) goto L18;
    L12:
        r7 = null;
        goto L14
    L20:
        if (isImeProvider == false) goto L22;
        ImeTracker.forLogging().onCancelled(statsToken, 49);
        goto L22
    L7:
        isImeProvider = false;
        goto L9
    L24:
        if (changed == false) goto L31;
        notifyInsetsChanged();
        this.mDisplayContent.updateSystemGestureExclusion();
        this.mDisplayContent.getDisplayPolicy().updateSystemBarAttributes();
        return;
    }

    int getFakeControllingTypes(InsetsTarget target) {
        int types = 0;
        int i = this.mProviders.size() - 1;
    L3:
        if (i < 0) goto L9;
        InsetsSourceProvider provider = this.mProviders.valueAt(i);
        InsetsControlTarget fakeControlTarget = provider.getFakeControlTarget();
        if (target != fakeControlTarget) goto L7;
        types = types | provider.getSource().getType();
    L7:
        i = i - 1;
        goto L3
    L9:
        return types;
    }

    void onImeControlTargetChanged(InsetsControlTarget imeTarget) {
        if (imeTarget == null) goto L4;
        InsetsControlTarget target = imeTarget;
    L5:
        onControlTargetChanged(getImeSourceProvider(), target, false);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[0] == false) goto L13;
        if (target != null) goto L9;
    L11:
        InsetsControlTarget r1 = target;
    L12:
        String protoLogParam0 = String.valueOf(r1);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IME, -6684172224226118673L, 0, new Object[]{protoLogParam0});
        goto L13
    L9:
        if (target.getWindow() == null) goto L11;
        r1 = target.getWindow();
    L13:
        notifyPendingInsetsControlChanged();
        return;
    L4:
        target = this.mEmptyImeControlTarget;
        goto L5
    }

    void onBarControlTargetChanged(InsetsControlTarget statusControlling, InsetsControlTarget fakeStatusControlling, InsetsControlTarget navControlling, InsetsControlTarget fakeNavControlling) {
        int i = this.mProviders.size() - 1;
    L3:
        if (i < 0) goto L11;
        InsetsSourceProvider provider = this.mProviders.valueAt(i);
        int type = provider.getSource().getType();
        if (type != WindowInsets.Type.statusBars()) goto L8;
        onControlTargetChanged(provider, statusControlling, false);
        onControlTargetChanged(provider, fakeStatusControlling, true);
    L10:
        i = i - 1;
        goto L3
    L8:
        if (type != WindowInsets.Type.navigationBars()) goto L10;
        onControlTargetChanged(provider, navControlling, false);
        onControlTargetChanged(provider, fakeNavControlling, true);
        goto L10
    L11:
        notifyPendingInsetsControlChanged();
    }

    void notifyControlTargetChanged(InsetsControlTarget target, InsetsSourceProvider provider) {
        onControlTargetChanged(provider, target, false);
        notifyPendingInsetsControlChanged();
    }

    void notifyControlRevoked(InsetsControlTarget previousControlTarget, InsetsSourceProvider provider) {
        removeFromControlMaps(previousControlTarget, provider, false);
    }

    private void onControlTargetChanged(InsetsSourceProvider provider, InsetsControlTarget target, boolean fake) {
        if (fake == false) goto L4;
        InsetsControlTarget lastTarget = this.mIdFakeControlTargetMap.get(provider.getSource().getId());
    L6:
        if (target != lastTarget) goto L9;
        return;
    L9:
        if (provider.isControllable() == true) goto L11;
        return;
    L11:
        if (fake == false) goto L13;
        provider.updateFakeControlTarget(target);
    L16:
        if (lastTarget == null) goto L18;
        removeFromControlMaps(lastTarget, provider, fake);
        addToPendingControlMaps(lastTarget, provider);
    L18:
        if (target == null) goto L21;
        addToControlMaps(target, provider, fake);
        addToPendingControlMaps(target, provider);
        return;
    L21:
        return;
    L13:
        provider.updateControlForTarget(target, false, null);
        target = provider.getControlTarget();
        if (target != lastTarget) goto L16;
        return;
    L4:
        lastTarget = this.mIdControlTargetMap.get(provider.getSource().getId());
        goto L6
    }

    private void removeFromControlMaps(InsetsControlTarget target, InsetsSourceProvider provider, boolean fake) {
        ArrayList<InsetsSourceProvider> array = this.mControlTargetProvidersMap.get(target);
        if (array != null) goto L5;
        return;
    L5:
        array.remove(provider);
        if (array.isEmpty() == false) goto L8;
        this.mControlTargetProvidersMap.remove(target);
    L8:
        if (fake == false) goto L10;
        this.mIdFakeControlTargetMap.remove(provider.getSource().getId());
        return;
    L10:
        this.mIdControlTargetMap.remove(provider.getSource().getId());
    }

    private void addToControlMaps(InsetsControlTarget target, InsetsSourceProvider provider, boolean fake) {
        ArrayList<InsetsSourceProvider> array = this.mControlTargetProvidersMap.computeIfAbsent(target, new InsetsStateController$$ExternalSyntheticLambda4());
        array.add(provider);
        if (fake == false) goto L5;
        this.mIdFakeControlTargetMap.put(provider.getSource().getId(), target);
        return;
    L5:
        this.mIdControlTargetMap.put(provider.getSource().getId(), target);
    }

    private static /* synthetic */ ArrayList lambda$addToControlMaps$2(InsetsControlTarget key) {
        return new ArrayList();
    }

    private void addToPendingControlMaps(InsetsControlTarget target, InsetsSourceProvider provider) {
        ArrayList<InsetsSourceProvider> array = this.mPendingTargetProvidersMap.computeIfAbsent(target, new InsetsStateController$$ExternalSyntheticLambda0());
        array.add(provider);
    }

    private static /* synthetic */ ArrayList lambda$addToPendingControlMaps$3(InsetsControlTarget key) {
        return new ArrayList();
    }

    void notifyControlChanged(InsetsControlTarget target, InsetsSourceProvider provider) {
        addToPendingControlMaps(target, provider);
        notifyPendingInsetsControlChanged();
    }

    void notifySurfaceTransactionReady(InsetsSourceProvider provider, long id, boolean ready) {
        if (ready == false) goto L4;
        this.mSurfaceTransactionIds.put(provider.getSource().getId(), id);
        return;
    L4:
        this.mSurfaceTransactionIds.delete(provider.getSource().getId());
    }

    void onAnimatingTypesChanged(InsetsControlTarget target, ImeTracker.Token statsToken) {
        int i = this.mProviders.size() - 1;
    L3:
        if (i < 0) goto L13;
        InsetsSourceProvider provider = this.mProviders.valueAt(i);
        if (provider.getSource().getType() != WindowInsets.Type.ime()) goto L7;
        boolean isImeProvider = true;
    L8:
        if (isImeProvider == false) goto L10;
        ImeTracker.Token r4 = statsToken;
    L11:
        provider.onAnimatingTypesChanged(target, r4);
        i = i - 1;
        goto L3
    L10:
        r4 = null;
        goto L11
    L7:
        isImeProvider = false;
        goto L8
    }

    private void notifyPendingInsetsControlChanged() {
        if (this.mPendingTargetProvidersMap.isEmpty() == false) goto L5;
        return;
    L5:
        final int size = this.mSurfaceTransactionIds.size();
        final SparseLongArray surfaceTransactionIds = new SparseLongArray(size);
        int i = 0;
    L6:
        if (i >= size) goto L8;
        surfaceTransactionIds.append(this.mSurfaceTransactionIds.keyAt(i), this.mSurfaceTransactionIds.valueAt(i));
        i = i + 1;
        goto L6
    L8:
        this.mDisplayContent.mWmService.mAnimator.addAfterPrepareSurfacesRunnable(new InsetsStateController$$ExternalSyntheticLambda1(this, size, surfaceTransactionIds));
    }

    private /* synthetic */ void lambda$notifyPendingInsetsControlChanged$4(int size, SparseLongArray surfaceTransactionIds) {
        int i = 0;
    L3:
        if (i >= size) goto L9;
        int sourceId = surfaceTransactionIds.keyAt(i);
        InsetsSourceProvider provider = this.mProviders.get(sourceId);
        if (provider == null) goto L8;
        provider.onSurfaceTransactionCommitted(surfaceTransactionIds.valueAt(i));
    L8:
        i = i + 1;
        goto L3
    L9:
        ArraySet<InsetsControlTarget> newControlTargets = new ArraySet();
        int displayId = this.mDisplayContent.getDisplayId();
        ArrayMap<InsetsControlTarget, ArrayList<InsetsSourceProvider>> pendingControlMap = this.mPendingTargetProvidersMap;
        int i2 = pendingControlMap.size() - 1;
    L10:
        if (i2 < 0) goto L25;
        InsetsControlTarget target = pendingControlMap.keyAt(i2);
        ArrayList<InsetsSourceProvider> providers = pendingControlMap.valueAt(i2);
        int p = providers.size() - 1;
    L12:
        if (p < 0) goto L20;
        InsetsSourceProvider provider2 = providers.get(p);
        if (provider2.isLeashInitialized() == false) goto L16;
    L17:
        providers.remove(p);
    L18:
        p = p - 1;
        goto L12
    L16:
        if (provider2.getControlTarget() == target) goto L18;
    L20:
        if (providers.isEmpty() == false) goto L24;
        pendingControlMap.removeAt(i2);
        target.notifyInsetsControlChanged(displayId);
        if (this.mControlTargetProvidersMap.containsKey(target) == false) goto L24;
        newControlTargets.add(target);
    L24:
        i2 = i2 - 1;
        goto L10
    L25:
        int i3 = newControlTargets.size();
        int i4 = i3 - 1;
    L26:
        if (i4 < 0) goto L28;
        onRequestedVisibleTypesChanged(newControlTargets.valueAt(i4), WindowInsets.Type.all(), null);
        i4 = i4 - 1;
        goto L26
    L28:
        newControlTargets.clear();
    }

    void notifyInsetsChanged() {
        this.mDisplayContent.notifyInsetsChanged(this.mDispatchInsetsChanged);
    }

    void notifyInsetsChanged(ArraySet<WindowState> changedWindows) {
        int i = changedWindows.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mDispatchInsetsChanged.accept(changedWindows.valueAt(i));
        i = i - 1;
        goto L3
    }

    boolean hasPendingControls(InsetsControlTarget target) {
        return this.mPendingTargetProvidersMap.containsKey(target);
    }

    void dump(String prefix, PrintWriter pw) {
        pw.println(prefix + "WindowInsetsStateController");
        String prefix2 = prefix + "  ";
        this.mState.dump(prefix2, pw);
        pw.println(prefix2 + "Control map:");
        int i = this.mControlTargetProvidersMap.size() + (-1);
    L3:
        if (i < 0) goto L15;
        InsetsControlTarget controlTarget = this.mControlTargetProvidersMap.keyAt(i);
        pw.print(prefix2 + "  ");
        pw.print(controlTarget);
        pw.println(":");
        ArrayList<InsetsSourceProvider> providers = this.mControlTargetProvidersMap.valueAt(i);
        int j = providers.size() - 1;
    L5:
        if (j < 0) goto L13;
        InsetsSourceProvider provider = providers.get(j);
        if (provider == null) goto L12;
        pw.print(prefix2 + "    ");
        if (controlTarget != provider.getFakeControlTarget()) goto L11;
        pw.print("(fake) ");
    L11:
        pw.println(provider.getControl(controlTarget));
    L12:
        j = j - 1;
        goto L5
    L13:
        i = i - 1;
        goto L3
    L15:
        if (this.mControlTargetProvidersMap.isEmpty() == false) goto L17;
        pw.print(prefix2 + "  none");
    L17:
        pw.println(prefix2 + "InsetsSourceProviders:");
        int i2 = this.mProviders.size() + (-1);
    L18:
        if (i2 < 0) goto L20;
        this.mProviders.valueAt(i2).dump(pw, prefix2 + "  ");
        i2 = i2 + (-1);
        goto L18
    L20:
        int i3 = this.mForcedConsumingTypes;
        if (i3 == 0) goto L29;
        pw.println(prefix2 + "mForcedConsumingTypes=" + WindowInsets.Type.toString(this.mForcedConsumingTypes));
        return;
    }

    void dumpDebug(ProtoOutputStream proto, int logLevel) {
        int i = this.mProviders.size() - 1;
    L3:
        if (i < 0) goto L10;
        InsetsSourceProvider provider = this.mProviders.valueAt(i);
        if (provider.getSource().getType() != WindowInsets.Type.ime()) goto L7;
        long r2 = 1146756268063L;
    L8:
        provider.dumpDebug(proto, r2, logLevel);
        i = i - 1;
        goto L3
    L7:
        r2 = 2246267895843L;
        goto L8
    }
}
