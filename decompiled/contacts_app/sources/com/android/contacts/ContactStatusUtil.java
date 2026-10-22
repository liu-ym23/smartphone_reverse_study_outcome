package com.android.contacts;

import android.content.Context;
import android.content.res.Resources;
import com.android.contacts.util.Constants;

/* JADX INFO: loaded from: classes.dex */
public class ContactStatusUtil {
    private static final String TAG = "ContactStatusUtil";

    public ContactStatusUtil() {
    }

    public static String getStatusString(Context r1, int r2) {
        Resources r3 = r1.getResources();
        if (r2 == 2) goto L17;
        if (r2 == 3) goto L17;
        if (r2 == 4) goto L15;
        if (r2 == 5) goto L13;
        return null;
    L13:
        return r3.getString(R.string.status_available);
    L15:
        return r3.getString(R.string.status_busy);
    L17:
        return r3.getString(R.string.common_leave);
    }

    public static boolean isRightHandMode() {
        if (Constants.HANDMODE == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
