package com.android.server.inputmethod;

import android.os.IBinder;
import android.os.SystemClock;
import android.view.inputmethod.EditorInfo;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class StartInputInfo {
    private static final AtomicInteger sSequenceNumber = null;
    final int mClientBindSequenceNumber;
    final EditorInfo mEditorInfo;
    final int mImeDisplayId;
    final String mImeId;
    final IBinder mImeToken;
    final int mImeUserId;
    final boolean mRestarting;
    final int mSequenceNumber;
    final int mStartInputReason;
    final int mTargetDisplayId;
    final int mTargetUserId;
    final IBinder mTargetWindow;
    final int mTargetWindowSoftInputMode;
    final long mTimestamp;
    final long mWallTime;

    static {
        sSequenceNumber = new AtomicInteger(0);
    }

    StartInputInfo(int imeUserId, IBinder imeToken, int imeDisplayId, String imeId, int startInputReason, boolean restarting, int targetUserId, int targetDisplayId, IBinder targetWindow, EditorInfo editorInfo, int targetWindowSoftInputMode, int clientBindSequenceNumber) {
        this.mSequenceNumber = sSequenceNumber.getAndIncrement();
        this.mTimestamp = SystemClock.uptimeMillis();
        this.mWallTime = System.currentTimeMillis();
        this.mImeUserId = imeUserId;
        this.mImeToken = imeToken;
        this.mImeDisplayId = imeDisplayId;
        this.mImeId = imeId;
        this.mStartInputReason = startInputReason;
        this.mRestarting = restarting;
        this.mTargetUserId = targetUserId;
        this.mTargetDisplayId = targetDisplayId;
        this.mTargetWindow = targetWindow;
        this.mEditorInfo = editorInfo;
        this.mTargetWindowSoftInputMode = targetWindowSoftInputMode;
        this.mClientBindSequenceNumber = clientBindSequenceNumber;
    }
}
