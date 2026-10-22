package com.android.server.wm;

import android.hardware.display.DisplayManager;
import android.util.SparseArray;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;

/* JADX INFO: loaded from: classes3.dex */
class PresentationController implements DisplayManager.DisplayListener {
    private final SparseArray<Presentation> mPresentations;

    private static class Presentation {
        final Task mHostTask;
        final WindowContainerListener mHostTaskListener;
        final WindowContainerListener mPresentationListener;
        final WindowState mWin;

        Presentation(WindowState win, WindowContainerListener presentationListener, Task hostTask, WindowContainerListener hostTaskListener) {
            this.mWin = win;
            this.mPresentationListener = presentationListener;
            this.mHostTask = hostTask;
            this.mHostTaskListener = hostTaskListener;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("{win: ");
            r0.append(this.mWin.getName());
            r0.append(", display: ");
            r0.append(this.mWin.getDisplayId());
            r0.append(", hostTask: ");
            if (this.mHostTask == null) goto L5;
            String r1 = this.mHostTask.getName();
        L6:
            r0.append(r1);
            r0.append("}");
            return r0.toString();
        L5:
            r1 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPresentations, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m10089$$Nest$fgetmPresentations(PresentationController r0) {
        return r0.mPresentations;
    }

    /* JADX INFO: renamed from: -$$Nest$mhasPresentationWindow, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10090$$Nest$mhasPresentationWindow(PresentationController r0, int r1) {
        return r0.hasPresentationWindow(r1);
    }

    PresentationController() {
        this.mPresentations = new SparseArray();
    }

    private Presentation getPresentation(WindowState win) {
        if (win != null) goto L5;
        return null;
    L5:
        int i = 0;
    L7:
        if (i >= this.mPresentations.size()) goto L13;
        Presentation presentation = this.mPresentations.valueAt(i);
        if (win == presentation.mWin) goto L10;
        i = i + 1;
        goto L7
    L10:
        return presentation;
    L13:
        return null;
    }

    private boolean hasPresentationWindow(int displayId) {
        return this.mPresentations.contains(displayId);
    }

    boolean isPresentationVisible(int displayId) {
        Presentation presentation = this.mPresentations.get(displayId);
        if (presentation != null) goto L5;
    L7:
        return false;
    L5:
        if (presentation.mWin.mToken.isVisibleRequested() == false) goto L7;
        return true;
    }

    boolean canPresent(WindowState win, DisplayContent displayContent) {
        return canPresent(win, displayContent, win.mAttrs.type, win.getUid());
    }

    boolean canPresent(WindowState win, DisplayContent displayContent, int type, int uid) {
        if (type != 2030) goto L7;
        return displayContent.isPrivate();
    L7:
        if (type == 2037) goto L11;
        return false;
    L11:
        return displayContent.getDisplay().isPublicPresentation();
    }

    boolean shouldOccludeActivities(int displayId) {
        return false;
    }

    void onPresentationAdded(final WindowState win, int uid) {
        final int displayId = win.getDisplayId();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_PRESENTATION_enabled[1] == false) goto L5;
        long protoLogParam0 = displayId;
        String protoLogParam1 = String.valueOf(win);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_PRESENTATION, 3849682624373536183L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
    L5:
        win.mWmService.mDisplayManagerInternal.onPresentation(displayId, true);
        WindowContainerListener presentationWindowListener = new AnonymousClass1(this, displayId, win);
        win.mToken.registerWindowContainerListener(presentationWindowListener);
        Task hostTask = null;
        WindowContainerListener hostTaskListener = null;
        if (0 == 0) goto L8;
        hostTaskListener = new AnonymousClass2(this, win);
        hostTask.registerWindowContainerListener(hostTaskListener);
    L8:
        this.mPresentations.put(displayId, new Presentation(win, presentationWindowListener, null, hostTaskListener));
    }

    void removePresentation(int displayId, String reason) {
        Presentation r0 = this.mPresentations.get(displayId);
    }

    private static /* synthetic */ void lambda$removePresentation$0(WindowState win) {
        WindowManagerGlobalLock r0 = win.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        win.removeIfPossible();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int displayId) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int displayId) {
        removePresentation(displayId, "display removed " + displayId);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int displayId) {
    }
}
