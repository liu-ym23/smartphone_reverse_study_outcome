package com.android.server.wm;

import android.content.pm.ParceledListSlice;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import android.view.SurfaceControl;
import android.window.DisplayAreaAppearedInfo;
import android.window.IDisplayAreaOrganizer;
import android.window.IDisplayAreaOrganizerController;
import android.window.WindowContainerToken;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DisplayAreaOrganizerController extends IDisplayAreaOrganizerController.Stub {
    private static final String TAG = "DisplayAreaOrganizerController";
    private final WindowManagerGlobalLock mGlobalLock;
    private int mNextTaskDisplayAreaFeatureId;
    private final HashMap<Integer, DisplayAreaOrganizerState> mOrganizersByFeatureIds;
    final ActivityTaskManagerService mService;

    private class DeathRecipient implements IBinder.DeathRecipient {
        int mFeature;
        IDisplayAreaOrganizer mOrganizer;
        final /* synthetic */ DisplayAreaOrganizerController this$0;

        DeathRecipient(DisplayAreaOrganizerController r1, IDisplayAreaOrganizer organizer, int feature) {
            this.this$0 = r1;
            this.mOrganizer = organizer;
            this.mFeature = feature;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            WindowManagerGlobalLock r0 = DisplayAreaOrganizerController.m9872$$Nest$fgetmGlobalLock(this.this$0);
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            IDisplayAreaOrganizer featureOrganizer = this.this$0.getOrganizerByFeature(this.mFeature);     // Catch: Throwable -> L14
            if (featureOrganizer == null) goto L17;
            IBinder organizerBinder = featureOrganizer.asBinder();     // Catch: Throwable -> L14
            if (organizerBinder.equals(this.mOrganizer.asBinder()) == false) goto L9;
        L16:
            ((DisplayAreaOrganizerState) DisplayAreaOrganizerController.m9873$$Nest$fgetmOrganizersByFeatureIds(this.this$0).remove(Integer.valueOf(this.mFeature))).destroy();     // Catch: Throwable -> L14
            goto L17
        L9:
            if (organizerBinder.isBinderAlive() == false) goto L16;
            Slog.d(DisplayAreaOrganizerController.TAG, "Dead organizer replaced for feature=" + this.mFeature);     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L14
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L14:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    private class DisplayAreaOrganizerState {
        private final DeathRecipient mDeathRecipient;
        private final IDisplayAreaOrganizer mOrganizer;
        final /* synthetic */ DisplayAreaOrganizerController this$0;

        public static /* synthetic */ void $r8$lambda$AyRUxBOJZz2CT4uFqJu237eBzs8(DisplayAreaOrganizerState r0, IBinder r1, DisplayArea r2) {
            r0.lambda$destroy$0(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOrganizer, reason: not valid java name */
        static /* bridge */ /* synthetic */ IDisplayAreaOrganizer m9875$$Nest$fgetmOrganizer(DisplayAreaOrganizerState r0) {
            return r0.mOrganizer;
        }

        DisplayAreaOrganizerState(DisplayAreaOrganizerController r3, IDisplayAreaOrganizer organizer, int feature) {
            this.this$0 = r3;
            this.mOrganizer = organizer;
            this.mDeathRecipient = new DeathRecipient(r3, organizer, feature);
            organizer.asBinder().linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L5
            return;
        }

        void destroy() {
            final IBinder organizerBinder = this.mOrganizer.asBinder();
            this.this$0.mService.mRootWindowContainer.forAllDisplayAreas(new DisplayAreaOrganizerController$DisplayAreaOrganizerState$$ExternalSyntheticLambda0(this, organizerBinder));
            organizerBinder.unlinkToDeath(this.mDeathRecipient, 0);
        }

        private /* synthetic */ void lambda$destroy$0(IBinder organizerBinder, DisplayArea da) {
            if (da.mOrganizer != null) goto L5;
            return;
        L5:
            if (da.mOrganizer.asBinder().equals(organizerBinder) == true) goto L7;
            return;
        L7:
            if (da.isTaskDisplayArea() == true) goto L9;
        L11:
            da.setOrganizer(null);
            return;
        L9:
            if (da.asTaskDisplayArea().mCreatedByOrganizer == false) goto L11;
            DisplayAreaOrganizerController.m9874$$Nest$mdeleteTaskDisplayArea(this.this$0, da.asTaskDisplayArea());
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$0W4dxQY8A11mbgGB8IAalv-CNbY, reason: not valid java name */
    public static /* synthetic */ RootDisplayArea m9869$r8$lambda$0W4dxQY8A11mbgGB8IAalvCNbY(int r0, DisplayArea r1) {
        return lambda$createTaskDisplayArea$3(r0, r1);
    }

    public static /* synthetic */ TaskDisplayArea $r8$lambda$0vyYOhrVpYnNQvaW4mfJFY1YdR0(int r0, TaskDisplayArea r1) {
        return lambda$createTaskDisplayArea$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$CvQU9LqFTmbUEmALsGj5S7UV_PU(DisplayAreaOrganizerController r0, int r1, List r2, IDisplayAreaOrganizer r3, DisplayArea r4) {
        r0.lambda$registerOrganizer$0(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$i_FduVmijwgFw-MnGSZd4ElsXSg, reason: not valid java name */
    public static /* synthetic */ DisplayArea m9870$r8$lambda$i_FduVmijwgFwMnGSZd4ElsXSg(RootDisplayArea r0, DisplayArea r1) {
        return lambda$createTaskDisplayArea$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$pw6XtEQ_1QT3fJee-FhRa5Ap7sI, reason: not valid java name */
    public static /* synthetic */ boolean m9871$r8$lambda$pw6XtEQ_1QT3fJeeFhRa5Ap7sI(IDisplayAreaOrganizer r0, Map.Entry r1) {
        return lambda$unregisterOrganizer$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$wSnU_Pe7TXl_HhzB7fVcyiY4FP4(DisplayAreaOrganizerController r0, int r1, List r2, IDisplayAreaOrganizer r3, DisplayContent r4) {
        r0.lambda$registerOrganizer$1(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGlobalLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerGlobalLock m9872$$Nest$fgetmGlobalLock(DisplayAreaOrganizerController r0) {
        return r0.mGlobalLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOrganizersByFeatureIds, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m9873$$Nest$fgetmOrganizersByFeatureIds(DisplayAreaOrganizerController r0) {
        return r0.mOrganizersByFeatureIds;
    }

    /* JADX INFO: renamed from: -$$Nest$mdeleteTaskDisplayArea, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9874$$Nest$mdeleteTaskDisplayArea(DisplayAreaOrganizerController r0, TaskDisplayArea r1) {
        r0.deleteTaskDisplayArea(r1);
    }

    DisplayAreaOrganizerController(ActivityTaskManagerService atm) {
        this.mNextTaskDisplayAreaFeatureId = 20002;
        this.mOrganizersByFeatureIds = new HashMap();
        this.mService = atm;
        this.mGlobalLock = atm.mGlobalLock;
    }

    private void enforceTaskPermission(String func) {
        ActivityTaskManagerService.enforceTaskPermission(func);
    }

    IDisplayAreaOrganizer getOrganizerByFeature(int featureId) {
        DisplayAreaOrganizerState state = this.mOrganizersByFeatureIds.get(Integer.valueOf(featureId));
        if (state != null) goto L7;
        return null;
    L7:
        return DisplayAreaOrganizerState.m9875$$Nest$fgetmOrganizer(state);
    }

    public ParceledListSlice<DisplayAreaAppearedInfo> registerOrganizer(final IDisplayAreaOrganizer organizer, final int feature) {
        enforceTaskPermission("registerOrganizer()");
        long uid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r4 = this.mGlobalLock;     // Catch: Throwable -> L20
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L20
        monitor-enter(r4);     // Catch: Throwable -> L20
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L11;
        String protoLogParam0 = String.valueOf(organizer.asBinder());     // Catch: Throwable -> L8
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 3968604152682328317L, 4, new Object[]{protoLogParam0, Long.valueOf(uid)});     // Catch: Throwable -> L8
    L11:
        if (this.mOrganizersByFeatureIds.get(Integer.valueOf(feature)) == null) goto L13;
        this.mOrganizersByFeatureIds.remove(Integer.valueOf(feature)).destroy();     // Catch: Throwable -> L8
        Slog.d(TAG, "Replacing dead organizer for feature=" + feature);     // Catch: Throwable -> L8
    L13:
        DisplayAreaOrganizerState state = new DisplayAreaOrganizerState(this, organizer, feature);     // Catch: Throwable -> L8
        final List<DisplayAreaAppearedInfo> displayAreaInfos = new ArrayList();     // Catch: Throwable -> L8
        this.mService.mRootWindowContainer.forAllDisplays(new DisplayAreaOrganizerController$$ExternalSyntheticLambda5(this, feature, displayAreaInfos, organizer));     // Catch: Throwable -> L8
        this.mOrganizersByFeatureIds.put(Integer.valueOf(feature), state);     // Catch: Throwable -> L8
        ParceledListSlice<DisplayAreaAppearedInfo> r7 = new ParceledListSlice(displayAreaInfos);     // Catch: Throwable -> L8
        monitor-exit(r4);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r7;
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    private /* synthetic */ void lambda$registerOrganizer$1(final int feature, final List displayAreaInfos, final IDisplayAreaOrganizer organizer, DisplayContent dc) {
        if (dc.isTrusted() == false) goto L5;
        dc.forAllDisplayAreas(new DisplayAreaOrganizerController$$ExternalSyntheticLambda1(this, feature, displayAreaInfos, organizer));
        return;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[3] == false) goto L10;
        long protoLogParam0 = dc.getDisplayId();
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -3066370283926570943L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        return;
    }

    private /* synthetic */ void lambda$registerOrganizer$0(int feature, List displayAreaInfos, IDisplayAreaOrganizer organizer, DisplayArea da) {
        if (da.mFeatureId == feature) goto L5;
        return;
    L5:
        displayAreaInfos.add(organizeDisplayArea(organizer, da, "DisplayAreaOrganizerController.registerOrganizer"));
    }

    public void unregisterOrganizer(final IDisplayAreaOrganizer organizer) {
        enforceTaskPermission("unregisterTaskOrganizer()");
        long uid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r4 = this.mGlobalLock;     // Catch: Throwable -> L15
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L15
        monitor-enter(r4);     // Catch: Throwable -> L15
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L10;
        String protoLogParam0 = String.valueOf(organizer.asBinder());     // Catch: Throwable -> L8
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -943497726140336963L, 4, new Object[]{protoLogParam0, Long.valueOf(uid)});     // Catch: Throwable -> L8
    L10:
        this.mOrganizersByFeatureIds.entrySet().removeIf(new DisplayAreaOrganizerController$$ExternalSyntheticLambda2(organizer));     // Catch: Throwable -> L8
        monitor-exit(r4);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(origId);
        return;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    private static /* synthetic */ boolean lambda$unregisterOrganizer$2(IDisplayAreaOrganizer organizer, Map.Entry entry) {
        boolean matches = DisplayAreaOrganizerState.m9875$$Nest$fgetmOrganizer((DisplayAreaOrganizerState) entry.getValue()).asBinder().equals(organizer.asBinder());
        if (matches == false) goto L5;
        ((DisplayAreaOrganizerState) entry.getValue()).destroy();
    L5:
        return matches;
    }

    public DisplayAreaAppearedInfo createTaskDisplayArea(IDisplayAreaOrganizer organizer, int displayId, final int parentFeatureId, String name) {
        enforceTaskPermission("createTaskDisplayArea()");
        long uid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r10 = this.mGlobalLock;     // Catch: Throwable -> L46
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L46
        monitor-enter(r10);     // Catch: Throwable -> L46
    L12:
        th = th;
    L41:
        monitor-exit(r10);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L44
        throw th;     // Catch: Throwable -> L44
    L44:
        th = th;
    L48:
        Binder.restoreCallingIdentity(origId);
        throw th;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L15;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 5147103403966149923L, 1, new Object[]{Long.valueOf(uid)});     // Catch: Throwable -> L10
    L15:
        DisplayContent display = this.mService.mRootWindowContainer.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (display == null) goto L40;
        if (display.isTrusted() == false) goto L38;
        RootDisplayArea parentRoot = (RootDisplayArea) display.getItemFromDisplayAreas(new DisplayAreaOrganizerController$$ExternalSyntheticLambda3(parentFeatureId));     // Catch: Throwable -> L10
        if (parentRoot != null) goto L22;
        TaskDisplayArea parentTda = (TaskDisplayArea) display.getItemFromTaskDisplayAreas(new DisplayAreaOrganizerController$$ExternalSyntheticLambda4(parentFeatureId));     // Catch: Throwable -> L10
    L23:
        if (parentRoot != null) goto L28;
        if (parentTda != null) goto L28;
        throw new IllegalArgumentException("Can't find a parent DisplayArea with featureId=" + parentFeatureId);     // Catch: Throwable -> L10
    L28:
        int taskDisplayAreaFeatureId = this.mNextTaskDisplayAreaFeatureId;     // Catch: Throwable -> L10
        this.mNextTaskDisplayAreaFeatureId = taskDisplayAreaFeatureId + 1;     // Catch: Throwable -> L10
        DisplayAreaOrganizerState state = new DisplayAreaOrganizerState(this, organizer, taskDisplayAreaFeatureId);     // Catch: Throwable -> L10
        if (parentRoot == null) goto L31;
        TaskDisplayArea tda = createTaskDisplayArea(parentRoot, name, taskDisplayAreaFeatureId);     // Catch: Throwable -> L10
    L32:
        DisplayAreaAppearedInfo tdaInfo = organizeDisplayArea(organizer, tda, "DisplayAreaOrganizerController.createTaskDisplayArea");     // Catch: Throwable -> L10
        this.mOrganizersByFeatureIds.put(Integer.valueOf(taskDisplayAreaFeatureId), state);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return tdaInfo;
    L31:
        tda = createTaskDisplayArea(parentTda, name, taskDisplayAreaFeatureId);     // Catch: Throwable -> L10
        goto L32
    L22:
        parentTda = null;
        goto L23
    L38:
        throw new IllegalArgumentException("createTaskDisplayArea untrusted displayId=" + displayId);     // Catch: Throwable -> L10
    L40:
        throw new IllegalArgumentException("createTaskDisplayArea unknown displayId=" + displayId);     // Catch: Throwable -> L10
    L10:
        th = th;
    L46:
        th = th;
        goto L48
    }

    private static /* synthetic */ RootDisplayArea lambda$createTaskDisplayArea$3(int parentFeatureId, DisplayArea da) {
        if (da.asRootDisplayArea() != null) goto L5;
    L7:
        return null;
    L5:
        if (da.mFeatureId != parentFeatureId) goto L7;
        return da.asRootDisplayArea();
    }

    private static /* synthetic */ TaskDisplayArea lambda$createTaskDisplayArea$4(int parentFeatureId, TaskDisplayArea taskDisplayArea) {
        if (taskDisplayArea.mFeatureId == parentFeatureId) goto L7;
        return null;
    L7:
        return taskDisplayArea;
    }

    public void deleteTaskDisplayArea(WindowContainerToken token) {
        enforceTaskPermission("deleteTaskDisplayArea()");
        long uid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r4 = this.mGlobalLock;     // Catch: Throwable -> L21
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L21
        monitor-enter(r4);     // Catch: Throwable -> L21
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L10;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -1659480097203667175L, 1, new Object[]{Long.valueOf(uid)});     // Catch: Throwable -> L8
    L10:
        WindowContainer wc = WindowContainer.fromBinder(token.asBinder());     // Catch: Throwable -> L8
        if (wc == null) goto L26;
        if (wc.asTaskDisplayArea() == null) goto L26;
        TaskDisplayArea taskDisplayArea = wc.asTaskDisplayArea();     // Catch: Throwable -> L8
        if (taskDisplayArea.mCreatedByOrganizer == false) goto L24;
        this.mOrganizersByFeatureIds.remove(Integer.valueOf(taskDisplayArea.mFeatureId)).destroy();     // Catch: Throwable -> L8
        monitor-exit(r4);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L21
        Binder.restoreCallingIdentity(origId);
        return;
    L24:
        throw new IllegalArgumentException("Attempt to delete TaskDisplayArea not created by organizer TaskDisplayArea=" + taskDisplayArea);     // Catch: Throwable -> L8
    L26:
        throw new IllegalArgumentException("Can't resolve TaskDisplayArea from token");     // Catch: Throwable -> L8
    L21:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    void onDisplayAreaAppeared(IDisplayAreaOrganizer organizer, DisplayArea da) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L9;
        String protoLogParam0 = String.valueOf(da.getName());
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -4514772405648277945L, 0, new Object[]{protoLogParam0});
    L9:
        SurfaceControl outSurfaceControl = new SurfaceControl(da.getSurfaceControl(), "DisplayAreaOrganizerController.onDisplayAreaAppeared");     // Catch: RemoteException -> L7
        organizer.onDisplayAreaAppeared(da.getDisplayAreaInfo(), outSurfaceControl);     // Catch: RemoteException -> L7
        return;
    }

    void onDisplayAreaVanished(IDisplayAreaOrganizer organizer, DisplayArea da) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L6;
        String protoLogParam0 = String.valueOf(da.getName());
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, 995846188225477231L, 0, new Object[]{protoLogParam0});
    L6:
        if (organizer.asBinder().isBinderAlive() == true) goto L13;
        Slog.d(TAG, "Organizer died before sending onDisplayAreaVanished");
        return;
    L13:
        organizer.onDisplayAreaVanished(da.getDisplayAreaInfo());     // Catch: RemoteException -> L11
        return;
    }

    void onDisplayAreaInfoChanged(IDisplayAreaOrganizer organizer, DisplayArea da) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_ORGANIZER_enabled[1] == false) goto L9;
        String protoLogParam0 = String.valueOf(da.getName());
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, -1007032390526684388L, 0, new Object[]{protoLogParam0});
    L9:
        organizer.onDisplayAreaInfoChanged(da.getDisplayAreaInfo());     // Catch: RemoteException -> L7
        return;
    }

    private DisplayAreaAppearedInfo organizeDisplayArea(IDisplayAreaOrganizer organizer, DisplayArea displayArea, String callsite) {
        displayArea.setOrganizer(organizer, true);
        return new DisplayAreaAppearedInfo(displayArea.getDisplayAreaInfo(), new SurfaceControl(displayArea.getSurfaceControl(), callsite));
    }

    private TaskDisplayArea createTaskDisplayArea(final RootDisplayArea root, String name, int taskDisplayAreaFeatureId) {
        TaskDisplayArea taskDisplayArea = new TaskDisplayArea(root.mDisplayContent, root.mWmService, name, taskDisplayAreaFeatureId, true);
        DisplayArea topTaskContainer = (DisplayArea) root.getItemFromDisplayAreas(new DisplayAreaOrganizerController$$ExternalSyntheticLambda0(root));
        if (topTaskContainer == null) goto L7;
        WindowContainer parent = topTaskContainer.getParent();
        int index = parent.mChildren.indexOf(topTaskContainer) + 1;
        parent.addChild(taskDisplayArea, index);
        return taskDisplayArea;
    L7:
        throw new IllegalStateException("Root must either contain TDA or DAG root=" + root);
    }

    private static /* synthetic */ DisplayArea lambda$createTaskDisplayArea$5(RootDisplayArea root, DisplayArea da) {
        if (da.mType == DisplayArea.Type.ANY) goto L5;
        return null;
    L5:
        RootDisplayArea rootDA = da.getRootDisplayArea();
        if (rootDA == root) goto L10;
        if (rootDA == da) goto L10;
        return null;
    L10:
        return da;
    }

    private TaskDisplayArea createTaskDisplayArea(TaskDisplayArea parentTda, String name, int taskDisplayAreaFeatureId) {
        TaskDisplayArea taskDisplayArea = new TaskDisplayArea(parentTda.mDisplayContent, parentTda.mWmService, name, taskDisplayAreaFeatureId, true);
        parentTda.addChild(taskDisplayArea, Integer.MAX_VALUE);
        return taskDisplayArea;
    }

    private void deleteTaskDisplayArea(TaskDisplayArea taskDisplayArea) {
        taskDisplayArea.setOrganizer(null);
        this.mService.mRootWindowContainer.mTaskSupervisor.beginDeferResume();
        Task lastReparentedRootTask = taskDisplayArea.prepareForRemoval();     // Catch: Throwable -> L8
        this.mService.mRootWindowContainer.mTaskSupervisor.endDeferResume();
        taskDisplayArea.removeImmediately();
        if (lastReparentedRootTask == null) goto L13;
        lastReparentedRootTask.resumeNextFocusAfterReparent();
        return;
    L13:
        return;
    L8:
        th = move-exception;
        this.mService.mRootWindowContainer.mTaskSupervisor.endDeferResume();
        throw th;
    }
}
