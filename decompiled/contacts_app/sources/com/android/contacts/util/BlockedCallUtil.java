package com.android.contacts.util;

import android.content.Context;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class BlockedCallUtil {
    private static final int AUTO_BLOCKED = 2;
    private static final int DISTURB_BLOCKED = 1;

    public static boolean isBlocked(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public BlockedCallUtil() {
    }

    public static String getBlockedLabel(Context r2, int r3) {
        if (r2 != null) goto L5;
    L15:
        return null;
    L5:
        if (isBlocked(r3) == false) goto L15;
        if (r3 != 1) goto L12;
        return r2.getResources().getString(R.string.blocked_incoming_call_label);
    L12:
        if (r3 != 2) goto L15;
        return r2.getResources().getString(R.string.auto_blocked_incoming_call_label);
    }
}
