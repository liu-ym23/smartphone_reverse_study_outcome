package com.obric.autogui.platforms.tools.computercontrol;

import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.view.Surface;
import com.android.extensions.computercontrol.AssistantComputerControlSession;
import com.android.extensions.computercontrol.ComputerControlSession;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.computercontrol.CCActionFailureReason;
import com.obric.autogui.common.api.platform.computercontrol.CCActionResult;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.m;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ComputerControlSdkApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StandardCCSessionAccessor implements CCSessionAccessor {
    private static final Companion Companion = null;
    private static final String TAG = "StandardCCSessionAccessor";
    private final AtomicReference<AssistantComputerControlSession.AccessCallback> accessCallbackRef;
    private final AtomicBoolean callbacksCleaned;
    private final Context context;
    private final int displayId;
    private final m<Integer, Integer> displaySize;
    private VirtualDisplay mirrorVirtualDisplay;
    private final AssistantComputerControlSession rawSession;
    private final AtomicReference<ComputerControlSession.StabilityListener> stabilityListenerRef;
    private final AtomicReference<CCSessionState> stateRef;

    /* JADX INFO: compiled from: ComputerControlSdkApiImpl.kt */
    private static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StandardCCSessionAccessor(Context r3, AssistantComputerControlSession r4, int r5, m<Integer, Integer> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AssistantComputerControlSession r8 = (AssistantComputerControlSession) ZeusTransformUtils.wrapperContextForParams(r4, AssistantComputerControlSession.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r8, "rawSession");
        o.e(r6, "displaySize");
        this.context = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        this.rawSession = r8;
        this.displayId = r5;
        this.displaySize = r6;
        this.stateRef = new AtomicReference(CCSessionState.Created.INSTANCE);
        this.callbacksCleaned = new AtomicBoolean(false);
        this.stabilityListenerRef = new AtomicReference();
        this.accessCallbackRef = new AtomicReference();
    }

    public final Context getContext$base_release() {
        return this.context;
    }

    public final AssistantComputerControlSession getRawSession$base_release() {
        return this.rawSession;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor
    public int getDisplayId() {
        return this.displayId;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor
    public m<Integer, Integer> getDisplaySize() {
        return this.displaySize;
    }

    public final AtomicBoolean getCallbacksCleaned$base_release() {
        return this.callbacksCleaned;
    }

    public final AtomicReference<ComputerControlSession.StabilityListener> getStabilityListenerRef$base_release() {
        return this.stabilityListenerRef;
    }

    public final AtomicReference<AssistantComputerControlSession.AccessCallback> getAccessCallbackRef$base_release() {
        return this.accessCallbackRef;
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor
    public CCSessionState getState() {
        CCSessionState r2 = this.stateRef.get();
        o.c(r2, "get(...)");
        return (CCSessionState) ZeusTransformUtils.preCheckCast(r2, CCSessionState.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor
    public boolean isClosed() {
        return ZeusTransformUtils.instanceOf(getState(), CCSessionState.Closed.class);
    }

    public final void updateState(CCSessionState r2) {
        o.e(r2, "state");
        this.stateRef.set(r2);
    }

    public final synchronized void attachMirrorVirtualDisplay(VirtualDisplay r2) {
        monitor-enter(this);
        o.e(r2, "virtualDisplay");     // Catch: Throwable -> L6
        releaseMirrorVirtualDisplay();     // Catch: Throwable -> L6
        this.mirrorVirtualDisplay = r2;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized CCActionResult setMirrorSurface(Surface r4) {
        monitor-enter(this);
        VirtualDisplay r0 = this.mirrorVirtualDisplay;     // Catch: Throwable -> L14
        if (r0 != null) goto L18;
        Loog.INSTANCE.w(TAG, "setSurface ignored because Surface mirror display is unavailable.");     // Catch: Throwable -> L14
        CCActionResult r5 = (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.Unsupported, null, 2, null), CCActionResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        monitor-exit(this);
        return r5;
    L18:
        r0.setSurface(r4);     // Catch: Throwable -> L10
        CCActionResult r6 = (CCActionResult) ZeusTransformUtils.preCheckCast(CCActionResult.Success.INSTANCE, CCActionResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);
        return r6;
    L10:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "setSurface failed on Surface mirror display.", th);     // Catch: Throwable -> L14
        r6 = (CCActionResult) ZeusTransformUtils.preCheckCast(new CCActionResult.Failed(CCActionFailureReason.ApiError, th), CCActionResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void releaseLocalResources() {
        monitor-enter(this);
        releaseMirrorVirtualDisplay();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final void releaseMirrorVirtualDisplay() {
        VirtualDisplay r0 = this.mirrorVirtualDisplay;
        this.mirrorVirtualDisplay = null;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.release();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "release Surface mirror virtual display failed.", th);
    }
}
