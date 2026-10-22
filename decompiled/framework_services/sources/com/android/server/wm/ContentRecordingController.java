package com.android.server.wm;

import android.util.Utils;
import android.view.ContentRecordingSession;
import android.view.DisplayInfo;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;

/* JADX INFO: loaded from: classes3.dex */
final class ContentRecordingController {
    private DisplayContent mDisplayContent;
    private boolean mIsFirstRecording;
    private ContentRecordingSession mSession;

    public static /* synthetic */ void $r8$lambda$BMfvrvhC_XhYGPO8nXUdqo3gPSI(ContentRecordingController r0, WindowManagerService r1, ContentRecordingSession r2, DisplayContent r3) {
        r0.lambda$setContentRecordingSessionLocked$0(r1, r2, r3);
    }

    ContentRecordingController() {
        this.mSession = null;
        this.mDisplayContent = null;
        this.mIsFirstRecording = true;
    }

    ContentRecordingSession getContentRecordingSessionLocked() {
        return this.mSession;
    }

    void setContentRecordingSessionLocked(final ContentRecordingSession incomingSession, final WindowManagerService wmService) {
        if (incomingSession == null) goto L8;
        if (ContentRecordingSession.isValid(incomingSession) == true) goto L8;
        return;
    L8:
        if (this.mSession == null) goto L15;
        if (incomingSession == null) goto L15;
        if (this.mSession.isWaitingForConsent() == false) goto L15;
        if (incomingSession.isWaitingForConsent() == true) goto L15;
        boolean hasSessionUpdatedWithConsent = true;
    L17:
        if (ContentRecordingSession.isProjectionOnSameDisplay(this.mSession, incomingSession) == false) goto L26;
        if (hasSessionUpdatedWithConsent == false) goto L23;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L26;
        long protoLogParam0 = incomingSession.getVirtualDisplayId();
        String protoLogParam1 = String.valueOf(this.mSession.getVirtualDisplayId());
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -225319884529912382L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
        goto L26
    L23:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L71;
        long protoLogParam2 = incomingSession.getVirtualDisplayId();
        String protoLogParam3 = String.valueOf(this.mSession.getVirtualDisplayId());
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -5981322449150461244L, 1, new Object[]{Long.valueOf(protoLogParam2), protoLogParam3});
        return;
    L71:
        return;
    L26:
        final DisplayContent incomingDisplayContent = null;
        if (incomingSession != null) goto L29;
        wmService.dispatchScreenRecordingState(false);
    L63:
        if (this.mSession == null) goto L69;
        if (hasSessionUpdatedWithConsent == true) goto L69;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L68;
        String protoLogParam4 = String.valueOf(this.mDisplayContent.getDisplayId());
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -5750232782380780139L, 0, new Object[]{protoLogParam4});
    L68:
        this.mDisplayContent.pauseRecording();
        this.mDisplayContent.setContentRecordingSession(null);
    L69:
        this.mDisplayContent = incomingDisplayContent;
        this.mSession = incomingSession;
        return;
    L29:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L35;
        long protoLogParam5 = incomingSession.getVirtualDisplayId();
        if (this.mSession != null) goto L33;
        Integer r10 = null;
    L34:
        String protoLogParam6 = String.valueOf(r10);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 4226710957373144819L, 1, new Object[]{Long.valueOf(protoLogParam5), protoLogParam6});
        goto L35
    L33:
        r10 = Integer.valueOf(this.mSession.getVirtualDisplayId());
    L35:
        incomingDisplayContent = wmService.mRoot.getDisplayContentOrCreate(incomingSession.getVirtualDisplayId());
        if (incomingDisplayContent != null) goto L42;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L72;
        long protoLogParam7 = incomingSession.getVirtualDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -1415855962859555663L, 1, new Object[]{Long.valueOf(protoLogParam7)});
        return;
    L72:
        return;
    L42:
        if (incomingDisplayContent.getDisplayInfo() != null) goto L44;
    L46:
        boolean isXtsPkg = false;
    L47:
        boolean forceSdr = !incomingSession.isWaitingForConsent();
        if (forceSdr == false) goto L59;
        if (isXtsPkg == true) goto L59;
        wmService.dispatchScreenRecordingState(true);
        DisplayInfo displayInfo = incomingDisplayContent.getDisplayInfo();
        if (displayInfo == null) goto L53;
        float r13 = displayInfo.getRefreshRate();
    L54:
        float refreshRate = Math.max(1.0f, r13);
        long frameDelayMs = Math.max(1, Math.round(1000.0f / refreshRate));
        if (this.mIsFirstRecording == false) goto L57;
        long delayMs = 2 * frameDelayMs;
    L58:
        wmService.mH.postDelayed(new ContentRecordingController$$ExternalSyntheticLambda0(this, wmService, incomingSession, incomingDisplayContent), delayMs);
        goto L63
    L57:
        delayMs = frameDelayMs;
        goto L58
    L53:
        r13 = 60.0f;
    L59:
        incomingDisplayContent.setContentRecordingSession(incomingSession);
        incomingDisplayContent.updateRecording();
        goto L63
    L44:
        if (Utils.isXtsPkg(incomingDisplayContent.getDisplayInfo().ownerPackageName) == false) goto L46;
        isXtsPkg = true;
    L15:
        hasSessionUpdatedWithConsent = false;
        goto L17
    }

    private /* synthetic */ void lambda$setContentRecordingSessionLocked$0(WindowManagerService wmService, ContentRecordingSession finalSession, DisplayContent finalIncomingDisplayContent) {
        WindowManagerGlobalLock r0 = wmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mSession == finalSession) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        if (finalIncomingDisplayContent != this.mDisplayContent) goto L11;
        this.mIsFirstRecording = false;     // Catch: Throwable -> L9
        finalIncomingDisplayContent.setContentRecordingSession(finalSession);     // Catch: Throwable -> L9
        finalIncomingDisplayContent.updateRecording();     // Catch: Throwable -> L9
        goto L11
    }
}
