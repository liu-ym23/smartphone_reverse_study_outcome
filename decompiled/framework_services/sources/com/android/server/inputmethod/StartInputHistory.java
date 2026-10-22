package com.android.server.inputmethod;

import android.app.ActivityManager;
import android.view.inputmethod.EditorInfo;
import com.android.internal.inputmethod.InputMethodDebug;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
final class StartInputHistory {
    private static final int ENTRY_SIZE_FOR_HIGH_RAM_DEVICE = 32;
    private static final int ENTRY_SIZE_FOR_LOW_RAM_DEVICE = 5;
    private final Entry[] mEntries;
    private int mNextIndex;

    private static final class Entry {
        int mClientBindSequenceNumber;
        EditorInfo mEditorInfo;
        int mImeDisplayId;
        String mImeId;
        String mImeTokenString;
        int mImeUserId;
        boolean mRestarting;
        int mSequenceNumber;
        int mStartInputReason;
        int mTargetDisplayId;
        int mTargetUserId;
        int mTargetWindowSoftInputMode;
        String mTargetWindowString;
        long mTimestamp;
        long mWallTime;

        Entry(StartInputInfo original) {
            set(original);
        }

        void set(StartInputInfo original) {
            this.mSequenceNumber = original.mSequenceNumber;
            this.mTimestamp = original.mTimestamp;
            this.mWallTime = original.mWallTime;
            this.mImeUserId = original.mImeUserId;
            this.mImeTokenString = String.valueOf(original.mImeToken);
            this.mImeDisplayId = original.mImeDisplayId;
            this.mImeId = original.mImeId;
            this.mStartInputReason = original.mStartInputReason;
            this.mRestarting = original.mRestarting;
            this.mTargetUserId = original.mTargetUserId;
            this.mTargetDisplayId = original.mTargetDisplayId;
            this.mTargetWindowString = String.valueOf(original.mTargetWindow);
            this.mEditorInfo = original.mEditorInfo;
            this.mTargetWindowSoftInputMode = original.mTargetWindowSoftInputMode;
            this.mClientBindSequenceNumber = original.mClientBindSequenceNumber;
        }
    }

    StartInputHistory() {
        this.mEntries = new Entry[getEntrySize()];
        this.mNextIndex = 0;
    }

    private static int getEntrySize() {
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L6;
        return 5;
    L6:
        return 32;
    }

    void addEntry(StartInputInfo info) {
        int index = this.mNextIndex;
        if (this.mEntries[index] != null) goto L5;
        this.mEntries[index] = new Entry(info);
    L6:
        this.mNextIndex = (this.mNextIndex + 1) % this.mEntries.length;
        return;
    L5:
        this.mEntries[index].set(info);
        goto L6
    }

    void dump(PrintWriter pw, String prefix) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).withZone(ZoneId.systemDefault());
        int i = 0;
    L4:
        if (i >= this.mEntries.length) goto L11;
        Entry entry = this.mEntries[(this.mNextIndex + i) % this.mEntries.length];
        if (entry == null) goto L9;
        pw.print(prefix);
        pw.println("StartInput #" + entry.mSequenceNumber + ":");
        pw.print(prefix);
        pw.println("  time=" + formatter.format(Instant.ofEpochMilli(entry.mWallTime)) + " (timestamp=" + entry.mTimestamp + ") reason=" + InputMethodDebug.startInputReasonToString(entry.mStartInputReason) + " restarting=" + entry.mRestarting);
        pw.print(prefix);
        StringBuilder r3 = new StringBuilder();
        r3.append("  imeToken=");
        r3.append(entry.mImeTokenString);
        r3.append(" [");
        r3.append(entry.mImeId);
        r3.append("]");
        pw.print(r3.toString());
        pw.print(" imeUserId=" + entry.mImeUserId);
        pw.println(" imeDisplayId=" + entry.mImeDisplayId);
        pw.print(prefix);
        pw.println("  targetWin=" + entry.mTargetWindowString + " [" + entry.mEditorInfo.packageName + "] targetUserId=" + entry.mTargetUserId + " targetDisplayId=" + entry.mTargetDisplayId + " clientBindSeq=" + entry.mClientBindSequenceNumber);
        pw.print(prefix);
        StringBuilder r4 = new StringBuilder();
        r4.append("  softInputMode=");
        r4.append(InputMethodDebug.softInputModeToString(entry.mTargetWindowSoftInputMode));
        pw.println(r4.toString());
        pw.print(prefix);
        pw.println("  inputType=0x" + Integer.toHexString(entry.mEditorInfo.inputType) + " imeOptions=0x" + Integer.toHexString(entry.mEditorInfo.imeOptions) + " fieldId=0x" + Integer.toHexString(entry.mEditorInfo.fieldId) + " fieldName=" + entry.mEditorInfo.fieldName + " actionId=" + entry.mEditorInfo.actionId + " actionLabel=" + entry.mEditorInfo.actionLabel);
    L9:
        i = i + 1;
        goto L4
    }
}
