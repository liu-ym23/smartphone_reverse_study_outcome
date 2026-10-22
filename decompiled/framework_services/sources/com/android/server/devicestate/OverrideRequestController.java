package com.android.server.devicestate;

import android.os.IBinder;
import android.util.Slog;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
final class OverrideRequestController {
    static final int FLAG_POWER_SAVE_ENABLED = 2;
    static final int FLAG_THERMAL_CRITICAL = 1;
    static final int STATUS_ACTIVE = 1;
    static final int STATUS_CANCELED = 2;
    static final int STATUS_UNKNOWN = 0;
    private static final String TAG = "OverrideRequestController";
    private OverrideRequest mBaseStateRequest;
    private final StatusChangeListener mListener;
    private OverrideRequest mRequest;
    private boolean mStickyRequest;
    private boolean mStickyRequestsAllowed;

    @Retention(RetentionPolicy.SOURCE)
    @interface RequestStatus {
    }

    public interface StatusChangeListener {
        void onStatusChanged(OverrideRequest r1, int r2, int r3);
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface StatusChangedFlag {
    }

    static String statusToString(int status) {
        switch(status) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "CANCELED";
    L7:
        return "ACTIVE";
    L9:
        return "UNKNOWN";
    L4:
        throw new IllegalArgumentException("Unknown status: " + status);
    }

    OverrideRequestController(StatusChangeListener listener) {
        this.mListener = listener;
    }

    void setStickyRequestsAllowed(boolean stickyRequestsAllowed) {
        this.mStickyRequestsAllowed = stickyRequestsAllowed;
        if (this.mStickyRequestsAllowed == true) goto L6;
        cancelStickyRequest();
        return;
    }

    void addRequest(OverrideRequest request) {
        OverrideRequest previousRequest = this.mRequest;
        this.mRequest = request;
        this.mListener.onStatusChanged(request, 1, 0);
        if (previousRequest == null) goto L6;
        cancelRequestLocked(previousRequest);
        return;
    }

    void addBaseStateRequest(OverrideRequest request) {
        OverrideRequest previousRequest = this.mBaseStateRequest;
        this.mBaseStateRequest = request;
        this.mListener.onStatusChanged(request, 1, 0);
        if (previousRequest == null) goto L6;
        cancelRequestLocked(previousRequest);
        return;
    }

    void cancelRequest(OverrideRequest request) {
        if (hasRequest(request.getToken(), request.getRequestType()) == true) goto L5;
        return;
    L5:
        cancelCurrentRequestLocked();
    }

    void cancelStickyRequest() {
        if (this.mStickyRequest == false) goto L6;
        cancelCurrentRequestLocked();
        return;
    }

    void cancelOverrideRequest() {
        cancelCurrentRequestLocked();
    }

    void cancelBaseStateOverrideRequest() {
        cancelCurrentBaseStateRequestLocked();
    }

    boolean hasRequest(IBinder token, int requestType) {
        if (requestType != 1) goto L11;
        if (this.mBaseStateRequest != null) goto L7;
        return false;
    L7:
        if (token == this.mBaseStateRequest.getToken()) goto L9;
        return false;
    L9:
        return true;
    L11:
        if (this.mRequest != null) goto L13;
        return false;
    L13:
        if (token == this.mRequest.getToken()) goto L15;
        return false;
    L15:
        return true;
    }

    void handleProcessDied(int pid) {
        if (this.mBaseStateRequest == null) goto L8;
        if (this.mBaseStateRequest.getPid() != pid) goto L8;
        cancelCurrentBaseStateRequestLocked();
    L8:
        if (this.mRequest != null) goto L10;
        return;
    L10:
        if (this.mRequest.getPid() == pid) goto L12;
        return;
    L12:
        if (this.mRequest.getRequestedDeviceState().hasProperty(5) == false) goto L16;
        cancelCurrentRequestLocked();
        return;
    L16:
        if (this.mStickyRequestsAllowed == false) goto L19;
        this.mStickyRequest = true;
        return;
    L19:
        cancelCurrentRequestLocked();
    }

    void handleBaseStateChanged(int state) {
        if (this.mBaseStateRequest == null) goto L8;
        if (state == this.mBaseStateRequest.getRequestedStateIdentifier()) goto L8;
        cancelBaseStateOverrideRequest();
    L8:
        if (this.mRequest != null) goto L11;
        return;
    L11:
        if ((this.mRequest.getFlags() & 1) == 0) goto L14;
        cancelCurrentRequestLocked();
        return;
    }

    void handleNewSupportedStates(int[] newSupportedStates, int reason) {
        int r1 = 1;
        int r2 = 0;
        if (reason != 3) goto L5;
        boolean isThermalCritical = true;
    L7:
        if (reason != 4) goto L9;
        boolean isPowerSaveEnabled = true;
    L11:
        if (isThermalCritical == true) goto L14;
        r1 = 0;
    L14:
        int flags = r1 | 0;
        if (isPowerSaveEnabled == false) goto L17;
        r2 = 2;
    L17:
        int flags2 = flags | r2;
        if (this.mBaseStateRequest == null) goto L23;
        if (contains(newSupportedStates, this.mBaseStateRequest.getRequestedStateIdentifier()) == true) goto L23;
        cancelCurrentBaseStateRequestLocked(flags2);
    L23:
        if (this.mRequest != null) goto L25;
        return;
    L25:
        if (contains(newSupportedStates, this.mRequest.getRequestedStateIdentifier()) == true) goto L29;
        cancelCurrentRequestLocked(flags2);
        return;
    L29:
        return;
    L9:
        isPowerSaveEnabled = false;
        goto L11
    L5:
        isThermalCritical = false;
        goto L7
    }

    void dumpInternal(PrintWriter pw) {
        OverrideRequest overrideRequest = this.mRequest;
        if (overrideRequest == null) goto L5;
        boolean requestActive = true;
    L6:
        pw.println();
        pw.println("Override Request active: " + requestActive);
        if (requestActive == false) goto L10;
        pw.println("Request: mPid=" + overrideRequest.getPid() + ", mRequestedState=" + overrideRequest.getRequestedStateIdentifier() + ", mFlags=" + overrideRequest.getFlags() + ", mStatus=" + statusToString(1));
        return;
    L10:
        return;
    L5:
        requestActive = false;
        goto L6
    }

    private void cancelRequestLocked(OverrideRequest requestToCancel) {
        cancelRequestLocked(requestToCancel, 0);
    }

    private void cancelRequestLocked(OverrideRequest requestToCancel, int flags) {
        this.mListener.onStatusChanged(requestToCancel, 2, flags);
    }

    private void cancelCurrentRequestLocked() {
        cancelCurrentRequestLocked(0);
    }

    private void cancelCurrentRequestLocked(int flags) {
        if (this.mRequest != null) goto L6;
        Slog.w(TAG, "Attempted to cancel a null OverrideRequest");
        return;
    L6:
        this.mStickyRequest = false;
        cancelRequestLocked(this.mRequest, flags);
        this.mRequest = null;
    }

    private void cancelCurrentBaseStateRequestLocked() {
        cancelCurrentBaseStateRequestLocked(0);
    }

    private void cancelCurrentBaseStateRequestLocked(int flags) {
        if (this.mBaseStateRequest != null) goto L6;
        Slog.w(TAG, "Attempted to cancel a null OverrideRequest");
        return;
    L6:
        cancelRequestLocked(this.mBaseStateRequest, flags);
        this.mBaseStateRequest = null;
    }

    private static boolean contains(int[] array, int value) {
        int i = 0;
    L4:
        if (i >= array.length) goto L10;
        if (array[i] == value) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }
}
