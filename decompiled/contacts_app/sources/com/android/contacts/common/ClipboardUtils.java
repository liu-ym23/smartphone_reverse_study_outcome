package com.android.contacts.common;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public class ClipboardUtils {
    private static final String TAG = "ClipboardUtils";

    private ClipboardUtils() {
    }

    public static void copyText(Context r1, CharSequence r2, CharSequence r3, boolean r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        ClipboardManager r0 = (ClipboardManager) r1.getSystemService("clipboard");
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0.setPrimaryClip(ClipData.newPlainText(r2, r3));
        if (r4 == false) goto L12;
        Toast.makeText(r1, r1.getString(R.string.toast_text_copied), 0).show();
        return;
    }
}
