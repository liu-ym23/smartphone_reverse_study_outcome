package com.android.server.inputmethod;

import android.os.SystemClock;
import android.view.inputmethod.EditorInfo;
import com.android.internal.inputmethod.InputMethodDebug;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class SoftInputShowHideHistory {
    private static final AtomicInteger sSequenceNumber = null;
    private final Entry[] mEntries;
    private int mNextIndex;

    static final class Entry {
        final ClientState mClientState;
        final EditorInfo mEditorInfo;
        final String mFocusedWindowName;
        final int mFocusedWindowSoftInputMode;
        final String mImeControlTargetName;
        final String mImeSurfaceParentName;
        final String mImeTargetNameFromWm;
        final int mImeUserId;
        final boolean mInFullscreenMode;
        final int mReason;
        final String mRequestWindowName;
        final int mSequenceNumber;
        final long mTimestamp;
        final long mWallTime;

        Entry(ClientState client, EditorInfo editorInfo, String focusedWindowName, int softInputMode, int reason, boolean inFullscreenMode, String requestWindowName, String imeControlTargetName, String imeTargetName, String imeSurfaceParentName, int imeUserId) {
            this.mSequenceNumber = SoftInputShowHideHistory.m4789$$Nest$sfgetsSequenceNumber().getAndIncrement();
            this.mClientState = client;
            this.mEditorInfo = editorInfo;
            this.mFocusedWindowName = focusedWindowName;
            this.mFocusedWindowSoftInputMode = softInputMode;
            this.mReason = reason;
            this.mTimestamp = SystemClock.uptimeMillis();
            this.mWallTime = System.currentTimeMillis();
            this.mInFullscreenMode = inFullscreenMode;
            this.mRequestWindowName = requestWindowName;
            this.mImeControlTargetName = imeControlTargetName;
            this.mImeTargetNameFromWm = imeTargetName;
            this.mImeSurfaceParentName = imeSurfaceParentName;
            this.mImeUserId = imeUserId;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsSequenceNumber, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicInteger m4789$$Nest$sfgetsSequenceNumber() {
        return sSequenceNumber;
    }

    SoftInputShowHideHistory() {
        this.mEntries = new Entry[16];
        this.mNextIndex = 0;
    }

    static {
        sSequenceNumber = new AtomicInteger(0);
    }

    void addEntry(Entry entry) {
        int index = this.mNextIndex;
        this.mEntries[index] = entry;
        this.mNextIndex = (this.mNextIndex + 1) % this.mEntries.length;
    }

    void dump(PrintWriter pw, String prefix) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).withZone(ZoneId.systemDefault());
        int i = 0;
    L4:
        if (i >= this.mEntries.length) goto L15;
        Entry entry = this.mEntries[(this.mNextIndex + i) % this.mEntries.length];
        if (entry == null) goto L13;
        pw.print(prefix);
        pw.println("SoftInputShowHide[" + entry.mImeUserId + "] #" + entry.mSequenceNumber + ":");
        pw.print(prefix);
        pw.println("  time=" + formatter.format(Instant.ofEpochMilli(entry.mWallTime)) + " (timestamp=" + entry.mTimestamp + ")");
        pw.print(prefix);
        StringBuilder r3 = new StringBuilder();
        r3.append("  reason=");
        r3.append(InputMethodDebug.softInputDisplayReasonToString(entry.mReason));
        pw.print(r3.toString());
        pw.println(" inFullscreenMode=" + entry.mInFullscreenMode);
        pw.print(prefix);
        pw.println("  requestClient=" + entry.mClientState);
        pw.print(prefix);
        pw.println("  focusedWindowName=" + entry.mFocusedWindowName);
        pw.print(prefix);
        pw.println("  requestWindowName=" + entry.mRequestWindowName);
        pw.print(prefix);
        pw.println("  imeControlTargetName=" + entry.mImeControlTargetName);
        pw.print(prefix);
        pw.println("  imeTargetNameFromWm=" + entry.mImeTargetNameFromWm);
        pw.print(prefix);
        pw.println("  imeSurfaceParentName=" + entry.mImeSurfaceParentName);
        pw.print(prefix);
        pw.print("  editorInfo:");
        if (entry.mEditorInfo == null) goto L11;
        pw.print(" inputType=" + entry.mEditorInfo.inputType);
        pw.print(" privateImeOptions=" + entry.mEditorInfo.privateImeOptions);
        pw.println(" fieldId (viewId)=" + entry.mEditorInfo.fieldId);
    L12:
        pw.print(prefix);
        pw.println("  focusedWindowSoftInputMode=" + InputMethodDebug.softInputModeToString(entry.mFocusedWindowSoftInputMode));
        goto L13
    L11:
        pw.println(" null");
    L13:
        i = i + 1;
        goto L4
    }
}
