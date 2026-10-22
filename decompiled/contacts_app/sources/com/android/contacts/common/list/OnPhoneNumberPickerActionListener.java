package com.android.contacts.common.list;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public interface OnPhoneNumberPickerActionListener {
    public static final int CALL_INITIATION_UNKNOWN = 0;

    void onHomeInActionBarSelected();

    void onPickDataUri(Uri r1, boolean r2, int r3);

    void onPickPhoneNumber(String r1, boolean r2, int r3);

    void onShortcutIntentCreated(Intent r1);
}
